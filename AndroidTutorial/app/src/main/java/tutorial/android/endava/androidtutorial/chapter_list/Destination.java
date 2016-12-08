package tutorial.android.endava.androidtutorial.chapter_list;

/**
 * Created by radpopescu on 7/14/2016.
 */
public class Destination {

    private String destinationName;
    private String destinationTime;
    private String destinationDetails;

    public String getDestinationDetails() {
        return destinationDetails;
    }

    public void setDestinationDetails(String destinationDetails) {
        this.destinationDetails = destinationDetails;
    }

    private String location;
    private int imageUrl;

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String name) {
        this.destinationName = name;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
