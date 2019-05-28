package com.tencent.ttpic.view;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceView extends SurfaceView implements Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private final WeakReference<GLSurfaceView> mThisWeakRef = new WeakReference(this);

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        /* synthetic */ GLThreadManager(AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void threadExiting(GLThread gLThread) {
            AppMethodBeat.i(84464);
            gLThread.mExited = true;
            notifyAll();
            AppMethodBeat.o(84464);
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            AppMethodBeat.i(84465);
            notifyAll();
            AppMethodBeat.o(84465);
        }
    }

    class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            int i;
            if (z) {
                i = 16;
            } else {
                i = 0;
            }
            super(8, 8, 8, 0, i, 0);
            AppMethodBeat.i(84471);
            AppMethodBeat.o(84471);
        }
    }

    static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        /* synthetic */ DefaultWindowSurfaceFactory(AnonymousClass1 anonymousClass1) {
            this();
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface = null;
            AppMethodBeat.i(84433);
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e) {
            }
            AppMethodBeat.o(84433);
            return eGLSurface;
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            AppMethodBeat.i(84434);
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
            AppMethodBeat.o(84434);
        }
    }

    abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
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

        private int[] filterConfigSpec(int[] iArr) {
            if (GLSurfaceView.this.mEGLContextClientVersion != 2 && GLSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            System.arraycopy(iArr, 0, iArr2, 0, length - 1);
            iArr2[length - 1] = 12352;
            if (GLSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            AppMethodBeat.i(84435);
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            RuntimeException runtimeException;
            if (this.mEglDisplay == EGL10.EGL_NO_DISPLAY) {
                runtimeException = new RuntimeException("eglGetDisplay failed");
                AppMethodBeat.o(84435);
                throw runtimeException;
            }
            if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView == null) {
                    this.mEglConfig = null;
                    this.mEglContext = null;
                } else {
                    this.mEglConfig = gLSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                    this.mEglContext = gLSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                }
                if (this.mEglContext == null || this.mEglContext == EGL10.EGL_NO_CONTEXT) {
                    this.mEglContext = null;
                    throwEglException("createContext");
                }
                this.mEglSurface = null;
                AppMethodBeat.o(84435);
                return;
            }
            runtimeException = new RuntimeException("eglInitialize failed");
            AppMethodBeat.o(84435);
            throw runtimeException;
        }

        public boolean createSurface() {
            AppMethodBeat.i(84436);
            RuntimeException runtimeException;
            if (this.mEgl == null) {
                runtimeException = new RuntimeException("egl not initialized");
                AppMethodBeat.o(84436);
                throw runtimeException;
            } else if (this.mEglDisplay == null) {
                runtimeException = new RuntimeException("eglDisplay not initialized");
                AppMethodBeat.o(84436);
                throw runtimeException;
            } else if (this.mEglConfig == null) {
                runtimeException = new RuntimeException("mEglConfig not initialized");
                AppMethodBeat.o(84436);
                throw runtimeException;
            } else {
                destroySurfaceImp();
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    this.mEglSurface = gLSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLSurfaceView.getHolder());
                } else {
                    this.mEglSurface = null;
                }
                if (this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE) {
                    this.mEgl.eglGetError();
                    AppMethodBeat.o(84436);
                    return false;
                } else if (this.mEgl.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext)) {
                    AppMethodBeat.o(84436);
                    return true;
                } else {
                    logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                    AppMethodBeat.o(84436);
                    return false;
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        public GL createGL() {
            AppMethodBeat.i(84437);
            GL gl = this.mEglContext.getGL();
            GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
            if (gLSurfaceView != null) {
                if (gLSurfaceView.mGLWrapper != null) {
                    gl = gLSurfaceView.mGLWrapper.wrap(gl);
                }
                if ((gLSurfaceView.mDebugFlags & 3) != 0) {
                    Writer logWriter;
                    int i = 0;
                    if ((gLSurfaceView.mDebugFlags & 1) != 0) {
                        i = 1;
                    }
                    if ((gLSurfaceView.mDebugFlags & 2) != 0) {
                        logWriter = new LogWriter();
                    } else {
                        logWriter = null;
                    }
                    gl = GLDebugHelper.wrap(gl, i, logWriter);
                }
            }
            AppMethodBeat.o(84437);
            return gl;
        }

        public int swap() {
            AppMethodBeat.i(84438);
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                AppMethodBeat.o(84438);
                return 12288;
            }
            int eglGetError = this.mEgl.eglGetError();
            AppMethodBeat.o(84438);
            return eglGetError;
        }

        public void destroySurface() {
            AppMethodBeat.i(84439);
            destroySurfaceImp();
            AppMethodBeat.o(84439);
        }

        private void destroySurfaceImp() {
            AppMethodBeat.i(84440);
            if (!(this.mEglSurface == null || this.mEglSurface == EGL10.EGL_NO_SURFACE)) {
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
            AppMethodBeat.o(84440);
        }

        public void finish() {
            AppMethodBeat.i(84441);
            if (this.mEglContext != null) {
                GLSurfaceView gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                if (gLSurfaceView != null) {
                    gLSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            if (this.mEglDisplay != null) {
                this.mEgl.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = null;
            }
            AppMethodBeat.o(84441);
        }

        private void throwEglException(String str) {
            AppMethodBeat.i(84442);
            throwEglException(str, this.mEgl.eglGetError());
            AppMethodBeat.o(84442);
        }

        public static void throwEglException(String str, int i) {
            AppMethodBeat.i(84443);
            RuntimeException runtimeException = new RuntimeException(formatEglError(str, i));
            AppMethodBeat.o(84443);
            throw runtimeException;
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            AppMethodBeat.i(84444);
            formatEglError(str2, i);
            AppMethodBeat.o(84444);
        }

        public static String formatEglError(String str, int i) {
            AppMethodBeat.i(84445);
            String str2 = str + " failed: " + i;
            AppMethodBeat.o(84445);
            return str2;
        }
    }

    class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        /* synthetic */ DefaultContextFactory(GLSurfaceView gLSurfaceView, AnonymousClass1 anonymousClass1) {
            this();
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            AppMethodBeat.i(84431);
            int[] iArr = new int[]{this.EGL_CONTEXT_CLIENT_VERSION, GLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
            AppMethodBeat.o(84431);
            return eglCreateContext;
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            AppMethodBeat.i(84432);
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                new StringBuilder("display:").append(eGLDisplay).append(" context: ").append(eGLContext);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
            AppMethodBeat.o(84432);
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList();
        private boolean mExited;
        private Runnable mFinishDrawingRunnable = null;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mWantRenderNotification = false;
        private int mWidth = 0;

        GLThread(WeakReference<GLSurfaceView> weakReference) {
            AppMethodBeat.i(84446);
            this.mGLSurfaceViewWeakRef = weakReference;
            AppMethodBeat.o(84446);
        }

        public void run() {
            AppMethodBeat.i(84447);
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException e) {
            } finally {
                GLSurfaceView.sGLThreadManager.threadExiting(this);
                AppMethodBeat.o(84447);
            }
        }

        private void stopEglSurfaceLocked() {
            AppMethodBeat.i(84448);
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
            AppMethodBeat.o(84448);
        }

        private void stopEglContextLocked() {
            AppMethodBeat.i(84449);
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
            AppMethodBeat.o(84449);
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A:{SYNTHETIC, Splitter:B:13:0x0053} */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x003f A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0053 A:{SYNTHETIC, Splitter:B:13:0x0053} */
        /* JADX WARNING: Removed duplicated region for block: B:108:0x01f7  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004e A:{SYNTHETIC, Splitter:B:10:0x004e} */
        /* JADX WARNING: Missing block: B:144:0x029a, code skipped:
            if (r4 == null) goto L_0x02e7;
     */
        /* JADX WARNING: Missing block: B:145:0x029c, code skipped:
            r2 = 1;
            r4 = null;
     */
        /* JADX WARNING: Missing block: B:146:0x029f, code skipped:
            r3 = r2;
     */
        /* JADX WARNING: Missing block: B:177:0x02e7, code skipped:
            r2 = r3;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() {
            AppMethodBeat.i(84450);
            this.mEglHelper = new EglHelper(this.mGLSurfaceViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            this.mWantRenderNotification = false;
            Object obj = null;
            GLThreadManager gLThreadManager = null;
            Object obj2 = null;
            Object obj3 = null;
            Object obj4 = null;
            Object obj5 = null;
            int i = 0;
            Object obj6 = null;
            int i2 = 0;
            int i3 = 0;
            Runnable runnable = null;
            boolean z = false;
            GL10 gl10 = null;
            while (true) {
                GLThreadManager th;
                try {
                    GLThreadManager access$800 = GLSurfaceView.sGLThreadManager;
                    synchronized (access$800) {
                        if (this.mEventQueue.isEmpty()) {
                            th = this.mShouldExit;
                            if (th == null) {
                                boolean z2;
                                GLSurfaceView gLSurfaceView;
                                if (this.mPaused != this.mRequestPaused) {
                                    z2 = this.mRequestPaused;
                                    this.mPaused = this.mRequestPaused;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                }
                                if (this.mShouldReleaseEglContext) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.mShouldReleaseEglContext = false;
                                    obj6 = 1;
                                }
                                if (obj3 != null) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    obj3 = null;
                                }
                                if (z2 && this.mHaveEglSurface) {
                                    stopEglSurfaceLocked();
                                }
                                if (z2 && this.mHaveEglContext) {
                                    gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                    if (gLSurfaceView == null) {
                                        z2 = false;
                                    } else {
                                        z2 = gLSurfaceView.mPreserveEGLContextOnPause;
                                    }
                                    if (!z2) {
                                        stopEglContextLocked();
                                    }
                                }
                                if (!(this.mHasSurface || this.mWaitingForSurface)) {
                                    if (this.mHaveEglSurface) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.mWaitingForSurface = true;
                                    this.mSurfaceIsBad = false;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                }
                                if (this.mHasSurface && this.mWaitingForSurface) {
                                    this.mWaitingForSurface = false;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                }
                                if (i != 0) {
                                    this.mWantRenderNotification = false;
                                    i = 0;
                                    this.mRenderComplete = true;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                }
                                if (this.mFinishDrawingRunnable != null) {
                                    th = this.mFinishDrawingRunnable;
                                    this.mFinishDrawingRunnable = null;
                                } else {
                                    th = z;
                                }
                                if (!readyToDraw()) {
                                    if (th != null) {
                                        th.run();
                                        th = null;
                                    }
                                    GLSurfaceView.sGLThreadManager.wait();
                                    z = th;
                                    if (this.mEventQueue.isEmpty()) {
                                    }
                                }
                                z = this.mHaveEglContext;
                                if (!z) {
                                    if (obj6 != null) {
                                        obj6 = null;
                                    }
                                    z = this.mEglHelper;
                                    z.start();
                                    this.mHaveEglContext = z;
                                    obj = 1;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                }
                                if (this.mHaveEglContext && !this.mHaveEglSurface) {
                                    this.mHaveEglSurface = true;
                                    gLThreadManager = true;
                                    obj2 = 1;
                                    obj4 = 1;
                                }
                                if (this.mHaveEglSurface) {
                                    if (this.mSizeChanged) {
                                        obj4 = 1;
                                        i2 = this.mWidth;
                                        i3 = this.mHeight;
                                        this.mWantRenderNotification = true;
                                        gLThreadManager = true;
                                        this.mSizeChanged = false;
                                    }
                                    this.mRequestRender = false;
                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                    if (this.mWantRenderNotification) {
                                        obj5 = 1;
                                        z = th;
                                    } else {
                                        z = th;
                                    }
                                    if (runnable == null) {
                                        runnable.run();
                                        runnable = null;
                                    } else {
                                        if (gLThreadManager != null) {
                                            if (this.mEglHelper.createSurface()) {
                                                gLThreadManager = GLSurfaceView.sGLThreadManager;
                                                synchronized (gLThreadManager) {
                                                    this.mFinishedCreatingEglSurface = true;
                                                    th = GLSurfaceView.sGLThreadManager;
                                                    th.notifyAll();
                                                }
                                                gLThreadManager = th;
                                            } else {
                                                access$800 = GLSurfaceView.sGLThreadManager;
                                                synchronized (access$800) {
                                                    this.mFinishedCreatingEglSurface = true;
                                                    this.mSurfaceIsBad = true;
                                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                                }
                                            }
                                        }
                                        if (obj2 != null) {
                                            obj2 = null;
                                            gl10 = (GL10) this.mEglHelper.createGL();
                                        }
                                        if (obj != null) {
                                            gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                            if (gLSurfaceView != null) {
                                                gLSurfaceView.mRenderer.onSurfaceCreated(gl10, this.mEglHelper.mEglConfig);
                                            }
                                            obj = null;
                                        }
                                        if (obj4 != null) {
                                            gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                            if (gLSurfaceView != null) {
                                                gLSurfaceView.mRenderer.onSurfaceChanged(gl10, i2, i3);
                                            }
                                            obj4 = null;
                                        }
                                        gLSurfaceView = (GLSurfaceView) this.mGLSurfaceViewWeakRef.get();
                                        if (gLSurfaceView != null) {
                                            gLSurfaceView.mRenderer.onDrawFrame(gl10);
                                            if (z) {
                                                z.run();
                                                z = false;
                                            }
                                        }
                                        int swap = this.mEglHelper.swap();
                                        switch (swap) {
                                            case 12288:
                                                break;
                                            case 12302:
                                                obj3 = 1;
                                                break;
                                            default:
                                                EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", swap);
                                                access$800 = GLSurfaceView.sGLThreadManager;
                                                synchronized (access$800) {
                                                    this.mSurfaceIsBad = true;
                                                    GLSurfaceView.sGLThreadManager.notifyAll();
                                                }
                                        }
                                    }
                                }
                                GLSurfaceView.sGLThreadManager.wait();
                                z = th;
                                if (this.mEventQueue.isEmpty()) {
                                }
                            }
                            synchronized (GLSurfaceView.sGLThreadManager) {
                                try {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                } finally {
                                    while (true) {
                                        AppMethodBeat.o(84450);
                                    }
                                }
                            }
                            return;
                        }
                        runnable = (Runnable) this.mEventQueue.remove(0);
                        if (runnable == null) {
                        }
                    }
                } catch (RuntimeException e) {
                    th = e;
                    GLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
                    throw th;
                } catch (Throwable th2) {
                    th = th2;
                    i = GLSurfaceView.sGLThreadManager;
                    synchronized (i) {
                        try {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                        } catch (Throwable th3) {
                            while (true) {
                                AppMethodBeat.o(84450);
                            }
                        }
                    }
                } finally {
                    i = 84450;
                    AppMethodBeat.o(84450);
                }
            }
            AppMethodBeat.o(i);
        }

        public boolean ableToDraw() {
            AppMethodBeat.i(84451);
            if (this.mHaveEglContext && this.mHaveEglSurface && readyToDraw()) {
                AppMethodBeat.o(84451);
                return true;
            }
            AppMethodBeat.o(84451);
            return false;
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            AppMethodBeat.i(84452);
            if (i < 0 || i > 1) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
                AppMethodBeat.o(84452);
                throw illegalArgumentException;
            }
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mRenderMode = i;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84452);
                }
            }
        }

        public int getRenderMode() {
            int i;
            AppMethodBeat.i(84453);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    i = this.mRenderMode;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84453);
                }
            }
            return i;
        }

        public void requestRender() {
            AppMethodBeat.i(84454);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mRequestRender = true;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84454);
                }
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            AppMethodBeat.i(84455);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    if (Thread.currentThread() == this) {
                    } else {
                        this.mWantRenderNotification = true;
                        this.mRequestRender = true;
                        this.mRenderComplete = false;
                        this.mFinishDrawingRunnable = runnable;
                        GLSurfaceView.sGLThreadManager.notifyAll();
                        AppMethodBeat.o(84455);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84455);
                }
            }
        }

        public void surfaceCreated() {
            AppMethodBeat.i(84456);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mHasSurface = true;
                    this.mFinishedCreatingEglSurface = false;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84456);
                }
            }
            AppMethodBeat.o(84456);
        }

        public void surfaceDestroyed() {
            AppMethodBeat.i(84457);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mHasSurface = false;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (!this.mWaitingForSurface && !this.mExited) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84457);
                }
            }
            AppMethodBeat.o(84457);
        }

        public void onPause() {
            AppMethodBeat.i(84458);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mRequestPaused = true;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84458);
                }
            }
            AppMethodBeat.o(84458);
        }

        public void onResume() {
            AppMethodBeat.i(84459);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mRequestPaused = false;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84459);
                }
            }
            AppMethodBeat.o(84459);
        }

        public void onWindowResize(int i, int i2) {
            AppMethodBeat.i(84460);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mWidth = i;
                    this.mHeight = i2;
                    this.mSizeChanged = true;
                    this.mRequestRender = true;
                    this.mRenderComplete = false;
                    if (Thread.currentThread() == this) {
                        AppMethodBeat.o(84460);
                        return;
                    }
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                    AppMethodBeat.o(84460);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84460);
                }
            }
        }

        public void requestExitAndWait() {
            AppMethodBeat.i(84461);
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mShouldExit = true;
                    GLSurfaceView.sGLThreadManager.notifyAll();
                    while (!this.mExited) {
                        GLSurfaceView.sGLThreadManager.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                    AppMethodBeat.o(84461);
                }
            }
            AppMethodBeat.o(84461);
        }

        public void requestReleaseEglContextLocked() {
            AppMethodBeat.i(84462);
            this.mShouldReleaseEglContext = true;
            GLSurfaceView.sGLThreadManager.notifyAll();
            AppMethodBeat.o(84462);
        }

        public void queueEvent(Runnable runnable) {
            AppMethodBeat.i(84463);
            if (runnable == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("r must not be null");
                AppMethodBeat.o(84463);
                throw illegalArgumentException;
            }
            synchronized (GLSurfaceView.sGLThreadManager) {
                try {
                    this.mEventQueue.add(runnable);
                    GLSurfaceView.sGLThreadManager.notifyAll();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84463);
                }
            }
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
            AppMethodBeat.i(84466);
            AppMethodBeat.o(84466);
        }

        public void close() {
            AppMethodBeat.i(84467);
            flushBuilder();
            AppMethodBeat.o(84467);
        }

        public void flush() {
            AppMethodBeat.i(84468);
            flushBuilder();
            AppMethodBeat.o(84468);
        }

        public void write(char[] cArr, int i, int i2) {
            AppMethodBeat.i(84469);
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
            AppMethodBeat.o(84469);
        }

        private void flushBuilder() {
            AppMethodBeat.i(84470);
            if (this.mBuilder.length() > 0) {
                this.mBuilder.delete(0, this.mBuilder.length());
            }
            AppMethodBeat.o(84470);
        }
    }

    class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            AppMethodBeat.i(84428);
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
            AppMethodBeat.o(84428);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            AppMethodBeat.i(84429);
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    findConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int findConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    findConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (findConfigAttrib == this.mRedSize && findConfigAttrib3 == this.mGreenSize && findConfigAttrib4 == this.mBlueSize && findConfigAttrib2 == this.mAlphaSize) {
                        AppMethodBeat.o(84429);
                        return eGLConfig;
                    }
                }
            }
            AppMethodBeat.o(84429);
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            AppMethodBeat.i(84430);
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue)) {
                i2 = this.mValue[0];
                AppMethodBeat.o(84430);
                return i2;
            }
            AppMethodBeat.o(84430);
            return i2;
        }
    }

    public GLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(84472);
        init();
        AppMethodBeat.o(84472);
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(84473);
        init();
        AppMethodBeat.o(84473);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(84474);
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
            super.finalize();
            AppMethodBeat.o(84474);
        } catch (Throwable th) {
            super.finalize();
            AppMethodBeat.o(84474);
        }
    }

    private void init() {
        AppMethodBeat.i(84475);
        getHolder().addCallback(this);
        AppMethodBeat.o(84475);
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
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

    public void setRenderer(Renderer renderer) {
        AppMethodBeat.i(84476);
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory(this, null);
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
        AppMethodBeat.o(84476);
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        AppMethodBeat.i(84477);
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
        AppMethodBeat.o(84477);
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        AppMethodBeat.i(84478);
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
        AppMethodBeat.o(84478);
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        AppMethodBeat.i(84479);
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
        AppMethodBeat.o(84479);
    }

    public void setEGLConfigChooser(boolean z) {
        AppMethodBeat.i(84480);
        setEGLConfigChooser(new SimpleEGLConfigChooser(z));
        AppMethodBeat.o(84480);
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(84481);
        setEGLConfigChooser(new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
        AppMethodBeat.o(84481);
    }

    public void setEGLContextClientVersion(int i) {
        AppMethodBeat.i(84482);
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
        AppMethodBeat.o(84482);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(84483);
        this.mGLThread.setRenderMode(i);
        AppMethodBeat.o(84483);
    }

    public int getRenderMode() {
        AppMethodBeat.i(84484);
        int renderMode = this.mGLThread.getRenderMode();
        AppMethodBeat.o(84484);
        return renderMode;
    }

    public void requestRender() {
        AppMethodBeat.i(84485);
        this.mGLThread.requestRender();
        AppMethodBeat.o(84485);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(84486);
        this.mGLThread.surfaceCreated();
        AppMethodBeat.o(84486);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(84487);
        this.mGLThread.surfaceDestroyed();
        AppMethodBeat.o(84487);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(84488);
        this.mGLThread.onWindowResize(i2, i3);
        AppMethodBeat.o(84488);
    }

    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        AppMethodBeat.i(84489);
        if (this.mGLThread != null) {
            this.mGLThread.requestRenderAndNotify(runnable);
        }
        AppMethodBeat.o(84489);
    }

    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public void onPause() {
        AppMethodBeat.i(84490);
        this.mGLThread.onPause();
        AppMethodBeat.o(84490);
    }

    public void onResume() {
        AppMethodBeat.i(84491);
        this.mGLThread.onResume();
        AppMethodBeat.o(84491);
    }

    public void queueEvent(Runnable runnable) {
        AppMethodBeat.i(84492);
        this.mGLThread.queueEvent(runnable);
        AppMethodBeat.o(84492);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(84493);
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            int renderMode;
            if (this.mGLThread != null) {
                renderMode = this.mGLThread.getRenderMode();
            } else {
                renderMode = 1;
            }
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (renderMode != 1) {
                this.mGLThread.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
        AppMethodBeat.o(84493);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(84494);
        if (this.mGLThread != null) {
            this.mGLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
        AppMethodBeat.o(84494);
    }

    private void checkRenderThreadState() {
        AppMethodBeat.i(84495);
        if (this.mGLThread != null) {
            IllegalStateException illegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
            AppMethodBeat.o(84495);
            throw illegalStateException;
        }
        AppMethodBeat.o(84495);
    }

    static {
        AppMethodBeat.i(84496);
        AppMethodBeat.o(84496);
    }
}
