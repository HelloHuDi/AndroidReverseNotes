package com.tencent.p177mm.vending.p642h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.vending.h.h */
public final class C7369h extends C5703d {
    /* renamed from: b */
    Looper f2008b;
    /* renamed from: c */
    public String f2009c;
    public C5702a zYv;

    private C7369h(Looper looper, C5702a c5702a, String str) {
        this.f2008b = looper;
        this.zYv = c5702a;
        this.f2009c = str;
    }

    public C7369h(Handler handler, String str) {
        this(new C7366b(handler), str);
        AppMethodBeat.m2504i(126118);
        AppMethodBeat.m2505o(126118);
    }

    public C7369h(C5702a c5702a, String str) {
        this(c5702a.getLooper(), c5702a, str);
        AppMethodBeat.m2504i(126119);
        AppMethodBeat.m2505o(126119);
    }

    public C7369h(Looper looper, String str) {
        this(new Handler(looper), str);
        AppMethodBeat.m2504i(126120);
        AppMethodBeat.m2505o(126120);
    }

    public final String getType() {
        return this.f2009c;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(126121);
        this.zYv.mo11592eD();
        AppMethodBeat.m2505o(126121);
    }

    /* renamed from: o */
    public final void mo10061o(Runnable runnable) {
        AppMethodBeat.m2504i(126122);
        this.zYv.mo11593f(runnable);
        AppMethodBeat.m2505o(126122);
    }

    /* renamed from: l */
    public final void mo10060l(Runnable runnable, long j) {
        AppMethodBeat.m2504i(126123);
        if (j >= 0) {
            this.zYv.mo11591d(runnable, j);
            AppMethodBeat.m2505o(126123);
            return;
        }
        this.zYv.mo11593f(runnable);
        AppMethodBeat.m2505o(126123);
    }
}
