package com.tencent.mm.media.h.a;

import a.f.b.j;
import a.l;
import android.opengl.GLSurfaceView.EGLContextFactory;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/render/config/RenderContextFactory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "()V", "EGL_CONTEXT_CLIENT_VERSION", "", "TAG", "", "createContext", "Ljavax/microedition/khronos/egl/EGLContext;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "display", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "destroyContext", "", "context", "plugin-mediaeditor_release"})
public final class b implements EGLContextFactory {
    private final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private final String TAG = "MicroMsg.RenderContextFactory";

    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(13098);
        j.p(egl10, "egl");
        j.p(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        j.p(eGLConfig, "eglConfig");
        ab.w(this.TAG, "creating OpenGL ES 2.0 context");
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        j.o(eglCreateContext, "egl.eglCreateContext(dis…_NO_CONTEXT, attrib_list)");
        AppMethodBeat.o(13098);
        return eglCreateContext;
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        AppMethodBeat.i(13099);
        j.p(egl10, "egl");
        j.p(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        j.p(eGLContext, "context");
        ab.w(this.TAG, "destroyContext OpenGL ES 2.0 Context");
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
        AppMethodBeat.o(13099);
    }
}
