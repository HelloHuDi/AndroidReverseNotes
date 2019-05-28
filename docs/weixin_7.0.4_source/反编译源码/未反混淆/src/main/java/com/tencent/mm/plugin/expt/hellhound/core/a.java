package com.tencent.mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.f;
import com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.v2.activity.c;

@TargetApi(14)
public class a {
    private static volatile a lMj;
    public c lMk;

    public static a bqm() {
        AppMethodBeat.i(73342);
        if (lMj == null) {
            synchronized (a.class) {
                try {
                    if (lMj == null) {
                        lMj = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73342);
                    }
                }
            }
        }
        a aVar = lMj;
        AppMethodBeat.o(73342);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(73343);
        if (bqn()) {
            this.lMk = new c();
            d.bqu();
            b.bqC();
            com.tencent.mm.plugin.expt.hellhound.a.b.a.bqG();
            AppMethodBeat.o(73343);
            return;
        }
        AppMethodBeat.o(73343);
    }

    public static void a(f fVar) {
        AppMethodBeat.i(73344);
        d.bqu().lMw.lMx.lMA = fVar;
        AppMethodBeat.o(73344);
    }

    public static boolean bqn() {
        return VERSION.SDK_INT >= 14;
    }
}
