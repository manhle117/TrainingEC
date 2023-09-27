package training.bai2;

import training.common.InputUtils;

import java.util.List;

public class MainBai2 {
    private static final DocumentManagement documentManagement = new DocumentManagement();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n\n\n=== menu ===");
            System.out.println("1. add new document");
            System.out.println("2. remove document by document code");
            System.out.println("3. display information of document");
            System.out.println("4. find document by document type");
            System.out.println("5. stop");
            String choose = InputUtils.inputString("Choose your choice: ");

            switch (choose) {
                case "1": {
                    Document doc = inputDocument();
                    documentManagement.addDocument(doc);
                    break;
                }

                case "2": {
                    String documentCode = InputUtils.inputString("Input document code: ");
                    boolean isRemoveSuccess = documentManagement.removeDocumentByDocumentCode(documentCode);
                    if (isRemoveSuccess) {
                        System.out.println("remove document successfully");
                    } else {
                        System.err.println("Not found document by document code: " + documentCode);
                    }
                    break;
                }

                case "3": {
                    documentManagement.showInformationDocuments();
                    break;
                }

                case "4": {
                    String type = inputDocumentType();
                    List<Document> resultsFind = documentManagement.findDocumentsByTypeDocument(type);
                    if (resultsFind.isEmpty()) {
                        System.err.println("don't find documents by type: " + type);
                    } else {
                        resultsFind.forEach(System.out::println);
                    }
                    break;
                }

                case "5": {
                    return;
                }

                default:
                    break;
            }
        }
    }

    private static String inputDocumentType() {
        String type = "";
        while (true) {
            type = InputUtils.inputString("Input document type (book, magazine, newspaper): ").trim();
            if ("book".equals(type) || "magazine".equals(type) || "newspaper".equals(type)) {
                break;
            } else {
                System.err.println("document type invalid, please enter again");
            }
        }
        return type;
    }

    private static Document inputDocument() {
        Document document = null;
        String type = inputDocumentType();

        String documentCode = "";
        while (true) {
            documentCode = InputUtils.inputString("Document code: ");
            if (documentManagement.isDocumentCodeExist(documentCode)) {
                System.err.println("Document code already exists, please enter again");
            } else {
                break;
            }
        }
        String publishingHouseName = InputUtils.inputString("publishing house name: ");
        String releaseNumber = InputUtils.inputString("release number: ");

        switch (type) {
            case "book":
                String authorName = InputUtils.inputString("author name: ");
                int pageNumber = InputUtils.inputNumber("page number: ");
                document = new Book(documentCode, publishingHouseName, releaseNumber, authorName, pageNumber);
                break;
            case "magazine":
                int issueNumber = InputUtils.inputNumber("issue number: ");
                int releaseMonth = InputUtils.inputNumber("release month: ");
                document = new Magazine(documentCode, publishingHouseName, releaseNumber, issueNumber,
                        releaseMonth);
                break;
            case "newspaper":
                String releaseDay = InputUtils.inputString("release day(dd/MM/yyyy): ");
                document = new Newspaper(documentCode, publishingHouseName, releaseNumber, releaseDay);
                break;
            default:
                break;
        }

        return document;
    }
}
