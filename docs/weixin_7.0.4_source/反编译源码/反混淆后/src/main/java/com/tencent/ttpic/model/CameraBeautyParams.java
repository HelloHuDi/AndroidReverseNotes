package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraBeautyParams implements Serializable {
    public static final int RESHAPE_FILTER_ID_EYEBROW_ANGLE = 23;
    public static final int RESHAPE_FILTER_ID_EYEBROW_DISTANCE = 21;
    public static final int RESHAPE_FILTER_ID_EYEBROW_HEIGHT = 20;
    public static final int RESHAPE_FILTER_ID_EYES_ANGLE = 5;
    public static final int RESHAPE_FILTER_ID_EYES_DISTANCE = 6;
    public static final int RESHAPE_FILTER_ID_EYES_HEIGHT = 3;
    public static final int RESHAPE_FILTER_ID_EYES_SIZE = 4;
    public static final int RESHAPE_FILTER_ID_EYES_WIDTH = 2;
    public static final int RESHAPE_FILTER_ID_FACEOFF = 0;
    public static final int RESHAPE_FILTER_ID_FACE_JAW = 17;
    public static final int RESHAPE_FILTER_ID_FACE_SMILE = 16;
    public static final int RESHAPE_FILTER_ID_FACE_V = 19;
    public static final int RESHAPE_FILTER_ID_FACE_WIDTH = 18;
    public static final int RESHAPE_FILTER_ID_FOREHEAD_HEIGHT = 22;
    public static final int RESHAPE_FILTER_ID_LIPS_HEIGHT = 13;
    public static final int RESHAPE_FILTER_ID_LIPS_POSITION = 15;
    public static final int RESHAPE_FILTER_ID_LIPS_SIZE = 12;
    public static final int RESHAPE_FILTER_ID_LIPS_WIDTH = 14;
    public static final int RESHAPE_FILTER_ID_NOSE_BRIDGE_WIDTH = 9;
    public static final int RESHAPE_FILTER_ID_NOSE_OUTLINE_WIDTH = 8;
    public static final int RESHAPE_FILTER_ID_NOSE_POSITION = 10;
    public static final int RESHAPE_FILTER_ID_NOSE_SIZE = 7;
    public static final int RESHAPE_FILTER_ID_NOSE_TIP_SIZE = 11;
    public static final int RESHAPE_FILTER_ID_TOTAL = 1;
    public static List<Integer> RESHAPE_OTHER_FACE_PARAM = new ArrayList();
    public static final int[] RESHAPE_WHOLE_FACE_PARAM = new int[]{16, 17, 18, 19, 22};
    public float[] mProgress = new float[24];
    public Map<String, Object> param = new HashMap();

    public CameraBeautyParams() {
        AppMethodBeat.m2504i(83454);
        AppMethodBeat.m2505o(83454);
    }

    static {
        AppMethodBeat.m2504i(83460);
        for (int i = 0; i < 24; i++) {
            if (!isInWholeFaceParam(i)) {
                RESHAPE_OTHER_FACE_PARAM.add(Integer.valueOf(i));
            }
        }
        AppMethodBeat.m2505o(83460);
    }

    private static boolean isInWholeFaceParam(int i) {
        for (int i2 : RESHAPE_WHOLE_FACE_PARAM) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public void updateReshapeParams() {
        AppMethodBeat.m2504i(83455);
        this.param.clear();
        this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
        this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
        this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
        this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
        this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
        this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
        this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
        this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
        this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
        this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
        this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
        this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
        this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
        this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
        this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
        this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
        this.param.put("faceWidth", Float.valueOf(this.mProgress[18]));
        this.param.put("faceWidth2", Float.valueOf(this.mProgress[19]));
        this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
        this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
        this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
        this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
        AppMethodBeat.m2505o(83455);
    }

    public void updateReshapeParams4() {
        AppMethodBeat.m2504i(83456);
        this.param.clear();
        this.param.put("eyesWidth", Float.valueOf(this.mProgress[2]));
        this.param.put("eyesHeight", Float.valueOf(this.mProgress[3]));
        this.param.put("eyesSize", Float.valueOf(this.mProgress[4]));
        this.param.put("eyesTiltAngle", Float.valueOf(this.mProgress[5]));
        this.param.put("eyesDistance", Float.valueOf(this.mProgress[6]));
        this.param.put("noseSize", Float.valueOf(this.mProgress[7]));
        this.param.put("noseOutlineWidth", Float.valueOf(this.mProgress[8]));
        this.param.put("noseBridgeWidth", Float.valueOf(this.mProgress[9]));
        this.param.put("nosePosition", Float.valueOf(this.mProgress[10]));
        this.param.put("noseTipSize", Float.valueOf(this.mProgress[11]));
        this.param.put("lipsSize", Float.valueOf(this.mProgress[12]));
        this.param.put("lipsWidth", Float.valueOf(this.mProgress[14]));
        this.param.put("lipsHeight", Float.valueOf(this.mProgress[13]));
        this.param.put("lipsYPosition", Float.valueOf(this.mProgress[15]));
        this.param.put("eyebrowHeight", Float.valueOf(this.mProgress[20]));
        this.param.put("eyebrowDistance", Float.valueOf(this.mProgress[21]));
        this.param.put("eyebrowAngle", Float.valueOf(this.mProgress[23]));
        this.param.put("faceSmile", Float.valueOf(this.mProgress[16]));
        this.param.put("faceJaw", Float.valueOf(this.mProgress[17]));
        this.param.put("faceWidth", Float.valueOf(this.mProgress[18]));
        this.param.put("faceWidth2", Float.valueOf(this.mProgress[19]));
        this.param.put("foreheadHeight", Float.valueOf(this.mProgress[22]));
        AppMethodBeat.m2505o(83456);
    }

    public void setParam(int i, float f) {
        if (i == TYPE.FOREHEAD.value) {
            this.mProgress[22] = f;
        } else if (i == TYPE.EYE.value) {
            this.mProgress[4] = f;
        } else if (i == TYPE.EYE_DISTANCE.value) {
            this.mProgress[6] = f;
        } else if (i == TYPE.EYE_ANGLE.value) {
            this.mProgress[5] = f;
        } else if (i == TYPE.MOUTH_SHAPE.value) {
            this.mProgress[12] = -f;
        } else if (i == TYPE.CHIN.value) {
            this.mProgress[17] = f;
        } else if (i == TYPE.FACE_THIN.value) {
            this.mProgress[18] = f;
        } else if (i == TYPE.FACE_V.value) {
            this.mProgress[19] = f;
        } else if (i == TYPE.NOSE_WING.value) {
            this.mProgress[8] = f;
        } else if (i == TYPE.NOSE_POSITION.value) {
            this.mProgress[10] = f;
        } else if (i == TYPE.LIPS_THICKNESS.value) {
            this.mProgress[13] = f;
        } else if (i == TYPE.LIPS_WIDTH.value) {
            this.mProgress[14] = f;
        }
    }

    public boolean needRenderWholeFace() {
        AppMethodBeat.m2504i(83457);
        for (int i : RESHAPE_WHOLE_FACE_PARAM) {
            if (((double) Math.abs(this.mProgress[i])) > 0.001d) {
                AppMethodBeat.m2505o(83457);
                return true;
            }
        }
        AppMethodBeat.m2505o(83457);
        return false;
    }

    public boolean needRenderEyeNoseLips() {
        AppMethodBeat.m2504i(83458);
        for (Integer intValue : RESHAPE_OTHER_FACE_PARAM) {
            if (((double) Math.abs(this.mProgress[intValue.intValue()])) > 0.001d) {
                AppMethodBeat.m2505o(83458);
                return true;
            }
        }
        AppMethodBeat.m2505o(83458);
        return false;
    }

    public boolean needRender() {
        AppMethodBeat.m2504i(83459);
        if (needRenderEyeNoseLips() || needRenderWholeFace()) {
            AppMethodBeat.m2505o(83459);
            return true;
        }
        AppMethodBeat.m2505o(83459);
        return false;
    }
}
