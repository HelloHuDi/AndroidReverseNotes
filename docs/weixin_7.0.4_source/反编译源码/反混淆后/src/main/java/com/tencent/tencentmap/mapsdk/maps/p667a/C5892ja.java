package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.p822gl.C25724e;
import com.tencent.map.lib.p822gl.C25724e.C25725m;
import com.tencent.map.lib.p822gl.C25724e.C25727g;
import com.tencent.map.lib.p822gl.C25724e.C25730f;
import com.tencent.map.lib.p822gl.JNICallback.C17847f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C44480ak;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ja */
public class C5892ja extends C25724e implements C17847f, C25725m, C44514gg {
    /* renamed from: a */
    private C31061iz f1648a;
    /* renamed from: b */
    private boolean f1649b;
    /* renamed from: c */
    private Object f1650c;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ja$2 */
    class C58932 implements C25727g {
        C58932() {
        }

        /* renamed from: a */
        public EGLSurface mo12513a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.m2504i(99986);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, C5892ja.this.f1650c, null);
            } catch (IllegalArgumentException | OutOfMemoryError e) {
            }
            AppMethodBeat.m2505o(99986);
            return eGLSurface;
        }

        /* renamed from: a */
        public void mo12514a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(99987);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.m2505o(99987);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ja$1 */
    class C58941 implements C25730f {
        C58941() {
        }

        /* renamed from: a */
        public void mo12516a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(99984);
            byte[] bArr = new byte[1];
            C5892ja.m9143a(C5892ja.this, bArr);
            synchronized (bArr) {
                try {
                    bArr.wait(1000);
                } catch (InterruptedException e) {
                    C1015d.m2290b(Log.getStackTraceString(e));
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(99984);
                }
            }
            C5892ja.m9142a(C5892ja.this);
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
            AppMethodBeat.m2505o(99984);
        }

        /* renamed from: a */
        public EGLContext mo12515a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(99985);
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            AppMethodBeat.m2505o(99985);
            return eglCreateContext;
        }
    }

    public C31061iz getVectorMapDelegate() {
        return this.f1648a;
    }

    public C5892ja(Context context, C44480ak c44480ak) {
        super(context);
        AppMethodBeat.m2504i(99988);
        if (!(c44480ak == null || c44480ak.mo70663d() == null)) {
            this.f1650c = c44480ak.mo70663d();
        }
        mo12503d();
        this.f1648a = new C31061iz(this, getContext().getApplicationContext(), c44480ak);
        setContentDescription("地图");
        AppMethodBeat.m2505o(99988);
    }

    /* renamed from: a */
    public void mo12500a(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(99989);
        if (this.f1648a != null) {
            this.f1648a.mo12500a(gl10, eGLConfig);
        }
        AppMethodBeat.m2505o(99989);
    }

    /* renamed from: a */
    public void mo12499a(GL10 gl10, int i, int i2) {
        AppMethodBeat.m2504i(99990);
        if (this.f1648a != null) {
            this.f1648a.mo12499a(gl10, i, i2);
        }
        AppMethodBeat.m2505o(99990);
    }

    /* renamed from: j */
    public void mo12510j() {
        AppMethodBeat.m2504i(99991);
        if (this.f1648a != null) {
            this.f1648a.mo12510j();
        }
        AppMethodBeat.m2505o(99991);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(99992);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f1648a != null) {
            this.f1648a.mo50433a(i, i2);
        }
        AppMethodBeat.m2505o(99992);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(99993);
        if (this.f1648a != null) {
            boolean a = this.f1648a.mo50453a(motionEvent);
            AppMethodBeat.m2505o(99993);
            return a;
        }
        AppMethodBeat.m2505o(99993);
        return false;
    }

    /* renamed from: g */
    public void mo12507g() {
        AppMethodBeat.m2504i(99994);
        if (this.f1648a != null) {
            this.f1648a.mo12507g();
        }
        AppMethodBeat.m2505o(99994);
    }

    /* renamed from: f */
    public void mo12506f() {
        AppMethodBeat.m2504i(99995);
        if (this.f1649b) {
            super.mo12506f();
        }
        if (this.f1648a != null) {
            this.f1648a.mo12506f();
        }
        AppMethodBeat.m2505o(99995);
    }

    /* renamed from: e */
    public void mo12505e() {
        AppMethodBeat.m2504i(99996);
        if (this.f1649b) {
            super.mo12505e();
        }
        if (this.f1648a != null) {
            this.f1648a.mo12505e();
        }
        AppMethodBeat.m2505o(99996);
    }

    /* renamed from: a_ */
    public void mo12502a_() {
        AppMethodBeat.m2504i(99997);
        if (getVisibility() == 0) {
            mo43575b();
        }
        AppMethodBeat.m2505o(99997);
    }

    /* renamed from: a */
    public boolean mo12501a(GL10 gl10) {
        AppMethodBeat.m2504i(99998);
        if (this.f1648a == null) {
            AppMethodBeat.m2505o(99998);
            return false;
        }
        boolean a = this.f1648a.mo12501a(gl10);
        AppMethodBeat.m2505o(99998);
        return a;
    }

    public int getEGLContextHash() {
        AppMethodBeat.m2504i(99999);
        if (this.f1648a != null) {
            int eGLContextHash = this.f1648a.getEGLContextHash();
            AppMethodBeat.m2505o(99999);
            return eGLContextHash;
        }
        AppMethodBeat.m2505o(99999);
        return 0;
    }

    /* renamed from: h */
    private void m9146h() {
        AppMethodBeat.m2504i(100000);
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        mo43574a(8, 8, 8, 8, 16, 0);
        setEGLContextFactory(new C58941());
        if (this.f1650c != null) {
            setEGLWindowSurfaceFactory(new C58932());
        }
        AppMethodBeat.m2505o(100000);
    }

    /* renamed from: i */
    private void m9147i() {
        AppMethodBeat.m2504i(100001);
        if (this.f1648a != null) {
            this.f1648a.mo75388d();
        }
        AppMethodBeat.m2505o(100001);
    }

    /* renamed from: a */
    private void m9144a(byte[] bArr) {
        AppMethodBeat.m2504i(100002);
        if (this.f1648a != null) {
            this.f1648a.mo75385a(bArr);
        }
        AppMethodBeat.m2505o(100002);
    }

    /* renamed from: d */
    public void mo12503d() {
        AppMethodBeat.m2504i(100003);
        m9146h();
        setRenderer(this);
        setRenderMode(0);
        this.f1649b = C44511ew.m80736a(this, true);
        AppMethodBeat.m2505o(100003);
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(100004);
        if (this.f1648a == null || !this.f1648a.mo50462b(motionEvent)) {
            boolean dispatchHoverEvent = super.dispatchHoverEvent(motionEvent);
            AppMethodBeat.m2505o(100004);
            return dispatchHoverEvent;
        }
        AppMethodBeat.m2505o(100004);
        return true;
    }
}
