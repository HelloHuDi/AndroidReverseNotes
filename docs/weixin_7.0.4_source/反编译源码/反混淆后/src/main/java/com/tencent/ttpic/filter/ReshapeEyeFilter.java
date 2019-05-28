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

public class ReshapeEyeFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader.dat");
    public static final String FRAGMENT_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeFragmentShader_v.dat");
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeVertexShader.dat");
    public static final String VERTEX_SHADER_V = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ReshapeEyeVertexShader_v.dat");
    private static final int XCOORD_NUM = 128;
    private static final int YCOORD_NUM = 128;
    private static List<PointF> mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private static List<PointF> mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(128, 128, 0.0f, 1.0f, 0.0f, 1.0f);
    private float[] angles;
    private float eyesDistance;
    private float eyesHeight;
    private float eyesSize;
    private float eyesTiltAngle;
    private float eyesWidth;
    private float[] leftEyeCenter;
    private float[] leftEyePlainSize;
    private float meshType;
    private float[] rightEyeCenter;
    private float[] rightEyePlainSize;
    private float[] size;

    static {
        AppMethodBeat.m2504i(82759);
        AppMethodBeat.m2505o(82759);
    }

    public ReshapeEyeFilter(float f, float f2, float f3, float f4) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82753);
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.eyesWidth = 0.0f;
        this.eyesHeight = 0.0f;
        this.eyesSize = 0.1f;
        this.eyesTiltAngle = 0.0f;
        this.eyesDistance = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.5f;
        initParams();
        AppMethodBeat.m2505o(82753);
    }

    public ReshapeEyeFilter(int i) {
        super(VERTEX_SHADER_V, FRAGMENT_SHADER_V);
        AppMethodBeat.m2504i(82754);
        this.leftEyePlainSize = new float[]{0.0f, 0.0f};
        this.leftEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.rightEyePlainSize = new float[]{0.0f, 0.0f};
        this.rightEyeCenter = new float[]{0.0f, 0.0f, 0.0f};
        this.eyesWidth = 0.0f;
        this.eyesHeight = 0.0f;
        this.eyesSize = 0.1f;
        this.eyesTiltAngle = 0.0f;
        this.eyesDistance = 1.0f;
        this.angles = new float[]{0.0f, 0.0f, 0.0f};
        this.size = new float[]{1.0f, 1.0f};
        this.meshType = 0.0f;
        this.meshType = 0.0f;
        initParams();
        AppMethodBeat.m2505o(82754);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82755);
        addParam(new C0934g("leftEyePlainSize", this.leftEyePlainSize));
        addParam(new C0934g("leftEyeCenter", this.leftEyeCenter));
        addParam(new C0934g("rightEyePlainSize", this.rightEyePlainSize));
        addParam(new C0934g("rightEyeCenter", this.rightEyeCenter));
        addParam(new C0933f("eyesSize", this.eyesSize));
        addParam(new C0933f("eyesWidth", this.eyesWidth));
        addParam(new C0933f("eyesHeight", this.eyesHeight));
        addParam(new C0933f("eyesTiltAngle", this.eyesTiltAngle));
        addParam(new C0933f("eyesDistance", this.eyesDistance));
        addParam(new C0934g("angles", this.angles));
        addParam(new C0934g("size", this.size));
        addParam(new C0933f("meshType", this.meshType));
        AppMethodBeat.m2505o(82755);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82756);
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
        setCoordNum(32897);
        AppMethodBeat.m2505o(82756);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82757);
        initParams();
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        AppMethodBeat.m2505o(82757);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.m2504i(82758);
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
        if (map.containsKey("eyesWidth")) {
            this.eyesWidth = ((Float) map.get("eyesWidth")).floatValue() * -0.008f;
        }
        if (map.containsKey("eyesHeight")) {
            this.eyesHeight = ((Float) map.get("eyesHeight")).floatValue() * -0.009f;
        }
        if (map.containsKey("eyesSize")) {
            this.eyesSize = ((Float) map.get("eyesSize")).floatValue() * -0.0075f;
        }
        if (map.containsKey("eyesTiltAngle")) {
            this.eyesTiltAngle = ((Float) map.get("eyesTiltAngle")).floatValue() * 0.001f;
        }
        if (map.containsKey("eyesDistance")) {
            this.eyesDistance = ((Float) map.get("eyesDistance")).floatValue() * 0.015f;
            if (this.eyesDistance > 0.0f) {
                this.eyesDistance *= 0.8f;
            }
        }
        if (map.containsKey("angles")) {
            this.angles = (float[]) map.get("angles");
        }
        if (map.containsKey("size")) {
            this.size = (float[]) map.get("size");
        }
        initParams();
        AppMethodBeat.m2505o(82758);
    }
}
