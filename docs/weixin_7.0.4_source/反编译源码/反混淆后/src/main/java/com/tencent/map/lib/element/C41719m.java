package com.tencent.map.lib.element;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.p666a.C24347di;

/* renamed from: com.tencent.map.lib.element.m */
public class C41719m {
    /* renamed from: a */
    protected String f17141a;
    /* renamed from: b */
    private GeoPoint f17142b;
    /* renamed from: c */
    private Bitmap[] f17143c;
    /* renamed from: d */
    private float f17144d = 0.5f;
    /* renamed from: e */
    private float f17145e = 0.5f;
    /* renamed from: f */
    private float f17146f = 1.0f;
    /* renamed from: g */
    private boolean f17147g = false;
    /* renamed from: h */
    private int f17148h;
    /* renamed from: i */
    private boolean f17149i;
    /* renamed from: j */
    private int f17150j;
    /* renamed from: k */
    private int f17151k;
    /* renamed from: l */
    private int f17152l;
    /* renamed from: m */
    private int f17153m = C24347di.f4623c;
    /* renamed from: n */
    private boolean f17154n;
    /* renamed from: o */
    private boolean f17155o = false;
    /* renamed from: p */
    private boolean f17156p;
    /* renamed from: q */
    private boolean f17157q = true;

    /* renamed from: a */
    public C41719m mo67435a(GeoPoint geoPoint) {
        this.f17142b = geoPoint;
        return this;
    }

    /* renamed from: a */
    public GeoPoint mo67430a() {
        return this.f17142b;
    }

    /* renamed from: a */
    public C41719m mo67436a(String str, Bitmap... bitmapArr) {
        this.f17141a = str;
        this.f17143c = bitmapArr;
        return this;
    }

    /* renamed from: a */
    public C41719m mo67434a(int i, int i2) {
        this.f17150j = i;
        this.f17151k = i2;
        return this;
    }

    /* renamed from: a */
    public C41719m mo67437a(boolean z) {
        this.f17155o = z;
        return this;
    }

    /* renamed from: b */
    public Bitmap[] mo67440b() {
        return this.f17143c;
    }

    /* renamed from: c */
    public String mo67443c() {
        return this.f17141a;
    }

    /* renamed from: b */
    public C41719m mo67439b(boolean z) {
        this.f17147g = z;
        return this;
    }

    /* renamed from: d */
    public boolean mo67445d() {
        return this.f17147g;
    }

    /* renamed from: a */
    public C41719m mo67431a(float f) {
        this.f17146f = f;
        return this;
    }

    /* renamed from: e */
    public float mo67446e() {
        return this.f17146f;
    }

    /* renamed from: a */
    public C41719m mo67432a(float f, float f2) {
        this.f17144d = f;
        this.f17145e = f2;
        return this;
    }

    /* renamed from: f */
    public float mo67448f() {
        return this.f17144d;
    }

    /* renamed from: g */
    public float mo67449g() {
        return this.f17145e;
    }

    /* renamed from: a */
    public C41719m mo67433a(int i) {
        this.f17148h = i;
        return this;
    }

    /* renamed from: h */
    public int mo67450h() {
        return this.f17148h;
    }

    /* renamed from: i */
    public boolean mo67451i() {
        return this.f17149i;
    }

    /* renamed from: c */
    public C41719m mo67442c(boolean z) {
        this.f17156p = z;
        return this;
    }

    /* renamed from: j */
    public boolean mo67452j() {
        return this.f17156p;
    }

    /* renamed from: k */
    public int mo67453k() {
        return this.f17150j;
    }

    /* renamed from: l */
    public int mo67454l() {
        return this.f17151k;
    }

    /* renamed from: b */
    public C41719m mo67438b(int i) {
        this.f17152l = i;
        return this;
    }

    /* renamed from: m */
    public int mo67455m() {
        return this.f17152l;
    }

    /* renamed from: c */
    public C41719m mo67441c(int i) {
        this.f17153m = i;
        return this;
    }

    /* renamed from: n */
    public int mo67456n() {
        return this.f17153m;
    }

    /* renamed from: d */
    public C41719m mo67444d(boolean z) {
        this.f17154n = z;
        return this;
    }

    /* renamed from: o */
    public boolean mo67457o() {
        return this.f17154n;
    }

    /* renamed from: p */
    public boolean mo67458p() {
        return this.f17155o;
    }

    /* renamed from: e */
    public C41719m mo67447e(boolean z) {
        this.f17157q = z;
        return this;
    }

    /* renamed from: q */
    public boolean mo67459q() {
        return this.f17157q;
    }
}
