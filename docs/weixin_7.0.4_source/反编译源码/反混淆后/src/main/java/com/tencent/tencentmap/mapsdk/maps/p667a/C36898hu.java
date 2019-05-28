package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.C45133b;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C5844cr;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hu */
public class C36898hu extends C36519hz implements C41717j {
    /* renamed from: a */
    private GeoPoint f15529a = new GeoPoint(39909230, 116397428);
    /* renamed from: b */
    private double f15530b = 0.0d;
    /* renamed from: c */
    private float f15531c = 1000.0f;
    /* renamed from: d */
    private C31061iz f15532d = null;
    /* renamed from: e */
    private C5844cr f15533e;
    /* renamed from: f */
    private int f15534f = -1;
    /* renamed from: g */
    private CircleInfo f15535g = new CircleInfo();

    public C36898hu(C31061iz c31061iz) {
        AppMethodBeat.m2504i(99586);
        this.f15532d = c31061iz;
        AppMethodBeat.m2505o(99586);
    }

    /* renamed from: a */
    public void mo58866a(C5844cr c5844cr) {
        AppMethodBeat.m2504i(99587);
        if (c5844cr == null) {
            AppMethodBeat.m2505o(99587);
            return;
        }
        this.f15533e = c5844cr;
        C24343db a = c5844cr.mo12357a();
        if (a != null) {
            mo58865a(C36520ic.m60470a(a));
        }
        mo58864a(c5844cr.mo12358b());
        mo50177d(c5844cr.mo12360c());
        mo50176c(c5844cr.mo12362d());
        mo50178d(c5844cr.mo12364e());
        mo50175c((float) c5844cr.mo12365f());
        mo29442a(c5844cr.mo12366g());
        mo50174a_(c5844cr.mo12367h());
        this.f15533e = c5844cr;
        this.f13966P = true;
        AppMethodBeat.m2505o(99587);
    }

