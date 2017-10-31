    //SERVER   
    import java.net.*;  
    import java.util.*;
    public class Server{  
      public static void main(String[] args) throws Exception {  
        String send,receive;
        DatagramSocket ob = new DatagramSocket(3001);  
        DatagramPacket ob1;
        System.out.println("------SERVER IS READY-------");
	System.out.println("TYPE bye TO END THE CHAT");
        do
        {   
        byte[] buffer = new byte[1024];  
        ob1 = new DatagramPacket(buffer, 1024);
        ob.receive(ob1);  
        receive = new String(ob1.getData(), 0,ob1.getLength());
	System.out.println(receive);  
         if(receive.equals("bye")||receive.equals("BYE"))
            {
              break;  
            }
        
        Scanner in=new Scanner(System.in);
        send=in.nextLine();
        InetAddress ip = InetAddress.getByName("127.0.0.1");       
        ob1 = new DatagramPacket(send.getBytes(), send.length(), ip, 3002);  
        ob.send(ob1);
	if(send.equals("bye")||send.equals("BYE"))
            {
              break;  
            }
        }while(true);  
        ob.close();  
      }  
    }  
