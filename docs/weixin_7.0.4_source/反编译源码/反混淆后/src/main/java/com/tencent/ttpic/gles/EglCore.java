package com.tencent.ttpic.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = GlUtil.TAG;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;

    public EglCore() {
        this(null, 0);
    }

    public EglCore(EGLContext eGLContext, int i) {
        AppMethodBeat.m2504i(49955);
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        RuntimeException runtimeException;
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            runtimeException = new RuntimeException("EGL already set up");
            AppMethodBeat.m2505o(49955);
            throw runtimeException;
        }
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            runtimeException = new RuntimeException("unable to get EGL14 display");
            AppMethodBeat.m2505o(49955);
            throw runtimeException;
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            EGLConfig config;
            EGLContext eglCreateContext;
            if ((i & 2) != 0) {
                config = getConfig(i, 3);
                if (config != null) {
                    eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{12440, 3, 12344}, 0);
                    if (EGL14.eglGetError() == 12288) {
                        this.mEGLConfig = config;
                        this.mEGLContext = eglCreateContext;
                        this.mGlVersion = 3;
                    }
                }
            }
            if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                config = getConfig(i, 2);
                if (config == null) {
                    runtimeException = new RuntimeException("Unable to find a suitable EGLConfig");
                    AppMethodBeat.m2505o(49955);
                    throw runtimeException;
                }
                eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{12440, 2, 12344}, 0);
                checkEglError("eglCreateContext");
                this.mEGLConfig = config;
                this.mEGLContext = eglCreateContext;
                this.mGlVersion = 2;
            }
            iArr = new int[1];
            EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, iArr, 0);
            new StringBuilder("EGLContext created, client version ").append(iArr[0]);
            AppMethodBeat.m2505o(49955);
            return;
        }
        this.mEGLDisplay = null;
        runtimeException = new RuntimeException("unable to initialize EGL14");
        AppMethodBeat.m2505o(49955);
        throw runtimeException;
    }

    private EGLConfig getConfig(int i, int i2) {
        AppMethodBeat.m2504i(49956);
        int i3 = 4;
        if (i2 >= 3) {
            i3 = 68;
        }
        int[] iArr = new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i3, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = EGL_RECORDABLE_ANDROID;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            EGLConfig eGLConfig = eGLConfigArr[0];
            AppMethodBeat.m2505o(49956);
            return eGLConfig;
        }
        new StringBuilder("unable to find RGB8888 / ").append(i2).append(" EGLConfig");
        AppMethodBeat.m2505o(49956);
        return null;
    }

    public final void release() {
        AppMethodBeat.m2504i(49957);
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        AppMethodBeat.m2505o(49957);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(49958);
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                release();
            }
            super.finalize();
            AppMethodBeat.m2505o(49958);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(49958);
        }
    }

    public final void releaseSurface(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(49959);
        EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface);
        AppMethodBeat.m2505o(49959);
    }

    public final EGLSurface createWindowSurface(Object obj) {
        AppMethodBeat.m2504i(49960);
        RuntimeException runtimeException;
        if ((obj instanceof Surface) || (obj instanceof SurfaceTexture)) {
            EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
            checkEglError("eglCreateWindowSurface");
            if (eglCreateWindowSurface == null) {
                runtimeException = new RuntimeException("surface was null");
                AppMethodBeat.m2505o(49960);
                throw runtimeException;
            }
            AppMethodBeat.m2505o(49960);
            return eglCreateWindowSurface;
        }
        runtimeException = new RuntimeException("invalid surface: ".concat(String.valueOf(obj)));
        AppMethodBeat.m2505o(49960);
        throw runtimeException;
    }

    public final EGLSurface createOffscreenSurface(int i, int i2) {
        AppMethodBeat.m2504i(49961);
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface == null) {
            RuntimeException runtimeException = new RuntimeException("surface was null");
            AppMethodBeat.m2505o(49961);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(49961);
        return eglCreatePbufferSurface;
    }

    public final void makeCurrent(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(49962);
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
        AppMethodBeat.m2505o(49962);
    }

    public final void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        AppMethodBeat.m2504i(49963);
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        if (EGL14.eglMakeCurrent(this.mEGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
            AppMethodBeat.m2505o(49963);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("eglMakeCurrent(draw,read) failed");
        AppMethodBeat.m2505o(49963);
        throw runtimeException;
    }

    public final void makeNothingCurrent() {
        AppMethodBeat.m2504i(49964);
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            AppMethodBeat.m2505o(49964);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("eglMakeCurrent failed");
        AppMethodBeat.m2505o(49964);
        throw runtimeException;
    }

    public final boolean swapBuffers(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(49965);
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
        AppMethodBeat.m2505o(49965);
        return eglSwapBuffers;
    }

    @TargetApi(18)
    public final void setPresentationTime(EGLSurface eGLSurface, long j) {
        AppMethodBeat.m2504i(49966);
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j);
        AppMethodBeat.m2505o(49966);
    }

    public final boolean isCurrent(EGLSurface eGLSurface) {
        AppMethodBeat.m2504i(49967);
        if (this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377))) {
            AppMethodBeat.m2505o(49967);
            return true;
        }
        AppMethodBeat.m2505o(49967);
        return false;
    }

    public final int querySurface(EGLSurface eGLSurface, int i) {
        AppMethodBeat.m2504i(49968);
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i, iArr, 0);
        int i2 = iArr[0];
        AppMethodBeat.m2505o(49968);
        return i2;
    }

    public final String queryString(int i) {
        AppMethodBeat.m2504i(49969);
        String eglQueryString = EGL14.eglQueryString(this.mEGLDisplay, i);
        AppMethodBeat.m2505o(49969);
        return eglQueryString;
    }

    public final int getGlVersion() {
        return this.mGlVersion;
    }

    public static void logCurrent(String str) {
        AppMethodBeat.m2504i(49970);
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        new StringBuilder("Current EGL (").append(str).append("): display=").append(eglGetCurrentDisplay).append(", context=").append(eglGetCurrentContext).append(", surface=").append(EGL14.eglGetCurrentSurface(12377));
        AppMethodBeat.m2505o(49970);
    }

    private void checkEglError(String str) {
        AppMethodBeat.m2504i(49971);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            new StringBuilder().append(str).append(": EGL error: 0x").append(Integer.toHexString(eglGetError));
        }
        AppMethodBeat.m2505o(49971);
    }
}
