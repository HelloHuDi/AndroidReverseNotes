package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C25627n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FabbyFeatherFilter extends BaseFilter {
    public static final String FRAGMENT_SHADER = "   precision mediump float; \n   precision mediump int; \n   varying mediump vec2 textureCoordinate; \n    uniform sampler2D inputImageTexture; \n   uniform sampler2D inputImageTexture2; \n   uniform float stepX; \n   uniform float stepY; \n   uniform float featherWidthInPixel; \n   float alphaForStep(float step_x, float step_y, float weight) { \n       float step_x45 = step_x * 0.7071; \n       float step_y45 = step_y * 0.7071; \n       vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n       vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n       vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n       vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n       vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n       vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n       vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n       float temp = step(0.1, v3_10.r); \n       temp = step(0.1, v3_12.r + temp); \n       temp = step(0.1, v3_13.r + temp); \n       temp = step(0.1, v3_14.r + temp); \n       temp = step(0.1, v3_15.r + temp); \n       temp = step(0.1, v3_16.r + temp); \n       float alpha = step(0.1, v3_17.r + temp); \n       return alpha * weight; \n   } \n   void main() \n   { \n       vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n       vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n       vec4 bg = vec4(0.0, 0.0, 0.0, 0.0); \n       float mask = v2.r; \n       if (mask < 0.1) { \n           float x = stepX * featherWidthInPixel; \n           float y = stepY * featherWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.9) { \n               float minA = 0.0; \n               float maxA = 1.0; \n               float alpha = 1.0; \n               float maxD = featherWidthInPixel; \n               float minD = 0.0; \n               for (int i = 0; i < 100; i++) { \n                   float mid = (minD + maxD) * 0.5; \n                   float midA = (minA + maxA) * 0.5; \n                   float xMid = stepX * mid; \n                   float yMid = stepY * mid; \n                   float aMid = alphaForStep(xMid, yMid, 1.0); \n                   if (aMid > 0.9) { \n                        maxD = mid; \n                       minA = midA; \n                   } else { \n                       minD = mid; \n                       maxA = midA; \n                   } \n                   if (maxD - minD <= 1.0) { \n                       alpha = midA; \n                       break; \n                   } \n               } \n               gl_FragColor = vec4(v1.rgb, alpha); \n           } else { \n               gl_FragColor = bg; \n           } \n       } else { \n           gl_FragColor = vec4(v1.rgb, 1.0); \n       } \n   }";
    private float featherWidthInPixel;
    private int mMaskTex;
    private float stepX;
    private float stepY;

    public FabbyFeatherFilter() {
        super(FRAGMENT_SHADER);
    }

    public void setmMaskTex(int i) {
        this.mMaskTex = i;
    }

    public void setStepX(float f) {
        this.stepX = f;
    }

    public void setStepY(float f) {
        this.stepY = f;
    }

    public void setFeatherWidthInPixel(float f) {
        this.featherWidthInPixel = f;
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(82249);
        addParam(new C25627n("inputImageTexture2", this.mMaskTex, 33986));
        addParam(new C0933f("stepX", this.stepX));
        addParam(new C0933f("stepY", this.stepY));
        addParam(new C0933f("featherWidthInPixel", this.featherWidthInPixel));
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(82249);
    }
}
