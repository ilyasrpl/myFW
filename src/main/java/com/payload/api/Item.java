package com.payload.api;

import com.stub.bw;

public class Item {
    bw item;

    public Item(bw item) {
        this.item = item;
    }

    public String getName() {
        return item.g;
    }

    // 7 bahan upgrade, 4 dapat dipakai, 3 equip
    public int getType() {
        return item.u;
    }

    public int getColor() {
        return item.N;
    }

    public byte getUpLevel() {
        return item.z;
    }

    public int getId() {
        return item.O;
    }

}
