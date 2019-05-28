package com.tencent.p177mm.p224d.p225a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.d.a.b */
final class C37664b extends C26066v {
    private C37664b(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* renamed from: f */
    static C26066v m63693f(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113797);
        C37664b c37664b = new C37664b(str, bArr);
        AppMethodBeat.m2505o(113797);
        return c37664b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Cp */
    public final C9254d mo43933Cp() {
        AppMethodBeat.m2504i(113798);
        Looper.prepare();
        C32481h c32481h = new C32481h(Looper.myLooper());
        AppMethodBeat.m2505o(113798);
        return c32481h;
    }
}
