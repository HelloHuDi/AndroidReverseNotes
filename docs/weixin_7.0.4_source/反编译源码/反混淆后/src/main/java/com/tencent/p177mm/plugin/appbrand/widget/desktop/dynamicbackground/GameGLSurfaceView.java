package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.Context;
import android.opengl.GLException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.facebook.internal.ServerProtocol;
import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.io.IOException;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView */
public class GameGLSurfaceView extends SurfaceView implements Callback2 {
    private static final C10972k iZP = new C10972k();
    public C27375j iZQ;
    private C33606n iZR;
    private C38580e iZS;
    private C38582f iZT;
    private C38581h iZU;
    private C2550l iZV;
    private boolean iZW = false;
    private int mDebugFlags;
    private boolean mDetached;
    private int mEGLContextClientVersion;
    private boolean mPreserveEGLContextOnPause;
    private final WeakReference<GameGLSurfaceView> mThisWeakRef = new WeakReference(this);

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$l */
    public interface C2550l {
        GL aPU();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$k */
    static class C10972k {
        private static String TAG = "GLThreadManager";

        private C10972k() {
        }

        /* synthetic */ C10972k(byte b) {
            this();
        }

        /* renamed from: f */
        public final synchronized void mo22594f(C27375j c27375j) {
            AppMethodBeat.m2504i(134088);
            C17837c.m27916i("MicroMsg.GLThread", "exiting tid=" + c27375j.getId(), new Object[0]);
            GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) c27375j.mGLSurfaceViewWeakRef.get();
            if (gameGLSurfaceView != null) {
                gameGLSurfaceView.iZR.onDestroy();
            } else {
                C17837c.m27916i("MicroMsg.GLThread", "onFinalize:view = null", new Object[0]);
            }
            C19843i b = c27375j.jai;
            C17837c.m27918w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId(), new Object[0]);
            b.destroySurfaceImp();
            C27375j.m43449c(c27375j);
            C27375j.m43450d(c27375j);
            try {
                C19843i b2 = c27375j.jai;
                C17837c.m27918w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
                if (b2.mEglContext != null) {
                    GameGLSurfaceView gameGLSurfaceView2 = (GameGLSurfaceView) b2.mGLSurfaceViewWeakRef.get();
                    if (gameGLSurfaceView2 != null) {
                        gameGLSurfaceView2.iZT.destroyContext(b2.mEgl, b2.mEglDisplay, b2.mEglContext);
                    }
                    b2.mEglContext = null;
                }
                if (b2.mEglDisplay != null) {
                    b2.mEgl.eglTerminate(b2.mEglDisplay);
                    b2.mEglDisplay = null;
                }
            } catch (Throwable th) {
                C17837c.m27915e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", Log.getStackTraceString(th));
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.iZR.aPF();
                }
            }
            c27375j.mExited = true;
            notifyAll();
            AppMethodBeat.m2505o(134088);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$b */
    class C19841b extends C33604a {
        protected int mAlphaSize = 8;
        protected int mBlueSize = 8;
        protected int mDepthSize = 16;
        protected int mGreenSize = 8;
        protected int mRedSize = 8;
        protected int mStencilSize = 8;
        private int[] mValue = new int[1];

