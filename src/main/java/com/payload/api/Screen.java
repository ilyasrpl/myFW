package com.payload.api;

import com.stub.fu;

public class Screen {
    public static int kondisi1() {
        if (fu.q())
            return 1;
        return 0;
    }

    public static int kondisi2() {
        if (fu.t != null)
            return 1;
        return 0;
    }

    public static int kondisi3() {
        if (fu.s != null)
            return 1;
        if (fu.p.a)
            return 2;
        if (fu.d.b)
            return 3;
        return 0;
    }
}
