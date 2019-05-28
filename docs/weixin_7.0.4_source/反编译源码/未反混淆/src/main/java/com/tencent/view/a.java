package com.tencent.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class a {
    EGL10 mEGL = ((EGL10) EGLContext.getEGL());
    EGLConfig mEGLConfig;
    EGLConfig[] mEGLConfigs;
    EGLContext mEGLContext;
    EGLDisplay mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    EGLSurface mEGLSurface;

    public a() {
        EGLConfig eGLConfig = null;
        AppMethodBeat.i(86625);
        int[] iArr = new int[2];
        int[] iArr2 = new int[]{12375, 100, 12374, 100, 12344};
        this.mEGL.eglInitialize(this.mEGLDisplay, iArr);
        int[] iArr3 = new int[]{12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr4 = new int[1];
        this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr3, null, 0, iArr4);
        int i = iArr4[0];
        if (i > 0) {
            this.mEGLConfigs = new EGLConfig[i];
            this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr3, this.mEGLConfigs, i, iArr4);
            eGLConfig = this.mEGLConfigs[0];
        }
        this.mEGLConfig = eGLConfig;
        if (this.mEGLConfig != null) {
            this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, iArr2);
        }
        AppMethodBeat.o(86625);
    }
}
