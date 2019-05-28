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

public class ReshapeForeheadFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeForeheadVertexShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float[] foreheadCenter;
    private float foreheadHeight;
    private float[] foreheadSize;
    private float[] leftEyebrowCenter;
    private float[] leftEyebrowPlainSize;
    private float meshType;
    private float[] rightEyebrowCenter;
    private float[] rightEyebrowPlainSize;
    private float[] size;

    static {
        AppMethodBeat.i(82792);
        AppMethodBeat.o(82792);
    }

    public ReshapeForeheadFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.i(82786);
        this.foreheadCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.foreheadSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.rightEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.foreheadHeight = 0.0f;
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.o(82786);
    }

    public ReshapeForeheadFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.i(82787);
        this.foreheadCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.foreheadSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyebrowPlainSize = new float[]{0.0f, 0.0f};
        this.rightEyebrowCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.foreheadHeight = 0.0f;
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.o(82787);
    }

    public void initParams() {
        AppMethodBeat.i(82788);
        addParam(new g("foreheadSize", this.foreheadSize));
        addParam(new g("foreheadCenter", this.foreheadCenter));
        addParam(new g("leftEyebrowPlainSize", this.leftEyebrowPlainSize));
        addParam(new g("leftEyebrowCenter", this.leftEyebrowCenter));
        addParam(new g("rightEyebrowPlainSize", this.rightEyebrowPlainSize));
        addParam(new g("rightEyebrowCenter", this.rightEyebrowCenter));
        addParam(new f("foreheadHeight", this.foreheadHeight));
        addParam(new g("angles", this.angles));
        addParam(new g("size", this.size));
        addParam(new f("meshType", this.meshType));
        AppMethodBeat.o(82788);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82789);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82789);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82790);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82790);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82791);
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
        if (map.containsKey("foreheadSize")) {
            this.foreheadSize = (float[]) map.get("foreheadSize");
        }
        if (map.containsKey("foreheadCenter")) {
            this.foreheadCenter = (float[]) map.get("foreheadCenter");
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("foreheadHeight")) {
            this.foreheadHeight = ((Float) map.get("foreheadHeight")).floatValue() * 0.024f;
            if (this.foreheadHeight > 0.0f) {
                this.foreheadHeight *= 1.5f;
            }
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.o(82791);
    }
}