        public C19841b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 8, 12344});
            AppMethodBeat.m2504i(134018);
            AppMethodBeat.m2505o(134018);
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.m2504i(134019);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = m30728a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = m30728a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.mDepthSize && a2 >= this.mStencilSize) {
                    a = m30728a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = m30728a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = m30728a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = m30728a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.mRedSize && a2 == this.mGreenSize && a3 == this.mBlueSize && a4 == this.mAlphaSize) {
                        AppMethodBeat.m2505o(134019);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.m2505o(134019);
            return null;
        }

        /* renamed from: a */
        private int m30728a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            AppMethodBeat.m2504i(134020);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                int i2 = this.mValue[0];
                AppMethodBeat.m2505o(134020);
                return i2;
            }
            AppMethodBeat.m2505o(134020);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$d */
    static class C19842d implements C38581h {
        private C19842d() {
        }

        /* synthetic */ C19842d(byte b) {
            this();
        }

        public final EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.m2504i(134023);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
                C17837c.m27915e("MicroMsg.GameGLSurfaceView", "eglCreateWindowSurface", e);
            }
            AppMethodBeat.m2505o(134023);
            return eGLSurface;
        }

        public final void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(134024);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.m2505o(134024);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$i */
    static class C19843i {
        EGLSurface jad;
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        WeakReference<GameGLSurfaceView> mGLSurfaceViewWeakRef;

        public C19843i(WeakReference<GameGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public final void start() {
            AppMethodBeat.m2504i(134072);
            C17837c.m27918w("MicroMsg.GLThread", "start() tid=" + Thread.currentThread().getId(), new Object[0]);
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.m2505o(134072);
                throw runtimeException;
            }
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gameGLSurfaceView == null) {
                    this.mEglConfig = null;
                    this.mEglContext = null;
                    C17837c.m27918w("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start but view is null and set mEglConfig = null, mEglContext = null", new Object[0]);
                } else {
                    this.mEglConfig = gameGLSurfaceView.iZS.chooseConfig(this.mEgl, this.mEglDisplay);
                    C17837c.m27916i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start chooseConfig end config: %s, display: %s", Integer.valueOf(this.mEglConfig.hashCode()), Integer.valueOf(this.mEglDisplay.hashCode()));
                    this.mEglContext = gameGLSurfaceView.iZT.mo45085b(this.mEgl, this.mEglDisplay, this.mEglConfig, EGL10.EGL_NO_CONTEXT);
                    C17837c.m27916i("MicroMsg.GameGLSurfaceView", "alvinluo EglHelper start createContext end", new Object[0]);
                }
                if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                    this.mEglContext = null;
                    C19843i.throwEglException("createContext", this.mEgl.eglGetError());
                }
                C17837c.m27918w("MicroMsg.GLThread", "createContext " + this.mEglContext + " tid=" + Thread.currentThread().getId(), new Object[0]);
                this.jad = this.mEgl.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, new int[]{12375, 16, 12374, 16, 12344});
                this.mEgl.eglMakeCurrent(this.mEglDisplay, this.jad, this.jad, this.mEglContext);
                this.mEglSurface = null;
                AppMethodBeat.m2505o(134072);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.m2505o(134072);
            throw runtimeException;
        }

        /* Access modifiers changed, original: final */
        public final void destroySurfaceImp() {
            AppMethodBeat.m2504i(134073);
            if (!(this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GameGLSurfaceView gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gameGLSurfaceView != null) {
                    gameGLSurfaceView.iZU.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
            AppMethodBeat.m2505o(134073);
        }

        public static void throwEglException(String str, int i) {
            AppMethodBeat.m2504i(134074);
            String formatEglError = C19843i.formatEglError(str, i);
            C17837c.m27915e("MicroMsg.GLThread", "throwEglException tid=" + Thread.currentThread().getId() + " " + formatEglError, new Object[0]);
            RuntimeException runtimeException = new RuntimeException(formatEglError);
            AppMethodBeat.m2505o(134074);
            throw runtimeException;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            AppMethodBeat.m2504i(134075);
            C17837c.m27918w(str, C19843i.formatEglError(str2, i), new Object[0]);
            AppMethodBeat.m2505o(134075);
        }

        private static String formatEglError(String str, int i) {
            AppMethodBeat.m2504i(134076);
            String str2 = str + " failed: " + C38579g.getErrorString(i);
            AppMethodBeat.m2505o(134076);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$c */
    class C27374c implements C38582f {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private C27374c() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ C27374c(GameGLSurfaceView gameGLSurfaceView, byte b) {
            this();
        }

        /* renamed from: b */
        public final EGLContext mo45085b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
            AppMethodBeat.m2504i(134021);
            C17837c.m27916i("MicroMsg.GLThread", "createContext", new Object[0]);
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GameGLSurfaceView.this.mEGLContextClientVersion, 12344};
            if (GameGLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.m2505o(134021);
            return eglCreateContext;
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(134022);
            C17837c.m27916i("MicroMsg.GLThread", " destroyContext tid=" + Thread.currentThread().getId(), new Object[0]);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                C17837c.m27915e("MicroMsg.GLThread", "display:" + eGLDisplay + " context: " + eGLContext, new Object[0]);
                C19843i.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.m2505o(134022);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$j */
    public static class C27375j extends Thread {
        private boolean jae;
        boolean jaf;
        boolean jag;
        private LinkedList<Runnable> jah = new LinkedList();
        private C19843i jai;
        boolean mExited;
        boolean mFinishedCreatingEglSurface;
        private WeakReference<GameGLSurfaceView> mGLSurfaceViewWeakRef;
        boolean mHasSurface;
        boolean mHaveEglContext;
        boolean mHaveEglSurface;
        int mHeight;
        boolean mPaused;
        boolean mRenderComplete;
        private int mRenderMode;
        boolean mRequestPaused;
        boolean mRequestRender;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        boolean mWaitingForSurface;
        private boolean mWantRenderNotification;
        int mWidth;

        /* renamed from: c */
        static /* synthetic */ void m43449c(C27375j c27375j) {
            AppMethodBeat.m2504i(134086);
            c27375j.stopEglSurfaceLocked();
            AppMethodBeat.m2505o(134086);
        }

        /* renamed from: d */
        static /* synthetic */ void m43450d(C27375j c27375j) {
            AppMethodBeat.m2504i(134087);
            c27375j.stopEglContextLocked();
            AppMethodBeat.m2505o(134087);
        }

        C27375j(WeakReference<GameGLSurfaceView> weakReference) {
            AppMethodBeat.m2504i(134077);
            try {
                setPriority(10);
            } catch (Exception e) {
            }
            this.mWidth = 0;
            this.mHeight = 0;
            this.mRequestRender = true;
            this.mRenderMode = 1;
            this.mWantRenderNotification = false;
            this.mGLSurfaceViewWeakRef = weakReference;
            AppMethodBeat.m2505o(134077);
        }

        public final void run() {
            AppMethodBeat.m2504i(134078);
            setName("MicroMsg.GLThread" + getId());
            C17837c.m27916i("MicroMsg.GLThread", "starting tid=" + getId(), new Object[0]);
            try {
                guardedRun();
                GameGLSurfaceView.iZP.mo22594f(this);
                AppMethodBeat.m2505o(134078);
            } catch (InterruptedException e) {
                C17837c.m27915e("MicroMsg.GLThread", Log.getStackTraceString(e) + " hy: InterruptedException", new Object[0]);
                GameGLSurfaceView.iZP.mo22594f(this);
                AppMethodBeat.m2505o(134078);
            } catch (Throwable th) {
                GameGLSurfaceView.iZP.mo22594f(this);
                AppMethodBeat.m2505o(134078);
                throw th;
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mFinishedCreatingEglSurface = false;
            }
        }

        private void stopEglContextLocked() {
            AppMethodBeat.m2504i(134079);
            if (this.mHaveEglContext) {
                this.mHaveEglContext = false;
                GameGLSurfaceView.iZP.notifyAll();
            }
            AppMethodBeat.m2505o(134079);
        }

        /* JADX WARNING: Removed duplicated region for block: B:135:0x038e A:{Catch:{ all -> 0x070c, all -> 0x06d8, all -> 0x05d0, all -> 0x05a0, RuntimeException -> 0x037f, RuntimeException -> 0x02c6, all -> 0x0276, Throwable -> 0x027f }} */
        /* JADX WARNING: Removed duplicated region for block: B:302:0x0318 A:{SYNTHETIC} */
        /* JADX WARNING: Missing block: B:30:0x007a, code skipped:
            if (r12 == null) goto L_0x03c8;
     */
        /* JADX WARNING: Missing block: B:32:?, code skipped:
            r12.run();
     */
        /* JADX WARNING: Missing block: B:33:0x007f, code skipped:
            r12 = null;
            r18 = r5;
     */
        /* JADX WARNING: Missing block: B:141:0x03c8, code skipped:
            if (r9 == null) goto L_0x071b;
     */
        /* JADX WARNING: Missing block: B:143:?, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27918w("MicroMsg.GLThread", "egl createSurface", new java.lang.Object[0]);
            r10 = r22.jai;
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27918w("MicroMsg.GLThread", "createSurface()  tid=" + java.lang.Thread.currentThread().getId(), new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:144:0x0408, code skipped:
            if (r10.mEgl != null) goto L_0x0421;
     */
        /* JADX WARNING: Missing block: B:145:0x040a, code skipped:
            r4 = new java.lang.RuntimeException("egl not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(134080);
     */
        /* JADX WARNING: Missing block: B:146:0x0418, code skipped:
            throw r4;
     */
        /* JADX WARNING: Missing block: B:152:0x0423, code skipped:
            if (r10.mEglDisplay != null) goto L_0x0434;
     */
        /* JADX WARNING: Missing block: B:153:0x0425, code skipped:
            r4 = new java.lang.RuntimeException("eglDisplay not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(134080);
     */
        /* JADX WARNING: Missing block: B:154:0x0433, code skipped:
            throw r4;
     */
        /* JADX WARNING: Missing block: B:156:0x0436, code skipped:
            if (r10.mEglConfig != null) goto L_0x0447;
     */
        /* JADX WARNING: Missing block: B:157:0x0438, code skipped:
            r4 = new java.lang.RuntimeException("mEglConfig not initialized");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(134080);
     */
        /* JADX WARNING: Missing block: B:158:0x0446, code skipped:
            throw r4;
     */
        /* JADX WARNING: Missing block: B:159:0x0447, code skipped:
            r10.destroySurfaceImp();
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r10.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:160:0x0452, code skipped:
            if (r4 == null) goto L_0x0556;
     */
        /* JADX WARNING: Missing block: B:161:0x0454, code skipped:
            r11 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65388d(r4);
            r18 = r10.mEgl;
            r19 = r10.mEglDisplay;
            r10.mEglSurface = r11.createWindowSurface(r18, r19, r10.mEglConfig, r4.getHolder());
     */
        /* JADX WARNING: Missing block: B:163:0x0476, code skipped:
            if (r10.mEglSurface == null) goto L_0x047e;
     */
        /* JADX WARNING: Missing block: B:165:0x047c, code skipped:
            if (r10.mEglSurface != javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x055b;
     */
        /* JADX WARNING: Missing block: B:167:0x0486, code skipped:
            if (r10.mEgl.eglGetError() != 12299) goto L_0x0494;
     */
        /* JADX WARNING: Missing block: B:168:0x0488, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27915e("MicroMsg.GLThread", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:169:0x0494, code skipped:
            r4 = null;
     */
        /* JADX WARNING: Missing block: B:170:0x0495, code skipped:
            if (r4 == null) goto L_0x05a9;
     */
        /* JADX WARNING: Missing block: B:171:0x0497, code skipped:
            r9 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW();
     */
        /* JADX WARNING: Missing block: B:172:0x049b, code skipped:
            monitor-enter(r9);
     */
        /* JADX WARNING: Missing block: B:175:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW().notifyAll();
     */
        /* JADX WARNING: Missing block: B:176:0x04a8, code skipped:
            monitor-exit(r9);
     */
        /* JADX WARNING: Missing block: B:177:0x04a9, code skipped:
            if (r17 != null) goto L_0x04ca;
     */
        /* JADX WARNING: Missing block: B:179:?, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27916i("MicroMsg.GLThread", "notifyOnEglSurfaceChanged", new java.lang.Object[0]);
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:180:0x04c1, code skipped:
            if (r4 == null) goto L_0x04ca;
     */
        /* JADX WARNING: Missing block: B:181:0x04c3, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65391g(r4).aPD();
     */
        /* JADX WARNING: Missing block: B:182:0x04ca, code skipped:
            r11 = null;
     */
        /* JADX WARNING: Missing block: B:183:0x04cc, code skipped:
            if (r16 == null) goto L_0x0525;
     */
        /* JADX WARNING: Missing block: B:184:0x04ce, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27918w("MicroMsg.GLThread", "createGLInterface", new java.lang.Object[0]);
            r4 = r22.jai;
            r9 = r4.mEglContext.getGL();
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r4.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:185:0x04ec, code skipped:
            if (r4 == null) goto L_0x0523;
     */
        /* JADX WARNING: Missing block: B:187:0x04f2, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65389e(r4) == null) goto L_0x04fc;
     */
        /* JADX WARNING: Missing block: B:188:0x04f4, code skipped:
            r9 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65389e(r4).aPU();
     */
        /* JADX WARNING: Missing block: B:190:0x0502, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65390f(r4) & 3) == 0) goto L_0x0523;
     */
        /* JADX WARNING: Missing block: B:191:0x0504, code skipped:
            r16 = 0;
     */
        /* JADX WARNING: Missing block: B:192:0x050d, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65390f(r4) & 1) == 0) goto L_0x0511;
     */
        /* JADX WARNING: Missing block: B:193:0x050f, code skipped:
            r16 = 1;
     */
        /* JADX WARNING: Missing block: B:195:0x0517, code skipped:
            if ((com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65390f(r4) & 2) == 0) goto L_0x072a;
     */
        /* JADX WARNING: Missing block: B:196:0x0519, code skipped:
            r4 = new com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.C33605m();
     */
        /* JADX WARNING: Missing block: B:197:0x051e, code skipped:
            android.opengl.GLDebugHelper.wrap(r9, r16, r4);
     */
        /* JADX WARNING: Missing block: B:198:0x0523, code skipped:
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:199:0x0525, code skipped:
            if (r17 == null) goto L_0x052e;
     */
        /* JADX WARNING: Missing block: B:200:0x0527, code skipped:
            r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:201:0x052e, code skipped:
            if (r17 == null) goto L_0x05e7;
     */
        /* JADX WARNING: Missing block: B:202:0x0530, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27918w("MicroMsg.GLThread", "createEglContext", new java.lang.Object[0]);
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:203:0x0546, code skipped:
            if (r4 == null) goto L_0x05d9;
     */
        /* JADX WARNING: Missing block: B:204:0x0548, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65391g(r4).aPC();
     */
        /* JADX WARNING: Missing block: B:205:0x054f, code skipped:
            r17 = null;
            r18 = r5;
            r9 = r11;
     */
        /* JADX WARNING: Missing block: B:206:0x0556, code skipped:
            r10.mEglSurface = null;
     */
        /* JADX WARNING: Missing block: B:208:0x0575, code skipped:
            if (r10.mEgl.eglMakeCurrent(r10.mEglDisplay, r10.mEglSurface, r10.mEglSurface, r10.mEglContext) != false) goto L_0x0589;
     */
        /* JADX WARNING: Missing block: B:209:0x0577, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.C19843i.logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", r10.mEgl.eglGetError());
            r4 = null;
     */
        /* JADX WARNING: Missing block: B:211:0x058b, code skipped:
            if (r10.jad == null) goto L_0x059d;
     */
        /* JADX WARNING: Missing block: B:212:0x058d, code skipped:
            r10.mEgl.eglDestroySurface(r10.mEglDisplay, r10.jad);
            r10.jad = null;
     */
        /* JADX WARNING: Missing block: B:213:0x059d, code skipped:
            r4 = 1;
     */
        /* JADX WARNING: Missing block: B:221:0x05a9, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27915e("MicroMsg.GLThread", "egl createSurface error", new java.lang.Object[0]);
            r10 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW();
     */
        /* JADX WARNING: Missing block: B:222:0x05b9, code skipped:
            monitor-enter(r10);
     */
        /* JADX WARNING: Missing block: B:225:?, code skipped:
            r22.mFinishedCreatingEglSurface = true;
            r22.mSurfaceIsBad = true;
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW().notifyAll();
     */
        /* JADX WARNING: Missing block: B:226:0x05cb, code skipped:
            monitor-exit(r10);
     */
        /* JADX WARNING: Missing block: B:227:0x05cc, code skipped:
            r18 = r5;
     */
        /* JADX WARNING: Missing block: B:234:0x05d9, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27915e("MicroMsg.GLThread", "alvinluo GLSurfaceView null", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:235:0x05e7, code skipped:
            if (r5 == null) goto L_0x0718;
     */
        /* JADX WARNING: Missing block: B:236:0x05e9, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27918w("MicroMsg.GLThread", "onSurfaceChanged(" + r14 + ", " + r13 + ")", new java.lang.Object[0]);
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:237:0x061e, code skipped:
            if (r4 == null) goto L_0x0633;
     */
        /* JADX WARNING: Missing block: B:239:?, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65391g(r4).mo45044do(r14, r13);
     */
        /* JADX WARNING: Missing block: B:241:?, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27915e("MicroMsg.GLThread", "GLThread#sizeChanged out synchronized", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:242:0x0633, code skipped:
            r10 = null;
     */
        /* JADX WARNING: Missing block: B:243:0x0635, code skipped:
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:244:0x063f, code skipped:
            if (r4 == null) goto L_0x0648;
     */
        /* JADX WARNING: Missing block: B:245:0x0641, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65391g(r4).aPE();
     */
        /* JADX WARNING: Missing block: B:246:0x0648, code skipped:
            r22.mGLSurfaceViewWeakRef.get();
            r5 = 12288;
            r9 = true;
            r4 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r22.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:247:0x065c, code skipped:
            if (r4 == null) goto L_0x0662;
     */
        /* JADX WARNING: Missing block: B:248:0x065e, code skipped:
            r9 = r4.getIsSwapNow();
     */
        /* JADX WARNING: Missing block: B:249:0x0662, code skipped:
            if (r9 == false) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:250:0x0664, code skipped:
            r9 = r22.jai;
            r5 = 12288;
     */
        /* JADX WARNING: Missing block: B:251:0x066e, code skipped:
            if (r9.mEglDisplay == null) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:253:0x067a, code skipped:
            if (r9.mEglDisplay == javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:255:0x0680, code skipped:
            if (r9.mEglSurface == null) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:257:0x068c, code skipped:
            if (r9.mEglSurface == javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:259:0x069e, code skipped:
            if (r9.mEgl.eglSwapBuffers(r9.mEglDisplay, r9.mEglSurface) != false) goto L_0x06a6;
     */
        /* JADX WARNING: Missing block: B:260:0x06a0, code skipped:
            r5 = r9.mEgl.eglGetError();
     */
        /* JADX WARNING: Missing block: B:261:0x06a6, code skipped:
            if (r4 == null) goto L_0x06ac;
     */
        /* JADX WARNING: Missing block: B:262:0x06a8, code skipped:
            r4.setSwapNow(true);
     */
        /* JADX WARNING: Missing block: B:263:0x06ac, code skipped:
            switch(r5) {
                case 12288: goto L_0x06ca;
                case 12302: goto L_0x06ec;
                default: goto L_0x06af;
            };
     */
        /* JADX WARNING: Missing block: B:264:0x06af, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.C19843i.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r5);
            r5 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW();
     */
        /* JADX WARNING: Missing block: B:265:0x06bc, code skipped:
            monitor-enter(r5);
     */
        /* JADX WARNING: Missing block: B:268:?, code skipped:
            r22.mSurfaceIsBad = true;
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW().notifyAll();
     */
        /* JADX WARNING: Missing block: B:269:0x06c9, code skipped:
            monitor-exit(r5);
     */
        /* JADX WARNING: Missing block: B:270:0x06ca, code skipped:
            if (r7 == null) goto L_0x0715;
     */
        /* JADX WARNING: Missing block: B:271:0x06cc, code skipped:
            r4 = 1;
            r5 = null;
     */
        /* JADX WARNING: Missing block: B:273:?, code skipped:
            aPX();
            r6 = r4;
            r7 = r5;
            r18 = r10;
            r9 = r11;
     */
        /* JADX WARNING: Missing block: B:277:0x06ec, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27916i("MicroMsg.GLThread", "egl context lost tid=" + getId(), new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:278:0x0709, code skipped:
            r8 = 1;
     */
        /* JADX WARNING: Missing block: B:286:0x0715, code skipped:
            r4 = r6;
            r5 = r7;
     */
        /* JADX WARNING: Missing block: B:287:0x0718, code skipped:
            r10 = r5;
     */
        /* JADX WARNING: Missing block: B:288:0x071b, code skipped:
            r11 = r9;
     */
        /* JADX WARNING: Missing block: B:292:0x072a, code skipped:
            r4 = null;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() {
            AppMethodBeat.m2504i(134080);
            this.jai = new C19843i(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            synchronized (GameGLSurfaceView.iZP) {
                try {
                    this.mWantRenderNotification = false;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(134080);
                        throw th;
                    }
                }
            }
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            int i = 0;
            int i2 = 0;
            Runnable runnable = null;
            Object obj8 = null;
            while (true) {
                GameGLSurfaceView gameGLSurfaceView;
                try {
                    synchronized (GameGLSurfaceView.iZP) {
                        Object obj9 = obj7;
                        Object obj10 = obj8;
                        while (!this.mShouldExit) {
                            if (this.mPaused || !this.mFinishedCreatingEglSurface || this.jah.isEmpty()) {
                                boolean z = false;
                                if (this.mPaused != this.mRequestPaused) {
                                    boolean z2 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    if (z2) {
                                        gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                        if (gameGLSurfaceView != null) {
                                            gameGLSurfaceView.iZR.onPause();
                                        }
                                    } else {
                                        gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                        if (gameGLSurfaceView != null) {
                                            gameGLSurfaceView.iZR.onResume();
                                        }
                                    }
                                    GameGLSurfaceView.iZP.notifyAll();
                                    C17837c.m27916i("MicroMsg.GLThread", "mPaused is now " + this.mPaused + " tid=" + getId(), new Object[0]);
                                    z = z2;
                                }
                                if (this.mShouldReleaseEglContext) {
                                    C17837c.m27916i("MicroMsg.GLThread", "releasing EGL context because asked to tid=" + getId(), new Object[0]);
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    obj9 = 1;
                                }
                                if (obj4 != null) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    obj4 = null;
                                }
                                if (z && this.mHaveEglSurface) {
                                    C17837c.m27916i("MicroMsg.GLThread", "releasing EGL surface because paused tid=" + getId(), new Object[0]);
                                    stopEglSurfaceLocked();
                                }
                                if (z && this.mHaveEglContext) {
                                    gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                    if (gameGLSurfaceView == null) {
                                        z = false;
                                    } else {
                                        z = gameGLSurfaceView.mPreserveEGLContextOnPause;
                                    }
                                    if (!z) {
                                        stopEglContextLocked();
                                        C17837c.m27916i("MicroMsg.GLThread", "releasing EGL context because paused tid=" + getId(), new Object[0]);
                                    }
                                }
                                if (!(this.mHasSurface || this.mWaitingForSurface)) {
                                    C17837c.m27916i("MicroMsg.GLThread", "noticed surfaceView surface lost tid=" + getId(), new Object[0]);
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    GameGLSurfaceView.iZP.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    C17837c.m27916i("MicroMsg.GLThread", "noticed surfaceView surface acquired tid=" + getId(), new Object[0]);
                                    this.mWaitingForSurface = false;
                                    GameGLSurfaceView.iZP.notifyAll();
                                }
                                if (obj6 != null) {
                                    C17837c.m27916i("MicroMsg.GLThread", "sending render notification tid=" + getId(), new Object[0]);
                                    this.mWantRenderNotification = false;
                                    obj6 = null;
                                    this.mRenderComplete = true;
                                    GameGLSurfaceView.iZP.notifyAll();
                                }
                                if (this.mHaveEglContext) {
                                    Object obj11;
                                    if (readyToDraw()) {
                                        Object obj12;
                                        if (!this.mHaveEglContext) {
                                            C17837c.m27916i("MicroMsg.GLThread", "not HaveEglContext", new Object[0]);
                                            if (obj9 != null) {
                                                obj12 = null;
                                                if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                                    C17837c.m27916i("MicroMsg.GLThread", "Have EglContext but no EglSurface", new Object[0]);
                                                    this.mHaveEglSurface = true;
                                                    obj2 = 1;
                                                    obj3 = 1;
                                                    obj10 = 1;
                                                }
                                                if (this.mHaveEglSurface) {
                                                    C17837c.m27915e("MicroMsg.GLThread", "readyToDraw but not haveEglSurface", new Object[0]);
                                                    obj11 = obj12;
                                                } else {
                                                    int i3;
                                                    int i4;
                                                    if (this.mSizeChanged) {
                                                        obj10 = 1;
                                                        i3 = this.mWidth;
                                                        i4 = this.mHeight;
                                                        this.mWantRenderNotification = true;
                                                        C17837c.m27916i("MicroMsg.GLThread", "noticing that we want render notification tid=" + getId(), new Object[0]);
                                                        obj2 = 1;
                                                        this.mSizeChanged = false;
                                                    } else {
                                                        i4 = i2;
                                                        i3 = i;
                                                    }
                                                    this.mRequestRender = false;
                                                    GameGLSurfaceView.iZP.notifyAll();
                                                    if (this.mWantRenderNotification) {
                                                        obj5 = 1;
                                                        i2 = i4;
                                                        i = i3;
                                                        obj7 = obj12;
                                                    } else {
                                                        i2 = i4;
                                                        i = i3;
                                                        obj7 = obj12;
                                                    }
                                                }
                                            } else {
                                                this.jai.start();
                                                this.mHaveEglContext = true;
                                                obj = 1;
                                                GameGLSurfaceView.iZP.notifyAll();
                                            }
                                        }
                                        obj12 = obj9;
                                        C17837c.m27916i("MicroMsg.GLThread", "Have EglContext but no EglSurface", new Object[0]);
                                        this.mHaveEglSurface = true;
                                        obj2 = 1;
                                        obj3 = 1;
                                        obj10 = 1;
                                        if (this.mHaveEglSurface) {
                                        }
                                    } else {
                                        obj11 = obj9;
                                    }
                                    if (aPY()) {
                                        C17837c.m27916i("MicroMsg.GLThread", "readyToPauseAlsoDoDraw mPaused = [%b]", Boolean.valueOf(this.mPaused));
                                        obj7 = obj11;
                                    } else {
                                        GameGLSurfaceView.iZP.wait();
                                        obj9 = obj11;
                                    }
                                } else {
                                    C17837c.m27916i("MicroMsg.GLThread", "not HaveEglContext", new Object[0]);
                                    if (obj9 != null) {
                                        obj7 = null;
                                    } else {
                                        this.jai.start();
                                        this.mHaveEglContext = true;
                                        GameGLSurfaceView.iZP.notifyAll();
                                        obj7 = obj9;
                                        int i5 = 1;
                                    }
                                }
                            } else {
                                runnable = (Runnable) this.jah.remove(0);
                                obj7 = obj9;
                            }
                        }
                        AppMethodBeat.m2505o(134080);
                        return;
                    }
                } catch (RuntimeException e) {
                    GameGLSurfaceView.iZP.notifyAll();
                    AppMethodBeat.m2505o(134080);
                    throw e;
                } catch (RuntimeException e2) {
                    GameGLSurfaceView.iZP.notifyAll();
                    AppMethodBeat.m2505o(134080);
                    throw e2;
                } catch (Throwable th2) {
                    try {
                        C17837c.m27913a("MicroMsg.GLThread", th2, "alvinluo guardedRun exception", new Object[0]);
                        gameGLSurfaceView = (GameGLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                        if (gameGLSurfaceView != null) {
                            gameGLSurfaceView.iZR.aPF();
                        }
                        AppMethodBeat.m2505o(134080);
                        return;
                    } catch (Throwable th22) {
                        AppMethodBeat.m2505o(134080);
                        throw th22;
                    }
                }
            }
        }

        /* JADX WARNING: Missing block: B:19:0x0044, code skipped:
            if (r2 == null) goto L_0x0051;
     */
        /* JADX WARNING: Missing block: B:20:0x0046, code skipped:
            r2.run();
            r0 = null;
     */
        /* JADX WARNING: Missing block: B:25:0x0051, code skipped:
            r0 = (com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView) r7.mGLSurfaceViewWeakRef.get();
     */
        /* JADX WARNING: Missing block: B:26:0x0059, code skipped:
            if (r0 == null) goto L_0x0087;
     */
        /* JADX WARNING: Missing block: B:28:?, code skipped:
            com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.m65391g(r0).aPE();
     */
        /* JADX WARNING: Missing block: B:29:0x0062, code skipped:
            r0 = r2;
     */
        /* JADX WARNING: Missing block: B:30:0x0064, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:31:0x0065, code skipped:
            com.tencent.magicbrush.p1173a.C37412c.C17837c.m27915e("MicroMsg.GLThread", android.util.Log.getStackTraceString(r0) + " readyToPauseAlsoDoDraw while() ", new java.lang.Object[0]);
            r0 = r2;
     */
        /* JADX WARNING: Missing block: B:32:0x0087, code skipped:
            r1 = com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.aPW();
     */
        /* JADX WARNING: Missing block: B:33:0x008b, code skipped:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:36:?, code skipped:
            r7.mShouldExit = true;
     */
        /* JADX WARNING: Missing block: B:37:0x008f, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:41:0x0096, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(134081);
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void aPX() {
            AppMethodBeat.m2504i(134081);
            Runnable runnable = null;
            while (true) {
                synchronized (GameGLSurfaceView.iZP) {
                    try {
                        Runnable runnable2;
                        if (!aPY()) {
                            AppMethodBeat.m2505o(134081);
                            return;
                        } else if (this.jaf) {
                            this.jaf = false;
                            C17837c.m27916i("MicroMsg.GLThread", "Request leave PAUSE_ALSO_DO_DRAW", new Object[0]);
                            AppMethodBeat.m2505o(134081);
                            return;
                        } else if (this.jah.isEmpty()) {
                            runnable2 = runnable;
                        } else {
                            runnable2 = (Runnable) this.jah.remove(0);
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(134081);
                    }
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private boolean aPY() {
            return this.mPaused && this.jag && this.mWidth > 0 && this.mHeight > 0 && (!this.mRequestRender || this.mRenderMode == 1);
        }

        public final void setRenderMode(int i) {
            AppMethodBeat.m2504i(134082);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.m2505o(134082);
                throw illegalArgumentException;
            }
            synchronized (GameGLSurfaceView.iZP) {
                try {
                    this.mRenderMode = i;
                    GameGLSurfaceView.iZP.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(134082);
                }
            }
        }

        public final int getRenderMode() {
            int i;
            AppMethodBeat.m2504i(134083);
            synchronized (GameGLSurfaceView.iZP) {
                try {
                    i = this.mRenderMode;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(134083);
                }
            }
            return i;
        }

        public final void onPause() {
            AppMethodBeat.m2504i(134084);
            synchronized (GameGLSurfaceView.iZP) {
                try {
                    C17837c.m27916i("MicroMsg.GLThread", "onPause tid=" + getId(), new Object[0]);
                    this.mRequestPaused = true;
                    GameGLSurfaceView.iZP.notifyAll();
                    while (!this.mExited && !this.mPaused) {
                        C17837c.m27916i("MicroMsg.GLThread", "onPause waiting for mPaused.", new Object[0]);
                        GameGLSurfaceView.iZP.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(134084);
                }
            }
            AppMethodBeat.m2505o(134084);
        }

        public final void aPZ() {
            AppMethodBeat.m2504i(134085);
            synchronized (GameGLSurfaceView.iZP) {
                try {
                    C17837c.m27916i("MicroMsg.GLThread", "requestExitAndWaitForDestory tid=" + getId(), new Object[0]);
                    this.mShouldExit = true;
                    this.jae = true;
                    this.jaf = true;
                    GameGLSurfaceView.iZP.notifyAll();
                    while (!this.mExited) {
                        GameGLSurfaceView.iZP.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(134085);
                }
            }
            AppMethodBeat.m2505o(134085);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$a */
    abstract class C33604a implements C38580e {
        protected int[] mConfigSpec;

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public C33604a(int[] iArr) {
            if (GameGLSurfaceView.this.mEGLContextClientVersion == 2 || GameGLSurfaceView.this.mEGLContextClientVersion == 3) {
                int[] iArr2 = new int[15];
                System.arraycopy(iArr, 0, iArr2, 0, 12);
                iArr2[12] = 12352;
                if (GameGLSurfaceView.this.mEGLContextClientVersion == 2) {
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

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$m */
    static class C33605m extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        C33605m() {
            AppMethodBeat.m2504i(134089);
            AppMethodBeat.m2505o(134089);
        }

        public final void close() {
            AppMethodBeat.m2504i(134090);
            flushBuilder();
            AppMethodBeat.m2505o(134090);
        }

        public final void flush() {
            AppMethodBeat.m2504i(134091);
            flushBuilder();
            AppMethodBeat.m2505o(134091);
        }

        public final void write(char[] cArr, int i, int i2) {
            AppMethodBeat.m2504i(134092);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
            AppMethodBeat.m2505o(134092);
        }

        private void flushBuilder() {
            AppMethodBeat.m2504i(134093);
            if (this.mBuilder.length() > 0) {
                C17837c.m27917v("GLSurfaceView", this.mBuilder.toString(), new Object[0]);
                this.mBuilder.delete(0, this.mBuilder.length());
            }
            AppMethodBeat.m2505o(134093);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$n */
    public interface C33606n {
        void aPC();

        void aPD();

        void aPE();

        void aPF();

        /* renamed from: do */
        void mo45044do(int i, int i2);

        void onDestroy();

        void onPause();

        void onResume();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$o */
    class C33607o extends C19841b {
        public C33607o() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$g */
    public static class C38579g implements EGL11 {
        private EGL10 iZY;
        Writer iZZ;
        boolean jaa;
        boolean jab;
        private int jac;

        public final boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2) {
            AppMethodBeat.m2504i(134025);
            m65384yF("eglChooseConfig");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65373a("attrib_list", iArr);
            m65375bz("config_size", i);
            end();
            boolean eglChooseConfig = this.iZY.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i, iArr2);
            m65381p("configs", (Object[]) eGLConfigArr);
            m65373a("num_config", iArr2);
            m65378eW(eglChooseConfig);
            checkError();
            AppMethodBeat.m2505o(134025);
            return eglChooseConfig;
        }

        public final boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) {
            AppMethodBeat.m2504i(134026);
            m65384yF("eglCopyBuffers");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65372a("surface", eGLSurface);
            m65380p("native_pixmap", obj);
            end();
            boolean eglCopyBuffers = this.iZY.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
            m65378eW(eglCopyBuffers);
            checkError();
            AppMethodBeat.m2505o(134026);
            return eglCopyBuffers;
        }

        public final EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
            AppMethodBeat.m2504i(134027);
            m65384yF("eglCreateContext");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65380p("config", (Object) eGLConfig);
            m65370a("share_context", eGLContext);
            m65373a("attrib_list", iArr);
            end();
            EGLContext eglCreateContext = this.iZY.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            m65374bL(eglCreateContext);
            checkError();
            AppMethodBeat.m2505o(134027);
            return eglCreateContext;
        }

        public final EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
            AppMethodBeat.m2504i(134028);
            m65384yF("eglCreatePbufferSurface");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65380p("config", (Object) eGLConfig);
            m65373a("attrib_list", iArr);
            end();
            EGLSurface eglCreatePbufferSurface = this.iZY.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
            m65374bL(eglCreatePbufferSurface);
            checkError();
            AppMethodBeat.m2505o(134028);
            return eglCreatePbufferSurface;
        }

        public final EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
            AppMethodBeat.m2504i(134029);
            m65384yF("eglCreatePixmapSurface");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65380p("config", (Object) eGLConfig);
            m65380p("native_pixmap", obj);
            m65373a("attrib_list", iArr);
            end();
            EGLSurface eglCreatePixmapSurface = this.iZY.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
            m65374bL(eglCreatePixmapSurface);
            checkError();
            AppMethodBeat.m2505o(134029);
            return eglCreatePixmapSurface;
        }

        public final EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
            AppMethodBeat.m2504i(134030);
            m65384yF("eglCreateWindowSurface");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65380p("config", (Object) eGLConfig);
            m65380p("native_window", obj);
            m65373a("attrib_list", iArr);
            end();
            EGLSurface eglCreateWindowSurface = this.iZY.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
            m65374bL(eglCreateWindowSurface);
            checkError();
            AppMethodBeat.m2505o(134030);
            return eglCreateWindowSurface;
        }

        public final boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.m2504i(134031);
            m65384yF("eglDestroyContext");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65370a("context", eGLContext);
            end();
            boolean eglDestroyContext = this.iZY.eglDestroyContext(eGLDisplay, eGLContext);
            m65378eW(eglDestroyContext);
            checkError();
            AppMethodBeat.m2505o(134031);
            return eglDestroyContext;
        }

        public final boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(134032);
            m65384yF("eglDestroySurface");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65372a("surface", eGLSurface);
            end();
            boolean eglDestroySurface = this.iZY.eglDestroySurface(eGLDisplay, eGLSurface);
            m65378eW(eglDestroySurface);
            checkError();
            AppMethodBeat.m2505o(134032);
            return eglDestroySurface;
        }

        public final boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr) {
            AppMethodBeat.m2504i(134033);
            m65384yF("eglGetConfigAttrib");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65380p("config", (Object) eGLConfig);
            m65375bz("attribute", i);
            end();
            boolean eglGetConfigAttrib = this.iZY.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, iArr);
            m65373a("value", iArr);
            m65378eW(eglGetConfigAttrib);
            checkError();
            AppMethodBeat.m2505o(134033);
            return false;
        }

        public final boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr) {
            AppMethodBeat.m2504i(134034);
            m65384yF("eglGetConfigs");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65375bz("config_size", i);
            end();
            boolean eglGetConfigs = this.iZY.eglGetConfigs(eGLDisplay, eGLConfigArr, i, iArr);
            m65381p("configs", (Object[]) eGLConfigArr);
            m65373a("num_config", iArr);
            m65378eW(eglGetConfigs);
            checkError();
            AppMethodBeat.m2505o(134034);
            return eglGetConfigs;
        }

        public final EGLContext eglGetCurrentContext() {
            AppMethodBeat.m2504i(134035);
            m65384yF("eglGetCurrentContext");
            end();
            EGLContext eglGetCurrentContext = this.iZY.eglGetCurrentContext();
            m65374bL(eglGetCurrentContext);
            checkError();
            AppMethodBeat.m2505o(134035);
            return eglGetCurrentContext;
        }

        public final EGLDisplay eglGetCurrentDisplay() {
            AppMethodBeat.m2504i(134036);
            m65384yF("eglGetCurrentDisplay");
            end();
            EGLDisplay eglGetCurrentDisplay = this.iZY.eglGetCurrentDisplay();
            m65374bL(eglGetCurrentDisplay);
            checkError();
            AppMethodBeat.m2505o(134036);
            return eglGetCurrentDisplay;
        }

        public final EGLSurface eglGetCurrentSurface(int i) {
            AppMethodBeat.m2504i(134037);
            m65384yF("eglGetCurrentSurface");
            m65375bz("readdraw", i);
            end();
            EGLSurface eglGetCurrentSurface = this.iZY.eglGetCurrentSurface(i);
            m65374bL(eglGetCurrentSurface);
            checkError();
            AppMethodBeat.m2505o(134037);
            return eglGetCurrentSurface;
        }

        public final EGLDisplay eglGetDisplay(Object obj) {
            AppMethodBeat.m2504i(134038);
            m65384yF("eglGetDisplay");
            m65380p("native_display", obj);
            end();
            EGLDisplay eglGetDisplay = this.iZY.eglGetDisplay(obj);
            m65374bL(eglGetDisplay);
            checkError();
            AppMethodBeat.m2505o(134038);
            return eglGetDisplay;
        }

        public final int eglGetError() {
            AppMethodBeat.m2504i(134039);
            m65384yF("eglGetError");
            end();
            int eglGetError = this.iZY.eglGetError();
            m65369Ex(C38579g.getErrorString(eglGetError));
            AppMethodBeat.m2505o(134039);
            return eglGetError;
        }

        public final boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) {
            AppMethodBeat.m2504i(134040);
            m65384yF("eglInitialize");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            end();
            boolean eglInitialize = this.iZY.eglInitialize(eGLDisplay, iArr);
            m65378eW(eglInitialize);
            m65373a("major_minor", iArr);
            checkError();
            AppMethodBeat.m2505o(134040);
            return eglInitialize;
        }

        public final boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) {
            AppMethodBeat.m2504i(134041);
            m65384yF("eglMakeCurrent");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65372a("draw", eGLSurface);
            m65372a("read", eGLSurface2);
            m65370a("context", eGLContext);
            end();
            boolean eglMakeCurrent = this.iZY.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
            m65378eW(eglMakeCurrent);
            checkError();
            AppMethodBeat.m2505o(134041);
            return eglMakeCurrent;
        }

        public final boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr) {
            AppMethodBeat.m2504i(134042);
            m65384yF("eglQueryContext");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65370a("context", eGLContext);
            m65375bz("attribute", i);
            end();
            boolean eglQueryContext = this.iZY.eglQueryContext(eGLDisplay, eGLContext, i, iArr);
            m65382qp(iArr[0]);
            m65378eW(eglQueryContext);
            checkError();
            AppMethodBeat.m2505o(134042);
            return eglQueryContext;
        }

        public final String eglQueryString(EGLDisplay eGLDisplay, int i) {
            AppMethodBeat.m2504i(134043);
            m65384yF("eglQueryString");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65375bz("name", i);
            end();
            String eglQueryString = this.iZY.eglQueryString(eGLDisplay, i);
            m65369Ex(eglQueryString);
            checkError();
            AppMethodBeat.m2505o(134043);
            return eglQueryString;
        }

        public final boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr) {
            AppMethodBeat.m2504i(134044);
            m65384yF("eglQuerySurface");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65372a("surface", eGLSurface);
            m65375bz("attribute", i);
            end();
            boolean eglQuerySurface = this.iZY.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr);
            m65382qp(iArr[0]);
            m65378eW(eglQuerySurface);
            checkError();
            AppMethodBeat.m2505o(134044);
            return eglQuerySurface;
        }

        public final boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(134045);
            m65384yF("eglSwapBuffers");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            m65372a("surface", eGLSurface);
            end();
            boolean eglSwapBuffers = this.iZY.eglSwapBuffers(eGLDisplay, eGLSurface);
            m65378eW(eglSwapBuffers);
            checkError();
            AppMethodBeat.m2505o(134045);
            return eglSwapBuffers;
        }

        public final boolean eglTerminate(EGLDisplay eGLDisplay) {
            AppMethodBeat.m2504i(134046);
            m65384yF("eglTerminate");
            m65371a(ServerProtocol.DIALOG_PARAM_DISPLAY, eGLDisplay);
            end();
            boolean eglTerminate = this.iZY.eglTerminate(eGLDisplay);
            m65378eW(eglTerminate);
            checkError();
            AppMethodBeat.m2505o(134046);
            return eglTerminate;
        }

        public final boolean eglWaitGL() {
            AppMethodBeat.m2504i(134047);
            m65384yF("eglWaitGL");
            end();
            boolean eglWaitGL = this.iZY.eglWaitGL();
            m65378eW(eglWaitGL);
            checkError();
            AppMethodBeat.m2505o(134047);
            return eglWaitGL;
        }

        public final boolean eglWaitNative(int i, Object obj) {
            AppMethodBeat.m2504i(134048);
            m65384yF("eglWaitNative");
            m65375bz("engine", i);
            m65380p("bindTarget", obj);
            end();
            boolean eglWaitNative = this.iZY.eglWaitNative(i, obj);
            m65378eW(eglWaitNative);
            checkError();
            AppMethodBeat.m2505o(134048);
            return eglWaitNative;
        }

        private void checkError() {
            AppMethodBeat.m2504i(134049);
            int eglGetError = this.iZY.eglGetError();
            if (eglGetError != 12288) {
                String str = "eglError: " + C38579g.getErrorString(eglGetError);
                m65368Ew(str);
                if (this.jab) {
                    GLException gLException = new GLException(eglGetError, str);
                    AppMethodBeat.m2505o(134049);
                    throw gLException;
                }
            }
            AppMethodBeat.m2505o(134049);
        }

        /* renamed from: Ew */
        private void m65368Ew(String str) {
            AppMethodBeat.m2504i(134050);
            log(str + 10);
            AppMethodBeat.m2505o(134050);
        }

        private void log(String str) {
            AppMethodBeat.m2504i(134051);
            try {
                this.iZZ.write(str);
                AppMethodBeat.m2505o(134051);
            } catch (IOException e) {
                AppMethodBeat.m2505o(134051);
            }
        }

        /* renamed from: yF */
        private void m65384yF(String str) {
            AppMethodBeat.m2504i(134052);
            log(str + '(');
            this.jac = 0;
            AppMethodBeat.m2505o(134052);
        }

        /* renamed from: cW */
        private void m65377cW(String str, String str2) {
            AppMethodBeat.m2504i(134053);
            int i = this.jac;
            this.jac = i + 1;
            if (i > 0) {
                log(", ");
            }
            if (this.jaa) {
                log(str + "=");
            }
            log(str2);
            AppMethodBeat.m2505o(134053);
        }

        private void end() {
            AppMethodBeat.m2504i(134054);
            log(");\n");
            flush();
            AppMethodBeat.m2505o(134054);
        }

        private void flush() {
            AppMethodBeat.m2504i(134055);
            try {
                this.iZZ.flush();
                AppMethodBeat.m2505o(134055);
            } catch (IOException e) {
                this.iZZ = null;
                AppMethodBeat.m2505o(134055);
            }
        }

        /* renamed from: bz */
        private void m65375bz(String str, int i) {
            AppMethodBeat.m2504i(134056);
            m65377cW(str, Integer.toString(i));
            AppMethodBeat.m2505o(134056);
        }

        /* renamed from: p */
        private void m65380p(String str, Object obj) {
            AppMethodBeat.m2504i(134057);
            m65377cW(str, C38579g.toString(obj));
            AppMethodBeat.m2505o(134057);
        }

        /* renamed from: a */
        private void m65371a(String str, EGLDisplay eGLDisplay) {
            AppMethodBeat.m2504i(134058);
            if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
                m65377cW(str, "EGL10.EGL_DEFAULT_DISPLAY");
                AppMethodBeat.m2505o(134058);
            } else if (eGLDisplay == EGL_NO_DISPLAY) {
                m65377cW(str, "EGL10.EGL_NO_DISPLAY");
                AppMethodBeat.m2505o(134058);
            } else {
                m65377cW(str, C38579g.toString(eGLDisplay));
                AppMethodBeat.m2505o(134058);
            }
        }

        /* renamed from: a */
        private void m65370a(String str, EGLContext eGLContext) {
            AppMethodBeat.m2504i(134059);
            if (eGLContext == EGL10.EGL_NO_CONTEXT) {
                m65377cW(str, "EGL10.EGL_NO_CONTEXT");
                AppMethodBeat.m2505o(134059);
                return;
            }
            m65377cW(str, C38579g.toString(eGLContext));
            AppMethodBeat.m2505o(134059);
        }

        /* renamed from: a */
        private void m65372a(String str, EGLSurface eGLSurface) {
            AppMethodBeat.m2504i(134060);
            if (eGLSurface == EGL10.EGL_NO_SURFACE) {
                m65377cW(str, "EGL10.EGL_NO_SURFACE");
                AppMethodBeat.m2505o(134060);
                return;
            }
            m65377cW(str, C38579g.toString(eGLSurface));
            AppMethodBeat.m2505o(134060);
        }

        /* renamed from: Ex */
        private void m65369Ex(String str) {
            AppMethodBeat.m2504i(134061);
            log(" returns " + str + ";\n");
            flush();
            AppMethodBeat.m2505o(134061);
        }

        /* renamed from: qp */
        private void m65382qp(int i) {
            AppMethodBeat.m2504i(134062);
            m65369Ex(Integer.toString(i));
            AppMethodBeat.m2505o(134062);
        }

        /* renamed from: eW */
        private void m65378eW(boolean z) {
            AppMethodBeat.m2504i(134063);
            m65369Ex(Boolean.toString(z));
            AppMethodBeat.m2505o(134063);
        }

        /* renamed from: bL */
        private void m65374bL(Object obj) {
            AppMethodBeat.m2504i(134064);
            m65369Ex(C38579g.toString(obj));
            AppMethodBeat.m2505o(134064);
        }

        private static String toString(Object obj) {
            AppMethodBeat.m2504i(134065);
            String str;
            if (obj == null) {
                str = BuildConfig.COMMAND;
                AppMethodBeat.m2505o(134065);
                return str;
            }
            str = obj.toString();
            AppMethodBeat.m2505o(134065);
            return str;
        }

        /* renamed from: a */
        private void m65373a(String str, int[] iArr) {
            AppMethodBeat.m2504i(134066);
            if (iArr == null) {
                m65377cW(str, BuildConfig.COMMAND);
                AppMethodBeat.m2505o(134066);
                return;
            }
            m65377cW(str, C38579g.m65376c(iArr.length, iArr));
            AppMethodBeat.m2505o(134066);
        }

        /* renamed from: p */
        private void m65381p(String str, Object[] objArr) {
            AppMethodBeat.m2504i(134067);
            if (objArr == null) {
                m65377cW(str, BuildConfig.COMMAND);
                AppMethodBeat.m2505o(134067);
                return;
            }
            m65377cW(str, C38579g.m65379f(objArr.length, objArr));
            AppMethodBeat.m2505o(134067);
        }

        /* renamed from: c */
        private static String m65376c(int i, int[] iArr) {
            AppMethodBeat.m2504i(134068);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\n");
            int length = iArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 + 0;
                stringBuilder.append(" [" + i3 + "] = ");
                if (i3 < 0 || i3 >= length) {
                    stringBuilder.append("out of bounds");
                } else {
                    stringBuilder.append(iArr[i3]);
                }
                stringBuilder.append(10);
            }
            stringBuilder.append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(134068);
            return stringBuilder2;
        }

        /* renamed from: f */
        private static String m65379f(int i, Object[] objArr) {
            AppMethodBeat.m2504i(134069);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\n");
            int length = objArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 + 0;
                stringBuilder.append(" [" + i3 + "] = ");
                if (i3 < 0 || i3 >= length) {
                    stringBuilder.append("out of bounds");
                } else {
                    stringBuilder.append(objArr[i3]);
                }
                stringBuilder.append(10);
            }
            stringBuilder.append("}");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(134069);
            return stringBuilder2;
        }

        /* renamed from: qq */
        private static String m65383qq(int i) {
            AppMethodBeat.m2504i(134070);
            String str = "0x" + Integer.toHexString(i);
            AppMethodBeat.m2505o(134070);
            return str;
        }

        public static String getErrorString(int i) {
            AppMethodBeat.m2504i(134071);
            String str;
            switch (i) {
                case 12288:
                    str = "EGL_SUCCESS";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12289:
                    str = "EGL_NOT_INITIALIZED";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12290:
                    str = "EGL_BAD_ACCESS";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12291:
                    str = "EGL_BAD_ALLOC";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12292:
                    str = "EGL_BAD_ATTRIBUTE";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12293:
                    str = "EGL_BAD_CONFIG";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12294:
                    str = "EGL_BAD_CONTEXT";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12295:
                    str = "EGL_BAD_CURRENT_SURFACE";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12296:
                    str = "EGL_BAD_DISPLAY";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12297:
                    str = "EGL_BAD_MATCH";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12298:
                    str = "EGL_BAD_NATIVE_PIXMAP";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12299:
                    str = "EGL_BAD_NATIVE_WINDOW";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12300:
                    str = "EGL_BAD_PARAMETER";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12301:
                    str = "EGL_BAD_SURFACE";
                    AppMethodBeat.m2505o(134071);
                    return str;
                case 12302:
                    str = "EGL_CONTEXT_LOST";
                    AppMethodBeat.m2505o(134071);
                    return str;
                default:
                    str = C38579g.m65383qq(i);
                    AppMethodBeat.m2505o(134071);
                    return str;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$e */
    public interface C38580e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$h */
    public interface C38581h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView$f */
    public interface C38582f {
        /* renamed from: b */
        EGLContext mo45085b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public GameGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134094);
        getHolder().addCallback(this);
        AppMethodBeat.m2505o(134094);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(134095);
        try {
            if (this.iZQ != null) {
                this.iZQ.aPZ();
            }
            super.finalize();
            AppMethodBeat.m2505o(134095);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.m2505o(134095);
        }
    }

    public void setFps(int i) {
    }

    public void setGLWrapper(C2550l c2550l) {
        this.iZV = c2550l;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setSwapNow(boolean z) {
        this.iZW = z;
    }

    public boolean getIsSwapNow() {
        return this.iZW;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(C33606n c33606n) {
        AppMethodBeat.m2504i(134096);
        checkRenderThreadState();
        if (this.iZS == null) {
            this.iZS = new C33607o();
        }
        if (this.iZT == null) {
            this.iZT = new C27374c(this, (byte) 0);
        }
        if (this.iZU == null) {
            this.iZU = new C19842d();
        }
        this.iZR = c33606n;
        this.iZQ = new C27375j(this.mThisWeakRef);
        this.iZQ.start();
        AppMethodBeat.m2505o(134096);
    }

    public void setEGLContextFactory(C38582f c38582f) {
        AppMethodBeat.m2504i(134097);
        checkRenderThreadState();
        this.iZT = c38582f;
        AppMethodBeat.m2505o(134097);
    }

    public void setEGLWindowSurfaceFactory(C38581h c38581h) {
        AppMethodBeat.m2504i(134098);
        checkRenderThreadState();
        this.iZU = c38581h;
        AppMethodBeat.m2505o(134098);
    }

    public void setEGLConfigChooser(C38580e c38580e) {
        AppMethodBeat.m2504i(134099);
        checkRenderThreadState();
        this.iZS = c38580e;
        AppMethodBeat.m2505o(134099);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.m2504i(134100);
        setEGLConfigChooser(new C33607o());
        AppMethodBeat.m2505o(134100);
    }

    public final void aPV() {
        AppMethodBeat.m2504i(134101);
        setEGLConfigChooser(new C19841b());
        AppMethodBeat.m2505o(134101);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.m2504i(134102);
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
        AppMethodBeat.m2505o(134102);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(134103);
        this.iZQ.setRenderMode(i);
        AppMethodBeat.m2505o(134103);
    }

    public int getRenderMode() {
        AppMethodBeat.m2504i(134104);
        int renderMode = this.iZQ.getRenderMode();
        AppMethodBeat.m2505o(134104);
        return renderMode;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(134105);
        C17837c.m27916i("MicroMsg.GameGLSurfaceView", "alvinluo GameGLSurfaceView surfaceCreated", new Object[0]);
        C27375j c27375j = this.iZQ;
        synchronized (iZP) {
            try {
                C17837c.m27916i("MicroMsg.GLThread", "surfaceCreated tid=" + c27375j.getId(), new Object[0]);
                c27375j.mHasSurface = true;
                c27375j.mFinishedCreatingEglSurface = false;
                c27375j.jaf = true;
                iZP.notifyAll();
                while (c27375j.mWaitingForSurface && !c27375j.mFinishedCreatingEglSurface && !c27375j.mExited) {
                    iZP.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134105);
            }
        }
        AppMethodBeat.m2505o(134105);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(134106);
        C27375j c27375j = this.iZQ;
        synchronized (iZP) {
            try {
                C17837c.m27916i("MicroMsg.GLThread", "surfaceDestroyed tid=" + c27375j.getId(), new Object[0]);
                c27375j.mHasSurface = false;
                c27375j.jaf = true;
                iZP.notifyAll();
                while (!c27375j.mWaitingForSurface && !c27375j.mExited) {
                    iZP.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134106);
            }
        }
        AppMethodBeat.m2505o(134106);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(134107);
        Thread thread = this.iZQ;
        synchronized (iZP) {
            if (thread.mWidth == i2 && thread.mHeight == i3) {
                AppMethodBeat.m2505o(134107);
                return;
            }
            try {
                thread.mWidth = i2;
                thread.mHeight = i3;
                thread.mSizeChanged = true;
                thread.mRequestRender = true;
                thread.mRenderComplete = false;
                thread.jaf = true;
                if (Thread.currentThread() == thread) {
                    AppMethodBeat.m2505o(134107);
                    return;
                }
                iZP.notifyAll();
                while (!thread.mExited && !thread.mPaused && !thread.mRenderComplete) {
                    Object obj;
                    if (thread.mHaveEglContext && thread.mHaveEglSurface && thread.readyToDraw()) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        C17837c.m27916i("MicroMsg.GLThread", "onWindowResize waiting for render complete from tid=" + thread.getId(), new Object[0]);
                        iZP.wait();
                    }
                }
                AppMethodBeat.m2505o(134107);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134107);
            }
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(134108);
        if (this.iZQ != null) {
            C27375j c27375j = this.iZQ;
            synchronized (iZP) {
                try {
                    c27375j.mRequestRender = true;
                    iZP.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(134108);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(134108);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(139128);
        this.iZQ.onPause();
        AppMethodBeat.m2505o(139128);
    }

    public void onResume() {
        AppMethodBeat.m2504i(134110);
        C17837c.m27916i("MicroMsg.GameGLSurfaceView", "onResume", new Object[0]);
        C27375j c27375j = this.iZQ;
        synchronized (iZP) {
            try {
                C17837c.m27916i("MicroMsg.GLThread", "onResume tid=" + c27375j.getId(), new Object[0]);
                c27375j.mRequestPaused = false;
                c27375j.jag = false;
                c27375j.mRequestRender = true;
                c27375j.mRenderComplete = false;
                iZP.notifyAll();
                while (!c27375j.mExited && c27375j.mPaused && !c27375j.mRenderComplete) {
                    C17837c.m27916i("MicroMsg.GLThread", "onResume waiting for !mPaused.", new Object[0]);
                    iZP.wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Throwable th) {
                AppMethodBeat.m2505o(134110);
            }
        }
        AppMethodBeat.m2505o(134110);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(134111);
        super.onAttachedToWindow();
        C17837c.m27916i("MicroMsg.GameGLSurfaceView", "onAttachedToWindow reattach =" + this.mDetached, new Object[0]);
        if (this.mDetached && this.iZR != null) {
            int renderMode;
            if (this.iZQ != null) {
                renderMode = this.iZQ.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.iZQ = new C27375j(this.mThisWeakRef);
            if (renderMode != 1) {
                this.iZQ.setRenderMode(renderMode);
            }
            this.iZQ.start();
        }
        this.mDetached = false;
        AppMethodBeat.m2505o(134111);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(134112);
        C17837c.m27916i("MicroMsg.GameGLSurfaceView", "onDetachedFromWindow", new Object[0]);
        if (this.iZQ != null) {
            this.iZQ.aPZ();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(134112);
    }

    private void checkRenderThreadState() {
        AppMethodBeat.m2504i(134113);
        if (this.iZQ != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.m2505o(134113);
            throw illegalStateException;
        }
        AppMethodBeat.m2505o(134113);
    }

    static {
        AppMethodBeat.m2504i(134114);
        AppMethodBeat.m2505o(134114);
    }
}
