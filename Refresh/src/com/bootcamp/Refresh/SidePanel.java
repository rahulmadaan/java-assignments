package com.bootcamp.Refresh;

class SidePanel implements Refreshable {
    @Override
    public String refresh() {
        return "Refreshing Side Panel" + "\n";
    }
}
