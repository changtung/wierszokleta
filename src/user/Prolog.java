/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package user;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;				// empirically, we need this, but I don't know why...
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jpl.*;
/**
 *
 * @author Grzegorz
 */
public class Prolog {
        public String[]
	start()
	{
		System.out.println( "start..." );
		Variable X = new Variable("X");
		Variable Y = new Variable("Y");
                Variable Z = new Variable("Z");
		Variable W = new Variable("W");
		Query query =
			new Query(
				"wiersz",
				new Term[] {X,Y,Z,W}
			);

		Hashtable solution = query.oneSolution();


			Object x = solution.get("X");
			Object y = solution.get("Y");
			Object z = solution.get("Z");
			Object w = solution.get("W");
                        String[] res = new String[4];
                        res[0] = ((Compound)x).toString();
                        res[1] = ((Compound)y).toString();
                        res[2] = ((Compound)z).toString();
                        res[3] = ((Compound)w).toString();
   
		System.out.println( "passed.d" );
                return res;
	}
        	static void
	test_0()
	{
		System.out.print( "test 0..." );

				Term consult_arg[] = {
			new Atom( "c:\\wiersz\\wiersz.pl" )
		};
		Query consult_query =
			new Query(
				"consult",
				consult_arg );

		boolean consulted = consult_query.query();

		if ( !consulted ){
			System.err.println( "Consult failed" );
			System.exit( 1 );
		}
		System.out.println( "passed." );
	}
                public String compoundToString(String s){
                      Pattern pattern = Pattern.compile( "[\\w\\u0105\\u0107\\u0119\\u0142\\u0144\\u00F3\\u015B\\u017A\\u017C]+" );
                      System.out.println("string: "+s);
    Matcher matcher = pattern.matcher( s );
    String st;
    String res = "";
    while ( matcher.find() ) {
        st = matcher.group();
        System.out.println("st:"+st);
        res += st +" ";
    }
    return res;
                }
}
