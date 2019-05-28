package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gp */
public class C16266gp implements OnTouchListener {
    /* renamed from: a */
    private static final float f3342a = ((float) Math.cos(0.0017453292780017621d));
    /* renamed from: b */
    private boolean f3343b;
    /* renamed from: c */
    private boolean f3344c;
    /* renamed from: d */
    private int f3345d;
    /* renamed from: e */
    private PointF f3346e = new PointF();
    /* renamed from: f */
    private PointF f3347f = new PointF();
    /* renamed from: g */
    private PointF f3348g = new PointF();
    /* renamed from: h */
    private PointF f3349h = new PointF();
    /* renamed from: i */
    private PointF f3350i = new PointF();
    /* renamed from: j */
    private PointF f3351j = new PointF();
    /* renamed from: k */
    private PointF f3352k = new PointF();
    /* renamed from: l */
    private long f3353l = 0;
    /* renamed from: m */
    private GestureDetector f3354m;
    /* renamed from: n */
    private C5882gq f3355n;
    /* renamed from: o */
    private C5876fn f3356o;
    /* renamed from: p */
    private WeakReference<C46787gd> f3357p;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gp$a */
    class C16267a extends SimpleOnGestureListener {
        /* renamed from: b */
        private PointF f3359b;
        /* renamed from: c */
        private boolean f3360c;

        private C16267a() {
            AppMethodBeat.m2504i(99408);
            this.f3359b = new PointF();
            this.f3360c = true;
            AppMethodBeat.m2505o(99408);
        }

