package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.C27360b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.C27360b.C27362a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView */
public class GLSurfaceView extends SurfaceView implements Callback2 {
    private static final C27373j iZF = new C27373j();
    private C27370i iZG;
    private C2548m iZH;
    private C27366e iZI;
    private C27369f iZJ;
    private C27368g iZK;
    private C19840k iZL;
    private int mDebugFlags;
    private boolean mDetached;
    private int mEGLContextClientVersion;
    private boolean mPreserveEGLContextOnPause;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference(this);

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$l */
    static class C2547l extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        C2547l() {
            AppMethodBeat.m2504i(133994);
            AppMethodBeat.m2505o(133994);
        }

        public final void close() {
            AppMethodBeat.m2504i(133995);
            flushBuilder();
            AppMethodBeat.m2505o(133995);
        }

        public final void flush() {
            AppMethodBeat.m2504i(133996);
            flushBuilder();
            AppMethodBeat.m2505o(133996);
        }

        public final void write(char[] cArr, int i, int i2) {
            AppMethodBeat.m2504i(133997);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
            AppMethodBeat.m2505o(133997);
        }

        private void flushBuilder() {
            AppMethodBeat.m2504i(133998);
            if (this.mBuilder.length() > 0) {
                C4990ab.m7418v("GLSurfaceView", this.mBuilder.toString());
                this.mBuilder.delete(0, this.mBuilder.length());
            }
            AppMethodBeat.m2505o(133998);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$m */
    public interface C2548m {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$n */
    class C2549n extends C19839b {
        public C2549n(boolean z) {
            super(z ? 16 : 0);
            AppMethodBeat.m2504i(133999);
            AppMethodBeat.m2505o(133999);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$d */
    static class C10971d implements C27368g {
        private C10971d() {
        }

        /* synthetic */ C10971d(byte b) {
            this();
        }

        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.m2504i(133979);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                C4990ab.m7413e("CustomGLSurfaceView", "eglCreateWindowSurface", e);
            }
            AppMethodBeat.m2505o(133979);
            return eGLSurface;
        }

        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(133980);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.m2505o(133980);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$b */
    class C19839b extends C27371a {
        protected int mAlphaSize = 0;
        protected int mBlueSize = 8;
        protected int mDepthSize;
        protected int mGreenSize = 8;
        protected int mRedSize = 8;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public C19839b(int i) {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, i, 12326, 0, 12344});
            AppMethodBeat.m2504i(133974);
            this.mDepthSize = i;
            this.mStencilSize = 0;
            AppMethodBeat.m2505o(133974);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(133975);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m30727a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = m30727a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                    a = m30727a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = m30727a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = m30727a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = m30727a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                        AppMethodBeat.m2505o(133975);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.m2505o(133975);
            return null;
        }

        /* renamed from: a */
        private int m30727a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            AppMethodBeat.m2504i(133976);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                int i2 = this.mValue[0];
                AppMethodBeat.m2505o(133976);
                return i2;
            }
            AppMethodBeat.m2505o(133976);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$k */
    public interface C19840k {
        GL aPU();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$e */
    public interface C27366e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$c */
    class C27367c implements C27369f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C27367c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C27367c(GLSurfaceView gLSurfaceView, byte b) {
            this();
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.m2504i(133977);
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.m2505o(133977);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(133978);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                C4990ab.m7412e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                C4990ab.m7416i("DefaultContextFactory", "tid=" + Thread.currentThread().getId());
                C27372h.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.m2505o(133978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$g */
    public interface C27368g {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$f */
    public interface C27369f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$i */
    static class C27370i extends Thread {
        private boolean iZN = true;
        private C27372h iZO;
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

        C27370i(WeakReference<GLSurfaceView> weakReference) {
            AppMethodBeat.m2504i(133985);
            this.mGLSurfaceViewWeakRef = weakReference;
            AppMethodBeat.m2505o(133985);
        }

        public final void run() {
            AppMethodBeat.m2504i(133986);
            setName("GLThread " + getId());
            C4990ab.m7416i("GLThread", "starting tid=" + getId());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                GLSurfaceView.iZF.mo45084b(this);
                AppMethodBeat.m2505o(133986);
            }
        }

        /* renamed from: d */
        private void m43444d(GL10 gl10) {
            AppMethodBeat.m2504i(133987);
            if (this.mHaveEglSurface) {
                if (this.iZN && gl10 != null) {
                    C4990ab.m7409c("CustomGLSurfaceView", "alvinluo stopEglsurface", new Object[0]);
                    this.iZN = false;
                    C4990ab.m7416i("CustomGLSurfaceView", "alvinluo saveBitmap");
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(8192000);
                    allocateDirect.position(0);
                    gl10.glReadPixels(0, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2000, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, allocateDirect);
                    C27362a c27362a = C27360b.iZv;
                    C27362a.m43434a(allocateDirect, "/sdcard/test.png");
                }
                this.mHaveEglSurface = false;
                C27372h c27372h = this.iZO;
                C4990ab.m7420w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
                c27372h.destroySurfaceImp();
            }
            AppMethodBeat.m2505o(133987);
        }

        private void stopEglContextLocked() {
            AppMethodBeat.m2504i(133988);
            if (this.mHaveEglContext) {
                C27372h c27372h = this.iZO;
                C4990ab.m7420w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
                if (c27372h.mEglContext != null) {
                    GLSurfaceView gLSurfaceView = (GLSurfaceView) c27372h.mGLSurfaceViewWeakRef.get();
                    if (gLSurfaceView != null) {
                        gLSurfaceView.iZJ.destroyContext(c27372h.mEgl, c27372h.mEglDisplay, c27372h.mEglContext);
                    }
                    c27372h.mEglContext = null;
                }
                if (c27372h.mEglDisplay != null) {
                    c27372h.mEgl.eglTerminate(c27372h.mEglDisplay);
                    c27372h.mEglDisplay = null;
                }
                this.mHaveEglContext = false;
                GLSurfaceView.iZF.notifyAll();
            }
            AppMethodBeat.m2505o(133988);
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
            monitor-enter(com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT());
     */
        /* JADX WARNING: Missing block: B:105:?, code skipped:
            m43444d(r4);
            stopEglContextLocked();
     */
        /* JADX WARNING: Missing block: B:130:0x04a0, code skipped:
            if (r5 == null) goto L_0x070f;
     */
        /* JADX WARNING: Missing block: B:132:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("GLThread", "egl createSurface");
            r6 = r22.iZO;
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("EglHelper", "createSurface()  tid=" + java.lang.Thread.currentThread().getId());
     */
        /* JADX WARNING: Missing block: B:133:0x04d1, code skipped:
            if (r6.mEgl != null) goto L_0x04e2;
     */
        /* JADX WARNING: Missing block: B:134:0x04d3, code skipped:
            r2 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(133989);
     */
        /* JADX WARNING: Missing block: B:135:0x04e1, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:137:0x04e4, code skipped:
            if (r6.mEglDisplay != null) goto L_0x04f5;
     */
        /* JADX WARNING: Missing block: B:138:0x04e6, code skipped:
            r2 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(133989);
     */
        /* JADX WARNING: Missing block: B:139:0x04f4, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:141:0x04f7, code skipped:
            if (r6.mEglConfig != null) goto L_0x0508;
     */
        /* JADX WARNING: Missing block: B:142:0x04f9, code skipped:
            r2 = new java.lang.RuntimeException("mEglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(133989);
     */
        /* JADX WARNING: Missing block: B:143:0x0507, code skipped:
            throw r2;
     */
        /* JADX WARNING: Missing block: B:144:0x0508, code skipped:
            r6.destroySurfaceImp();
            r2 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r6.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:145:0x0513, code skipped:
            if (r2 == null) goto L_0x0677;
     */
        /* JADX WARNING: Missing block: B:146:0x0515, code skipped:
            r7 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43438d(r2);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
     */
        /* JADX WARNING: Missing block: B:154:0x054e, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:155:0x054f, code skipped:
            if (r2 == null) goto L_0x06b2;
     */
        /* JADX WARNING: Missing block: B:156:0x0551, code skipped:
            r5 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:157:0x0555, code skipped:
            monitor-enter(r5);
     */
        /* JADX WARNING: Missing block: B:160:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            r2 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
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
            r2 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r2.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:165:0x0579, code skipped:
            if (r2 == null) goto L_0x070c;
     */
        /* JADX WARNING: Missing block: B:167:0x057f, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43439e(r2) == null) goto L_0x0589;
     */
        /* JADX WARNING: Missing block: B:168:0x0581, code skipped:
            r5 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43439e(r2).aPU();
     */
        /* JADX WARNING: Missing block: B:170:0x058f, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43440f(r2) & 3) == 0) goto L_0x070c;
     */
        /* JADX WARNING: Missing block: B:171:0x0591, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:172:0x0599, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43440f(r2) & 1) == 0) goto L_0x059c;
     */
        /* JADX WARNING: Missing block: B:173:0x059b, code skipped:
            r7 = 1;
     */
        /* JADX WARNING: Missing block: B:175:0x05a2, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43440f(r2) & 2) == 0) goto L_0x0709;
     */
        /* JADX WARNING: Missing block: B:176:0x05a4, code skipped:
            r2 = new com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.C2547l();
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("GLThread", "onSurfaceCreated");
            r2 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:181:0x05c8, code skipped:
            if (r2 == null) goto L_0x05cd;
     */
        /* JADX WARNING: Missing block: B:182:0x05ca, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43442h(r2);
     */
        /* JADX WARNING: Missing block: B:183:0x05cd, code skipped:
            r17 = null;
     */
        /* JADX WARNING: Missing block: B:184:0x05cf, code skipped:
            if (r14 == null) goto L_0x0609;
     */
        /* JADX WARNING: Missing block: B:185:0x05d1, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("GLThread", "onSurfaceChanged(" + r12 + ", " + r11 + ")");
            r2 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:186:0x0603, code skipped:
            if (r2 == null) goto L_0x0608;
     */
        /* JADX WARNING: Missing block: B:187:0x0605, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43442h(r2);
     */
        /* JADX WARNING: Missing block: B:188:0x0608, code skipped:
            r14 = null;
     */
        /* JADX WARNING: Missing block: B:189:0x0609, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7420w("GLThread", "onDrawFrame tid=" + getId());
            r2 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:190:0x062d, code skipped:
            if (r2 == null) goto L_0x0638;
     */
        /* JADX WARNING: Missing block: B:191:0x062f, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.m43442h(r2);
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
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.C27372h.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
            r5 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:199:0x065e, code skipped:
            monitor-enter(r5);
     */
        /* JADX WARNING: Missing block: B:202:?, code skipped:
            r22.mSurfaceIsBad = true;
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT().notifyAll();
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
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.C27372h.logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", r6.mEgl.eglGetError());
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
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(133989);
     */
        /* JADX WARNING: Missing block: B:222:0x06b2, code skipped:
            r6 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT();
     */
        /* JADX WARNING: Missing block: B:223:0x06b6, code skipped:
            monitor-enter(r6);
     */
        /* JADX WARNING: Missing block: B:226:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            r22.mSurfaceIsBad = true;
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView.aPT().notifyAll();
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
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r3);
     */
        /* JADX WARNING: Missing block: B:233:0x06d6, code skipped:
            r2 = 12288;
     */
        /* JADX WARNING: Missing block: B:234:0x06da, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("GLThread", "egl context lost tid=" + getId());
     */
        /* JADX WARNING: Missing block: B:235:0x06f4, code skipped:
            r15 = 1;
     */
        /* JADX WARNING: Missing block: B:236:0x06f7, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:240:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r3);
     */
        /* JADX WARNING: Missing block: B:245:0x0702, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(133989);
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
            AppMethodBeat.m2504i(133989);
            this.iZO = new C27372h(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            EGLConfig eGLConfig = null;
            C27373j c27373j = null;
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
                C27373j aPT = GLSurfaceView.iZF;
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
                                        C4990ab.m7416i("GLThread", thread);
                                    }
                                    EGLDisplay eGLDisplay = this.mShouldReleaseEglContext;
                                    if (eGLDisplay != null) {
                                        thread = "releasing EGL context because asked to tid=";
                                        eGLDisplay = getId();
                                        C4990ab.m7416i("GLThread", eGLDisplay);
                                        m43444d(gl102);
                                        stopEglContextLocked();
                                        z2 = false;
                                        this.mShouldReleaseEglContext = false;
                                        z = true;
                                    } else {
                                        z = z2;
                                    }
                                    if (obj2 != null) {
                                        m43444d(gl102);
                                        stopEglContextLocked();
                                        obj2 = null;
                                    }
                                    if (z3) {
                                        z2 = this.mHaveEglSurface;
                                        if (z2) {
                                            z2 = "GLThread";
                                            thread = "releasing EGL surface because paused tid=";
                                            eGLDisplay = getId();
                                            C4990ab.m7416i(z2, eGLDisplay);
                                            m43444d(gl102);
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
                                            C4990ab.m7416i("GLThread", z2);
                                        }
                                    }
                                    if (!(this.mHasSurface || this.mWaitingForSurface)) {
                                        eGLDisplay = "noticed surfaceView surface lost tid=";
                                        z2 = getId();
                                        C4990ab.m7416i("GLThread", z2);
                                        if (this.mHaveEglSurface) {
                                            m43444d(gl102);
                                        }
                                        this.mWaitingForSurface = true;
                                        this.mSurfaceIsBad = false;
                                        GLSurfaceView.iZF.notifyAll();
                                    }
                                    if (this.mHasSurface && this.mWaitingForSurface) {
                                        eGLDisplay = "noticed surfaceView surface acquired tid=";
                                        z2 = getId();
                                        C4990ab.m7416i("GLThread", z2);
                                        this.mWaitingForSurface = false;
                                        GLSurfaceView.iZF.notifyAll();
                                    }
                                    if (i != 0) {
                                        StringBuilder stringBuilder = new StringBuilder("sending render notification tid=");
                                        z2 = getId();
                                        C4990ab.m7416i("GLThread", stringBuilder.append(z2).toString());
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
                                                C4990ab.m7420w("EglHelper", stringBuilder2.append(thread.getId()).toString());
                                                z2.mEgl = (EGL10) EGLContext.getEGL();
                                                z2.mEglDisplay = z2.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                                i5 = z2.mEglDisplay;
                                                eGLDisplay = EGL10.EGL_NO_DISPLAY;
                                                if (i5 == eGLDisplay) {
                                                    e = new RuntimeException("eglGetDisplay failed");
                                                    AppMethodBeat.m2505o(133989);
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
                                                        C27369f c = gLSurfaceView.iZJ;
                                                        eGLDisplay = z2.mEgl;
                                                        thread = z2.mEglDisplay;
                                                        eGLConfig = z2.mEglConfig;
                                                        z2.mEglContext = c.createContext(eGLDisplay, thread, eGLConfig);
                                                    }
                                                    if (z2.mEglContext == null || z2.mEglContext == EGL10.EGL_NO_CONTEXT) {
                                                        z2.mEglContext = null;
                                                        C27372h.throwEglException("createContext", z2.mEgl.eglGetError());
                                                    }
                                                    stringBuilder2 = new StringBuilder("createContext ").append(z2.mEglContext).append(" tid=");
                                                    thread = Thread.currentThread();
                                                    eGLDisplay = stringBuilder2.append(thread.getId()).toString();
                                                    C4990ab.m7420w("EglHelper", eGLDisplay);
                                                    z2.mEglSurface = null;
                                                    this.mHaveEglContext = true;
                                                    boolean z5 = true;
                                                    GLSurfaceView.iZF.notifyAll();
                                                } else {
                                                    e = new RuntimeException("eglInitialize failed");
                                                    AppMethodBeat.m2505o(133989);
                                                    throw e;
                                                }
                                            }
                                        }
                                        if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                            this.mHaveEglSurface = true;
                                            c27373j = true;
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
                                                C4990ab.m7416i("GLThread", "noticing that we want render notification tid=" + getId());
                                                c27373j = true;
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
                                        C4990ab.m7416i("GLThread", append.append(i4).toString());
                                        GLSurfaceView.iZF.wait();
                                    } else {
                                        if (runnable != null) {
                                            C4990ab.m7420w("CustomGLSurfaceView", "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                            runnable.run();
                                            runnable = null;
                                        }
                                        append = new StringBuilder("waiting tid=").append(getId()).append(" mHaveEglContext: ").append(this.mHaveEglContext).append(" mHaveEglSurface: ").append(this.mHaveEglSurface).append(" mFinishedCreatingEglSurface: ").append(this.mFinishedCreatingEglSurface).append(" mPaused: ").append(this.mPaused).append(" mHasSurface: ").append(this.mHasSurface).append(" mSurfaceIsBad: ").append(this.mSurfaceIsBad).append(" mWaitingForSurface: ").append(this.mWaitingForSurface).append(" mWidth: ").append(this.mWidth).append(" mHeight: ").append(this.mHeight).append(" mRequestRender: ").append(this.mRequestRender).append(" mRenderMode: ");
                                        i4 = this.mRenderMode;
                                        C4990ab.m7416i("GLThread", append.append(i4).toString());
                                        GLSurfaceView.iZF.wait();
                                    }
                                } catch (RuntimeException e2) {
                                    e = e2;
                                    GLSurfaceView.iZF.notifyAll();
                                } finally {
                                    i = 133989;
                                    AppMethodBeat.m2505o(133989);
                                }
                            } else {
                                ArrayList th = this.mEventQueue;
                            }
                        }
                    }
                }
                synchronized (GLSurfaceView.iZF) {
                    try {
                        m43444d(null);
                        stopEglContextLocked();
                    } finally {
                        while (true) {
                            AppMethodBeat.m2505o(133989);
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
            AppMethodBeat.m2504i(133990);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.m2505o(133990);
                throw illegalArgumentException;
            }
            synchronized (GLSurfaceView.iZF) {
                try {
                    this.mRenderMode = i;
                    GLSurfaceView.iZF.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133990);
                }
            }
        }

        public final int getRenderMode() {
            int i;
            AppMethodBeat.m2504i(133991);
            synchronized (GLSurfaceView.iZF) {
                try {
                    i = this.mRenderMode;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133991);
                }
            }
            return i;
        }

        public final void requestExitAndWait() {
            AppMethodBeat.m2504i(133992);
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
                    AppMethodBeat.m2505o(133992);
                }
            }
            AppMethodBeat.m2505o(133992);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$a */
    abstract class C27371a implements C27366e {
        protected int[] mConfigSpec;

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C27371a(int[] iArr) {
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

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$h */
    static class C27372h {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public C27372h(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* Access modifiers changed, original: final */
        public final void destroySurfaceImp() {
            AppMethodBeat.m2504i(133981);
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
            AppMethodBeat.m2505o(133981);
        }

        public static void throwEglException(String str, int i) {
            AppMethodBeat.m2504i(133982);
            String formatEglError = C27372h.formatEglError(str, i);
            C4990ab.m7412e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + formatEglError);
            RuntimeException runtimeException = new RuntimeException(formatEglError);
            AppMethodBeat.m2505o(133982);
            throw runtimeException;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            AppMethodBeat.m2504i(133983);
            C4990ab.m7420w(str, C27372h.formatEglError(str2, i));
            AppMethodBeat.m2505o(133983);
        }

        private static String formatEglError(String str, int i) {
            AppMethodBeat.m2504i(133984);
            String str2 = str + " failed: " + i;
            AppMethodBeat.m2505o(133984);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GLSurfaceView$j */
    static class C27373j {
        private static String TAG = "GLThreadManager";

        private C27373j() {
        }

        /* synthetic */ C27373j(byte b) {
            this();
        }

        /* renamed from: b */
        public final synchronized void mo45084b(C27370i c27370i) {
            AppMethodBeat.m2504i(133993);
            C4990ab.m7416i("GLThread", "exiting tid=" + c27370i.getId());
            c27370i.mExited = true;
            notifyAll();
            AppMethodBeat.m2505o(133993);
        }
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134000);
        getHolder().addCallback(this);
        AppMethodBeat.m2505o(134000);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(134001);
        try {
            if (this.iZG != null) {
                this.iZG.requestExitAndWait();
            }
            super.finalize();
            AppMethodBeat.m2505o(134001);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(134001);
        }
    }

    public void setGLWrapper(C19840k c19840k) {
        this.iZL = c19840k;
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

    public void setRenderer(C2548m c2548m) {
        AppMethodBeat.m2504i(134002);
        checkRenderThreadState();
        if (this.iZI == null) {
            this.iZI = new C2549n(true);
        }
        if (this.iZJ == null) {
            this.iZJ = new C27367c(this, (byte) 0);
        }
        if (this.iZK == null) {
            this.iZK = new C10971d();
        }
        this.iZH = c2548m;
        this.iZG = new C27370i(this.mThisWeakRef);
        this.iZG.start();
        AppMethodBeat.m2505o(134002);
    }

    public void setEGLContextFactory(C27369f c27369f) {
        AppMethodBeat.m2504i(134003);
        checkRenderThreadState();
        this.iZJ = c27369f;
        AppMethodBeat.m2505o(134003);
    }

    public void setEGLWindowSurfaceFactory(C27368g c27368g) {
        AppMethodBeat.m2504i(134004);
        checkRenderThreadState();
        this.iZK = c27368g;
        AppMethodBeat.m2505o(134004);
    }

    public void setEGLConfigChooser(C27366e c27366e) {
        AppMethodBeat.m2504i(134005);
        checkRenderThreadState();
        this.iZI = c27366e;
        AppMethodBeat.m2505o(134005);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.m2504i(134006);
        setEGLConfigChooser(new C2549n(z));
        AppMethodBeat.m2505o(134006);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.m2504i(134007);
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
        AppMethodBeat.m2505o(134007);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(134008);
        this.iZG.setRenderMode(i);
        AppMethodBeat.m2505o(134008);
    }

    public int getRenderMode() {
        AppMethodBeat.m2504i(134009);
        int renderMode = this.iZG.getRenderMode();
        AppMethodBeat.m2505o(134009);
        return renderMode;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(134010);
        C27370i c27370i = this.iZG;
        synchronized (iZF) {
            try {
                C4990ab.m7416i("GLThread", "surfaceCreated tid=" + c27370i.getId());
                c27370i.mHasSurface = true;
                c27370i.mFinishedCreatingEglSurface = false;
                iZF.notifyAll();
                while (c27370i.mWaitingForSurface && !c27370i.mFinishedCreatingEglSurface && !c27370i.mExited) {
                    iZF.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134010);
            }
        }
        AppMethodBeat.m2505o(134010);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(134011);
        C27370i c27370i = this.iZG;
        synchronized (iZF) {
            try {
                C4990ab.m7416i("GLThread", "surfaceDestroyed tid=" + c27370i.getId());
                c27370i.mHasSurface = false;
                iZF.notifyAll();
                while (!c27370i.mWaitingForSurface && !c27370i.mExited) {
                    iZF.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134011);
            }
        }
        AppMethodBeat.m2505o(134011);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(134012);
        Thread thread = this.iZG;
        synchronized (iZF) {
            try {
                thread.mWidth = i2;
                thread.mHeight = i3;
                thread.mSizeChanged = true;
                thread.mRequestRender = true;
                thread.mRenderComplete = false;
                if (Thread.currentThread() == thread) {
                    AppMethodBeat.m2505o(134012);
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
                        C4990ab.m7416i("Main thread", "onWindowResize waiting for render complete from tid=" + thread.getId());
                        iZF.wait();
                    }
                }
                AppMethodBeat.m2505o(134012);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134012);
            }
        }
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        AppMethodBeat.m2504i(134013);
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
                        AppMethodBeat.m2505o(134013);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(134013);
                }
            }
        } else {
            AppMethodBeat.m2505o(134013);
        }
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(134014);
        super.onAttachedToWindow();
        C4990ab.m7410d("CustomGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached);
        if (this.mDetached && this.iZH != null) {
            int renderMode;
            if (this.iZG != null) {
                renderMode = this.iZG.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.iZG = new C27370i(this.mThisWeakRef);
            if (renderMode != 1) {
                this.iZG.setRenderMode(renderMode);
            }
            this.iZG.start();
        }
        this.mDetached = false;
        AppMethodBeat.m2505o(134014);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(134015);
        C4990ab.m7410d("CustomGLSurfaceView", "onDetachedFromWindow");
        if (this.iZG != null) {
            this.iZG.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(134015);
    }

    private void checkRenderThreadState() {
        AppMethodBeat.m2504i(134016);
        if (this.iZG != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.m2505o(134016);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(134016);
    }

    static {
        AppMethodBeat.m2504i(134017);
        AppMethodBeat.m2505o(134017);
    }
}
