package training.bai2;

public class Magazine extends Document{
    private int issueNumber;
    private int releaseMonth;

    public Magazine(String documentCode, String publishingHouseName, String releaseNumber,
                    int issueNumber, int releaseMonth) {
        super(documentCode, publishingHouseName, releaseNumber);
        this.issueNumber = issueNumber;
        this.releaseMonth = releaseMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString() + ", " +
                "issueNumber=" + issueNumber +
                ", releaseMonth=" + releaseMonth +
                '}';
    }
}
