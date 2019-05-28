package com.tencent.ttpic.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.oscarcamera.particlesystem.AttributeConst;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.VideoModule.DeviceType;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.config.MediaConfig.ENCODE_SIZE;
import com.tencent.ttpic.constant.CATEGORY_TYPE;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.face.EmptyStatusChecker;
import com.tencent.ttpic.face.EyesStatusChecker;
import com.tencent.ttpic.face.FaceStatusChecker;
import com.tencent.ttpic.face.LeftEyeStatusChecker;
import com.tencent.ttpic.face.MouthStatusChecker;
import com.tencent.ttpic.face.RightEyeStatusChecker;
import com.tencent.ttpic.face.SingleEyeStatusChecker;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.Point3D;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.VideoMaterialMetaData;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.util.C16371i;
import com.tencent.view.C31128d;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class VideoMaterialUtil {
    public static final String CRAZYFACE_ANTI_WRINKLE = "antiWrinkle";
    public static final String CRAZYFACE_BLEND_ALPHA = "blendAlpha";
    public static final String CRAZYFACE_CANVAS = "canvas";
    public static final String CRAZYFACE_DISTORTION_ALPHA = "distortionAlpha";
    public static final String CRAZYFACE_DISTORTION_LIST = "distortionList";
    public static final String CRAZYFACE_FACE_COLOR = "imageFaceColor";
    public static final String CRAZYFACE_FACE_COLOR2 = "imageFaceColor2";
    public static final String CRAZYFACE_FACE_COLOR_RANGE = "faceColorRange";
    public static final String CRAZYFACE_FACE_LAYER = "faceImageLayer";
    public static final String CRAZYFACE_FACE_MASK = "faceMaskImage";
    public static final String CRAZYFACE_FACE_MASK_POINTS = "faceMaskFacePoint";
    public static final String CRAZYFACE_FACE_POINTS = "imageFacePoint";
    public static final String CRAZYFACE_FACE_RIANGLE = "faceTriangle";
    public static final String CRAZYFACE_HEIGHT = "height";
    public static final String CRAZYFACE_IMAGE_LAYER = "imageLayer";
    public static final String CRAZYFACE_IMAGE_PATH = "image";
    public static final String CRAZYFACE_LAYER_TYPE = "type";
    public static final String CRAZYFACE_STK_TYPE = "stkType";
    public static final String CRAZYFACE_WIDTH = "width";
    public static final String CRAZYFACE_X = "x";
    public static final String CRAZYFACE_Y = "y";
    public static final String[] DEVICE_NEED_COPY_TRANSFORM = new String[]{"A1001", "SM-N9006", "vivo_X5Max_L", "vivo_X5Max_L", "vivo_X5V", "vivo_Y23L"};
    public static final String[] DEVICE_NEED_SMALL_SIZE = new String[]{"A1001"};
    public static final List<Integer> EMPTY_ANGLES_LIST = new ArrayList();
    public static final List<PointF> EMPTY_POINTS_LIST = new ArrayList();
    public static boolean ENABLE_FAST_RENDER = true;
    public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_ANDROID = "filterFragment_android.glsl";
    public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_COMMON = "filterFragment.glsl";
    public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_ANDROID = "filterVertex_android.glsl";
    public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_COMMON = "filterVertex.glsl";
    public static final String FILE_NAME_FRAGMENT_SHADER_ANDROID = "fragment_android.glsl";
    public static final String FILE_NAME_FRAGMENT_SHADER_COMMON = "fragment.glsl";
    public static final String FILE_NAME_VERTEX_SHADER_ANDROID = "vertex_android.glsl";
    public static final String FILE_NAME_VERTEX_SHADER_COMMON = "vertex.glsl";
    public static final String FRAMES_ID_SEPARATOR_3D = ":";
    public static final int INVALID_INT_FIELD_VALUE = -999999;
    public static final String ITEM_ID_CUSTOM = "nothing";
    public static final String MATERIAL_PREFIX = "video_";
    public static final String MP4_SUFFIX = ".mp4";
    public static final String PARAMS_FILE_NAME = "params";
    public static final String PNG_SUFFIX = ".png";
    public static final double RATIO_CANVAS = 0.75d;
    public static final double SCALE_DIFF = 100.0d;
    public static double SCALE_FACE_DETECT = 0.1666666716337204d;
    public static final double SCALE_Y = 0.25d;
    public static final int SIZE_FACE_ANGLE = 3;
    public static final int SIZE_FACE_POINT = 90;
    private static final String TAG = VideoMaterialUtil.class.getSimpleName();
    public static FilenameFilter mMp4Filter = new C245004();
    public static FilenameFilter mPngFilter = new C245013();

    public enum DISTORTION_ITEM_FILED {
        POSITION("position"),
        DISTORTION("distortion"),
        DIRECTION(TencentLocation.EXTRA_DIRECTION),
        RADIUS("radius"),
        STRENGH("strength"),
        X("dx"),
        Y("dy"),
        TARGETDX("targetDx"),
        TARGETDY("targetDy");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84068);
        }

        private DISTORTION_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    public enum ITEM_SOURCE_TYPE {
        IMAGE,
        VIDEO_UP_DOWN,
        VIDEO_LEFT_RIGHT,
        VIDEO_NORMAL;

        static {
            AppMethodBeat.m2505o(84113);
        }
    }

    public enum PHANTOM_ITEM_FIELD {
        ID("id"),
        MASK_IMAGE("maskImage"),
        BLEND_MODE("blendMode"),
        SCALE(WMElement.ANIMATE_TYPE_SCALE),
        OPACITY("opacity"),
        X_K("xK"),
        X_A_SIN("xAsin"),
        X_B_COS("xBcos"),
        X_PHASE("xPhase"),
        X_OFFSET("xOffset"),
        X_STEP("xStep"),
        X_RANGE("xRange"),
        Y_K("yK"),
        Y_A_SIN("yAsin"),
        Y_B_COS("yBcos"),
        Y_PHASE("yPhase"),
        Y_OFFSET("yOffset"),
        Y_STEP("yStep"),
        Y_RANGE("yRange");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84119);
        }

        private PHANTOM_ITEM_FIELD(String str) {
            this.value = str;
        }
    }

    public enum ENVIRONMENT {
        BYPASS(-1),
        ECHO(1),
        VIBRATE(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        NINE(9),
        TWENTY(20),
        FIFTY(50),
        FIFTYONE(51);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(84071);
        }

        private ENVIRONMENT(int i) {
            this.value = i;
        }
    }

    public enum FACE_MOVE_ITEM_FILED {
        POSITION("position"),
        POS1("pos1"),
        POS2("pos2"),
        RATIO1("ratio1"),
        RATIO2("ratio2"),
        X(VideoMaterialUtil.CRAZYFACE_X),
        Y(VideoMaterialUtil.CRAZYFACE_Y);
        
        public String value;

        static {
            AppMethodBeat.m2505o(84092);
        }

        private FACE_MOVE_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    public enum FACE_OFF_ITEM_FIELD {
        ID("id"),
        FACE_EXCHANGE_IMAGE("faceExchangeImage"),
        BLEND_ALPHA(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA),
        FEATURE_TYPE("featureType"),
        GRAY_SCALE("grayScale"),
        BLEND_MODE("blendMode"),
        PERSON_ID("personID"),
        RANDOM_GROUP_NUM("randomGroupNum"),
        FACE_POINTS("facePoints"),
        IRIS_IMAGE("eyeIrisImage"),
        FRAME_TYPE("frameType"),
        FRAMES("frames"),
        FRAME_DURATION("frameDuration"),
        TRIGGER_TYPE("triggerType");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84095);
        }

        private FACE_OFF_ITEM_FIELD(String str) {
            this.value = str;
        }
    }

    public enum VOICEKIND {
        BYPASS(-1),
        CAT(1),
        MAN(2),
        GIRL(4),
        UNCLE(5),
        BOY(6),
        FAST(7),
        SLOWLY(8),
        WOMAN(9),
        ELECTRONIC(10),
        ELEVEN(11),
        TWELVE(12),
        THIRTEEN(13),
        BIG(536936433);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(84131);
        }

        private VOICEKIND(int i) {
            this.value = i;
        }
    }

    public enum AR_MATERIAL_TYPE {
        NORMAL(1),
        CLICKABLE(2);
        
        public int value;

        static {
            AppMethodBeat.m2505o(84056);
        }

        private AR_MATERIAL_TYPE(int i) {
            this.value = i;
        }
    }

    public enum CHARM_RANGE_FIELD {
        MIN("min"),
        MAX("max");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84062);
        }

        private CHARM_RANGE_FIELD(String str) {
            this.value = str;
        }
    }

    public enum EXPRESSION_TYPE {
        JUMP_EYE_BROW(4),
        WINK(5),
        SHOOK_HEAD(6),
        RIGHT_EYE_WINK(8),
        LEFT_EYE_WINK(9),
        NOD(10),
        SHAKE_HEAD(11);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(84077);
        }

        private EXPRESSION_TYPE(int i) {
            this.value = i;
        }
    }

    public enum FIELD {
        MIN_APP_VERSION("minAppVersion"),
        CATEGORY_FLAG("categoryFlag"),
        SHADER_TYPE("shaderType"),
        FACE_OFF_TYPE("faceOffType"),
        RESET_WHEN_START_RECORD("resetWhenStartRecord"),
        SUPPORT_PAUSE("supportPause"),
        MAX_FACE_COUNT("maxFaceCount"),
        VOICE_KIND("voicekind"),
        ENVIRONMENT("environment"),
        RESOURCE_LIST("resourceList"),
        ITEM_LIST("itemList"),
        FACE_EXCHANGE_IMAGE("faceExchangeImage"),
        IMAGE_FACE_POINTS_FILE_NAME("imageFacePointsFileName"),
        BLEND_ALPHA(VideoMaterialUtil.CRAZYFACE_BLEND_ALPHA),
        DISTORTION_LIST(VideoMaterialUtil.CRAZYFACE_DISTORTION_LIST),
        FACE_POINTS_LIST("facePoints"),
        GRAY_SCALE("grayScale"),
        FEATURE_TYPE("featureType"),
        FACE_MOVE_LIST("faceMoveList"),
        FACE_MOVE_TRIANGLE("faceMoveTriangle"),
        BLEND_MODE("blendMode"),
        ORDER_MODE("orderMode"),
        FACE_SWAP_TYPE("faceSwapType"),
        FILTER_ID("filterId"),
        FILTER_BLUR_STRENGTH("filterBlurStrength"),
        FILTER_EFFECT("filterEffect"),
        CHARM_RANGE("charmRange"),
        FACE_MESH_ITEM_LIST("faceMeshItemList"),
        FACE_OFF_ITEM_LIST("faceOffItemList"),
        AR_PARTICLE_TYPE("arParticleType"),
        AR_PARTICLE_LIST("arParticleList"),
        SUPPORT_LANDSCAPE("supportLandscape"),
        RANDOM_GROUP_COUNT("randomGroupCount"),
        FACE_EXPRESSION("faceExpression"),
        TIPS_TEXT("tipsText"),
        TIPS_ICON("tipsIcon"),
        FACE_CROP("videoFaceCrop"),
        USE_MESH("useMesh"),
        FACE_HEAD_CROP_ITEM_LIST("headCropItemList"),
        WATERMARK_GROUP("watermarkGroup"),
        AD_ICON("adIcon"),
        AD_LINK("adH5Link"),
        AD_APP_LINK("adAppLink"),
        DETECTOR_FLAG("detectorFlag"),
        VIDEO_ALPHA_TYPE("videoAlphaType"),
        LIPS_LUT("lipsLut"),
        SPLIT_SCREEN("splitScreen"),
        MULTI_VIEWER("multiViewer"),
        HAND_BOOST_ENABLE("handBoostEnable");
        
        public final String value;

        static {
            AppMethodBeat.m2505o(84104);
        }

        private FIELD(String str) {
            this.value = str;
        }
    }

    public enum WATERMARK_ELEMENT {
        ID("id"),
        RELATIVE_ID("relativeID"),
        RELATIVE_ANCHOR("relativeAnchor"),
        ANCHOR("anchor"),
        OFFSETX("offsetX"),
        OFFSETY("offsetY"),
        WIDTH("width"),
        HEIGHT("height"),
        WMTYPE("wmtype"),
        EDITTYPE("editType"),
        FMTSTR("fmtstr"),
        FONT_NAME("fontName"),
        FONT_BOLD("fontBold"),
        FONT_ITALICS("fontItalics"),
        FONT_TEXTURE("fontTexture"),
        FONT_SIZE("fontSize"),
        FONT_FIT("fontFit"),
        KERN("kern"),
        IMG_PATH("imgPath"),
        FRAME_DURATION("frameDuration"),
        FRAMES("frames"),
        COLOR("color"),
        STROKE_COLOR("strokeColor"),
        STROKE_SIZE("strokeSize"),
        SHADOW_COLOR("shadowColor"),
        SHADOW_SIZE("shadowSize"),
        SHADOW_DX("shadowDx"),
        SHADOW_DY("shadowDy"),
        ALIGNMENT("alignment"),
        VERTICAL("vertical"),
        OUTER_STROKE_COLOR("outerStrokeColor"),
        OUTER_STROKE_SIZE("outerStrokeSize"),
        SHADER_BMP("shaderBmp"),
        EMBOSS("emboss"),
        MULTI_ROW("multiRow"),
        ROTATE(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION),
        ANIMATE_TYPE("animateType"),
        LOGIC("logic");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84134);
        }

        private WATERMARK_ELEMENT(String str) {
            this.value = str;
        }
    }

    public enum EXPRESSION_ITEM_FILED {
        EXPRESSION_TIME("expressionTime"),
        EXPRESSION_ID("expressionID"),
        EXPRESSION_FEAT_SIZE("expressionFeatSize"),
        EXPRESSION_FEAT("expressionFeat"),
        EXPRESSION_ANGLE("expressionAngle"),
        SCORE_IMAGE_ID("scoreImageID"),
        EXPRESSION_WEIGHT("expressionWeight");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84074);
        }

        private EXPRESSION_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    public enum PARTICLE_CLEAR_MODE {
        DO_NOT_CLEAR(0),
        CLEAR_ALL(1);
        
        public int value;

        static {
            AppMethodBeat.m2505o(84116);
        }

        private PARTICLE_CLEAR_MODE(int i) {
            this.value = i;
        }
    }

    public enum RANGE_TRIGGER_TYPE {
        NO_CHECK(0, EmptyStatusChecker.getInstance()),
        EYES(1, EyesStatusChecker.getInstance()),
        MOUTH(2, MouthStatusChecker.getInstance()),
        SINGLE_EYE(3, SingleEyeStatusChecker.getInstance()),
        LEFT_EYE(4, LeftEyeStatusChecker.getInstance()),
        RIGHT_EYE(5, RightEyeStatusChecker.getInstance());
        
        public final FaceStatusChecker checker;
        public final int value;

        static {
            AppMethodBeat.m2505o(84122);
        }

        private RANGE_TRIGGER_TYPE(int i, FaceStatusChecker faceStatusChecker) {
            this.value = i;
            this.checker = faceStatusChecker;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoMaterialUtil$1 */
    static class C244981 implements Comparator<StickerItem> {
        C244981() {
        }

        public final int compare(StickerItem stickerItem, StickerItem stickerItem2) {
            return stickerItem.type - stickerItem2.type;
        }
    }

    public enum TRANSITION {
        PARTICLE_COUNT_MAX(AttributeConst.MAX_COUNT),
        LIFE(AttributeConst.LIFE),
        EMISSION_MODE("emissionMode"),
        PARTICLE_ALWAYS_UPDATE("particleAlwaysUpdate"),
        EMISSION_RATE(AttributeConst.EMISSION_RATE),
        SCALE(WMElement.ANIMATE_TYPE_SCALE),
        ROTATE(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION),
        POSITION_X(AttributeConst.f17266X),
        POSITION_Y(AttributeConst.f17267Y),
        P0("p0"),
        P1("p1"),
        P2("p2"),
        REPEAT_COUNT("repeatCount"),
        MIN_UPDATE_INTERVAL("minUpdateInterval"),
        CLEAR_MODE("clearMode");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84128);
        }

        private TRANSITION(String str) {
            this.value = str;
        }
    }

    public enum WATERMARK_LOGIC {
        TYPE("type"),
        COMPARE("compare"),
        DATA("data"),
        RANGE("range"),
        CASE("case");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84137);
        }

        private WATERMARK_LOGIC(String str) {
            this.value = str;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoMaterialUtil$2 */
    static class C244992 implements FilenameFilter {
        C244992() {
        }

        public final boolean accept(File file, String str) {
            AppMethodBeat.m2504i(84051);
            boolean endsWith = str.endsWith(VideoMaterialUtil.MP4_SUFFIX);
            AppMethodBeat.m2505o(84051);
            return endsWith;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoMaterialUtil$4 */
    static class C245004 implements FilenameFilter {
        C245004() {
        }

        public final boolean accept(File file, String str) {
            AppMethodBeat.m2504i(84053);
            boolean endsWith = str.endsWith(VideoMaterialUtil.MP4_SUFFIX);
            AppMethodBeat.m2505o(84053);
            return endsWith;
        }
    }

    public enum CANVAS_ITEM_FILED {
        TYPE("type"),
        INDEX(C8741b.INDEX),
        START_TIME("startTime"),
        END_TIME("endTime"),
        Z_INDEX("zIndex"),
        ITEM_RECT("itemRect"),
        ITEM_RESIZE_MODE("itemResizeMode");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84059);
        }

        private CANVAS_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    public enum FACE_OFF_TYPE {
        NORMAL(0),
        BY_IMAGE(1);
        
        public int value;

        static {
            AppMethodBeat.m2505o(84098);
        }

        private FACE_OFF_TYPE(int i) {
            this.value = i;
        }
    }

    public enum SHADER_TYPE {
        NORMAL(0),
        CUSTOM_BEFORE_COMMON(1),
        COMMON_BEFORE_CUSTOM(2),
        SNAKE_FACE_BEFORE_COMMON(3),
        CUSTOM_VERTEX_SHADER(4),
        FACE_OFF(5),
        TRANSFORM(6),
        FACE_SWITCH(7),
        FACE_OFF_TRANSFORM(8),
        THREE_DIM(9),
        FACE_SWITCH_DUP(10),
        FACE_COPY(11),
        DOODLE(12),
        DOODLE_IND(13),
        DOODLE_LIGHT(14),
        DOODLE_FIREWORKS(15),
        FACE_MORPHING(16),
        FACE_HEAD_CROP(17),
        AR_PARTICLE(18),
        FACE_CROP(19),
        MAI_MENG(20),
        GAMEPLAY_3D(21),
        PHANTOM(23),
        AUDIO3D(24);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(84125);
        }

        private SHADER_TYPE(int i) {
            this.value = i;
        }
    }

    public enum FACE_CROP_ITEM {
        FRAME_DURATION("frameDuration"),
        FRAMES("frames"),
        FRAME_LIST("frameList");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84080);
        }

        private FACE_CROP_ITEM(String str) {
            this.value = str;
        }
    }

    public enum FACE_SWAP_TYPE {
        FACE_SWITCH(0),
        FACE_COPY(1);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(84101);
        }

        private FACE_SWAP_TYPE(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.ttpic.util.VideoMaterialUtil$3 */
    static class C245013 implements FilenameFilter {
        C245013() {
        }

        public final boolean accept(File file, String str) {
            AppMethodBeat.m2504i(84052);
            boolean endsWith = str.endsWith(".png");
            AppMethodBeat.m2505o(84052);
            return endsWith;
        }
    }

    public enum DETECTOR_BIT {
        REFINE(1);
        
        private final int value;

        static {
            AppMethodBeat.m2505o(84065);
        }

        private DETECTOR_BIT(int i) {
            this.value = i;
        }
    }

    public enum FACE_CROP_ITEM_FRAME {
        FACE_ANGLE("faceAngle"),
        FACE_WIDTH("faceWidth"),
        INDEX(C8741b.INDEX),
        NOSE_POINT("nosePoint"),
        SIZE("size");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84083);
        }

        private FACE_CROP_ITEM_FRAME(String str) {
            this.value = str;
        }
    }

    public enum FACE_EXPRESSION_ITEM_FILED {
        ID("id"),
        VIDEO_ID("videoID"),
        FRAME_DURATION("frameDuration"),
        FRAMES("frames"),
        AUDIO_ID("audioID"),
        CANVAS_SIZE("canvasSize"),
        CANVAS_RESIZE_MODE("canvasResizeMode"),
        SCORE_IMAGE_ID("scoreImageID"),
        EXPRESSION_NUMBER("expressionNumber"),
        EXPRESSION_LIST("expressionList"),
        CANVAS_ITEM_LIST("canvasItemList");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84086);
        }

        private FACE_EXPRESSION_ITEM_FILED(String str) {
            this.value = str;
        }
    }

    public enum FACE_MESH_ITEM_LIST {
        ID("id"),
        PERSON_ID("personID"),
        FRAMES("frames");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84089);
        }

        private FACE_MESH_ITEM_LIST(String str) {
            this.value = str;
        }
    }

    public enum FILTER_EFFECT_FIELD {
        TYPE("type"),
        ORDER("order");
        
        public String value;

        static {
            AppMethodBeat.m2505o(84107);
        }

        private FILTER_EFFECT_FIELD(String str) {
            this.value = str;
        }
    }

    public enum GAME_FIELD {
        GAME_NAME("gameName"),
        ANIM_NAMES("animNames"),
        ANIM_DEFAULT_ROTATE("animDefaultRotate"),
        ANIM_NODE_NAMES("animNodeNames"),
        RUNNING_ANIM_NAME("runningAnimName"),
        RUNNING_ANIM_DEFAULT_ROTATE("runningAnimDefaultRotate"),
        FOV("fov"),
        NOT_FLATTEN_EAR("notFlattenEar"),
        NOT_FLATTEN_NOSE("notFlattenNose"),
        TEXTURE_IMAGES("textureImages");
        
        public final String value;

        static {
            AppMethodBeat.m2505o(84110);
        }

        private GAME_FIELD(String str) {
            this.value = str;
        }
    }

    static {
        AppMethodBeat.m2504i(84211);
        AppMethodBeat.m2505o(84211);
    }

    public static float angleToRadian(float f) {
        return (float) ((((double) f) * 3.141592653589793d) / 180.0d);
    }

    public static PTExpression getOppositeTriggerType(int i) {
        AppMethodBeat.m2504i(84138);
        PTExpression pTExpression = getTriggerType(i).opposite;
        AppMethodBeat.m2505o(84138);
        return pTExpression;
    }

    public static PTExpression getTriggerType(int i) {
        AppMethodBeat.m2504i(84139);
        for (PTExpression pTExpression : PTExpression.values()) {
            if (pTExpression.value == i) {
                AppMethodBeat.m2505o(84139);
                return pTExpression;
            }
        }
        PTExpression pTExpression2 = PTExpression.UNKNOW;
        AppMethodBeat.m2505o(84139);
        return pTExpression2;
    }

    public static String loadVertexShader(String str) {
        AppMethodBeat.m2504i(84140);
        String load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_VERTEX_SHADER_ANDROID);
        if (TextUtils.isEmpty(load)) {
            load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_VERTEX_SHADER_COMMON);
        }
        AppMethodBeat.m2505o(84140);
        return load;
    }

    public static String loadFragmentShader(String str) {
        AppMethodBeat.m2504i(84141);
        String load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_FRAGMENT_SHADER_ANDROID);
        if (TextUtils.isEmpty(load)) {
            load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_FRAGMENT_SHADER_COMMON);
        }
        AppMethodBeat.m2505o(84141);
        return load;
    }

    public static String loadVideoCustomEffectFilterVertexShader(String str) {
        AppMethodBeat.m2504i(84142);
        String load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_ANDROID);
        if (TextUtils.isEmpty(load)) {
            load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_COMMON);
        }
        AppMethodBeat.m2505o(84142);
        return load;
    }

    public static String loadVideoCustomEffectFilterFragmentShader(String str) {
        AppMethodBeat.m2504i(84143);
        String load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_ANDROID);
        if (TextUtils.isEmpty(load)) {
            load = FileUtils.load(VideoGlobalContext.getContext(), str, FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_COMMON);
        }
        AppMethodBeat.m2505o(84143);
        return load;
    }

    public static boolean isActionTriggerType(int i) {
        for (PTExpression pTExpression : PTExpression.ACTION_TRIGGER_TYPE) {
            if (i == pTExpression.value) {
                return true;
            }
        }
        return false;
    }

    public static String getActionTipString(int i) {
        AppMethodBeat.m2504i(84144);
        String string;
        if (i == PTExpression.MOUTH_OPEN.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4d);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.EYEBROWS_RAISE.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4e);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.BLINK.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g49);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.HEAD_SHAKE.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4f);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.KISS.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4b);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.BLINK_LEFT_EYE.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4_);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.BLINK_RIGHT_EYE.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4a);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.HEAD_NOD.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4c);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.HEAD_SHAKE_NEW.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4f);
            AppMethodBeat.m2505o(84144);
            return string;
        } else if (i == PTExpression.TRY_CLICK_SCREEN.value) {
            string = VideoGlobalContext.getContext().getString(C25738R.string.g4g);
            AppMethodBeat.m2505o(84144);
            return string;
        } else {
            string = "";
            AppMethodBeat.m2505o(84144);
            return string;
        }
    }

    public static List<PointF> makeFacePoints(float[] fArr) {
        AppMethodBeat.m2504i(84145);
        ArrayList arrayList = new ArrayList(90);
        int min = Math.min(fArr.length / 2, 90);
        for (int i = 0; i < min; i++) {
            arrayList.add(new PointF(fArr[i * 2], fArr[(i * 2) + 1]));
        }
        AppMethodBeat.m2505o(84145);
        return arrayList;
    }

    private static float getCoordinate(float f, float f2, int i) {
        return (((float) i) * f2) + f;
    }

    public static PointWithIndex[][] getAllPoints(int i, int i2, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(84146);
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(84146);
            return null;
        }
        float f5 = (f2 - f) / ((float) i);
        float f6 = (f4 - f3) / ((float) i2);
        PointWithIndex[][] pointWithIndexArr = (PointWithIndex[][]) Array.newInstance(PointWithIndex.class, new int[]{i2 + 1, i + 1});
        int i3 = 0;
        for (int i4 = 0; i4 <= i2; i4++) {
            int i5 = 0;
            while (i5 <= i) {
                int i6 = i3 + 1;
                pointWithIndexArr[i4][i5] = new PointWithIndex(getCoordinate(f, f5, i5), getCoordinate(f3, f6, i4), i3);
                i5++;
                i3 = i6;
            }
        }
        AppMethodBeat.m2505o(84146);
        return pointWithIndexArr;
    }

    public static List<Integer> getAllIndex(PointWithIndex[][] pointWithIndexArr, int i, int i2) {
        AppMethodBeat.m2504i(84147);
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(84147);
            return null;
        }
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(pointWithIndexArr[0][0].index));
        for (int i3 = 0; i3 < i; i3++) {
            int i4;
            if (i3 % 2 == 0) {
                for (i4 = 0; i4 < i2; i4++) {
                    arrayList.add(Integer.valueOf(pointWithIndexArr[i4][i3 + 1].index));
                    arrayList.add(Integer.valueOf(pointWithIndexArr[i4 + 1][i3].index));
                }
                arrayList.add(Integer.valueOf(pointWithIndexArr[i2][i3 + 1].index));
            } else {
                for (i4 = i2; i4 > 0; i4--) {
                    arrayList.add(Integer.valueOf(pointWithIndexArr[i4][i3 + 1].index));
                    arrayList.add(Integer.valueOf(pointWithIndexArr[i4 - 1][i3].index));
                }
                arrayList.add(Integer.valueOf(pointWithIndexArr[0][i3 + 1].index));
            }
        }
        AppMethodBeat.m2505o(84147);
        return arrayList;
    }

    public static List<PointF> genFullScreenVertices(int i, int i2, float f, float f2, float f3, float f4) {
        AppMethodBeat.m2504i(84148);
        ArrayList arrayList = new ArrayList();
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(84148);
        } else {
            float f5 = (f2 - f) / ((float) i);
            float f6 = (f4 - f3) / ((float) i2);
            arrayList.add(new PointF(getCoordinate(f, f5, 0), getCoordinate(f3, f6, 0)));
            for (int i3 = 0; i3 < i; i3++) {
                int i4;
                if (i3 % 2 == 0) {
                    for (i4 = 0; i4 < i2; i4++) {
                        arrayList.add(new PointF(getCoordinate(f, f5, i3 + 1), getCoordinate(f3, f6, i4)));
                        arrayList.add(new PointF(getCoordinate(f, f5, i3), getCoordinate(f3, f6, i4 + 1)));
                    }
                    arrayList.add(new PointF(getCoordinate(f, f5, i3 + 1), getCoordinate(f3, f6, i2)));
                } else {
                    for (i4 = i2; i4 > 0; i4--) {
                        arrayList.add(new PointF(getCoordinate(f, f5, i3 + 1), getCoordinate(f3, f6, i4)));
                        arrayList.add(new PointF(getCoordinate(f, f5, i3), getCoordinate(f3, f6, i4 - 1)));
                    }
                    arrayList.add(new PointF(getCoordinate(f, f5, i3 + 1), getCoordinate(f3, f6, 0)));
                }
            }
            AppMethodBeat.m2505o(84148);
        }
        return arrayList;
    }

    public static int genFullScreenVertices(float[] fArr, int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = 1;
        AppMethodBeat.m2504i(84149);
        if (i <= 0 || i2 <= 0) {
            AppMethodBeat.m2505o(84149);
            return -1;
        }
        float f5 = (f2 - f) / ((float) i);
        float f6 = (f4 - f3) / ((float) i2);
        fArr[0] = getCoordinate(f, f5, 0);
        fArr[1] = getCoordinate(f3, f6, 0);
        int i4 = 0;
        while (i4 < i) {
            int i5;
            if (i4 % 2 == 0) {
                for (i5 = 0; i5 < i2; i5++) {
                    fArr[i3 * 2] = getCoordinate(f, f5, i4 + 1);
                    fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, i5);
                    i3++;
                    fArr[i3 * 2] = getCoordinate(f, f5, i4);
                    fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, i5 + 1);
                    i3++;
                }
                fArr[i3 * 2] = getCoordinate(f, f5, i4 + 1);
                fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, i2);
            } else {
                for (i5 = i2; i5 > 0; i5--) {
                    fArr[i3 * 2] = getCoordinate(f, f5, i4 + 1);
                    fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, i5);
                    i3++;
                    fArr[i3 * 2] = getCoordinate(f, f5, i4);
                    fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, i5 - 1);
                    i3++;
                }
                fArr[i3 * 2] = getCoordinate(f, f5, i4 + 1);
                fArr[(i3 * 2) + 1] = getCoordinate(f3, f6, 0);
            }
            i4++;
            i3++;
        }
        AppMethodBeat.m2505o(84149);
        return 0;
    }

    public static List<Float> arrayToList(float[] fArr) {
        AppMethodBeat.m2504i(84150);
        ArrayList arrayList = new ArrayList();
        if (fArr == null) {
            AppMethodBeat.m2505o(84150);
        } else {
            for (float valueOf : fArr) {
                arrayList.add(Float.valueOf(valueOf));
            }
            AppMethodBeat.m2505o(84150);
        }
        return arrayList;
    }

    public static List<PointF> arrayToPointList(float[] fArr) {
        AppMethodBeat.m2504i(84151);
        ArrayList arrayList = new ArrayList();
        if (fArr == null) {
            AppMethodBeat.m2505o(84151);
            return arrayList;
        }
        for (int i = 0; i < fArr.length / 2; i++) {
            arrayList.add(new PointF(fArr[i * 2], fArr[(i * 2) + 1]));
        }
        AppMethodBeat.m2505o(84151);
        return arrayList;
    }

    public static List<Point3D> arrayTo3DPointList(float[] fArr) {
        AppMethodBeat.m2504i(84152);
        ArrayList arrayList = new ArrayList();
        if (fArr == null) {
            AppMethodBeat.m2505o(84152);
            return arrayList;
        }
        for (int i = 0; i < fArr.length / 3; i++) {
            arrayList.add(new Point3D(fArr[i * 3], fArr[(i * 3) + 1], fArr[(i * 3) + 2]));
        }
        AppMethodBeat.m2505o(84152);
        return arrayList;
    }

    public static List<PointF> arrayToPointList(int[][] iArr) {
        AppMethodBeat.m2504i(84153);
        ArrayList arrayList = new ArrayList();
        if (iArr == null) {
            AppMethodBeat.m2505o(84153);
            return arrayList;
        }
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new PointF((float) iArr[i][0], (float) iArr[i][1]));
        }
        AppMethodBeat.m2505o(84153);
        return arrayList;
    }

    public static float[] listToArray(List<Float> list) {
        int i = 0;
        AppMethodBeat.m2504i(84154);
        if (list == null) {
            float[] fArr = new float[0];
            AppMethodBeat.m2505o(84154);
            return fArr;
        }
        float[] fArr2 = new float[list.size()];
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                fArr2[i2] = ((Float) list.get(i2)).floatValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(84154);
                return fArr2;
            }
        }
    }

    public static float[] toFlatArray(PointF[] pointFArr) {
        if (pointFArr == null) {
            return new float[0];
        }
        try {
            float[] fArr = new float[(pointFArr.length * 2)];
            for (int i = 0; i < pointFArr.length; i++) {
                if (pointFArr[i] != null) {
                    fArr[i * 2] = pointFArr[i].x;
                    fArr[(i * 2) + 1] = pointFArr[i].y;
                }
            }
            return fArr;
        } catch (OutOfMemoryError e) {
            return new float[0];
        }
    }

    public static float[] toFlatArray(List<PointF> list) {
        int i = 0;
        AppMethodBeat.m2504i(84155);
        if (list == null) {
            float[] fArr = new float[0];
            AppMethodBeat.m2505o(84155);
            return fArr;
        }
        float[] fArr2 = new float[(list.size() * 2)];
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                PointF pointF = (PointF) list.get(i2);
                if (pointF != null) {
                    fArr2[i2 * 2] = pointF.x;
                    fArr2[(i2 * 2) + 1] = pointF.y;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(84155);
                return fArr2;
            }
        }
    }

    public static void flipYPoints(List<PointF> list, int i) {
    }

    public static float[] flipYPoints(float[] fArr, int i) {
        return fArr;
    }

    public static boolean isValidOutputFile(String str) {
        AppMethodBeat.m2504i(84156);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(84156);
            return false;
        }
        boolean exists = new File(str).exists();
        AppMethodBeat.m2505o(84156);
        return exists;
    }

    public static List<PointF> copyList(List<PointF> list) {
        AppMethodBeat.m2504i(84157);
        if (list == null) {
            AppMethodBeat.m2505o(84157);
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (PointF pointF : list) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        AppMethodBeat.m2505o(84157);
        return arrayList;
    }

    public static int copyList(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.m2504i(84158);
        if (list2 == null || list == null) {
            AppMethodBeat.m2505o(84158);
            return -1;
        }
        int size = list2.size();
        int i = 0;
        while (i < list.size()) {
            ((PointF) list.get(i)).x = ((PointF) list2.get(i)).x;
            ((PointF) list.get(i)).y = ((PointF) list2.get(i)).y;
            i++;
        }
        while (i < size) {
            list.add(new PointF(((PointF) list2.get(i)).x, ((PointF) list2.get(i)).y));
            i++;
        }
        AppMethodBeat.m2505o(84158);
        return 0;
    }

    public static void updatePointList(List<PointF> list, List<PointF> list2) {
        AppMethodBeat.m2504i(84159);
        if (list2 == null) {
            AppMethodBeat.m2505o(84159);
            return;
        }
        List list3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        int size = list2.size();
        while (list3.size() > size) {
            list3.remove(list3.size() - 1);
        }
        while (list3.size() < size) {
            list3.add(new PointF());
        }
        for (int i = 0; i < size; i++) {
            ((PointF) list3.get(i)).x = ((PointF) list2.get(i)).x;
            ((PointF) list3.get(i)).y = ((PointF) list2.get(i)).y;
        }
        AppMethodBeat.m2505o(84159);
    }

    public static void updatePointListOfList(List<List<PointF>> list, List<List<PointF>> list2) {
        AppMethodBeat.m2504i(84160);
        if (list2 == null) {
            AppMethodBeat.m2505o(84160);
            return;
        }
        List list3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        int size = list2.size();
        while (list3.size() > size) {
            list3.remove(list3.size() - 1);
        }
        while (list3.size() < size) {
            list3.add(new ArrayList());
        }
        for (int i = 0; i < size; i++) {
            updatePointList((List) list3.get(i), (List) list2.get(i));
        }
        AppMethodBeat.m2505o(84160);
    }

    public static boolean needCopyTransform() {
        AppMethodBeat.m2504i(84161);
        String trim = DeviceInstance.getInstance().getDeviceName().trim();
        if (!TextUtils.isEmpty(trim)) {
            for (String toLowerCase : DEVICE_NEED_COPY_TRANSFORM) {
                if (trim.toLowerCase().endsWith(toLowerCase.toLowerCase())) {
                    AppMethodBeat.m2505o(84161);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(84161);
        return false;
    }

    public static boolean needSmallSize() {
        AppMethodBeat.m2504i(84162);
        String trim = DeviceInstance.getInstance().getDeviceName().trim();
        if (!TextUtils.isEmpty(trim)) {
            for (String toLowerCase : DEVICE_NEED_SMALL_SIZE) {
                if (trim.toLowerCase().endsWith(toLowerCase.toLowerCase())) {
                    AppMethodBeat.m2505o(84162);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(84162);
        return false;
    }

    public static void sort(List<StickerItem> list) {
        AppMethodBeat.m2504i(84163);
        if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.m2505o(84163);
            return;
        }
        Collections.sort(list, new C244981());
        AppMethodBeat.m2505o(84163);
    }

    public static void copyListToArray(List<PointF> list, PointF[] pointFArr) {
        AppMethodBeat.m2504i(84164);
        if (BaseUtils.isEmpty(list) || pointFArr == null) {
            AppMethodBeat.m2505o(84164);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < Math.min(list.size(), pointFArr.length)) {
                pointFArr[i2].x = ((PointF) list.get(i2)).x;
                pointFArr[i2].y = ((PointF) list.get(i2)).y;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(84164);
                return;
            }
        }
    }

    public static void copyArrayToArray(PointF[] pointFArr, PointF[] pointFArr2) {
        AppMethodBeat.m2504i(84165);
        if (pointFArr == null || pointFArr2 == null) {
            AppMethodBeat.m2505o(84165);
            return;
        }
        for (int i = 0; i < Math.min(pointFArr.length, pointFArr2.length); i++) {
            pointFArr2[i].x = pointFArr[i].x;
            pointFArr2[i].y = pointFArr[i].y;
        }
        AppMethodBeat.m2505o(84165);
    }

    public static boolean isDistortionFilter(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84166);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84166);
            return false;
        } else if (videoMaterial.getShaderType() != SHADER_TYPE.NORMAL.value) {
            AppMethodBeat.m2505o(84166);
            return true;
        } else {
            AppMethodBeat.m2505o(84166);
            return false;
        }
    }

    public static List<VideoMaterialMetaData> loadLocalMaterials() {
        AppMethodBeat.m2504i(84167);
        List<VideoMaterialMetaData> buildVideoMaterials = VideoLocalDataInitializer.buildVideoMaterials();
        if (buildVideoMaterials == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(84167);
            return arrayList;
        }
        for (VideoMaterialMetaData videoMaterialMetaData : buildVideoMaterials) {
            if (TextUtils.isEmpty(videoMaterialMetaData.path)) {
                videoMaterialMetaData.path = VideoPrefsUtil.getDefaultPrefs().getString(videoMaterialMetaData.f3495id, "");
            }
        }
        AppMethodBeat.m2505o(84167);
        return buildVideoMaterials;
    }

    public static String getMaterialId(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(84168);
        if (str == null) {
            AppMethodBeat.m2505o(84168);
        } else {
            String[] split = str.split(File.separator);
            for (int length = split.length - 1; length >= 0; length--) {
                if (!TextUtils.isEmpty(split[length])) {
                    str2 = split[length];
                    break;
                }
            }
            AppMethodBeat.m2505o(84168);
        }
        return str2;
    }

    public static String getMusicMaterialM4aPath(String str) {
        AppMethodBeat.m2504i(84169);
        if (str == null) {
            AppMethodBeat.m2505o(84169);
            return null;
        }
        String str2 = str + File.separator + getMaterialId(str) + MediaConfig.VIDEO_AAC_FILE_POSTFIX;
        AppMethodBeat.m2505o(84169);
        return str2;
    }

    public static void saveVideoMaterialToImages(String str) {
        AppMethodBeat.m2504i(84170);
        String materialId = getMaterialId(str);
        if (materialId == null || !materialId.startsWith("video_")) {
            AppMethodBeat.m2505o(84170);
            return;
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(84170);
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                File[] listFiles2 = file.listFiles(new C244992());
                if (listFiles2 != null) {
                    int length = listFiles2.length;
                    int i = 0;
                    while (i < length) {
                        File file2 = listFiles2[i];
                        try {
                            FileUtils.deleteFiles(file.getAbsolutePath(), ".png");
                            int[] videoIndexMap = getVideoIndexMap(file2.getAbsolutePath());
                            ArrayList arrayList = new ArrayList();
                            int i2 = 0;
                            while (true) {
                                arrayList.clear();
                                for (int i3 = 0; i3 < videoIndexMap.length; i3++) {
                                    if (videoIndexMap[i3] == i2) {
                                        arrayList.add(file.getAbsolutePath() + File.separator + getMaterialId(file.getAbsolutePath()) + "_" + i3 + ".png");
                                    }
                                }
                                i2++;
                            }
                        } catch (Exception e) {
                            C16371i.m25188m(TAG, e.toString());
                            i++;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.m2505o(84170);
    }

    public static int getAllImageSize(String str) {
        int i = 0;
        AppMethodBeat.m2504i(84171);
        String[] list;
        Point bitmapSize;
        if (str.startsWith("assets://")) {
            try {
                list = VideoGlobalContext.getContext().getAssets().list(FileUtils.getRealPath(str));
                if (list == null || list.length == 0) {
                    AppMethodBeat.m2505o(84171);
                } else {
                    bitmapSize = BitmapUtils.getBitmapSize(VideoGlobalContext.getContext(), str + File.separator + list[0]);
                    if (bitmapSize == null) {
                        AppMethodBeat.m2505o(84171);
                    } else {
                        i = (list.length * ((bitmapSize.y * bitmapSize.x) * 4)) + 0;
                        AppMethodBeat.m2505o(84171);
                    }
                }
            } catch (IOException e) {
            }
        } else {
            list = new File(str).list(mPngFilter);
            if (list == null || list.length == 0) {
                AppMethodBeat.m2505o(84171);
            } else {
                bitmapSize = BitmapUtils.getBitmapSize(VideoGlobalContext.getContext(), str + File.separator + list[i]);
                if (bitmapSize == null) {
                    AppMethodBeat.m2505o(84171);
                } else {
                    i = (((bitmapSize.x * bitmapSize.y) * 4) * list.length) + 0;
                    AppMethodBeat.m2505o(84171);
                }
            }
        }
        return i;
    }

    public static int getAllImageSize(VideoMaterial videoMaterial) {
        int i = 0;
        AppMethodBeat.m2504i(84172);
        if (videoMaterial == null || videoMaterial.getDataPath() == null) {
            AppMethodBeat.m2505o(84172);
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            arrayList.addAll(videoMaterial.getItemList());
        }
        if (videoMaterial.getHeadCropItemList() != null) {
            arrayList.addAll(videoMaterial.getHeadCropItemList());
        }
        Iterator it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = getAllImageSize(videoMaterial.getDataPath() + File.separator + ((StickerItem) it.next()).subFolder) + i2;
            } else {
                AppMethodBeat.m2505o(84172);
                return i2;
            }
        }
    }

    public static boolean isCpValueMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84173);
        if (videoMaterial != null) {
            List<StickerItem> itemList = videoMaterial.getItemList();
            if (itemList != null) {
                for (StickerItem stickerItem : itemList) {
                    if (stickerItem.markMode != DETECT_TYPE.DETECT_TYPE_CP.value) {
                        if (stickerItem.cpRange != null) {
                        }
                    }
                    AppMethodBeat.m2505o(84173);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(84173);
        return false;
    }

    public static boolean isWatermarkMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84174);
        if (videoMaterial != null) {
            List<StickerItem> itemList = videoMaterial.getItemList();
            if (itemList != null) {
                for (StickerItem stickerItem : itemList) {
                    if (stickerItem.stickerType == STICKER_TYPE.WATERMARK.type) {
                        AppMethodBeat.m2505o(84174);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84174);
        return false;
    }

    public static boolean isWatermarkEditable(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84175);
        if (videoMaterial != null) {
            List<StickerItem> itemList = videoMaterial.getItemList();
            if (itemList != null) {
                for (StickerItem stickerItem : itemList) {
                    if (stickerItem.wmGroup != null) {
                        for (WMElement wMElement : stickerItem.wmGroup.wmElements) {
                            if (wMElement.edittype == 1) {
                                AppMethodBeat.m2505o(84175);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84175);
        return false;
    }

    public static boolean isEmojiMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84176);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84176);
            return false;
        } else if (videoMaterial.getCategoryFlag() == CATEGORY_TYPE.EMOJI.value) {
            AppMethodBeat.m2505o(84176);
            return true;
        } else {
            AppMethodBeat.m2505o(84176);
            return false;
        }
    }

    public static boolean isChangeFaceMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84177);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84177);
            return false;
        } else if (videoMaterial.getShaderType() == 5 && videoMaterial.getFaceoffType() == 1) {
            AppMethodBeat.m2505o(84177);
            return true;
        } else {
            AppMethodBeat.m2505o(84177);
            return false;
        }
    }

    public static boolean isFaceSwitchMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84178);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84178);
            return false;
        } else if ((videoMaterial.getShaderType() == SHADER_TYPE.FACE_SWITCH.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_SWITCH_DUP.value) && videoMaterial.getFaceSwapType() == FACE_SWAP_TYPE.FACE_SWITCH.value) {
            AppMethodBeat.m2505o(84178);
            return true;
        } else {
            AppMethodBeat.m2505o(84178);
            return false;
        }
    }

    public static boolean isFaceCopyMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84179);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84179);
            return false;
        } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_COPY.value || (videoMaterial.getShaderType() == SHADER_TYPE.FACE_SWITCH.value && videoMaterial.getFaceSwapType() == FACE_SWAP_TYPE.FACE_COPY.value)) {
            AppMethodBeat.m2505o(84179);
            return true;
        } else {
            AppMethodBeat.m2505o(84179);
            return false;
        }
    }

    public static boolean isFaceMorphingMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84180);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84180);
            return false;
        } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_MORPHING.value) {
            AppMethodBeat.m2505o(84180);
            return true;
        } else {
            AppMethodBeat.m2505o(84180);
            return false;
        }
    }

    public static boolean isARMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84181);
        if (videoMaterial == null || videoMaterial.getArParticleList() == null || videoMaterial.getArParticleList().isEmpty()) {
            AppMethodBeat.m2505o(84181);
            return false;
        }
        AppMethodBeat.m2505o(84181);
        return true;
    }

    public static boolean isCosMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84182);
        if (videoMaterial == null || !(videoMaterial.getDetectorFlag() == 1 || videoMaterial.getDetectorFlag() == 2)) {
            AppMethodBeat.m2505o(84182);
            return false;
        }
        AppMethodBeat.m2505o(84182);
        return true;
    }

    public static boolean needOpenRefine(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84183);
        if (videoMaterial == null || !(videoMaterial.getDetectorFlag() == 1 || (videoMaterial.getDetectorFlag() == 2 && VideoModule.getDeviceType() == DeviceType.HIGH))) {
            AppMethodBeat.m2505o(84183);
            return false;
        }
        AppMethodBeat.m2505o(84183);
        return true;
    }

    public static boolean needVoiceChange(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84184);
        if (videoMaterial == null || videoMaterial.getVoicekind() == INVALID_INT_FIELD_VALUE || videoMaterial.getEnvironment() == INVALID_INT_FIELD_VALUE) {
            AppMethodBeat.m2505o(84184);
            return false;
        }
        AppMethodBeat.m2505o(84184);
        return true;
    }

    public static boolean isAudio2textMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84185);
        if (videoMaterial == null || videoMaterial.getAudio2Text() == null || videoMaterial.getAudio2Text().sentenceCount <= 0) {
            AppMethodBeat.m2505o(84185);
            return false;
        }
        AppMethodBeat.m2505o(84185);
        return true;
    }

    public static int getNormalEncodeWidth() {
        AppMethodBeat.m2504i(84186);
        int i;
        if (needSmallSize()) {
            i = ENCODE_SIZE.MEDIUM.width;
            AppMethodBeat.m2505o(84186);
            return i;
        }
        i = VideoPrefsUtil.getNormalEncodeWidth();
        AppMethodBeat.m2505o(84186);
        return i;
    }

    public static boolean needDetectFace(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84187);
        if (videoMaterial == null || videoMaterial.getTriggerType() == 0 || videoMaterial.getTriggerType() == 1) {
            AppMethodBeat.m2505o(84187);
            return false;
        }
        AppMethodBeat.m2505o(84187);
        return true;
    }

    public static boolean supportLandscape(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84188);
        if (videoMaterial == null || !videoMaterial.isSupportLandscape()) {
            AppMethodBeat.m2505o(84188);
            return false;
        }
        AppMethodBeat.m2505o(84188);
        return true;
    }

    public static boolean isDownloaded(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84189);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84189);
            return false;
        }
        boolean startsWith = videoMaterial.getDataPath().startsWith("/");
        AppMethodBeat.m2505o(84189);
        return startsWith;
    }

    public static void updateSupportLandscape(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84190);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84190);
            return;
        }
        if (videoMaterial.getShaderType() == SHADER_TYPE.MAI_MENG.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_CROP.value || isFaceMorphingMaterial(videoMaterial)) {
            videoMaterial.setSupportLandscape(false);
        }
        AppMethodBeat.m2505o(84190);
    }

    public static void updateMaxFaceCount(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84191);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84191);
            return;
        }
        if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_CROP.value) {
            videoMaterial.setMaxFaceCount(1);
        }
        AppMethodBeat.m2505o(84191);
    }

    public static void updateFaceValueDetectType(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84192);
        if (videoMaterial == null || videoMaterial.getItemList() == null) {
            AppMethodBeat.m2505o(84192);
            return;
        }
        int i = 0;
        Iterator it = videoMaterial.getItemList().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                StickerItem stickerItem = (StickerItem) it.next();
                if (stickerItem.ageRange != null) {
                    i2 |= 1;
                }
                if (stickerItem.genderRange != null) {
                    i2 |= 2;
                }
                if (stickerItem.popularRange != null) {
                    i2 |= 4;
                }
                if (stickerItem.cpRange != null) {
                    i2 |= 8;
                }
                i = stickerItem.markMode | i2;
            } else {
                videoMaterial.setFaceValueDetectType(i2);
                AppMethodBeat.m2505o(84192);
                return;
            }
        }
    }

    public static void updateItemImageType(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84193);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84193);
            return;
        }
        ArrayList<StickerItem> arrayList = new ArrayList();
        if (videoMaterial.getItemList() != null) {
            arrayList.addAll(videoMaterial.getItemList());
        }
        if (videoMaterial.getFaceFeatureItemList() != null) {
            for (FaceFeatureItem faceFeatureItem : videoMaterial.getFaceFeatureItemList()) {
                if (!(faceFeatureItem == null || faceFeatureItem.getFaceOffItemList() == null)) {
                    arrayList.addAll(faceFeatureItem.getStickerItems());
                }
            }
        }
        if (videoMaterial.getHeadCropItemList() != null) {
            arrayList.addAll(videoMaterial.getHeadCropItemList());
        }
        if (videoMaterial.getFabbyParts() != null) {
            for (FabbyMvPart fabbyMvPart : videoMaterial.getFabbyParts().getParts()) {
                if (fabbyMvPart.bgItem != null) {
                    arrayList.add(fabbyMvPart.bgItem);
                }
                if (fabbyMvPart.fgItem != null) {
                    arrayList.add(fabbyMvPart.fgItem);
                }
                if (fabbyMvPart.coverItem != null) {
                    arrayList.add(fabbyMvPart.coverItem);
                }
                if (fabbyMvPart.transitionItem != null) {
                    arrayList.add(fabbyMvPart.transitionItem);
                }
            }
        }
        for (StickerItem stickerItem : arrayList) {
            if (stickerItem.sourceType == null) {
                stickerItem.sourceType = ITEM_SOURCE_TYPE.IMAGE;
            }
        }
        List<StickerItem> itemList3D = videoMaterial.getItemList3D();
        if (itemList3D != null) {
            for (StickerItem stickerItem2 : itemList3D) {
                if (stickerItem2.sourceType == null) {
                    stickerItem2.sourceType = ITEM_SOURCE_TYPE.IMAGE;
                }
            }
        }
        AppMethodBeat.m2505o(84193);
    }

    public static void updateWatermarkInfo(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84194);
        if (videoMaterial == null || videoMaterial.getItemList() == null) {
            AppMethodBeat.m2505o(84194);
            return;
        }
        for (StickerItem stickerItem : videoMaterial.getItemList()) {
            if (stickerItem.wmGroup != null) {
                stickerItem.wmGroup.setItemId(stickerItem.f18271id);
                stickerItem.wmGroup.setSize(stickerItem.width, stickerItem.height);
            }
            if (stickerItem.wmGroupCopies != null) {
                for (WMGroup wMGroup : stickerItem.wmGroupCopies) {
                    wMGroup.setItemId(stickerItem.f18271id);
                    wMGroup.setSize(stickerItem.width, stickerItem.height);
                }
            }
        }
        AppMethodBeat.m2505o(84194);
    }

    public static void updateNeedFaceInfo(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84195);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84195);
        } else if (videoMaterial.getShaderType() == SHADER_TYPE.CUSTOM_BEFORE_COMMON.value || videoMaterial.getShaderType() == SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_OFF.value || videoMaterial.getShaderType() == SHADER_TYPE.TRANSFORM.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_SWITCH.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_OFF_TRANSFORM.value || videoMaterial.getShaderType() == SHADER_TYPE.THREE_DIM.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_SWITCH_DUP.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_COPY.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_MORPHING.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_HEAD_CROP.value || videoMaterial.getShaderType() == SHADER_TYPE.FACE_CROP.value || videoMaterial.getShaderType() == SHADER_TYPE.MAI_MENG.value || videoMaterial.getShaderType() == SHADER_TYPE.GAMEPLAY_3D.value) {
            videoMaterial.setNeedFaceInfo(true);
            AppMethodBeat.m2505o(84195);
        } else {
            if (videoMaterial.getItemList() != null) {
                for (StickerItem stickerItem : videoMaterial.getItemList()) {
                    if (stickerItem.type == POSITION_TYPE.STATIC.type || stickerItem.type == POSITION_TYPE.DYNAMIC.type) {
                        videoMaterial.setNeedFaceInfo(true);
                        AppMethodBeat.m2505o(84195);
                        return;
                    } else if (isFaceTriggerType(stickerItem.triggerType)) {
                        videoMaterial.setNeedFaceInfo(true);
                        AppMethodBeat.m2505o(84195);
                        return;
                    }
                }
            }
            videoMaterial.setNeedFaceInfo(false);
            AppMethodBeat.m2505o(84195);
        }
    }

    public static void updateNeedBodyInfo(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84196);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84196);
            return;
        }
        if (videoMaterial.getItemList() != null) {
            for (StickerItem stickerItem : videoMaterial.getItemList()) {
                if (stickerItem.type == POSITION_TYPE.BODY.type) {
                    videoMaterial.setNeedBodyInfo(true);
                    AppMethodBeat.m2505o(84196);
                    return;
                } else if (isBodyTriggerType(stickerItem.triggerType)) {
                    videoMaterial.setNeedBodyInfo(true);
                    AppMethodBeat.m2505o(84196);
                    return;
                }
            }
        }
        videoMaterial.setNeedBodyInfo(false);
        AppMethodBeat.m2505o(84196);
    }

    public static int calSampleSize(long j, long j2, int i) {
        if (j <= 0) {
            return 128;
        }
        int i2 = i;
        while (j2 > j) {
            i2 <<= 1;
            j2 >>= 2;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A:{SYNTHETIC, Splitter:B:25:0x0061} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A:{SYNTHETIC, Splitter:B:31:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] getVideoIndexMap(String str) {
        Throwable th;
        AppMethodBeat.m2504i(84197);
        int[] iArr = new int[0];
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                long length = randomAccessFile.length();
                randomAccessFile.seek(length - 4);
                byte[] bArr = new byte[4];
                randomAccessFile.read(bArr);
                int readInt = ByteUtil.readInt(bArr);
                if (readInt <= 12 || readInt >= 400) {
                    randomAccessFile.close();
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(84197);
                    return iArr;
                }
                randomAccessFile.seek((length - ((long) readInt)) + 8);
                int i = (readInt - 12) / 4;
                iArr = new int[i];
                for (readInt = 0; readInt < i; readInt++) {
                    randomAccessFile.read(bArr);
                    iArr[readInt] = ByteUtil.readInt(bArr);
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(84197);
                return iArr;
            } catch (Exception e3) {
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(84197);
                return iArr;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(84197);
                throw th;
            }
        } catch (Exception e4) {
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.m2505o(84197);
            return iArr;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(84197);
            throw th;
        }
    }

    public static ITEM_SOURCE_TYPE getItemSourceType(int i) {
        if (i == 1) {
            return ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
        }
        if (i == 2) {
            return ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
        }
        return ITEM_SOURCE_TYPE.VIDEO_NORMAL;
    }

    public static boolean isHeadCropMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84198);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84198);
            return false;
        } else if (videoMaterial.getShaderType() == SHADER_TYPE.FACE_HEAD_CROP.value) {
            AppMethodBeat.m2505o(84198);
            return true;
        } else {
            AppMethodBeat.m2505o(84198);
            return false;
        }
    }

    public static boolean isFaceItem(StickerItem stickerItem) {
        return stickerItem != null && (stickerItem.type == POSITION_TYPE.STATIC.type || stickerItem.type == POSITION_TYPE.DYNAMIC.type || stickerItem.type == POSITION_TYPE.RELATIVE.type);
    }

    public static boolean isGestureItem(StickerItem stickerItem) {
        return stickerItem != null && stickerItem.type == POSITION_TYPE.GESTURE.type;
    }

    public static boolean isBodyDetectItem(StickerItem stickerItem) {
        return stickerItem != null && stickerItem.type == POSITION_TYPE.BODY.type;
    }

    public static boolean isGestureCountTriggerItem(StickerItem stickerItem) {
        return stickerItem != null && 200 <= stickerItem.countTriggerType && stickerItem.countTriggerType <= 211;
    }

    public static boolean isFaceCountTriggerItem(StickerItem stickerItem) {
        return stickerItem != null && 2 <= stickerItem.countTriggerType && stickerItem.countTriggerType <= 107;
    }

    public static boolean isFaceTriggerType(int i) {
        return i < 200;
    }

    public static boolean isGestureTriggerType(int i) {
        return 200 <= i && i <= 213;
    }

    public static boolean isAudioTextTriggerType(int i) {
        return 300 <= i && i <= C31128d.MIC_PTU_HONGKONG;
    }

    public static boolean isBodyDetectType(int i) {
        return i == 400;
    }

    public static boolean isBodyTriggerType(int i) {
        return i == 401;
    }

    public static boolean canStickerItemUseFastRender(StickerItem stickerItem) {
        return ENABLE_FAST_RENDER && stickerItem != null && stickerItem.markMode == 0 && stickerItem.personID < 0 && stickerItem.stickerType == 0 && ((stickerItem.type == POSITION_TYPE.DYNAMIC.type || stickerItem.type == POSITION_TYPE.BODY.type) && ((stickerItem.blendMode < 2 || stickerItem.blendMode > 12) && stickerItem.zIndex == 0 && stickerItem.charmRange == null && stickerItem.ageRange == null && stickerItem.popularRange == null && stickerItem.genderRange == null && stickerItem.cpRange == null && stickerItem.randomGroupNum == 0 && stickerItem.audioTriggerType == 0 && stickerItem.particleConfig == null));
    }

    public static boolean canStickerItemUseFastFaceRender(StickerItem stickerItem) {
        AppMethodBeat.m2504i(84199);
        if (canStickerItemUseFastRender(stickerItem) && stickerItem.type == POSITION_TYPE.DYNAMIC.type) {
            AppMethodBeat.m2505o(84199);
            return true;
        }
        AppMethodBeat.m2505o(84199);
        return false;
    }

    public static boolean canStickerItemUseFastBodyRender(StickerItem stickerItem) {
        AppMethodBeat.m2504i(84200);
        if (canStickerItemUseFastRender(stickerItem) && stickerItem.type == POSITION_TYPE.BODY.type) {
            AppMethodBeat.m2505o(84200);
            return true;
        }
        AppMethodBeat.m2505o(84200);
        return false;
    }

    public static boolean canMaterialUseFastRender(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84201);
        int i = 0;
        for (StickerItem canStickerItemUseFastRender : videoMaterial.getItemList()) {
            int i2;
            if (canStickerItemUseFastRender(canStickerItemUseFastRender)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i <= 7) {
            AppMethodBeat.m2505o(84201);
            return true;
        }
        AppMethodBeat.m2505o(84201);
        return false;
    }

    public static boolean is3DMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84202);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84202);
            return false;
        } else if (videoMaterial.getGameParams() != null) {
            AppMethodBeat.m2505o(84202);
            return true;
        } else {
            AppMethodBeat.m2505o(84202);
            return false;
        }
    }

    public static boolean needFaceTips(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84203);
        if (videoMaterial == null) {
            AppMethodBeat.m2505o(84203);
            return false;
        }
        List<StickerItem> itemList = videoMaterial.getItemList();
        if (itemList == null) {
            AppMethodBeat.m2505o(84203);
            return false;
        }
        for (StickerItem stickerItem : itemList) {
            if (stickerItem.triggerType >= 2) {
                AppMethodBeat.m2505o(84203);
                return true;
            }
        }
        AppMethodBeat.m2505o(84203);
        return false;
    }

    public static boolean isEmptyItem(StickerItem stickerItem) {
        AppMethodBeat.m2504i(84204);
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.f18271id) || stickerItem.f18271id.equals(NativeProtocol.WEB_DIALOG_ACTION) || stickerItem.f18271id.equals(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
            AppMethodBeat.m2505o(84204);
            return true;
        }
        AppMethodBeat.m2505o(84204);
        return false;
    }

    public static boolean isEmptyItem(FaceItem faceItem) {
        AppMethodBeat.m2504i(84205);
        if (faceItem == null || ((TextUtils.isEmpty(faceItem.f3494id) && TextUtils.isEmpty(faceItem.faceExchangeImage)) || ((!TextUtils.isEmpty(faceItem.f3494id) && faceItem.f3494id.equals(NativeProtocol.WEB_DIALOG_ACTION)) || (!TextUtils.isEmpty(faceItem.f3494id) && faceItem.f3494id.equals(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE))))) {
            AppMethodBeat.m2505o(84205);
            return true;
        }
        AppMethodBeat.m2505o(84205);
        return false;
    }

    public static boolean hasValidFaceOffItem(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84206);
        if (!(videoMaterial == null || videoMaterial.getFaceOffItemList() == null)) {
            for (FaceItem isEmptyItem : videoMaterial.getFaceOffItemList()) {
                if (!isEmptyItem(isEmptyItem)) {
                    AppMethodBeat.m2505o(84206);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(84206);
        return false;
    }

    public static int[][] listToIntArray(List<PointF> list) {
        AppMethodBeat.m2504i(84207);
        int[][] iArr;
        if (list == null) {
            iArr = new int[0][];
            AppMethodBeat.m2505o(84207);
            return iArr;
        }
        iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{list.size(), 2});
        for (int i = 0; i < list.size(); i++) {
            iArr[i][0] = (int) ((PointF) list.get(i)).x;
            iArr[i][1] = (int) ((PointF) list.get(i)).y;
        }
        AppMethodBeat.m2505o(84207);
        return iArr;
    }

    public static boolean isBodyDetectMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84208);
        if (videoMaterial != null) {
            List itemList = videoMaterial.getItemList();
            List<StickerItem3D> itemList3D = videoMaterial.getItemList3D();
            List headCropItemList = videoMaterial.getHeadCropItemList();
            List<FaceItem> faceOffItemList = videoMaterial.getFaceOffItemList();
            ArrayList<StickerItem> arrayList = new ArrayList();
            if (itemList != null) {
                arrayList.addAll(itemList);
            }
            if (headCropItemList != null) {
                arrayList.addAll(headCropItemList);
            }
            for (StickerItem stickerItem : arrayList) {
                if (stickerItem.type == POSITION_TYPE.BODY.type) {
                    AppMethodBeat.m2505o(84208);
                    return true;
                } else if (isBodyTriggerType(stickerItem.triggerType)) {
                    AppMethodBeat.m2505o(84208);
                    return true;
                }
            }
            if (faceOffItemList != null) {
                for (FaceItem faceItem : faceOffItemList) {
                    if (isBodyTriggerType(faceItem.triggerType)) {
                        AppMethodBeat.m2505o(84208);
                        return true;
                    }
                }
            }
            if (itemList3D != null) {
                for (StickerItem3D stickerItem3D : itemList3D) {
                    if (stickerItem3D.type == POSITION_TYPE.BODY.type) {
                        AppMethodBeat.m2505o(84208);
                        return true;
                    } else if (isBodyTriggerType(stickerItem3D.triggerType)) {
                        AppMethodBeat.m2505o(84208);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84208);
        return false;
    }

    public static boolean isSegmentMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84209);
        if (videoMaterial == null || !videoMaterial.isSegmentRequired()) {
            AppMethodBeat.m2505o(84209);
            return false;
        }
        AppMethodBeat.m2505o(84209);
        return true;
    }

    public static boolean isGestureDetectMaterial(VideoMaterial videoMaterial) {
        AppMethodBeat.m2504i(84210);
        if (videoMaterial != null) {
            List itemList = videoMaterial.getItemList();
            List<StickerItem3D> itemList3D = videoMaterial.getItemList3D();
            List headCropItemList = videoMaterial.getHeadCropItemList();
            List<FaceItem> faceOffItemList = videoMaterial.getFaceOffItemList();
            ArrayList<StickerItem> arrayList = new ArrayList();
            if (itemList != null) {
                arrayList.addAll(itemList);
            }
            if (headCropItemList != null) {
                arrayList.addAll(headCropItemList);
            }
            for (StickerItem stickerItem : arrayList) {
                if (stickerItem.type == POSITION_TYPE.GESTURE.type) {
                    AppMethodBeat.m2505o(84210);
                    return true;
                } else if (isGestureTriggerType(stickerItem.triggerType)) {
                    AppMethodBeat.m2505o(84210);
                    return true;
                }
            }
            if (faceOffItemList != null) {
                for (FaceItem faceItem : faceOffItemList) {
                    if (isGestureTriggerType(faceItem.triggerType)) {
                        AppMethodBeat.m2505o(84210);
                        return true;
                    }
                }
            }
            if (itemList3D != null) {
                for (StickerItem3D stickerItem3D : itemList3D) {
                    if (stickerItem3D.type == POSITION_TYPE.GESTURE.type) {
                        AppMethodBeat.m2505o(84210);
                        return true;
                    } else if (isGestureTriggerType(stickerItem3D.triggerType)) {
                        AppMethodBeat.m2505o(84210);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(84210);
        return false;
    }
}
