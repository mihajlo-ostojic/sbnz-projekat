package sbnz.integracija.example.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CommentStore {

	
	private List<Comment> allComments;
	private int lastId = 0;

	public CommentStore() {
		super();
		this.allComments = new ArrayList<Comment>();
		this.lastId = 0;
	}
	
	public Comment addComment(Comment newComment) {
		this.lastId++;
		newComment.setCommentId(this.lastId);
		
		allComments.add(newComment);
		return newComment;
	}
	
	public Comment getComment(int id) {
		for (Comment c : this.allComments) {
			if(c.getCommentId() == id)
			{
				return c;
			}
		}
		return null;
	}
	
	public List<Comment> getCommentsByBook(int bookId)
	{
		List<Comment> allFound = new ArrayList<Comment>();
		for (Comment c : this.allComments) {
			if(c.getBookId() == bookId )
			{
				allFound.add(c);
			}
		}
		
		return allFound;
	}

	public List<Comment> getAllComments() {
		return allComments;
	}

	public void setAllComments(List<Comment> allComments) {
		this.allComments = allComments;
	}
	
	
}
