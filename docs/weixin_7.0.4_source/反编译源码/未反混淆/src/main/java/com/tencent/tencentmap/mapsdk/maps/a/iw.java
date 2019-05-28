package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ak;

public class iw extends View implements gg {
    private Context a;
    private iz b;
    private Object c;
    private int d;
    private int e;
    private ak f;
    private iy g;
    private boolean h = true;
    private boolean i = false;

    public iw(Context context, ak akVar) {
        super(context);
        AppMethodBeat.i(99883);
        if (!(akVar == null || context == null)) {
            Object d = akVar.d();
            if (d == null) {
                AppMethodBeat.o(99883);
                return;
            }
            this.a = context.getApplicationContext();
            this.c = d;
            this.d = akVar.e();
            this.e = akVar.f();
            if (this.e <= 0 || this.d <= 0) {
                this.d = 0;
                this.e = 0;
            }
            this.f = akVar;
            this.b = new iz(this, this.a, this.f);
        }
        AppMethodBeat.o(99883);
    }

    public void a_() {
        AppMethodBeat.i(99884);
        if (this.g != null) {
            synchronized (this.g) {
                try {
                    this.g.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(99884);
                }
            }
            return;
        }
        AppMethodBeat.o(99884);
    }

    public void e() {
        AppMethodBeat.i(99885);
        if (this.b != null) {
            this.b.e();
        }
        if (this.g != null) {
            this.g.b();
        }
        b();
        c();
        AppMethodBeat.o(99885);
    }

    public void f() {
        AppMethodBeat.i(99886);
        if (this.b != null) {
            this.b.f();
        }
        if (this.g != null) {
            this.g.a();
        }
        AppMethodBeat.o(99886);
    }

    public void g() {
        AppMethodBeat.i(99887);
        if (this.b != null) {
            this.b.g();
        }
        if (this.g != null) {
            this.g.c();
        }
        AppMethodBeat.o(99887);
    }

    public void setZOrderMediaOverlay(boolean z) {
    }

    public ge getVectorMapDelegate() {
        return this.b;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(99888);
        if (this.b != null) {
            boolean a = this.b.a(motionEvent);
            AppMethodBeat.o(99888);
            return a;
        }
        AppMethodBeat.o(99888);
        return false;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(99889);
        if (this.b != null) {
            this.d = i;
            this.e = i2;
            this.b.a(null, i, i2);
            this.b.a(i, i2);
            this.b.h();
            this.h = true;
        }
        AppMethodBeat.o(99889);
    }

    private void b() {
        AppMethodBeat.i(99890);
        if (this.b != null && this.h) {
            this.b.a(null, null);
            this.b.a(null, this.d, this.e);
            this.b.a(this.d, this.e);
            this.h = false;
        }
        AppMethodBeat.o(99890);
    }

    private void c() {
        AppMethodBeat.i(99891);
        if (this.g == null) {
            this.g = new iy(this.c, this.b);
        }
        if (!this.i) {
            this.g.start();
            this.i = true;
        }
        AppMethodBeat.o(99891);
    }
}
