package com.tencent.p177mm.chatroom.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.chatroom.C26011b;
import com.tencent.p177mm.model.C7485q;

/* renamed from: com.tencent.mm.chatroom.plugin.a */
public final class C32443a extends C7485q {
    private static C32443a ehI;

    public C32443a() {
        super(C26011b.class);
    }

    /* renamed from: JA */
    public static synchronized C32443a m53115JA() {
        C32443a c32443a;
        synchronized (C32443a.class) {
            AppMethodBeat.m2504i(103960);
            if (ehI == null) {
                ehI = new C32443a();
            }
            c32443a = ehI;
            AppMethodBeat.m2505o(103960);
        }
        return c32443a;
    }
}
