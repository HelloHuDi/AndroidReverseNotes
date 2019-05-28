package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.widget.C8415j;
import com.google.android.gms.common.internal.Constants;
import com.tencent.map.lib.C8889f;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C37423c;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16286jj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16287jk;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs.C24380b;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24393iw;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24406lh.C24404a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31044fv;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31045fx;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31059ix;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31061iz;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36508fl;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36508fl.C36509a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36894gk.C24378a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44514gg;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46793im;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46793im.C16283a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5892ja;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30981g;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30985h;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30986j;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30987k;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30988a;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30990c;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30991i;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;
import com.tencent.tencentmap.mapsdk.p666a.C36463bi.C16187a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ar */
public final class C25001ar implements C24333as, C24338bw, C46757ce, C30998cg {
    /* renamed from: a */
    private C44514gg f4961a = null;
    /* renamed from: b */
    private C31061iz f4962b = null;
    /* renamed from: c */
    private Context f4963c = null;
    /* renamed from: d */
    private String f4964d = null;
    /* renamed from: e */
    private C36463bi f4965e = null;
    /* renamed from: f */
    private C16287jk f4966f = null;
    /* renamed from: g */
    private C16203q f4967g = null;
    /* renamed from: h */
    private C16286jj f4968h = null;
    /* renamed from: i */
    private final GeoPoint f4969i = null;
    /* renamed from: j */
    private final GeoPoint f4970j = null;
    /* renamed from: k */
    private int f4971k = 0;
    /* renamed from: l */
    private int f4972l = 0;
    /* renamed from: m */
    private int f4973m = 0;
    /* renamed from: n */
    private int f4974n = 0;
    /* renamed from: o */
    private byte[] f4975o = new byte[0];
    /* renamed from: p */
    private int f4976p = 0;
    /* renamed from: q */
    private boolean f4977q = false;
    /* renamed from: r */
    private float f4978r = 1.0f;
    /* renamed from: s */
    private boolean f4979s = false;
    /* renamed from: t */
    private final C25007c f4980t = new C25007c(false);
    /* renamed from: u */
    private final C25007c f4981u = new C25007c(true);
    /* renamed from: v */
    private C24378a f4982v = new C250051();
    /* renamed from: w */
    private C16283a f4983w = new C250022();
    /* renamed from: x */
    private C31044fv f4984x = new C161814();

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$4 */
    class C161814 implements C31044fv {
        /* renamed from: a */
        boolean f3069a = false;
        /* renamed from: b */
        Handler f3070b = new Handler(Looper.getMainLooper());

        /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$4$1 */
        class C161821 implements Runnable {
            C161821() {
            }

            public void run() {
                AppMethodBeat.m2504i(100593);
                if (C25001ar.this.f4962b == null) {
                    AppMethodBeat.m2505o(100593);
                    return;
                }
                C25001ar.this.f4962b.mo50431a(C25001ar.this.f4962b.mo75386b().mo20231j());
                C25001ar.this.f4962b.mo50418K().mo40719h();
                if (C25001ar.this.f4962b.f14282q != null) {
                    C25001ar.this.f4962b.f14282q.mo50170a();
                    C25001ar.this.f4962b.f14282q = null;
                }
                AppMethodBeat.m2505o(100593);
            }
        }

        C161814() {
            AppMethodBeat.m2504i(100594);
            AppMethodBeat.m2505o(100594);
        }

        /* renamed from: a */
        public void mo29059a() {
            AppMethodBeat.m2504i(100595);
            if (!this.f3069a) {
                this.f3069a = true;
            }
            this.f3070b.post(new C161821());
            AppMethodBeat.m2505o(100595);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$a */
    static class C24332a {
        /* renamed from: a */
        static C44514gg m37503a(int i, Context context, C44480ak c44480ak) {
            AppMethodBeat.m2504i(100596);
            C44514gg c5892ja;
            switch (i) {
                case 0:
                    c5892ja = new C5892ja(context, c44480ak);
                    AppMethodBeat.m2505o(100596);
                    return c5892ja;
                case 1:
                    c5892ja = new C31059ix(context, c44480ak);
                    AppMethodBeat.m2505o(100596);
                    return c5892ja;
                case 2:
                    c5892ja = new C24393iw(context, c44480ak);
                    AppMethodBeat.m2505o(100596);
                    return c5892ja;
                default:
                    C5892ja c5892ja2 = new C5892ja(context, c44480ak);
                    AppMethodBeat.m2505o(100596);
                    return c5892ja2;
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$2 */
    class C250022 implements C16283a {
        C250022() {
        }

        /* renamed from: b */
        public int mo29516b() {
            AppMethodBeat.m2504i(100583);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100583);
                return 0;
            }
            int c = C25001ar.this.f4962b.mo75386b().mo20203c();
            AppMethodBeat.m2505o(100583);
            return c;
        }

        /* renamed from: c */
        public GeoPoint mo29517c() {
            AppMethodBeat.m2504i(100584);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100584);
                return null;
            }
            GeoPoint f = C25001ar.this.f4962b.mo75386b().mo20219f();
            AppMethodBeat.m2505o(100584);
            return f;
        }

        /* renamed from: d */
        public float mo29518d() {
            AppMethodBeat.m2504i(100585);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100585);
                return 0.0f;
            }
            float q = C25001ar.this.f4962b.mo75386b().mo20241q();
            AppMethodBeat.m2505o(100585);
            return q;
        }

