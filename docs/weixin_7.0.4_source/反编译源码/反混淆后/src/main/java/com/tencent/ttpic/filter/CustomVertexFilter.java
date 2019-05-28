package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.C25624m.C25625a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class CustomVertexFilter extends VideoFilterBase {
    private static final int SIZE_POINT_FACE = 90;
    private static final int XCOORD_NUM = 24;
    private static final int YCOORD_NUM = 32;
    private float[] facePoints = new float[FaceMoveUtil.TRIANGLE_COUNT];
    private List<PointF> mFullscreenVertices;
    private List<PointF> mInitTextureCoordinates;

    public CustomVertexFilter(String str, String str2) {
        super(str, str2);
        AppMethodBeat.m2504i(82138);
        initCoordinates();
        initParams();
        AppMethodBeat.m2505o(82138);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82139);
        addParam(new C25625a("facePoints", new float[0]));
        AppMethodBeat.m2505o(82139);
    }

    private void initCoordinates() {
        AppMethodBeat.m2504i(82140);
        this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(24, 32, -1.0f, 1.0f, -1.0f, 1.0f);
        this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(24, 32, 0.0f, 1.0f, 0.0f, 1.0f);
        AppMethodBeat.m2505o(82140);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(82141);
        float[] toFlatArray = VideoMaterialUtil.toFlatArray(pTDetectInfo.facePoints);
        VideoMaterialUtil.flipYPoints(toFlatArray, (int) (((double) this.height) * this.mFaceDetScale));
        int i = 0;
        while (i < 180) {
            if (toFlatArray == null || i >= toFlatArray.length) {
                this.facePoints[i] = -1.0f;
            } else {
                this.facePoints[i] = (float) (((double) toFlatArray[i]) / this.mFaceDetScale);
            }
            i++;
        }
        if (toFlatArray == null) {
            this.facePoints[180] = -1.0f;
            this.facePoints[181] = -1.0f;
        } else {
            this.facePoints[180] = (float) this.width;
            this.facePoints[181] = (float) this.height;
        }
        addParam(new C25625a("facePoints", this.facePoints));
        AppMethodBeat.m2505o(82141);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82142);
        super.ApplyGLSLFilter();
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) this.mFullscreenVertices.toArray(new PointF[0])));
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) this.mInitTextureCoordinates.toArray(new PointF[0])));
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        setCoordNum(1561);
        AppMethodBeat.m2505o(82142);
    }
}
