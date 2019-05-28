package com.tencent.tencentmap.mapsdk.maps.a;

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
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.element.m;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.a.ac;
import com.tencent.tencentmap.mapsdk.a.aj;
import com.tencent.tencentmap.mapsdk.a.bl;
import com.tencent.tencentmap.mapsdk.a.cl;
import com.tencent.tencentmap.mapsdk.a.cm;
import com.tencent.tencentmap.mapsdk.a.de;
import com.tencent.tencentmap.mapsdk.a.df;
import com.tencent.tencentmap.mapsdk.maps.a.if.b;
import javax.microedition.khronos.opengles.GL10;

public class hx extends hz {
    private boolean A = false;
    private boolean B = false;
    private int C = 0;
    private int D = 0;
    private boolean E = false;
    private GeoPoint F = null;
    private iz G = null;
    private l H;
    private cl R = null;
    private if S = null;
    private aj.l T;
    private View U = null;
    private View V = null;
    private ViewGroup W = null;
    private LinearLayout X = null;
    private boolean Y = false;
    private final int Z = 1;
    protected Object a = null;
    private final int aa = 2;
    private Runnable ab = new Runnable() {
        public void run() {
            AppMethodBeat.i(99639);
            try {
                if (hx.this.R != null) {
                    hx.this.R.a();
                }
                AppMethodBeat.o(99639);
            } catch (NullPointerException e) {
                AppMethodBeat.o(99639);
            }
        }
    };
    private Runnable ac = new Runnable() {
        public void run() {
            AppMethodBeat.i(99640);
            try {
                if (hx.this.R != null) {
                    hx.this.R.b();
                }
                AppMethodBeat.o(99640);
            } catch (NullPointerException e) {
                AppMethodBeat.o(99640);
            }
        }
    };
    private b ad = new b() {
        public void a(float f, float f2, float f3, float f4) {
            AppMethodBeat.i(99641);
            hx.this.h = f;
            hx.this.j = f2;
            hx.this.k = f3;
            hx.this.l = f4;
            hx.this.i = true;
            if (hx.this.H != null) {
                hx.this.H.b((int) hx.this.h);
            }
            AppMethodBeat.o(99641);
        }

        public void a(float f) {
            AppMethodBeat.i(99642);
            hx.this.s = f;
            if (hx.this.H != null) {
                hx.this.H.a(hx.this.s);
                hx.this.m.b(hx.this.s);
            }
            AppMethodBeat.o(99642);
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(99643);
            if (!(hx.this.G == null || hx.this.p == null)) {
                GeoPoint geoPoint = new GeoPoint();
                if (!hx.this.E || hx.this.F == null || hx.this.G.b() == null) {
                    hx.this.p.setLatitudeE6(i + 0);
                    hx.this.p.setLongitudeE6(i2 + 0);
                } else {
                    GeoPoint a = hx.this.G.b().t().a(new DoublePoint((double) hx.this.C, (double) hx.this.D));
                    int latitudeE6 = a.getLatitudeE6() - hx.this.F.getLatitudeE6();
                    int longitudeE6 = a.getLongitudeE6() - hx.this.F.getLongitudeE6();
                    geoPoint.setLatitudeE6(latitudeE6 + i);
                    geoPoint.setLongitudeE6(longitudeE6 + i2);
                    DoublePoint b = hx.this.G.b().t().b(geoPoint);
                    hx.this.p.setLatitudeE6((int) b.y);
                    hx.this.p.setLongitudeE6((int) b.x);
                }
                if (hx.this.H != null) {
                    hx.this.H.a(hx.this.p);
                }
            }
            AppMethodBeat.o(99643);
        }

        public void a(float f, float f2) {
            AppMethodBeat.i(99644);
            hx.this.t = f;
            hx.this.u = f2;
            if (hx.this.H != null) {
                hx.this.H.b(hx.this.t, hx.this.u);
            }
            AppMethodBeat.o(99644);
        }

        public void b(float f) {
        }
    };
    protected Bitmap b = null;
    boolean c = false;
    protected byte[] d = new byte[0];
    float e = 0.5f;
    float f = 0.5f;
    boolean g = false;
    protected float h = 0.0f;
    protected boolean i = false;
    protected float j = 0.0f;
    protected float k = 0.0f;
    protected float l = -1.0f;
    protected df m = null;
    protected String n = null;
    String o = null;
    protected GeoPoint p = null;
    protected GeoPoint q = null;
    protected GeoPoint r = null;
    protected float s = 1.0f;
    protected float t = 1.0f;
    protected float u = 1.0f;
    public boolean v = false;
    public boolean w = false;
    public boolean x = true;
    public de y = null;
    public hw z;

