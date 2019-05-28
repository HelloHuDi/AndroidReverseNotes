package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FaceLineFilter extends VideoFilterBase {
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineFragmentShader.dat");
    private static final String TAG = FaceLineFilter.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceLineVertexShader.dat");
    private float[] faceVertices = new float[2760];
    private float[] irisVertices = new float[96];

    static {
        AppMethodBeat.m2504i(82402);
        AppMethodBeat.m2505o(82402);
    }

    public FaceLineFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82396);
        initParams();
        AppMethodBeat.m2505o(82396);
    }

    public void initParams() {
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82397);
        setPositions(GlUtil.ORIGIN_POSITION_COORDS);
        AppMethodBeat.m2505o(82397);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82398);
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.LINES);
        AppMethodBeat.m2505o(82398);
    }

    public void updatePoints(List<List<PointF>> list) {
        AppMethodBeat.m2504i(82399);
        if (list.size() == 0) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            setCoordNum(4);
            AppMethodBeat.m2505o(82399);
            return;
        }
        List copyList = VideoMaterialUtil.copyList((List) list.get(0));
        FaceOffUtil.getFullCoords(copyList, 2.0f);
        setPositions(FaceOffUtil.initFaceLinePositions(copyList, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        setCoordNum(1380);
        AppMethodBeat.m2505o(82399);
    }

    public void render(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82400);
        GLES20.glLineWidth(3.0f);
        GlUtil.setBlendMode(true);
        OnDrawFrameGLSL();
        renderTexture(i, i2, i3);
        GlUtil.setBlendMode(false);
        AppMethodBeat.m2505o(82400);
    }

    public void updateIrisPoints(List<PointF> list) {
        AppMethodBeat.m2504i(82401);
        setPositions(FaceOffUtil.initIrisLinePositions(VideoMaterialUtil.copyList(list), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.irisVertices));
        setCoordNum(48);
        AppMethodBeat.m2505o(82401);
    }
}
