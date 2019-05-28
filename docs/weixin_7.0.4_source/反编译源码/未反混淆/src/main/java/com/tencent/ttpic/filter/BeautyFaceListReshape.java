package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeautyFaceListReshape {
    public static final String TAG = BeautyFaceListReshape.class.getName();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private h mCopyFrame1 = new h();
    private h mCopyFrame2 = new h();
    private EyeLightenAndPounchFilterReshape mEyeLightenFilter = new EyeLightenAndPounchFilterReshape();
    private h mEyeLightenFrame = new h();
    private FaceFeatureFilterReshape mFaceFeatureFilter = new FaceFeatureFilterReshape();
    private h mFaceFeatureFrame = new h();
    private h mRemovePounchFrame = new h();

    static {
        AppMethodBeat.i(81999);
        AppMethodBeat.o(81999);
    }

    public BeautyFaceListReshape() {
        AppMethodBeat.i(81989);
        AppMethodBeat.o(81989);
    }

    public void initial() {
        AppMethodBeat.i(81990);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.ApplyGLSLFilter();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        AppMethodBeat.o(81990);
    }

    public void setRemovePounchAlpha(float f) {
        AppMethodBeat.i(81991);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setSmoothOpacity(f);
        }
        AppMethodBeat.o(81991);
    }

    public void setEyeLightenAlpha(float f) {
        AppMethodBeat.i(81992);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setAlphaValue(f);
        }
        AppMethodBeat.o(81992);
    }

    public void setPounchEnhance(float f) {
        AppMethodBeat.i(81993);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setPounchEnhance(f);
        }
        AppMethodBeat.o(81993);
    }

    public void setFaceFeatherAlpha(float f) {
        AppMethodBeat.i(81994);
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setAlphaValue(f);
        }
        AppMethodBeat.o(81994);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(81995);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.updateVideoSize(i, i2, d);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.updateVideoSize(i, i2, d);
        }
        AppMethodBeat.o(81995);
    }

    public h render(h hVar, List<List<PointF>> list, List<float[]> list2, FaceDetector faceDetector, List<PointF> list3, Set<Integer> set, double d, int i, long j) {
        Map faceActionCounter;
        int i2;
        int i3;
        float[] fArr;
        AppMethodBeat.i(81996);
        if (faceDetector != null) {
            faceActionCounter = faceDetector.getFaceActionCounter();
        } else {
            faceActionCounter = null;
        }
        BenchUtil.benchStart("mBeautyFaceList mFaceFeatherFilter");
        if (this.mFaceFeatureFilter != null && this.mFaceFeatureFilter.needRender()) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mFaceFeatureFrame);
            i2 = 0;
            while (true) {
                i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                fArr = (float[]) list2.get(i3);
                this.mFaceFeatureFilter.updatePreview(new Builder().facePoints((List) list.get(i3)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(list3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(set).phoneAngle((float) i).timestamp(j).build());
                this.mFaceFeatureFilter.OnDrawFrameGLSL();
                this.mFaceFeatureFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                i2 = i3 + 1;
            }
            hVar = this.mFaceFeatureFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mFaceFeatherFilter");
        BenchUtil.benchStart("mBeautyFaceList mEyeLightenFilter");
        if (this.mEyeLightenFilter != null && this.mEyeLightenFilter.needRender()) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mEyeLightenFrame);
            i2 = 0;
            while (true) {
                i3 = i2;
                if (i3 >= list.size()) {
                    break;
                }
                fArr = (float[]) list2.get(i3);
                this.mEyeLightenFilter.updatePreview(new Builder().facePoints((List) list.get(i3)).faceAngles(fArr).faceActionCounter(faceActionCounter).handPoints(list3).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(set).phoneAngle((float) i).timestamp(j).build());
                this.mEyeLightenFilter.OnDrawFrameGLSL();
                this.mEyeLightenFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
                i2 = i3 + 1;
            }
            hVar = this.mEyeLightenFrame;
        }
        BenchUtil.benchEnd("mBeautyFaceList mEyeLightenFilter");
        AppMethodBeat.o(81996);
        return hVar;
    }

    public void clear() {
        AppMethodBeat.i(81997);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.clearGLSLSelf();
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.clearGLSLSelf();
        }
        this.mCopyFilter.ClearGLSL();
        this.mRemovePounchFrame.clear();
        this.mEyeLightenFrame.clear();
        this.mFaceFeatureFrame.clear();
        this.mCopyFrame1.clear();
        this.mCopyFrame2.clear();
        AppMethodBeat.o(81997);
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(81998);
        if (this.mEyeLightenFilter != null) {
            this.mEyeLightenFilter.setRenderMode(i);
        }
        if (this.mFaceFeatureFilter != null) {
            this.mFaceFeatureFilter.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(81998);
    }
}
