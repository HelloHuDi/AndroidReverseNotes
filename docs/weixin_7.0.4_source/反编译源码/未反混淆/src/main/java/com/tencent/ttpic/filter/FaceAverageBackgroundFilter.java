package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.model.FaceImageLayer;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.util.FaceOffUtil;
import java.io.File;

public class FaceAverageBackgroundFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main(void) {\n         gl_FragColor = texture2D(inputImageTexture2, textureCoordinate);\n }";
    private static final String VERTEX_SHADER = " attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
    private FaceImageLayer mFaceLayer = null;
    private FaceItem mItem = null;
    private Bitmap materialBitmap = null;
    private int materialImageHeight = 0;
    private int materialImageWidth = 0;

    public FaceAverageBackgroundFilter(String str, FaceImageLayer faceImageLayer) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        AppMethodBeat.i(82307);
        this.dataPath = str;
        this.mFaceLayer = faceImageLayer;
        initParams();
        AppMethodBeat.o(82307);
    }

    public void initParams() {
        AppMethodBeat.i(82308);
        if (this.materialBitmap == null && this.mFaceLayer != null) {
            this.materialBitmap = FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.mFaceLayer.imagePath);
        }
        if (this.materialBitmap != null) {
            this.materialImageWidth = this.materialBitmap.getWidth();
            this.materialImageHeight = this.materialBitmap.getHeight();
        }
        addParam(new k("inputImageTexture2", this.materialBitmap, 33986, true));
        AppMethodBeat.o(82308);
    }

    public void initAttribParams() {
        AppMethodBeat.i(82309);
        super.initAttribParams();
        float f = ((float) this.materialImageHeight) / ((float) this.height);
        if (((float) this.materialImageHeight) / ((float) this.materialImageWidth) > ((float) this.height) / ((float) this.width)) {
            f = ((float) this.materialImageWidth) / ((float) this.width);
        }
        float f2 = ((float) this.materialImageWidth) / f;
        f = ((float) this.materialImageHeight) / f;
        addAttribParam("inputTextureCoordinate", new float[]{((f2 - ((float) this.width)) / 2.0f) / f2, 1.0f - (((f - ((float) this.height)) / 2.0f) / f), ((f2 - ((float) this.width)) / 2.0f) / f2, ((f - ((float) this.height)) / 2.0f) / f, 1.0f - (((f2 - ((float) this.width)) / 2.0f) / f2), ((f - ((float) this.height)) / 2.0f) / f, 1.0f - (((f2 - ((float) this.width)) / 2.0f) / f2), 1.0f - (((f - ((float) this.height)) / 2.0f) / f)});
        AppMethodBeat.o(82309);
    }

    public void updatePreview(PTDetectInfo pTDetectInfo) {
        AppMethodBeat.i(82310);
        float f = ((float) this.materialImageHeight) / ((float) this.height);
        if (((float) this.materialImageHeight) / ((float) this.materialImageWidth) > ((float) this.height) / ((float) this.width)) {
            f = ((float) this.materialImageWidth) / ((float) this.width);
        }
        float f2 = ((float) this.materialImageWidth) / f;
        f = ((float) this.materialImageHeight) / f;
        addAttribParam("inputTextureCoordinate", new float[]{((f2 - ((float) this.width)) / 2.0f) / f2, 1.0f - (((f - ((float) this.height)) / 2.0f) / f), ((f2 - ((float) this.width)) / 2.0f) / f2, ((f - ((float) this.height)) / 2.0f) / f, 1.0f - (((f2 - ((float) this.width)) / 2.0f) / f2), ((f - ((float) this.height)) / 2.0f) / f, 1.0f - (((f2 - ((float) this.width)) / 2.0f) / f2), 1.0f - (((f - ((float) this.height)) / 2.0f) / f)});
        AppMethodBeat.o(82310);
    }
}
