package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.map.lib.a;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class gd implements ge {
    protected gg a = null;
    private Context b;
    private f c;
    private gm d;
    private gp e;
    private gy f;
    private float g = 0.5f;
    private Handler h = new Handler();
    private int i = 0;

    static /* synthetic */ void a(gd gdVar, float f, float f2, boolean z) {
        AppMethodBeat.i(99015);
        gdVar.a(f, f2, z);
        AppMethodBeat.o(99015);
    }

    public gd(gg ggVar, Context context) {
        AppMethodBeat.i(98989);
        this.a = ggVar;
        this.b = context;
        k();
        AppMethodBeat.o(98989);
    }

    public void a_() {
        AppMethodBeat.i(98990);
        if (this.a != null) {
            this.a.a_();
        }
        AppMethodBeat.o(98990);
    }

    public void a(gf gfVar) {
        AppMethodBeat.i(98991);
        this.e.a(gfVar);
        AppMethodBeat.o(98991);
    }

    public void b(gf gfVar) {
        AppMethodBeat.i(98992);
        this.e.b(gfVar);
        AppMethodBeat.o(98992);
    }

    public f b() {
        return this.c;
    }

    public gm c() {
        return this.d;
    }

    public void a(a aVar, hf hfVar) {
        AppMethodBeat.i(98993);
        if (this.d.a(this.b.getApplicationContext(), aVar, hfVar)) {
            this.d.a().k();
        }
        AppMethodBeat.o(98993);
    }

    public void a(float f, float f2, float f3) {
        AppMethodBeat.i(98994);
        if (!(this.d == null || this.h == null)) {
            float l = this.d.a().l();
            final float a = a(f3);
            final boolean z = ((double) Math.abs(l - a)) > 1.0E-4d;
            this.i = 0;
            final float f4 = (f2 - this.g) / 10.0f;
            final float f5 = f;
            final float f6 = f2;
            final float f7 = f3;
            this.h.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(98988);
                    gd.this.g = gd.this.g + f4;
                    gd.a(gd.this, f5, gd.this.g, true);
                    if (gd.this.i = gd.this.i + 1 < 10) {
                        gd.this.h.postDelayed(this, 16);
                        AppMethodBeat.o(98988);
                        return;
                    }
                    gd.a(gd.this, f5, f6, true);
                    if (f7 >= 3.0f && f7 <= 20.0f) {
                        if (z) {
                            gd.this.d.a().a((int) f7, new Runnable() {
                                public void run() {
                                    AppMethodBeat.i(98987);
                                    gd.this.d.a().a(a);
                                    AppMethodBeat.o(98987);
                                }
                            }, false);
                            AppMethodBeat.o(98988);
                            return;
                        }
                        gd.this.d.a().a(a);
                    }
                    AppMethodBeat.o(98988);
                }
            });
        }
        AppMethodBeat.o(98994);
    }

    public int getEGLContextHash() {
        AppMethodBeat.i(98995);
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        if (egl10 != null) {
            EGLContext eglGetCurrentContext = egl10.eglGetCurrentContext();
            if (eglGetCurrentContext != null) {
                int hashCode = eglGetCurrentContext.hashCode();
                AppMethodBeat.o(98995);
                return hashCode;
            }
        }
        AppMethodBeat.o(98995);
        return 0;
    }

    public void d() {
        AppMethodBeat.i(98996);
        if (this.d != null) {
            getEGLContextHash();
            this.d.n();
        }
        AppMethodBeat.o(98996);
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(98997);
        if (this.f != null) {
            this.f.b();
            this.f.a(bArr);
        }
        AppMethodBeat.o(98997);
    }

    public void e() {
        AppMethodBeat.i(98998);
        if (this.f != null) {
            this.f.b();
        }
        this.d.l();
        AppMethodBeat.o(98998);
    }

    public void f() {
        AppMethodBeat.i(98999);
        if (this.f != null) {
            this.f.a();
        }
        this.d.m();
        AppMethodBeat.o(98999);
    }

    public void g() {
        AppMethodBeat.i(99000);
        b.a();
        AppMethodBeat.o(99000);
    }

    public void setZOrderMediaOverlay(boolean z) {
        AppMethodBeat.i(99001);
        if (this.a != null) {
            this.a.setZOrderMediaOverlay(z);
        }
        AppMethodBeat.o(99001);
    }

    public ge getVectorMapDelegate() {
        return this;
    }

    public int getWidth() {
        AppMethodBeat.i(99002);
        if (this.a != null) {
            int width = this.a.getWidth();
            AppMethodBeat.o(99002);
            return width;
        }
        AppMethodBeat.o(99002);
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public int getHeight() {
        AppMethodBeat.i(99003);
        if (this.a != null) {
            int height = this.a.getHeight();
            AppMethodBeat.o(99003);
            return height;
        }
        AppMethodBeat.o(99003);
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public boolean a(MotionEvent motionEvent) {
        AppMethodBeat.i(99004);
        if (this.e != null) {
            boolean onTouch = this.e.onTouch(null, motionEvent);
            AppMethodBeat.o(99004);
            return onTouch;
        }
        AppMethodBeat.o(99004);
        return false;
    }

    public void h() {
        AppMethodBeat.i(99005);
        if (this.a != null) {
            this.a.a_();
        }
        AppMethodBeat.o(99005);
    }

    public Context i() {
        return this.b;
    }

    public void a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(99006);
        this.d.a(gl10);
        AppMethodBeat.o(99006);
    }

    public void a(GL10 gl10, int i, int i2) {
        AppMethodBeat.i(99007);
        this.d.a(i, i2);
        AppMethodBeat.o(99007);
    }

    public void j() {
    }

    public boolean a(GL10 gl10) {
        AppMethodBeat.i(99008);
        boolean b = this.d.b(gl10);
        AppMethodBeat.o(99008);
        return b;
    }

    public void k() {
        AppMethodBeat.i(99009);
        if (this.b == null) {
            AppMethodBeat.o(99009);
            return;
        }
        this.e = new gp(this);
        if (this.d == null) {
            this.d = new gm(this.b, this);
        }
        this.c = new f(this.d);
        this.e.a(this.d);
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        this.d.b(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
        this.f = new gy(c());
        this.f.start();
        AppMethodBeat.o(99009);
    }

    private void a(float f, float f2, boolean z) {
        AppMethodBeat.i(99010);
        this.d.a().a(f, f2, 0, z);
        AppMethodBeat.o(99010);
    }

    private float a(float f) {
        AppMethodBeat.i(99011);
        int i = (int) f;
        float pow = (((float) (1 << (i - 3))) * 3.0517578E-5f) * ((float) Math.pow(2.0d, (double) (f - ((float) i))));
        AppMethodBeat.o(99011);
        return pow;
    }

    public void l() {
        AppMethodBeat.i(99012);
        if (this.d != null) {
            this.d.q();
        }
        AppMethodBeat.o(99012);
    }

    /* Access modifiers changed, original: protected */
    public boolean m() {
        AppMethodBeat.i(99013);
        Context i = i();
        if (i == null) {
            AppMethodBeat.o(99013);
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) i.getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        if (VERSION.SDK_INT < 14) {
            AppMethodBeat.o(99013);
            return isEnabled;
        }
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            AppMethodBeat.o(99013);
            return true;
        }
        AppMethodBeat.o(99013);
        return false;
    }

    public boolean n() {
        AppMethodBeat.i(99014);
        if (this.d == null || !this.d.F()) {
            AppMethodBeat.o(99014);
            return false;
        }
        AppMethodBeat.o(99014);
        return true;
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }
}
