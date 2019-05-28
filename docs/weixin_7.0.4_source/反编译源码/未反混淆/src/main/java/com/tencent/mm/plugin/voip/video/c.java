package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLContextFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

final class c implements EGLContextFactory {
    private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

    c() {
    }

    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(5050);
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        AppMethodBeat.o(5050);
        return eglCreateContext;
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        AppMethodBeat.i(5051);
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
        AppMethodBeat.o(5051);
    }
}
