package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.C41672h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class HeadCropFilter extends VideoFilterBase {
    private static final String TAG = HeadCropFilter.class.getSimpleName();
    private float[] faceVertices = new float[1380];
    private int grayImageHeight;
    private int grayImageWidth;
    private float[] grayVertices = new float[1380];
    private C41672h inputFrame;

    static {
        AppMethodBeat.m2504i(82601);
        AppMethodBeat.m2505o(82601);
    }

    public HeadCropFilter() {
        super(PROGRAM_TYPE.HEAD_CROP);
        AppMethodBeat.m2504i(82596);
        initParams();
        AppMethodBeat.m2505o(82596);
    }

    public void initParams() {
        AppMethodBeat.m2504i(82597);
        Bitmap grayBitmap = FaceOffUtil.getGrayBitmap(FEATURE_TYPE.FACE_HEAD_CROP);
        this.grayImageWidth = grayBitmap.getWidth();
        this.grayImageHeight = grayBitmap.getHeight();
        addParam(new C25628k("inputImageTexture2", grayBitmap, 33986, true));
        addParam(new C0935i("enableFaceOff", 1));
        AppMethodBeat.m2505o(82597);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(82598);
        if (pTDetectInfo.facePoints == null || pTDetectInfo.facePoints.size() < 90) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            setCoordNum(4);
            AppMethodBeat.m2505o(82598);
            return;
        }
        setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(pTDetectInfo.facePoints), 3.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        setCoordNum(690);
        AppMethodBeat.m2505o(82598);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82599);
        super.initAttribParams();
        setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FEATURE_TYPE.FACE_HEAD_CROP), 3.0f), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        AppMethodBeat.m2505o(82599);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(82600);
        boolean renderTexture = super.renderTexture(this.inputFrame.texture[0], this.inputFrame.width, this.inputFrame.height);
        AppMethodBeat.m2505o(82600);
        return renderTexture;
    }

    public void setInputFrame(C41672h c41672h) {
        this.inputFrame = c41672h;
    }

    public C41672h getInputFrame() {
        return this.inputFrame;
    }
}
