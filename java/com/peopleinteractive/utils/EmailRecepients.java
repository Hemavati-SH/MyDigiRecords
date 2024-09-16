package com.peopleinteractive.utils;

import java.util.ArrayList;
import java.util.List;

public class EmailRecepients {
	
	public static List<String> mailID = new ArrayList<>();

	
	public static String saad_mail = "saad.k@peopleinteractive.in";
	
	public static String sagar_mail = "sagar.kunder@peopleinteractive.in";
	
	public static String rahul_mail = "rahul.g@peopleinteractive.in";
	
	public static String kalpit_mail = "kalpit.s@peopleinteractive.in";
	
	public static String yatin_mail = "yatin.m@peopleinteractive.in";
	
	public static String imran_mail = "imran.sayyed@peopleinteractive.in";
	
	public static String yogi_mail = "yogendra.singh@peopleinteractive.in";
	
	public static String panchasheela_mail = "panchsheela.k@peopleinteractive.in";
	
	public static String purna_mail = "purna.t@peopleinteractive.in";

	public static String prachi_mail = "prachi.walawalkar@peopleinteractive.in";
	
	public static String nitin_mail = "nitin.s@peopleinteractive.in";


	
	public static List<String> getMailIds(){
		
		mailID.add(nitin_mail);
		
		mailID.add(sagar_mail);
		
		return mailID;

	}
	
	/*
	 * public static String[] getArrayOfMail() {
	 * 
	 * String[] mails = new String[mailID.size()]; for(int i = 0 ; i < mailID.size()
	 * ; i++) {
	 * 
	 * mails[i] = mailID.get(i);
	 * 
	 * }
	 * 
	 * return mails; }
	 */




}
