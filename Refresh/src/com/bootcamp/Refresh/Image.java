package com.bootcamp.Refresh;

public class Image implements Refreshable {
    @Override
    public String refresh() {
        return "Refreshing Image" + "\n";
    }
}
