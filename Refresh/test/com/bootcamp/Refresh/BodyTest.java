package com.bootcamp.Refresh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyTest {
    @Test
    void shouldRefreshAllComponentsInBody() {
        SidePanel sidePanel = new SidePanel();

        BottomPanel bottomPanel = new BottomPanel();

        Image image = new Image();
        Text text = new Text();
        Contents contents = new Contents(image,text);


        Body body = new Body(sidePanel,contents,bottomPanel);
        String actual = body.refresh();
        String expected = "Refreshing Body" + "\n" + "Refreshing Side Panel";
        expected += "\n" + "Refreshing Contents" + "\n" + "Refreshing Image";
        expected += "\n" + "Refreshing Text" + "\n" + "Refreshing Bottom Panel" + "\n";
        assertEquals(expected, actual);
    }
}