import java.net.*;
import java.io.*;
public class serverSide {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(3333);
		Socket s=ss.accept();
		System.out.println("Connection established");
		DataInputStream Din = new DataInputStream(s.getInputStream());
		DataOutputStream Dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
	    for(int i=0;i<10;i++) {
		Message msg = (Message)oi.readObject();
		System.out.println(" header: "+msg.getHeader());
		System.out.println(" Data: "+msg.getData());
		System.out.println(" protocallId: "+msg.getProtocallId());
		System.out.println(" parity check: "+msg.getTailors());
		System.out.println();
	    }
	    
		
		
		String recMsg="",sendMsg="";
		while(!recMsg.equals("stop")) {
			recMsg = Din.readUTF();
			System.out.println("Client says: " + recMsg);
			sendMsg = br.readLine();
			Dout.writeUTF(sendMsg);
			Dout.flush();
		}
		System.out.println("Connection Terminated");
		Din.close();
		s.close();
		ss.close();

	}

}