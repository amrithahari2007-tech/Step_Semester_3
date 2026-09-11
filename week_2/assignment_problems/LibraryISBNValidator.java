public class LibraryISBNValidator {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return pubCode + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            System.out.println("Invalid: wrong length");
            return "Invalid: wrong length";
        }

        String pubCode = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < pubCode.length(); i++) {
            if (!Character.isLetter(pubCode.charAt(i))) {
                System.out.println("Invalid: publisher code must be 3 letters");
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return "Invalid: non-digit body";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalog);

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String code1 = normalizeCode(" pen2026004251 ");
        validateAndFormat(code1);

        String code2 = normalizeCode("12N2026004251");
        validateAndFormat(code2);
    }
}