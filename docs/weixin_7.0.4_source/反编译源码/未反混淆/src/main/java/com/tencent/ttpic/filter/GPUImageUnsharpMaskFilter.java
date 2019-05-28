package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.aj;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class GPUImageUnsharpMaskFilter extends BaseFilter {
    private static String SHARP_FRAGMENT = " precision highp float;\n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; \n \n uniform float intensity;\n \n void main()\n {\n     vec4 sharpImageColor = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 blurredImageColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     \n     gl_FragColor = vec4(sharpImageColor.rgb * intensity + blurredImageColor * (1.0 - intensity), sharpImageColor.a);\n }";
    private float blurRadius = 2.0f;
    private BaseFilter horizontal = null;
    private float intensity = 1.365f;
    private BaseFilter unsharpMask = null;
    private BaseFilter vertical = null;

    public void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(82555);
        if (map.containsKey("blurRadius")) {
            this.blurRadius = ((Float) map.get("blurRadius")).floatValue();
        }
        if (map.containsKey("intensity")) {
            this.intensity = ((Float) map.get("intensity")).floatValue();
            if (this.unsharpMask != null) {
                this.unsharpMask.addParam(new f("intensity", this.intensity));
            }
        }
        AppMethodBeat.o(82555);
    }

    public GPUImageUnsharpMaskFilter() {
        super(GLSLRender.bJB);
    }

    public void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(82556);
        int i = 0;
        float round = (float) Math.round(this.blurRadius);
        if (round >= 1.0f) {
            i = (int) Math.floor(Math.sqrt((-2.0d * Math.pow((double) round, 2.0d)) * Math.log(0.00390625d * Math.sqrt(6.283185307179586d * Math.pow((double) round, 2.0d)))));
            i += i % 2;
        }
        this.horizontal = new BaseFilter(aj.b(i, round, true));
        this.vertical = new BaseFilter(aj.b(i, round, false));
        setNextFilter(this.horizontal, null);
        this.horizontal.setNextFilter(this.vertical, null);
        this.unsharpMask = new BaseFilter(SHARP_FRAGMENT);
        this.unsharpMask.addParam(new f("intensity", this.intensity));
        this.vertical.setNextFilter(this.unsharpMask, new int[]{0});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(82556);
    }
}
