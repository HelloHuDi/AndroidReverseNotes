package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.WindowSurface;
import com.tencent.ttpic.util.FrameRateUtil;

@TargetApi(18)
public class RenderSrfTex {
    private static final String TAG = RenderSrfTex.class.getSimpleName();
    private int[] alterWidths;
    private Handler handler;
    private double mAspectRatio = 0.0d;
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame = new C41672h();
    private EglCore mCore;
    private int mFboTexH;
    private int mFboTexW;
    private HandlerThread mGlThread;
    private boolean mIgnoreWatermark;
    private WindowSurface mInputSurface;
    private final MyRecorder mRecorder;
    private long mSampleTimeMs = -1;

    static /* synthetic */ void access$1000(RenderSrfTex renderSrfTex) {
        AppMethodBeat.m2504i(83718);
        renderSrfTex.initGL();
        AppMethodBeat.m2505o(83718);
    }

    static {
        AppMethodBeat.m2504i(83719);
        AppMethodBeat.m2505o(83719);
    }

    public RenderSrfTex(int i, int i2, String str, int i3, boolean z) {
        AppMethodBeat.m2504i(83710);
        this.mRecorder = new MyRecorder(str);
        this.mFboTexW = Math.max(i, 1);
        this.mFboTexH = Math.max(i2, 1);
        if (i3 == 90 || i3 == 270) {
            int i4 = this.mFboTexW;
            this.mFboTexW = this.mFboTexH;
            this.mFboTexH = i4;
        }
        this.alterWidths = new int[0];
        this.mIgnoreWatermark = z;
        AppMethodBeat.m2505o(83710);
    }

