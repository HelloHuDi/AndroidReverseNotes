package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.element.C41718k;
import com.tencent.map.lib.element.C44680l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16263gj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24374fw;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bo */
public class C46754bo extends C41718k {
    /* renamed from: c */
    private static int f18035c = 0;
    /* renamed from: a */
    private CopyOnWriteArrayList<C44483a> f18036a;
    /* renamed from: b */
    private Context f18037b;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.bo$a */
    class C44483a {
        /* renamed from: a */
        final /* synthetic */ C46754bo f17339a;
        /* renamed from: b */
        private C5840co f17340b;
        /* renamed from: c */
        private C44680l f17341c;
        /* renamed from: d */
        private Bitmap[] f17342d;

        /* renamed from: a */
        public boolean mo70697a() {
            AppMethodBeat.m2504i(100843);
            boolean h = this.f17340b.mo12322h();
            AppMethodBeat.m2505o(100843);
            return h;
        }

        /* renamed from: b */
        public int mo70698b() {
            AppMethodBeat.m2504i(100844);
            if (this.f17340b == null) {
                AppMethodBeat.m2505o(100844);
                return 0;
            }
            int g = this.f17340b.mo12321g();
            AppMethodBeat.m2505o(100844);
            return g;
        }

        /* renamed from: c */
        public C44680l mo70699c() {
            return this.f17341c;
        }

        /* renamed from: a */
        public C44680l mo70696a(C24374fw c24374fw, C44484b c44484b) {
            AppMethodBeat.m2504i(100845);
            C44490de a = this.f17340b.mo12315a();
            C24343db f = this.f17340b.mo12320f();
            if (f == null) {
                f = a.mo70745e();
            }
            if (f == null) {
                AppMethodBeat.m2505o(100845);
                return null;
            }
            int a2;
            int b;
            int i;
            float q;
            float r;
            double d;
            double d2;
            DoublePoint b2 = c24374fw.mo29298b(C46754bo.m88640a(this.f17339a, f));
            if (a != null) {
                a2 = a.mo70726a(this.f17339a.f18037b);
                b = a.mo70736b(this.f17339a.f18037b);
                i = a2;
            } else {
                a2 = this.f17340b.mo12316b();
                b = this.f17340b.mo12317c();
                i = a2;
            }
            if (a != null) {
                q = a.mo70759q();
                r = a.mo70760r();
            } else {
                q = this.f17340b.mo12318d();
                r = this.f17340b.mo12319e();
            }
            if (q >= 0.0f && q <= 1.0f) {
                b2.f2800x -= (((double) q) - 0.5d) * ((double) i);
            }
            if (r >= 0.0f && r <= 1.0f) {
                b2.f2801y -= (((double) r) - 0.5d) * ((double) b);
            }
            Bitmap bitmap = this.f17342d[c44484b.ordinal()];
            int width = bitmap.getWidth() / 2;
            a2 = (bitmap.getHeight() / 2) + (b / 2);
            if (c44484b == C44484b.LEFT_TOP) {
                d = b2.f2800x - ((double) width);
                d2 = b2.f2801y - ((double) a2);
            } else if (c44484b == C44484b.RIGHT_TOP) {
                d = b2.f2800x + ((double) width);
                d2 = b2.f2801y - ((double) a2);
            } else if (c44484b == C44484b.RIGHT_BOTTOM) {
                d = b2.f2800x + ((double) width);
                d2 = ((double) a2) + b2.f2801y;
            } else {
                d = b2.f2800x - ((double) width);
                d2 = ((double) a2) + b2.f2801y;
            }
            this.f17341c.mo71710a(c24374fw.mo29297a(new DoublePoint(d, d2)));
            this.f17341c.mo71712a(m80538a(c44484b), bitmap);
            C44680l c44680l = this.f17341c;
            AppMethodBeat.m2505o(100845);
            return c44680l;
        }

