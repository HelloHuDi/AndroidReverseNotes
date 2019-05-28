package com.tencent.filter;

import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.d */
public final class C17754d extends BaseFilter {
    int bJv = 0;

    public C17754d() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86349);
        if (map.containsKey("effectIndex")) {
            this.bJv = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.m2505o(86349);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86350);
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
        baseFilter.addParam(new C0936o("inputImageTexture2", str, 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJE);
        if (this.bJv == 2) {
            baseFilter2.addParam(new C0933f("filterAdjustParam", 0.6f));
        } else {
            baseFilter2.addParam(new C0933f("filterAdjustParam", 0.5f));
        }
        baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex});
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86350);
    }
}