    public boolean prepare() {
        boolean prepareEncoder;
        AppMethodBeat.m2504i(83711);
        int i = this.mFboTexH;
        int i2 = this.mFboTexW;
        float f = ((float) i) / ((float) i2);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            prepareEncoder = this.mRecorder.prepareEncoder(i4, i);
            if (prepareEncoder || i3 >= this.alterWidths.length) {
                this.mFboTexW = Math.max(i4, 1);
                this.mFboTexH = Math.max(i, 1);
                AppMethodBeat.m2505o(83711);
            } else if (i4 > i) {
                i2 = i3 + 1;
                i = this.alterWidths[i3];
                i4 = (int) (((float) i) / f);
                i3 = i2;
            } else {
                i2 = i3 + 1;
                i4 = this.alterWidths[i3];
                i = (int) (((float) i4) * f);
                i3 = i2;
            }
        }
        this.mFboTexW = Math.max(i4, 1);
        this.mFboTexH = Math.max(i, 1);
        AppMethodBeat.m2505o(83711);
        return prepareEncoder;
    }

    public void setAlternativeWidth(int[] iArr) {
        this.alterWidths = iArr;
    }

    public boolean ignoreWatermark() {
        return this.mIgnoreWatermark;
    }

    public void draw(final int i) {
        AppMethodBeat.m2504i(83712);
        if (i < 0) {
            AppMethodBeat.m2505o(83712);
            return;
        }
        queue(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(83707);
                if (FrameRateUtil.mRecordStartTime == -1) {
                    FrameRateUtil.mRecordStartTime = System.currentTimeMillis();
                    FrameRateUtil.mFrameCount = 0;
                }
                if (RenderSrfTex.this.mSampleTimeMs <= 0 || System.currentTimeMillis() - FrameRateUtil.mRecordStartTime >= ((long) FrameRateUtil.mFrameCount) * RenderSrfTex.this.mSampleTimeMs) {
                    FrameRateUtil.mFrameCount++;
                    RenderSrfTex.this.mCopyFilter.RenderProcess(i, RenderSrfTex.this.mFboTexW, RenderSrfTex.this.mFboTexH, 0, RenderSrfTex.this.mAspectRatio, RenderSrfTex.this.mCopyFrame);
                    if (RenderSrfTex.this.mInputSurface != null) {
                        RenderSrfTex.this.mInputSurface.swapBuffers();
                        RenderSrfTex.this.mInputSurface.setPresentationTime(System.nanoTime());
                    }
                    RenderSrfTex.this.mRecorder.swapBuffers();
                    GlUtil.checkGlError("draw_E");
                    AppMethodBeat.m2505o(83707);
                    return;
                }
                AppMethodBeat.m2505o(83707);
            }
        });
        AppMethodBeat.m2505o(83712);
    }

    private void initGL() {
        AppMethodBeat.m2504i(83713);
        GlUtil.checkGlError("initGL_S");
        this.mCopyFilter.ApplyGLSLFilter();
        this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
        GlUtil.checkGlError("initGL_E");
        AppMethodBeat.m2505o(83713);
    }

    public void initGlThread(final EGLContext eGLContext) {
        AppMethodBeat.m2504i(83714);
        C59842 c59842 = new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(83708);
                RenderSrfTex.TAG;
                Surface inputSurface = RenderSrfTex.this.mRecorder.getInputSurface();
                RenderSrfTex.TAG;
                if (inputSurface == null) {
                    RenderSrfTex.this.mInputSurface = null;
                    RenderSrfTex.TAG;
                    AppMethodBeat.m2505o(83708);
                    return;
                }
                RenderSrfTex.TAG;
                RenderSrfTex.this.mCore = new EglCore(eGLContext, 0);
                RenderSrfTex.this.mInputSurface = new WindowSurface(RenderSrfTex.this.mCore, RenderSrfTex.this.mRecorder.getInputSurface(), true);
                RenderSrfTex.TAG;
                RenderSrfTex.TAG;
                RenderSrfTex.this.mInputSurface.makeCurrent();
                RenderSrfTex.TAG;
                RenderSrfTex.TAG;
                RenderSrfTex.access$1000(RenderSrfTex.this);
                RenderSrfTex.TAG;
                try {
                    RenderSrfTex.TAG;
                    RenderSrfTex.this.mRecorder.start();
                    RenderSrfTex.TAG;
                } catch (Exception e) {
                    RenderSrfTex.TAG;
                    RenderSrfTex.this.mRecorder.releaseEncoder();
                }
                RenderSrfTex.TAG;
                AppMethodBeat.m2505o(83708);
            }
        };
        if (this.mGlThread == null) {
            this.mGlThread = new HandlerThread("VideoGlThread");
            this.mGlThread.start();
            this.handler = new Handler(this.mGlThread.getLooper());
            this.handler.post(c59842);
        }
        AppMethodBeat.m2505o(83714);
    }

    public void queue(Runnable runnable) {
        AppMethodBeat.m2504i(83715);
        if (this.handler != null) {
            this.handler.post(runnable);
        }
        AppMethodBeat.m2505o(83715);
    }

    public void stop(final VideoRecorderListener videoRecorderListener) {
        AppMethodBeat.m2504i(83716);
        queue(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(83709);
                if (RenderSrfTex.this.mRecorder != null) {
                    RenderSrfTex.this.mRecorder.stop();
                }
                if (RenderSrfTex.this.mInputSurface != null) {
                    RenderSrfTex.this.mInputSurface.release();
                }
                if (RenderSrfTex.this.mCore != null) {
                    RenderSrfTex.this.mCore.release();
                }
                RenderSrfTex.this.mCopyFilter.clearGLSLSelf();
                RenderSrfTex.this.mCopyFrame.clear();
                if (!(videoRecorderListener == null || RenderSrfTex.this.mRecorder == null)) {
                    videoRecorderListener.onVideoRecordFinish(RenderSrfTex.this.mRecorder.getOutputPath());
                }
                if (RenderSrfTex.this.mGlThread != null) {
                    RenderSrfTex.this.mGlThread.quit();
                    RenderSrfTex.this.mGlThread = null;
                }
                if (RenderSrfTex.this.handler != null) {
                    RenderSrfTex.this.handler = null;
                }
                AppMethodBeat.m2505o(83709);
            }
        });
        AppMethodBeat.m2505o(83716);
    }

    public void setPlayRate(float f) {
        AppMethodBeat.m2504i(83717);
        if (this.mRecorder != null) {
            this.mRecorder.setPlayRate(f);
        }
        AppMethodBeat.m2505o(83717);
    }

    public void setSampleTime(long j) {
        this.mSampleTimeMs = j;
    }

    public int getWidth() {
        return this.mFboTexW;
    }

    public int getHeight() {
        return this.mFboTexH;
    }
}
