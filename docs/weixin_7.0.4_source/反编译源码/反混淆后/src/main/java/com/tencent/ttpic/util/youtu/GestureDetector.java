package com.tencent.ttpic.util.youtu;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestureDetector {
    private static final float[] CLASSIFY_THRESHOLD = new float[]{0.95f, 0.6f, 0.6f, 0.7f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f, 0.6f, 0.7f};
    private static final float DETECT_THRESHOLD = 0.9f;
    public static int THREAD_NUM = 2;
    protected static final int TOP_K = 61;
    private static boolean mIS_BUSY = false;
    private static GestureDetector mInstance;
    public final String COLLECT_PATH = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Collect");
    public Bitmap mBitmapCollect;
    protected float[] mClassifyOutputConfidence;
    public FileWriter mCollectInfoOut = null;
    private Handler mDetectHandler;
    private YtHandLabel mDetectedGestureLabel = new YtHandLabel();
    private YtHandBox mDetectedHandBox = new YtHandBox();
    protected float[] mDetectorOutputConfidence;
    protected float[] mDetectorOutputXMax;
    protected float[] mDetectorOutputXMin;
    protected float[] mDetectorOutputYMax;
    protected float[] mDetectorOutputYMin;
    private boolean mEnableInterpolation = true;
    protected final Map<Integer, HandActionCounter> mHandActionCounter = new HashMap();
    private int mImageHeight;
    private int mImageWidth;
    private volatile boolean mInited = false;
    protected int[] mLabelIndex;
    protected boolean mUpdateActionCounter;

    public native boolean Gesture(byte[] bArr, int i, int i2, int i3, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, int[] iArr, int[] iArr2, float[] fArr6);

    public native int Init(String str, String str2, int i);

    public native boolean Uninit();

    public GestureDetector() {
        AppMethodBeat.m2504i(84349);
        AppMethodBeat.m2505o(84349);
    }

    static {
        AppMethodBeat.m2504i(84364);
        if (FeatureManager.isGestureDetectionReady()) {
            try {
                System.loadLibrary("XGestureSDK");
                System.loadLibrary("pt_handdetector");
                AppMethodBeat.m2505o(84364);
                return;
            } catch (UnsatisfiedLinkError e) {
                AppMethodBeat.m2505o(84364);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.m2505o(84364);
    }

    public static synchronized GestureDetector getInstance() {
        GestureDetector gestureDetector;
        synchronized (GestureDetector.class) {
            AppMethodBeat.m2504i(84350);
            if (mInstance == null) {
                mInstance = new GestureDetector();
            }
            if (!mInstance.mInited) {
                mInstance.init();
            }
            gestureDetector = mInstance;
            AppMethodBeat.m2505o(84350);
        }
        return gestureDetector;
    }

    public void init() {
        AppMethodBeat.m2504i(84351);
        if (this.mInited || !FeatureManager.isGestureDetectionReady()) {
            AppMethodBeat.m2505o(84351);
            return;
        }
        int Init;
        String absolutePath = VideoGlobalContext.getContext().getFilesDir().getAbsolutePath();
        String str = "cls.xnet";
        String str2 = "det.xnet";
        String str3 = absolutePath + "/" + str;
        String str4 = absolutePath + "/" + str2;
        if (!new File(str3).exists()) {
            String modelResPath = ResourcePathMapper.getModelResPath(str);
            LogUtils.m50202e("resPath", "resPath = ".concat(String.valueOf(modelResPath)));
            if (modelResPath == null || modelResPath.startsWith("assets://")) {
                copyAsset(VideoGlobalContext.getContext().getAssets(), "xlabHandmodel/".concat(String.valueOf(str)), str3);
            } else {
                FileUtils.copyFile(modelResPath + str, str3);
            }
        }
        if (!new File(str4).exists()) {
            str3 = ResourcePathMapper.getModelResPath(str2);
            if (str3 == null || str3.startsWith("assets://")) {
                copyAsset(VideoGlobalContext.getContext().getAssets(), "xlabHandmodel/".concat(String.valueOf(str2)), str4);
            } else {
                FileUtils.copyFile(str3 + str2, str4);
            }
        }
        try {
            Init = Init(absolutePath + "/" + str, absolutePath + "/" + str2, THREAD_NUM);
        } catch (UnsatisfiedLinkError e) {
            try {
                System.loadLibrary("XGestureSDK");
                System.loadLibrary("pt_handdetector");
                Init = Init(absolutePath + "/" + str, absolutePath + "/" + str2, THREAD_NUM);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(84351);
                return;
            }
        }
        if (Init != 0) {
            AppMethodBeat.m2505o(84351);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("HandDetectThread");
        handlerThread.start();
        this.mDetectHandler = new Handler(handlerThread.getLooper());
        this.mDetectorOutputConfidence = new float[61];
        this.mDetectorOutputXMin = new float[61];
        this.mDetectorOutputYMin = new float[61];
        this.mDetectorOutputXMax = new float[61];
        this.mDetectorOutputYMax = new float[61];
        this.mClassifyOutputConfidence = new float[61];
        this.mLabelIndex = new int[1];
        for (PTExpression pTExpression : PTExpression.values()) {
            this.mHandActionCounter.put(Integer.valueOf(pTExpression.value), new HandActionCounter(0, -1));
        }
        this.mInited = true;
        AppMethodBeat.m2505o(84351);
    }

    public void initWriteFile() {
        AppMethodBeat.m2504i(84352);
        File file = new File(this.COLLECT_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            this.mCollectInfoOut = new FileWriter(this.COLLECT_PATH + File.separator + "xlabCollect.txt", true);
            AppMethodBeat.m2505o(84352);
        } catch (IOException e) {
            AppMethodBeat.m2505o(84352);
        }
    }

    public void clearPicture() {
        AppMethodBeat.m2504i(84353);
        deleteDirectory(new File(this.COLLECT_PATH));
        AppMethodBeat.m2505o(84353);
    }

    private void deleteDirectory(File file) {
        AppMethodBeat.m2504i(84354);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        AppMethodBeat.m2505o(84354);
    }

    public static boolean copyAsset(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.m2504i(84355);
        try {
            System.out.println(str2);
            InputStream open = assetManager.open(str);
            new File(str2).createNewFile();
            OutputStream fileOutputStream = new FileOutputStream(str2);
            FileUtils.copyFile(open, fileOutputStream);
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.m2505o(84355);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(84355);
            return false;
        }
    }

    public void destroy() {
        AppMethodBeat.m2504i(84356);
        if (this.mInited) {
            Uninit();
            if (this.mDetectHandler != null) {
                this.mDetectHandler.getLooper().quit();
            }
            this.mInited = false;
            mInstance = null;
        }
        if (this.mBitmapCollect != null) {
            this.mBitmapCollect.recycle();
        }
        if (this.mCollectInfoOut != null) {
            try {
                this.mCollectInfoOut.close();
                AppMethodBeat.m2505o(84356);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(84356);
    }

    public void detectHand(final byte[] bArr, final int i, final int i2) {
        AppMethodBeat.m2504i(84357);
        if (!this.mInited || mIS_BUSY) {
            AppMethodBeat.m2505o(84357);
            return;
        }
        this.mDetectHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(84348);
                GestureDetector.mIS_BUSY = true;
                if (GestureDetector.this.Gesture(bArr, i, i2, 2, GestureDetector.this.mDetectorOutputXMin, GestureDetector.this.mDetectorOutputYMin, GestureDetector.this.mDetectorOutputXMax, GestureDetector.this.mDetectorOutputYMax, GestureDetector.this.mDetectorOutputConfidence, new int[]{0}, GestureDetector.this.mLabelIndex, GestureDetector.this.mClassifyOutputConfidence)) {
                    for (int i = 0; i <= 0; i++) {
                        if (PTExpression.HAND_LABEL_HEART.ordinal() <= GestureDetector.this.mLabelIndex[0] + 20 && GestureDetector.this.mLabelIndex[0] + 20 <= PTExpression.HAND_LABEL_GOOD_FORTUNE.ordinal()) {
                            if (GestureDetector.this.mClassifyOutputConfidence[0] > GestureDetector.CLASSIFY_THRESHOLD[GestureDetector.this.mLabelIndex[0]]) {
                                GestureDetector.this.mDetectedGestureLabel.value = GestureDetector.this.mLabelIndex[0] + 201;
                            } else {
                                GestureDetector.this.mDetectedGestureLabel.value = 200;
                            }
                            GestureDetector.this.mDetectedGestureLabel.lostStartTimestamp = -1;
                        }
                    }
                    GestureDetector.this.updateActionCount();
                } else {
                    GestureDetector.this.mDetectedGestureLabel.value = 200;
                    GestureDetector.this.mDetectorOutputXMin[0] = 0.0f;
                    GestureDetector.this.mDetectorOutputYMin[0] = 0.0f;
                    GestureDetector.this.mDetectorOutputXMax[0] = 0.0f;
                    GestureDetector.this.mDetectorOutputYMax[0] = 0.0f;
                    GestureDetector.this.updateActionCount();
                }
                GestureDetector.mIS_BUSY = false;
                AppMethodBeat.m2505o(84348);
            }
        });
        this.mImageWidth = i;
        this.mImageHeight = i2;
        AppMethodBeat.m2505o(84357);
    }

    public void setConfig(int i) {
        this.mEnableInterpolation = (i & 2) != 0;
    }

    public boolean isGestureTriggered(int i) {
        AppMethodBeat.m2504i(84358);
        if (this.mDetectedGestureLabel.value == i || ((this.mDetectedHandBox.isValid() && i == PTExpression.HAND_LABEL_HAND.value) || i == PTExpression.ALWAYS.value || this.mEnableInterpolation)) {
            AppMethodBeat.m2505o(84358);
            return true;
        }
        AppMethodBeat.m2505o(84358);
        return false;
    }

    public List<PointF> getHandPoints() {
        AppMethodBeat.m2504i(84359);
        if (this.mInited) {
            if (this.mDetectorOutputXMin[0] < 0.0f) {
                this.mDetectorOutputXMin[0] = 0.0f;
            }
            if (this.mDetectorOutputYMin[0] < 0.0f) {
                this.mDetectorOutputYMin[0] = 0.0f;
            }
            if (this.mDetectorOutputXMax[0] > ((float) this.mImageWidth)) {
                this.mDetectorOutputXMax[0] = (float) (this.mImageWidth - 1);
            }
            if (this.mDetectorOutputYMax[0] > ((float) this.mImageHeight)) {
                this.mDetectorOutputYMax[0] = (float) (this.mImageHeight - 1);
            }
            List<PointF> arrayList = new ArrayList();
            PointF pointF = new PointF(this.mDetectorOutputXMin[0], this.mDetectorOutputYMin[0]);
            PointF pointF2 = new PointF(this.mDetectorOutputXMax[0], this.mDetectorOutputYMin[0]);
            PointF pointF3 = new PointF(this.mDetectorOutputXMin[0], this.mDetectorOutputYMax[0]);
            PointF pointF4 = new PointF(this.mDetectorOutputXMax[0], this.mDetectorOutputYMax[0]);
            PointF midPoint = getMidPoint(pointF, pointF3);
            PointF midPoint2 = getMidPoint(pointF, pointF2);
            PointF midPoint3 = getMidPoint(pointF2, pointF4);
            PointF midPoint4 = getMidPoint(pointF3, pointF4);
            arrayList.add(getMidPoint(midPoint, midPoint3));
            arrayList.add(pointF);
            arrayList.add(midPoint2);
            arrayList.add(pointF2);
            arrayList.add(midPoint);
            arrayList.add(midPoint3);
            arrayList.add(pointF3);
            arrayList.add(midPoint4);
            arrayList.add(pointF4);
            this.mDetectedHandBox.f16571x = this.mDetectorOutputXMin[0];
            this.mDetectedHandBox.f16572y = this.mDetectorOutputYMin[0];
            this.mDetectedHandBox.width = this.mDetectorOutputXMax[0] - this.mDetectorOutputXMin[0];
            this.mDetectedHandBox.height = this.mDetectorOutputYMax[0] - this.mDetectorOutputYMin[0];
            AppMethodBeat.m2505o(84359);
            return arrayList;
        }
        AppMethodBeat.m2505o(84359);
        return null;
    }

    public List<float[]> getHandAngles() {
        AppMethodBeat.m2504i(84360);
        if (this.mInited) {
            List<float[]> arrayList = new ArrayList();
            for (int i = 0; i <= 0; i++) {
                arrayList.add(new float[]{0.0f, 0.0f, 0.0f});
            }
            AppMethodBeat.m2505o(84360);
            return arrayList;
        }
        AppMethodBeat.m2505o(84360);
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void updateActionCount() {
        AppMethodBeat.m2504i(84361);
        if (this.mUpdateActionCounter) {
            long currentTimeMillis = System.currentTimeMillis();
            for (PTExpression pTExpression : PTExpression.values()) {
                if (this.mDetectedGestureLabel.value == pTExpression.value) {
                    HandActionCounter handActionCounter = (HandActionCounter) this.mHandActionCounter.get(Integer.valueOf(pTExpression.value));
                    if (currentTimeMillis - handActionCounter.updateTime > 1000) {
                        handActionCounter.count++;
                        handActionCounter.updateTime = currentTimeMillis;
                    }
                }
            }
            AppMethodBeat.m2505o(84361);
            return;
        }
        AppMethodBeat.m2505o(84361);
    }

    public void clearActionCounter() {
        AppMethodBeat.m2504i(84362);
        this.mUpdateActionCounter = true;
        for (HandActionCounter clear : this.mHandActionCounter.values()) {
            clear.clear();
        }
        AppMethodBeat.m2505o(84362);
    }

    public void lockActionCounter() {
        this.mUpdateActionCounter = false;
    }

    public void unlockActionCounter() {
        this.mUpdateActionCounter = true;
    }

    private PointF getMidPoint(PointF pointF, PointF pointF2) {
        AppMethodBeat.m2504i(84363);
        PointF pointF3 = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        AppMethodBeat.m2505o(84363);
        return pointF3;
    }

    public Map<Integer, HandActionCounter> getHandActionCounter() {
        return this.mHandActionCounter;
    }
}
