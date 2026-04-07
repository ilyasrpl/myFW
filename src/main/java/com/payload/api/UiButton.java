package com.payload.api;

import com.stub.bt;
import com.stub.fu;

public class UiButton {
    public bt button;

    public UiButton(String s, int a) {
        this.button = new bt(s, a);
    }

    public static void openAutoFungsi() {
        fu.c.j();
    }

    public static void openKuda() {
        fu.p.a(14, 0);
    }
}
