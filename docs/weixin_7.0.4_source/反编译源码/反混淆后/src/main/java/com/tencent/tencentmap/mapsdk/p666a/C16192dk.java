package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Typeface;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dk */
public class C16192dk {
    /* renamed from: a */
    private final List<C24343db> f3082a = new ArrayList();
    /* renamed from: b */
    private float f3083b = 1.0f;
    /* renamed from: c */
    private int f3084c = WebView.NIGHT_MODE_COLOR;
    /* renamed from: d */
    private int f3085d = C36520ic.f15406k;
    /* renamed from: e */
    private int f3086e = 0;
    /* renamed from: f */
    private boolean f3087f = true;
    /* renamed from: g */
    private boolean f3088g = false;
    /* renamed from: h */
    private String f3089h = "";
    /* renamed from: i */
    private int f3090i = WebView.NIGHT_MODE_COLOR;
    /* renamed from: j */
    private Typeface f3091j = Typeface.DEFAULT;
    /* renamed from: k */
    private int f3092k = BaseClientBuilder.API_PRIORITY_OTHER;
    /* renamed from: l */
    private int f3093l = 1;
    /* renamed from: m */
    private int f3094m = -1;
    /* renamed from: n */
    private int f3095n = C24347di.f4623c;

    public C16192dk() {
        AppMethodBeat.m2504i(101056);
        AppMethodBeat.m2505o(101056);
    }

    /* renamed from: a */
    public void mo29145a(Iterable<C24343db> iterable) {
        AppMethodBeat.m2504i(101057);
        if (this.f3082a == null) {
            AppMethodBeat.m2505o(101057);
            return;
        }
        this.f3082a.clear();
        if (iterable == null) {
            AppMethodBeat.m2505o(101057);
            return;
        }
        mo29148b((Iterable) iterable);
        AppMethodBeat.m2505o(101057);
    }

    /* renamed from: b */
    public C16192dk mo29148b(Iterable<C24343db> iterable) {
        AppMethodBeat.m2504i(101058);
        if (iterable != null) {
            for (C24343db add : iterable) {
                this.f3082a.add(add);
            }
        }
        AppMethodBeat.m2505o(101058);
        return this;
    }

    /* renamed from: a */
    public C16192dk mo29141a(float f) {
        if (f < 0.0f) {
            this.f3083b = 1.0f;
        } else {
            this.f3083b = f;
        }
        return this;
    }

    /* renamed from: a */
    public C16192dk mo29142a(int i) {
        this.f3084c = i;
        return this;
    }

    /* renamed from: b */
    public C16192dk mo29147b(int i) {
        this.f3085d = i;
        return this;
    }

    /* renamed from: c */
    public C16192dk mo29150c(int i) {
        this.f3086e = i;
        return this;
    }

    /* renamed from: a */
    public C16192dk mo29143a(boolean z) {
        this.f3087f = z;
        return this;
    }

    /* renamed from: a */
    public List<C24343db> mo29144a() {
        return this.f3082a;
    }

    /* renamed from: b */
    public float mo29146b() {
        return this.f3083b;
    }

    /* renamed from: c */
    public int mo29149c() {
        return this.f3084c;
    }

    /* renamed from: d */
    public int mo29151d() {
        return this.f3085d;
    }

    /* renamed from: e */
    public float mo29153e() {
        return (float) this.f3086e;
    }

    /* renamed from: f */
    public boolean mo29154f() {
        return this.f3087f;
    }

    /* renamed from: g */
    public String mo29155g() {
        return this.f3089h;
    }

    /* renamed from: d */
    public C16192dk mo29152d(int i) {
        if (i >= C24347di.f4621a && i <= C24347di.f4623c) {
            this.f3095n = i;
        }
        return this;
    }

    /* renamed from: h */
    public int mo29156h() {
        return this.f3095n;
    }
}
