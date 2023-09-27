package training.bai2;

public class Document {
    private String documentCode;
    private String publishingHouseName;
    private String releaseNumber;

    public Document() {
    }

    public Document(String documentCode, String publishingHouseName, String releaseNumber) {
        this.documentCode = documentCode;
        this.publishingHouseName = publishingHouseName;
        this.releaseNumber = releaseNumber;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    public String getPublishingHouseName() {
        return publishingHouseName;
    }

    public void setPublishingHouseName(String publishingHouseName) {
        this.publishingHouseName = publishingHouseName;
    }

    public String getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentCode='" + documentCode + '\'' +
                ", publishingHouseName='" + publishingHouseName + '\'' +
                ", releaseNumber='" + releaseNumber + '\'' +
                '}';
    }
}
