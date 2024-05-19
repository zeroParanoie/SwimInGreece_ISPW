package engClasses.exceptions;

public class LoginFromDBException extends Exception {
    private int code;

    public LoginFromDBException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
