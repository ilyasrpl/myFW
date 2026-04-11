package com.payload.api;

import com.stub.fu;

public class Notification {
    public static void log(String msg) {
        fu.b(msg);
    }

    public static void alert(String msg) {
        fu.a(msg);
    }

    public static void show(String msg) {
        fu.c(msg);
    }

    public static void bigNotif(String msg, String title) {
        fu.b(msg, title);
    }
}
