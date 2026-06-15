package com.payload.api;

import com.stub.bw;

public class Inventory {
    public static Item[] getMyItems() {
        Item[] items = new Item[bw.V.c()];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item((bw) bw.V.a(i));
        }
        return items;
    }
}
