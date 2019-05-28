package com.tencent.map.lib.element;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.di;

public class m {
    protected String a;
    private GeoPoint b;
    private Bitmap[] c;
    private float d = 0.5f;
    private float e = 0.5f;
    private float f = 1.0f;
    private boolean g = false;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m = di.c;
    private boolean n;
    private boolean o = false;
    private boolean p;
    private boolean q = true;

    public m a(GeoPoint geoPoint) {
        this.b = geoPoint;
        return this;
    }

    public GeoPoint a() {
        return this.b;
    }

    public m a(String str, Bitmap... bitmapArr) {
        this.a = str;
        this.c = bitmapArr;
        return this;
    }

    public m a(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public m a(boolean z) {
        this.o = z;
        return this;
    }

    public Bitmap[] b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public m b(boolean z) {
        this.g = z;
        return this;
    }

    public boolean d() {
        return this.g;
    }

    public m a(float f) {
        this.f = f;
        return this;
    }

    public float e() {
        return this.f;
    }

    public m a(float f, float f2) {
        this.d = f;
        this.e = f2;
        return this;
    }

    public float f() {
        return this.d;
    }

    public float g() {
        return this.e;
    }

    public m a(int i) {
        this.h = i;
        return this;
    }

    public int h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public m c(boolean z) {
        this.p = z;
        return this;
    }

    public boolean j() {
        return this.p;
    }

    public int k() {
        return this.j;
    }

    public int l() {
        return this.k;
    }

    public m b(int i) {
        this.l = i;
        return this;
    }

    public int m() {
        return this.l;
    }

    public m c(int i) {
        this.m = i;
        return this;
    }

    public int n() {
        return this.m;
    }

    public m d(boolean z) {
        this.n = z;
        return this;
    }

    public boolean o() {
        return this.n;
    }

    public boolean p() {
        return this.o;
    }

    public m e(boolean z) {
        this.q = z;
        return this;
    }

    public boolean q() {
        return this.q;
    }
}
