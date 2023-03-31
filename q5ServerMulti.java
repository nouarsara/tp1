package multi;
import java.io.*;
import java.net.*;
public class Mult extends Thread {
	    private int nb;
		private Socket socket;
		public static void main(String argv[]){
			try {
				int nb=0;
		ServerSocket serverSocket = new ServerSocket(1236);
		System.out.println("Serveur en attente");
		while (true) 
		{Socket socketclient = serverSocket.accept();
		nb=nb+1;
		
		Mult t=new Mult (socketclient,nb);
		t.start();}}
		catch (Exception e) {e.printStackTrace(); }}
		
		public Mult(Socket socket,int nb){
			this.socket=socket;
			this.nb=nb;}
		public void run(){
		try{
		ObjectOutputStream output =new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream input =new ObjectInputStream(socket.getInputStream());
		
		// attente les données venant du client
		  //lire les 2mots recus
        String line =(String) input.readObject();
        String line2 = (String)input.readObject();
      
        System.out.println(" message reçu du client est : "+line+ " et " +line2);
         output.writeObject("Bienvenue, vous etes le client numero "+nb);
        //verifier 
        if (line.contains(line2)) {
        	output.writeObject(line + " contient " + line2);
        } else {
          output.writeObject(line + " ne contient pas " + line2);
        }}
		catch(Exception e) {
		System.err.println("Erreur :"+e);}}
		}