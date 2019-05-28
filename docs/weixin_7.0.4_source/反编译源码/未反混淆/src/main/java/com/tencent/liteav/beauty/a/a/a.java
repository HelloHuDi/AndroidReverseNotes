package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a {
    private EGL10 a;
    private final EGLContext b;
    private EGLDisplay c;
    private EGLConfig d;
    private EGLSurface e;

    public a() {
        this(null);
    }

    public a(EGLConfig eGLConfig) {
        AppMethodBeat.i(66834);
        this.a = (EGL10) EGLContext.getEGL();
        this.c = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        RuntimeException runtimeException;
        if (this.c == EGL10.EGL_NO_DISPLAY) {
            runtimeException = new RuntimeException("unable to get EGL10 display");
            AppMethodBeat.o(66834);
            throw runtimeException;
        }
        if (this.a.eglInitialize(this.c, new int[2])) {
            if (eGLConfig != null) {
                this.d = eGLConfig;
            } else {
                this.d = b();
            }
            this.b = this.a.eglCreateContext(this.c, this.d, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            AppMethodBeat.o(66834);
            return;
        }
        this.c = null;
        runtimeException = new RuntimeException("unable to initialize EGL10");
        AppMethodBeat.o(66834);
        throw runtimeException;
    }

    private EGLConfig b() {
        AppMethodBeat.i(66835);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.a.eglChooseConfig(this.c, new int[]{12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.o(66835);
            return eGLConfig;
        }
        TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
        AppMethodBeat.o(66835);
        return null;
    }

    public void a() {
        AppMethodBeat.i(66836);
        EGL10 egl10 = this.a;
        EGLDisplay eGLDisplay = this.c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.a.eglDestroyContext(this.c, this.b);
        this.a.eglTerminate(this.c);
        AppMethodBeat.o(66836);
    }

    public void a(EGLSurface eGLSurface) {
        AppMethodBeat.i(66837);
        this.a.eglDestroySurface(this.c, eGLSurface);
        AppMethodBeat.o(66837);
    }

    public EGLSurface a(int i, int i2) {
        AppMethodBeat.i(66838);
        this.e = this.a.eglCreatePbufferSurface(this.c, this.d, new int[]{12375, i, 12374, i2, 12344});
        a("eglCreatePbufferSurface");
        if (this.e == null) {
            RuntimeException runtimeException = new RuntimeException("surface was null");
            AppMethodBeat.o(66838);
            throw runtimeException;
        }
        EGLSurface eGLSurface = this.e;
        AppMethodBeat.o(66838);
        return eGLSurface;
    }

    public void b(EGLSurface eGLSurface) {
        AppMethodBeat.i(66839);
        EGLDisplay eGLDisplay = this.c;
        if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            TXCLog.d("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (this.a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.b)) {
            AppMethodBeat.o(66839);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("eglMakeCurrent failed");
        AppMethodBeat.o(66839);
        throw runtimeException;
    }

    private void a(String str) {
        AppMethodBeat.i(66840);
        int eglGetError = this.a.eglGetError();
        if (eglGetError != 12288) {
            RuntimeException runtimeException = new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            AppMethodBeat.o(66840);
            throw runtimeException;
        }
        AppMethodBeat.o(66840);
    }
}
