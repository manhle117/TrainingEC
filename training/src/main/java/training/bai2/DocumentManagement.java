package training.bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentManagement {
    private List<Document> documents;

    public DocumentManagement() {
        documents = new ArrayList<>();
    }

    public boolean isDocumentCodeExist(String documentCode) {
        return documents
                .stream()
                .anyMatch(doc -> doc.getDocumentCode().equals(documentCode));
    }

    public void addDocument(Document newDocument) {
        documents.add(newDocument);
    }

    public boolean removeDocumentByDocumentCode(String documentCode) {
        if (!isDocumentCodeExist(documentCode)) {
            return false;
        }
        documents = documents
                .stream()
                .filter(doc -> !doc.getDocumentCode().equals(documentCode))
                .collect(Collectors.toList());
        return true;
    }

    public void showInformationDocuments() {
        documents.forEach(System.out::println);
    }

    public List<Document> findDocumentsByTypeDocument(String typeDocument) {
        List<Document> returnDocuments = null;

        switch (typeDocument.toLowerCase()) {
            case "book":
                returnDocuments = documents
                        .stream()
                        .filter(Book.class::isInstance)
                        .collect(Collectors.toList());
                break;
            case "magazine":
                returnDocuments = documents
                        .stream()
                        .filter(Magazine.class::isInstance)
                        .collect(Collectors.toList());
                break;
            case "newspaper":
                returnDocuments = documents
                        .stream()
                        .filter(Newspaper.class::isInstance)
                        .collect(Collectors.toList());
                break;
            default:
                break;
        }

        return returnDocuments;
    }
}
