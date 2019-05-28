package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kf */
public final class C31072kf {
    /* renamed from: a */
    private final int f14306a;
    /* renamed from: b */
    private final int f14307b;
    /* renamed from: c */
    private final C5902kq f14308c;
    /* renamed from: d */
    private final C5901ko f14309d;

    public C31072kf(int i, int i2, C5901ko c5901ko, C5902kq c5902kq) {
        AppMethodBeat.m2504i(100218);
        if (c5902kq == null || c5901ko == null || i2 <= 2 || i <= 0 || i >= i2) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(100218);
            throw illegalArgumentException;
        }
        this.f14309d = c5901ko;
        this.f14306a = i2;
        this.f14307b = i;
        this.f14308c = c5902kq;
        AppMethodBeat.m2505o(100218);
    }

    /* renamed from: a */
    public final int mo50525a() {
        return this.f14306a;
    }

    /* renamed from: b */
    public final int mo50526b() {
        return this.f14307b;
    }

    /* renamed from: c */
    public final C5902kq mo50527c() {
        return this.f14308c;
    }

    /* renamed from: d */
    public final C5901ko mo50528d() {
        return this.f14309d;
    }
}
