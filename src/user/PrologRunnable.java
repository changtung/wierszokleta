/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class PrologRunnable implements Runnable {
    public PrologRunnable(BufferedReader input){
        this.input = input;
    }
        public PrologRunnable(){
    }
    BufferedReader input;
    List<String> rezultat = null;

    public List<String> getRezultat() {
        return rezultat;
    }

    public void setRezultat(List<String> rezultat) {
        this.rezultat = rezultat;
    }
    public void run() {
      /*  String line = "";
        this.rezultat = new ArrayList();
        try {
        while ( (!Thread.currentThread().isInterrupted()) || ((line = input.readLine()) != null) ){
                            if ( line != "")
                             rezultat.add(line);
            }
        }
        catch ( Exception e){
            
        }
        finally {
            System.out.println("rezultat");
        this.setRezultat(rezultat);
        }
       * 
       */
    }

    public static void main(String args[]) {
        PrologRunnable pr = new PrologRunnable();
        Thread t = new Thread(pr);
        //Thread t = new Thread(pr);
        t.start();

        //wait for specified time
        Thread thisThread = Thread.currentThread();
         try
             {
             thisThread.sleep(3000);
         }
         catch (Throwable tt)
             {
             throw new OutOfMemoryError("An Error has occured");
         }
        System.out.println("oki");
        try {
        t.interrupt();
        }
        catch ( Exception e){
            System.out.println("exc:"+e);
        }
               // System.out.println(pr.isAlive());
        
    }

}