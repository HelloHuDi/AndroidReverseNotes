package com.tencent.p177mm.vending.p642h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.h.b */
public final class C7366b implements C5702a {
    /* renamed from: a */
    public Handler f2007a;

    public C7366b(Handler handler) {
        this.f2007a = handler;
    }

    /* renamed from: f */
    public final void mo11593f(Runnable runnable) {
        AppMethodBeat.m2504i(126114);
        this.f2007a.post(runnable);
        AppMethodBeat.m2505o(126114);
    }

    /* renamed from: d */
    public final void mo11591d(Runnable runnable, long j) {
        AppMethodBeat.m2504i(126115);
        this.f2007a.postDelayed(runnable, j);
        AppMethodBeat.m2505o(126115);
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(126116);
        Looper looper = this.f2007a.getLooper();
        AppMethodBeat.m2505o(126116);
        return looper;
    }

    /* renamed from: eD */
    public final void mo11592eD() {
        AppMethodBeat.m2504i(126117);
        this.f2007a.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(126117);
    }
}
