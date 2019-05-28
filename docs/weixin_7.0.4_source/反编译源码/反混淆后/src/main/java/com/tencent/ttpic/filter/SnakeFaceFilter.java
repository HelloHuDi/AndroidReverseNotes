package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25632c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.List;

public class SnakeFaceFilter extends VideoFilterBase {
    private static final float CHIN_DOWN_SCALE = 0.05f;
    private static final float EYE_MAGNIFY_SCALE = 0.4f;
    private static final float FACE_SLIM_SCALE = 0.3f;
    private static final int SIZE_POINT = 102;
    private static final int XCOORD_NUM = 24;
    private static final int YCOORD_NUM = 32;
    private PointF[] dstPoints;
    private List<PointF> mFullscreenVertices;
    private List<PointF> mInitTextureCoordinates;
    private PointF[] pDst = new PointF[90];
    private PointF[] pSrc = new PointF[90];
    private PointF[] srcPoints;

    enum SHADER_FIELD {
        NPOINT("nPoint"),
        FSRC("fSrc"),
        FDST("fDst");
        
        public String name;

        static {
            AppMethodBeat.m2505o(82941);
        }

        private SHADER_FIELD(String str) {
            this.name = str;
        }
    }

    public SnakeFaceFilter() {
        super(PROGRAM_TYPE.SNAKE_FACE);
        AppMethodBeat.m2504i(82942);
        initCoordinates();
        initParams();
        AppMethodBeat.m2505o(82942);
    }

