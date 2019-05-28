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

public class ReshapeWrinkleFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeWrinkleVertexShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeWrinkleVertexShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float faceSmile;
    private float[] lipsLeftEdge;
    private float[] lipsPlainSize;
    private float[] lipsRightEdge;
    private float meshType;
    private float[] nose3DCenter;
    private float[] nosePlainSize;
    private float[] size;

    static {
        AppMethodBeat.m2504i(82826);
        AppMethodBeat.m2505o(82826);
    }

    public ReshapeWrinkleFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82820);
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.lipsLeftEdge = new float[]{0.0f, 0.0f};
        this.lipsRightEdge = new float[]{0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.faceSmile = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.m2505o(82820);
    }

    public ReshapeWrinkleFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.m2504i(82821);
        this.lipsPlainSize = new float[]{0.0f, 0.0f};
        this.lipsLeftEdge = new float[]{0.0f, 0.0f};
        this.lipsRightEdge = new float[]{0.0f, 0.0f};
        this.nose3DCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.nosePlainSize = new float[]{0.0f, 0.0f};
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.faceSmile = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.m2505o(82821);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82822);
        addParam(new C0934g("lipsPlainSize", this.lipsPlainSize));
        addParam(new C0934g("lipsLeftEdge", this.lipsLeftEdge));
        addParam(new C0934g("lipsRightEdge", this.lipsRightEdge));
        addParam(new C0934g("nose3DCenter", this.nose3DCenter));
        addParam(new C0934g("nosePlainSize", this.nosePlainSize));
        addParam(new C0934g("angles", this.angles));
        addParam(new C0934g("size", this.size));
        addParam(new C0933f("faceSmile", this.faceSmile));
        addParam(new C0933f("meshType", this.meshType));
        AppMethodBeat.m2505o(82822);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82823);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.m2505o(82823);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82824);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(82824);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(82825);
        if (map.containsKey("lipsPlainSize")) {
            this.lipsPlainSize = (float[]) map.get("lipsPlainSize");
        }
        if (map.containsKey("lipsLeftEdge")) {
            this.lipsLeftEdge = (float[]) map.get("lipsLeftEdge");
        }
        if (map.containsKey("lipsRightEdge")) {
            this.lipsRightEdge = (float[]) map.get("lipsRightEdge");
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
        if (map.containsKey("faceSmile")) {
            this.faceSmile = ((Float) map.get("faceSmile")).floatValue() * 0.03f;
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.m2505o(82825);
    }
}
