/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Keywords;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grzegorz Patynek
 */
public class Keywords {
    public Keywords(List<String> slowa){
        
    }
    public static void main(String[] args){
        List<String> slowa = new ArrayList();
        slowa.add("ginekolog");
        slowa.add("poznań");
        slowa.add("invitro");
        slowa.add("hsg");
        slowa.add("ginekolog poznań");
        Keywords k = new Keywords(slowa);
        
    }
}
