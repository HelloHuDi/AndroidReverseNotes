package com.tencent.tencentmap.mapsdk.p666a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.be */
public class C5837be {
    /* renamed from: a */
    private final int f1438a;
    /* renamed from: b */
    private final int f1439b;
    /* renamed from: c */
    private final int f1440c;
    /* renamed from: d */
    private final int f1441d;
    /* renamed from: e */
    private Bitmap f1442e = null;
    /* renamed from: f */
    private C31001da f1443f;
    /* renamed from: g */
    private Options f1444g;

    public C5837be(int i, int i2, int i3, int i4) {
        this.f1438a = i;
        this.f1439b = i2;
        this.f1440c = i3;
        this.f1441d = i4;
    }

    public C5837be(int i, int i2, int i3, int i4, C31001da c31001da) {
        this.f1438a = i;
        this.f1439b = i2;
        this.f1440c = i3;
        this.f1441d = i4;
        this.f1443f = c31001da;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5837be)) {
            return false;
        }
        C5837be c5837be = (C5837be) obj;
        if (this.f1438a == c5837be.f1438a && this.f1439b == c5837be.f1439b && this.f1440c == c5837be.f1440c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f1438a * 7) + (this.f1439b * 11)) + (this.f1440c * 13);
    }

    public String toString() {
        AppMethodBeat.m2504i(100781);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append(this.f1438a);
        stringBuilder.append("-");
        stringBuilder.append(this.f1439b);
        stringBuilder.append("-");
        stringBuilder.append(this.f1440c);
        stringBuilder.append("-");
        stringBuilder.append(this.f1441d);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(100781);
        return stringBuilder2;
    }

    /* renamed from: a */
    public int mo12300a() {
        return this.f1438a;
    }

    /* renamed from: b */
    public int mo12303b() {
        return this.f1439b;
    }

    /* renamed from: c */
    public int mo12304c() {
        return this.f1440c;
    }

    /* renamed from: d */
    public int mo12305d() {
        return this.f1441d;
    }

    /* renamed from: a */
    public void mo12301a(Bitmap bitmap) {
        this.f1442e = bitmap;
    }

    /* renamed from: e */
    public C31001da mo12306e() {
        return this.f1443f;
    }

    /* renamed from: a */
    public void mo12302a(Options options) {
        this.f1444g = options;
    }

    /* renamed from: f */
    public Options mo12308f() {
        return this.f1444g;
    }
}
