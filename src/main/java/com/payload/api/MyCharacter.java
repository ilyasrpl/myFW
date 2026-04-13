package com.payload.api;

import com.stub.cn;
import com.stub.cs;
import com.stub.fu;

public class MyCharacter {
    public static int getLocationX() {
        return cn.g.aY / cs.l;
    }

    public static int getLocationY() {
        return cn.g.aZ / cs.l;
    }

    public static Character getFocus() {
        if (cn.i == null) {
            return new Character();
        }
        return new Character(cn.i);
    }

    public static boolean canTalk() {
        return cn.g.y();
    }

    public static void changeFocus() {
        cn.r.f(3);
    }

    public static void moveTo(int x, int y) {
        int mapWidth = fu.q.e;
        int mapHeight = fu.q.f;
        if (mapWidth >= getLocationX() && mapHeight >= getLocationY()) {
            cn.g.cN = cn.b().a(x, y, getLocationX(), getLocationY(), 100);
        }
    }

    public static void useSkill(int skillSlot) {
        cn.g.a(skillSlot, false);
    }
}
