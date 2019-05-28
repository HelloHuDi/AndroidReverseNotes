package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.List;

public class CrazyFaceFilters {
    private FaceAverageBackgroundFilter faceAverageBackgroundFilter;
    private FaceAverageFilter faceAverageFilter;
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h mCopyFrame = new h();
    private FaceSkinBalanceFilter mFaceSkinBalanceFilter;
    private h mSkinBalanceFrame = new h();

    public CrazyFaceFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.i(82124);
        if (videoMaterial == null) {
            videoMaterial = new VideoMaterial();
        }
        this.faceAverageBackgroundFilter = new FaceAverageBackgroundFilter(videoMaterial.getDataPath(), videoMaterial.getFaceImageLayer());
        this.faceAverageFilter = new FaceAverageFilter(videoMaterial.getDataPath(), videoMaterial.getFaceImageLayer());
        this.mFaceSkinBalanceFilter = new FaceSkinBalanceFilter(videoMaterial.getFaceImageLayer());
        AppMethodBeat.o(82124);
    }

    public h updateAndRender(h hVar, int i, int i2, List<PointF> list, float[] fArr) {
        AppMethodBeat.i(82125);
        this.mCopyFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mCopyFrame);
        this.faceAverageBackgroundFilter.updatePreview(new Builder().build());
        this.faceAverageBackgroundFilter.OnDrawFrameGLSL();
        this.faceAverageBackgroundFilter.renderTexture(this.mCopyFrame.texture[0], i, i2);
        this.mFaceSkinBalanceFilter.RenderProcess(hVar.texture[0], i, i2, -1, 0.0d, this.mSkinBalanceFrame);
        this.faceAverageFilter.setUserTexture(this.mSkinBalanceFrame.texture[0]);
        this.faceAverageFilter.updatePreview(new Builder().facePoints(list).faceAngles(fArr).timestamp(0).build());
        this.mCopyFrame.a(this.mCopyFrame.texture[0], i, i2, 0.0d);
        this.faceAverageFilter.OnDrawFrameGLSL();
        this.faceAverageFilter.renderTexture(this.mCopyFrame.texture[0], i, i2);
        h hVar2 = this.mCopyFrame;
        AppMethodBeat.o(82125);
        return hVar2;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82126);
        this.faceAverageBackgroundFilter.ApplyGLSLFilter();
        this.faceAverageFilter.ApplyGLSLFilter();
        this.mFaceSkinBalanceFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.o(82126);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82127);
        this.faceAverageBackgroundFilter.updateVideoSize(i, i2, d);
        this.faceAverageFilter.updateVideoSize(i, i2, d);
        AppMethodBeat.o(82127);
    }

    public void clear() {
        AppMethodBeat.i(82128);
        this.faceAverageBackgroundFilter.clearGLSLSelf();
        this.faceAverageFilter.clearGLSLSelf();
        this.mFaceSkinBalanceFilter.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
        this.mCopyFrame.clear();
        this.mSkinBalanceFrame.clear();
        AppMethodBeat.o(82128);
    }

    public void setImageData(byte[] bArr) {
        AppMethodBeat.i(82129);
        this.mFaceSkinBalanceFilter.setImageData(bArr);
        AppMethodBeat.o(82129);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82130);
        this.faceAverageBackgroundFilter.setRenderMode(i);
        this.faceAverageFilter.setRenderMode(i);
        this.mFaceSkinBalanceFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(82130);
    }
}
