package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C41719m;
import com.tencent.map.lib.element.C44680l;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31056if.C31058b;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30989b;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C30992l;
import com.tencent.tencentmap.mapsdk.p666a.C36456ac;
import com.tencent.tencentmap.mapsdk.p666a.C36466cl;
import com.tencent.tencentmap.mapsdk.p666a.C41018cm;
import com.tencent.tencentmap.mapsdk.p666a.C44490de;
import com.tencent.tencentmap.mapsdk.p666a.C44491df;
import com.tencent.tencentmap.mapsdk.p666a.C5838bl;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hx */
public class C36899hx extends C36519hz {
    /* renamed from: A */
    private boolean f15536A = false;
    /* renamed from: B */
    private boolean f15537B = false;
    /* renamed from: C */
    private int f15538C = 0;
    /* renamed from: D */
    private int f15539D = 0;
    /* renamed from: E */
    private boolean f15540E = false;
    /* renamed from: F */
    private GeoPoint f15541F = null;
    /* renamed from: G */
    private C31061iz f15542G = null;
    /* renamed from: H */
    private C44680l f15543H;
    /* renamed from: R */
    private C36466cl f15544R = null;
    /* renamed from: S */
    private C31056if f15545S = null;
    /* renamed from: T */
    private C30992l f15546T;
    /* renamed from: U */
    private View f15547U = null;
    /* renamed from: V */
    private View f15548V = null;
    /* renamed from: W */
    private ViewGroup f15549W = null;
    /* renamed from: X */
    private LinearLayout f15550X = null;
    /* renamed from: Y */
    private boolean f15551Y = false;
    /* renamed from: Z */
    private final int f15552Z = 1;
    /* renamed from: a */
    protected Object f15553a = null;
    /* renamed from: aa */
    private final int f15554aa = 2;
    /* renamed from: ab */
    private Runnable f15555ab = new C58871();
    /* renamed from: ac */
    private Runnable f15556ac = new C58882();
    /* renamed from: ad */
    private C31058b f15557ad = new C369003();
    /* renamed from: b */
    protected Bitmap f15558b = null;
    /* renamed from: c */
    boolean f15559c = false;
    /* renamed from: d */
    protected byte[] f15560d = new byte[0];
    /* renamed from: e */
    float f15561e = 0.5f;
    /* renamed from: f */
    float f15562f = 0.5f;
    /* renamed from: g */
    boolean f15563g = false;
    /* renamed from: h */
    protected float f15564h = 0.0f;
    /* renamed from: i */
    protected boolean f15565i = false;
    /* renamed from: j */
    protected float f15566j = 0.0f;
    /* renamed from: k */
    protected float f15567k = 0.0f;
    /* renamed from: l */
    protected float f15568l = -1.0f;
    /* renamed from: m */
    protected C44491df f15569m = null;
    /* renamed from: n */
    protected String f15570n = null;
    /* renamed from: o */
    String f15571o = null;
    /* renamed from: p */
    protected GeoPoint f15572p = null;
    /* renamed from: q */
    protected GeoPoint f15573q = null;
    /* renamed from: r */
    protected GeoPoint f15574r = null;
    /* renamed from: s */
    protected float f15575s = 1.0f;
    /* renamed from: t */
    protected float f15576t = 1.0f;
    /* renamed from: u */
    protected float f15577u = 1.0f;
    /* renamed from: v */
    public boolean f15578v = false;
    /* renamed from: w */
    public boolean f15579w = false;
    /* renamed from: x */
    public boolean f15580x = true;
    /* renamed from: y */
    public C44490de f15581y = null;
    /* renamed from: z */
    public C5885hw f15582z;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hx$1 */
    class C58871 implements Runnable {
        C58871() {
        }

