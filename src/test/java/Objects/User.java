package Objects;

import java.util.Random;

public class User {
    private static String email;
    private static String password;
    private static String ssn;

    public User() {
        email = getSaltString(8)+"@test.com";
        password = getSaltString(8);
        ssn = getSaltString(6)+"00A99A000Z";
    }

    protected String getSaltString(int str_len) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < str_len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSsn() { return ssn; }
}