package sbnz.integracija.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.event.BookMarkedEvent;
import sbnz.integracija.example.event.CancelOrderEvent;
import sbnz.integracija.example.event.CommentApprovalEvent;
import sbnz.integracija.example.event.OrderCreatedEvent;
import sbnz.integracija.example.event.ShareBookInfoEvent;
import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.facts.UserCategory;
import sbnz.integracija.example.model.Book;
import sbnz.integracija.example.model.Book.BindingType;
import sbnz.integracija.example.model.BookDto;
import sbnz.integracija.example.model.BookStore;
import sbnz.integracija.example.model.Comment;
import sbnz.integracija.example.model.CommentStatus;
import sbnz.integracija.example.model.CommentStore;
import sbnz.integracija.example.model.Gender;
import sbnz.integracija.example.model.NewCommentDto;
import sbnz.integracija.example.model.Order;
import sbnz.integracija.example.model.OrderLine;
import sbnz.integracija.example.model.OrderStore;
import sbnz.integracija.example.model.RecomendationsDTO;
import sbnz.integracija.example.model.RecomendationsModule;
import sbnz.integracija.example.model.UserStore;

@Service
@Scope("singleton")
public class SampleAppService {

	private static Logger log = LoggerFactory.getLogger(SampleAppService.class);

	private final KieContainer kieContainer;
	private KieSession kieSession;
	private RecomendationsModule recomendationsModule;
	private BookStore bookStore;
    private UserStore userStore;
    private CommentStore commentStore;
    private OrderStore orderStore;
    public List<Book> allInitBooks;
    public List<Comment> allInitComments;
    public List<Order> allInitOrder;
	public List<User> allInitUsers;

