package com.tencent.p177mm.p612ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.chatting.ah */
public interface C23698ah {

    /* renamed from: com.tencent.mm.ui.chatting.ah$a */
    public enum C23699a {
        del,
        trans,
        fav;

        static {
            AppMethodBeat.m2505o(30959);
        }
    }

    /* renamed from: a */
    void mo27932a(C23699a c23699a);

    /* renamed from: b */
    void mo27933b(C23699a c23699a);

    void dCI();

    boolean dCJ();
}
