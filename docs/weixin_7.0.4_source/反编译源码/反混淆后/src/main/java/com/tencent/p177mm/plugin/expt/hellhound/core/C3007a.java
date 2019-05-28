package com.tencent.p177mm.plugin.expt.hellhound.core;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.C11761c;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a.C38989b;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C20600d;
import com.tencent.p177mm.plugin.expt.hellhound.core.stack.C27896f;
import com.tencent.p177mm.plugin.expt.hellhound.p958a.p1546b.C38986a;

@TargetApi(14)
/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.a */
public class C3007a {
    private static volatile C3007a lMj;
    public C38987c lMk;

    public static C3007a bqm() {
        AppMethodBeat.m2504i(73342);
        if (lMj == null) {
            synchronized (C3007a.class) {
                try {
                    if (lMj == null) {
                        lMj = new C3007a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73342);
                    }
                }
            }
        }
        C3007a c3007a = lMj;
        AppMethodBeat.m2505o(73342);
        return c3007a;
    }

    private C3007a() {
        AppMethodBeat.m2504i(73343);
        if (C3007a.bqn()) {
            this.lMk = new C11761c();
            C20600d.bqu();
            C38989b.bqC();
            C38986a.bqG();
            AppMethodBeat.m2505o(73343);
            return;
        }
        AppMethodBeat.m2505o(73343);
    }

    /* renamed from: a */
    public static void m5295a(C27896f c27896f) {
        AppMethodBeat.m2504i(73344);
        C20600d.bqu().lMw.lMx.lMA = c27896f;
        AppMethodBeat.m2505o(73344);
    }

    public static boolean bqn() {
        return VERSION.SDK_INT >= 14;
    }
}