	@Autowired
	public SampleAppService(KieContainer kieContainer) {
		log.info("Initialising a new example session.");
		this.kieContainer = kieContainer;
		this.kieSession = kieContainer.newKieSession();
		this.bookStore = new BookStore();
		this.userStore = new UserStore();
		this.orderStore = new OrderStore();
		this.commentStore = new CommentStore();
		
		initBooks();
		initUsers();
		
		 for (Book book : allInitBooks) {
			bookStore.addBook(book);
		 }
		 for (User user : allInitUsers) {
			userStore.addUser(user);
		 }
		 for (Book book : bookStore.getAllBooks()) {
			 this.kieSession.insert(book);
		 }
		 for (User user : allInitUsers) {
			 this.kieSession.insert(user);
		 }
		 this.kieSession.fireAllRules();
		 System.out.println("Velicina svih knjiga je");
		 System.out.println(bookStore.getAllBooks().size());
		 
		 
		 
		 initComments();
		 initOrders();
		 for (Order o : allInitOrder) {
				orderStore.addOrder(o);
		 }
		 for (Comment c : allInitComments) {
				commentStore.addComment(c);
		 }
		 
		 
		 for (Order o : orderStore.getAllOrders()) {
			 this.kieSession.insert(o);
		 }
		 
		 for (Comment c : commentStore.getAllComments()) {
			 this.kieSession.insert(c);
		 }
//		 
////		 factHandle = session.insert(user);
		 this.kieSession.fireAllRules();
		 
		 
	     CancelOrderEvent e1 = new CancelOrderEvent(1,1);
	     CancelOrderEvent e2 = new CancelOrderEvent(1,2);
	     CancelOrderEvent e3 = new CancelOrderEvent(1,3);
	     CommentApprovalEvent cae = new CommentApprovalEvent(1,1,CommentStatus.APPROVED);
	     CommentApprovalEvent cae2 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     
	     this.kieSession.insert(e1);
	     this.kieSession.insert(e2);
	     this.kieSession.insert(e3);
	     this.kieSession.insert(cae);
	     this.kieSession.insert(cae2);
	     this.kieSession.fireAllRules();
	     
	     BookMarkedEvent bme = new BookMarkedEvent(1,1,5);
	     this.kieSession.insert(bme);
	     this.kieSession.fireAllRules();
	     Book b = bookStore.getBook(1);
	     System.out.println("Book new mark:" + b.getAverageMark());
	     
	     BookMarkedEvent bme2 = new BookMarkedEvent(1,1,5);
	     this.kieSession.insert(bme2);
	     this.kieSession.fireAllRules();
	     Book b2 = bookStore.getBook(1);
	     System.out.println("Book new mark:" + b2.getAverageMark());
	     
	     OrderCreatedEvent oce = new OrderCreatedEvent(1,orderStore.getOrder(1));
	     this.kieSession.insert(oce);
	     this.kieSession.fireAllRules();
	     System.out.println("New user points:" + userStore.getUser(1).getPoints());
	     
	     
	     
	     System.out.println("Old user points:" + userStore.getUser(2).getPoints());
	     OrderCreatedEvent oce1 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce2 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce3 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce4 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce5 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce6 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     OrderCreatedEvent oce7 = new OrderCreatedEvent(2,orderStore.getOrder(2));
	     this.kieSession.insert(oce1);
	     this.kieSession.insert(oce2);
	     this.kieSession.insert(oce3);
	     this.kieSession.insert(oce4);
	     this.kieSession.insert(oce5);
	     this.kieSession.insert(oce6);
	     this.kieSession.insert(oce7);
	     
	     CommentApprovalEvent cae1 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae22 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae3 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae4 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae5 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae6 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     CommentApprovalEvent cae7 = new CommentApprovalEvent(2,2,CommentStatus.APPROVED);
	     this.kieSession.insert(cae1);
	     this.kieSession.insert(cae22);
	     this.kieSession.insert(cae3);
	     this.kieSession.insert(cae4);
	     this.kieSession.insert(cae5);
	     this.kieSession.insert(cae6);
	     this.kieSession.insert(cae7);
	     
	     this.kieSession.fireAllRules();
	     System.out.println("New user points:" + userStore.getUser(2).getPoints());
	     
	     
	     ShareBookInfoEvent sbie1 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     ShareBookInfoEvent sbie2 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     ShareBookInfoEvent sbie3 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     ShareBookInfoEvent sbie4 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     ShareBookInfoEvent sbie5 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     ShareBookInfoEvent sbie6 = new ShareBookInfoEvent(2,bookStore.getBook(1),LocalDate.now());
	     
	     this.kieSession.insert(sbie1);
	     this.kieSession.insert(sbie2);
	     this.kieSession.insert(sbie3);
	     this.kieSession.insert(sbie4);
	     this.kieSession.insert(sbie5);
	     this.kieSession.insert(sbie6);
//	     
	     BookMarkedEvent bme1 = new BookMarkedEvent(2,2,4);
	     BookMarkedEvent bme22 = new BookMarkedEvent(2,2,4);
	     BookMarkedEvent bme3 = new BookMarkedEvent(2,2,4);
	     BookMarkedEvent bme4 = new BookMarkedEvent(2,2,4);
	     BookMarkedEvent bme5 = new BookMarkedEvent(2,2,4);
	     BookMarkedEvent bme6 = new BookMarkedEvent(2,2,4);
	     
	     this.kieSession.insert(bme1);
	     this.kieSession.insert(bme22);
	     this.kieSession.insert(bme3);
	     this.kieSession.insert(bme4);
	     this.kieSession.insert(bme5);
	     this.kieSession.insert(bme6);
	     
	     this.kieSession.fireAllRules();
	     System.out.println("New user points:" + userStore.getUser(2).getPoints());
	     
	     
	     CancelOrderEvent coe1 = new CancelOrderEvent(3,3);
	     CancelOrderEvent coe2 = new CancelOrderEvent(3,3);
	     CancelOrderEvent coe3 = new CancelOrderEvent(3,3);
	     CancelOrderEvent coe4 = new CancelOrderEvent(3,3);
	     CancelOrderEvent coe5 = new CancelOrderEvent(3,3);
	     CancelOrderEvent coe6 = new CancelOrderEvent(3,3);
	     
	     this.kieSession.insert(coe1);
	     this.kieSession.insert(coe2);
	     this.kieSession.insert(coe3);
	     this.kieSession.insert(coe4);
	     this.kieSession.insert(coe5);
	     this.kieSession.insert(coe6);
	     
	     CommentApprovalEvent caer1 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     CommentApprovalEvent caer2 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     CommentApprovalEvent caer3 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     CommentApprovalEvent caer4 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     CommentApprovalEvent caer5 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     CommentApprovalEvent caer6 = new CommentApprovalEvent(3,3,CommentStatus.REJECTED);
	     
	     this.kieSession.insert(caer1);
	     this.kieSession.insert(caer2);
	     this.kieSession.insert(caer3);
	     this.kieSession.insert(caer4);
	     this.kieSession.insert(caer5);
	     this.kieSession.insert(caer6);
	     
	     System.out.println("Old user 3 points:" + userStore.getUser(3).getPoints());
	     this.kieSession.fireAllRules();
	     System.out.println("New user 3 points:" + userStore.getUser(3).getPoints());
	     
	     
//	     CommentApprovalEvent
	}

