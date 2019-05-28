package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.map.lib.util.MathUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class gp implements OnTouchListener {
    private static final float a = ((float) Math.cos(0.0017453292780017621d));
    private boolean b;
    private boolean c;
    private int d;
    private PointF e = new PointF();
    private PointF f = new PointF();
    private PointF g = new PointF();
    private PointF h = new PointF();
    private PointF i = new PointF();
    private PointF j = new PointF();
    private PointF k = new PointF();
    private long l = 0;
    private GestureDetector m;
    private gq n;
    private fn o;
    private WeakReference<gd> p;

    class a extends SimpleOnGestureListener {
        private PointF b;
        private boolean c;

        private a() {
            AppMethodBeat.i(99408);
            this.b = new PointF();
            this.c = true;
            AppMethodBeat.o(99408);
        }

        /* synthetic */ a(gp gpVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(99409);
            gp.this.n.b(motionEvent.getX(), motionEvent.getY());
            AppMethodBeat.o(99409);
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(99410);
            gp.this.n.c(f, f2);
            AppMethodBeat.o(99410);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.i(99411);
            if (!(gp.this.p == null || gp.this.p.get() == null || !((gd) gp.this.p.get()).m())) {
                double sqrt = Math.sqrt((double) ((f * f) + (f2 * f2)));
                if ((motionEvent != null && (motionEvent.getX() < 0.0f || motionEvent.getY() < 0.0f)) || ((motionEvent2 != null && (motionEvent2.getX() < 0.0f || motionEvent2.getY() < 0.0f)) || sqrt > 50.0d)) {
                    AppMethodBeat.o(99411);
                    return true;
                }
            }
            gp.this.n.d(-f, -f2);
            AppMethodBeat.o(99411);
            return true;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        public void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(99412);
            if (!gp.this.b) {
                gp.this.n.e(motionEvent.getX(), motionEvent.getY());
            }
            AppMethodBeat.o(99412);
        }

        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(99413);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.c = true;
                    gp.this.m.setIsLongpressEnabled(false);
                    this.b.set(motionEvent.getX(), motionEvent.getY());
                    gp.this.n.f(x, y);
                    break;
                case 1:
                    if (this.c) {
                        if (gp.a(gp.this, x, y)) {
                            gp.this.n.a(x, y);
                        } else {
                            gp.this.n.a(x, y);
                        }
                    }
                    this.b.set(0.0f, 0.0f);
                    gp.this.m.setIsLongpressEnabled(true);
                    gp.this.n.h(x, y);
                    break;
                case 2:
                    float f = y - this.b.y;
                    if (Math.abs(x - this.b.x) > 10.0f || Math.abs(f) > 10.0f) {
                        this.c = false;
                        gp.this.n.g(x, y);
                    }
                    gp.this.m.setIsLongpressEnabled(true);
                    break;
            }
            AppMethodBeat.o(99413);
            return true;
        }
    }

    static {
        AppMethodBeat.i(99424);
        AppMethodBeat.o(99424);
    }

    public gp(gd gdVar) {
        AppMethodBeat.i(99414);
        this.p = new WeakReference(gdVar);
        if (gdVar.i() != null) {
            this.m = new GestureDetector(gdVar.i(), new a(this, null));
        } else {
            this.m = new GestureDetector(new a(this, null));
        }
        this.n = new gq();
        AppMethodBeat.o(99414);
    }

    public void a(fn fnVar) {
        this.o = fnVar;
    }

    public void a(gf gfVar) {
        AppMethodBeat.i(99415);
        synchronized (this.n) {
            try {
                this.n.a(gfVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99415);
            }
        }
    }

    public void b(gf gfVar) {
        AppMethodBeat.i(99416);
        synchronized (this.n) {
            try {
                this.n.b(gfVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99416);
            }
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(99417);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.l = 0;
                this.b = false;
                this.n.i(motionEvent.getX(), motionEvent.getY());
            case 1:
            case 3:
                long currentTimeMillis = System.currentTimeMillis() - this.l;
                if (this.d == 0 && currentTimeMillis > 0 && currentTimeMillis < 200 && c()) {
                    this.n.b();
                }
                this.n.j(motionEvent.getX(), motionEvent.getY());
            case 2:
                if (this.b && !this.c) {
                    a(this.e, this.f, motionEvent);
                    a();
                    AppMethodBeat.o(99417);
                    break;
                }
                this.n.k(motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                this.l = System.currentTimeMillis();
                this.d = 0;
                this.b = true;
                this.c = false;
                a(this.g, this.h, motionEvent);
                this.n.c();
                AppMethodBeat.o(99417);
                break;
            case 6:
                if (!this.c) {
                    this.c = true;
                    this.n.d();
                    AppMethodBeat.o(99417);
                    break;
                }
        }
        if (!this.b) {
            this.m.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(99417);
        return true;
    }

    private void a() {
        double d;
        AppMethodBeat.i(99418);
        float f = this.e.x - this.g.x;
        float f2 = this.e.y - this.g.y;
        float f3 = this.f.x - this.h.x;
        float f4 = this.f.y - this.h.y;
        if (this.d == 0 || this.d == 1) {
            d = this.d == 0 ? 24.0d : 8.0d;
            if ((((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) && f2 * f4 > 0.0f && ((double) Math.abs(f2)) > ((double) Math.abs(f)) * 1.2d && ((double) Math.abs(f4)) > ((double) Math.abs(f3)) * 1.2d) {
                this.d = 1;
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                this.n.a(Math.abs(f2) > Math.abs(f4) ? f2 : f4);
                AppMethodBeat.o(99418);
                return;
            }
        }
        double d2 = (double) (this.h.x - this.g.x);
        double d3 = (double) (this.h.y - this.g.y);
        double d4 = (double) (this.f.x - this.e.x);
        double d5 = (double) (this.f.y - this.e.y);
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        double sqrt2 = Math.sqrt((d4 * d4) + (d5 * d5));
        if ((this.d == 0 || this.d == 2) && sqrt * sqrt2 > 0.0d && Math.abs(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2)) < ((double) a)) {
            d = (180.0d * Math.acos(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2))) / 3.141592653589793d;
            if ((d2 * d5) - (d3 * d4) < 0.0d) {
                d = -d;
            }
            if (Math.abs(d) > (this.d == 0 ? 5.0d : 1.0d)) {
                this.d = 2;
                if (b()) {
                    this.k.set((float) (this.o == null ? 0 : this.o.g().width() / 2), (float) (this.o == null ? 0 : this.o.g().height() / 2));
                    this.n.a(this.k, this.k, (float) d);
                } else {
                    this.i.set((this.g.x + this.h.x) / 2.0f, (this.g.y + this.h.y) / 2.0f);
                    this.j.set((this.e.x + this.f.x) / 2.0f, (this.e.y + this.f.y) / 2.0f);
                    this.n.a(this.i, this.j, (float) d);
                }
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                AppMethodBeat.o(99418);
                return;
            }
        }
        if ((this.d == 0 || this.d == 3) && sqrt > 0.0d) {
            if (Math.abs((sqrt2 / sqrt) - 1.0d) > (this.d == 0 ? 0.05d : 0.025d)) {
                this.d = 3;
                this.i.set((this.g.x + this.h.x) / 2.0f, (this.g.y + this.h.y) / 2.0f);
                this.j.set((this.e.x + this.f.x) / 2.0f, (this.e.y + this.f.y) / 2.0f);
                this.n.a(this.i, this.j, sqrt, sqrt2);
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                AppMethodBeat.o(99418);
                return;
            }
        }
        if (this.d == 0 || this.d == 4) {
            d = this.d == 0 ? 80.0d : 8.0d;
            if (((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) {
                this.d = 4;
                this.n.d((f + f3) / 2.0f, (f2 + f4) / 2.0f);
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                AppMethodBeat.o(99418);
                return;
            }
        }
        AppMethodBeat.o(99418);
    }

    private boolean b() {
        AppMethodBeat.i(99419);
        PointF poiWith2Line = MathUtil.getPoiWith2Line(this.h, this.g, this.f, this.e);
        if (poiWith2Line == null) {
            AppMethodBeat.o(99419);
            return false;
        }
        boolean a = a(poiWith2Line.x, poiWith2Line.y);
        AppMethodBeat.o(99419);
        return a;
    }

    private boolean a(float f, float f2) {
        float f3 = 0.0f;
        AppMethodBeat.i(99420);
        int width = this.o == null ? 0 : this.o.g().width() / 2;
        int height = this.o == null ? 0 : this.o.g().height() / 2;
        float width2 = this.o == null ? 0.0f : ((float) this.o.g().width()) / 3.0f;
        if (this.o != null) {
            f3 = ((float) this.o.g().height()) / 3.0f;
        }
        if (Math.abs(f - ((float) width)) >= width2 || Math.abs(f2 - ((float) height)) >= f3) {
            AppMethodBeat.o(99420);
            return false;
        }
        AppMethodBeat.o(99420);
        return true;
    }

    private boolean b(float f, float f2) {
        AppMethodBeat.i(99421);
        boolean a = a(f, f2);
        AppMethodBeat.o(99421);
        return a;
    }

    private boolean c() {
        double d = (double) (this.g.x - this.h.x);
        double d2 = (double) (this.g.y - this.h.y);
        return (d * d) + (d2 * d2) > 2500.0d;
    }

    private void a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        AppMethodBeat.i(99422);
        try {
            float x = motionEvent.getX(0);
            float x2 = motionEvent.getX(1);
            float y = motionEvent.getY(0);
            float y2 = motionEvent.getY(1);
            pointF.set(x, y);
            pointF2.set(x2, y2);
            AppMethodBeat.o(99422);
        } catch (Exception e) {
            AppMethodBeat.o(99422);
        }
    }
}
