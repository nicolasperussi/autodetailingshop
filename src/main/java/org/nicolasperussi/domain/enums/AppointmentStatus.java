package org.nicolasperussi.domain.enums;

public enum AppointmentStatus {
    CANCELED(0),
    SCHEDULED(1),
    ON_GOING(2),
    COMPLETED(3);

    private int code;

    AppointmentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AppointmentStatus valueOf(int code) {
        for (AppointmentStatus value : AppointmentStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid AppointmentStatus code");
    }
}
