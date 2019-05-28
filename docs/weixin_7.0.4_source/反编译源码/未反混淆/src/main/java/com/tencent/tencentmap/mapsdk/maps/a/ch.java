package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class ch {
    private ThreadPoolExecutor a;

    static class a {
        private static final ch a = new ch();

        static {
            AppMethodBeat.i(98635);
            AppMethodBeat.o(98635);
        }
    }

    /* synthetic */ ch(byte b) {
        this();
    }

    public static ch a() {
        AppMethodBeat.i(98637);
        ch a = a.a;
        AppMethodBeat.o(98637);
        return a;
    }

    public final ThreadPoolExecutor b() {
        return this.a;
    }

    private ch() {
        AppMethodBeat.i(98636);
        this.a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new bv("halley_" + bt.c() + "_" + "BusinessTaskPool"));
        AppMethodBeat.o(98636);
    }
}
