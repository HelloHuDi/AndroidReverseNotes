package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceView extends SurfaceView implements Callback2 {
    private static final j iZF = new j();
    private i iZG;
    private m iZH;
    private e iZI;
    private f iZJ;
    private g iZK;
    private k iZL;
    private int mDebugFlags;
    private boolean mDetached;
    private int mEGLContextClientVersion;
    private boolean mPreserveEGLContextOnPause;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference(this);

    static class l extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        l() {
            AppMethodBeat.i(133994);
            AppMethodBeat.o(133994);
        }

        public final void close() {
            AppMethodBeat.i(133995);
            flushBuilder();
            AppMethodBeat.o(133995);
        }

        public final void flush() {
            AppMethodBeat.i(133996);
            flushBuilder();
            AppMethodBeat.o(133996);
        }

        public final void write(char[] cArr, int i, int i2) {
            AppMethodBeat.i(133997);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
            AppMethodBeat.o(133997);
        }

        private void flushBuilder() {
            AppMethodBeat.i(133998);
            if (this.mBuilder.length() > 0) {
                ab.v("GLSurfaceView", this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }
            AppMethodBeat.o(133998);
        }
    }

    public interface m {
    }

    class n extends b {
        public n(boolean z) {
            super(z ? 16 : 0);
            AppMethodBeat.i(133999);
            AppMethodBeat.o(133999);
        }
    }

    static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(133979);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                ab.e("CustomGLSurfaceView", "eglCreateWindowSurface", e);
            }
            AppMethodBeat.o(133979);
            return eGLSurface;
        }

        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(133980);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(133980);
        }
    }

    class b extends a {
        protected int mAlphaSize = 0;
        protected int mBlueSize = 8;
        protected int mDepthSize;
        protected int mGreenSize = 8;
        protected int mRedSize = 8;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public b(int i) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, i, 12326, 0, 12344});
            AppMethodBeat.i(133974);
            this.mDepthSize = i;
            this.mStencilSize = 0;
            AppMethodBeat.o(133974);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(133975);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                    a = a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                        AppMethodBeat.o(133975);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(133975);
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            AppMethodBeat.i(133976);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                int i2 = this.mValue[0];
                AppMethodBeat.o(133976);
                return i2;
            }
            AppMethodBeat.o(133976);
            return 0;
        }
    }

    public interface k {
        GL aPU();
    }

    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    class c implements f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ c(GLSurfaceView gLSurfaceView, byte b) {
            this();
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(133977);
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(133977);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(133978);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                ab.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                ab.i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                h.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(133978);
        }
    }

    public interface g {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    static class i extends Thread {
        private boolean iZN = true;
        private h iZO;
        private ArrayList<Runnable> mEventQueue = new ArrayList();
        boolean mExited;
        Runnable mFinishDrawingRunnable = null;
        boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        boolean mHasSurface;
        boolean mHaveEglContext;
        boolean mHaveEglSurface;
        int mHeight = 0;
        boolean mPaused;
        boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        boolean mWaitingForSurface;
        boolean mWantRenderNotification = false;
        int mWidth = 0;

        i(WeakReference<GLSurfaceView> weakReference) {
            AppMethodBeat.i(133985);
            this.mGLSurfaceViewWeakRef = weakReference;
            AppMethodBeat.o(133985);
        }

        public final void run() {
            AppMethodBeat.i(133986);
            setName("GLThread " + getId());
            ab.i("GLThread", "starting tid=" + getId());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                GLSurfaceView.iZF.b(this);
                AppMethodBeat.o(133986);
            }
        }

        private void d(GL10 gl10) {
            AppMethodBeat.i(133987);
            if (this.mHaveEglSurface) {
                if (this.iZN && gl10 != null) {
                    ab.c("CustomGLSurfaceView", "alvinluo stopEglsurface", new Object[0]);
                    this.iZN = false;
                    ab.i("CustomGLSurfaceView", "alvinluo saveBitmap");
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192000);
                    allocateDirect.position(0);
                    gl10.glReadPixels(0, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2000, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocateDirect);
                    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.a aVar = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.iZv;
                    com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.b.a.a(allocateDirect, "/sdcard/test.png");
                }
                this.mHaveEglSurface = false;
                h hVar = this.iZO;
                ab.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
                hVar.destroySurfaceImp();
            }
            AppMethodBeat.o(133987);
        }

        private void stopEglContextLocked() {
            AppMethodBeat.i(133988);
            if (this.mHaveEglContext) {
                h hVar = this.iZO;
                ab.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
                if (hVar.mEglContext != null) {
                    GLSurfaceView gLSurfaceView = (GLSurfaceView) hVar.mGLSurfaceViewWeakRef.get();
                    if (gLSurfaceView != null) {
                        gLSurfaceView.iZJ.destroyContext(hVar.mEgl, hVar.mEglDisplay, hVar.mEglContext);
                    }
                    hVar.mEglContext = null;
                }
                if (hVar.mEglDisplay != null) {
                    hVar.mEgl.eglTerminate(hVar.mEglDisplay);
                    hVar.mEglDisplay = null;
                }
                this.mHaveEglContext = false;
                GLSurfaceView.iZF.notifyAll();
            }
            AppMethodBeat.o(133988);
        }

        /* JADX WARNING: Missing block: B:23:0x0079, code skipped:
            monitor-exit(r19);
     */
        /* JADX WARNING: Missing block: B:24:0x007a, code skipped:
            if (r10 == null) goto L_0x04a0;
     */
        /* JADX WARNING: Missing block: B:26:?, code skipped:
            r10.run();
     */
        /* JADX WARNING: Missing block: B:27:0x007f, code skipped:
            r10 = null;
            r6 = r9;
            r7 = null;
     */
        /* JADX WARNING: Missing block: B:101:0x0303, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:103:0x0308, code skipped:
            monitor-enter(com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT());
     */
        /* JADX WARNING: Missing block: B:105:?, code skipped:
            d(r4);
            stopEglContextLocked();
     */
        /* JADX WARNING: Missing block: B:130:0x04a0, code skipped:
            if (r5 == null) goto L_0x070f;
     */
        /* JADX WARNING: Missing block: B:132:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("GLThread", "egl createSurface");
            r6 = r22.iZO;
            com.tencent.mm.sdk.platformtools.ab.w("EglHelper", "createSurface()  tid=" + java.lang.Thread.currentThread().getId());
     */
        /* JADX WARNING: Missing block: B:133:0x04d1, code skipped:
            if (r6.mEgl != null) goto L_0x04e2;
     */
        /* JADX WARNING: Missing block: B:134:0x04d3, code skipped:
            r2 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(133989);
     */
        /* JADX WARNING: Missing block: B:135:0x04e1, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:137:0x04e4, code skipped:
            if (r6.mEglDisplay != null) goto L_0x04f5;
     */
        /* JADX WARNING: Missing block: B:138:0x04e6, code skipped:
            r2 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(133989);
     */
        /* JADX WARNING: Missing block: B:139:0x04f4, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:141:0x04f7, code skipped:
            if (r6.mEglConfig != null) goto L_0x0508;
     */
        /* JADX WARNING: Missing block: B:142:0x04f9, code skipped:
            r2 = new java.lang.RuntimeException("mEglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.o(133989);
     */
        /* JADX WARNING: Missing block: B:143:0x0507, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:144:0x0508, code skipped:
            r6.destroySurfaceImp();
            r2 = (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r6.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:145:0x0513, code skipped:
            if (r2 == null) goto L_0x0677;
     */
        /* JADX WARNING: Missing block: B:146:0x0515, code skipped:
            r7 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.d(r2);
            r8 = r6.mEgl;
            r19 = r6.mEglDisplay;
            r6.mEglSurface = r7.createWindowSurface(r8, r19, r6.mEglConfig, r2.getHolder());
     */
        /* JADX WARNING: Missing block: B:148:0x0533, code skipped:
            if (r6.mEglSurface == null) goto L_0x053b;
     */
        /* JADX WARNING: Missing block: B:150:0x0539, code skipped:
            if (r6.mEglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x067c;
     */
        /* JADX WARNING: Missing block: B:152:0x0543, code skipped:
            if (r6.mEgl.eglGetError() != 12299) goto L_0x054e;
     */
        /* JADX WARNING: Missing block: B:153:0x0545, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
     */
        /* JADX WARNING: Missing block: B:154:0x054e, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:155:0x054f, code skipped:
            if (r2 == null) goto L_0x06b2;
     */
        /* JADX WARNING: Missing block: B:156:0x0551, code skipped:
            r5 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:157:0x0555, code skipped:
            monitor-enter(r5);
     */
        /* JADX WARNING: Missing block: B:160:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            r2 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
            r2.notifyAll();
     */
        /* JADX WARNING: Missing block: B:161:0x0562, code skipped:
            monitor-exit(r5);
     */
        /* JADX WARNING: Missing block: B:162:0x0565, code skipped:
            if (r16 == null) goto L_0x05b3;
     */
        /* JADX WARNING: Missing block: B:164:?, code skipped:
            r2 = r22.iZO;
            r5 = r2.mEglContext.getGL();
            r2 = (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r2.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:165:0x0579, code skipped:
            if (r2 == null) goto L_0x070c;
     */
        /* JADX WARNING: Missing block: B:167:0x057f, code skipped:
            if (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.e(r2) == null) goto L_0x0589;
     */
        /* JADX WARNING: Missing block: B:168:0x0581, code skipped:
            r5 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.e(r2).aPU();
     */
        /* JADX WARNING: Missing block: B:170:0x058f, code skipped:
            if ((com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.f(r2) & 3) == 0) goto L_0x070c;
     */
        /* JADX WARNING: Missing block: B:171:0x0591, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:172:0x0599, code skipped:
            if ((com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.f(r2) & 1) == 0) goto L_0x059c;
     */
        /* JADX WARNING: Missing block: B:173:0x059b, code skipped:
            r7 = 1;
     */
        /* JADX WARNING: Missing block: B:175:0x05a2, code skipped:
            if ((com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.f(r2) & 2) == 0) goto L_0x0709;
     */
        /* JADX WARNING: Missing block: B:176:0x05a4, code skipped:
            r2 = new com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.l();
     */
        /* JADX WARNING: Missing block: B:177:0x05a9, code skipped:
            r2 = android.opengl.GLDebugHelper.wrap(r5, r7, r2);
     */
        /* JADX WARNING: Missing block: B:178:0x05ad, code skipped:
            r16 = null;
            r18 = (javax.microedition.khronos.opengles.GL10) r2;
     */
        /* JADX WARNING: Missing block: B:179:0x05b3, code skipped:
            if (r17 == null) goto L_0x05cf;
     */
        /* JADX WARNING: Missing block: B:180:0x05b5, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("GLThread", "onSurfaceCreated");
            r2 = (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:181:0x05c8, code skipped:
            if (r2 == null) goto L_0x05cd;
     */
        /* JADX WARNING: Missing block: B:182:0x05ca, code skipped:
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h(r2);
     */
        /* JADX WARNING: Missing block: B:183:0x05cd, code skipped:
            r17 = null;
     */
        /* JADX WARNING: Missing block: B:184:0x05cf, code skipped:
            if (r14 == null) goto L_0x0609;
     */
        /* JADX WARNING: Missing block: B:185:0x05d1, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("GLThread", "onSurfaceChanged(" + r12 + ", " + r11 + ")");
            r2 = (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:186:0x0603, code skipped:
            if (r2 == null) goto L_0x0608;
     */
        /* JADX WARNING: Missing block: B:187:0x0605, code skipped:
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h(r2);
     */
        /* JADX WARNING: Missing block: B:188:0x0608, code skipped:
            r14 = null;
     */
        /* JADX WARNING: Missing block: B:189:0x0609, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("GLThread", "onDrawFrame tid=" + getId());
            r2 = (com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:190:0x062d, code skipped:
            if (r2 == null) goto L_0x0638;
     */
        /* JADX WARNING: Missing block: B:191:0x062f, code skipped:
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h(r2);
     */
        /* JADX WARNING: Missing block: B:192:0x0632, code skipped:
            if (r9 == 0) goto L_0x0638;
     */
        /* JADX WARNING: Missing block: B:193:0x0634, code skipped:
            r9.run();
            r9 = 0;
     */
        /* JADX WARNING: Missing block: B:194:0x0638, code skipped:
            r2 = r22.iZO;
     */
        /* JADX WARNING: Missing block: B:195:0x0646, code skipped:
            if (r2.mEgl.eglSwapBuffers(r2.mEglDisplay, r2.mEglSurface) != false) goto L_0x06d6;
     */
        /* JADX WARNING: Missing block: B:196:0x0648, code skipped:
            r2 = r2.mEgl.eglGetError();
     */
        /* JADX WARNING: Missing block: B:197:0x064e, code skipped:
            switch(r2) {
                case 12288: goto L_0x066c;
                case 12302: goto L_0x06da;
                default: goto L_0x0651;
            };
     */
        /* JADX WARNING: Missing block: B:198:0x0651, code skipped:
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
            r5 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:199:0x065e, code skipped:
            monitor-enter(r5);
     */
        /* JADX WARNING: Missing block: B:202:?, code skipped:
            r22.mSurfaceIsBad = true;
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT().notifyAll();
     */
        /* JADX WARNING: Missing block: B:203:0x066b, code skipped:
            monitor-exit(r5);
     */
        /* JADX WARNING: Missing block: B:204:0x066c, code skipped:
            if (r4 == null) goto L_0x071f;
     */
        /* JADX WARNING: Missing block: B:205:0x066e, code skipped:
            r2 = 1;
            r4 = null;
     */
        /* JADX WARNING: Missing block: B:206:0x0671, code skipped:
            r6 = r9;
            r7 = r10;
            r3 = r2;
            r5 = r8;
     */
        /* JADX WARNING: Missing block: B:209:?, code skipped:
            r6.mEglSurface = null;
     */
        /* JADX WARNING: Missing block: B:210:0x067c, code skipped:
            r2 = r6.mEgl;
            r7 = r6.mEglDisplay;
            r8 = r6.mEglSurface;
            r19 = r6.mEglSurface;
     */
        /* JADX WARNING: Missing block: B:211:0x0692, code skipped:
            if (r2.eglMakeCurrent(r7, r8, r19, r6.mEglContext) != false) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:212:0x0694, code skipped:
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.h.logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", r6.mEgl.eglGetError());
     */
        /* JADX WARNING: Missing block: B:213:0x06a3, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:214:0x06a6, code skipped:
            r2 = 1;
     */
        /* JADX WARNING: Missing block: B:218:0x06ab, code skipped:
            r3 = 133989;
     */
        /* JADX WARNING: Missing block: B:220:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(133989);
     */
        /* JADX WARNING: Missing block: B:222:0x06b2, code skipped:
            r6 = com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:223:0x06b6, code skipped:
            monitor-enter(r6);
     */
        /* JADX WARNING: Missing block: B:226:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            r22.mSurfaceIsBad = true;
            com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT().notifyAll();
     */
        /* JADX WARNING: Missing block: B:227:0x06c8, code skipped:
            monitor-exit(r6);
     */
        /* JADX WARNING: Missing block: B:228:0x06c9, code skipped:
            r6 = r9;
            r7 = r10;
     */
        /* JADX WARNING: Missing block: B:229:0x06cd, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:231:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3);
     */
        /* JADX WARNING: Missing block: B:233:0x06d6, code skipped:
            r2 = 12288;
     */
        /* JADX WARNING: Missing block: B:234:0x06da, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("GLThread", "egl context lost tid=" + getId());
     */
        /* JADX WARNING: Missing block: B:235:0x06f4, code skipped:
            r15 = 1;
     */
        /* JADX WARNING: Missing block: B:236:0x06f7, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:240:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3);
     */
        /* JADX WARNING: Missing block: B:245:0x0702, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(133989);
     */
        /* JADX WARNING: Missing block: B:246:0x0709, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:247:0x070c, code skipped:
            r2 = r5;
     */
        /* JADX WARNING: Missing block: B:248:0x070f, code skipped:
            r8 = r5;
     */
        /* JADX WARNING: Missing block: B:252:0x071f, code skipped:
            r2 = r3;
     */
        /* JADX WARNING: Missing block: B:285:?, code skipped:
            r8 = r2;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() {
            RuntimeException e;
            AppMethodBeat.i(133989);
            this.iZO = new h(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            EGLConfig eGLConfig = null;
            j jVar = null;
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            GL10 gl10 = null;
            int i = 0;
            boolean z = false;
            int i2 = 0;
            int i3 = 0;
            Thread thread = null;
            int i4 = 0;
            Runnable runnable = null;
            Thread thread2 = null;
            GL10 gl102 = null;
            while (true) {
                j aPT = GLSurfaceView.iZF;
                synchronized (aPT) {
                    while (true) {
                        boolean z2 = z;
                        if (this.mShouldExit) {
                        } else {
                            e = this.mEventQueue.isEmpty();
                            if (e == true) {
                                try {
                                    boolean z3;
                                    GLSurfaceView gLSurfaceView;
                                    boolean z4 = this.mPaused;
                                    thread = this.mRequestPaused;
                                    if (z4 != thread) {
                                        z3 = this.mRequestPaused;
                                        this.mPaused = this.mRequestPaused;
                                        GLSurfaceView.iZF.notifyAll();
                                        thread = "mPaused is now " + this.mPaused + " tid=" + getId();
                                        ab.i("GLThread", thread);
                                    }
                                    EGLDisplay eGLDisplay = this.mShouldReleaseEglContext;
                                    if (eGLDisplay != null) {
                                        thread = "releasing EGL context because asked to tid=";
                                        eGLDisplay = getId();
                                        ab.i("GLThread", eGLDisplay);
                                        d(gl102);
                                        stopEglContextLocked();
                                        z2 = false;
                                        this.mShouldReleaseEglContext = false;
                                        z = true;
                                    } else {
                                        z = z2;
                                    }
                                    if (obj2 != null) {
                                        d(gl102);
                                        stopEglContextLocked();
                                        obj2 = null;
                                    }
                                    if (z3) {
                                        z2 = this.mHaveEglSurface;
                                        if (z2) {
                                            z2 = "GLThread";
                                            thread = "releasing EGL surface because paused tid=";
                                            eGLDisplay = getId();
                                            ab.i(z2, eGLDisplay);
                                            d(gl102);
                                        }
                                    }
                                    if (z3 && this.mHaveEglContext) {
                                        gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                        if (gLSurfaceView == null) {
                                            z3 = false;
                                        } else {
                                            z3 = gLSurfaceView.mPreserveEGLContextOnPause;
                                        }
                                        if (!z3) {
                                            stopEglContextLocked();
                                            eGLDisplay = "releasing EGL context because paused tid=";
                                            z2 = getId();
                                            ab.i("GLThread", z2);
                                        }
                                    }
                                    if (!(this.mHasSurface || this.mWaitingForSurface)) {
                                        eGLDisplay = "noticed surfaceView surface lost tid=";
                                        z2 = getId();
                                        ab.i("GLThread", z2);
                                        if (this.mHaveEglSurface) {
                                            d(gl102);
                                        }
                                        this.mWaitingForSurface = true;
                                        this.mSurfaceIsBad = false;
                                        GLSurfaceView.iZF.notifyAll();
                                    }
                                    if (this.mHasSurface && this.mWaitingForSurface) {
                                        eGLDisplay = "noticed surfaceView surface acquired tid=";
                                        z2 = getId();
                                        ab.i("GLThread", z2);
                                        this.mWaitingForSurface = false;
                                        GLSurfaceView.iZF.notifyAll();
                                    }
                                    if (i != 0) {
                                        StringBuilder stringBuilder = new StringBuilder("sending render notification tid=");
                                        z2 = getId();
                                        ab.i("GLThread", stringBuilder.append(z2).toString());
                                        this.mWantRenderNotification = false;
                                        i = 0;
                                        this.mRenderComplete = true;
                                        GLSurfaceView.iZF.notifyAll();
                                    }
                                    if (this.mFinishDrawingRunnable != null) {
                                        runnable = this.mFinishDrawingRunnable;
                                        this.mFinishDrawingRunnable = null;
                                    }
                                    StringBuilder append;
                                    if (readyToDraw()) {
                                        int i5;
                                        if (!this.mHaveEglContext) {
                                            if (z) {
                                                z = false;
                                            } else {
                                                z2 = this.iZO;
                                                StringBuilder stringBuilder2 = new StringBuilder("start() tid=");
                                                thread = Thread.currentThread();
                                                ab.w("EglHelper", stringBuilder2.append(thread.getId()).toString());
                                                z2.mEgl = (EGL10) EGLContext.getEGL();
                                                z2.mEglDisplay = z2.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                                i5 = z2.mEglDisplay;
                                                eGLDisplay = EGL10.EGL_NO_DISPLAY;
                                                if (i5 == eGLDisplay) {
                                                    e = new RuntimeException("eglGetDisplay failed");
                                                    AppMethodBeat.o(133989);
                                                    throw e;
                                                }
                                                int[] iArr = new int[i5];
                                                eGLDisplay = z2.mEgl;
                                                thread = z2.mEglDisplay;
                                                if (eGLDisplay.eglInitialize(thread, iArr)) {
                                                    gLSurfaceView = (GLSurfaceView) z2.mGLSurfaceViewWeakRef.get();
                                                    if (gLSurfaceView == null) {
                                                        z2.mEglConfig = null;
                                                        z2.mEglContext = null;
                                                    } else {
                                                        z2.mEglConfig = gLSurfaceView.iZI.chooseConfig(z2.mEgl, z2.mEglDisplay);
                                                        f c = gLSurfaceView.iZJ;
                                                        eGLDisplay = z2.mEgl;
                                                        thread = z2.mEglDisplay;
                                                        eGLConfig = z2.mEglConfig;
                                                        z2.mEglContext = c.createContext(eGLDisplay, thread, eGLConfig);
                                                    }
                                                    if (z2.mEglContext == null || z2.mEglContext == EGL10.EGL_NO_CONTEXT) {
                                                        z2.mEglContext = null;
                                                        h.throwEglException("createContext", z2.mEgl.eglGetError());
                                                    }
                                                    stringBuilder2 = new StringBuilder("createContext ").append(z2.mEglContext).append(" tid=");
                                                    thread = Thread.currentThread();
                                                    eGLDisplay = stringBuilder2.append(thread.getId()).toString();
                                                    ab.w("EglHelper", eGLDisplay);
                                                    z2.mEglSurface = null;
                                                    this.mHaveEglContext = true;
                                                    boolean z5 = true;
                                                    GLSurfaceView.iZF.notifyAll();
                                                } else {
                                                    e = new RuntimeException("eglInitialize failed");
                                                    AppMethodBeat.o(133989);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                            this.mHaveEglSurface = true;
                                            jVar = true;
                                            obj = 1;
                                            obj3 = 1;
                                        }
                                        if (this.mHaveEglSurface) {
                                            int i6;
                                            if (this.mSizeChanged) {
                                                obj3 = 1;
                                                i6 = this.mWidth;
                                                i5 = this.mHeight;
                                                this.mWantRenderNotification = true;
                                                ab.i("GLThread", "noticing that we want render notification tid=" + getId());
                                                jVar = true;
                                                this.mSizeChanged = false;
                                            } else {
                                                i5 = i3;
                                                i6 = i2;
                                            }
                                            this.mRequestRender = false;
                                            GLSurfaceView.iZF.notifyAll();
                                            if (this.mWantRenderNotification) {
                                                boolean z6 = true;
                                                i4 = runnable;
                                                thread = thread2;
                                                i3 = i5;
                                                i2 = i6;
                                            } else {
                                                i4 = runnable;
                                                thread = thread2;
                                                i3 = i5;
                                                i2 = i6;
                                            }
                                        }
                                        append = new StringBuilder("waiting tid=").append(getId()).append(" mHaveEglContext: ").append(this.mHaveEglContext).append(" mHaveEglSurface: ").append(this.mHaveEglSurface).append(" mFinishedCreatingEglSurface: ").append(this.mFinishedCreatingEglSurface).append(" mPaused: ").append(this.mPaused).append(" mHasSurface: ").append(this.mHasSurface).append(" mSurfaceIsBad: ").append(this.mSurfaceIsBad).append(" mWaitingForSurface: ").append(this.mWaitingForSurface).append(" mWidth: ").append(this.mWidth).append(" mHeight: ").append(this.mHeight).append(" mRequestRender: ").append(this.mRequestRender).append(" mRenderMode: ");
                                        i4 = this.mRenderMode;
                                        ab.i("GLThread", append.append(i4).toString());
                                        GLSurfaceView.iZF.wait();
                                    } else {
                                        if (runnable != null) {
                                            ab.w("CustomGLSurfaceView", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                            runnable.run();
                                            runnable = null;
                                        }
                                        append = new StringBuilder("waiting tid=").append(getId()).append(" mHaveEglContext: ").append(this.mHaveEglContext).append(" mHaveEglSurface: ").append(this.mHaveEglSurface).append(" mFinishedCreatingEglSurface: ").append(this.mFinishedCreatingEglSurface).append(" mPaused: ").append(this.mPaused).append(" mHasSurface: ").append(this.mHasSurface).append(" mSurfaceIsBad: ").append(this.mSurfaceIsBad).append(" mWaitingForSurface: ").append(this.mWaitingForSurface).append(" mWidth: ").append(this.mWidth).append(" mHeight: ").append(this.mHeight).append(" mRequestRender: ").append(this.mRequestRender).append(" mRenderMode: ");
                                        i4 = this.mRenderMode;
                                        ab.i("GLThread", append.append(i4).toString());
                                        GLSurfaceView.iZF.wait();
                                    }
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    GLSurfaceView.iZF.notifyAll();
                                } finally {
                                    i = 133989;
                                    AppMethodBeat.o(133989);
                                }
                            } else {
                                ArrayList th = this.mEventQueue;
                            }
                        }
                    }
                }
                synchronized (GLSurfaceView.iZF) {
                    try {
                        d(null);
                        stopEglContextLocked();
                    } finally {
                        while (true) {
                            AppMethodBeat.o(133989);
                        }
                    }
                }
                return;
            }
            throw e;
        }

        /* Access modifiers changed, original: final */
        public final boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public final void setRenderMode(int i) {
            AppMethodBeat.i(133990);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(133990);
                throw illegalArgumentException;
            }
            synchronized (GLSurfaceView.iZF) {
                try {
                    this.mRenderMode = i;
                    GLSurfaceView.iZF.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133990);
                }
            }
        }

        public final int getRenderMode() {
            int i;
            AppMethodBeat.i(133991);
            synchronized (GLSurfaceView.iZF) {
                try {
                    i = this.mRenderMode;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133991);
                }
            }
            return i;
        }

        public final void requestExitAndWait() {
            AppMethodBeat.i(133992);
            synchronized (GLSurfaceView.iZF) {
                try {
                    this.mShouldExit = true;
                    GLSurfaceView.iZF.notifyAll();
                    while (!this.mExited) {
                        GLSurfaceView.iZF.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(133992);
                }
            }
            AppMethodBeat.o(133992);
        }
    }

    abstract class a implements e {
        protected int[] mConfigSpec;

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public a(int[] iArr) {
            if (GLSurfaceView.this.mEGLContextClientVersion == 2 || GLSurfaceView.this.mEGLContextClientVersion == 3) {
                int[] iArr2 = new int[15];
                System.arraycopy(iArr, 0, iArr2, 0, 12);
                iArr2[12] = 12352;
                if (GLSurfaceView.this.mEGLContextClientVersion == 2) {
                    iArr2[13] = 4;
                } else {
                    iArr2[13] = 64;
                }
                iArr2[14] = 12344;
                iArr = iArr2;
            }
            this.mConfigSpec = iArr;
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                int i = iArr[0];
                if (i <= 0) {
                    throw new IllegalArgumentException("No configs match configSpec");
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[i];
                if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                    EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                    if (chooseConfig != null) {
                        return chooseConfig;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    static class h {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public h(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* Access modifiers changed, original: final */
        public final void destroySurfaceImp() {
            AppMethodBeat.i(133981);
            if (!(this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.iZK.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
            AppMethodBeat.o(133981);
        }

        public static void throwEglException(String str, int i) {
            AppMethodBeat.i(133982);
            String formatEglError = formatEglError(str, i);
            ab.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + formatEglError);
            RuntimeException runtimeException = new RuntimeException(formatEglError);
            AppMethodBeat.o(133982);
            throw runtimeException;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            AppMethodBeat.i(133983);
            ab.w(str, formatEglError(str2, i));
            AppMethodBeat.o(133983);
        }

        private static String formatEglError(String str, int i) {
            AppMethodBeat.i(133984);
            String str2 = str + " failed: " + i;
            AppMethodBeat.o(133984);
            return str2;
        }
    }

    static class j {
        private static String TAG = "GLThreadManager";

        private j() {
        }

        /* synthetic */ j(byte b) {
            this();
        }

        public final synchronized void b(i iVar) {
            AppMethodBeat.i(133993);
            ab.i("GLThread", "exiting tid=" + iVar.getId());
            iVar.mExited = true;
            notifyAll();
            AppMethodBeat.o(133993);
        }
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134000);
        getHolder().addCallback(this);
        AppMethodBeat.o(134000);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(134001);
        try {
            if (this.iZG != null) {
                this.iZG.requestExitAndWait();
            }
            super.finalize();
            AppMethodBeat.o(134001);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(134001);
        }
    }

    public void setGLWrapper(k kVar) {
        this.iZL = kVar;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(m mVar) {
        AppMethodBeat.i(134002);
        checkRenderThreadState();
        if (this.iZI == null) {
            this.iZI = new n(true);
        }
        if (this.iZJ == null) {
            this.iZJ = new c(this, (byte) 0);
        }
        if (this.iZK == null) {
            this.iZK = new d();
        }
        this.iZH = mVar;
        this.iZG = new i(this.mThisWeakRef);
        this.iZG.start();
        AppMethodBeat.o(134002);
    }

    public void setEGLContextFactory(f fVar) {
        AppMethodBeat.i(134003);
        checkRenderThreadState();
        this.iZJ = fVar;
        AppMethodBeat.o(134003);
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        AppMethodBeat.i(134004);
        checkRenderThreadState();
        this.iZK = gVar;
        AppMethodBeat.o(134004);
    }

    public void setEGLConfigChooser(e eVar) {
        AppMethodBeat.i(134005);
        checkRenderThreadState();
        this.iZI = eVar;
        AppMethodBeat.o(134005);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(134006);
        setEGLConfigChooser(new n(z));
        AppMethodBeat.o(134006);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.i(134007);
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
        AppMethodBeat.o(134007);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(134008);
        this.iZG.setRenderMode(i);
        AppMethodBeat.o(134008);
    }

    public int getRenderMode() {
        AppMethodBeat.i(134009);
        int renderMode = this.iZG.getRenderMode();
        AppMethodBeat.o(134009);
        return renderMode;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(134010);
        i iVar = this.iZG;
        synchronized (iZF) {
            try {
                ab.i("GLThread", "surfaceCreated tid=" + iVar.getId());
                iVar.mHasSurface = true;
                iVar.mFinishedCreatingEglSurface = false;
                iZF.notifyAll();
                while (iVar.mWaitingForSurface && !iVar.mFinishedCreatingEglSurface && !iVar.mExited) {
                    iZF.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.o(134010);
            }
        }
        AppMethodBeat.o(134010);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(134011);
        i iVar = this.iZG;
        synchronized (iZF) {
            try {
                ab.i("GLThread", "surfaceDestroyed tid=" + iVar.getId());
                iVar.mHasSurface = false;
                iZF.notifyAll();
                while (!iVar.mWaitingForSurface && !iVar.mExited) {
                    iZF.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.o(134011);
            }
        }
        AppMethodBeat.o(134011);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(134012);
        Thread thread = this.iZG;
        synchronized (iZF) {
            try {
                thread.mWidth = i2;
                thread.mHeight = i3;
                thread.mSizeChanged = true;
                thread.mRequestRender = true;
                thread.mRenderComplete = false;
                if (Thread.currentThread() == thread) {
                    AppMethodBeat.o(134012);
                    return;
                }
                iZF.notifyAll();
                while (!thread.mExited && !thread.mPaused && !thread.mRenderComplete) {
                    Object obj;
                    if (thread.mHaveEglContext && thread.mHaveEglSurface && thread.readyToDraw()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        ab.i("Main thread", "onWindowResize waiting for render complete from tid=" + thread.getId());
                        iZF.wait();
                    }
                }
                AppMethodBeat.o(134012);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.o(134012);
            }
        }
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        AppMethodBeat.i(134013);
        if (this.iZG != null) {
            Thread thread = this.iZG;
            synchronized (iZF) {
                try {
                    if (Thread.currentThread() == thread) {
                    } else {
                        thread.mWantRenderNotification = true;
                        thread.mRequestRender = true;
                        thread.mRenderComplete = false;
                        thread.mFinishDrawingRunnable = runnable;
                        iZF.notifyAll();
                        AppMethodBeat.o(134013);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(134013);
                }
            }
        } else {
            AppMethodBeat.o(134013);
        }
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(134014);
        super.onAttachedToWindow();
        ab.d("CustomGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached && this.iZH != null) {
            int renderMode;
            if (this.iZG != null) {
                renderMode = this.iZG.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.iZG = new i(this.mThisWeakRef);
            if (renderMode != 1) {
                this.iZG.setRenderMode(renderMode);
            }
            this.iZG.start();
        }
        this.mDetached = false;
        AppMethodBeat.o(134014);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(134015);
        ab.d("CustomGLSurfaceView", "onDetachedFromWindow");
        if (this.iZG != null) {
            this.iZG.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(134015);
    }

    private void checkRenderThreadState() {
        AppMethodBeat.i(134016);
        if (this.iZG != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(134016);
            throw illegalStateException;
        }
        AppMethodBeat.o(134016);
    }

    static {
        AppMethodBeat.i(134017);
        AppMethodBeat.o(134017);
    }
}
