/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LoadingIspell;

/**
 * Klasa odpowiada za dodawanie ispella do bazy, musza byc odpowiednio spreparowane pliki
 * @author Grzegorz
 */
public class Loading {
    /**
     * Dodaje pliki ispella do nowej bazy danych
     * @param host host do bazy danych
     * @param login login do bazy
     * @param password haslo do bazy
     * @param dbName nazwa bazy
     * @param ISpellDirectory sciezka do katalogu z ispellem
     */
    public Loading(String host,String login,String password,String dbName,String ISpellDirectory,javax.swing.JProgressBar jpb){
        String dbAddress = "jdbc:mysql://"+host+"/"+dbName+"?user="+login+"&password="+password;
        this.dbAddress = dbAddress;
        this.ISpell = ISpellDirectory;
        this.init();
        this.jProgressBar1 = jpb;
    }
        public Loading(String host,String login,String password,String dbName,String ISpellDirectory){
        String dbAddress = "jdbc:mysql://"+host+"/"+dbName+"?user="+login+"&password="+password;
        this.dbAddress = dbAddress;
        this.ISpell = ISpellDirectory;
        this.init();
        this.jProgressBar1 = null;
    }
    /**
     * kasuje wszystkie tabele i tworzy na nowo
     */
    public void init(){
                        wczytajSl w = new wczytajSl('a',this.ISpell,"A",this.dbAddress);
                        w.init();
                        System.out.println("inicjacja zakonczona");
    }
    /**
     * adres relacyjnej bazy danych znany dla jdbc
     */
    private String dbAddress;
    private static javax.swing.JProgressBar jProgressBar1;
    /**
     * sciezka do kataogu gdzie znajduja sie pliki slownika
     */
    private String ISpell;
    /**
     * wrzuca wszystkie slowa ispella do relacyjnej bazy danych
     */
    public void start(){
        int i = 0;
        int k = 150;
        System.out.println("Database inserting started");

                wczytajSl w = new wczytajSl('a',this.ISpell,"A",this.dbAddress);


                w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('b',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('c',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('d',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('e',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('f',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('g',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('h',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('i',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('j',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('k',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('l',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('m',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('n',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('o',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('p',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('q',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('r',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('s',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('t',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('u',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('v',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('w',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('x',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('y',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('z',this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

                //duze
                w = new wczytajSl('A',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('B',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('C',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('D',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('E',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('F',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('G',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('H',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('I',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('J',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('K',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('L',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('M',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('N',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('O',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('P',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Q',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('R',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('S',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('T',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('U',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('V',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('W',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('X',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Y',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Z',true,this.ISpell,"A",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

                //B
                w = new wczytajSl('a',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('b',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('c',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('d',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('e',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('f',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('g',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('h',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('i',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('j',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('k',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('l',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('m',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('n',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('o',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('p',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('q',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('r',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('s',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('t',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('u',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('v',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('w',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('x',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('y',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('z',this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

                //duze
                w = new wczytajSl('A',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('B',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('C',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('D',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('E',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('F',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('G',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('H',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('I',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('J',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('K',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('L',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('M',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('N',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('O',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('P',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Q',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('R',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('S',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('T',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('U',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('V',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('W',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('X',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Y',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Z',true,this.ISpell,"B",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
                //C

                w = new wczytajSl('a',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('b',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('c',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('d',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('e',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('f',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('g',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('h',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('i',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('j',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('k',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('l',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('m',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('n',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('o',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('p',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('q',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('r',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('s',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('t',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('u',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('v',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('w',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('x',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('y',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('z',this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

                //duze
                w = new wczytajSl('A',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('B',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('C',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('D',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('E',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('F',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('G',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('H',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('I',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('J',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('K',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('L',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('M',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('N',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('O',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('P',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Q',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('R',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('S',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('T',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('U',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('V',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;

		w = new wczytajSl('W',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('X',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Y',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
		w = new wczytajSl('Z',true,this.ISpell,"C",this.dbAddress);
		w.wczytujSlowa();System.out.println("Pozostalo: "+i+"/155 blokow");i++;
        System.out.println("Database inserting finished");
    }
    public static void main(String[] args){
        Loading l = new Loading("localhost","root","","ispell","d:\\teddy\\lib");
        l.start();
    }
}
