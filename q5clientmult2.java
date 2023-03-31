﻿package app1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3M {

public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Socket socket = new Socket("localhost", 1236);
		
	    Scanner scan = new Scanner(System.in);//lire
	    ObjectOutputStream toserv = new ObjectOutputStream(socket.getOutputStream());//envoyer
	    ObjectInputStream inserv = new ObjectInputStream(socket.getInputStream());//recevoir
	    
	    //lire les 2mots
	    System.out.println("Entrer le 1er mot : ");
	    String line = scan.nextLine();
	    System.out.println("Entrer le 2eme mot : ");
	    String line2 = scan.nextLine();
	    
	    
	    //les envoyer au serveur
	    toserv.writeObject(line);
	    toserv.writeObject(line2);
	    
	    //lire la rep du server
	    String rep = (String) inserv.readObject();
	    
	    //affichage
	    String num = (String) inserv.readObject();
	    System.out.println("mon Adresse client : " + socket.getLocalAddress() + " : " + socket.getLocalPort());
	    System.out.println("mon serveur : " + socket.getInetAddress() + " : " + socket.getPort());
	    System.out.println( num);
	    System.out.println(rep);
	    //fermer
	    socket.close();
		
	  }}


