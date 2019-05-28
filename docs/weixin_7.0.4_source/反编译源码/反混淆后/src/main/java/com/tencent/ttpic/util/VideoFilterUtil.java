package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.C41672h;
import com.tencent.filter.p138a.C44654ab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.factory.FabbyFilterFactory;
import com.tencent.ttpic.filter.ActFilters;
import com.tencent.ttpic.filter.Audio3DFilter;
import com.tencent.ttpic.filter.CrazyFaceFilters;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.DoodleFilter;
import com.tencent.ttpic.filter.FabbyFilters;
import com.tencent.ttpic.filter.FabbyMvFilter;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FaceCropFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.FacialFeatureFilter;
import com.tencent.ttpic.filter.FastStickerFilter;
import com.tencent.ttpic.filter.GameFilter;
import com.tencent.ttpic.filter.HeadCropFilter;
import com.tencent.ttpic.filter.LipsCosFilter;
import com.tencent.ttpic.filter.MultiViewerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.ParticleXFilter;
import com.tencent.ttpic.filter.PhantomFilter;
import com.tencent.ttpic.filter.SimpleEffectVideoFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.ThreeDimFilter;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VoiceTextFilter;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.p683ar.filter.ARParticleFilter;
import com.tencent.ttpic.particle.ParticleFilter;
import com.tencent.ttpic.particlesystemx.ParticleSystemX;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_OFF_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.RANGE_TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.SHADER_TYPE;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class VideoFilterUtil {
    public static final int IMAGE_HEIGHT = 960;
    public static final int IMAGE_WIDTH = 720;
    public static final double SCREEN_RATIO = 0.75d;
    public static final int SHOW_ONCE_TEX_COUNT = 2;
    public static final String SIMPLE_FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
    public static final String SIMPLE_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat");

    public enum RATIO_MODE {
        RATIO_MODE_1_1("1:1"),
        RATIO_MODE_4_3("4:3"),
        RATIO_MODE_16_9("16:9");
        
        public final String value;

        static {
            AppMethodBeat.m2505o(83989);
        }

        private RATIO_MODE(String str) {
            this.value = str;
        }
    }

    static {
        AppMethodBeat.m2504i(84037);
        AppMethodBeat.m2505o(84037);
    }

    public static boolean needCopy(VideoFilterBase videoFilterBase) {
        AppMethodBeat.m2504i(83990);
        if (videoFilterBase == null) {
            AppMethodBeat.m2505o(83990);
            return false;
        } else if (videoFilterBase instanceof NormalVideoFilter) {
            boolean needCopyTex = ((NormalVideoFilter) videoFilterBase).needCopyTex();
            AppMethodBeat.m2505o(83990);
            return needCopyTex;
        } else if (videoFilterBase instanceof FaceOffFilter) {
            AppMethodBeat.m2505o(83990);
            return true;
        } else {
            AppMethodBeat.m2505o(83990);
            return false;
        }
    }

    public static List<String> getAllPngFileNames(String str) {
        AppMethodBeat.m2504i(83991);
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            AppMethodBeat.m2505o(83991);
        } else {
            if (str.startsWith("assets://")) {
                try {
                    String[] list = VideoGlobalContext.getContext().getAssets().list(FileUtils.getRealPath(str));
                    if (list == null) {
                        AppMethodBeat.m2505o(83991);
                    } else {
                        for (String str2 : list) {
                            if (str2.endsWith(".png")) {
                                arrayList.add(str2);
                            }
                        }
                    }
                } catch (IOException e) {
                }
            } else {
                String[] list2 = new File(str).list(VideoMaterialUtil.mPngFilter);
                if (list2 == null) {
                    AppMethodBeat.m2505o(83991);
                } else {
                    arrayList.addAll(Arrays.asList(list2));
                }
            }
            AppMethodBeat.m2505o(83991);
        }
        return arrayList;
    }

    public static VideoFilterList createFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83992);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(83992);
            return null;
        }
        CustomVideoFilter createCustomVideoFilter = createCustomVideoFilter(videoMaterial);
        CustomVertexFilter createCustomVertexFilter = createCustomVertexFilter(videoMaterial);
        SnakeFaceFilter createSnakeFaceFilter = createSnakeFaceFilter(videoMaterial);
        List createFaceOffFilter = createFaceOffFilter(videoMaterial);
        List createTransformFilter = createTransformFilter(videoMaterial);
        VideoFilterBase createDoodleFilter = createDoodleFilter(videoMaterial);
        List createThreeDimFilter = createThreeDimFilter(videoMaterial);
        FaceCropFilter createFaceCropFilter = createFaceCropFilter(videoMaterial);
        HeadCropFilter createHeadCropFilter = createHeadCropFilter(videoMaterial);
        List createHeadCropFilterList = createHeadCropFilterList(videoMaterial);
        List createFaceFilterList = createFaceFilterList(videoMaterial);
        List createGestureVideoFilterList = createGestureVideoFilterList(videoMaterial);
        List createBodyVideoFilterList = createBodyVideoFilterList(videoMaterial);
        FabbyFilters createFabbyMvFilterList = createFabbyMvFilterList(videoMaterial);
        LipsCosFilter createLipsCosFilter = createLipsCosFilter(videoMaterial);
        List createMultiViewerFilters = createMultiViewerFilters(videoMaterial);
        List createFacialFeatureFilters = createFacialFeatureFilters(videoMaterial);
        GameFilter createGameFilter = createGameFilter(videoMaterial);
        List createVoiceTextFilter = createVoiceTextFilter(videoMaterial);
        List createFaceParticleFilters = createFaceParticleFilters(videoMaterial);
        List createGestureParticleFilters = createGestureParticleFilters(videoMaterial);
        List createBodyParticleFilters = createBodyParticleFilters(videoMaterial);
        PhantomFilter createPhantomFilter = createPhantomFilter(videoMaterial);
        if (createCustomVideoFilter != null) {
            createCustomVideoFilter.setNormalFilters(createFaceFilterList);
        }
        VideoFilterList videoFilterList = new VideoFilterList();
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getShaderType() == SHADER_TYPE.NORMAL.value) {
            arrayList.addAll(createFaceFilterList);
        } else {
            if (videoMaterial.getShaderType() == SHADER_TYPE.COMMON_BEFORE_CUSTOM.value) {
                arrayList.addAll(createFaceFilterList);
                if (createCustomVideoFilter != null) {
                    arrayList.add(createCustomVideoFilter);
                }
            } else {
                if (videoMaterial.getShaderType() == SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) {
                    if (createCustomVideoFilter != null) {
                        arrayList.add(createCustomVideoFilter);
                    }
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {
                    arrayList.add(createSnakeFaceFilter);
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.CUSTOM_VERTEX_SHADER.value) {
                    arrayList.add(createCustomVertexFilter);
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_OFF.value) {
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.TRANSFORM.value) {
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_OFF_TRANSFORM.value || videoMaterial.getShaderType() == SHADER_TYPE.GAMEPLAY_3D.value) {
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.THREE_DIM.value) {
                    arrayList.addAll(createThreeDimFilter);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.DOODLE.value) {
                    arrayList.add(createDoodleFilter);
                } else if (VideoMaterialUtil.isFaceMorphingMaterial(videoMaterial)) {
                    videoFilterList.setCrazyFaceFilters(new CrazyFaceFilters(videoMaterial));
                    arrayList.addAll(createFaceFilterList);
                } else if (VideoMaterialUtil.isARMaterial(videoMaterial)) {
                    videoFilterList.setARParticleFilter(createARParticleFilter(videoMaterial));
                    if (createFaceFilterList != null) {
                        arrayList.addAll(createFaceFilterList);
                    }
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.MAI_MENG.value) {
                    videoFilterList.setActFilter(createActFilter(videoMaterial));
                    arrayList.addAll(createFaceFilterList);
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_CROP.value) {
                    arrayList.add(createFaceCropFilter);
                    if (createFaceFilterList != null) {
                        arrayList.addAll(createFaceFilterList);
                        createFaceCropFilter.setNormalFilters(createFaceFilterList);
                    }
                } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_HEAD_CROP.value) {
                    videoFilterList.setHeadCropFilter(createHeadCropFilter);
                    arrayList.add(createHeadCropFilter);
                    arrayList.addAll(createFaceFilterList);
                    videoFilterList.setHeadCropItemFilters(createHeadCropFilterList);
                }
            }
        }
        if (createPhantomFilter != null) {
            videoFilterList.setPhantomFilter(createPhantomFilter);
        }
        arrayList.addAll(createVoiceTextFilter);
        VideoFilterBase createEffectFilter = createEffectFilter(videoMaterial);
        if (createEffectFilter != null) {
            videoFilterList.setVideoEffectFilter(createEffectFilter);
            videoFilterList.setVideoEffectOrder(videoMaterial.getVideoFilterEffect().order);
        }
        if (createLipsCosFilter != null) {
            videoFilterList.setLipsCosFilter(createLipsCosFilter);
        }
        videoFilterList.setFabbyMvFilters(createFabbyMvFilterList);
        videoFilterList.setFilters(arrayList, createFaceOffFilter, createTransformFilter);
        videoFilterList.setFastFaceStickerFilter(createFastFaceStickerFilter(videoMaterial));
        videoFilterList.setFastBodyStickerFilter(createFastBodyStickerFilter(videoMaterial));
        videoFilterList.setFaceParticleFilters(createFaceParticleFilters);
        videoFilterList.setGestureParticleFilters(createGestureParticleFilters);
        videoFilterList.setBodyParticleFilters(createBodyParticleFilters);
        videoFilterList.setAudio3DFilter(createAudio3DFilter(videoMaterial));
        videoFilterList.setGestureFilters(createGestureVideoFilterList);
        videoFilterList.setBodyFilters(createBodyVideoFilterList);
        videoFilterList.setGameFilter(createGameFilter);
        videoFilterList.setMultiViewerFilters(createMultiViewerFilters);
        videoFilterList.setNeedDetectGesture(VideoMaterialUtil.isGestureDetectMaterial(videoMaterial));
        videoFilterList.setMaterial(videoMaterial);
        videoFilterList.setFacialFeatureFilterList(createFacialFeatureFilters);
        if (videoMaterial.getAudio2Text() != null) {
            videoFilterList.setTriggerWords(videoMaterial.getAudio2Text().triggerWords);
        }
        AppMethodBeat.m2505o(83992);
        return videoFilterList;
    }

    private static PhantomFilter createPhantomFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83993);
        PhantomFilter phantomFilter = null;
        List phantomItemList = videoMaterial.getPhantomItemList();
        if (phantomItemList != null && phantomItemList.size() > 0) {
            phantomFilter = new PhantomFilter(phantomItemList);
        }
        AppMethodBeat.m2505o(83993);
        return phantomFilter;
    }

    private static List<FacialFeatureFilter> createFacialFeatureFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83994);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial == null || videoMaterial.getFaceFeatureItemList() == null) {
            AppMethodBeat.m2505o(83994);
            return null;
        }
        for (FaceFeatureItem faceFeatureItem : videoMaterial.getFaceFeatureItemList()) {
            if (!(faceFeatureItem.getFaceOffItemList() == null || faceFeatureItem.getFaceOffItemList().isEmpty())) {
                List<StickerItem> stickerItems = faceFeatureItem.getStickerItems();
                FacialFeatureFilter facialFeatureFilter = new FacialFeatureFilter((FaceItem) faceFeatureItem.getFaceOffItemList().get(0), faceFeatureItem.getDistortionItemList(), faceFeatureItem);
                ArrayList arrayList2 = new ArrayList();
                if (!BaseUtils.isEmpty(stickerItems)) {
                    for (StickerItem stickerItem : stickerItems) {
                        if (stickerItem != null) {
                            NormalVideoFilter createFilter = VideoFilterFactory.createFilter(stickerItem, videoMaterial.getDataPath());
                            if (createFilter != null) {
                                arrayList2.add(createFilter);
                            }
                        }
                    }
                }
                facialFeatureFilter.setStickerFilters(arrayList2);
                arrayList.add(facialFeatureFilter);
            }
        }
        AppMethodBeat.m2505o(83994);
        return arrayList;
    }

    private static List<VideoFilterBase> createTransformFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83995);
        ArrayList arrayList = new ArrayList();
        List faceMeshItemList = videoMaterial.getFaceMeshItemList();
        if (!BaseUtils.isEmpty(faceMeshItemList)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= faceMeshItemList.size()) {
                    break;
                }
                arrayList.add(new TransformFilter((FaceMeshItem) faceMeshItemList.get(i2), videoMaterial.getDataPath()));
                i = i2 + 1;
            }
        } else if (BaseUtils.isEmpty(videoMaterial.getDistortionItemList())) {
            if (!BaseUtils.isEmpty(videoMaterial.getFaceMoveItemList())) {
                arrayList.add(new FaceMoveFilter(videoMaterial.getFaceMoveItemList(), videoMaterial.getItemList(), videoMaterial.getFaceMoveTriangles()));
            }
        } else if (videoMaterial.isUseMesh()) {
            TransformFilter transformFilter = new TransformFilter(videoMaterial.getDistortionItemList(), videoMaterial.getItemList());
            transformFilter.setOptimizeBoundary(true);
            arrayList.add(transformFilter);
        }
        AppMethodBeat.m2505o(83995);
        return arrayList;
    }

    private static VideoFilterBase createDoodleFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83996);
        VideoFilterBase videoFilterBase = null;
        if (videoMaterial.getShaderType() == SHADER_TYPE.DOODLE.value) {
            videoFilterBase = new DoodleFilter();
        }
        AppMethodBeat.m2505o(83996);
        return videoFilterBase;
    }

    private static VideoFilterBase createSimpleEffectVideoFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83997);
        SimpleEffectVideoFilter simpleEffectVideoFilter = new SimpleEffectVideoFilter(videoMaterial.getDataPath());
        AppMethodBeat.m2505o(83997);
        return simpleEffectVideoFilter;
    }

    private static List<VideoFilterBase> createThreeDimFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83998);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getShaderType() == SHADER_TYPE.THREE_DIM.value && videoMaterial.getItemList() != null) {
            for (StickerItem threeDimFilter : videoMaterial.getItemList()) {
                arrayList.add(new ThreeDimFilter(threeDimFilter, videoMaterial.getDataPath()));
            }
        }
        AppMethodBeat.m2505o(83998);
        return arrayList;
    }

    private static ActFilters createActFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(83999);
        ActFilters actFilters = null;
        if (videoMaterial.getShaderType() == SHADER_TYPE.MAI_MENG.value && videoMaterial.getFaceExpression() != null) {
            actFilters = new ActFilters(videoMaterial.getFaceExpression(), videoMaterial.getDataPath());
        }
        AppMethodBeat.m2505o(83999);
        return actFilters;
    }

    private static List<NormalVideoFilter> createHeadCropFilterList(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84000);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getHeadCropItemList() != null) {
            for (StickerItem createFilter : videoMaterial.getHeadCropItemList()) {
                NormalVideoFilter createFilter2 = VideoFilterFactory.createFilter(createFilter, videoMaterial.getDataPath());
                if (createFilter2 != null) {
                    arrayList.add(createFilter2);
                }
            }
        }
        AppMethodBeat.m2505o(84000);
        return arrayList;
    }

    private static List<NormalVideoFilter> createFaceFilterList(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84001);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            boolean canMaterialUseFastRender = VideoMaterialUtil.canMaterialUseFastRender(videoMaterial);
            for (StickerItem stickerItem : videoMaterial.getItemList()) {
                if (VideoMaterialUtil.isFaceItem(stickerItem) && stickerItem.particleConfig == null) {
                    if (!canMaterialUseFastRender || !VideoMaterialUtil.canStickerItemUseFastRender(stickerItem)) {
                        NormalVideoFilter createFilter = VideoFilterFactory.createFilter(stickerItem, videoMaterial.getDataPath());
                        if (createFilter != null) {
                            arrayList.add(createFilter);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84001);
        return arrayList;
    }

    private static List<NormalVideoFilter> createGestureVideoFilterList(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84002);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            for (StickerItem stickerItem : videoMaterial.getItemList()) {
                if (VideoMaterialUtil.isGestureItem(stickerItem) && stickerItem.particleConfig == null) {
                    NormalVideoFilter createFilter = VideoFilterFactory.createFilter(stickerItem, videoMaterial.getDataPath());
                    if (createFilter != null) {
                        arrayList.add(createFilter);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84002);
        return arrayList;
    }

    private static List<NormalVideoFilter> createBodyVideoFilterList(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84003);
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            boolean canMaterialUseFastRender = VideoMaterialUtil.canMaterialUseFastRender(videoMaterial);
            for (StickerItem stickerItem : videoMaterial.getItemList()) {
                if (VideoMaterialUtil.isBodyDetectItem(stickerItem) && stickerItem.particleConfig == null) {
                    if (!canMaterialUseFastRender || !VideoMaterialUtil.canStickerItemUseFastRender(stickerItem)) {
                        NormalVideoFilter createFilter = VideoFilterFactory.createFilter(stickerItem, videoMaterial.getDataPath());
                        if (createFilter != null) {
                            arrayList.add(createFilter);
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84003);
        return arrayList;
    }

    private static FastStickerFilter createFastFaceStickerFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84004);
        if (videoMaterial.getItemList() != null) {
            if (VideoMaterialUtil.canMaterialUseFastRender(videoMaterial)) {
                FastStickerFilter fastStickerFilter = new FastStickerFilter();
                for (StickerItem stickerItem : videoMaterial.getItemList()) {
                    if (VideoMaterialUtil.isFaceItem(stickerItem) && VideoMaterialUtil.canStickerItemUseFastFaceRender(stickerItem)) {
                        fastStickerFilter.addSticker(stickerItem, videoMaterial.getDataPath());
                    }
                }
                if (fastStickerFilter.getStickerListSize() > 0) {
                    AppMethodBeat.m2505o(84004);
                    return fastStickerFilter;
                }
            }
            AppMethodBeat.m2505o(84004);
            return null;
        }
        AppMethodBeat.m2505o(84004);
        return null;
    }

    private static Audio3DFilter createAudio3DFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84005);
        if (!(videoMaterial == null || videoMaterial.getAudio3DParams() == null)) {
            Audio3DFilter audio3DFilter = new Audio3DFilter(videoMaterial.getItemList3D(), videoMaterial.getOrderMode(), videoMaterial.getMaxFaceCount());
            audio3DFilter.setGameParams(videoMaterial.getGameParams(), videoMaterial.getDataPath());
            if (videoMaterial.getItemList() != null) {
                for (StickerItem addSticker : videoMaterial.getItemList()) {
                    audio3DFilter.addSticker(addSticker, videoMaterial.getDataPath());
                }
            }
            if (audio3DFilter.getStickerListSize() > 0) {
                AppMethodBeat.m2505o(84005);
                return audio3DFilter;
            }
        }
        AppMethodBeat.m2505o(84005);
        return null;
    }

    private static FastStickerFilter createFastBodyStickerFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84006);
        if (videoMaterial.getItemList() != null) {
            if (VideoMaterialUtil.canMaterialUseFastRender(videoMaterial)) {
                FastStickerFilter fastStickerFilter = new FastStickerFilter();
                for (StickerItem stickerItem : videoMaterial.getItemList()) {
                    if (VideoMaterialUtil.isBodyDetectItem(stickerItem) && VideoMaterialUtil.canStickerItemUseFastBodyRender(stickerItem)) {
                        fastStickerFilter.addSticker(stickerItem, videoMaterial.getDataPath());
                    }
                }
                if (fastStickerFilter.getStickerListSize() > 0) {
                    AppMethodBeat.m2505o(84006);
                    return fastStickerFilter;
                }
            }
            AppMethodBeat.m2505o(84006);
            return null;
        }
        AppMethodBeat.m2505o(84006);
        return null;
    }

    private static List<MultiViewerFilter> createMultiViewerFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84007);
        ArrayList arrayList = new ArrayList();
        for (MultiViewerItem multiViewerItem : videoMaterial.getMultiViewerItemList()) {
            if (!(multiViewerItem == null || multiViewerItem.videoMaterial == null)) {
                MultiViewerFilter multiViewerFilter = new MultiViewerFilter();
                multiViewerFilter.setVideoFilterList(createFilters(multiViewerItem.videoMaterial));
                multiViewerFilter.setActiveParts(multiViewerItem.activeParts);
                multiViewerFilter.setRenderId(multiViewerItem.renderId);
                multiViewerFilter.setNeedOriginFrame(multiViewerItem.needOriginFrame);
                if (!TextUtils.isEmpty(multiViewerItem.videoMaterial.getFilterId())) {
                    multiViewerFilter.setEffectFilter(FabbyFilterFactory.createFilter(multiViewerItem.videoMaterial.getFilterId()));
                }
                arrayList.add(multiViewerFilter);
            }
        }
        AppMethodBeat.m2505o(84007);
        return arrayList;
    }

    private static GameFilter createGameFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84008);
        if (videoMaterial == null || videoMaterial.getGameParams() == null) {
            AppMethodBeat.m2505o(84008);
            return null;
        }
        GameFilter gameFilter = new GameFilter(videoMaterial.getItemList3D(), videoMaterial.getOrderMode(), videoMaterial.getMaxFaceCount());
        gameFilter.setGameParams(videoMaterial.getGameParams(), videoMaterial.getDataPath());
        AppMethodBeat.m2505o(84008);
        return gameFilter;
    }

    private static FabbyFilters createFabbyMvFilterList(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84009);
        FabbyFilters fabbyFilters = null;
        if (videoMaterial.getFabbyParts() != null) {
            ArrayList arrayList = new ArrayList();
            for (FabbyMvPart fabbyMvPart : videoMaterial.getFabbyParts().getParts()) {
                FabbyMvFilter fabbyMvFilter = new FabbyMvFilter();
                if (fabbyMvPart.bgItem != null) {
                    fabbyMvFilter.bgFilter = (StaticStickerFilter) VideoFilterFactory.createFilter(fabbyMvPart.bgItem, videoMaterial.getDataPath());
                }
                if (fabbyMvPart.fgItem != null) {
                    fabbyMvFilter.fgFilter = (StaticStickerFilter) VideoFilterFactory.createFilter(fabbyMvPart.fgItem, videoMaterial.getDataPath());
                }
                if (fabbyMvPart.coverItem != null) {
                    fabbyMvFilter.coverFilter = (StaticStickerFilter) VideoFilterFactory.createFilter(fabbyMvPart.coverItem, videoMaterial.getDataPath());
                }
                if (fabbyMvPart.filterType == 1) {
                    fabbyMvFilter.mEffectFilter = FabbyFilterFactory.createFilter(fabbyMvPart.filterId);
                } else if (fabbyMvPart.filterType == 2) {
                    fabbyMvFilter.mEffectFilter = new C44654ab();
                    fabbyMvFilter.mEffectFilter.addParam(new C25628k("inputImageTexture2", BitmapUtils.decodeSampledBitmapFromFile(videoMaterial.getDataPath() + File.separator + fabbyMvPart.lutFile, 1), 33986, true));
                }
                fabbyMvFilter.mvPart = fabbyMvPart;
                int i = 0;
                for (Pair pair : fabbyMvPart.gridSettingMap) {
                    int size;
                    if (((GridSettingModel) pair.second).canvasRectList.size() > i) {
                        size = ((GridSettingModel) pair.second).canvasRectList.size();
                    } else {
                        size = i;
                    }
                    i = size;
                }
                arrayList.add(fabbyMvFilter);
            }
            fabbyFilters = new FabbyFilters(arrayList, videoMaterial.getDataPath(), videoMaterial.getFabbyParts().getAudioFile());
        }
        AppMethodBeat.m2505o(84009);
        return fabbyFilters;
    }

    private static List<VideoFilterBase> createFaceOffFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84010);
        ArrayList arrayList = new ArrayList();
        List faceOffItemList = videoMaterial.getFaceOffItemList();
        if (faceOffItemList == null) {
            AppMethodBeat.m2505o(84010);
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < faceOffItemList.size()) {
                Object faceOffByImageFilter;
                FaceItem faceItem = (FaceItem) faceOffItemList.get(i2);
                if (videoMaterial.getFaceoffType() == FACE_OFF_TYPE.BY_IMAGE.value) {
                    faceOffByImageFilter = new FaceOffByImageFilter(faceItem);
                } else {
                    FaceOffFilter faceOffFilter = new FaceOffFilter(faceItem, videoMaterial.getDataPath());
                    String loadVertexShader = VideoMaterialUtil.loadVertexShader(videoMaterial.getDataPath());
                    String loadFragmentShader = VideoMaterialUtil.loadFragmentShader(videoMaterial.getDataPath());
                    if (!(TextUtils.isEmpty(loadVertexShader) && TextUtils.isEmpty(loadFragmentShader))) {
                        if (TextUtils.isEmpty(loadVertexShader)) {
                            loadVertexShader = FaceOffFilter.VERTEX_SHADER;
                        }
                        if (TextUtils.isEmpty(loadFragmentShader)) {
                            loadFragmentShader = FaceOffFilter.FRAGMENT_SHADER;
                        }
                        faceOffFilter.updateFilterShader(loadVertexShader, loadFragmentShader);
                    }
                    FaceOffFilter faceOffByImageFilter2 = faceOffFilter;
                }
                arrayList.add(faceOffByImageFilter2);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(84010);
                return arrayList;
            }
        }
    }

    private static SnakeFaceFilter createSnakeFaceFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84011);
        SnakeFaceFilter snakeFaceFilter = null;
        if (videoMaterial.getShaderType() == SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {
            snakeFaceFilter = new SnakeFaceFilter();
        }
        AppMethodBeat.m2505o(84011);
        return snakeFaceFilter;
    }

    private static CustomVideoFilter createCustomVideoFilter(VideoMaterial videoMaterial) {
        CustomVideoFilter customVideoFilter = null;
        AppMethodBeat.m2504i(84012);
        if (videoMaterial.getShaderType() == SHADER_TYPE.CUSTOM_BEFORE_COMMON.value || videoMaterial.getShaderType() == SHADER_TYPE.COMMON_BEFORE_CUSTOM.value) {
            String loadVertexShader = VideoMaterialUtil.loadVertexShader(videoMaterial.getDataPath());
            String loadFragmentShader = VideoMaterialUtil.loadFragmentShader(videoMaterial.getDataPath());
            if (TextUtils.isEmpty(loadVertexShader) && TextUtils.isEmpty(loadFragmentShader)) {
                AppMethodBeat.m2505o(84012);
                return customVideoFilter;
            }
            if (TextUtils.isEmpty(loadVertexShader)) {
                loadVertexShader = VideoFilterFactory.VERTEX_SHADER_COMMON;
            }
            if (TextUtils.isEmpty(loadFragmentShader)) {
                loadFragmentShader = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
            }
            customVideoFilter = new CustomVideoFilter(loadVertexShader, loadFragmentShader, videoMaterial.getResourceList(), getCustomFilterTriggerType(videoMaterial.getItemList()), videoMaterial.getDataPath());
        }
        AppMethodBeat.m2505o(84012);
        return customVideoFilter;
    }

    private static CustomVideoFilter createCustomEffectVideoFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84013);
        String loadVideoCustomEffectFilterVertexShader = VideoMaterialUtil.loadVideoCustomEffectFilterVertexShader(videoMaterial.getDataPath());
        String loadVideoCustomEffectFilterFragmentShader = VideoMaterialUtil.loadVideoCustomEffectFilterFragmentShader(videoMaterial.getDataPath());
        if (TextUtils.isEmpty(loadVideoCustomEffectFilterVertexShader)) {
            loadVideoCustomEffectFilterVertexShader = VideoFilterFactory.VERTEX_SHADER_COMMON;
        }
        if (TextUtils.isEmpty(loadVideoCustomEffectFilterFragmentShader)) {
            loadVideoCustomEffectFilterFragmentShader = VideoFilterFactory.FRAGMENT_SHADER_IMAGE;
        }
        CustomVideoFilter customVideoFilter = new CustomVideoFilter(loadVideoCustomEffectFilterVertexShader, loadVideoCustomEffectFilterFragmentShader, videoMaterial.getResourceList(), getCustomFilterTriggerType(videoMaterial.getItemList()), videoMaterial.getDataPath());
        AppMethodBeat.m2505o(84013);
        return customVideoFilter;
    }

    private static CustomVertexFilter createCustomVertexFilter(VideoMaterial videoMaterial) {
        CustomVertexFilter customVertexFilter;
        AppMethodBeat.m2504i(84014);
        if (videoMaterial.getShaderType() == SHADER_TYPE.CUSTOM_VERTEX_SHADER.value) {
            String loadVertexShader = VideoMaterialUtil.loadVertexShader(videoMaterial.getDataPath());
            String loadFragmentShader = VideoMaterialUtil.loadFragmentShader(videoMaterial.getDataPath());
            if (TextUtils.isEmpty(loadVertexShader)) {
                loadVertexShader = SIMPLE_VERTEX_SHADER;
            }
            if (TextUtils.isEmpty(loadFragmentShader)) {
                loadFragmentShader = SIMPLE_FRAGMENT_SHADER;
            }
            if (!BaseUtils.isEmpty(videoMaterial.getItemList())) {
                customVertexFilter = new CustomVertexFilter(loadVertexShader, loadFragmentShader);
                AppMethodBeat.m2505o(84014);
                return customVertexFilter;
            }
        }
        customVertexFilter = null;
        AppMethodBeat.m2505o(84014);
        return customVertexFilter;
    }

    private static ARParticleFilter createARParticleFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84015);
        ARParticleFilter aRParticleFilter = null;
        if (VideoMaterialUtil.isARMaterial(videoMaterial)) {
            aRParticleFilter = new ARParticleFilter(videoMaterial.getArParticleList(), videoMaterial.getDataPath());
        }
        AppMethodBeat.m2505o(84015);
        return aRParticleFilter;
    }

    private static FaceCropFilter createFaceCropFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84016);
        FaceCropFilter faceCropFilter = null;
        if (videoMaterial != null && videoMaterial.getShaderType() == SHADER_TYPE.FACE_CROP.value) {
            faceCropFilter = new FaceCropFilter(videoMaterial);
        }
        AppMethodBeat.m2505o(84016);
        return faceCropFilter;
    }

    private static HeadCropFilter createHeadCropFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84017);
        HeadCropFilter headCropFilter = null;
        if (videoMaterial != null && videoMaterial.getShaderType() == SHADER_TYPE.FACE_HEAD_CROP.value) {
            headCropFilter = new HeadCropFilter();
        }
        AppMethodBeat.m2505o(84017);
        return headCropFilter;
    }

    private static LipsCosFilter createLipsCosFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84018);
        LipsCosFilter lipsCosFilter = null;
        if (!TextUtils.isEmpty(videoMaterial.getLipsLutPath())) {
            Bitmap decodeSampleBitmapFromAssets;
            String str = videoMaterial.getDataPath() + File.separator + videoMaterial.getLipsLutPath();
            if (str.startsWith("assets://")) {
                decodeSampleBitmapFromAssets = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(str), 1);
            } else {
                decodeSampleBitmapFromAssets = BitmapUtils.decodeSampledBitmapFromFile(str, 1);
            }
            LipsCosFilter lipsCosFilter2 = new LipsCosFilter();
            lipsCosFilter2.setTypeAndLut(1, decodeSampleBitmapFromAssets);
            lipsCosFilter = lipsCosFilter2;
        }
        AppMethodBeat.m2505o(84018);
        return lipsCosFilter;
    }

    private static PTExpression getCustomFilterTriggerType(List<StickerItem> list) {
        AppMethodBeat.m2504i(84019);
        PTExpression pTExpression;
        if (BaseUtils.isEmpty(list)) {
            pTExpression = PTExpression.UNKNOW;
            AppMethodBeat.m2505o(84019);
            return pTExpression;
        }
        int i = PTExpression.UNKNOW.value;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                StickerItem stickerItem = (StickerItem) it.next();
                if (stickerItem.triggerType > i2) {
                    i = stickerItem.triggerType;
                } else {
                    i = i2;
                }
            } else {
                pTExpression = VideoMaterialUtil.getTriggerType(i2);
                AppMethodBeat.m2505o(84019);
                return pTExpression;
            }
        }
    }

    public static int get4DirectionAngle(double d) {
        if (d > 3.141592653589793d) {
            d -= 6.283185307179586d;
        }
        if (d >= -0.7853981633974483d && d <= 0.7853981633974483d) {
            return 0;
        }
        if (d >= 0.7853981633974483d && d <= 2.356194490192345d) {
            return 90;
        }
        if (d < -2.356194490192345d || d > -0.7853981633974483d) {
            return 180;
        }
        return 270;
    }

    public static double get8DirectionAngle(double d) {
        if (d >= -0.39269908169872414d && d <= 0.39269908169872414d) {
            return 0.0d;
        }
        if (d >= 0.39269908169872414d && d <= 1.1780972450961724d) {
            return 0.7853981633974483d;
        }
        if (d >= 1.1780972450961724d && d <= 1.9634954084936207d) {
            return 1.5707963267948966d;
        }
        if (d >= 1.9634954084936207d && d <= 2.748893571891069d) {
            return 2.356194490192345d;
        }
        if (d >= -1.1780972450961724d && d <= -0.39269908169872414d) {
            return -0.7853981633974483d;
        }
        if (d >= -1.9634954084936207d && d <= -1.1780972450961724d) {
            return -1.5707963267948966d;
        }
        if (d < -2.748893571891069d || d > -1.9634954084936207d) {
            return -3.141592653589793d;
        }
        return -2.356194490192345d;
    }

    public static void setRenderMode(List<? extends VideoFilterBase> list, int i) {
        AppMethodBeat.m2504i(84020);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.m2505o(84020);
            return;
        }
        for (VideoFilterBase renderMode : list) {
            renderMode.setRenderMode(i);
        }
        AppMethodBeat.m2505o(84020);
    }

    public static void setRenderMode(BaseFilter baseFilter, int i) {
        AppMethodBeat.m2504i(84021);
        while (baseFilter != null) {
            baseFilter.setRenderMode(i);
            baseFilter = baseFilter.getmNextFilter();
        }
        AppMethodBeat.m2505o(84021);
    }

    public static void setRenderMode(VideoFilterBase videoFilterBase, int i) {
        AppMethodBeat.m2504i(84022);
        if (videoFilterBase != null) {
            videoFilterBase.setRenderMode(i);
        }
        AppMethodBeat.m2505o(84022);
    }

    public static C41672h getSecondLastFrame(C41672h c41672h) {
        AppMethodBeat.m2504i(84023);
        if (FrameUtil.isValid(c41672h) && FrameUtil.isValid(c41672h.bJA)) {
            while (FrameUtil.isValid(c41672h.bJA) && FrameUtil.isValid(c41672h.bJA.bJA)) {
                c41672h = c41672h.bJA;
            }
            AppMethodBeat.m2505o(84023);
            return c41672h;
        }
        AppMethodBeat.m2505o(84023);
        return null;
    }

    public static boolean needBlendMode(List<VideoFilterBase> list) {
        AppMethodBeat.m2504i(84024);
        if (list == null) {
            AppMethodBeat.m2505o(84024);
            return false;
        }
        for (VideoFilterBase videoFilterBase : list) {
            if (videoFilterBase instanceof NormalVideoFilter) {
                AppMethodBeat.m2505o(84024);
                return true;
            }
        }
        AppMethodBeat.m2505o(84024);
        return false;
    }

    public static boolean canUseBlendMode(VideoFilterBase videoFilterBase) {
        AppMethodBeat.m2504i(84025);
        if (videoFilterBase == null) {
            AppMethodBeat.m2505o(84025);
            return false;
        } else if (videoFilterBase instanceof NormalVideoFilter) {
            if (((NormalVideoFilter) videoFilterBase).canUseBlendMode() || VideoModule.es_GL_EXT_shader_framebuffer_fetch) {
                AppMethodBeat.m2505o(84025);
                return true;
            }
            AppMethodBeat.m2505o(84025);
            return false;
        } else if ((videoFilterBase instanceof FaceOffByImageFilter) || (videoFilterBase instanceof ThreeDimFilter) || (videoFilterBase instanceof ARParticleFilter) || (videoFilterBase instanceof HeadCropFilter)) {
            AppMethodBeat.m2505o(84025);
            return true;
        } else if (videoFilterBase instanceof FaceOffFilter) {
            if (((FaceOffFilter) videoFilterBase).canUseBlendMode() || VideoModule.es_GL_EXT_shader_framebuffer_fetch) {
                AppMethodBeat.m2505o(84025);
                return true;
            }
            AppMethodBeat.m2505o(84025);
            return false;
        } else if (videoFilterBase instanceof VoiceTextFilter) {
            AppMethodBeat.m2505o(84025);
            return true;
        } else if (videoFilterBase instanceof ParticleFilter) {
            AppMethodBeat.m2505o(84025);
            return true;
        } else {
            AppMethodBeat.m2505o(84025);
            return false;
        }
    }

    public static boolean needDepthBuffer(VideoFilterBase videoFilterBase) {
        return videoFilterBase != null && (videoFilterBase instanceof ThreeDimFilter);
    }

    public static boolean actionTriggered(List<PointF> list, List<StickerItem> list2, Set<Integer> set) {
        AppMethodBeat.m2504i(84026);
        if (list == null) {
            AppMethodBeat.m2505o(84026);
            return false;
        } else if (list2 == null || list2.size() == 0 || set == null) {
            AppMethodBeat.m2505o(84026);
            return true;
        } else {
            for (StickerItem stickerItem : list2) {
                if (stickerItem != null && set.contains(Integer.valueOf(stickerItem.triggerType))) {
                    AppMethodBeat.m2505o(84026);
                    return true;
                }
            }
            AppMethodBeat.m2505o(84026);
            return false;
        }
    }

    public static boolean isStatusTriggered(FaceRangeStatus faceRangeStatus, int i, ValueRange valueRange) {
        AppMethodBeat.m2504i(84027);
        if (faceRangeStatus == null) {
            AppMethodBeat.m2505o(84027);
            return false;
        }
        for (RANGE_TRIGGER_TYPE range_trigger_type : RANGE_TRIGGER_TYPE.values()) {
            if (range_trigger_type.value == i) {
                boolean isInRange = range_trigger_type.checker.isInRange(faceRangeStatus, valueRange);
                AppMethodBeat.m2505o(84027);
                return isInRange;
            }
        }
        AppMethodBeat.m2505o(84027);
        return false;
    }

    public static float getFaceStatus(FaceRangeStatus faceRangeStatus, int i, ValueRange valueRange) {
        AppMethodBeat.m2504i(84028);
        if (faceRangeStatus == null) {
            AppMethodBeat.m2505o(84028);
            return -1.0f;
        }
        for (RANGE_TRIGGER_TYPE range_trigger_type : RANGE_TRIGGER_TYPE.values()) {
            if (range_trigger_type.value == i) {
                float level = range_trigger_type.checker.getLevel(faceRangeStatus, valueRange);
                AppMethodBeat.m2505o(84028);
                return level;
            }
        }
        AppMethodBeat.m2505o(84028);
        return -1.0f;
    }

    public static boolean needRecordTouchPoint(VideoFilterList videoFilterList) {
        AppMethodBeat.m2504i(84029);
        if (videoFilterList == null || !VideoMaterialUtil.isARMaterial(videoFilterList.getMaterial())) {
            AppMethodBeat.m2505o(84029);
            return false;
        }
        AppMethodBeat.m2505o(84029);
        return true;
    }

    private static List<VideoFilterBase> createVoiceTextFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84030);
        ArrayList arrayList = new ArrayList();
        List<StickerItem> itemList = videoMaterial.getItemList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (itemList != null) {
            for (StickerItem stickerItem : itemList) {
                if (!(stickerItem.transition == null || stickerItem.wmGroupCopies == null)) {
                    if (stickerItem.zIndex >= 0) {
                        arrayList2.add(stickerItem);
                    } else {
                        arrayList3.add(stickerItem);
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                arrayList.add(new VoiceTextFilter(((StickerItem) arrayList2.get(0)).zIndex, arrayList2));
            }
            if (!arrayList3.isEmpty()) {
                arrayList.add(new VoiceTextFilter(((StickerItem) arrayList3.get(0)).zIndex, arrayList3));
            }
        }
        AppMethodBeat.m2505o(84030);
        return arrayList;
    }

    private static List<VideoFilterBase> createParticleXFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84031);
        ArrayList arrayList = new ArrayList();
        List itemList = videoMaterial.getItemList();
        if (itemList != null) {
            ParticleSystemX.getInstance().init(VideoGlobalContext.getContext());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= itemList.size()) {
                    break;
                }
                StickerItem stickerItem = (StickerItem) itemList.get(i2);
                if (stickerItem.transition != null && stickerItem.wmGroupCopies == null) {
                    arrayList.add(new ParticleXFilter(stickerItem, videoMaterial.getDataPath(), i2));
                    ParticleSystemX.getInstance().addParticle(stickerItem.transition);
                }
                i = i2 + 1;
            }
            ParticleSystemX.getInstance().registerTemplate();
        }
        AppMethodBeat.m2505o(84031);
        return arrayList;
    }

    private static List<ParticleFilter> createFaceParticleFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84032);
        ArrayList arrayList = new ArrayList();
        List itemList = videoMaterial.getItemList();
        if (itemList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= itemList.size()) {
                    break;
                }
                StickerItem stickerItem = (StickerItem) itemList.get(i2);
                if (stickerItem.particleConfig != null && VideoMaterialUtil.isFaceItem(stickerItem)) {
                    arrayList.add(new ParticleFilter(videoMaterial.getDataPath() + File.separator + stickerItem.f18271id, stickerItem));
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(84032);
        return arrayList;
    }

    private static List<ParticleFilter> createGestureParticleFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84033);
        ArrayList arrayList = new ArrayList();
        List itemList = videoMaterial.getItemList();
        if (itemList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= itemList.size()) {
                    break;
                }
                StickerItem stickerItem = (StickerItem) itemList.get(i2);
                if (stickerItem.particleConfig != null && VideoMaterialUtil.isGestureItem(stickerItem)) {
                    arrayList.add(new ParticleFilter(videoMaterial.getDataPath() + File.separator + stickerItem.f18271id, stickerItem));
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(84033);
        return arrayList;
    }

    private static List<ParticleFilter> createBodyParticleFilters(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84034);
        ArrayList arrayList = new ArrayList();
        List itemList = videoMaterial.getItemList();
        if (itemList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= itemList.size()) {
                    break;
                }
                StickerItem stickerItem = (StickerItem) itemList.get(i2);
                if (stickerItem.particleConfig != null && VideoMaterialUtil.isBodyDetectItem(stickerItem)) {
                    arrayList.add(new ParticleFilter(videoMaterial.getDataPath() + File.separator + stickerItem.f18271id, stickerItem));
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(84034);
        return arrayList;
    }

    private static VideoFilterBase createEffectFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84035);
        VideoFilterBase videoFilterBase = null;
        if (videoMaterial != null) {
            VideoFilterEffect videoFilterEffect = videoMaterial.getVideoFilterEffect();
            if (videoFilterEffect != null) {
                switch (videoFilterEffect.type) {
                    case 1:
                        videoFilterBase = createSimpleEffectVideoFilter(videoMaterial);
                        break;
                    case 2:
                        videoFilterBase = createCustomEffectVideoFilter(videoMaterial);
                        break;
                }
            }
        }
        AppMethodBeat.m2505o(84035);
        return videoFilterBase;
    }

    public static List<VideoFilterBase> getSimpleNormalVideoFilter(List<VideoFilterBase> list) {
        AppMethodBeat.m2504i(84036);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.m2505o(84036);
            return arrayList;
        }
        for (VideoFilterBase videoFilterBase : list) {
            if (canUseBlendMode(videoFilterBase)) {
                arrayList.add(videoFilterBase);
            }
        }
        AppMethodBeat.m2505o(84036);
        return arrayList;
    }

    public static boolean maybeTransformFilter(VideoFilterBase videoFilterBase) {
        return videoFilterBase != null && ((videoFilterBase instanceof TransformFilter) || (videoFilterBase instanceof CustomVideoFilter));
    }
}
