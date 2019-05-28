package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.d;
import com.tencent.map.lib.element.e;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ck;
import com.tencent.tencentmap.mapsdk.a.cm;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.di;
import com.tencent.tencentmap.mapsdk.a.dl;
import com.tencent.tencentmap.mapsdk.a.dm;
import com.tencent.tencentmap.mapsdk.maps.a.if.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class ib extends hz {
    private static final int[] w = new int[]{5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80};
    private boolean A = false;
    private boolean B = false;
    private int C = -1;
    private GeoPoint D = null;
    private String E;
    private int F = -1;
    private List<Integer> G;
    private int H = 0;
    private final String R = (A() + "_arrow_texture_");
    private final float S;
    private b T = new b() {
        public void a(float f, float f2, float f3, float f4) {
        }

        public void a(float f) {
            AppMethodBeat.i(99766);
            ib.this.q = f;
            AppMethodBeat.o(99766);
        }

        public void a(int i, int i2) {
        }

        public void a(float f, float f2) {
        }

        public void b(float f) {
            AppMethodBeat.i(99767);
            ib.this.s = f;
            AppMethodBeat.o(99767);
        }
    };
    protected byte[] a = new byte[0];
    private d b = null;
    private dl c = null;
    private ArrayList<a> d = null;
    private ArrayList<GeoPoint> e = null;
    private float f;
    private iz g = null;
    private boolean h = false;
    private int[] i = null;
    private int[] j = null;
    private int[] k = null;
    private int l = -7829368;
    private com.tencent.tencentmap.mapsdk.a.dm.a m;
    private cm n = null;
    private int o = 12;
    private if p;
    private float q;
    private a r = null;
    private float s = 1.0f;
    private int t = 0;
    private boolean u = false;
    private boolean v = true;
    private float x = 0.0f;
    private int y = 0;
    private ArrayList<GeoPoint> z;

    static class a extends GeoPoint {
        float a = 0.0f;
        int b = 0;

        public a(GeoPoint geoPoint) {
            super(geoPoint);
        }

        public String toString() {
            AppMethodBeat.i(99768);
            String str = super.toString() + "," + this.a;
            AppMethodBeat.o(99768);
            return str;
        }
    }

    public ib(iz izVar) {
        AppMethodBeat.i(99769);
        this.g = izVar;
        this.d = new ArrayList();
        this.S = this.g.i().getResources().getDisplayMetrics().density;
        AppMethodBeat.o(99769);
    }

    public void a(int i, List<db> list) {
        AppMethodBeat.i(99770);
        this.y = i;
        if (list == null) {
            AppMethodBeat.o(99770);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.o(99770);
            return;
        }
        this.z = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            db dbVar = (db) list.get(i2);
            if (dbVar != null) {
                GeoPoint a = ic.a(dbVar);
                if (a != null) {
                    this.z.add(a);
                }
            }
        }
        AppMethodBeat.o(99770);
    }

    public void a(Bitmap bitmap) {
        AppMethodBeat.i(99771);
        com.tencent.map.lib.util.b.b(this.R + this.H);
        StringBuilder append = new StringBuilder().append(this.R);
        int i = this.H + 1;
        this.H = i;
        String stringBuilder = append.append(i).toString();
        com.tencent.map.lib.util.b.a(stringBuilder, bitmap);
        this.E = stringBuilder;
        AppMethodBeat.o(99771);
    }

    public void b(int i) {
        this.F = i;
    }

    public void a(List<db> list) {
        AppMethodBeat.i(99772);
        this.x = 0.0f;
        this.d.clear();
        if (list == null) {
            AppMethodBeat.o(99772);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.o(99772);
            return;
        }
        GeoPoint geoPoint = null;
        this.e = new ArrayList();
        int i = 0;
        while (i < size) {
            GeoPoint aVar;
            db dbVar = (db) list.get(i);
            if (dbVar != null) {
                GeoPoint a = ic.a(dbVar);
                if (a != null) {
                    aVar = new a(a);
                    this.e.add(aVar);
                    if (geoPoint != null) {
                        this.x += a(aVar, geoPoint);
                        aVar.a = this.x;
                        aVar.b = geoPoint.b + 1;
                    }
                    this.d.add(aVar);
                    i++;
                    geoPoint = aVar;
                }
            }
            aVar = geoPoint;
            i++;
            geoPoint = aVar;
        }
        AppMethodBeat.o(99772);
    }

    public void a(dm dmVar) {
        AppMethodBeat.i(99773);
        if (this.g == null || this.g.b() == null || dmVar == null) {
            AppMethodBeat.o(99773);
            return;
        }
        if (dmVar.f() == -1.0f) {
            d(9.0f);
        } else {
            d(dmVar.f());
        }
        c(dmVar.g());
        c((float) dmVar.i());
        a(dmVar.k());
        a(dmVar.n());
        c(dmVar.l());
        a(dmVar.r());
        e(dmVar.o());
        b(dmVar.x());
        b(dmVar.y());
        this.k = dmVar.z();
        this.J = dmVar.j();
        this.t = dmVar.q();
        this.Q = dmVar.t();
        this.l = dmVar.d();
        if (dmVar.m() && this.Q == di.a) {
            this.Q = di.c;
        }
        a(dmVar.e());
        a(dmVar.a(), dmVar.b());
        if (dmVar.u() != null) {
            a(dmVar.u().a(this.g.i()));
        }
        b(dmVar.v());
        this.v = dmVar.s();
        ck p = dmVar.p();
        if (p != null) {
            a(p.a);
        }
        int[][] h = dmVar.h();
        if (h != null && h.length == 2) {
            int[] iArr = h[0];
            int[] iArr2 = h[1];
            if (!(iArr == null || iArr2 == null || iArr.length != iArr2.length)) {
                a(iArr, iArr2);
            }
        }
        this.m = a(dmVar.c());
        k();
        AppMethodBeat.o(99773);
    }

    public void b(boolean z) {
        this.u = z;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public void c(int i) {
        AppMethodBeat.i(99774);
        super.c(i);
        AppMethodBeat.o(99774);
    }

    private void k() {
        AppMethodBeat.i(99775);
        if (this.g == null || this.g.b() == null) {
            AppMethodBeat.o(99775);
        } else if (!a()) {
            if (this.b != null) {
                this.g.b().b(this.b);
                this.b.B();
                this.b = null;
            }
            AppMethodBeat.o(99775);
        } else if (this.e == null || this.e.size() < 2) {
            AppMethodBeat.o(99775);
        } else {
            if (this.b == null) {
                this.g.b();
                this.b = new d(m());
                this.g.b().a(this.b);
            } else {
                this.b.a(m());
            }
            this.b.a(this.C, this.D);
            this.g.b().a();
            AppMethodBeat.o(99775);
        }
    }

    public void a(cm cmVar) {
        AppMethodBeat.i(99776);
        if (this.g == null || this.g.b() == null || cmVar == null || cmVar.a() == null) {
            AppMethodBeat.o(99776);
            return;
        }
        this.n = cmVar;
        com.tencent.map.lib.util.b.a(this.n.a().a(), this.n.a(this.g.i()));
        this.m = com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_TEXTURE;
        AppMethodBeat.o(99776);
    }

    private void l() {
        AppMethodBeat.i(99777);
        if (!(this.g == null || this.g.b() == null || this.b == null)) {
            this.g.b().b(this.b);
            this.b = null;
        }
        AppMethodBeat.o(99777);
    }

    private com.tencent.tencentmap.mapsdk.a.dm.a a(com.tencent.tencentmap.mapsdk.a.dm.a aVar) {
        if (aVar != com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_NONE) {
            return aVar;
        }
        if (this.i == null || this.i.length <= 0) {
            return (this.M < 0 || this.M >= this.o) ? com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_ARGB : com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_TEXTURE;
        } else {
            int i = 0;
            int length = this.i.length;
            while (i < length) {
                if (this.i[i] < 0 || this.i[i] >= this.o) {
                    return com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_ARGB;
                }
                i++;
            }
            return com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_TEXTURE;
        }
    }

    private int e(int i) {
        int i2;
        if (i >= this.o) {
            i2 = this.o - 1;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    private e m() {
        AppMethodBeat.i(99778);
        if (this.g == null || this.g.b() == null) {
            AppMethodBeat.o(99778);
            return null;
        }
        e eVar = new e();
        if (!(this.n == null || this.n.a() == null)) {
            eVar.a(this.n.a().a());
        }
        int[][] d = d(this.e);
        eVar.c(this.h);
        eVar.d((float) this.F);
        eVar.a(this.e);
        eVar.a(this.l);
        if (this.t == 0) {
            int a = a(this.g.i(), this.n);
            if (a > 0) {
                eVar.b(this.K > ((float) a) ? (float) a : this.K);
            } else {
                eVar.b(this.K);
            }
        } else {
            eVar.b(this.K);
        }
        if (this.m == com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_ARGB) {
            eVar.b(true);
            if (this.f * 2.0f > this.K) {
                this.f = this.K / 3.0f;
            }
            eVar.c(this.f);
        }
        int[] f = f();
        if (this.v) {
            eVar.a(d[1]);
            if (this.f <= 0.0f || f == null || f.length <= 0) {
                eVar.b(d[0]);
            } else {
                eVar.a(d[0], f);
            }
        } else {
            eVar.a(new int[]{0});
            if (this.f <= 0.0f || f == null || f.length <= 0) {
                eVar.b(new int[]{this.M});
            } else {
                eVar.a(new int[]{this.M}, new int[]{f[0]});
            }
        }
        eVar.a(this.q);
        eVar.b(this.t);
        eVar.c((int) this.N);
        eVar.e(this.u);
        if (this.y > 0 && this.y <= 3) {
            eVar.a(this.y, this.z);
        }
        eVar.f(this.A);
        eVar.a(this.B);
        eVar.d(this.v);
        eVar.b(this.E);
        eVar.b(this.G);
        eVar.d(this.Q);
        AppMethodBeat.o(99778);
        return eVar;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(99779);
        if (obj == null) {
            AppMethodBeat.o(99779);
            return false;
        } else if (obj instanceof ib) {
            boolean equals = TextUtils.equals(A(), ((ib) obj).A());
            AppMethodBeat.o(99779);
            return equals;
        } else {
            AppMethodBeat.o(99779);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(99780);
        int hashCode = A().hashCode();
        AppMethodBeat.o(99780);
        return hashCode;
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99781);
        if (a()) {
            b(gl10);
            AppMethodBeat.o(99781);
            return;
        }
        AppMethodBeat.o(99781);
    }

    /* Access modifiers changed, original: protected */
    public boolean b(GL10 gl10) {
        AppMethodBeat.i(99782);
        if (this.g == null || this.g.b() == null) {
            AppMethodBeat.o(99782);
            return false;
        } else if (this.p == null || !this.p.e()) {
            AppMethodBeat.o(99782);
            return false;
        } else {
            this.p.d();
            if (this.p instanceof ih) {
                this.e = c(this.d);
                if (this.e.size() >= 2) {
                    k();
                }
            } else if (this.p instanceof ie) {
                k();
            }
            this.g.b().a();
            if (this.p.f()) {
                this.p.a(null);
                this.p = null;
            }
            AppMethodBeat.o(99782);
            return true;
        }
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(99783);
        if (this.g == null || this.g.b() == null || !a()) {
            AppMethodBeat.o(99783);
            return false;
        } else if (this.b != null) {
            boolean a = this.b.a(this.g.b().t(), f, f2);
            AppMethodBeat.o(99783);
            return a;
        } else {
            AppMethodBeat.o(99783);
            return false;
        }
    }

    public float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.i(99784);
        float f = 0.0f;
        if (!(geoPoint == null || geoPoint2 == null || geoPoint == null)) {
            f = (float) (Math.hypot((double) (geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6()), (double) (geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6())) + 0.0d);
        }
        AppMethodBeat.o(99784);
        return f;
    }

    private ArrayList<GeoPoint> c(List<a> list) {
        AppMethodBeat.i(99785);
        ArrayList<GeoPoint> arrayList = new ArrayList();
        if (list == null || list.size() < 2) {
            AppMethodBeat.o(99785);
            return arrayList;
        }
        float f = this.r.a;
        float f2 = f - (this.s * f);
        float f3 = f + ((this.x - this.r.a) * this.s);
        a aVar = null;
        int i = 0;
        while (i < list.size()) {
            a aVar2 = (a) list.get(i);
            if (aVar2.a > f2 && aVar2.a < f3) {
                if (aVar != null && aVar.a < f2) {
                    a a = a(aVar, aVar2, (f2 - aVar.a) / (aVar2.a - aVar.a));
                    a.b = aVar.b;
                    arrayList.add(a);
                }
                arrayList.add(aVar2);
            } else if (aVar2.a > f3) {
                if (aVar != null && aVar.a < f3) {
                    a a2 = a(aVar, aVar2, (f3 - aVar.a) / (aVar2.a - aVar.a));
                    a2.b = aVar2.b;
                    arrayList.add(a2);
                }
                AppMethodBeat.o(99785);
                return arrayList;
            } else if (Float.compare(aVar2.a, f2) == 0 || Float.compare(aVar2.a, f3) == 0) {
                arrayList.add(aVar2);
            }
            i++;
            aVar = aVar2;
        }
        AppMethodBeat.o(99785);
        return arrayList;
    }

    private a a(a aVar, a aVar2, float f) {
        AppMethodBeat.i(99786);
        a aVar3 = new a();
        int longitudeE6 = aVar2.getLongitudeE6() - aVar.getLongitudeE6();
        int latitudeE6 = aVar2.getLatitudeE6() - aVar.getLatitudeE6();
        aVar3.setLatitudeE6(Math.round(((float) latitudeE6) * f) + aVar.getLatitudeE6());
        aVar3.setLongitudeE6(Math.round(((float) longitudeE6) * f) + aVar.getLongitudeE6());
        aVar3.a = aVar.a + ((aVar2.a - aVar.a) * f);
        AppMethodBeat.o(99786);
        return aVar3;
    }

    private int[][] d(List<GeoPoint> list) {
        AppMethodBeat.i(99787);
        int i;
        int e;
        int[][] iArr;
        if (this.i == null || this.j == null || list == null || this.i.length == 0 || this.j.length == 0 || list.isEmpty()) {
            i = this.M;
            if (this.m == com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_TEXTURE) {
                e = e(i);
            } else {
                e = i;
            }
            iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, 1});
            iArr[0][0] = e;
            iArr[1][0] = 0;
            AppMethodBeat.o(99787);
            return iArr;
        }
        int i2;
        if (this.i == null || this.j == null) {
            e = 0;
        } else {
            e = Math.min(this.i.length, this.j.length);
        }
        int[] iArr2 = new int[e];
        for (i = 0; i < e; i++) {
            iArr2[i] = this.i[i];
            if (this.m == com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_TEXTURE) {
                iArr2[i] = e(iArr2[i]);
            }
        }
        TreeMap treeMap = new TreeMap();
        a aVar = (a) list.get(0);
        int i3 = 1;
        while (i3 < e) {
            if (aVar.b <= this.j[i3]) {
                treeMap.put(Integer.valueOf(0), Integer.valueOf(iArr2[i3 - 1]));
                i2 = i3;
                break;
            }
            i3++;
        }
        i2 = 0;
        if (i3 == e && treeMap.size() == 0) {
            treeMap.put(Integer.valueOf(0), Integer.valueOf(iArr2[e - 1]));
            i2 = e;
        }
        a aVar2 = aVar;
        int i4 = 1;
        int i5 = i2;
        while (i4 < list.size()) {
            aVar = (a) list.get(i4);
            i2 = i5;
            int i6 = i5;
            while (i2 < e && aVar.b > this.j[i2] && aVar2.b <= this.j[i2]) {
                treeMap.put(Integer.valueOf(i4 - 1), Integer.valueOf(iArr2[i2]));
                i6++;
                i2++;
            }
            aVar2 = aVar;
            i4++;
            i5 = i6;
        }
        iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, treeMap.size()});
        i3 = 0;
        for (Entry entry : treeMap.entrySet()) {
            iArr[0][i3] = ((Integer) entry.getValue()).intValue();
            iArr[1][i3] = ((Integer) entry.getKey()).intValue();
            i3++;
        }
        AppMethodBeat.o(99787);
        return iArr;
    }

    private float a(a aVar, a aVar2, GeoPoint geoPoint, a aVar3) {
        AppMethodBeat.i(99788);
        int longitudeE6 = aVar.getLongitudeE6();
        int latitudeE6 = aVar.getLatitudeE6();
        int longitudeE62 = aVar2.getLongitudeE6();
        int latitudeE62 = aVar2.getLatitudeE6();
        int longitudeE63 = geoPoint.getLongitudeE6();
        int latitudeE63 = geoPoint.getLatitudeE6();
        float f = (float) (((longitudeE62 - longitudeE6) * (longitudeE63 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE63 - latitudeE6)));
        float hypot;
        if (f <= 0.0f) {
            aVar3.setLatitudeE6(aVar.getLatitudeE6());
            aVar3.setLongitudeE6(aVar.getLongitudeE6());
            aVar3.a = aVar.a;
            hypot = (float) Math.hypot((double) (longitudeE63 - longitudeE6), (double) (latitudeE63 - latitudeE6));
            AppMethodBeat.o(99788);
            return hypot;
        }
        double d = (double) (((longitudeE62 - longitudeE6) * (longitudeE62 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE62 - latitudeE6)));
        if (((double) f) >= d) {
            aVar3.setLatitudeE6(aVar2.getLatitudeE6());
            aVar3.setLongitudeE6(aVar2.getLongitudeE6());
            aVar3.a = aVar2.a;
            hypot = (float) Math.hypot((double) (longitudeE63 - longitudeE62), (double) (latitudeE63 - latitudeE62));
            AppMethodBeat.o(99788);
            return hypot;
        }
        f = (float) (((double) f) / d);
        hypot = (((float) (longitudeE62 - longitudeE6)) * f) + ((float) longitudeE6);
        float f2 = (((float) (latitudeE62 - latitudeE6)) * f) + ((float) latitudeE6);
        aVar3.setLongitudeE6(Math.round(hypot));
        aVar3.setLatitudeE6(Math.round(f2));
        aVar3.a = aVar.a + ((aVar2.a - aVar.a) * f);
        hypot = (float) Math.hypot((double) (((float) longitudeE63) - hypot), (double) (((float) latitudeE63) - f2));
        AppMethodBeat.o(99788);
        return hypot;
    }

    public boolean a() {
        AppMethodBeat.i(99789);
        if (B() == null) {
            boolean z = this.O;
            AppMethodBeat.o(99789);
            return z;
        } else if (this.O && this.I) {
            AppMethodBeat.o(99789);
            return true;
        } else {
            AppMethodBeat.o(99789);
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        AppMethodBeat.i(99790);
        k();
        AppMethodBeat.o(99790);
    }

    public void d() {
        AppMethodBeat.i(99791);
        l();
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        if (this.e != null) {
            this.e.clear();
            this.e = null;
        }
        com.tencent.map.lib.util.b.b(this.E);
        if (!(this.n == null || this.n.a() == null)) {
            com.tencent.map.lib.util.b.b(this.n.a().a());
        }
        AppMethodBeat.o(99791);
    }

    public void a(int[] iArr, int[] iArr2) {
        AppMethodBeat.i(99792);
        this.i = iArr;
        this.j = iArr2;
        this.m = a(com.tencent.tencentmap.mapsdk.a.dm.a.LINE_COLOR_NONE);
        AppMethodBeat.o(99792);
    }

    public int[][] e() {
        if (this.i == null || this.j == null || this.i.length != this.j.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, this.i.length});
        iArr[0] = this.i;
        iArr[1] = this.j;
        return iArr;
    }

    public int[] f() {
        return this.k;
    }

    public void g() {
        AppMethodBeat.i(99793);
        if (this.b == null) {
            AppMethodBeat.o(99793);
            return;
        }
        this.b.p();
        AppMethodBeat.o(99793);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99794);
        if (this.b == null) {
            AppMethodBeat.o(99794);
            return;
        }
        this.b.p();
        this.b.a(i, i2);
        k();
        AppMethodBeat.o(99794);
    }

    public boolean r() {
        return true;
    }

    public void a(dl dlVar) {
        this.c = dlVar;
    }

    public dl h() {
        return this.c;
    }

    public void a(float f) {
        this.q = f;
    }

    public void a(int i, db dbVar) {
        AppMethodBeat.i(99795);
        GeoPoint a = ic.a(dbVar);
        if (i == -1 || a == null) {
            AppMethodBeat.o(99795);
            return;
        }
        this.C = i;
        this.D = a;
        c();
        AppMethodBeat.o(99795);
    }

    public void d(boolean z) {
        AppMethodBeat.i(99796);
        this.A = z;
        if (this.b != null) {
            this.b.a(z);
        }
        AppMethodBeat.o(99796);
    }

    public void e(boolean z) {
        this.B = z;
    }

    public void b(List<Integer> list) {
        this.G = list;
    }

    public void b(float f) {
        this.f = f;
    }

    public Rect i() {
        AppMethodBeat.i(99797);
        Rect u = this.b.u();
        AppMethodBeat.o(99797);
        return u;
    }

    public void a(if ifVar) {
        AppMethodBeat.i(99798);
        if (this.p != null) {
            this.p.b();
            this.p.a(null);
        }
        if (ifVar instanceof ih) {
            a((ih) ifVar);
            AppMethodBeat.o(99798);
        } else if (ifVar instanceof ie) {
            a((ie) ifVar);
            AppMethodBeat.o(99798);
        } else {
            this.p = null;
            AppMethodBeat.o(99798);
        }
    }

    private void a(ih ihVar) {
        AppMethodBeat.i(99799);
        if (this.g == null || this.g.b() == null) {
            AppMethodBeat.o(99799);
            return;
        }
        this.p = ihVar;
        this.r = a(ic.a(ihVar.g()));
        if (this.r == null) {
            RuntimeException runtimeException = new RuntimeException("Error, start point not found.");
            AppMethodBeat.o(99799);
            throw runtimeException;
        }
        ihVar.a(this.T);
        ihVar.a(null, null);
        this.g.b().a();
        AppMethodBeat.o(99799);
    }

    private void a(ie ieVar) {
        AppMethodBeat.i(99800);
        this.p = ieVar;
        this.p.a(this.T);
        this.p.a(null, null);
        if (!(this.g == null || this.g.b() == null)) {
            this.g.b().a();
        }
        AppMethodBeat.o(99800);
    }

    private a a(GeoPoint geoPoint) {
        AppMethodBeat.i(99801);
        float f = Float.MAX_VALUE;
        a aVar = null;
        a aVar2 = new a();
        if (!(this.d == null || this.d.size() < 2 || geoPoint == null)) {
            int i = 1;
            a aVar3 = (a) this.d.get(0);
            while (i < this.d.size()) {
                a aVar4;
                a aVar5 = (a) this.d.get(i);
                float a = a(aVar3, aVar5, geoPoint, aVar2);
                if (a < f) {
                    aVar4 = new a();
                    aVar = aVar2;
                } else {
                    aVar4 = aVar2;
                    a = f;
                }
                i++;
                aVar3 = aVar5;
                aVar2 = aVar4;
                f = a;
            }
        }
        AppMethodBeat.o(99801);
        return aVar;
    }

    public d j() {
        return this.b;
    }

    private int a(Context context, cm cmVar) {
        AppMethodBeat.i(99802);
        if (context == null || cmVar == null) {
            AppMethodBeat.o(99802);
            return 0;
        }
        Bitmap a = cmVar.a(context);
        if (a == null) {
            AppMethodBeat.o(99802);
            return 0;
        }
        int height = a.getHeight();
        if (height <= 0) {
            AppMethodBeat.o(99802);
            return 0;
        }
        int pow = (int) ((Math.pow(2.0d, 25.0d) / Math.pow((double) height, 2.0d)) / ((double) SystemUtil.getDensity(context)));
        AppMethodBeat.o(99802);
        return pow;
    }
}
