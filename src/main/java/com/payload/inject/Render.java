package com.payload.inject;

import com.payload.api.DrawText;
import com.payload.api.Screen;

public class Render {
    public static void render() {
        DrawText.drawWhite(String.valueOf(Screen.kondisi1()), 5, 95);
        DrawText.drawOrange(String.valueOf(Screen.kondisi2()), 5, 105);
        DrawText.drawPurple(String.valueOf(Screen.kondisi3()), 5, 115);
    }
}
