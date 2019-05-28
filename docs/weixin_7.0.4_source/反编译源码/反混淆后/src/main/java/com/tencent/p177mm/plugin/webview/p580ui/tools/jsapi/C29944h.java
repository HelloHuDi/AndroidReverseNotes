package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.modelcache.C14526r.C4557a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.h */
public final class C29944h {
    private static final SparseArray<C23018g> uIE = new SparseArray();
    private static volatile C23018g uIF = null;

    private C29944h() {
    }

    static {
        AppMethodBeat.m2504i(9809);
        AppMethodBeat.m2505o(9809);
    }

    @Deprecated
    public static C23018g dcN() {
        AppMethodBeat.m2504i(9806);
        if (uIF == null) {
            uIF = new C23018g(0);
        }
        C23018g c23018g = uIF;
        AppMethodBeat.m2505o(9806);
        return c23018g;
    }

    /* renamed from: JR */
    public static C23018g m47401JR(int i) {
        C23018g c23018g;
        AppMethodBeat.m2504i(9807);
        synchronized (C29944h.class) {
            try {
                if (uIE.get(i) == null) {
                    uIE.put(i, new C23018g(i));
                }
                c23018g = (C23018g) uIE.get(i);
                uIF = c23018g;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(9807);
            }
        }
        return c23018g;
    }

    public static void detach() {
        AppMethodBeat.m2504i(9808);
        C4990ab.m7416i("MicroMsg.MsgHandlerHolder", "detach");
        synchronized (C29944h.class) {
            int i = 0;
            while (i < uIE.size()) {
                try {
                    C23018g c23018g = (C23018g) uIE.valueAt(i);
                    int keyAt = uIE.keyAt(i);
                    if (c23018g != null) {
                        C4557a.uor.mo26756IP(keyAt);
                    }
                    i++;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(9808);
                    }
                }
            }
            uIE.clear();
        }
        if (uIF != null) {
            C4557a.uor.mo26756IP(0);
            uIF = null;
        }
        AppMethodBeat.m2505o(9808);
    }
}
