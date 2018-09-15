package com.jmust.thrift.demo;

class MyThread extends Thread{
	public void run(){
		
		int i=0;
		while(true){
			long start=System.currentTimeMillis()/1000;
			try {
				i++;
				//Thread.sleep(3000);
				HelloClientDemo client = new HelloClientDemo();
				long end = System.currentTimeMillis()/1000;
 				client.startClient((end-start)+"]["+i+"]Thrify client result =: Hi,client:5025 welcome to my blog www.jmust.comThrify client result =: Hi,client:5025 welcome to my blog www.jmust.comThrify client result =: Hi,client:5025 welcome to my blog www.jmust.comThrify client result =: Hi,client:5025 welcome to my blog www.jmust.comThrify client result =: Hi,client:5025 welcome to my blog www.jmust.comThrify client result =: Hi,client:5025 welcome to my blog www.jmust.com:"+i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
			 
		 
 		}
	}
}