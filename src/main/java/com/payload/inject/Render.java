package com.payload.inject;

import com.payload.api.DrawText;

public class Render {
    public static void render() {
        DrawText.drawWhite("hello", 5, 95);
        DrawText.drawOrange("world", 5, 105);
        DrawText.drawPurple("!", 5, 115);
    }
}
