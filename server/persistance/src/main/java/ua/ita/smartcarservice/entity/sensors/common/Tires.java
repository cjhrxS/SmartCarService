package ua.ita.smartcarservice.entity.sensors.common;

public enum Tires {
    FRONT_LEFT("frontLeft"),
    FRONT_RIGHT("frontRight"),
    BACK_LEFT("backLeft"),
    BACK_RIGHT("backRight");

    private String tire;

    private Tires(String tire) {
        this.tire = tire;
    }

    public String toString() {
        return tire;
    }
}
