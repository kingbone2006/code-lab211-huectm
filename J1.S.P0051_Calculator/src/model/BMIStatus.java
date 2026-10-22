package model;

public enum BMIStatus {
    UNDER_STANDARD("UNDER-STANDARD"),
    STANDARD("STANDARD"),
    OVERWEIGHT("OVERWEIGHT"),
    FAT("FAT - should lose weight"),
    VERY_FAT("VERY FAT - should lose weight immediately");

    private final String message;

    BMIStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
