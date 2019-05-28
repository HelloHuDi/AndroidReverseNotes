package com.tencent.liteav.basic.p141e;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* renamed from: com.tencent.liteav.basic.e.b */
public class C32141b {
    /* renamed from: a */
    public static final String f14705a = C32141b.class.getSimpleName();
    /* renamed from: l */
    private static int[] f14706l = new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    /* renamed from: m */
    private static int[] f14707m = new int[]{12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};
    /* renamed from: b */
    private EGL10 f14708b;
    /* renamed from: c */
    private EGLDisplay f14709c;
    /* renamed from: d */
    private EGLConfig f14710d;
    /* renamed from: e */
    private boolean f14711e;
    /* renamed from: f */
    private EGLContext f14712f;
    /* renamed from: g */
    private boolean f14713g;
    /* renamed from: h */
    private EGLSurface f14714h;
    /* renamed from: i */
    private int f14715i = 0;
    /* renamed from: j */
    private int f14716j = 0;
    /* renamed from: k */
    private int[] f14717k = new int[2];

    static {
        AppMethodBeat.m2504i(66186);
        AppMethodBeat.m2505o(66186);
    }

    private C32141b() {
        AppMethodBeat.m2504i(66180);
        AppMethodBeat.m2505o(66180);
    }

    /* renamed from: a */
    public static C32141b m52280a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i, int i2) {
        AppMethodBeat.m2504i(66181);
        C32141b c32141b = new C32141b();
        c32141b.f14715i = i;
        c32141b.f14716j = i2;
        if (c32141b.m52281a(eGLConfig, eGLContext, surface)) {
            AppMethodBeat.m2505o(66181);
            return c32141b;
        }
        AppMethodBeat.m2505o(66181);
        return null;
    }

    /* renamed from: a */
    public boolean mo52722a() {
        AppMethodBeat.m2504i(66182);
        boolean eglSwapBuffers = this.f14708b.eglSwapBuffers(this.f14709c, this.f14714h);
        mo52725d();
        AppMethodBeat.m2505o(66182);
        return eglSwapBuffers;
    }

    /* renamed from: b */
    public void mo52723b() {
        AppMethodBeat.m2504i(66183);
        EGL10 egl10 = this.f14708b;
        EGLDisplay eGLDisplay = this.f14709c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        if (this.f14714h != null) {
            this.f14708b.eglDestroySurface(this.f14709c, this.f14714h);
        }
        if (this.f14712f != null) {
            this.f14708b.eglDestroyContext(this.f14709c, this.f14712f);
        }
        this.f14708b.eglTerminate(this.f14709c);
        mo52725d();
        this.f14709c = null;
        this.f14714h = null;
        this.f14709c = null;
        AppMethodBeat.m2505o(66183);
    }

    /* renamed from: a */
    private boolean m52281a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        AppMethodBeat.m2504i(66184);
        this.f14708b = (EGL10) EGLContext.getEGL();
        this.f14709c = this.f14708b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f14708b.eglInitialize(this.f14709c, this.f14717k);
        if (eGLConfig == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.f14708b.eglChooseConfig(this.f14709c, surface == null ? f14706l : f14707m, eGLConfigArr, 1, new int[1]);
            this.f14710d = eGLConfigArr[0];
            this.f14711e = true;
        } else {
            this.f14710d = eGLConfig;
        }
        int[] iArr = new int[]{12440, 2, 12344};
        if (eGLContext == null) {
            this.f14712f = this.f14708b.eglCreateContext(this.f14709c, this.f14710d, EGL10.EGL_NO_CONTEXT, iArr);
        } else {
            this.f14712f = this.f14708b.eglCreateContext(this.f14709c, this.f14710d, eGLContext, iArr);
            this.f14713g = true;
        }
        if (this.f14712f == EGL10.EGL_NO_CONTEXT) {
            mo52725d();
            AppMethodBeat.m2505o(66184);
            return false;
        }
        iArr = new int[]{12375, this.f14715i, 12374, this.f14716j, 12344};
        if (surface == null) {
            this.f14714h = this.f14708b.eglCreatePbufferSurface(this.f14709c, this.f14710d, iArr);
        } else {
            this.f14714h = this.f14708b.eglCreateWindowSurface(this.f14709c, this.f14710d, surface, null);
        }
        if (this.f14714h == EGL10.EGL_NO_SURFACE) {
            mo52725d();
            AppMethodBeat.m2505o(66184);
            return false;
        } else if (this.f14708b.eglMakeCurrent(this.f14709c, this.f14714h, this.f14714h, this.f14712f)) {
            AppMethodBeat.m2505o(66184);
            return true;
        } else {
            mo52725d();
            AppMethodBeat.m2505o(66184);
            return false;
        }
    }

    /* renamed from: c */
    public EGLContext mo52724c() {
        return this.f14712f;
    }

    /* renamed from: d */
    public void mo52725d() {
        AppMethodBeat.m2504i(66185);
        int eglGetError = this.f14708b.eglGetError();
        if (eglGetError != 12288) {
            TXCLog.m15676e(f14705a, "EGL error: 0x" + Integer.toHexString(eglGetError));
        }
        AppMethodBeat.m2505o(66185);
    }
}
