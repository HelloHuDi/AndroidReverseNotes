package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;
import java.util.Map;

public class ReshapeEyeNoseLips extends VideoFilterBase {
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeNoseLipsVertexShader_v.glsl");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private float[] angles = new float[]{0.0f, 0.0f, 0.0f};
    private float eyebrowDistance = 1.0f;
    private float eyebrowHeight = 0.0f;
    private float eyebrowTiltAngle = 0.0f;
    private float eyesDistance = 1.0f;
    private float eyesHeight = 0.0f;
    private float eyesSize = 0.1f;
    private float eyesTiltAngle = 0.0f;
    private float eyesWidth = 0.0f;
    private float[] leftEyeCenter = new float[]{0.0f, 0.0f};
    private float[] leftEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] leftEyebrowCenter = new float[]{0.0f, 0.0f};
    private float[] leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
    private float[] lipsCenter = new float[]{0.0f, 0.0f};
    private float lipsHeight = 0.0f;
    private float[] lipsPlainSize = new float[]{0.0f, 0.0f};
    private float lipsProtectAngleLeft = 0.0f;
    private float lipsProtectAngleRight = 0.0f;
    private float[] lipsProtectCenterLeft = new float[]{0.0f, 0.0f};
    private float[] lipsProtectCenterRight = new float[]{0.0f, 0.0f};
    private float[] lipsProtectSizeLeft = new float[]{0.0f, 0.0f};
    private float[] lipsProtectSizeRight = new float[]{0.0f, 0.0f};
    private float lipsSize = 0.0f;
    private float lipsWidth = 0.0f;
    private float lipsYPosition = 0.0f;
    private List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float meshType = 0.0f;
    private float[] nose3DCenter = new float[]{0.0f, 0.0f};
    private float[] noseBottomCenter = new float[]{0.0f, 0.0f};
    private float noseBridgeWidth = 0.1f;
    private float noseOutlineWidth = 0.0f;
    private float[] nosePlainSize = new float[]{0.0f, 0.0f};
    private float nosePosition = 0.0f;
    private float noseSize = 0.0f;
    private float[] noseTipCenter = new float[]{0.0f, 0.0f};
    private float[] noseTipPlaneSize = new float[]{0.0f, 0.0f};
    private float noseTipSize = 1.0f;
    private float[] rightEyeCenter = new float[]{0.0f, 0.0f};
    private float[] rightEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] rightEyebrowCenter = new float[]{0.0f, 0.0f};
    private float[] rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
    private float[] size = new float[]{1.0f, 1.0f};

    static {
        AppMethodBeat.i(82765);
        AppMethodBeat.o(82765);
    }

    public ReshapeEyeNoseLips(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.i(82760);
        if (i == 0) {
            this.meshType = 0.5f;
        } else {
            this.meshType = 0.0f;
        }
        initParams();
        AppMethodBeat.o(82760);
    }

    public void initParams() {
        AppMethodBeat.i(82761);
        addParam(new g("leftEyePlainSize", this.leftEyePlainSize));
        addParam(new g("leftEyeCenter", this.leftEyeCenter));
        addParam(new g("rightEyePlainSize", this.rightEyePlainSize));
        addParam(new g("rightEyeCenter", this.rightEyeCenter));
        addParam(new g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
        addParam(new g("leftEyebrowCenter", this.leftEyebrowCenter));
        addParam(new g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
        addParam(new g("rightEyebrowCenter", this.rightEyebrowCenter));
        addParam(new g("nose3DCenter", this.nose3DCenter));
        addParam(new g("nosePlainSize", this.nosePlainSize));
        addParam(new g("noseTipCenter", this.noseTipCenter));
        addParam(new g("noseTipPlaneSize", this.noseTipPlaneSize));
        addParam(new g("noseBottomCenter", this.noseBottomCenter));
        addParam(new g("lipsCenter", this.lipsCenter));
        addParam(new g("lipsPlainSize", this.lipsPlainSize));
        addParam(new g("lipsProtectSizeLeft", this.lipsProtectSizeLeft));
        addParam(new g("lipsProtectCenterLeft", this.lipsProtectCenterLeft));
        addParam(new f("lipsProtectAngleLeft", this.lipsProtectAngleLeft));
        addParam(new g("lipsProtectSizeRight", this.lipsProtectSizeRight));
        addParam(new g("lipsProtectCenterRight", this.lipsProtectCenterRight));
        addParam(new f("lipsProtectAngleRight", this.lipsProtectAngleRight));
        addParam(new f("eyebrowHeight", this.eyebrowHeight));
        addParam(new f("eyebrowDistance", this.eyebrowDistance));
        addParam(new f("eyebrowTiltAngle", this.eyebrowTiltAngle));
        addParam(new f("eyesSize", this.eyesSize));
        addParam(new f("eyesWidth", this.eyesWidth));
        addParam(new f("eyesHeight", this.eyesHeight));
        addParam(new f("eyesTiltAngle", this.eyesTiltAngle));
        addParam(new f("eyesDistance", this.eyesDistance));
        addParam(new f("noseSize", this.noseSize));
        addParam(new f("noseOutlineWidth", this.noseOutlineWidth));
        addParam(new f("noseBridgeWidth", this.noseBridgeWidth));
        addParam(new f("nosePosition", this.nosePosition));
        addParam(new f("noseTipSize", this.noseTipSize));
        addParam(new f("lipsSize", this.lipsSize));
        addParam(new f("lipsWidth", this.lipsWidth));
        addParam(new f("lipsHeight", this.lipsHeight));
        addParam(new f("lipsYPosition", this.lipsYPosition));
        addParam(new g("angles", this.angles));
        addParam(new g("size", this.size));
        addParam(new f("meshType", this.meshType));
        float cos = (float) Math.cos((double) this.angles[2]);
        addParam(new f("sin_t", (float) Math.sin((double) this.angles[2])));
        addParam(new f("cos_t", cos));
        AppMethodBeat.o(82761);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82762);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82762);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82763);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82763);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82764);
        if (map.containsKey("leftEyebrowPlainSize")) {
            this.leftEyebrowPlainSize = (float[]) map.get("leftEyebrowPlainSize");
        }
        if (map.containsKey("leftEyebrowCenter")) {
            this.leftEyebrowCenter = (float[]) map.get("leftEyebrowCenter");
        }
        if (map.containsKey("rightEyebrowPlainSize")) {
            this.rightEyebrowPlainSize = (float[]) map.get("rightEyebrowPlainSize");
        }
        if (map.containsKey("rightEyebrowCenter")) {
            this.rightEyebrowCenter = (float[]) map.get("rightEyebrowCenter");
        }
        if (map.containsKey("leftEyePlainSize")) {
            this.leftEyePlainSize = (float[]) map.get("leftEyePlainSize");
        }
        if (map.containsKey("leftEyeCenter")) {
            this.leftEyeCenter = (float[]) map.get("leftEyeCenter");
        }
        if (map.containsKey("rightEyePlainSize")) {
            this.rightEyePlainSize = (float[]) map.get("rightEyePlainSize");
        }
        if (map.containsKey("rightEyeCenter")) {
            this.rightEyeCenter = (float[]) map.get("rightEyeCenter");
        }
        if (map.containsKey("nose3DCenter")) {
            this.nose3DCenter = (float[]) map.get("nose3DCenter");
        }
        if (map.containsKey("nosePlainSize")) {
            this.nosePlainSize = (float[]) map.get("nosePlainSize");
        }
        if (map.containsKey("noseTipCenter")) {
            this.noseTipCenter = (float[]) map.get("noseTipCenter");
        }
        if (map.containsKey("noseTipPlaneSize")) {
            this.noseTipPlaneSize = (float[]) map.get("noseTipPlaneSize");
        }
        if (map.containsKey("noseBottomCenter")) {
            this.noseBottomCenter = (float[]) map.get("noseBottomCenter");
        }
        if (map.containsKey("lipsCenter")) {
            this.lipsCenter = (float[]) map.get("lipsCenter");
        }
        if (map.containsKey("lipsPlainSize")) {
            this.lipsPlainSize = (float[]) map.get("lipsPlainSize");
        }
        if (map.containsKey("lipsProtectSizeLeft")) {
            this.lipsProtectSizeLeft = (float[]) map.get("lipsProtectSizeLeft");
        }
        if (map.containsKey("lipsProtectCenterLeft")) {
            this.lipsProtectCenterLeft = (float[]) map.get("lipsProtectCenterLeft");
        }
        if (map.containsKey("lipsProtectAngleLeft")) {
            this.lipsProtectAngleLeft = ((Float) map.get("lipsProtectAngleLeft")).floatValue();
        }
        if (map.containsKey("lipsProtectSizeRight")) {
            this.lipsProtectSizeRight = (float[]) map.get("lipsProtectSizeRight");
        }
        if (map.containsKey("lipsProtectCenterRight")) {
            this.lipsProtectCenterRight = (float[]) map.get("lipsProtectCenterRight");
        }
        if (map.containsKey("lipsProtectAngleRight")) {
            this.lipsProtectAngleRight = ((Float) map.get("lipsProtectAngleRight")).floatValue();
        }
        if (map.containsKey("eyebrowHeight")) {
            this.eyebrowHeight = ((Float) map.get("eyebrowHeight")).floatValue() * 0.006f;
        }
        if (map.containsKey("eyebrowDistance")) {
            this.eyebrowDistance = ((Float) map.get("eyebrowDistance")).floatValue() * 0.009f;
        }
        if (map.containsKey("eyebrowAngle")) {
            this.eyebrowTiltAngle = ((Float) map.get("eyebrowAngle")).floatValue() * 0.0017f;
        }
        if (map.containsKey("eyesWidth")) {
            this.eyesWidth = ((Float) map.get("eyesWidth")).floatValue() * -0.003f;
        }
        if (map.containsKey("eyesHeight")) {
            this.eyesHeight = ((Float) map.get("eyesHeight")).floatValue() * -0.004f;
        }
        if (map.containsKey("eyesSize")) {
            this.eyesSize = ((Float) map.get("eyesSize")).floatValue() * -0.0032f;
        }
        if (map.containsKey("eyesTiltAngle")) {
            this.eyesTiltAngle = ((Float) map.get("eyesTiltAngle")).floatValue() * 0.001f;
        }
        if (map.containsKey("eyesDistance")) {
            this.eyesDistance = ((Float) map.get("eyesDistance")).floatValue() * 0.016f;
        }
        if (map.containsKey("noseSize")) {
            this.noseSize = ((Float) map.get("noseSize")).floatValue() * 0.006f;
        }
        if (map.containsKey("noseOutlineWidth")) {
            this.noseOutlineWidth = ((Float) map.get("noseOutlineWidth")).floatValue() * 0.01f;
        }
        if (map.containsKey("noseBridgeWidth")) {
            this.noseBridgeWidth = ((Float) map.get("noseBridgeWidth")).floatValue() * 0.008f;
        }
        if (map.containsKey("nosePosition")) {
            this.nosePosition = ((Float) map.get("nosePosition")).floatValue() * 0.008f;
        }
        if (map.containsKey("noseTipSize")) {
            this.noseTipSize = ((Float) map.get("noseTipSize")).floatValue() * -0.02f;
        }
        if (map.containsKey("lipsSize")) {
            this.lipsSize = ((Float) map.get("lipsSize")).floatValue() * -0.003f;
        }
        if (map.containsKey("lipsHeight")) {
            this.lipsHeight = ((Float) map.get("lipsHeight")).floatValue() * -0.008f;
        }
        if (map.containsKey("lipsWidth")) {
            this.lipsWidth = ((Float) map.get("lipsWidth")).floatValue() * -0.0038f;
            if (this.lipsWidth < 0.0f) {
                this.lipsWidth *= 0.8f;
            }
        }
        if (map.containsKey("lipsYPosition")) {
            this.lipsYPosition = ((Float) map.get("lipsYPosition")).floatValue() * -0.01f;
            if (this.lipsYPosition < 0.0f) {
                this.lipsYPosition *= 1.4f;
            }
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.o(82764);
    }
}
