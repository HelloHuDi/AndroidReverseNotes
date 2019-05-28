package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C37424e;
import com.tencent.map.lib.element.C45135d;
import com.tencent.map.lib.util.C17862b;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31058b;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C24347di;
import com.tencent.tencentmap.mapsdk.p666a.C31003dl;
import com.tencent.tencentmap.mapsdk.p666a.C31004dm;
import com.tencent.tencentmap.mapsdk.p666a.C31004dm.C31005a;
import com.tencent.tencentmap.mapsdk.p666a.C36465ck;
import com.tencent.tencentmap.mapsdk.p666a.C41018cm;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ib */
public class C36901ib extends C36519hz {
    /* renamed from: w */
    private static final int[] f15584w = new int[]{5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80};
    /* renamed from: A */
    private boolean f15585A = false;
    /* renamed from: B */
    private boolean f15586B = false;
    /* renamed from: C */
    private int f15587C = -1;
    /* renamed from: D */
    private GeoPoint f15588D = null;
    /* renamed from: E */
    private String f15589E;
    /* renamed from: F */
    private int f15590F = -1;
    /* renamed from: G */
    private List<Integer> f15591G;
    /* renamed from: H */
    private int f15592H = 0;
    /* renamed from: R */
    private final String f15593R = (mo57757A() + "_arrow_texture_");
    /* renamed from: S */
    private final float f15594S;
    /* renamed from: T */
    private C31058b f15595T = new C243891();
    /* renamed from: a */
    protected byte[] f15596a = new byte[0];
    /* renamed from: b */
    private C45135d f15597b = null;
    /* renamed from: c */
    private C31003dl f15598c = null;
    /* renamed from: d */
    private ArrayList<C36902a> f15599d = null;
    /* renamed from: e */
    private ArrayList<GeoPoint> f15600e = null;
    /* renamed from: f */
    private float f15601f;
    /* renamed from: g */
    private C31061iz f15602g = null;
    /* renamed from: h */
    private boolean f15603h = false;
    /* renamed from: i */
    private int[] f15604i = null;
    /* renamed from: j */
    private int[] f15605j = null;
    /* renamed from: k */
    private int[] f15606k = null;
    /* renamed from: l */
    private int f15607l = -7829368;
    /* renamed from: m */
    private C31005a f15608m;
    /* renamed from: n */
    private C41018cm f15609n = null;
    /* renamed from: o */
    private int f15610o = 12;
    /* renamed from: p */
    private C31056if f15611p;
    /* renamed from: q */
    private float f15612q;
    /* renamed from: r */
    private C36902a f15613r = null;
    /* renamed from: s */
    private float f15614s = 1.0f;
    /* renamed from: t */
    private int f15615t = 0;
    /* renamed from: u */
    private boolean f15616u = false;
    /* renamed from: v */
    private boolean f15617v = true;
    /* renamed from: x */
    private float f15618x = 0.0f;
    /* renamed from: y */
    private int f15619y = 0;
    /* renamed from: z */
    private ArrayList<GeoPoint> f15620z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ib$1 */
    class C243891 implements C31058b {
        C243891() {
        }

        /* renamed from: a */
        public void mo29455a(float f, float f2, float f3, float f4) {
        }

        /* renamed from: a */
        public void mo29453a(float f) {
            AppMethodBeat.m2504i(99766);
            C36901ib.this.f15612q = f;
            AppMethodBeat.m2505o(99766);
        }

        /* renamed from: a */
        public void mo29456a(int i, int i2) {
        }

        /* renamed from: a */
        public void mo29454a(float f, float f2) {
        }

