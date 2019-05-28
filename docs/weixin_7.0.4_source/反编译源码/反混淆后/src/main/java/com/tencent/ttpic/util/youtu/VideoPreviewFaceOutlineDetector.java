package com.tencent.ttpic.util.youtu;

import android.graphics.Point;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.facedetect.FaceDetector.FaceDetectListener;
import com.tencent.ttpic.facedetect.FaceInfo;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VideoPreviewFaceOutlineDetector extends FaceDetector {
    private static final String TAG = VideoPreviewFaceOutlineDetector.class.getSimpleName();
    private final int FACEINFO_BUFFER_LIFE = 3;
    private Handler doTrackHandler;
    private int faceinfo_outdate = 0;
    private boolean isRunning = false;
    private Point lastDoTrackSize = new Point(0, 0);
    private List<FaceInfo> lastFaceInfos = new ArrayList(3);
    private int mDetectType = DETECT_TYPE.DETECT_TYPE_NONE.value;
    private VideoFaceDetector mFaceDetect = new VideoFaceDetector();
    private boolean mInitSuccess = false;
    private boolean mIsLastFaceDetected = false;

    static {
        AppMethodBeat.m2504i(84397);
        AppMethodBeat.m2505o(84397);
    }

    public VideoPreviewFaceOutlineDetector() {
        AppMethodBeat.m2504i(84382);
        AppMethodBeat.m2505o(84382);
    }

    public int init() {
        int i = 0;
        AppMethodBeat.m2504i(84383);
        if (this.mInitSuccess) {
            AppMethodBeat.m2505o(84383);
        } else {
            super.init();
            if (this.mFaceDetect != null) {
                boolean z;
                boolean init = this.mFaceDetect.init();
                if (!init) {
                    z = true;
                }
                this.mInitSuccess = z;
                i = init;
            }
            AppMethodBeat.m2505o(84383);
        }
        return i;
    }

    public void destroy() {
        AppMethodBeat.m2504i(84384);
        super.destroy();
        synchronized (mDetectLock) {
            try {
                if (this.mFaceDetect != null) {
                    this.mDetectType = DETECT_TYPE.DETECT_TYPE_NONE.value;
                    this.mFaceDetect.destroy();
                    this.mFaceDetect = null;
                    this.doTrackHandler = null;
                    Point point = this.lastDoTrackSize;
                    this.lastDoTrackSize.y = 0;
                    point.x = 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(84384);
            }
        }
    }

    public boolean doTrack(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84385);
        if (!this.mInitSuccess || this.mFaceDetect == null) {
            AppMethodBeat.m2505o(84385);
            return false;
        }
        FaceStatus[] faceStatusArr;
        this.lastDoTrackSize.x = i;
        this.lastDoTrackSize.y = i2;
        this.mTrackFrameCount++;
        boolean hasGame = GamePlaySDK.getInstance().hasGame();
        if (bArr == null || bArr.length != (i * i2) * 4) {
            faceStatusArr = null;
        } else {
            FaceStatus[] doTrack3D;
            BenchUtil.benchStart("only doTrack");
            if (hasGame) {
                doTrack3D = this.mFaceDetect.doTrack3D(bArr, i, i2, GamePlaySDK.getInstance().getFov());
            } else {
                doTrack3D = this.mFaceDetect.doTrack(bArr, i, i2);
            }
            BenchUtil.benchEnd("only doTrack");
            faceStatusArr = doTrack3D;
        }
        boolean z = faceStatusArr != null && faceStatusArr.length > 0;
        this.mIsLastFaceDetected = z;
        updatePointsAndAngles(faceStatusArr, hasGame);
        bufferFaceInfos();
        ExpressionDetector.getInstance().addFaces(this.faceInfos);
        updateTriggerExpression();
        updateActionCount();
        updateActionStatusChanged();
        notifyFaceDetectListener();
        AppMethodBeat.m2505o(84385);
        return z;
    }

    private void bufferFaceInfos() {
        AppMethodBeat.m2504i(84386);
        if (BaseUtils.isEmpty(this.faceInfos)) {
            if (BaseUtils.isEmpty(this.faceInfos) && this.faceinfo_outdate < 3) {
                this.faceInfos.addAll(this.lastFaceInfos);
                this.faceinfo_outdate++;
            }
            AppMethodBeat.m2505o(84386);
            return;
        }
        this.lastFaceInfos.clear();
        this.lastFaceInfos.addAll(this.faceInfos);
        this.faceinfo_outdate = 0;
        AppMethodBeat.m2505o(84386);
    }

    private void notifyFaceDetectListener() {
        AppMethodBeat.m2504i(84387);
        if (!(this.faceDetectListeners == null || this.faceDetectListeners.isEmpty())) {
            List allFaces = getAllFaces();
            for (FaceDetectListener faceDetectListener : this.faceDetectListeners) {
                if (faceDetectListener != null) {
                    faceDetectListener.onFaceDetectResult(allFaces);
                }
            }
        }
        AppMethodBeat.m2505o(84387);
    }

    public void doFaceDetect(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84388);
        if (this.mInitSuccess && bArr != null && bArr.length == (i * i2) * 4) {
            synchronized (mDetectLock) {
                try {
                    if (this.mFaceDetect != null) {
                        this.mFaceDetect.doFaceDetect(bArr, i, i2);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(84388);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(84388);
    }

    public void doFaceDetectByY(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84389);
        if (bArr == null || bArr.length != i * i2) {
            AppMethodBeat.m2505o(84389);
            return;
        }
        synchronized (mDetectLock) {
            try {
                if (this.mFaceDetect != null) {
                    this.mFaceDetect.doFaceDetectByY(bArr, i, i2);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(84389);
            }
        }
    }

    public DATA_TYPE getDataType() {
        return DATA_TYPE.RGBA;
    }

    public float getFaceValues(int i, int i2) {
        AppMethodBeat.m2504i(84390);
        float fakeFaceValues = getFakeFaceValues(i2);
        AppMethodBeat.m2505o(84390);
        return fakeFaceValues;
    }

    private float getFakeFaceValues(int i) {
        AppMethodBeat.m2504i(84391);
        float nextFloat;
        switch (i) {
            case 1:
                nextFloat = 0.18f + (new Random().nextFloat() * 0.12f);
                AppMethodBeat.m2505o(84391);
                return nextFloat;
            case 2:
                nextFloat = new Random().nextFloat();
                AppMethodBeat.m2505o(84391);
                return nextFloat;
            case 4:
                nextFloat = (new Random().nextFloat() * 0.2f) + 0.8f;
                AppMethodBeat.m2505o(84391);
                return nextFloat;
            case 8:
                nextFloat = (new Random().nextFloat() * 0.2f) + 0.8f;
                AppMethodBeat.m2505o(84391);
                return nextFloat;
            default:
                AppMethodBeat.m2505o(84391);
                return 0.0f;
        }
    }

    public byte[] doTrackByTexture(int i, final int i2, final int i3) {
        AppMethodBeat.m2504i(84392);
        final byte[] retrieveData = RetrieveDataManager.getInstance().retrieveData(DATA_TYPE.RGBA.value, i, i2, i3);
        if (needDetectFace(doTrack(retrieveData, i2, i3))) {
            postJob(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(84380);
                    BenchUtil.benchStart("only faceDetect");
                    VideoPreviewFaceOutlineDetector.this.doFaceDetect(retrieveData, i2, i3);
                    BenchUtil.benchEnd("only faceDetect");
                    AppMethodBeat.m2505o(84380);
                }
            });
        }
        AppMethodBeat.m2505o(84392);
        return retrieveData;
    }

    public void doTrackByRGBA(final byte[] bArr, final int i, final int i2) {
        AppMethodBeat.m2504i(84393);
        if (needDetectFace(doTrack(bArr, i, i2)) && !this.isRunning) {
            this.isRunning = true;
            postJob(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(84381);
                    BenchUtil.benchStart("only faceDetect");
                    long j = 0;
                    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                        j = System.currentTimeMillis();
                    }
                    VideoPreviewFaceOutlineDetector.this.doFaceDetect(bArr, i, i2);
                    if (BenchUtil.ENABLE_PERFORMANCE_RECORD) {
                        new StringBuilder("人脸追踪耗时： ").append(System.currentTimeMillis() - j).append(" ms.");
                    }
                    BenchUtil.benchEnd("only faceDetect");
                    VideoPreviewFaceOutlineDetector.this.isRunning = false;
                    VideoPreviewFaceOutlineDetector.this.mTrackFrameCount = 0;
                    AppMethodBeat.m2505o(84381);
                }
            });
        }
        AppMethodBeat.m2505o(84393);
    }

    public void doDectectTrackByRGBA(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(84394);
        doFaceDetect(bArr, i, i2);
        doTrack(bArr, i, i2);
        AppMethodBeat.m2505o(84394);
    }

    public void setRefine(boolean z) {
        AppMethodBeat.m2504i(84395);
        init();
        YTFaceDetectorBase.getInstance().nativeSetRefine(z);
        AppMethodBeat.m2505o(84395);
    }

    public boolean needDetectFaceValue() {
        return this.mDetectType != DETECT_TYPE.DETECT_TYPE_NONE.value;
    }

    public void setFaceValueDetectType(int i) {
        this.mDetectType = i;
    }

    public Point getLastDoTrackSize() {
        return this.lastDoTrackSize;
    }

    public void postDoTrack(Runnable runnable) {
        AppMethodBeat.m2504i(84396);
        synchronized (mDetectLock) {
            try {
                if (this.doTrackHandler != null) {
                    this.doTrackHandler.post(runnable);
                } else {
                    runnable.run();
                }
            } finally {
                AppMethodBeat.m2505o(84396);
            }
        }
    }

    public void setDoTrackHandler(Handler handler) {
        this.doTrackHandler = handler;
    }

    public boolean isLastFrameDetectFaces() {
        return this.mIsLastFaceDetected;
    }
}
