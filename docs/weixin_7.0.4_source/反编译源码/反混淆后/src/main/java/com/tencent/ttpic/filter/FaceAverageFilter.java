package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceImageLayer;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceDetectUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FaceAverageFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n varying lowp vec2 textureCoordinate2;\n varying lowp vec2 textureCoordinate3;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D inputImageTexture4;\n \n uniform int drawTypeFragment;\n uniform float alphaBlend;\n \n void main(void) {\n     \n     vec4 modelColor = texture2D(inputImageTexture4, textureCoordinate);\n     vec4 userColor  = texture2D(inputImageTexture2, textureCoordinate2);\n     vec4 grayColor  = texture2D(inputImageTexture3, textureCoordinate3);\n     \n     \n     float xAlpha = alphaBlend + (1.0 - alphaBlend) * grayColor.r;\n     vec3 resultColor = userColor.rgb * (1.0 - xAlpha) + modelColor.rgb * xAlpha;\n     gl_FragColor = vec4(resultColor, 1.0);\n     \n }";
    private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n attribute vec4 inputTextureCoordinate2;\n varying vec2 textureCoordinate2;\n \n attribute vec4 inputTextureCoordinate3;\n varying vec2 textureCoordinate3;\n \n uniform int drawTypeVertex;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureCoordinate2 = inputTextureCoordinate2.xy;\n     textureCoordinate3 = inputTextureCoordinate3.xy;\n }";
    private float[] faceVertices = new float[1104];
    private float[] grayVertices = new float[1104];
    private FaceImageLayer mFaceLayer = null;
    private FaceItem mItem = null;
    private Bitmap maskBitmap = null;
    private Bitmap materialBitmap = null;
    private float[] positions = new float[1104];
    private float[] texVertices = new float[1104];
    private int userTex = 0;

    public FaceAverageFilter(String str, FaceImageLayer faceImageLayer) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.m2504i(82311);
        this.dataPath = str;
        this.mFaceLayer = faceImageLayer;
        this.materialBitmap = FaceOffUtil.getFaceBitmap(str + File.separator + this.mFaceLayer.imagePath);
        if (this.mFaceLayer.faceMaskImagePath != null) {
            this.maskBitmap = FaceOffUtil.getFaceBitmap(str + File.separator + this.mFaceLayer.faceMaskImagePath);
        } else {
            this.maskBitmap = FaceOffUtil.getGrayBitmap(this.mFaceLayer.featureType);
        }
        initParams();
        AppMethodBeat.m2505o(82311);
    }

    public void setUserTexture(int i) {
        this.userTex = i;
    }

    public void initParams() {
        AppMethodBeat.m2504i(82312);
        addParam(new C25627n("inputImageTexture2", this.userTex, 33986));
        addParam(new C25628k("inputImageTexture3", this.maskBitmap, 33987, true));
        addParam(new C25628k("inputImageTexture4", this.materialBitmap, 33988, true));
        addParam(new C0933f("alphaBlend", (float) this.mFaceLayer.blendAlpha));
        addParam(new C0935i("drawTypeFragment", 1));
        addParam(new C0935i("drawTypeVertex", 1));
        AppMethodBeat.m2505o(82312);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.m2504i(82313);
        if (pTDetectInfo.facePoints == null || pTDetectInfo.facePoints.size() == 0) {
            AppMethodBeat.m2505o(82313);
            return;
        }
        addParam(new C25627n("inputImageTexture2", this.userTex, 33986));
        List genPointsDouble = FaceOffUtil.genPointsDouble(this.mFaceLayer.imageFacePoint);
        FaceDetectUtil.facePointf83to90(genPointsDouble);
        List fullCoords = FaceOffUtil.getFullCoords(genPointsDouble, 3.0f);
        List fullCoords2 = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(pTDetectInfo.facePoints), 3.0f);
        addAttribParam("inputTextureCoordinate2", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(fullCoords2, (int) (((double) this.width) * this.mFaceDetScale), (int) (((double) this.height) * this.mFaceDetScale), this.faceVertices));
        if (this.materialBitmap != null) {
            addAttribParam("position", FaceOffUtil.initFacePositionsFaceAverage(getVertexCoords(fullCoords, fullCoords2, this.materialBitmap.getWidth(), this.materialBitmap.getHeight(), this.width, this.height, (float) this.mFaceLayer.distortionAlpha, pTDetectInfo.faceAngles), this.width, this.height, this.positions));
        }
        AppMethodBeat.m2505o(82313);
    }

    public void initAttribParams() {
        AppMethodBeat.m2504i(82314);
        super.initAttribParams();
        List genPointsDouble = FaceOffUtil.genPointsDouble(this.mFaceLayer.imageFacePoint);
        FaceDetectUtil.facePointf83to90(genPointsDouble);
        genPointsDouble = FaceOffUtil.getFullCoords(genPointsDouble, 3.0f);
        if (this.materialBitmap != null) {
            addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(genPointsDouble, this.materialBitmap.getWidth(), this.materialBitmap.getHeight(), this.texVertices));
        } else {
            addAttribParam("inputTextureCoordinate", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(genPointsDouble, -1, -1, this.texVertices));
        }
        if (this.mFaceLayer.faceMaskImagePath == null) {
            genPointsDouble = FaceOffUtil.getGrayCoords(FEATURE_TYPE.CRAZY_FACE);
        } else {
            genPointsDouble = FaceOffUtil.genPointsDouble(this.mFaceLayer.faceMaskFacePoint);
        }
        FaceDetectUtil.facePointf83to90(genPointsDouble);
        genPointsDouble = FaceOffUtil.getFullCoords(genPointsDouble, 3.0f);
        if (this.maskBitmap != null) {
            addAttribParam("inputTextureCoordinate3", FaceOffUtil.initMaterialFaceTexCoordsFaceAverage(genPointsDouble, this.maskBitmap.getWidth(), this.maskBitmap.getHeight(), this.grayVertices));
        }
        addAttribParam("inputTextureCoordinate2", this.faceVertices);
        setDrawMode(DRAW_MODE.TRIANGLES);
        setCoordNum(552);
        AppMethodBeat.m2505o(82314);
    }

    private List<PointF> getVertexCoords(List<PointF> list, List<PointF> list2, int i, int i2, int i3, int i4, float f, float[] fArr) {
        int i5;
        float f2;
        float f3;
        int i6;
        AppMethodBeat.m2504i(82315);
        List copyList = VideoMaterialUtil.copyList(list);
        List copyList2 = VideoMaterialUtil.copyList(list2);
        PointF pointF = new PointF(((PointF) copyList2.get(64)).x, ((PointF) copyList2.get(64)).y);
        PointF pointF2 = new PointF(((PointF) copyList.get(64)).x, ((PointF) copyList.get(64)).y);
        float f4 = fArr[2] - ((float) (-Math.atan((double) ((((PointF) copyList.get(35)).y - ((PointF) copyList.get(45)).y) / (((PointF) copyList.get(35)).x - ((PointF) copyList.get(45)).x)))));
        int i7 = 0;
        while (true) {
            i5 = i7;
            if (i5 >= copyList.size()) {
                break;
            }
            if (i5 <= 98 || i5 >= 107) {
                f2 = ((PointF) copyList2.get(i5)).x - pointF.x;
                f3 = ((PointF) copyList2.get(i5)).y - pointF.y;
                double cos = (((double) f2) * Math.cos((double) f4)) - (((double) f3) * Math.sin((double) f4));
                double sin = (((double) f2) * Math.sin((double) f4)) + (((double) f3) * Math.cos((double) f4));
                ((PointF) copyList2.get(i5)).x = ((float) cos) + pointF.x;
                ((PointF) copyList2.get(i5)).y = ((float) sin) + pointF.y;
            }
            i7 = i5 + 1;
        }
        f4 = pointF.x - pointF2.x;
        f2 = pointF.y - pointF2.y;
        i7 = 0;
        while (true) {
            i6 = i7;
            if (i6 >= copyList.size()) {
                break;
            }
            ((PointF) copyList2.get(i6)).x -= f4;
            ((PointF) copyList2.get(i6)).y -= f2;
            i7 = i6 + 1;
        }
        PointF pointF3 = new PointF(((PointF) copyList2.get(43)).x, ((PointF) copyList2.get(43)).y);
        pointF = new PointF(((PointF) copyList2.get(53)).x, ((PointF) copyList2.get(53)).y);
        PointF pointF4 = new PointF(((PointF) copyList2.get(99)).x, ((PointF) copyList2.get(99)).y);
        pointF4 = new PointF(((PointF) copyList2.get(101)).x, ((PointF) copyList2.get(101)).y);
        pointF4 = new PointF(((PointF) copyList2.get(105)).x, ((PointF) copyList2.get(105)).y);
        pointF4 = new PointF(((PointF) copyList.get(43)).x, ((PointF) copyList.get(43)).y);
        PointF pointF5 = new PointF(((PointF) copyList.get(53)).x, ((PointF) copyList.get(53)).y);
        PointF pointF6 = new PointF(((PointF) copyList.get(99)).x, ((PointF) copyList.get(99)).y);
        pointF6 = new PointF(((PointF) copyList.get(101)).x, ((PointF) copyList.get(101)).y);
        pointF6 = new PointF(((PointF) copyList.get(105)).x, ((PointF) copyList.get(105)).y);
        float distance = AlgoUtils.getDistance(pointF4, pointF5) / AlgoUtils.getDistance(pointF3, pointF);
        f4 = AlgoUtils.getDistance(pointF4, pointF5) / AlgoUtils.getDistance(pointF3, pointF);
        i7 = 0;
        while (true) {
            i6 = i7;
            if (i6 >= copyList.size()) {
                break;
            }
            if (i6 < 99 || i6 > 106) {
                float f5 = ((PointF) copyList2.get(i6)).y - pointF2.y;
                PointF pointF7 = (PointF) copyList2.get(i6);
                pointF7.x = ((PointF) copyList2.get(i6)).x + ((((PointF) copyList2.get(i6)).x - pointF2.x) * (distance - 1.0f));
                ((PointF) copyList2.get(i6)).y += (f4 - 1.0f) * f5;
            }
            i7 = i6 + 1;
        }
        i7 = 99;
        while (true) {
            i6 = i7;
            if (i6 >= 107) {
                break;
            }
            ((PointF) copyList2.get(i6)).x = ((PointF) copyList.get(i6)).x;
            ((PointF) copyList2.get(i6)).y = ((PointF) copyList.get(i6)).y;
            i7 = i6 + 1;
        }
        ArrayList arrayList = new ArrayList();
        i7 = 0;
        while (true) {
            i5 = i7;
            if (i5 >= copyList2.size()) {
                break;
            }
            arrayList.add(new PointF(((PointF) copyList2.get(i5)).x, ((PointF) copyList2.get(i5)).y));
            i7 = i5 + 1;
        }
        f4 = f * smootherstep(0.9f, 1.0f, ((float) ((Math.abs(Math.cos((double) fArr[0])) + Math.abs(Math.cos((double) fArr[1]))) + Math.abs(Math.cos((double) fArr[2])))) / 3.0f);
        i7 = 0;
        while (true) {
            i6 = i7;
            if (i6 >= copyList.size()) {
                break;
            }
            if (i6 < 99 || i6 > 106) {
                ((PointF) arrayList.get(i6)).x = (((PointF) copyList.get(i6)).x * f4) + ((1.0f - f4) * ((PointF) copyList2.get(i6)).x);
                ((PointF) arrayList.get(i6)).y = (((PointF) copyList.get(i6)).y * f4) + ((1.0f - f4) * ((PointF) copyList2.get(i6)).y);
            }
            i7 = i6 + 1;
        }
        f3 = ((float) i2) / ((float) this.height);
        if (((float) (this.width / this.height)) > ((float) (i / i2))) {
            f3 = ((float) i) / ((float) this.width);
        }
        float f6 = ((float) i) / f3;
        f3 = ((float) i2) / f3;
        PointF pointF8 = new PointF((((float) this.width) - f6) / 2.0f, (((float) this.height) - f3) / 2.0f);
        float f7 = f6 / ((float) i);
        f4 = f3 / ((float) i2);
        i7 = 0;
        while (true) {
            i6 = i7;
            if (i6 < arrayList.size()) {
                ((PointF) arrayList.get(i6)).x = (((PointF) arrayList.get(i6)).x * f7) + pointF8.x;
                ((PointF) arrayList.get(i6)).y = (((PointF) arrayList.get(i6)).y * f4) + pointF8.y;
                i7 = i6 + 1;
            } else {
                AppMethodBeat.m2505o(82315);
                return arrayList;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public float clampf(float f, float f2, float f3) {
        AppMethodBeat.m2504i(82316);
        float max = Math.max(f2, Math.min(f3, f));
        AppMethodBeat.m2505o(82316);
        return max;
    }

    /* Access modifiers changed, original: 0000 */
    public float smootherstep(float f, float f2, float f3) {
        AppMethodBeat.m2504i(82317);
        float clampf = clampf((f3 - f) / (f2 - f), 0.0f, 1.0f);
        clampf = ((clampf * ((6.0f * clampf) - 15.0f)) + 10.0f) * ((clampf * clampf) * clampf);
        AppMethodBeat.m2505o(82317);
        return clampf;
    }
}
