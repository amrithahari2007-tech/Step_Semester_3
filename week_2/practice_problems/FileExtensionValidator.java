public class FileExtensionValidator {

    static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            System.out.println("Rejected — invalid file type");
            return "Rejected";
        }
        String ext = filename.substring(dotIndex + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            System.out.println("Accepted");
            return "Accepted";
        } else {
            System.out.println("Rejected — invalid file type");
            return "Rejected";
        }
    }

    public static void main(String[] args) {
        validateFileExtension("Assignment1.PDF");
        validateFileExtension("notes.txt");
    }
}