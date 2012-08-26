/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

/**
 *
 * @author Grzegorz
 */
public class Slowo {
private int id;
private String slowo;

    public Slowo(String slowo,int id) {
        this.slowo = slowo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlowo() {
        return slowo;
    }

    public void setSlowo(String slowo) {
        this.slowo = slowo;
    }
    public String toString(){
        return "slowo: "+this.getSlowo() + " id: " + this.getId();
    }
}
