package day0307;

public class Ex7Board {

	private String writer;
	private String subject;
	private String content;
	
	//생성자
	public Ex7Board() {
		// TODO Auto-generated constructor stub
	}
	public Ex7Board(String writer,String subject,String content) {
		this.writer=writer;
		this.subject=subject;
		this.content=content;
	}
	//setters & getters
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
