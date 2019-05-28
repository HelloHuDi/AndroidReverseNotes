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

public class ReshapeJawFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeJawVertextShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float faceJaw;
    private float[] jawCenterOfGravity;
    private float[] jawSize;
    private float[] lipsCenter;
    private float[] lipsPlainSize;
    private float meshType;
    private float[] nose3DCenter;
    private float[] nosePlainSize;
    private float[] size;

    static {
        AppMethodBeat.m2504i(82799);
        AppMethodBeat.m2505o(82799);
    }

    public ReshapeJawFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82793);
        this.jawCenterOfGravity = new float[]{0.0f, 0.0f, 0.0f};
        this.jawSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.faceJaw = 0.0f;
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.m2505o(82793);
    }

    public ReshapeJawFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.m2504i(82794);
        this.jawCenterOfGravity = new float[]{0.0f, 0.0f, 0.0f};
        this.jawSize = new float[]{0.0f, 0.0f};
        this.lipsCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.faceJaw = 0.0f;
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.m2505o(82794);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82795);
        addParam(new C0934g("jawCenterOfGravity", this.jawCenterOfGravity));
        addParam(new C0934g("jawSize", this.jawSize));
        addParam(new C0934g("lipsCenter", this.lipsCenter));
        addParam(new C0934g("lipsPlainSize", this.lipsPlainSize));
        addParam(new C0934g("nose3DCenter", this.nose3DCenter));
        addParam(new C0934g("nosePlainSize", this.nosePlainSize));
        addParam(new C0934g("angles", this.angles));
        addParam(new C0933f("faceJaw", this.faceJaw));
        addParam(new C0934g("size", this.size));
        addParam(new C0933f("meshType", this.meshType));
        AppMethodBeat.m2505o(82795);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82796);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.m2505o(82796);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82797);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(82797);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(82798);
        if (map.containsKey("jawCenterOfGravity")) {
            this.jawCenterOfGravity = (float[]) map.get("jawCenterOfGravity");
        }
        if (map.containsKey("jawSize")) {
            this.jawSize = (float[]) map.get("jawSize");
        }
        if (map.containsKey("lipsCenter")) {
            this.lipsCenter = (float[]) map.get("lipsCenter");
        }
        if (map.containsKey("lipsPlainSize")) {
            this.lipsPlainSize = (float[]) map.get("lipsPlainSize");
        }
        if (map.containsKey("nose3DCenter")) {
            this.nose3DCenter = (float[]) map.get("nose3DCenter");
        }
        if (map.containsKey("nosePlainSize")) {
            this.nosePlainSize = (float[]) map.get("nosePlainSize");
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("faceJaw")) {
            this.faceJaw = ((Float) map.get("faceJaw")).floatValue() * 0.01f;
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.m2505o(82798);
    }
}
