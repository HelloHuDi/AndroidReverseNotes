package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kk */
final class C36526kk<T, S extends C36529kt> {
    /* renamed from: a */
    private final C46800kj<T, S> f15435a;
    /* renamed from: b */
    private final int f15436b;

    C36526kk(C46800kj<T, S> c46800kj, int i) {
        this.f15435a = c46800kj;
        this.f15436b = i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C46800kj<T, S> mo57767a() {
        return this.f15435a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo57768b() {
        return this.f15436b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final C36526kk<T, S> mo57769c() {
        AppMethodBeat.m2504i(100235);
        C36526kk c36526kk = new C36526kk(this.f15435a, this.f15436b + 1);
        AppMethodBeat.m2505o(100235);
        return c36526kk;
    }
}