        /* synthetic */ C16267a(C16266gp c16266gp, C162681 c162681) {
            this();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(99409);
            C16266gp.this.f3355n.mo12463b(motionEvent.getX(), motionEvent.getY());
            AppMethodBeat.m2505o(99409);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(99410);
            C16266gp.this.f3355n.mo12465c(f, f2);
            AppMethodBeat.m2505o(99410);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(99411);
            if (!(C16266gp.this.f3357p == null || C16266gp.this.f3357p.get() == null || !((C46787gd) C16266gp.this.f3357p.get()).mo75392m())) {
                double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2)));
                if ((motionEvent != null && (motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f)) || ((motionEvent2 != null && (motionEvent2.getX() < 0.0f || motionEvent2.getY() < 0.0f)) || sqrt > 50.0d)) {
                    AppMethodBeat.m2505o(99411);
                    return true;
                }
            }
            C16266gp.this.f3355n.mo12467d(-f, -f2);
            AppMethodBeat.m2505o(99411);
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(99412);
            if (!C16266gp.this.f3343b) {
                C16266gp.this.f3355n.mo12468e(motionEvent.getX(), motionEvent.getY());
            }
            AppMethodBeat.m2505o(99412);
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(99413);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f3360c = true;
                    C16266gp.this.f3354m.setIsLongpressEnabled(false);
                    this.f3359b.set(motionEvent.getX(), motionEvent.getY());
                    C16266gp.this.f3355n.mo12469f(x, y);
                    break;
                case 1:
                    if (this.f3360c) {
                        if (C16266gp.m24937a(C16266gp.this, x, y)) {
                            C16266gp.this.f3355n.mo12458a(x, y);
                        } else {
                            C16266gp.this.f3355n.mo12458a(x, y);
                        }
                    }
                    this.f3359b.set(0.0f, 0.0f);
                    C16266gp.this.f3354m.setIsLongpressEnabled(true);
                    C16266gp.this.f3355n.mo12471h(x, y);
                    break;
                case 2:
                    float f = y - this.f3359b.y;
                    if (Math.abs(x - this.f3359b.x) > 10.0f || Math.abs(f) > 10.0f) {
                        this.f3360c = false;
                        C16266gp.this.f3355n.mo12470g(x, y);
                    }
                    C16266gp.this.f3354m.setIsLongpressEnabled(true);
                    break;
            }
            AppMethodBeat.m2505o(99413);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(99424);
        AppMethodBeat.m2505o(99424);
    }

    public C16266gp(C46787gd c46787gd) {
        AppMethodBeat.m2504i(99414);
        this.f3357p = new WeakReference(c46787gd);
        if (c46787gd.mo65138i() != null) {
            this.f3354m = new GestureDetector(c46787gd.mo65138i(), new C16267a(this, null));
        } else {
            this.f3354m = new GestureDetector(new C16267a(this, null));
        }
        this.f3355n = new C5882gq();
        AppMethodBeat.m2505o(99414);
    }

    /* renamed from: a */
    public void mo29423a(C5876fn c5876fn) {
        this.f3356o = c5876fn;
    }

    /* renamed from: a */
    public void mo29424a(C44513gf c44513gf) {
        AppMethodBeat.m2504i(99415);
        synchronized (this.f3355n) {
            try {
                this.f3355n.mo12456a(c44513gf);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99415);
            }
        }
    }

    /* renamed from: b */
    public void mo29425b(C44513gf c44513gf) {
        AppMethodBeat.m2504i(99416);
        synchronized (this.f3355n) {
            try {
                this.f3355n.mo12461b(c44513gf);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99416);
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99417);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f3353l = 0;
                this.f3343b = false;
                this.f3355n.mo12472i(motionEvent.getX(), motionEvent.getY());
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis() - this.f3353l;
                if (this.f3345d == 0 && currentTimeMillis > 0 && currentTimeMillis < 200 && m24941c()) {
                    this.f3355n.mo12462b();
                }
                this.f3355n.mo12473j(motionEvent.getX(), motionEvent.getY());
            case 2:
                if (this.f3343b && !this.f3344c) {
                    m24935a(this.f3346e, this.f3347f, motionEvent);
                    m24934a();
                    AppMethodBeat.m2505o(99417);
                    break;
                }
                this.f3355n.mo12474k(motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                this.f3353l = System.currentTimeMillis();
                this.f3345d = 0;
                this.f3343b = true;
                this.f3344c = false;
                m24935a(this.f3348g, this.f3349h, motionEvent);
                this.f3355n.mo12464c();
                AppMethodBeat.m2505o(99417);
                break;
            case 6:
                if (!this.f3344c) {
                    this.f3344c = true;
                    this.f3355n.mo12466d();
                    AppMethodBeat.m2505o(99417);
                    break;
                }
        }
        if (!this.f3343b) {
            this.f3354m.onTouchEvent(motionEvent);
        }
        AppMethodBeat.m2505o(99417);
        return true;
    }

    /* renamed from: a */
    private void m24934a() {
        double d;
        AppMethodBeat.m2504i(99418);
        float f = this.f3346e.x - this.f3348g.x;
        float f2 = this.f3346e.y - this.f3348g.y;
        float f3 = this.f3347f.x - this.f3349h.x;
        float f4 = this.f3347f.y - this.f3349h.y;
        if (this.f3345d == 0 || this.f3345d == 1) {
            d = this.f3345d == 0 ? 24.0d : 8.0d;
            if ((((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) && f2 * f4 > 0.0f && ((double) Math.abs(f2)) > ((double) Math.abs(f)) * 1.2d && ((double) Math.abs(f4)) > ((double) Math.abs(f3)) * 1.2d) {
                this.f3345d = 1;
                this.f3348g.set(this.f3346e.x, this.f3346e.y);
                this.f3349h.set(this.f3347f.x, this.f3347f.y);
                this.f3355n.mo12457a(Math.abs(f2) > Math.abs(f4) ? f2 : f4);
                AppMethodBeat.m2505o(99418);
                return;
            }
        }
        double d2 = (double) (this.f3349h.x - this.f3348g.x);
        double d3 = (double) (this.f3349h.y - this.f3348g.y);
        double d4 = (double) (this.f3347f.x - this.f3346e.x);
        double d5 = (double) (this.f3347f.y - this.f3346e.y);
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        double sqrt2 = Math.sqrt((d4 * d4) + (d5 * d5));
        if ((this.f3345d == 0 || this.f3345d == 2) && sqrt * sqrt2 > 0.0d && Math.abs(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2)) < ((double) f3342a)) {
            d = (180.0d * Math.acos(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2))) / 3.141592653589793d;
            if ((d2 * d5) - (d3 * d4) < 0.0d) {
                d = -d;
            }
            if (Math.abs(d) > (this.f3345d == 0 ? 5.0d : 1.0d)) {
                this.f3345d = 2;
                if (m24939b()) {
                    this.f3352k.set((float) (this.f3356o == null ? 0 : this.f3356o.mo12446g().width() / 2), (float) (this.f3356o == null ? 0 : this.f3356o.mo12446g().height() / 2));
                    this.f3355n.mo12460a(this.f3352k, this.f3352k, (float) d);
                } else {
                    this.f3350i.set((this.f3348g.x + this.f3349h.x) / 2.0f, (this.f3348g.y + this.f3349h.y) / 2.0f);
                    this.f3351j.set((this.f3346e.x + this.f3347f.x) / 2.0f, (this.f3346e.y + this.f3347f.y) / 2.0f);
                    this.f3355n.mo12460a(this.f3350i, this.f3351j, (float) d);
                }
                this.f3348g.set(this.f3346e.x, this.f3346e.y);
                this.f3349h.set(this.f3347f.x, this.f3347f.y);
                AppMethodBeat.m2505o(99418);
                return;
            }
        }
        if ((this.f3345d == 0 || this.f3345d == 3) && sqrt > 0.0d) {
            if (Math.abs((sqrt2 / sqrt) - 1.0d) > (this.f3345d == 0 ? 0.05d : 0.025d)) {
                this.f3345d = 3;
                this.f3350i.set((this.f3348g.x + this.f3349h.x) / 2.0f, (this.f3348g.y + this.f3349h.y) / 2.0f);
                this.f3351j.set((this.f3346e.x + this.f3347f.x) / 2.0f, (this.f3346e.y + this.f3347f.y) / 2.0f);
                this.f3355n.mo12459a(this.f3350i, this.f3351j, sqrt, sqrt2);
                this.f3348g.set(this.f3346e.x, this.f3346e.y);
                this.f3349h.set(this.f3347f.x, this.f3347f.y);
                AppMethodBeat.m2505o(99418);
                return;
            }
        }
        if (this.f3345d == 0 || this.f3345d == 4) {
            d = this.f3345d == 0 ? 80.0d : 8.0d;
            if (((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) {
                this.f3345d = 4;
                this.f3355n.mo12467d((f + f3) / 2.0f, (f2 + f4) / 2.0f);
                this.f3348g.set(this.f3346e.x, this.f3346e.y);
                this.f3349h.set(this.f3347f.x, this.f3347f.y);
                AppMethodBeat.m2505o(99418);
                return;
            }
        }
        AppMethodBeat.m2505o(99418);
    }

    /* renamed from: b */
    private boolean m24939b() {
        AppMethodBeat.m2504i(99419);
        PointF poiWith2Line = MathUtil.getPoiWith2Line(this.f3349h, this.f3348g, this.f3347f, this.f3346e);
        if (poiWith2Line == null) {
            AppMethodBeat.m2505o(99419);
            return false;
        }
        boolean a = m24936a(poiWith2Line.x, poiWith2Line.y);
        AppMethodBeat.m2505o(99419);
        return a;
    }

    /* renamed from: a */
    private boolean m24936a(float f, float f2) {
        float f3 = 0.0f;
        AppMethodBeat.m2504i(99420);
        int width = this.f3356o == null ? 0 : this.f3356o.mo12446g().width() / 2;
        int height = this.f3356o == null ? 0 : this.f3356o.mo12446g().height() / 2;
        float width2 = this.f3356o == null ? 0.0f : ((float) this.f3356o.mo12446g().width()) / 3.0f;
        if (this.f3356o != null) {
            f3 = ((float) this.f3356o.mo12446g().height()) / 3.0f;
        }
        if (Math.abs(f - ((float) width)) >= width2 || Math.abs(f2 - ((float) height)) >= f3) {
            AppMethodBeat.m2505o(99420);
            return false;
        }
        AppMethodBeat.m2505o(99420);
        return true;
    }

    /* renamed from: b */
    private boolean m24940b(float f, float f2) {
        AppMethodBeat.m2504i(99421);
        boolean a = m24936a(f, f2);
        AppMethodBeat.m2505o(99421);
        return a;
    }

    /* renamed from: c */
    private boolean m24941c() {
        double d = (double) (this.f3348g.x - this.f3349h.x);
        double d2 = (double) (this.f3348g.y - this.f3349h.y);
        return (d * d) + (d2 * d2) > 2500.0d;
    }

    /* renamed from: a */
    private void m24935a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99422);
        try {
            float x = motionEvent.getX(0);
            float x2 = motionEvent.getX(1);
            float y = motionEvent.getY(0);
            float y2 = motionEvent.getY(1);
            pointF.set(x, y);
            pointF2.set(x2, y2);
            AppMethodBeat.m2505o(99422);
        } catch (Exception e) {
            AppMethodBeat.m2505o(99422);
        }
    }
}
