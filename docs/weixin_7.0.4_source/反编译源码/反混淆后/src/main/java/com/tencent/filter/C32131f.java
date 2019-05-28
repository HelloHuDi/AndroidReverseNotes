package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.f */
public final class C32131f extends BaseFilter {
    float scaleFact = 1.0f;

    public C32131f() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86356);
        if (map.containsKey("scalefact")) {
            this.scaleFact = ((Float) map.get("scalefact")).floatValue();
        }
        AppMethodBeat.m2505o(86356);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86357);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = this.scaleFact;
        setNextFilter(baseFilter, null);
        baseFilter.setNextFilter(new BaseFilter(GLSLRender.bJB), null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86357);
    }
}
