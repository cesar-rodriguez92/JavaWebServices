package com.crodriguezt.restws.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class RestWebServiceClient {

	private Client client;
	private String REST_SERVICE_URL = "http://localhost:8080/UserManagement/apis/UserService/users";
	private static final String SUCCESS_RESULT = "<result>Success</result>";
	private static final String PASS = "pass";
	private static final String FAIL = "fail";
	
	private void init(){
		this.client = ClientBuilder.newClient();
	}

	public static void main(String[] args) {
		RestWebServiceClient clienterest = new RestWebServiceClient();
	      //initialize the tester
		  clienterest.init();
	      //test get all users Web Service Method
	      clienterest.testGetAllUsers();
	      //test get user Web Service Method 
	      clienterest.testGetUser();
	      //test update user Web Service Method
	      clienterest.testUpdateUser();
	      //test add user Web Service Method
	      clienterest.testAddUser();
	      //test delete user Web Service Method
	      clienterest.testDeleteUser();
		
	}
	
	private void testGetAllUsers(){
		GenericType<List<User>> lista =  new GenericType<List<User>>() {};
		List<User> users = client
				.target(REST_SERVICE_URL)
				.request(MediaType.APPLICATION_XML)
				.get(lista);
		String result =PASS;
		if (users.isEmpty()) {
			result= FAIL;
		}
		System.out.println("Test case name: testGetAllUsers, Result: " + result);
		for(User usuario: users){
			System.out.println(usuario.getId() + " - " +usuario.getName() + " - " + usuario.getProfession());
		}
	}
		
	private void testGetUser(){
	      User sampleUser = new User();
	      sampleUser.setId(1);

	      User user = client
	         .target(REST_SERVICE_URL)
	         .path("/{userid}")
	         .resolveTemplate("userid", 1)
	         .request(MediaType.APPLICATION_XML)
	         .get(User.class);
	      String result = FAIL;
	      if(sampleUser != null && sampleUser.getId() == user.getId()){
	         result = PASS;
	      }
	      System.out.println("Test case name: testGetUser, Result: " + result );
	   }
	   //Test: Update User of id 1
	   //Test: Check if result is success XML.
	   private void testUpdateUser(){
	      Form form = new Form();
	      form.param("id", "2");
	      form.param("name", "suresh");
	      form.param("profession", "clerk");

	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .put(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testUpdateUser, Result: " + result );
	   }
	   //Test: Add User of id 2
	   //Test: Check if result is success XML.
	   private void testAddUser(){
	      Form form = new Form();
	      form.param("id", "2");
	      form.param("name", "naresh");
	      form.param("profession", "clerk");

	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .request(MediaType.APPLICATION_XML)
	         .post(Entity.entity(form,
	            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
	            String.class);
	   
	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testAddUser, Result: " + result );
	   }
	   //Test: Delete User of id 2
	   //Test: Check if result is success XML.
	   private void testDeleteUser(){
	      String callResult = client
	         .target(REST_SERVICE_URL)
	         .path("/{userid}")
	         .resolveTemplate("userid", 2)
	         .request(MediaType.APPLICATION_XML)
	         .delete(String.class);

	      String result = PASS;
	      if(!SUCCESS_RESULT.equals(callResult)){
	         result = FAIL;
	      }

	      System.out.println("Test case name: testDeleteUser, Result: " + result );
	   }

}