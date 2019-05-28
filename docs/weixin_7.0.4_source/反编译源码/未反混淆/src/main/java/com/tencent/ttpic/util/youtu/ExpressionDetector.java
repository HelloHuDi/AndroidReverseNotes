package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceInfo;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoMaterialUtil.EXPRESSION_TYPE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ExpressionDetector {
    private static final int FACE_QUEUE_MAX_SIZE = 30;
    private static final String TAG = ExpressionDetector.class.getSimpleName();
    private static ThreadLocal<ExpressionDetector> mInstance = new ThreadLocal<ExpressionDetector>() {
        /* Access modifiers changed, original: protected|final */
        public final ExpressionDetector initialValue() {
            AppMethodBeat.i(84316);
            ExpressionDetector expressionDetector = new ExpressionDetector();
            AppMethodBeat.o(84316);
            return expressionDetector;
        }
    };
    private List<LinkedList<FaceInfo>> mFaceQueueList = new ArrayList();

    static {
        AppMethodBeat.i(84347);
        AppMethodBeat.o(84347);
    }

    public static ExpressionDetector getInstance() {
        AppMethodBeat.i(84318);
        ExpressionDetector expressionDetector = (ExpressionDetector) mInstance.get();
        AppMethodBeat.o(84318);
        return expressionDetector;
    }

    ExpressionDetector() {
        AppMethodBeat.i(84319);
        AppMethodBeat.o(84319);
    }

    public void addFaces(List<FaceInfo> list) {
        AppMethodBeat.i(84320);
        if (list == null) {
            this.mFaceQueueList.clear();
            AppMethodBeat.o(84320);
            return;
        }
        if (list.size() != this.mFaceQueueList.size()) {
            this.mFaceQueueList.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (i2 == this.mFaceQueueList.size()) {
                    this.mFaceQueueList.add(new LinkedList());
                }
                LinkedList linkedList = (LinkedList) this.mFaceQueueList.get(i2);
                if (linkedList.size() > 30) {
                    linkedList.removeLast();
                }
                linkedList.addFirst(list.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(84320);
                return;
            }
        }
    }

    public boolean detectExpression(int i) {
        AppMethodBeat.i(84321);
        boolean isFaceDetected;
        switch (i) {
            case 1:
                AppMethodBeat.o(84321);
                return true;
            case 2:
                isFaceDetected = isFaceDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 3:
                isFaceDetected = isExpressionOpenMouthDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 4:
                isFaceDetected = isExpressionJumpEyebrowDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 5:
                isFaceDetected = isExpressionRightEyeWinkDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 6:
                isFaceDetected = isExpressionShakeHeadDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 7:
                isFaceDetected = isExpressionKissDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 8:
                isFaceDetected = isExpressionLeftEyeWinkDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 9:
                isFaceDetected = isExpressionRightEyeWinkDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 10:
                isFaceDetected = isExpressionNodDetected();
                AppMethodBeat.o(84321);
                return isFaceDetected;
            case 103:
                if (!isFaceDetected() || isExpressionOpenMouthDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 104:
                if (!isFaceDetected() || isExpressionJumpEyebrowDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 106:
                if (!isFaceDetected() || isExpressionShookHeadDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 107:
                if (!isFaceDetected() || isExpressionKissDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 108:
                if (!isFaceDetected() || isExpressionLeftEyeWinkDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 109:
                if (!isFaceDetected() || isExpressionLeftEyeWinkDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            case 110:
                if (!isFaceDetected() || isExpressionNodDetected()) {
                    AppMethodBeat.o(84321);
                    return false;
                }
                AppMethodBeat.o(84321);
                return true;
            default:
                AppMethodBeat.o(84321);
                return false;
        }
    }

    private boolean isExpressionOpenMouthDetected() {
        AppMethodBeat.i(84322);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionOpenMouthDetected(i)) {
                AppMethodBeat.o(84322);
                return true;
            }
        }
        AppMethodBeat.o(84322);
        return false;
    }

    private boolean isExpressionOpenMouthDetected(int i) {
        AppMethodBeat.i(84323);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84323);
            return false;
        }
        FaceInfo faceInfo = (FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst();
        if (((double) AlgoUtils.getDistance((PointF) faceInfo.points.get(73), (PointF) faceInfo.points.get(81))) > ((double) AlgoUtils.getDistance((PointF) faceInfo.points.get(65), (PointF) faceInfo.points.get(66))) * 0.2d) {
            AppMethodBeat.o(84323);
            return true;
        }
        AppMethodBeat.o(84323);
        return false;
    }

    private boolean isExpressionJumpEyebrowDetected() {
        AppMethodBeat.i(84324);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionJumpEyebrowDetected(i)) {
                AppMethodBeat.o(84324);
                return true;
            }
        }
        AppMethodBeat.o(84324);
        return false;
    }

    private boolean isExpressionJumpEyebrowDetected(int i) {
        AppMethodBeat.i(84325);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84325);
            return false;
        }
        boolean z;
        FaceInfo faceInfo = (FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst();
        double distance = (double) (AlgoUtils.getDistance((PointF) faceInfo.points.get(26), (PointF) faceInfo.points.get(64)) / AlgoUtils.getDistance((PointF) faceInfo.points.get(24), (PointF) faceInfo.points.get(64)));
        ListIterator listIterator = ((LinkedList) this.mFaceQueueList.get(i)).listIterator();
        listIterator.next();
        while (listIterator.hasNext()) {
            faceInfo = (FaceInfo) listIterator.next();
            if (1.04d * distance <= ((double) AlgoUtils.getDistance((PointF) faceInfo.points.get(26), (PointF) faceInfo.points.get(64))) / ((double) AlgoUtils.getDistance((PointF) faceInfo.points.get(24), (PointF) faceInfo.points.get(64)))) {
                z = true;
                break;
            }
        }
        z = false;
        AppMethodBeat.o(84325);
        return z;
    }

    private float pointPairToBearingDegrees(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(84326);
        PointF pointF3 = new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
        float atan2 = (float) (((double) ((float) Math.atan2((double) pointF3.y, (double) pointF3.x))) * 57.29577951308232d);
        if (atan2 > 0.0f) {
            AppMethodBeat.o(84326);
            return atan2;
        }
        atan2 += 360.0f;
        AppMethodBeat.o(84326);
        return atan2;
    }

    private PointF pointSub(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(84327);
        PointF pointF3 = new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
        AppMethodBeat.o(84327);
        return pointF3;
    }

    private double calDistanceSquare(PointF pointF, PointF pointF2) {
        AppMethodBeat.i(84328);
        double pow = Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d);
        AppMethodBeat.o(84328);
        return pow;
    }

    private boolean isExpressionDistanceChangeDetected(int i, int i2) {
        AppMethodBeat.i(84329);
        for (int i3 = 0; i3 < this.mFaceQueueList.size(); i3++) {
            if (isExpressionDistanceChangeDetected(i3, i, i2)) {
                AppMethodBeat.o(84329);
                return true;
            }
        }
        AppMethodBeat.o(84329);
        return false;
    }

    private boolean isExpressionDistanceChangeDetected(int i, int i2, int i3) {
        AppMethodBeat.i(84330);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84330);
            return false;
        }
        boolean z;
        FaceInfo faceInfo = (FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst();
        double calDistanceSquare = calDistanceSquare((PointF) faceInfo.points.get(i2), (PointF) faceInfo.points.get(i3));
        Iterator it = ((LinkedList) this.mFaceQueueList.get(i)).iterator();
        while (it.hasNext()) {
            faceInfo = (FaceInfo) it.next();
            if (calDistanceSquare / calDistanceSquare((PointF) faceInfo.points.get(i2), (PointF) faceInfo.points.get(i3)) < 0.5d) {
                z = true;
                break;
            }
        }
        z = false;
        AppMethodBeat.o(84330);
        return z;
    }

    private boolean isExpressionRightEyeWinkDetected() {
        AppMethodBeat.i(84331);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionDistanceChangeDetected(i, 37, 41)) {
                AppMethodBeat.o(84331);
                return true;
            }
        }
        AppMethodBeat.o(84331);
        return false;
    }

    private boolean isExpressionLeftEyeWinkDetected() {
        AppMethodBeat.i(84332);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionDistanceChangeDetected(i, 47, 51)) {
                AppMethodBeat.o(84332);
                return true;
            }
        }
        AppMethodBeat.o(84332);
        return false;
    }

    private boolean isExpressionNodDetected() {
        AppMethodBeat.i(84333);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionNodDetected(i)) {
                AppMethodBeat.o(84333);
                return true;
            }
        }
        AppMethodBeat.o(84333);
        return false;
    }

    private boolean isExpressionNodDetected(int i) {
        AppMethodBeat.i(84334);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84334);
            return false;
        }
        boolean z;
        float f = 100.0f;
        float f2 = (float) (((double) (((FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst()).angles[0] * 180.0f)) / 3.141592653589793d);
        Iterator it = ((LinkedList) this.mFaceQueueList.get(i)).iterator();
        while (it.hasNext()) {
            float min = Math.min(f, (float) (((double) (((FaceInfo) it.next()).angles[0] * 180.0f)) / 3.141592653589793d));
            if (f2 - min > 5.0f) {
                z = true;
                break;
            }
            f = min;
        }
        z = false;
        AppMethodBeat.o(84334);
        return z;
    }

    private boolean isExpressionShakeHeadDetected() {
        AppMethodBeat.i(84335);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionShakeHeadDetected(i)) {
                AppMethodBeat.o(84335);
                return true;
            }
        }
        AppMethodBeat.o(84335);
        return false;
    }

    private boolean isExpressionShakeHeadDetected(int i) {
        AppMethodBeat.i(84336);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84336);
            return false;
        }
        boolean z;
        float f = 100.0f;
        float f2 = -100.0f;
        Iterator it = ((LinkedList) this.mFaceQueueList.get(i)).iterator();
        while (it.hasNext()) {
            float f3 = (float) (((double) (((FaceInfo) it.next()).angles[1] * 180.0f)) / 3.141592653589793d);
            f = Math.min(f, f3);
            f3 = Math.max(f2, f3);
            if (f3 - f > 7.0f) {
                z = true;
                break;
            }
            f2 = f3;
        }
        z = false;
        AppMethodBeat.o(84336);
        return z;
    }

    private boolean isExpressionShookHeadDetected() {
        AppMethodBeat.i(84337);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionShookHeadDetected(i)) {
                AppMethodBeat.o(84337);
                return true;
            }
        }
        AppMethodBeat.o(84337);
        return false;
    }

    private boolean isExpressionShookHeadDetected(int i) {
        AppMethodBeat.i(84338);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84338);
            return false;
        }
        boolean z;
        FaceInfo faceInfo = (FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst();
        if (((LinkedList) this.mFaceQueueList.get(i)).size() > 1 && AlgoUtils.getDistance((PointF) faceInfo.points.get(2), (PointF) faceInfo.points.get(64)) * 0.7f > AlgoUtils.getDistance((PointF) faceInfo.points.get(64), (PointF) faceInfo.points.get(16))) {
            ListIterator listIterator = ((LinkedList) this.mFaceQueueList.get(i)).listIterator();
            listIterator.next();
            while (listIterator.hasNext()) {
                faceInfo = (FaceInfo) listIterator.next();
                if (AlgoUtils.getDistance((PointF) faceInfo.points.get(64), (PointF) faceInfo.points.get(16)) * 0.7f > AlgoUtils.getDistance((PointF) faceInfo.points.get(2), (PointF) faceInfo.points.get(64))) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        AppMethodBeat.o(84338);
        return z;
    }

    private boolean isExpressionKissDetected() {
        AppMethodBeat.i(84339);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionKissDetected(i)) {
                AppMethodBeat.o(84339);
                return true;
            }
        }
        AppMethodBeat.o(84339);
        return false;
    }

    private boolean isExpressionKissDetected(int i) {
        AppMethodBeat.i(84340);
        if (i < 0 || i >= this.mFaceQueueList.size() || ((LinkedList) this.mFaceQueueList.get(i)).isEmpty()) {
            AppMethodBeat.o(84340);
            return false;
        }
        FaceInfo faceInfo = (FaceInfo) ((LinkedList) this.mFaceQueueList.get(i)).getFirst();
        if (AlgoUtils.getDistance((PointF) faceInfo.points.get(77), (PointF) faceInfo.points.get(69)) / AlgoUtils.getDistance((PointF) faceInfo.points.get(65), (PointF) faceInfo.points.get(66)) >= 0.55f) {
            AppMethodBeat.o(84340);
            return true;
        }
        AppMethodBeat.o(84340);
        return false;
    }

    private boolean isExpressionOpenMouthDetectedForAtLeastOneFace() {
        AppMethodBeat.i(84341);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionOpenMouthDetected(i)) {
                AppMethodBeat.o(84341);
                return true;
            }
        }
        AppMethodBeat.o(84341);
        return false;
    }

    private boolean isExpressionJumpEyebrowDetectedForAtLeastOneFace() {
        AppMethodBeat.i(84342);
        for (int i = 0; i < this.mFaceQueueList.size(); i++) {
            if (isExpressionJumpEyebrowDetected(i)) {
                AppMethodBeat.o(84342);
                return true;
            }
        }
        AppMethodBeat.o(84342);
        return false;
    }

    public static boolean needSaveDetectedExpression(int i) {
        return i == EXPRESSION_TYPE.JUMP_EYE_BROW.value || i == EXPRESSION_TYPE.WINK.value || i == EXPRESSION_TYPE.SHOOK_HEAD.value || i == EXPRESSION_TYPE.RIGHT_EYE_WINK.value || i == EXPRESSION_TYPE.LEFT_EYE_WINK.value || i == EXPRESSION_TYPE.NOD.value || i == EXPRESSION_TYPE.SHAKE_HEAD.value;
    }

    private boolean isFaceDetected() {
        AppMethodBeat.i(84343);
        if (this.mFaceQueueList.isEmpty()) {
            AppMethodBeat.o(84343);
            return false;
        }
        AppMethodBeat.o(84343);
        return true;
    }

    private double calcDistanceOfFeaturePoints(float f, float f2, float f3, float f4) {
        AppMethodBeat.i(84344);
        double sqrt = Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
        AppMethodBeat.o(84344);
        return sqrt;
    }

    public void clearFaceQueue() {
        AppMethodBeat.i(84345);
        for (LinkedList linkedList : this.mFaceQueueList) {
            while (linkedList.size() > 1) {
                linkedList.removeLast();
            }
        }
        AppMethodBeat.o(84345);
    }

    private void clearFaceQueue(int i) {
        AppMethodBeat.i(84346);
        if (i < this.mFaceQueueList.size()) {
            while (((LinkedList) this.mFaceQueueList.get(i)).size() > 1) {
                ((LinkedList) this.mFaceQueueList.get(i)).removeLast();
            }
        }
        AppMethodBeat.o(84346);
    }
}
