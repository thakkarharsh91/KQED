package com.paymentgateway.restcontroller;
import java.io.IOException;
import java.util.Random;

import javax.ws.rs.core.MediaType;

import com.paymentgateway.model.User;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SendEmailMethods {

	public static void sendCustomEmail(User user) throws IOException {
		Random r = new Random();
		int responseCode = 0;
		int responseStatus = 0;
		int counter = 0;
		if(r.nextBoolean()){
			while(counter < 3){
				if(counter == 0){
					System.out.println("Sending the email using the Mailgun Api");
					responseStatus = sendEmailUsingMailGun(user);
					counter++;
					if(responseStatus == 200)
						break;
				}
					
				else if(counter > 0 && !(responseStatus == 200)){
					System.out.println("Trying again using the Mailgun Api");
					responseStatus =  sendEmailUsingMailGun(user);
					counter++;
					if(responseStatus == 200)
						break;
				}
				else
					counter++;
			}
			if(!(responseStatus == 200)){
				System.out.println("Sending finally with Sendgrid Api");
				sendEmailUsingSendGrid(user);
			}
		
		}
		else{

			while(counter < 3){
				if(counter == 0){
					System.out.println("Sending the email using the SendGrid Api");
					responseCode = sendEmailUsingSendGrid(user);
					counter++;
					if(responseCode == 202)
						break;
				}
					
				else if(counter > 0 && !(responseCode==202)){
					System.out.println("Trying again using the SendGrid Api");
					responseCode =  sendEmailUsingSendGrid(user);
					counter++;
					if(responseCode == 202)
						break;
				}
				else
					counter++;
			}
			if(!(responseCode == 202)){
				System.out.println("Sending finally with mailgun Api");
				sendEmailUsingMailGun(user);
			}
		
		}
	}

	private static int sendEmailUsingSendGrid(User user) throws IOException {

		Email from = new Email("test@example.com");
		String subject = user.getSubject();
		Email to = new Email(user.getEmail());
		Content content = new Content("text/plain", user.getBody());
		Mail mail = new Mail(from, subject, to, content);

		SendGrid sg = new SendGrid("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");
		Request request = new Request();
		try {
			request.method = Method.POST;
			request.endpoint = "mail/send";
			request.body = mail.build();
			Response response = sg.api(request);
			return response.statusCode;
		} catch (IOException ex) {
			throw ex;
		}
	}
	
	private static int sendEmailUsingMailGun(User user) {

	       Client client = Client.create();
	       client.addFilter(new HTTPBasicAuthFilter("api",
	                       "key-6ccbcefd92ef23373e638edb9fbcb84b"));
	       WebResource webResource =
	               client.resource("https://api.mailgun.net/v3/sandbox49500e12fe5b4f679478baf006256263.mailgun.org" +
	                               "/messages");
	       MultivaluedMapImpl formData = new MultivaluedMapImpl();
	       formData.add("from", "KQED User <mailgun@sandbox49500e12fe5b4f679478baf006256263.mailgun.org>");
	       formData.add("to", user.getEmail());
	       formData.add("subject", user.getSubject());
	       formData.add("text", user.getBody());
	       ClientResponse cr = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	               post(ClientResponse.class, formData);
	       return cr.getStatus();
	       /*return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	               post(ClientResponse.class, formData);*/
	
		
	}
}