        public void run() {
            AppMethodBeat.m2504i(99639);
            try {
                if (C36899hx.this.f15544R != null) {
                    C36899hx.this.f15544R.mo57690a();
                }
                AppMethodBeat.m2505o(99639);
            } catch (NullPointerException e) {
                AppMethodBeat.m2505o(99639);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hx$2 */
    class C58882 implements Runnable {
        C58882() {
        }

        public void run() {
            AppMethodBeat.m2504i(99640);
            try {
                if (C36899hx.this.f15544R != null) {
                    C36899hx.this.f15544R.mo57691b();
                }
                AppMethodBeat.m2505o(99640);
            } catch (NullPointerException e) {
                AppMethodBeat.m2505o(99640);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hx$3 */
    class C369003 implements C31058b {
        C369003() {
        }

        /* renamed from: a */
        public void mo29455a(float f, float f2, float f3, float f4) {
            AppMethodBeat.m2504i(99641);
            C36899hx.this.f15564h = f;
            C36899hx.this.f15566j = f2;
            C36899hx.this.f15567k = f3;
            C36899hx.this.f15568l = f4;
            C36899hx.this.f15565i = true;
            if (C36899hx.this.f15543H != null) {
                C36899hx.this.f15543H.mo71717b((int) C36899hx.this.f15564h);
            }
            AppMethodBeat.m2505o(99641);
        }

        /* renamed from: a */
        public void mo29453a(float f) {
            AppMethodBeat.m2504i(99642);
            C36899hx.this.f15575s = f;
            if (C36899hx.this.f15543H != null) {
                C36899hx.this.f15543H.mo71707a(C36899hx.this.f15575s);
                C36899hx.this.f15569m.mo70777b(C36899hx.this.f15575s);
            }
            AppMethodBeat.m2505o(99642);
        }

        /* renamed from: a */
        public void mo29456a(int i, int i2) {
            AppMethodBeat.m2504i(99643);
            if (!(C36899hx.this.f15542G == null || C36899hx.this.f15572p == null)) {
                GeoPoint geoPoint = new GeoPoint();
                if (!C36899hx.this.f15540E || C36899hx.this.f15541F == null || C36899hx.this.f15542G.mo75386b() == null) {
                    C36899hx.this.f15572p.setLatitudeE6(i + 0);
                    C36899hx.this.f15572p.setLongitudeE6(i2 + 0);
                } else {
                    GeoPoint a = C36899hx.this.f15542G.mo75386b().mo20244t().mo29297a(new DoublePoint((double) C36899hx.this.f15538C, (double) C36899hx.this.f15539D));
                    int latitudeE6 = a.getLatitudeE6() - C36899hx.this.f15541F.getLatitudeE6();
                    int longitudeE6 = a.getLongitudeE6() - C36899hx.this.f15541F.getLongitudeE6();
                    geoPoint.setLatitudeE6(latitudeE6 + i);
                    geoPoint.setLongitudeE6(longitudeE6 + i2);
                    DoublePoint b = C36899hx.this.f15542G.mo75386b().mo20244t().mo29298b(geoPoint);
                    C36899hx.this.f15572p.setLatitudeE6((int) b.f2801y);
                    C36899hx.this.f15572p.setLongitudeE6((int) b.f2800x);
                }
                if (C36899hx.this.f15543H != null) {
                    C36899hx.this.f15543H.mo71710a(C36899hx.this.f15572p);
                }
            }
            AppMethodBeat.m2505o(99643);
        }

        /* renamed from: a */
        public void mo29454a(float f, float f2) {
            AppMethodBeat.m2504i(99644);
            C36899hx.this.f15576t = f;
            C36899hx.this.f15577u = f2;
            if (C36899hx.this.f15543H != null) {
                C36899hx.this.f15543H.mo71716b(C36899hx.this.f15576t, C36899hx.this.f15577u);
            }
            AppMethodBeat.m2505o(99644);
        }

        /* renamed from: b */
        public void mo29457b(float f) {
        }
    }

    public C36899hx(C31061iz c31061iz) {
        AppMethodBeat.m2504i(99645);
        this.f15542G = c31061iz;
        AppMethodBeat.m2505o(99645);
    }

    /* renamed from: e */
    public C44491df mo58883e() {
        return this.f15569m;
    }

    /* renamed from: a */
    public void mo58873a(C44491df c44491df) {
        AppMethodBeat.m2504i(99646);
        if (c44491df == null) {
            AppMethodBeat.m2505o(99646);
            return;
        }
        this.f15569m = c44491df;
        mo58870a(C36520ic.m60470a(c44491df.mo70776b()));
        mo58877b(c44491df.mo70788f(), c44491df.mo70789g());
        mo29442a(c44491df.mo70791i());
        mo58867a(c44491df.mo70797o());
        mo58872a(c44491df.mo70786e());
        mo58876b(c44491df.mo70793k());
        mo50175c(c44491df.mo70794l());
        mo50174a_(c44491df.mo70806x());
        this.f15389J = c44491df.mo70795m();
        this.f15553a = c44491df.mo70803u();
        m61551b(c44491df);
        AppMethodBeat.m2505o(99646);
    }

    /* renamed from: a */
    public void mo58872a(C41018cm c41018cm) {
        AppMethodBeat.m2504i(99647);
        if (this.f15542G == null || c41018cm == null) {
            AppMethodBeat.m2505o(99647);
            return;
        }
        C5838bl a = c41018cm.mo65065a();
        if (!(a == null || this.f15542G == null)) {
            Bitmap a2 = a.mo12311a(this.f15542G.mo65138i());
            m61548a(a.mo12312a());
            mo58878b(a2);
        }
        AppMethodBeat.m2505o(99647);
    }

    /* renamed from: a */
    public void mo58870a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99648);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(99648);
            return;
        }
        if (this.f15572p == null) {
            this.f15572p = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.f15572p.setLatitudeE6(geoPoint.getLatitudeE6());
            this.f15572p.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        this.f15536A = true;
        if (this.f15543H != null) {
            this.f15543H.mo71710a(this.f15572p);
        }
        AppMethodBeat.m2505o(99648);
    }

    /* renamed from: a_ */
    public void mo50174a_(int i) {
        AppMethodBeat.m2504i(99649);
        super.mo50174a_(i);
        if (this.f15543H != null) {
            this.f15543H.mo71709a(i);
        }
        if (this.f15582z != null) {
            this.f15543H.mo71709a(i);
        }
        AppMethodBeat.m2505o(99649);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: f */
    public void mo58884f() {
        AppMethodBeat.m2504i(99650);
        if (this.f15542G == null || !this.f15579w) {
            AppMethodBeat.m2505o(99650);
            return;
        }
        mo58870a(this.f15542G.mo50413F());
        AppMethodBeat.m2505o(99650);
    }

    /* renamed from: g */
    public GeoPoint mo58885g() {
        return this.f15572p;
    }

    /* renamed from: a */
    public void mo58867a(float f) {
        AppMethodBeat.m2504i(99651);
        this.f15564h = f;
        if (this.f15543H != null) {
            this.f15543H.mo71717b((int) this.f15564h);
        }
        AppMethodBeat.m2505o(99651);
    }

    /* renamed from: b */
    public void mo58877b(float f, float f2) {
        boolean z;
        AppMethodBeat.m2504i(99652);
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f == this.f15561e && f2 == this.f15562f) {
            z = false;
        } else {
            z = true;
        }
        this.f15563g = z;
        this.f15561e = f;
        this.f15562f = f2;
        if (this.f15543H != null) {
            this.f15543H.mo71708a(this.f15561e, this.f15562f);
        }
        if (this.f15582z != null && this.f15582z.mo12491j()) {
            mo58875a(false, false);
        }
        AppMethodBeat.m2505o(99652);
    }

    /* renamed from: h */
    public boolean mo58886h() {
        return this.f15563g;
    }

    /* renamed from: a */
    private void m61548a(String str) {
        synchronized (this.f15560d) {
            this.f15570n = str;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo58869a(Bitmap bitmap) {
        AppMethodBeat.m2504i(99653);
        synchronized (this.f15560d) {
            try {
                this.f15558b = bitmap;
                if (this.f15570n == null) {
                    this.f15570n = bitmap.toString();
                }
                if (this.f15543H != null) {
                    this.f15543H.mo71712a(this.f15570n, this.f15558b);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99653);
            }
        }
    }

    /* renamed from: b */
    public void mo58878b(Bitmap bitmap) {
        AppMethodBeat.m2504i(99654);
        if (bitmap == null) {
            AppMethodBeat.m2505o(99654);
            return;
        }
        mo58869a(bitmap);
        mo58887i();
        AppMethodBeat.m2505o(99654);
    }

    /* renamed from: i */
    public void mo58887i() {
        AppMethodBeat.m2504i(99655);
        synchronized (this.f15560d) {
            try {
                if (!(this.f15558b == null || this.f15558b.isRecycled())) {
                    this.f15559c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99655);
            }
        }
    }

    /* renamed from: a */
    public void mo29441a(GL10 gl10) {
        AppMethodBeat.m2504i(99656);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99656);
        } else if (mo29443a()) {
            mo58884f();
            mo58880b(gl10);
            if (this.f15542G.mo75386b() != null) {
                C16263gj z = this.f15542G.mo75386b().mo20250z();
                if (!(z == null || this.f15543H == null)) {
                    this.f15543H.mo20132b(z, this.f15542G.mo75386b().mo20244t());
                }
            }
            mo58900w();
            AppMethodBeat.m2505o(99656);
        } else {
            mo29445b();
            AppMethodBeat.m2505o(99656);
        }
    }

    /* renamed from: a */
    public boolean mo29444a(float f, float f2) {
        boolean z = false;
        AppMethodBeat.m2504i(99657);
        if (this.f15542G == null || !this.f15580x) {
            AppMethodBeat.m2505o(99657);
        } else if (this.f15543H != null) {
            z = this.f15543H.mo20130a(this.f15542G.mo75386b().mo20244t(), f, f2);
            if (z && this.f15546T != null) {
                this.f15546T.mo50171a(this.f15581y);
            }
            AppMethodBeat.m2505o(99657);
        } else {
            AppMethodBeat.m2505o(99657);
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo29443a() {
        AppMethodBeat.m2504i(99658);
        if (mo57758B() == null) {
            boolean z = this.f13965O;
            AppMethodBeat.m2505o(99658);
            return z;
        } else if (this.f13965O && this.f15388I) {
            AppMethodBeat.m2505o(99658);
            return true;
        } else {
            AppMethodBeat.m2505o(99658);
            return false;
        }
    }

    /* renamed from: a */
    public void mo29442a(boolean z) {
        AppMethodBeat.m2504i(99659);
        this.f13965O = z;
        if (this.f15543H != null) {
            this.f15543H.mo71713a(z);
        }
        if (!(this.f15542G == null || this.f15542G.mo75386b() == null)) {
            this.f15542G.mo75386b().mo20154a();
        }
        AppMethodBeat.m2505o(99659);
    }

    /* renamed from: b */
    public void mo29445b() {
        AppMethodBeat.m2504i(99660);
        if (this.f15543H != null) {
            this.f15543H.mo71724g();
        }
        AppMethodBeat.m2505o(99660);
    }

    /* renamed from: c */
    public void mo29449c() {
    }

    /* renamed from: d */
    public void mo29450d() {
        AppMethodBeat.m2504i(99661);
        this.f15572p = null;
        if (this.f15543H != null) {
            this.f15543H.mo71724g();
        }
        if (this.f15582z != null) {
            this.f15582z.mo12490i();
        }
        AppMethodBeat.m2505o(99661);
    }

    /* renamed from: a */
    public void mo58874a(C31056if c31056if) {
        AppMethodBeat.m2504i(99662);
        this.f15545S = c31056if;
        if (this.f15545S != null) {
            this.f15545S.mo29510a(this.f15557ad);
        }
        AppMethodBeat.m2505o(99662);
    }

    /* renamed from: j */
    public boolean mo58888j() {
        AppMethodBeat.m2504i(99663);
        if (this.f15542G == null || this.f15545S == null) {
            AppMethodBeat.m2505o(99663);
            return false;
        }
        GeoPoint geoPoint = this.f15572p;
        if (this.f15537B && this.f15542G.mo75386b() != null) {
            geoPoint = this.f15542G.mo75386b().mo20244t().mo29297a(new DoublePoint((double) this.f15538C, (double) this.f15539D));
            this.f15541F = new GeoPoint(geoPoint);
        }
        boolean a = this.f15545S.mo29512a(geoPoint, this.f15574r);
        AppMethodBeat.m2505o(99663);
        return a;
    }

    /* renamed from: k */
    public Rect mo58889k() {
        AppMethodBeat.m2504i(99664);
        Rect rect;
        if (this.f15543H == null || this.f15542G == null || this.f15542G.mo75386b() == null) {
            rect = new Rect();
            AppMethodBeat.m2505o(99664);
            return rect;
        }
        rect = this.f15543H.mo20125a(this.f15542G.mo75386b().mo20244t());
        AppMethodBeat.m2505o(99664);
        return rect;
    }

    /* renamed from: l */
    public Rect mo58890l() {
        AppMethodBeat.m2504i(99665);
        Rect rect;
        if (this.f15543H == null || this.f15542G == null || this.f15542G.mo75386b() == null) {
            rect = new Rect();
            AppMethodBeat.m2505o(99665);
            return rect;
        }
        rect = this.f15543H.mo71715b(this.f15542G.mo75386b().mo20244t());
        AppMethodBeat.m2505o(99665);
        return rect;
    }

    /* renamed from: m */
    public String mo58891m() {
        AppMethodBeat.m2504i(99666);
        C44491df e = mo58883e();
        if (e == null) {
            AppMethodBeat.m2505o(99666);
            return null;
        }
        String w = e.mo70805w();
        AppMethodBeat.m2505o(99666);
        return w;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo58880b(GL10 gl10) {
        AppMethodBeat.m2504i(99667);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99667);
            return false;
        } else if (this.f15545S != null) {
            this.f15545S.mo50393d();
            this.f15540E = this.f15545S.mo50392c();
            if (this.f15540E && this.f15542G.mo75386b() != null) {
                this.f15542G.mo75386b().mo20154a();
            }
            AppMethodBeat.m2505o(99667);
            return true;
        } else {
            AppMethodBeat.m2505o(99667);
            return false;
        }
    }

    /* renamed from: b */
    public void mo58876b(float f) {
        AppMethodBeat.m2504i(99668);
        this.f15575s = f;
        if (this.f15543H != null) {
            this.f15543H.mo71707a(f);
        }
        AppMethodBeat.m2505o(99668);
    }

    /* renamed from: b */
    public void mo58879b(boolean z) {
        this.f15580x = z;
    }

    /* renamed from: c */
    public void mo50175c(float f) {
        AppMethodBeat.m2504i(99669);
        this.f13964N = f;
        if (this.f15543H != null) {
            this.f15543H.mo71720c((int) f);
        }
        AppMethodBeat.m2505o(99669);
    }

    /* renamed from: n */
    public float mo58892n() {
        return this.f15564h;
    }

    /* renamed from: c */
    public void mo58881c(boolean z) {
        AppMethodBeat.m2504i(99670);
        this.f15537B = z;
        if (this.f15543H != null) {
            this.f15543H.mo71718b(z);
        }
        AppMethodBeat.m2505o(99670);
    }

    /* renamed from: a */
    public void mo58868a(int i, int i2) {
        AppMethodBeat.m2504i(99671);
        this.f15538C = i;
        this.f15539D = i2;
        if (this.f15543H != null) {
            mo58881c(true);
            this.f15543H.mo71710a(new GeoPoint(this.f15539D, this.f15538C));
        }
        AppMethodBeat.m2505o(99671);
    }

    /* renamed from: o */
    public boolean mo58893o() {
        return this.f15537B;
    }

    /* renamed from: p */
    public Point mo58894p() {
        AppMethodBeat.m2504i(99672);
        Point point = new Point(this.f15538C, this.f15539D);
        AppMethodBeat.m2505o(99672);
        return point;
    }

    /* renamed from: d */
    public int mo58882d(boolean z) {
        AppMethodBeat.m2504i(99673);
        if (this.f15558b == null || this.f15543H == null) {
            AppMethodBeat.m2505o(99673);
            return 0;
        }
        int height = this.f15558b.getHeight();
        if (z) {
            height = (int) (((float) height) * (1.0f - this.f15543H.mo71719c()));
            AppMethodBeat.m2505o(99673);
            return height;
        }
        height = (int) (((float) height) * this.f15543H.mo71719c());
        AppMethodBeat.m2505o(99673);
        return height;
    }

    /* renamed from: q */
    public int mo58895q() {
        AppMethodBeat.m2504i(99674);
        if (this.f15558b == null || this.f15543H == null) {
            AppMethodBeat.m2505o(99674);
            return 0;
        }
        int width = this.f15558b.getWidth();
        width = (int) ((((float) width) * this.f15543H.mo71714b()) - (((float) width) * 0.5f));
        AppMethodBeat.m2505o(99674);
        return width;
    }

    /* renamed from: r */
    public boolean mo57761r() {
        return true;
    }

    /* renamed from: s */
    public boolean mo58896s() {
        return this.f15540E;
    }

    /* renamed from: t */
    public C44680l mo58897t() {
        return this.f15543H;
    }

    /* renamed from: b */
    private void m61551b(C44491df c44491df) {
        AppMethodBeat.m2504i(99675);
        if (this.f15542G == null || c44491df == null || this.f15543H != null) {
            AppMethodBeat.m2505o(99675);
            return;
        }
        C41719m c41719m = new C41719m();
        c41719m.mo67435a(C36520ic.m60470a(c44491df.mo70776b())).mo67431a(c44491df.mo70793k()).mo67432a(c44491df.mo70788f(), c44491df.mo70789g());
        String str = Math.random();
        try {
            str = c44491df.mo70786e().mo65065a().mo12312a();
        } catch (NullPointerException e) {
        }
        c41719m.mo67436a(str, c44491df.mo70786e().mo65064a(this.f15542G.mo65138i())).mo67433a((int) c44491df.mo70797o()).mo67439b(c44491df.mo70796n()).mo67438b((int) c44491df.mo70794l()).mo67444d(this.f15537B).mo67442c(c44491df.mo70775a()).mo67447e(c44491df.mo70800r()).mo67437a(c44491df.mo70804v()).mo67441c(c44491df.mo70806x());
        this.f15543H = new C44680l(c41719m);
        AppMethodBeat.m2505o(99675);
    }

    /* renamed from: a */
    private void m61547a(C44490de c44490de) {
        AppMethodBeat.m2504i(99676);
        if (this.f15547U == null) {
            this.f15547U = m61552c(c44490de);
        } else {
            m61550b(c44490de);
        }
        this.f15548V = this.f15547U;
        AppMethodBeat.m2505o(99676);
    }

    /* renamed from: b */
    private void m61550b(C44490de c44490de) {
        AppMethodBeat.m2504i(99677);
        if (this.f15547U == null || c44490de == null) {
            AppMethodBeat.m2505o(99677);
            return;
        }
        TextView textView = (TextView) this.f15547U.findViewById(1);
        if (textView != null) {
            String f = c44490de.mo70747f();
            if (StringUtil.isEmpty(f)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(f);
            }
        }
        TextView textView2 = (TextView) this.f15547U.findViewById(2);
        if (textView2 != null) {
            String g = c44490de.mo70748g();
            if (StringUtil.isEmpty(g)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(g);
            }
        }
        if ((textView != null && textView.getVisibility() == 8 && textView2 != null && textView2.getVisibility() == 8) || (textView == null && textView2 == null)) {
            this.f15547U = null;
        }
        AppMethodBeat.m2505o(99677);
    }

    /* renamed from: a */
    private View m61543a(View view) {
        AppMethodBeat.m2504i(99678);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99678);
            return null;
        }
        if (this.f15549W == null) {
            this.f15549W = m61544a(this.f15542G.mo65138i());
            this.f15550X = new LinearLayout(this.f15542G.mo65138i());
            this.f15550X.setGravity(17);
            this.f15550X.setOrientation(1);
            this.f15550X.setPadding(10, 10, 10, 30);
            this.f15549W.addView(this.f15550X, new LayoutParams(-2, -2));
        }
        if (this.f15550X != null) {
            this.f15550X.removeAllViews();
            this.f15550X.addView(view);
        }
        View view2 = this.f15549W;
        AppMethodBeat.m2505o(99678);
        return view2;
    }

    /* renamed from: c */
    private View m61552c(C44490de c44490de) {
        AppMethodBeat.m2504i(99679);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99679);
            return null;
        }
        View a = m61544a(this.f15542G.mo65138i());
        m61546a((ViewGroup) a, this.f15542G.mo65138i());
        a.setVisibility(8);
        TextView textView = (TextView) a.findViewById(1);
        if (textView != null) {
            String f = c44490de.mo70747f();
            if (StringUtil.isEmpty(f)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(f);
            }
        }
        TextView textView2 = (TextView) a.findViewById(2);
        if (textView2 != null) {
            String g = c44490de.mo70748g();
            if (StringUtil.isEmpty(g)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(g);
            }
        }
        if ((textView == null || textView.getVisibility() != 8 || textView2 == null || textView2.getVisibility() != 8) && !(textView == null && textView2 == null)) {
            AppMethodBeat.m2505o(99679);
            return a;
        }
        AppMethodBeat.m2505o(99679);
        return null;
    }

