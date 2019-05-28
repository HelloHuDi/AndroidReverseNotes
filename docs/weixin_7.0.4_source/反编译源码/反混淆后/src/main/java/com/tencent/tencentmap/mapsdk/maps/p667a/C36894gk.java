package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.C1016e;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.p822gl.C17853d;
import com.tencent.map.lib.p822gl.JNICallback.C17848g;
import com.tencent.map.lib.thread.AsyncTask;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24380b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24381c;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46786fz.C36510a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gk */
public class C36894gk implements C17848g, C41047ex, C31044fv, C36510a, C36514gu {
    /* renamed from: c */
    private static int f15484c = 116307503;
    /* renamed from: d */
    private static int f15485d = 39984186;
    /* renamed from: A */
    private float f15486A = 0.5f;
    /* renamed from: B */
    private boolean f15487B = true;
    /* renamed from: C */
    private int f15488C = 0;
    /* renamed from: D */
    private int f15489D = 0;
    /* renamed from: E */
    private int f15490E = 0;
    /* renamed from: F */
    private int f15491F = 0;
    /* renamed from: G */
    private Runnable f15492G;
    /* renamed from: H */
    private boolean f15493H = false;
    /* renamed from: a */
    public C46786fz f15494a;
    /* renamed from: b */
    public C41055go f15495b;
    /* renamed from: e */
    private List<C46785fq> f15496e;
    /* renamed from: f */
    private List<C16229fm> f15497f;
    /* renamed from: g */
    private List<C17853d> f15498g;
    /* renamed from: h */
    private List<C5877fo> f15499h;
    /* renamed from: i */
    private List<C41050ft> f15500i;
    /* renamed from: j */
    private List<C44512fs> f15501j;
    /* renamed from: k */
    private List<C31044fv> f15502k;
    /* renamed from: l */
    private List<C5884gt> f15503l;
    /* renamed from: m */
    private List<C5883gr> f15504m;
    /* renamed from: n */
    private List<C41049fr> f15505n;
    /* renamed from: o */
    private List<C31043fu> f15506o;
    /* renamed from: p */
    private boolean f15507p = true;
    /* renamed from: q */
    private Stack<C24382gs> f15508q = new Stack();
    /* renamed from: r */
    private WeakReference<C41052ge> f15509r;
    /* renamed from: s */
    private C5876fn f15510s;
    /* renamed from: t */
    private C24382gs f15511t;
    /* renamed from: u */
    private C16230fp f15512u;
    /* renamed from: v */
    private Rect f15513v;
    /* renamed from: w */
    private Rect f15514w;
    /* renamed from: x */
    private Handler f15515x = null;
    /* renamed from: y */
    private C24378a f15516y = null;
    /* renamed from: z */
    private float f15517z = 0.5f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gk$a */
    public interface C24378a {
        /* renamed from: a */
        void mo40584a(C31045fx c31045fx);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gk$1 */
    class C368951 implements C17853d {
        C368951() {
        }

        /* renamed from: a */
        public void mo33217a() {
            AppMethodBeat.m2504i(99179);
            final PointF a = C36894gk.m61427a(C36894gk.this);
            new AsyncTask<Void, Void, Void>() {
                public /* synthetic */ Object doInBackground(Object[] objArr) {
                    AppMethodBeat.m2504i(99178);
                    Void a = mo58863a((Void[]) objArr);
                    AppMethodBeat.m2505o(99178);
                    return a;
                }

                /* Access modifiers changed, original: protected|varargs */
                /* renamed from: a */
                public Void mo58863a(Void... voidArr) {
                    AppMethodBeat.m2504i(99177);
                    C36894gk.this.mo58793a(a.x, a.y, false);
                    AppMethodBeat.m2505o(99177);
                    return null;
                }
            }.execute((Object[]) new Void[0]);
            C36894gk.this.mo58820b((C17853d) this);
            AppMethodBeat.m2505o(99179);
        }
    }

    public C36894gk(C5876fn c5876fn) {
        AppMethodBeat.m2504i(99182);
        this.f15510s = c5876fn;
        this.f15509r = c5876fn.mo12441b();
        this.f15511t = c5876fn.mo12444e();
        this.f15512u = (C16230fp) c5876fn.mo12443d();
        this.f15513v = c5876fn.mo12446g();
        this.f15494a = new C46786fz(this);
        this.f15494a.mo75371a((C31044fv) this);
        mo58809a(this.f15494a);
        this.f15495b = new C41055go(c5876fn);
        this.f15500i = new CopyOnWriteArrayList();
        this.f15501j = new CopyOnWriteArrayList();
        this.f15496e = new CopyOnWriteArrayList();
        this.f15497f = new CopyOnWriteArrayList();
        this.f15498g = new CopyOnWriteArrayList();
        this.f15504m = new CopyOnWriteArrayList();
        this.f15505n = new CopyOnWriteArrayList();
        this.f15506o = new CopyOnWriteArrayList();
        this.f15502k = new CopyOnWriteArrayList();
        mo58798a(C31049gi.m49906a(1));
        this.f15515x = new Handler();
        AppMethodBeat.m2505o(99182);
    }