        /* renamed from: a */
        private String m80538a(C44484b c44484b) {
            AppMethodBeat.m2504i(100846);
            String obj = toString();
            if (c44484b == C44484b.LEFT_TOP) {
                obj = "b_lt_".concat(String.valueOf(obj));
                AppMethodBeat.m2505o(100846);
                return obj;
            } else if (c44484b == C44484b.RIGHT_TOP) {
                obj = "b_rt_".concat(String.valueOf(obj));
                AppMethodBeat.m2505o(100846);
                return obj;
            } else if (c44484b == C44484b.RIGHT_BOTTOM) {
                obj = "b_rb_".concat(String.valueOf(obj));
                AppMethodBeat.m2505o(100846);
                return obj;
            } else {
                obj = "b_lb_".concat(String.valueOf(obj));
                AppMethodBeat.m2505o(100846);
                return obj;
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.bo$b */
    public enum C44484b {
        LEFT_TOP,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        LEFT_BOTTOM;

        static {
            AppMethodBeat.m2505o(100849);
        }
    }

    /* renamed from: a */
    static /* synthetic */ GeoPoint m88640a(C46754bo c46754bo, C24343db c24343db) {
        AppMethodBeat.m2504i(100857);
        GeoPoint a = c46754bo.m88641a(c24343db);
        AppMethodBeat.m2505o(100857);
        return a;
    }

    /* renamed from: e */
    public synchronized void mo75307e() {
        AppMethodBeat.m2504i(100850);
        this.f18036a.clear();
        mo20135d();
        AppMethodBeat.m2505o(100850);
    }

    /* renamed from: f */
    public synchronized void mo75308f() {
        AppMethodBeat.m2504i(100851);
        Iterator it = this.f18036a.iterator();
        while (it.hasNext()) {
            C44483a c44483a = (C44483a) it.next();
            if (c44483a != null && c44483a.mo70697a()) {
                this.f18036a.remove(c44483a);
                mo20133b(c44483a.mo70699c());
            }
        }
        AppMethodBeat.m2505o(100851);
    }

    /* renamed from: b */
    public synchronized void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
        AppMethodBeat.m2504i(100852);
        m88644b(c24374fw);
        super.mo20132b(c16263gj, c24374fw);
        AppMethodBeat.m2505o(100852);
    }

    /* renamed from: a */
    public synchronized boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(100853);
        int c = mo20134c();
        int i = 0;
        while (i < c) {
            C44680l c44680l = (C44680l) mo20126a(i);
            if (c44680l.mo20130a(c24374fw, f, f2)) {
                if (i < c - 1 && mo20133b(c44680l)) {
                    mo20127a((C41717j) c44680l);
                }
                z = true;
                AppMethodBeat.m2505o(100853);
            } else {
                i++;
            }
        }
        AppMethodBeat.m2505o(100853);
        z = false;
        return z;
    }

    /* renamed from: b */
    private void m88644b(C24374fw c24374fw) {
        AppMethodBeat.m2504i(100854);
        if (this.f18036a == null || this.f18036a.isEmpty()) {
            AppMethodBeat.m2505o(100854);
            return;
        }
        int size = this.f18036a.size();
        int ordinal = C44484b.LEFT_BOTTOM.ordinal();
        C44484b[] c44484bArr = new C44484b[size];
        for (int i = 0; i < size; i++) {
            c44484bArr[i] = C44484b.LEFT_TOP;
        }
        for (int i2 = 0; i2 < size; i2++) {
            C44483a c44483a = (C44483a) this.f18036a.get(i2);
            C44680l c = c44483a.mo70699c();
            c44483a.mo70696a(c24374fw, c44484bArr[i2]);
            for (int i3 = i2 + 1; i3 < size; i3++) {
                C44483a c44483a2 = (C44483a) this.f18036a.get(i3);
                C44680l c2 = c44483a2.mo70699c();
                c44483a2.mo70696a(c24374fw, c44484bArr[i3]);
                int ordinal2;
                C44484b b;
                if (c44483a.mo70698b() > c44483a2.mo70698b()) {
                    for (ordinal2 = c44484bArr[i2].ordinal() - 1; ordinal2 < ordinal; ordinal2++) {
                        b = m88643b(ordinal2);
                        c44483a2.mo70696a(c24374fw, b);
                        c44484bArr[i2] = b;
                        if (!m88642a(c24374fw, c, c2)) {
                            break;
                        }
                    }
                } else {
                    for (ordinal2 = c44484bArr[i3].ordinal(); ordinal2 <= ordinal; ordinal2++) {
                        b = m88643b(ordinal2);
                        c44483a2.mo70696a(c24374fw, b);
                        c44484bArr[i3] = b;
                        if (!m88642a(c24374fw, c, c2)) {
                            break;
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(100854);
    }

    /* renamed from: a */
    private boolean m88642a(C24374fw c24374fw, C44680l c44680l, C44680l c44680l2) {
        AppMethodBeat.m2504i(100855);
        Rect a = c44680l.mo20125a(c24374fw);
        Rect a2 = c44680l2.mo20125a(c24374fw);
        if (a == null || a2 == null) {
            AppMethodBeat.m2505o(100855);
            return false;
        }
        boolean intersects = Rect.intersects(a, a2);
        AppMethodBeat.m2505o(100855);
        return intersects;
    }

    /* renamed from: b */
    private C44484b m88643b(int i) {
        switch (i) {
            case 0:
                return C44484b.LEFT_TOP;
            case 1:
                return C44484b.RIGHT_TOP;
            case 2:
                return C44484b.RIGHT_BOTTOM;
            default:
                return C44484b.LEFT_BOTTOM;
        }
    }

    /* renamed from: a */
    private GeoPoint m88641a(C24343db c24343db) {
        AppMethodBeat.m2504i(100856);
        if (c24343db == null) {
            AppMethodBeat.m2505o(100856);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint((int) (c24343db.f4615a * 1000000.0d), (int) (c24343db.f4616b * 1000000.0d));
        AppMethodBeat.m2505o(100856);
        return geoPoint;
    }
}
