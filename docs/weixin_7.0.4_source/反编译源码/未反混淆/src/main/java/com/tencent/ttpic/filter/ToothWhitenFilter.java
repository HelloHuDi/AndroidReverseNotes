package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.filter.m.f;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.Map;

public class ToothWhitenFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ToothWhitenFragmentShader.dat");
    private static String LUT_FILE = "assets://luts/teethLUT.png";
    private static final String MASK_COORDS = "assets://mask/coords/toothwhite.tsv";
    private static String MASK_FILE = "assets://mask/images/toothmask.png";
    private static final String TAG = ToothWhitenFilter.class.getSimpleName();
    private static final String VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ToothWhitenVertexShader.dat");
    private FaceParam faceParam;
    private float[] faceVertices = new float[1380];
    private Bitmap inputWhiteBitmap;
    private Bitmap maskBitmap;
    private int maskHeight;
    private float[] maskTexCoords = new float[1380];
    private int maskWidth;
    private float whiteTeeth = 0.0f;

    static {
        AppMethodBeat.i(83019);
        AppMethodBeat.o(83019);
    }

    public ToothWhitenFilter(FaceParam faceParam) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(83011);
        this.faceParam = faceParam;
        initBitmaps();
        initParams();
        AppMethodBeat.o(83011);
    }

    public void initParams() {
        AppMethodBeat.i(83012);
        addParam(new f("whiteTeeth", this.whiteTeeth));
        addParam(new k("inputMaskTexture", this.maskBitmap, 33986, true));
        addParam(new k("inputWhiteTeethLutTexture", this.inputWhiteBitmap, 33987, true));
        AppMethodBeat.o(83012);
    }

    public void initAttribParams() {
        AppMethodBeat.i(83013);
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(690);
        setRenderMode(2);
        initMaskCoords();
        initPositions(this.faceParam);
        AppMethodBeat.o(83013);
    }

    public void clearGLSLSelf() {
        AppMethodBeat.i(83014);
        super.clearGLSLSelf();
        BitmapUtils.recycle(this.maskBitmap);
        BitmapUtils.recycle(this.inputWhiteBitmap);
        LogUtils.d(TAG, "[clearGLSLSelf] delete texture, recycle bmp");
        AppMethodBeat.o(83014);
    }

    public void setParam(Map<String, Object> map) {
        AppMethodBeat.i(83015);
        if (map.containsKey("whiteTeeth")) {
            this.whiteTeeth = ((Float) map.get("whiteTeeth")).floatValue();
        }
        this.whiteTeeth /= 200.0f;
        addParam(new f("whiteTeeth", this.whiteTeeth));
        AppMethodBeat.o(83015);
    }

    private void initBitmaps() {
        AppMethodBeat.i(83016);
        this.maskBitmap = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(MASK_FILE), BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.maskBitmap != null) {
            this.maskWidth = this.maskBitmap.getWidth();
            this.maskHeight = this.maskBitmap.getHeight();
        }
        this.inputWhiteBitmap = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath(LUT_FILE), BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER);
        AppMethodBeat.o(83016);
    }

    private void initMaskCoords() {
        AppMethodBeat.i(83017);
        this.maskTexCoords = FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.loadTexCoords(MASK_COORDS), 2.0f), this.maskWidth, this.maskHeight, this.maskTexCoords);
        addAttribParam("inputTextureCoordinate", this.maskTexCoords, true);
        AppMethodBeat.o(83017);
    }

    private void initPositions(FaceParam faceParam) {
        AppMethodBeat.i(83018);
        if (faceParam == null) {
            AppMethodBeat.o(83018);
            return;
        }
        int[][] iArr = faceParam.bJr;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            arrayList.add(new PointF((float) iArr[i][0], (float) iArr[i][1]));
        }
        FaceDetectUtil.facePointf83to90(arrayList);
        setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(arrayList, 2.0f), faceParam.width, faceParam.height, this.faceVertices));
        AppMethodBeat.o(83018);
    }
}
