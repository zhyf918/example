package com.jmust.thrift.impl;
 
import org.apache.thrift.TException;
 

import com.jmust.thrift.service.HelloWorldService.Iface;
 
/**
 * 
 * @author LK
 *
 */
public class HelloWorldImpl implements Iface
{
 
	public HelloWorldImpl(){
		
	}
	
	public String sayHello(String username) throws TException {
		return "Hi," + username + " welcome to my blog www.jmust.com";
	}
   
}
