package sbnz.integracija.example;

import java.util.Collection;

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
	
	@GetMapping("/allbooks")
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(sampleService.getAllBooks());
    }
	
	@RequestMapping(value = "/userdata", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> getUserData(@RequestParam(required = true) String username) {

		return ResponseEntity.ok(sampleService.getUserData(username));
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

    @RequestMapping(value = "/addComment", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Comment> addComment(@RequestParam(required = true) int userId, @RequestParam(required = true) int bookId,
			@RequestParam(required = true) String content,@RequestParam(required = true) boolean status) {

    	return ResponseEntity.ok(sampleService.addNewComment(new NewCommentDto(bookId,userId,content,status)));
	}
    
    @RequestMapping(value = "/cancelorder", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> cancelOrder(@RequestParam(required = true) int userId, @RequestParam(required = true) int orderId) {
    	sampleService.cancelOrder(userId, orderId);
    	return ResponseEntity.ok("Order canceled");
	}

    @GetMapping("/recomendations/{username}")
    public ResponseEntity<RecomendationsDTO> getUserFeed(@PathVariable String username) {
        return ResponseEntity.ok(sampleService.getRecomendations(username));
    }
	
	
	
}
