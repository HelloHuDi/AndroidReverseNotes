package com.tencent.liteav.basic.p141e;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
/* renamed from: com.tencent.liteav.basic.e.c */
public class C32142c {
    /* renamed from: a */
    private static int f14718a = 2;
    /* renamed from: b */
    private static final String f14719b = C32142c.class.getSimpleName();
    /* renamed from: k */
    private static int[] f14720k;
    /* renamed from: l */
    private static int[] f14721l;
    /* renamed from: c */
    private EGLDisplay f14722c = EGL14.EGL_NO_DISPLAY;
    /* renamed from: d */
    private EGLContext f14723d = EGL14.EGL_NO_CONTEXT;
    /* renamed from: e */
    private EGLConfig f14724e = null;
    /* renamed from: f */
    private int f14725f = 0;
    /* renamed from: g */
    private int f14726g = 0;
    /* renamed from: h */
    private boolean f14727h;
    /* renamed from: i */
    private EGLSurface f14728i;
    /* renamed from: j */
    private int f14729j = -1;

    /* renamed from: a */
    public static C32142c m52286a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i, int i2) {
        AppMethodBeat.m2504i(66188);
        C32142c c32142c = new C32142c();
        c32142c.f14725f = i;
        c32142c.f14726g = i2;
        if (c32142c.m52287a(eGLConfig, eGLContext, surface)) {
            AppMethodBeat.m2505o(66188);
            return c32142c;
        }
        AppMethodBeat.m2505o(66188);
        return null;
    }

    /* renamed from: a */
    public void mo52726a() {
        AppMethodBeat.m2504i(66189);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            RuntimeException runtimeException = new RuntimeException(": EGL error: 0x" + Integer.toHexString(eglGetError));
            AppMethodBeat.m2505o(66189);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(66189);
    }

    /* renamed from: b */
    public void mo52728b() {
        AppMethodBeat.m2504i(66190);
        if (this.f14722c != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.f14722c;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f14722c, this.f14728i);
            EGL14.eglDestroyContext(this.f14722c, this.f14723d);
            this.f14723d = EGL14.EGL_NO_CONTEXT;
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f14722c);
        }
        this.f14722c = EGL14.EGL_NO_DISPLAY;
        AppMethodBeat.m2505o(66190);
    }

    /* renamed from: c */
    public boolean mo52729c() {
        AppMethodBeat.m2504i(66191);
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.f14722c, this.f14728i);
        AppMethodBeat.m2505o(66191);
        return eglSwapBuffers;
    }

    /* renamed from: a */
    private boolean m52287a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        AppMethodBeat.m2504i(66192);
        this.f14722c = EGL14.eglGetDisplay(0);
        RuntimeException runtimeException;
        if (this.f14722c == EGL14.EGL_NO_DISPLAY) {
            runtimeException = new RuntimeException("unable to get EGL14 display");
            AppMethodBeat.m2505o(66192);
            throw runtimeException;
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.f14722c, iArr, 0, iArr, 1)) {
            if (eGLConfig != null) {
                this.f14724e = eGLConfig;
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f14722c, surface == null ? f14721l : f14720k, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.f14724e = eGLConfigArr[0];
                } else {
                    AppMethodBeat.m2505o(66192);
                    return false;
                }
            }
            if (eGLContext != null) {
                this.f14727h = true;
            } else {
                eGLContext = EGL14.EGL_NO_CONTEXT;
            }
            this.f14723d = EGL14.eglCreateContext(this.f14722c, this.f14724e, eGLContext, new int[]{12440, f14718a, 12344}, 0);
            iArr = new int[]{12344};
            if (this.f14723d == EGL14.EGL_NO_CONTEXT) {
                mo52726a();
                AppMethodBeat.m2505o(66192);
                return false;
            }
            if (surface == null) {
                this.f14728i = EGL14.eglCreatePbufferSurface(this.f14722c, this.f14724e, new int[]{12375, this.f14725f, 12374, this.f14726g, 12344}, 0);
            } else {
                this.f14728i = EGL14.eglCreateWindowSurface(this.f14722c, this.f14724e, surface, iArr, 0);
            }
            mo52726a();
            if (EGL14.eglMakeCurrent(this.f14722c, this.f14728i, this.f14728i, this.f14723d)) {
                AppMethodBeat.m2505o(66192);
                return true;
            }
            mo52726a();
            AppMethodBeat.m2505o(66192);
            return false;
        }
        this.f14722c = null;
        runtimeException = new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.m2505o(66192);
        throw runtimeException;
    }

    /* renamed from: a */
    public void mo52727a(long j) {
        AppMethodBeat.m2504i(66193);
        EGLExt.eglPresentationTimeANDROID(this.f14722c, this.f14728i, j);
        AppMethodBeat.m2505o(66193);
    }

    static {
        int i;
        int i2 = 4;
        AppMethodBeat.m2504i(66194);
        int[] iArr = new int[17];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12325;
        iArr[9] = 0;
        iArr[10] = 12326;
        iArr[11] = 0;
        iArr[12] = 12352;
        if (f14718a == 2) {
            i = 4;
        } else {
            i = 68;
        }
        iArr[13] = i;
        iArr[14] = 12610;
        iArr[15] = 1;
        iArr[16] = 12344;
        f14720k = iArr;
        int[] iArr2 = new int[19];
        iArr2[0] = 12339;
        iArr2[1] = 1;
        iArr2[2] = 12324;
        iArr2[3] = 8;
        iArr2[4] = 12323;
        iArr2[5] = 8;
        iArr2[6] = 12322;
        iArr2[7] = 8;
        iArr2[8] = 12321;
        iArr2[9] = 8;
        iArr2[10] = 12325;
        iArr2[11] = 0;
        iArr2[12] = 12326;
        iArr2[13] = 0;
        iArr2[14] = 12352;
        if (f14718a != 2) {
            i2 = 68;
        }
        iArr2[15] = i2;
        iArr2[16] = 12610;
        iArr2[17] = 1;
        iArr2[18] = 12344;
        f14721l = iArr2;
        AppMethodBeat.m2505o(66194);
    }
}
