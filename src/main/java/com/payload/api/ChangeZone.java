package com.payload.api;

import com.stub.bt;
import com.stub.ce;
import com.stub.cf;
import com.stub.cn;
import com.stub.cs;
import com.stub.ep;
import com.stub.et;
import com.stub.fu;

public class ChangeZone {
    public static void changeZone(ep var0) {
        try {
            cs.o = new int[cs.v = var0.b().readByte()];
            String[] var1 = new String[cs.v];

            int var2;
            for (var2 = 0; var2 < cs.v; ++var2) {
                cs.o[var2] = var0.b().readByte();
                byte var3;
                if ((var3 = var0.b().readByte()) != 0) {
                    cs.o[var2] = var3;
                }
            }

            for (var2 = 0; var2 < cs.v; ++var2) {
                var1[var2] = var0.b().readUTF();
            }

            fu.a("Loading...", new bt("Tutup", -1));
            et var6 = new et("ReadMessenge menu4");

            for (int var7 = 0; var7 < cs.v; ++var7) {
                bt var5;
                (var5 = new bt(var1[var7], 13, var7, cn.b())).a((ce) cf.s, 1, cs.o[var7]);
                var6.a(var5);
            }

            fu.p.a(var6, 2, "Zona", false, (et) null);
            fu.j();
        } catch (Exception var4) {
        }
    }
}
