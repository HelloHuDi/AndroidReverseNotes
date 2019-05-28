package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.util.Log;
import com.tencent.map.lib.d;
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

public class iy extends Thread {
    private static int d = 60;
    private static long p = 1500;
    private WeakReference<iz> a;
    private AtomicBoolean b = new AtomicBoolean(true);
    private AtomicBoolean c = new AtomicBoolean(false);
    private byte[] e = new byte[0];
    private WeakReference<Object> f;
    private volatile boolean g = false;
    private EGLConfig h = null;
    private EGL10 i;
    private EGLDisplay j = EGL10.EGL_NO_DISPLAY;
    private EGLContext k = EGL10.EGL_NO_CONTEXT;
    private EGLSurface l = EGL10.EGL_NO_SURFACE;
    private GL m;
    private volatile long n = 0;
    private boolean o = false;

    public iy(Object obj, iz izVar) {
        AppMethodBeat.i(99902);
        this.f = new WeakReference(obj);
        this.a = new WeakReference(izVar);
        AppMethodBeat.o(99902);
    }

    public void run() {
        AppMethodBeat.i(99903);
        super.run();
        e();
        while (this.b.get()) {
            try {
                synchronized (this.e) {
                    while (this.c.get()) {
                        this.e.wait();
                    }
                }
                if (this.g) {
                    f();
                    this.o = true;
                    this.g = false;
                    d();
                }
                if (!(this.a == null || this.a.get() == null)) {
                    iz izVar = (iz) this.a.get();
                    if (!this.o || System.currentTimeMillis() - this.n >= p) {
                        this.o = false;
                        this.n = 0;
                    } else if (izVar != null) {
                        izVar.l();
                    }
                    if (izVar != null && izVar.a((GL10) this.m)) {
                        this.i.eglSwapBuffers(this.j, this.l);
                    }
                    synchronized (this) {
                        wait((long) (1000 / d));
                    }
                }
            } catch (Throwable th) {
                if (this.b.get() || !(th instanceof InterruptedException)) {
                    new StringBuilder("TextureGLRenderThread Render Exception:").append(Log.getStackTraceString(th));
                }
            }
        }
        g();
        AppMethodBeat.o(99903);
    }

    public void a() {
        AppMethodBeat.i(99904);
        this.c.set(true);
        synchronized (this.e) {
            try {
                this.e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99904);
            }
        }
    }

    public void b() {
        AppMethodBeat.i(99905);
        this.c.set(false);
        synchronized (this.e) {
            try {
                this.e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99905);
            }
        }
    }

    public void c() {
        AppMethodBeat.i(99906);
        this.b.set(false);
        this.c.set(false);
        synchronized (this.e) {
            try {
                this.e.notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99906);
            }
        }
        interrupt();
    }

    @TargetApi(14)
    private void e() {
        AppMethodBeat.i(99907);
        while (this.b.get()) {
            try {
                if (this.f == null || this.f.get() == null) {
                    AppMethodBeat.o(99907);
                    return;
                }
                Object obj = this.f.get();
                this.i = (EGL10) EGLContext.getEGL();
                this.j = this.i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                if (this.j == EGL10.EGL_NO_DISPLAY) {
                    new StringBuilder("eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                } else {
                    if (this.i.eglInitialize(this.j, new int[2])) {
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        if (this.i.eglChooseConfig(this.j, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                            this.h = eGLConfigArr[0];
                            this.l = this.i.eglCreateWindowSurface(this.j, this.h, obj, null);
                            if (this.l == EGL10.EGL_NO_SURFACE) {
                                new StringBuilder("eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                            } else {
                                this.k = this.i.eglCreateContext(this.j, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                                if (this.k == EGL10.EGL_NO_CONTEXT) {
                                    new StringBuilder("eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                                } else if (this.i.eglMakeCurrent(this.j, this.l, this.l, this.k)) {
                                    this.m = this.k.getGL();
                                    AppMethodBeat.o(99907);
                                    return;
                                } else {
                                    new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                                }
                            }
                        } else {
                            new StringBuilder("eglChooseConfig failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                        }
                    } else {
                        new StringBuilder("eglInitialize failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("initializeGLContext failed,errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.o(99907);
    }

    public void a(Object obj) {
        AppMethodBeat.i(99908);
        this.f = new WeakReference(obj);
        this.g = true;
        AppMethodBeat.o(99908);
    }

    public void d() {
        AppMethodBeat.i(99909);
        this.o = true;
        this.n = System.currentTimeMillis();
        AppMethodBeat.o(99909);
    }

    @TargetApi(14)
    private void f() {
        AppMethodBeat.i(99910);
        while (this.b.get()) {
            try {
                if (this.f == null || this.f.get() == null) {
                    AppMethodBeat.o(99910);
                    return;
                }
                this.l = this.i.eglCreateWindowSurface(this.j, this.h, this.f.get(), null);
                if (this.l == EGL10.EGL_NO_SURFACE) {
                    new StringBuilder("eglCreateWindowSurface failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                } else if (this.i.eglMakeCurrent(this.j, this.l, this.l, this.k)) {
                    AppMethodBeat.o(99910);
                    return;
                } else {
                    new StringBuilder("eglMakeCurrent failed,errorDetail:").append(GLUtils.getEGLErrorString(this.i.eglGetError()));
                }
            } catch (Throwable th) {
                new StringBuilder("updateSurface failed,errorDetail:").append(Log.getStackTraceString(th));
            }
        }
        AppMethodBeat.o(99910);
    }

    private void g() {
        AppMethodBeat.i(99911);
        if (!(this.a == null || this.a.get() == null)) {
            iz izVar = (iz) this.a.get();
            byte[] bArr = new byte[1];
            izVar.a(bArr);
            synchronized (bArr) {
                try {
                    bArr.wait(1000);
                } catch (InterruptedException e) {
                    d.b(Log.getStackTraceString(e));
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(99911);
                }
            }
            izVar.d();
        }
        h();
        AppMethodBeat.o(99911);
    }

    private void h() {
        AppMethodBeat.i(99912);
        if (!(this.l == null || this.l == EGL10.EGL_NO_SURFACE)) {
            EGL10 egl10 = this.i;
            EGLDisplay eGLDisplay = this.j;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.i.eglDestroySurface(this.j, this.l);
        }
        if (!(this.k == null || this.k == EGL10.EGL_NO_CONTEXT)) {
            this.i.eglDestroyContext(this.j, this.k);
        }
        if (!(this.j == null || this.j == EGL10.EGL_NO_DISPLAY)) {
            this.i.eglTerminate(this.j);
        }
        this.k = EGL10.EGL_NO_CONTEXT;
        this.l = EGL10.EGL_NO_SURFACE;
        this.j = EGL10.EGL_NO_DISPLAY;
        this.a = null;
        AppMethodBeat.o(99912);
    }
}
