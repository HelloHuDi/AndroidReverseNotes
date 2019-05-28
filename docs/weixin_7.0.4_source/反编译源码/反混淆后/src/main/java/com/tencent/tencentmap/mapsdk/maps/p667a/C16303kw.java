package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.kw */
public final class C16303kw<T extends C31074kv> {
    /* renamed from: a */
    private final C36530ku<T> f3476a;
    /* renamed from: b */
    private final C36530ku<T> f3477b;
    /* renamed from: c */
    private Float f3478c = null;
    /* renamed from: d */
    private final Float f3479d;

    public C16303kw(List<T> list, List<T> list2) {
        AppMethodBeat.m2504i(100270);
        this.f3476a = new C36530ku(list);
        this.f3477b = new C36530ku(list2);
        this.f3479d = Float.valueOf(this.f3476a.mo29553b().mo29565a().mo29575h() + this.f3477b.mo29553b().mo29565a().mo29575h());
        AppMethodBeat.m2505o(100270);
    }

    /* renamed from: a */
    public final C36530ku<T> mo29562a() {
        return this.f3476a;
    }

    /* renamed from: b */
    public final C36530ku<T> mo29563b() {
        return this.f3477b;
    }

    /* renamed from: c */
    public final float mo29564c() {
        AppMethodBeat.m2504i(100271);
        if (this.f3478c == null) {
            this.f3478c = Float.valueOf(this.f3476a.mo29553b().mo29565a().mo29574g() + this.f3477b.mo29553b().mo29565a().mo29574g());
        }
        float floatValue = this.f3478c.floatValue();
        AppMethodBeat.m2505o(100271);
        return floatValue;
    }
}
