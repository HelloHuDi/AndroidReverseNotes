package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C41672h;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.List;

public class CrazyFaceFilters {
    private FaceAverageBackgroundFilter faceAverageBackgroundFilter;
    private FaceAverageFilter faceAverageFilter;
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private C41672h mCopyFrame = new C41672h();
    private FaceSkinBalanceFilter mFaceSkinBalanceFilter;
    private C41672h mSkinBalanceFrame = new C41672h();

    public CrazyFaceFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(82124);
        if (videoMaterial == null) {
            videoMaterial = new VideoMaterial();
        }
        this.faceAverageBackgroundFilter = new FaceAverageBackgroundFilter(videoMaterial.getDataPath(), videoMaterial.getFaceImageLayer());
        this.faceAverageFilter = new FaceAverageFilter(videoMaterial.getDataPath(), videoMaterial.getFaceImageLayer());
        this.mFaceSkinBalanceFilter = new FaceSkinBalanceFilter(videoMaterial.getFaceImageLayer());
        AppMethodBeat.m2505o(82124);
    }

    public C41672h updateAndRender(C41672h c41672h, int i, int i2, List<PointF> list, float[] fArr) {
        AppMethodBeat.m2504i(82125);
        this.mCopyFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mCopyFrame);
        this.faceAverageBackgroundFilter.updatePreview(new Builder().build());
        this.faceAverageBackgroundFilter.OnDrawFrameGLSL();
        this.faceAverageBackgroundFilter.renderTexture(this.mCopyFrame.texture[0], i, i2);
        this.mFaceSkinBalanceFilter.RenderProcess(c41672h.texture[0], i, i2, -1, 0.0d, this.mSkinBalanceFrame);
        this.faceAverageFilter.setUserTexture(this.mSkinBalanceFrame.texture[0]);
        this.faceAverageFilter.updatePreview(new Builder().facePoints(list).faceAngles(fArr).timestamp(0).build());
        this.mCopyFrame.mo67189a(this.mCopyFrame.texture[0], i, i2, 0.0d);
        this.faceAverageFilter.OnDrawFrameGLSL();
        this.faceAverageFilter.renderTexture(this.mCopyFrame.texture[0], i, i2);
        C41672h c41672h2 = this.mCopyFrame;
        AppMethodBeat.m2505o(82125);
        return c41672h2;
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.m2504i(82126);
        this.faceAverageBackgroundFilter.ApplyGLSLFilter();
        this.faceAverageFilter.ApplyGLSLFilter();
        this.mFaceSkinBalanceFilter.ApplyGLSLFilter();
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.m2505o(82126);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.m2504i(82127);
        this.faceAverageBackgroundFilter.updateVideoSize(i, i2, d);
        this.faceAverageFilter.updateVideoSize(i, i2, d);
        AppMethodBeat.m2505o(82127);
    }

    public void clear() {
        AppMethodBeat.m2504i(82128);
        this.faceAverageBackgroundFilter.clearGLSLSelf();
        this.faceAverageFilter.clearGLSLSelf();
        this.mFaceSkinBalanceFilter.clearGLSLSelf();
        this.mCopyFilter.clearGLSLSelf();
        this.mCopyFrame.clear();
        this.mSkinBalanceFrame.clear();
        AppMethodBeat.m2505o(82128);
    }

    public void setImageData(byte[] bArr) {
        AppMethodBeat.m2504i(82129);
        this.mFaceSkinBalanceFilter.setImageData(bArr);
        AppMethodBeat.m2505o(82129);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(82130);
        this.faceAverageBackgroundFilter.setRenderMode(i);
        this.faceAverageFilter.setRenderMode(i);
        this.mFaceSkinBalanceFilter.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.m2505o(82130);
    }
}
