package com.project.model;

import java.io.Serializable;

public class ChangePassword implements Serializable {

    private String lastPassword;
    private String newPassword;

    public ChangePassword() {

    }

    public ChangePassword(String lastPassword, String newPassword) {
        this.lastPassword = lastPassword;
        this.newPassword = newPassword;
    }

    public String getLastPassword() {
        return lastPassword;
    }

    public void setLastPassword(String lastPassword) {
        this.lastPassword = lastPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "ChangePassword{" + "lastPassword=" + lastPassword + ", newPassword=" + newPassword + '}';
    }
}