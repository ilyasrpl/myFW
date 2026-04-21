package com.payload.api;

import com.stub.fu;

public class ActiveMenu {
    public static ListMenu menus = new ListMenu();

    public static boolean isOpen() {
        return fu.p != null;
    }

    public static void reset() {
        menus.d();
    }
}