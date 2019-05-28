package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoTemplateParser;
import java.io.File;
import java.util.List;

public class FaceFeatureFilterReshape extends VideoFilterBase {
    private static final String CONTENT = "{\n  \"minAppVersion\": 400,\n  \"shaderType\": 5,\n  \"maxFaceCount\": 10,\n  \"faceOffType\": 0,\n  \"faceOffItemList\": [\n  {\n    \"faceExchangeImage\": \"beauty_normal.png\",\n    \"blendAlpha\":1.0,\n    \"featureType\": 0,\n    \"grayScale\": 0,\n\t\"blendMode\": 1,\n\t\"facePoints\": [\n156.88185140529998, 528.1364190166,\n  169.5493300902, 595.3714981903,\n  181.24238733779998, 649.9390986791,\n  191.9610231481, 695.7369062322,\n  214.372716206, 738.6114494734,\n  238.7332521385, 776.6138855281,\n  277.71010963049997, 811.6930572709,\n  311.814859936, 843.8489647018,\n  351.7661388653, 868.2095006343,\n  398.53836785569996, 876.97929357,\n  445.3105968461, 866.2606577596999,\n  491.10840439919997, 841.9001218272,\n  528.1364190166, 807.7953715217,\n  558.3434835729, 769.792935467,\n  585.6272838172999, 734.7137637242,\n  605.1157125633, 690.8647990457,\n  618.7576126855, 645.0669914926,\n  630.4506699331, 592.4482338784,\n  633.373934245, 524.2387332674,\n  199.75639464649998, 446.2850182834,\n  239.7076735758, 444.3361754088,\n  280.6333739424, 448.23386115799997,\n  321.559074309, 456.0292326564,\n  362.48477467559997, 458.9524969683,\n  327.4056029328, 433.6175395985,\n  283.55663825429997, 425.8221681001,\n  239.7076735758, 425.8221681001,\n  595.3714981903, 445.3105968461,\n  555.4202192609999, 444.3361754088,\n  515.4689403317, 452.1315469072,\n  484.28745433809996, 457.0036540937,\n  438.489646785, 460.9013398429,\n  464.7990255921, 435.56638247309996,\n  508.64799027059996, 422.89890378819996,\n  559.3179050102, 422.89890378819996,\n  241.6565164504, 506.699147396,\n  260.1705237591, 518.3922046435999,\n  285.5054811289, 522.2898903928,\n  309.8660170614, 520.3410475182,\n  336.1753958685, 511.5712545825,\n  317.6613885598, 493.0572472738,\n  287.4543240035, 483.3130329008,\n  263.093788071, 489.1595615246,\n  291.3520097527, 504.7503045214,\n  291.3520097527, 502.80146164679996,\n  558.3434835729, 501.8270402095,\n  537.8806333896, 516.443361769,\n  511.5712545825, 523.2643118300999,\n  487.21071865, 521.3154689555,\n  460.9013398429, 512.5456760198,\n  481.3641900262, 492.0828258365,\n  508.64799027059996, 484.28745433809996,\n  534.9573690777, 488.1851400873,\n  508.64799027059996, 502.80146164679996,\n  508.64799027059996, 500.8526187722,\n  370.280146174, 512.5456760198,\n  366.3824604248, 600.2436053768,\n  340.0730816177, 649.9390986791,\n  370.280146174, 668.4531059878,\n  400.4872107303, 672.350791737,\n  428.745432412, 666.5042631132,\n  458.9524969683, 647.0158343672,\n  432.6431181612, 601.2180268141,\n  430.6942752866, 513.5200974571,\n  400.4872107303, 636.2971985569,\n  312.7892813733, 719.1230207274,\n  489.1595615246, 717.1741778528,\n  335.2009744312, 743.4835566598999,\n  364.4336175502, 759.0742996567,\n  399.51278929299997, 766.8696711550999,\n  434.5919610358, 758.0998782194,\n  464.7990255921, 741.5347137853,\n  442.38733253419997, 736.6626065987999,\n  401.4616321676, 741.5347137853,\n  352.7405603026, 736.6626065987999,\n  346.8940316788, 713.2764921035999,\n  379.0499391097, 710.3532277917,\n  401.4616321676, 714.2509135409,\n  421.9244823509, 713.2764921035999,\n  454.08038978179997, 713.2764921035999,\n  442.38733253419997, 729.8416565377,\n  400.4872107303, 731.7904994122999,\n  354.6894031772, 727.8928136631,\n  400.4872107303, 512.5456760198,\n  404.3848964795, 460.9013398429,\n  400.4872107303, 692.8136419203,\n  205.60292327029998, 205.60292327029998,\n  398.53836785569996, 275.7612667559,\n  598.2947625022, 197.8075517719,\n  400.4872107303, 356.63824605179997\n    ]\n  }\n  \n  ]\n}\n\n";
    private static final String FOLDER = "assets://realtimeBeauty/video_wuguanliti_zhuang";
    public static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceFeatureFragmentShaderReshape.dat");
    private static final String TAG = FaceFeatureFilterReshape.class.getSimpleName();
    public static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceFeatureVertexShader.dat");
    private float alpha;
    private int faceImageHeight;
    private int faceImageWidth;
    private float[] faceVertices;
    private boolean isFaceImageReady;
    private FaceItem item;
    private Bitmap multiplyBitmap;
    private Bitmap normalBitmap;
    private int sampleSize;
    private Bitmap softLightBitmap;
    private float[] texVertices;
    private int[] texture;

    static {
        AppMethodBeat.i(82375);
        AppMethodBeat.o(82375);
    }

