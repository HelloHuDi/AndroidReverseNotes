package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TargetApi(18)
public class FaceGestureDetGLThread {
    public static final long BRIGHTNESS_DURATION = 2000;
    private ExecutorService SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();
    private double averageFaceL;
    private int[] brightnessAdjustmentCurve;
    private byte[] brightnessAdjustmentData;
    private int curLevel;
    private int[] his;
    private final Object mBodyDetLock = new Object();
    private List<BodyDetectResult> mBodyDetectResults;
    private OnBodyDetListener mBodyListener = new OnBodyDetListener() {
        public void onBodyDataReady(List<BodyDetectResult> list) {
            AppMethodBeat.i(83746);
            FaceGestureDetGLThread.access$700(FaceGestureDetGLThread.this, list);
            AppMethodBeat.o(83746);
        }
    };
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h mCopyFrame;
    private EglCore mCore;
    private VideoPreviewFaceOutlineDetector mFaceDetector = new VideoPreviewFaceOutlineDetector();
    private GestureDetector mGestureDetector = GestureDetector.getInstance();
    private Handler mHandler;
    private boolean mInitReady;
    private long mLastBrightnessTime = -1;
    private OnFaceDetListener mListener;
    private OffscreenSurface mOffscreenSurface;
    private GLSegSharedData sharedData;

    public interface OnFaceDetListener {
        void onDataReady(SegmentDataPipe segmentDataPipe);
    }

    public interface OnBodyDetListener {
        void onBodyDataReady(List<BodyDetectResult> list);
    }

    static /* synthetic */ void access$1200(FaceGestureDetGLThread faceGestureDetGLThread, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(83770);
        faceGestureDetGLThread.switchBrightnessAdjustment(bArr, i, i2);
        AppMethodBeat.o(83770);
    }

    static /* synthetic */ Pair access$1500(FaceGestureDetGLThread faceGestureDetGLThread, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(83771);
        Pair histogram = faceGestureDetGLThread.getHistogram(bArr, i, i2);
        AppMethodBeat.o(83771);
        return histogram;
    }

    static /* synthetic */ void access$1800(FaceGestureDetGLThread faceGestureDetGLThread, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        AppMethodBeat.i(83772);
        faceGestureDetGLThread.createBrightnessCurve(i, i2, i3, i4, i5, i6, bArr);
        AppMethodBeat.o(83772);
    }

    static /* synthetic */ void access$700(FaceGestureDetGLThread faceGestureDetGLThread, List list) {
        AppMethodBeat.i(83769);
        faceGestureDetGLThread.setBodyResult(list);
        AppMethodBeat.o(83769);
    }