        /* renamed from: b */
        public void mo29457b(float f) {
            AppMethodBeat.m2504i(99767);
            C36901ib.this.f15614s = f;
            AppMethodBeat.m2505o(99767);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ib$a */
    static class C36902a extends GeoPoint {
        /* renamed from: a */
        float f15621a = 0.0f;
        /* renamed from: b */
        int f15622b = 0;

        public C36902a(GeoPoint geoPoint) {
            super(geoPoint);
        }

        public String toString() {
            AppMethodBeat.m2504i(99768);
            String str = super.toString() + "," + this.f15621a;
            AppMethodBeat.m2505o(99768);
            return str;
        }
    }

    public C36901ib(C31061iz c31061iz) {
        AppMethodBeat.m2504i(99769);
        this.f15602g = c31061iz;
        this.f15599d = new ArrayList();
        this.f15594S = this.f15602g.mo65138i().getResources().getDisplayMetrics().density;
        AppMethodBeat.m2505o(99769);
    }

    /* renamed from: a */
    public void mo58906a(int i, List<C24343db> list) {
        AppMethodBeat.m2504i(99770);
        this.f15619y = i;
        if (list == null) {
            AppMethodBeat.m2505o(99770);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.m2505o(99770);
            return;
        }
        this.f15620z = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C24343db c24343db = (C24343db) list.get(i2);
            if (c24343db != null) {
                GeoPoint a = C36520ic.m60470a(c24343db);
                if (a != null) {
                    this.f15620z.add(a);
                }
            }
        }
        AppMethodBeat.m2505o(99770);
    }

    /* renamed from: a */
    public void mo58907a(Bitmap bitmap) {
        AppMethodBeat.m2504i(99771);
        C17862b.m27957b(this.f15593R + this.f15592H);
        StringBuilder append = new StringBuilder().append(this.f15593R);
        int i = this.f15592H + 1;
        this.f15592H = i;
        String stringBuilder = append.append(i).toString();
        C17862b.m27956a(stringBuilder, bitmap);
        this.f15589E = stringBuilder;
        AppMethodBeat.m2505o(99771);
    }

    /* renamed from: b */
    public void mo58915b(int i) {
        this.f15590F = i;
    }

    /* renamed from: a */
    public void mo58912a(List<C24343db> list) {
        AppMethodBeat.m2504i(99772);
        this.f15618x = 0.0f;
        this.f15599d.clear();
        if (list == null) {
            AppMethodBeat.m2505o(99772);
            return;
        }
        int size = list.size();
        if (size <= 0) {
            AppMethodBeat.m2505o(99772);
            return;
        }
        GeoPoint geoPoint = null;
        this.f15600e = new ArrayList();
        int i = 0;
        while (i < size) {
            GeoPoint c36902a;
            C24343db c24343db = (C24343db) list.get(i);
            if (c24343db != null) {
                GeoPoint a = C36520ic.m60470a(c24343db);
                if (a != null) {
                    c36902a = new C36902a(a);
                    this.f15600e.add(c36902a);
                    if (geoPoint != null) {
                        this.f15618x += mo58902a(c36902a, geoPoint);
                        c36902a.f15621a = this.f15618x;
                        c36902a.f15622b = geoPoint.f15622b + 1;
                    }
                    this.f15599d.add(c36902a);
                    i++;
                    geoPoint = c36902a;
                }
            }
            c36902a = geoPoint;
            i++;
            geoPoint = c36902a;
        }
        AppMethodBeat.m2505o(99772);
    }

    /* renamed from: a */
    public void mo58910a(C31004dm c31004dm) {
        AppMethodBeat.m2504i(99773);
        if (this.f15602g == null || this.f15602g.mo75386b() == null || c31004dm == null) {
            AppMethodBeat.m2505o(99773);
            return;
        }
        if (c31004dm.mo50258f() == -1.0f) {
            mo50177d(9.0f);
        } else {
            mo50177d(c31004dm.mo50258f());
        }
        mo50176c(c31004dm.mo50260g());
        mo50175c((float) c31004dm.mo50263i());
        mo29442a(c31004dm.mo50265k());
        mo58903a(c31004dm.mo50268n());
        mo58919c(c31004dm.mo50266l());
        mo58908a(c31004dm.mo50272r());
        mo58921e(c31004dm.mo50269o());
        mo58916b(c31004dm.mo50278x());
        mo58914b(c31004dm.mo50279y());
        this.f15606k = c31004dm.mo50280z();
        this.f15389J = c31004dm.mo50264j();
        this.f15615t = c31004dm.mo50271q();
        this.f13967Q = c31004dm.mo50274t();
        this.f15607l = c31004dm.mo50254d();
        if (c31004dm.mo50267m() && this.f13967Q == C24347di.f4621a) {
            this.f13967Q = C24347di.f4623c;
        }
        mo58912a(c31004dm.mo50257e());
        mo58906a(c31004dm.mo50235a(), c31004dm.mo50250b());
        if (c31004dm.mo50275u() != null) {
            mo58907a(c31004dm.mo50275u().mo65064a(this.f15602g.mo65138i()));
        }
        mo58915b(c31004dm.mo50276v());
        this.f15617v = c31004dm.mo50273s();
        C36465ck p = c31004dm.mo50270p();
        if (p != null) {
            mo58911a(p.f15229a);
        }
        int[][] h = c31004dm.mo50262h();
        if (h != null && h.length == 2) {
            int[] iArr = h[0];
            int[] iArr2 = h[1];
            if (!(iArr == null || iArr2 == null || iArr.length != iArr2.length)) {
                mo58913a(iArr, iArr2);
            }
        }
        this.f15608m = m61612a(c31004dm.mo50251c());
        m61621k();
        AppMethodBeat.m2505o(99773);
    }