    /* renamed from: a */
    public void mo58865a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99588);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(99588);
            return;
        }
        if (this.f15529a == null) {
            this.f15529a = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.f15529a.setLatitudeE6(geoPoint.getLatitudeE6());
            this.f15529a.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        this.f13966P = true;
        AppMethodBeat.m2505o(99588);
    }

    /* renamed from: a */
    public void mo58864a(double d) {
        AppMethodBeat.m2504i(99589);
        if (d < 0.0d) {
            AppMethodBeat.m2505o(99589);
            return;
        }
        if (d == 0.0d) {
            d = 1.0E-10d;
        }
        if (this.f15533e == null || this.f15533e.mo12357a() == null) {
            AppMethodBeat.m2505o(99589);
            return;
        }
        this.f15530b = d;
        this.f15531c = (float) C36520ic.m60466a(d, this.f15533e.mo12357a().f4615a);
        this.f13966P = true;
        AppMethodBeat.m2505o(99589);
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
        AppMethodBeat.m2504i(99590);
        if (this.f15532d == null || this.f15532d.mo75386b() == null) {
            AppMethodBeat.m2505o(99590);
            return;
        }
        mo29449c();
        AppMethodBeat.m2505o(99590);
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        AppMethodBeat.m2504i(99591);
        if (this.f15529a == null || this.f15532d == null || this.f15532d.mo75386b() == null) {
            AppMethodBeat.m2505o(99591);
            return false;
        }
        GeoPoint a = this.f15532d.mo75386b().mo20244t().mo29297a(new DoublePoint((double) f, (double) f2));
        if (Math.hypot((double) (a.getLatitudeE6() - this.f15529a.getLatitudeE6()), (double) (a.getLongitudeE6() - this.f15529a.getLongitudeE6())) <= ((double) this.f15531c)) {
            AppMethodBeat.m2505o(99591);
            return true;
        }
        AppMethodBeat.m2505o(99591);
        return false;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        return this.f13965O;
    }

    /* renamed from: a */
    public void mo29442a(boolean z) {
        this.f13965O = z;
        this.f13966P = true;
    }

    /* renamed from: b */
    public void mo29445b() {
    }

    /* renamed from: c */
    public void mo29449c() {
        AppMethodBeat.m2504i(99592);
        if ((this.f15534f > 0 && !this.f13966P) || this.f15532d == null || this.f15532d.mo75386b() == null) {
            AppMethodBeat.m2505o(99592);
            return;
        }
        this.f15535g.zIndex = (int) this.f13964N;
        this.f15535g.borderColor = this.f13963M;
        this.f15535g.borderWidth = (int) this.f13961K;
        this.f15535g.fillColor = this.f13962L;
        this.f15535g.radius = (float) this.f15530b;
        this.f15535g.centerX = this.f15529a.getLongitudeE6();
        this.f15535g.centerY = this.f15529a.getLatitudeE6();
        this.f15535g.isVisible = this.f13965O;
        this.f15535g.level = this.f13967Q;
        if (this.f15534f == -1) {
            this.f15534f = this.f15532d.mo75386b().mo20151a(this.f15535g);
        } else if (this.f13966P) {
            this.f15532d.mo75386b().mo20162a(this.f15534f, this.f15535g);
        }
        this.f13966P = false;
        AppMethodBeat.m2505o(99592);
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(99593);
        if (!(this.f15534f == -1 || this.f15532d == null || this.f15532d.mo75386b() == null)) {
            this.f15532d.mo75386b().mo20212d(this.f15534f);
            this.f15534f = -1;
        }
        AppMethodBeat.m2505o(99593);
    }

    /* renamed from: b */
    public void mo20132b(C16263gj c16263gj, C24374fw c24374fw) {
    }

    /* renamed from: a */
    public boolean mo20130a(C24374fw c24374fw, float f, float f2) {
        return false;
    }

    /* renamed from: a */
    public Rect mo20125a(C24374fw c24374fw) {
        AppMethodBeat.m2504i(99594);
        double a = m61527a(this.f15530b, ((double) this.f15529a.getLatitudeE6()) / 1000000.0d);
        C45133b a2 = m61528a(new C24343db(((double) this.f15529a.getLatitudeE6()) / 1000000.0d, ((double) this.f15529a.getLongitudeE6()) / 1000000.0d));
        C45133b c45133b = new C45133b(a2.mo72954b() - a, a2.mo72952a() + a);
        C45133b c45133b2 = new C45133b(a2.mo72954b() + a, a2.mo72952a() - a);
        C24343db a3 = m61529a(c45133b);
        C24343db a4 = m61529a(c45133b2);
        Rect rect = new Rect();
        rect.left = (int) (a3.f4616b * 1000000.0d);
        rect.top = (int) (a3.f4615a * 1000000.0d);
        rect.right = (int) (a4.f4616b * 1000000.0d);
        rect.bottom = (int) (a4.f4615a * 1000000.0d);
        AppMethodBeat.m2505o(99594);
        return rect;
    }

    /* renamed from: a */
    private double m61527a(double d, double d2) {
        AppMethodBeat.m2504i(99595);
        double cos = d / Math.cos((3.141592653589793d * d2) / 180.0d);
        AppMethodBeat.m2505o(99595);
        return cos;
    }

    /* renamed from: a */
    private C45133b m61528a(C24343db c24343db) {
        AppMethodBeat.m2504i(99596);
        if (c24343db == null) {
            AppMethodBeat.m2505o(99596);
            return null;
        }
        C45133b c45133b = new C45133b((c24343db.f4616b * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((c24343db.f4615a + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
        AppMethodBeat.m2505o(99596);
        return c45133b;
    }

    /* renamed from: a */
    private C24343db m61529a(C45133b c45133b) {
        AppMethodBeat.m2504i(99597);
        C24343db c24343db = new C24343db((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((c45133b.mo72952a() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((c45133b.mo72954b() * 180.0d) / 2.003750834E7d)));
        AppMethodBeat.m2505o(99597);
        return c24343db;
    }
}
