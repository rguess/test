package org.guess.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;


public class RequestTest {
    public static void main(String args []){
        try {
//Configure and open a connection to the site you will send the request
            URL url = new URL("http://www.oschina.net");
    URLConnection urlConnection = url.openConnection();

    //by setting doOutput property to true we indicate that we will use this urlConnection to write data

    urlConnection.setDoOutput(true);
    
   // by setting content-type property to  application/x-www-form-urlencoded we define that
  // the data that we intent to write on the request's body consist of  key/value pairs

    urlConnection.setRequestProperty("content-type","application/x-www-form-urlencoded");
    
// Get the request's output stream 
    OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
  
// write the data to the request body
    out.write("message=Hello world");
    
    out.flush();

    out.close();
//Read server's response
    InputStream inputStream = urlConnection.getInputStream();
    String encoding = urlConnection.getContentEncoding();
    String body = IOUtils.toString(inputStream, encoding);
    System.out.println(body);
        } catch (IOException ex) {
            Logger.getLogger(RequestTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
