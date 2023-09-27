package training.bai2;

public class Book extends  Document {
    private String authorName;
    private int pageNumber;

    public Book(String documentCode, String publishingHouseName, String releaseNumber,
                String authorName, int pageNumber) {
        super(documentCode, publishingHouseName, releaseNumber);
        this.authorName = authorName;
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                super.toString() + ", " +
                "authorName='" + authorName + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
