package com.endava.androidlist;

/**
 * Created by amihaescu on 8/26/2016.
 */
public class Employee {

    private String name;
    private String position;
    private boolean lineManager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isLineManager() {
        return lineManager;
    }

    public void setLineManager(boolean lineManager) {
        this.lineManager = lineManager;
    }
}