	public Item getClassifiedItem(Item i) {
//		KieSession kieSession = kieContainer.newKieSession();
		
		
		
		
		
		
		
		
		
		
//		kieSession.insert(i);
//		int br = kieSession.fireAllRules();
//		System.out.println("Broj pravila je " + br);
//		
		User u1 = userStore.getUser("marko");
		if(u1 == null)
		{
			System.out.println("null je");
			return i;
		}
//		u1.setPoints(3000);
//		kieSession.insert(u1);
		int br = kieSession.fireAllRules();
	
		
		System.out.println("Broj pravila samo korisnik je " + br);
		
		
		CancelOrderEvent e1 = new CancelOrderEvent(2,1);
		CancelOrderEvent e2 = new CancelOrderEvent(2,2);
		CancelOrderEvent e3 = new CancelOrderEvent(2,3);
		CancelOrderEvent e4 = new CancelOrderEvent(2,4);
		CancelOrderEvent e5 = new CancelOrderEvent(2,5);
		CancelOrderEvent e6 = new CancelOrderEvent(2,6);
		CancelOrderEvent e7 = new CancelOrderEvent(2,7);
		kieSession.insert(e1);
		br = kieSession.fireAllRules();
		System.out.println("Broj pravila nakon jednog cancela je " + br);
		kieSession.insert(e2);
		br = kieSession.fireAllRules();
		System.out.println("Broj pravila nakon dva cancela je " + br);
		kieSession.insert(e3);
		br = kieSession.fireAllRules();
		System.out.println("Broj pravila nakon tri cancela je " + br);
		
		kieSession.insert(e1);
		kieSession.insert(e2);
		kieSession.insert(e3);
		kieSession.insert(e4);
		kieSession.insert(e5);
		kieSession.insert(e6);
		kieSession.insert(e7);
		br = kieSession.fireAllRules();
		System.out.println("Broj pravila nakon svih cancela je " + br);
		
		User u2 = userStore.getUser("marko");
		if(u2!=null)
			System.out.println("marko sada ima poena:" + u2.getPoints());
//		int br = kieSession.fireAllRules();
//		System.out.println("Broj pravila je " + br);
//		User u2 = userStore.getUser("marko");
//		System.out.println("Nakon pravila kategorija je " + u2.getCategory());
//	     User u2 = new User();
//		 u1.setAge(22);
//		 u1.setCategory(User.Category.BRONZE);
//		 u1.setUserId(22);
//		 u1.setfirstName("Marko");
//		 u1.setLastName("Markovic");
//		 u1.setUsername("marko");
//		 u1.setEmail("marko@gmail.com");
//		 u1.setPoints(3000);	     
		return i;
	}
	
	
	public Collection<Book> getAllBooks() {
        return bookStore.getAllBooks();
    }
    
    public User getUserData(String username) {
        return userStore.getUser(username);
    }
    
    public BookDto getBookData(int bookId) {
        Book book = bookStore.getBook(bookId);
        List<Comment> allComments = commentStore.getCommentsByBook(bookId);
        BookDto dto = new BookDto(book, allComments);
        return dto;
    }
    
    

    public Book markBook(int bookId, int userId, double mark) {
        kieSession.insert(new BookMarkedEvent(bookId,userId,mark));
        kieSession.fireAllRules();
        return bookStore.getBook(bookId);
    }

    public void cancelOrder(int userId, int orderId) {
        kieSession.insert(new CancelOrderEvent(userId, orderId));
        kieSession.fireAllRules();
    }
    
