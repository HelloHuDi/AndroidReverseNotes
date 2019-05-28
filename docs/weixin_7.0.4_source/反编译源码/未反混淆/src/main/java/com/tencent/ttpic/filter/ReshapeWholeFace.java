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

public class ReshapeWholeFace extends VideoFilterBase {
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeWholeFaceVertexShader_v.glsl");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private float[] angles = new float[]{0.0f, 0.0f, 0.0f};
    private float[] faceCenter = new float[]{0.0f, 0.0f};
    private float[] faceCenterLeft2 = new float[]{0.0f, 0.0f};
    private float[] faceCenterRight2 = new float[]{0.0f, 0.0f};
    private float faceJaw = 0.0f;
    private float[] faceMoveCenter2 = new float[]{0.0f, 0.0f, 0.0f};
    private float[] facePlainSize = new float[]{0.0f, 0.0f};
    private float[] facePlainSizeLeft2 = new float[]{0.0f, 0.0f};
    private float[] facePlainSizeRight2 = new float[]{0.0f, 0.0f};
    private float faceSmile = 0.0f;
    private float faceWidth = 1.0f;
    private float faceWidth2 = 1.0f;
    private float[] foreheadCenter = new float[]{0.0f, 0.0f};
    private float foreheadHeight = 0.0f;
    private float[] foreheadSize = new float[]{0.0f, 0.0f};
    private float[] jawCenterOfGravity = new float[]{0.0f, 0.0f};
    private float[] jawSize = new float[]{0.0f, 0.0f};
    private float leftAngle2 = 0.0f;
    private float[] leftEyeCenter = new float[]{0.0f, 0.0f};
    private float[] leftEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] leftEyebrowCenter = new float[]{0.0f, 0.0f};
    private float[] leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
    private float[] lipsCenter = new float[]{0.0f, 0.0f};
    private float[] lipsLeftEdge = new float[]{0.0f, 0.0f};
    private float[] lipsPlainSize = new float[]{0.0f, 0.0f};
    private float[] lipsRightEdge = new float[]{0.0f, 0.0f};
    private List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float meshType = 0.0f;
    private float[] nose3DCenter = new float[]{0.0f, 0.0f};
    private float[] nosePlainSize = new float[]{0.0f, 0.0f};
    private float rightAngle2 = 0.0f;
    private float[] rightEyeCenter = new float[]{0.0f, 0.0f};
    private float[] rightEyePlainSize = new float[]{0.0f, 0.0f};
    private float[] rightEyebrowCenter = new float[]{0.0f, 0.0f};
    private float[] rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
    private float[] size = new float[]{1.0f, 1.0f};

    static {
        AppMethodBeat.i(82819);
        AppMethodBeat.o(82819);
    }

    public ReshapeWholeFace(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.i(82814);
        if (i == 0) {
            this.meshType = 0.5f;
        } else {
            this.meshType = 0.0f;
        }
        initParams();
        AppMethodBeat.o(82814);
    }

    public void initParams() {
        AppMethodBeat.i(82815);
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
        addParam(new g("lipsCenter", this.lipsCenter));
        addParam(new g("lipsPlainSize", this.lipsPlainSize));
        addParam(new g("lipsLeftEdge", this.lipsLeftEdge));
        addParam(new g("lipsRightEdge", this.lipsRightEdge));
        addParam(new g("facePlainSize", this.facePlainSize));
        addParam(new g("faceCenter", this.faceCenter));
        addParam(new g("facePlainSizeLeft2", this.facePlainSizeLeft2));
        addParam(new g("faceCenterLeft2", this.faceCenterLeft2));
        addParam(new f("leftAngle2", this.leftAngle2));
        addParam(new g("facePlainSizeRight2", this.facePlainSizeRight2));
        addParam(new g("faceCenterRight2", this.faceCenterRight2));
        addParam(new f("rightAngle2", this.rightAngle2));
        addParam(new g("faceMoveCenter2", this.faceMoveCenter2));
        addParam(new g("jawCenterOfGravity", this.jawCenterOfGravity));
        addParam(new g("jawSize", this.jawSize));
        addParam(new g("foreheadSize", this.foreheadSize));
        addParam(new g("foreheadCenter", this.foreheadCenter));
        addParam(new f("faceWidth", this.faceWidth));
        addParam(new f("faceWidth2", this.faceWidth2));
        addParam(new f("faceJaw", this.faceJaw));
        addParam(new f("faceSmile", this.faceSmile));
        addParam(new f("foreheadHeight", this.foreheadHeight));
        addParam(new g("angles", this.angles));
        addParam(new g("size", this.size));
        addParam(new f("meshType", this.meshType));
        float cos = (float) Math.cos((double) this.angles[2]);
        addParam(new f("sin_t", (float) Math.sin((double) this.angles[2])));
        addParam(new f("cos_t", cos));
        AppMethodBeat.o(82815);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82816);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) this.mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) this.mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82816);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82817);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82817);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82818);
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
        if (map.containsKey("nose3DCenter")) {
            this.nose3DCenter = (float[]) map.get("nose3DCenter");
        }
        if (map.containsKey("nosePlainSize")) {
            this.nosePlainSize = (float[]) map.get("nosePlainSize");
        }
        if (map.containsKey("lipsCenter")) {
            this.lipsCenter = (float[]) map.get("lipsCenter");
        }
        if (map.containsKey("lipsPlainSize")) {
            this.lipsPlainSize = (float[]) map.get("lipsPlainSize");
        }
        if (map.containsKey("lipsLeftEdge")) {
            this.lipsLeftEdge = (float[]) map.get("lipsLeftEdge");
        }
        if (map.containsKey("lipsRightEdge")) {
            this.lipsRightEdge = (float[]) map.get("lipsRightEdge");
        }
        if (map.containsKey("facePlainSize")) {
            this.facePlainSize = (float[]) map.get("facePlainSize");
        }
        if (map.containsKey("faceCenter")) {
            this.faceCenter = (float[]) map.get("faceCenter");
        }
        if (map.containsKey("facePlainSizeLeft2")) {
            this.facePlainSizeLeft2 = (float[]) map.get("facePlainSizeLeft2");
        }
        if (map.containsKey("faceCenterLeft2")) {
            this.faceCenterLeft2 = (float[]) map.get("faceCenterLeft2");
        }
        if (map.containsKey("leftAngle2")) {
            this.leftAngle2 = ((Float) map.get("leftAngle2")).floatValue();
        }
        if (map.containsKey("facePlainSizeRight2")) {
            this.facePlainSizeRight2 = (float[]) map.get("facePlainSizeRight2");
        }
        if (map.containsKey("faceCenterRight2")) {
            this.faceCenterRight2 = (float[]) map.get("faceCenterRight2");
        }
        if (map.containsKey("rightAngle2")) {
            this.rightAngle2 = ((Float) map.get("rightAngle2")).floatValue();
        }
        if (map.containsKey("faceMoveCenter2")) {
            this.faceMoveCenter2 = (float[]) map.get("faceMoveCenter2");
        }
        if (map.containsKey("jawCenterOfGravity")) {
            this.jawCenterOfGravity = (float[]) map.get("jawCenterOfGravity");
        }
        if (map.containsKey("foreheadSize")) {
            this.foreheadSize = (float[]) map.get("foreheadSize");
        }
        if (map.containsKey("foreheadCenter")) {
            this.foreheadCenter = (float[]) map.get("foreheadCenter");
        }
        if (map.containsKey("jawSize")) {
            this.jawSize = (float[]) map.get("jawSize");
        }
        if (map.containsKey("foreheadHeight")) {
            this.foreheadHeight = ((Float) map.get("foreheadHeight")).floatValue() * 0.02f;
            if (this.foreheadHeight > 0.0f) {
                this.foreheadHeight *= 1.5f;
            }
        }
        if (map.containsKey("faceJaw")) {
            this.faceJaw = ((Float) map.get("faceJaw")).floatValue() * 0.01f;
        }
        if (map.containsKey("faceSmile")) {
            this.faceSmile = ((Float) map.get("faceSmile")).floatValue() * 0.03f;
        }
        if (map.containsKey("faceWidth")) {
            this.faceWidth = ((Float) map.get("faceWidth")).floatValue() * 0.0011999999f;
            if (this.faceWidth > 0.0f) {
                this.faceWidth *= 1.15f;
            }
        }
        if (map.containsKey("faceWidth2")) {
            this.faceWidth2 = ((Float) map.get("faceWidth2")).floatValue() * 0.0017f;
            if (this.faceWidth2 > 0.0f) {
                this.faceWidth2 *= 1.15f;
            }
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.o(82818);
    }
}
