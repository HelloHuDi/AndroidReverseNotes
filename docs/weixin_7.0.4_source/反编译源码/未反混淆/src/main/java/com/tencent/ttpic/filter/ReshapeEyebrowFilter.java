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

public class ReshapeEyebrowFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyebrowVertexShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyebrowVertexShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float eyebrowDistance;
    private float eyebrowHeight;
    private float eyebrowTiltAngle;
    private float[] leftEyeCenter;
    private float[] leftEyePlainSize;
    private float[] leftEyebrowCenter;
    private float[] leftEyebrowPlainSize;
    private float meshType;
    private float[] nose3DCenter;
    private float[] nosePlainSize;
    private float[] rightEyeCenter;
    private float[] rightEyePlainSize;
    private float[] rightEyebrowCenter;
    private float[] rightEyebrowPlainSize;
    private float[] size;

    static {
        AppMethodBeat.i(82772);
        AppMethodBeat.o(82772);
    }

    public ReshapeEyebrowFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.i(82766);
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
        this.eyebrowHeight = 0.0f;
        this.eyebrowDistance = 1.0f;
        this.eyebrowTiltAngle = 0.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.o(82766);
    }

    public ReshapeEyebrowFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.i(82767);
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
        this.eyebrowHeight = 0.0f;
        this.eyebrowDistance = 1.0f;
        this.eyebrowTiltAngle = 0.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.o(82767);
    }

    public void initParams() {
        AppMethodBeat.i(82768);
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
        addParam(new f("eyebrowHeight", this.eyebrowHeight));
        addParam(new f("eyebrowDistance", this.eyebrowDistance));
        addParam(new f("eyebrowTiltAngle", this.eyebrowTiltAngle));
        addParam(new g("angles", this.angles));
        addParam(new g("size", this.size));
        addParam(new f("meshType", this.meshType));
        AppMethodBeat.o(82768);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82769);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82769);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82770);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82770);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82771);
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
        if (map.containsKey("eyebrowHeight")) {
            this.eyebrowHeight = ((Float) map.get("eyebrowHeight")).floatValue() * 0.006f;
        }
        if (map.containsKey("eyebrowDistance")) {
            this.eyebrowDistance = ((Float) map.get("eyebrowDistance")).floatValue() * 0.009f;
        }
        if (map.containsKey("eyebrowAngle")) {
            this.eyebrowTiltAngle = ((Float) map.get("eyebrowAngle")).floatValue() * 0.0017f;
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.o(82771);
    }
}
