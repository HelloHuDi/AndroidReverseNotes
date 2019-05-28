package com.tencent.p177mm.plugin.webview.luggage;

import com.tencent.luggage.p146d.C17821n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.luggage.h */
public final class C43887h {
    private static Set<C17821n> uiT = new HashSet();

    static {
        AppMethodBeat.m2504i(6156);
        AppMethodBeat.m2505o(6156);
    }

    /* renamed from: b */
    public static void m78713b(C17821n c17821n) {
        AppMethodBeat.m2504i(6154);
        uiT.add(c17821n);
        AppMethodBeat.m2505o(6154);
    }

    /* renamed from: c */
    public static void m78714c(C17821n c17821n) {
        AppMethodBeat.m2504i(6155);
        uiT.remove(c17821n);
        AppMethodBeat.m2505o(6155);
    }

    public static Set<C17821n> cXb() {
        return uiT;
    }
}
