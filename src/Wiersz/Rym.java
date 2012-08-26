/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Wiersz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 304 rymy 
 * @author Grzegorz
 */
public class Rym {
   // private String[] rymys = { "aw","wa","ar","ra","at","ta","ap","pa","as","sa","ad","da","af","fa","ag","ga","ah","ha","ak","ka","al","la","az","za","ac","ca","ab","ba","an","na","am","ma","ań","ńa","aż","ża","ać","ća","ew","we","er","re","et","te","ep","pe","es","se","ed","de","ef","fe","eg","ge","eh","he","ek","ke","el","le","ez","ze","ec","ce","eb","be","en","ne","em","me","eń","ńe","eż","że","eć","će","yw","wy","yr","ry","yt","ty","yp","py","ys","sy","yd","dy","yf","fy","yg","gy","yh","hy","yk","ky","yl","ly","yz","zy","yc","cy","yb","by","yn","ny","ym","my","yń","ńy","yż","ży","yć","ćy","uw","wu","ur","ru","ut","tu","up","pu","us","su","ud","du","uf","fu","ug","gu","uh","hu","uk","ku","ul","lu","uz","zu","uc","cu","ub","bu","un","nu","um","mu","uń","ńu","uż","żu","uć","ću","iw","wi","ir","ri","it","ti","ip","pi","is","si","id","di","if","fi","ig","gi","ih","hi","ik","ki","il","li","iz","zi","ic","ci","ib","bi","in","ni","im","mi","iń","ńi","iż","żi","ić","ći","ow","wo","or","ro","ot","to","op","po","os","so","od","do","of","fo","og","go","oh","ho","ok","ko","ol","lo","oz","zo","oc","co","ob","bo","on","no","om","mo","oń","ńo","oż","żo","oć","ćo","ęw","wę","ęr","rę","ęt","tę","ęp","pę","ęs","sę","ęd","dę","ęf","fę","ęg","gę","ęh","hę","ęk","kę","ęl","lę","ęz","zę","ęc","cę","ęb","bę","ęn","nę","ęm","mę","ęń","ńę","ęż","żę","ęć","ćę","ąw","wą","ąr","rą","ąt","tą","ąp","pą","ąs","są","ąd","dą","ąf","fą","ąg","gą","ąh","hą","ąk","ką","ąl","lą","ąz","zą","ąc","cą","ąb","bą","ąn","ną","ąm","mą","ąń","ńą","ąż","żą","ąć","ćą" };
          String[] rymys = { "a","e","y","u","i","o","ę","ą","w","r","t","p","s","d","f","g","h","k","l","z","c","b","n","m","ń","ż","ć"};
          
    private List<String> rymy = new ArrayList();

    public List<String> getRymy() {
        return rymy;
    }

    public void setRymy(List<String> rymy) {
        this.rymy = rymy;
    }

    public Rym() {
        for ( int i = 0 ; i < rymys.length ; i++)
            rymy.add(rymys[i]);
    }

    public static void main(String[] args){
        String[] samogloski = { "a","e","y","u","i","o","ę","ą"};
        String[] spolgloski = { "w","r","t","p","s","d","f","g","h","k","l","z","c","b","n","m","ń","ż","ć"};
        List<String> rymy = new ArrayList();
        for ( int i= 0 ; i < samogloski.length ; i++ )
            for ( int j = 0 ; j < spolgloski.length ; j++ ){
                rymy.add(samogloski[i]+spolgloski[j]);
                rymy.add(spolgloski[j]+samogloski[i]);
            }
        Iterator it = rymy.iterator();
        String tmp = "";
        while ( it.hasNext() ){
            tmp = (String)it.next();
            System.out.print("\""+tmp+"\""+",");
        }
        System.out.println(rymy.size());
    }
}