    public hx(iz izVar) {
        AppMethodBeat.i(99645);
        this.G = izVar;
        AppMethodBeat.o(99645);
    }

    public df e() {
        return this.m;
    }

    public void a(df dfVar) {
        AppMethodBeat.i(99646);
        if (dfVar == null) {
            AppMethodBeat.o(99646);
            return;
        }
        this.m = dfVar;
        a(ic.a(dfVar.b()));
        b(dfVar.f(), dfVar.g());
        a(dfVar.i());
        a(dfVar.o());
        a(dfVar.e());
        b(dfVar.k());
        c(dfVar.l());
        a_(dfVar.x());
        this.J = dfVar.m();
        this.a = dfVar.u();
        b(dfVar);
        AppMethodBeat.o(99646);
    }

    public void a(cm cmVar) {
        AppMethodBeat.i(99647);
        if (this.G == null || cmVar == null) {
            AppMethodBeat.o(99647);
            return;
        }
        bl a = cmVar.a();
        if (!(a == null || this.G == null)) {
            Bitmap a2 = a.a(this.G.i());
            a(a.a());
            b(a2);
        }
        AppMethodBeat.o(99647);
    }

    public void a(GeoPoint geoPoint) {
        AppMethodBeat.i(99648);
        if (geoPoint == null) {
            AppMethodBeat.o(99648);
            return;
        }
        if (this.p == null) {
            this.p = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        } else {
            this.p.setLatitudeE6(geoPoint.getLatitudeE6());
            this.p.setLongitudeE6(geoPoint.getLongitudeE6());
        }
        this.A = true;
        if (this.H != null) {
            this.H.a(this.p);
        }
        AppMethodBeat.o(99648);
    }

    public void a_(int i) {
        AppMethodBeat.i(99649);
        super.a_(i);
        if (this.H != null) {
            this.H.a(i);
        }
        if (this.z != null) {
            this.H.a(i);
        }
        AppMethodBeat.o(99649);
    }

    /* Access modifiers changed, original: protected */
    public void f() {
        AppMethodBeat.i(99650);
        if (this.G == null || !this.w) {
            AppMethodBeat.o(99650);
            return;
        }
        a(this.G.F());
        AppMethodBeat.o(99650);
    }

    public GeoPoint g() {
        return this.p;
    }

    public void a(float f) {
        AppMethodBeat.i(99651);
        this.h = f;
        if (this.H != null) {
            this.H.b((int) this.h);
        }
        AppMethodBeat.o(99651);
    }

    public void b(float f, float f2) {
        boolean z;
        AppMethodBeat.i(99652);
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
        if (f == this.e && f2 == this.f) {
            z = false;
        } else {
            z = true;
        }
        this.g = z;
        this.e = f;
        this.f = f2;
        if (this.H != null) {
            this.H.a(this.e, this.f);
        }
        if (this.z != null && this.z.j()) {
            a(false, false);
        }
        AppMethodBeat.o(99652);
    }

    public boolean h() {
        return this.g;
    }

