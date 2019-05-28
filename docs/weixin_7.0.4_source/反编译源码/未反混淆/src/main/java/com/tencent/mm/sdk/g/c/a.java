package com.tencent.mm.sdk.g.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import junit.framework.Assert;

@Deprecated
public final class a {
    private ThreadGroup cme = new ThreadGroup("MM_FREE_THREAD_GROUP");
    private final AtomicInteger xEF = new AtomicInteger(1);

    static class a extends HandlerThread {
        a(String str, int i) {
            super(str, i);
        }

        public final void start() {
            AppMethodBeat.i(52675);
            super.start();
            AppMethodBeat.o(52675);
        }

        public final void run() {
            AppMethodBeat.i(52676);
            super.run();
            AppMethodBeat.o(52676);
        }
    }

    public a() {
        AppMethodBeat.i(52677);
        AppMethodBeat.o(52677);
    }

    public static HandlerThread em(String str, int i) {
        AppMethodBeat.i(52678);
        Assert.assertNotNull("newThread arg name is null!", str);
        a aVar = new a("mmt_h".concat(String.valueOf(str)), i);
        AppMethodBeat.o(52678);
        return aVar;
    }
}
