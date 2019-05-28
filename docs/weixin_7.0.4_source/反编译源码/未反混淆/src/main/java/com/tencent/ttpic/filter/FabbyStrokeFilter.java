package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.e;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FabbyStrokeFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = "precision mediump float; \nvarying mediump vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform float stepX; \nuniform float stepY; \nuniform float strokeGapInPixel; \nuniform float strokeWidthInPixel; \nuniform vec4 strokeColor; \nfloat alphaForStep(float step_x, float step_y, float weight) { \n   float step_x45 = step_x * 0.7071; \n   float step_y45 = step_y * 0.7071; \n   vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n   vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n   vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n   vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n   vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n   vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n   float alpha = step(0.1, v3_10.r+v3_11.r+v3_12.r+v3_13.r+v3_14.r+v3_15.r+v3_16.r+v3_17.r); \n   return alpha * weight; \n} \nvoid main() \n{ \n   vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n   vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n   vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n   float mask = v2.r; \n   if (mask < 0.1) { \n       float x = stepX * strokeGapInPixel; \n       float y = stepY * strokeGapInPixel; \n       float innerAlpha = alphaForStep(x, y, 1.0); \n       if (innerAlpha > 1.0) { \n           gl_FragColor = mix(bg, v1, mask); \n       } else { \n           x += stepX * strokeWidthInPixel; \n           y += stepY * strokeWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               gl_FragColor = strokeColor; \n           } else { \n               gl_FragColor = bg; \n           } \n       } \n   } else { \n       gl_FragColor = v1; \n   } \n }";

    public FabbyStrokeFilter() {
        super(FRAGMENT_SHADER);
        AppMethodBeat.i(82299);
        initParam();
        AppMethodBeat.o(82299);
    }

    public void setmMaskTex(int i) {
        AppMethodBeat.i(82300);
        addParam(new n("inputImageTexture2", i, 33986));
        AppMethodBeat.o(82300);
    }

    public void setStepX(float f) {
        AppMethodBeat.i(82301);
        addParam(new f("stepX", f));
        AppMethodBeat.o(82301);
    }

    public void setStepY(float f) {
        AppMethodBeat.i(82302);
        addParam(new f("stepY", f));
        AppMethodBeat.o(82302);
    }

    public void setStrokeGapInPixel(float f) {
        AppMethodBeat.i(82303);
        addParam(new f("strokeGapInPixel", f));
        AppMethodBeat.o(82303);
    }

    public void setStrokeWidthInPixel(float f) {
        AppMethodBeat.i(82304);
        addParam(new f("strokeWidthInPixel", f));
        AppMethodBeat.o(82304);
    }

    public void setStrokeColor(float[] fArr) {
        AppMethodBeat.i(82305);
        addParam(new e("strokeColor", fArr[0], fArr[1], fArr[2], fArr[3]));
        AppMethodBeat.o(82305);
    }

    private void initParam() {
        AppMethodBeat.i(82306);
        addParam(new n("inputImageTexture2", 0, 33986));
        addParam(new f("stepX", 0.0f));
        addParam(new f("stepY", 0.0f));
        addParam(new f("strokeGapInPixel", 0.0f));
        addParam(new f("strokeWidthInPixel", 0.0f));
        addParam(new e("strokeColor", 0.0f, 0.0f, 0.0f, 0.0f));
        AppMethodBeat.o(82306);
    }
}
