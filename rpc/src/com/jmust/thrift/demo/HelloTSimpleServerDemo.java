package com.jmust.thrift.demo;

 

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
 




import com.jmust.thrift.impl.HelloWorldImpl;
import com.jmust.thrift.service.HelloWorldService;
import com.jmust.thrift.service.HelloWorldService.Iface;
import com.jmust.thrift.service.HelloWorldService.Processor;
 
/**
 * 单线程服务模型，一般用于测试  TSimpleServer服务端
 * @author LK
 *
 */
public class HelloTSimpleServerDemo {
 
	public static final int SERVER_PORT = 8100;
 
	public void startServer() {
		try {
			System.out.println("HelloWorld TSimpleServer start ....");
 
			  TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldImpl());
	            // HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;
	            // tprocessor =
	            // new HelloWorldService.Processor&lt;HelloWorldService.Iface&gt;(
	            // new HelloWorldImpl());

	            // 简单的单线程服务模型，一般用于测试
	            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
	            TServer.Args tArgs = new TServer.Args(serverTransport);
	            tArgs.processor(tprocessor);
	            tArgs.protocolFactory(new TBinaryProtocol.Factory());
	            // tArgs.protocolFactory(new TCompactProtocol.Factory());
	            // tArgs.protocolFactory(new TJSONProtocol.Factory());
	            TServer server = new TSimpleServer(tArgs);
	            server.serve();
 
		} catch (Exception e) {
			System.out.println("Server start error!!!");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyThread myThread=new MyThread();
  	  myThread.start();

		HelloTSimpleServerDemo server = new HelloTSimpleServerDemo();
		server.startServer();
		
		
		
	}
	
	
	
	

}
