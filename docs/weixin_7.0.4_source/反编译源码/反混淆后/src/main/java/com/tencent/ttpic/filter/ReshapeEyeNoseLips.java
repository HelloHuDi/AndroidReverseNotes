package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
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
        AppMethodBeat.m2504i(82765);
        AppMethodBeat.m2505o(82765);
    }

    public ReshapeEyeNoseLips(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.m2504i(82760);
        if (i == 0) {
            this.meshType = 0.5f;
        } else {
            this.meshType = 0.0f;
        }
        initParams();
        AppMethodBeat.m2505o(82760);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82761);
        addParam(new C0934g("leftEyePlainSize", this.leftEyePlainSize));
        addParam(new C0934g("leftEyeCenter", this.leftEyeCenter));
        addParam(new C0934g("rightEyePlainSize", this.rightEyePlainSize));
        addParam(new C0934g("rightEyeCenter", this.rightEyeCenter));
        addParam(new C0934g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
        addParam(new C0934g("leftEyebrowCenter", this.leftEyebrowCenter));
        addParam(new C0934g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
        addParam(new C0934g("rightEyebrowCenter", this.rightEyebrowCenter));
        addParam(new C0934g("nose3DCenter", this.nose3DCenter));
        addParam(new C0934g("nosePlainSize", this.nosePlainSize));
        addParam(new C0934g("noseTipCenter", this.noseTipCenter));
        addParam(new C0934g("noseTipPlaneSize", this.noseTipPlaneSize));
        addParam(new C0934g("noseBottomCenter", this.noseBottomCenter));
        addParam(new C0934g("lipsCenter", this.lipsCenter));
        addParam(new C0934g("lipsPlainSize", this.lipsPlainSize));
        addParam(new C0934g("lipsProtectSizeLeft", this.lipsProtectSizeLeft));
        addParam(new C0934g("lipsProtectCenterLeft", this.lipsProtectCenterLeft));
        addParam(new C0933f("lipsProtectAngleLeft", this.lipsProtectAngleLeft));
        addParam(new C0934g("lipsProtectSizeRight", this.lipsProtectSizeRight));
        addParam(new C0934g("lipsProtectCenterRight", this.lipsProtectCenterRight));
        addParam(new C0933f("lipsProtectAngleRight", this.lipsProtectAngleRight));
        addParam(new C0933f("eyebrowHeight", this.eyebrowHeight));
        addParam(new C0933f("eyebrowDistance", this.eyebrowDistance));
        addParam(new C0933f("eyebrowTiltAngle", this.eyebrowTiltAngle));
        addParam(new C0933f("eyesSize", this.eyesSize));
        addParam(new C0933f("eyesWidth", this.eyesWidth));
        addParam(new C0933f("eyesHeight", this.eyesHeight));
        addParam(new C0933f("eyesTiltAngle", this.eyesTiltAngle));
        addParam(new C0933f("eyesDistance", this.eyesDistance));
        addParam(new C0933f("noseSize", this.noseSize));
        addParam(new C0933f("noseOutlineWidth", this.noseOutlineWidth));
        addParam(new C0933f("noseBridgeWidth", this.noseBridgeWidth));
        addParam(new C0933f("nosePosition", this.nosePosition));
        addParam(new C0933f("noseTipSize", this.noseTipSize));
        addParam(new C0933f("lipsSize", this.lipsSize));
        addParam(new C0933f("lipsWidth", this.lipsWidth));
        addParam(new C0933f("lipsHeight", this.lipsHeight));
        addParam(new C0933f("lipsYPosition", this.lipsYPosition));
        addParam(new C0934g("angles", this.angles));
        addParam(new C0934g("size", this.size));
        addParam(new C0933f("meshType", this.meshType));
        float cos = (float) Math.cos((double) this.angles[2]);
        addParam(new C0933f("sin_t", (float) Math.sin((double) this.angles[2])));
        addParam(new C0933f("cos_t", cos));
        AppMethodBeat.m2505o(82761);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82762);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.m2505o(82762);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82763);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(82763);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(82764);
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
        AppMethodBeat.m2505o(82764);
    }
}
