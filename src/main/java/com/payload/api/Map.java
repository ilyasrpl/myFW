package com.payload.api;

import com.stub.cn;
import com.stub.fa;

public class Map {
    public static int test() {
        return cn.j.c();
    }

    public static Character[] getAllCharacters() {
        int total = cn.j.c();
        Character[] output = new Character[total];
        for (int i = 0; i < total; i++) {
            output[i] = new Character((fa) cn.j.a(i));
        }
        return output;
    }
}