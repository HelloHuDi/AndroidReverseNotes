package com.tencent.p177mm.sandbox.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9483ty;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.sandbox.updater.h */
public final class C44211h extends C4884c<C9483ty> {
    public C44211h() {
        AppMethodBeat.m2504i(28910);
        this.xxI = C9483ty.class.getName().hashCode();
        AppMethodBeat.m2505o(28910);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(28911);
        C9483ty c9483ty = (C9483ty) c4883b;
        if (c9483ty instanceof C9483ty) {
            Updater e = Updater.m79774e(c9483ty.cQc.context, null);
            if (e == null) {
                AppMethodBeat.m2505o(28911);
            } else {
                e.mo69847aA(c9483ty.cQc.type, true);
                AppMethodBeat.m2505o(28911);
            }
        } else {
            AppMethodBeat.m2505o(28911);
        }
        return false;
    }
}
