package com.tencent.filter.p138a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

/* renamed from: com.tencent.filter.a.aj */
public final class C37324aj {
    private static String bNX = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}\n";
    private static String bNY = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";

    /* renamed from: b */
    public static String m62724b(int i, float f, boolean z) {
        AppMethodBeat.m2504i(86488);
        String str;
        if (i <= 0) {
            str = bNY;
            AppMethodBeat.m2505o(86488);
            return str;
        }
        int i2;
        float f2;
        float[] fArr = new float[(i + 1)];
        float f3 = 0.0f;
        int i3 = 0;
        while (i3 < i + 1) {
            float f4;
            fArr[i3] = (float) ((1.0d / Math.sqrt(6.283185307179586d * Math.pow((double) f, 2.0d))) * Math.exp((-Math.pow((double) i3, 2.0d)) / (2.0d * Math.pow((double) f, 2.0d))));
            if (i3 == 0) {
                f4 = fArr[i3] + f3;
            } else {
                f4 = (float) (((double) f3) + (2.0d * ((double) fArr[i3])));
            }
            i3++;
            f3 = f4;
        }
        for (i2 = 0; i2 < i + 1; i2++) {
            fArr[i2] = fArr[i2] / f3;
        }
        i3 = Math.min((i / 2) + (i % 2), 7);
        float[] fArr2 = new float[i3];
        for (i2 = 0; i2 < i3; i2++) {
            f3 = fArr[(i2 * 2) + 1];
            float f5 = fArr[(i2 * 2) + 2];
            fArr2[i2] = ((f3 * ((float) ((i2 * 2) + 1))) + (f5 * ((float) ((i2 * 2) + 2)))) / (f3 + f5);
        }
        int i4 = (i / 2) + (i % 2);
        str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", new Object[]{Integer.valueOf((i3 * 2) + 1)}) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", new Object[]{Float.valueOf(fArr[0])});
        if (z) {
            str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
        } else {
            str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
        }
        for (int i5 = 0; i5 < i3; i5++) {
            f2 = fArr[(i5 * 2) + 1] + fArr[(i5 * 2) + 2];
            str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)});
        }
        if (i4 > i3) {
            while (i3 < i4) {
                f3 = fArr[(i3 * 2) + 1];
                float f6 = fArr[(i3 * 2) + 2];
                f3 = ((f3 * ((float) ((i3 * 2) + 1))) + (f6 * ((float) ((i3 * 2) + 2)))) / (f3 + f6);
                str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)});
                i3++;
            }
        }
        str = (str + "gl_FragColor = sum;\n") + "}\n";
        AppMethodBeat.m2505o(86488);
        return str;
    }

    /* renamed from: b */
    public static String m62725b(int i, float f, boolean z, boolean z2) {
        AppMethodBeat.m2504i(86489);
        String str;
        if (i <= 0) {
            str = bNY;
            AppMethodBeat.m2505o(86489);
            return str;
        }
        int i2;
        float f2;
        float[] fArr = new float[(i + 1)];
        float f3 = 0.0f;
        int i3 = 0;
        while (i3 < i + 1) {
            float f4;
            fArr[i3] = (float) ((1.0d / Math.sqrt(6.283185307179586d * Math.pow((double) f, 2.0d))) * Math.exp((-Math.pow((double) i3, 2.0d)) / (2.0d * Math.pow((double) f, 2.0d))));
            if (i3 == 0) {
                f4 = fArr[i3] + f3;
            } else {
                f4 = (float) (((double) f3) + (2.0d * ((double) fArr[i3])));
            }
            i3++;
            f3 = f4;
        }
        for (i2 = 0; i2 < i + 1; i2++) {
            fArr[i2] = fArr[i2] / f3;
        }
        i3 = Math.min((i / 2) + (i % 2), 7);
        float[] fArr2 = new float[i3];
        for (i2 = 0; i2 < i3; i2++) {
            f3 = fArr[(i2 * 2) + 1];
            float f5 = fArr[(i2 * 2) + 2];
            fArr2[i2] = ((f3 * ((float) ((i2 * 2) + 1))) + (f5 * ((float) ((i2 * 2) + 2)))) / (f3 + f5);
        }
        int i4 = (i / 2) + (i % 2);
        str = String.format(Locale.ENGLISH, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n vec4 color = texture2D(inputImageTexture,textureCoordinate);\nlowp float sum = 0.0;\n", new Object[]{Integer.valueOf((i3 * 2) + 1)});
        if (z) {
            str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).g * %f;\n", new Object[]{Float.valueOf(fArr[0])});
        } else {
            str = str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy).a * %f;\n", new Object[]{Float.valueOf(fArr[0])});
        }
        if (z2) {
            str = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
        } else {
            str = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
        }
        for (int i5 = 0; i5 < i3; i5++) {
            f2 = fArr[(i5 * 2) + 1] + fArr[(i5 * 2) + 2];
            if (z) {
                str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)});
            } else {
                str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[]{Float.valueOf(fArr2[i5]), Float.valueOf(f2)});
            }
        }
        if (i4 > i3) {
            while (i3 < i4) {
                f3 = fArr[(i3 * 2) + 1];
                float f6 = fArr[(i3 * 2) + 2];
                f3 = ((f3 * ((float) ((i3 * 2) + 1))) + (f6 * ((float) ((i3 * 2) + 2)))) / (f3 + f6);
                if (z) {
                    str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)});
                } else {
                    str = (str + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)})) + String.format(Locale.ENGLISH, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", new Object[]{Float.valueOf(f3), Float.valueOf(f2)});
                }
                i3++;
            }
        }
        str = ((str + "color.a = sum;\n") + "gl_FragColor = color;\n") + "}\n";
        AppMethodBeat.m2505o(86489);
        return str;
    }
}
