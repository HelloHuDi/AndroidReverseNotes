package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dm {
    private static String A = "color_texture_flat_style.png";
    private boolean B;
    private a C;
    private cx D;
    private int E;
    private int F;
    private final List<db> a;
    private float b;
    private float c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private float j;
    private boolean k;
    private ck l;
    private List<Integer> m;
    private int[] n;
    private int[] o;
    private int[] p;
    private int q;
    private int r;
    @Deprecated
    private String s;
    private cm t;
    private boolean u;
    private int v;
    private boolean w;
    private List<db> x;
    private boolean y;
    private cm z;

    public enum a {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB;

        static {
            AppMethodBeat.o(101082);
        }
    }

    public int a() {
        return this.v;
    }

    public List<db> b() {
        return this.x;
    }

    public dm() {
        AppMethodBeat.i(101083);
        this.i = false;
        this.n = null;
        this.o = new int[]{-16711936};
        this.p = null;
        this.q = -7829368;
        this.r = 0;
        this.s = A;
        this.t = cn.a(A);
        this.u = false;
        this.v = 0;
        this.w = true;
        this.y = false;
        this.z = null;
        this.C = a.LINE_COLOR_NONE;
        this.E = di.a;
        this.F = 100;
        this.b = -1.0f;
        this.d = ic.k;
        this.f = true;
        this.g = false;
        this.a = new ArrayList();
        this.j = 1.0f;
        this.k = false;
        this.v = 0;
        this.e = 0;
        this.x = new ArrayList();
        AppMethodBeat.o(101083);
    }

    @Deprecated
    public void a(List<db> list) {
        AppMethodBeat.i(101084);
        b((List) list);
        AppMethodBeat.o(101084);
    }

    public dm b(List<db> list) {
        AppMethodBeat.i(101085);
        if (list != null) {
            this.a.clear();
            this.a.addAll(list);
        }
        AppMethodBeat.o(101085);
        return this;
    }

    public dm a(db dbVar, db... dbVarArr) {
        AppMethodBeat.i(101086);
        this.a.add(dbVar);
        if (dbVarArr != null) {
            a(dbVarArr);
        }
        AppMethodBeat.o(101086);
        return this;
    }

    public dm a(db[] dbVarArr) {
        AppMethodBeat.i(101087);
        if (dbVarArr != null) {
            this.a.addAll(Arrays.asList(dbVarArr));
        }
        AppMethodBeat.o(101087);
        return this;
    }

    public dm a(Iterable<db> iterable) {
        AppMethodBeat.i(101088);
        if (iterable != null) {
            for (db a : iterable) {
                a(a, new db[0]);
            }
        }
        AppMethodBeat.o(101088);
        return this;
    }

    public dm a(float f) {
        if (f < 0.0f) {
            this.b = 9.0f;
        } else {
            this.b = f;
        }
        return this;
    }

    public dm b(float f) {
        if (f < 0.0f) {
            this.c = 1.0f;
        } else {
            this.c = f;
        }
        return this;
    }

    public a c() {
        return this.C;
    }

    public dm a(int i) {
        this.d = i;
        return this;
    }

    public dm b(int i) {
        this.o = new int[]{i};
        return this;
    }

    public dm c(int i) {
        this.q = i;
        return this;
    }

    public int d() {
        return this.q;
    }

    public dm d(int i) {
        AppMethodBeat.i(101089);
        this.e = Math.max(0, i);
        AppMethodBeat.o(101089);
        return this;
    }

    public dm a(cx cxVar) {
        if (cxVar != null) {
            this.D = cxVar;
            this.i = true;
        }
        return this;
    }

    public dm a(boolean z) {
        this.f = z;
        return this;
    }

    public dm b(boolean z) {
        this.h = z;
        return this;
    }

    public List<db> e() {
        return this.a;
    }

    public float f() {
        return this.b;
    }

    public int g() {
        return this.d;
    }

    public int[][] h() {
        if (this.n == null || this.p == null || this.n.length != this.p.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, this.n.length});
        iArr[0] = this.n;
        iArr[1] = this.p;
        return iArr;
    }

    public int i() {
        return this.e;
    }

    public cx j() {
        return this.D;
    }

    public boolean k() {
        return this.f;
    }

    public boolean l() {
        return this.h;
    }

    public boolean m() {
        return this.i;
    }

    public float n() {
        return this.j;
    }

    public boolean o() {
        return this.k;
    }

    public ck p() {
        return this.l;
    }

    public int q() {
        return this.r;
    }

    public dm e(int i) {
        this.r = i;
        return this;
    }

    public dm a(cm cmVar) {
        this.t = cmVar;
        this.C = a.LINE_COLOR_TEXTURE;
        return this;
    }

    public cm r() {
        return this.t;
    }

    public boolean s() {
        return this.w;
    }

    public dm f(int i) {
        if (i >= di.a && i <= di.c) {
            this.E = i;
        }
        return this;
    }

    public int t() {
        return this.E;
    }

    public dm b(cm cmVar) {
        this.z = cmVar;
        return this;
    }

    public dm g(int i) {
        this.F = i;
        return this;
    }

    public cm u() {
        return this.z;
    }

    public int v() {
        return this.F;
    }

    public boolean w() {
        return this.B;
    }

    public List<Integer> x() {
        return this.m;
    }

    public dm c(List<Integer> list) {
        this.m = list;
        return this;
    }

    public float y() {
        return this.c;
    }

    public int[] z() {
        return this.o;
    }
}
