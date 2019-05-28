package com.tencent.filter;

import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class d extends BaseFilter {
    int bJv = 0;

    public d() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86349);
        if (map.containsKey("effectIndex")) {
            this.bJv = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.o(86349);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86350);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bKL);
        String str = "sh/";
        switch (this.bJv) {
            case 0:
                str = str + "blue_sh_blend.jpg";
                break;
            case 1:
                str = str + "green_sh_blend.jpg";
                break;
            case 2:
                str = str + "purple_sh_blend.jpg";
                break;
            case 3:
                str = str + "red_sh_blend.jpg";
                break;
            case 4:
                str = str + "yellow_sh_blend.jpg";
                break;
        }
        baseFilter.addParam(new o("inputImageTexture2", str, 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJE);
        if (this.bJv == 2) {
            baseFilter2.addParam(new f("filterAdjustParam", 0.6f));
        } else {
            baseFilter2.addParam(new f("filterAdjustParam", 0.5f));
        }
        baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86350);
    }
}
