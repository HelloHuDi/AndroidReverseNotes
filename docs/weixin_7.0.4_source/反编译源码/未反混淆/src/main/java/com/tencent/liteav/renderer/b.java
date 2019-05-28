package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class b extends Thread {
    private int a = 12440;
    private int b = 4;
    private WeakReference<a> c;
    private EGL10 d;
    private EGLContext e;
    private EGLDisplay f;
    private EGLSurface g;
    private EGLConfig h;
    private WeakReference<SurfaceTexture> i;
    private boolean j = false;
    private int k = ActUtil.HEIGHT;
    private int l = 720;

    b(WeakReference<a> weakReference) {
        this.c = weakReference;
    }

    public void run() {
        AppMethodBeat.i(67262);
        setName("VRender" + getId());
        try {
            this.j = true;
            h();
            c();
            f();
            while (this.j) {
                if (!(!e() || this.d == null || this.f == null || this.g == null)) {
                    this.d.eglSwapBuffers(this.f, this.g);
                }
            }
            g();
            d();
            i();
        } catch (Exception e) {
        } finally {
            AppMethodBeat.o(67262);
        }
    }

    public EGLContext a() {
        return this.e;
    }

    public void b() {
        this.j = false;
    }

    private void c() {
        AppMethodBeat.i(67263);
        try {
            a aVar = (a) this.c.get();
            if (aVar != null) {
                aVar.c();
            }
            AppMethodBeat.o(67263);
        } catch (Exception e) {
            AppMethodBeat.o(67263);
        }
    }

    private void d() {
        AppMethodBeat.i(67264);
        try {
            a aVar = (a) this.c.get();
            if (aVar != null) {
                aVar.d();
            }
            AppMethodBeat.o(67264);
        } catch (Exception e) {
            AppMethodBeat.o(67264);
        }
    }

    private boolean e() {
        AppMethodBeat.i(67265);
        try {
            Thread.sleep(10);
            if (this.c != null) {
                a aVar = (a) this.c.get();
                if (aVar != null) {
                    boolean e = aVar.e();
                    AppMethodBeat.o(67265);
                    return e;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(67265);
        return false;
    }

    private void f() {
        AppMethodBeat.i(67266);
        if (this.c != null) {
            a aVar = (a) this.c.get();
            if (aVar != null) {
                aVar.o();
            }
        }
        AppMethodBeat.o(67266);
    }

    private void g() {
        AppMethodBeat.i(67267);
        if (this.c != null) {
            a aVar = (a) this.c.get();
            if (aVar != null) {
                aVar.p();
            }
        }
        AppMethodBeat.o(67267);
    }

    private void h() {
        AppMethodBeat.i(67268);
        a aVar = (a) this.c.get();
        if (aVar == null) {
            AppMethodBeat.o(67268);
            return;
        }
        this.d = (EGL10) EGLContext.getEGL();
        this.f = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.d.eglInitialize(this.f, new int[2]);
        this.h = j();
        SurfaceTexture f = aVar.f();
        if (f != null) {
            this.i = new WeakReference(f);
            this.g = this.d.eglCreateWindowSurface(this.f, this.h, f, null);
        } else {
            this.g = this.d.eglCreatePbufferSurface(this.f, this.h, new int[]{12375, this.k, 12374, this.l, 12344});
        }
        this.e = a(this.d, this.f, this.h, EGL10.EGL_NO_CONTEXT);
        TXCLog.w("TXCVideoRenderThread", "vrender: init egl @context=" + this.e + ",surface=" + this.g);
        try {
            RuntimeException runtimeException;
            if (this.g == null || this.g == EGL10.EGL_NO_SURFACE) {
                runtimeException = new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
                AppMethodBeat.o(67268);
                throw runtimeException;
            } else if (this.d.eglMakeCurrent(this.f, this.g, this.g, this.e)) {
                AppMethodBeat.o(67268);
            } else {
                runtimeException = new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.d.eglGetError()));
                AppMethodBeat.o(67268);
                throw runtimeException;
            }
        } catch (Exception e) {
            AppMethodBeat.o(67268);
        }
    }

    private void i() {
        AppMethodBeat.i(67269);
        EGL10 egl10 = this.d;
        EGLDisplay eGLDisplay = this.f;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.d.eglDestroyContext(this.f, this.e);
        this.d.eglDestroySurface(this.f, this.g);
        this.d.eglTerminate(this.f);
        this.i = null;
        TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.e + ",surface=" + this.g);
        AppMethodBeat.o(67269);
    }

    private EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        AppMethodBeat.i(67270);
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{this.a, 2, 12344});
        AppMethodBeat.o(67270);
        return eglCreateContext;
    }

    private EGLConfig j() {
        AppMethodBeat.i(67271);
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.d.eglChooseConfig(this.f, k(), eGLConfigArr, 1, iArr)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.d.eglGetError()));
            AppMethodBeat.o(67271);
            throw illegalArgumentException;
        } else if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.o(67271);
            return eGLConfig;
        } else {
            AppMethodBeat.o(67271);
            return null;
        }
    }

    private int[] k() {
        return new int[]{12352, this.b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