        /* renamed from: e */
        public float mo29519e() {
            AppMethodBeat.m2504i(100586);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100586);
                return 0.0f;
            }
            float r = C25001ar.this.f4962b.mo75386b().mo20242r();
            AppMethodBeat.m2505o(100586);
            return r;
        }

        /* renamed from: a */
        public float mo29514a() {
            AppMethodBeat.m2504i(100587);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100587);
                return 0.0f;
            }
            float s = C25001ar.this.mo41912s();
            AppMethodBeat.m2505o(100587);
            return s;
        }

        /* renamed from: f */
        public GeoPoint mo29520f() {
            AppMethodBeat.m2504i(100588);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100588);
                return null;
            }
            GeoPoint F = C25001ar.this.f4962b.mo50413F();
            AppMethodBeat.m2505o(100588);
            return F;
        }

        /* renamed from: g */
        public boolean mo29521g() {
            AppMethodBeat.m2504i(100589);
            if (C25001ar.this.f4962b == null) {
                AppMethodBeat.m2505o(100589);
                return false;
            }
            boolean a = C25001ar.this.f4962b.mo50412E().mo40470a();
            AppMethodBeat.m2505o(100589);
            return a;
        }

        /* renamed from: a */
        public void mo29515a(Runnable runnable) {
            AppMethodBeat.m2504i(100590);
            if (runnable == null) {
                AppMethodBeat.m2505o(100590);
            } else if (C25001ar.this.f4962b == null || C25001ar.this.f4962b.f14195I == null) {
                AppMethodBeat.m2505o(100590);
            } else {
                C25001ar.this.f4962b.f14195I.postDelayed(runnable, 100);
                AppMethodBeat.m2505o(100590);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$1 */
    class C250051 implements C24378a {
        C250051() {
        }

        /* renamed from: a */
        public void mo40584a(C31045fx c31045fx) {
            AppMethodBeat.m2504i(100582);
            if (c31045fx.f14124a != Downloads.MIN_WAIT_FOR_NETWORK) {
                AppMethodBeat.m2505o(100582);
            } else if (c31045fx instanceof C46793im) {
                C46793im c46793im = (C46793im) c31045fx;
                if (c46793im.mo75494j()) {
                    C25001ar.this.f4962b.mo75386b().mo20207c((C25001ar.this.f4962b.f14206T / 2) - c46793im.mo75495k(), (C25001ar.this.f4962b.f14207U / 2) - c46793im.mo75496l());
                }
                if (c46793im.mo75489e()) {
                    C25001ar.this.f4962b.mo75386b().mo20207c(c46793im.mo75490f(), c46793im.mo75491g());
                }
                if (c46793im.mo75492h()) {
                    C25001ar.this.f4962b.mo75386b().mo20189b((double) c46793im.mo75493i());
                }
                if (c46793im.mo75497m()) {
                    int n = c46793im.mo75498n();
                    int o = c46793im.mo75499o();
                    C25001ar.this.f4962b.mo75386b().mo20160a(n, o);
                    if (c46793im.mo75504t()) {
                        C25001ar.this.f4962b.mo50464c(n, o);
                    }
                }
                if (c46793im.mo75501q()) {
                    C25001ar.this.f4962b.mo75386b().mo20190b(c46793im.mo75500p());
                }
                if (c46793im.mo75502r()) {
                    C25001ar.this.f4962b.mo75386b().mo20157a(c46793im.mo75503s());
                }
                if (c46793im.mo75494j()) {
                    C25001ar.this.f4962b.mo75386b().mo20207c(c46793im.mo75495k() - (C25001ar.this.f4962b.f14206T / 2), c46793im.mo75496l() - (C25001ar.this.f4962b.f14207U / 2));
                }
                AppMethodBeat.m2505o(100582);
            } else {
                AppMethodBeat.m2505o(100582);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$b */
    public interface C25006b {
        /* renamed from: a */
        void mo41915a();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.ar$c */
    class C25007c implements C25006b {
        /* renamed from: b */
        private boolean f4995b = false;

        public C25007c(boolean z) {
            this.f4995b = z;
        }

        /* renamed from: a */
        public void mo41915a() {
            AppMethodBeat.m2504i(100597);
            if (C25001ar.this.f4962b.f14206T == 0 || C25001ar.this.f4962b.f14207U == 0) {
                AppMethodBeat.m2505o(100597);
                return;
            }
            C25001ar.this.f4962b.mo50439a(null);
            if (C25001ar.this.f4962b.f14199M == null || C25001ar.this.f4962b.f14200N == null) {
                AppMethodBeat.m2505o(100597);
                return;
            }
            float a;
            GeoPoint geoPoint = new GeoPoint();
            if (C25001ar.this.f4962b.f14202P == 0 && C25001ar.this.f4962b.f14203Q == 0 && C25001ar.this.f4962b.f14204R == 0 && C25001ar.this.f4962b.f14205S == 0) {
                a = C25001ar.this.mo41895a(0, 0, 0, 0, C25001ar.this.f4962b.f14199M, C25001ar.this.f4962b.f14200N, geoPoint);
            } else {
                a = C25001ar.this.mo41895a(C25001ar.this.f4962b.f14202P, C25001ar.this.f4962b.f14203Q, C25001ar.this.f4962b.f14204R, C25001ar.this.f4962b.f14205S, C25001ar.this.f4962b.f14199M, C25001ar.this.f4962b.f14200N, geoPoint);
            }
            C30988a c30988a = C25001ar.this.f4962b.f14288w;
            int latitudeE6 = geoPoint.getLatitudeE6();
            int longitudeE6 = geoPoint.getLongitudeE6();
            if (this.f4995b) {
                C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
                c46793im.mo75485c(0.0f);
                c46793im.mo75488d(0.0f);
                c46793im.mo75486c(latitudeE6, longitudeE6);
                c46793im.mo75477a(a);
                c46793im.mo75481a(C25001ar.this.f4983w);
                c46793im.mo75480a(c30988a);
                C25001ar.this.f4962b.mo75386b().mo20176a(c46793im);
            } else {
                C25001ar.this.f4962b.mo75386b().mo20190b(0.0f);
                C25001ar.this.f4962b.mo75386b().mo20157a(0.0f);
                C25001ar.this.f4962b.mo75386b().mo20160a(latitudeE6, longitudeE6);
                C25001ar.m39177a(C25001ar.this, a, false, 0, null);
            }
            C25001ar.this.f4962b.f14199M = null;
            C25001ar.this.f4962b.f14200N = null;
            C25001ar.this.f4962b.f14202P = 0;
            C25001ar.this.f4962b.f14203Q = 0;
            C25001ar.this.f4962b.f14204R = 0;
            C25001ar.this.f4962b.f14205S = 0;
            C25001ar.this.f4962b.f14288w = null;
            AppMethodBeat.m2505o(100597);
        }
    }

    /* renamed from: a */
    public final C36463bi mo41898a() {
        return this.f4965e;
    }

    /* renamed from: b */
    public final C16203q mo41903b() {
        return this.f4967g;
    }

    /* renamed from: c */
    public final C16286jj mo41905c() {
        return this.f4968h;
    }

    public C25001ar(int i, C36456ac c36456ac, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100598);
        this.f4963c = c36456ac.getContext().getApplicationContext();
        this.f4978r = SystemUtil.getDensity(this.f4963c);
        if (this.f4961a == null) {
            this.f4961a = C24332a.m37503a(i, this.f4963c, c44480ak);
            this.f4962b = (C31061iz) this.f4961a.getVectorMapDelegate();
            this.f4962b.mo50434a(this.f4963c, c44480ak);
        }
        if (C36520ic.f15415t == null) {
            C36520ic.f15415t = new C24331aq(10);
        }
        this.f4962b.mo50440a((C24333as) this);
        this.f4962b.mo75386b().mo20177a(this.f4982v);
        this.f4962b.mo75386b().mo20175a(this.f4984x);
        this.f4962b.mo75386b().mo20218e(0, 0);
        mo41902a(false, false);
        if (!(c44480ak == null || StringUtil.isEmpty(c44480ak.mo70667h()))) {
            this.f4964d = c44480ak.mo70667h();
        }
        this.f4967g = new C16203q(this.f4963c, this.f4964d);
        this.f4968h = new C16286jj(this.f4963c, this.f4962b.mo75386b(), this.f4964d);
        if (this.f4965e == null) {
            this.f4965e = new C36463bi(c36456ac, this.f4961a);
        }
        AppMethodBeat.m2505o(100598);
    }

    /* renamed from: a */
    public final void mo41900a(C16187a c16187a) {
        AppMethodBeat.m2504i(100599);
        this.f4965e.mo57685a(c16187a);
        AppMethodBeat.m2505o(100599);
    }

    /* renamed from: a */
    public final void mo41901a(C24404a c24404a, C44480ak c44480ak) {
        AppMethodBeat.m2504i(100600);
        this.f4965e.mo57687a(c24404a, c44480ak);
        AppMethodBeat.m2505o(100600);
    }

    /* renamed from: d */
    public final void mo41907d() {
        AppMethodBeat.m2504i(100601);
        if (this.f4962b != null) {
            this.f4962b.mo75386b().mo20198b(this.f4984x);
            this.f4962b.mo50408A();
            this.f4962b = null;
        }
        if (this.f4963c != null) {
            this.f4963c = null;
        }
        if (C36520ic.f15415t != null) {
            C36520ic.f15415t.mo40420a();
        }
        AppMethodBeat.m2505o(100601);
    }

    /* renamed from: a */
    public final C24343db mo41899a(Point point) {
        AppMethodBeat.m2504i(100602);
        if (point == null) {
            AppMethodBeat.m2505o(100602);
            return null;
        }
        C24343db a = C36520ic.m60471a(this.f4962b.mo75386b().mo20244t().mo29297a(new DoublePoint((double) point.x, (double) point.y)));
        AppMethodBeat.m2505o(100602);
        return a;
    }

    /* renamed from: a */
    public final Point mo41896a(C24343db c24343db) {
        AppMethodBeat.m2504i(100603);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100603);
            return null;
        }
        DoublePoint b = this.f4962b.mo75386b().mo20244t().mo29298b(C36520ic.m60470a(c24343db));
        if (b == null) {
            AppMethodBeat.m2505o(100603);
            return null;
        }
        Point point = new Point();
        point.x = (int) Math.round(b.f2800x);
        point.y = (int) Math.round(b.f2801y);
        AppMethodBeat.m2505o(100603);
        return point;
    }

    /* renamed from: a */
    public final double mo41894a(double d) {
        AppMethodBeat.m2504i(100604);
        double a = this.f4962b.mo75386b().mo20244t().mo29295a(d);
        AppMethodBeat.m2505o(100604);
        return a;
    }

    /* renamed from: e */
    public final C46759do mo41908e() {
        AppMethodBeat.m2504i(100605);
        Point point = new Point(0, this.f4962b.f14207U);
        Point point2 = new Point(this.f4962b.f14206T, this.f4962b.f14207U);
        Point point3 = new Point(0, 0);
        Point point4 = new Point(this.f4962b.f14206T, 0);
        C24343db a = mo41899a(point);
        C24343db a2 = mo41899a(point2);
        C24343db a3 = mo41899a(point3);
        C24343db a4 = mo41899a(point4);
        C46759do c46759do = new C46759do(a, a2, a3, a4, C24345dc.m37562a().mo12368a(a).mo12368a(a2).mo12368a(a3).mo12368a(a4).mo12370a());
        AppMethodBeat.m2505o(100605);
        return c46759do;
    }

    /* renamed from: f */
    public final C44514gg mo41909f() {
        return this.f4961a;
    }

    /* renamed from: a */
    private void m39179a(boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100606);
        if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75483b(1.0f);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100606);
            return;
        }
        this.f4962b.mo75386b().mo20191b(this.f4962b.mo75386b().mo20225h() + 1);
        AppMethodBeat.m2505o(100606);
    }

    /* renamed from: b */
    private void m39183b(boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100607);
        if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75483b(-1.0f);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100607);
            return;
        }
        this.f4962b.mo75386b().mo20191b(this.f4962b.mo75386b().mo20225h() - 1);
        AppMethodBeat.m2505o(100607);
    }

    /* renamed from: a */
    private void m39175a(float f, float f2, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100608);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100608);
        } else if (f == 0.0f && f2 == 0.0f) {
            AppMethodBeat.m2505o(100608);
        } else if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75478a((int) f, (int) f2);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100608);
        } else {
            this.f4962b.mo75386b().mo20207c((int) f, (int) f2);
            AppMethodBeat.m2505o(100608);
        }
    }

    /* renamed from: a */
    private void m39176a(float f, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100609);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100609);
        } else if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75477a(f);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100609);
        } else {
            this.f4962b.mo75386b().mo20155a((double) ((float) (1.0d / Math.pow(2.0d, (double) (((float) this.f4962b.mo75386b().mo20210d()) - Math.min(f, (float) Math.min(this.f4962b.mo75386b().mo20203c(), this.f4962b.mo50412E().mo40470a() ? 22 : 20)))))));
            AppMethodBeat.m2505o(100609);
        }
    }

    /* renamed from: b */
    private void m39182b(float f, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100610);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100610);
        } else if (f == 0.0f) {
            AppMethodBeat.m2505o(100610);
        } else if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75483b(f);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100610);
        } else {
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.f4962b.mo75386b().mo20155a((double) (pow * this.f4962b.mo75386b().mo20228i()));
            AppMethodBeat.m2505o(100610);
        }
    }

    /* renamed from: a */
    private void m39174a(float f, float f2, float f3, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100611);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100611);
        } else if (f == 0.0f) {
            AppMethodBeat.m2505o(100611);
        } else if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75484b((int) f2, (int) f3);
            c46793im.mo75483b(f);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100611);
        } else {
            float pow;
            if (f < 0.0f) {
                pow = (float) (1.0d / Math.pow(2.0d, (double) Math.abs(f)));
            } else {
                pow = (float) (1.0d / Math.pow(0.5d, (double) Math.abs(f)));
            }
            this.f4962b.mo75386b().mo20156a((double) pow, (double) f2, (double) f3, (double) f2, (double) f3, null);
            AppMethodBeat.m2505o(100611);
        }
    }

    /* renamed from: a */
    private void m39178a(C5841cp c5841cp, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100612);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100612);
        } else if (c5841cp == null) {
            AppMethodBeat.m2505o(100612);
        } else {
            GeoPoint a = C36520ic.m60470a(c5841cp.f1462a);
            float f = c5841cp.f1463b;
            int d = this.f4962b.mo75386b().mo20210d();
            int b = this.f4962b.mo75386b().mo20187b();
            if (f < ((float) b)) {
                f = (float) b;
            }
            if (f > ((float) d)) {
                f = (float) d;
            }
            if (z) {
                C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
                if (a != null) {
                    c46793im.mo75486c(a.getLatitudeE6(), a.getLongitudeE6());
                }
                c46793im.mo75477a(f);
                c46793im.mo75485c(c5841cp.f1465d);
                if (c5841cp.f1464c >= 0.0f) {
                    c46793im.mo75488d(c5841cp.f1464c);
                }
                c46793im.mo75481a(this.f4983w);
                c46793im.mo75479a(j);
                c46793im.mo75480a(c30988a);
                this.f4962b.mo75386b().mo20176a(c46793im);
                AppMethodBeat.m2505o(100612);
                return;
            }
            double pow = 1.0d / Math.pow(2.0d, (double) (((float) d) - f));
            if (a != null) {
                this.f4962b.mo75386b().mo20160a(a.getLatitudeE6(), a.getLongitudeE6());
            }
            this.f4962b.mo75386b().mo20205c((float) pow);
            this.f4962b.mo75386b().mo20190b(c5841cp.f1465d);
            if (c5841cp.f1464c >= 0.0f) {
                this.f4962b.mo75386b().mo20157a(c5841cp.f1464c);
            }
            AppMethodBeat.m2505o(100612);
        }
    }

    /* renamed from: a */
    private void m39172a(double d, double d2, float f, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100613);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100613);
            return;
        }
        float f2;
        int i = (int) (1000000.0d * d);
        int i2 = (int) (1000000.0d * d2);
        int d3 = this.f4962b.mo75386b().mo20210d();
        int b = this.f4962b.mo75386b().mo20187b();
        if (f < ((float) b)) {
            f2 = (float) b;
        } else {
            f2 = f;
        }
        if (f2 > ((float) d3)) {
            f2 = (float) d3;
        }
        double pow = 1.0d / Math.pow(2.0d, (double) (((float) d3) - f2));
        if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75486c(i, i2);
            c46793im.mo75477a(f2);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100613);
            return;
        }
        this.f4962b.mo75386b().mo20160a(i, i2);
        this.f4962b.mo75386b().mo20205c((float) pow);
        AppMethodBeat.m2505o(100613);
    }

    /* renamed from: a */
    private void m39173a(double d, double d2, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100614);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100614);
            return;
        }
        int i = (int) (d * 1000000.0d);
        int i2 = (int) (1000000.0d * d2);
        if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75486c(i, i2);
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100614);
            return;
        }
        this.f4962b.mo75386b().mo20160a(i, i2);
        AppMethodBeat.m2505o(100614);
    }

    /* renamed from: a */
    private int m39168a(C24345dc c24345dc, int i, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100615);
        int windowWidth;
        int windowHeight;
        if (c24345dc == null) {
            AppMethodBeat.m2505o(100615);
            return -1;
        } else if (c24345dc.f4618b == null || c24345dc.f4617a == null) {
            AppMethodBeat.m2505o(100615);
            return -1;
        } else if (this.f4962b.f14206T == 0 || this.f4962b.f14207U == 0) {
            this.f4962b.f14199M = c24345dc.f4617a;
            this.f4962b.f14200N = c24345dc.f4618b;
            this.f4962b.f14201O = i;
            this.f4962b.f14288w = c30988a;
            if (z) {
                this.f4962b.mo50439a(this.f4981u);
            } else {
                this.f4962b.mo50439a(this.f4980t);
            }
            windowWidth = SystemUtil.getWindowWidth(this.f4963c);
            windowHeight = SystemUtil.getWindowHeight(this.f4963c);
            if (((i * 2) + this.f4971k) + this.f4973m > windowWidth || ((i * 2) + this.f4972l) + this.f4974n > windowHeight) {
                AppMethodBeat.m2505o(100615);
                return -1;
            }
            AppMethodBeat.m2505o(100615);
            return 0;
        } else {
            this.f4962b.mo50439a(null);
            GeoPoint geoPoint = new GeoPoint();
            float a = mo41895a(i, i, i, i, c24345dc.f4617a, c24345dc.f4618b, geoPoint);
            if (a < 0.0f) {
                windowWidth = (int) a;
                AppMethodBeat.m2505o(100615);
                return windowWidth;
            }
            windowWidth = geoPoint.getLatitudeE6();
            windowHeight = geoPoint.getLongitudeE6();
            if (z) {
                C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
                c46793im.mo75485c(0.0f);
                c46793im.mo75488d(0.0f);
                c46793im.mo75486c(windowWidth, windowHeight);
                c46793im.mo75477a(a);
                c46793im.mo75481a(this.f4983w);
                c46793im.mo75480a(c30988a);
                c46793im.mo75479a(j);
                this.f4962b.mo75386b().mo20176a(c46793im);
            } else {
                this.f4962b.mo75386b().mo20160a(windowWidth, windowHeight);
                m39176a(a, false, j, null);
                this.f4962b.mo75386b().mo20190b(0.0f);
                this.f4962b.mo75386b().mo20157a(0.0f);
            }
            AppMethodBeat.m2505o(100615);
            return 0;
        }
    }

    /* renamed from: b */
    private void m39181b(float f, float f2, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100616);
        if (z) {
            C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
            c46793im.mo75485c(f);
            if (f2 >= 0.0f) {
                c46793im.mo75488d(f2);
            }
            c46793im.mo75481a(this.f4983w);
            c46793im.mo75480a(c30988a);
            c46793im.mo75479a(j);
            this.f4962b.mo75386b().mo20176a(c46793im);
            AppMethodBeat.m2505o(100616);
            return;
        }
        this.f4962b.mo75386b().mo20190b(f);
        if (f2 >= 0.0f) {
            this.f4962b.mo75386b().mo20157a(f2);
        }
        AppMethodBeat.m2505o(100616);
    }

    /* renamed from: a */
    private int m39167a(C24345dc c24345dc, int i, int i2, int i3, int i4, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100617);
        int windowWidth;
        int windowHeight;
        if (c24345dc == null) {
            AppMethodBeat.m2505o(100617);
            return -1;
        } else if (c24345dc.f4618b == null || c24345dc.f4617a == null) {
            AppMethodBeat.m2505o(100617);
            return -1;
        } else if (this.f4962b.f14206T == 0 || this.f4962b.f14207U == 0) {
            this.f4962b.f14199M = c24345dc.f4617a;
            this.f4962b.f14200N = c24345dc.f4618b;
            this.f4962b.f14202P = i;
            this.f4962b.f14203Q = i2;
            this.f4962b.f14204R = i3;
            this.f4962b.f14205S = i4;
            this.f4962b.f14288w = c30988a;
            if (z) {
                this.f4962b.mo50439a(this.f4981u);
            } else {
                this.f4962b.mo50439a(this.f4980t);
            }
            windowWidth = SystemUtil.getWindowWidth(this.f4963c);
            windowHeight = SystemUtil.getWindowHeight(this.f4963c);
            if (((i + i2) + this.f4971k) + this.f4973m > windowWidth || ((i3 + i4) + this.f4972l) + this.f4974n > windowHeight) {
                AppMethodBeat.m2505o(100617);
                return -1;
            }
            AppMethodBeat.m2505o(100617);
            return 0;
        } else {
            this.f4962b.mo50439a(null);
            GeoPoint geoPoint = new GeoPoint();
            float a = mo41895a(i, i2, i3, i4, c24345dc.f4617a, c24345dc.f4618b, geoPoint);
            if (a < 0.0f) {
                windowWidth = (int) a;
                AppMethodBeat.m2505o(100617);
                return windowWidth;
            }
            windowWidth = geoPoint.getLatitudeE6();
            windowHeight = geoPoint.getLongitudeE6();
            if (z) {
                C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
                c46793im.mo75485c(0.0f);
                c46793im.mo75488d(0.0f);
                c46793im.mo75486c(windowWidth, windowHeight);
                c46793im.mo75477a(a);
                c46793im.mo75481a(this.f4983w);
                c46793im.mo75480a(c30988a);
                c46793im.mo75479a(j);
                this.f4962b.mo75386b().mo20176a(c46793im);
            } else {
                this.f4962b.mo75386b().mo20160a(windowWidth, windowHeight);
                m39176a(a, false, j, null);
                this.f4962b.mo75386b().mo20190b(0.0f);
                this.f4962b.mo75386b().mo20157a(0.0f);
            }
            AppMethodBeat.m2505o(100617);
            return 0;
        }
    }

    /* renamed from: a */
    private int m39169a(List<C46755bx> list, int i, int i2, int i3, int i4, boolean z, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100618);
        C36508fl c36508fl = (C36508fl) this.f4962b.mo75386b().mo20245u();
        if (c36508fl == null) {
            AppMethodBeat.m2505o(100618);
            return C8415j.INVALID_ID;
        } else if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(100618);
            return -1;
        } else {
            List arrayList = new ArrayList();
            for (C46755bx c46755bx : list) {
                if (!(c46755bx == null || c46755bx.mo12330a() == null)) {
                    arrayList.addAll(c46755bx.mo12330a());
                }
            }
            if (this.f4962b.f14206T == 0 || this.f4962b.f14207U == 0) {
                int windowWidth = SystemUtil.getWindowWidth(this.f4963c);
                int windowHeight = SystemUtil.getWindowHeight(this.f4963c);
                if (i + i2 > windowWidth || i3 + i4 > windowHeight) {
                    AppMethodBeat.m2505o(100618);
                    return -1;
                }
                AppMethodBeat.m2505o(100618);
                return 0;
            } else if (i + i2 > this.f4962b.f14206T || i3 + i4 > this.f4962b.f14207U) {
                AppMethodBeat.m2505o(100618);
                return -1;
            } else {
                final boolean z2 = z;
                final C30988a c30988a2 = c30988a;
                final long j2 = j;
                c36508fl.mo57734a(arrayList, new Rect(i, i3, i2, i4), new C36509a() {
                    /* renamed from: a */
                    public void mo41913a(final float f, final GeoPoint geoPoint, double d) {
                        AppMethodBeat.m2504i(100592);
                        if (C25001ar.this.f4962b == null) {
                            AppMethodBeat.m2505o(100592);
                            return;
                        }
                        C25001ar.this.f4962b.f14195I.post(new Runnable() {
                            public void run() {
                                double d = 0.0d;
                                AppMethodBeat.m2504i(100591);
                                if (C25001ar.this.f4962b == null) {
                                    AppMethodBeat.m2505o(100591);
                                } else if (z2) {
                                    double h = (((double) ((int) C25001ar.this.mo40454h())) - (Math.log((double) (1.0f / f)) / Math.log(2.0d))) - 2.0d;
                                    if (h >= 0.0d) {
                                        d = h;
                                    }
                                    C31045fx c46793im = new C46793im(Downloads.MIN_WAIT_FOR_NETWORK);
                                    c46793im.mo75486c(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
                                    c46793im.mo75477a((float) d);
                                    c46793im.mo75481a(C25001ar.this.f4983w);
                                    c46793im.mo75480a(c30988a2);
                                    c46793im.mo75479a(j2);
                                    C25001ar.this.f4962b.mo75386b().mo20176a(c46793im);
                                    AppMethodBeat.m2505o(100591);
                                } else {
                                    C25001ar.this.f4962b.mo75386b().mo20193b(geoPoint);
                                    C25001ar.this.f4962b.mo75386b().mo20205c(f);
                                    AppMethodBeat.m2505o(100591);
                                }
                            }
                        });
                        AppMethodBeat.m2505o(100592);
                    }
                });
                AppMethodBeat.m2505o(100618);
                return 0;
            }
        }
    }

    /* renamed from: g */
    public final C5841cp mo40453g() {
        AppMethodBeat.m2504i(100619);
        C24343db a = C36520ic.m60471a(this.f4962b.mo75386b().mo20219f());
        float q = this.f4962b.mo75386b().mo20241q();
        if (q < 0.0f) {
            q = (q % 360.0f) + 360.0f;
        }
        C5841cp a2 = C5841cp.m8926a().mo12325a(mo41912s()).mo12326a(a).mo12329c(q).mo12328b(this.f4962b.mo75386b().mo20242r()).mo12327a();
        AppMethodBeat.m2505o(100619);
        return a2;
    }

    /* renamed from: h */
    public final float mo40454h() {
        AppMethodBeat.m2504i(100620);
        float c = (float) this.f4962b.mo75386b().mo20203c();
        AppMethodBeat.m2505o(100620);
        return c;
    }

    /* renamed from: i */
    public final float mo40455i() {
        AppMethodBeat.m2504i(100621);
        float b = (float) this.f4962b.mo75386b().mo20187b();
        AppMethodBeat.m2505o(100621);
        return b;
    }

    /* renamed from: a */
    public final int mo40429a(C41004ad c41004ad) {
        AppMethodBeat.m2504i(100622);
        if (c41004ad == null) {
            AppMethodBeat.m2505o(100622);
            return -1;
        }
        C41008ao a = c41004ad.mo64968a();
        if (a == null) {
            AppMethodBeat.m2505o(100622);
            return -1;
        }
        int a2;
        switch (a.f16360o) {
            case 0:
                m39179a(false, 0, null);
                break;
            case 1:
                m39183b(false, 0, null);
                break;
            case 2:
                m39175a(a.f16361p, a.f16362q, false, 0, null);
                break;
            case 3:
                m39176a(a.f16363r, false, 0, null);
                break;
            case 4:
                m39182b(a.f16364s, false, 0, null);
                break;
            case 5:
                m39174a(a.f16365t, (float) a.f16366u.x, (float) a.f16366u.y, false, 0, null);
                break;
            case 6:
                m39178a(a.f16367v, false, 0, null);
                break;
            case 7:
                m39173a(a.f16368w.f4615a, a.f16368w.f4616b, false, 0, null);
                break;
            case 8:
                m39172a(a.f16369x.f4615a, a.f16369x.f4616b, a.f16370y, false, 0, null);
                break;
            case 9:
                a2 = m39168a(a.f16371z, a.f16348A, false, 0, null);
                AppMethodBeat.m2505o(100622);
                return a2;
            case 10:
                a2 = m39167a(a.f16349B, a.f16352E, a.f16352E, a.f16352E, a.f16352E, false, 0, null);
                AppMethodBeat.m2505o(100622);
                return a2;
            case 11:
                a2 = m39167a(a.f16349B, a.f16353F, a.f16354G, a.f16355H, a.f16356I, false, 0, null);
                AppMethodBeat.m2505o(100622);
                return a2;
            case 12:
                m39181b(a.f16357J, a.f16358K, false, 0, null);
                break;
            case 13:
                a2 = m39169a(a.f16359L, a.f16353F, a.f16354G, a.f16355H, a.f16356I, false, 0, null);
                AppMethodBeat.m2505o(100622);
                return a2;
        }
        AppMethodBeat.m2505o(100622);
        return 0;
    }

    /* renamed from: a */
    public final int mo40430a(C41004ad c41004ad, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(100623);
        if (c41004ad == null) {
            AppMethodBeat.m2505o(100623);
            return -1;
        }
        C41008ao a = c41004ad.mo64968a();
        if (a == null) {
            AppMethodBeat.m2505o(100623);
            return -1;
        }
        long j2 = j < 0 ? 0 : j;
        int a2;
        switch (a.f16360o) {
            case 0:
                m39179a(true, j2, c30988a);
                break;
            case 1:
                m39183b(true, j2, c30988a);
                break;
            case 2:
                m39175a(a.f16361p, a.f16362q, true, j2, c30988a);
                break;
            case 3:
                m39176a(a.f16363r, true, j2, c30988a);
                break;
            case 4:
                m39182b(a.f16364s, true, j2, c30988a);
                break;
            case 5:
                m39174a(a.f16365t, (float) a.f16366u.x, (float) a.f16366u.y, true, j2, c30988a);
                break;
            case 6:
                m39178a(a.f16367v, true, j2, c30988a);
                break;
            case 7:
                m39173a(a.f16368w.f4615a, a.f16368w.f4616b, true, j2, c30988a);
                break;
            case 8:
                m39172a(a.f16369x.f4615a, a.f16369x.f4616b, a.f16370y, true, j2, c30988a);
                break;
            case 9:
                a2 = m39168a(a.f16371z, a.f16348A, true, j2, c30988a);
                AppMethodBeat.m2505o(100623);
                return a2;
            case 10:
                a2 = m39167a(a.f16349B, a.f16352E, a.f16352E, a.f16352E, a.f16352E, true, j2, c30988a);
                AppMethodBeat.m2505o(100623);
                return a2;
            case 11:
                a2 = m39167a(a.f16349B, a.f16353F, a.f16354G, a.f16355H, a.f16356I, true, j2, c30988a);
                AppMethodBeat.m2505o(100623);
                return a2;
            case 12:
                m39181b(a.f16357J, a.f16358K, true, j2, c30988a);
                break;
            case 13:
                a2 = m39169a(a.f16359L, a.f16353F, a.f16354G, a.f16355H, a.f16356I, true, j2, c30988a);
                AppMethodBeat.m2505o(100623);
                return a2;
        }
        AppMethodBeat.m2505o(100623);
        return 0;
    }

    /* renamed from: j */
    public final void mo40456j() {
        AppMethodBeat.m2504i(100624);
        this.f4962b.mo75386b().mo20246v();
        AppMethodBeat.m2505o(100624);
    }

    /* renamed from: a */
    public final void mo40432a(int i) {
        AppMethodBeat.m2504i(100625);
        if (this.f4977q) {
            AppMethodBeat.m2505o(100625);
            return;
        }
        if (this.f4967g != null) {
            i = this.f4967g.mo29199a(i);
        }
        this.f4976p = i;
        this.f4962b.mo75386b().mo20159a(i);
        C36520ic.m60480a(true);
        AppMethodBeat.m2505o(100625);
    }

    /* renamed from: a */
    public final void mo40445a(boolean z) {
        AppMethodBeat.m2504i(100626);
        C8889f b = this.f4962b.mo75386b();
        if (z) {
            b.mo20183a(true);
            AppMethodBeat.m2505o(100626);
            return;
        }
        b.mo20183a(false);
        AppMethodBeat.m2505o(100626);
    }

    /* renamed from: b */
    public final void mo40449b(boolean z) {
        AppMethodBeat.m2504i(100627);
        this.f4977q = z;
        if (z) {
            this.f4962b.mo75386b().mo20159a(11);
            AppMethodBeat.m2505o(100627);
            return;
        }
        this.f4962b.mo75386b().mo20159a(this.f4976p);
        AppMethodBeat.m2505o(100627);
    }

    /* renamed from: k */
    public final boolean mo40457k() {
        AppMethodBeat.m2504i(100628);
        boolean g = this.f4962b.mo75386b().mo20224g();
        AppMethodBeat.m2505o(100628);
        return g;
    }

    /* renamed from: l */
    public final C31061iz mo41910l() {
        return this.f4962b;
    }

    /* renamed from: m */
    public final Context mo41911m() {
        return this.f4963c;
    }

    /* renamed from: n */
    public final void mo40458n() {
    }

    /* renamed from: o */
    public final void mo40459o() {
        AppMethodBeat.m2504i(100629);
        this.f4961a.mo12505e();
        if (this.f4965e != null) {
            this.f4965e.mo57688f();
        }
        AppMethodBeat.m2505o(100629);
    }

    /* renamed from: p */
    public final void mo40460p() {
        AppMethodBeat.m2504i(100630);
        this.f4961a.mo12506f();
        AppMethodBeat.m2505o(100630);
    }

    /* renamed from: q */
    public final void mo40461q() {
        AppMethodBeat.m2504i(100631);
        this.f4961a.mo12507g();
        if (this.f4966f != null) {
            this.f4966f.mo29534b();
            this.f4966f = null;
        }
        if (this.f4965e != null) {
            this.f4965e.mo57684a();
            this.f4965e = null;
        }
        AppMethodBeat.m2505o(100631);
    }

    /* renamed from: a */
    public final void mo40437a(C30985h c30985h) {
        this.f4962b.f14278m = c30985h;
    }

    /* renamed from: a */
    public final void mo40439a(C30986j c30986j) {
        this.f4962b.f14281p = c30986j;
    }

    /* renamed from: a */
    public final void mo40434a(C30990c c30990c) {
        AppMethodBeat.m2504i(100632);
        this.f4962b.mo50436a(c30990c);
        AppMethodBeat.m2505o(100632);
    }

    /* renamed from: a */
    public final void mo40422a(int i, int i2) {
        AppMethodBeat.m2504i(100633);
        if (i == 0 || i2 == 0) {
            AppMethodBeat.m2505o(100633);
            return;
        }
        if (this.f4965e != null) {
            this.f4965e.mo40422a(i, i2);
        }
        AppMethodBeat.m2505o(100633);
    }

    /* renamed from: a */
    public final void mo40433a(Handler handler, Config config) {
        AppMethodBeat.m2504i(100634);
        this.f4962b.mo50435a(handler, config);
        AppMethodBeat.m2505o(100634);
    }

    /* renamed from: a */
    public final void mo40443a(C44494dn c44494dn) {
        AppMethodBeat.m2504i(100635);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100635);
            return;
        }
        this.f4962b.mo50442a(c44494dn);
        AppMethodBeat.m2505o(100635);
    }

    /* renamed from: b */
    public final void mo40448b(C44494dn c44494dn) {
        AppMethodBeat.m2504i(100636);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100636);
            return;
        }
        this.f4962b.mo50459b(c44494dn);
        AppMethodBeat.m2505o(100636);
    }

    /* renamed from: r */
    public final String mo40462r() {
        return "4.2.2";
    }

    /* renamed from: a */
    public final DoublePoint mo41897a(GeoPoint geoPoint, DoublePoint doublePoint) {
        AppMethodBeat.m2504i(100637);
        double d = (double) (2.68435456E8f * this.f4978r);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d /= 6.283185307179586d;
        double min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        d3 = (d3 * (((double) geoPoint.getLongitudeE6()) / 1000000.0d)) + d2;
        d = ((d * Math.log((1.0d + min) / (1.0d - min))) * 0.5d) + d2;
        if (doublePoint == null) {
            doublePoint = new DoublePoint();
        }
        doublePoint.set(d3, d);
        AppMethodBeat.m2505o(100637);
        return doublePoint;
    }

    /* renamed from: a */
    public final float mo41895a(int i, int i2, int i3, int i4, C24343db c24343db, C24343db c24343db2, GeoPoint geoPoint) {
        AppMethodBeat.m2504i(100638);
        int i5 = this.f4962b.f14206T;
        int i6 = this.f4962b.f14207U;
        if (i5 == 0 || i6 == 0 || c24343db == null || c24343db2 == null) {
            AppMethodBeat.m2505o(100638);
            return -2.0f;
        } else if (((i + i2) + this.f4971k) + this.f4973m > i5 || ((i3 + i4) + this.f4972l) + this.f4974n > i6) {
            AppMethodBeat.m2505o(100638);
            return -1.0f;
        } else {
            double pow;
            GeoPoint a = C36520ic.m60470a(c24343db);
            GeoPoint a2 = C36520ic.m60470a(c24343db2);
            int d = this.f4962b.mo75386b().mo20210d();
            DoublePoint a3 = mo41897a(a, null);
            DoublePoint a4 = mo41897a(a2, null);
            double d2 = a4.f2800x - a3.f2800x;
            if (d2 < 0.0d) {
                d2 = Math.abs(d2);
            }
            double d3 = a4.f2801y - a3.f2801y;
            if (d3 < 0.0d) {
                d3 = Math.abs(d3);
            }
            int i7 = (((i5 - i) - i2) - this.f4971k) - this.f4973m;
            int i8 = (((i6 - i3) - i4) - this.f4972l) - this.f4974n;
            if (i7 <= 0) {
                i7 = 1;
            }
            if (i8 <= 0) {
                i8 = 1;
            }
            d2 = Math.max(d2 / ((double) i7), d3 / ((double) i8));
            float log = (float) (((double) d) - (Math.log(d2) / Math.log(2.0d)));
            float h = mo40454h();
            float i9 = mo40455i();
            if (h < log) {
                d2 = Math.pow(2.0d, (double) (((float) d) - h));
            } else {
                h = log;
            }
            if (i9 > h) {
                pow = Math.pow(2.0d, (double) (((float) d) - i9));
            } else {
                pow = d2;
                i9 = h;
            }
            if (geoPoint != null) {
                d3 = (((double) (i2 - i)) * pow) / 2.0d;
                d2 = (((double) (i3 - i4)) * pow) / 2.0d;
                DoublePoint a5 = mo41897a(C36520ic.m60470a(new C24343db((c24343db.f4615a + c24343db2.f4615a) / 2.0d, (c24343db.f4616b + c24343db2.f4616b) / 2.0d)), null);
                a5.f2800x = d3 + a5.f2800x;
                a5.f2801y = d2 + a5.f2801y;
                double d4 = a5.f2800x;
                double d5 = a5.f2801y;
                if (this.f4979s) {
                    double d6;
                    int i10 = this.f4971k - this.f4973m;
                    int i11 = this.f4972l - this.f4974n;
                    h = (((float) (this.f4971k - this.f4973m)) / (2.0f * ((float) i5))) + 0.5f;
                    if (((double) h) < 0.25d) {
                        i10 = (int) (-0.5d * ((double) i5));
                    } else if (((double) h) > 0.75d) {
                        i10 = (int) (0.5d * ((double) i5));
                    }
                    h = (((float) (this.f4972l - this.f4974n)) / (2.0f * ((float) i6))) + 0.5f;
                    if (((double) h) < 0.25d) {
                        i11 = (int) (-0.5d * ((double) i6));
                    } else if (((double) h) > 0.75d) {
                        i11 = (int) (0.5d * ((double) i6));
                    }
                    double d7 = (((double) i10) * pow) / 2.0d;
                    double d8 = (((double) i11) * pow) / 2.0d;
                    C24380b q = this.f4962b.mo75386b().mo20138A().mo40626q();
                    if (q == null) {
                        d2 = 0.0d;
                        d6 = 0.0d;
                    } else {
                        d2 = (double) q.mo40588a();
                        d6 = (double) q.mo40590b();
                    }
                    d3 = (d4 - d7) + ((d2 * ((double) i5)) * pow);
                    d2 = (d5 - d8) - ((d6 * ((double) i6)) * pow);
                } else {
                    d2 = d5;
                    d3 = d4;
                }
                a = m39170a(new DoublePoint(d3, d2), null);
                geoPoint.setLatitudeE6(a.getLatitudeE6());
                geoPoint.setLongitudeE6(a.getLongitudeE6());
            }
            AppMethodBeat.m2505o(100638);
            return i9;
        }
    }

    /* renamed from: a */
    private GeoPoint m39170a(DoublePoint doublePoint, GeoPoint geoPoint) {
        AppMethodBeat.m2504i(100639);
        double d = (double) (2.68435456E8f * this.f4978r);
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        d3 = (doublePoint.f2800x - d2) / d3;
        d = (Math.asin(1.0d - (2.0d / (Math.pow(2.718281828459045d, ((doublePoint.f2801y - d2) / 0.5d) / (d / 6.283185307179586d)) + 1.0d))) * 180.0d) / 3.141592653589793d;
        if (geoPoint == null) {
            geoPoint = new GeoPoint(0, 0);
        }
        geoPoint.setLatitudeE6((int) (d * 1000000.0d));
        geoPoint.setLongitudeE6((int) (1000000.0d * d3));
        AppMethodBeat.m2505o(100639);
        return geoPoint;
    }

    /* renamed from: s */
    public final float mo41912s() {
        AppMethodBeat.m2504i(100640);
        float j = this.f4962b.mo75386b().mo20231j();
        AppMethodBeat.m2505o(100640);
        return j;
    }

    /* renamed from: a */
    public final void mo40431a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(100641);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100641);
            return;
        }
        this.f4979s = true;
        this.f4962b.mo75386b().mo20158a(f, f2, 0, z);
        AppMethodBeat.m2505o(100641);
    }

    /* renamed from: c */
    public final void mo41906c(boolean z) {
        AppMethodBeat.m2504i(100642);
        this.f4961a.setZOrderMediaOverlay(z);
        AppMethodBeat.m2505o(100642);
    }

    /* renamed from: t */
    public final void mo40463t() {
    }

    /* renamed from: u */
    public final void mo40464u() {
    }

    /* renamed from: a */
    public final void mo41902a(boolean z, boolean z2) {
        AppMethodBeat.m2504i(100643);
        this.f4962b.mo75386b().mo20209c(z2);
        this.f4962b.mo75386b().mo20201b(z);
        AppMethodBeat.m2505o(100643);
    }

    /* renamed from: a */
    public final void mo40438a(C30991i c30991i) {
        this.f4962b.f14282q = c30991i;
    }

    /* renamed from: a */
    public final void mo40441a(C30992l c30992l) {
        this.f4962b.f14284s = c30992l;
    }

    /* renamed from: a */
    public final void mo40436a(C30981g c30981g) {
        this.f4962b.f14285t = c30981g;
    }

    /* renamed from: a */
    public final void mo40435a(C24326f c24326f) {
        AppMethodBeat.m2504i(100644);
        this.f4962b.mo50437a(c24326f);
        AppMethodBeat.m2505o(100644);
    }

    /* renamed from: d */
    public final void mo40450d(boolean z) {
        AppMethodBeat.m2504i(100645);
        if (this.f4968h == null) {
            AppMethodBeat.m2505o(100645);
            return;
        }
        this.f4968h.mo29528a(z);
        AppMethodBeat.m2505o(100645);
    }

    /* renamed from: b */
    public final void mo40447b(int i) {
        AppMethodBeat.m2504i(100646);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100646);
            return;
        }
        C8889f b = this.f4962b.mo75386b();
        if (b == null) {
            AppMethodBeat.m2505o(100646);
            return;
        }
        b.mo20220f(i);
        AppMethodBeat.m2505o(100646);
    }

    /* renamed from: v */
    public final int mo40465v() {
        AppMethodBeat.m2504i(100647);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100647);
            return -1;
        }
        C8889f b = this.f4962b.mo75386b();
        if (b == null) {
            AppMethodBeat.m2505o(100647);
            return -1;
        }
        int x = b.mo20248x();
        AppMethodBeat.m2505o(100647);
        return x;
    }

    /* renamed from: w */
    public final String[] mo40466w() {
        AppMethodBeat.m2504i(100648);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100648);
            return null;
        }
        C8889f b = this.f4962b.mo75386b();
        if (b == null) {
            AppMethodBeat.m2505o(100648);
            return null;
        }
        String[] y = b.mo20249y();
        AppMethodBeat.m2505o(100648);
        return y;
    }

    /* renamed from: b */
    public final String mo40446b(C24343db c24343db) {
        AppMethodBeat.m2504i(100649);
        if (this.f4962b == null || c24343db == null) {
            AppMethodBeat.m2505o(100649);
            return null;
        }
        C8889f b = this.f4962b.mo75386b();
        if (b == null) {
            AppMethodBeat.m2505o(100649);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        String c = b.mo20204c(geoPoint);
        c24343db.f4615a = (((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d;
        c24343db.f4616b = (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d;
        AppMethodBeat.m2505o(100649);
        return c;
    }

    /* renamed from: c */
    public final C31000cw mo41904c(C24343db c24343db) {
        AppMethodBeat.m2504i(100650);
        GeoPoint geoPoint = new GeoPoint();
        C37423c d = mo41910l().mo75386b().mo20211d(geoPoint);
        if (d == null || d.f16072a == null || d.f16073b == null || d.f16075d == null || d.f16075d.length == 0 || d.f16074c >= d.f16075d.length || d.f16074c == -1) {
            AppMethodBeat.m2505o(100650);
            return null;
        }
        if (c24343db != null) {
            c24343db.f4615a = (((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d;
            c24343db.f4616b = (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d;
        }
        ArrayList arrayList = new ArrayList();
        for (String c36473cy : d.f16075d) {
            arrayList.add(new C36473cy(c36473cy));
        }
        C31000cw c31000cw = new C31000cw(d.f16072a, d.f16073b, arrayList, d.f16074c);
        AppMethodBeat.m2505o(100650);
        return c31000cw;
    }

    /* renamed from: a */
    public final void mo40440a(C30987k c30987k) {
        AppMethodBeat.m2504i(100651);
        this.f4962b.mo50438a(c30987k);
        AppMethodBeat.m2505o(100651);
    }

    /* renamed from: e */
    public final void mo40451e(boolean z) {
        AppMethodBeat.m2504i(100652);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100652);
        } else if (z) {
            this.f4962b.mo50419L();
            AppMethodBeat.m2505o(100652);
        } else {
            this.f4962b.mo50420M();
            AppMethodBeat.m2505o(100652);
        }
    }

    /* renamed from: x */
    public final boolean mo40467x() {
        AppMethodBeat.m2504i(100653);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100653);
            return false;
        }
        boolean N = this.f4962b.mo50421N();
        AppMethodBeat.m2505o(100653);
        return N;
    }

    /* renamed from: y */
    public final boolean mo40468y() {
        AppMethodBeat.m2504i(100654);
        if (this.f4962b == null) {
            AppMethodBeat.m2505o(100654);
            return false;
        }
        boolean O = this.f4962b.mo50422O();
        AppMethodBeat.m2505o(100654);
        return O;
    }

    /* renamed from: a */
    public final void mo40442a(C31001da c31001da) {
        AppMethodBeat.m2504i(100655);
        if (this.f4962b == null || this.f4962b.mo50478o() == null) {
            AppMethodBeat.m2505o(100655);
            return;
        }
        this.f4962b.mo50478o().mo40739a(c31001da);
        AppMethodBeat.m2505o(100655);
    }

    /* renamed from: z */
    public final String mo40469z() {
        String str = null;
        AppMethodBeat.m2504i(100656);
        if (this.f4963c == null || this.f4962b == null) {
            AppMethodBeat.m2505o(100656);
        } else {
            try {
                C41027s a;
                JSONObject jSONObject = new JSONObject();
                if (StringUtil.isEmpty(this.f4964d)) {
                    a = C31016w.m49806a(this.f4963c);
                } else {
                    a = C41355u.m72123a(this.f4963c, this.f4964d);
                }
                jSONObject.put("cfgVer", a.mo65088b());
                int windowWidth = SystemUtil.getWindowWidth(this.f4963c);
                jSONObject.put("resolution", "{" + windowWidth + "," + SystemUtil.getWindowHeight(this.f4963c) + "}");
                jSONObject.put(Constants.PARAM_DENSITY, (double) this.f4978r);
                jSONObject.put("renderStatus", this.f4962b.mo75386b().mo20147J());
                jSONObject.put("renderError", this.f4962b.mo75386b().mo20148K());
                jSONObject.put("sdkver", "4.2.2.1");
                str = jSONObject.toString();
                AppMethodBeat.m2505o(100656);
            } catch (JSONException e) {
                AppMethodBeat.m2505o(100656);
            }
        }
        return str;
    }

    /* renamed from: a */
    public final void mo40444a(String str, String str2) {
        AppMethodBeat.m2504i(100657);
        if (this.f4962b == null || this.f4962b.mo75386b() == null) {
            AppMethodBeat.m2505o(100657);
            return;
        }
        C8889f b = this.f4962b.mo75386b();
        if (b != null) {
            b.mo20181a(str, str2);
        }
        AppMethodBeat.m2505o(100657);
    }

    /* renamed from: f */
    public final void mo40452f(boolean z) {
        if (this.f4962b != null) {
            this.f4962b.f14208V = z;
        }
    }
}
