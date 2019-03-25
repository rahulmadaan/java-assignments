package com.bootcamp.Refresh;


class Contents implements Refreshable {

    private Image image;
    private Text text;

    public Contents(Image image, Text text) {
        this.image = image;
        this.text = text;
    }

    @Override
    public String refresh() {
        StringBuilder refreshMsg = new StringBuilder();
        refreshMsg.append("Refreshing Contents" + "\n");
        refreshMsg.append(this.image.refresh());
        refreshMsg.append(this.text.refresh());
        return refreshMsg.toString();
    }
}
