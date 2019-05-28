package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;

@TargetApi(18)
class InputSurface {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final String TAG = InputSurface.class.getSimpleName();
    private EGLContext mEGLContext = null;
    private EGLDisplay mEGLDisplay = null;
    private EGLSurface mEGLSurface = null;
    private Surface mSurface = null;

    static {
        AppMethodBeat.i(83699);
        AppMethodBeat.o(83699);
    }

    public InputSurface(EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(83693);
        if (surface == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(83693);
            throw nullPointerException;
        }
        this.mSurface = surface;
        eglSetup(eGLContext);
        AppMethodBeat.o(83693);
    }

    public void release() {
        AppMethodBeat.i(83694);
        EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        EGL14.eglTerminate(this.mEGLDisplay);
        this.mSurface.release();
        this.mSurface = null;
        this.mEGLDisplay = null;
        this.mEGLContext = null;
        this.mEGLSurface = null;
        AppMethodBeat.o(83694);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void makeCurrent() {
        AppMethodBeat.i(83695);
        EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
        AppMethodBeat.o(83695);
    }

    public boolean swapBuffers() {
        AppMethodBeat.i(83696);
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
        AppMethodBeat.o(83696);
        return eglSwapBuffers;
    }

    public void setPresentationTime(long j) {
        AppMethodBeat.i(83697);
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j);
        AppMethodBeat.o(83697);
    }

    private void eglSetup(EGLContext eGLContext) {
        AppMethodBeat.i(83698);
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    iArr = new int[]{12440, 2, 12344};
                    EGLDisplay eGLDisplay = this.mEGLDisplay;
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    if (eGLContext == null) {
                        eGLContext = EGL14.EGL_NO_CONTEXT;
                    }
                    this.mEGLContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr, 0);
                    GlUtil.checkEglError("eglCreateContext");
                    if (this.mEGLContext != null) {
                        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
                        GlUtil.checkEglError("eglCreateWindowSurface");
                    }
                }
            } else {
                this.mEGLDisplay = null;
                AppMethodBeat.o(83698);
                return;
            }
        }
        AppMethodBeat.o(83698);
    }
}
