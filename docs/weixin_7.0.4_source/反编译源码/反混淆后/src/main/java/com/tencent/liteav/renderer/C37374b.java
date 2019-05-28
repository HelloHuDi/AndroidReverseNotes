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

/* renamed from: com.tencent.liteav.renderer.b */
class C37374b extends Thread {
    /* renamed from: a */
    private int f16000a = 12440;
    /* renamed from: b */
    private int f16001b = 4;
    /* renamed from: c */
    private WeakReference<C37373a> f16002c;
    /* renamed from: d */
    private EGL10 f16003d;
    /* renamed from: e */
    private EGLContext f16004e;
    /* renamed from: f */
    private EGLDisplay f16005f;
    /* renamed from: g */
    private EGLSurface f16006g;
    /* renamed from: h */
    private EGLConfig f16007h;
    /* renamed from: i */
    private WeakReference<SurfaceTexture> f16008i;
    /* renamed from: j */
    private boolean f16009j = false;
    /* renamed from: k */
    private int f16010k = ActUtil.HEIGHT;
    /* renamed from: l */
    private int f16011l = 720;

    C37374b(WeakReference<C37373a> weakReference) {
        this.f16002c = weakReference;
    }

    public void run() {
        AppMethodBeat.m2504i(67262);
        setName("VRender" + getId());
        try {
            this.f16009j = true;
            m62938h();
            m62933c();
            m62936f();
            while (this.f16009j) {
                if (!(!m62935e() || this.f16003d == null || this.f16005f == null || this.f16006g == null)) {
                    this.f16003d.eglSwapBuffers(this.f16005f, this.f16006g);
                }
            }
            m62937g();
            m62934d();
            m62939i();
        } catch (Exception e) {
        } finally {
            AppMethodBeat.m2505o(67262);
        }
    }

    /* renamed from: a */
    public EGLContext mo60208a() {
        return this.f16004e;
    }

    /* renamed from: b */
    public void mo60209b() {
        this.f16009j = false;
    }

    /* renamed from: c */
    private void m62933c() {
        AppMethodBeat.m2504i(67263);
        try {
            C37373a c37373a = (C37373a) this.f16002c.get();
            if (c37373a != null) {
                c37373a.mo60200c();
            }
            AppMethodBeat.m2505o(67263);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67263);
        }
    }

    /* renamed from: d */
    private void m62934d() {
        AppMethodBeat.m2504i(67264);
        try {
            C37373a c37373a = (C37373a) this.f16002c.get();
            if (c37373a != null) {
                c37373a.mo60201d();
            }
            AppMethodBeat.m2505o(67264);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67264);
        }
    }

    /* renamed from: e */
    private boolean m62935e() {
        AppMethodBeat.m2504i(67265);
        try {
            Thread.sleep(10);
            if (this.f16002c != null) {
                C37373a c37373a = (C37373a) this.f16002c.get();
                if (c37373a != null) {
                    boolean e = c37373a.mo60202e();
                    AppMethodBeat.m2505o(67265);
                    return e;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.m2505o(67265);
        return false;
    }

    /* renamed from: f */
    private void m62936f() {
        AppMethodBeat.m2504i(67266);
        if (this.f16002c != null) {
            C37373a c37373a = (C37373a) this.f16002c.get();
            if (c37373a != null) {
                c37373a.mo72922o();
            }
        }
        AppMethodBeat.m2505o(67266);
    }

    /* renamed from: g */
    private void m62937g() {
        AppMethodBeat.m2504i(67267);
        if (this.f16002c != null) {
            C37373a c37373a = (C37373a) this.f16002c.get();
            if (c37373a != null) {
                c37373a.mo72926p();
            }
        }
        AppMethodBeat.m2505o(67267);
    }

    /* renamed from: h */
    private void m62938h() {
        AppMethodBeat.m2504i(67268);
        C37373a c37373a = (C37373a) this.f16002c.get();
        if (c37373a == null) {
            AppMethodBeat.m2505o(67268);
            return;
        }
        this.f16003d = (EGL10) EGLContext.getEGL();
        this.f16005f = this.f16003d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f16003d.eglInitialize(this.f16005f, new int[2]);
        this.f16007h = m62940j();
        SurfaceTexture f = c37373a.mo60203f();
        if (f != null) {
            this.f16008i = new WeakReference(f);
            this.f16006g = this.f16003d.eglCreateWindowSurface(this.f16005f, this.f16007h, f, null);
        } else {
            this.f16006g = this.f16003d.eglCreatePbufferSurface(this.f16005f, this.f16007h, new int[]{12375, this.f16010k, 12374, this.f16011l, 12344});
        }
        this.f16004e = m62932a(this.f16003d, this.f16005f, this.f16007h, EGL10.EGL_NO_CONTEXT);
        TXCLog.m15679w("TXCVideoRenderThread", "vrender: init egl @context=" + this.f16004e + ",surface=" + this.f16006g);
        try {
            RuntimeException runtimeException;
            if (this.f16006g == null || this.f16006g == EGL10.EGL_NO_SURFACE) {
                runtimeException = new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.f16003d.eglGetError()));
                AppMethodBeat.m2505o(67268);
                throw runtimeException;
            } else if (this.f16003d.eglMakeCurrent(this.f16005f, this.f16006g, this.f16006g, this.f16004e)) {
                AppMethodBeat.m2505o(67268);
            } else {
                runtimeException = new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.f16003d.eglGetError()));
                AppMethodBeat.m2505o(67268);
                throw runtimeException;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(67268);
        }
    }

    /* renamed from: i */
    private void m62939i() {
        AppMethodBeat.m2504i(67269);
        EGL10 egl10 = this.f16003d;
        EGLDisplay eGLDisplay = this.f16005f;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f16003d.eglDestroyContext(this.f16005f, this.f16004e);
        this.f16003d.eglDestroySurface(this.f16005f, this.f16006g);
        this.f16003d.eglTerminate(this.f16005f);
        this.f16008i = null;
        TXCLog.m15679w("TXCVideoRenderThread", "vrender: uninit egl @context=" + this.f16004e + ",surface=" + this.f16006g);
        AppMethodBeat.m2505o(67269);
    }

    /* renamed from: a */
    private EGLContext m62932a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
        AppMethodBeat.m2504i(67270);
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{this.f16000a, 2, 12344});
        AppMethodBeat.m2505o(67270);
        return eglCreateContext;
    }

    /* renamed from: j */
    private EGLConfig m62940j() {
        AppMethodBeat.m2504i(67271);
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f16003d.eglChooseConfig(this.f16005f, m62941k(), eGLConfigArr, 1, iArr)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed to choose config:" + GLUtils.getEGLErrorString(this.f16003d.eglGetError()));
            AppMethodBeat.m2505o(67271);
            throw illegalArgumentException;
        } else if (iArr[0] > 0) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.m2505o(67271);
            return eGLConfig;
        } else {
            AppMethodBeat.m2505o(67271);
            return null;
        }
    }

    /* renamed from: k */
    private int[] m62941k() {
        return new int[]{12352, this.f16001b, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
