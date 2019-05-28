package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.ar.filter.ARParticleFilter;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.manager.MaterialManager;
import com.tencent.ttpic.manager.RandomGroupManager;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.FaceAverageUtil;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.ttpic.util.VideoFilterFactory;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import com.tencent.ttpic.util.VideoFrameUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.view.g;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class VideoFilterList {
    public static final String FABBY_LOG = "[FABBY]";
    private static final int HAND_RANDOM_INDEX = 0;
    public static final String PERF_LOG = "[showPreview]";
    private static String TAG = VideoFilterList.class.getSimpleName();
    private static final Random mRandom = new Random(System.currentTimeMillis());
    private Audio3DFilter audio3DFilter;
    private List<VideoFilterBase> bgDynamicStickerFilters;
    private List<VideoFilterBase> bgStaticStickerFilters;
    private List<NormalVideoFilter> bodyFilters;
    private List<ParticleFilter> bodyParticleFilters;
    private h[] copyFrame = new h[2];
    private CrazyFaceFilters crazyFaceFilters;
    private FabbyExtractFilter fabbyExtractFilter;
    private h fabbyFeatheredMaskStep1 = new h();
    private h fabbyFeatheredMaskStep2 = new h();
    private FabbyFilters fabbyMvFilters;
    private h fabbyOriginCopyFrame = new h();
    private FabbyStrokeFilter fabbyStrokeFilter;
    private h fabbyStrokeFrame = new h();
    private List<VideoFilterBase> faceParticleDynamicFilters;
    private List<VideoFilterBase> faceParticleStaticFilters;
    private FastBlurFilter fastBlurFilter;
    private FastStickerFilter fastBodyStickerFilter;
    private FastStickerFilter fastFaceStickerFilter;
    private FastParticleFilter fastParticleFilter = new FastParticleFilter();
    private List<VideoFilterBase> fgDynamicFilters;
    private List<VideoFilterBase> fgStaticStickerFilters;
    private List<VideoFilterBase> filters;
    private GameFilter gameFilter;
    private List<NormalVideoFilter> gestureFilters;
    private List<ParticleFilter> gestureParticleFilters;
    private HeadCropFilter headCropFilter;
    private List<NormalVideoFilter> headCropItemFilters = new ArrayList();
    private ARParticleFilter mARParticleFilter;
    private Queue<PointF> mARTouchPointQueue = new LinkedList();
    private ActFilters mActFilters;
    private Map<Integer, Float> mAgeValueMap = new HashMap();
    private h mBgFrame = new h();
    private Map<Integer, Double> mCharmValueMap = new HashMap();
    private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.bJB);
    private Map<Integer, Float> mCpValueMap = new HashMap();
    private int mCurPersonId = -1;
    private VideoFilterBase mEffectFilter;
    private h mEffectFrame = new h();
    private int mEffectOrder = -1;
    private h mEffectTestFrame = new h();
    private double mFaceDetScale = VideoMaterialUtil.SCALE_FACE_DETECT;
    private Comparator<Face> mFaceIndexComperator = new Comparator<Face>() {
        public int compare(Face face, Face face2) {
            return face.faceIndex - face2.faceIndex;
        }
    };
    private List<Face> mFaceList = new ArrayList();
    private List<VideoFilterBase> mFaceOffFilters;
    private List<FacialFeatureFilter> mFacialFeatureFilterList;
    private Map<Integer, Float> mGenderValueMap = new HashMap();
    private Map<Integer, Double> mHandsValueMap = new HashMap();
    private h mHeadCropFrame = new h();
    private LipsCosFilter mLipsCosFilter;
    private BaseFilter mMaskFilter;
    private PhantomFilter mPhantomFilter;
    private h mPhantomFrame = new h();
    private Map<Integer, Float> mPopularValueMap = new HashMap();
    private float mScaleFace = 1.0f;
    private List<List<PointF>> mTouchPoints = new ArrayList();
    private List<VideoFilterBase> mTransformFilters;
    private VideoMaterial material;
    private List<MultiViewerFilter> multiViewerFilters;
    public Map<Integer, h> multiViewerFrameMap = new HashMap();
    private h multiViewerOutFrame;
    private int multiViewerSrcTexture;
    private boolean needDetectGesture = false;
    private h renderFrame = new h();
    private VoiceTextFilter voiceTextFilter;

    class FaceData {
        public float mFaceAngle;
        public List<PointF> mFacePoints;
        public float mPhoneAngle;
        public long mTimeStamp;

        private FaceData() {
        }

        public void init(List<PointF> list, float f, float f2, long j) {
            this.mFacePoints = list;
            this.mFaceAngle = f;
            this.mPhoneAngle = f2;
            this.mTimeStamp = j;
        }
    }

    public VideoFilterList() {
        AppMethodBeat.i(83079);
        AppMethodBeat.o(83079);
    }

    static {
        AppMethodBeat.i(83159);
        AppMethodBeat.o(83159);
    }

    public h updateAndRenderDynamicStickers(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83080);
        if (!pTFaceAttr.isLandscape() || getMaterial().isSupportLandscape()) {
            if (pTFaceAttr.getFaceCount() > 0) {
                setImageData(pTFaceAttr.getData());
            }
            BenchUtil.benchStart("[VideoFilterList] updateAndRender");
            hVar = updateAndRender(hVar, pTFaceAttr);
            BenchUtil.benchEnd("[VideoFilterList] updateAndRender");
            AppMethodBeat.o(83080);
            return hVar;
        }
        destroyNormalAudio();
        AppMethodBeat.o(83080);
        return hVar;
    }

    private h RenderProcessForFilters(h hVar, List<? extends VideoFilterBase> list) {
        AppMethodBeat.i(83081);
        h RenderProcessForFilters = RenderProcessForFilters(hVar, null, list);
        AppMethodBeat.o(83081);
        return RenderProcessForFilters;
    }

    private h RenderProcessForFilters(h hVar, h hVar2, List<? extends VideoFilterBase> list) {
        AppMethodBeat.i(83082);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83082);
            return hVar;
        }
        h hVar3;
        if (hVar.texture[0] == this.copyFrame[0].texture[0]) {
            hVar3 = this.copyFrame[1];
        } else {
            hVar3 = this.copyFrame[0];
        }
        if (hVar2 == null) {
            hVar2 = hVar;
        }
        GLES20.glBindFramebuffer(36160, hVar2.bJz[0]);
        GLES20.glViewport(0, 0, hVar2.width, hVar2.height);
        int i = 0;
        h hVar4 = hVar;
        while (i < list.size()) {
            h hVar5;
            VideoFilterBase videoFilterBase = (VideoFilterBase) list.get(i);
            if (needRender(videoFilterBase)) {
                if (VideoFilterUtil.canUseBlendMode(videoFilterBase)) {
                    BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
                    videoFilterBase.OnDrawFrameGLSL();
                    videoFilterBase.renderTexture(hVar4.texture[0], hVar4.width, hVar4.height);
                    BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
                } else {
                    h renderProcessByCopy;
                    if (VideoFilterUtil.needCopy(videoFilterBase)) {
                        GlUtil.setBlendMode(false);
                        hVar4 = FrameUtil.renderProcessBySwitchFbo(hVar4.texture[0], hVar4.width, hVar4.height, this.mCopyFilter, hVar, hVar3);
                        GlUtil.setBlendMode(true);
                    }
                    BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + videoFilterBase.getClass().getName());
                    if (VideoFilterUtil.maybeTransformFilter(videoFilterBase) && VideoMaterialUtil.needCopyTransform()) {
                        renderProcessByCopy = VideoFrameUtil.renderProcessByCopy(hVar4.texture[0], hVar4.width, hVar4.height, videoFilterBase, this.mCopyFilter, hVar, hVar3);
                    } else {
                        renderProcessByCopy = VideoFrameUtil.renderProcessBySwitchFbo(hVar4.texture[0], hVar4.width, hVar4.height, videoFilterBase, hVar, hVar3);
                    }
                    BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + videoFilterBase.getClass().getName());
                    hVar5 = renderProcessByCopy;
                    hVar2 = renderProcessByCopy;
                    i++;
                    hVar4 = hVar5;
                }
            }
            hVar5 = hVar4;
            i++;
            hVar4 = hVar5;
        }
        AppMethodBeat.o(83082);
        return hVar2;
    }

    private h RenderProcessForFastFaceStickerFilter(h hVar, h hVar2, List<Face> list, int i, PTFaceAttr pTFaceAttr, int i2) {
        AppMethodBeat.i(83083);
        if (hVar2 != null) {
            hVar = hVar2;
        }
        this.fastFaceStickerFilter.setFaceCount(i);
        this.fastFaceStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
        if (i <= 0) {
            this.fastFaceStickerFilter.updatePreview(new Builder().faceActionCounter(pTFaceAttr.getFaceActionCounter()).triggeredExpression(pTFaceAttr.getTriggeredExpression()).timestamp(pTFaceAttr.getTimeStamp()).faceDetector(pTFaceAttr.getFaceDetector()).build());
        } else {
            int i3 = 0;
            while (i3 < i && i3 < list.size()) {
                Face face = (Face) list.get(i3);
                this.fastFaceStickerFilter.updatePreview(new Builder().facePoints(face.facePoints).faceAngles(face.faceAngles).faceActionCounter(pTFaceAttr.getFaceActionCounter()).handPoints(pTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(pTFaceAttr.getTriggeredExpression()).phoneAngle((float) pTFaceAttr.getRotation()).timestamp(pTFaceAttr.getTimeStamp()).faceDetector(pTFaceAttr.getFaceDetector()).build());
                this.fastFaceStickerFilter.setRenderParams(i2);
                i3++;
            }
        }
        this.fastFaceStickerFilter.render(hVar);
        AppMethodBeat.o(83083);
        return hVar;
    }

    private h RenderProcessForAudio3DFilter(h hVar, h hVar2, List<Face> list, int i, PTFaceAttr pTFaceAttr, int i2) {
        AppMethodBeat.i(83084);
        if (hVar2 != null) {
            hVar = hVar2;
        }
        this.audio3DFilter.setFaceCount(i);
        this.audio3DFilter.addSrcTexture(this.multiViewerSrcTexture);
        if (i <= 0) {
            this.audio3DFilter.updatePreview(new Builder().faceActionCounter(pTFaceAttr.getFaceActionCounter()).triggeredExpression(pTFaceAttr.getTriggeredExpression()).timestamp(pTFaceAttr.getTimeStamp()).faceDetector(pTFaceAttr.getFaceDetector()).build());
        } else {
            int i3 = 0;
            while (i3 < i && i3 < list.size()) {
                Face face = (Face) list.get(i3);
                this.audio3DFilter.updatePreview(new Builder().facePoints(face.facePoints).faceAngles(face.faceAngles).faceActionCounter(pTFaceAttr.getFaceActionCounter()).handPoints(pTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(pTFaceAttr.getTriggeredExpression()).phoneAngle((float) pTFaceAttr.getRotation()).timestamp(pTFaceAttr.getTimeStamp()).faceDetector(pTFaceAttr.getFaceDetector()).build());
                this.audio3DFilter.setRenderParams(i2);
                i3++;
            }
        }
        this.audio3DFilter.render(hVar, pTFaceAttr);
        AppMethodBeat.o(83084);
        return hVar;
    }

    private h RenderProcessForFastBodyStickerFilter(h hVar, h hVar2, PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(83085);
        if (hVar2 != null) {
            hVar = hVar2;
        }
        this.fastBodyStickerFilter.setFaceCount(1);
        this.fastBodyStickerFilter.addSrcTexture(this.multiViewerSrcTexture);
        this.fastBodyStickerFilter.updatePreview(pTDetectInfo);
        this.fastBodyStickerFilter.setRenderParams(0);
        this.fastBodyStickerFilter.render(hVar);
        AppMethodBeat.o(83085);
        return hVar;
    }

    private h RenderProcessForFastParticleFilter(h hVar, List<ParticleFilter> list) {
        AppMethodBeat.i(83086);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83086);
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (((ParticleFilter) list.get(i2)).getParticleParam().needRender) {
                    arrayList.add(((ParticleFilter) list.get(i2)).getParticleParam());
                }
                i = i2 + 1;
            }
            this.fastParticleFilter.render(arrayList, hVar);
            AppMethodBeat.o(83086);
        }
        return hVar;
    }

    public h RenderProcess(h hVar) {
        AppMethodBeat.i(83087);
        if (BaseUtils.isEmpty(this.filters)) {
            AppMethodBeat.o(83087);
            return hVar;
        }
        h hVar2;
        if (hVar.texture[0] == this.copyFrame[0].texture[0]) {
            hVar2 = this.copyFrame[1];
        } else {
            hVar2 = this.copyFrame[0];
        }
        GLES20.glBindFramebuffer(36160, hVar.bJz[0]);
        GLES20.glViewport(0, 0, hVar.width, hVar.height);
        int i = 0;
        h hVar3 = hVar;
        while (i < this.filters.size()) {
            h hVar4;
            VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i);
            if (needRender(videoFilterBase)) {
                if (VideoFilterUtil.canUseBlendMode(videoFilterBase)) {
                    BenchUtil.benchStart("[showPreview]OnDrawFrameGLSL");
                    videoFilterBase.OnDrawFrameGLSL();
                    videoFilterBase.renderTexture(hVar3.texture[0], hVar3.width, hVar3.height);
                    BenchUtil.benchEnd("[showPreview]OnDrawFrameGLSL");
                } else {
                    h renderProcessByCopy;
                    if (VideoFilterUtil.needCopy(videoFilterBase)) {
                        hVar3 = FrameUtil.renderProcessBySwitchFbo(hVar3.texture[0], hVar3.width, hVar3.height, this.mCopyFilter, hVar, hVar2);
                    }
                    BenchUtil.benchStart("[showPreview]renderProcessBySwitchFbo " + videoFilterBase.getClass().getName());
                    if (VideoFilterUtil.maybeTransformFilter(videoFilterBase) && VideoMaterialUtil.needCopyTransform()) {
                        renderProcessByCopy = VideoFrameUtil.renderProcessByCopy(hVar3.texture[0], hVar3.width, hVar3.height, videoFilterBase, this.mCopyFilter, hVar, hVar2);
                    } else {
                        renderProcessByCopy = VideoFrameUtil.renderProcessBySwitchFbo(hVar3.texture[0], hVar3.width, hVar3.height, videoFilterBase, hVar, hVar2);
                    }
                    BenchUtil.benchEnd("[showPreview]renderProcessBySwitchFbo " + videoFilterBase.getClass().getName());
                    hVar4 = renderProcessByCopy;
                    i++;
                    hVar3 = hVar4;
                }
            }
            hVar4 = hVar3;
            i++;
            hVar3 = hVar4;
        }
        AppMethodBeat.o(83087);
        return hVar3;
    }

    private void hitCharmRangeItem(int i) {
        AppMethodBeat.i(83088);
        if (this.filters != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i3);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.charmRange == null)) {
                        stickerItem.charmRange.hit(((Double) this.mCharmValueMap.get(Integer.valueOf(i))).doubleValue());
                    }
                }
                if (videoFilterBase instanceof FaceOffFilter) {
                    FaceItem faceOffItem = ((FaceOffFilter) videoFilterBase).getFaceOffItem();
                    if (!(faceOffItem == null || faceOffItem.charmRange == null)) {
                        faceOffItem.charmRange.hit(((Double) this.mCharmValueMap.get(Integer.valueOf(i))).doubleValue());
                    }
                }
                if (videoFilterBase instanceof TransformFilter) {
                    FaceMeshItem faceMeshItem = ((TransformFilter) videoFilterBase).getFaceMeshItem();
                    if (!(faceMeshItem == null || faceMeshItem.charmRange == null)) {
                        faceMeshItem.charmRange.hit(((Double) this.mCharmValueMap.get(Integer.valueOf(i))).doubleValue());
                    }
                }
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(83088);
    }

    private void hitFaceRandomGroupItem(int i) {
        AppMethodBeat.i(83089);
        if (this.filters != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i3);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    ((NormalVideoFilter) videoFilterBase).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(i));
                }
                if (videoFilterBase instanceof FaceOffFilter) {
                    ((FaceOffFilter) videoFilterBase).updateRandomGroupValue(RandomGroupManager.getInstance().getFaceValue(i));
                }
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(83089);
    }

    private void hitHandRandomGroupItem() {
        AppMethodBeat.i(83090);
        if (this.gestureFilters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gestureFilters.size()) {
                    break;
                }
                ((NormalVideoFilter) this.gestureFilters.get(i2)).updateRandomGroupValue(RandomGroupManager.getInstance().getHandValue());
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(83090);
    }

    private boolean hasHands(List<PointF> list) {
        AppMethodBeat.i(83091);
        if (list != null && list.size() > 0 && this.gestureFilters != null && this.gestureFilters.size() > 0) {
            for (PointF pointF : list) {
                if (((double) ((pointF.y * pointF.y) + (pointF.x * pointF.x))) >= 1.0E-4d) {
                    NormalVideoFilter normalVideoFilter = (NormalVideoFilter) this.gestureFilters.get(0);
                    if (!(normalVideoFilter == null || normalVideoFilter.getStickerItem() == null)) {
                        boolean isGestureTriggered = GestureDetector.getInstance().isGestureTriggered(normalVideoFilter.getStickerItem().triggerType);
                        AppMethodBeat.o(83091);
                        return isGestureTriggered;
                    }
                }
            }
        }
        AppMethodBeat.o(83091);
        return false;
    }

    private boolean isHandPointsValid(List<PointF> list) {
        AppMethodBeat.i(83092);
        if (list == null) {
            AppMethodBeat.o(83092);
            return false;
        }
        int i = 0;
        for (PointF pointF : list) {
            i = (int) (((pointF.y * pointF.y) + (pointF.x * pointF.x)) + ((float) i));
        }
        if (((double) i) > 1.0E-4d) {
            AppMethodBeat.o(83092);
            return true;
        }
        AppMethodBeat.o(83092);
        return false;
    }

    private void syncCharmRangeAndHandsRangeValue(boolean z) {
        double nextDouble;
        double nextDouble2;
        AppMethodBeat.i(83093);
        if ((!BaseUtils.isEmpty(this.mFaceList) && !this.mCharmValueMap.containsKey(Integer.valueOf(((Face) this.mFaceList.get(0)).faceIndex))) || (z && !this.mHandsValueMap.containsKey(Integer.valueOf(0)))) {
            nextDouble = mRandom.nextDouble();
        } else if (!BaseUtils.isEmpty(this.mFaceList) && this.mCharmValueMap.containsKey(Integer.valueOf(((Face) this.mFaceList.get(0)).faceIndex))) {
            nextDouble = ((Double) this.mCharmValueMap.get(Integer.valueOf(((Face) this.mFaceList.get(0)).faceIndex))).doubleValue();
        } else if (this.mHandsValueMap.containsKey(Integer.valueOf(0))) {
            nextDouble = ((Double) this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue();
        } else {
            nextDouble = -1.0d;
        }
        if (nextDouble < 0.0d) {
            nextDouble2 = mRandom.nextDouble();
        } else {
            nextDouble2 = nextDouble;
        }
        if (!BaseUtils.isEmpty(this.mFaceList)) {
            this.mCharmValueMap.put(Integer.valueOf(((Face) this.mFaceList.get(0)).faceIndex), Double.valueOf(nextDouble2));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.mFaceList.size()) {
                break;
            }
            if (!this.mCharmValueMap.containsKey(Integer.valueOf(((Face) this.mFaceList.get(i2)).faceIndex))) {
                this.mCharmValueMap.put(Integer.valueOf(((Face) this.mFaceList.get(i2)).faceIndex), Double.valueOf(mRandom.nextDouble()));
            }
            i = i2 + 1;
        }
        if (z) {
            this.mHandsValueMap.put(Integer.valueOf(0), Double.valueOf(nextDouble2));
        }
        AppMethodBeat.o(83093);
    }

    private void syncRandomGroupValue(boolean z) {
        AppMethodBeat.i(83094);
        if (this.material.getRandomGroupCount() <= 0) {
            AppMethodBeat.o(83094);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Face face : this.mFaceList) {
            arrayList.add(Integer.valueOf(face.faceIndex));
        }
        RandomGroupManager.getInstance().updateValue(arrayList, z, this.material.getRandomGroupCount());
        AppMethodBeat.o(83094);
    }

    private void hitHandsRangeItem() {
        AppMethodBeat.i(83095);
        if (this.mHandsValueMap.containsKey(Integer.valueOf(0))) {
            if (this.gestureFilters != null) {
                for (int i = 0; i < this.gestureFilters.size(); i++) {
                    StickerItem stickerItem = ((NormalVideoFilter) this.gestureFilters.get(i)).getStickerItem();
                    if (!(stickerItem == null || stickerItem.charmRange == null)) {
                        stickerItem.charmRange.hit(((Double) this.mHandsValueMap.get(Integer.valueOf(0))).doubleValue());
                    }
                }
            }
            AppMethodBeat.o(83095);
            return;
        }
        AppMethodBeat.o(83095);
    }

    private void hitPopularRangeItem(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector, int i) {
        AppMethodBeat.i(83096);
        if (videoPreviewFaceOutlineDetector.needDetectFaceValue()) {
            if (this.filters != null) {
                if (!this.mPopularValueMap.containsKey(Integer.valueOf(i)) || (this.mPopularValueMap.containsKey(Integer.valueOf(i)) && ((Float) this.mPopularValueMap.get(Integer.valueOf(i))).floatValue() < 0.0f)) {
                    float faceValues = videoPreviewFaceOutlineDetector.getFaceValues(i, DETECT_TYPE.DETECT_TYPE_POPULAR.value);
                    if (((int) (faceValues * 100.0f)) == 0) {
                        AppMethodBeat.o(83096);
                        return;
                    }
                    this.mPopularValueMap.put(Integer.valueOf(i), Float.valueOf(faceValues));
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.filters.size()) {
                        break;
                    }
                    VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i3);
                    if (videoFilterBase instanceof NormalVideoFilter) {
                        StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                        if (stickerItem != null) {
                            if (stickerItem.popularRange != null) {
                                stickerItem.popularRange.setValue(((Float) this.mPopularValueMap.get(Integer.valueOf(i))).floatValue());
                            }
                            if ((videoFilterBase instanceof DynamicNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_POPULAR.value) {
                                ((DynamicNumFilter) videoFilterBase).setNum((int) (((Float) this.mPopularValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                            if ((videoFilterBase instanceof StaticNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_POPULAR.value) {
                                ((StaticNumFilter) videoFilterBase).setNum((int) (((Float) this.mPopularValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            AppMethodBeat.o(83096);
            return;
        }
        AppMethodBeat.o(83096);
    }

    private void hitAgeRangeItem(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector, int i) {
        AppMethodBeat.i(83097);
        if (videoPreviewFaceOutlineDetector.needDetectFaceValue()) {
            if (this.filters != null) {
                if (!this.mAgeValueMap.containsKey(Integer.valueOf(i)) || (this.mAgeValueMap.containsKey(Integer.valueOf(i)) && ((Float) this.mAgeValueMap.get(Integer.valueOf(i))).floatValue() < 0.0f)) {
                    float faceValues = videoPreviewFaceOutlineDetector.getFaceValues(i, DETECT_TYPE.DETECT_TYPE_AGE.value);
                    if (((int) (faceValues * 100.0f)) == 0) {
                        AppMethodBeat.o(83097);
                        return;
                    } else {
                        this.mAgeValueMap.put(Integer.valueOf(i), Float.valueOf(getAdjustedAge(faceValues)));
                    }
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.filters.size()) {
                        break;
                    }
                    VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i3);
                    if (videoFilterBase instanceof NormalVideoFilter) {
                        StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                        if (stickerItem != null) {
                            if (stickerItem.ageRange != null) {
                                stickerItem.ageRange.setValue(((Float) this.mAgeValueMap.get(Integer.valueOf(i))).floatValue());
                            }
                            if ((videoFilterBase instanceof DynamicNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_AGE.value) {
                                ((DynamicNumFilter) videoFilterBase).setNum((int) (((Float) this.mAgeValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                            if ((videoFilterBase instanceof StaticNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_AGE.value) {
                                ((StaticNumFilter) videoFilterBase).setNum((int) (((Float) this.mAgeValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            AppMethodBeat.o(83097);
            return;
        }
        AppMethodBeat.o(83097);
    }

    private void hitGenderRangeItem(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector, int i) {
        AppMethodBeat.i(83098);
        if (videoPreviewFaceOutlineDetector.needDetectFaceValue()) {
            if (this.filters != null) {
                if (!this.mGenderValueMap.containsKey(Integer.valueOf(i)) || (this.mGenderValueMap.containsKey(Integer.valueOf(i)) && ((Float) this.mGenderValueMap.get(Integer.valueOf(i))).floatValue() < 0.0f)) {
                    float faceValues = videoPreviewFaceOutlineDetector.getFaceValues(i, DETECT_TYPE.DETECT_TYPE_SEX.value);
                    if (((int) (faceValues * 100.0f)) == 0) {
                        AppMethodBeat.o(83098);
                        return;
                    }
                    this.mGenderValueMap.put(Integer.valueOf(i), Float.valueOf(faceValues));
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.filters.size()) {
                        break;
                    }
                    VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i3);
                    if (videoFilterBase instanceof NormalVideoFilter) {
                        StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                        if (stickerItem != null) {
                            if (stickerItem.genderRange != null) {
                                stickerItem.genderRange.setValue(((Float) this.mGenderValueMap.get(Integer.valueOf(i))).floatValue());
                            }
                            if ((videoFilterBase instanceof DynamicNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_SEX.value) {
                                ((DynamicNumFilter) videoFilterBase).setNum((int) (((Float) this.mGenderValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                            if ((videoFilterBase instanceof StaticNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_SEX.value) {
                                ((StaticNumFilter) videoFilterBase).setNum((int) (((Float) this.mGenderValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                            }
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            AppMethodBeat.o(83098);
            return;
        }
        AppMethodBeat.o(83098);
    }

    private float getAdjustedAge(float f) {
        if (((double) f) >= 0.21d && ((double) f) <= 0.25d) {
            return (float) (((double) f) * 0.8d);
        }
        if (((double) f) >= 0.26d && ((double) f) <= 0.3d) {
            return (float) (((double) f) * 0.7d);
        }
        if (((double) f) >= 0.31d && ((double) f) <= 0.49d) {
            return (float) (((double) f) * 0.6d);
        }
        if (((double) f) < 0.5d || ((double) f) > 0.7d) {
            return f;
        }
        return (float) (((double) f) * 0.5d);
    }

    private void hitCpRangeItem(VideoPreviewFaceOutlineDetector videoPreviewFaceOutlineDetector, int i, int i2) {
        AppMethodBeat.i(83099);
        if (!videoPreviewFaceOutlineDetector.needDetectFaceValue() || i2 < 2) {
            AppMethodBeat.o(83099);
            return;
        }
        if (this.filters != null) {
            if (!this.mCpValueMap.containsKey(Integer.valueOf(i)) || (this.mCpValueMap.containsKey(Integer.valueOf(i)) && ((Float) this.mCpValueMap.get(Integer.valueOf(i))).floatValue() < 0.0f)) {
                float faceValues = videoPreviewFaceOutlineDetector.getFaceValues(i, DETECT_TYPE.DETECT_TYPE_CP.value);
                if (((int) (faceValues * 100.0f)) == 0) {
                    AppMethodBeat.o(83099);
                    return;
                }
                this.mCpValueMap.put(Integer.valueOf(i), Float.valueOf(faceValues));
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i4);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (stickerItem != null) {
                        if (stickerItem.cpRange != null) {
                            stickerItem.cpRange.setValue(((Float) this.mCpValueMap.get(Integer.valueOf(i))).floatValue());
                        }
                        if ((videoFilterBase instanceof StaticNumFilter) && stickerItem.markMode == DETECT_TYPE.DETECT_TYPE_CP.value) {
                            ((StaticNumFilter) videoFilterBase).setNum((int) (((Float) this.mCpValueMap.get(Integer.valueOf(i))).floatValue() * 100.0f));
                        }
                    }
                }
                i3 = i4 + 1;
            }
        }
        AppMethodBeat.o(83099);
    }

    private void clearCharmRangeItemStatus() {
        AppMethodBeat.i(83100);
        if (this.filters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i2);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.charmRange == null)) {
                        stickerItem.charmRange.clearStatus();
                    }
                }
                i = i2 + 1;
            }
        }
        this.mCharmValueMap.clear();
        AppMethodBeat.o(83100);
    }

    private void clearHandsRangeItemStatus() {
        AppMethodBeat.i(83101);
        if (this.gestureFilters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gestureFilters.size()) {
                    break;
                }
                StickerItem stickerItem = ((NormalVideoFilter) ((VideoFilterBase) this.gestureFilters.get(i2))).getStickerItem();
                if (!(stickerItem == null || stickerItem.charmRange == null)) {
                    stickerItem.charmRange.clearStatus();
                }
                i = i2 + 1;
            }
        }
        this.mHandsValueMap.clear();
        AppMethodBeat.o(83101);
    }

    private void clearAgeRangeItemStatus() {
        AppMethodBeat.i(83102);
        if (this.filters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i2);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.ageRange == null)) {
                        stickerItem.ageRange.clearStatus();
                    }
                }
                i = i2 + 1;
            }
        }
        this.mAgeValueMap.clear();
        AppMethodBeat.o(83102);
    }

    private void clearGenderRangeItemStatus() {
        AppMethodBeat.i(83103);
        if (this.filters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i2);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.genderRange == null)) {
                        stickerItem.genderRange.clearStatus();
                    }
                }
                i = i2 + 1;
            }
        }
        this.mGenderValueMap.clear();
        AppMethodBeat.o(83103);
    }

    private void clearPopularRangeItemStatus() {
        AppMethodBeat.i(83104);
        if (this.filters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i2);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.popularRange == null)) {
                        stickerItem.popularRange.clearStatus();
                    }
                }
                i = i2 + 1;
            }
        }
        this.mPopularValueMap.clear();
        AppMethodBeat.o(83104);
    }

    private void clearCpRangeItemStatus() {
        AppMethodBeat.i(83105);
        if (this.filters != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.filters.size()) {
                    break;
                }
                VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i2);
                if (videoFilterBase instanceof NormalVideoFilter) {
                    StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
                    if (!(stickerItem == null || stickerItem.cpRange == null)) {
                        stickerItem.cpRange.clearStatus();
                    }
                }
                i = i2 + 1;
            }
        }
        this.mCpValueMap.clear();
        AppMethodBeat.o(83105);
    }

    private void removeValueRangeForFace(int i) {
        AppMethodBeat.i(83106);
        this.mCharmValueMap.remove(Integer.valueOf(i));
        this.mAgeValueMap.remove(Integer.valueOf(i));
        this.mGenderValueMap.remove(Integer.valueOf(i));
        this.mPopularValueMap.remove(Integer.valueOf(i));
        this.mCpValueMap.remove(Integer.valueOf(i));
        AppMethodBeat.o(83106);
    }

    private void clearFaceMappingData() {
        AppMethodBeat.i(83107);
        this.mFaceList.clear();
        AppMethodBeat.o(83107);
    }

    private void init() {
        AppMethodBeat.i(83108);
        this.mCurPersonId = -1;
        MaterialManager.getInstance().setCurrentMaterial(this.material);
        AppMethodBeat.o(83108);
    }

    public void updateVideoSize(int i, int i2, double d, int i3) {
        AppMethodBeat.i(83109);
        this.mFaceDetScale = d;
        for (VideoFilterBase updateVideoSize : this.filters) {
            updateVideoSize.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize2 : this.gestureFilters) {
            updateVideoSize2.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize22 : this.bodyFilters) {
            updateVideoSize22.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize222 : this.faceParticleDynamicFilters) {
            updateVideoSize222.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize2222 : this.faceParticleStaticFilters) {
            updateVideoSize2222.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize22222 : this.gestureParticleFilters) {
            updateVideoSize22222.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize222222 : this.bodyParticleFilters) {
            updateVideoSize222222.updateVideoSize(i, i2, d);
        }
        for (VideoFilterBase updateVideoSize2222222 : this.headCropItemFilters) {
            updateVideoSize2222222.updateVideoSize(i, i2, d);
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.updateVideoSize(i, i2, d);
        }
        if (this.headCropFilter != null) {
            this.headCropFilter.updateVideoSize(i, i2, d);
        }
        if (this.crazyFaceFilters != null) {
            this.crazyFaceFilters.updateVideoSize(i, i2, d);
        }
        if (this.mFacialFeatureFilterList != null) {
            for (FacialFeatureFilter updateVideoSize3 : this.mFacialFeatureFilterList) {
                updateVideoSize3.updateVideoSize(i, i2, d);
            }
        }
        if (this.mLipsCosFilter != null) {
            this.mLipsCosFilter.updateVideoSize(i, i2, d);
        }
        if (this.mARParticleFilter != null) {
            this.mARParticleFilter.updateVideoSize(i, i2, d);
        }
        if (this.voiceTextFilter != null) {
            this.voiceTextFilter.updateVideoSize(i, i2, d);
        }
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.updateVideoSize(i, i2, d);
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.updateVideoSize(i, i2, d);
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.updateVideoSize(i, i2, d, i3);
        }
        AppMethodBeat.o(83109);
    }

    public void updateTextureParam(Map<Integer, FaceActionCounter> map, Set<Integer> set, long j) {
        AppMethodBeat.i(83110);
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                ((NormalVideoFilter) videoFilterBase).updateTextureParam(j);
            }
        }
        if (this.headCropItemFilters != null) {
            for (VideoFilterBase videoFilterBase2 : this.headCropItemFilters) {
                if (videoFilterBase2 instanceof NormalVideoFilter) {
                    ((NormalVideoFilter) videoFilterBase2).updateTextureParam(j);
                }
            }
        }
        if (this.gestureFilters != null) {
            for (NormalVideoFilter updateTextureParam : this.gestureFilters) {
                updateTextureParam.updateTextureParam(j);
            }
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.updateTextureParam(map, set, j);
        }
        AppMethodBeat.o(83110);
    }

    public void updateAllFilters(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(83111);
        updateFilters(pTDetectInfo, this.filters);
        AppMethodBeat.o(83111);
    }

    public void updateFilters(PTDetectInfo pTDetectInfo, List<? extends VideoFilterBase> list) {
        AppMethodBeat.i(83112);
        for (VideoFilterBase updatePreview : list) {
            updatePreview.updatePreview(pTDetectInfo);
        }
        AppMethodBeat.o(83112);
    }

    public void destroy() {
        AppMethodBeat.i(83113);
        destroyAudio();
        for (VideoFilterBase clearGLSLSelf : this.filters) {
            clearGLSLSelf.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf2 : this.gestureFilters) {
            clearGLSLSelf2.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf22 : this.bodyFilters) {
            clearGLSLSelf22.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf222 : this.faceParticleDynamicFilters) {
            clearGLSLSelf222.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf2222 : this.faceParticleStaticFilters) {
            clearGLSLSelf2222.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf22222 : this.gestureParticleFilters) {
            clearGLSLSelf22222.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf222222 : this.bodyParticleFilters) {
            clearGLSLSelf222222.clearGLSLSelf();
        }
        for (VideoFilterBase clearGLSLSelf2222222 : this.headCropItemFilters) {
            clearGLSLSelf2222222.clearGLSLSelf();
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.clear();
        }
        if (this.multiViewerFilters != null) {
            for (MultiViewerFilter clear : this.multiViewerFilters) {
                clear.clear();
            }
        }
        if (this.gameFilter != null) {
            this.gameFilter.clear();
        }
        this.renderFrame.clear();
        this.mEffectFrame.clear();
        this.mEffectTestFrame.clear();
        this.mHeadCropFrame.clear();
        this.mBgFrame.clear();
        this.fabbyStrokeFrame.clear();
        this.fabbyFeatheredMaskStep1.clear();
        this.fabbyFeatheredMaskStep2.clear();
        this.mPhantomFrame.clear();
        for (h clear2 : this.copyFrame) {
            clear2.clear();
        }
        for (h clear3 : this.multiViewerFrameMap.values()) {
            clear3.clear();
        }
        this.multiViewerFrameMap.clear();
        this.mCopyFilter.ClearGLSL();
        if (this.headCropFilter != null) {
            this.headCropFilter.clearGLSLSelf();
        }
        if (this.crazyFaceFilters != null) {
            this.crazyFaceFilters.clear();
        }
        if (this.mFacialFeatureFilterList != null) {
            for (FacialFeatureFilter clearGLSLSelf3 : this.mFacialFeatureFilterList) {
                clearGLSLSelf3.clearGLSLSelf();
            }
        }
        if (this.mLipsCosFilter != null) {
            this.mLipsCosFilter.clear();
        }
        if (this.mPhantomFilter != null) {
            this.mPhantomFilter.clearGLSLSelf();
        }
        if (this.mARParticleFilter != null) {
            this.mARParticleFilter.clear();
        }
        if (this.mActFilters != null) {
            this.mActFilters.clear();
        }
        if (this.mEffectFilter != null) {
            this.mEffectFilter.clearGLSLSelf();
        }
        if (this.fabbyExtractFilter != null) {
            this.fabbyExtractFilter.ClearGLSL();
        }
        if (this.fabbyStrokeFilter != null) {
            this.fabbyStrokeFilter.ClearGLSL();
        }
        if (this.fastBlurFilter != null) {
            this.fastBlurFilter.ClearGLSL();
        }
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.clearGLSLSelf();
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.clearGLSLSelf();
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.clearGLSLSelf();
        }
        if (this.fabbyOriginCopyFrame != null) {
            this.fabbyOriginCopyFrame.clear();
        }
        if (this.voiceTextFilter != null) {
            this.voiceTextFilter.clearGLSLSelf();
        }
        this.fastParticleFilter.clearGLSLSelf();
        destroyAudio();
        AppMethodBeat.o(83113);
    }

    public void destroyAudio() {
        AppMethodBeat.i(83114);
        destroyNormalAudio();
        if (this.mARParticleFilter != null) {
            this.mARParticleFilter.destroyAudioPlayer();
        }
        if (this.mActFilters != null) {
            this.mActFilters.destroyAudio();
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.destroyAudio();
        }
        AppMethodBeat.o(83114);
    }

    private void destroyNormalAudio() {
        AppMethodBeat.i(83115);
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                ((NormalVideoFilter) videoFilterBase).destroyAudio();
            }
        }
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.destroyAudio();
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.destroyAudio();
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.destroyAudio();
        }
        AppMethodBeat.o(83115);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(83116);
        init();
        for (VideoFilterBase ApplyGLSLFilter : this.filters) {
            ApplyGLSLFilter.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter2 : this.gestureFilters) {
            ApplyGLSLFilter2.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter22 : this.bodyFilters) {
            ApplyGLSLFilter22.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter222 : this.faceParticleDynamicFilters) {
            ApplyGLSLFilter222.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter2222 : this.faceParticleStaticFilters) {
            ApplyGLSLFilter2222.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter22222 : this.gestureParticleFilters) {
            ApplyGLSLFilter22222.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter222222 : this.bodyParticleFilters) {
            ApplyGLSLFilter222222.ApplyGLSLFilter();
        }
        for (VideoFilterBase ApplyGLSLFilter2222222 : this.headCropItemFilters) {
            ApplyGLSLFilter2222222.ApplyGLSLFilter();
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.ApplyGLSLFilter(this.material.getDataPath());
        }
        if (this.headCropFilter != null) {
            this.headCropFilter.ApplyGLSLFilter();
        }
        if (this.crazyFaceFilters != null) {
            this.crazyFaceFilters.ApplyGLSLFilter();
        }
        if (this.mFacialFeatureFilterList != null) {
            for (FacialFeatureFilter ApplyGLSLFilter3 : this.mFacialFeatureFilterList) {
                ApplyGLSLFilter3.ApplyGLSLFilter();
            }
        }
        if (this.mLipsCosFilter != null) {
            this.mLipsCosFilter.ApplyGLSLFilter();
        }
        if (this.mPhantomFilter != null) {
            this.mPhantomFilter.ApplyGLSLFilter();
        }
        if (this.mEffectFilter != null) {
            this.mEffectFilter.ApplyGLSLFilter();
        }
        if (this.mARParticleFilter != null) {
            this.mARParticleFilter.ApplyGLSLFilter();
        }
        if (this.voiceTextFilter != null) {
            this.voiceTextFilter.ApplyGLSLFilter();
        }
        if (this.mActFilters != null) {
            this.mActFilters.ApplyGLSLFilter();
        }
        if (this.multiViewerFilters != null) {
            for (MultiViewerFilter ApplyGLSLFilter4 : this.multiViewerFilters) {
                ApplyGLSLFilter4.ApplyGLSLFilter();
            }
        }
        if (this.gameFilter != null) {
            this.gameFilter.applyGLSLFilter();
        }
        if (isSegmentRequired()) {
            this.fabbyExtractFilter = new FabbyExtractFilter();
            this.fabbyStrokeFilter = new FabbyStrokeFilter();
            this.fastBlurFilter = new FastBlurFilter();
            this.mMaskFilter = new BaseFilter(VideoFilterFactory.FRAGMENT_SHADER_MASK);
            this.fabbyExtractFilter.ApplyGLSLFilter();
            this.fabbyStrokeFilter.ApplyGLSLFilter();
            this.fastBlurFilter.ApplyGLSLFilter();
            this.mMaskFilter.ApplyGLSLFilter();
        }
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.ApplyGLSLFilter();
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.ApplyGLSLFilter();
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.ApplyGLSLFilter();
        }
        this.mCopyFilter.ApplyGLSLFilter();
        for (int i = 0; i < this.copyFrame.length; i++) {
            this.copyFrame[i] = new h();
        }
        this.fastParticleFilter.applyGLSLFilter();
        AppMethodBeat.o(83116);
    }

    public void setFilters(List<VideoFilterBase> list, List<VideoFilterBase> list2, List<VideoFilterBase> list3) {
        AppMethodBeat.i(83117);
        this.fgStaticStickerFilters = getStickerFilters(list, true, true);
        this.fgDynamicFilters = getStickerFilters(list, false, true);
        this.bgStaticStickerFilters = getStickerFilters(list, true, false);
        this.bgDynamicStickerFilters = getStickerFilters(list, false, false);
        this.filters = new ArrayList();
        this.filters.addAll(list2);
        this.filters.addAll(list3);
        this.filters.addAll(list);
        this.mFaceOffFilters = list2;
        this.mTransformFilters = list3;
        AppMethodBeat.o(83117);
    }

    public void setGestureFilters(List<NormalVideoFilter> list) {
        this.gestureFilters = list;
    }

    public void setGameFilter(GameFilter gameFilter) {
        this.gameFilter = gameFilter;
    }

    private List<VideoFilterBase> getStickerFilters(List<? extends VideoFilterBase> list, boolean z, boolean z2) {
        AppMethodBeat.i(83118);
        List staticStickerFilters = getStaticStickerFilters(list);
        List excludeFilters = getExcludeFilters(list, staticStickerFilters);
        if (z) {
            staticStickerFilters = getZIndexFilters(staticStickerFilters, z2);
            AppMethodBeat.o(83118);
            return staticStickerFilters;
        }
        List<VideoFilterBase> zIndexFilters = getZIndexFilters(excludeFilters, z2);
        AppMethodBeat.o(83118);
        return zIndexFilters;
    }

    private List<VideoFilterBase> getZIndexFilters(List<VideoFilterBase> list, boolean z) {
        AppMethodBeat.i(83119);
        ArrayList arrayList = new ArrayList();
        for (VideoFilterBase videoFilterBase : list) {
            int i = 0;
            if (videoFilterBase instanceof NormalVideoFilter) {
                i = ((NormalVideoFilter) videoFilterBase).getStickerItem().zIndex;
            }
            if (videoFilterBase instanceof VoiceTextFilter) {
                i = ((VoiceTextFilter) videoFilterBase).getZIndex();
            }
            if (z) {
                if (i >= 0) {
                    arrayList.add(videoFilterBase);
                }
            } else if (i < 0) {
                arrayList.add(videoFilterBase);
            }
        }
        AppMethodBeat.o(83119);
        return arrayList;
    }

    public VideoMaterial getMaterial() {
        return this.material;
    }

    public void setMaterial(VideoMaterial videoMaterial) {
        this.material = videoMaterial;
    }

    public void setCurPersonId(int i) {
        this.mCurPersonId = i;
    }

    public void updateCosAlpha(int i) {
        AppMethodBeat.i(83120);
        if (VideoMaterialUtil.isCosMaterial(getMaterial())) {
            for (VideoFilterBase videoFilterBase : this.filters) {
                if (videoFilterBase instanceof FaceOffFilter) {
                    ((FaceOffFilter) videoFilterBase).setCosAlpha(((float) i) / 100.0f);
                }
            }
            if (this.mLipsCosFilter != null) {
                this.mLipsCosFilter.setCosAlpha(((float) i) / 100.0f);
            }
        }
        AppMethodBeat.o(83120);
    }

    public void updateFaceParams(List<List<PointF>> list, List<float[]> list2, List<PointF> list3, int i) {
        AppMethodBeat.i(83121);
        int min = Math.min(list.size(), getMaterial().getMaxFaceCount());
        processMappingFace(list, list2, i);
        if (min <= 0) {
            clearCharmRangeItemStatus();
            clearGenderRangeItemStatus();
            clearPopularRangeItemStatus();
            clearAgeRangeItemStatus();
            clearFaceMappingData();
        }
        if (min < 2) {
            clearCpRangeItemStatus();
        }
        if (!hasHands(list3)) {
            clearHandsRangeItemStatus();
        }
        syncCharmRangeAndHandsRangeValue(hasHands(list3));
        syncRandomGroupValue(hasHands(list3));
        hitHandsRangeItem();
        hitHandRandomGroupItem();
        AppMethodBeat.o(83121);
    }

    private h updateAndRender(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83122);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        List bodyPoints = pTFaceAttr.getBodyPoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        long timeStamp = pTFaceAttr.getTimeStamp();
        GlUtil.setBlendMode(true);
        GLES20.glBindFramebuffer(36160, hVar.bJz[0]);
        GLES20.glViewport(0, 0, hVar.width, hVar.height);
        if (this.mEffectOrder == 1 && this.mEffectFilter != null) {
            this.mEffectFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mEffectFrame);
            hVar = this.mEffectFrame;
        }
        if (VideoMaterialUtil.isFaceSwitchMaterial(getMaterial())) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.copyFrame[0]);
            GLES20.glBindFramebuffer(36160, hVar.bJz[0]);
            GLES20.glViewport(0, 0, hVar.width, hVar.height);
        } else if (getMaterial().getShaderType() == SHADER_TYPE.DOODLE.value) {
            for (VideoFilterBase videoFilterBase : this.filters) {
                if (videoFilterBase instanceof DoodleFilter) {
                    DoodleFilter doodleFilter = (DoodleFilter) videoFilterBase;
                    doodleFilter.setTouchPoints(allFacePoints, this.mTouchPoints, hVar.width, hVar.height, this.mScaleFace);
                    doodleFilter.renderProcess();
                }
            }
        } else if (getMaterial().getShaderType() == SHADER_TYPE.AUDIO3D.value) {
            pTFaceAttr.getRotation();
            if (this.audio3DFilter != null) {
                BenchUtil.benchStart("[showPreview]RenderProcessForAudio3DFilter");
                hVar = RenderProcessForAudio3DFilter(hVar, this.multiViewerOutFrame, this.mFaceList, Math.min(allFacePoints.size(), getMaterial().getMaxFaceCount()), pTFaceAttr, this.mCurPersonId);
                BenchUtil.benchEnd("[showPreview]RenderProcessForAudio3DFilter");
            }
        } else {
            h hVar2;
            PTDetectInfo build;
            int min = Math.min(allFacePoints.size(), getMaterial().getMaxFaceCount());
            List arrayList = bodyPoints.size() == 0 ? new ArrayList() : (List) bodyPoints.get(0);
            if (this.crazyFaceFilters == null || min <= 0) {
                hVar2 = hVar;
            } else {
                float[] fArr = (float[]) allFaceAngles.get(0);
                List list = (List) allFacePoints.get(0);
                if (FaceAverageUtil.isPositiveFace(fArr, list, hVar.width, hVar.height, this.mFaceDetScale)) {
                    hVar2 = this.crazyFaceFilters.updateAndRender(hVar, hVar.width, hVar.height, list, fArr);
                } else {
                    AppMethodBeat.o(83122);
                    return hVar;
                }
            }
            if (min <= 0) {
                setCurPersonId(-1);
                build = new Builder().triggeredExpression(triggeredExpression).timestamp(timeStamp).build();
                updateFilters(build, this.fgDynamicFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.fgDynamicFilters);
                updateFilters(build, this.faceParticleDynamicFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.faceParticleDynamicFilters);
            }
            if (this.fastFaceStickerFilter != null) {
                BenchUtil.benchStart("[showPreview]RenderProcessForFastFaceStickerFilter");
                hVar2 = RenderProcessForFastFaceStickerFilter(hVar2, this.multiViewerOutFrame, this.mFaceList, min, pTFaceAttr, this.mCurPersonId);
                BenchUtil.benchEnd("[showPreview]RenderProcessForFastFaceStickerFilter");
            }
            h hVar3 = hVar2;
            for (int i = 0; i < min; i++) {
                Face face = (Face) this.mFaceList.get(i);
                setCurPersonId(face.faceIndex);
                hitCharmRangeItem(face.faceIndex);
                hitFaceRandomGroupItem(face.faceIndex);
                hitAgeRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
                hitGenderRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
                hitPopularRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
                hitCpRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex, min);
                BenchUtil.benchStart("[showPreview]RenderProcess");
                build = new Builder().facePoints(face.facePoints).faceAngles(face.faceAngles).faceActionCounter(pTFaceAttr.getFaceActionCounter()).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build();
                updateFilters(build, this.fgDynamicFilters);
                hVar2 = RenderProcessForFilters(hVar3, this.multiViewerOutFrame, this.fgDynamicFilters);
                updateFilters(build, this.faceParticleDynamicFilters);
                hVar3 = RenderProcessForFilters(hVar2, this.multiViewerOutFrame, this.faceParticleDynamicFilters);
                BenchUtil.benchEnd("[showPreview]RenderProcess");
            }
            if (this.mPhantomFilter != null) {
                GlUtil.setBlendMode(false);
                this.mPhantomFilter.updatePreview(pTFaceAttr.getTimeStamp());
                this.mPhantomFilter.RenderProcess(hVar3.texture[0], hVar3.width, hVar3.height, -1, 0.0d, this.mPhantomFrame);
                h hVar4 = this.mPhantomFrame;
                GlUtil.setBlendMode(true);
                hVar2 = hVar4;
            } else {
                hVar2 = hVar3;
            }
            build = new Builder().handPoints(pTFaceAttr.getHandPoints()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).faceAngles(allFaceAngles.size() > 0 ? (float[]) allFaceAngles.get(0) : null).build();
            if (isHandPointsValid(pTFaceAttr.getHandPoints())) {
                updateFilters(build, this.gestureFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.gestureFilters);
                updateFilters(build, this.gestureParticleFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.gestureParticleFilters);
            }
            build = new Builder().triggeredExpression(triggeredExpression).bodyPoints(arrayList).timestamp(timeStamp).build();
            if (this.fastBodyStickerFilter != null) {
                BenchUtil.benchStart("[showPreview]RenderProcessForFastBodyStickerFilter");
                hVar2 = RenderProcessForFastBodyStickerFilter(hVar2, null, build);
                BenchUtil.benchEnd("[showPreview]RenderProcessForFastBodyStickerFilter");
            }
            updateFilters(build, this.bodyFilters);
            hVar2 = RenderProcessForFilters(hVar2, this.bodyFilters);
            updateFilters(build, this.bodyParticleFilters);
            hVar = RenderProcessForFastParticleFilter(hVar2, this.bodyParticleFilters);
        }
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(83122);
        return hVar;
    }

    public h processTransformRelatedFilters(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83123);
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long timeStamp = pTFaceAttr.getTimeStamp();
        int min = Math.min(this.mFaceList.size(), getMaterial().getMaxFaceCount());
        GlUtil.setBlendMode(true);
        if (min <= 0) {
            PTDetectInfo build = new Builder().triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build();
            updateFilters(build, this.mFaceOffFilters);
            updateFilters(build, this.mTransformFilters);
        }
        h hVar2 = hVar;
        for (int i = 0; i < min; i++) {
            Face face = (Face) this.mFaceList.get(i);
            setCurPersonId(face.faceIndex);
            hitCharmRangeItem(face.faceIndex);
            hitFaceRandomGroupItem(face.faceIndex);
            hitAgeRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
            hitGenderRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
            hitPopularRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex);
            hitCpRangeItem(pTFaceAttr.getFaceDetector(), face.faceIndex, min);
            if (this.mCurPersonId <= 1 && this.mLipsCosFilter != null && (getMaterial().getLipsLutPath() == null || FeatureManager.isLutLipsReady())) {
                this.mLipsCosFilter.updateAndRender(hVar2, hVar2.width, hVar2.height, face.facePoints, face.faceAngles, null);
            }
            PTDetectInfo build2 = new Builder().facePoints(face.facePoints).faceAngles(face.faceAngles).faceActionCounter(pTFaceAttr.getFaceActionCounter()).triggeredExpression(triggeredExpression).phoneAngle((float) pTFaceAttr.getRotation()).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build();
            if (this.mFaceOffFilters != null) {
                updateFilters(build2, this.mFaceOffFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.multiViewerOutFrame, this.mFaceOffFilters);
            }
            if (this.mFacialFeatureFilterList != null) {
                GlUtil.setBlendMode(false);
                for (FacialFeatureFilter updateStickerFilterList : this.mFacialFeatureFilterList) {
                    updateStickerFilterList.updateStickerFilterList(face.facePoints, face.faceAngles, hVar2);
                }
                GlUtil.setBlendMode(true);
            }
            if (this.mTransformFilters != null) {
                updateFilters(build2, this.mTransformFilters);
                hVar2 = RenderProcessForFilters(hVar2, this.multiViewerOutFrame, this.mTransformFilters);
            }
            if (this.mFacialFeatureFilterList != null) {
                for (FacialFeatureFilter updateStickerFilterList2 : this.mFacialFeatureFilterList) {
                    updateFilters(build2, updateStickerFilterList2.getStickerFilters());
                    hVar2 = RenderProcessForFilters(hVar2, updateStickerFilterList2.getStickerFilters());
                }
            }
        }
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(83123);
        return hVar2;
    }

    private void processMappingFace(List<List<PointF>> list, List<float[]> list2, int i) {
        int i2 = 0;
        AppMethodBeat.i(83124);
        int i3;
        Face face;
        if (this.mFaceList.isEmpty()) {
            while (true) {
                i3 = i2;
                if (i3 < list.size()) {
                    face = new Face();
                    face.facePoints = (List) list.get(i3);
                    face.faceAngles = (float[]) list2.get(i3);
                    face.faceIndex = i3;
                    this.mFaceList.add(face);
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(83124);
                    return;
                }
            }
        } else if (this.gameFilter == null) {
            mappingFace(this.mFaceList, list, list2, i);
            Collections.sort(this.mFaceList, this.mFaceIndexComperator);
            AppMethodBeat.o(83124);
        } else {
            this.mFaceList.clear();
            while (true) {
                i3 = i2;
                if (i3 < list.size()) {
                    face = new Face();
                    face.facePoints = (List) list.get(i3);
                    face.faceAngles = (float[]) list2.get(i3);
                    face.faceIndex = i3;
                    this.mFaceList.add(face);
                    i2 = i3 + 1;
                } else {
                    AppMethodBeat.o(83124);
                    return;
                }
            }
        }
    }

    public h updateAndRenderHeadCropItemFilters(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83125);
        int rotation = (pTFaceAttr.getRotation() + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if ((rotation == 90 || rotation == 270) && !this.material.isSupportLandscape()) {
            AppMethodBeat.o(83125);
            return hVar;
        }
        h RenderProcessForFilters;
        GlUtil.setBlendMode(true);
        if (this.headCropFilter != null) {
            this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mHeadCropFrame);
            this.headCropFilter.setInputFrame(this.mHeadCropFrame);
            hVar.a(-1, hVar.width, hVar.height, 0.0d);
        }
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long timeStamp = pTFaceAttr.getTimeStamp();
        if (allFacePoints.size() <= 0) {
            updateFilters(new Builder().faceActionCounter(faceActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
            RenderProcessForFilters = RenderProcessForFilters(hVar, this.headCropItemFilters);
        } else {
            updateFilters(new Builder().facePoints((List) allFacePoints.get(0)).faceAngles((float[]) allFaceAngles.get(0)).faceActionCounter(faceActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build(), this.headCropItemFilters);
            RenderProcessForFilters = RenderProcessForFilters(hVar, this.headCropItemFilters);
        }
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(83125);
        return RenderProcessForFilters;
    }

    public h updateAndRenderStaticStickers(h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83126);
        int rotation = (pTFaceAttr.getRotation() + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if ((rotation == 90 || rotation == 270) && !this.material.isSupportLandscape()) {
            AppMethodBeat.o(83126);
            return hVar;
        }
        h RenderProcessForFilters;
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        long timeStamp = pTFaceAttr.getTimeStamp();
        GlUtil.setBlendMode(true);
        PTDetectInfo build;
        h RenderProcessForFilters2;
        if (allFacePoints.size() <= 0) {
            build = new Builder().faceActionCounter(faceActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build();
            updateFilters(build, this.fgStaticStickerFilters);
            RenderProcessForFilters2 = RenderProcessForFilters(hVar, this.fgStaticStickerFilters);
            updateFilters(build, this.faceParticleStaticFilters);
            RenderProcessForFilters = RenderProcessForFilters(RenderProcessForFilters2, this.faceParticleStaticFilters);
        } else {
            build = new Builder().facePoints((List) allFacePoints.get(0)).faceAngles((float[]) allFaceAngles.get(0)).faceActionCounter(faceActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).handActionCounter(GestureDetector.getInstance().getHandActionCounter()).build();
            updateFilters(build, this.fgStaticStickerFilters);
            RenderProcessForFilters2 = RenderProcessForFilters(hVar, this.fgStaticStickerFilters);
            updateFilters(build, this.faceParticleStaticFilters);
            RenderProcessForFilters = RenderProcessForFilters(RenderProcessForFilters2, this.faceParticleStaticFilters);
        }
        GlUtil.setBlendMode(false);
        if (this.mEffectOrder == 2 && this.mEffectFilter != null) {
            this.mEffectFilter.RenderProcess(RenderProcessForFilters.texture[0], RenderProcessForFilters.width, RenderProcessForFilters.height, -1, 0.0d, this.mEffectFrame);
            RenderProcessForFilters = this.mEffectFrame;
        }
        AppMethodBeat.o(83126);
        return RenderProcessForFilters;
    }

    public h updateAndRenderBgFilters(h hVar, PTFaceAttr pTFaceAttr) {
        h RenderProcessForFilters;
        AppMethodBeat.i(83127);
        List allFacePoints = pTFaceAttr.getAllFacePoints();
        List allFaceAngles = pTFaceAttr.getAllFaceAngles();
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        List handPoints = pTFaceAttr.getHandPoints();
        Map handActionCounter = GestureDetector.getInstance().getHandActionCounter();
        Set triggeredExpression = pTFaceAttr.getTriggeredExpression();
        long timeStamp = pTFaceAttr.getTimeStamp();
        this.mBgFrame.a(-1, hVar.width, hVar.height, 0.0d);
        FrameUtil.clearFrame(this.mBgFrame, 0.0f, 0.0f, 0.0f, 0.0f, hVar.width, hVar.height);
        h hVar2 = this.mBgFrame;
        GlUtil.setBlendMode(true);
        int min = Math.min(allFacePoints.size(), getMaterial().getMaxFaceCount());
        for (int i = 0; i < min; i++) {
            BenchUtil.benchStart("[showPreview]updateAllFilters");
            updateFilters(new Builder().facePoints((List) allFacePoints.get(i)).faceAngles((float[]) allFaceAngles.get(i)).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(handActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build(), this.bgDynamicStickerFilters);
            BenchUtil.benchEnd("[showPreview]updateAllFilters");
            BenchUtil.benchStart("[showPreview]RenderProcess");
            hVar2 = RenderProcessForFilters(hVar2, this.bgDynamicStickerFilters);
            BenchUtil.benchEnd("[showPreview]RenderProcess");
        }
        if (allFacePoints.size() <= 0) {
            updateFilters(new Builder().faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(handActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build(), this.bgStaticStickerFilters);
            RenderProcessForFilters = RenderProcessForFilters(hVar2, this.bgStaticStickerFilters);
        } else {
            updateFilters(new Builder().facePoints((List) allFacePoints.get(0)).faceAngles((float[]) allFaceAngles.get(0)).faceActionCounter(faceActionCounter).handPoints(handPoints).handActionCounter(handActionCounter).triggeredExpression(triggeredExpression).timestamp(timeStamp).faceDetector(pTFaceAttr.getFaceDetector()).build(), this.bgStaticStickerFilters);
            RenderProcessForFilters = RenderProcessForFilters(hVar2, this.bgStaticStickerFilters);
        }
        this.mMaskFilter.OnDrawFrameGLSL();
        this.mMaskFilter.renderTexture(hVar.texture[0], hVar.width, hVar.height);
        GlUtil.setBlendMode(false);
        AppMethodBeat.o(83127);
        return RenderProcessForFilters;
    }

    private List<VideoFilterBase> getStaticStickerFilters(List<? extends VideoFilterBase> list) {
        AppMethodBeat.i(83128);
        ArrayList arrayList = new ArrayList();
        for (VideoFilterBase videoFilterBase : list) {
            if ((videoFilterBase instanceof StaticStickerFilter) || (videoFilterBase instanceof StaticNumFilter) || ((videoFilterBase instanceof ParticleFilter) && ((ParticleFilter) videoFilterBase).isStatic())) {
                arrayList.add(videoFilterBase);
            }
        }
        AppMethodBeat.o(83128);
        return arrayList;
    }

    private List<VideoFilterBase> getExcludeFilters(List<? extends VideoFilterBase> list, List<VideoFilterBase> list2) {
        AppMethodBeat.i(83129);
        ArrayList arrayList = new ArrayList();
        for (VideoFilterBase videoFilterBase : list) {
            if (!list2.contains(videoFilterBase)) {
                arrayList.add(videoFilterBase);
            }
        }
        AppMethodBeat.o(83129);
        return arrayList;
    }

    public h updateAndRenderActMaterial(h hVar, List<List<PointF>> list, List<float[]> list2, int i, long j) {
        AppMethodBeat.i(83130);
        if (this.mActFilters != null) {
            GlUtil.setBlendMode(true);
            hVar = this.mActFilters.updateAndRender(hVar, j, list, list2, i);
            GlUtil.setBlendMode(false);
        }
        AppMethodBeat.o(83130);
        return hVar;
    }

    public void updateAndRenderMultiViewerMaterial(Map<Integer, h> map, h hVar, PTFaceAttr pTFaceAttr) {
        AppMethodBeat.i(83131);
        Map faceActionCounter = pTFaceAttr.getFaceActionCounter();
        map.clear();
        if (this.multiViewerFilters != null) {
            FabbyFaceActionCounter fabbyFaceActionCounter = (FabbyFaceActionCounter) faceActionCounter.get(Integer.valueOf(PTExpression.MV_PART_INDEX.value));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.multiViewerFilters.size()) {
                    break;
                }
                MultiViewerFilter multiViewerFilter = (MultiViewerFilter) this.multiViewerFilters.get(i2);
                if (multiViewerFilter.needRenderThisPart(fabbyFaceActionCounter.count)) {
                    PointF pointF;
                    int renderId = multiViewerFilter.getRenderId();
                    if (fabbyFaceActionCounter.scaleMap.get(Integer.valueOf(renderId)) != null) {
                        pointF = (PointF) fabbyFaceActionCounter.scaleMap.get(Integer.valueOf(renderId));
                    } else {
                        pointF = new PointF(1.0f, 1.0f);
                    }
                    float max = Math.max(pointF.x, pointF.y);
                    int i3 = (int) (((float) hVar.width) * max);
                    int i4 = (int) (((float) hVar.height) * max);
                    multiViewerFilter.updateVideoSize(i3, i4, this.mFaceDetScale / ((double) max));
                    if (!this.multiViewerFrameMap.containsKey(Integer.valueOf(renderId))) {
                        this.multiViewerFrameMap.put(Integer.valueOf(renderId), new h());
                    }
                    h hVar2 = (h) this.multiViewerFrameMap.get(Integer.valueOf(renderId));
                    hVar2.a(-1, i3, i4, 0.0d);
                    BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - clearFrame");
                    FrameUtil.clearFrame(hVar2, 0.0f, 0.0f, 0.0f, 0.0f, hVar2.width, hVar2.height);
                    BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - clearFrame");
                    BenchUtil.benchStart("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
                    hVar2 = multiViewerFilter.render(hVar, hVar2, pTFaceAttr);
                    BenchUtil.benchEnd("updateAndRenderMultiViewerMaterial - multiViewerFilter.render");
                    map.put(Integer.valueOf(renderId), hVar2);
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(83131);
    }

    public void setIsRenderForBitmap(boolean z) {
        AppMethodBeat.i(83132);
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                ((NormalVideoFilter) videoFilterBase).setRenderForBitmap(z);
            } else if (videoFilterBase instanceof FaceOffFilter) {
                ((FaceOffFilter) videoFilterBase).setRenderForBitmap(z);
            } else if (videoFilterBase instanceof TransformFilter) {
                ((TransformFilter) videoFilterBase).setRenderForBitmap(z);
            }
        }
        AppMethodBeat.o(83132);
    }

    public Bitmap renderForBitmap(int i, int i2, int i3) {
        AppMethodBeat.i(83133);
        Bitmap aK;
        if (this.filters == null) {
            aK = g.aK(i, i2, i3);
            AppMethodBeat.o(83133);
            return aK;
        }
        GlUtil.setBlendMode(true);
        h hVar = new h();
        this.mCopyFilter.RenderProcess(i, i2, i3, -1, 0.0d, hVar);
        GLES20.glViewport(0, 0, i2, i3);
        h hVar2 = hVar;
        for (int i4 = 0; i4 < this.filters.size(); i4++) {
            VideoFilterBase videoFilterBase = (VideoFilterBase) this.filters.get(i4);
            if (VideoFilterUtil.canUseBlendMode(videoFilterBase)) {
                videoFilterBase.OnDrawFrameGLSL();
                videoFilterBase.renderTexture(hVar2.texture[0], i2, i3);
            } else {
                if (VideoFilterUtil.needCopy(videoFilterBase)) {
                    hVar2 = FrameUtil.renderProcessBySwitchFbo(hVar2.texture[0], i2, i3, this.mCopyFilter, hVar, this.copyFrame[0]);
                }
                hVar2 = VideoFrameUtil.renderProcessBySwitchFbo(hVar2.texture[0], i2, i3, videoFilterBase, hVar, this.copyFrame[0]);
            }
        }
        GlUtil.setBlendMode(false);
        aK = g.aK(hVar2.texture[0], i2, i3);
        hVar2.clear();
        AppMethodBeat.o(83133);
        return aK;
    }

    private void mappingFace(List<Face> list, List<List<PointF>> list2, List<float[]> list3, int i) {
        int i2;
        int i3;
        AppMethodBeat.i(83134);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= list2.size()) {
                break;
            }
            List list4 = (List) list2.get(i5);
            float[] fArr = (float[]) list3.get(i5);
            PointF pointF = (PointF) list4.get(64);
            int i6 = -1;
            double d = ((double) i) * 0.1d;
            i2 = 0;
            while (true) {
                int i7 = i2;
                if (i7 >= list.size()) {
                    break;
                }
                if (!hashSet.contains(Integer.valueOf(i7))) {
                    double distance = (double) AlgoUtils.getDistance(pointF, (PointF) ((Face) list.get(i7)).facePoints.get(64));
                    if (distance < d) {
                        d = distance;
                        i6 = i7;
                    }
                }
                i2 = i7 + 1;
            }
            if (i6 != -1) {
                hashSet.add(Integer.valueOf(i6));
                hashSet2.add(Integer.valueOf(i5));
                ((Face) list.get(i6)).facePoints = list4;
                ((Face) list.get(i6)).faceAngles = fArr;
            }
            i4 = i5 + 1;
        }
        HashSet<Integer> hashSet3 = new HashSet();
        ArrayList arrayList = new ArrayList();
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 >= list.size()) {
                break;
            }
            hashSet3.add(Integer.valueOf(((Face) list.get(i3)).faceIndex));
            if (hashSet.contains(Integer.valueOf(i3))) {
                arrayList.add(list.get(i3));
            }
            i4 = i3 + 1;
        }
        List newFaceIndexList = getNewFaceIndexList(list2.size() - hashSet2.size(), hashSet, list);
        int i8 = 0;
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i8 >= list2.size()) {
                break;
            }
            if (hashSet2.contains(Integer.valueOf(i8))) {
                i4 = i3;
            } else {
                Face face = new Face();
                face.facePoints = (List) list2.get(i8);
                face.faceAngles = (float[]) list3.get(i8);
                i2 = i3 + 1;
                face.faceIndex = ((Integer) newFaceIndexList.get(i3)).intValue();
                this.mCharmValueMap.remove(Integer.valueOf(face.faceIndex));
                arrayList.add(face);
                i4 = i2;
            }
            i8++;
        }
        HashSet hashSet4 = new HashSet();
        i4 = 0;
        while (true) {
            i3 = i4;
            if (i3 >= arrayList.size()) {
                break;
            }
            hashSet4.add(Integer.valueOf(((Face) arrayList.get(i3)).faceIndex));
            i4 = i3 + 1;
        }
        for (Integer num : hashSet3) {
            if (!hashSet4.contains(num)) {
                removeValueRangeForFace(num.intValue());
            }
        }
        list.clear();
        list.addAll(arrayList);
        AppMethodBeat.o(83134);
    }

    private List<Integer> getNewFaceIndexList(int i, Set<Integer> set, List<Face> list) {
        AppMethodBeat.i(83135);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Integer intValue : set) {
            hashSet.add(Integer.valueOf(((Face) list.get(intValue.intValue())).faceIndex));
        }
        int i2 = 0;
        while (arrayList.size() < i) {
            if (!hashSet.contains(Integer.valueOf(i2))) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        AppMethodBeat.o(83135);
        return arrayList;
    }

    public void addTouchPoint(PointF pointF, float f, boolean z) {
        AppMethodBeat.i(83136);
        if (pointF == null) {
            AppMethodBeat.o(83136);
            return;
        }
        if (z || this.mTouchPoints.size() == 0) {
            this.mTouchPoints.add(new ArrayList());
        }
        ((List) this.mTouchPoints.get(this.mTouchPoints.size() - 1)).add(pointF);
        this.mScaleFace = f;
        AppMethodBeat.o(83136);
    }

    private boolean needRender(VideoFilterBase videoFilterBase) {
        AppMethodBeat.i(83137);
        if (videoFilterBase instanceof NormalVideoFilter) {
            StickerItem stickerItem = ((NormalVideoFilter) videoFilterBase).getStickerItem();
            if (stickerItem == null || !((NormalVideoFilter) videoFilterBase).isRenderReady()) {
                AppMethodBeat.o(83137);
                return false;
            } else if (this.mCurPersonId == -1) {
                AppMethodBeat.o(83137);
                return true;
            } else if (!(stickerItem.personID == -1 || stickerItem.personID == this.mCurPersonId)) {
                AppMethodBeat.o(83137);
                return false;
            }
        }
        if (videoFilterBase instanceof FaceOffFilter) {
            FaceOffFilter faceOffFilter = (FaceOffFilter) videoFilterBase;
            FaceItem faceOffItem = faceOffFilter.getFaceOffItem();
            if (faceOffItem == null || !faceOffFilter.isRenderReady()) {
                AppMethodBeat.o(83137);
                return false;
            } else if (this.mCurPersonId == -1) {
                AppMethodBeat.o(83137);
                return true;
            } else if (!(faceOffItem.personID == -1 || faceOffItem.personID == this.mCurPersonId)) {
                AppMethodBeat.o(83137);
                return false;
            }
        }
        if (videoFilterBase instanceof TransformFilter) {
            FaceMeshItem faceMeshItem = ((TransformFilter) videoFilterBase).getFaceMeshItem();
            if (!(faceMeshItem == null || ((faceMeshItem.personID == -1 || this.mCurPersonId == -1 || faceMeshItem.personID == this.mCurPersonId) && (this.mCurPersonId == -1 || faceMeshItem.charmRange == null || faceMeshItem.charmRange.isHit())))) {
                AppMethodBeat.o(83137);
                return false;
            }
        }
        if (videoFilterBase instanceof FaceCropFilter) {
            boolean isNeedRender = ((FaceCropFilter) videoFilterBase).isNeedRender();
            AppMethodBeat.o(83137);
            return isNeedRender;
        }
        AppMethodBeat.o(83137);
        return true;
    }

    public void setMultiViewerSrcTexture(int i) {
        this.multiViewerSrcTexture = i;
    }

    public void setMultiViewerOutFrame(h hVar) {
        this.multiViewerOutFrame = hVar;
    }

    public void setVideoEffectFilter(VideoFilterBase videoFilterBase) {
        this.mEffectFilter = videoFilterBase;
    }

    public void setVideoEffectOrder(int i) {
        this.mEffectOrder = i;
    }

    public int getVideoEffectOrder() {
        return this.mEffectOrder;
    }

    public void setCrazyFaceFilters(CrazyFaceFilters crazyFaceFilters) {
        this.crazyFaceFilters = crazyFaceFilters;
    }

    public void setLipsCosFilter(LipsCosFilter lipsCosFilter) {
        this.mLipsCosFilter = lipsCosFilter;
    }

    public void setPhantomFilter(PhantomFilter phantomFilter) {
        this.mPhantomFilter = phantomFilter;
    }

    public void setARParticleFilter(ARParticleFilter aRParticleFilter) {
        this.mARParticleFilter = aRParticleFilter;
    }

    public void setVoiceTextFilter(VoiceTextFilter voiceTextFilter) {
        this.voiceTextFilter = voiceTextFilter;
    }

    public void setActFilter(ActFilters actFilters) {
        this.mActFilters = actFilters;
    }

    public void setFastFaceStickerFilter(FastStickerFilter fastStickerFilter) {
        this.fastFaceStickerFilter = fastStickerFilter;
    }

    public void setAudio3DFilter(Audio3DFilter audio3DFilter) {
        this.audio3DFilter = audio3DFilter;
    }

    public void setFastBodyStickerFilter(FastStickerFilter fastStickerFilter) {
        this.fastBodyStickerFilter = fastStickerFilter;
    }

    public void setMultiViewerFilters(List<MultiViewerFilter> list) {
        this.multiViewerFilters = list;
    }

    public void setFacialFeatureFilterList(List<FacialFeatureFilter> list) {
        this.mFacialFeatureFilterList = list;
    }

    public CrazyFaceFilters getCrazyFaceFilters() {
        return this.crazyFaceFilters;
    }

    public void setImageData(byte[] bArr) {
        AppMethodBeat.i(83138);
        if (this.crazyFaceFilters != null) {
            this.crazyFaceFilters.setImageData(bArr);
        }
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof FaceOffFilter) {
                ((FaceOffFilter) videoFilterBase).setImageData(bArr);
            }
        }
        AppMethodBeat.o(83138);
    }

    public void addTouchPoint(PointF pointF) {
        AppMethodBeat.i(83139);
        this.mARTouchPointQueue.offer(pointF);
        AppMethodBeat.o(83139);
    }

    public void renderARFilterIfNeeded(h hVar) {
        AppMethodBeat.i(83140);
        if (this.mARParticleFilter != null) {
            GlUtil.setBlendMode(true);
            hVar.a(-1, hVar.width, hVar.height, 0.0d);
            while (!this.mARTouchPointQueue.isEmpty()) {
                PointF pointF = (PointF) this.mARTouchPointQueue.poll();
                if (pointF != null) {
                    this.mARParticleFilter.addTouchPoint(pointF);
                }
            }
            this.mARParticleFilter.updateAndRender(hVar);
            GlUtil.setBlendMode(false);
        }
        AppMethodBeat.o(83140);
    }

    public h updateAndRender3DFilter(h hVar, PTFaceAttr pTFaceAttr, int i) {
        AppMethodBeat.i(83141);
        if (!(this.gameFilter == null || getMaterial().getShaderType() == SHADER_TYPE.AUDIO3D.value)) {
            this.gameFilter.updateVideoSize(hVar.width, hVar.height, i);
            hVar = this.gameFilter.updateAndRender(hVar, pTFaceAttr);
        }
        AppMethodBeat.o(83141);
        return hVar;
    }

    public void onResume() {
        AppMethodBeat.i(83142);
        if (this.mActFilters != null) {
            this.mActFilters.reset(System.currentTimeMillis());
        }
        AppMethodBeat.o(83142);
    }

    public void onPause() {
        AppMethodBeat.i(83143);
        destroyAudio();
        AppMethodBeat.o(83143);
    }

    public void setHeadCropItemFilters(List<NormalVideoFilter> list) {
        this.headCropItemFilters = list;
    }

    public void setHeadCropFilter(HeadCropFilter headCropFilter) {
        this.headCropFilter = headCropFilter;
    }

    public boolean needFaceInfo(int i) {
        AppMethodBeat.i(83144);
        int i2 = (i + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if ((i2 == 90 || i2 == 270) && !this.material.isSupportLandscape()) {
            AppMethodBeat.o(83144);
            return false;
        }
        AppMethodBeat.o(83144);
        return true;
    }

    public void setNeedDetectGesture(boolean z) {
        this.needDetectGesture = z;
    }

    public boolean needDetectGesture() {
        return this.needDetectGesture;
    }

    public void setRenderMode(int i) {
        AppMethodBeat.i(83145);
        VideoFilterUtil.setRenderMode(this.filters, i);
        VideoFilterUtil.setRenderMode(this.headCropItemFilters, i);
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.setRenderMode(i);
        }
        this.mCopyFilter.setRenderMode(i);
        if (this.headCropFilter != null) {
            this.headCropFilter.setRenderMode(i);
        }
        if (this.crazyFaceFilters != null) {
            this.crazyFaceFilters.setRenderMode(i);
        }
        if (this.mFacialFeatureFilterList != null) {
            for (FacialFeatureFilter renderMode : this.mFacialFeatureFilterList) {
                renderMode.setRenderMode(i);
            }
        }
        if (this.mLipsCosFilter != null) {
            this.mLipsCosFilter.setRenderMode(i);
        }
        if (this.mARParticleFilter != null) {
            this.mARParticleFilter.setRenderMode(i);
        }
        if (this.mActFilters != null) {
            this.mActFilters.setRenderMode(i);
        }
        if (this.fabbyExtractFilter != null) {
            this.fabbyExtractFilter.setRenderMode(i);
        }
        if (this.fabbyStrokeFilter != null) {
            this.fabbyStrokeFilter.setRenderMode(i);
        }
        if (this.fastBlurFilter != null) {
            this.fastBlurFilter.setRenderMode(i);
        }
        AppMethodBeat.o(83145);
    }

    public h updateAndRenderFabbyMV(h hVar, Map<Integer, h> map, Map<Integer, FaceActionCounter> map2, Set<Integer> set, long j) {
        AppMethodBeat.i(83146);
        h updateAndRender;
        if (this.fabbyMvFilters != null) {
            h hVar2;
            if (map != null && map.containsKey(Integer.valueOf(0)) && hVar.texture[0] == ((h) map.get(Integer.valueOf(0))).texture[0]) {
                this.mCopyFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.fabbyOriginCopyFrame);
                hVar2 = this.fabbyOriginCopyFrame;
            } else {
                hVar2 = hVar;
            }
            updateAndRender = this.fabbyMvFilters.updateAndRender(hVar2, map, map2, set, j);
            AppMethodBeat.o(83146);
            return updateAndRender;
        }
        updateAndRender = (h) map.values().iterator().next();
        AppMethodBeat.o(83146);
        return updateAndRender;
    }

    public h doFabbyStroke(h hVar, h hVar2) {
        AppMethodBeat.i(83147);
        BenchUtil.benchStart("[showPreview][FABBY] doFabbyStroke");
        if (this.material.getSegmentStrokeWidth() > 0.0d) {
            this.fabbyStrokeFilter.setmMaskTex(hVar2.texture[0]);
            this.fabbyStrokeFilter.setStepX(1.0f / ((float) hVar.width));
            this.fabbyStrokeFilter.setStepY(1.0f / ((float) hVar.height));
            this.fabbyStrokeFilter.setStrokeGapInPixel(((float) this.material.getSegmentStrokeGap()) * ((float) Math.min(hVar.width, hVar.height)));
            this.fabbyStrokeFilter.setStrokeWidthInPixel(((float) this.material.getSegmentStrokeWidth()) * ((float) Math.min(hVar.width, hVar.height)));
            this.fabbyStrokeFilter.setStrokeColor(this.material.getSegmentStrokeColor());
            this.fabbyStrokeFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.fabbyStrokeFrame);
        } else if (this.material.getSegmentFeather() > 0) {
            int i = hVar.width / 2;
            int i2 = hVar.height / 2;
            this.fastBlurFilter.updateParams(1.2f / ((float) i), 0.0f);
            this.fastBlurFilter.RenderProcess(hVar2.texture[0], i, i2, -1, 0.0d, this.fabbyFeatheredMaskStep1);
            this.fastBlurFilter.updateParams(0.0f, 1.2f / ((float) i2));
            this.fastBlurFilter.RenderProcess(this.fabbyFeatheredMaskStep1.texture[0], hVar.width, hVar.height, -1, 0.0d, this.fabbyFeatheredMaskStep2);
            this.fabbyExtractFilter.setTex(this.fabbyFeatheredMaskStep2.texture[0]);
            this.fabbyExtractFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.fabbyStrokeFrame);
        } else {
            this.fabbyExtractFilter.setTex(hVar2.texture[0]);
            this.fabbyExtractFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.fabbyStrokeFrame);
        }
        BenchUtil.benchEnd("[showPreview][FABBY] doFabbyStroke");
        h hVar3 = this.fabbyStrokeFrame;
        AppMethodBeat.o(83147);
        return hVar3;
    }

    public void setFabbyMvFilters(FabbyFilters fabbyFilters) {
        this.fabbyMvFilters = fabbyFilters;
    }

    public boolean isSegmentRequired() {
        AppMethodBeat.i(83148);
        if (this.material == null) {
            AppMethodBeat.o(83148);
            return false;
        }
        boolean isSegmentRequired = this.material.isSegmentRequired();
        AppMethodBeat.o(83148);
        return isSegmentRequired;
    }

    public boolean isSupportPause() {
        AppMethodBeat.i(83149);
        if (this.material == null) {
            AppMethodBeat.o(83149);
            return false;
        }
        boolean isSupportPause = this.material.isSupportPause();
        AppMethodBeat.o(83149);
        return isSupportPause;
    }

    public boolean hasVoiceTextFilter() {
        AppMethodBeat.i(83150);
        if (this.filters != null) {
            for (VideoFilterBase videoFilterBase : this.filters) {
                if (videoFilterBase instanceof VoiceTextFilter) {
                    AppMethodBeat.o(83150);
                    return true;
                }
            }
        }
        AppMethodBeat.o(83150);
        return false;
    }

    public boolean hasParticleFilter() {
        AppMethodBeat.i(83151);
        if (this.filters != null) {
            for (VideoFilterBase videoFilterBase : this.filters) {
                if (videoFilterBase instanceof ParticleFilter) {
                    AppMethodBeat.o(83151);
                    return true;
                }
            }
        }
        AppMethodBeat.o(83151);
        return false;
    }

    public void setRatioMode(RATIO_MODE ratio_mode) {
        AppMethodBeat.i(83152);
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof StaticStickerFilter) {
                ((StaticStickerFilter) videoFilterBase).setRatioMode(ratio_mode);
            }
        }
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.setRatioMode(ratio_mode);
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.setRatioMode(ratio_mode);
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.setRatioMode(ratio_mode);
        }
        if (this.multiViewerFilters != null) {
            for (MultiViewerFilter ratioMode : this.multiViewerFilters) {
                ratioMode.setRatioMode(ratio_mode);
            }
        }
        AppMethodBeat.o(83152);
    }

    public boolean render3DFirst() {
        AppMethodBeat.i(83153);
        if (this.gameFilter == null || this.gameFilter.getOrderMode() != 2) {
            AppMethodBeat.o(83153);
            return false;
        }
        AppMethodBeat.o(83153);
        return true;
    }

    public void setTriggerWords(String str) {
        AppMethodBeat.i(83154);
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                ((NormalVideoFilter) videoFilterBase).setTriggerWords(str);
            } else if (videoFilterBase instanceof FaceOffFilter) {
                ((FaceOffFilter) videoFilterBase).setTriggerWords(str);
            } else if (videoFilterBase instanceof TransformFilter) {
                ((TransformFilter) videoFilterBase).setTriggerWords(str);
            } else if (videoFilterBase instanceof VoiceTextFilter) {
                ((VoiceTextFilter) videoFilterBase).setTriggerWords(str);
            }
        }
        AppMethodBeat.o(83154);
    }

    public void reset() {
        AppMethodBeat.i(83155);
        if (this.material.isResetWhenStartRecord()) {
            for (VideoFilterBase videoFilterBase : this.filters) {
                if (videoFilterBase instanceof NormalVideoFilter) {
                    ((NormalVideoFilter) videoFilterBase).reset();
                }
                if (videoFilterBase instanceof FaceOffFilter) {
                    ((FaceOffFilter) videoFilterBase).reset();
                }
                if (videoFilterBase instanceof TransformFilter) {
                    ((TransformFilter) videoFilterBase).reset();
                }
            }
            for (NormalVideoFilter reset : this.gestureFilters) {
                reset.reset();
            }
            for (NormalVideoFilter reset2 : this.bodyFilters) {
                reset2.reset();
            }
            for (NormalVideoFilter reset22 : this.headCropItemFilters) {
                reset22.reset();
            }
            if (this.fabbyMvFilters != null) {
                this.fabbyMvFilters.reset();
            }
            if (this.mFacialFeatureFilterList != null) {
                for (FacialFeatureFilter reset3 : this.mFacialFeatureFilterList) {
                    reset3.reset();
                }
            }
            if (this.fastFaceStickerFilter != null) {
                this.fastFaceStickerFilter.reset();
            }
            if (this.fastBodyStickerFilter != null) {
                this.fastBodyStickerFilter.reset();
            }
            if (this.audio3DFilter != null) {
                this.audio3DFilter.reset();
            }
            for (MultiViewerFilter reset4 : this.multiViewerFilters) {
                reset4.reset();
            }
            if (this.mActFilters != null) {
                this.mActFilters.reset();
            }
            AppMethodBeat.o(83155);
            return;
        }
        AppMethodBeat.o(83155);
    }

    public h renderEffectFilter(h hVar) {
        AppMethodBeat.i(83156);
        if (this.mEffectFilter != null) {
            this.mEffectFilter.RenderProcess(hVar.texture[0], hVar.width, hVar.height, -1, 0.0d, this.mEffectTestFrame);
            hVar = this.mEffectTestFrame;
        }
        AppMethodBeat.o(83156);
        return hVar;
    }

    public void setAudioPause(boolean z) {
        AppMethodBeat.i(83157);
        if (this.fastFaceStickerFilter != null) {
            this.fastFaceStickerFilter.setAudioPause(z);
        }
        if (this.fastBodyStickerFilter != null) {
            this.fastBodyStickerFilter.setAudioPause(z);
        }
        if (this.audio3DFilter != null) {
            this.audio3DFilter.setAudioPause(z);
        }
        for (VideoFilterBase videoFilterBase : this.filters) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                ((NormalVideoFilter) videoFilterBase).setAudioPause(z);
            }
        }
        if (this.fabbyMvFilters != null) {
            this.fabbyMvFilters.setAudioPause(z);
        }
        if (this.mActFilters != null) {
            this.mActFilters.setAudioPause(z);
        }
        if (this.multiViewerFilters != null) {
            for (MultiViewerFilter audioPause : this.multiViewerFilters) {
                audioPause.setAudioPause(z);
            }
        }
        AppMethodBeat.o(83157);
    }

    public void setBodyFilters(List<NormalVideoFilter> list) {
        this.bodyFilters = list;
    }

    public void setFaceParticleFilters(List<ParticleFilter> list) {
        AppMethodBeat.i(83158);
        this.faceParticleDynamicFilters = getStickerFilters(list, false, true);
        this.faceParticleStaticFilters = getStickerFilters(list, true, true);
        AppMethodBeat.o(83158);
    }

    public void setGestureParticleFilters(List<ParticleFilter> list) {
        this.gestureParticleFilters = list;
    }

    public void setBodyParticleFilters(List<ParticleFilter> list) {
        this.bodyParticleFilters = list;
    }

    public FastStickerFilter getFastFaceStickerFilter() {
        return this.fastFaceStickerFilter;
    }

    public Audio3DFilter getAudio3DFilter() {
        return this.audio3DFilter;
    }

    public FastStickerFilter getFastBodyStickerFilter() {
        return this.fastBodyStickerFilter;
    }

    public List<VideoFilterBase> getFgStaticStickerFilters() {
        return this.fgStaticStickerFilters;
    }
}