    public FaceFeatureFilterReshape() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82360);
        this.faceVertices = new float[1380];
        this.texVertices = new float[1380];
        this.texture = new int[3];
        this.alpha = 0.8f;
        this.item = createFaceItem();
        this.dataPath = FOLDER;
        initParams();
        this.sampleSize = decodeBitmaps();
        AppMethodBeat.o(82360);
    }

    private FaceItem createFaceItem() {
        AppMethodBeat.i(82361);
        FaceItem faceItem = (FaceItem) VideoTemplateParser.parseVideoMaterial(FOLDER, CONTENT, null).getFaceOffItemList().get(0);
        AppMethodBeat.o(82361);
        return faceItem;
    }

    public void initParams() {
        AppMethodBeat.i(82362);
        this.faceImageWidth = this.item.width;
        this.faceImageHeight = this.item.height;
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new n("inputImageTexture3", 0, 33987));
        addParam(new n("inputImageTexture4", 0, 33988));
        addParam(new f("alpha", this.alpha));
        addParam(new b("canvasSize", (float) this.width, (float) this.height));
        addParam(new f("positionRotate", 0.0f));
        AppMethodBeat.o(82362);
    }

    public void setAlphaValue(float f) {
        AppMethodBeat.i(82363);
        this.alpha = f;
        addParam(new f("alpha", this.alpha));
        AppMethodBeat.o(82363);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82364);
        updatePointParams(VideoMaterialUtil.copyList(pTDetectInfo.facePoints));
        updateTextureParams(pTDetectInfo.timestamp);
        AppMethodBeat.o(82364);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82365);
        super.initAttribParams();
        initFaceTexCoords();
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        AppMethodBeat.o(82365);
    }

    private void initFaceTexCoords() {
        AppMethodBeat.i(82366);
        setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 2.0f), this.faceImageWidth, this.faceImageHeight, this.texVertices));
        AppMethodBeat.o(82366);
    }

    public void updateVideoSize(int i, int i2, double d) {
        AppMethodBeat.i(82367);
        super.updateVideoSize(i, i2, d);
        addParam(new b("canvasSize", (float) i, (float) i2));
        AppMethodBeat.o(82367);
    }

    public boolean renderTexture(int i, int i2, int i3) {
        AppMethodBeat.i(82368);
        AttributeParam attribParam = getAttribParam("position");
        if (attribParam == null || attribParam.vertices.length / attribParam.perVertexFloat != 690) {
            AppMethodBeat.o(82368);
            return false;
        }
        attribParam = getAttribParam("inputTextureCoordinate");
        if (attribParam == null || attribParam.vertices.length / attribParam.perVertexFloat != 690) {
            AppMethodBeat.o(82368);
            return false;
        }
        boolean renderTexture = super.renderTexture(i, i2, i3);
        AppMethodBeat.o(82368);
        return renderTexture;
    }

    public void updateTextureParams(long j) {
        AppMethodBeat.i(82369);
        initFaceImage();
        AppMethodBeat.o(82369);
    }

    private boolean initFaceImage() {
        AppMethodBeat.i(82370);
        if (this.isFaceImageReady) {
            AppMethodBeat.o(82370);
            return true;
        }
        if (BitmapUtils.isLegal(this.softLightBitmap)) {
            GlUtil.loadTexture(this.texture[0], this.softLightBitmap);
            this.faceImageWidth = this.softLightBitmap.getWidth() * this.sampleSize;
            this.faceImageHeight = this.softLightBitmap.getHeight() * this.sampleSize;
            initFaceTexCoords();
            addParam(new n("inputImageTexture2", this.texture[0], 33986));
            this.isFaceImageReady = true;
        }
        if (BitmapUtils.isLegal(this.multiplyBitmap)) {
            GlUtil.loadTexture(this.texture[1], this.multiplyBitmap);
            addParam(new n("inputImageTexture3", this.texture[1], 33987));
            this.isFaceImageReady = true;
        }
        if (BitmapUtils.isLegal(this.normalBitmap)) {
            GlUtil.loadTexture(this.texture[2], this.normalBitmap);
            addParam(new n("inputImageTexture4", this.texture[2], 33988));
            this.isFaceImageReady = true;
        }
        boolean z = this.isFaceImageReady;
        AppMethodBeat.o(82370);
        return z;
    }

    private int decodeBitmaps() {
        AppMethodBeat.i(82371);
        this.softLightBitmap = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(this.dataPath + File.separator + "beauty_softlight.png"), 1);
        this.multiplyBitmap = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(this.dataPath + File.separator + "beauty_multiply.png"), 1);
        this.normalBitmap = BitmapUtils.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(this.dataPath + File.separator + "beauty_normal.png"), 1);
        AppMethodBeat.o(82371);
        return 1;
    }

    public void updatePointParams(List<PointF> list) {
        AppMethodBeat.i(82372);
        setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(list), 2.0f), (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        setCoordNum(690);
        AppMethodBeat.o(82372);
    }

    public void ApplyGLSLFilter() {
        AppMethodBeat.i(82373);
        super.ApplyGLSLFilter();
        GLES20.glGenTextures(this.texture.length, this.texture, 0);
        AppMethodBeat.o(82373);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(82374);
        GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
        this.isFaceImageReady = false;
        BitmapUtils.recycle(this.softLightBitmap);
        BitmapUtils.recycle(this.multiplyBitmap);
        BitmapUtils.recycle(this.normalBitmap);
        LogUtils.d(TAG, "[clearGLSLSelf] delete texture, recycle bmp");
        super.clearGLSLSelf();
        AppMethodBeat.o(82374);
    }

    public boolean needRender() {
        return this.alpha > 0.01f;
    }
}
