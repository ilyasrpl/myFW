package com.payload.api;

import com.stub.cn;
import com.stub.cs;

public class MyCharacter {
    public static int getLocationX() {
        return cn.g.aY / cs.l;
    }

    public static int getLocationY() {
        return cn.g.aZ / cs.l;
    }

    public static void changeFocus() {
        cn.r.f(3);
    }

    public static void moveTo(int x, int y) {
        cn.g.cN = cn.b().a(x, y, getLocationX(), getLocationY(), 100);
    }

    public static void useSkill(int skillSlot) {
        cn.g.a(skillSlot, false);
    }
}
