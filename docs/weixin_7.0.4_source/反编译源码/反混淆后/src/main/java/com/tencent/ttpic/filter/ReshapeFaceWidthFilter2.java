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

public class ReshapeFaceWidthFilter2 extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader2.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeFaceWidthVertexShader2_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float[] faceCenter;
    private float[] faceCenterLeft2;
    private float[] faceCenterRight2;
    private float[] faceMoveCenter2;
    private float[] facePlainSize;
    private float[] facePlainSizeLeft2;
    private float[] facePlainSizeRight2;
    private float faceWidth;
    private float faceWidth2;
    private float leftAngle2;
    private float[] leftEyeCenter;
    private float[] leftEyePlainSize;
    private float[] leftEyebrowCenter;
    private float[] leftEyebrowPlainSize;
    private float[] lipsCenter;
    private float[] lipsPlainSize;
    private float meshType;
    private float[] nose3DCenter;
    private float[] nosePlainSize;
    private float rightAngle2;
    private float[] rightEyeCenter;
    private float[] rightEyePlainSize;
    private float[] rightEyebrowCenter;
    private float[] rightEyebrowPlainSize;
    private float[] size;

    static {
        AppMethodBeat.m2504i(82785);
        AppMethodBeat.m2505o(82785);
    }

    public ReshapeFaceWidthFilter2(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82779);
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.rightEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.facePlainSize = new float[]{0.0f, 0.0f};
        this.faceCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.facePlainSizeLeft2 = new float[]{0.0f, 0.0f};
        this.faceCenterLeft2 = new float[]{0.0f, 0.0f, 0.0f};
        this.leftAngle2 = 0.0f;
        this.facePlainSizeRight2 = new float[]{0.0f, 0.0f};
        this.faceCenterRight2 = new float[]{0.0f, 0.0f, 0.0f};
        this.rightAngle2 = 0.0f;
        this.faceMoveCenter2 = new float[]{0.0f, 0.0f, 0.0f};
        this.faceWidth = 1.0f;
        this.faceWidth2 = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.m2505o(82779);
    }

    public ReshapeFaceWidthFilter2(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.m2504i(82780);
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.rightEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.facePlainSize = new float[]{0.0f, 0.0f};
        this.faceCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.facePlainSizeLeft2 = new float[]{0.0f, 0.0f};
        this.faceCenterLeft2 = new float[]{0.0f, 0.0f, 0.0f};
        this.leftAngle2 = 0.0f;
        this.facePlainSizeRight2 = new float[]{0.0f, 0.0f};
        this.faceCenterRight2 = new float[]{0.0f, 0.0f, 0.0f};
        this.rightAngle2 = 0.0f;
        this.faceMoveCenter2 = new float[]{0.0f, 0.0f, 0.0f};
        this.faceWidth = 1.0f;
        this.faceWidth2 = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.m2505o(82780);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82781);
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
        addParam(new C0934g("lipsCenter", this.lipsCenter));
        addParam(new C0934g("lipsPlainSize", this.lipsPlainSize));
        addParam(new C0934g("facePlainSize", this.facePlainSize));
        addParam(new C0934g("faceCenter", this.faceCenter));
        addParam(new C0934g("facePlainSizeLeft2", this.facePlainSizeLeft2));
        addParam(new C0934g("faceCenterLeft2", this.faceCenterLeft2));
        addParam(new C0933f("leftAngle2", this.leftAngle2));
        addParam(new C0934g("facePlainSizeRight2", this.facePlainSizeRight2));
        addParam(new C0934g("faceCenterRight2", this.faceCenterRight2));
        addParam(new C0933f("rightAngle2", this.rightAngle2));
        addParam(new C0934g("faceMoveCenter2", this.faceMoveCenter2));
        addParam(new C0933f("faceWidth", this.faceWidth));
        addParam(new C0933f("faceWidth2", this.faceWidth2));
        addParam(new C0934g("angles", this.angles));
        addParam(new C0934g("size", this.size));
        addParam(new C0933f("meshType", this.meshType));
        AppMethodBeat.m2505o(82781);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82782);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.m2505o(82782);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82783);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(82783);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(82784);
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
        AppMethodBeat.m2505o(82784);
    }
}
