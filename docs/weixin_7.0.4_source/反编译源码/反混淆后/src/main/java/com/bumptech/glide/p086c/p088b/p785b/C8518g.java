package com.bumptech.glide.p086c.p088b.p785b;

import android.annotation.SuppressLint;
import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p785b.C25414h.C17519a;
import com.bumptech.glide.p095h.C0780f;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.c.b.b.g */
public final class C8518g extends C0780f<C0779h, C17526u<?>> implements C25414h {
    private C17519a aDi;

    /* renamed from: W */
    public final /* synthetic */ int mo2245W(Object obj) {
        AppMethodBeat.m2504i(91989);
        C17526u c17526u = (C17526u) obj;
        int W;
        if (c17526u == null) {
            W = super.mo2245W(null);
            AppMethodBeat.m2505o(91989);
            return W;
        }
        W = c17526u.getSize();
        AppMethodBeat.m2505o(91989);
        return W;
    }

    /* renamed from: a */
    public final /* synthetic */ C17526u mo18620a(C0779h c0779h, C17526u c17526u) {
        AppMethodBeat.m2504i(91990);
        C17526u c17526u2 = (C17526u) super.put(c0779h, c17526u);
        AppMethodBeat.m2505o(91990);
        return c17526u2;
    }

    /* renamed from: b */
    public final /* synthetic */ C17526u mo18622b(C0779h c0779h) {
        AppMethodBeat.m2504i(91991);
        C17526u c17526u = (C17526u) super.remove(c0779h);
        AppMethodBeat.m2505o(91991);
        return c17526u;
    }

    /* renamed from: g */
    public final /* synthetic */ void mo2246g(Object obj, Object obj2) {
        AppMethodBeat.m2504i(91988);
        C17526u c17526u = (C17526u) obj2;
        if (!(this.aDi == null || c17526u == null)) {
            this.aDi.mo31950c(c17526u);
        }
        AppMethodBeat.m2505o(91988);
    }

    public C8518g(long j) {
        super(j);
    }

    /* renamed from: a */
    public final void mo18621a(C17519a c17519a) {
        this.aDi = c17519a;
    }

    @SuppressLint({"InlinedApi"})
    public final void trimMemory(int i) {
        AppMethodBeat.m2504i(91987);
        if (i >= 40) {
            mo2248mO();
            AppMethodBeat.m2505o(91987);
            return;
        }
        if (i >= 20 || i == 15) {
            mo2250p(mo2249ol() / 2);
        }
        AppMethodBeat.m2505o(91987);
    }
}
