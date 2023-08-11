package com.example.expandcollapsetoolbar;

public class User {
    private int resourceId;
    private String name;
    private String address;

    public User(int resourceId, String name, String address) {
        this.resourceId = resourceId;
        this.name = name;
        this.address = address;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