    public Comment addNewComment(NewCommentDto dto) {
    	//TODO: add comments to books
    	Comment new1 = new Comment(1,dto.getBookId(),dto.getUserId(),dto.getContent());
    	Comment ret = commentStore.addComment(new1);
    	CommentStatus status = CommentStatus.REJECTED;
    	if(dto.isStatus())
    		status = CommentStatus.APPROVED;
    	
        kieSession.insert(new CommentApprovalEvent(dto.getUserId(), ret,ret.getCommentId(),status));
        kieSession.fireAllRules();
        return ret;
    }


    public RecomendationsDTO getRecomendations(String username) {
    	
    	return null;
//        return recomendationsModule.createFeedForUser(username, getAllSongs(), userRepo::getUser);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	private void initBooks() {
//		 Book(int bookId, String name, int authorId, int yearOfPublication, String description, String category,
//					double averageMark, String alphabet, BindingType bindingType, double cost, double salePrice,
//					List<Double> allMarks) 
		 List<Double> allMarks1 = new ArrayList<Double>();
		 allMarks1.add(5.0);
		 allMarks1.add(4.0);
		 Book b1 = new Book(1, "Stepski vuk", 1, 1927, "Stepski vuk opis", "klasika",
					0, "cirilica", BindingType.HARDCOVER,1000.0, 1000.0,
					allMarks1);
		 
		 List<Double> allMarks2 = new ArrayList<Double>();
		 allMarks2.add(5.0);
		 allMarks2.add(4.0);
		 Book b2 = new Book(2, "Sidarta", 1, 1922, "Sidarta opis", "klasika",
					0, "cirilica", BindingType.HARDCOVER,900.0, 900.0,
					allMarks2);
		 
		 List<Double> allMarks3 = new ArrayList<Double>();
		 Book b3 = new Book(3, "Narcis i zlatousti", 1, 1930, "Narcis i zlatousti opis", "klasika",
					0, "cirilica", BindingType.HARDCOVER,950.0, 950.0,
					allMarks3);
		 
		 List<Double> allMarks4 = new ArrayList<Double>();
		 allMarks4.add(5.0);
		 allMarks4.add(4.0);
		 Book b4 = new Book(4, "Svet kao volja i predstava", 2, 1819, "Svet kao volja i predstava opis", "filozofija",
					0, "cirilica", BindingType.PAPERBACK,3000.0, 3000.0,
					allMarks4);
		 
		 List<Double> allMarks5 = new ArrayList<Double>();
		 allMarks5.add(1.0);
		 allMarks5.add(2.0);
		 Book b5 = new Book(5, "O slobodi volje", 2, 1825, "O slobodi volje opis", "filozofija",
					0, "cirilica", BindingType.PAPERBACK,700.0, 700.0,
					allMarks5);
		 
		 List<Double> allMarks6 = new ArrayList<Double>();
		 allMarks6.add(3.0);
		 allMarks6.add(3.0);
		 Book b6 = new Book(6, "Dina", 3, 1965, "Dina opis", "naucnafantastika",
					0, "cirilica", BindingType.PAPERBACK,1500.0, 1500.0,
					allMarks6);
		 
		 List<Double> allMarks7 = new ArrayList<Double>();
		 allMarks7.add(4.0);
		 allMarks7.add(4.0);
		 Book b7 = new Book(7, "Dina 2", 3, 1967, "Dina 2 opis", "naucnafantastika",
					0, "cirilica", BindingType.PAPERBACK,1500.0, 1500.0,
					allMarks7);
		 List<Double> allMarks8 = new ArrayList<Double>();
		 allMarks8.add(4.0);
		 allMarks8.add(4.0);
		 Book b8 = new Book(8, "Dina 3", 3, 1970, "Dina 3 opis", "naucnafantastika",
					0, "cirilica", BindingType.PAPERBACK,1500.0, 1500.0,
					allMarks8);
		 
		 List<Double> allMarks9 = new ArrayList<Double>();
		 Book b9 = new Book(9, "Dina 4", 3, 1972, "Dina 4 opis", "naucnafantastika",
					0, "cirilica", BindingType.PAPERBACK,1500.0, 1500.0,
					allMarks9);
		 
		 List<Double> allMarks10 = new ArrayList<Double>();
		 allMarks10.add(5.0);
		 allMarks10.add(4.0);
		 Book b10 = new Book(10, " Naslednici zemlje", 4, 2010, "Naslednici zemlje opis", "triler",
					0, "cirilica", BindingType.HARDCOVER,1200.0, 1200.0,
					allMarks10);
		 
		 allInitBooks = new ArrayList<Book>();
		 
		 allInitBooks.add(b1);
		 allInitBooks.add(b2);
		 allInitBooks.add(b3);
		 allInitBooks.add(b4);
		 allInitBooks.add(b5);
		 allInitBooks.add(b6);
		 allInitBooks.add(b7);
		 allInitBooks.add(b8);
		 allInitBooks.add(b9);
		 allInitBooks.add(b10);
		 
	 }
	 
