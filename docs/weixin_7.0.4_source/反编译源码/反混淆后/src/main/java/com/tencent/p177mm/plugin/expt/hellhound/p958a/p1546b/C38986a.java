package com.tencent.p177mm.plugin.expt.hellhound.p958a.p1546b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.C11759b;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.a */
public final class C38986a {
    private static C38986a lMU;
    /* renamed from: mq */
    private List<Object> f16170mq;

    public static C38986a bqG() {
        AppMethodBeat.m2504i(73460);
        if (lMU == null) {
            synchronized (C38986a.class) {
                try {
                    if (lMU == null) {
                        lMU = new C38986a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(73460);
                    }
                }
            }
        }
        C38986a c38986a = lMU;
        AppMethodBeat.m2505o(73460);
        return c38986a;
    }

    private C38986a() {
        AppMethodBeat.m2504i(73461);
        if (C11759b.bqo()) {
            C20599b.m31826v("mmkv_key_session_page", new byte[0]);
        }
        this.f16170mq = new ArrayList();
        AppMethodBeat.m2505o(73461);
    }
}
