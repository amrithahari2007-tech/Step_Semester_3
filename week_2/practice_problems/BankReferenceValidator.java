public class BankReferenceValidator {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed.toUpperCase();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            System.out.println("Invalid: wrong length");
            return "Invalid: wrong length";
        }

        String bankCode = reference.substring(0, 3);
        String body = reference.substring(3);

        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                System.out.println("Invalid: non-digit body");
                return "Invalid: non-digit body";
            }
        }

        String dateStr = body.substring(0, 6); // ddMMyy
        String seq = body.substring(6);        // 5 digits
        String dd = dateStr.substring(0, 2);
        String MM = dateStr.substring(2, 4);
        String yy = dateStr.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
                .append(dd).append("/").append(MM).append("/").append(yy)
                .append(" | SEQ: ").append(seq);

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        validateAndFormat(ref1);

        String ref2 = normalizeReference("12F03022600042");
        validateAndFormat(ref2);
    }
}