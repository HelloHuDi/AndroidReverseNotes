package com.tencent.ttpic.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.json.XML;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.ExpressionItem;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceImageLayer;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ImageWMElement;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMElement.WMType;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.model.WMLogic;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.CANVAS_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.CHARM_RANGE_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.EXPRESSION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_CROP_ITEM;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_CROP_ITEM_FRAME;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_MESH_ITEM_LIST;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_MOVE_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FACE_OFF_ITEM_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.FILTER_EFFECT_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.GAME_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.PARTICLE_CLEAR_MODE;
import com.tencent.ttpic.util.VideoMaterialUtil.PHANTOM_ITEM_FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.TRANSITION;
import com.tencent.ttpic.util.VideoMaterialUtil.WATERMARK_ELEMENT;
import com.tencent.ttpic.util.VideoMaterialUtil.WATERMARK_LOGIC;
import com.tencent.util.C5989g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class VideoTemplateParser {
    public static final String POSTFIX_DAT = "dat";
    private static final String POSTFIX_JSON = "json";
    private static final String TAG = VideoTemplateParser.class.getSimpleName();
    private static final DecryptListener decryptListener = new C365671();
    private static Comparator<Pair<Float, Integer>> mDivideValueComp = new C163683();
    private static Comparator<Pair<Float, ? extends Object>> mDivideValueCompForObject = new C311254();
    private static Comparator<GridModel> mGridModelComparator = new C365686();
    private static Comparator<Pair<Float, Double>> mRangeValueComp = new C245025();

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$2 */
    static class C163672 implements Comparator<StickerItem> {
        C163672() {
        }

        public final int compare(StickerItem stickerItem, StickerItem stickerItem2) {
            return stickerItem.zIndex - stickerItem2.zIndex;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$3 */
    static class C163683 implements Comparator<Pair<Float, Integer>> {
        C163683() {
        }

        public final int compare(Pair<Float, Integer> pair, Pair<Float, Integer> pair2) {
            AppMethodBeat.m2504i(84231);
            int compareTo = ((Float) pair.first).compareTo((Float) pair2.first);
            AppMethodBeat.m2505o(84231);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$5 */
    static class C245025 implements Comparator<Pair<Float, Double>> {
        C245025() {
        }

        public final int compare(Pair<Float, Double> pair, Pair<Float, Double> pair2) {
            AppMethodBeat.m2504i(84235);
            int compareTo = ((Float) pair.first).compareTo((Float) pair2.first);
            AppMethodBeat.m2505o(84235);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$4 */
    static class C311254 implements Comparator<Pair<Float, ? extends Object>> {
        C311254() {
        }

        public final int compare(Pair<Float, ? extends Object> pair, Pair<Float, ? extends Object> pair2) {
            AppMethodBeat.m2504i(84233);
            int compareTo = ((Float) pair.first).compareTo((Float) pair2.first);
            AppMethodBeat.m2505o(84233);
            return compareTo;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$1 */
    static class C365671 implements DecryptListener {
        C365671() {
        }

        public final byte[] decrypt(byte[] bArr) {
            AppMethodBeat.m2504i(84229);
            byte[] drink = Coffee.drink(bArr, Coffee.getDefaultSign());
            AppMethodBeat.m2505o(84229);
            return drink;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoTemplateParser$6 */
    static class C365686 implements Comparator<GridModel> {
        C365686() {
        }

        public final int compare(GridModel gridModel, GridModel gridModel2) {
            return gridModel.zIndex - gridModel2.zIndex;
        }
    }

    static {
        AppMethodBeat.m2504i(84278);
        AppMethodBeat.m2505o(84278);
    }

    public static VideoMaterial parseVideoMaterial(String str) {
        AppMethodBeat.m2504i(84238);
        VideoMaterial parseVideoMaterial = parseVideoMaterial(str, "params", true, decryptListener);
        AppMethodBeat.m2505o(84238);
        return parseVideoMaterial;
    }

    public static VideoMaterial parseVideoMaterial(String str, String str2, boolean z, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84239);
        VideoMaterial parseVideoMaterial = parseVideoMaterial(str, parseVideoMaterialFileAsJSONObject(str, str2, z, decryptListener), decryptListener);
        AppMethodBeat.m2505o(84239);
        return parseVideoMaterial;
    }

    public static VideoMaterial parseVideoMaterial(String str, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84240);
        VideoMaterial parseVideoMaterial = parseVideoMaterial(null, parseVideoMaterialString(str, decryptListener), decryptListener);
        AppMethodBeat.m2505o(84240);
        return parseVideoMaterial;
    }

    public static VideoMaterial parseVideoMaterial(String str, String str2, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84241);
        VideoMaterial parseVideoMaterial = parseVideoMaterial(str, parseVideoMaterialString(str2, decryptListener), decryptListener);
        AppMethodBeat.m2505o(84241);
        return parseVideoMaterial;
    }

    public static Object getVideoMaterialField(String str, FIELD field) {
        Object obj = null;
        AppMethodBeat.m2504i(84242);
        JSONObject parseVideoMaterialFileAsJSONObject = parseVideoMaterialFileAsJSONObject(str, "params", true, decryptListener);
        if (parseVideoMaterialFileAsJSONObject == null) {
            AppMethodBeat.m2505o(84242);
        } else {
            try {
                obj = parseVideoMaterialFileAsJSONObject.get(field.value);
            } catch (JSONException e) {
            }
            AppMethodBeat.m2505o(84242);
        }
        return obj;
    }

    private static VideoMaterial parseVideoMaterial(String str, JSONObject jSONObject, DecryptListener decryptListener) {
        boolean z = false;
        AppMethodBeat.m2504i(84243);
        VideoMaterial videoMaterial = new VideoMaterial();
        videoMaterial.setDataPath(str);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(84243);
        } else {
            int i;
            boolean i2;
            parseBasicParams(str, jSONObject, videoMaterial);
            if (!TextUtils.isEmpty(jSONObject.optString(GAME_FIELD.GAME_NAME.value))) {
                parseGameParams(jSONObject, videoMaterial);
            }
            if (!TextUtils.isEmpty(jSONObject.optString(GAME_FIELD.GAME_NAME.value))) {
                parseAudio3DParams(jSONObject, videoMaterial);
            }
            parseResourceListParams(jSONObject, videoMaterial);
            int[] iArr = new int[]{0};
            boolean[] zArr = new boolean[]{false};
            List parseItemListParams = parseItemListParams(str, jSONObject.optJSONArray(FIELD.ITEM_LIST.value), STICKER_TYPE.NORMAL.type, videoMaterial, videoMaterial.getBlendMode(), zArr, iArr, decryptListener);
            videoMaterial.setTriggerType(iArr[0]);
            videoMaterial.setItemList(parseItemListParams);
            if (zArr[0]) {
                i2 = 1;
            } else {
                i2 = false;
            }
            boolean[] zArr2 = new boolean[]{false};
            parse3DItemListParams(str, jSONObject, videoMaterial, zArr2);
            if (i2 != 0 || zArr2[0]) {
                i2 = true;
            } else {
                i2 = false;
            }
            parseHeadCropItemListParams(jSONObject, videoMaterial);
            videoMaterial.setDistortionItemList(parseDistortionItemListParams(jSONObject.optJSONArray(FIELD.DISTORTION_LIST.value)));
            parseFaceMoveItemListParams(jSONObject, videoMaterial);
            parseFaceMoveTrianglesParams(jSONObject, videoMaterial);
            parseFacePointsListParams(jSONObject, videoMaterial);
            parseFilterEffectParams(jSONObject, videoMaterial);
            List parseFaceOffItemListParams = parseFaceOffItemListParams(jSONObject.optJSONArray(FIELD.FACE_OFF_ITEM_LIST.value));
            if (!TextUtils.isEmpty(videoMaterial.getFaceExchangeImage())) {
                parseFaceOffItemListParams.add(new FaceItem(videoMaterial.getFaceExchangeImage(), (float) videoMaterial.getBlendAlpha(), videoMaterial.getGrayScale(), videoMaterial.getFeatureType(), videoMaterial.getFacePoints()));
            }
            videoMaterial.setFaceOffItemList(parseFaceOffItemListParams);
            parseFaceMeshItemListParams(jSONObject, videoMaterial);
            parseFaceMeshItemListParams(jSONObject, videoMaterial);
            parseFaceImageLayerParams(jSONObject, videoMaterial);
            parseArParticleListParams(jSONObject, videoMaterial);
            zArr2 = new boolean[]{false};
            parseFaceExpressionParams(jSONObject, videoMaterial, zArr2);
            if (i2 || zArr2[0]) {
                z = true;
            }
            parseFaceCropParams(jSONObject, videoMaterial);
            videoMaterial.setHasAudio(z);
            parseFabbyMvItems(str, jSONObject, videoMaterial, decryptListener);
            parseSegmentParams(jSONObject, videoMaterial);
            parseFaceFeatureItemListParams(str, jSONObject, videoMaterial, decryptListener);
            parsePhantomItemListParams(jSONObject, videoMaterial);
            parseAudio2TextParams(jSONObject, videoMaterial);
            VideoMaterialUtil.updateSupportLandscape(videoMaterial);
            VideoMaterialUtil.updateMaxFaceCount(videoMaterial);
            VideoMaterialUtil.updateFaceValueDetectType(videoMaterial);
            VideoMaterialUtil.updateItemImageType(videoMaterial);
            VideoMaterialUtil.updateWatermarkInfo(videoMaterial);
            VideoMaterialUtil.updateNeedFaceInfo(videoMaterial);
            VideoMaterialUtil.updateNeedBodyInfo(videoMaterial);
            try {
                checkValid(videoMaterial);
            } catch (IllegalArgumentException e) {
            }
            AppMethodBeat.m2505o(84243);
        }
        return videoMaterial;
    }

    private static void parsePhantomItemListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84244);
        JSONArray optJSONArray = jSONObject.optJSONArray("phantomItemList");
        if (optJSONArray == null) {
            videoMaterial.setPhantomItemList(new ArrayList());
            AppMethodBeat.m2505o(84244);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                PhantomItem parsePhantomItem = parsePhantomItem(optJSONObject, videoMaterial);
                if (parsePhantomItem != null) {
                    arrayList.add(parsePhantomItem);
                }
            }
        }
        videoMaterial.setPhantomItemList(arrayList);
        AppMethodBeat.m2505o(84244);
    }

    private static PhantomItem parsePhantomItem(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84245);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(84245);
            return null;
        }
        PhantomItem phantomItem = new PhantomItem();
        phantomItem.setDataPath(videoMaterial.getDataPath());
        phantomItem.setId(jSONObject.optString(PHANTOM_ITEM_FIELD.ID.value));
        phantomItem.setMaskImage(jSONObject.optString(PHANTOM_ITEM_FIELD.MASK_IMAGE.value));
        phantomItem.setBlendMode(jSONObject.optInt(PHANTOM_ITEM_FIELD.BLEND_MODE.value));
        phantomItem.setScale(jSONObject.optDouble(PHANTOM_ITEM_FIELD.SCALE.value));
        phantomItem.setOpacity(jSONObject.optDouble(PHANTOM_ITEM_FIELD.OPACITY.value));
        phantomItem.setxK(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_K.value));
        phantomItem.setxAsin(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_A_SIN.value));
        phantomItem.setxBcos(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_B_COS.value));
        phantomItem.setxPhase(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_PHASE.value));
        phantomItem.setxOffset(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_OFFSET.value));
        phantomItem.setxStep(jSONObject.optDouble(PHANTOM_ITEM_FIELD.X_STEP.value));
        double[] dArr = new double[]{0.0d, 360.0d};
        JSONArray optJSONArray = jSONObject.optJSONArray(PHANTOM_ITEM_FIELD.X_RANGE.value);
        if (optJSONArray != null) {
            dArr[0] = optJSONArray.optDouble(0);
            dArr[1] = optJSONArray.optDouble(1);
        }
        phantomItem.setxRange(dArr);
        phantomItem.setyK(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_K.value));
        phantomItem.setyAsin(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_A_SIN.value));
        phantomItem.setyBcos(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_B_COS.value));
        phantomItem.setyPhase(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_PHASE.value));
        phantomItem.setyOffset(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_OFFSET.value));
        phantomItem.setyStep(jSONObject.optDouble(PHANTOM_ITEM_FIELD.Y_STEP.value));
        JSONArray optJSONArray2 = jSONObject.optJSONArray(PHANTOM_ITEM_FIELD.Y_RANGE.value);
        double[] dArr2 = new double[]{0.0d, 360.0d};
        if (optJSONArray2 != null) {
            dArr2[0] = optJSONArray2.optDouble(0);
            dArr2[1] = optJSONArray2.optDouble(1);
        }
        phantomItem.setyRange(dArr2);
        AppMethodBeat.m2505o(84245);
        return phantomItem;
    }

    private static void parseFaceFeatureItemListParams(String str, JSONObject jSONObject, VideoMaterial videoMaterial, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84246);
        JSONArray optJSONArray = jSONObject.optJSONArray("faceFeatureItemList");
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(84246);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                FaceFeatureItem parseFaceFeatureItem = parseFaceFeatureItem(str, optJSONObject, videoMaterial, decryptListener);
                if (parseFaceFeatureItem != null) {
                    arrayList.add(parseFaceFeatureItem);
                }
            }
        }
        videoMaterial.setFaceFeatureItemList(arrayList);
        AppMethodBeat.m2505o(84246);
    }

    private static FaceFeatureItem parseFaceFeatureItem(String str, JSONObject jSONObject, VideoMaterial videoMaterial, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84247);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(84247);
            return null;
        }
        int lastIndexOf;
        JSONObject parseVideoMaterialFileAsJSONObject;
        JSONArray optJSONArray;
        List parseDistortionItemListParams;
        FaceFeatureItem faceFeatureItem = new FaceFeatureItem();
        faceFeatureItem.setId(jSONObject.optString("id"));
        faceFeatureItem.setMaskAnchorPoint(jSONObject.optInt("maskAnchorPoint", -1));
        String str2 = str.endsWith("/") ? str : str + "/" + faceFeatureItem.getId();
        faceFeatureItem.setDataPath(str2);
        String optString = jSONObject.optString("distortionFile");
        if (!TextUtils.isEmpty(optString)) {
            lastIndexOf = optString.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                optString = optString.substring(0, lastIndexOf);
            }
            parseVideoMaterialFileAsJSONObject = parseVideoMaterialFileAsJSONObject(str2, optString, true, decryptListener);
            if (parseVideoMaterialFileAsJSONObject != null) {
                optJSONArray = parseVideoMaterialFileAsJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_DISTORTION_LIST);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    parseDistortionItemListParams = parseDistortionItemListParams(optJSONArray);
                    if (parseDistortionItemListParams != null) {
                        faceFeatureItem.setDistortionItemList(parseDistortionItemListParams);
                    }
                }
            }
        }
        optString = jSONObject.optString("faceOffFile");
        if (!TextUtils.isEmpty(optString)) {
            lastIndexOf = optString.lastIndexOf(".");
            if (lastIndexOf >= 0) {
                optString = optString.substring(0, lastIndexOf);
            }
            parseVideoMaterialFileAsJSONObject = parseVideoMaterialFileAsJSONObject(str2, optString, true, decryptListener);
            if (parseVideoMaterialFileAsJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(parseVideoMaterialFileAsJSONObject);
                parseDistortionItemListParams = parseFaceOffItemListParams(jSONArray);
                if (parseDistortionItemListParams != null) {
                    faceFeatureItem.setFaceOffItemList(parseDistortionItemListParams);
                }
            }
        }
        optJSONArray = jSONObject.optJSONArray("itemList");
        if (optJSONArray != null) {
            List parseItemListParams = parseItemListParams(str2, optJSONArray, STICKER_TYPE.FACE_FEATURE.type, videoMaterial, videoMaterial.getBlendMode(), null, null, decryptListener);
            if (parseItemListParams != null) {
                Collections.sort(parseItemListParams, new C163672());
                faceFeatureItem.setStickerItems(parseItemListParams);
            }
        }
        AppMethodBeat.m2505o(84247);
        return faceFeatureItem;
    }

    private static void parseSegmentParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84248);
        videoMaterial.setSegmentFeather(jSONObject.optInt("SegmentFeathering", 0));
        videoMaterial.setSegmentRequired(jSONObject.optInt("SegmentRequired", 0) == 1);
        videoMaterial.setSegmentStrokeWidth(jSONObject.optDouble("SegmentStrokeWidth", 0.0d));
        videoMaterial.setSegmentStrokeGap(jSONObject.optDouble("SegmentStrokeGap", 0.0d));
        String optString = jSONObject.optString("SegmentStrokeColor", "");
        if (!TextUtils.isEmpty(optString)) {
            int parseColor;
            try {
                parseColor = Color.parseColor(optString);
            } catch (Exception e) {
                parseColor = 0;
            }
            videoMaterial.setSegmentStrokeColor(new float[]{((float) Color.red(parseColor)) / 255.0f, ((float) Color.green(parseColor)) / 255.0f, ((float) Color.blue(parseColor)) / 255.0f, ((float) Color.alpha(parseColor)) / 255.0f});
        }
        AppMethodBeat.m2505o(84248);
    }

    private static void parseBasicParams(String str, JSONObject jSONObject, VideoMaterial videoMaterial) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(84249);
        videoMaterial.setId(VideoMaterialUtil.getMaterialId(str));
        videoMaterial.setMinAppVersion(jSONObject.optInt(FIELD.MIN_APP_VERSION.value));
        videoMaterial.setCategoryFlag(jSONObject.optInt(FIELD.CATEGORY_FLAG.value, 0));
        videoMaterial.setShaderType(jSONObject.optInt(FIELD.SHADER_TYPE.value));
        videoMaterial.setFaceoffType(jSONObject.optInt(FIELD.FACE_OFF_TYPE.value));
        videoMaterial.setFaceSwapType(jSONObject.optInt(FIELD.FACE_SWAP_TYPE.value));
        videoMaterial.setMaxFaceCount(jSONObject.optInt(FIELD.MAX_FACE_COUNT.value));
        videoMaterial.setResetWhenStartRecord(jSONObject.optInt(FIELD.RESET_WHEN_START_RECORD.value, 0) == 1);
        if (jSONObject.optInt(FIELD.SUPPORT_PAUSE.value, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        videoMaterial.setSupportPause(z);
        videoMaterial.setVoicekind(jSONObject.optInt(FIELD.VOICE_KIND.value, VideoMaterialUtil.INVALID_INT_FIELD_VALUE));
        videoMaterial.setEnvironment(jSONObject.optInt(FIELD.ENVIRONMENT.value, VideoMaterialUtil.INVALID_INT_FIELD_VALUE));
        videoMaterial.setFaceExchangeImage(jSONObject.optString(FIELD.FACE_EXCHANGE_IMAGE.value));
        videoMaterial.setImageFacePointsFileName(jSONObject.optString(FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
        videoMaterial.setBlendAlpha(jSONObject.optDouble(FIELD.BLEND_ALPHA.value));
        videoMaterial.setGrayScale(jSONObject.optInt(FIELD.GRAY_SCALE.value));
        videoMaterial.setOrderMode(jSONObject.optInt(FIELD.ORDER_MODE.value));
        videoMaterial.setBlendMode(jSONObject.optInt(FIELD.BLEND_MODE.value));
        videoMaterial.setFeatureType(jSONObject.optInt(FIELD.FEATURE_TYPE.value));
        videoMaterial.setFilterId(jSONObject.optString(FIELD.FILTER_ID.value));
        videoMaterial.setFilterBlurStrength(jSONObject.optDouble(FIELD.FILTER_BLUR_STRENGTH.value, 0.0d));
        videoMaterial.setArParticleType(jSONObject.optInt(FIELD.AR_PARTICLE_TYPE.value));
        videoMaterial.setSupportLandscape(jSONObject.optInt(FIELD.SUPPORT_LANDSCAPE.value, 1) == 1);
        videoMaterial.setRandomGroupCount(jSONObject.optInt(FIELD.RANDOM_GROUP_COUNT.value));
        videoMaterial.setTipsText(jSONObject.optString(FIELD.TIPS_TEXT.value));
        videoMaterial.setTipsIcon(jSONObject.optString(FIELD.TIPS_ICON.value));
        videoMaterial.setHandBoostEnable(jSONObject.optInt(FIELD.HAND_BOOST_ENABLE.value));
        if (jSONObject.optInt(FIELD.USE_MESH.value, 0) == 0) {
            z2 = false;
        }
        videoMaterial.setUseMesh(z2);
        if (!TextUtils.isEmpty(jSONObject.optString(FIELD.AD_ICON.value))) {
            videoMaterial.setAdIcon(str + File.separator + jSONObject.optString(FIELD.AD_ICON.value));
        }
        videoMaterial.setAdLink(jSONObject.optString(FIELD.AD_LINK.value));
        videoMaterial.setAdAppLink(jSONObject.optString(FIELD.AD_APP_LINK.value));
        videoMaterial.setWeiboTag(jSONObject.optString("weiboTag"));
        videoMaterial.setDetectorFlag(jSONObject.optInt(FIELD.DETECTOR_FLAG.value));
        videoMaterial.setLipsLutPath(jSONObject.optString(FIELD.LIPS_LUT.value));
        videoMaterial.setSplitScreen((float) jSONObject.optDouble(FIELD.SPLIT_SCREEN.value, 0.0d));
        AppMethodBeat.m2505o(84249);
    }

    private static void parseResourceListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84250);
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.RESOURCE_LIST.value);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            videoMaterial.setResourceList(arrayList);
        }
        AppMethodBeat.m2505o(84250);
    }

    private static void parseFaceCropParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84251);
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(FIELD.FACE_CROP.value);
            if (optJSONObject != null) {
                FaceCropItem faceCropItem = new FaceCropItem();
                faceCropItem.frameDuration = optJSONObject.optInt(FACE_CROP_ITEM.FRAME_DURATION.value);
                faceCropItem.frames = optJSONObject.optInt(FACE_CROP_ITEM.FRAMES.value);
                faceCropItem.frameList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray(FACE_CROP_ITEM.FRAME_LIST.value);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        CropFrame cropFrame = new CropFrame();
                        cropFrame.faceAngle = jSONObject2.optDouble(FACE_CROP_ITEM_FRAME.FACE_ANGLE.value);
                        cropFrame.faceWidth = jSONObject2.optDouble(FACE_CROP_ITEM_FRAME.FACE_WIDTH.value);
                        cropFrame.index = jSONObject2.optInt(FACE_CROP_ITEM_FRAME.INDEX.value);
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray(FACE_CROP_ITEM_FRAME.NOSE_POINT.value);
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            cropFrame.noseX = optJSONArray2.getDouble(0);
                            cropFrame.noseY = optJSONArray2.getDouble(1);
                        }
                        JSONArray optJSONArray3 = jSONObject2.optJSONArray(FACE_CROP_ITEM_FRAME.SIZE.value);
                        if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                            cropFrame.width = optJSONArray3.getDouble(0);
                            cropFrame.height = optJSONArray3.getDouble(1);
                        }
                        faceCropItem.frameList.add(cropFrame);
                    }
                }
                videoMaterial.setFaceCropItem(faceCropItem);
            }
            AppMethodBeat.m2505o(84251);
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
            AppMethodBeat.m2505o(84251);
        }
    }

    private static void parseFaceExpressionParams(JSONObject jSONObject, VideoMaterial videoMaterial, boolean[] zArr) {
        AppMethodBeat.m2504i(84252);
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD.FACE_EXPRESSION.value);
        if (optJSONObject != null) {
            int i;
            JSONArray optJSONArray;
            FaceExpression faceExpression = new FaceExpression();
            faceExpression.f16559id = optJSONObject.optString(FACE_EXPRESSION_ITEM_FILED.ID.value);
            faceExpression.videoID = optJSONObject.optString(FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
            faceExpression.frameDuration = optJSONObject.optDouble(FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
            faceExpression.frames = optJSONObject.optInt(FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
            faceExpression.audioID = optJSONObject.optString(FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
            zArr[0] = !TextUtils.isEmpty(faceExpression.audioID);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray(FACE_EXPRESSION_ITEM_FILED.CANVAS_SIZE.value);
            if (optJSONArray2 != null && optJSONArray2.length() == 2) {
                faceExpression.canvasSize = new SizeI();
                faceExpression.canvasSize.width = optJSONArray2.optInt(0);
                faceExpression.canvasSize.height = optJSONArray2.optInt(1);
            }
            faceExpression.canvasResizeMode = optJSONObject.optInt(FACE_EXPRESSION_ITEM_FILED.CANVAS_RESIZE_MODE.value);
            faceExpression.scoreImageID = optJSONObject.optString(FACE_EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
            faceExpression.expressionNumber = optJSONObject.optInt(FACE_EXPRESSION_ITEM_FILED.EXPRESSION_NUMBER.value);
            JSONArray optJSONArray3 = optJSONObject.optJSONArray(FACE_EXPRESSION_ITEM_FILED.EXPRESSION_LIST.value);
            if (optJSONArray3 != null) {
                faceExpression.expressionList = new ArrayList();
                for (i = 0; i < optJSONArray3.length(); i++) {
                    ExpressionItem expressionItem = new ExpressionItem();
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        int i2;
                        expressionItem.expressionTime = optJSONObject2.optInt(EXPRESSION_ITEM_FILED.EXPRESSION_TIME.value);
                        expressionItem.expressionID = optJSONObject2.optString(EXPRESSION_ITEM_FILED.EXPRESSION_ID.value);
                        optJSONArray = optJSONObject2.optJSONArray(EXPRESSION_ITEM_FILED.EXPRESSION_FEAT_SIZE.value);
                        if (optJSONArray != null && optJSONArray.length() == 2) {
                            expressionItem.expressionFeatSize = new SizeI();
                            expressionItem.expressionFeatSize.width = optJSONArray.optInt(0);
                            expressionItem.expressionFeatSize.height = optJSONArray.optInt(1);
                        }
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray(EXPRESSION_ITEM_FILED.EXPRESSION_FEAT.value);
                        if (optJSONArray4 != null) {
                            expressionItem.expressionFeat = new ArrayList();
                            for (i2 = 0; i2 < optJSONArray4.length() / 2; i2++) {
                                expressionItem.expressionFeat.add(new PointF((float) optJSONArray4.optInt(i2 * 2), (float) optJSONArray4.optInt((i2 * 2) + 1)));
                            }
                        }
                        optJSONArray = optJSONObject2.optJSONArray(EXPRESSION_ITEM_FILED.EXPRESSION_ANGLE.value);
                        if (optJSONArray != null && optJSONArray.length() == 3) {
                            expressionItem.expressionAngle = new float[3];
                            expressionItem.expressionAngle[0] = (float) optJSONArray.optDouble(0);
                            expressionItem.expressionAngle[1] = (float) optJSONArray.optDouble(1);
                            expressionItem.expressionAngle[2] = (float) optJSONArray.optDouble(2);
                        }
                        expressionItem.scoreImageID = optJSONObject2.optString(EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
                        JSONArray optJSONArray5 = optJSONObject2.optJSONArray(EXPRESSION_ITEM_FILED.EXPRESSION_WEIGHT.value);
                        if (optJSONArray5 == null || optJSONArray5.length() != 7) {
                            expressionItem.expressionWeight = ActUtil.WEIGHT;
                        } else {
                            expressionItem.expressionWeight = new double[7];
                            for (i2 = 0; i2 < 7; i2++) {
                                expressionItem.expressionWeight[i2] = optJSONArray5.optDouble(i2);
                            }
                        }
                        faceExpression.expressionList.add(expressionItem);
                    }
                }
            }
            optJSONArray = optJSONObject.optJSONArray(FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
            if (optJSONArray != null) {
                faceExpression.canvasItemList = new ArrayList();
                for (i = 0; i < optJSONArray.length(); i++) {
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        CanvasItem canvasItem = new CanvasItem();
                        canvasItem.type = optJSONObject.optInt(CANVAS_ITEM_FILED.TYPE.value);
                        canvasItem.index = optJSONObject.optInt(CANVAS_ITEM_FILED.INDEX.value);
                        canvasItem.startTime = optJSONObject.optInt(CANVAS_ITEM_FILED.START_TIME.value);
                        canvasItem.endTime = optJSONObject.optInt(CANVAS_ITEM_FILED.END_TIME.value);
                        canvasItem.zIndex = optJSONObject.optInt(CANVAS_ITEM_FILED.Z_INDEX.value);
                        JSONArray optJSONArray6 = optJSONObject.optJSONArray(CANVAS_ITEM_FILED.ITEM_RECT.value);
                        if (optJSONArray6 != null && optJSONArray6.length() == 4) {
                            canvasItem.itemRect = new Rect();
                            canvasItem.itemRect.f1681x = optJSONArray6.optInt(0);
                            canvasItem.itemRect.f1682y = optJSONArray6.optInt(1);
                            canvasItem.itemRect.width = optJSONArray6.optInt(2);
                            canvasItem.itemRect.height = optJSONArray6.optInt(3);
                        }
                        canvasItem.itemResizeMode = optJSONObject.optInt(CANVAS_ITEM_FILED.ITEM_RESIZE_MODE.value);
                        faceExpression.canvasItemList.add(canvasItem);
                    }
                }
            }
            videoMaterial.setFaceExpression(faceExpression);
        }
        AppMethodBeat.m2505o(84252);
    }

    private static void parseArParticleListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84253);
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.AR_PARTICLE_LIST.value);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
            videoMaterial.setArParticleList(arrayList);
        }
        AppMethodBeat.m2505o(84253);
    }

    private static void parseFaceImageLayerParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        int i = 0;
        AppMethodBeat.m2504i(84254);
        JSONObject optJSONObject = jSONObject.optJSONObject("faceAverage");
        if (optJSONObject != null) {
            ArrayList arrayList;
            int i2;
            FaceImageLayer faceImageLayer = new FaceImageLayer();
            faceImageLayer.width = optJSONObject.optDouble("width");
            faceImageLayer.height = optJSONObject.optDouble("height");
            faceImageLayer.f16560x = optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_X);
            faceImageLayer.f16561y = optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_Y);
            faceImageLayer.type = optJSONObject.optInt("type");
            faceImageLayer.imagePath = optJSONObject.optString("image");
            JSONArray optJSONArray = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_POINTS);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Double.valueOf(optJSONArray.optDouble(i2)));
                }
                faceImageLayer.imageFacePoint = arrayList;
            }
            optJSONArray = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_COLOR);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Double.valueOf(optJSONArray.optDouble(i2)));
                }
                faceImageLayer.imageFaceColor = arrayList;
            }
            optJSONArray = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_COLOR2);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Double.valueOf(optJSONArray.optDouble(i2)));
                }
                faceImageLayer.imageFaceColor2 = arrayList;
            }
            optJSONArray = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_COLOR_RANGE);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Double.valueOf(optJSONArray.optDouble(i2)));
                }
                faceImageLayer.faceColorRange = arrayList;
            }
            faceImageLayer.blendAlpha = optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA, 0.5d);
            faceImageLayer.distortionAlpha = optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_DISTORTION_ALPHA, 0.5d);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_DISTORTION_LIST);
            if (optJSONArray2 != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    Object opt = optJSONArray2.opt(i3);
                    if (opt instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) opt;
                        DistortionItem distortionItem = new DistortionItem();
                        distortionItem.position = jSONObject2.optInt(DISTORTION_ITEM_FILED.POSITION.value);
                        distortionItem.distortion = jSONObject2.optInt(DISTORTION_ITEM_FILED.DISTORTION.value);
                        distortionItem.direction = jSONObject2.optInt(DISTORTION_ITEM_FILED.DIRECTION.value);
                        distortionItem.radius = (float) jSONObject2.optDouble(DISTORTION_ITEM_FILED.RADIUS.value);
                        distortionItem.strength = (float) jSONObject2.optDouble(DISTORTION_ITEM_FILED.STRENGH.value);
                        distortionItem.f18267x = jSONObject2.optInt(DISTORTION_ITEM_FILED.X.value, 0);
                        distortionItem.f18268y = jSONObject2.optInt(DISTORTION_ITEM_FILED.Y.value, 0);
                        arrayList2.add(distortionItem);
                    }
                }
                faceImageLayer.distortionList = arrayList2;
            }
            faceImageLayer.faceMaskImagePath = optJSONObject.optString(VideoMaterialUtil.CRAZYFACE_FACE_MASK, null);
            optJSONArray = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_MASK_POINTS);
            if (optJSONArray != null) {
                arrayList = new ArrayList();
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(Double.valueOf(optJSONArray.optDouble(i2)));
                }
                faceImageLayer.faceMaskFacePoint = arrayList;
            }
            JSONArray optJSONArray3 = optJSONObject.optJSONArray(VideoMaterialUtil.CRAZYFACE_FACE_RIANGLE);
            if (optJSONArray3 != null) {
                ArrayList arrayList3 = new ArrayList();
                while (i < optJSONArray3.length()) {
                    arrayList3.add(Integer.valueOf(optJSONArray3.optInt(i)));
                    i++;
                }
                faceImageLayer.faceTriangle = arrayList3;
            }
            faceImageLayer.antiWrinkle = optJSONObject.optDouble(VideoMaterialUtil.CRAZYFACE_ANTI_WRINKLE);
            videoMaterial.setFaceImageLayer(faceImageLayer);
        }
        AppMethodBeat.m2505o(84254);
    }

    private static void parseFaceMeshItemListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84255);
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.FACE_MESH_ITEM_LIST.value);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    FaceMeshItem faceMeshItem = new FaceMeshItem();
                    faceMeshItem.f14331id = optJSONObject.optString(FACE_MESH_ITEM_LIST.ID.value);
                    faceMeshItem.personID = optJSONObject.optInt(FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
                    faceMeshItem.frames = optJSONObject.optInt(FACE_MESH_ITEM_LIST.FRAMES.value);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(FIELD.CHARM_RANGE.value);
                    if (optJSONObject2 != null) {
                        faceMeshItem.charmRange = new CharmRange();
                        faceMeshItem.charmRange.min = optJSONObject2.optDouble(CHARM_RANGE_FIELD.MIN.value);
                        faceMeshItem.charmRange.max = optJSONObject2.optDouble(CHARM_RANGE_FIELD.MAX.value);
                    }
                    faceMeshItem.frameType = optJSONObject.optInt("frameType");
                    faceMeshItem.frameDuration = optJSONObject.optDouble("frameDuration");
                    faceMeshItem.triggerType = Math.max(optJSONObject.optInt("triggerType"), 2);
                    if (VideoMaterialUtil.isActionTriggerType(faceMeshItem.triggerType)) {
                        videoMaterial.setTriggerType(faceMeshItem.triggerType);
                    }
                    faceMeshItem.alwaysTriggered = optJSONObject.optInt("alwaysTriggered") == 1;
                    faceMeshItem.featureStatType = optJSONObject.optInt("featureStatType");
                    optJSONObject2 = optJSONObject.optJSONObject("featureStatValueRange");
                    if (optJSONObject2 != null) {
                        faceMeshItem.featureStatValueRange = new ValueRange();
                        faceMeshItem.featureStatValueRange.min = optJSONObject2.optDouble("min");
                        faceMeshItem.featureStatValueRange.max = optJSONObject2.optDouble("max");
                    }
                    arrayList.add(faceMeshItem);
                }
            }
            videoMaterial.setFaceMeshItemList(arrayList);
        }
        AppMethodBeat.m2505o(84255);
    }

    private static List<FaceItem> parseFaceOffItemListParams(JSONArray jSONArray) {
        AppMethodBeat.m2504i(84256);
        ArrayList<FaceItem> arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int i2 = -1;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    FaceItem faceItem = new FaceItem();
                    faceItem.f3494id = optJSONObject.optString(FACE_OFF_ITEM_FIELD.ID.value);
                    faceItem.faceExchangeImage = optJSONObject.optString(FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE.value);
                    faceItem.irisImage = optJSONObject.optString(FACE_OFF_ITEM_FIELD.IRIS_IMAGE.value);
                    faceItem.blendAlpha = (float) optJSONObject.optDouble(FACE_OFF_ITEM_FIELD.BLEND_ALPHA.value);
                    faceItem.featureType = FaceOffUtil.getFeatureType(optJSONObject.optInt(FACE_OFF_ITEM_FIELD.FEATURE_TYPE.value));
                    faceItem.grayScale = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.GRAY_SCALE.value);
                    faceItem.blendMode = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.BLEND_MODE.value);
                    faceItem.personID = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.PERSON_ID.value, -1);
                    faceItem.randomGroupNum = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.RANDOM_GROUP_NUM.value);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
                    if (optJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                            arrayList2.add(Float.valueOf((float) optJSONArray.optDouble(i4)));
                        }
                        faceItem.facePoints = arrayList2;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(FIELD.CHARM_RANGE.value);
                    if (optJSONObject2 != null) {
                        faceItem.charmRange = new CharmRange();
                        faceItem.charmRange.min = optJSONObject2.optDouble(CHARM_RANGE_FIELD.MIN.value);
                        faceItem.charmRange.max = optJSONObject2.optDouble(CHARM_RANGE_FIELD.MAX.value);
                    }
                    faceItem.frameType = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.FRAME_TYPE.value);
                    faceItem.frames = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.FRAMES.value);
                    faceItem.frameDuration = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.FRAME_DURATION.value);
                    faceItem.width = optJSONObject.optInt("width");
                    faceItem.height = optJSONObject.optInt("height");
                    faceItem.triggerType = optJSONObject.optInt(FACE_OFF_ITEM_FIELD.TRIGGER_TYPE.value, PTExpression.FACE_DETECT.value);
                    faceItem.alwaysTriggered = optJSONObject.optInt("alwaysTriggered", 1) == 1;
                    faceItem.featureStatType = optJSONObject.optInt("featureStatType");
                    optJSONObject2 = optJSONObject.optJSONObject("featureStatValueRange");
                    if (optJSONObject2 != null) {
                        faceItem.featureStatValueRange = new ValueRange();
                        faceItem.featureStatValueRange.min = optJSONObject2.optDouble("min");
                        faceItem.featureStatValueRange.max = optJSONObject2.optDouble("max");
                    }
                    faceItem.activateTriggerType = optJSONObject.optInt("activateTriggerType", 0);
                    faceItem.activateTriggerCount = optJSONObject.optInt("activateTriggerCount", 0);
                    faceItem.activateTriggerTotalCount = optJSONObject.optInt("activateTriggerTotalCount", 0);
                    faceItem.playCount = optJSONObject.optInt("playCount");
                    faceItem.preTriggerType = faceItem.triggerType;
                    faceItem.countTriggerType = faceItem.triggerType;
                    if (i2 == -1) {
                        i2 = faceItem.triggerType;
                    } else {
                        i = Math.max(i, faceItem.triggerType);
                    }
                    arrayList.add(faceItem);
                }
            }
            for (FaceItem faceItem2 : arrayList) {
                faceItem2.preTriggerType = i2;
                faceItem2.countTriggerType = i;
            }
        }
        AppMethodBeat.m2505o(84256);
        return arrayList;
    }

    private static void parseFilterEffectParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84257);
        JSONObject optJSONObject = jSONObject.optJSONObject(FIELD.FILTER_EFFECT.value);
        if (optJSONObject != null) {
            VideoFilterEffect videoFilterEffect = new VideoFilterEffect();
            videoFilterEffect.type = optJSONObject.optInt(FILTER_EFFECT_FIELD.TYPE.value);
            videoFilterEffect.order = optJSONObject.optInt(FILTER_EFFECT_FIELD.ORDER.value);
            videoMaterial.setVideoFilterEffect(videoFilterEffect);
        }
        AppMethodBeat.m2505o(84257);
    }

    private static void parseFacePointsListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84258);
        JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.FACE_POINTS_LIST.value);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(Float.valueOf((float) optJSONArray.optDouble(i)));
            }
            videoMaterial.setFacePoints(arrayList);
        }
        AppMethodBeat.m2505o(84258);
    }

    private static void parseFaceMoveTrianglesParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84259);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.FACE_MOVE_TRIANGLE.value);
            if (optJSONArray != null) {
                int[] iArr = new int[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    iArr[i] = optJSONArray.getInt(i);
                }
                videoMaterial.setFaceMoveTriangles(iArr);
            }
            AppMethodBeat.m2505o(84259);
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
            AppMethodBeat.m2505o(84259);
        }
    }

    private static void parseFaceMoveItemListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84260);
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.FACE_MOVE_LIST.value);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FaceMoveItem faceMoveItem = new FaceMoveItem();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    faceMoveItem.position = jSONObject2.optInt(FACE_MOVE_ITEM_FILED.POSITION.value);
                    faceMoveItem.pos1 = jSONObject2.optInt(FACE_MOVE_ITEM_FILED.POS1.value);
                    faceMoveItem.pos2 = jSONObject2.optInt(FACE_MOVE_ITEM_FILED.POS2.value);
                    faceMoveItem.ratio1 = (float) jSONObject2.optDouble(FACE_MOVE_ITEM_FILED.RATIO1.value);
                    faceMoveItem.ratio2 = (float) jSONObject2.optDouble(FACE_MOVE_ITEM_FILED.RATIO2.value);
                    faceMoveItem.f15466dx = jSONObject2.optInt(FACE_MOVE_ITEM_FILED.X.value);
                    faceMoveItem.f15467dy = jSONObject2.optInt(FACE_MOVE_ITEM_FILED.Y.value);
                    arrayList.add(faceMoveItem);
                }
                videoMaterial.setFaceMoveItemList(arrayList);
            }
            AppMethodBeat.m2505o(84260);
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
            AppMethodBeat.m2505o(84260);
        }
    }

    private static List<DistortionItem> parseDistortionItemListParams(JSONArray jSONArray) {
        AppMethodBeat.m2504i(84261);
        if (jSONArray != null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    DistortionItem distortionItem = new DistortionItem();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    distortionItem.position = jSONObject.optInt(DISTORTION_ITEM_FILED.POSITION.value);
                    distortionItem.distortion = jSONObject.optInt(DISTORTION_ITEM_FILED.DISTORTION.value);
                    distortionItem.direction = jSONObject.optInt(DISTORTION_ITEM_FILED.DIRECTION.value);
                    distortionItem.radius = (float) jSONObject.optDouble(DISTORTION_ITEM_FILED.RADIUS.value);
                    distortionItem.strength = (float) jSONObject.optDouble(DISTORTION_ITEM_FILED.STRENGH.value);
                    distortionItem.f18267x = jSONObject.optInt(DISTORTION_ITEM_FILED.X.value);
                    distortionItem.f18268y = jSONObject.optInt(DISTORTION_ITEM_FILED.Y.value);
                    arrayList.add(distortionItem);
                }
                AppMethodBeat.m2505o(84261);
                return arrayList;
            } catch (JSONException e) {
                LogUtils.m50205e(TAG, e);
            }
        }
        AppMethodBeat.m2505o(84261);
        return null;
    }

    private static void parseHeadCropItemListParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84262);
        try {
            ArrayList<StickerItem> arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
            if (optJSONArray != null) {
                int i = -1;
                int i2 = 0;
                int i3 = 0;
                while (i3 < optJSONArray.length()) {
                    int i4;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.f18271id = jSONObject2.optString("id");
                    stickerItem.subFolder = stickerItem.f18271id;
                    stickerItem.type = jSONObject2.optInt("type");
                    stickerItem.triggerType = jSONObject2.optInt("triggerType");
                    stickerItem.alwaysTriggered = jSONObject2.optInt("alwaysTriggered") == 1;
                    stickerItem.featureStatType = jSONObject2.optInt("featureStatType");
                    stickerItem.playCount = jSONObject2.optInt("playCount");
                    if (VideoMaterialUtil.isActionTriggerType(stickerItem.triggerType)) {
                        videoMaterial.setTriggerType(stickerItem.triggerType);
                    }
                    stickerItem.frameType = jSONObject2.optInt("frameType");
                    stickerItem.frameDuration = jSONObject2.optDouble("frameDuration");
                    stickerItem.frames = jSONObject2.optInt("frames");
                    stickerItem.width = jSONObject2.optInt("width");
                    stickerItem.height = jSONObject2.optInt("height");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("position");
                    if (optJSONArray2 != null) {
                        stickerItem.position = new double[optJSONArray2.length()];
                        for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                            stickerItem.position[i4] = optJSONArray2.getDouble(i4);
                        }
                    } else {
                        stickerItem.position = new double[]{0.0d, 0.0d};
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("scalePivots");
                    if (optJSONArray2 != null) {
                        stickerItem.scalePivots = new int[optJSONArray2.length()];
                        for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                            stickerItem.scalePivots[i4] = optJSONArray2.getInt(i4);
                        }
                    }
                    stickerItem.scaleFactor = jSONObject2.optInt("scaleFactor");
                    stickerItem.blendMode = jSONObject2.optInt("blendMode", -1);
                    if (stickerItem.blendMode == -1) {
                        stickerItem.blendMode = videoMaterial.getBlendMode();
                    }
                    stickerItem.support3D = jSONObject2.optInt("enable3D", 1);
                    stickerItem.personID = jSONObject2.optInt("personID", -1);
                    stickerItem.activateTriggerCount = jSONObject2.optInt("activateTriggerCount", 0);
                    stickerItem.activateTriggerTotalCount = jSONObject2.optInt("activateTriggerTotalCount", 0);
                    arrayList.add(stickerItem);
                    if (i == -1) {
                        i = stickerItem.triggerType;
                        i4 = i2;
                    } else {
                        i4 = Math.max(i2, stickerItem.triggerType);
                    }
                    i3++;
                    i2 = i4;
                }
                for (StickerItem stickerItem2 : arrayList) {
                    stickerItem2.preTriggerType = i;
                    stickerItem2.countTriggerType = i2;
                }
                videoMaterial.setHeadCropItemList(arrayList);
            }
            AppMethodBeat.m2505o(84262);
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
            AppMethodBeat.m2505o(84262);
        }
    }

    /* JADX WARNING: Missing block: B:73:0x0243, code skipped:
            if (r18.contains("/files/olm/camera/video_") != false) goto L_0x0245;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parse3DItemListParams(String str, JSONObject jSONObject, VideoMaterial videoMaterial, boolean[] zArr) {
        AppMethodBeat.m2504i(84263);
        try {
            ArrayList<StickerItem3D> arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("itemList3D");
            if (optJSONArray != null) {
                StickerItem3D stickerItem3D;
                int i = 0;
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    int i3;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    StickerItem3D stickerItem3D2 = new StickerItem3D();
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(WMElement.ANIMATE_TYPE_SCALE);
                    if (optJSONArray2 != null) {
                        stickerItem3D2.nodeScale = new float[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.nodeScale[i3] = (float) optJSONArray2.getDouble(i3);
                        }
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("position");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.nodePosition = new float[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.nodePosition[i3] = (float) optJSONArray2.getDouble(i3);
                        }
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("eulerAngles");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.nodeEulerAngles = new float[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.nodeEulerAngles[i3] = (float) optJSONArray2.getDouble(i3);
                        }
                    }
                    stickerItem3D2.f18271id = jSONObject2.optString("id");
                    stickerItem3D2.frames = jSONObject2.optInt("frames");
                    stickerItem3D2.frameDuration = jSONObject2.optDouble("frameDuration");
                    if (stickerItem3D2.frames > 0) {
                        NodeParameter nodeParameter = new NodeParameter();
                        nodeParameter.nodeId = stickerItem3D2.f18271id;
                        nodeParameter.frames = stickerItem3D2.frames;
                        nodeParameter.frameDuration = (int) stickerItem3D2.frameDuration;
                        stickerItem3D2.nodeParameter = nodeParameter;
                    }
                    if (stickerItem3D2.f18271id.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                        String[] split = stickerItem3D2.f18271id.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if (split.length == 2) {
                            stickerItem3D2.subFolder = split[1];
                        }
                    } else {
                        stickerItem3D2.subFolder = stickerItem3D2.f18271id;
                    }
                    stickerItem3D2.name = jSONObject2.optString("name");
                    stickerItem3D2.type = jSONObject2.optInt("type");
                    stickerItem3D2.personID = jSONObject2.optInt("personID", -1);
                    stickerItem3D2.featureStatType = jSONObject2.optInt("featureStatType");
                    stickerItem3D2.frameType = jSONObject2.optInt("frameType");
                    stickerItem3D2.blendMode = jSONObject2.optInt("blendMode", -1);
                    stickerItem3D2.zIndex = jSONObject2.optInt("zIndex", 0);
                    stickerItem3D2.audioLoopCount = jSONObject2.optInt("audioLoopCount", -1);
                    JSONObject optJSONObject = jSONObject2.optJSONObject(FIELD.CHARM_RANGE.value);
                    if (optJSONObject != null) {
                        stickerItem3D2.charmRange = new CharmRange();
                        stickerItem3D2.charmRange.min = optJSONObject.optDouble(CHARM_RANGE_FIELD.MIN.value);
                        stickerItem3D2.charmRange.max = optJSONObject.optDouble(CHARM_RANGE_FIELD.MAX.value);
                    }
                    if (stickerItem3D2.blendMode == -1) {
                        stickerItem3D2.blendMode = videoMaterial.getBlendMode();
                    }
                    stickerItem3D2.triggerType = jSONObject2.optInt("triggerType");
                    if (VideoMaterialUtil.isActionTriggerType(stickerItem3D2.triggerType)) {
                        videoMaterial.setTriggerType(stickerItem3D2.triggerType);
                    }
                    stickerItem3D2.alwaysTriggered = jSONObject2.optInt("alwaysTriggered") == 1;
                    stickerItem3D2.playCount = jSONObject2.optInt("playCount");
                    stickerItem3D2.stickerType = jSONObject2.optInt("stickerType", 0);
                    if (stickerItem3D2.stickerType == STICKER_TYPE.VIDEO_UP_DOWN.type || stickerItem3D2.stickerType == STICKER_TYPE.VIDEO_LEFT_RIGHT.type) {
                        stickerItem3D2.sourceType = stickerItem3D2.stickerType == STICKER_TYPE.VIDEO_UP_DOWN.type ? ITEM_SOURCE_TYPE.VIDEO_UP_DOWN : ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
                    }
                    stickerItem3D2.width = jSONObject2.optInt("width");
                    stickerItem3D2.height = jSONObject2.optInt("height");
                    stickerItem3D2.support3D = jSONObject2.optInt("enable3D", 1);
                    optJSONArray2 = jSONObject2.optJSONArray("position");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.position = new double[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.position[i3] = optJSONArray2.getDouble(i3);
                        }
                    } else {
                        stickerItem3D2.position = new double[]{0.0d, 0.0d};
                    }
                    stickerItem3D2.audio = jSONObject2.optString(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (!(TextUtils.isEmpty(stickerItem3D2.audio) || TextUtils.isEmpty(str))) {
                        if (!str.startsWith("assets://camera/camera_video/video_")) {
                        }
                        zArr[0] = true;
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("anchorPoint");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.anchorPoint = new int[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.anchorPoint[i3] = optJSONArray2.getInt(i3);
                        }
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("alignFacePoints");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.alignFacePoints = new int[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.alignFacePoints[i3] = optJSONArray2.getInt(i3);
                        }
                    }
                    optJSONArray2 = jSONObject2.optJSONArray("scalePivots");
                    if (optJSONArray2 != null) {
                        stickerItem3D2.scalePivots = new int[optJSONArray2.length()];
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            stickerItem3D2.scalePivots[i3] = optJSONArray2.getInt(i3);
                        }
                    }
                    stickerItem3D2.scaleFactor = jSONObject2.optInt("scaleFactor");
                    stickerItem3D2.markMode = jSONObject2.optInt("markMode");
                    stickerItem3D2.activateTriggerType = jSONObject2.optInt("activateTriggerType", 0);
                    stickerItem3D2.activateTriggerCount = jSONObject2.optInt("activateTriggerCount", 0);
                    stickerItem3D2.activateTriggerTotalCount = jSONObject2.optInt("activateTriggerTotalCount", 0);
                    optJSONObject = jSONObject2.optJSONObject("ageRange");
                    if (optJSONObject != null) {
                        stickerItem3D2.ageRange = new AgeRange();
                        stickerItem3D2.ageRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem3D2.ageRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject2.optJSONObject("genderRange");
                    if (optJSONObject != null) {
                        stickerItem3D2.genderRange = new GenderRange();
                        stickerItem3D2.genderRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem3D2.genderRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject2.optJSONObject("popularRange");
                    if (optJSONObject != null) {
                        stickerItem3D2.popularRange = new PopularRange();
                        stickerItem3D2.popularRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem3D2.popularRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject2.optJSONObject("cpRange");
                    if (optJSONObject != null) {
                        stickerItem3D2.cpRange = new CpRange();
                        stickerItem3D2.cpRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem3D2.cpRange.max = (float) optJSONObject.optDouble("max");
                    }
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(FIELD.WATERMARK_GROUP.value);
                    if (optJSONArray3 != null) {
                        WMGroup wMGroup = new WMGroup();
                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                            JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i4);
                            if (optJSONObject2 != null) {
                                WMElement textWMElement;
                                int optInt = optJSONObject2.optInt(WATERMARK_ELEMENT.WMTYPE.value);
                                if (optInt == WMType.TEXT.value) {
                                    textWMElement = new TextWMElement();
                                } else {
                                    textWMElement = new ImageWMElement();
                                }
                                textWMElement.dataPath = videoMaterial.getDataPath();
                                textWMElement.sid = videoMaterial.getId();
                                textWMElement.f16566id = optJSONObject2.optString(WATERMARK_ELEMENT.ID.value);
                                textWMElement.relativeID = optJSONObject2.optString(WATERMARK_ELEMENT.RELATIVE_ID.value);
                                JSONArray optJSONArray4 = optJSONObject2.optJSONArray(WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
                                if (optJSONArray4 == null || optJSONArray4.length() != 2) {
                                    textWMElement.relativeAnchor = new PointF(0.0f, 0.0f);
                                } else {
                                    textWMElement.relativeAnchor = new PointF((float) optJSONArray4.getDouble(0), (float) optJSONArray4.getDouble(1));
                                }
                                optJSONArray4 = optJSONObject2.optJSONArray(WATERMARK_ELEMENT.ANCHOR.value);
                                if (optJSONArray4 == null || optJSONArray4.length() != 2) {
                                    textWMElement.anchor = new PointF(0.0f, 0.0f);
                                } else {
                                    textWMElement.anchor = new PointF((float) optJSONArray4.getDouble(0), (float) optJSONArray4.getDouble(1));
                                }
                                textWMElement.offsetX = optJSONObject2.optInt(WATERMARK_ELEMENT.OFFSETX.value);
                                textWMElement.offsetY = optJSONObject2.optInt(WATERMARK_ELEMENT.OFFSETY.value);
                                textWMElement.width = optJSONObject2.optInt(WATERMARK_ELEMENT.WIDTH.value);
                                textWMElement.height = optJSONObject2.optInt(WATERMARK_ELEMENT.HEIGHT.value);
                                textWMElement.wmtype = optInt;
                                textWMElement.edittype = optJSONObject2.optInt(WATERMARK_ELEMENT.EDITTYPE.value);
                                textWMElement.fmtstr = optJSONObject2.optString(WATERMARK_ELEMENT.FMTSTR.value);
                                textWMElement.fontName = optJSONObject2.optString(WATERMARK_ELEMENT.FONT_NAME.value);
                                textWMElement.fontBold = optJSONObject2.optInt(WATERMARK_ELEMENT.FONT_BOLD.value) == 1;
                                textWMElement.fontItalics = optJSONObject2.optInt(WATERMARK_ELEMENT.FONT_ITALICS.value) == 1;
                                textWMElement.fontTexture = optJSONObject2.optString(WATERMARK_ELEMENT.FONT_TEXTURE.value);
                                textWMElement.fontSize = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.FONT_SIZE.value, 60.0d);
                                textWMElement.fontFit = optJSONObject2.optInt(WATERMARK_ELEMENT.FONT_FIT.value);
                                textWMElement.kern = optJSONObject2.optInt(WATERMARK_ELEMENT.KERN.value);
                                textWMElement.imgPath = optJSONObject2.optString(WATERMARK_ELEMENT.IMG_PATH.value);
                                textWMElement.frameDuration = optJSONObject2.optInt(WATERMARK_ELEMENT.FRAME_DURATION.value);
                                textWMElement.frames = optJSONObject2.optInt(WATERMARK_ELEMENT.FRAMES.value);
                                textWMElement.color = optJSONObject2.optString(WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
                                textWMElement.strokeColor = optJSONObject2.optString(WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
                                textWMElement.strokeSize = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0d);
                                textWMElement.shadowColor = optJSONObject2.optString(WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
                                textWMElement.shadowSize = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0d);
                                textWMElement.shadowDx = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.SHADOW_DX.value, -1.0d);
                                textWMElement.shadowDy = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.SHADOW_DY.value, -1.0d);
                                textWMElement.alignment = optJSONObject2.optString(WATERMARK_ELEMENT.ALIGNMENT.value);
                                textWMElement.vertical = optJSONObject2.optInt(WATERMARK_ELEMENT.VERTICAL.value);
                                textWMElement.outerStrokeColor = optJSONObject2.optString(WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
                                textWMElement.outerStrokeSize = (float) optJSONObject2.optDouble(WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0d);
                                textWMElement.shaderBmp = optJSONObject2.optString(WATERMARK_ELEMENT.SHADER_BMP.value, null);
                                textWMElement.emboss = optJSONObject2.optInt(WATERMARK_ELEMENT.EMBOSS.value, 0) == 1;
                                textWMElement.multiRow = optJSONObject2.optInt(WATERMARK_ELEMENT.MULTI_ROW.value, 0) == 1;
                                textWMElement.animateType = optJSONObject2.optString(WATERMARK_ELEMENT.ANIMATE_TYPE.value);
                                optJSONObject2 = optJSONObject2.optJSONObject(WATERMARK_ELEMENT.LOGIC.value);
                                if (optJSONObject2 != null) {
                                    String str2;
                                    WMLogic wMLogic = new WMLogic();
                                    wMLogic.type = optJSONObject2.optString(WATERMARK_LOGIC.TYPE.value);
                                    wMLogic.setCompare(optJSONObject2.optString(WATERMARK_LOGIC.COMPARE.value), textWMElement.sid);
                                    wMLogic.data = optJSONObject2.optString(WATERMARK_LOGIC.DATA.value);
                                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(WATERMARK_LOGIC.RANGE.value);
                                    if (optJSONObject3 != null) {
                                        wMLogic.range = new ArrayList();
                                        Iterator keys = optJSONObject3.keys();
                                        while (keys.hasNext()) {
                                            str2 = (String) keys.next();
                                            wMLogic.range.add(new WMLogicPair(str2, optJSONObject3.optString(str2)));
                                        }
                                        Collections.sort(wMLogic.range);
                                    }
                                    optJSONObject2 = optJSONObject2.optJSONObject(WATERMARK_LOGIC.CASE.value);
                                    if (optJSONObject2 != null) {
                                        wMLogic.wmcase = new ArrayList();
                                        Iterator keys2 = optJSONObject2.keys();
                                        while (keys2.hasNext()) {
                                            str2 = (String) keys2.next();
                                            wMLogic.wmcase.add(new WMLogicPair(str2, optJSONObject2.optString(str2)));
                                        }
                                    }
                                    textWMElement.logic = wMLogic;
                                }
                                wMGroup.wmElements.add(textWMElement);
                            }
                        }
                        stickerItem3D2.wmGroup = wMGroup;
                    }
                    stickerItem3D2.preTriggerType = stickerItem3D2.triggerType;
                    arrayList.add(stickerItem3D2);
                    i = stickerItem3D2.triggerType;
                }
                for (StickerItem3D stickerItem3D3 : arrayList) {
                    if (stickerItem3D3.activateTriggerType == 0) {
                        stickerItem3D3.countTriggerType = i;
                    } else {
                        stickerItem3D3.playCount = 0;
                        stickerItem3D3.countTriggerType = PTExpression.MV_PART_INDEX.value;
                    }
                }
                videoMaterial.setItemList3D(arrayList);
                GameParams gameParams = videoMaterial.getGameParams();
                if (gameParams != null) {
                    for (i = 0; i < arrayList.size(); i++) {
                        stickerItem3D3 = (StickerItem3D) arrayList.get(i);
                        Object obj = null;
                        String str3 = "";
                        if (stickerItem3D3.nodePosition == null || stickerItem3D3.nodePosition.length != 3) {
                            str3 = str3 + "0/0/0/";
                        } else {
                            obj = 1;
                            for (float f : stickerItem3D3.nodePosition) {
                                str3 = str3 + f + "/";
                            }
                        }
                        if (stickerItem3D3.f18271id.equals("head")) {
                            str3 = str3 + "180/0/0/";
                        } else if (stickerItem3D3.nodeEulerAngles == null || stickerItem3D3.nodeEulerAngles.length != 3) {
                            str3 = str3 + "0/0/0/";
                        } else {
                            obj = 1;
                            for (float f2 : stickerItem3D3.nodeEulerAngles) {
                                str3 = str3 + f2 + "/";
                            }
                        }
                        if (stickerItem3D3.nodeScale == null || stickerItem3D3.nodeScale.length != 3) {
                            str3 = str3 + "1/1/1/";
                        } else {
                            obj = 1;
                            for (float f22 : stickerItem3D3.nodeScale) {
                                str3 = str3 + f22 + "/";
                            }
                        }
                        if (obj != null) {
                            gameParams.nodeInitialTransform += stickerItem3D3.f18271id.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0] + "/" + str3;
                        }
                    }
                    if (!TextUtils.isEmpty(gameParams.nodeInitialTransform)) {
                        gameParams.nodeInitialTransform = gameParams.nodeInitialTransform.substring(0, gameParams.nodeInitialTransform.length() - 1);
                    }
                }
            }
            AppMethodBeat.m2505o(84263);
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
            AppMethodBeat.m2505o(84263);
        }
    }

    private static List<StickerItem> parseItemListParams(String str, JSONArray jSONArray, int i, VideoMaterial videoMaterial, int i2, boolean[] zArr, int[] iArr, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84264);
        try {
            ArrayList<StickerItem> arrayList = new ArrayList();
            if (jSONArray != null) {
                int i3 = 0;
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    int i5;
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.f18271id = jSONObject.optString("id");
                    stickerItem.subFolder = stickerItem.f18271id;
                    stickerItem.name = jSONObject.optString("name");
                    stickerItem.type = jSONObject.optInt("type");
                    stickerItem.scale = (float) jSONObject.optDouble(WMElement.ANIMATE_TYPE_SCALE, 1.0d);
                    stickerItem.angle = (float) jSONObject.optDouble("angle", 0.0d);
                    stickerItem.f18269dx = jSONObject.optInt("dx", 0);
                    stickerItem.f18270dy = jSONObject.optInt("dy", 0);
                    stickerItem.personID = jSONObject.optInt("personID", -1);
                    stickerItem.featureStatType = jSONObject.optInt("featureStatType");
                    stickerItem.frameType = jSONObject.optInt("frameType");
                    stickerItem.blendMode = jSONObject.optInt("blendMode", -1);
                    stickerItem.zIndex = jSONObject.optInt("zIndex");
                    stickerItem.audioLoopCount = jSONObject.optInt("audioLoopCount", -1);
                    stickerItem.randomGroupNum = jSONObject.optInt("randomGroupNum");
                    JSONObject optJSONObject = jSONObject.optJSONObject("featureStatValueRange");
                    if (optJSONObject != null) {
                        stickerItem.featureStatValueRange = new ValueRange();
                        stickerItem.featureStatValueRange.min = optJSONObject.optDouble("min");
                        stickerItem.featureStatValueRange.max = optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject.optJSONObject(FIELD.CHARM_RANGE.value);
                    if (optJSONObject != null) {
                        stickerItem.charmRange = new CharmRange();
                        stickerItem.charmRange.min = optJSONObject.optDouble(CHARM_RANGE_FIELD.MIN.value);
                        stickerItem.charmRange.max = optJSONObject.optDouble(CHARM_RANGE_FIELD.MAX.value);
                    }
                    if (stickerItem.blendMode == -1) {
                        stickerItem.blendMode = i2;
                    }
                    stickerItem.triggerType = jSONObject.optInt("triggerType");
                    stickerItem.audioTriggerType = jSONObject.optInt("audioTriggerType");
                    stickerItem.audioNeedAdjust = jSONObject.optInt("audioNeedAdjust", 1) == 1;
                    optJSONObject = jSONObject.optJSONObject("audioValueRange");
                    if (optJSONObject != null) {
                        stickerItem.audioValueRange = new ValueRange();
                        stickerItem.audioValueRange.min = optJSONObject.optDouble("min");
                        stickerItem.audioValueRange.max = optJSONObject.optDouble("max");
                    }
                    if (VideoMaterialUtil.isActionTriggerType(stickerItem.triggerType) && iArr != null) {
                        iArr[0] = stickerItem.triggerType;
                    }
                    stickerItem.alwaysTriggered = jSONObject.optInt("alwaysTriggered") == 1;
                    stickerItem.playCount = jSONObject.optInt("playCount");
                    stickerItem.frameDuration = jSONObject.optDouble("frameDuration");
                    stickerItem.stickerType = jSONObject.optInt("stickerType", i);
                    if (stickerItem.stickerType == STICKER_TYPE.VIDEO_UP_DOWN.type || stickerItem.stickerType == STICKER_TYPE.VIDEO_LEFT_RIGHT.type) {
                        stickerItem.sourceType = stickerItem.stickerType == STICKER_TYPE.VIDEO_UP_DOWN.type ? ITEM_SOURCE_TYPE.VIDEO_UP_DOWN : ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
                    }
                    stickerItem.frames = jSONObject.optInt("frames");
                    stickerItem.width = jSONObject.optInt("width");
                    stickerItem.height = jSONObject.optInt("height");
                    stickerItem.support3D = jSONObject.optInt("enable3D", 1);
                    stickerItem.scaleDirection = jSONObject.optInt("scaleDirection");
                    JSONArray optJSONArray = jSONObject.optJSONArray("position");
                    if (optJSONArray != null) {
                        stickerItem.position = new double[optJSONArray.length()];
                        for (i5 = 0; i5 < optJSONArray.length(); i5++) {
                            stickerItem.position[i5] = optJSONArray.getDouble(i5);
                        }
                    } else {
                        stickerItem.position = new double[]{0.0d, 0.0d};
                    }
                    stickerItem.audio = jSONObject.optString(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (!(TextUtils.isEmpty(stickerItem.audio) || zArr == null)) {
                        zArr[0] = true;
                    }
                    optJSONArray = jSONObject.optJSONArray("anchorPoint");
                    if (optJSONArray != null) {
                        stickerItem.anchorPoint = new int[optJSONArray.length()];
                        for (i5 = 0; i5 < optJSONArray.length(); i5++) {
                            stickerItem.anchorPoint[i5] = optJSONArray.getInt(i5);
                        }
                    }
                    optJSONArray = jSONObject.optJSONArray("anchorPointAudio");
                    if (optJSONArray != null) {
                        stickerItem.anchorPointAudio = new double[optJSONArray.length()];
                        for (i5 = 0; i5 < optJSONArray.length(); i5++) {
                            stickerItem.anchorPointAudio[i5] = optJSONArray.getDouble(i5);
                        }
                    } else {
                        stickerItem.anchorPointAudio = new double[]{0.5d, 0.5d};
                    }
                    optJSONArray = jSONObject.optJSONArray("alignFacePoints");
                    if (optJSONArray != null) {
                        stickerItem.alignFacePoints = new int[optJSONArray.length()];
                        for (i5 = 0; i5 < optJSONArray.length(); i5++) {
                            stickerItem.alignFacePoints[i5] = optJSONArray.getInt(i5);
                        }
                    }
                    optJSONArray = jSONObject.optJSONArray("scalePivots");
                    if (optJSONArray != null) {
                        stickerItem.scalePivots = new int[optJSONArray.length()];
                        for (i5 = 0; i5 < optJSONArray.length(); i5++) {
                            stickerItem.scalePivots[i5] = optJSONArray.getInt(i5);
                        }
                    }
                    stickerItem.scaleFactor = jSONObject.optInt("scaleFactor");
                    stickerItem.originalScaleFactor = stickerItem.scaleFactor;
                    stickerItem.markMode = jSONObject.optInt("markMode");
                    stickerItem.activateTriggerType = jSONObject.optInt("activateTriggerType", 0);
                    stickerItem.activateTriggerCount = jSONObject.optInt("activateTriggerCount", 0);
                    stickerItem.activateTriggerTotalCount = jSONObject.optInt("activateTriggerTotalCount", 0);
                    stickerItem.bodyTriggerPoint = jSONObject.optInt("bodyTriggerPoint", 0);
                    stickerItem.bodyTriggerDirection = jSONObject.optInt("bodyTriggerDirection", 0);
                    stickerItem.bodyTriggerDistance = jSONObject.optInt("bodyTriggerDistance", 0);
                    stickerItem.bodyTriggerTimeGap = jSONObject.optDouble("bodyTriggerTimeGap", 0.0d);
                    optJSONObject = jSONObject.optJSONObject("ageRange");
                    if (optJSONObject != null) {
                        stickerItem.ageRange = new AgeRange();
                        stickerItem.ageRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem.ageRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject.optJSONObject("genderRange");
                    if (optJSONObject != null) {
                        stickerItem.genderRange = new GenderRange();
                        stickerItem.genderRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem.genderRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject.optJSONObject("popularRange");
                    if (optJSONObject != null) {
                        stickerItem.popularRange = new PopularRange();
                        stickerItem.popularRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem.popularRange.max = (float) optJSONObject.optDouble("max");
                    }
                    optJSONObject = jSONObject.optJSONObject("cpRange");
                    if (optJSONObject != null) {
                        stickerItem.cpRange = new CpRange();
                        stickerItem.cpRange.min = (float) optJSONObject.optDouble("min");
                        stickerItem.cpRange.max = (float) optJSONObject.optDouble("max");
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("audioScaleFactor");
                    if (optJSONObject2 != null) {
                        Iterator keys = optJSONObject2.keys();
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            stickerItem.audioScaleFactorMap.add(Pair.create(Float.valueOf(str2), Double.valueOf(optJSONObject2.optDouble(str2, 0.0d))));
                        }
                    }
                    Collections.sort(stickerItem.audioScaleFactorMap, mRangeValueComp);
                    optJSONObject2 = jSONObject.optJSONObject("transition");
                    if (optJSONObject2 != null) {
                        stickerItem.transition = new Transition();
                        stickerItem.transition.particleCountMax = optJSONObject2.optInt(TRANSITION.PARTICLE_COUNT_MAX.value);
                        stickerItem.transition.life = optJSONObject2.optString(TRANSITION.LIFE.value);
                        stickerItem.transition.emissionMode = optJSONObject2.optInt(TRANSITION.EMISSION_MODE.value);
                        stickerItem.transition.particleAlwaysUpdate = optJSONObject2.optInt(TRANSITION.PARTICLE_ALWAYS_UPDATE.value) == 1;
                        stickerItem.transition.emissionRate = (float) optJSONObject2.optInt(TRANSITION.EMISSION_RATE.value);
                        stickerItem.transition.scale = optJSONObject2.optString(TRANSITION.SCALE.value);
                        stickerItem.transition.rotate = optJSONObject2.optString(TRANSITION.ROTATE.value);
                        stickerItem.transition.positionX = optJSONObject2.optString(TRANSITION.POSITION_X.value);
                        stickerItem.transition.positionY = optJSONObject2.optString(TRANSITION.POSITION_Y.value);
                        stickerItem.transition.f18272p0 = optJSONObject2.optString(TRANSITION.P0.value);
                        stickerItem.transition.f18273p1 = optJSONObject2.optString(TRANSITION.P1.value);
                        stickerItem.transition.f18274p2 = optJSONObject2.optString(TRANSITION.P2.value);
                        stickerItem.transition.repeatCount = optJSONObject2.optInt(TRANSITION.REPEAT_COUNT.value, 1);
                        stickerItem.transition.minUpdateInterval = optJSONObject2.optInt(TRANSITION.MIN_UPDATE_INTERVAL.value, 1);
                        stickerItem.transition.clearMode = optJSONObject2.optInt(TRANSITION.CLEAR_MODE.value, 0);
                        JSONArray optJSONArray2 = jSONObject.optJSONArray(FIELD.WATERMARK_GROUP.value);
                        if (optJSONArray2 != null) {
                            stickerItem.wmGroupCopies = new ArrayList();
                            i3 = 0;
                            while (true) {
                                if (i3 >= (stickerItem.transition.clearMode == PARTICLE_CLEAR_MODE.CLEAR_ALL.value ? 1 : 0) + (stickerItem.transition.particleCountMax / stickerItem.transition.repeatCount)) {
                                    break;
                                }
                                WMGroup parseWMGroup = parseWMGroup(optJSONArray2, videoMaterial);
                                parseWMGroup.f4886id = i3;
                                stickerItem.wmGroupCopies.add(parseWMGroup);
                                i3++;
                            }
                        }
                    } else {
                        JSONArray optJSONArray3 = jSONObject.optJSONArray(FIELD.WATERMARK_GROUP.value);
                        if (optJSONArray3 != null) {
                            stickerItem.wmGroup = parseWMGroup(optJSONArray3, videoMaterial);
                        }
                    }
                    stickerItem.triggerWords = jSONObject.optString("triggerWords");
                    stickerItem.preTriggerType = stickerItem.triggerType;
                    arrayList.add(stickerItem);
                    i3 = stickerItem.triggerType;
                    stickerItem.particleConfig = parseParticleConfig(str + File.separator + stickerItem.f18271id, jSONObject.optString("dexName"), decryptListener);
                }
                for (StickerItem stickerItem2 : arrayList) {
                    if (stickerItem2.activateTriggerType == 0) {
                        stickerItem2.countTriggerType = i3;
                    } else {
                        stickerItem2.playCount = 0;
                        stickerItem2.countTriggerType = PTExpression.MV_PART_INDEX.value;
                    }
                }
                AppMethodBeat.m2505o(84264);
                return arrayList;
            }
        } catch (JSONException e) {
            LogUtils.m50205e(TAG, e);
        }
        AppMethodBeat.m2505o(84264);
        return null;
    }

    private static WMGroup parseWMGroup(JSONArray jSONArray, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84265);
        WMGroup wMGroup = new WMGroup();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    WMElement textWMElement;
                    boolean z;
                    int optInt = optJSONObject.optInt(WATERMARK_ELEMENT.WMTYPE.value);
                    if (optInt == WMType.TEXT.value) {
                        textWMElement = new TextWMElement();
                    } else {
                        textWMElement = new ImageWMElement();
                    }
                    textWMElement.dataPath = videoMaterial.getDataPath();
                    textWMElement.sid = videoMaterial.getId();
                    textWMElement.f16566id = optJSONObject.optString(WATERMARK_ELEMENT.ID.value);
                    textWMElement.relativeID = optJSONObject.optString(WATERMARK_ELEMENT.RELATIVE_ID.value);
                    JSONArray optJSONArray = optJSONObject.optJSONArray(WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
                    if (optJSONArray == null || optJSONArray.length() != 2) {
                        textWMElement.relativeAnchor = new PointF(0.0f, 0.0f);
                    } else {
                        textWMElement.relativeAnchor = new PointF((float) optJSONArray.getDouble(0), (float) optJSONArray.getDouble(1));
                    }
                    optJSONArray = optJSONObject.optJSONArray(WATERMARK_ELEMENT.ANCHOR.value);
                    if (optJSONArray == null || optJSONArray.length() != 2) {
                        textWMElement.anchor = new PointF(0.0f, 0.0f);
                    } else {
                        textWMElement.anchor = new PointF((float) optJSONArray.getDouble(0), (float) optJSONArray.getDouble(1));
                    }
                    textWMElement.offsetX = optJSONObject.optInt(WATERMARK_ELEMENT.OFFSETX.value);
                    textWMElement.offsetY = optJSONObject.optInt(WATERMARK_ELEMENT.OFFSETY.value);
                    textWMElement.width = optJSONObject.optInt(WATERMARK_ELEMENT.WIDTH.value);
                    textWMElement.height = optJSONObject.optInt(WATERMARK_ELEMENT.HEIGHT.value);
                    textWMElement.wmtype = optInt;
                    textWMElement.edittype = optJSONObject.optInt(WATERMARK_ELEMENT.EDITTYPE.value);
                    textWMElement.fmtstr = optJSONObject.optString(WATERMARK_ELEMENT.FMTSTR.value);
                    textWMElement.fontName = optJSONObject.optString(WATERMARK_ELEMENT.FONT_NAME.value);
                    if (optJSONObject.optInt(WATERMARK_ELEMENT.FONT_BOLD.value) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    textWMElement.fontBold = z;
                    if (optJSONObject.optInt(WATERMARK_ELEMENT.FONT_ITALICS.value) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    textWMElement.fontItalics = z;
                    textWMElement.fontTexture = optJSONObject.optString(WATERMARK_ELEMENT.FONT_TEXTURE.value);
                    textWMElement.fontSize = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.FONT_SIZE.value, 40.0d);
                    textWMElement.fontFit = optJSONObject.optInt(WATERMARK_ELEMENT.FONT_FIT.value);
                    textWMElement.kern = optJSONObject.optInt(WATERMARK_ELEMENT.KERN.value);
                    textWMElement.imgPath = optJSONObject.optString(WATERMARK_ELEMENT.IMG_PATH.value);
                    textWMElement.frameDuration = optJSONObject.optInt(WATERMARK_ELEMENT.FRAME_DURATION.value);
                    textWMElement.frames = optJSONObject.optInt(WATERMARK_ELEMENT.FRAMES.value);
                    textWMElement.color = optJSONObject.optString(WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
                    textWMElement.strokeColor = optJSONObject.optString(WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
                    textWMElement.strokeSize = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0d);
                    textWMElement.shadowColor = optJSONObject.optString(WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
                    textWMElement.shadowSize = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0d);
                    textWMElement.shadowDx = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.SHADOW_DX.value, -1.0d);
                    textWMElement.shadowDy = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.SHADOW_DY.value, -1.0d);
                    textWMElement.alignment = optJSONObject.optString(WATERMARK_ELEMENT.ALIGNMENT.value);
                    textWMElement.vertical = optJSONObject.optInt(WATERMARK_ELEMENT.VERTICAL.value);
                    textWMElement.outerStrokeColor = optJSONObject.optString(WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
                    textWMElement.outerStrokeSize = (float) optJSONObject.optDouble(WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0d);
                    textWMElement.shaderBmp = optJSONObject.optString(WATERMARK_ELEMENT.SHADER_BMP.value, null);
                    textWMElement.emboss = optJSONObject.optInt(WATERMARK_ELEMENT.EMBOSS.value, 0) == 1;
                    if (optJSONObject.optInt(WATERMARK_ELEMENT.MULTI_ROW.value, 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    textWMElement.multiRow = z;
                    textWMElement.animateType = optJSONObject.optString(WATERMARK_ELEMENT.ANIMATE_TYPE.value);
                    optJSONObject = optJSONObject.optJSONObject(WATERMARK_ELEMENT.LOGIC.value);
                    if (optJSONObject != null) {
                        String str;
                        WMLogic wMLogic = new WMLogic();
                        wMLogic.type = optJSONObject.optString(WATERMARK_LOGIC.TYPE.value);
                        wMLogic.setCompare(optJSONObject.optString(WATERMARK_LOGIC.COMPARE.value), textWMElement.sid);
                        wMLogic.data = optJSONObject.optString(WATERMARK_LOGIC.DATA.value);
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(WATERMARK_LOGIC.RANGE.value);
                        if (optJSONObject2 != null) {
                            wMLogic.range = new ArrayList();
                            Iterator keys = optJSONObject2.keys();
                            while (keys.hasNext()) {
                                str = (String) keys.next();
                                wMLogic.range.add(new WMLogicPair(str, optJSONObject2.optString(str)));
                            }
                            Collections.sort(wMLogic.range);
                        }
                        optJSONObject = optJSONObject.optJSONObject(WATERMARK_LOGIC.CASE.value);
                        if (optJSONObject != null) {
                            wMLogic.wmcase = new ArrayList();
                            Iterator keys2 = optJSONObject.keys();
                            while (keys2.hasNext()) {
                                str = (String) keys2.next();
                                wMLogic.wmcase.add(new WMLogicPair(str, optJSONObject.optString(str)));
                            }
                        }
                        textWMElement.logic = wMLogic;
                    }
                    wMGroup.wmElements.add(textWMElement);
                }
                i++;
            } catch (Exception e) {
                LogUtils.m50206e(e);
            }
        }
        AppMethodBeat.m2505o(84265);
        return wMGroup;
    }

    private static void parseGameParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(84266);
        GameParams gameParams = new GameParams();
        gameParams.mGameName = jSONObject.optString(GAME_FIELD.GAME_NAME.value);
        gameParams.mAnimNames = jSONObject.optString(GAME_FIELD.ANIM_NAMES.value);
        gameParams.mAnimDefaultRotate = jSONObject.optString(GAME_FIELD.ANIM_DEFAULT_ROTATE.value);
        gameParams.mAnimNodeNames = jSONObject.optString(GAME_FIELD.ANIM_NODE_NAMES.value);
        gameParams.mRunningAnimName = jSONObject.optString(GAME_FIELD.RUNNING_ANIM_NAME.value);
        gameParams.mRunningAnimDefaultRotate = jSONObject.optString(GAME_FIELD.RUNNING_ANIM_DEFAULT_ROTATE.value);
        JSONArray optJSONArray = jSONObject.optJSONArray(GAME_FIELD.TEXTURE_IMAGES.value);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            gameParams.textureImages = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                gameParams.textureImages[i] = optJSONArray.optString(i);
            }
            gameParams.usePreload = true;
        }
        gameParams.fov = (float) jSONObject.optDouble(GAME_FIELD.FOV.value, 60.0d);
        if (jSONObject.optInt(GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0) {
            z = true;
        } else {
            z = false;
        }
        gameParams.flattenEar = z;
        if (jSONObject.optInt(GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
            z2 = false;
        }
        gameParams.flattenNose = z2;
        videoMaterial.setGameParams(gameParams);
        AppMethodBeat.m2505o(84266);
    }

    private static void parseAudio3DParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(84267);
        GameParams gameParams = new GameParams();
        gameParams.mGameName = jSONObject.optString(GAME_FIELD.GAME_NAME.value);
        gameParams.mAnimNames = jSONObject.optString(GAME_FIELD.ANIM_NAMES.value);
        gameParams.mAnimDefaultRotate = jSONObject.optString(GAME_FIELD.ANIM_DEFAULT_ROTATE.value);
        gameParams.mAnimNodeNames = jSONObject.optString(GAME_FIELD.ANIM_NODE_NAMES.value);
        gameParams.mRunningAnimName = jSONObject.optString(GAME_FIELD.RUNNING_ANIM_NAME.value);
        gameParams.mRunningAnimDefaultRotate = jSONObject.optString(GAME_FIELD.RUNNING_ANIM_DEFAULT_ROTATE.value);
        JSONArray optJSONArray = jSONObject.optJSONArray(GAME_FIELD.TEXTURE_IMAGES.value);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            gameParams.textureImages = new String[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                gameParams.textureImages[i] = optJSONArray.optString(i);
            }
            gameParams.usePreload = true;
        }
        gameParams.fov = (float) jSONObject.optDouble(GAME_FIELD.FOV.value, 60.0d);
        if (jSONObject.optInt(GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0) {
            z = true;
        } else {
            z = false;
        }
        gameParams.flattenEar = z;
        if (jSONObject.optInt(GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
            z2 = false;
        }
        gameParams.flattenNose = z2;
        videoMaterial.setAudio3DParams(gameParams);
        AppMethodBeat.m2505o(84267);
    }

    private static void parseFabbyMvItems(String str, JSONObject jSONObject, VideoMaterial videoMaterial, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84268);
        String optString = jSONObject.optString("mvTemplateFile");
        if (TextUtils.isEmpty(optString)) {
            AppMethodBeat.m2505o(84268);
            return;
        }
        int lastIndexOf = optString.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            optString = optString.substring(0, lastIndexOf);
        }
        JSONObject parseVideoMaterialFileAsJSONObject = parseVideoMaterialFileAsJSONObject(str, optString, true, decryptListener);
        if (parseVideoMaterialFileAsJSONObject == null) {
            AppMethodBeat.m2505o(84268);
            return;
        }
        JSONArray optJSONArray = parseVideoMaterialFileAsJSONObject.optJSONArray("parts");
        if (optJSONArray == null) {
            AppMethodBeat.m2505o(84268);
        } else if (optJSONArray.length() <= 0) {
            AppMethodBeat.m2505o(84268);
        } else {
            optJSONArray.length();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                FabbyMvPart fabbyMvPart = new FabbyMvPart();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    StickerItem stickerItem;
                    String optString2;
                    int lastIndexOf2;
                    Object obj;
                    StickerItem stickerItem2;
                    int lastIndexOf3;
                    double optDouble = optJSONObject.optDouble(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("background");
                    if (optJSONObject2 != null) {
                        stickerItem = new StickerItem();
                        optString2 = optJSONObject2.optString("videoFile");
                        optString = optJSONObject2.optString("imageName");
                        if (!(TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString))) {
                            if (TextUtils.isEmpty(optString2)) {
                                if (optString.endsWith("_")) {
                                    optString = optString.substring(0, optString.length() - 1);
                                }
                                lastIndexOf2 = optString.lastIndexOf("/");
                                stickerItem.f18271id = optString.substring(lastIndexOf2 + 1, optString.length());
                                stickerItem.subFolder = optString.substring(0, lastIndexOf2);
                                obj = null;
                            } else {
                                i = optString2.lastIndexOf("/");
                                stickerItem.f18271id = optString2.substring(i + 1, optString2.length());
                                stickerItem.subFolder = optString2.substring(0, i);
                                obj = 1;
                            }
                            stickerItem.type = 1;
                            stickerItem.alwaysTriggered = true;
                            stickerItem.frames = optJSONObject2.optInt("imageCount", 1);
                            stickerItem.frameDuration = (optJSONObject2.optDouble("imageDuration", optDouble) / ((double) stickerItem.frames)) * 1000.0d;
                            stickerItem.aspectMode = optJSONObject2.optInt("aspectMode", 0);
                            stickerItem.blendMode = optJSONObject2.optInt("blendMode", 0);
                            stickerItem.width = optJSONObject2.optInt("width", 720);
                            stickerItem.height = optJSONObject2.optInt("height", VideoFilterUtil.IMAGE_HEIGHT);
                            stickerItem.position = new double[]{0.0d, 0.0d};
                            stickerItem.isFabbyMvItem = true;
                            stickerItem.fabbyTotalParts = optJSONArray.length();
                            stickerItem.fabbyPart = i2;
                            if (obj != null) {
                                stickerItem.sourceType = VideoMaterialUtil.getItemSourceType(optJSONObject2.optInt(FIELD.VIDEO_ALPHA_TYPE.value));
                            } else {
                                stickerItem.sourceType = ITEM_SOURCE_TYPE.IMAGE;
                            }
                            fabbyMvPart.bgItem = stickerItem;
                        }
                    }
                    optJSONObject2 = optJSONObject.optJSONObject("foreground");
                    if (optJSONObject2 != null) {
                        stickerItem = new StickerItem();
                        optString2 = optJSONObject2.optString("videoFile");
                        optString = optJSONObject2.optString("imageName");
                        if (!(TextUtils.isEmpty(optString2) && TextUtils.isEmpty(optString))) {
                            if (TextUtils.isEmpty(optString2)) {
                                if (optString.endsWith("_")) {
                                    optString = optString.substring(0, optString.length() - 1);
                                }
                                lastIndexOf2 = optString.lastIndexOf("/");
                                stickerItem.f18271id = optString.substring(lastIndexOf2 + 1, optString.length());
                                stickerItem.subFolder = optString.substring(0, lastIndexOf2);
                                obj = null;
                            } else {
                                i = optString2.lastIndexOf("/");
                                stickerItem.f18271id = optString2.substring(i + 1, optString2.length());
                                stickerItem.subFolder = optString2.substring(0, i);
                                obj = 1;
                            }
                            stickerItem.type = 1;
                            stickerItem.alwaysTriggered = true;
                            stickerItem.frames = optJSONObject2.optInt("imageCount", 1);
                            stickerItem.frameDuration = (optJSONObject2.optDouble("imageDuration", optDouble) / ((double) stickerItem.frames)) * 1000.0d;
                            stickerItem.aspectMode = optJSONObject2.optInt("aspectMode", 0);
                            stickerItem.blendMode = optJSONObject2.optInt("blendMode", 0);
                            stickerItem.width = optJSONObject2.optInt("width", 720);
                            stickerItem.height = optJSONObject2.optInt("height", ActUtil.HEIGHT);
                            stickerItem.position = new double[]{0.0d, 0.0d};
                            stickerItem.isFabbyMvItem = true;
                            stickerItem.fabbyTotalParts = optJSONArray.length();
                            stickerItem.fabbyPart = i2;
                            if (obj != null) {
                                stickerItem.sourceType = VideoMaterialUtil.getItemSourceType(optJSONObject2.optInt(FIELD.VIDEO_ALPHA_TYPE.value));
                            } else {
                                stickerItem.sourceType = ITEM_SOURCE_TYPE.IMAGE;
                            }
                            fabbyMvPart.fgItem = stickerItem;
                        }
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("cover");
                    if (optJSONObject3 != null) {
                        stickerItem2 = new StickerItem();
                        optString = optJSONObject3.optString("imageFile");
                        if (!TextUtils.isEmpty(optString)) {
                            if (optString.endsWith("_")) {
                                optString = optString.substring(0, optString.length() - 1);
                            }
                            lastIndexOf3 = optString.lastIndexOf("/");
                            stickerItem2.f18271id = optString.substring(lastIndexOf3 + 1, optString.lastIndexOf("_"));
                            stickerItem2.subFolder = optString.substring(0, lastIndexOf3);
                            stickerItem2.type = 1;
                            stickerItem2.alwaysTriggered = true;
                            stickerItem2.frames = 1;
                            stickerItem2.frameDuration = 1000.0d * optDouble;
                            stickerItem2.aspectMode = optJSONObject3.optInt("aspectMode", 0);
                            stickerItem2.blendMode = optJSONObject3.optInt("blendMode", 0);
                            stickerItem2.width = optJSONObject3.optInt("width", 720);
                            stickerItem2.height = optJSONObject3.optInt("height", ActUtil.HEIGHT);
                            stickerItem2.position = new double[]{0.0d, 0.0d};
                            stickerItem2.isFabbyMvItem = true;
                            stickerItem2.fabbyTotalParts = optJSONArray.length();
                            stickerItem2.fabbyPart = i2;
                            fabbyMvPart.coverItem = stickerItem2;
                        }
                    }
                    optJSONObject2 = optJSONObject.optJSONObject("cameraFrame");
                    if (optJSONObject2 != null) {
                        String str2;
                        JSONObject optJSONObject4;
                        Iterator keys;
                        fabbyMvPart.easeCurve = optJSONObject2.optInt("easeCurve", 0);
                        fabbyMvPart.scaleMap.clear();
                        JSONObject optJSONObject5 = optJSONObject2.optJSONObject("shakaEffect");
                        if (optJSONObject5 != null) {
                            ShakaEffectItem shakaEffectItem = new ShakaEffectItem();
                            shakaEffectItem.setFilterType(optJSONObject5.optInt("filterType"));
                            HashMap hashMap = new HashMap();
                            Iterator keys2 = optJSONObject5.keys();
                            while (keys2.hasNext()) {
                                str2 = (String) keys2.next();
                                optJSONObject4 = optJSONObject5.optJSONObject(str2);
                                new StringBuilder("key = ").append(str2).append(", valueJson = ").append(optJSONObject4);
                                if (optJSONObject4 != null) {
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator keys3 = optJSONObject4.keys();
                                    while (keys3.hasNext()) {
                                        optString = (String) keys3.next();
                                        arrayList2.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject4.optDouble(optString, 0.0d))));
                                    }
                                    Collections.sort(arrayList2, mRangeValueComp);
                                    hashMap.put(str2, arrayList2);
                                }
                            }
                            shakaEffectItem.setValueMap(hashMap);
                            fabbyMvPart.setShakaEffectItem(shakaEffectItem);
                        }
                        optJSONObject3 = optJSONObject2.optJSONObject(WMElement.ANIMATE_TYPE_SCALE);
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.scaleMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 1.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.scaleMap, mRangeValueComp);
                        fabbyMvPart.degreeMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.degreeMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.degreeMap, mRangeValueComp);
                        fabbyMvPart.translateXMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("translateX");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.translateXMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.translateXMap, mRangeValueComp);
                        fabbyMvPart.translateYMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("translateY");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.translateYMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.translateYMap, mRangeValueComp);
                        fabbyMvPart.anchorXMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("anchorX");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.anchorXMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.anchorXMap, mRangeValueComp);
                        fabbyMvPart.anchorYMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("anchorY");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.anchorYMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.anchorYMap, mRangeValueComp);
                        fabbyMvPart.alphaMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("alpha");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.alphaMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 1.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.alphaMap, mRangeValueComp);
                        fabbyMvPart.blurRadiusMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("blurRadius");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.blurRadiusMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.blurRadiusMap, mRangeValueComp);
                        fabbyMvPart.blurDirectionMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("blurDirection");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.blurDirectionMap.add(Pair.create(Float.valueOf(optString), Double.valueOf(optJSONObject3.optDouble(optString, 0.0d))));
                            }
                        }
                        Collections.sort(fabbyMvPart.blurDirectionMap, mRangeValueComp);
                        fabbyMvPart.gridTypeMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("gridType");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.gridTypeMap.add(Pair.create(Float.valueOf(optString), Integer.valueOf(optJSONObject3.optInt(optString, 0))));
                            }
                        }
                        Collections.sort(fabbyMvPart.gridTypeMap, mDivideValueComp);
                        fabbyMvPart.gridSettingMap.clear();
                        optJSONObject5 = optJSONObject2.optJSONObject("gridSettingFile");
                        if (optJSONObject5 != null) {
                            Iterator keys4 = optJSONObject5.keys();
                            while (keys4.hasNext()) {
                                optString = (String) keys4.next();
                                str2 = optJSONObject5.optString(optString);
                                if (!TextUtils.isEmpty(str2)) {
                                    optJSONObject3 = parseVideoMaterialFileAsJSONObject(str, str2, true, decryptListener);
                                    if (optJSONObject3 != null) {
                                        GridSettingModel gridSettingModel = new GridSettingModel();
                                        Rect rect = new Rect(0, 0, 720, ActUtil.HEIGHT);
                                        optJSONObject4 = optJSONObject3.optJSONObject("canvasSize");
                                        if (optJSONObject4 != null) {
                                            rect.width = (int) optJSONObject4.optDouble("width", 720.0d);
                                            rect.height = (int) optJSONObject4.optDouble("height", 1280.0d);
                                        }
                                        JSONArray optJSONArray2 = optJSONObject3.optJSONArray("canvasRectList");
                                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                            for (lastIndexOf = 0; lastIndexOf < optJSONArray2.length(); lastIndexOf++) {
                                                GridModel gridModel = new GridModel();
                                                Rect rect2 = new Rect(0, 0, 720, ActUtil.HEIGHT);
                                                JSONObject optJSONObject6 = optJSONArray2.optJSONObject(lastIndexOf);
                                                if (optJSONObject6 != null) {
                                                    rect2.f1681x = (int) optJSONObject6.optDouble("left", 0.0d);
                                                    rect2.f1682y = (int) optJSONObject6.optDouble("top", 0.0d);
                                                    rect2.width = (int) optJSONObject6.optDouble("width", 720.0d);
                                                    rect2.height = (int) optJSONObject6.optDouble("height", 1280.0d);
                                                    gridModel.renderId = optJSONObject6.optInt("renderId", 0);
                                                    gridModel.zIndex = optJSONObject6.optInt("zIndex", 0);
                                                    gridModel.aspectMode = optJSONObject6.optInt("aspectMode", 0);
                                                    gridModel.positionMode = optJSONObject6.optInt("positionMode", 0);
                                                    gridModel.transformType = optJSONObject6.optInt("transformType", 0);
                                                }
                                                gridModel.canvasRect = rect2;
                                                gridSettingModel.canvasRectList.add(gridModel);
                                            }
                                            Collections.sort(gridSettingModel.canvasRectList, mGridModelComparator);
                                        }
                                        gridSettingModel.canvasRect = rect;
                                        fabbyMvPart.gridSettingMap.add(Pair.create(Float.valueOf(optString), gridSettingModel));
                                    }
                                }
                            }
                        }
                        Collections.sort(fabbyMvPart.gridSettingMap, mDivideValueCompForObject);
                        fabbyMvPart.gridModeMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("gridMode");
                        if (optJSONObject3 != null) {
                            keys = optJSONObject3.keys();
                            while (keys.hasNext()) {
                                optString = (String) keys.next();
                                fabbyMvPart.gridModeMap.add(Pair.create(Float.valueOf(optString), Integer.valueOf(optJSONObject3.optInt(optString, 0))));
                            }
                        }
                        Collections.sort(fabbyMvPart.gridModeMap, mDivideValueComp);
                        fabbyMvPart.gridOrderMap.clear();
                        optJSONObject3 = optJSONObject2.optJSONObject("gridOrder");
                        if (optJSONObject3 != null) {
                            Iterator keys5 = optJSONObject3.keys();
                            while (keys5.hasNext()) {
                                optString = (String) keys5.next();
                                fabbyMvPart.gridOrderMap.add(Pair.create(Float.valueOf(optString), Integer.valueOf(optJSONObject3.optInt(optString, 0))));
                            }
                        }
                        Collections.sort(fabbyMvPart.gridOrderMap, mDivideValueComp);
                    }
                    optJSONObject3 = optJSONObject.optJSONObject("finishTransition");
                    if (optJSONObject3 != null) {
                        stickerItem2 = new StickerItem();
                        String optString3 = optJSONObject3.optString("maskVideoFile");
                        optString = optJSONObject3.optString("maskImageName");
                        lastIndexOf2 = optJSONObject3.optInt("transitionFunction", 0);
                        if (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString)) {
                            stickerItem2.f18271id = "";
                            stickerItem2.subFolder = "";
                        } else if (TextUtils.isEmpty(optString3)) {
                            if (optString.endsWith("_")) {
                                optString = optString.substring(0, optString.length() - 1);
                            }
                            lastIndexOf3 = optString.lastIndexOf("/");
                            stickerItem2.f18271id = optString.substring(lastIndexOf3 + 1, optString.length());
                            stickerItem2.subFolder = optString.substring(0, lastIndexOf3);
                        } else {
                            i = optString3.lastIndexOf("/");
                            stickerItem2.f18271id = optString3.substring(i + 1, optString3.length());
                            stickerItem2.subFolder = optString3.substring(0, i);
                        }
                        stickerItem2.frames = optJSONObject3.optInt("maskImageCount", 1);
                        stickerItem2.frameDuration = (optJSONObject3.optDouble("maskImageDuration", 0.0d) / ((double) stickerItem2.frames)) * 1000.0d;
                        stickerItem2.triggerType = optJSONObject3.optInt("triggerType", 0);
                        if (!(stickerItem2.triggerType != 1 || videoMaterial.getItemList() == null || videoMaterial.getItemList().size() == 0)) {
                            stickerItem2.triggerType = ((StickerItem) videoMaterial.getItemList().get(videoMaterial.getItemList().size() - 1)).triggerType;
                        }
                        fabbyMvPart.transitionItem = stickerItem2;
                        fabbyMvPart.transitionDuration = (long) (optJSONObject3.optDouble(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0.0d) * 1000.0d);
                        fabbyMvPart.transitionEase = optJSONObject3.optInt("easeCurve", 0);
                        fabbyMvPart.transitionMaskType = optJSONObject3.optInt("maskType", 1);
                        fabbyMvPart.transitionFunction = lastIndexOf2;
                    }
                    JSONObject optJSONObject7 = optJSONObject.optJSONObject("filterEffect");
                    if (optJSONObject7 != null) {
                        fabbyMvPart.filterType = optJSONObject7.optInt("type", 0);
                        fabbyMvPart.filterId = optJSONObject7.optString("filter");
                        fabbyMvPart.lutFile = optJSONObject7.optString("lutFile");
                        fabbyMvPart.filterParamMap.clear();
                        optJSONObject3 = optJSONObject7.optJSONObject("param");
                        if (optJSONObject3 != null) {
                            Iterator keys6 = optJSONObject3.keys();
                            while (keys6.hasNext()) {
                                optString = (String) keys6.next();
                                fabbyMvPart.filterParamMap.add(Pair.create(Float.valueOf(optString), Integer.valueOf(optJSONObject3.optInt(optString, 0))));
                            }
                            Collections.sort(fabbyMvPart.filterParamMap, mDivideValueComp);
                        }
                    }
                    fabbyMvPart.duration = (long) (1000.0d * optDouble);
                    fabbyMvPart.partIndex = i2;
                    arrayList.add(fabbyMvPart);
                }
                i = i2 + 1;
            }
            optString = parseVideoMaterialFileAsJSONObject.optString("bgmAudio", "");
            if (!TextUtils.isEmpty(optString)) {
                videoMaterial.setHasAudio(true);
            }
            videoMaterial.setFabbyParts(new FabbyParts(arrayList, optString));
            JSONArray optJSONArray3 = jSONObject.optJSONArray(FIELD.MULTI_VIEWER.value);
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray3 != null) {
                for (i = 0; i < optJSONArray3.length(); i++) {
                    MultiViewerItem multiViewerItem = new MultiViewerItem();
                    JSONObject optJSONObject8 = optJSONArray3.optJSONObject(i);
                    if (optJSONObject8 != null) {
                        multiViewerItem.videoMaterial = parseVideoMaterial(str, optJSONObject8.optString("importMaterial"), true, decryptListener);
                        if (VideoMaterialUtil.isWatermarkMaterial(multiViewerItem.videoMaterial)) {
                            LogicDataManager.getInstance().init(multiViewerItem.videoMaterial);
                        }
                        multiViewerItem.renderId = optJSONObject8.optInt("renderId");
                        JSONArray optJSONArray4 = optJSONObject8.optJSONArray("activeParts");
                        if (optJSONArray4 != null) {
                            for (lastIndexOf = 0; lastIndexOf < optJSONArray4.length(); lastIndexOf++) {
                                multiViewerItem.activeParts.add(Integer.valueOf(optJSONArray4.optInt(lastIndexOf)));
                            }
                        }
                        multiViewerItem.needOriginFrame = optJSONObject8.optInt("needOriginFrame", 1) == 1;
                    }
                    arrayList3.add(multiViewerItem);
                }
            }
            videoMaterial.setMultiViewerItemList(arrayList3);
            AppMethodBeat.m2505o(84268);
        }
    }

    public static void parseAudio2TextParams(JSONObject jSONObject, VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84269);
        JSONObject optJSONObject = jSONObject.optJSONObject("audio2text");
        if (optJSONObject != null) {
            Audio2Text audio2Text = new Audio2Text();
            audio2Text.sentenceCount = optJSONObject.optInt("sentenceCount", 0);
            audio2Text.sentenceMode = optJSONObject.optInt("sentenceMode", 0);
            audio2Text.silenceTime = optJSONObject.optDouble("silenceTime", 0.0d);
            audio2Text.segmentCount = optJSONObject.optInt("segmentCount", 0);
            audio2Text.segmentTime = optJSONObject.optDouble("segmentTime", 0.0d);
            audio2Text.triggerWords = optJSONObject.optString("triggerWords", null);
            videoMaterial.setAudio2Text(audio2Text);
        }
        AppMethodBeat.m2505o(84269);
    }

    public static JSONObject parseVideoMaterialString(String str, DecryptListener decryptListener) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(84270);
        JSONObject jSONObject2 = null;
        CharSequence trim = str.trim();
        if (trim != null) {
            try {
                if (trim.charAt(0) != '{') {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(drinkACupOfCoffee(new ByteArrayInputStream(trim.getBytes(Charset.forName("UTF-8"))), decryptListener)), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    trim = stringBuffer.toString();
                }
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(trim)) {
            jSONObject = null;
        } else {
            jSONObject = (JSONObject) new JSONTokener(trim).nextValue();
        }
        jSONObject2 = jSONObject;
        AppMethodBeat.m2505o(84270);
        return jSONObject2;
    }

    public static JSONObject parseVideoMaterialFileAsJSONObject(String str, String str2, boolean z, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84271);
        String readMaterialFile = readMaterialFile(str, str2, z, decryptListener);
        LogUtils.m50199d(TAG, "[material str]".concat(String.valueOf(readMaterialFile)));
        if (!(readMaterialFile == null || TextUtils.isEmpty(readMaterialFile))) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(readMaterialFile).nextValue();
                AppMethodBeat.m2505o(84271);
                return jSONObject;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(84271);
        return null;
    }

    public static JSONArray parseVideoMaterialFileAsJSONArray(String str, String str2, boolean z, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84272);
        String readMaterialFile = readMaterialFile(str, str2, z, decryptListener);
        if (!(readMaterialFile == null || TextUtils.isEmpty(readMaterialFile))) {
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(readMaterialFile).nextValue();
                AppMethodBeat.m2505o(84272);
                return jSONArray;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(84272);
        return null;
    }

    public static ParticleConfig parseParticleConfig(String str, String str2, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84273);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(84273);
        } else {
            try {
                new JSONTokener(XML.toJSONObject(readPexFile(str, str2, decryptListener)).toString()).nextValue();
                AppMethodBeat.m2505o(84273);
            } catch (Exception | JSONException e) {
                AppMethodBeat.m2505o(84273);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A:{SYNTHETIC, Splitter:B:40:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A:{SYNTHETIC, Splitter:B:40:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A:{SYNTHETIC, Splitter:B:40:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1 A:{SYNTHETIC, Splitter:B:40:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b6 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A:{Catch:{ IOException -> 0x0165 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x017a A:{SYNTHETIC, Splitter:B:103:0x017a} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x017f A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0184 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0189 A:{Catch:{ IOException -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A:{SYNTHETIC, Splitter:B:25:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01cf A:{Splitter:B:64:0x00f7, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a8 A:{Splitter:B:64:0x00f7, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0111 A:{Catch:{ IOException -> 0x0121, Exception -> 0x01cf, all -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0086 A:{SYNTHETIC, Splitter:B:25:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014b  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:?, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:43:0x00b6, code skipped:
            r5.close();
     */
    /* JADX WARNING: Missing block: B:45:0x00bb, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:47:0x00c0, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:79:0x0122, code skipped:
            r1 = null;
            r7 = r4;
     */
    /* JADX WARNING: Missing block: B:98:0x0165, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:99:0x0166, code skipped:
            com.tencent.ttpic.baseutils.LogUtils.m50203e(TAG, r0.getMessage(), r0, new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:119:0x01a8, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:120:0x01a9, code skipped:
            r1 = null;
            r5 = null;
            r6 = null;
            r7 = r4;
     */
    /* JADX WARNING: Missing block: B:134:0x01cf, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:135:0x01d0, code skipped:
            r1 = null;
            r5 = null;
            r6 = null;
            r7 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String readPexFile(String str, String str2, DecryptListener decryptListener) {
        InputStream drinkACupOfCoffee;
        Exception e;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        int i = 1;
        AppMethodBeat.m2504i(84274);
        int i2 = !str2.endsWith("dat") ? 1 : 0;
        String realPath = FileUtils.getRealPath(str);
        String str3 = realPath + "/" + str2;
        String str4 = realPath + "/" + str2;
        try {
            File file = new File(str3);
            File file2 = new File(str4);
            InputStream fileInputStream2;
            if ((file.exists() && file.isFile()) || (file2.exists() && file2.isFile())) {
                if (file.exists() && file.isFile()) {
                    fileInputStream2 = new FileInputStream(file);
                } else if (file2.exists() && file2.isFile()) {
                    fileInputStream2 = new FileInputStream(file2);
                    if (i2 != 0) {
                        i = 0;
                    }
                    i2 = i;
                } else {
                    fileInputStream2 = null;
                }
                if (i2 == 0) {
                    try {
                        drinkACupOfCoffee = drinkACupOfCoffee(fileInputStream2, decryptListener);
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        drinkACupOfCoffee = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        drinkACupOfCoffee = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (drinkACupOfCoffee != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(84274);
                        throw th;
                    }
                    try {
                        C5989g.closeQuietly(fileInputStream2);
                        fileInputStream = fileInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        inputStream = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        try {
                            LogUtils.m50203e(TAG, e.getMessage(), e, new Object[0]);
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (drinkACupOfCoffee != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.m2505o(84274);
                            return null;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (drinkACupOfCoffee != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.m2505o(84274);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (drinkACupOfCoffee != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(84274);
                        throw th;
                    }
                }
                inputStream = fileInputStream2;
                drinkACupOfCoffee = fileInputStream2;
            } else {
                try {
                    drinkACupOfCoffee = VideoGlobalContext.getContext().getAssets().open(str3);
                    if (i2 == 0) {
                        fileInputStream2 = drinkACupOfCoffee(drinkACupOfCoffee, decryptListener);
                        try {
                            C5989g.closeQuietly(drinkACupOfCoffee);
                            fileInputStream = null;
                            drinkACupOfCoffee = fileInputStream2;
                        } catch (IOException e4) {
                            drinkACupOfCoffee = VideoGlobalContext.getContext().getAssets().open(str4);
                            if (i2 != 0) {
                                i = 0;
                            }
                            if (i != 0) {
                                fileInputStream2 = drinkACupOfCoffee(drinkACupOfCoffee, decryptListener);
                                C5989g.closeQuietly(drinkACupOfCoffee);
                                fileInputStream = null;
                                drinkACupOfCoffee = fileInputStream2;
                            } else {
                                fileInputStream = null;
                            }
                            if (drinkACupOfCoffee != null) {
                            }
                        } catch (Exception e5) {
                        } catch (Throwable th5) {
                        }
                    } else {
                        fileInputStream = null;
                    }
                } catch (IOException e6) {
                    fileInputStream2 = null;
                    drinkACupOfCoffee = VideoGlobalContext.getContext().getAssets().open(str4);
                    if (i2 != 0) {
                    }
                    if (i != 0) {
                    }
                    if (drinkACupOfCoffee != null) {
                    }
                }
            }
            if (drinkACupOfCoffee != null) {
                try {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(drinkACupOfCoffee);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        try {
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                str3 = bufferedReader.readLine();
                                if (str3 == null) {
                                    break;
                                }
                                stringBuilder.append(str3);
                            }
                            String stringBuilder2 = stringBuilder.toString();
                            try {
                                bufferedReader.close();
                                inputStreamReader2.close();
                                if (drinkACupOfCoffee != null) {
                                    drinkACupOfCoffee.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            } catch (IOException e7) {
                                LogUtils.m50203e(TAG, e7.getMessage(), e7, new Object[0]);
                            }
                            AppMethodBeat.m2505o(84274);
                            return stringBuilder2;
                        } catch (Exception e8) {
                            e = e8;
                            inputStreamReader = inputStreamReader2;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStreamReader = inputStreamReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e72) {
                                    LogUtils.m50203e(TAG, e72.getMessage(), e72, new Object[0]);
                                    AppMethodBeat.m2505o(84274);
                                    throw th;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (drinkACupOfCoffee != null) {
                                drinkACupOfCoffee.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            AppMethodBeat.m2505o(84274);
                            throw th;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        LogUtils.m50203e(TAG, e.getMessage(), e, new Object[0]);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (drinkACupOfCoffee != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(84274);
                        return null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (drinkACupOfCoffee != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(84274);
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.m50203e(TAG, e.getMessage(), e, new Object[0]);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (drinkACupOfCoffee != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(84274);
                    return null;
                } catch (Throwable th8) {
                    th = th8;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (drinkACupOfCoffee != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(84274);
                    throw th;
                }
            }
            if (drinkACupOfCoffee != null) {
                try {
                    drinkACupOfCoffee.close();
                } catch (IOException e11) {
                    LogUtils.m50203e(TAG, e11.getMessage(), e11, new Object[0]);
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            AppMethodBeat.m2505o(84274);
            return null;
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            drinkACupOfCoffee = null;
            LogUtils.m50203e(TAG, e.getMessage(), e, new Object[0]);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (drinkACupOfCoffee != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(84274);
            return null;
        } catch (Throwable th9) {
            th = th9;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            drinkACupOfCoffee = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (drinkACupOfCoffee != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(84274);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c A:{SYNTHETIC, Splitter:B:28:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0127 A:{Catch:{ IOException -> 0x0137, Exception -> 0x01c1, all -> 0x0190 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009c A:{SYNTHETIC, Splitter:B:28:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A:{SYNTHETIC, Splitter:B:43:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A:{SYNTHETIC, Splitter:B:43:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A:{SYNTHETIC, Splitter:B:43:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01c1 A:{Splitter:B:69:0x010d, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0190 A:{Splitter:B:69:0x010d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf A:{SYNTHETIC, Splitter:B:43:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce A:{Catch:{ IOException -> 0x01a7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b A:{SYNTHETIC, Splitter:B:103:0x016b} */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0170 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0175 A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017a A:{Catch:{ IOException -> 0x0181 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:118:0x0190, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:119:0x0191, code skipped:
            r2 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* JADX WARNING: Missing block: B:135:0x01c1, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:136:0x01c2, code skipped:
            r2 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String readMaterialFile(String str, String str2, boolean z, DecryptListener decryptListener) {
        String str3;
        InputStream inputStream;
        FileInputStream fileInputStream;
        Exception e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        Object obj = 1;
        AppMethodBeat.m2504i(84275);
        String realPath = FileUtils.getRealPath(str);
        String str4 = realPath + "/" + str2 + "." + (z ? POSTFIX_JSON : "dat");
        StringBuilder append = new StringBuilder().append(realPath).append("/").append(str2).append(".");
        if (z) {
            str3 = "dat";
        } else {
            str3 = POSTFIX_JSON;
        }
        realPath = append.append(str3).toString();
        try {
            File file = new File(str4);
            File file2 = new File(realPath);
            if ((file.exists() && file.isFile()) || (file2.exists() && file2.isFile())) {
                InputStream fileInputStream2;
                if (file.exists() && file.isFile()) {
                    fileInputStream2 = new FileInputStream(file);
                } else if (file2.exists() && file2.isFile()) {
                    fileInputStream2 = new FileInputStream(file2);
                    z = !z;
                } else {
                    fileInputStream2 = null;
                }
                InputStream fileInputStream3;
                if (z) {
                    fileInputStream3 = fileInputStream2;
                    inputStream = fileInputStream2;
                } else {
                    try {
                        inputStream = drinkACupOfCoffee(fileInputStream2, decryptListener);
                        try {
                            C5989g.closeQuietly(fileInputStream2);
                            fileInputStream3 = fileInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            try {
                                e.getMessage();
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream3 != null) {
                                }
                                AppMethodBeat.m2505o(84275);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream3 != null) {
                                }
                                AppMethodBeat.m2505o(84275);
                                throw th;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.m2505o(84275);
                            throw th;
                        }
                    } catch (Exception e22) {
                        e = e22;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                    } catch (Throwable th222) {
                        th = th222;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.m2505o(84275);
                        throw th;
                    }
                }
            }
            InputStream drinkACupOfCoffee;
            try {
                inputStream = VideoGlobalContext.getContext().getAssets().open(str4);
                if (z) {
                    fileInputStream3 = null;
                } else {
                    drinkACupOfCoffee = drinkACupOfCoffee(inputStream, decryptListener);
                    try {
                        C5989g.closeQuietly(inputStream);
                        fileInputStream3 = null;
                        inputStream = drinkACupOfCoffee;
                    } catch (IOException e3) {
                        fileInputStream3 = null;
                        inputStream = drinkACupOfCoffee;
                    } catch (Exception e4) {
                    } catch (Throwable th3) {
                    }
                }
            } catch (IOException e5) {
                drinkACupOfCoffee = null;
                inputStream = VideoGlobalContext.getContext().getAssets().open(realPath);
                if (z) {
                    obj = null;
                }
                if (obj != null) {
                    drinkACupOfCoffee = drinkACupOfCoffee(inputStream, decryptListener);
                    C5989g.closeQuietly(inputStream);
                    fileInputStream3 = null;
                    inputStream = drinkACupOfCoffee;
                } else {
                    fileInputStream3 = null;
                }
                if (inputStream != null) {
                }
            }
            if (inputStream != null) {
                InputStreamReader inputStreamReader2;
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                } catch (Exception e222) {
                    e = e222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    e.getMessage();
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream3 != null) {
                    }
                    AppMethodBeat.m2505o(84275);
                    return null;
                } catch (Throwable th2222) {
                    th = th2222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream3 != null) {
                    }
                    AppMethodBeat.m2505o(84275);
                    throw th;
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        }
                        str3 = stringBuilder.toString();
                        try {
                            bufferedReader.close();
                            inputStreamReader2.close();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileInputStream3 != null) {
                                fileInputStream3.close();
                            }
                        } catch (IOException e6) {
                        }
                        AppMethodBeat.m2505o(84275);
                        return str3;
                    } catch (Exception e2222) {
                        e = e2222;
                        inputStreamReader = inputStreamReader2;
                    } catch (Throwable th22222) {
                        th = th22222;
                        inputStreamReader = inputStreamReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e7) {
                                AppMethodBeat.m2505o(84275);
                                throw th;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        AppMethodBeat.m2505o(84275);
                        throw th;
                    }
                } catch (Exception e22222) {
                    e = e22222;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    e.getMessage();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    AppMethodBeat.m2505o(84275);
                    return null;
                } catch (Throwable th222222) {
                    th = th222222;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream3 != null) {
                    }
                    AppMethodBeat.m2505o(84275);
                    throw th;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
            AppMethodBeat.m2505o(84275);
            return null;
        } catch (Exception e222222) {
            e = e222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            e.getMessage();
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            AppMethodBeat.m2505o(84275);
            return null;
        } catch (Throwable th2222222) {
            th = th2222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            AppMethodBeat.m2505o(84275);
            throw th;
        }
    }

    private static InputStream drinkACupOfCoffee(InputStream inputStream, DecryptListener decryptListener) {
        AppMethodBeat.m2504i(84276);
        byte[] toByteArray = C5989g.toByteArray(inputStream);
        if (decryptListener != null) {
            toByteArray = decryptListener.decrypt(toByteArray);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(toByteArray);
        AppMethodBeat.m2505o(84276);
        return byteArrayInputStream;
    }

    private static void checkValid(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84277);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84277);
            return;
        }
        List<StickerItem> itemList = videoMaterial.getItemList();
        if (itemList == null) {
            AppMethodBeat.m2505o(84277);
            return;
        }
        for (StickerItem stickerItem : itemList) {
            IllegalArgumentException illegalArgumentException;
            if (stickerItem.type == POSITION_TYPE.STATIC.type) {
                if (stickerItem.position == null || stickerItem.position.length < 2) {
                    illegalArgumentException = new IllegalArgumentException("No \"position\" field in static sticker");
                    AppMethodBeat.m2505o(84277);
                    throw illegalArgumentException;
                }
            } else if (stickerItem.type != POSITION_TYPE.DYNAMIC.type) {
                continue;
            } else if (stickerItem.scalePivots == null || stickerItem.scalePivots.length < 2) {
                illegalArgumentException = new IllegalArgumentException("No \"scalePivot\" field in dynamic sticker");
                AppMethodBeat.m2505o(84277);
                throw illegalArgumentException;
            } else if (stickerItem.alignFacePoints == null || stickerItem.alignFacePoints.length == 0) {
                illegalArgumentException = new IllegalArgumentException("No \"alignFacePoints\" field in dynamic sticker");
                AppMethodBeat.m2505o(84277);
                throw illegalArgumentException;
            } else if (stickerItem.anchorPoint == null || stickerItem.anchorPoint.length < 2) {
                illegalArgumentException = new IllegalArgumentException("No \"anchorPoint\" field in dynamic sticker");
                AppMethodBeat.m2505o(84277);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(84277);
    }
}
