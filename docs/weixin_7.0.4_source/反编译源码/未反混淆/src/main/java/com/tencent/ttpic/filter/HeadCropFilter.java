package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.h;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
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
    private h inputFrame;

    static {
        AppMethodBeat.i(82601);
        AppMethodBeat.o(82601);
    }

    public HeadCropFilter() {
        super(PROGRAM_TYPE.HEAD_CROP);
        AppMethodBeat.i(82596);
        initParams();
        AppMethodBeat.o(82596);
    }

    public void initParams() {
        AppMethodBeat.i(82597);
        Bitmap grayBitmap = FaceOffUtil.getGrayBitmap(FEATURE_TYPE.FACE_HEAD_CROP);
        this.grayImageWidth = grayBitmap.getWidth();
        this.grayImageHeight = grayBitmap.getHeight();
        addParam(new k("inputImageTexture2", grayBitmap, 33986, true));
        addParam(new i("enableFaceOff", 1));
        AppMethodBeat.o(82597);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82598);
        if (pTDetectInfo.facePoints == null || pTDetectInfo.facePoints.size() < 90) {
            setPositions(GlUtil.EMPTY_POSITIONS);
            setCoordNum(4);
            AppMethodBeat.o(82598);
            return;
        }
        setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(pTDetectInfo.facePoints), 3.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        setCoordNum(690);
        AppMethodBeat.o(82598);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82599);
        super.initAttribParams();
        setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(FEATURE_TYPE.FACE_HEAD_CROP), 3.0f), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        AppMethodBeat.o(82599);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82600);
        boolean renderTexture = super.renderTexture(this.inputFrame.texture[0], this.inputFrame.width, this.inputFrame.height);
        AppMethodBeat.o(82600);
        return renderTexture;
    }

    public void setInputFrame(h hVar) {
        this.inputFrame = hVar;
    }

    public h getInputFrame() {
        return this.inputFrame;
    }
}
