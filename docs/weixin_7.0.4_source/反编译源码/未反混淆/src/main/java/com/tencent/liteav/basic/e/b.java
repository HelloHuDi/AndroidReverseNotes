package com.tencent.liteav.basic.e;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b {
    public static final String a = b.class.getSimpleName();
    private static int[] l = new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    private static int[] m = new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};
    private EGL10 b;
    private EGLDisplay c;
    private EGLConfig d;
    private boolean e;
    private EGLContext f;
    private boolean g;
    private EGLSurface h;
    private int i = 0;
    private int j = 0;
    private int[] k = new int[2];

    static {
        AppMethodBeat.i(66186);
        AppMethodBeat.o(66186);
    }

    private b() {
        AppMethodBeat.i(66180);
        AppMethodBeat.o(66180);
    }

    public static b a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i, int i2) {
        AppMethodBeat.i(66181);
        b bVar = new b();
        bVar.i = i;
        bVar.j = i2;
        if (bVar.a(eGLConfig, eGLContext, surface)) {
            AppMethodBeat.o(66181);
            return bVar;
        }
        AppMethodBeat.o(66181);
        return null;
    }

    public boolean a() {
        AppMethodBeat.i(66182);
        boolean eglSwapBuffers = this.b.eglSwapBuffers(this.c, this.h);
        d();
        AppMethodBeat.o(66182);
        return eglSwapBuffers;
    }

    public void b() {
        AppMethodBeat.i(66183);
        EGL10 egl10 = this.b;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        if (this.h != null) {
            this.b.eglDestroySurface(this.c, this.h);
        }
        if (this.f != null) {
            this.b.eglDestroyContext(this.c, this.f);
        }
        this.b.eglTerminate(this.c);
        d();
        this.c = null;
        this.h = null;
        this.c = null;
        AppMethodBeat.o(66183);
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(66184);
        this.b = (EGL10) EGLContext.getEGL();
        this.c = this.b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b.eglInitialize(this.c, this.k);
        if (eGLConfig == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.b.eglChooseConfig(this.c, surface == null ? l : m, eGLConfigArr, 1, new int[1]);
            this.d = eGLConfigArr[0];
            this.e = true;
        } else {
            this.d = eGLConfig;
        }
        int[] iArr = new int[]{12440, 2, 12344};
        if (eGLContext == null) {
            this.f = this.b.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, iArr);
        } else {
            this.f = this.b.eglCreateContext(this.c, this.d, eGLContext, iArr);
            this.g = true;
        }
        if (this.f == EGL10.EGL_NO_CONTEXT) {
            d();
            AppMethodBeat.o(66184);
            return false;
        }
        iArr = new int[]{12375, this.i, 12374, this.j, 12344};
        if (surface == null) {
            this.h = this.b.eglCreatePbufferSurface(this.c, this.d, iArr);
        } else {
            this.h = this.b.eglCreateWindowSurface(this.c, this.d, surface, null);
        }
        if (this.h == EGL10.EGL_NO_SURFACE) {
            d();
            AppMethodBeat.o(66184);
            return false;
        } else if (this.b.eglMakeCurrent(this.c, this.h, this.h, this.f)) {
            AppMethodBeat.o(66184);
            return true;
        } else {
            d();
            AppMethodBeat.o(66184);
            return false;
        }
    }

    public EGLContext c() {
        return this.f;
    }

    public void d() {
        AppMethodBeat.i(66185);
        int eglGetError = this.b.eglGetError();
        if (eglGetError != 12288) {
            TXCLog.e(a, "EGL error: 0x" + Integer.toHexString(eglGetError));
        }
        AppMethodBeat.o(66185);
    }
}
