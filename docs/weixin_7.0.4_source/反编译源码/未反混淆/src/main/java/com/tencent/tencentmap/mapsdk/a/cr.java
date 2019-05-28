package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public class cr {
    private db a = new db(39.984253d, 116.307439d);
    private double b = 1.0d;
    private float c = 1.0f;
    private int d = WebView.NIGHT_MODE_COLOR;
    private int e = 0;
    private int f = 0;
    private boolean g = true;
    private int h = di.c;

    public cr() {
        AppMethodBeat.i(100975);
        AppMethodBeat.o(100975);
    }

    public cr a(db dbVar) {
        this.a = dbVar;
        return this;
    }

    public cr a(double d) {
        this.b = d;
        return this;
    }

    public cr a(float f) {
        if (f < 0.0f) {
            this.c = 1.0f;
        } else {
            this.c = f;
        }
        return this;
    }

    public cr a(int i) {
        this.d = i;
        return this;
    }

    public cr b(int i) {
        this.e = i;
        return this;
    }

    public cr c(int i) {
        this.f = i;
        return this;
    }

    public cr a(boolean z) {
        this.g = z;
        return this;
    }

    public db a() {
        return this.a;
    }

    public double b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.g;
    }

    public cr d(int i) {
        if (i >= di.a && i <= di.c) {
            this.h = i;
        }
        return this;
    }

    public int h() {
        return this.h;
    }
}
