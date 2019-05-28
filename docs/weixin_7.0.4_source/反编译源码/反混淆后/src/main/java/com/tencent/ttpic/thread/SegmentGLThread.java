package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.filter.ExpFilter;
import com.tencent.ttpic.filter.FabbyExtractFilter;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.filter.SimpleGaussionFilter;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.shader.ShaderManager;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.view.C41106g;

@TargetApi(18)
public class SegmentGLThread {
    private static final int SEGMENT_HEIGHT;
    private static final int SEGMENT_WIDTH = 16;
    private ExpFilter expFilter = new ExpFilter();
    private FabbyExtractFilter fabbyExtractFilter = new FabbyExtractFilter();
    private FabbyStrokeFilter fabbyStrokeFilter = new FabbyStrokeFilter();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame;
    private EglCore mCore;
    private Handler mHandler;
    private boolean mIsInitReady;
    private OnSegDataReadyListener mListener;
    private Bitmap mMaskBitmap;
    private Bitmap mMaskBitmapHorizon;
    private OffscreenSurface mOffscreenSurface;
    private boolean mRunOnCpuForce;
    private Bitmap mSegBitmap;
    private Bitmap mSegBitmapHorizon;
    private C41672h mSegFrame;
    private SimpleGaussionFilter mSimpleBlurFilter = new SimpleGaussionFilter();
    private C41672h mTempFrame;
    private int[] mTempTexId = new int[2];
    private GLSegSharedData sharedData;

    /* renamed from: com.tencent.ttpic.thread.SegmentGLThread$4 */
    class C163594 implements Runnable {
        C163594() {
        }

        public void run() {
            AppMethodBeat.m2504i(83776);
            SegmentGLThread.this.sharedData.reset();
            AppMethodBeat.m2505o(83776);
        }
    }

    /* renamed from: com.tencent.ttpic.thread.SegmentGLThread$6 */
    class C163606 implements Runnable {
        C163606() {
        }

        public void run() {
            AppMethodBeat.m2504i(83778);
            FabbyManager.getInstance().clearSegmentBuffer();
            AppMethodBeat.m2505o(83778);
        }
    }

    /* renamed from: com.tencent.ttpic.thread.SegmentGLThread$5 */
    class C163615 implements Runnable {
        C163615() {
        }

        public void run() {
            AppMethodBeat.m2504i(83777);
            FabbyManager.getInstance().compileKernel();
            AppMethodBeat.m2505o(83777);
        }
    }

    public interface OnSegDataReadyListener {
        void onDataReady(SegmentDataPipe segmentDataPipe);
    }

    /* renamed from: com.tencent.ttpic.thread.SegmentGLThread$3 */
    class C163643 implements Runnable {
        C163643() {
        }

        public void run() {
            AppMethodBeat.m2504i(83775);
            if (BitmapUtils.isLegal(SegmentGLThread.this.mSegBitmap)) {
                SegmentGLThread.this.mSegBitmap.recycle();
                SegmentGLThread.this.mSegBitmap = null;
            }
            if (BitmapUtils.isLegal(SegmentGLThread.this.mSegBitmapHorizon)) {
                SegmentGLThread.this.mSegBitmapHorizon.recycle();
                SegmentGLThread.this.mSegBitmapHorizon = null;
            }
            if (BitmapUtils.isLegal(SegmentGLThread.this.mMaskBitmap)) {
                SegmentGLThread.this.mMaskBitmap.recycle();
                SegmentGLThread.this.mMaskBitmap = null;
            }
            if (BitmapUtils.isLegal(SegmentGLThread.this.mMaskBitmapHorizon)) {
                SegmentGLThread.this.mMaskBitmapHorizon.recycle();
                SegmentGLThread.this.mMaskBitmapHorizon = null;
            }
            SegmentGLThread.this.sharedData.clear();
            SegmentGLThread.this.mTempFrame.clear();
            SegmentGLThread.this.mCopyFrame.clear();
            SegmentGLThread.this.mSegFrame.clear();
            SegmentGLThread.this.mCopyFilter.ClearGLSL();
            SegmentGLThread.this.fabbyStrokeFilter.clearGLSLSelf();
            SegmentGLThread.this.fabbyExtractFilter.clearGLSLSelf();
            SegmentGLThread.this.expFilter.clearGLSLSelf();
            SegmentGLThread.this.mSimpleBlurFilter.clearGLSLSelf();
            GLES20.glDeleteTextures(SegmentGLThread.this.mTempTexId.length, SegmentGLThread.this.mTempTexId, 0);
            SegmentGLThread.this.mOffscreenSurface.release();
            SegmentGLThread.this.mCore.release();
            SegmentGLThread.this.mHandler.getLooper().quit();
            AppMethodBeat.m2505o(83775);
        }
    }

