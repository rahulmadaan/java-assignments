package com.bootcamp.Refresh;

public class Text implements Refreshable {
    @Override
    public String refresh() {
        return "Refreshing Text" + "\n";
    }
}