    /* renamed from: a */
    public int mo58783a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99183);
        this.f15488C = i;
        this.f15489D = i2;
        this.f15490E = i3;
        this.f15491F = i4;
        if (this.f15513v == null || this.f15513v.width() <= 0 || this.f15513v.height() <= 0) {
            mo58801a(new C368951());
            if (this.f15510s instanceof C46789gm) {
                Context k = ((C46789gm) this.f15510s).mo75458k();
                if (i + i3 > SystemUtil.getWindowWidth(k) || i2 + i4 > SystemUtil.getWindowHeight(k)) {
                    AppMethodBeat.m2505o(99183);
                    return -1;
                }
                AppMethodBeat.m2505o(99183);
                return 0;
            }
            AppMethodBeat.m2505o(99183);
            return -2;
        } else if (i + i3 > this.f15513v.width() || i2 + i4 > this.f15513v.height()) {
            AppMethodBeat.m2505o(99183);
            return -1;
        } else {
            PointF E = m61419E();
            mo58793a(E.x, E.y, false);
            AppMethodBeat.m2505o(99183);
            return 0;
        }
    }

    /* renamed from: E */
    private PointF m61419E() {
        int width;
        int height;
        int i;
        AppMethodBeat.m2504i(99184);
        if (this.f15513v != null) {
            width = this.f15513v.width();
            height = this.f15513v.height();
            i = width;
        } else {
            height = 0;
            i = 0;
        }
        width = this.f15488C;
        int i2 = (((i - width) - this.f15490E) / 2) + width;
        width = this.f15489D;
        int i3 = (((height - width) - this.f15491F) / 2) + width;
        if (i == 0 || height == 0) {
            PointF pointF = new PointF(0.5f, 0.5f);
            AppMethodBeat.m2505o(99184);
            return pointF;
        }
        PointF pointF2 = new PointF((((float) i2) * 1.0f) / ((float) i), (((float) i3) * 1.0f) / ((float) height));
        AppMethodBeat.m2505o(99184);
        return pointF2;
    }

    /* renamed from: b */
    public Rect mo58813b() {
        AppMethodBeat.m2504i(99185);
        Rect rect = new Rect(this.f15488C, this.f15489D, this.f15490E, this.f15491F);
        AppMethodBeat.m2505o(99185);
        return rect;
    }

    /* renamed from: F */
    private boolean m61420F() {
        AppMethodBeat.m2504i(99186);
        if (this.f15513v == null || this.f15513v.width() <= 0 || this.f15513v.height() <= 0) {
            AppMethodBeat.m2505o(99186);
            return false;
        }
        AppMethodBeat.m2505o(99186);
        return true;
    }

    /* renamed from: c */
    public C46786fz mo58828c() {
        AppMethodBeat.m2504i(99187);
        this.f15494a.mo75369a();
        C46786fz c46786fz = this.f15494a;
        AppMethodBeat.m2505o(99187);
        return c46786fz;
    }

    /* renamed from: d */
    public void mo58833d() {
        AppMethodBeat.m2504i(99188);
        if (this.f15494a != null) {
            this.f15494a.mo75375d();
        }
        AppMethodBeat.m2505o(99188);
    }

    /* renamed from: e */
    public void mo58835e() {
        AppMethodBeat.m2504i(99189);
        if (this.f15494a != null) {
            this.f15494a.mo75374c();
        }
        AppMethodBeat.m2505o(99189);
    }

    /* renamed from: f */
    public void mo58837f() {
        AppMethodBeat.m2504i(99190);
        if (this.f15494a != null) {
            this.f15494a.mo75373b();
        }
        AppMethodBeat.m2505o(99190);
    }

    /* renamed from: g */
    public C46786fz mo58839g() {
        return this.f15494a;
    }

    /* renamed from: a */
    public void mo58809a(C5884gt c5884gt) {
        AppMethodBeat.m2504i(99191);
        if (c5884gt == null) {
            AppMethodBeat.m2505o(99191);
            return;
        }
        if (this.f15503l == null) {
            this.f15503l = new CopyOnWriteArrayList();
        }
        synchronized (this.f15503l) {
            try {
                if (!this.f15503l.contains(c5884gt)) {
                    this.f15503l.add(c5884gt);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99191);
            }
        }
    }

    /* renamed from: G */
    private void m61421G() {
        AppMethodBeat.m2504i(99192);
        if (this.f15503l == null) {
            AppMethodBeat.m2505o(99192);
            return;
        }
        for (C5884gt c5884gt : this.f15503l) {
            if (c5884gt != null) {
                try {
                    c5884gt.mo12476a(this.f15511t);
                } catch (Exception e) {
                }
            }
        }
        mo58862z();
        AppMethodBeat.m2505o(99192);
    }

    /* renamed from: h */
    public void mo58841h() {
        AppMethodBeat.m2504i(99193);
        try {
            C24382gs c24382gs = (C24382gs) this.f15511t.clone();
            C1015d.m2288a("mapParam stack saveMapParam:" + c24382gs.toString());
            this.f15508q.push(c24382gs);
            AppMethodBeat.m2505o(99193);
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.m2505o(99193);
        }
    }

    /* renamed from: i */
    public void mo58843i() {
        AppMethodBeat.m2504i(99194);
        try {
            C24382gs c24382gs = (C24382gs) this.f15508q.pop();
            if (c24382gs.mo40619j() != this.f15511t.mo40619j()) {
                mo58808a(C24381c.SCALE_LEVEL_CHANGED);
            } else if (c24382gs.mo40618i() != this.f15511t.mo40618i()) {
                mo58808a(C24381c.SCALE_CHANGED);
            }
            if (c24382gs.mo40605c() != this.f15511t.mo40605c()) {
                mo58784a((double) c24382gs.mo40605c());
            }
            if (c24382gs.mo40609d() != this.f15511t.mo40609d()) {
                mo58814b((double) c24382gs.mo40609d());
            }
            this.f15511t.mo40596a(c24382gs);
            m61421G();
            AppMethodBeat.m2505o(99194);
        } catch (Exception e) {
            AppMethodBeat.m2505o(99194);
        }
    }

    /* renamed from: a */
    public void mo58812a(boolean z) {
        AppMethodBeat.m2504i(99195);
        this.f15487B = z;
        m61426L();
        AppMethodBeat.m2505o(99195);
    }

    /* renamed from: a */
    public void mo58798a(Rect rect) {
        AppMethodBeat.m2504i(99196);
        if (m61420F()) {
            float a = mo58782a(rect, this.f15513v);
            this.f15511t.mo40594a(rect);
            this.f15511t.mo40612e(a);
            AppMethodBeat.m2505o(99196);
            return;
        }
        AppMethodBeat.m2505o(99196);
    }

    /* renamed from: j */
    public C24382gs mo58845j() {
        AppMethodBeat.m2504i(99197);
        try {
            C24382gs c24382gs = (C24382gs) this.f15511t.clone();
            AppMethodBeat.m2505o(99197);
            return c24382gs;
        } catch (CloneNotSupportedException e) {
            AppMethodBeat.m2505o(99197);
            return null;
        }
    }

    /* renamed from: a */
    public void mo58803a(C41049fr c41049fr) {
        AppMethodBeat.m2504i(99198);
        if (c41049fr == null) {
            AppMethodBeat.m2505o(99198);
            return;
        }
        synchronized (this.f15505n) {
            try {
                if (!this.f15505n.contains(c41049fr)) {
                    this.f15505n.add(c41049fr);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99198);
            }
        }
    }

    /* renamed from: a */
    public void mo58784a(double d) {
        AppMethodBeat.m2504i(99199);
        m61426L();
        for (C41049fr c41049fr : this.f15505n) {
            if (c41049fr != null) {
                try {
                    c41049fr.mo65135a(d);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99199);
    }

    /* renamed from: a */
    public void mo58805a(C31043fu c31043fu) {
        AppMethodBeat.m2504i(99200);
        if (c31043fu == null) {
            AppMethodBeat.m2505o(99200);
            return;
        }
        synchronized (this.f15506o) {
            try {
                C1015d.m2288a("skew addSkewListener");
                if (!this.f15506o.contains(c31043fu)) {
                    this.f15506o.add(c31043fu);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99200);
            }
        }
    }

    /* renamed from: b */
    public void mo58823b(C31043fu c31043fu) {
        AppMethodBeat.m2504i(99201);
        synchronized (this.f15506o) {
            try {
                C1015d.m2288a("skew addSkewListener");
                this.f15506o.remove(c31043fu);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99201);
            }
        }
    }

    /* renamed from: b */
    public void mo58814b(double d) {
        AppMethodBeat.m2504i(99202);
        m61426L();
        C1015d.m2288a("skew notifySkew");
        for (C31043fu c31043fu : this.f15506o) {
            if (c31043fu != null) {
                try {
                    c31043fu.mo50368a(d);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99202);
    }

    /* renamed from: a */
    public void mo58800a(C1016e c1016e) {
        AppMethodBeat.m2504i(99203);
        this.f15495b.mo65147a(c1016e);
        AppMethodBeat.m2505o(99203);
    }

    /* renamed from: k */
    public void mo58847k() {
        AppMethodBeat.m2504i(99204);
        GeoPoint geoPoint = new GeoPoint(f15485d, f15484c);
        this.f15511t.mo40595a(this.f15510s.mo12446g(), geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 13);
        m61421G();
        m61426L();
        AppMethodBeat.m2505o(99204);
    }

    /* renamed from: a */
    public void mo58794a(int i) {
        AppMethodBeat.m2504i(99205);
        if (this.f15511t.mo40604b(i)) {
            mo58808a(C24381c.SCALE_LEVEL_CHANGED);
        }
        AppMethodBeat.m2505o(99205);
    }

    /* renamed from: l */
    public float mo58848l() {
        AppMethodBeat.m2504i(99206);
        float i = this.f15511t.mo40618i();
        AppMethodBeat.m2505o(99206);
        return i;
    }

    /* renamed from: a */
    public void mo58795a(int i, int i2) {
        AppMethodBeat.m2504i(99207);
        mo58796a(i, i2, 1);
        AppMethodBeat.m2505o(99207);
    }

    /* renamed from: a */
    public void mo58796a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(99208);
        this.f15511t.mo40600a(i, i2, false);
        if (i3 == 1) {
            m61430c(i3);
            m61421G();
        }
        AppMethodBeat.m2505o(99208);
    }

    /* renamed from: a */
    public void mo58789a(float f, float f2) {
        AppMethodBeat.m2504i(99209);
        if (this.f15510s != null) {
            C16238gh f3 = this.f15510s.mo12445f();
            if (f3 != null) {
                f3.mo29321a(f, f2, false);
                m61421G();
            }
        }
        AppMethodBeat.m2505o(99209);
    }

    /* renamed from: a */
    public float mo58782a(Rect rect, Rect rect2) {
        AppMethodBeat.m2504i(99210);
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
        Rect rect3 = new Rect();
        rect3.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        rect3.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        float a = (float) this.f15510s.mo12445f().mo29305a(rect3, rect2);
        AppMethodBeat.m2505o(99210);
        return a;
    }

    /* renamed from: a */
    public void mo58799a(Rect rect, Rect rect2, boolean z) {
        AppMethodBeat.m2504i(99211);
        if (m61420F()) {
            Rect rect3 = new Rect(this.f15513v);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
            GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
            Rect rect4 = new Rect();
            rect4.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            rect4.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            this.f15510s.mo12445f().mo29330a(rect4, rect3, z);
            mo58862z();
            AppMethodBeat.m2505o(99211);
            return;
        }
        AppMethodBeat.m2505o(99211);
    }

    /* renamed from: a */
    public void mo58788a(float f) {
        AppMethodBeat.m2504i(99212);
        mo58808a(this.f15511t.mo40606c(f));
        AppMethodBeat.m2505o(99212);
    }

    /* renamed from: m */
    public int mo58849m() {
        AppMethodBeat.m2504i(99213);
        int j = this.f15511t.mo40619j();
        AppMethodBeat.m2505o(99213);
        return j;
    }

    /* renamed from: n */
    public GeoPoint mo58850n() {
        AppMethodBeat.m2504i(99214);
        GeoPoint p = this.f15511t.mo40625p();
        AppMethodBeat.m2505o(99214);
        return p;
    }

    /* renamed from: b */
    public void mo58815b(float f) {
        AppMethodBeat.m2504i(99215);
        mo58838f((double) f);
        AppMethodBeat.m2505o(99215);
    }

    /* renamed from: o */
    public float mo58851o() {
        AppMethodBeat.m2504i(99216);
        float c = this.f15511t.mo40605c();
        AppMethodBeat.m2505o(99216);
        return c;
    }

    /* renamed from: c */
    public void mo58830c(float f) {
        AppMethodBeat.m2504i(99217);
        mo58834d((double) f);
        AppMethodBeat.m2505o(99217);
    }

    /* renamed from: p */
    public float mo58852p() {
        AppMethodBeat.m2504i(99218);
        float d = this.f15511t.mo40609d();
        AppMethodBeat.m2505o(99218);
        return d;
    }

    /* renamed from: q */
    public float mo58853q() {
        AppMethodBeat.m2504i(99219);
        float k = this.f15511t.mo40620k();
        AppMethodBeat.m2505o(99219);
        return k;
    }

    /* renamed from: a */
    public void mo58785a(double d, double d2) {
        AppMethodBeat.m2504i(99220);
        this.f15510s.mo12445f().mo29321a((float) d, (float) d2, false);
        m61430c(1);
        m61421G();
        AppMethodBeat.m2505o(99220);
    }

    /* renamed from: c */
    public void mo58829c(double d) {
        AppMethodBeat.m2504i(99221);
        if (d == 0.0d) {
            AppMethodBeat.m2505o(99221);
            return;
        }
        float b = this.f15511t.mo40602b(this.f15511t.mo40609d() + ((float) d));
        m61421G();
        mo58814b((double) b);
        AppMethodBeat.m2505o(99221);
    }

    /* renamed from: d */
    public void mo58834d(double d) {
        AppMethodBeat.m2504i(99222);
        if (d == ((double) this.f15511t.mo40609d())) {
            AppMethodBeat.m2505o(99222);
            return;
        }
        float b = this.f15511t.mo40602b((float) d);
        m61421G();
        mo58814b((double) b);
        AppMethodBeat.m2505o(99222);
    }

    /* renamed from: e */
    public void mo58836e(double d) {
        AppMethodBeat.m2504i(99223);
        if (d == 0.0d) {
            AppMethodBeat.m2505o(99223);
            return;
        }
        float a = this.f15511t.mo40591a(this.f15511t.mo40605c() + ((float) d));
        m61421G();
        mo58784a((double) a);
        AppMethodBeat.m2505o(99223);
    }

    /* renamed from: f */
    public void mo58838f(double d) {
        AppMethodBeat.m2504i(99224);
        if (MathUtil.calShortestAngleDistance(d - ((double) this.f15511t.mo40605c())) == 0.0d) {
            AppMethodBeat.m2505o(99224);
            return;
        }
        float a = this.f15511t.mo40591a((float) d);
        m61421G();
        mo58784a((double) a);
        AppMethodBeat.m2505o(99224);
    }

    /* renamed from: g */
    public void mo58840g(double d) {
        AppMethodBeat.m2504i(99225);
        mo58842h((double) (this.f15511t.mo40618i() * ((float) d)));
        AppMethodBeat.m2505o(99225);
    }

    /* renamed from: h */
    public void mo58842h(double d) {
        AppMethodBeat.m2504i(99226);
        mo58788a((float) d);
        AppMethodBeat.m2505o(99226);
    }

    /* renamed from: H */
    private void m61422H() {
        AppMethodBeat.m2504i(99227);
        this.f15511t.mo40591a(0.0f);
        this.f15511t.mo40602b(0.0f);
        mo58784a(0.0d);
        mo58814b(0.0d);
        m61421G();
        AppMethodBeat.m2505o(99227);
    }

    /* renamed from: b */
    public void mo58825b(C31045fx c31045fx) {
        AppMethodBeat.m2504i(99228);
        this.f15494a.mo75381j();
        mo58831c(c31045fx);
        AppMethodBeat.m2505o(99228);
    }

    /* renamed from: i */
    public void mo58844i(double d) {
        AppMethodBeat.m2504i(99229);
        this.f15494a.mo75381j();
        mo58831c(new C31045fx(102, new double[]{0.0d, d}));
        AppMethodBeat.m2505o(99229);
    }

    /* renamed from: j */
    public void mo58846j(double d) {
        AppMethodBeat.m2504i(99230);
        this.f15494a.mo75381j();
        mo58831c(new C31045fx(108, new double[]{d}));
        AppMethodBeat.m2505o(99230);
    }

    /* renamed from: a */
    public void mo58786a(double d, double d2, double d3, double d4, double d5) {
        AppMethodBeat.m2504i(99231);
        if (mo58856t()) {
            this.f15494a.mo75381j();
            mo58831c(new C31045fx(103, new double[]{d, d2, d3, d4, d5}));
            AppMethodBeat.m2505o(99231);
            return;
        }
        AppMethodBeat.m2505o(99231);
    }

    /* renamed from: a */
    public void mo58787a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        AppMethodBeat.m2504i(99232);
        this.f15494a.mo75381j();
        float width = ((float) this.f15510s.mo12446g().width()) / 2.0f;
        float height = ((float) this.f15510s.mo12446g().height()) / 2.0f;
        C24380b q = mo58781D().mo40626q();
        if (this.f15493H) {
            double a;
            double b;
            if (q != null) {
                a = (double) (width + ((q.mo40588a() * width) * 2.0f));
                b = (double) (((q.mo40590b() * height) * 2.0f) + height);
            } else {
                a = (double) width;
                b = (double) height;
            }
            d5 = b;
            d4 = a;
            d3 = b;
            d2 = a;
        }
        mo58831c(new C31045fx(101, new double[]{d, d2, d3, d4, d5}));
        C31045fx c31045fx = new C31045fx(runnable);
        c31045fx.f14128e = false;
        c31045fx.f14126c = 0;
        mo58831c(c31045fx);
        AppMethodBeat.m2505o(99232);
    }

    /* renamed from: a */
    public void mo58810a(Runnable runnable) {
        AppMethodBeat.m2504i(99233);
        mo58811a(runnable, null);
        AppMethodBeat.m2505o(99233);
    }

    /* renamed from: a */
    public void mo58811a(Runnable runnable, C24375fy c24375fy) {
        AppMethodBeat.m2504i(99234);
        if (m61423I()) {
            this.f15510s.mo12445f().mo29351b(((float) this.f15510s.mo12446g().width()) / 2.0f, ((float) this.f15510s.mo12446g().height()) / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.m2505o(99234);
            return;
        }
        AppMethodBeat.m2505o(99234);
    }

    /* renamed from: a */
    public void mo58791a(float f, float f2, Runnable runnable) {
        AppMethodBeat.m2504i(99235);
        if (this.f15493H) {
            C24380b q = mo58781D().mo40626q();
            if (q != null) {
                f = ((float) this.f15510s.mo12446g().width()) * (q.mo40588a() + 0.5f);
                f2 = ((float) this.f15510s.mo12446g().height()) * (q.mo40590b() + 0.5f);
            } else {
                mo58810a(runnable);
                AppMethodBeat.m2505o(99235);
                return;
            }
        }
        mo58792a(f, f2, runnable, null);
        AppMethodBeat.m2505o(99235);
    }

    /* renamed from: a */
    public void mo58792a(float f, float f2, Runnable runnable, C24375fy c24375fy) {
        AppMethodBeat.m2504i(99236);
        if (m61423I()) {
            this.f15510s.mo12445f().mo29351b(f, f2);
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.m2505o(99236);
            return;
        }
        AppMethodBeat.m2505o(99236);
    }

    /* renamed from: b */
    public void mo58826b(Runnable runnable) {
        AppMethodBeat.m2504i(99237);
        mo58827b(runnable, null);
        AppMethodBeat.m2505o(99237);
    }

    /* renamed from: b */
    public void mo58827b(Runnable runnable, C24375fy c24375fy) {
        AppMethodBeat.m2504i(99238);
        if (m61424J()) {
            this.f15510s.mo12445f().mo29407t();
            if (runnable != null) {
                runnable.run();
            }
            AppMethodBeat.m2505o(99238);
            return;
        }
        AppMethodBeat.m2505o(99238);
    }

    /* renamed from: r */
    public void mo58854r() {
        AppMethodBeat.m2504i(99239);
        this.f15494a.mo75381j();
        m61428a(0.0d, 0.0d, true);
        AppMethodBeat.m2505o(99239);
    }

    /* renamed from: a */
    private void m61428a(double d, double d2, boolean z) {
        AppMethodBeat.m2504i(99240);
        final double k = m61435k(d - ((double) mo58851o()));
        final double p = d2 - ((double) mo58852p());
        if (k == 0.0d && p == 0.0d) {
            AppMethodBeat.m2505o(99240);
            return;
        }
        boolean z2;
        C1015d.m2288a("postRotateAndSkew distance:" + k + "," + p);
        final long currentTimeMillis = System.currentTimeMillis();
        final float f = (float) (0.10000000149011612d * k);
        final float f2 = (float) (0.10000000149011612d * p);
        double[] dArr = new double[]{d, d2, 0.0d, 0.0d};
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        final double d3 = d;
        final double d4 = d2;
        mo58831c(new C31045fx(102, dArr, z2) {
            /* renamed from: a */
            public boolean mo29421a() {
                int i;
                AppMethodBeat.m2504i(99180);
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                double b = C36502fh.m60385b(currentTimeMillis, 0.0f, f, 5000);
                double b2 = C36502fh.m60385b(currentTimeMillis, 0.0f, f2, 5000);
                double[] dArr = this.f14125b;
                dArr[2] = dArr[2] + Math.abs(b);
                dArr = this.f14125b;
                dArr[3] = dArr[3] + Math.abs(b2);
                int i2 = this.f14125b[2] >= Math.abs(k) ? 1 : 0;
                if (this.f14125b[3] >= Math.abs(p)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i2 != 0) {
                    this.f14125b[0] = d3 - ((double) C36894gk.this.mo58851o());
                } else {
                    this.f14125b[0] = b;
                }
                if (i != 0) {
                    this.f14125b[1] = d4 - ((double) C36894gk.this.mo58852p());
                } else {
                    this.f14125b[1] = b2;
                }
                if (i2 == 0 || i == 0) {
                    AppMethodBeat.m2505o(99180);
                    return false;
                }
                AppMethodBeat.m2505o(99180);
                return true;
            }
        });
        AppMethodBeat.m2505o(99240);
    }

    /* renamed from: k */
    private double m61435k(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    /* renamed from: s */
    public void mo58855s() {
        AppMethodBeat.m2504i(99241);
        m61434d(false);
        mo58854r();
        AppMethodBeat.m2505o(99241);
    }

    /* renamed from: t */
    public boolean mo58856t() {
        AppMethodBeat.m2504i(99242);
        if (((double) Math.abs(mo58852p())) > 1.0E-6d || Math.abs(mo58851o()) > 1.0f) {
            AppMethodBeat.m2505o(99242);
            return true;
        }
        AppMethodBeat.m2505o(99242);
        return false;
    }

    /* renamed from: I */
    private boolean m61423I() {
        AppMethodBeat.m2504i(99243);
        if (mo58849m() < this.f15511t.mo40622m()) {
            AppMethodBeat.m2505o(99243);
            return true;
        }
        AppMethodBeat.m2505o(99243);
        return false;
    }

    /* renamed from: J */
    private boolean m61424J() {
        AppMethodBeat.m2504i(99244);
        if (mo58849m() > this.f15511t.mo40621l()) {
            AppMethodBeat.m2505o(99244);
            return true;
        }
        AppMethodBeat.m2505o(99244);
        return false;
    }

    /* renamed from: d */
    private void m61433d(C31045fx c31045fx) {
        AppMethodBeat.m2504i(99245);
        int i;
        int i2;
        switch (c31045fx.f14124a) {
            case 2:
                if (!(this.f15509r == null || this.f15509r.get() == null)) {
                    ((C41052ge) this.f15509r.get()).mo12502a_();
                    AppMethodBeat.m2505o(99245);
                    return;
                }
            case 3:
                mo58785a(c31045fx.f14125b[0], c31045fx.f14125b[1]);
                AppMethodBeat.m2505o(99245);
                return;
            case 4:
                if (c31045fx.f14125b.length > 2) {
                    i = (int) c31045fx.f14125b[2];
                } else {
                    i = 1;
                }
                mo58796a((int) c31045fx.f14125b[0], (int) c31045fx.f14125b[1], i);
                AppMethodBeat.m2505o(99245);
                return;
            case 6:
                if (c31045fx.f14129f != null) {
                    c31045fx.f14129f.run();
                    AppMethodBeat.m2505o(99245);
                    return;
                }
                break;
            case 100:
                mo58840g(c31045fx.f14125b[0]);
                AppMethodBeat.m2505o(99245);
                return;
            case 101:
                int width = this.f15510s.mo12446g().width();
                int height = this.f15510s.mo12446g().height();
                i2 = width / 2;
                i = height / 2;
                C24380b q = mo58781D().mo40626q();
                if (q != null) {
                    i2 = (int) (((float) i2) + (((float) width) * q.mo40588a()));
                    i = (int) (((float) i) + (q.mo40590b() * ((float) height)));
                }
                double d = ((double) i2) - c31045fx.f14125b[1];
                double d2 = ((double) i) - c31045fx.f14125b[2];
                double d3 = c31045fx.f14125b[3] - ((double) i2);
                double d4 = c31045fx.f14125b[4] - ((double) i);
                C1015d.m2288a("Debug ScaleFix innerPerform        before   center:" + this.f15511t.mo40625p().toString());
                mo58785a(d, d2);
                mo58840g(c31045fx.f14125b[0]);
                C1015d.m2288a("Debug ScaleFix innerPerform        after      center:" + this.f15511t.mo40625p().toString());
                mo58785a(d3, d4);
                C1015d.m2288a("Debug ScaleFix finally scale move by:" + d3 + "," + d4 + " curCenter:" + this.f15511t.mo40625p().toString());
                AppMethodBeat.m2505o(99245);
                return;
            case 102:
                mo58836e(c31045fx.f14125b[0]);
                mo58829c(c31045fx.f14125b[1]);
                AppMethodBeat.m2505o(99245);
                return;
            case 103:
                i = this.f15510s.mo12446g().width() / 2;
                i2 = this.f15510s.mo12446g().height() / 2;
                mo58785a(((double) i) - c31045fx.f14125b[1], ((double) i2) - c31045fx.f14125b[2]);
                mo58836e(c31045fx.f14125b[0]);
                mo58785a(c31045fx.f14125b[3] - ((double) i), c31045fx.f14125b[4] - ((double) i2));
                AppMethodBeat.m2505o(99245);
                return;
            case 104:
                m61422H();
                AppMethodBeat.m2505o(99245);
                return;
            case 108:
                mo58842h(c31045fx.f14125b[0]);
                AppMethodBeat.m2505o(99245);
                return;
            case 109:
                mo58838f(c31045fx.f14125b[0]);
                AppMethodBeat.m2505o(99245);
                return;
            case 110:
                mo58834d(c31045fx.f14125b[0]);
                AppMethodBeat.m2505o(99245);
                return;
            case 120:
                mo58842h(c31045fx.f14125b[0]);
                mo58795a((int) c31045fx.f14125b[1], (int) c31045fx.f14125b[2]);
                AppMethodBeat.m2505o(99245);
                return;
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
                if (this.f15516y != null) {
                    this.f15516y.mo40584a(c31045fx);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(99245);
    }

    /* renamed from: b */
    public void mo58816b(int i) {
        AppMethodBeat.m2504i(99246);
        if (this.f15511t.mo40598a(i)) {
            m61432d(i);
        }
        AppMethodBeat.m2505o(99246);
    }

    /* renamed from: a */
    public void mo58793a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(99247);
        this.f15511t.mo40597a(f - 0.5f, f2 - 0.5f, z);
        if (z) {
            m61421G();
        }
        AppMethodBeat.m2505o(99247);
    }

    /* renamed from: a */
    public void mo58790a(float f, float f2, int i, boolean z) {
        AppMethodBeat.m2504i(99248);
        if (this.f15511t.mo40597a(f - 0.5f, f2 - 0.5f, z)) {
            m61421G();
        }
        AppMethodBeat.m2505o(99248);
    }

    /* renamed from: b */
    public void mo58818b(Rect rect) {
        AppMethodBeat.m2504i(99249);
        if (this.f15513v == null || rect == null) {
            AppMethodBeat.m2505o(99249);
            return;
        }
        this.f15514w = rect;
        if (this.f15510s instanceof C46789gm) {
            ((C46789gm) this.f15510s).mo75415a(rect);
        }
        m61421G();
        AppMethodBeat.m2505o(99249);
    }

    /* renamed from: u */
    public int mo58857u() {
        AppMethodBeat.m2504i(99250);
        int b = this.f15511t.mo40603b();
        AppMethodBeat.m2505o(99250);
        return b;
    }

    /* renamed from: K */
    private void m61425K() {
        AppMethodBeat.m2504i(99251);
        for (C46785fq c46785fq : this.f15496e) {
            if (c46785fq != null) {
                try {
                    c46785fq.mo70906c_();
                } catch (Exception e) {
                }
            }
        }
        m61421G();
        AppMethodBeat.m2505o(99251);
    }

    /* renamed from: c */
    private void m61430c(int i) {
        AppMethodBeat.m2504i(99252);
        for (C16229fm c16229fm : this.f15497f) {
            if (c16229fm != null) {
                try {
                    c16229fm.mo29294a(i);
                } catch (Exception e) {
                }
            }
        }
        m61425K();
        AppMethodBeat.m2505o(99252);
    }

    /* renamed from: v */
    public void mo58858v() {
        AppMethodBeat.m2504i(99253);
        mo58818b(this.f15514w);
        for (C17853d c17853d : this.f15498g) {
            if (c17853d != null) {
                try {
                    c17853d.mo33217a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99253);
    }

    /* renamed from: d */
    private void m61434d(boolean z) {
        AppMethodBeat.m2504i(99254);
        if (this.f15499h == null) {
            AppMethodBeat.m2505o(99254);
            return;
        }
        boolean t = mo58856t();
        for (C5877fo c5877fo : this.f15499h) {
            if (c5877fo != null) {
                try {
                    c5877fo.mo12448a(t, z);
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99254);
    }

    /* renamed from: a */
    public void mo58804a(C41050ft c41050ft) {
        AppMethodBeat.m2504i(99255);
        if (c41050ft == null) {
            AppMethodBeat.m2505o(99255);
            return;
        }
        synchronized (this.f15500i) {
            try {
                if (!this.f15500i.contains(c41050ft)) {
                    this.f15500i.add(c41050ft);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99255);
            }
        }
    }

    /* renamed from: b */
    public void mo58822b(C41050ft c41050ft) {
        AppMethodBeat.m2504i(99256);
        synchronized (this.f15500i) {
            try {
                this.f15500i.remove(c41050ft);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99256);
            }
        }
    }

    /* renamed from: a */
    public void mo58808a(final C24381c c24381c) {
        AppMethodBeat.m2504i(99257);
        if (c24381c == C24381c.NO_CHANGED) {
            AppMethodBeat.m2505o(99257);
            return;
        }
        if (this.f15515x != null) {
            this.f15515x.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(99181);
                    for (C41050ft c41050ft : C36894gk.this.f15500i) {
                        if (c41050ft != null) {
                            c41050ft.mo29503a(c24381c);
                        }
                    }
                    C36894gk.m61431c(C36894gk.this);
                    AppMethodBeat.m2505o(99181);
                }
            });
        }
        AppMethodBeat.m2505o(99257);
    }

    /* renamed from: w */
    public void mo58859w() {
        AppMethodBeat.m2504i(99258);
        for (C44512fs c44512fs : this.f15501j) {
            if (c44512fs != null) {
                try {
                    c44512fs.mo70883a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99258);
    }

    /* renamed from: a */
    public void mo58806a(C31044fv c31044fv) {
        AppMethodBeat.m2504i(99259);
        if (c31044fv == null) {
            AppMethodBeat.m2505o(99259);
            return;
        }
        synchronized (this.f15502k) {
            try {
                if (!this.f15502k.contains(c31044fv)) {
                    this.f15502k.add(c31044fv);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99259);
            }
        }
    }

    /* renamed from: b */
    public void mo58824b(C31044fv c31044fv) {
        AppMethodBeat.m2504i(99260);
        synchronized (this.f15502k) {
            try {
                this.f15502k.remove(c31044fv);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99260);
            }
        }
    }

    /* renamed from: x */
    public void mo58860x() {
        AppMethodBeat.m2504i(99261);
        for (C31044fv c31044fv : this.f15502k) {
            if (c31044fv != null) {
                try {
                    c31044fv.mo29059a();
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(99261);
    }

    /* renamed from: a */
    public void mo58802a(C46785fq c46785fq) {
        AppMethodBeat.m2504i(99262);
        if (c46785fq == null) {
            AppMethodBeat.m2505o(99262);
            return;
        }
        synchronized (this.f15496e) {
            try {
                if (!this.f15496e.contains(c46785fq)) {
                    this.f15496e.add(c46785fq);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99262);
            }
        }
    }

    /* renamed from: b */
    public void mo58821b(C46785fq c46785fq) {
        AppMethodBeat.m2504i(99263);
        synchronized (this.f15496e) {
            try {
                this.f15496e.remove(c46785fq);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99263);
            }
        }
    }

    /* renamed from: a */
    public void mo58801a(C17853d c17853d) {
        AppMethodBeat.m2504i(99264);
        if (c17853d == null) {
            AppMethodBeat.m2505o(99264);
            return;
        }
        if (!this.f15498g.contains(c17853d)) {
            this.f15498g.add(c17853d);
        }
        AppMethodBeat.m2505o(99264);
    }

    /* renamed from: b */
    public void mo58820b(C17853d c17853d) {
        AppMethodBeat.m2504i(99265);
        synchronized (this.f15498g) {
            try {
                this.f15498g.remove(c17853d);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99265);
            }
        }
    }

    /* renamed from: d */
    private void m61432d(int i) {
        AppMethodBeat.m2504i(99266);
        for (C5883gr c5883gr : this.f15504m) {
            if (c5883gr != null) {
                try {
                    c5883gr.mo12475a(i);
                } catch (Exception e) {
                }
            }
        }
        m61421G();
        AppMethodBeat.m2505o(99266);
    }

    /* renamed from: b */
    public void mo58819b(Rect rect, Rect rect2) {
        AppMethodBeat.m2504i(99267);
        if (rect == null) {
            AppMethodBeat.m2505o(99267);
            return;
        }
        if (rect.height() > 0 || rect.width() > 0) {
            mo58799a(rect, rect2, false);
        }
        m61430c(1);
        AppMethodBeat.m2505o(99267);
    }

    /* renamed from: a */
    public void mo58797a(int i, Runnable runnable, boolean z) {
        AppMethodBeat.m2504i(99268);
        this.f15510s.mo12445f().mo29355b(i, true);
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.m2505o(99268);
    }

    /* renamed from: y */
    public Rect mo58861y() {
        AppMethodBeat.m2504i(99269);
        DoublePoint doublePoint = new DoublePoint((double) this.f15510s.mo12446g().width(), (double) this.f15510s.mo12446g().height());
        GeoPoint a = this.f15512u.mo29297a(doublePoint);
        doublePoint.set(0.0d, 0.0d);
        GeoPoint a2 = this.f15512u.mo29297a(doublePoint);
        Rect rect = new Rect(Math.min(a2.getLongitudeE6(), a.getLongitudeE6()), Math.min(a2.getLatitudeE6(), a.getLatitudeE6()), Math.max(a2.getLongitudeE6(), a.getLongitudeE6()), Math.max(a2.getLatitudeE6(), a.getLatitudeE6()));
        AppMethodBeat.m2505o(99269);
        return rect;
    }

    /* renamed from: z */
    public void mo58862z() {
        AppMethodBeat.m2504i(99270);
        this.f15494a.mo75380i();
        AppMethodBeat.m2505o(99270);
    }

    /* renamed from: c */
    public void mo58831c(C31045fx c31045fx) {
        AppMethodBeat.m2504i(99271);
        this.f15494a.mo75372a(c31045fx);
        AppMethodBeat.m2505o(99271);
    }

    /* renamed from: A */
    public void mo58778A() {
        AppMethodBeat.m2504i(99272);
        this.f15494a.mo75381j();
        AppMethodBeat.m2505o(99272);
    }

    /* renamed from: a */
    public void mo57736a(C31045fx c31045fx) {
        AppMethodBeat.m2504i(99273);
        if (c31045fx != null) {
            m61433d(c31045fx);
        }
        AppMethodBeat.m2505o(99273);
    }

    /* renamed from: a */
    public void mo29059a() {
        AppMethodBeat.m2504i(99274);
        mo58860x();
        AppMethodBeat.m2505o(99274);
    }

    /* renamed from: B */
    public boolean mo58779B() {
        return this.f15507p;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: C */
    public boolean mo58780C() {
        AppMethodBeat.m2504i(99275);
        boolean k = this.f15494a.mo75382k();
        AppMethodBeat.m2505o(99275);
        return k;
    }

    /* renamed from: b */
    public void mo58817b(int i, int i2) {
        AppMethodBeat.m2504i(99276);
        mo58785a((double) i, (double) i2);
        AppMethodBeat.m2505o(99276);
    }

    /* renamed from: a */
    public void mo58807a(C24378a c24378a) {
        this.f15516y = c24378a;
    }

    /* renamed from: D */
    public C24382gs mo58781D() {
        return this.f15511t;
    }

    /* renamed from: L */
    private void m61426L() {
        AppMethodBeat.m2504i(99277);
        C16238gh f = this.f15510s.mo12445f();
        boolean z = mo58856t() && this.f15487B;
        f.mo29367c(z);
        AppMethodBeat.m2505o(99277);
    }

    /* renamed from: b */
    public void mo33211b(boolean z) {
        AppMethodBeat.m2504i(99278);
        if (z) {
            if (this.f15492G != null) {
                this.f15492G.run();
                this.f15492G = null;
            }
            m61421G();
        }
        AppMethodBeat.m2505o(99278);
    }

    /* renamed from: c */
    public void mo58832c(boolean z) {
        this.f15493H = z;
    }
}
