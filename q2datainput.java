package appCS;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/////////////////////////////Q2/datainput/////////////////////////////
public class Client {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("localhost", 10233);
	    Scanner scan = new Scanner(System.in);//lire
	    DataOutputStream toserv = new DataOutputStream(socket.getOutputStream());//envoyer
	    DataInputStream inserv = new DataInputStream(socket.getInputStream());//recevoir
	    
	    //lire les 2mots
	    System.out.println("Entrer le 1er mot : ");
	    String line = scan.nextLine();
	    System.out.println("Entrer le 2eme mot : ");
	    String line2 = scan.nextLine();
	    
	    
	    //les envoyer au serveur
	    toserv.writeUTF(line);
	    toserv.writeUTF(line2);
	    
	    //lire la rep du server
	    String rep = inserv.readUTF();
	    
	    //affichage
	    System.out.println("mon Adresse client : " + socket.getLocalAddress() + " : " + socket.getLocalPort());
	    System.out.println("mon serveur : " + socket.getInetAddress() + " : " + socket.getPort());
	    System.out.println("Réponse du serveur : " + rep);
	    
	    //fermer
	    socket.close();
	    
	  }
	}      