    public FaceGestureDetGLThread(final EGLContext eGLContext) {
        AppMethodBeat.i(83753);
        HandlerThread handlerThread = new HandlerThread("FaceGestureDetGLThread" + ((int) (Math.random() * 100.0d)));
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(83745);
                FaceGestureDetGLThread.this.mCore = new EglCore(eGLContext, 0);
                FaceGestureDetGLThread.this.mOffscreenSurface = new OffscreenSurface(FaceGestureDetGLThread.this.mCore, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
                FaceGestureDetGLThread.this.mOffscreenSurface.makeCurrent();
                FaceGestureDetGLThread.this.mCopyFilter.ApplyGLSLFilter();
                FaceGestureDetGLThread.this.sharedData = new GLSegSharedData(eGLContext);
                FaceGestureDetGLThread.this.mCopyFrame = new h();
                if (FaceGestureDetGLThread.this.mFaceDetector.init() != 0) {
                    FaceGestureDetGLThread.this.mInitReady = false;
                    AppMethodBeat.o(83745);
                    return;
                }
                FaceGestureDetGLThread.this.mInitReady = true;
                AppMethodBeat.o(83745);
            }
        });
        AppMethodBeat.o(83753);
    }

    public VideoPreviewFaceOutlineDetector getDetector() {
        return this.mFaceDetector;
    }

    public void setOnFaceDetListener(OnFaceDetListener onFaceDetListener) {
        this.mListener = onFaceDetListener;
    }

    public boolean isInitReady() {
        return this.mInitReady;
    }

    public void postFaceGestureDet(h hVar, boolean z, boolean z2, boolean z3, double d) {
        AppMethodBeat.i(83754);
        postFaceGestureDet(hVar, z, z2, z3, d, false);
        AppMethodBeat.o(83754);
    }

    public void postFaceGestureDet(h hVar, boolean z, boolean z2, boolean z3, double d, boolean z4) {
        AppMethodBeat.i(83755);
        if (this.mHandler == null) {
            AppMethodBeat.o(83755);
            return;
        }
        final h hVar2 = hVar;
        final double d2 = d;
        final boolean z5 = z;
        final boolean z6 = z4;
        final boolean z7 = z2;
        final boolean z8 = z3;
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(83747);
                long j = 0;
                if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                    j = System.currentTimeMillis();
                }
                if (FaceGestureDetGLThread.this.mListener == null) {
                    AppMethodBeat.o(83747);
                    return;
                }
                SegmentDataPipe freeTexturePileMakeBusy = FaceGestureDetGLThread.this.sharedData.getFreeTexturePileMakeBusy();
                if (freeTexturePileMakeBusy == null) {
                    AppMethodBeat.o(83747);
                    return;
                }
                freeTexturePileMakeBusy.mTimestamp = System.currentTimeMillis();
                int i = (int) (((double) hVar2.width) * d2);
                int i2 = (int) (((double) hVar2.height) * d2);
                freeTexturePileMakeBusy.mTexFrame = hVar2;
                byte[] retrieveData = RetrieveDataManager.getInstance().retrieveData(DATA_TYPE.RGBA.value, hVar2.texture[0], i, i2);
                if (retrieveData != null) {
                    try {
                        if (freeTexturePileMakeBusy.mData == null || freeTexturePileMakeBusy.mData.length != retrieveData.length) {
                            freeTexturePileMakeBusy.mData = new byte[retrieveData.length];
                        }
                        System.arraycopy(retrieveData, 0, freeTexturePileMakeBusy.mData, 0, retrieveData.length);
                    } catch (OutOfMemoryError e) {
                    }
                }
                FaceGestureDetGLThread.this.mFaceDetector.clear();
                if (z5) {
                    FaceGestureDetGLThread.this.mFaceDetector.clearSavedTriggeredExpression();
                    FaceGestureDetGLThread.this.mFaceDetector.init();
                    if (z6) {
                        FaceGestureDetGLThread.this.mFaceDetector.doDectectTrackByRGBA(freeTexturePileMakeBusy.mData, i, i2);
                    } else {
                        FaceGestureDetGLThread.this.mFaceDetector.doTrackByRGBA(freeTexturePileMakeBusy.mData, i, i2);
                    }
                }
                if (z7) {
                    GestureDetector.getInstance().init();
                    GestureDetector.getInstance().detectHand(freeTexturePileMakeBusy.mData, i, i2);
                }
                List arrayList = new ArrayList();
                if (z8 && BodyDetector.getInstance().isInited()) {
                    synchronized (FaceGestureDetGLThread.this.mBodyDetLock) {
                        while (FaceGestureDetGLThread.this.mBodyDetectResults == null) {
                            try {
                                FaceGestureDetGLThread.this.mBodyDetLock.wait();
                            } catch (InterruptedException e2) {
                            }
                        }
                        try {
                            arrayList = FaceGestureDetGLThread.this.mBodyDetectResults;
                            FaceGestureDetGLThread.this.mBodyDetectResults = null;
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(83747);
                            }
                        }
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (FaceGestureDetGLThread.this.mLastBrightnessTime <= 0) {
                    FaceGestureDetGLThread.this.mLastBrightnessTime = (currentTimeMillis - FaceGestureDetGLThread.BRIGHTNESS_DURATION) + FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                } else if (currentTimeMillis - FaceGestureDetGLThread.this.mLastBrightnessTime >= FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    FaceGestureDetGLThread.access$1200(FaceGestureDetGLThread.this, retrieveData, i, i2);
                    FaceGestureDetGLThread.this.mLastBrightnessTime = currentTimeMillis;
                }
                freeTexturePileMakeBusy.allFacePoints = FaceGestureDetGLThread.this.mFaceDetector.getAllFaces();
                freeTexturePileMakeBusy.allIrisPoints = FaceGestureDetGLThread.this.mFaceDetector.getAllIris();
                freeTexturePileMakeBusy.allFaceAngles = FaceGestureDetGLThread.this.mFaceDetector.getAllFaceAngles();
                freeTexturePileMakeBusy.mTriggeredExpressionType = FaceGestureDetGLThread.this.mFaceDetector.getTriggeredExpression();
                freeTexturePileMakeBusy.allHandPoints = FaceGestureDetGLThread.this.mGestureDetector.getHandPoints();
                freeTexturePileMakeBusy.allHandAngles = FaceGestureDetGLThread.this.mGestureDetector.getHandAngles();
                freeTexturePileMakeBusy.bodyDetectResults = arrayList;
                freeTexturePileMakeBusy.faceStatus = FaceGestureDetGLThread.this.mFaceDetector.getFaceStatus3Ds();
                freeTexturePileMakeBusy.brightnessAdjustmentCurve = FaceGestureDetGLThread.this.brightnessAdjustmentCurve;
                freeTexturePileMakeBusy.faceActionCounter = FaceGestureDetGLThread.this.mFaceDetector.getFaceActionCounter();
                freeTexturePileMakeBusy.histogram = FaceGestureDetGLThread.access$1500(FaceGestureDetGLThread.this, retrieveData, i, i2);
                freeTexturePileMakeBusy.makeDataReady();
                FaceGestureDetGLThread.this.sharedData.makeBrotherTextureFree(freeTexturePileMakeBusy);
                FaceGestureDetGLThread.this.mListener.onDataReady(freeTexturePileMakeBusy);
                if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                    new StringBuilder("人脸人体检测耗时： ").append(System.currentTimeMillis() - j).append(" ms.");
                }
                AppMethodBeat.o(83747);
            }
        });
        AppMethodBeat.o(83755);
    }

    public void postFaceDetectorDestroy() {
        AppMethodBeat.i(83756);
        if (this.mHandler == null) {
            AppMethodBeat.o(83756);
            return;
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(83748);
                BodyDetector.getInstance().destroy();
                GestureDetector.getInstance().destroy();
                FaceGestureDetGLThread.this.mFaceDetector.clear();
                FaceGestureDetGLThread.this.mFaceDetector.destroy();
                AppMethodBeat.o(83748);
            }
        });
        AppMethodBeat.o(83756);
    }

    private void setBodyResult(List<BodyDetectResult> list) {
        AppMethodBeat.i(83757);
        synchronized (this.mBodyDetLock) {
            try {
                this.mBodyDetectResults = list;
                this.mBodyDetLock.notifyAll();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(83757);
            }
        }
    }

    public void resetBodyDetector() {
        AppMethodBeat.i(83758);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(83749);
                    BodyDetector.getInstance().reset();
                    AppMethodBeat.o(83749);
                }
            });
        }
        AppMethodBeat.o(83758);
    }

    public void destroy() {
        AppMethodBeat.i(83759);
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(83750);
                    FaceGestureDetGLThread.this.sharedData.clear();
                    FaceGestureDetGLThread.this.mCopyFrame.clear();
                    FaceGestureDetGLThread.this.mCopyFilter.ClearGLSL();
                    FaceGestureDetGLThread.this.mOffscreenSurface.release();
                    FaceGestureDetGLThread.this.mCore.release();
                    FaceGestureDetGLThread.this.mHandler.getLooper().quit();
                    AppMethodBeat.o(83750);
                }
            });
        }
        this.SINGLE_THREAD_EXECUTOR.shutdownNow();
        AppMethodBeat.o(83759);
    }

    public boolean needWait() {
        AppMethodBeat.i(83760);
        if (this.sharedData == null) {
            AppMethodBeat.o(83760);
            return true;
        }
        for (SegmentDataPipe segmentDataPipe : this.sharedData.mTexturePile) {
            if (segmentDataPipe.isBusy() || segmentDataPipe.isReady()) {
                AppMethodBeat.o(83760);
                return true;
            }
        }
        AppMethodBeat.o(83760);
        return false;
    }

    public void postUpdateParams(VideoFilterList videoFilterList) {
        AppMethodBeat.i(83761);
        if (this.mHandler == null) {
            AppMethodBeat.o(83761);
            return;
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(83751);
                if (FaceGestureDetGLThread.this.mListener == null) {
                    AppMethodBeat.o(83751);
                    return;
                }
                SegmentDataPipe freeTexturePileMakeBusy = FaceGestureDetGLThread.this.sharedData.getFreeTexturePileMakeBusy();
                if (freeTexturePileMakeBusy == null) {
                    AppMethodBeat.o(83751);
                    return;
                }
                freeTexturePileMakeBusy.mTimestamp = System.currentTimeMillis();
                freeTexturePileMakeBusy.makeDataReady();
                FaceGestureDetGLThread.this.sharedData.makeBrotherTextureFree(freeTexturePileMakeBusy);
                FaceGestureDetGLThread.this.mListener.onDataReady(freeTexturePileMakeBusy);
                AppMethodBeat.o(83751);
            }
        });
        AppMethodBeat.o(83761);
    }

    private void switchDenoise(byte[] bArr) {
        int i = 0;
        if (bArr != null) {
            int i2;
            if (this.his == null) {
                this.his = new int[256];
            } else {
                for (i2 = 0; i2 < 256; i2++) {
                    this.his[i2] = 0;
                }
            }
            int length = bArr.length;
            for (i2 = 0; i2 < length; i2 += 4) {
                if (i2 + 2 < length) {
                    float f = ((((float) (bArr[i2] & 255)) * 0.3f) + (((float) (bArr[i2 + 1] & 255)) * 0.6f)) + (0.1f * ((float) (bArr[i2 + 2] & 255)));
                    int[] iArr = this.his;
                    int i3 = (int) f;
                    iArr[i3] = iArr[i3] + 1;
                }
            }
            length = 0;
            for (i2 = 0; i2 < 256; i2++) {
                length += this.his[i2];
            }
            length = (int) (((float) length) * 0.03f);
            i2 = 255;
            while (i2 >= 0) {
                i += this.his[i2];
                if (i >= length) {
                    break;
                }
                i2--;
            }
            this.curLevel = i2;
        }
    }

    private void switchBrightnessAdjustment(byte[] bArr, final int i, final int i2) {
        AppMethodBeat.i(83762);
        if (bArr == null) {
            AppMethodBeat.o(83762);
            return;
        }
        if (this.brightnessAdjustmentData == null || this.brightnessAdjustmentData.length != bArr.length) {
            this.brightnessAdjustmentData = new byte[bArr.length];
        }
        System.arraycopy(bArr, 0, this.brightnessAdjustmentData, 0, bArr.length);
        if (this.SINGLE_THREAD_EXECUTOR.isShutdown() || this.SINGLE_THREAD_EXECUTOR.isTerminated()) {
            AppMethodBeat.o(83762);
            return;
        }
        this.SINGLE_THREAD_EXECUTOR.execute(new Runnable() {
            public void run() {
                AppMethodBeat.i(83752);
                List allFaces = FaceGestureDetGLThread.this.mFaceDetector.getAllFaces();
                if (allFaces != null && allFaces.size() > 0 && ((List) allFaces.get(0)).size() > 0) {
                    ArrayList arrayList = new ArrayList((Collection) allFaces.get(0));
                    FaceGestureDetGLThread.access$1800(FaceGestureDetGLThread.this, (int) ((PointF) arrayList.get(4)).x, (int) ((PointF) arrayList.get(14)).x, (int) ((PointF) arrayList.get(0)).y, (int) ((PointF) arrayList.get(3)).y, i, i2, FaceGestureDetGLThread.this.brightnessAdjustmentData);
                }
                AppMethodBeat.o(83752);
            }
        });
        AppMethodBeat.o(83762);
    }

    private void createBrightnessCurve(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        AppMethodBeat.i(83763);
        double d = 0.0d;
        double d2 = 0.0d;
        while (i <= i2) {
            for (int i7 = i3; i7 <= i4; i7++) {
                int i8 = ((i7 * i5) + i) * 4;
                if (i8 >= 0 && i8 + 2 < bArr.length) {
                    int i9 = bArr[i8] & 255;
                    int i10 = bArr[i8 + 1] & 255;
                    i8 = bArr[i8 + 2] & 255;
                    d += XYZ2Lab(sRGB2XYZ(new double[]{(double) i9, (double) i10, (double) i8}))[0];
                    d2 += 1.0d;
                }
            }
            i++;
        }
        if (d2 != 0.0d) {
            int i11;
            double d3;
            double d4;
            double d5;
            this.averageFaceL = d / d2;
            if (this.averageFaceL < 60.0d) {
                d2 = (1.07d * (60.0d - this.averageFaceL)) + 128.0d;
            } else {
                d2 = (1.0d * (60.0d - this.averageFaceL)) + 128.0d;
            }
            this.brightnessAdjustmentCurve = new int[256];
            d = d2 - 128.0d;
            double[] dArr = new double[]{0.0d, 128.0d, 192.0d, 255.0d};
            double[] dArr2 = new double[]{0.0d, d2, 192.0d + (d / 3.0d), 255.0d};
            double[] dArr3 = new double[]{128.0d, 64.0d, 63.0d};
            double[] dArr4 = new double[]{d2 / 128.0d, ((192.0d + (d / 3.0d)) - d2) / 64.0d, (63.0d - (d / 3.0d)) / 63.0d};
            ArrayList arrayList = new ArrayList();
            arrayList.add(Double.valueOf(dArr4[0]));
            for (i11 = 0; i11 < 2; i11++) {
                d = dArr4[i11];
                d3 = dArr4[i11 + 1];
                if (d * d3 <= 0.0d) {
                    arrayList.add(Double.valueOf(0.0d));
                } else {
                    d4 = dArr3[i11];
                    d5 = dArr3[i11 + 1];
                    double d6 = d4 + d5;
                    arrayList.add(Double.valueOf((3.0d * d6) / (((d5 + d6) / d) + ((d4 + d6) / d3))));
                }
            }
            arrayList.add(Double.valueOf(dArr4[2]));
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            i11 = 0;
            while (true) {
                int i12 = i11;
                if (i12 >= arrayList.size() - 1) {
                    break;
                }
                d = ((Double) arrayList.get(i12)).doubleValue();
                d3 = dArr4[i12];
                d4 = 1.0d / dArr3[i12];
                d5 = ((((Double) arrayList.get(i12 + 1)).doubleValue() + d) - d3) - d3;
                arrayList2.add(Double.valueOf(((d3 - d) - d5) * d4));
                arrayList3.add(Double.valueOf((d5 * d4) * d4));
                i11 = i12 + 1;
            }
            for (i11 = 0; i11 <= 255; i11++) {
                if (i11 == 0) {
                    this.brightnessAdjustmentCurve[0] = 0;
                } else if (i11 == 255) {
                    this.brightnessAdjustmentCurve[255] = 255;
                } else {
                    this.brightnessAdjustmentCurve[i11] = (int) getInterpolateValue((double) i11, dArr, dArr2, arrayList, arrayList2, arrayList3);
                }
            }
        }
        AppMethodBeat.o(83763);
    }

    public String getHistogramInfo() {
        AppMethodBeat.i(83764);
        String str;
        if (this.his == null) {
            str = "";
            AppMethodBeat.o(83764);
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hisLevel: " + this.curLevel + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("averageL: " + ((int) this.averageFaceL) + IOUtils.LINE_SEPARATOR_UNIX);
        str = stringBuffer.toString();
        AppMethodBeat.o(83764);
        return str;
    }

    private double[] sRGB2XYZ(double[] dArr) {
        double d;
        AppMethodBeat.i(83765);
        double[] dArr2 = new double[3];
        double d2 = dArr[0];
        d2 /= 255.0d;
        double d3 = dArr[1] / 255.0d;
        double d4 = dArr[2] / 255.0d;
        if (d2 <= 0.04045d) {
            d = d2 / 12.92d;
        } else {
            d = Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        }
        if (d3 <= 0.04045d) {
            d3 /= 12.92d;
        } else {
            d3 = Math.pow((0.055d + d3) / 1.055d, 2.4d);
        }
        if (d4 <= 0.04045d) {
            d2 = d4 / 12.92d;
        } else {
            d2 = Math.pow((0.055d + d4) / 1.055d, 2.4d);
        }
        dArr2[0] = ((41.24d * d) + (35.76d * d3)) + (18.05d * d2);
        dArr2[1] = ((21.26d * d) + (71.52d * d3)) + (7.2d * d2);
        d2 *= 95.05d;
        dArr2[2] = d2 + ((d3 * 11.92d) + (d * 1.93d));
        AppMethodBeat.o(83765);
        return dArr2;
    }

    private double[] XYZ2Lab(double[] dArr) {
        double pow;
        AppMethodBeat.i(83766);
        double[] dArr2 = new double[3];
        double d = dArr[0];
        d /= 95.04d;
        double d2 = dArr[1] / 100.0d;
        double d3 = dArr[2] / 108.89d;
        if (d > 0.008856d) {
            pow = Math.pow(d, 0.333333d);
        } else {
            pow = (d * 7.787d) + 0.137931d;
        }
        if (d2 > 0.008856d) {
            d2 = Math.pow(d2, 0.333333d);
        } else {
            d2 = (7.787d * d2) + 0.137931d;
        }
        if (d3 > 0.008856d) {
            d = Math.pow(d3, 0.333333d);
        } else {
            d = (7.787d * d3) + 0.137931d;
        }
        dArr2[0] = (116.0d * d2) - 16.0d;
        dArr2[1] = (pow - d2) * 500.0d;
        dArr2[2] = (d2 - d) * 200.0d;
        AppMethodBeat.o(83766);
        return dArr2;
    }

    private double getInterpolateValue(double d, double[] dArr, double[] dArr2, List<Double> list, List<Double> list2, List<Double> list3) {
        AppMethodBeat.i(83767);
        int length = dArr.length - 1;
        double d2;
        if (d == dArr[length]) {
            d2 = dArr2[length];
            AppMethodBeat.o(83767);
            return d2;
        }
        double d3;
        int i = 0;
        length = list3.size() - 1;
        while (i <= length) {
            int floor = (int) Math.floor(0.5d * ((double) (i + length)));
            d3 = dArr[floor];
            if (d3 < d) {
                i = floor + 1;
            } else if (d3 > d) {
                length = floor - 1;
            } else {
                d2 = dArr2[floor];
                AppMethodBeat.o(83767);
                return d2;
            }
        }
        i = Math.max(0, length);
        double d4 = d - dArr[i];
        d3 = d4 * d4;
        d2 = ((((Double) list3.get(i)).doubleValue() * d4) * d3) + ((dArr2[i] + (((Double) list.get(i)).doubleValue() * d4)) + (((Double) list2.get(i)).doubleValue() * d3));
        AppMethodBeat.o(83767);
        return d2;
    }

    private Pair<Integer, int[]> getHistogram(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(83768);
        int[] iArr = new int[256];
        int[] iArr2 = new int[256];
        List allFaces = this.mFaceDetector.getAllFaces();
        Rect rect = new Rect();
        if (allFaces == null || allFaces.size() <= 0 || ((List) allFaces.get(0)).size() <= 0) {
            rect.left = 0;
            rect.right = i;
            rect.top = 0;
            rect.bottom = i2;
        } else {
            ArrayList arrayList = new ArrayList((Collection) allFaces.get(0));
            i3 = (int) ((PointF) arrayList.get(33)).x;
            int i7 = (int) ((PointF) arrayList.get(87)).y;
            i4 = (int) ((PointF) arrayList.get(4)).y;
            rect.left = (int) ((PointF) arrayList.get(25)).x;
            rect.right = i3;
            rect.top = i7;
            rect.bottom = i4;
        }
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 >= i) {
                break;
            }
            i4 = 0;
            while (true) {
                i5 = i4;
                if (i5 >= i2) {
                    break;
                }
                i4 = ((i5 * i) + i3) * 4;
                if (i4 >= 0 && i4 + 2 < bArr.length) {
                    i6 = (int) ((((double) ((float) (bArr[i4 + 2] & 255))) * 0.11d) + ((((double) ((float) (bArr[i4] & 255))) * 0.3d) + (((double) ((float) (bArr[i4 + 1] & 255))) * 0.59d)));
                    i4 = i6 >= 256 ? 255 : i6;
                    iArr2[i4] = iArr2[i4] + 1;
                    if (rect.contains(i3, i5)) {
                        if (i6 >= 256) {
                            i6 = 255;
                        }
                        iArr[i6] = iArr[i6] + 1;
                    }
                }
                i4 = i5 + 1;
            }
            i4 = i3 + 1;
        }
        i3 = 0;
        i5 = 0;
        i4 = 255;
        for (i6 = 0; i6 < 256; i6++) {
            i3 += iArr[i6];
            i5 += iArr[i6] * i6;
        }
        if (i3 > 0) {
            i4 = i5 / i3;
        }
        Pair create = Pair.create(Integer.valueOf(i4), iArr2);
        AppMethodBeat.o(83768);
        return create;
    }

    public Handler getHandler() {
        return this.mHandler;
    }
}
