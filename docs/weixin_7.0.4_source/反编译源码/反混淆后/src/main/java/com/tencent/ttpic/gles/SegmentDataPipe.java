package com.tencent.ttpic.gles;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SegmentDataPipe {
    public static final int BUFFER_BUSY = 1;
    public static final int BUFFER_FREE = 0;
    public static final int BUFFER_READY = 2;
    public static final String TAG = SegmentDataPipe.class.getSimpleName();
    private static float[] sMtxIdentity = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public List<float[]> allFaceAngles;
    public List<List<PointF>> allFacePoints;
    public List<float[]> allHandAngles;
    public List<PointF> allHandPoints;
    public List<List<PointF>> allIrisPoints;
    public List<BodyDetectResult> bodyDetectResults;
    public int[] brightnessAdjustmentCurve;
    public Map<Integer, FaceActionCounter> faceActionCounter;
    public List<FaceStatus> faceStatus;
    public Pair<Integer, int[]> histogram;
    public byte[] mData;
    public C41672h mMaskFrame = new C41672h();
    public C41672h mTexFrame = new C41672h();
    public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
    public long mTimestamp;
    public Set<Integer> mTriggeredExpressionType = new HashSet();

    public interface OnFrameAvailableListener {
        void onFrameAvailable();
    }

    static {
        AppMethodBeat.m2504i(83258);
        AppMethodBeat.m2505o(83258);
    }

    public SegmentDataPipe() {
        AppMethodBeat.m2504i(83249);
        AppMethodBeat.m2505o(83249);
    }

    public void getTransformMatrix(float[] fArr) {
        AppMethodBeat.m2504i(83250);
        if (fArr.length != 16) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(83250);
            throw illegalArgumentException;
        }
        System.arraycopy(sMtxIdentity, 0, fArr, 0, sMtxIdentity.length);
        AppMethodBeat.m2505o(83250);
    }

    public boolean isBusy() {
        AppMethodBeat.m2504i(83251);
        if (this.mTextureDataFlag.get() == 1) {
            AppMethodBeat.m2505o(83251);
            return true;
        }
        AppMethodBeat.m2505o(83251);
        return false;
    }

    public boolean isReady() {
        AppMethodBeat.m2504i(83252);
        if (this.mTextureDataFlag.get() == 2) {
            AppMethodBeat.m2505o(83252);
            return true;
        }
        AppMethodBeat.m2505o(83252);
        return false;
    }

    public void release() {
        AppMethodBeat.m2504i(83253);
        this.mTexFrame.clear();
        this.mMaskFrame.clear();
        AppMethodBeat.m2505o(83253);
    }

    public void makeFree() {
        AppMethodBeat.m2504i(83254);
        this.mTextureDataFlag.getAndSet(0);
        AppMethodBeat.m2505o(83254);
    }

    public void makeBusy() {
        AppMethodBeat.m2504i(83255);
        this.mTextureDataFlag.getAndSet(1);
        AppMethodBeat.m2505o(83255);
    }

    public void makeDataReady() {
        AppMethodBeat.m2504i(83256);
        this.mTextureDataFlag.getAndSet(2);
        AppMethodBeat.m2505o(83256);
    }

    public int getTexureCurrentStatus() {
        AppMethodBeat.m2504i(83257);
        int andAdd = this.mTextureDataFlag.getAndAdd(0);
        AppMethodBeat.m2505o(83257);
        return andAdd;
    }
}
