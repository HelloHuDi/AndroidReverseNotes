package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.by */
final class C31028by implements Runnable {
    /* renamed from: a */
    private /* synthetic */ String f14063a;
    /* renamed from: b */
    private /* synthetic */ int f14064b;
    /* renamed from: c */
    private /* synthetic */ int f14065c;
    /* renamed from: d */
    private /* synthetic */ String f14066d;
    /* renamed from: e */
    private /* synthetic */ Map f14067e;
    /* renamed from: f */
    private /* synthetic */ Map f14068f;
    /* renamed from: g */
    private /* synthetic */ boolean f14069g;
    /* renamed from: h */
    private /* synthetic */ int f14070h;

    C31028by(String str, int i, int i2, String str2, Map map, Map map2, boolean z, int i3) {
        this.f14063a = str;
        this.f14064b = i;
        this.f14065c = i2;
        this.f14066d = str2;
        this.f14067e = map;
        this.f14068f = map2;
        this.f14069g = z;
        this.f14070h = i3;
    }

    public final void run() {
        AppMethodBeat.m2504i(98603);
        C31027bx.m49844b(this.f14063a, this.f14064b, this.f14065c, this.f14066d, this.f14067e, this.f14068f, this.f14069g, this.f14070h);
        AppMethodBeat.m2505o(98603);
    }
}
