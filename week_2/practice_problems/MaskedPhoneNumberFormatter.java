public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.chars().allMatch(Character::isDigit)) {
            System.out.println("Invalid phone number");
            return "Invalid phone number";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(phone.substring(6));
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        maskPhoneNumber("9876543210");
        maskPhoneNumber("98765");
    }
}