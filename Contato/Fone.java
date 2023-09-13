package Contato;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Fone {
    private String id;
    private String number;

    public Fone() {
        this("", "");
    }

    public Fone(String id, String number) {
            this.id = id;
            this.number = number;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public boolean isValid(String number) {
        Pattern pattern = Pattern.compile("^[0-9().]+$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public String toString() {
        return id + ":" + number;
    }
}

