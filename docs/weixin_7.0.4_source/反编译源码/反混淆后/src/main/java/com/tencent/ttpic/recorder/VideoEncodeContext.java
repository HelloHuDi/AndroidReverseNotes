package com.tencent.ttpic.recorder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.C16371i;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoEncodeContext {
    static final boolean LIST_CONFIGS = false;
    static final String TAG = VideoEncodeContext.class.getSimpleName();
    EGL10 mEGL = ((EGL10) EGLContext.getEGL());
    EGLConfig mEGLConfig;
    EGLConfig[] mEGLConfigs;
    EGLContext mEGLContext;
    EGLDisplay mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    EGLSurface mEGLSurface;

    static {
        AppMethodBeat.m2504i(83726);
        AppMethodBeat.m2505o(83726);
    }

    public VideoEncodeContext() {
        AppMethodBeat.m2504i(83720);
        int[] iArr = new int[2];
        int[] iArr2 = new int[]{12375, 100, 12374, 100, 12344};
        this.mEGL.eglInitialize(this.mEGLDisplay, iArr);
        this.mEGLConfig = chooseConfig();
        if (this.mEGLConfig != null) {
            this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, iArr2);
        }
        AppMethodBeat.m2505o(83720);
    }

    public void destroyEgl() {
        AppMethodBeat.m2504i(83721);
        EGL10 egl10 = this.mEGL;
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        if (this.mEGLConfig != null) {
            this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        }
        this.mEGL.eglTerminate(this.mEGLDisplay);
        AppMethodBeat.m2505o(83721);
    }

    private EGLConfig chooseConfig() {
        AppMethodBeat.m2504i(83722);
        int[] iArr = new int[]{12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr2 = new int[1];
        this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr, null, 0, iArr2);
        int i = iArr2[0];
        if (i > 0) {
            this.mEGLConfigs = new EGLConfig[i];
            this.mEGL.eglChooseConfig(this.mEGLDisplay, iArr, this.mEGLConfigs, i, iArr2);
            EGLConfig eGLConfig = this.mEGLConfigs[0];
            AppMethodBeat.m2505o(83722);
            return eGLConfig;
        }
        AppMethodBeat.m2505o(83722);
        return null;
    }

    private void listConfig() {
        AppMethodBeat.m2504i(83723);
        C16371i.m25185j(TAG, "Config List {");
        for (EGLConfig eGLConfig : this.mEGLConfigs) {
            C16371i.m25185j(TAG, "    <d,s,r,g,b,a> = <" + getConfigAttrib(eGLConfig, 12325) + "," + getConfigAttrib(eGLConfig, 12326) + "," + getConfigAttrib(eGLConfig, 12324) + "," + getConfigAttrib(eGLConfig, 12323) + "," + getConfigAttrib(eGLConfig, 12322) + "," + getConfigAttrib(eGLConfig, 12321) + ">");
        }
        C16371i.m25185j(TAG, "}");
        AppMethodBeat.m2505o(83723);
    }

    private int getConfigAttrib(EGLConfig eGLConfig, int i) {
        AppMethodBeat.m2504i(83724);
        int[] iArr = new int[1];
        if (this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, eGLConfig, i, iArr)) {
            int i2 = iArr[0];
            AppMethodBeat.m2505o(83724);
            return i2;
        }
        AppMethodBeat.m2505o(83724);
        return 0;
    }

    public boolean usecurruntContext() {
        AppMethodBeat.m2504i(83725);
        if (this.mEGLConfig == null) {
            AppMethodBeat.m2505o(83725);
            return false;
        }
        boolean eglMakeCurrent = this.mEGL.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
        AppMethodBeat.m2505o(83725);
        return eglMakeCurrent;
    }
}
