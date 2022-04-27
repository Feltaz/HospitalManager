package tn.enicar.groupb.hospitalmanager.AppUser;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum AppUserRole {
    ADMIN("admin"), DOCTOR("doctor"), EMPLOYEE("employee"), PATIENT("patient");

    private String role;

    AppUserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    @Override
    public String toString() {
        return role;
    }
    //fromText()
    @JsonCreator
    public static AppUserRole fromText(String text) {
        for (AppUserRole b : AppUserRole.values()) {
            if (b.role.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
