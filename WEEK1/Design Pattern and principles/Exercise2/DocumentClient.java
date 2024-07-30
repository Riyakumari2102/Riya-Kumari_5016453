public class DocumentClient {
    public static void main(String[] args) {
        DocumentFactory factory = new WordDocumentFactory();
        Document document = factory.createDocument();
        document.open();
        document.save();
        document.close();
    }
}
