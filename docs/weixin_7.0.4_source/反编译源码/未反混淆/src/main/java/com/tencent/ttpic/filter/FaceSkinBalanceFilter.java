package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.FaceImageLayer;
import java.util.List;

public class FaceSkinBalanceFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = " precision mediump float;\n varying lowp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n uniform vec3 diffRGB;\n uniform vec3 userRGB;\n uniform int shouldBalance;\n\n \n void main()\n {\n     vec4 color = texture2D(inputImageTexture, textureCoordinate);\n     if (shouldBalance == 1) {\n         float ry;\n         float ri;\n         float rq;\n         if (color.r <= userRGB.r) {\n             ry = color.r + diffRGB.r * (color.r / userRGB.r);\n         } else {\n             ry = color.r + diffRGB.r * ((1.0 - color.r) / (1.0 - userRGB.r));\n         }\n         if (color.g <= userRGB.g) {\n             ri = color.g + diffRGB.g * (color.g / userRGB.g);\n         } else {\n             ri = color.g + diffRGB.g * ((1.0 - color.g) / (1.0 - userRGB.g));\n         }\n         if (color.b <= userRGB.b) {\n             rq = color.b + diffRGB.b * (color.b / userRGB.b);\n         } else {\n             rq = color.b + diffRGB.b * ((1.0 - color.b) / (1.0 - userRGB.b));\n         }\n         vec3 refineRGB = vec3(ry, ri, rq);\n         gl_FragColor = vec4(clamp(refineRGB, 0.0, 1.0), 1.0);\n     }\n     else {\n         gl_FragColor = color;\n     }\n }";
    private static int count = 0;
    private static int total = 0;
    private byte[] data = null;
    private float modelU = -1.0f;
    private float modelU2 = -1.0f;
    private float modelV = -1.0f;
    private float modelV2 = -1.0f;
    private float modelY = -1.0f;
    private float modelY2 = -1.0f;
    private int shouldBalance = 1;

    public FaceSkinBalanceFilter(FaceImageLayer faceImageLayer) {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82443);
        setModelColor(faceImageLayer.imageFaceColor);
        initParam();
        AppMethodBeat.o(82443);
    }

    public void setModelColor(List<Double> list) {
        AppMethodBeat.i(82444);
        if (list == null || list.size() < 6) {
            this.shouldBalance = 0;
            AppMethodBeat.o(82444);
            return;
        }
        this.modelY = ((Double) list.get(0)).floatValue();
        this.modelU = ((Double) list.get(1)).floatValue();
        this.modelV = ((Double) list.get(2)).floatValue();
        this.modelY2 = ((Double) list.get(3)).floatValue();
        this.modelU2 = ((Double) list.get(4)).floatValue();
        this.modelV2 = ((Double) list.get(5)).floatValue();
        AppMethodBeat.o(82444);
    }

    private void initParam() {
        AppMethodBeat.i(82445);
        addParam(new i("shouldBalance", this.shouldBalance));
        addParam(new g("diffRGB", new float[]{0.0f, 0.0f, 0.0f}));
        addParam(new g("userRGB", new float[]{this.modelY, this.modelU, this.modelV}));
        AppMethodBeat.o(82445);
    }

    public void setImageData(byte[] bArr) {
        if (count < 10) {
            count++;
        } else if (bArr != null) {
            count = 0;
            this.data = bArr;
            total = 1;
        }
    }

    public void beforeRender(int i, int i2, int i3) {
        AppMethodBeat.i(82446);
        if (total == 0 || this.data == null) {
            AppMethodBeat.o(82446);
            return;
        }
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        total = 0;
        int length = this.data.length / 4;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = this.data[i5 * 4] & 255;
            int i7 = this.data[(i5 * 4) + 1] & 255;
            int i8 = this.data[(i5 * 4) + 2] & 255;
            boolean isSkinColor = isSkinColor(i6, i7, i8);
            f = ((float) i6) / 255.0f;
            f2 = ((float) i7) / 255.0f;
            float f9 = ((float) i8) / 255.0f;
            if (isSkinColor) {
                d += (double) f;
                d2 += (double) f2;
                d3 += (double) f9;
                i4++;
            }
            d4 += (double) f;
            d5 += (double) f2;
            d6 += (double) f9;
        }
        d4 /= (double) length;
        d5 /= (double) length;
        d6 /= (double) length;
        if (i4 == 0) {
            d3 = d6;
            d2 = d5;
            d = d4;
        } else {
            d /= (double) i4;
            d2 /= (double) i4;
            d3 /= (double) i4;
        }
        f2 = this.modelY;
        f = this.modelU;
        float f10 = this.modelV;
        float f11 = (float) d4;
        float f12 = (float) d5;
        float f13 = (float) d6;
        if (d > 0.0d) {
            f3 = (float) d;
            f4 = (float) d2;
            f5 = (float) d3;
            f6 = this.modelY2;
            f7 = this.modelU2;
            f8 = this.modelV2;
        } else {
            f5 = f13;
            f4 = f12;
            f3 = f11;
            f8 = f10;
            f7 = f;
            f6 = f2;
        }
        if (f6 <= 0.0f && r6 <= 0.0f && r4 <= 0.0f) {
            f8 = f5;
            f7 = f4;
            f6 = f3;
        }
        addParam(new g("diffRGB", new float[]{f6 - f3, f7 - f4, f8 - f5}));
        addParam(new g("userRGB", new float[]{f3, f4, f5}));
        addParam(new i("shouldBalance", this.shouldBalance));
        AppMethodBeat.o(82446);
    }

    private boolean isSkinColor(int i, int i2, int i3) {
        if (i <= 80 && i2 <= 80 && i3 <= 80) {
            return false;
        }
        if ((i < 230 && i2 < 230 && i3 < 230 && (i3 >= i2 || i2 >= i)) || i + i2 > 400) {
            return false;
        }
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float f4 = ((128.0f - (81.085f * f)) + (112.0f * f2)) - (30.915f * f3);
        f = (((f * 112.0f) + 128.0f) - (f2 * 93.786f)) - (18.214f * f3);
        if (f4 < 85.0f || f4 > 135.0f || f < 260.0f - f4 || f > 280.0f - f4) {
            return false;
        }
        return true;
    }
}
