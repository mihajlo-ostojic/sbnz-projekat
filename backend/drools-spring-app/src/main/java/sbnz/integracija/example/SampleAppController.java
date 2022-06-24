package sbnz.integracija.example;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.facts.User;
import sbnz.integracija.example.model.Book;
import sbnz.integracija.example.model.BookDto;
import sbnz.integracija.example.model.Comment;
import sbnz.integracija.example.model.NewCommentDto;
import sbnz.integracija.example.model.Order;
import sbnz.integracija.example.model.RecomendationsDTO;

@RestController
public class SampleAppController {
	private static Logger log = LoggerFactory.getLogger(SampleAppController.class);

	private final SampleAppService sampleService;

	@Autowired
	public SampleAppController(SampleAppService sampleService) {
		this.sampleService = sampleService;
	}

//	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
//	public Item getQuestions(@RequestParam(required = true) String id, @RequestParam(required = true) String name,
//			@RequestParam(required = true) double cost, @RequestParam(required = true) double salePrice) {
//
//		Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);
//
//		log.debug("Item request received for: " + newItem);
//
//		Item i2 = sampleService.getClassifiedItem(newItem);
//
//		return i2;
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> getUserData(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {
		System.out.println("trazi " + username + " " + password);
		User found = sampleService.login(username, password);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("/allbooks")
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(sampleService.getAllBooks());
    }
	
	@RequestMapping(value = "/userdata", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> getUserData(@RequestParam(required = true) String username) {
		System.out.println("trazi korisnice podatk");
		return ResponseEntity.ok(sampleService.getUserData(username));
	}
	
	@RequestMapping(value = "/userorders", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Order>> getUserOrders(@RequestParam(required = true) int userId) {
		System.out.println("trazi korisnice ordere");
		return ResponseEntity.ok(sampleService.getUserOrders(userId));
	}
	
	@RequestMapping(value = "/bookData", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<BookDto> getUserData(@RequestParam(required = true) int bookId) {
		return ResponseEntity.ok(sampleService.getBookData(bookId));
	}
    
    @RequestMapping(value = "/markbook", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Book> markBook(@RequestParam(required = true) int userId, @RequestParam(required = true) int bookId,
			@RequestParam(required = true) double mark) {

    	return ResponseEntity.ok(sampleService.markBook(bookId, userId, mark));
	}
    
    @RequestMapping(value = "/shareinfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> shareInfo(@RequestParam(required = true) int userId, @RequestParam(required = true) int bookId) {
    	sampleService.shareInfo(bookId, userId);
    	return ResponseEntity.ok("shared info");
	}

    @RequestMapping(value = "/addComment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Comment> addComment(@RequestParam(required = true) int userId, @RequestParam(required = true) int bookId,
			@RequestParam(required = true) String content,@RequestParam(required = true) boolean statuss) {

    	return ResponseEntity.ok(sampleService.addNewComment(new NewCommentDto(bookId,userId,content,statuss)));
	}
    
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Order> addOrder(@RequestParam(required = true) int userId, @RequestParam(required = true) int bookId,
			@RequestParam(required = true) int amount) {
    	
    	return ResponseEntity.ok(sampleService.addNewOrder(userId, bookId, amount));
	}
    
    @RequestMapping(value = "/cancelorder", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> cancelOrder(@RequestParam(required = true) int userId, @RequestParam(required = true) int orderId) {
    	sampleService.cancelOrder(userId, orderId);
    	return ResponseEntity.ok("Order canceled");
	}
    
    @RequestMapping(value = "/approveorder", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> approveOrder(@RequestParam(required = true) int userId, @RequestParam(required = true) int orderId) {
    	sampleService.approveOrder(userId, orderId);
//    	sampleService.cancelOrder(userId, orderId);
    	return ResponseEntity.ok("Order approve");
	}
    
    @RequestMapping(value = "/recomendations", method = RequestMethod.GET, produces = "application/json")
   	public ResponseEntity<RecomendationsDTO> getRecomendations(@RequestParam(required = true) String username) {
      
       	return ResponseEntity.ok(sampleService.getRecomendations(username));
   	}
	
	
	
}
