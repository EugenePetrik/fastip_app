package enums;

public enum Platform {
    ANDROID("android"),
    IOS("ios");

    private String value;

    Platform(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
