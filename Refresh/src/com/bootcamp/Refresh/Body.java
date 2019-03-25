package com.bootcamp.Refresh;

class Body implements Refreshable {

    private SidePanel sidePanel;
    private Contents contents;
    private BottomPanel bottomPanel;

    Body(SidePanel sidePanel, Contents contents, BottomPanel bottomPanel) {
        this.sidePanel = sidePanel;
        this.contents = contents;
        this.bottomPanel = bottomPanel;
    }

    @Override
    public String refresh() {
        StringBuilder refreshMsg = new StringBuilder();
        refreshMsg.append("Refreshing Body" + "\n");
        refreshMsg.append(sidePanel.refresh());
        refreshMsg.append(contents.refresh());
        refreshMsg.append(bottomPanel.refresh());
        return refreshMsg.toString();
    }
}
