package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cr */
public class C5844cr {
    /* renamed from: a */
    private C24343db f1473a = new C24343db(39.984253d, 116.307439d);
    /* renamed from: b */
    private double f1474b = 1.0d;
    /* renamed from: c */
    private float f1475c = 1.0f;
    /* renamed from: d */
    private int f1476d = WebView.NIGHT_MODE_COLOR;
    /* renamed from: e */
    private int f1477e = 0;
    /* renamed from: f */
    private int f1478f = 0;
    /* renamed from: g */
    private boolean f1479g = true;
    /* renamed from: h */
    private int f1480h = C24347di.f4623c;

    public C5844cr() {
        AppMethodBeat.m2504i(100975);
        AppMethodBeat.m2505o(100975);
    }

    /* renamed from: a */
    public C5844cr mo12355a(C24343db c24343db) {
        this.f1473a = c24343db;
        return this;
    }

    /* renamed from: a */
    public C5844cr mo12352a(double d) {
        this.f1474b = d;
        return this;
    }

    /* renamed from: a */
    public C5844cr mo12353a(float f) {
        if (f < 0.0f) {
            this.f1475c = 1.0f;
        } else {
            this.f1475c = f;
        }
        return this;
    }

    /* renamed from: a */
    public C5844cr mo12354a(int i) {
        this.f1476d = i;
        return this;
    }

    /* renamed from: b */
    public C5844cr mo12359b(int i) {
        this.f1477e = i;
        return this;
    }

    /* renamed from: c */
    public C5844cr mo12361c(int i) {
        this.f1478f = i;
        return this;
    }

    /* renamed from: a */
    public C5844cr mo12356a(boolean z) {
        this.f1479g = z;
        return this;
    }

    /* renamed from: a */
    public C24343db mo12357a() {
        return this.f1473a;
    }

    /* renamed from: b */
    public double mo12358b() {
        return this.f1474b;
    }

    /* renamed from: c */
    public float mo12360c() {
        return this.f1475c;
    }

    /* renamed from: d */
    public int mo12362d() {
        return this.f1476d;
    }

    /* renamed from: e */
    public int mo12364e() {
        return this.f1477e;
    }

    /* renamed from: f */
    public int mo12365f() {
        return this.f1478f;
    }

    /* renamed from: g */
    public boolean mo12366g() {
        return this.f1479g;
    }

    /* renamed from: d */
    public C5844cr mo12363d(int i) {
        if (i >= C24347di.f4621a && i <= C24347di.f4623c) {
            this.f1480h = i;
        }
        return this;
    }

    /* renamed from: h */
    public int mo12367h() {
        return this.f1480h;
    }
}
