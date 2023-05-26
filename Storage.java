package com.mirea.kt.android2023.homework2_12;

public class Storage {
    private String address;
    private String open;
    private String close;
    private String name;

    public Storage(String address, String name, String open, String close){
        this.address = address;
        this.open = open;
        this.close = close;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
