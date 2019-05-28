package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.map.lib.C1015d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iy */
public class C31060iy extends Thread {
    /* renamed from: d */
    private static int f14171d = 60;
    /* renamed from: p */
    private static long f14172p = 1500;
    /* renamed from: a */
    private WeakReference<C31061iz> f14173a;
    /* renamed from: b */
    private AtomicBoolean f14174b = new AtomicBoolean(true);
    /* renamed from: c */
    private AtomicBoolean f14175c = new AtomicBoolean(false);
    /* renamed from: e */
    private byte[] f14176e = new byte[0];
    /* renamed from: f */
    private WeakReference<Object> f14177f;
    /* renamed from: g */
    private volatile boolean f14178g = false;
    /* renamed from: h */
    private EGLConfig f14179h = null;
    /* renamed from: i */
    private EGL10 f14180i;
    /* renamed from: j */
    private EGLDisplay f14181j = EGL10.EGL_NO_DISPLAY;
    /* renamed from: k */
    private EGLContext f14182k = EGL10.EGL_NO_CONTEXT;
    /* renamed from: l */
    private EGLSurface f14183l = EGL10.EGL_NO_SURFACE;
    /* renamed from: m */
    private GL f14184m;
    /* renamed from: n */
    private volatile long f14185n = 0;
    /* renamed from: o */
    private boolean f14186o = false;

    public C31060iy(Object obj, C31061iz c31061iz) {
        AppMethodBeat.m2504i(99902);
        this.f14177f = new WeakReference(obj);
        this.f14173a = new WeakReference(c31061iz);
        AppMethodBeat.m2505o(99902);
    }

    public void run() {
        AppMethodBeat.m2504i(99903);
        super.run();
        m49958e();
        while (this.f14174b.get()) {
            try {
                synchronized (this.f14176e) {
                    while (this.f14175c.get()) {
                        this.f14176e.wait();
                    }
                }
                if (this.f14178g) {
                    m49959f();
                    this.f14186o = true;
                    this.f14178g = false;
                    mo50406d();
                }
                if (!(this.f14173a == null || this.f14173a.get() == null)) {
                    C31061iz c31061iz = (C31061iz) this.f14173a.get();
                    if (!this.f14186o || System.currentTimeMillis() - this.f14185n >= f14172p) {
                        this.f14186o = false;
                        this.f14185n = 0;
                    } else if (c31061iz != null) {
                        c31061iz.mo75391l();
                    }
                    if (c31061iz != null && c31061iz.mo12501a((GL10) this.f14184m)) {
                        this.f14180i.eglSwapBuffers(this.f14181j, this.f14183l);
                    }
                    synchronized (this) {
                        wait((long) (1000 / f14171d));
                    }
                }
            } catch (Throwable th) {
                if (this.f14174b.get() || !(th instanceof InterruptedException)) {
                    new StringBuilder("TextureGLRenderThread Render Exception:").append(Log.getStackTraceString(th));
                }
            }
        }
        m49960g();
        AppMethodBeat.m2505o(99903);
    }