    private void a(String str) {
        synchronized (this.d) {
            this.n = str;
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(Bitmap bitmap) {
        AppMethodBeat.i(99653);
        synchronized (this.d) {
            try {
                this.b = bitmap;
                if (this.n == null) {
                    this.n = bitmap.toString();
                }
                if (this.H != null) {
                    this.H.a(this.n, this.b);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99653);
            }
        }
    }

    public void b(Bitmap bitmap) {
        AppMethodBeat.i(99654);
        if (bitmap == null) {
            AppMethodBeat.o(99654);
            return;
        }
        a(bitmap);
        i();
        AppMethodBeat.o(99654);
    }

    public void i() {
        AppMethodBeat.i(99655);
        synchronized (this.d) {
            try {
                if (!(this.b == null || this.b.isRecycled())) {
                    this.c = true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99655);
            }
        }
    }

    public void a(GL10 gl10) {
        AppMethodBeat.i(99656);
        if (this.G == null) {
            AppMethodBeat.o(99656);
        } else if (a()) {
            f();
            b(gl10);
            if (this.G.b() != null) {
                gj z = this.G.b().z();
                if (!(z == null || this.H == null)) {
                    this.H.b(z, this.G.b().t());
                }
            }
            w();
            AppMethodBeat.o(99656);
        } else {
            b();
            AppMethodBeat.o(99656);
        }
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        AppMethodBeat.i(99657);
        if (this.G == null || !this.x) {
            AppMethodBeat.o(99657);
        } else if (this.H != null) {
            z = this.H.a(this.G.b().t(), f, f2);
            if (z && this.T != null) {
                this.T.a(this.y);
            }
            AppMethodBeat.o(99657);
        } else {
            AppMethodBeat.o(99657);
        }
        return z;
    }

    public boolean a() {
        AppMethodBeat.i(99658);
        if (B() == null) {
            boolean z = this.O;
            AppMethodBeat.o(99658);
            return z;
        } else if (this.O && this.I) {
            AppMethodBeat.o(99658);
            return true;
        } else {
            AppMethodBeat.o(99658);
            return false;
        }
    }

    public void a(boolean z) {
        AppMethodBeat.i(99659);
        this.O = z;
        if (this.H != null) {
            this.H.a(z);
        }
        if (!(this.G == null || this.G.b() == null)) {
            this.G.b().a();
        }
        AppMethodBeat.o(99659);
    }

    public void b() {
        AppMethodBeat.i(99660);
        if (this.H != null) {
            this.H.g();
        }
        AppMethodBeat.o(99660);
    }

    public void c() {
    }

    public void d() {
        AppMethodBeat.i(99661);
        this.p = null;
        if (this.H != null) {
            this.H.g();
        }
        if (this.z != null) {
            this.z.i();
        }
        AppMethodBeat.o(99661);
    }

    public void a(if ifVar) {
        AppMethodBeat.i(99662);
        this.S = ifVar;
        if (this.S != null) {
            this.S.a(this.ad);
        }
        AppMethodBeat.o(99662);
    }

    public boolean j() {
        AppMethodBeat.i(99663);
        if (this.G == null || this.S == null) {
            AppMethodBeat.o(99663);
            return false;
        }
        GeoPoint geoPoint = this.p;
        if (this.B && this.G.b() != null) {
            geoPoint = this.G.b().t().a(new DoublePoint((double) this.C, (double) this.D));
            this.F = new GeoPoint(geoPoint);
        }
        boolean a = this.S.a(geoPoint, this.r);
        AppMethodBeat.o(99663);
        return a;
    }

    public Rect k() {
        AppMethodBeat.i(99664);
        Rect rect;
        if (this.H == null || this.G == null || this.G.b() == null) {
            rect = new Rect();
            AppMethodBeat.o(99664);
            return rect;
        }
        rect = this.H.a(this.G.b().t());
        AppMethodBeat.o(99664);
        return rect;
    }

    public Rect l() {
        AppMethodBeat.i(99665);
        Rect rect;
        if (this.H == null || this.G == null || this.G.b() == null) {
            rect = new Rect();
            AppMethodBeat.o(99665);
            return rect;
        }
        rect = this.H.b(this.G.b().t());
        AppMethodBeat.o(99665);
        return rect;
    }

    public String m() {
        AppMethodBeat.i(99666);
        df e = e();
        if (e == null) {
            AppMethodBeat.o(99666);
            return null;
        }
        String w = e.w();
        AppMethodBeat.o(99666);
        return w;
    }

    /* Access modifiers changed, original: protected */
    public boolean b(GL10 gl10) {
        AppMethodBeat.i(99667);
        if (this.G == null) {
            AppMethodBeat.o(99667);
            return false;
        } else if (this.S != null) {
            this.S.d();
            this.E = this.S.c();
            if (this.E && this.G.b() != null) {
                this.G.b().a();
            }
            AppMethodBeat.o(99667);
            return true;
        } else {
            AppMethodBeat.o(99667);
            return false;
        }
    }

    public void b(float f) {
        AppMethodBeat.i(99668);
        this.s = f;
        if (this.H != null) {
            this.H.a(f);
        }
        AppMethodBeat.o(99668);
    }

    public void b(boolean z) {
        this.x = z;
    }

    public void c(float f) {
        AppMethodBeat.i(99669);
        this.N = f;
        if (this.H != null) {
            this.H.c((int) f);
        }
        AppMethodBeat.o(99669);
    }

    public float n() {
        return this.h;
    }

    public void c(boolean z) {
        AppMethodBeat.i(99670);
        this.B = z;
        if (this.H != null) {
            this.H.b(z);
        }
        AppMethodBeat.o(99670);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(99671);
        this.C = i;
        this.D = i2;
        if (this.H != null) {
            c(true);
            this.H.a(new GeoPoint(this.D, this.C));
        }
        AppMethodBeat.o(99671);
    }

    public boolean o() {
        return this.B;
    }

    public Point p() {
        AppMethodBeat.i(99672);
        Point point = new Point(this.C, this.D);
        AppMethodBeat.o(99672);
        return point;
    }

    public int d(boolean z) {
        AppMethodBeat.i(99673);
        if (this.b == null || this.H == null) {
            AppMethodBeat.o(99673);
            return 0;
        }
        int height = this.b.getHeight();
        if (z) {
            height = (int) (((float) height) * (1.0f - this.H.c()));
            AppMethodBeat.o(99673);
            return height;
        }
        height = (int) (((float) height) * this.H.c());
        AppMethodBeat.o(99673);
        return height;
    }

    public int q() {
        AppMethodBeat.i(99674);
        if (this.b == null || this.H == null) {
            AppMethodBeat.o(99674);
            return 0;
        }
        int width = this.b.getWidth();
        width = (int) ((((float) width) * this.H.b()) - (((float) width) * 0.5f));
        AppMethodBeat.o(99674);
        return width;
    }

    public boolean r() {
        return true;
    }

    public boolean s() {
        return this.E;
    }

    public l t() {
        return this.H;
    }

    private void b(df dfVar) {
        AppMethodBeat.i(99675);
        if (this.G == null || dfVar == null || this.H != null) {
            AppMethodBeat.o(99675);
            return;
        }
        m mVar = new m();
        mVar.a(ic.a(dfVar.b())).a(dfVar.k()).a(dfVar.f(), dfVar.g());
        String str = Math.random();
        try {
            str = dfVar.e().a().a();
        } catch (NullPointerException e) {
        }
        mVar.a(str, dfVar.e().a(this.G.i())).a((int) dfVar.o()).b(dfVar.n()).b((int) dfVar.l()).d(this.B).c(dfVar.a()).e(dfVar.r()).a(dfVar.v()).c(dfVar.x());
        this.H = new l(mVar);
        AppMethodBeat.o(99675);
    }

    private void a(de deVar) {
        AppMethodBeat.i(99676);
        if (this.U == null) {
            this.U = c(deVar);
        } else {
            b(deVar);
        }
        this.V = this.U;
        AppMethodBeat.o(99676);
    }

    private void b(de deVar) {
        AppMethodBeat.i(99677);
        if (this.U == null || deVar == null) {
            AppMethodBeat.o(99677);
            return;
        }
        TextView textView = (TextView) this.U.findViewById(1);
        if (textView != null) {
            String f = deVar.f();
            if (StringUtil.isEmpty(f)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(f);
            }
        }
        TextView textView2 = (TextView) this.U.findViewById(2);
        if (textView2 != null) {
            String g = deVar.g();
            if (StringUtil.isEmpty(g)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(g);
            }
        }
        if ((textView != null && textView.getVisibility() == 8 && textView2 != null && textView2.getVisibility() == 8) || (textView == null && textView2 == null)) {
            this.U = null;
        }
        AppMethodBeat.o(99677);
    }

    private View a(View view) {
        AppMethodBeat.i(99678);
        if (this.G == null) {
            AppMethodBeat.o(99678);
            return null;
        }
        if (this.W == null) {
            this.W = a(this.G.i());
            this.X = new LinearLayout(this.G.i());
            this.X.setGravity(17);
            this.X.setOrientation(1);
            this.X.setPadding(10, 10, 10, 30);
            this.W.addView(this.X, new LayoutParams(-2, -2));
        }
        if (this.X != null) {
            this.X.removeAllViews();
            this.X.addView(view);
        }
        View view2 = this.W;
        AppMethodBeat.o(99678);
        return view2;
    }

    private View c(de deVar) {
        AppMethodBeat.i(99679);
        if (this.G == null) {
            AppMethodBeat.o(99679);
            return null;
        }
        View a = a(this.G.i());
        a((ViewGroup) a, this.G.i());
        a.setVisibility(8);
        TextView textView = (TextView) a.findViewById(1);
        if (textView != null) {
            String f = deVar.f();
            if (StringUtil.isEmpty(f)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(f);
            }
        }
        TextView textView2 = (TextView) a.findViewById(2);
        if (textView2 != null) {
            String g = deVar.g();
            if (StringUtil.isEmpty(g)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(g);
            }
        }
        if ((textView == null || textView.getVisibility() != 8 || textView2 == null || textView2.getVisibility() != 8) && !(textView == null && textView2 == null)) {
            AppMethodBeat.o(99679);
            return a;
        }
        AppMethodBeat.o(99679);
        return null;
    }

    private LinearLayout a(Context context) {
        AppMethodBeat.i(99680);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Bitmap b = ic.b(context, "marker_infowindow.9.png");
        if (b != null) {
            linearLayout.setBackgroundDrawable(new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), new Rect(), null));
        }
        AppMethodBeat.o(99680);
        return linearLayout;
    }