    private void initCoordinates() {
        AppMethodBeat.m2504i(82943);
        this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(24, 32, -1.0f, 1.0f, -1.0f, 1.0f);
        this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(24, 32, 0.0f, 1.0f, 0.0f, 1.0f);
        AppMethodBeat.m2505o(82943);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82944);
        addParam(new C0935i(SHADER_FIELD.NPOINT.name, 0));
        addParam(new C25632c(SHADER_FIELD.FSRC.name, new float[0]));
        addParam(new C25632c(SHADER_FIELD.FDST.name, new float[0]));
        AppMethodBeat.m2505o(82944);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(82945);
        List copyList = VideoMaterialUtil.copyList(pTDetectInfo.facePoints);
        if (copyList == null || copyList.size() < 90) {
            this.srcPoints = new PointF[0];
            this.dstPoints = new PointF[0];
            i = 0;
        } else {
            float f;
            VideoMaterialUtil.flipYPoints(copyList, (int) (((double) this.height) * this.mFaceDetScale));
            for (int i3 = 0; i3 < 90; i3++) {
                if (this.pSrc[i3] == null) {
                    this.pSrc[i3] = new PointF();
                }
                if (this.pDst[i3] == null) {
                    this.pDst[i3] = new PointF();
                }
                PointF pointF = this.pSrc[i3];
                PointF pointF2 = this.pDst[i3];
                f = ((PointF) copyList.get(i3)).x;
                pointF2.x = f;
                pointF.x = f;
                pointF = this.pSrc[i3];
                pointF2 = this.pDst[i3];
                f = ((PointF) copyList.get(i3)).y;
                pointF2.y = f;
                pointF.y = f;
            }
            f = this.pSrc[9].x - this.pSrc[64].x;
            float f2 = this.pSrc[9].y - this.pSrc[64].y;
            PointF pointF3 = this.pDst[9];
            pointF3.x = (f * CHIN_DOWN_SCALE) + pointF3.x;
            PointF pointF4 = this.pDst[9];
            pointF4.y = (f2 * CHIN_DOWN_SCALE) + pointF4.y;
            refineSnakeFacePoint(this.pSrc, this.pDst);
            refineSnakeEyePoint(this.pSrc, this.pDst);
            if (this.srcPoints == null || this.srcPoints.length != 102) {
                this.srcPoints = new PointF[102];
            }
            if (this.dstPoints == null || this.dstPoints.length != 102) {
                this.dstPoints = new PointF[102];
            }
            while (i2 < 83) {
                this.srcPoints[i2] = this.pSrc[i2];
                this.dstPoints[i2] = this.pDst[i2];
                i2++;
            }
            for (i = 83; i < 101; i++) {
                i2 = i - 83;
                this.srcPoints[i] = new PointF((this.pSrc[i2].x + this.pSrc[i2 + 1].x) / 2.0f, (this.pSrc[i2].y + this.pSrc[i2 + 1].y) / 2.0f);
                this.dstPoints[i] = new PointF((this.pDst[i2].x + this.pDst[i2 + 1].x) / 2.0f, (this.pDst[i2 + 1].y + this.pDst[i2].y) / 2.0f);
            }
            this.srcPoints[101] = new PointF((float) (((double) this.width) * this.mFaceDetScale), (float) (((double) this.height) * this.mFaceDetScale));
            this.dstPoints[101] = new PointF((float) (((double) this.width) * this.mFaceDetScale), (float) (((double) this.height) * this.mFaceDetScale));
            i = 102;
        }
        adjustPoints(i);
        updateGLParams(i);
        AppMethodBeat.m2505o(82945);
    }

    private void updateGLParams(int i) {
        AppMethodBeat.m2504i(82946);
        addParam(new C0935i(SHADER_FIELD.NPOINT.name, i));
        addParam(new C25632c(SHADER_FIELD.FSRC.name, VideoMaterialUtil.toFlatArray(this.srcPoints)));
        addParam(new C25632c(SHADER_FIELD.FDST.name, VideoMaterialUtil.toFlatArray(this.dstPoints)));
        AppMethodBeat.m2505o(82946);
    }

    private void adjustPoints(int i) {
        if (this.srcPoints != null && this.dstPoints != null && this.srcPoints.length == this.dstPoints.length) {
            for (int i2 = 0; i2 < i; i2++) {
                PointF pointF = this.srcPoints[i2];
                pointF.x = (float) (((double) pointF.x) + 0.02d);
                pointF = this.srcPoints[i2];
                pointF.y = (float) (((double) pointF.y) + 0.02d);
                pointF = this.dstPoints[i2];
                pointF.x = (float) (((double) pointF.x) + 0.02d);
                pointF = this.dstPoints[i2];
                pointF.y = (float) (((double) pointF.y) + 0.02d);
            }
        }
    }

    private void refineSnakeFacePoint(PointF[] pointFArr, PointF[] pointFArr2) {
        int i;
        AppMethodBeat.m2504i(82947);
        PointF pointF = pointFArr2[0];
        PointF pointF2 = pointFArr2[9];
        PointF pointF3 = pointFArr2[18];
        for (i = 1; i <= 9; i++) {
            pointFArr2[i] = new PointF(((pointF.x * ((float) (9 - i))) + (pointF2.x * ((float) i))) / 9.0f, ((pointF.y * ((float) (9 - i))) + (pointF2.y * ((float) i))) / 9.0f);
            pointFArr2[18 - i] = new PointF(((pointF3.x * ((float) (9 - i))) + (pointF2.x * ((float) i))) / 9.0f, ((pointF3.y * ((float) (9 - i))) + (pointF2.y * ((float) i))) / 9.0f);
        }
        for (i = 1; i < 18; i++) {
            pointFArr2[i] = new PointF(((pointFArr2[i].x - pointFArr[i].x) * FACE_SLIM_SCALE) + pointFArr[i].x, ((pointFArr2[i].y - pointFArr[i].y) * FACE_SLIM_SCALE) + pointFArr[i].y);
        }
        AppMethodBeat.m2505o(82947);
    }

    private void refineSnakeEyePoint(PointF[] pointFArr, PointF[] pointFArr2) {
        int i;
        AppMethodBeat.m2504i(82948);
        PointF pointF = pointFArr2[44];
        PointF pointF2 = pointFArr2[54];
        for (i = 35; i <= 42; i++) {
            pointFArr2[i] = new PointF(pointFArr[i].x + ((pointFArr[i].x - pointF.x) * EYE_MAGNIFY_SCALE), pointFArr[i].y + ((pointFArr[i].y - pointF.y) * EYE_MAGNIFY_SCALE));
        }
        for (i = 45; i <= 52; i++) {
            pointFArr2[i] = new PointF(pointFArr[i].x + ((pointFArr[i].x - pointF2.x) * EYE_MAGNIFY_SCALE), pointFArr[i].y + ((pointFArr[i].y - pointF2.y) * EYE_MAGNIFY_SCALE));
        }
        AppMethodBeat.m2505o(82948);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82949);
        super.ApplyGLSLFilter();
        setPositions(VideoMaterialUtil.toFlatArray((PointF[]) this.mFullscreenVertices.toArray(new PointF[0])));
        setTexCords(VideoMaterialUtil.toFlatArray((PointF[]) this.mInitTextureCoordinates.toArray(new PointF[0])));
        setDrawMode(DRAW_MODE.TRIANGLE_STRIP);
        setCoordNum(1561);
        AppMethodBeat.m2505o(82949);
    }
}
