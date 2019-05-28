package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bz */
final class C16213bz implements Runnable {
    /* renamed from: a */
    private /* synthetic */ String f3177a;
    /* renamed from: b */
    private /* synthetic */ int f3178b;
    /* renamed from: c */
    private /* synthetic */ int f3179c;
    /* renamed from: d */
    private /* synthetic */ String f3180d;
    /* renamed from: e */
    private /* synthetic */ Map f3181e;
    /* renamed from: f */
    private /* synthetic */ Map f3182f;
    /* renamed from: g */
    private /* synthetic */ boolean f3183g;

    C16213bz(String str, int i, int i2, String str2, Map map, Map map2, boolean z) {
        this.f3177a = str;
        this.f3178b = i;
        this.f3179c = i2;
        this.f3180d = str2;
        this.f3181e = map;
        this.f3182f = map2;
        this.f3183g = z;
    }

    public final void run() {
        AppMethodBeat.m2504i(98604);
        C31027bx.m49844b(this.f3177a, this.f3178b, this.f3179c, this.f3180d, this.f3181e, this.f3182f, this.f3183g, 0);
        AppMethodBeat.m2505o(98604);
    }
}
