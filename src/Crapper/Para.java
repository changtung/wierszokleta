package Crapper;

/**
 * klasa odpowiedzialna za pare adresow (a,b)
 * @author witchhunter
 */
public class Para {
    Para(String a,String b){
        this.a = a;
        this.b = b;
    }
    public String a;
    public String b;
    /**
     * przeciazenie metody equals, tak ze mozemy porownywac pary jak obiekty. rowne gdy wektory dwoch par sa sobie rowne
     * @param o obiekt, musi byc to obiekt typu Para
     * @return true jesli sa sobie rowne
     */
    public boolean equals(Object o){
        Para p = (Para)o;
        if ( ( p.a.equals(this.a) == true ) && ( p.b.equals(this.b) == true ) ){
            return true;
        }
        else 
            return false;
    }
}
