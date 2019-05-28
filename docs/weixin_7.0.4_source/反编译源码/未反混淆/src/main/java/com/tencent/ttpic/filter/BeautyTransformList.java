package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BeautyTransformList {
    private static int FACE_CACHE_LEN = 10;
    private static final int MAX_TRANSFORMED_FACES = 5;
    private final int MAX_COUNT = 6;
    private int frameIndex;
    private TransformFilter mBasic3 = null;
    private BeautyParam mBeautyParam;
    private TransformFilter mChinThinShorten;
    private BaseFilter mCopyFilter;
    private List<TransformFilter> mFilters;
    private TransformFilter mVFaceEyeNose;
    private List<FaceInfoOfPeople> peopleList = new LinkedList();
    private h[] transFrame = new h[2];

    public class FaceInfoOfPeople {
        int count = -1;
        public LinkedList<List<PointF>> faces = new LinkedList();
        public LinkedList<float[]> facesAngles = new LinkedList();

        public FaceInfoOfPeople() {
            AppMethodBeat.i(82024);
            AppMethodBeat.o(82024);
        }
    }

    public class FaceInfoOfFrame {
        public List<Integer> countList;
        public List<List<PointF>> faces;
        public List<float[]> facesAngles;
        public float phoneRotate;

        public FaceInfoOfFrame(List<List<PointF>> list, List<float[]> list2, List<Integer> list3) {
            this.faces = list;
            this.facesAngles = list2;
            this.countList = list3;
        }
    }

    public BeautyTransformList() {
        int i = 0;
        AppMethodBeat.i(82025);
        BenchUtil.benchStart("[onSurfaceCreated] create BeautyParam");
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
        AppMethodBeat.o(82025);
    }

    public void initial() {
        AppMethodBeat.i(82026);
        BenchUtil.benchStart("[onSurfaceCreated] create Beauty Transform Filters");
        this.mVFaceEyeNose.ApplyGLSLFilter();
        this.mChinThinShorten.ApplyGLSLFilter();
        this.mBasic3.ApplyGLSLFilter();
        BenchUtil.benchEnd("[onSurfaceCreated] create Beauty Transform Filters");
        BenchUtil.benchStart("[onSurfaceCreated] create Beauty mCopyFilter");
        this.mCopyFilter.ApplyGLSLFilter();
        BenchUtil.benchEnd("[onSurfaceCreated] create Beauty mCopyFilter");
        AppMethodBeat.o(82026);
    }

    public void setBeautyParam(BeautyParam beautyParam) {
        AppMethodBeat.i(82027);
        if (beautyParam == null) {
            AppMethodBeat.o(82027);
            return;
        }
        setBeautyParam(TYPE.FACE_V.value, beautyParam.vlian);
        setBeautyParam(TYPE.EYE.value, beautyParam.eye);
        setBeautyParam(TYPE.NOSE.value, beautyParam.nose);
        setBeautyParam(TYPE.FACE_THIN.value, beautyParam.zhailian);
        setBeautyParam(TYPE.CHIN.value, beautyParam.xiaba);
        setBeautyParam(TYPE.FACE_SHORTEN.value, beautyParam.faceShorten);
        if (BeautyParam.MESH_SET == 0) {
            setBeautyParam(TYPE.BASIC3.value, beautyParam.basic573);
        } else {
            setBeautyParam(TYPE.BASIC3.value, beautyParam.basic4);
        }
        rebuildFilterList();
        AppMethodBeat.o(82027);
    }

    public void setBeautyParam(int i, DistortParam distortParam) {
        AppMethodBeat.i(82028);
        if (distortParam == null) {
            AppMethodBeat.o(82028);
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
        AppMethodBeat.o(82028);
    }

    private void rebuildFilterList() {
        AppMethodBeat.i(82029);
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
        AppMethodBeat.o(82029);
    }

    private void clearTransFrame() {
        AppMethodBeat.i(82030);
        for (h clear : this.transFrame) {
            clear.clear();
        }
        AppMethodBeat.o(82030);
    }

    public h process(h hVar, List<List<PointF>> list, double d, List<float[]> list2, float f) {
        AppMethodBeat.i(82031);
        updateVideoSize(hVar.width, hVar.height, d);
        h updateAndRender = updateAndRender(hVar, list, list2, f);
        AppMethodBeat.o(82031);
        return updateAndRender;
    }

    private boolean samePeople(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.i(82032);
        if (AlgoUtils.getDistance(new PointF((((PointF) list.get(18)).x + ((PointF) list.get(0)).x) / 2.0f, (((PointF) list.get(18)).y + ((PointF) list.get(0)).y) / 2.0f), new PointF((((PointF) list2.get(18)).x + ((PointF) list2.get(0)).x) / 2.0f, (((PointF) list2.get(18)).y + ((PointF) list2.get(0)).y) / 2.0f)) < Math.min(AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(18)), AlgoUtils.getDistance((PointF) list2.get(0), (PointF) list2.get(18))) * 0.5f) {
            AppMethodBeat.o(82032);
            return true;
        }
        AppMethodBeat.o(82032);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updatePeopleList(List<List<PointF>> list, List<float[]> list2) {
        AppMethodBeat.i(82033);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(82033);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj;
            List list3 = (List) list.get(i);
            for (FaceInfoOfPeople faceInfoOfPeople : this.peopleList) {
                FaceInfoOfPeople faceInfoOfPeople2;
                if (samePeople(list3, (List) faceInfoOfPeople2.faces.getLast())) {
                    if (faceInfoOfPeople2.count > 0) {
                        faceInfoOfPeople2.faces.clear();
                        faceInfoOfPeople2.facesAngles.clear();
                    }
                    faceInfoOfPeople2.faces.add(list3);
                    if (faceInfoOfPeople2.faces.size() > FACE_CACHE_LEN) {
                        faceInfoOfPeople2.faces.removeFirst();
                    }
                    faceInfoOfPeople2.facesAngles.add(list2.get(i));
                    if (faceInfoOfPeople2.facesAngles.size() > FACE_CACHE_LEN) {
                        faceInfoOfPeople2.facesAngles.removeFirst();
                    }
                    faceInfoOfPeople2.count = -1;
                    obj = null;
                    if (obj == null) {
                        faceInfoOfPeople2 = new FaceInfoOfPeople();
                        faceInfoOfPeople2.faces.add(list3);
                        faceInfoOfPeople2.facesAngles.add(list2.get(i));
                        this.peopleList.add(faceInfoOfPeople2);
                    }
                }
            }
            int obj2 = 1;
            if (obj2 == null) {
            }
        }
        Iterator it = this.peopleList.iterator();
        while (it.hasNext()) {
            FaceInfoOfPeople faceInfoOfPeople3 = (FaceInfoOfPeople) it.next();
            faceInfoOfPeople3.count++;
            if (faceInfoOfPeople3.count > 0) {
                if (faceInfoOfPeople3.count >= 6) {
                    it.remove();
                } else {
                    int chooseBestDataIndex = chooseBestDataIndex(faceInfoOfPeople3.faces, faceInfoOfPeople3.facesAngles);
                    List list4 = (List) faceInfoOfPeople3.faces.get(chooseBestDataIndex);
                    float[] fArr = (float[]) faceInfoOfPeople3.facesAngles.get(chooseBestDataIndex);
                    faceInfoOfPeople3.faces.clear();
                    faceInfoOfPeople3.facesAngles.clear();
                    faceInfoOfPeople3.faces.add(list4);
                    faceInfoOfPeople3.facesAngles.add(fArr);
                }
            }
        }
        AppMethodBeat.o(82033);
    }

    private int chooseBestDataIndex(List<List<PointF>> list, List<float[]> list2) {
        AppMethodBeat.i(82034);
        String.valueOf(list.size());
        for (int size = list.size() - 1; size >= 0; size--) {
            if (sameShape((List) list.get(0), (List) list.get(size), (float[]) list2.get(0), (float[]) list2.get(size))) {
                String.valueOf(size);
                AppMethodBeat.o(82034);
                return size;
            }
        }
        AppMethodBeat.o(82034);
        return 0;
    }

    private FaceInfoOfFrame getFaceInfo() {
        AppMethodBeat.i(82035);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (FaceInfoOfPeople faceInfoOfPeople : this.peopleList) {
            arrayList.add(faceInfoOfPeople.faces.getLast());
            arrayList2.add(faceInfoOfPeople.facesAngles.getLast());
            arrayList3.add(Integer.valueOf(faceInfoOfPeople.count));
        }
        FaceInfoOfFrame faceInfoOfFrame = new FaceInfoOfFrame(arrayList, arrayList2, arrayList3);
        AppMethodBeat.o(82035);
        return faceInfoOfFrame;
    }

    private boolean sameShape(List<PointF> list, List<PointF> list2, float[] fArr, float[] fArr2) {
        AppMethodBeat.i(82036);
        float min = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr[1]) * 1.2d));
        float min2 = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr[0]) * 1.1d));
        float distance = (float) (((double) AlgoUtils.getDistance((PointF) list.get(0), (PointF) list.get(18))) / Math.cos((double) min));
        min = (float) (((double) AlgoUtils.getDistance((PointF) list.get(44), (PointF) list.get(54))) / Math.cos((double) min));
        min2 = (float) (((double) AlgoUtils.getDistance(new PointF((((PointF) list.get(54)).x + ((PointF) list.get(44)).x) / 2.0f, (((PointF) list.get(54)).y + ((PointF) list.get(44)).y) / 2.0f), (PointF) list.get(9))) / Math.cos((double) min2));
        float min3 = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr2[1]) * 1.2d));
        float min4 = (float) Math.min(0.8353981633974483d, Math.max(-0.8353981633974483d, ((double) fArr2[0]) * 1.1d));
        float distance2 = (float) (((double) AlgoUtils.getDistance((PointF) list2.get(0), (PointF) list2.get(18))) / Math.cos((double) min3));
        float distance3 = (float) (((double) AlgoUtils.getDistance((PointF) list2.get(44), (PointF) list2.get(54))) / Math.cos((double) min3));
        float distance4 = (float) (((double) AlgoUtils.getDistance(new PointF((((PointF) list2.get(54)).x + ((PointF) list2.get(44)).x) / 2.0f, (((PointF) list2.get(54)).y + ((PointF) list2.get(44)).y) / 2.0f), (PointF) list2.get(9))) / Math.cos((double) min4));
        if (((double) (Math.abs((min2 / distance) - (distance4 / distance2)) + Math.abs((min / distance) - (distance3 / distance2)))) < 0.1d) {
            AppMethodBeat.o(82036);
            return true;
        }
        AppMethodBeat.o(82036);
        return false;
    }

    private float my_smoothstep(float f, float f2, float f3) {
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = (f3 - f) / (f2 - f);
        if (f6 >= 0.0f) {
            f5 = f6;
        }
        if (f5 <= 1.0f) {
            f4 = f5;
        }
        return (3.0f - (f4 * 2.0f)) * (f4 * f4);
    }

    public h updateAndRender(h hVar, List<List<PointF>> list, List<float[]> list2, float f) {
        h hVar2;
        AppMethodBeat.i(82037);
        updatePeopleList(list, list2);
        FaceInfoOfFrame faceInfo = getFaceInfo();
        List list3 = faceInfo.faces;
        List list4 = faceInfo.facesAngles;
        List list5 = faceInfo.countList;
        this.frameIndex = (this.frameIndex + 1) % 2;
        if (BaseUtils.isEmpty(list3)) {
            hVar2 = hVar;
        } else {
            int i = 0;
            hVar2 = hVar;
            while (i < Math.min(list3.size(), 5)) {
                List list6 = (List) list3.get(i);
                float[] fArr = (float[]) list4.get(i);
                h hVar3 = hVar2;
                for (TransformFilter transformFilter : this.mFilters) {
                    BenchUtil.benchStart("[BeautyTransformList] updatePreview");
                    transformFilter.updateStrength(1.0f - my_smoothstep(0.4f, 1.0f, ((float) ((Integer) list5.get(i)).intValue()) / 6.0f));
                    transformFilter.updatePreview(new Builder().facePoints(list6).faceAngles(fArr).phoneAngle(f).build());
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
        }
        AppMethodBeat.o(82037);
        return hVar2;
    }

    public void updateAndRender(int i, int i2, float f, int i3, int i4, List<List<PointF>> list) {
        AppMethodBeat.i(82038);
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
        AppMethodBeat.o(82038);
    }

    public void clear() {
        AppMethodBeat.i(82039);
        clearTransFrame();
        this.mVFaceEyeNose.clearGLSLSelf();
        this.mChinThinShorten.clearGLSLSelf();
        this.mBasic3.clearGLSLSelf();
        this.mCopyFilter.ClearGLSL();
        AppMethodBeat.o(82039);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82040);
        this.mVFaceEyeNose.updateVideoSize(i, i2, d);
        this.mChinThinShorten.updateVideoSize(i, i2, d);
        this.mBasic3.updateVideoSize(i, i2, d);
        AppMethodBeat.o(82040);
    }

    public BeautyParam getBeautyParam() {
        return this.mBeautyParam;
    }

    public boolean needFaceInfo() {
        AppMethodBeat.i(82041);
        if (this.mFilters.size() != 0) {
            AppMethodBeat.o(82041);
            return true;
        }
        AppMethodBeat.o(82041);
        return false;
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(82042);
        this.mVFaceEyeNose.setRenderMode(i);
        this.mChinThinShorten.setRenderMode(i);
        this.mCopyFilter.setRenderMode(i);
        AppMethodBeat.o(82042);
    }

    public void updateFaceFeature(List<List<PointF>> list) {
        AppMethodBeat.i(82043);
        if (list == null) {
            AppMethodBeat.o(82043);
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
        AppMethodBeat.o(82043);
    }
}
