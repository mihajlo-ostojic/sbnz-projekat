package sbnz.integracija.example.event;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import sbnz.integracija.example.model.Comment;



@Role(Role.Type.EVENT)
@Expires("30d")
public class NewCommentEvent {

	private int customerId;
	private Comment comment;
	
	public NewCommentEvent()
	{}

	public NewCommentEvent(int customerId, Comment comment) {
		super();
		this.customerId = customerId;
		this.comment = comment;
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
	
	
}
