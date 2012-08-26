/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Accessor;

/**
 *
 * @author Grzegorz
 */
public class Lyric {
int id;
String lyric;
String url;

    public Lyric(int id, String lyric, String url) {
        this.id = id;
        this.lyric = lyric;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
