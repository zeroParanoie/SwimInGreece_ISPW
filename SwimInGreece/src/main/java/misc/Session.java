package misc;

public class Session {
    private boolean isOrganiser;
    private String sessionFirstPage;

    public Session() {}

    public void setOrganiser(boolean organiser) {
        isOrganiser = organiser;
    }

    public boolean isOrganiser() {
        return isOrganiser;
    }
}
