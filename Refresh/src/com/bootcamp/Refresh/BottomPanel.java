package com.bootcamp.Refresh;

public class BottomPanel implements Refreshable{
    @Override
    public String refresh() {
        return "Refreshing Bottom Panel" + "\n";
    }
}