    private void a(ViewGroup viewGroup, Context context) {
        AppMethodBeat.i(99681);
        if (viewGroup == null || context == null) {
            AppMethodBeat.o(99681);
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
        AppMethodBeat.o(99681);
    }

    public void u() {
        AppMethodBeat.i(99682);
        if (this.G == null) {
            AppMethodBeat.o(99682);
            return;
        }
        this.G.a("", true);
        this.G.b().a();
        synchronized (this.G.b) {
            try {
                if (this.z == null) {
                } else {
                    this.z.d(false);
                    AppMethodBeat.o(99682);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99682);
            }
        }
    }

    public void a(boolean z, boolean z2) {
        AppMethodBeat.i(99683);
        if (this.G == null) {
            AppMethodBeat.o(99683);
            return;
        }
        this.g = false;
        Bitmap a = ht.a(this.V);
        if (a == null) {
            AppMethodBeat.o(99683);
            return;
        }
        synchronized (this.G.b) {
            try {
                if (this.z == null) {
                    this.z = new hw(this.G);
                    if (z2) {
                        this.z.d(true);
                        this.G.W = this.z;
                    }
                    this.z.c(true);
                }
                if (!z) {
                    this.z.d(true);
                    this.G.W = this.z;
                }
                this.z.b(a);
                this.z.b(d(false), d(true));
                this.z.a(q());
                if (this.G.f != null) {
                    this.z.a(this.G.q());
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(99683);
                }
            }
        }
        if (this.G.b() != null) {
            this.G.b().a();
        }
        AppMethodBeat.o(99683);
    }

    public void a(ac acVar, aj.b bVar) {
        AppMethodBeat.i(99684);
        View a = bVar.a(this.y);
        if (a == null) {
            a = bVar.b(this.y);
            if (a == null) {
                a(this.y);
                this.V = this.U;
                AppMethodBeat.o(99684);
                return;
            }
            a = a(a);
            if (this.V == null) {
                this.V = a;
            } else if (!this.V.equals(a)) {
                if (acVar.indexOfChild(this.V) >= 0) {
                    acVar.removeView(this.V);
                }
                this.V = a;
                AppMethodBeat.o(99684);
                return;
            }
            AppMethodBeat.o(99684);
            return;
        }
        if (this.V == null) {
            this.V = a;
        } else if (!this.V.equals(a)) {
            if (acVar.indexOfChild(this.V) >= 0) {
                acVar.removeView(this.V);
            }
            this.V = a;
        }
        if (this.V != null && this.V.getLayoutParams() == null) {
            this.V.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
        AppMethodBeat.o(99684);
    }

    public void v() {
        AppMethodBeat.i(99685);
        a(this.y);
        AppMethodBeat.o(99685);
    }

    public void w() {
        AppMethodBeat.i(99686);
        hw hwVar = this.z;
        if (hwVar != null && hwVar.j()) {
            hwVar.b(o());
            hwVar.b(g());
            hwVar.a(e());
            if (o() && !s()) {
                Point p = p();
                hwVar.a(p.x, p.y);
            }
            hwVar.a(null);
        }
        AppMethodBeat.o(99686);
    }

    public boolean x() {
        AppMethodBeat.i(99687);
        Rect l = l();
        int width = this.G.getWidth();
        int height = this.G.getHeight();
        if (l.left < 0 || l.top < 0 || l.right > width || l.bottom > height) {
            AppMethodBeat.o(99687);
            return false;
        }
        AppMethodBeat.o(99687);
        return true;
    }

    public boolean y() {
        AppMethodBeat.i(99688);
        if (this.a == null || !"AUTH_MARKER".equals(this.a.toString())) {
            AppMethodBeat.o(99688);
            return false;
        }
        AppMethodBeat.o(99688);
        return true;
    }
}
