package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.LeftEyeRangeDetector;
import com.tencent.ttpic.face.MouthRangeDetector;
import com.tencent.ttpic.face.RightEyeRangeDetector;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceActionCallback;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.youtu.ExpressionDetector;
import com.tencent.ttpic.util.youtu.YoutuPointsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FaceDetector {
    public static final float FACE_DETECT_WIDTH = 180.0f;
    protected static final int FACE_DET_INTERVAL = 7;
    private static final String TAG = FaceDetector.class.getSimpleName();
    protected static final Object mDetectLock = new Object();
    private Sensor accelerometer;
    private double angle = 0.0d;
    protected List<FaceDetectListener> faceDetectListeners = new ArrayList();
    protected List<FaceInfo> faceInfos = new ArrayList();
    private long factor = 0;
    private boolean isFaceActionCounterInited = false;
    protected Handler mDetectorThreadHandler;
    protected final SparseArray<Set<FaceActionCallback>> mFaceActionCallbacks = new SparseArray();
    protected final Map<Integer, FaceActionCounter> mFaceActionCounter = new HashMap();
    protected final Map<Integer, Boolean> mFaceActionStatus = new HashMap();
    private SensorEventListener mSensorEventListener = new C311191();
    public int mTrackFrameCount;
    protected Set<Integer> mTriggeredExpressionType = new HashSet();
    protected boolean mUpdateActionCounter;
    private SensorManager sensorManager;

    public enum FACE_DETECT_MODE {
        SINGLE,
        MULTIPLE;

        static {
            AppMethodBeat.m2505o(81914);
        }
    }

    public interface FaceDetectListener {
        void onFaceDetectResult(List<List<PointF>> list);
    }

    /* renamed from: com.tencent.ttpic.facedetect.FaceDetector$1 */
    class C311191 implements SensorEventListener {
        C311191() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(81908);
            if (sensorEvent.sensor != FaceDetector.this.accelerometer) {
                AppMethodBeat.m2505o(81908);
                return;
            }
            FaceDetector.this.angle = Math.atan2((double) sensorEvent.values[0], (double) sensorEvent.values[1]);
            AppMethodBeat.m2505o(81908);
        }
    }

    public enum DETECT_TYPE {
        DETECT_TYPE_NONE(0),
        DETECT_TYPE_AGE(1),
        DETECT_TYPE_SEX(2),
        DETECT_TYPE_POPULAR(4),
        DETECT_TYPE_CP(8);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(81911);
        }

        private DETECT_TYPE(int i) {
            this.value = i;
        }
    }

    public abstract void doFaceDetect(byte[] bArr, int i, int i2);

    public abstract void doTrackByRGBA(byte[] bArr, int i, int i2);

    public abstract byte[] doTrackByTexture(int i, int i2, int i3);

    public abstract DATA_TYPE getDataType();

    public int init() {
        if (this.mDetectorThreadHandler == null) {
            synchronized (mDetectLock) {
                if (this.mDetectorThreadHandler == null) {
                    for (PTExpression pTExpression : PTExpression.values()) {
                        this.mFaceActionStatus.put(Integer.valueOf(pTExpression.value), Boolean.FALSE);
                    }
                    for (PTExpression pTExpression2 : PTExpression.values()) {
                        Object faceActionCounter;
                        Map map = this.mFaceActionCounter;
                        Integer valueOf = Integer.valueOf(pTExpression2.value);
                        if (pTExpression2.value != PTExpression.MV_PART_INDEX.value) {
                            faceActionCounter = new FaceActionCounter(0, -1);
                        } else {
                            faceActionCounter = new FabbyFaceActionCounter(0, -1);
                        }
                        map.put(valueOf, faceActionCounter);
                    }
                    this.isFaceActionCounterInited = true;
                    this.sensorManager = (SensorManager) VideoGlobalContext.getContext().getSystemService("sensor");
                    this.accelerometer = this.sensorManager.getDefaultSensor(1);
                    this.sensorManager.registerListener(this.mSensorEventListener, this.accelerometer, 3);
                    HandlerThread handlerThread = new HandlerThread("VideoPreviewFaceOutlineDetector");
                    handlerThread.start();
                    this.mDetectorThreadHandler = new Handler(handlerThread.getLooper());
                }
            }
        }
        return 0;
    }

    public void registerFaceDetectListeners(FaceDetectListener faceDetectListener) {
        this.faceDetectListeners.add(faceDetectListener);
    }

    public void unregisterFaceDetectListener(FaceDetectListener faceDetectListener) {
        this.faceDetectListeners.remove(faceDetectListener);
    }

    public void clear() {
        synchronized (this) {
            this.faceInfos.clear();
            this.mTriggeredExpressionType.clear();
        }
    }

    public void destroy() {
        synchronized (mDetectLock) {
            if (this.mDetectorThreadHandler != null) {
                this.mFaceActionStatus.clear();
                this.mFaceActionCallbacks.clear();
                this.mDetectorThreadHandler.getLooper().quit();
                this.mDetectorThreadHandler = null;
                this.sensorManager.unregisterListener(this.mSensorEventListener);
            }
            this.faceDetectListeners.clear();
        }
    }

    public void postJob(Runnable runnable) {
        if (runnable != null && this.mDetectorThreadHandler != null) {
            this.mDetectorThreadHandler.post(runnable);
        }
    }

    public int getFaceCount() {
        return this.faceInfos.size();
    }

    public void lockActionCounter() {
        this.mUpdateActionCounter = false;
    }

    public void unlockActionCounter() {
        this.mUpdateActionCounter = true;
    }

    public List<List<PointF>> getAllFaces() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getFaceCount(); i++) {
            arrayList.add(getAllPoints(i));
        }
        return arrayList;
    }

    public List<List<PointF>> getAllIris() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getFaceCount(); i++) {
            arrayList.add(getIrisPoints(i));
        }
        return arrayList;
    }

    public List<float[]> getAllFaceAngles() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getFaceCount(); i++) {
            arrayList.add(getFaceAngles(i));
        }
        return arrayList;
    }

    public List<FaceStatus> getFaceStatus3Ds() {
        ArrayList arrayList = new ArrayList();
        for (FaceInfo faceInfo : this.faceInfos) {
            FaceStatus faceStatus = new FaceStatus();
            faceStatus.pitch = faceInfo.pitch;
            faceStatus.yaw = faceInfo.yaw;
            faceStatus.roll = faceInfo.roll;
            faceStatus.f16557tx = faceInfo.f17522tx;
            faceStatus.f16558ty = faceInfo.f17523ty;
            faceStatus.scale = faceInfo.scale;
            faceStatus.denseFaceModel = faceInfo.denseFaceModel;
            faceStatus.transform = faceInfo.transform;
            arrayList.add(faceStatus);
        }
        return arrayList;
    }

    public List<PointF> getAllPoints(int i) {
        List<PointF> arrayList;
        synchronized (this) {
            if (BaseUtils.indexOutOfBounds(this.faceInfos, i)) {
                arrayList = new ArrayList();
            } else {
                arrayList = ((FaceInfo) this.faceInfos.get(i)).points;
            }
        }
        return arrayList;
    }

    public List<PointF> getIrisPoints(int i) {
        List<PointF> arrayList;
        synchronized (this) {
            if (BaseUtils.indexOutOfBounds(this.faceInfos, i)) {
                arrayList = new ArrayList();
            } else {
                arrayList = ((FaceInfo) this.faceInfos.get(i)).irisPoints;
            }
        }
        return arrayList;
    }

    public float[] getFaceAngles(int i) {
        float[] fArr;
        synchronized (this) {
            if (BaseUtils.indexOutOfBounds(this.faceInfos, i)) {
                fArr = new float[0];
            } else {
                fArr = ((FaceInfo) this.faceInfos.get(i)).angles;
            }
        }
        return fArr;
    }

    public float getPhotoAngle() {
        return (float) this.angle;
    }

    public boolean detectExpression(int i) {
        return this.mTriggeredExpressionType.contains(Integer.valueOf(i)) || i == PTExpression.ALWAYS.value;
    }

    public void clearSavedTriggeredExpression() {
        this.mTriggeredExpressionType.clear();
    }

    public Set<Integer> getTriggeredExpression() {
        HashSet hashSet = new HashSet();
        for (Integer intValue : this.mTriggeredExpressionType) {
            hashSet.add(Integer.valueOf(intValue.intValue()));
        }
        return hashSet;
    }

    public FaceRangeStatus detectFaceRangeStatus(List<PointF> list) {
        FaceRangeStatus faceRangeStatus = new FaceRangeStatus();
        if (list == null || list.size() < 90) {
            return faceRangeStatus;
        }
        faceRangeStatus.leftEye = LeftEyeRangeDetector.getInstance().detectRange(list);
        faceRangeStatus.rightEye = RightEyeRangeDetector.getInstance().detectRange(list);
        faceRangeStatus.mouth = MouthRangeDetector.getInstance().detectRange(list);
        faceRangeStatus.isKiss = AlgoUtils.getDistance((PointF) list.get(77), (PointF) list.get(69)) / AlgoUtils.getDistance((PointF) list.get(65), (PointF) list.get(66)) >= 0.6f;
        return faceRangeStatus;
    }

    /* Access modifiers changed, original: protected */
    public void updatePointsAndAngles(FaceStatus[] faceStatusArr, boolean z) {
        synchronized (this) {
            this.faceInfos.clear();
            if (faceStatusArr == null) {
                return;
            }
            for (FaceStatus faceStatus : faceStatusArr) {
                FaceInfo faceInfo = new FaceInfo();
                faceInfo.points = YoutuPointsUtil.transformYTPointsToPtuPoints(faceStatus.xys);
                faceInfo.irisPoints = YoutuPointsUtil.getIrisPoints(faceStatus.xys);
                faceInfo.angles[0] = ((float) ((((double) faceStatus.pitch) * 3.141592653589793d) / 180.0d)) * -1.0f;
                faceInfo.angles[1] = ((float) ((((double) faceStatus.yaw) * 3.141592653589793d) / 180.0d)) * -1.0f;
                faceInfo.angles[2] = ((float) ((((double) faceStatus.roll) * 3.141592653589793d) / 180.0d)) * -1.0f;
                faceInfo.scale = faceStatus.scale;
                faceInfo.pitch = faceStatus.pitch;
                faceInfo.yaw = faceStatus.yaw;
                faceInfo.roll = faceStatus.roll;
                faceInfo.f17522tx = faceStatus.f16557tx;
                faceInfo.f17523ty = faceStatus.f16558ty;
                faceInfo.denseFaceModel = faceStatus.denseFaceModel;
                faceInfo.transform = faceStatus.transform;
                this.faceInfos.add(faceInfo);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void updateTriggerExpression() {
        Object obj = null;
        for (PTExpression pTExpression : PTExpression.values()) {
            if (ExpressionDetector.getInstance().detectExpression(pTExpression.value)) {
                this.mTriggeredExpressionType.add(Integer.valueOf(pTExpression.value));
                if (ExpressionDetector.needSaveDetectedExpression(pTExpression.value)) {
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            ExpressionDetector.getInstance().clearFaceQueue();
        }
    }

    /* Access modifiers changed, original: protected */
    public void updateActionCount() {
        if (this.mUpdateActionCounter) {
            long currentTimeMillis = System.currentTimeMillis();
            for (PTExpression pTExpression : PTExpression.values()) {
                if (this.mTriggeredExpressionType.contains(Integer.valueOf(pTExpression.value))) {
                    FaceActionCounter faceActionCounter = (FaceActionCounter) this.mFaceActionCounter.get(Integer.valueOf(pTExpression.value));
                    if (currentTimeMillis - faceActionCounter.updateTime > 1000) {
                        faceActionCounter.count++;
                        faceActionCounter.updateTime = currentTimeMillis;
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void updateActionStatusChanged() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mFaceActionCallbacks.size()) {
                int keyAt = this.mFaceActionCallbacks.keyAt(i2);
                boolean booleanValue = ((Boolean) this.mFaceActionStatus.get(Integer.valueOf(keyAt))).booleanValue();
                boolean detectExpression = detectExpression(keyAt);
                if (booleanValue != detectExpression) {
                    for (FaceActionCallback onActionDetected : (Set) this.mFaceActionCallbacks.valueAt(i2)) {
                        onActionDetected.onActionDetected(keyAt, detectExpression);
                    }
                }
                this.mFaceActionStatus.put(Integer.valueOf(keyAt), Boolean.valueOf(detectExpression));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public boolean needDetectFace(boolean z) {
        if (z) {
            this.factor = 0;
            if (this.mTrackFrameCount > 7) {
                return true;
            }
            return false;
        } else if (this.factor > 7) {
            return true;
        } else {
            this.factor++;
            return true;
        }
    }

    public Map<Integer, FaceActionCounter> getFaceActionCounter() {
        return this.isFaceActionCounterInited ? new HashMap(this.mFaceActionCounter) : new HashMap();
    }

    public void clearActionCounter() {
        if (this.isFaceActionCounterInited) {
            this.mUpdateActionCounter = true;
            for (FaceActionCounter clear : this.mFaceActionCounter.values()) {
                clear.clear();
            }
        }
    }

    public void addFaceActionCallback(int i, FaceActionCallback faceActionCallback) {
        if (faceActionCallback != null) {
            Set set = (Set) this.mFaceActionCallbacks.get(i);
            if (set == null) {
                set = new HashSet();
                this.mFaceActionCallbacks.put(i, set);
            }
            set.add(faceActionCallback);
        }
    }

    public void removeFaceActionCallback(FaceActionCallback faceActionCallback) {
        if (faceActionCallback != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mFaceActionCallbacks.size()) {
                    Set set = (Set) this.mFaceActionCallbacks.valueAt(i2);
                    if (set != null) {
                        set.remove(faceActionCallback);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
