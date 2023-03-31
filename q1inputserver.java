import java.io.*;
import java.net.*;
public class ServerTry {
	public static void main(String[] args) 
	{
//////////////////////////Q1/////////////
	try { int port=42010;
		// serveur positionne sa socket d'écoute
		ServerSocket ss = new ServerSocket(port);
		// se met en attente de connexion de la part d'un client
		System.out.println("Serveur en attente: ");
		Socket soc = ss.accept();

		PrintWriter tocli = new PrintWriter ( soc . getOutputStream ());//pour envoyer au client
		
        BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));//recevoir du client
        
        //lire from client 2 chaines et les stocker dans 2 var line et line2
		String line = reader.readLine ();
		 String line2 = reader.readLine();
		 System.out.println(" message reçu du client est : "+line+ " et " +line2);
		 
		 //verifier si la 1ere contient la 2eme
		 String rep = "";
         if (line.contains(line2)) {
             rep = line + " contient " + line2;
         } else {
            rep = line + " ne contient pas " + line2;
         }
		 // envoyer la reponse au client 
         tocli.println(rep);
         tocli.flush();
         
         //fermer les scockets
         ss.close();
         soc.close();
	}
	catch (Exception e) {
		System.err.println("Erreur: "+e);}}


}	

   