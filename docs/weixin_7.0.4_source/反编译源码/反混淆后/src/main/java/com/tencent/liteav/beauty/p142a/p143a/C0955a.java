package com.tencent.liteav.beauty.p142a.p143a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.tencent.liteav.beauty.a.a.a */
public class C0955a {
    /* renamed from: a */
    private EGL10 f1082a;
    /* renamed from: b */
    private final EGLContext f1083b;
    /* renamed from: c */
    private EGLDisplay f1084c;
    /* renamed from: d */
    private EGLConfig f1085d;
    /* renamed from: e */
    private EGLSurface f1086e;

    public C0955a() {
        this(null);
    }

    public C0955a(EGLConfig eGLConfig) {
        AppMethodBeat.m2504i(66834);
        this.f1082a = (EGL10) EGLContext.getEGL();
        this.f1084c = this.f1082a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        RuntimeException runtimeException;
        if (this.f1084c == EGL10.EGL_NO_DISPLAY) {
            runtimeException = new RuntimeException("unable to get EGL10 display");
            AppMethodBeat.m2505o(66834);
            throw runtimeException;
        }
        if (this.f1082a.eglInitialize(this.f1084c, new int[2])) {
            if (eGLConfig != null) {
                this.f1085d = eGLConfig;
            } else {
                this.f1085d = m2155b();
            }
            this.f1083b = this.f1082a.eglCreateContext(this.f1084c, this.f1085d, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            AppMethodBeat.m2505o(66834);
            return;
        }
        this.f1084c = null;
        runtimeException = new RuntimeException("unable to initialize EGL10");
        AppMethodBeat.m2505o(66834);
        throw runtimeException;
    }

    /* renamed from: b */
    private EGLConfig m2155b() {
        AppMethodBeat.m2504i(66835);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.f1082a.eglChooseConfig(this.f1084c, new int[]{12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.m2505o(66835);
            return eGLConfig;
        }
        TXCLog.m15679w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
        AppMethodBeat.m2505o(66835);
        return null;
    }

    /* renamed from: a */
    public void mo3833a() {
        AppMethodBeat.m2504i(66836);
        EGL10 egl10 = this.f1082a;
        EGLDisplay eGLDisplay = this.f1084c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f1082a.eglDestroyContext(this.f1084c, this.f1083b);
        this.f1082a.eglTerminate(this.f1084c);
        AppMethodBeat.m2505o(66836);
    }

    /* renamed from: a */
    public void mo3834a(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(66837);
        this.f1082a.eglDestroySurface(this.f1084c, eGLSurface);
        AppMethodBeat.m2505o(66837);
    }

    /* renamed from: a */
    public EGLSurface mo3832a(int i, int i2) {
        AppMethodBeat.m2504i(66838);
        this.f1086e = this.f1082a.eglCreatePbufferSurface(this.f1084c, this.f1085d, new int[]{12375, i, 12374, i2, 12344});
        m2154a("eglCreatePbufferSurface");
        if (this.f1086e == null) {
            RuntimeException runtimeException = new RuntimeException("surface was null");
            AppMethodBeat.m2505o(66838);
            throw runtimeException;
        }
        EGLSurface eGLSurface = this.f1086e;
        AppMethodBeat.m2505o(66838);
        return eGLSurface;
    }

    /* renamed from: b */
    public void mo3835b(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(66839);
        EGLDisplay eGLDisplay = this.f1084c;
        if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            TXCLog.m15675d("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (this.f1082a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f1083b)) {
            AppMethodBeat.m2505o(66839);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("eglMakeCurrent failed");
        AppMethodBeat.m2505o(66839);
        throw runtimeException;
    }

    /* renamed from: a */
    private void m2154a(String str) {
        AppMethodBeat.m2504i(66840);
        int eglGetError = this.f1082a.eglGetError();
        if (eglGetError != 12288) {
            RuntimeException runtimeException = new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            AppMethodBeat.m2505o(66840);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(66840);
    }
}
