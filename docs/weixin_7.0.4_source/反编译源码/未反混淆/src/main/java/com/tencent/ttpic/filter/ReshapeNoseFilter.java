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

public class ReshapeNoseFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeNoseVertexShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeNoseVertexShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float[] leftEyeCenter;
    private float[] leftEyePlainSize;
    private float[] lipsCenter;
    private float[] lipsPlainSize;
    private float meshType;
    private float[] nose3DCenter;
    private float[] noseBottomCenter;
    private float noseBridgeWidth;
    private float noseOutlineWidth;
    private float[] nosePlainSize;
    private float nosePosition;
    private float noseSize;
    private float[] noseTipCenter;
    private float[] noseTipPlaneSize;
    private float noseTipSize;
    private float[] nostrilsCenter;
    private float[] nostrilsPlaneSize;
    private float[] rightEyeCenter;
    private float[] rightEyePlainSize;
    private float[] size;

    static {
        AppMethodBeat.i(82813);
        AppMethodBeat.o(82813);
    }

    public ReshapeNoseFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.i(82807);
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.nostrilsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nostrilsPlaneSize = new float[]{0.0f, 0.0f};
        this.noseTipCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseBottomCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseTipPlaneSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseSize = 0.0f;
        this.noseOutlineWidth = 0.0f;
        this.noseBridgeWidth = 0.1f;
        this.nosePosition = 0.0f;
        this.noseTipSize = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.o(82807);
    }

    public ReshapeNoseFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.i(82808);
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.nostrilsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nostrilsPlaneSize = new float[]{0.0f, 0.0f};
        this.noseTipCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseBottomCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseTipPlaneSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.noseSize = 0.0f;
        this.noseOutlineWidth = 0.0f;
        this.noseBridgeWidth = 0.1f;
        this.nosePosition = 0.0f;
        this.noseTipSize = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.o(82808);
    }

    public void initParams() {
        AppMethodBeat.i(82809);
        addParam(new g("nose3DCenter", this.nose3DCenter));
        addParam(new g("nosePlainSize", this.nosePlainSize));
        addParam(new g("nostrilsCenter", this.nostrilsCenter));
        addParam(new g("nostrilsPlaneSize", this.nostrilsPlaneSize));
        addParam(new g("noseTipCenter", this.noseTipCenter));
        addParam(new g("noseTipPlaneSize", this.noseTipPlaneSize));
        addParam(new g("noseBottomCenter", this.noseBottomCenter));
        addParam(new g("lipsCenter", this.lipsCenter));
        addParam(new g("lipsPlainSize", this.lipsPlainSize));
        addParam(new g("leftEyePlainSize", this.leftEyePlainSize));
        addParam(new g("leftEyeCenter", this.leftEyeCenter));
        addParam(new g("rightEyePlainSize", this.rightEyePlainSize));
        addParam(new g("rightEyeCenter", this.rightEyeCenter));
        addParam(new f("noseSize", this.noseSize));
        addParam(new f("noseOutlineWidth", this.noseOutlineWidth));
        addParam(new f("noseBridgeWidth", this.noseBridgeWidth));
        addParam(new f("nosePosition", this.nosePosition));
        addParam(new f("noseTipSize", this.noseTipSize));
        addParam(new g("angles", this.angles));
        addParam(new g("size", this.size));
        addParam(new f("meshType", this.meshType));
        AppMethodBeat.o(82809);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82810);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.o(82810);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82811);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.o(82811);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(82812);
        if (map.containsKey("nose3DCenter")) {
            this.nose3DCenter = (float[]) map.get("nose3DCenter");
        }
        if (map.containsKey("nosePlainSize")) {
            this.nosePlainSize = (float[]) map.get("nosePlainSize");
        }
        if (map.containsKey("nostrilsCenter")) {
            this.nostrilsCenter = (float[]) map.get("nostrilsCenter");
        }
        if (map.containsKey("nostrilsPlaneSize")) {
            this.nostrilsPlaneSize = (float[]) map.get("nostrilsPlaneSize");
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
            this.noseTipSize = ((Float) map.get("noseTipSize")).floatValue() * -0.01f;
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.o(82812);
    }
}
