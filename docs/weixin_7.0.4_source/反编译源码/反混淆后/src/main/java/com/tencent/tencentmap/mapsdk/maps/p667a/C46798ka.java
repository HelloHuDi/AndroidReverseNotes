package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31058b;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ka */
public class C46798ka {
    /* renamed from: a */
    private final int f18241a;
    /* renamed from: b */
    private final int f18242b;
    /* renamed from: c */
    private final int f18243c;
    /* renamed from: d */
    private DoublePoint f18244d;
    /* renamed from: e */
    private DoublePoint f18245e;
    /* renamed from: f */
    private float f18246f = 0.0f;
    /* renamed from: g */
    private C41063ie f18247g;
    /* renamed from: h */
    private C31058b f18248h = new C410681();
    /* renamed from: i */
    private volatile boolean f18249i = false;
    /* renamed from: j */
    private boolean f18250j = true;
    /* renamed from: k */
    private Bitmap f18251k = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ka$1 */
    class C410681 implements C31058b {
        C410681() {
        }

        /* renamed from: a */
        public void mo29454a(float f, float f2) {
        }

        /* renamed from: a */
        public void mo29455a(float f, float f2, float f3, float f4) {
        }

        /* renamed from: a */
        public void mo29456a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo29453a(float f) {
            AppMethodBeat.m2504i(100190);
            C46798ka.this.f18246f = f;
            AppMethodBeat.m2505o(100190);
        }

        /* renamed from: b */
        public void mo29457b(float f) {
        }
    }

    public C46798ka(int i, int i2, int i3) {
        AppMethodBeat.m2504i(100191);
        this.f18241a = i;
        this.f18242b = i2;
        this.f18243c = i3;
        AppMethodBeat.m2505o(100191);
    }

    /* renamed from: a */
    public void mo75505a() {
        AppMethodBeat.m2504i(100192);
        if (this.f18251k != null) {
            if (this.f18247g != null) {
                this.f18247g.mo50391b();
                this.f18247g = null;
            }
            this.f18251k.recycle();
            this.f18251k = null;
        }
        AppMethodBeat.m2505o(100192);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C46798ka)) {
            return false;
        }
        C46798ka c46798ka = (C46798ka) obj;
        if (this.f18241a == c46798ka.f18241a && this.f18242b == c46798ka.f18242b && this.f18243c == c46798ka.f18243c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f18241a * 7) + (this.f18242b * 11)) + (this.f18243c * 13);
    }

    public String toString() {
        AppMethodBeat.m2504i(100193);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(this.f18241a);
        stringBuilder.append("-");
        stringBuilder.append(this.f18242b);
        stringBuilder.append("-");
        stringBuilder.append(this.f18243c);
        stringBuilder.append("-");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(100193);
        return stringBuilder2;
    }

    /* renamed from: b */
    public int mo75509b() {
        return this.f18243c;
    }

    /* renamed from: a */
    public void mo75506a(float f) {
        AppMethodBeat.m2504i(100194);
        this.f18249i = true;
        this.f18246f = f;
        this.f18247g = new C41063ie(f, 1.0f);
        this.f18247g.mo29510a(this.f18248h);
        this.f18247g.mo50388a(250);
        this.f18247g.mo29512a(null, null);
        AppMethodBeat.m2505o(100194);
    }

    /* renamed from: a */
    public void mo75507a(Bitmap bitmap) {
        AppMethodBeat.m2504i(100195);
        if (bitmap == null) {
            AppMethodBeat.m2505o(100195);
            return;
        }
        this.f18251k = bitmap;
        mo75506a(0.0f);
        AppMethodBeat.m2505o(100195);
    }

    /* renamed from: c */
    public DoublePoint mo75511c() {
        return this.f18244d;
    }

    /* renamed from: a */
    public void mo75508a(DoublePoint doublePoint) {
        this.f18244d = doublePoint;
    }

    /* renamed from: d */
    public DoublePoint mo75512d() {
        return this.f18245e;
    }

    /* renamed from: b */
    public void mo75510b(DoublePoint doublePoint) {
        this.f18245e = doublePoint;
    }
}
