package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static final d a = new d(a.NO_NETWORK, 0);
    public static final d b = new d(a.WIFI, 0);
    public final int c;
    public final a d;

    public enum a {
        NO_NETWORK,
        WIFI,
        MOBILE;

        static {
            AppMethodBeat.o(67634);
        }
    }

    static {
        AppMethodBeat.i(67631);
        AppMethodBeat.o(67631);
    }

    public d(a aVar, int i) {
        this.d = aVar;
        this.c = i;
    }
}
