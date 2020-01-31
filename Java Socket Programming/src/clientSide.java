import java.net.*;
import java.io.*;
public class clientSide {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Socket cs = new Socket("localhost",3333);
		DataInputStream Din = new DataInputStream(cs.getInputStream());
		DataOutputStream Dout = new DataOutputStream(cs.getOutputStream());
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
		Message object = new Message(12,"WabbalabbaDubbDubb",1,true);
		os.writeObject(object);
		os.flush();
	
		String rcvMsg="",sentMsg="";
		while(!sentMsg.equals("stop")) {
			sentMsg = br.readLine();
			Dout.writeUTF(sentMsg);
			Dout.flush();
			rcvMsg = Din.readUTF();
			System.out.println("Server Says"+rcvMsg);
			
		}
		
		Dout.close();
		cs.close();
	}

}
