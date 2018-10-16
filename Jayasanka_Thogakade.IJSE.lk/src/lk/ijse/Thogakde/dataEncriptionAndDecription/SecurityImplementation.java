package lk.ijse.Thogakde.dataEncriptionAndDecription;

import java.util.ArrayList;


public class SecurityImplementation {

    public static String implementationEncript(String data) {
        Security security = new Security();
        ArrayList<String> PasswordEncript = security.PasswordEncript(data);
        String encriptedData = "";
        for (String PasswordEncript1 : PasswordEncript) {
            encriptedData += PasswordEncript1;
        }
        return encriptedData;
    }

    public static String implementationDecript(String data) {
        Security security = new Security();
        ArrayList<String> PasswordDecript = security.PasswordDecript(data);
        String decriptData = "";
        for (String PasswordDecript1 : PasswordDecript) {
            decriptData += PasswordDecript1;
        }
        return decriptData;
    }

}
