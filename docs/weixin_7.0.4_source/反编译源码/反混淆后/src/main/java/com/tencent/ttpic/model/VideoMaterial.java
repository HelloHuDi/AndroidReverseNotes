package com.tencent.ttpic.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoMaterial {
    private String adAppLink;
    private String adIcon;
    private String adLink;
    private List<String> arParticleList;
    private int arParticleType;
    private Audio2Text audio2Text;
    private GameParams audio3DParams;
    private double blendAlpha;
    private int blendMode;
    private int categoryFlag;
    private String dataPath;
    private int detectorFlag;
    private List<DistortionItem> distortionItemList;
    private int environment;
    private FabbyParts fabbyParts;
    private FaceCropItem faceCropItem;
    private int faceDetectType;
    private String faceExchangeImage;
    private FaceExpression faceExpression;
    private List<FaceFeatureItem> faceFeatureItemList;
    private FaceImageLayer faceImageLayer;
    private List<FaceMeshItem> faceMeshItemList;
    private List<FaceMoveItem> faceMoveItemList;
    private int[] faceMoveTriangles;
    private List<FaceItem> faceOffItemList;
    private List<Float> facePoints;
    private int faceSwapType;
    private int faceValueDetectType;
    private int faceoffType;
    private int featureType;
    private double filterBlurStrength;
    private String filterId;
    private boolean flattenEar;
    private boolean flattenNose;
    private float fov;
    private GameParams gameParams;
    private int grayScale;
    private int handBoostEnable;
    private boolean hasAudio;
    private List<StickerItem> headCropItemList;
    /* renamed from: id */
    private String f16565id;
    private String imageFacePointsFileName;
    private List<StickerItem> itemList;
    private List<StickerItem3D> itemList3D;
    private String lipsLutPath;
    private int maxFaceCount;
    private int minAppVersion;
    private List<MultiViewerItem> multiViewerItemList = new ArrayList();
    private boolean needBodyInfo = false;
    private boolean needFaceInfo = true;
    private int orderMode;
    private List<PhantomItem> phantomItemList;
    private int randomGroupCount;
    private boolean resetWhenStartRecord;
    private List<String> resourceList;
    private int segmentFeather;
    private boolean segmentRequired = false;
    private float[] segmentStrokeColor;
    private double segmentStrokeGap;
    private double segmentStrokeWidth;
    private int shaderType;
    private float splitScreen;
    private boolean supportLandscape;
    private boolean supportPause;
    private String tipsIcon;
    private String tipsText;
    private int triggerType;
    private boolean useMesh = false;
    private VideoFilterEffect videoFilterEffect;
    private int voicekind;
    private String weiboTag;

    public VideoMaterial() {
        AppMethodBeat.m2504i(83580);
        AppMethodBeat.m2505o(83580);
    }

    public float getSplitScreen() {
        return this.splitScreen;
    }

    public void setSplitScreen(float f) {
        this.splitScreen = f;
    }

    public boolean isFlattenEar() {
        return this.flattenEar;
    }

    public void setFlattenEar(boolean z) {
        this.flattenEar = z;
    }

    public boolean isFlattenNose() {
        return this.flattenNose;
    }

    public void setFlattenNose(boolean z) {
        this.flattenNose = z;
    }

    public float getFov() {
        return this.fov;
    }

    public void setFov(float f) {
        this.fov = f;
    }

    public GameParams getGameParams() {
        return this.gameParams;
    }

    public void setGameParams(GameParams gameParams) {
        this.gameParams = gameParams;
    }

    public GameParams getAudio3DParams() {
        return this.audio3DParams;
    }

    public void setAudio3DParams(GameParams gameParams) {
        this.audio3DParams = gameParams;
    }

    public FabbyParts getFabbyParts() {
        return this.fabbyParts;
    }

    public void setFabbyParts(FabbyParts fabbyParts) {
        this.fabbyParts = fabbyParts;
    }

    public String getTipsText() {
        return this.tipsText;
    }

    public void setTipsText(String str) {
        this.tipsText = str;
    }

    public String getTipsIcon() {
        return this.tipsIcon;
    }

    public void setTipsIcon(String str) {
        this.tipsIcon = str;
    }

    public FaceImageLayer getFaceImageLayer() {
        return this.faceImageLayer;
    }

    public void setFaceImageLayer(FaceImageLayer faceImageLayer) {
        this.faceImageLayer = faceImageLayer;
    }

    public List<StickerItem> getItemList() {
        return this.itemList;
    }

    public List<StickerItem3D> getItemList3D() {
        return this.itemList3D;
    }

    public void setItemList(List<StickerItem> list) {
        this.itemList = list;
    }

    public void setItemList3D(List<StickerItem3D> list) {
        this.itemList3D = list;
    }

    public List<StickerItem> getHeadCropItemList() {
        return this.headCropItemList;
    }

    public void setHeadCropItemList(List<StickerItem> list) {
        this.headCropItemList = list;
    }

    public List<String> getResourceList() {
        return this.resourceList;
    }

    public void setResourceList(List<String> list) {
        this.resourceList = list;
    }

    public int getMinAppVersion() {
        return this.minAppVersion;
    }

    public void setMinAppVersion(int i) {
        this.minAppVersion = i;
    }

    public int getShaderType() {
        return this.shaderType;
    }

    public void setShaderType(int i) {
        this.shaderType = i;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(int i) {
        if (i > this.triggerType && i < 100) {
            this.triggerType = i;
        }
    }

    public boolean isHasAudio() {
        boolean z;
        AppMethodBeat.m2504i(83581);
        for (MultiViewerItem multiViewerItem : this.multiViewerItemList) {
            z = this.hasAudio || multiViewerItem.videoMaterial.hasAudio;
            this.hasAudio = z;
        }
        z = this.hasAudio;
        AppMethodBeat.m2505o(83581);
        return z;
    }

    public void setHasAudio(boolean z) {
        this.hasAudio = z;
    }

    public String getFaceExchangeImage() {
        return this.faceExchangeImage;
    }

    public void setFaceExchangeImage(String str) {
        this.faceExchangeImage = str;
    }

    public String getImageFacePointsFileName() {
        return this.imageFacePointsFileName;
    }

    public void setImageFacePointsFileName(String str) {
        this.imageFacePointsFileName = str;
    }

    public double getBlendAlpha() {
        return this.blendAlpha;
    }

    public void setBlendAlpha(double d) {
        this.blendAlpha = d;
    }

    public List<DistortionItem> getDistortionItemList() {
        return this.distortionItemList;
    }

    public void setDistortionItemList(List<DistortionItem> list) {
        this.distortionItemList = list;
    }

    public int getVoicekind() {
        return this.voicekind;
    }

    public void setVoicekind(int i) {
        this.voicekind = i;
    }

    public int getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(int i) {
        this.environment = i;
    }

    public List<Float> getFacePoints() {
        return this.facePoints;
    }

    public void setFacePoints(List<Float> list) {
        this.facePoints = list;
    }

    public int getGrayScale() {
        return this.grayScale;
    }

    public void setGrayScale(int i) {
        this.grayScale = i;
    }

    public int getFeatureType() {
        return this.featureType;
    }

    public void setFeatureType(int i) {
        this.featureType = i;
    }

    public void setId(String str) {
        this.f16565id = str;
    }

    public String getId() {
        return this.f16565id;
    }

    public int getMaxFaceCount() {
        return this.maxFaceCount;
    }

    public void setMaxFaceCount(int i) {
        AppMethodBeat.m2504i(83582);
        this.maxFaceCount = Math.max(1, i);
        AppMethodBeat.m2505o(83582);
    }

    public boolean isSupportLandscape() {
        return this.supportLandscape;
    }

    public void setSupportLandscape(boolean z) {
        this.supportLandscape = z;
    }

    public void setFaceMoveItemList(List<FaceMoveItem> list) {
        this.faceMoveItemList = list;
    }

    public List<FaceMoveItem> getFaceMoveItemList() {
        return this.faceMoveItemList;
    }

    public void setFaceMoveTriangles(int[] iArr) {
        this.faceMoveTriangles = iArr;
    }

    public int[] getFaceMoveTriangles() {
        return this.faceMoveTriangles;
    }

    public int getFaceoffType() {
        return this.faceoffType;
    }

    public void setFaceoffType(int i) {
        this.faceoffType = i;
    }

    public void setBlendMode(int i) {
        this.blendMode = i;
    }

    public int getBlendMode() {
        return this.blendMode;
    }

    public int getOrderMode() {
        return this.orderMode;
    }

    public void setOrderMode(int i) {
        this.orderMode = i;
    }

    public void setFaceSwapType(int i) {
        this.faceSwapType = i;
    }

    public int getFaceSwapType() {
        return this.faceSwapType;
    }

    public void setFilterId(String str) {
        this.filterId = str;
    }

    public String getFilterId() {
        return this.filterId;
    }

    public void setVideoFilterEffect(VideoFilterEffect videoFilterEffect) {
        this.videoFilterEffect = videoFilterEffect;
    }

    public VideoFilterEffect getVideoFilterEffect() {
        return this.videoFilterEffect;
    }

    public void setFaceOffItemList(List<FaceItem> list) {
        this.faceOffItemList = list;
    }

    public List<FaceItem> getFaceOffItemList() {
        return this.faceOffItemList;
    }

    public List<FaceMeshItem> getFaceMeshItemList() {
        return this.faceMeshItemList;
    }

    public void setFaceMeshItemList(List<FaceMeshItem> list) {
        this.faceMeshItemList = list;
    }

    public List<String> getArParticleList() {
        return this.arParticleList;
    }

    public void setArParticleList(List<String> list) {
        this.arParticleList = list;
    }

    public int getArParticleType() {
        return this.arParticleType;
    }

    public void setArParticleType(int i) {
        this.arParticleType = i;
    }

    public boolean needFaceInfo() {
        return this.needFaceInfo;
    }

    public void setNeedFaceInfo(boolean z) {
        this.needFaceInfo = z;
    }

    public boolean needBodyInfo() {
        return this.needBodyInfo;
    }

    public void setNeedBodyInfo(boolean z) {
        this.needBodyInfo = z;
    }

    public int getFaceDetectType() {
        return this.faceDetectType;
    }

    public void setFaceDetectType(int i) {
        this.faceDetectType = i;
    }

    public FaceExpression getFaceExpression() {
        return this.faceExpression;
    }

    public void setFaceExpression(FaceExpression faceExpression) {
        this.faceExpression = faceExpression;
    }

    public void setFaceCropItem(FaceCropItem faceCropItem) {
        this.faceCropItem = faceCropItem;
    }

    public FaceCropItem getFaceCropItem() {
        return this.faceCropItem;
    }

    public int getFaceValueDetectType() {
        return this.faceValueDetectType;
    }

    public void setFaceValueDetectType(int i) {
        this.faceValueDetectType = i;
    }

    public boolean isUseMesh() {
        return this.useMesh;
    }

    public void setUseMesh(boolean z) {
        this.useMesh = z;
    }

    public void setDetectorFlag(int i) {
        this.detectorFlag = i;
    }

    public int getDetectorFlag() {
        return this.detectorFlag;
    }

    public boolean isSegmentRequired() {
        return this.segmentRequired;
    }

    public void setSegmentRequired(boolean z) {
        this.segmentRequired = z;
    }

    public void setSegmentFeather(int i) {
        this.segmentFeather = i;
    }

    public int getSegmentFeather() {
        return this.segmentFeather;
    }

    public double getSegmentStrokeWidth() {
        return this.segmentStrokeWidth;
    }

    public void setSegmentStrokeWidth(double d) {
        this.segmentStrokeWidth = d;
    }

    public double getSegmentStrokeGap() {
        return this.segmentStrokeGap;
    }

    public void setSegmentStrokeGap(double d) {
        this.segmentStrokeGap = d;
    }

    public float[] getSegmentStrokeColor() {
        return this.segmentStrokeColor;
    }

    public void setSegmentStrokeColor(float[] fArr) {
        this.segmentStrokeColor = fArr;
    }

    public void setCategoryFlag(int i) {
        this.categoryFlag = i;
    }

    public int getCategoryFlag() {
        return this.categoryFlag;
    }

    public List<MultiViewerItem> getMultiViewerItemList() {
        return this.multiViewerItemList;
    }

    public void setMultiViewerItemList(List<MultiViewerItem> list) {
        this.multiViewerItemList = list;
    }

    public int getRandomGroupCount() {
        return this.randomGroupCount;
    }

    public void setRandomGroupCount(int i) {
        this.randomGroupCount = i;
    }

    public boolean isResetWhenStartRecord() {
        return this.resetWhenStartRecord;
    }

    public void setResetWhenStartRecord(boolean z) {
        this.resetWhenStartRecord = z;
    }

    public boolean isSupportPause() {
        return this.supportPause;
    }

    public void setSupportPause(boolean z) {
        this.supportPause = z;
    }

    public String getAdIcon() {
        return this.adIcon;
    }

    public void setAdIcon(String str) {
        this.adIcon = str;
    }

    public String getAdLink() {
        return this.adLink;
    }

    public void setAdLink(String str) {
        this.adLink = str;
    }

    public String getAdAppLink() {
        return this.adAppLink;
    }

    public void setAdAppLink(String str) {
        this.adAppLink = str;
    }

    public String getWeiboTag() {
        return this.weiboTag;
    }

    public void setWeiboTag(String str) {
        this.weiboTag = str;
    }

    public void setLipsLutPath(String str) {
        this.lipsLutPath = str;
    }

    public String getLipsLutPath() {
        return this.lipsLutPath;
    }

    public void setFilterBlurStrength(double d) {
        this.filterBlurStrength = d;
    }

    public double getFilterBlurStrength() {
        return this.filterBlurStrength;
    }

    public boolean hasAd() {
        AppMethodBeat.m2504i(83583);
        if (TextUtils.isEmpty(this.adIcon) && TextUtils.isEmpty(this.adLink) && TextUtils.isEmpty(this.adAppLink)) {
            AppMethodBeat.m2505o(83583);
            return false;
        }
        AppMethodBeat.m2505o(83583);
        return true;
    }

    public List<PhantomItem> getPhantomItemList() {
        return this.phantomItemList;
    }

    public void setPhantomItemList(List<PhantomItem> list) {
        this.phantomItemList = list;
    }

    public List<FaceFeatureItem> getFaceFeatureItemList() {
        return this.faceFeatureItemList;
    }

    public void setFaceFeatureItemList(List<FaceFeatureItem> list) {
        this.faceFeatureItemList = list;
    }

    public Audio2Text getAudio2Text() {
        return this.audio2Text;
    }

    public void setAudio2Text(Audio2Text audio2Text) {
        this.audio2Text = audio2Text;
    }

    public int getHandBoostEnable() {
        return this.handBoostEnable;
    }

    public void setHandBoostEnable(int i) {
        this.handBoostEnable = i;
    }

    public String toString() {
        AppMethodBeat.m2504i(83584);
        String str = "VideoMaterial{dataPath='" + this.dataPath + '\'' + ", hasAudio=" + this.hasAudio + ", minAppVersion=" + this.minAppVersion + ", shaderType=" + this.shaderType + ", faceoffType=" + this.faceoffType + ", maxFaceCount=" + this.maxFaceCount + ", voicekind=" + this.voicekind + ", environment=" + this.environment + ", resourceList=" + this.resourceList + ", itemList=" + this.itemList + ", itemList3D=" + this.itemList3D + ", faceOffItemList=" + this.faceOffItemList + ", headCropItemList=" + this.headCropItemList + ", distortionItemList=" + this.distortionItemList + ", faceMeshItemList=" + this.faceMeshItemList + ", faceMoveItemList=" + this.faceMoveItemList + ", multiViewerItemList=" + this.multiViewerItemList + ", facePoints=" + this.facePoints + ", triggerType=" + this.triggerType + ", faceExchangeImage='" + this.faceExchangeImage + '\'' + ", imageFacePointsFileName='" + this.imageFacePointsFileName + '\'' + ", blendAlpha=" + this.blendAlpha + ", grayScale=" + this.grayScale + ", orderMode=" + this.orderMode + ", blendMode=" + this.blendMode + ", featureType=" + this.featureType + ", id='" + this.f16565id + '\'' + ", supportLandscape=" + this.supportLandscape + ", randomGroupCount=" + this.randomGroupCount + ", faceMoveTriangles=" + Arrays.toString(this.faceMoveTriangles) + ", filterId='" + this.filterId + '\'' + ", filterBlurStrength='" + this.filterBlurStrength + '\'' + ", videoFilterEffect=" + this.videoFilterEffect + ", faceSwapType=" + this.faceSwapType + ", arParticleType=" + this.arParticleType + ", arParticleList=" + this.arParticleList + ", faceDetectType=" + this.faceDetectType + ", faceExpression=" + this.faceExpression + ", faceImageLayer=" + this.faceImageLayer + ", tipsText='" + this.tipsText + '\'' + ", tipsIcon='" + this.tipsIcon + '\'' + ", faceCropItem=" + this.faceCropItem + ", faceValueDetectType=" + this.faceValueDetectType + ", adIcon='" + this.adIcon + '\'' + ", adLink='" + this.adLink + '\'' + ", adAppLink='" + this.adAppLink + '\'' + ", weiboTag='" + this.weiboTag + '\'' + ", lipsLutPath='" + this.lipsLutPath + '\'' + ", useMesh=" + this.useMesh + ", detectorFlag=" + this.detectorFlag + ", segmentRequired=" + this.segmentRequired + ", segmentStrokeWidth=" + this.segmentStrokeWidth + ", segmentStrokeGap=" + this.segmentStrokeGap + ", segmentStrokeColor=" + Arrays.toString(this.segmentStrokeColor) + ", segmentFeather=" + this.segmentFeather + ", fabbyParts=" + this.fabbyParts + ", categoryFlag=" + this.categoryFlag + ", needFaceInfo=" + this.needFaceInfo + ", fov=" + this.fov + ", gameParams=" + this.gameParams + ", auido2Text=" + this.audio2Text + ", audio3DParams=" + this.audio3DParams + '}';
        AppMethodBeat.m2505o(83584);
        return str;
    }

    public boolean isDBTriggered() {
        AppMethodBeat.m2504i(83585);
        if (this.itemList == null) {
            AppMethodBeat.m2505o(83585);
            return false;
        } else if (hasCustomVideoFilter()) {
            AppMethodBeat.m2505o(83585);
            return true;
        } else {
            for (StickerItem isDBTriggered : this.itemList) {
                if (isDBTriggered.isDBTriggered()) {
                    AppMethodBeat.m2505o(83585);
                    return true;
                }
            }
            AppMethodBeat.m2505o(83585);
            return false;
        }
    }

    private boolean hasCustomVideoFilter() {
        return this.shaderType == 1 || this.shaderType == 2;
    }
}
