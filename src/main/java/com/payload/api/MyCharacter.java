package com.payload.api;

import com.stub.cn;
import com.stub.cs;
import com.stub.fu;
import com.stub.q;

public class MyCharacter {
    public static boolean isWaitingForResponse = false;

    public static long getGold() {
        return cn.g.bC;
    }

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
        if (mapWidth >= x && mapHeight >= y) {
            cn.g.cN = cn.b().a(x, y, getLocationX(), getLocationY(), 100);
        }
    }

    public static void useSkill(int skillSlot) {
        cn.g.a(skillSlot, false);
    }

    public static void talkTo(byte npcId) {
        q.a().a(npcId);
    }

    public static void talkTo(short npcId, byte arg1, byte arg2) {
        q.a().b(npcId, arg1, arg2);
    }

    public static void changeZone(byte zone) {
        zone = (byte) (zone - 1);
        talkTo((byte) -46);
        q.a().d(zone);
    }

    public static void revive() {
        q.a().b((byte) 1);
    }
}
