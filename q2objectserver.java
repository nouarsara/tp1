package app1;

import java.io.*;
import java.net.*;
public class Server3 {   //////////Q2/object//////

	  public static void main(String[] args) throws ClassNotFoundException {
		    try {
		      ServerSocket server = new ServerSocket(12231);

		      System.out.println("Serveur en attente");

		      while (true) {
		        Socket socket = server.accept();
		        ObjectInputStream inserv = new ObjectInputStream(socket.getInputStream());
		        ObjectOutputStream tocli = new ObjectOutputStream(socket.getOutputStream());
		        
	            //lire les 2mots recus
		        String line =(String) inserv.readObject();
		        String line2 = (String)inserv.readObject();
		        System.out.println(" message reçu du client est : "+line+ " et " +line2);
		  
	            //verifier 
		        if (line.contains(line2)) {
		        	tocli.writeObject(line + " contient " + line2);
		        } else {
		          tocli.writeObject(line + " ne contient pas " + line2);
		        }
		      
	            //fermer
		        socket.close();
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
		}
