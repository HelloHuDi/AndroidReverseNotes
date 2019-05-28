package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gs */
public class C24382gs implements Cloneable {
    /* renamed from: a */
    private int f4706a = -1;
    /* renamed from: b */
    private C24383a f4707b = new C24383a();
    /* renamed from: c */
    private Rect f4708c = new Rect();
    /* renamed from: d */
    private int f4709d;
    /* renamed from: e */
    private double f4710e;
    /* renamed from: f */
    private double f4711f;
    /* renamed from: g */
    private double f4712g = 0.0d;
    /* renamed from: h */
    private double f4713h = 1.0d;
    /* renamed from: i */
    private double f4714i = 0.0d;
    /* renamed from: j */
    private double f4715j = 1.0d;
    /* renamed from: k */
    private double f4716k = 0.0d;
    /* renamed from: l */
    private double f4717l = 1.0d;
    /* renamed from: m */
    private GeoPoint f4718m = new GeoPoint();
    /* renamed from: n */
    private Rect f4719n;
    /* renamed from: o */
    private C46789gm f4720o;
    /* renamed from: p */
    private C16238gh f4721p;
    /* renamed from: q */
    private Integer f4722q = Integer.valueOf(0);
    /* renamed from: r */
    private DoublePoint f4723r = new DoublePoint();
    /* renamed from: s */
    private C24380b f4724s;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gs$b */
    public static class C24380b {
        /* renamed from: a */
        private float f4700a = 0.0f;
        /* renamed from: b */
        private float f4701b = 0.0f;

        public C24380b(float f, float f2) {
            this.f4700a = f;
            this.f4701b = f2;
        }

        /* renamed from: a */
        public void mo40589a(float f, float f2) {
            this.f4700a = f;
            this.f4701b = f2;
        }

        /* renamed from: a */
        public float mo40588a() {
            return this.f4700a;
        }

