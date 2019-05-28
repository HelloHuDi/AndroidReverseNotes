package com.tencent.ttpic;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PTFaceAttr {
    private List<BodyDetectResult> bodyDetectResult;
    private List<List<PointF>> bodyPoints;
    private int[] brightnessAdjustmentCurve;
    private VideoPreviewFaceOutlineDetector faceDetector;
    private Pair<Integer, int[]> histogram;
    private h mCorrectFrame;
    private byte[] mData;
    private boolean mEnableDenoise;
    private Map<Integer, FaceActionCounter> mFaceActionCounter;
    private double mFaceDetectScale;
    private Map<PTExpression, Boolean> mFaceExpression;
    private List<PTFace> mFaceInfos;
    private List<FaceStatus> mFaceStatusList;
    private float[] mHandAngles;
    private List<PointF> mHandPoints;
    private h mOrigFrame;
    private h mOrigLargeFrame;
    private int mRotation;
    private long mTimeStamp;
    private Set<Integer> mTriggeredExpression;

    public static class PTFace {
        private Map<PTExpression, Boolean> mExpressionRet;
        private float[] mFaceAngle = new float[3];
        private List<PointF> mFacePoints;
        private List<PointF> mIrisPoints;

        public PTFace() {
            AppMethodBeat.i(81568);
            AppMethodBeat.o(81568);
        }

        public List<PointF> getFacePoints() {
            return this.mFacePoints;
        }

        public List<PointF> getIrisPoints() {
            return this.mIrisPoints;
        }

        public void setFacePoints(List<PointF> list) {
            this.mFacePoints = list;
        }

        public void setIrisPoints(List<PointF> list) {
            this.mIrisPoints = list;
        }

        public float[] getFaceAngle() {
            return this.mFaceAngle;
        }

        public void setFaceAngle(float[] fArr) {
            this.mFaceAngle = fArr;
        }
    }

    public enum PTExpression {
        UNKNOW(0),
        ALWAYS(1),
        FACE_DETECT(2),
        MOUTH_OPEN(3),
        EYEBROWS_RAISE(4),
        BLINK(5),
        HEAD_SHAKE(6),
        KISS(7),
        BLINK_LEFT_EYE(8),
        BLINK_RIGHT_EYE(9),
        HEAD_NOD(10),
        HEAD_SHAKE_NEW(11),
        TRY_CLICK_SCREEN(12),
        MV_PART_INDEX(13),
        FACE_NO_NOUTH(103, MOUTH_OPEN),
        FACE_NO_EYEBROWS(104, EYEBROWS_RAISE),
        FACE_NO_BLINK(105, BLINK),
        FACE_NO_HEAD(106, HEAD_SHAKE),
        FACE_NO_KISS(107, KISS),
        HAND_LABEL_HAND(200),
        HAND_LABEL_HEART(201),
        HAND_LABEL_PAPER(202),
        HAND_LABEL_SCISSOR(203),
        HAND_LABEL_FIST(204),
        HAND_LABEL_ONE(205),
        HAND_LABEL_LOVE(206),
        HAND_LABEL_LIKE(207),
        HAND_LABEL_OK(208),
        HAND_LABEL_ROCK(209),
        HAND_LABEL_SIX(210),
        HAND_LABEL_EIGHT(211),
        HAND_LABEL_LIFT(212),
        HAND_LABEL_GOOD_FORTUNE(213);
        
        public static final PTExpression[] ACTION_TRIGGER_TYPE = null;
        public PTExpression opposite;
        public final int value;

        static {
            ACTION_TRIGGER_TYPE = new PTExpression[]{MOUTH_OPEN, EYEBROWS_RAISE, BLINK, HEAD_SHAKE, KISS, BLINK_LEFT_EYE, BLINK_RIGHT_EYE, HEAD_NOD, HEAD_SHAKE_NEW, TRY_CLICK_SCREEN};
            AppMethodBeat.o(81567);
        }

        private PTExpression(int i) {
            this.value = i;
        }

        private PTExpression(int i, PTExpression pTExpression) {
            this.value = i;
            this.opposite = pTExpression;
        }
    }

    public Map<PTExpression, Boolean> getFaceExpression() {
        return this.mFaceExpression;
    }

    public void setFaceExpression(Map<PTExpression, Boolean> map) {
        this.mFaceExpression = map;
    }

    public List<PTFace> getFaceInfos() {
        return this.mFaceInfos;
    }

    public void setFaceInfos(List<PTFace> list) {
        this.mFaceInfos = list;
    }

    public List<PointF> getHandPoints() {
        return this.mHandPoints;
    }

    public void setHandPoints(List<PointF> list) {
        this.mHandPoints = list;
    }

    public byte[] getData() {
        return this.mData;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public List<List<PointF>> getAllFacePoints() {
        AppMethodBeat.i(81569);
        ArrayList arrayList = new ArrayList();
        if (this.mFaceInfos == null) {
            AppMethodBeat.o(81569);
            return arrayList;
        }
        for (PTFace facePoints : this.mFaceInfos) {
            arrayList.add(facePoints.getFacePoints());
        }
        AppMethodBeat.o(81569);
        return arrayList;
    }

    public List<List<PointF>> getAllIrisPoints() {
        AppMethodBeat.i(81570);
        if (this.mFaceInfos == null) {
            AppMethodBeat.o(81570);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PTFace irisPoints : this.mFaceInfos) {
            arrayList.add(irisPoints.getIrisPoints());
        }
        AppMethodBeat.o(81570);
        return arrayList;
    }

    public List<float[]> getAllFaceAngles() {
        AppMethodBeat.i(81571);
        if (this.mFaceInfos == null) {
            AppMethodBeat.o(81571);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (PTFace faceAngle : this.mFaceInfos) {
            arrayList.add(faceAngle.getFaceAngle());
        }
        AppMethodBeat.o(81571);
        return arrayList;
    }

    public void setHandAngles(float[] fArr) {
        this.mHandAngles = fArr;
    }

    public float[] getHandAngles() {
        return this.mHandAngles;
    }

    public void setFaceStatusList(List<FaceStatus> list) {
        this.mFaceStatusList = list;
    }

    public List<FaceStatus> getFaceStatusList() {
        return this.mFaceStatusList;
    }

    public void setEnableDenoise(boolean z) {
        this.mEnableDenoise = z;
    }

    public boolean isEnableDenoise() {
        return this.mEnableDenoise;
    }

    public int[] getBrightnessAdjustmentCurve() {
        return this.brightnessAdjustmentCurve;
    }

    public void setBrightnessAdjustmentCurve(int[] iArr) {
        this.brightnessAdjustmentCurve = iArr;
    }

    public void setOrigFrame(h hVar) {
        this.mOrigFrame = hVar;
    }

    public h getOrigLargeFrame() {
        return this.mOrigLargeFrame;
    }

    public void setOrigLargeFrame(h hVar) {
        this.mOrigLargeFrame = hVar;
    }

    public h getOrigFrame() {
        return this.mOrigFrame;
    }

    public void setCorrectFrame(h hVar) {
        this.mCorrectFrame = hVar;
    }

    public h getCorrectFrame() {
        return this.mCorrectFrame;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public boolean isLandscape() {
        return this.mRotation == 90 || this.mRotation == 270;
    }

    public void setTriggeredExpression(Set<Integer> set) {
        this.mTriggeredExpression = set;
    }

    public Set<Integer> getTriggeredExpression() {
        return this.mTriggeredExpression;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setFaceDetectScale(double d) {
        this.mFaceDetectScale = d;
    }

    public Pair<Integer, int[]> getHistogram() {
        return this.histogram;
    }

    public void setHistogram(Pair<Integer, int[]> pair) {
        this.histogram = pair;
    }

    public double getFaceDetectScale() {
        return this.mFaceDetectScale;
    }

    public static PTFaceAttr genFaceAttr(List<List<PointF>> list, List<List<PointF>> list2, List<float[]> list3, Set<Integer> set, List<PointF> list4, float[] fArr, List<FaceStatus> list5, List<BodyDetectResult> list6, double d, byte[] bArr, boolean z, h hVar, h hVar2, h hVar3, int i, int[] iArr, Map<Integer, FaceActionCounter> map, Pair<Integer, int[]> pair, VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        int i2;
        AppMethodBeat.i(81572);
        PTFaceAttr pTFaceAttr = new PTFaceAttr();
        pTFaceAttr.setTimeStamp(System.currentTimeMillis());
        pTFaceAttr.setData(bArr);
        pTFaceAttr.setRotation(i);
        pTFaceAttr.setTriggeredExpression(set);
        pTFaceAttr.setFaceDetector(videoPreviewFaceOutlineDetector);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                break;
            }
            PTFace pTFace = new PTFace();
            pTFace.setFacePoints((List) list.get(i4));
            pTFace.setIrisPoints((List) list2.get(i4));
            pTFace.setFaceAngle((float[]) list3.get(i4));
            arrayList.add(pTFace);
            i3 = i4 + 1;
        }
        HashMap hashMap = new HashMap();
        if (set == null) {
            set = new HashSet();
            set.add(Integer.valueOf(1));
        }
        for (PTExpression pTExpression : PTExpression.values()) {
            if (set.contains(Integer.valueOf(pTExpression.value))) {
                hashMap.put(pTExpression, Boolean.TRUE);
            } else {
                hashMap.put(pTExpression, Boolean.FALSE);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (!(list6 == null || list6.isEmpty())) {
            for (BodyDetectResult bodyDetectResult : list6) {
                if (!(bodyDetectResult.bodyPoints == null || bodyDetectResult.bodyPoints.isEmpty())) {
                    ArrayList arrayList3 = new ArrayList();
                    i3 = 0;
                    while (true) {
                        i2 = i3;
                        if (i2 >= bodyDetectResult.bodyPoints.size()) {
                            break;
                        }
                        arrayList3.add(new PointF(((PointF) bodyDetectResult.bodyPoints.get(i2)).x, ((PointF) bodyDetectResult.bodyPoints.get(i2)).y));
                        i3 = i2 + 1;
                    }
                    arrayList2.add(arrayList3);
                }
            }
        }
        pTFaceAttr.setFaceInfos(arrayList);
        pTFaceAttr.setFaceExpression(hashMap);
        pTFaceAttr.setHandPoints(list4);
        pTFaceAttr.setHandAngles(fArr);
        pTFaceAttr.setBodyDetectResult(list6);
        pTFaceAttr.setBodyPoints(arrayList2);
        pTFaceAttr.setFaceStatusList(list5);
        pTFaceAttr.setFaceDetectScale(d);
        pTFaceAttr.setEnableDenoise(z);
        pTFaceAttr.setOrigFrame(hVar);
        pTFaceAttr.setOrigLargeFrame(hVar2);
        pTFaceAttr.setCorrectFrame(hVar3);
        pTFaceAttr.setFaceActionCounter(map);
        pTFaceAttr.setHistogram(pair);
        if (iArr != null) {
            pTFaceAttr.setBrightnessAdjustmentCurve(iArr);
        }
        AppMethodBeat.o(81572);
        return pTFaceAttr;
    }

    public Map<Integer, FaceActionCounter> getFaceActionCounter() {
        return this.mFaceActionCounter;
    }

    public void setFaceActionCounter(Map<Integer, FaceActionCounter> map) {
        this.mFaceActionCounter = map;
    }

    public void setBodyPoints(List<List<PointF>> list) {
        this.bodyPoints = list;
    }

    public List<List<PointF>> getBodyPoints() {
        return this.bodyPoints;
    }

    public List<BodyDetectResult> getBodyDetectResult() {
        return this.bodyDetectResult;
    }

    public void setBodyDetectResult(List<BodyDetectResult> list) {
        this.bodyDetectResult = list;
    }

    public int getFaceCount() {
        AppMethodBeat.i(81573);
        int size = this.mFaceInfos.size();
        AppMethodBeat.o(81573);
        return size;
    }

    public VideoPreviewFaceOutlineDetector getFaceDetector() {
        return this.faceDetector;
    }

    public void setFaceDetector(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector) {
        this.faceDetector = videoPreviewFaceOutlineDetector;
    }
}
