package com.payload.api;

import com.stub.bt;
import com.stub.et;

public class ListMenu extends et {

    public ListMenu add(String name, int action) {
        a(new bt(name, action));
        return this;
    }
}
