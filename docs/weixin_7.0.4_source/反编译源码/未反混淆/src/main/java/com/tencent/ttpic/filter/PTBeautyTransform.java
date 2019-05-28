package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.util.BeautyRealUtil;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class PTBeautyTransform {
    private static final int MAX_TRANSFORMED_FACES = 5;
    private int frameIndex;
    private TransformFilter mBasic3 = null;
    private BeautyParam mBeautyParam;
    private TransformFilter mChinThinShorten;
    private BaseFilter mCopyFilter;
    private List<TransformFilter> mFilters;
    private BeautyParam mOrigBeautyParam;
    private TransformFilter mVFaceEyeNose;
    private h[] transFrame = new h[2];

    public PTBeautyTransform() {
        int i = 0;
        AppMethodBeat.i(82696);
        BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
        this.mOrigBeautyParam = new BeautyParam(true);
        this.mBeautyParam = new BeautyParam(false);
        BenchUtil.benchEnd("[onSurfaceCreated] create BeautyParam");
        this.mVFaceEyeNose = new TransformFilter(new ArrayList(), null);
        this.mChinThinShorten = new TransformFilter(new ArrayList(), null);
        this.mBasic3 = new TransformFilter(new ArrayList(), null);
        this.mFilters = new ArrayList();
        this.mCopyFilter = new BaseFilter(GLSLRender.bJB);
        while (i < this.transFrame.length) {
            this.transFrame[i] = new h();
            i++;
        }
        AppMethodBeat.o(82696);
    }

    public void initial() {
        AppMethodBeat.i(82697);
        BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
        this.mVFaceEyeNose.ApplyGLSLFilter();
        this.mChinThinShorten.ApplyGLSLFilter();
        this.mBasic3.ApplyGLSLFilter();
        BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
        BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
        this.mCopyFilter.ApplyGLSLFilter();
        BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
        AppMethodBeat.o(82697);
    }

    public void setBeautyParam(BeautyParam beautyParam) {
        AppMethodBeat.i(82698);
        if (beautyParam == null) {
            AppMethodBeat.o(82698);
            return;
        }
        setBeautyParamItem(TYPE.FACE_V.value, beautyParam.vlian);
        setBeautyParamItem(TYPE.EYE.value, beautyParam.eye);
        setBeautyParamItem(TYPE.NOSE.value, beautyParam.nose);
        setBeautyParamItem(TYPE.FACE_THIN.value, beautyParam.zhailian);
        setBeautyParamItem(TYPE.CHIN.value, beautyParam.xiaba);
        setBeautyParamItem(TYPE.FACE_SHORTEN.value, beautyParam.faceShorten);
        if (BeautyParam.MESH_SET == 0) {
            setBeautyParamItem(TYPE.BASIC3.value, beautyParam.basic573);
        } else {
            setBeautyParamItem(TYPE.BASIC3.value, beautyParam.basic4);
        }
        rebuildFilterList();
        AppMethodBeat.o(82698);
    }

    public void setBeautyParam(int i, int i2) {
        AppMethodBeat.i(82699);
        setBeautyParamItem(i, BeautyRealUtil.getDistortParam(this.mOrigBeautyParam.getDistortList(i), i2, i));
        AppMethodBeat.o(82699);
    }

    public void setBeautyParamItem(int i, DistortParam distortParam) {
        AppMethodBeat.i(82700);
        if (distortParam == null) {
            AppMethodBeat.o(82700);
            return;
        }
        ArrayList arrayList;
        if (i == TYPE.FACE_V.value || i == TYPE.EYE.value || i == TYPE.NOSE.value) {
            if (i == TYPE.FACE_V.value) {
                this.mBeautyParam.vlian = distortParam;
            } else if (i == TYPE.EYE.value) {
                this.mBeautyParam.eye = distortParam;
            } else if (i == TYPE.NOSE.value) {
                this.mBeautyParam.nose = distortParam;
            }
            arrayList = new ArrayList();
            arrayList.addAll(this.mBeautyParam.vlian.getItems());
            arrayList.addAll(this.mBeautyParam.eye.getItems());
            arrayList.addAll(this.mBeautyParam.nose.getItems());
            this.mVFaceEyeNose.setDistortionItems(arrayList);
        } else if (i == TYPE.FACE_THIN.value || i == TYPE.CHIN.value || i == TYPE.FACE_SHORTEN.value) {
            if (i == TYPE.FACE_THIN.value) {
                this.mBeautyParam.zhailian = distortParam;
            } else if (i == TYPE.CHIN.value) {
                this.mBeautyParam.xiaba = distortParam;
            } else if (i == TYPE.FACE_SHORTEN.value) {
                this.mBeautyParam.faceShorten = distortParam;
            }
            arrayList = new ArrayList();
            arrayList.addAll(this.mBeautyParam.zhailian.getItems());
            arrayList.addAll(this.mBeautyParam.xiaba.getItems());
            arrayList.addAll(this.mBeautyParam.faceShorten.getItems());
            this.mChinThinShorten.setDistortionItems(arrayList);
        } else if (i == TYPE.BASIC3.value) {
            if (BeautyParam.MESH_SET == 0) {
                this.mBeautyParam.basic573 = distortParam;
                arrayList = new ArrayList();
                arrayList.addAll(this.mBeautyParam.basic573.getItems());
                this.mBasic3.setDistortionItems(arrayList);
            } else {
                this.mBeautyParam.basic4 = distortParam;
                arrayList = new ArrayList();
                arrayList.addAll(this.mBeautyParam.basic4.getItems());
                this.mBasic3.setDistortionItems(arrayList);
            }
        }
        rebuildFilterList();
        AppMethodBeat.o(82700);
    }

    private void rebuildFilterList() {
        AppMethodBeat.i(82701);
        this.mFilters.clear();
        if (!(this.mBeautyParam.vlian.getLevel() == 0 && this.mBeautyParam.eye.getLevel() == 0 && this.mBeautyParam.nose.getLevel() == 0)) {
            this.mFilters.add(this.mVFaceEyeNose);
        }
        if (!(this.mBeautyParam.zhailian.getLevel() == 0 && this.mBeautyParam.xiaba.getLevel() == 0 && this.mBeautyParam.faceShorten.getLevel() == 0)) {
            this.mFilters.add(this.mChinThinShorten);
        }
        if (BeautyParam.MESH_SET == 0) {
            if (this.mBeautyParam.basic573.getLevel() != 0) {
                this.mFilters.add(this.mBasic3);
            }
        } else if (this.mBeautyParam.basic4.getLevel() != 0) {
            this.mFilters.add(this.mBasic3);
        }
        clearTransFrame();
        AppMethodBeat.o(82701);
    }

    private void clearTransFrame() {
        AppMethodBeat.i(82702);
        for (h clear : this.transFrame) {
            clear.clear();
        }
        AppMethodBeat.o(82702);
    }

    public h process(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(82703);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        double faceDetectScale = pTFaceAttr.getFaceDetectScale();
        int rotation = pTFaceAttr.getRotation();
        updateVideoSize(hVar.width, hVar.height, faceDetectScale);
        h updateAndRender = updateAndRender(hVar, allFacePoints, allFaceAngles, (float) rotation);
        AppMethodBeat.o(82703);
        return updateAndRender;
    }

    public h updateAndRender(h hVar, List<List<PointF>> list, List<float[]> list2, float f) {
        h hVar2;
        AppMethodBeat.i(82704);
        this.frameIndex = (this.frameIndex + 1) % 2;
        if (list != null) {
            int i = 0;
            hVar2 = hVar;
            while (i < Math.min(list.size(), 5)) {
                List list3 = (List) list.get(i);
                float[] fArr = (float[]) list2.get(i);
                h hVar3 = hVar2;
                for (TransformFilter transformFilter : this.mFilters) {
                    BenchUtil.benchStart("[BeautyTransformList] updatePreview");
                    transformFilter.updatePreview(new Builder().facePoints(list3).faceAngles(fArr).phoneAngle(f).build());
                    BenchUtil.benchEnd("[BeautyTransformList] updatePreview");
                    BenchUtil.benchStart("[BeautyTransformList] renderProcessBySwitchFbo");
                    if (VideoMaterialUtil.needCopyTransform()) {
                        hVar3 = VideoFrameUtil.renderProcessByCopy(hVar3.texture[0], hVar3.width, hVar3.height, transformFilter, this.mCopyFilter, hVar, this.transFrame[this.frameIndex]);
                    } else {
                        hVar3 = VideoFrameUtil.renderProcessBySwitchFbo(hVar3.texture[0], hVar3.width, hVar3.height, transformFilter, hVar, this.transFrame[this.frameIndex]);
                    }
                    BenchUtil.benchEnd("[BeautyTransformList] renderProcessBySwitchFbo");
                }
                i++;
                hVar2 = hVar3;
            }
        } else {
            hVar2 = hVar;
        }
        AppMethodBeat.o(82704);
        return hVar2;
    }

    public void updateAndRender(int i, int i2, float f, int i3, int i4, List<List<PointF>> list) {
        AppMethodBeat.i(82705);
        h hVar = new h(i, i2, i3, i4);
        if (list != null) {
            int i5 = 0;
            h hVar2 = hVar;
            while (i5 < Math.min(list.size(), 5)) {
                h hVar3 = hVar2;
                for (VideoFilterBase videoFilterBase : this.mFilters) {
                    videoFilterBase.updateParams((List) list.get(i5), null, 1.0d, new float[]{0.0f, 0.0f, 0.0f});
                    hVar3 = VideoFrameUtil.renderProcessBySwitchFbo(hVar3.texture[0], i3, i4, videoFilterBase, hVar, this.transFrame[0]);
                }
                if (hVar3.texture[0] != i2) {
                    this.mCopyFilter.RenderProcess(hVar3.texture[0], i3, i4, i2, 0.0d, new h(i, i2, i3, i4));
                }
                i5++;
                hVar2 = hVar3;
            }
        }
        AppMethodBeat.o(82705);
    }

    public void destroy() {
        AppMethodBeat.i(82706);
        clearTransFrame();
        this.mVFaceEyeNose.clearGLSLSelf();
        this.mChinThinShorten.clearGLSLSelf();
        this.mBasic3.clearGLSLSelf();
        this.mCopyFilter.ClearGLSL();
        AppMethodBeat.o(82706);
    }

    private void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82707);
        this.mVFaceEyeNose.updateVideoSize(i, i2, d);
        this.mChinThinShorten.updateVideoSize(i, i2, d);
        this.mBasic3.updateVideoSize(i, i2, d);
        AppMethodBeat.o(82707);
    }

    public BeautyParam getBeautyParam() {
        return this.mBeautyParam;
    }

    public boolean needFaceInfo() {
        AppMethodBeat.i(82708);
        if (this.mFilters.size() != 0) {
            AppMethodBeat.o(82708);
            return true;
        }
        AppMethodBeat.o(82708);
        return false;
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82709);
        this.mVFaceEyeNose.setRenderMode(i);
        this.mChinThinShorten.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(82709);
    }

    public void updateFaceFeature(List<List<PointF>> list) {
        AppMethodBeat.i(82710);
        if (list == null) {
            AppMethodBeat.o(82710);
            return;
        }
        for (List list2 : list) {
            BenchUtil.benchStart("[BeautyTransformList] getFullCoords");
            FaceOffUtil.getFullCoords(list2, 2.0f);
            BenchUtil.benchEnd("[BeautyTransformList] getFullCoords");
            BenchUtil.benchStart("[BeautyTransformList] updateFaceFeature");
            for (TransformFilter updateFaceFeatures : this.mFilters) {
                updateFaceFeatures.updateFaceFeatures(list2);
            }
            BenchUtil.benchEnd("[BeautyTransformList] updateFaceFeature");
        }
        AppMethodBeat.o(82710);
    }
}
