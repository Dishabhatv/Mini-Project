package com;
import java.util.Random;
//email address
//set password and update password
//mailbox capacity
//alternate email id.
import java.util.Scanner;
import java.util.regex.Pattern;

public class Email {
	private String email;
	private String password;
	private String altemail;
	private int capacity;
	
	//constructor
	public Email(String email) {
		this.email=email;
		this.password=setPassword(8);
		this.capacity=setCapacity(1000);
	}
	
	//set password of given length.
	public String setPassword(int length) {
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_0123456789@$#^&";
		Random rand=new Random();
		StringBuilder password=new StringBuilder();
		for(int i=0;i<length;i++) {
		char ch=chars.charAt(rand.nextInt(chars.length()));
		password.append(ch);
		}
		return password.toString();
	}
	
	//setting capacity of the mailbox.
	public int setCapacity(int cap) {
		this.capacity=cap;
		return capacity;
	}
	
	//Alternative g-mail.
	public void setAltemail(String email2) {
		this.altemail=email2;
	}
	
	//update the password.
	public void updatePassword(String newPass) {
		this.password=newPass;
	}
	
	//display the information.
	public void showinfo() {
		System.out.println("Email:"+this.email);
		System.out.println("Capacity of Mailbox:"+this.capacity+"MB");
		System.out.println("Password:"+this.password);
		System.out.println(this.altemail==null ? "none":this.altemail);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the email:");
		String ip=sc.next();
		//verify the email.
		String pattern="[A-Za-z0-9]+@[A-Za-z]+\\.[a-z]{2,}";
		while(!Pattern.matches(pattern, ip)) {
			System.out.println("Enter valid email id(A-z@gmail.com):");
			ip=sc.next();
		}
		
		Email obj=new Email(ip);
		System.out.println("Enter an alternative email:");
		String email2=sc.next();
		obj.setAltemail(email2);
		
		System.out.println("Email info:");
		obj.showinfo();
		
		System.out.println("Enter the new password to update:");
		String newPass=sc.next();
		obj.updatePassword(newPass);
		
		System.out.println("Email info:");
		obj.showinfo();

		sc.close();
	}
	
}
