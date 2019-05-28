package com.tencent.magicbrush;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.support.annotation.Keep;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.handler.MBCanvasHandler;
import com.tencent.magicbrush.handler.MBJsThreadHandler;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.magicbrush.handler.image.IMBImageHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

@Keep
public class MBRuntime {
    private static final String TAG = "MicroMsg.MagicBrush.MBRuntime";
    private int __filed_touchJava = 0;
    private com.tencent.magicbrush.c.a mAnimationFrameHandler;
    private final MBCanvasHandler mCanvasHandler;
    private IMBEventListener mClientEventListener = null;
    private IMBFontHandler mFontHandler = null;
    private IMBImageHandler mImageHandler = null;
    private volatile MBJsThreadHandler mJsThreadHandler;
    private ConcurrentLinkedQueue<IMBEventListener> mListenerQueue = null;
    public volatile long mNativeInst;
    private MBParams mParams;
    private volatile int mScreenCanvasId = -1;
    private volatile int mSystemDisplayHeight = 0;
    private volatile int mSystemDisplayWidth = 0;
    private boolean mainThreadWaitingFlag = false;
    private a mbInspector = new a(this);
    private com.tencent.magicbrush.c.b mbView;

    @Keep
    public interface IMBEventListener {
        void onConsoleOutput(String str);

        void onError(int i);

        void onFirstFrameRendered();

        void onJsExceptionOccurred(String str, String str2, int i);

        void onMainCanvasCreated(int i);

        void onMainCanvasTypeDefined(int i);

        void onRendererReady(int i, int i2);

        void onSystemSizeChanged(int i, int i2);
    }

    class b implements IMBEventListener {
        private b() {
        }

        /* synthetic */ b(MBRuntime mBRuntime, byte b) {
            this();
        }

        public final void onSystemSizeChanged(int i, int i2) {
            AppMethodBeat.i(115796);
            c.i(MBRuntime.TAG, "ClientEventListener.onSystemSizeChanged [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            MBRuntime.this.mSystemDisplayWidth = i;
            MBRuntime.this.mSystemDisplayHeight = i2;
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onSystemSizeChanged(i, i2);
            }
            AppMethodBeat.o(115796);
        }

        public final void onRendererReady(int i, int i2) {
            AppMethodBeat.i(115797);
            c.i(MBRuntime.TAG, "ClientEventListener.onRendererReady [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
            MBRuntime.this.mSystemDisplayWidth = i;
            MBRuntime.this.mSystemDisplayHeight = i2;
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onRendererReady(i, i2);
            }
            AppMethodBeat.o(115797);
        }

        public final void onFirstFrameRendered() {
            AppMethodBeat.i(115798);
            c.i(MBRuntime.TAG, "ClientEventListener.onFirstFrameRendered ", new Object[0]);
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onFirstFrameRendered();
            }
            AppMethodBeat.o(115798);
        }

        public final void onMainCanvasCreated(int i) {
            AppMethodBeat.i(115799);
            MBRuntime.this.mScreenCanvasId = i;
            AppMethodBeat.o(115799);
        }