    static /* synthetic */ void access$1200(SegmentGLThread segmentGLThread, int i) {
        AppMethodBeat.m2504i(83788);
        segmentGLThread.setAllRenderMode(i);
        AppMethodBeat.m2505o(83788);
    }

    static {
        int i = 16;
        boolean z = FabbyManager.USE_SMALL_IMAGE;
        if (!FabbyManager.USE_SMALL_IMAGE) {
            i = 32;
        }
        SEGMENT_HEIGHT = i;
    }

    public SegmentGLThread(final EGLContext eGLContext) {
        AppMethodBeat.m2504i(83779);
        HandlerThread handlerThread = new HandlerThread("SegmentGLThread");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(83773);
                SegmentGLThread.this.mCore = new EglCore(eGLContext, 0);
                SegmentGLThread.this.mOffscreenSurface = new OffscreenSurface(SegmentGLThread.this.mCore, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                SegmentGLThread.this.mOffscreenSurface.makeCurrent();
                SegmentGLThread.this.mCopyFilter.ApplyGLSLFilter();
                SegmentGLThread.this.fabbyStrokeFilter.ApplyGLSLFilter();
                SegmentGLThread.this.fabbyExtractFilter.ApplyGLSLFilter();
                SegmentGLThread.this.expFilter.ApplyGLSLFilter();
                SegmentGLThread.this.mSimpleBlurFilter.ApplyGLSLFilter();
                SegmentGLThread.this.sharedData = new GLSegSharedData(eGLContext);
                SegmentGLThread.this.mTempFrame = new C41672h();
                SegmentGLThread.this.mCopyFrame = new C41672h();
                SegmentGLThread.this.mSegFrame = new C41672h();
                GLES20.glGenTextures(SegmentGLThread.this.mTempTexId.length, SegmentGLThread.this.mTempTexId, 0);
                SegmentGLThread.access$1200(SegmentGLThread.this, 1);
                ShaderManager.getInstance().clear();
                SegmentGLThread.this.mIsInitReady = true;
                AppMethodBeat.m2505o(83773);
            }
        });
        AppMethodBeat.m2505o(83779);
    }

    public void setOnDataReadyListener(OnSegDataReadyListener onSegDataReadyListener) {
        this.mListener = onSegDataReadyListener;
    }

    public boolean isInitReady() {
        return this.mIsInitReady;
    }

    public void postSegJob(final C41672h c41672h, final boolean z) {
        AppMethodBeat.m2504i(83780);
        if (this.mHandler == null) {
            AppMethodBeat.m2505o(83780);
            return;
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(83774);
                if (SegmentGLThread.this.mListener == null) {
                    AppMethodBeat.m2505o(83774);
                    return;
                }
                SegmentDataPipe freeTexturePileMakeBusy = SegmentGLThread.this.sharedData.getFreeTexturePileMakeBusy();
                if (freeTexturePileMakeBusy == null) {
                    AppMethodBeat.m2505o(83774);
                    return;
                }
                int access$1500 = z ? SegmentGLThread.SEGMENT_HEIGHT : SegmentGLThread.SEGMENT_WIDTH;
                int access$1600 = z ? SegmentGLThread.SEGMENT_WIDTH : SegmentGLThread.SEGMENT_HEIGHT;
                freeTexturePileMakeBusy.mTimestamp = System.currentTimeMillis();
                BenchUtil.benchStart("[showPreview][FABBY] segment");
                SegmentGLThread.this.mCopyFilter.RenderProcess(c41672h.texture[0], c41672h.width, c41672h.height, -1, 0.0d, freeTexturePileMakeBusy.mTexFrame);
                SegmentGLThread.this.mSegFrame = freeTexturePileMakeBusy.mTexFrame;
                freeTexturePileMakeBusy.mMaskFrame.mo67189a(-1, SegmentGLThread.this.mSegFrame.width, SegmentGLThread.this.mSegFrame.height, 0.0d);
                if (!FabbyManager.getInstance().isGPUSupportOpenCL() || SegmentGLThread.this.mRunOnCpuForce) {
                    SegmentGLThread.this.mCopyFilter.RenderProcess(SegmentGLThread.this.mSegFrame.texture[0], access$1500 * 16, access$1600 * 16, -1, 0.0d, SegmentGLThread.this.mCopyFrame);
                    if (!BitmapUtils.isLegal(SegmentGLThread.this.mSegBitmap)) {
                        SegmentGLThread.this.mSegBitmap = Bitmap.createBitmap(SegmentGLThread.SEGMENT_WIDTH * 16, SegmentGLThread.SEGMENT_HEIGHT * 16, Config.ARGB_8888);
                    }
                    if (!BitmapUtils.isLegal(SegmentGLThread.this.mSegBitmapHorizon)) {
                        SegmentGLThread.this.mSegBitmapHorizon = Bitmap.createBitmap(SegmentGLThread.SEGMENT_HEIGHT * 16, SegmentGLThread.SEGMENT_WIDTH * 16, Config.ARGB_8888);
                    }
                    if (!BitmapUtils.isLegal(SegmentGLThread.this.mMaskBitmap)) {
                        SegmentGLThread.this.mMaskBitmap = Bitmap.createBitmap(SegmentGLThread.SEGMENT_WIDTH, SegmentGLThread.SEGMENT_HEIGHT, Config.ARGB_8888);
                    }
                    if (!BitmapUtils.isLegal(SegmentGLThread.this.mMaskBitmapHorizon)) {
                        SegmentGLThread.this.mMaskBitmapHorizon = Bitmap.createBitmap(SegmentGLThread.SEGMENT_HEIGHT, SegmentGLThread.SEGMENT_WIDTH, Config.ARGB_8888);
                    }
                    Bitmap access$1900 = z ? SegmentGLThread.this.mSegBitmapHorizon : SegmentGLThread.this.mSegBitmap;
                    Bitmap access$2100 = z ? SegmentGLThread.this.mMaskBitmapHorizon : SegmentGLThread.this.mMaskBitmap;
                    C41106g.m71539a(SegmentGLThread.this.mCopyFrame.texture[0], access$1500 * 16, access$1600 * 16, access$1900);
                    FabbyManager.getInstance().segmentOnBitmap(access$1900, access$2100, access$1500 * 16, access$1600 * 16, access$1500, access$1600);
                    GlUtil.loadTexture(SegmentGLThread.this.mTempTexId[0], access$2100);
                    SegmentGLThread.this.expFilter.updateParam((float) SegmentGLThread.this.mSegFrame.width, (float) SegmentGLThread.this.mSegFrame.height, access$1500, access$1600);
                    SegmentGLThread.this.expFilter.RenderProcess(SegmentGLThread.this.mTempTexId[0], SegmentGLThread.this.mSegFrame.width, SegmentGLThread.this.mSegFrame.height, -1, 0.0d, freeTexturePileMakeBusy.mMaskFrame);
                } else if (FabbyManager.getInstance().segmentOnTexture(SegmentGLThread.this.mSegFrame.texture[0], freeTexturePileMakeBusy.mMaskFrame.texture[0], SegmentGLThread.this.mSegFrame.width, SegmentGLThread.this.mSegFrame.height, false, access$1500, access$1600) != 0) {
                    SegmentGLThread.this.mRunOnCpuForce = true;
                }
                freeTexturePileMakeBusy.makeDataReady();
                SegmentGLThread.this.sharedData.makeBrotherTextureFree(freeTexturePileMakeBusy);
                SegmentGLThread.this.mListener.onDataReady(freeTexturePileMakeBusy);
                BenchUtil.benchEnd("[showPreview][FABBY] segment");
                AppMethodBeat.m2505o(83774);
            }
        });
        AppMethodBeat.m2505o(83780);
    }

    public SegmentDataPipe getCurrentDataPipe() {
        AppMethodBeat.m2504i(83781);
        if (this.sharedData == null) {
            AppMethodBeat.m2505o(83781);
            return null;
        }
        SegmentDataPipe currentTexturePile = this.sharedData.getCurrentTexturePile();
        AppMethodBeat.m2505o(83781);
        return currentTexturePile;
    }

    public void destroy() {
        AppMethodBeat.m2504i(83782);
        if (this.mHandler != null) {
            this.mHandler.post(new C163643());
        }
        AppMethodBeat.m2505o(83782);
    }

    public boolean needWait() {
        AppMethodBeat.m2504i(83783);
        if (this.sharedData == null) {
            AppMethodBeat.m2505o(83783);
            return true;
        }
        for (SegmentDataPipe segmentDataPipe : this.sharedData.mTexturePile) {
            if (segmentDataPipe.isBusy() || segmentDataPipe.isReady()) {
                AppMethodBeat.m2505o(83783);
                return true;
            }
        }
        AppMethodBeat.m2505o(83783);
        return false;
    }

    private void setAllRenderMode(int i) {
        AppMethodBeat.m2504i(83784);
        this.fabbyExtractFilter.setRenderMode(i);
        this.fabbyStrokeFilter.setRenderMode(i);
        this.expFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(83784);
    }

    public void reset() {
        AppMethodBeat.m2504i(83785);
        if (this.mHandler != null) {
            this.mHandler.post(new C163594());
        }
        AppMethodBeat.m2505o(83785);
    }

    public void initSegLig() {
        AppMethodBeat.m2504i(83786);
        if (this.mHandler != null) {
            this.mHandler.post(new C163615());
        }
        AppMethodBeat.m2505o(83786);
    }

    public void clearSegLig() {
        AppMethodBeat.m2504i(83787);
        if (this.mHandler != null) {
            this.mHandler.post(new C163606());
        }
        AppMethodBeat.m2505o(83787);
    }
}