        /* renamed from: b */
        public float mo40590b() {
            return this.f4701b;
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gs$c */
    public enum C24381c {
        NO_CHANGED,
        SCALE_CHANGED,
        SCALE_LEVEL_CHANGED;

        static {
            AppMethodBeat.m2505o(99454);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gs$a */
    public static class C24383a implements Cloneable {
        /* renamed from: a */
        private float f4725a = 3.0517578E-5f;
        /* renamed from: b */
        private float f4726b = 4.0f;
        /* renamed from: c */
        private int f4727c = 3;
        /* renamed from: d */
        private int f4728d = 20;
        /* renamed from: e */
        private float f4729e;
        /* renamed from: f */
        private int f4730f;

        /* renamed from: a */
        public void mo40631a(float f) {
            this.f4729e = f;
        }

        /* renamed from: a */
        public void mo40632a(int i, float f) {
            this.f4729e = f;
            this.f4730f = i;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo40633a(C24383a c24383a) {
            this.f4725a = c24383a.f4725a;
            this.f4726b = c24383a.f4726b;
            this.f4727c = c24383a.f4727c;
            this.f4728d = c24383a.f4728d;
            this.f4729e = c24383a.f4729e;
            this.f4730f = c24383a.f4730f;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public void mo40635b(float f) {
            AppMethodBeat.m2504i(99447);
            C24383a c24383a = new C24383a();
            this.f4727c = c24383a.mo40634b();
            this.f4725a = f / c24383a.mo40637c();
            AppMethodBeat.m2505o(99447);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public float mo40630a(int i) {
            return 1.9073486E-6f * ((float) (1 << (i - 1)));
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public float mo40629a() {
            return this.f4729e;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public int mo40634b() {
            return this.f4730f;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: c */
        public float mo40637c() {
            AppMethodBeat.m2504i(99448);
            float a = this.f4729e / mo40630a(this.f4730f);
            AppMethodBeat.m2505o(99448);
            return a;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: d */
        public int mo40639d() {
            return this.f4727c;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: e */
        public int mo40640e() {
            return this.f4728d;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: f */
        public int mo40642f() {
            return 20;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public void mo40636b(int i) {
            this.f4728d = i;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: g */
        public float mo40643g() {
            return this.f4725a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C24383a)) {
                return false;
            }
            C24383a c24383a = (C24383a) obj;
            if (this.f4729e == c24383a.f4729e && this.f4730f == c24383a.f4730f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            AppMethodBeat.m2504i(99449);
            int hashCode = toString().hashCode();
            AppMethodBeat.m2505o(99449);
            return hashCode;
        }

        public String toString() {
            AppMethodBeat.m2504i(99450);
            String str = "scale:" + this.f4729e + ", scaleLevel:" + this.f4730f;
            AppMethodBeat.m2505o(99450);
            return str;
        }

        public Object clone() {
            AppMethodBeat.m2504i(99451);
            Object clone = super.clone();
            AppMethodBeat.m2505o(99451);
            return clone;
        }
    }

    public C24382gs(C46789gm c46789gm) {
        AppMethodBeat.m2504i(99455);
        this.f4720o = c46789gm;
        this.f4721p = c46789gm.mo12445f();
        AppMethodBeat.m2505o(99455);
    }

    /* renamed from: a */
    public void mo40596a(C24382gs c24382gs) {
        AppMethodBeat.m2504i(99456);
        this.f4706a = c24382gs.f4706a;
        this.f4707b.mo40633a(c24382gs.f4707b);
        this.f4708c.set(c24382gs.f4708c);
        this.f4709d = c24382gs.f4709d;
        this.f4710e = c24382gs.f4710e;
        this.f4711f = c24382gs.f4711f;
        this.f4712g = c24382gs.f4712g;
        this.f4713h = c24382gs.f4713h;
        this.f4714i = c24382gs.f4714i;
        this.f4715j = c24382gs.f4715j;
        this.f4716k = c24382gs.f4716k;
        this.f4717l = c24382gs.f4717l;
        this.f4718m.setGeoPoint(c24382gs.f4718m);
        this.f4723r.set(c24382gs.f4723r.f2800x, c24382gs.f4723r.f2801y);
        this.f4719n = c24382gs.f4719n;
        AppMethodBeat.m2505o(99456);
    }

    /* renamed from: a */
    public void mo40595a(Rect rect, int i, int i2, int i3) {
        AppMethodBeat.m2504i(99457);
        this.f4719n = rect;
        this.f4708c = C31049gi.m49906a(2);
        mo40604b(i3);
        mo40598a(0);
        mo40600a(i, i2, false);
        AppMethodBeat.m2505o(99457);
    }

    /* renamed from: a */
    public void mo40592a() {
        AppMethodBeat.m2504i(99458);
        if (this.f4720o == null) {
            AppMethodBeat.m2505o(99458);
            return;
        }
        this.f4718m = this.f4721p.mo29404q();
        int s = this.f4721p.mo29406s();
        float r = this.f4721p.mo29405r();
        if (s != mo40619j()) {
            this.f4720o.mo12440a().mo58808a(C24381c.SCALE_LEVEL_CHANGED);
        } else if (r != mo40618i()) {
            this.f4720o.mo12440a().mo58808a(C24381c.SCALE_CHANGED);
        }
        if (this.f4707b != null) {
            this.f4707b.mo40632a(s, r);
        }
        this.f4706a = this.f4721p.mo29412y();
        AppMethodBeat.m2505o(99458);
    }

    /* renamed from: a */
    public boolean mo40598a(int i) {
        AppMethodBeat.m2504i(99459);
        if (this.f4721p == null) {
            AppMethodBeat.m2505o(99459);
            return false;
        }
        int y = this.f4721p.mo29412y();
        if (y == i) {
            AppMethodBeat.m2505o(99459);
            return false;
        }
        if (y == 11) {
            this.f4720o.mo75443c(false);
        }
        if (i == 11) {
            this.f4720o.mo75443c(true);
        }
        this.f4706a = i;
        this.f4721p.mo29364c(i, m37777b(y, i));
        AppMethodBeat.m2505o(99459);
        return true;
    }

    /* renamed from: b */
    public int mo40603b() {
        AppMethodBeat.m2504i(99460);
        int i;
        if (this.f4721p == null) {
            i = this.f4706a;
            AppMethodBeat.m2505o(99460);
            return i;
        }
        i = this.f4721p.mo29412y();
        AppMethodBeat.m2505o(99460);
        return i;
    }

    /* renamed from: a */
    public float mo40591a(float f) {
        AppMethodBeat.m2504i(99461);
        if (this.f4721p.mo29411x() == f) {
            AppMethodBeat.m2505o(99461);
            return f;
        }
        float f2 = f % 360.0f;
        double toRadians = Math.toRadians((double) f);
        this.f4712g = Math.sin(toRadians);
        this.f4713h = Math.cos(toRadians);
        if (this.f4721p != null) {
            this.f4721p.mo29320a(f2);
        }
        AppMethodBeat.m2505o(99461);
        return f2;
    }

    /* renamed from: c */
    public float mo40605c() {
        AppMethodBeat.m2504i(99462);
        float x = this.f4721p.mo29411x();
        AppMethodBeat.m2505o(99462);
        return x;
    }

    /* renamed from: b */
    public float mo40602b(float f) {
        AppMethodBeat.m2504i(99463);
        if (this.f4721p.mo29410w() == f) {
            AppMethodBeat.m2505o(99463);
            return f;
        }
        float max = Math.max(0.0f, Math.min(40.0f, f));
        double toRadians = Math.toRadians((double) f);
        this.f4714i = Math.sin(toRadians);
        this.f4715j = Math.cos(toRadians);
        toRadians = 1.5707963267948966d - toRadians;
        this.f4717l = Math.cos(toRadians);
        this.f4716k = Math.sin(toRadians);
        if (this.f4721p != null) {
            this.f4721p.mo29350b(max);
        }
        AppMethodBeat.m2505o(99463);
        return max;
    }

    /* renamed from: d */
    public float mo40609d() {
        AppMethodBeat.m2504i(99464);
        float w = this.f4721p.mo29410w();
        AppMethodBeat.m2505o(99464);
        return w;
    }

    /* renamed from: c */
    public C24381c mo40606c(float f) {
        float r;
        int s;
        C24381c c24381c;
        AppMethodBeat.m2504i(99465);
        C24381c c24381c2 = C24381c.NO_CHANGED;
        float a = this.f4707b.mo40629a();
        int b = this.f4707b.mo40634b();
        if (this.f4721p != null) {
            this.f4721p.mo29319a((double) f, false);
            r = this.f4721p.mo29405r();
            s = this.f4721p.mo29406s();
        } else {
            s = b;
            r = a;
        }
        this.f4707b.mo40632a(s, r);
        if (s != b) {
            c24381c = C24381c.SCALE_LEVEL_CHANGED;
        } else if (r != a) {
            c24381c = C24381c.SCALE_CHANGED;
        } else {
            c24381c = c24381c2;
        }
        switch (c24381c) {
            case SCALE_LEVEL_CHANGED:
                m37778d(this.f4707b.mo40634b());
                break;
        }
        DoublePoint a2 = C16230fp.m24761a(this, mo40625p());
        this.f4723r.set(a2.f2800x, a2.f2801y);
        AppMethodBeat.m2505o(99465);
        return c24381c;
    }

    /* renamed from: e */
    public void mo40611e() {
        AppMethodBeat.m2504i(99466);
        m37778d(this.f4707b.mo40634b());
        DoublePoint a = C16230fp.m24761a(this, mo40625p());
        this.f4723r.set(a.f2800x, a.f2801y);
        AppMethodBeat.m2505o(99466);
    }

    /* renamed from: d */
    public C24381c mo40610d(float f) {
        AppMethodBeat.m2504i(99467);
        if (this.f4721p != null) {
            this.f4721p.mo29318a((double) f);
        }
        this.f4707b.mo40631a(f);
        C24381c c24381c = C24381c.SCALE_LEVEL_CHANGED;
        AppMethodBeat.m2505o(99467);
        return c24381c;
    }

    /* renamed from: d */
    private void m37778d(int i) {
        double d = (double) ((1 << i) * 256);
        this.f4709d = (int) d;
        this.f4710e = d / 360.0d;
        this.f4711f = d / 6.283185307179586d;
    }

    /* renamed from: b */
    public boolean mo40604b(int i) {
        AppMethodBeat.m2504i(99468);
        if (mo40606c(this.f4707b.mo40630a(i)) == C24381c.SCALE_LEVEL_CHANGED) {
            AppMethodBeat.m2505o(99468);
            return true;
        }
        AppMethodBeat.m2505o(99468);
        return false;
    }

    /* renamed from: f */
    public int mo40614f() {
        return this.f4709d;
    }

    /* renamed from: g */
    public double mo40615g() {
        return this.f4710e;
    }

    /* renamed from: h */
    public double mo40616h() {
        return this.f4711f;
    }

    /* renamed from: i */
    public float mo40618i() {
        AppMethodBeat.m2504i(99469);
        float a = this.f4707b.mo40629a();
        AppMethodBeat.m2505o(99469);
        return a;
    }

    /* renamed from: j */
    public int mo40619j() {
        AppMethodBeat.m2504i(99470);
        int b = this.f4707b.mo40634b();
        AppMethodBeat.m2505o(99470);
        return b;
    }

    /* renamed from: k */
    public float mo40620k() {
        AppMethodBeat.m2504i(99471);
        float c = this.f4707b.mo40637c();
        AppMethodBeat.m2505o(99471);
        return c;
    }

    /* renamed from: l */
    public int mo40621l() {
        AppMethodBeat.m2504i(99472);
        int d = this.f4707b.mo40639d();
        AppMethodBeat.m2505o(99472);
        return d;
    }

    /* renamed from: m */
    public int mo40622m() {
        AppMethodBeat.m2504i(99473);
        int e = this.f4707b.mo40640e();
        AppMethodBeat.m2505o(99473);
        return e;
    }

    /* renamed from: n */
    public int mo40623n() {
        AppMethodBeat.m2504i(99474);
        int f = this.f4707b.mo40642f();
        AppMethodBeat.m2505o(99474);
        return f;
    }

    /* renamed from: c */
    public void mo40607c(int i) {
        AppMethodBeat.m2504i(99475);
        this.f4707b.mo40636b(i);
        AppMethodBeat.m2505o(99475);
    }

    /* renamed from: o */
    public float mo40624o() {
        AppMethodBeat.m2504i(99476);
        float g = this.f4707b.mo40643g();
        AppMethodBeat.m2505o(99476);
        return g;
    }

    /* renamed from: e */
    public void mo40612e(float f) {
        AppMethodBeat.m2504i(99477);
        this.f4707b.mo40635b(f);
        AppMethodBeat.m2505o(99477);
    }

    /* renamed from: a */
    public void mo40594a(Rect rect) {
        AppMethodBeat.m2504i(99478);
        this.f4708c.set(rect);
        AppMethodBeat.m2505o(99478);
    }

    /* renamed from: a */
    public boolean mo40601a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99479);
        boolean a = mo40599a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        AppMethodBeat.m2505o(99479);
        return a;
    }

    /* renamed from: a */
    public boolean mo40600a(int i, int i2, boolean z) {
        int i3;
        int width;
        boolean z2 = false;
        AppMethodBeat.m2504i(99480);
        if ((1 << (20 - mo40619j())) < 0) {
            i3 = 0;
        } else {
            i3 = 20 - mo40619j();
        }
        if (WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT > i3) {
            width = ((this.f4719n.width() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (this.f4719n.width() * i3)) / 2;
            i3 = ((this.f4719n.height() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (i3 * this.f4719n.height())) / 2;
        } else {
            i3 = 0;
            width = 0;
        }
        int i4 = this.f4708c.left - width;
        width += this.f4708c.right;
        int i5 = this.f4708c.top - i3;
        i3 += this.f4708c.bottom;
        if (i >= i5) {
            i5 = i;
        }
        if (i5 > i3) {
            i5 = i3;
        }
        if (i2 < i4) {
            i3 = i4;
        } else {
            i3 = i2;
        }
        if (i3 > width) {
            i3 = width;
        }
        if (!(i5 == this.f4718m.getLatitudeE6() && i3 == this.f4718m.getLongitudeE6())) {
            z2 = true;
        }
        this.f4718m.setLatitudeE6(i5);
        this.f4718m.setLongitudeE6(i3);
        DoublePoint a = C16230fp.m24761a(this, this.f4718m);
        mo40593a(a.f2800x, a.f2801y);
        this.f4721p.mo29331a(this.f4718m, z);
        AppMethodBeat.m2505o(99480);
        return z2;
    }

    /* renamed from: a */
    public boolean mo40599a(int i, int i2) {
        int width;
        int i3;
        AppMethodBeat.m2504i(99481);
        int j = 1 << (20 - mo40619j());
        if (WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT > j) {
            width = ((this.f4719n.width() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (this.f4719n.width() * j)) / 2;
            j = ((this.f4719n.height() * WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) - (j * this.f4719n.height())) / 2;
            i3 = width;
        } else {
            j = 0;
            i3 = 0;
        }
        int i4 = this.f4708c.left - i3;
        width = this.f4708c.right + i3;
        i3 = this.f4708c.top - j;
        j += this.f4708c.bottom;
        if (i >= i3) {
            i3 = i;
        }
        if (i3 > j) {
            i3 = j;
        }
        if (i2 < i4) {
            j = i4;
        } else {
            j = i2;
        }
        if (j > width) {
            j = width;
        }
        this.f4721p.mo29373d(new GeoPoint(i3, j));
        AppMethodBeat.m2505o(99481);
        return true;
    }

    /* renamed from: a */
    public void mo40593a(double d, double d2) {
        AppMethodBeat.m2504i(99482);
        this.f4723r.set(d, d2);
        AppMethodBeat.m2505o(99482);
    }

    /* renamed from: p */
    public GeoPoint mo40625p() {
        return this.f4718m;
    }

    /* renamed from: a */
    public boolean mo40597a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(99483);
        if (this.f4724s == null) {
            this.f4724s = new C24380b(f, f2);
        } else {
            this.f4724s.mo40589a(f, f2);
        }
        this.f4720o.mo75410a(f, f2, z);
        AppMethodBeat.m2505o(99483);
        return true;
    }

    /* renamed from: q */
    public C24380b mo40626q() {
        return this.f4724s;
    }

    /* renamed from: r */
    public byte[] mo40627r() {
        return null;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(99484);
        int hashCode = toString().hashCode();
        AppMethodBeat.m2505o(99484);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(99485);
        if (obj instanceof C24382gs) {
            C24382gs c24382gs = (C24382gs) obj;
            if (!c24382gs.f4718m.equals(this.f4718m)) {
                AppMethodBeat.m2505o(99485);
                return false;
            } else if (!c24382gs.f4707b.equals(this.f4707b)) {
                AppMethodBeat.m2505o(99485);
                return false;
            } else if (c24382gs.f4706a != this.f4706a) {
                AppMethodBeat.m2505o(99485);
                return false;
            } else {
                AppMethodBeat.m2505o(99485);
                return true;
            }
        }
        AppMethodBeat.m2505o(99485);
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(99486);
        StringBuilder stringBuilder = new StringBuilder();
        GeoPoint p = mo40625p();
        stringBuilder.append("mapParam: ");
        stringBuilder.append("center:" + p.toString() + " ");
        stringBuilder.append("mode:" + this.f4706a + " ");
        stringBuilder.append("mapScale:" + this.f4707b.toString() + " ");
        stringBuilder.append("screenRect:" + this.f4719n.toString() + " ");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(99486);
        return stringBuilder2;
    }

    public Object clone() {
        AppMethodBeat.m2504i(99487);
        C24382gs c24382gs = (C24382gs) super.clone();
        c24382gs.f4708c = new Rect(this.f4708c);
        c24382gs.f4707b = (C24383a) this.f4707b.clone();
        c24382gs.f4718m = new GeoPoint(this.f4718m);
        c24382gs.f4723r = new DoublePoint(this.f4723r.f2800x, this.f4723r.f2801y);
        AppMethodBeat.m2505o(99487);
        return c24382gs;
    }

    /* renamed from: b */
    private boolean m37777b(int i, int i2) {
        if (i == i2) {
            return true;
        }
        if (i == 11 && i2 != 13) {
            return false;
        }
        if (i == 13 && i2 != 11) {
            return false;
        }
        if (i2 == 11 && i != 13) {
            return false;
        }
        if (i2 != 13 || i == 11) {
            return true;
        }
        return false;
    }
}
