package appCS;
import java.io.*;
import java.net.*;
//////////////////////////////Q2/datainput///////////
public class Serveur {


	  public static void main(String[] args) {
	    try {
	      ServerSocket server = new ServerSocket(10233);

	      System.out.println("Serveur en attente");

	      while (true) {
	        Socket socket = server.accept();
	        DataInputStream inserv = new DataInputStream(socket.getInputStream());
	        DataOutputStream tocli = new DataOutputStream(socket.getOutputStream());
	        
            //lire les 2mots recus
	        String line = inserv.readUTF();
	        String line2 = inserv.readUTF();
	        System.out.println(" message reçu du client est : "+line+ " et " +line2);
	  
            //verifier 
	        if (line.contains(line2)) {
	        	tocli.writeUTF(line + " contient " + line2);
	        } else {
	          tocli.writeUTF(line + " ne contient pas " + line2);
	        }
	      
            //fermer
	        socket.close();
	      }
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	}
