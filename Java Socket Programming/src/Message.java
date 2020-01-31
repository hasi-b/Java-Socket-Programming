import java.io.*;
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int header;
	private String data;
	private int protocallId;
	private boolean tailor;
	
	public Message(int header,String data,int protocallId, boolean tailor) {
		this.header = header;
		this.data=data;
		this.protocallId=protocallId;
		this.tailor=tailor;
		
		
	}

	public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getProtocallId() {
		return protocallId;
	}

	public void setProtocallId(int protocallId) {
		this.protocallId = protocallId;
	}

	public boolean isTailor() {
		return tailor;
	}

	public void setTailor(boolean tailor) {
		this.tailor = tailor;
	}
	
	
	

}
