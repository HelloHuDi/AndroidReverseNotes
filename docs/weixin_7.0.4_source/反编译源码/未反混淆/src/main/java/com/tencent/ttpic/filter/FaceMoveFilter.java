package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class FaceMoveFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat").replace(IOUtils.LINE_SEPARATOR_UNIX, "");
    private static final String TAG = FaceMoveFilter.class.getSimpleName();
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat").replace(IOUtils.LINE_SEPARATOR_UNIX, "");
    private PointF[] dstPoints = new PointF[107];
    private int[] faceMoveTriangles;
    private List<FaceMoveItem> items;
    private float[] posVertices = new float[FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG];
    private PointF[] srcPoints = new PointF[107];
    private List<StickerItem> stickerItems;
    private float[] texVertices = new float[FilterEnum4Shaka.MIC_WEISHI_v4_4_HUAYANG];

    static {
        AppMethodBeat.i(82406);
        AppMethodBeat.o(82406);
    }

    public FaceMoveFilter(List<FaceMoveItem> list, List<StickerItem> list2, int[] iArr) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82403);
        this.items = list;
        this.stickerItems = list2;
        this.faceMoveTriangles = iArr;
        for (int i = 0; i < this.srcPoints.length; i++) {
            this.srcPoints[i] = new PointF();
            this.dstPoints[i] = new PointF();
        }
        initParams();
        AppMethodBeat.o(82403);
    }

    public void initParams() {
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        boolean contains;
        AppMethodBeat.i(82404);
        if (this.stickerItems == null || this.stickerItems.size() == 0) {
            contains = pTDetectInfo.triggeredExpression.contains(Integer.valueOf(PTExpression.FACE_DETECT.value));
        } else {
            contains = VideoFilterUtil.actionTriggered(pTDetectInfo.facePoints, this.stickerItems, pTDetectInfo.triggeredExpression);
        }
        if (contains) {
            VideoMaterialUtil.copyListToArray(pTDetectInfo.facePoints, this.srcPoints);
            FaceMoveUtil.genFullCoords(this.srcPoints);
            FaceMoveUtil.adjustCoords(this.srcPoints, this.dstPoints, this.items);
            setPositions(FaceMoveUtil.initFacePositions(this.dstPoints, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.posVertices, this.faceMoveTriangles));
            setTexCords(FaceMoveUtil.initMaterialFaceTexCoords(this.srcPoints, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.texVertices, this.faceMoveTriangles));
            setCoordNum(this.faceMoveTriangles == null ? 546 : this.faceMoveTriangles.length);
            AppMethodBeat.o(82404);
            return;
        }
        setPositions(GlUtil.EMPTY_POSITIONS);
        setCoordNum(4);
        AppMethodBeat.o(82404);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82405);
        super.ApplyGLSLFilter();
        setDrawMode(DRAW_MODE.TRIANGLES);
        AppMethodBeat.o(82405);
    }
}
