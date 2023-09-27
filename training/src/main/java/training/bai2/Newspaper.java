package training.bai2;

public class Newspaper extends Document{
    private String releaseDay;

    public Newspaper(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    public Newspaper(String documentCode, String publishingHouseName, String releaseNumber, String releaseDay) {
        super(documentCode, publishingHouseName, releaseNumber);
        this.releaseDay = releaseDay;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "releaseDay='" + releaseDay + '\'' +
                "} " + super.toString();
    }
}