    /* renamed from: b */
    public void mo58917b(boolean z) {
        this.f15616u = z;
    }

    /* renamed from: c */
    public void mo58919c(boolean z) {
        this.f15603h = z;
    }

    /* renamed from: c */
    public void mo50176c(int i) {
        AppMethodBeat.m2504i(99774);
        super.mo50176c(i);
        AppMethodBeat.m2505o(99774);
    }

    /* renamed from: k */
    private void m61621k() {
        AppMethodBeat.m2504i(99775);
        if (this.f15602g == null || this.f15602g.mo75386b() == null) {
            AppMethodBeat.m2505o(99775);
        } else if (!mo29443a()) {
            if (this.f15597b != null) {
                this.f15602g.mo75386b().mo20194b(this.f15597b);
                this.f15597b.mo72963B();
                this.f15597b = null;
            }
            AppMethodBeat.m2505o(99775);
        } else if (this.f15600e == null || this.f15600e.size() < 2) {
            AppMethodBeat.m2505o(99775);
        } else {
            if (this.f15597b == null) {
                this.f15602g.mo75386b();
                this.f15597b = new C45135d(m61623m());
                this.f15602g.mo75386b().mo20164a(this.f15597b);
            } else {
                this.f15597b.mo72969a(m61623m());
            }
            this.f15597b.mo72968a(this.f15587C, this.f15588D);
            this.f15602g.mo75386b().mo20154a();
            AppMethodBeat.m2505o(99775);
        }
    }

    /* renamed from: a */
    public void mo58908a(C41018cm c41018cm) {
        AppMethodBeat.m2504i(99776);
        if (this.f15602g == null || this.f15602g.mo75386b() == null || c41018cm == null || c41018cm.mo65065a() == null) {
            AppMethodBeat.m2505o(99776);
            return;
        }
        this.f15609n = c41018cm;
        C17862b.m27956a(this.f15609n.mo65065a().mo12312a(), this.f15609n.mo65064a(this.f15602g.mo65138i()));
        this.f15608m = C31005a.LINE_COLOR_TEXTURE;
        AppMethodBeat.m2505o(99776);
    }

    /* renamed from: l */
    private void m61622l() {
        AppMethodBeat.m2504i(99777);
        if (!(this.f15602g == null || this.f15602g.mo75386b() == null || this.f15597b == null)) {
            this.f15602g.mo75386b().mo20194b(this.f15597b);
            this.f15597b = null;
        }
        AppMethodBeat.m2505o(99777);
    }

    /* renamed from: a */
    private C31005a m61612a(C31005a c31005a) {
        if (c31005a != C31005a.LINE_COLOR_NONE) {
            return c31005a;
        }
        if (this.f15604i == null || this.f15604i.length <= 0) {
            return (this.f13963M < 0 || this.f13963M >= this.f15610o) ? C31005a.LINE_COLOR_ARGB : C31005a.LINE_COLOR_TEXTURE;
        } else {
            int i = 0;
            int length = this.f15604i.length;
            while (i < length) {
                if (this.f15604i[i] < 0 || this.f15604i[i] >= this.f15610o) {
                    return C31005a.LINE_COLOR_ARGB;
                }
                i++;
            }
            return C31005a.LINE_COLOR_TEXTURE;
        }
    }

