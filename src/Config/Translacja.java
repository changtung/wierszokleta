package Config;

/**
 * klasa odpowiedzialna za translacjec polskich literek z bazy danych i do bazy danych
 * @author pacior
 *
 */
public class Translacja {
	public String bazaJava(String slowo){
		String nowy ="";
		for ( int i = 0 ; i < slowo.length() ; i++ ){
			if ( slowo.charAt(i) == '/' )
				{
				i++;
				if ( slowo.charAt(i) == 'a' )
					{
					nowy += "ą";
					continue;
					}
				if ( slowo.charAt(i) == 'c' )
				{
				nowy += "ć";
				continue;
				}
				if ( slowo.charAt(i) == 'e' )
				{
				nowy += "ę";
				continue;
				}
				if ( slowo.charAt(i) == 'l' )
				{
				nowy += "ł";
				continue;
				}
				if ( slowo.charAt(i) == 'n' )
				{
				nowy += "ń";
				continue;
				}
				if ( slowo.charAt(i) == 'o' )
				{
				nowy += "ó";
				continue;
				}
				if ( slowo.charAt(i) == 's' )
				{
				nowy += "ś";
				continue;
				}
				if ( slowo.charAt(i) == 'x' )
				{
				nowy += "ź";
				continue;
				}
				if ( slowo.charAt(i) == 'z' )
				{
				nowy += "ż";
				continue;
				}
				}
			nowy += slowo.charAt(i);
		}
		return nowy;
	}
	public String javaBaza(String slowo){
		String nowy ="";
		for ( int i = 0 ; i < slowo.length() ; i++ ){
			if ( slowo.charAt(i) == 'ą' )
				{
				nowy += "/a";
				continue;
				}
			if ( slowo.charAt(i) == 'ć' )
			{
			nowy += "/c";
			continue;
			}
			if ( slowo.charAt(i) == 'ę' )
			{
			nowy += "/e";
			continue;
			}
			if ( slowo.charAt(i) == 'ł' )
			{
			nowy += "/l";
			continue;
			}
			if ( slowo.charAt(i) == 'ń' )
			{
			nowy += "/n";
			continue;
			}
			if ( slowo.charAt(i) == 'ó' )
			{
			nowy += "/o";
			continue;
			}
			if ( slowo.charAt(i) == 'ś' )
			{
			nowy += "/s";
			continue;
			}
			if ( slowo.charAt(i) == 'ź' )
			{
			nowy += "/x";
			continue;
			}
			if ( slowo.charAt(i) == 'ż' )
			{
			nowy += "/z";
			continue;
			}
			nowy += slowo.charAt(i);
			}
		return nowy; 
	}
	public static void main(String[] args){
		Translacja t = new Translacja();
		System.out.println(t.bazaJava("/afd/ad/cf"));
	}
}
