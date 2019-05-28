package com.tencent.ttpic.util.youtu.bodydetector;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.thread.FaceGestureDetGLThread.OnBodyDetListener;
import com.tencent.ttpic.util.BenchUtil;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BodyDetector {
    private static int[] leftIndex = new int[]{13, 14, 15, 16, 17};
    private static BodyDetector mInstance;
    private static int[] rightIndex = new int[]{41, 42, 43, 44, 45};
    private final int DETECT_INTERVAL = 10;
    private final int KEY_POINT_NUM_17 = 17;
    private final int KEY_POINT_NUM_59 = 59;
    boolean bodyDetected = false;
    private final Object dataLock = new Object();
    private Handler detectHandler;
    private int detectIndex = 0;
    private float[] detector_confidence = new float[59];
    private float[] detector_xmax = new float[59];
    private float[] detector_xmin = new float[59];
    private float[] detector_ymax = new float[59];
    private float[] detector_ymin = new float[59];
    private float[] fscore = new float[59];
    private float[] fscore17 = new float[17];
    private volatile boolean inited = false;
    private boolean mHasRect = false;
    private float mPConfidence;
    private float mPxmax;
    private float mPxmin;
    private float mPymax;
    private float mPymin;
    private float[] ptX = new float[59];
    private float[] ptX17 = new float[17];
    private float[] ptY = new float[59];
    private float[] ptY17 = new float[17];

    public native boolean nativeBodyDetect(byte[] bArr, int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, int[] iArr);

    public native boolean nativeBodyKeypoint(byte[] bArr, int i, int i2, int i3, int i4, float f, float f2, float f3, float f4, float f5, float[] fArr, float[] fArr2, float[] fArr3);

    public native boolean nativeDestroy();

    public native boolean nativeDetectBody(byte[] bArr, int i, int i2, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6, int i3, int i4, int i5);

    public native boolean nativeInit(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8);

    public BodyDetector() {
        AppMethodBeat.i(84420);
        AppMethodBeat.o(84420);
    }

    static /* synthetic */ void access$1800(BodyDetector bodyDetector, float[] fArr, float[] fArr2) {
        AppMethodBeat.i(84426);
        bodyDetector.updatePreviousRect(fArr, fArr2);
        AppMethodBeat.o(84426);
    }

    static {
        AppMethodBeat.i(84427);
        if (FeatureManager.isBodyDetectionReady()) {
            try {
                if (VERSION.SDK_INT <= 17) {
                    System.load("/data/data/com.tencent.xnet/lib/libxnet.so");
                } else {
                    FeatureManager.loadLibrary("xnet");
                }
                FeatureManager.loadLibrary("bodydetector");
                AppMethodBeat.o(84427);
                return;
            } catch (Exception e) {
                LogUtils.e(e);
            }
        }
        AppMethodBeat.o(84427);
    }

    public static synchronized BodyDetector getInstance() {
        BodyDetector bodyDetector;
        synchronized (BodyDetector.class) {
            AppMethodBeat.i(84421);
            if (mInstance == null) {
                mInstance = new BodyDetector();
            }
            bodyDetector = mInstance;
            AppMethodBeat.o(84421);
        }
        return bodyDetector;
    }

    public void init() {
        Throwable e;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        HandlerThread handlerThread;
        AppMethodBeat.i(84422);
        if (!FeatureManager.isBodyDetectionReady() || this.inited) {
            AppMethodBeat.o(84422);
            return;
        }
        InputStream modelStream;
        byte[] bArr7;
        try {
            modelStream = FeatureManager.getModelStream("xnet_keypoint1.param.bin.xd");
            bArr7 = new byte[modelStream.available()];
            try {
                modelStream.read(bArr7);
                modelStream.close();
            } catch (Exception e2) {
                e = e2;
                LogUtils.e(e);
                modelStream = FeatureManager.getModelStream("xnet_keypoint1.bin.xd");
                bArr = new byte[modelStream.available()];
                modelStream.read(bArr);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("xnet_keypoint2.param.bin.xd");
                bArr2 = new byte[modelStream.available()];
                modelStream.read(bArr2);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
                bArr3 = new byte[modelStream.available()];
                modelStream.read(bArr3);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("label.txt");
                bArr4 = new byte[modelStream.available()];
                try {
                    modelStream.read(bArr4);
                    modelStream.close();
                    bArr5 = bArr4;
                } catch (Exception e3) {
                    e = e3;
                    LogUtils.e(e);
                    bArr5 = bArr4;
                    modelStream = FeatureManager.getModelStream("threshold.txt");
                    bArr6 = new byte[modelStream.available()];
                    modelStream.read(bArr6);
                    modelStream.close();
                    handlerThread = new HandlerThread("BodyDetectThread");
                    handlerThread.start();
                    this.detectHandler = new Handler(handlerThread.getLooper());
                    this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                    AppMethodBeat.o(84422);
                }
                modelStream = FeatureManager.getModelStream("threshold.txt");
                bArr6 = new byte[modelStream.available()];
                modelStream.read(bArr6);
                modelStream.close();
                handlerThread = new HandlerThread("BodyDetectThread");
                handlerThread.start();
                this.detectHandler = new Handler(handlerThread.getLooper());
                this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                AppMethodBeat.o(84422);
            }
        } catch (Exception e4) {
            e = e4;
            bArr7 = null;
            LogUtils.e(e);
            modelStream = FeatureManager.getModelStream("xnet_keypoint1.bin.xd");
            bArr = new byte[modelStream.available()];
            modelStream.read(bArr);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.param.bin.xd");
            bArr2 = new byte[modelStream.available()];
            modelStream.read(bArr2);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
            bArr3 = new byte[modelStream.available()];
            modelStream.read(bArr3);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("label.txt");
            bArr4 = new byte[modelStream.available()];
            modelStream.read(bArr4);
            modelStream.close();
            bArr5 = bArr4;
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            modelStream.read(bArr6);
            modelStream.close();
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        try {
            modelStream = FeatureManager.getModelStream("xnet_keypoint1.bin.xd");
            bArr = new byte[modelStream.available()];
            try {
                modelStream.read(bArr);
                modelStream.close();
            } catch (Exception e5) {
                e = e5;
                LogUtils.e(e);
                modelStream = FeatureManager.getModelStream("xnet_keypoint2.param.bin.xd");
                bArr2 = new byte[modelStream.available()];
                modelStream.read(bArr2);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
                bArr3 = new byte[modelStream.available()];
                modelStream.read(bArr3);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("label.txt");
                bArr4 = new byte[modelStream.available()];
                modelStream.read(bArr4);
                modelStream.close();
                bArr5 = bArr4;
                modelStream = FeatureManager.getModelStream("threshold.txt");
                bArr6 = new byte[modelStream.available()];
                modelStream.read(bArr6);
                modelStream.close();
                handlerThread = new HandlerThread("BodyDetectThread");
                handlerThread.start();
                this.detectHandler = new Handler(handlerThread.getLooper());
                this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                AppMethodBeat.o(84422);
            }
        } catch (Exception e6) {
            e = e6;
            bArr = null;
            LogUtils.e(e);
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.param.bin.xd");
            bArr2 = new byte[modelStream.available()];
            modelStream.read(bArr2);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
            bArr3 = new byte[modelStream.available()];
            modelStream.read(bArr3);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("label.txt");
            bArr4 = new byte[modelStream.available()];
            modelStream.read(bArr4);
            modelStream.close();
            bArr5 = bArr4;
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            modelStream.read(bArr6);
            modelStream.close();
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        try {
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.param.bin.xd");
            bArr2 = new byte[modelStream.available()];
            try {
                modelStream.read(bArr2);
                modelStream.close();
            } catch (Exception e7) {
                e = e7;
                LogUtils.e(e);
                modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
                bArr3 = new byte[modelStream.available()];
                modelStream.read(bArr3);
                modelStream.close();
                modelStream = FeatureManager.getModelStream("label.txt");
                bArr4 = new byte[modelStream.available()];
                modelStream.read(bArr4);
                modelStream.close();
                bArr5 = bArr4;
                modelStream = FeatureManager.getModelStream("threshold.txt");
                bArr6 = new byte[modelStream.available()];
                modelStream.read(bArr6);
                modelStream.close();
                handlerThread = new HandlerThread("BodyDetectThread");
                handlerThread.start();
                this.detectHandler = new Handler(handlerThread.getLooper());
                this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                AppMethodBeat.o(84422);
            }
        } catch (Exception e8) {
            e = e8;
            bArr2 = null;
            LogUtils.e(e);
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
            bArr3 = new byte[modelStream.available()];
            modelStream.read(bArr3);
            modelStream.close();
            modelStream = FeatureManager.getModelStream("label.txt");
            bArr4 = new byte[modelStream.available()];
            modelStream.read(bArr4);
            modelStream.close();
            bArr5 = bArr4;
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            modelStream.read(bArr6);
            modelStream.close();
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        try {
            modelStream = FeatureManager.getModelStream("xnet_keypoint2.bin.xd");
            bArr3 = new byte[modelStream.available()];
            try {
                modelStream.read(bArr3);
                modelStream.close();
            } catch (Exception e9) {
                e = e9;
                LogUtils.e(e);
                modelStream = FeatureManager.getModelStream("label.txt");
                bArr4 = new byte[modelStream.available()];
                modelStream.read(bArr4);
                modelStream.close();
                bArr5 = bArr4;
                modelStream = FeatureManager.getModelStream("threshold.txt");
                bArr6 = new byte[modelStream.available()];
                modelStream.read(bArr6);
                modelStream.close();
                handlerThread = new HandlerThread("BodyDetectThread");
                handlerThread.start();
                this.detectHandler = new Handler(handlerThread.getLooper());
                this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                AppMethodBeat.o(84422);
            }
        } catch (Exception e10) {
            e = e10;
            bArr3 = null;
            LogUtils.e(e);
            modelStream = FeatureManager.getModelStream("label.txt");
            bArr4 = new byte[modelStream.available()];
            modelStream.read(bArr4);
            modelStream.close();
            bArr5 = bArr4;
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            modelStream.read(bArr6);
            modelStream.close();
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        try {
            modelStream = FeatureManager.getModelStream("label.txt");
            bArr4 = new byte[modelStream.available()];
            modelStream.read(bArr4);
            modelStream.close();
            bArr5 = bArr4;
        } catch (Exception e11) {
            e = e11;
            bArr4 = null;
            LogUtils.e(e);
            bArr5 = bArr4;
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            modelStream.read(bArr6);
            modelStream.close();
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        try {
            modelStream = FeatureManager.getModelStream("threshold.txt");
            bArr6 = new byte[modelStream.available()];
            try {
                modelStream.read(bArr6);
                modelStream.close();
            } catch (Exception e12) {
                e = e12;
                LogUtils.e(e);
                handlerThread = new HandlerThread("BodyDetectThread");
                handlerThread.start();
                this.detectHandler = new Handler(handlerThread.getLooper());
                this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
                AppMethodBeat.o(84422);
            }
        } catch (Exception e13) {
            e = e13;
            bArr6 = null;
            LogUtils.e(e);
            handlerThread = new HandlerThread("BodyDetectThread");
            handlerThread.start();
            this.detectHandler = new Handler(handlerThread.getLooper());
            this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
            AppMethodBeat.o(84422);
        }
        handlerThread = new HandlerThread("BodyDetectThread");
        handlerThread.start();
        this.detectHandler = new Handler(handlerThread.getLooper());
        this.inited = nativeInit(bArr7, bArr, bArr2, bArr3, null, null, bArr5, bArr6);
        AppMethodBeat.o(84422);
    }

    public void destroy() {
        AppMethodBeat.i(84423);
        if (this.inited) {
            nativeDestroy();
            this.inited = false;
        }
        if (this.detectHandler != null) {
            this.detectHandler.getLooper().quit();
        }
        AppMethodBeat.o(84423);
    }

    public boolean isInited() {
        return this.inited;
    }

    public void reset() {
        this.detectIndex = 0;
        this.bodyDetected = false;
    }

    public List<BodyDetectResult> detectBody(final byte[] bArr, final int i, final int i2) {
        AppMethodBeat.i(84424);
        List<BodyDetectResult> arrayList = new ArrayList();
        if (this.inited) {
            if (this.detectIndex % 10 == 0) {
                this.detectHandler.post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(84418);
                        float[] fArr = new float[59];
                        float[] fArr2 = new float[59];
                        float[] fArr3 = new float[59];
                        BodyDetector.this.nativeDetectBody(bArr, i, i2, fArr, fArr2, fArr3, BodyDetector.this.ptX17, BodyDetector.this.ptY17, BodyDetector.this.fscore17, 59, 17, 2);
                        synchronized (BodyDetector.this.dataLock) {
                            try {
                                System.arraycopy(fArr, 0, BodyDetector.this.ptX, 0, 59);
                                System.arraycopy(fArr2, 0, BodyDetector.this.ptY, 0, 59);
                                System.arraycopy(fArr3, 0, BodyDetector.this.fscore, 0, 59);
                                BodyDetector bodyDetector = BodyDetector.this;
                                boolean z = (((double) BodyDetector.this.fscore[15]) > 0.2d && ((double) BodyDetector.this.fscore[20]) > 0.2d) || (((double) BodyDetector.this.fscore[43]) > 0.2d && ((double) BodyDetector.this.fscore[31]) > 0.2d);
                                bodyDetector.bodyDetected = z;
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(84418);
                            }
                        }
                    }
                });
            }
            synchronized (this.dataLock) {
                try {
                    if (this.bodyDetected) {
                        BodyDetectResult bodyDetectResult = new BodyDetectResult();
                        bodyDetectResult.bodyPoints = new ArrayList();
                        bodyDetectResult.bodyPointScores = new ArrayList();
                        for (int i3 = 0; i3 < 59; i3++) {
                            bodyDetectResult.bodyPoints.add(new PointF(this.ptX[i3], this.ptY[i3]));
                            bodyDetectResult.bodyPointScores.add(Float.valueOf(this.fscore[i3]));
                        }
                        arrayList.add(bodyDetectResult);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(84424);
                }
            }
            this.detectIndex++;
        } else {
            AppMethodBeat.o(84424);
        }
        return arrayList;
    }

    public void detectBody(OnBodyDetListener onBodyDetListener, byte[] bArr, int i, int i2) {
        AppMethodBeat.i(84425);
        if (this.inited) {
            final byte[] bArr2 = bArr;
            final int i3 = i;
            final int i4 = i2;
            final OnBodyDetListener onBodyDetListener2 = onBodyDetListener;
            this.detectHandler.post(new Runnable() {
                public void run() {
                    long currentTimeMillis;
                    int i;
                    AppMethodBeat.i(84419);
                    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                        currentTimeMillis = System.currentTimeMillis();
                    } else {
                        currentTimeMillis = 0;
                    }
                    ArrayList arrayList = new ArrayList();
                    int[] iArr = new int[]{0};
                    if (!BodyDetector.this.mHasRect) {
                        if (BodyDetector.this.nativeBodyDetect(bArr2, i3, i4, 2, BodyDetector.this.detector_xmin, BodyDetector.this.detector_ymin, BodyDetector.this.detector_xmax, BodyDetector.this.detector_ymax, BodyDetector.this.detector_confidence, iArr)) {
                            float f = 0.0f;
                            float f2 = 0.0f;
                            float f3 = 0.0f;
                            float f4 = 0.0f;
                            float f5 = 0.0f;
                            for (i = 0; i < iArr[0]; i++) {
                                if (f5 < BodyDetector.this.detector_confidence[i]) {
                                    f5 = BodyDetector.this.detector_confidence[i];
                                    f = BodyDetector.this.detector_xmin[i];
                                    f2 = BodyDetector.this.detector_ymin[i];
                                    f3 = BodyDetector.this.detector_xmax[i];
                                    f4 = BodyDetector.this.detector_ymax[i];
                                }
                            }
                            if (iArr[0] <= 0 || ((double) f5) <= 0.7d) {
                                BodyDetector.this.mHasRect = false;
                            } else {
                                BodyDetector.this.mPxmin = f;
                                BodyDetector.this.mPymin = f2;
                                BodyDetector.this.mPxmax = f3;
                                BodyDetector.this.mPymax = f4;
                                BodyDetector.this.mPConfidence = f5;
                                BodyDetector.this.mHasRect = true;
                            }
                        } else {
                            BodyDetector.this.mHasRect = false;
                        }
                    }
                    if (BodyDetector.this.mHasRect && BodyDetector.this.nativeBodyKeypoint(bArr2, i3, i4, 59, 2, BodyDetector.this.mPxmin, BodyDetector.this.mPymin, BodyDetector.this.mPxmax, BodyDetector.this.mPymax, BodyDetector.this.mPConfidence, BodyDetector.this.ptX, BodyDetector.this.ptY, BodyDetector.this.fscore)) {
                        BodyDetector bodyDetector = BodyDetector.this;
                        boolean z = (((double) BodyDetector.this.fscore[17]) > 0.7d && ((double) BodyDetector.this.fscore[15]) > 0.7d) || (((double) BodyDetector.this.fscore[43]) > 0.7d && ((double) BodyDetector.this.fscore[41]) > 0.7d);
                        bodyDetector.bodyDetected = z;
                        if (BodyDetector.this.bodyDetected) {
                            BodyDetector.this.mHasRect = true;
                            BodyDetector.access$1800(BodyDetector.this, BodyDetector.this.ptX, BodyDetector.this.ptY);
                            BodyDetectResult bodyDetectResult = new BodyDetectResult();
                            bodyDetectResult.bodyPoints = new ArrayList();
                            bodyDetectResult.bodyPointScores = new ArrayList();
                            for (i = 0; i < 59; i++) {
                                bodyDetectResult.bodyPoints.add(new PointF(BodyDetector.this.ptX[i], BodyDetector.this.ptY[i]));
                                bodyDetectResult.bodyPointScores.add(Float.valueOf(BodyDetector.this.fscore[i]));
                            }
                            arrayList.add(bodyDetectResult);
                        } else {
                            BodyDetector.this.mHasRect = false;
                        }
                    }
                    onBodyDetListener2.onBodyDataReady(arrayList);
                    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                        new StringBuilder("人体检测耗时： ").append(System.currentTimeMillis() - currentTimeMillis).append(" ms.");
                    }
                    AppMethodBeat.o(84419);
                }
            });
            AppMethodBeat.o(84425);
            return;
        }
        onBodyDetListener.onBodyDataReady(new ArrayList());
        AppMethodBeat.o(84425);
    }

    private void updatePreviousRect(float[] fArr, float[] fArr2) {
        float f;
        int length = leftIndex.length;
        int i = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i < length) {
            f = ((fArr[rightIndex[i]] + fArr[leftIndex[i]]) / 2.0f) + f3;
            f2 += (fArr2[rightIndex[i]] + fArr2[leftIndex[i]]) / 2.0f;
            f4 += fArr[rightIndex[i]] - fArr[leftIndex[i]];
            i++;
            f3 = f;
        }
        float f5 = f3 / ((float) length);
        f2 /= (float) length;
        f = (float) (((double) (f4 / ((float) length))) * 1.5d);
        f3 = 4.0f * f;
        this.mPxmin = f5 - (f / 2.0f);
        this.mPxmax = f5 + (f / 2.0f);
        this.mPymin = f2 - (f3 / 2.0f);
        this.mPymax = (f3 / 2.0f) + f2;
    }
}