    /* renamed from: a */
    private LinearLayout m61544a(Context context) {
        AppMethodBeat.m2504i(99680);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Bitmap b = C36520ic.m60482b(context, "marker_infowindow.9.png");
        if (b != null) {
            linearLayout.setBackgroundDrawable(new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), new Rect(), null));
        }
        AppMethodBeat.m2505o(99680);
        return linearLayout;
    }

    /* renamed from: a */
    private void m61546a(ViewGroup viewGroup, Context context) {
        AppMethodBeat.m2504i(99681);
        if (viewGroup == null || context == null) {
            AppMethodBeat.m2505o(99681);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(10, 10, 10, 30);
        TextView textView = new TextView(context);
        textView.setGravity(3);
        textView.setId(1);
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setText("Title");
        linearLayout.addView(textView, new LayoutParams(-2, -2));
        textView = new TextView(context);
        textView.setGravity(3);
        textView.setId(2);
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setText("Snippet");
        linearLayout.addView(textView, new LayoutParams(-2, -2));
        viewGroup.addView(linearLayout);
        AppMethodBeat.m2505o(99681);
    }

    /* renamed from: u */
    public void mo58898u() {
        AppMethodBeat.m2504i(99682);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99682);
            return;
        }
        this.f15542G.mo50449a("", true);
        this.f15542G.mo75386b().mo20154a();
        synchronized (this.f15542G.f14265b) {
            try {
                if (this.f15582z == null) {
                } else {
                    this.f15582z.mo12486d(false);
                    AppMethodBeat.m2505o(99682);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99682);
            }
        }
    }

    /* renamed from: a */
    public void mo58875a(boolean z, boolean z2) {
        AppMethodBeat.m2504i(99683);
        if (this.f15542G == null) {
            AppMethodBeat.m2505o(99683);
            return;
        }
        this.f15563g = false;
        Bitmap a = C24388ht.m37844a(this.f15548V);
        if (a == null) {
            AppMethodBeat.m2505o(99683);
            return;
        }
        synchronized (this.f15542G.f14265b) {
            try {
                if (this.f15582z == null) {
                    this.f15582z = new C5885hw(this.f15542G);
                    if (z2) {
                        this.f15582z.mo12486d(true);
                        this.f15542G.f14209W = this.f15582z;
                    }
                    this.f15582z.mo12485c(true);
                }
                if (!z) {
                    this.f15582z.mo12486d(true);
                    this.f15542G.f14209W = this.f15582z;
                }
                this.f15582z.mo12483b(a);
                this.f15582z.mo12482b(mo58882d(false), mo58882d(true));
                this.f15582z.mo12478a(mo58895q());
                if (this.f15542G.f14271f != null) {
                    this.f15582z.mo12479a(this.f15542G.mo50480q());
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(99683);
                }
            }
        }
        if (this.f15542G.mo75386b() != null) {
            this.f15542G.mo75386b().mo20154a();
        }
        AppMethodBeat.m2505o(99683);
    }

    /* renamed from: a */
    public void mo58871a(C36456ac c36456ac, C30989b c30989b) {
        AppMethodBeat.m2504i(99684);
        View a = c30989b.mo29179a(this.f15581y);
        if (a == null) {
            a = c30989b.mo29180b(this.f15581y);
            if (a == null) {
                m61547a(this.f15581y);
                this.f15548V = this.f15547U;
                AppMethodBeat.m2505o(99684);
                return;
            }
            a = m61543a(a);
            if (this.f15548V == null) {
                this.f15548V = a;
            } else if (!this.f15548V.equals(a)) {
                if (c36456ac.indexOfChild(this.f15548V) >= 0) {
                    c36456ac.removeView(this.f15548V);
                }
                this.f15548V = a;
                AppMethodBeat.m2505o(99684);
                return;
            }
            AppMethodBeat.m2505o(99684);
            return;
        }
        if (this.f15548V == null) {
            this.f15548V = a;
        } else if (!this.f15548V.equals(a)) {
            if (c36456ac.indexOfChild(this.f15548V) >= 0) {
                c36456ac.removeView(this.f15548V);
            }
            this.f15548V = a;
        }
        if (this.f15548V != null && this.f15548V.getLayoutParams() == null) {
            this.f15548V.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
        AppMethodBeat.m2505o(99684);
    }

    /* renamed from: v */
    public void mo58899v() {
        AppMethodBeat.m2504i(99685);
        m61547a(this.f15581y);
        AppMethodBeat.m2505o(99685);
    }

    /* renamed from: w */
    public void mo58900w() {
        AppMethodBeat.m2504i(99686);
        C5885hw c5885hw = this.f15582z;
        if (c5885hw != null && c5885hw.mo12491j()) {
            c5885hw.mo29447b(mo58893o());
            c5885hw.mo12484b(mo58885g());
            c5885hw.mo12480a(mo58883e());
            if (mo58893o() && !mo58896s()) {
                Point p = mo58894p();
                c5885hw.mo29438a(p.x, p.y);
            }
            c5885hw.mo29441a(null);
        }
        AppMethodBeat.m2505o(99686);
    }

    /* renamed from: x */
    public boolean mo58901x() {
        AppMethodBeat.m2504i(99687);
        Rect l = mo58890l();
        int width = this.f15542G.getWidth();
        int height = this.f15542G.getHeight();
        if (l.left < 0 || l.top < 0 || l.right > width || l.bottom > height) {
            AppMethodBeat.m2505o(99687);
            return false;
        }
        AppMethodBeat.m2505o(99687);
        return true;
    }

    /* renamed from: y */
    public boolean mo57762y() {
        AppMethodBeat.m2504i(99688);
        if (this.f15553a == null || !"AUTH_MARKER".equals(this.f15553a.toString())) {
            AppMethodBeat.m2505o(99688);
            return false;
        }
        AppMethodBeat.m2505o(99688);
        return true;
    }
}