    /* renamed from: e */
    private int m61620e(int i) {
        int i2;
        if (i >= this.f15610o) {
            i2 = this.f15610o - 1;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    /* renamed from: m */
    private C37424e m61623m() {
        AppMethodBeat.m2504i(99778);
        if (this.f15602g == null || this.f15602g.mo75386b() == null) {
            AppMethodBeat.m2505o(99778);
            return null;
        }
        C37424e c37424e = new C37424e();
        if (!(this.f15609n == null || this.f15609n.mo65065a() == null)) {
            c37424e.mo60265a(this.f15609n.mo65065a().mo12312a());
        }
        int[][] d = m61619d(this.f15600e);
        c37424e.mo60281c(this.f15603h);
        c37424e.mo60282d((float) this.f15590F);
        c37424e.mo60266a(this.f15600e);
        c37424e.mo60263a(this.f15607l);
        if (this.f15615t == 0) {
            int a = m61611a(this.f15602g.mo65138i(), this.f15609n);
            if (a > 0) {
                c37424e.mo60272b(this.f13961K > ((float) a) ? (float) a : this.f13961K);
            } else {
                c37424e.mo60272b(this.f13961K);
            }
        } else {
            c37424e.mo60272b(this.f13961K);
        }
        if (this.f15608m == C31005a.LINE_COLOR_ARGB) {
            c37424e.mo60276b(true);
            if (this.f15601f * 2.0f > this.f13961K) {
                this.f15601f = this.f13961K / 3.0f;
            }
            c37424e.mo60279c(this.f15601f);
        }
        int[] f = mo58924f();
        if (this.f15617v) {
            c37424e.mo60267a(d[1]);
            if (this.f15601f <= 0.0f || f == null || f.length <= 0) {
                c37424e.mo60277b(d[0]);
            } else {
                c37424e.mo60268a(d[0], f);
            }
        } else {
            c37424e.mo60267a(new int[]{0});
            if (this.f15601f <= 0.0f || f == null || f.length <= 0) {
                c37424e.mo60277b(new int[]{this.f13963M});
            } else {
                c37424e.mo60268a(new int[]{this.f13963M}, new int[]{f[0]});
            }
        }
        c37424e.mo60269a(this.f15612q);
        c37424e.mo60273b(this.f15615t);
        c37424e.mo60280c((int) this.f13964N);
        c37424e.mo60285e(this.f15616u);
        if (this.f15619y > 0 && this.f15619y <= 3) {
            c37424e.mo60264a(this.f15619y, this.f15620z);
        }
        c37424e.mo60286f(this.f15585A);
        c37424e.mo60270a(this.f15586B);
        c37424e.mo60283d(this.f15617v);
        c37424e.mo60274b(this.f15589E);
        c37424e.mo60275b(this.f15591G);
        c37424e.mo60284d(this.f13967Q);
        AppMethodBeat.m2505o(99778);
        return c37424e;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(99779);
        if (obj == null) {
            AppMethodBeat.m2505o(99779);
            return false;
        } else if (obj instanceof C36901ib) {
            boolean equals = TextUtils.equals(mo57757A(), ((C36901ib) obj).mo57757A());
            AppMethodBeat.m2505o(99779);
            return equals;
        } else {
            AppMethodBeat.m2505o(99779);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.m2504i(99780);
        int hashCode = mo57757A().hashCode();
        AppMethodBeat.m2505o(99780);
        return hashCode;
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
        AppMethodBeat.m2504i(99781);
        if (mo29443a()) {
            mo58918b(gl10);
            AppMethodBeat.m2505o(99781);
            return;
        }
        AppMethodBeat.m2505o(99781);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo58918b(GL10 gl10) {
        AppMethodBeat.m2504i(99782);
        if (this.f15602g == null || this.f15602g.mo75386b() == null) {
            AppMethodBeat.m2505o(99782);
            return false;
        } else if (this.f15611p == null || !this.f15611p.mo50394e()) {
            AppMethodBeat.m2505o(99782);
            return false;
        } else {
            this.f15611p.mo50393d();
            if (this.f15611p instanceof C31509ih) {
                this.f15600e = m61618c(this.f15599d);
                if (this.f15600e.size() >= 2) {
                    m61621k();
                }
            } else if (this.f15611p instanceof C41063ie) {
                m61621k();
            }
            this.f15602g.mo75386b().mo20154a();
            if (this.f15611p.mo50395f()) {
                this.f15611p.mo29510a(null);
                this.f15611p = null;
            }
            AppMethodBeat.m2505o(99782);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        AppMethodBeat.m2504i(99783);
        if (this.f15602g == null || this.f15602g.mo75386b() == null || !mo29443a()) {
            AppMethodBeat.m2505o(99783);
            return false;
        } else if (this.f15597b != null) {
            boolean a = this.f15597b.mo20130a(this.f15602g.mo75386b().mo20244t(), f, f2);
            AppMethodBeat.m2505o(99783);
            return a;
        } else {
            AppMethodBeat.m2505o(99783);
            return false;
        }
    }

    /* renamed from: a */
    public float mo58902a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        AppMethodBeat.m2504i(99784);
        float f = 0.0f;
        if (!(geoPoint == null || geoPoint2 == null || geoPoint == null)) {
            f = (float) (Math.hypot((double) (geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6()), (double) (geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6())) + 0.0d);
        }
        AppMethodBeat.m2505o(99784);
        return f;
    }

    /* renamed from: c */
    private ArrayList<GeoPoint> m61618c(List<C36902a> list) {
        AppMethodBeat.m2504i(99785);
        ArrayList<GeoPoint> arrayList = new ArrayList();
        if (list == null || list.size() < 2) {
            AppMethodBeat.m2505o(99785);
            return arrayList;
        }
        float f = this.f15613r.f15621a;
        float f2 = f - (this.f15614s * f);
        float f3 = f + ((this.f15618x - this.f15613r.f15621a) * this.f15614s);
        C36902a c36902a = null;
        int i = 0;
        while (i < list.size()) {
            C36902a c36902a2 = (C36902a) list.get(i);
            if (c36902a2.f15621a > f2 && c36902a2.f15621a < f3) {
                if (c36902a != null && c36902a.f15621a < f2) {
                    C36902a a = m61614a(c36902a, c36902a2, (f2 - c36902a.f15621a) / (c36902a2.f15621a - c36902a.f15621a));
                    a.f15622b = c36902a.f15622b;
                    arrayList.add(a);
                }
                arrayList.add(c36902a2);
            } else if (c36902a2.f15621a > f3) {
                if (c36902a != null && c36902a.f15621a < f3) {
                    C36902a a2 = m61614a(c36902a, c36902a2, (f3 - c36902a.f15621a) / (c36902a2.f15621a - c36902a.f15621a));
                    a2.f15622b = c36902a2.f15622b;
                    arrayList.add(a2);
                }
                AppMethodBeat.m2505o(99785);
                return arrayList;
            } else if (Float.compare(c36902a2.f15621a, f2) == 0 || Float.compare(c36902a2.f15621a, f3) == 0) {
                arrayList.add(c36902a2);
            }
            i++;
            c36902a = c36902a2;
        }
        AppMethodBeat.m2505o(99785);
        return arrayList;
    }

    /* renamed from: a */
    private C36902a m61614a(C36902a c36902a, C36902a c36902a2, float f) {
        AppMethodBeat.m2504i(99786);
        C36902a c36902a3 = new C36902a();
        int longitudeE6 = c36902a2.getLongitudeE6() - c36902a.getLongitudeE6();
        int latitudeE6 = c36902a2.getLatitudeE6() - c36902a.getLatitudeE6();
        c36902a3.setLatitudeE6(Math.round(((float) latitudeE6) * f) + c36902a.getLatitudeE6());
        c36902a3.setLongitudeE6(Math.round(((float) longitudeE6) * f) + c36902a.getLongitudeE6());
        c36902a3.f15621a = c36902a.f15621a + ((c36902a2.f15621a - c36902a.f15621a) * f);
        AppMethodBeat.m2505o(99786);
        return c36902a3;
    }

    /* renamed from: d */
    private int[][] m61619d(List<GeoPoint> list) {
        AppMethodBeat.m2504i(99787);
        int i;
        int e;
        int[][] iArr;
        if (this.f15604i == null || this.f15605j == null || list == null || this.f15604i.length == 0 || this.f15605j.length == 0 || list.isEmpty()) {
            i = this.f13963M;
            if (this.f15608m == C31005a.LINE_COLOR_TEXTURE) {
                e = m61620e(i);
            } else {
                e = i;
            }
            iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, 1});
            iArr[0][0] = e;
            iArr[1][0] = 0;
            AppMethodBeat.m2505o(99787);
            return iArr;
        }
        int i2;
        if (this.f15604i == null || this.f15605j == null) {
            e = 0;
        } else {
            e = Math.min(this.f15604i.length, this.f15605j.length);
        }
        int[] iArr2 = new int[e];
        for (i = 0; i < e; i++) {
            iArr2[i] = this.f15604i[i];
            if (this.f15608m == C31005a.LINE_COLOR_TEXTURE) {
                iArr2[i] = m61620e(iArr2[i]);
            }
        }
        TreeMap treeMap = new TreeMap();
        C36902a c36902a = (C36902a) list.get(0);
        int i3 = 1;
        while (i3 < e) {
            if (c36902a.f15622b <= this.f15605j[i3]) {
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
        C36902a c36902a2 = c36902a;
        int i4 = 1;
        int i5 = i2;
        while (i4 < list.size()) {
            c36902a = (C36902a) list.get(i4);
            i2 = i5;
            int i6 = i5;
            while (i2 < e && c36902a.f15622b > this.f15605j[i2] && c36902a2.f15622b <= this.f15605j[i2]) {
                treeMap.put(Integer.valueOf(i4 - 1), Integer.valueOf(iArr2[i2]));
                i6++;
                i2++;
            }
            c36902a2 = c36902a;
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
        AppMethodBeat.m2505o(99787);
        return iArr;
    }

    /* renamed from: a */
    private float m61609a(C36902a c36902a, C36902a c36902a2, GeoPoint geoPoint, C36902a c36902a3) {
        AppMethodBeat.m2504i(99788);
        int longitudeE6 = c36902a.getLongitudeE6();
        int latitudeE6 = c36902a.getLatitudeE6();
        int longitudeE62 = c36902a2.getLongitudeE6();
        int latitudeE62 = c36902a2.getLatitudeE6();
        int longitudeE63 = geoPoint.getLongitudeE6();
        int latitudeE63 = geoPoint.getLatitudeE6();
        float f = (float) (((longitudeE62 - longitudeE6) * (longitudeE63 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE63 - latitudeE6)));
        float hypot;
        if (f <= 0.0f) {
            c36902a3.setLatitudeE6(c36902a.getLatitudeE6());
            c36902a3.setLongitudeE6(c36902a.getLongitudeE6());
            c36902a3.f15621a = c36902a.f15621a;
            hypot = (float) Math.hypot((double) (longitudeE63 - longitudeE6), (double) (latitudeE63 - latitudeE6));
            AppMethodBeat.m2505o(99788);
            return hypot;
        }
        double d = (double) (((longitudeE62 - longitudeE6) * (longitudeE62 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE62 - latitudeE6)));
        if (((double) f) >= d) {
            c36902a3.setLatitudeE6(c36902a2.getLatitudeE6());
            c36902a3.setLongitudeE6(c36902a2.getLongitudeE6());
            c36902a3.f15621a = c36902a2.f15621a;
            hypot = (float) Math.hypot((double) (longitudeE63 - longitudeE62), (double) (latitudeE63 - latitudeE62));
            AppMethodBeat.m2505o(99788);
            return hypot;
        }
        f = (float) (((double) f) / d);
        hypot = (((float) (longitudeE62 - longitudeE6)) * f) + ((float) longitudeE6);
        float f2 = (((float) (latitudeE62 - latitudeE6)) * f) + ((float) latitudeE6);
        c36902a3.setLongitudeE6(Math.round(hypot));
        c36902a3.setLatitudeE6(Math.round(f2));
        c36902a3.f15621a = c36902a.f15621a + ((c36902a2.f15621a - c36902a.f15621a) * f);
        hypot = (float) Math.hypot((double) (((float) longitudeE63) - hypot), (double) (((float) latitudeE63) - f2));
        AppMethodBeat.m2505o(99788);
        return hypot;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        AppMethodBeat.m2504i(99789);
        if (mo57758B() == null) {
            boolean z = this.f13965O;
            AppMethodBeat.m2505o(99789);
            return z;
        } else if (this.f13965O && this.f15388I) {
            AppMethodBeat.m2505o(99789);
            return true;
        } else {
            AppMethodBeat.m2505o(99789);
            return false;
        }
    }

    /* renamed from: b */
    public void mo29445b() {
    }

    /* renamed from: c */
    public void mo29449c() {
        AppMethodBeat.m2504i(99790);
        m61621k();
        AppMethodBeat.m2505o(99790);
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(99791);
        m61622l();
        if (this.f15599d != null) {
            this.f15599d.clear();
            this.f15599d = null;
        }
        if (this.f15600e != null) {
            this.f15600e.clear();
            this.f15600e = null;
        }
        C17862b.m27957b(this.f15589E);
        if (!(this.f15609n == null || this.f15609n.mo65065a() == null)) {
            C17862b.m27957b(this.f15609n.mo65065a().mo12312a());
        }
        AppMethodBeat.m2505o(99791);
    }

    /* renamed from: a */
    public void mo58913a(int[] iArr, int[] iArr2) {
        AppMethodBeat.m2504i(99792);
        this.f15604i = iArr;
        this.f15605j = iArr2;
        this.f15608m = m61612a(C31005a.LINE_COLOR_NONE);
        AppMethodBeat.m2505o(99792);
    }

    /* renamed from: e */
    public int[][] mo58922e() {
        if (this.f15604i == null || this.f15605j == null || this.f15604i.length != this.f15605j.length) {
            return null;
        }
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, this.f15604i.length});
        iArr[0] = this.f15604i;
        iArr[1] = this.f15605j;
        return iArr;
    }

    /* renamed from: f */
    public int[] mo58924f() {
        return this.f15606k;
    }

    /* renamed from: g */
    public void mo58925g() {
        AppMethodBeat.m2504i(99793);
        if (this.f15597b == null) {
            AppMethodBeat.m2505o(99793);
            return;
        }
        this.f15597b.mo72985p();
        AppMethodBeat.m2505o(99793);
    }

    /* renamed from: a */
    public void mo58904a(int i, int i2) {
        AppMethodBeat.m2504i(99794);
        if (this.f15597b == null) {
            AppMethodBeat.m2505o(99794);
            return;
        }
        this.f15597b.mo72985p();
        this.f15597b.mo72967a(i, i2);
        m61621k();
        AppMethodBeat.m2505o(99794);
    }

    /* renamed from: r */
    public boolean mo57761r() {
        return true;
    }

    /* renamed from: a */
    public void mo58909a(C31003dl c31003dl) {
        this.f15598c = c31003dl;
    }

    /* renamed from: h */
    public C31003dl mo58926h() {
        return this.f15598c;
    }

    /* renamed from: a */
    public void mo58903a(float f) {
        this.f15612q = f;
    }

    /* renamed from: a */
    public void mo58905a(int i, C24343db c24343db) {
        AppMethodBeat.m2504i(99795);
        GeoPoint a = C36520ic.m60470a(c24343db);
        if (i == -1 || a == null) {
            AppMethodBeat.m2505o(99795);
            return;
        }
        this.f15587C = i;
        this.f15588D = a;
        mo29449c();
        AppMethodBeat.m2505o(99795);
    }

    /* renamed from: d */
    public void mo58920d(boolean z) {
        AppMethodBeat.m2504i(99796);
        this.f15585A = z;
        if (this.f15597b != null) {
            this.f15597b.mo72970a(z);
        }
        AppMethodBeat.m2505o(99796);
    }

    /* renamed from: e */
    public void mo58921e(boolean z) {
        this.f15586B = z;
    }

    /* renamed from: b */
    public void mo58916b(List<Integer> list) {
        this.f15591G = list;
    }

    /* renamed from: b */
    public void mo58914b(float f) {
        this.f15601f = f;
    }

    /* renamed from: i */
    public Rect mo58928i() {
        AppMethodBeat.m2504i(99797);
        Rect u = this.f15597b.mo72990u();
        AppMethodBeat.m2505o(99797);
        return u;
    }

    /* renamed from: a */
    public void mo58911a(C31056if c31056if) {
        AppMethodBeat.m2504i(99798);
        if (this.f15611p != null) {
            this.f15611p.mo50391b();
            this.f15611p.mo29510a(null);
        }
        if (c31056if instanceof C31509ih) {
            m61616a((C31509ih) c31056if);
            AppMethodBeat.m2505o(99798);
        } else if (c31056if instanceof C41063ie) {
            m61615a((C41063ie) c31056if);
            AppMethodBeat.m2505o(99798);
        } else {
            this.f15611p = null;
            AppMethodBeat.m2505o(99798);
        }
    }

    /* renamed from: a */
    private void m61616a(C31509ih c31509ih) {
        AppMethodBeat.m2504i(99799);
        if (this.f15602g == null || this.f15602g.mo75386b() == null) {
            AppMethodBeat.m2505o(99799);
            return;
        }
        this.f15611p = c31509ih;
        this.f15613r = m61613a(C36520ic.m60470a(c31509ih.mo29513g()));
        if (this.f15613r == null) {
            RuntimeException runtimeException = new RuntimeException("Error, start point not found.");
            AppMethodBeat.m2505o(99799);
            throw runtimeException;
        }
        c31509ih.mo29510a(this.f15595T);
        c31509ih.mo29512a(null, null);
        this.f15602g.mo75386b().mo20154a();
        AppMethodBeat.m2505o(99799);
    }

    /* renamed from: a */
    private void m61615a(C41063ie c41063ie) {
        AppMethodBeat.m2504i(99800);
        this.f15611p = c41063ie;
        this.f15611p.mo29510a(this.f15595T);
        this.f15611p.mo29512a(null, null);
        if (!(this.f15602g == null || this.f15602g.mo75386b() == null)) {
            this.f15602g.mo75386b().mo20154a();
        }
        AppMethodBeat.m2505o(99800);
    }

    /* renamed from: a */
    private C36902a m61613a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99801);
        float f = Float.MAX_VALUE;
        C36902a c36902a = null;
        C36902a c36902a2 = new C36902a();
        if (!(this.f15599d == null || this.f15599d.size() < 2 || geoPoint == null)) {
            int i = 1;
            C36902a c36902a3 = (C36902a) this.f15599d.get(0);
            while (i < this.f15599d.size()) {
                C36902a c36902a4;
                C36902a c36902a5 = (C36902a) this.f15599d.get(i);
                float a = m61609a(c36902a3, c36902a5, geoPoint, c36902a2);
                if (a < f) {
                    c36902a4 = new C36902a();
                    c36902a = c36902a2;
                } else {
                    c36902a4 = c36902a2;
                    a = f;
                }
                i++;
                c36902a3 = c36902a5;
                c36902a2 = c36902a4;
                f = a;
            }
        }
        AppMethodBeat.m2505o(99801);
        return c36902a;
    }

    /* renamed from: j */
    public C45135d mo58929j() {
        return this.f15597b;
    }

    /* renamed from: a */
    private int m61611a(Context context, C41018cm c41018cm) {
        AppMethodBeat.m2504i(99802);
        if (context == null || c41018cm == null) {
            AppMethodBeat.m2505o(99802);
            return 0;
        }
        Bitmap a = c41018cm.mo65064a(context);
        if (a == null) {
            AppMethodBeat.m2505o(99802);
            return 0;
        }
        int height = a.getHeight();
        if (height <= 0) {
            AppMethodBeat.m2505o(99802);
            return 0;
        }
        int pow = (int) ((Math.pow(2.0d, 25.0d) / Math.pow((double) height, 2.0d)) / ((double) SystemUtil.getDensity(context)));
        AppMethodBeat.m2505o(99802);
        return pow;
    }
}
