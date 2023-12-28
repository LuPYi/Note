package beans;

public class NoteBook {
	private int id;  // 自動新增
    private String subject;
    private String context;
    
    // 空的建構子
    public NoteBook() {
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
 
    
}
