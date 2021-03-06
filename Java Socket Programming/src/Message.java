import java.io.*;
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int header;
	private String data;
	private int protocallId;
	private int tailors;
	
	public Message(int header,String data,int protocallId) {
		this.header = header;
		this.data=data;
		this.protocallId=protocallId;
		
		
		String head = binaryConvertionInteger(header);
		String pID = binaryConvertionInteger(protocallId);
		String databin = binaryConvertionString(data);
		String tailorcheck = sum(head,pID,databin);
		System.out.println(tailorcheck);
		int tailorvalue = tailorcheck(tailorcheck);
		setTailors(tailorvalue);
		
		
	}
	
	public int tailorcheck(String tailor) {
		int length = tailor.length();
		int count=0;
		for(int i=0;i<length;i++) {
			if(tailor.charAt(i)=='1' ) {
				count ++;
			}
			
		}
		if(count%2==0) {
			return 0;
		}
		else {
			return 1;
		}
		
		
	}
	
	public String sum(String head, String pID,String databin) {
		int h = Integer.parseInt(head);
		int protocallID = Integer.parseInt(pID);
		int datab = Integer.parseInt(databin);
		int sum = h + protocallID + datab;
		String total = Integer.toBinaryString(sum);
		return total;
		
		
		
	}
	public String binaryConvertionInteger(int number) {
		String converted = Integer.toBinaryString(number);
		
		return converted;
	}
	public String binaryConvertionString(String data) {
		
		String converted = "010101010";
		
		return converted;
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

	public int getTailors() {
		return tailors;
	}

	public void setTailors(int tailors) {
		this.tailors = tailors;
	}

	
	
	
	

}
