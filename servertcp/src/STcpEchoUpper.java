/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 18220
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class STcpEchoUpper {

    public static void main(String[] args) throws IOException {

        int PORTA = 2000;  // porta di ascolto
        ServerSocket S;

        S = new ServerSocket(PORTA);
        System.out.println("Server in ascolto");
        Socket ss = S.accept();
        System.out.println("Serve connesso");
        // ss connesso con client

        BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        PrintWriter bw = new PrintWriter(new OutputStreamWriter(ss.getOutputStream()), true);
        String riga;
        riga = br.readLine();
        if(riga.contains("GET")){
        while (riga.length()>0) {
            
            System.out.println(">" + riga);

            
            riga=br.readLine();
        }
        
        String risposta,risposta2;
        risposta="<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "  <h1>Hi there!</h1>\n"
                + "</head>\n"
                + "<body>\n"
                + " <p> Hello world</p>\n"
                + "</body>\n"
                + "</html>";
       
        
        risposta2 = "HTTP/1.1 200 OK\n"
                + "Content-Length:"+risposta.length()+"\n"
                + "Content-Type: text/html\n";
        System.out.println(risposta);
        System.out.println(risposta2);
       
        bw.println(risposta2);
        bw.println();
        bw.println();
        bw.println(risposta);
        ss.close();
        S.close();
    }
    else{
            System.out.println("Non è la richiesta corretta");
}
}
}