        public final void onMainCanvasTypeDefined(int i) {
            AppMethodBeat.i(115800);
            c.i(MBRuntime.TAG, "ClientEventListener.onMainCanvasTypeDefined ", new Object[0]);
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onMainCanvasTypeDefined(i);
            }
            AppMethodBeat.o(115800);
        }

        public final void onError(int i) {
            AppMethodBeat.i(115801);
            c.i(MBRuntime.TAG, "ClientEventListener.onError ", new Object[0]);
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onError(i);
            }
            AppMethodBeat.o(115801);
        }

        public final void onJsExceptionOccurred(String str, String str2, int i) {
            AppMethodBeat.i(115802);
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onJsExceptionOccurred(str, str2, i);
            }
            AppMethodBeat.o(115802);
        }

        public final void onConsoleOutput(String str) {
            AppMethodBeat.i(115803);
            Iterator it = MBRuntime.this.mListenerQueue.iterator();
            while (it.hasNext()) {
                ((IMBEventListener) it.next()).onConsoleOutput(str);
            }
            AppMethodBeat.o(115803);
        }
    }

    @Keep
    public static class MBParams {
        public boolean adjust_thread_priority;
        public boolean allow_antialias_;
        public boolean allow_opengl3;
        public double device_pixel_ratio_;
        public boolean enable_request_animation_frame;
        public boolean enable_wxbindcanvastexture;
        public float gc_factor;
        public int screen_height_;
        public int screen_width_;
        public boolean use_command_buffer;
    }

    public static abstract class a implements IMBEventListener {
        public void onSystemSizeChanged(int i, int i2) {
        }

        public void onRendererReady(int i, int i2) {
        }

        public void onFirstFrameRendered() {
        }

        public void onError(int i) {
        }

        public void onMainCanvasTypeDefined(int i) {
        }

        public void onMainCanvasCreated(int i) {
        }

        public void onJsExceptionOccurred(String str, String str2, int i) {
        }

        public void onConsoleOutput(String str) {
        }
    }

    private native void nativeBindTo(long j, long j2, long j3);

    private native long nativeCreate(MBParams mBParams);

    private native void nativeDebug(long j, int i);

    private native void nativeDestroy(long j);

    private native int[] nativeGetCanvasSize(long j, int i);

    private native int nativeGetGLThreadTid(long j);

    private native int nativeGetJsThreadTid(long j);

    private native void nativeInit(long j);

    private native void nativeNotifyAnimationFrame(long j, double d);

    private native void nativeNotifyImageDecoded(long j, String str, Object obj);

    private native void nativeNotifyTouchEvent(long j, long j2);

    private native void nativeNotifyWindowAvailable(long j, SurfaceTexture surfaceTexture, int i, int i2);

    private native void nativeNotifyWindowChanged(long j, SurfaceTexture surfaceTexture, int i, int i2);

    private native void nativeNotifyWindowDestroyed(long j);

    private native void nativePause(long j);

    private native void nativeResume(long j);

    private native void nativeSetEventListener(long j, IMBEventListener iMBEventListener);

    private native void nativeSetFontHandler(long j, IMBFontHandler iMBFontHandler);

    private native void nativeSetImageHandler(long j, IMBImageHandler iMBImageHandler);

    private native void nativeSetJsThreadHandler(long j, long j2);

    private native void nativeSetUserPreferredFps(long j, double d);

    public native float[] nativeGetCurrentFps(long j);

    public native float nativeGetCurrentFpsVariance(long j);

    public native int nativeGetDrawCalls(long j);

    public native int nativeGetFrameCounter(long j);

    public native int nativeGetTriangles(long j);

    public native int nativeGetVertexes(long j);

    public native void nativeSetEnableInspectFpsVariance(long j, boolean z);

    static /* synthetic */ void access$100(MBRuntime mBRuntime, long j, long j2, long j3) {
        AppMethodBeat.i(115829);
        mBRuntime.nativeBindTo(j, j2, j3);
        AppMethodBeat.o(115829);
    }

    static /* synthetic */ void access$1000(MBRuntime mBRuntime, long j, long j2) {
        AppMethodBeat.i(115836);
        mBRuntime.nativeNotifyTouchEvent(j, j2);
        AppMethodBeat.o(115836);
    }

    static /* synthetic */ void access$1100(MBRuntime mBRuntime, long j, String str, Object obj) {
        AppMethodBeat.i(115837);
        mBRuntime.nativeNotifyImageDecoded(j, str, obj);
        AppMethodBeat.o(115837);
    }

    static /* synthetic */ void access$200(MBRuntime mBRuntime, long j) {
        AppMethodBeat.i(115830);
        mBRuntime.nativeResume(j);
        AppMethodBeat.o(115830);
    }

    static /* synthetic */ void access$500(MBRuntime mBRuntime, long j) {
        AppMethodBeat.i(115831);
        mBRuntime.nativePause(j);
        AppMethodBeat.o(115831);
    }

    static /* synthetic */ void access$600(MBRuntime mBRuntime, long j, SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(115832);
        mBRuntime.nativeNotifyWindowAvailable(j, surfaceTexture, i, i2);
        AppMethodBeat.o(115832);
    }

    static /* synthetic */ void access$700(MBRuntime mBRuntime, long j, SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(115833);
        mBRuntime.nativeNotifyWindowChanged(j, surfaceTexture, i, i2);
        AppMethodBeat.o(115833);
    }

    static /* synthetic */ void access$800(MBRuntime mBRuntime, long j) {
        AppMethodBeat.i(115834);
        mBRuntime.nativeNotifyWindowDestroyed(j);
        AppMethodBeat.o(115834);
    }

    static /* synthetic */ void access$900(MBRuntime mBRuntime, long j, double d) {
        AppMethodBeat.i(115835);
        mBRuntime.nativeSetUserPreferredFps(j, d);
        AppMethodBeat.o(115835);
    }

    static {
        AppMethodBeat.i(115838);
        com.tencent.magicbrush.a.b.yB();
        AppMethodBeat.o(115838);
    }

    public MBRuntime(MBParams mBParams) {
        AppMethodBeat.i(115804);
        this.mParams = mBParams;
        IllegalArgumentException illegalArgumentException;
        if (this.mParams.device_pixel_ratio_ <= 0.0d || this.mParams.screen_width_ <= 0 || this.mParams.screen_height_ <= 0) {
            illegalArgumentException = new IllegalArgumentException("MBRuntime can only accept positive screen.");
            AppMethodBeat.o(115804);
            throw illegalArgumentException;
        } else if (this.mParams.gc_factor < 0.0f || this.mParams.gc_factor > 1.0f) {
            illegalArgumentException = new IllegalArgumentException("MBRuntime gc_factor can only accept [0, 1].");
            AppMethodBeat.o(115804);
            throw illegalArgumentException;
        } else {
            this.mNativeInst = nativeCreate(this.mParams);
            this.mClientEventListener = new b(this, (byte) 0);
            nativeSetEventListener(this.mNativeInst, this.mClientEventListener);
            this.mCanvasHandler = new MBCanvasHandler(this, this.mNativeInst);
            AppMethodBeat.o(115804);
        }
    }

    public synchronized boolean isDestroyed() {
        return this.mNativeInst == 0;
    }

    public boolean isDestroyedUnlock() {
        return this.mNativeInst == 0;
    }

    public void init() {
        AppMethodBeat.i(115805);
        if (this.mParams.enable_request_animation_frame) {
            this.mAnimationFrameHandler = new com.tencent.magicbrush.c.a(this, this.mJsThreadHandler);
        }
        if (this.mFontHandler == null) {
            this.mFontHandler = new h();
            nativeSetFontHandler(this.mNativeInst, this.mFontHandler);
        }
        if (this.mImageHandler == null) {
            this.mImageHandler = new com.tencent.magicbrush.handler.image.a(this, this.mJsThreadHandler);
            nativeSetImageHandler(this.mNativeInst, this.mImageHandler);
        }
        IllegalStateException illegalStateException;
        if (this.mJsThreadHandler == null) {
            illegalStateException = new IllegalStateException("[MBRuntime] JsThreadHandler not registered.");
            AppMethodBeat.o(115805);
            throw illegalStateException;
        } else if (this.mImageHandler == null) {
            illegalStateException = new IllegalStateException("[MBRuntime] ImageHandler not registered.");
            AppMethodBeat.o(115805);
            throw illegalStateException;
        } else if (this.mFontHandler == null) {
            illegalStateException = new IllegalStateException("[MBRuntime] FontHandler not registered.");
            AppMethodBeat.o(115805);
            throw illegalStateException;
        } else if (this.mNativeInst == 0) {
            c.i(TAG, "init. mNativeInst == 0", new Object[0]);
            AppMethodBeat.o(115805);
        } else {
            nativeInit(this.mNativeInst);
            AppMethodBeat.o(115805);
        }
    }

    public void bindTo(long j, long j2) {
        AppMethodBeat.i(115806);
        c.i(TAG, "MBRuntime.bindTo", new Object[0]);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115806);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115806);
            return;
        }
        final long j3 = j;
        final long j4 = j2;
        mBJsThreadHandler.i(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115787);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115787);
                    return;
                }
                MBRuntime.access$100(MBRuntime.this, MBRuntime.this.mNativeInst, j3, j4);
                AppMethodBeat.o(115787);
            }
        });
        AppMethodBeat.o(115806);
    }

    public void resume() {
        AppMethodBeat.i(115807);
        c.i(TAG, "MBRuntime.resume ", new Object[0]);
        if (this.mbView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("MBRuntime can not resume, before a MBRuntimeView attached.");
            AppMethodBeat.o(115807);
            throw illegalStateException;
        } else if (this.mNativeInst == 0) {
            AppMethodBeat.o(115807);
        } else {
            MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
            if (mBJsThreadHandler == null) {
                AppMethodBeat.o(115807);
                return;
            }
            mBJsThreadHandler.f(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(115788);
                    if (MBRuntime.this.mNativeInst == 0) {
                        AppMethodBeat.o(115788);
                        return;
                    }
                    MBRuntime.access$200(MBRuntime.this, MBRuntime.this.mNativeInst);
                    if (MBRuntime.this.mParams.enable_request_animation_frame) {
                        MBRuntime.this.mAnimationFrameHandler.resume();
                    }
                    AppMethodBeat.o(115788);
                }
            });
            AppMethodBeat.o(115807);
        }
    }

    public void pause() {
        AppMethodBeat.i(115808);
        c.i(TAG, "MBRuntime.pause ", new Object[0]);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115808);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115808);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115789);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115789);
                    return;
                }
                if (MBRuntime.this.mParams.enable_request_animation_frame) {
                    MBRuntime.this.mAnimationFrameHandler.pause();
                }
                MBRuntime.access$500(MBRuntime.this, MBRuntime.this.mNativeInst);
                AppMethodBeat.o(115789);
            }
        });
        AppMethodBeat.o(115808);
    }

    public void debug(int i) {
        AppMethodBeat.i(115809);
        nativeDebug(this.mNativeInst, i);
        AppMethodBeat.o(115809);
    }

    public void notifyAnimationFrame(double d) {
        AppMethodBeat.i(115810);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115810);
            return;
        }
        nativeNotifyAnimationFrame(this.mNativeInst, d);
        AppMethodBeat.o(115810);
    }

    public void notifyWindowAvailable(final SurfaceTexture surfaceTexture, final int i, final int i2) {
        AppMethodBeat.i(115811);
        c.i(TAG, "MBRuntime.notifyWindowAvailable ", new Object[0]);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115811);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115811);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115790);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115790);
                    return;
                }
                MBRuntime.access$600(MBRuntime.this, MBRuntime.this.mNativeInst, surfaceTexture, i, i2);
                AppMethodBeat.o(115790);
            }
        });
        AppMethodBeat.o(115811);
    }

    public void notifyWindowChanged(final SurfaceTexture surfaceTexture, final int i, final int i2) {
        AppMethodBeat.i(115812);
        c.i(TAG, "MBRuntime.notifyWindowChanged ", new Object[0]);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115812);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115812);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115791);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115791);
                    return;
                }
                MBRuntime.access$700(MBRuntime.this, MBRuntime.this.mNativeInst, surfaceTexture, i, i2);
                AppMethodBeat.o(115791);
            }
        });
        AppMethodBeat.o(115812);
    }

    public void notifyWindowDestroyed(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(115813);
        c.i(TAG, "MBRuntime.notifyWindowDestroyed ", new Object[0]);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115813);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115813);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115792);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115792);
                    return;
                }
                MBRuntime.access$800(MBRuntime.this, MBRuntime.this.mNativeInst);
                surfaceTexture.release();
                AppMethodBeat.o(115792);
            }
        });
        AppMethodBeat.o(115813);
    }

    public void destroy() {
        AppMethodBeat.i(115814);
        c.i(TAG, "MBRuntime.destroy", new Object[0]);
        if (this.mNativeInst == 0) {
            c.i(TAG, "MBRuntime.destroy skip outside", new Object[0]);
            AppMethodBeat.o(115814);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                if (this.mNativeInst == 0) {
                    c.i(TAG, "MBRuntime.destroy skip inside, lock [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (this.mParams.enable_request_animation_frame) {
                        this.mAnimationFrameHandler.destroy();
                    }
                    nativeDestroy(this.mNativeInst);
                    this.mJsThreadHandler = null;
                    resetJavaClientRes();
                    this.mNativeInst = 0;
                    this.mbView = null;
                    c.i(TAG, "MBRuntime.destroy cost [%d]ms, monitoring lock cost [%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    AppMethodBeat.o(115814);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115814);
            }
        }
    }

    public int getJsThreadTid() {
        int i = 0;
        AppMethodBeat.i(115815);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115815);
        } else {
            synchronized (this) {
                try {
                    if (this.mNativeInst == 0) {
                    } else {
                        i = nativeGetJsThreadTid(this.mNativeInst);
                        AppMethodBeat.o(115815);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(115815);
                }
            }
        }
        return i;
    }

    public int getGLThreadTid() {
        int i = 0;
        AppMethodBeat.i(115816);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115816);
        } else {
            synchronized (this) {
                try {
                    if (this.mNativeInst == 0) {
                    } else {
                        i = nativeGetGLThreadTid(this.mNativeInst);
                        AppMethodBeat.o(115816);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(115816);
                }
            }
        }
        return i;
    }

    private void resetJavaClientRes() {
        AppMethodBeat.i(115817);
        if (this.mListenerQueue != null) {
            this.mListenerQueue.clear();
            this.mListenerQueue = null;
        }
        this.mClientEventListener = null;
        this.mImageHandler = null;
        this.mFontHandler = null;
        AppMethodBeat.o(115817);
    }

    public boolean isMainThreadWaiting() {
        return this.mainThreadWaitingFlag;
    }

    public void setMBRuntimeView(com.tencent.magicbrush.c.b bVar) {
        this.mbView = bVar;
    }

    public com.tencent.magicbrush.c.b getMBRuntimeView() {
        return this.mbView;
    }

    public void setImageHandler(IMBImageHandler iMBImageHandler) {
        AppMethodBeat.i(115818);
        this.mImageHandler = iMBImageHandler;
        nativeSetImageHandler(this.mNativeInst, iMBImageHandler);
        AppMethodBeat.o(115818);
    }

    public IMBImageHandler getImageHandler() {
        return this.mImageHandler;
    }

    public void setFontHandler(IMBFontHandler iMBFontHandler) {
        AppMethodBeat.i(115819);
        this.mFontHandler = iMBFontHandler;
        nativeSetFontHandler(this.mNativeInst, iMBFontHandler);
        AppMethodBeat.o(115819);
    }

    public IMBFontHandler getFontHandler() {
        return this.mFontHandler;
    }

    public MBCanvasHandler getCanvasHandler() {
        return this.mCanvasHandler;
    }

    public int getScreenCanvasId() {
        return this.mScreenCanvasId;
    }

    public MBParams getParams() {
        return this.mParams;
    }

    public com.tencent.magicbrush.a.a getCurrentFps() {
        AppMethodBeat.i(115820);
        com.tencent.magicbrush.a.a currentFps = getInspector().getCurrentFps();
        AppMethodBeat.o(115820);
        return currentFps;
    }

    public a getInspector() {
        return this.mbInspector;
    }

    public void setUserPreferredFps(final double d) {
        AppMethodBeat.i(115821);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115821);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            AppMethodBeat.o(115821);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115793);
                if (MBRuntime.this.mNativeInst == 0) {
                    AppMethodBeat.o(115793);
                    return;
                }
                MBRuntime.access$900(MBRuntime.this, MBRuntime.this.mNativeInst, d);
                AppMethodBeat.o(115793);
            }
        });
        AppMethodBeat.o(115821);
    }

    public void notifyTouchEvent(final long j, final com.tencent.magicbrush.handler.JsTouchEventHandler.a aVar) {
        AppMethodBeat.i(115822);
        if (this.mNativeInst == 0) {
            aVar.aA(j);
            AppMethodBeat.o(115822);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            aVar.aA(j);
            AppMethodBeat.o(115822);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115794);
                if (MBRuntime.this.mNativeInst == 0) {
                    aVar.aA(j);
                    AppMethodBeat.o(115794);
                    return;
                }
                MBRuntime.access$1000(MBRuntime.this, MBRuntime.this.mNativeInst, j);
                AppMethodBeat.o(115794);
            }
        });
        AppMethodBeat.o(115822);
    }

    public void notifyImageDecoded(final String str, final Object obj, final com.tencent.magicbrush.handler.image.IMBImageHandler.a aVar) {
        AppMethodBeat.i(115823);
        if (this.mNativeInst == 0) {
            aVar.ag(obj);
            AppMethodBeat.o(115823);
            return;
        }
        MBJsThreadHandler mBJsThreadHandler = this.mJsThreadHandler;
        if (mBJsThreadHandler == null) {
            aVar.ag(obj);
            AppMethodBeat.o(115823);
            return;
        }
        mBJsThreadHandler.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115795);
                if (MBRuntime.this.mNativeInst == 0) {
                    aVar.ag(obj);
                    AppMethodBeat.o(115795);
                    return;
                }
                MBRuntime.access$1100(MBRuntime.this, MBRuntime.this.mNativeInst, str, obj);
                AppMethodBeat.o(115795);
            }
        });
        AppMethodBeat.o(115823);
    }

    public int getSystemDisplayWidth() {
        return this.mSystemDisplayWidth;
    }

    public int getSystemDisplayHeight() {
        return this.mSystemDisplayHeight;
    }

    public int[] getCanvasSize(int i) {
        AppMethodBeat.i(115824);
        if (this.mNativeInst == 0) {
            AppMethodBeat.o(115824);
            return null;
        }
        int[] nativeGetCanvasSize = nativeGetCanvasSize(this.mNativeInst, i);
        if (nativeGetCanvasSize == null || nativeGetCanvasSize.length == 2) {
            AppMethodBeat.o(115824);
            return nativeGetCanvasSize;
        }
        AppMethodBeat.o(115824);
        return null;
    }

    public void registerEventListener(IMBEventListener iMBEventListener) {
        AppMethodBeat.i(115825);
        c.i(TAG, "MBRuntime.registerEventListener ", new Object[0]);
        if (this.mListenerQueue == null) {
            this.mListenerQueue = new ConcurrentLinkedQueue();
        }
        this.mListenerQueue.add(iMBEventListener);
        AppMethodBeat.o(115825);
    }

    public void unregisterEventListener(IMBEventListener iMBEventListener) {
        AppMethodBeat.i(115826);
        c.i(TAG, "MBRuntime.unregisterEventListener ", new Object[0]);
        if (this.mListenerQueue == null) {
            IllegalStateException illegalStateException = new IllegalStateException("[MBRuntime:unregisterEventListener] You may make a mistake.");
            AppMethodBeat.o(115826);
            throw illegalStateException;
        }
        this.mListenerQueue.remove(iMBEventListener);
        AppMethodBeat.o(115826);
    }

    public void setJsThreadHandler(com.tencent.magicbrush.handler.a aVar) {
        AppMethodBeat.i(115827);
        c.i(TAG, "MBRuntime.setJsThreadHandler ", new Object[0]);
        if (this.mJsThreadHandler != null) {
            c.e(TAG, "Why you setJsThreadHandler twice, unexpected behaviour.", new Object[0]);
            AppMethodBeat.o(115827);
            return;
        }
        long j = this.mNativeInst;
        this.mJsThreadHandler = new MBJsThreadHandler(aVar);
        AppMethodBeat.o(115827);
    }

    public MBJsThreadHandler getJsThreadHandler() {
        return this.mJsThreadHandler;
    }

    @Keep
    private void touchJava() {
        this.__filed_touchJava++;
    }

    @Keep
    private Bitmap captureScreen(Bitmap bitmap) {
        AppMethodBeat.i(115828);
        Bitmap a = getCanvasHandler().a(bitmap, true);
        AppMethodBeat.o(115828);
        return a;
    }
}
