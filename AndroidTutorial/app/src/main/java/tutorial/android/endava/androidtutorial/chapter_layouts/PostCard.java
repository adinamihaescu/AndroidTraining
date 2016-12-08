package tutorial.android.endava.androidtutorial.chapter_layouts;

import java.io.Serializable;

/**
 * Created by amihaescu on 8/3/2016.
 */
public class PostCard implements Serializable {

    private String destination;
    private String date;
    private String text;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
