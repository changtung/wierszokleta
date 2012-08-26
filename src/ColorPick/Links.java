/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ColorPick;

import Config.Paths;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Grzegorz
 */
public class Links {
    Links(String temat){
        try {
        this.urls = this.pobierzLinki(temat);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
 String parserPath = Paths.htmlparser;
    public List<String> urls;

    public List<String> pobierzLinki(String temat) throws Exception{
           FileReader reader = new FileReader(Config.Paths.curl+temat+".html");
           return LinkExtractor.extractLinks(reader);
    }
}
