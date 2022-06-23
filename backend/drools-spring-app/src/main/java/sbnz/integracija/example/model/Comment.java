package sbnz.integracija.example.model;


public class Comment {
	
	
    private int commentId;
    private int bookId;
	private int userId;
	private String content;
	public Comment() {
		super();
	}
	
	
	
	public Comment(int commentId, int bookId, int userId, String content) {
		super();
		this.commentId = commentId;
		this.bookId = bookId;
		this.userId = userId;
		this.content = content;
	}



	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