	 private void initUsers() {
		 
		 User u1 = new User();
	     u1.setAge(21);
	     u1.setCategory(UserCategory.NA);
	     u1.setUserId(1);
	     u1.setUsername("pera");
	     u1.setGender(Gender.MALE);
	     u1.setEmail("pera@gmail.com");
	     u1.setPoints(0);
	        
	     User u2 = new User();
	     u2.setAge(22);
	     u2.setCategory(UserCategory.NA);
	     u2.setUserId(2);
	     u2.setUsername("marko");
	     u2.setGender(Gender.MALE);
	     u2.setEmail("marko@gmail.com");
	     u2.setPoints(1500);
	        
	        
	     User u3 = new User();
	     u3.setAge(41);
	     u3.setCategory(UserCategory.BRONZE);
	     u3.setUserId(3);
	     u3.setUsername("joka");
	     u3.setGender(Gender.FEMALE);
	     u3.setEmail("joka@gmail.com");
	     u3.setPoints(3000);
	        
	        
	     User u4 = new User();
	     u4.setAge(24);
	     u4.setCategory(UserCategory.SILVER);
	     u4.setUserId(4);
	     u4.setUsername("jelena");
	     u4.setGender(Gender.FEMALE);
	     u4.setEmail("jelena@gmail.com");
	     u4.setPoints(5500);
	     
	     allInitUsers = new ArrayList<User>();
	     allInitUsers.add(u1);
	     allInitUsers.add(u2);
	     allInitUsers.add(u3);
	     allInitUsers.add(u4);
		 
	 }
	 
	 
	 private void initComments() {
		 
		 Comment c1 = new Comment(1,1,1,"Dobra knjiga");
		 
		 Comment c2 = new Comment(1,2,1,"Losa knjiga");
		 
		 Comment c3 = new Comment(1,3,2,"Losa knjiga");
		 
		 
		 
	     allInitComments = new ArrayList<Comment>();
	     allInitComments.add(c1);
	     allInitComments.add(c2);
	     allInitComments.add(c3);
	     
	     
	 }
	 
	 private void initOrders() {
		 
		 OrderLine orderLine1 = new OrderLine();
	     orderLine1.setBook(bookStore.getBook(1));
	     orderLine1.setQuantity(3);
	     Order o = new Order();
	     List<OrderLine> l1 = new LinkedList<OrderLine>();
	     l1.add(orderLine1);
	     o.setItems(l1);
	     o.setUserId(1);
	     o.setUser(userStore.getUser(1));
	     
	     OrderLine orderLine2 = new OrderLine();
	     orderLine2.setBook(bookStore.getBook(2));
	     orderLine2.setQuantity(20);
	     Order o2 = new Order();
	     List<OrderLine> l2 = new LinkedList<OrderLine>();
	     l2.add(orderLine2);
	     o2.setItems(l2);
	     o2.setUserId(2);
	     o2.setUser(userStore.getUser(2));
	     
	     OrderLine orderLine3 = new OrderLine();
	     orderLine3.setBook(bookStore.getBook(3));
	     orderLine3.setQuantity(20);
	     Order o3 = new Order();
	     List<OrderLine> l3 = new LinkedList<OrderLine>();
	     l3.add(orderLine3);
	     o3.setItems(l3);
	     o3.setUserId(3);
	     o3.setUser(userStore.getUser(3));
		 
	     allInitOrder = new ArrayList<Order>();
	     allInitOrder.add(o);
	     allInitOrder.add(o2);
	     allInitOrder.add(o3);
	     
	     
	 }
}
