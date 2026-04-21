package com.payload.api;

import com.stub.bt;
import com.stub.dl;
import com.stub.et;

public class ListMenu extends et {

    public ListMenu add(String name, int action) {
        a(new bt(name, action));
        return this;
    }

    public void add(String name) {
        a(new bt(name, (dl) null));
    }

    public String getMenuLabel(int id) {
        return ((bt) a(id)).a;
    }

    public int length() {
        return c();
    }

    public void run(int id) {
        ((bt) a(id)).a();
    }
}
