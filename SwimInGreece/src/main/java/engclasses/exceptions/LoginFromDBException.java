package engclasses.exceptions;

public class LoginFromDBException extends Exception {
    private final int code;

    public LoginFromDBException(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
