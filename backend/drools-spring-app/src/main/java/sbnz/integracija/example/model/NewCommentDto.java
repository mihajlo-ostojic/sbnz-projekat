package sbnz.integracija.example.model;

public class NewCommentDto {

	private int bookId;
	private int userId;
	private String content;
	private boolean status;
	
	
	public NewCommentDto() {
		super();
	}
	public NewCommentDto(int bookId, int userId, String content, boolean status) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.content = content;
		this.status = status;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
