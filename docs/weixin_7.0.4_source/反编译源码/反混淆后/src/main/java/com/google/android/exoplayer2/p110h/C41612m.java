package com.google.android.exoplayer2.p110h;

import android.content.Context;
import com.google.android.exoplayer2.p110h.C0867f.C0868a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.h.m */
public final class C41612m implements C0868a {
    private final C41615u<? super C0867f> bpJ;
    private final C0868a bqq;
    private final Context context;

    public C41612m(Context context, C41615u<? super C0867f> c41615u, C0868a c0868a) {
        AppMethodBeat.m2504i(95823);
        this.context = context.getApplicationContext();
        this.bpJ = c41615u;
        this.bqq = c0868a;
        AppMethodBeat.m2505o(95823);
    }

    /* renamed from: tm */
    public final /* synthetic */ C0867f mo2587tm() {
        AppMethodBeat.m2504i(95824);
        C45038l c45038l = new C45038l(this.context, this.bpJ, this.bqq.mo2587tm());
        AppMethodBeat.m2505o(95824);
        return c45038l;
    }
}
