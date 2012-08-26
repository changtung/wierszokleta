/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CreWriter;

import java.util.ArrayList;

/**
 *
 * @author witchhunter
 */
public class Encja {
    private boolean single = true;
    private String sValue;
    private ArrayList<String> lValue;
    public Encja(String s){
        this.single = true;
        this.sValue = s;
        this.lValue = null;
    }
    public Encja(ArrayList<String> l){
        this.single = false;
        this.sValue = null;
        this.lValue = l;
    }
    public String toString(){
        if ( this.single == true )
            return sValue;
        else
            return los(lValue);
    }
    public String los(ArrayList<String> al){
        double r = (Double)( Math.random() * (al.size()) );
        int rr = (int)r;
        return al.get(rr);
    }
}
