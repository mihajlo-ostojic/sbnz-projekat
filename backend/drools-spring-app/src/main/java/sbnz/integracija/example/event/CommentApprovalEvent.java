package sbnz.integracija.example.event;

import java.time.LocalDate;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import sbnz.integracija.example.model.Comment;
import sbnz.integracija.example.model.CommentStatus;


@Role(Role.Type.EVENT)
@Expires("30d")
public class CommentApprovalEvent {
	private int customerId;
	private int commentId;
	private Comment comment;
	private CommentStatus status;
	private LocalDate date;
	private int seen = 0;
	
	public CommentApprovalEvent()
	{
		this.date = LocalDate.now();
	}
	
	
	
	

	public CommentApprovalEvent(int customerId, int commentId, CommentStatus status) {
		super();
		this.customerId = customerId;
		this.commentId = commentId;
		this.status = status;
		this.date = LocalDate.now();
	}
	
	public CommentApprovalEvent(int customerId,Comment com, int commentId, CommentStatus status) {
		super();
		this.comment = com;
		this.customerId = customerId;
		this.commentId = commentId;
		this.status = status;
		this.date = LocalDate.now();
	}




	public int getSeen() {
		return seen;
	}





	public void setSeen(int seen) {
		this.seen = seen;
	}





	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public CommentStatus getStatus() {
		return status;
	}

	public void setStatus(CommentStatus status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate orderDate) {
		this.date = orderDate;
	}



	public int getCommentId() {
		return commentId;
	}



	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	
	
	
	
}
