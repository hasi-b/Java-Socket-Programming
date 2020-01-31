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
		Message msg = (Message)oi.readObject();
		System.out.println("Obect header: "+msg.getHeader());
		System.out.println("Obect header: "+msg.getData());
		System.out.println("Obect header: "+msg.getProtocallId());
		System.out.println("Obect header: "+msg.getTailors());
		
		
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
