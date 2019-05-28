package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class df {
    private db a;
    private String b = "";
    private String c;
    private cm d;
    private float e = 0.5f;
    private float f = 0.5f;
    private boolean g;
    private boolean h = true;
    private float i = 0.0f;
    private float j = 1.0f;
    private float k = 0.0f;
    private Object l;
    private String m;
    private cx n;
    private boolean o = true;
    private boolean p = false;
    private int q = 0;
    private boolean r = false;
    private boolean s = false;
    private boolean t = true;
    private float u = 0.5f;
    private float v = 0.5f;
    private int w = 0;
    private int x = 0;
    private boolean y = false;
    private int z = di.c;

    public df(db dbVar) {
        this.a = dbVar;
    }

    public df a(db dbVar) {
        this.a = dbVar;
        return this;
    }

    public df a(cm cmVar) {
        this.d = cmVar;
        return this;
    }

    public df a(float f, float f2) {
        this.e = f;
        this.f = f2;
        return this;
    }

    public df a(String str) {
        this.b = str;
        return this;
    }

    public df a(float f) {
        this.i = f;
        return this;
    }

    public df b(String str) {
        this.c = str;
        return this;
    }

    public df a(boolean z) {
        this.g = z;
        return this;
    }

    public df b(float f) {
        this.j = f;
        return this;
    }

    public df b(boolean z) {
        this.h = z;
        return this;
    }

    public df c(boolean z) {
        this.p = z;
        return this;
    }

    public df c(float f) {
        this.k = f;
        return this;
    }

    public df a(cx cxVar) {
        this.n = cxVar;
        return this;
    }

    public df a(Object obj) {
        this.l = obj;
        return this;
    }

    public boolean a() {
        return this.s;
    }

    public db b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public cm e() {
        AppMethodBeat.i(101035);
        if (this.d == null) {
            this.d = new cm(new bl(5));
        }
        cm cmVar = this.d;
        AppMethodBeat.o(101035);
        return cmVar;
    }

    public float f() {
        return this.e;
    }

    public float g() {
        return this.f;
    }

    public boolean h() {
        return this.g;
    }

    public boolean i() {
        return this.h;
    }

    public boolean j() {
        return this.o;
    }

    public float k() {
        return this.j;
    }

    public float l() {
        return this.k;
    }

    public cx m() {
        return this.n;
    }

    public boolean n() {
        return this.p;
    }

    public float o() {
        return this.i;
    }

    /* Access modifiers changed, original: 0000 */
    public int p() {
        return this.q;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean q() {
        return this.r;
    }

    public df d(boolean z) {
        this.t = z;
        return this;
    }

    public boolean r() {
        return this.t;
    }

    public df a(int i, int i2) {
        this.w = i;
        this.x = i2;
        return this;
    }

    public int s() {
        return this.w;
    }

    public int t() {
        return this.x;
    }

    public Object u() {
        return this.l;
    }

    public boolean v() {
        return this.y;
    }

    public void e(boolean z) {
        this.y = z;
    }

    public df c(String str) {
        this.m = str;
        return this;
    }

    public String w() {
        return this.m;
    }

    public df a(int i) {
        if (i >= di.a && i <= di.c) {
            this.z = i;
        }
        return this;
    }

    public int x() {
        return this.z;
    }
}