    /* renamed from: a */
    public void mo50402a() {
        AppMethodBeat.m2504i(99904);
        this.f14175c.set(true);
        synchronized (this.f14176e) {
            try {
                this.f14176e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99904);
            }
        }
    }

    /* renamed from: b */
    public void mo50404b() {
        AppMethodBeat.m2504i(99905);
        this.f14175c.set(false);
        synchronized (this.f14176e) {
            try {
                this.f14176e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99905);
            }
        }
    }

    /* renamed from: c */
    public void mo50405c() {
        AppMethodBeat.m2504i(99906);
        this.f14174b.set(false);
        this.f14175c.set(false);
        synchronized (this.f14176e) {
            try {
                this.f14176e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99906);
            }
        }
        interrupt();
    }

    @TargetApi(14)
    /* renamed from: e */
    private void m49958e() {
        AppMethodBeat.m2504i(99907);
        while (this.f14174b.get()) {
            try {
                if (this.f14177f == null || this.f14177f.get() == null) {
                    AppMethodBeat.m2505o(99907);
                    return;
                }
                Object obj = this.f14177f.get();
                this.f14180i = (EGL10) EGLContext.getEGL();
                this.f14181j = this.f14180i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                if (this.f14181j == EGL10.EGL_NO_DISPLAY) {
                    new StringBuilder("eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                } else {
                    if (this.f14180i.eglInitialize(this.f14181j, new int[2])) {
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        if (this.f14180i.eglChooseConfig(this.f14181j, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                            this.f14179h = eGLConfigArr[0];
                            this.f14183l = this.f14180i.eglCreateWindowSurface(this.f14181j, this.f14179h, obj, null);
                            if (this.f14183l == EGL10.EGL_NO_SURFACE) {
                                new StringBuilder("eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                            } else {
                                this.f14182k = this.f14180i.eglCreateContext(this.f14181j, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                                if (this.f14182k == EGL10.EGL_NO_CONTEXT) {
                                    new StringBuilder("eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                                } else if (this.f14180i.eglMakeCurrent(this.f14181j, this.f14183l, this.f14183l, this.f14182k)) {
                                    this.f14184m = this.f14182k.getGL();
                                    AppMethodBeat.m2505o(99907);
                                    return;
                                } else {
                                    new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                                }
                            }
                        } else {
                            new StringBuilder("eglChooseConfig failed,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                        }
                    } else {
                        new StringBuilder("eglInitialize failed,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("initializeGLContext failed,errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.m2505o(99907);
    }

    /* renamed from: a */
    public void mo50403a(Object obj) {
        AppMethodBeat.m2504i(99908);
        this.f14177f = new WeakReference(obj);
        this.f14178g = true;
        AppMethodBeat.m2505o(99908);
    }

    /* renamed from: d */
    public void mo50406d() {
        AppMethodBeat.m2504i(99909);
        this.f14186o = true;
        this.f14185n = System.currentTimeMillis();
        AppMethodBeat.m2505o(99909);
    }

    @TargetApi(14)
    /* renamed from: f */
    private void m49959f() {
        AppMethodBeat.m2504i(99910);
        while (this.f14174b.get()) {
            try {
                if (this.f14177f == null || this.f14177f.get() == null) {
                    AppMethodBeat.m2505o(99910);
                    return;
                }
                this.f14183l = this.f14180i.eglCreateWindowSurface(this.f14181j, this.f14179h, this.f14177f.get(), null);
                if (this.f14183l == EGL10.EGL_NO_SURFACE) {
                    new StringBuilder("eglCreateWindowSurface failed,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                } else if (this.f14180i.eglMakeCurrent(this.f14181j, this.f14183l, this.f14183l, this.f14182k)) {
                    AppMethodBeat.m2505o(99910);
                    return;
                } else {
                    new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.f14180i.eglGetError()));
                }
            } catch (Throwable th) {
                new StringBuilder("updateSurface failed,errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.m2505o(99910);
    }

    /* renamed from: g */
    private void m49960g() {
        AppMethodBeat.m2504i(99911);
        if (!(this.f14173a == null || this.f14173a.get() == null)) {
            C31061iz c31061iz = (C31061iz) this.f14173a.get();
            byte[] bArr = new byte[1];
            c31061iz.mo75385a(bArr);
            synchronized (bArr) {
                try {
                    bArr.wait(1000);
                } catch (InterruptedException e) {
                    C1015d.m2290b(Log.getStackTraceString(e));
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(99911);
                }
            }
            c31061iz.mo75388d();
        }
        m49961h();
        AppMethodBeat.m2505o(99911);
    }

    /* renamed from: h */
    private void m49961h() {
        AppMethodBeat.m2504i(99912);
        if (!(this.f14183l == null || this.f14183l == EGL10.EGL_NO_SURFACE)) {
            EGL10 egl10 = this.f14180i;
            EGLDisplay eGLDisplay = this.f14181j;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f14180i.eglDestroySurface(this.f14181j, this.f14183l);
        }
        if (!(this.f14182k == null || this.f14182k == EGL10.EGL_NO_CONTEXT)) {
            this.f14180i.eglDestroyContext(this.f14181j, this.f14182k);
        }
        if (!(this.f14181j == null || this.f14181j == EGL10.EGL_NO_DISPLAY)) {
            this.f14180i.eglTerminate(this.f14181j);
        }
        this.f14182k = EGL10.EGL_NO_CONTEXT;
        this.f14183l = EGL10.EGL_NO_SURFACE;
        this.f14181j = EGL10.EGL_NO_DISPLAY;
        this.f14173a = null;
        AppMethodBeat.m2505o(99912);
    }
}
