package com.tencent.p177mm.p217ci;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p642h.C5702a;

/* renamed from: com.tencent.mm.ci.d */
public final class C6455d implements C5702a {
    private C7306ak mHandler;

    public C6455d(C7306ak c7306ak) {
        this.mHandler = c7306ak;
    }

    /* renamed from: c */
    public static C6455d m10673c(C7306ak c7306ak) {
        AppMethodBeat.m2504i(59210);
        C6455d c6455d = new C6455d(c7306ak);
        AppMethodBeat.m2505o(59210);
        return c6455d;
    }

    /* renamed from: f */
    public final void mo11593f(Runnable runnable) {
        AppMethodBeat.m2504i(59211);
        this.mHandler.post(runnable);
        AppMethodBeat.m2505o(59211);
    }

    /* renamed from: d */
    public final void mo11591d(Runnable runnable, long j) {
        AppMethodBeat.m2504i(59212);
        this.mHandler.postDelayed(runnable, j);
        AppMethodBeat.m2505o(59212);
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(59213);
        Looper looper = this.mHandler.getLooper();
        AppMethodBeat.m2505o(59213);
        return looper;
    }

    /* renamed from: eD */
    public final void mo11592eD() {
        AppMethodBeat.m2504i(59214);
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(59214);
    }
}
