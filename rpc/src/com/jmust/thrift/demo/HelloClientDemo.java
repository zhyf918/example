package com.jmust.thrift.demo;
 
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
 



import com.jmust.thrift.service.HelloWorldService;
import com.jmust.thrift.service.HelloWorldService.Client;
 
/**
 * 
 * @author LK
 *
 */
public class HelloClientDemo {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 8100;
	public static final int TIMEOUT = 30000;
 
	/**
	 *
	 * @param userName
	 */
	public void startClient(String userName) {
		TTransport transport = null;
		try {
			transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
			 // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            int i=0;
        	long start=System.currentTimeMillis()/1000;
            for(;;)
            {
            	i    ++;
            	 long end = System.currentTimeMillis()/1000;
            String result = client.sayHello((end-start)+"]["+i+"]"+userName);
           
            
            System.out.println("Thrify client result =: " + result);
            }
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			if (null != transport) {
				transport.close();
			}
		}
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloClientDemo client = new HelloClientDemo();
		client.startClient("lvk");
 
	}
}
