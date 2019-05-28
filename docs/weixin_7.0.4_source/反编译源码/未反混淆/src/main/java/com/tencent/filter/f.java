package com.tencent.filter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class f extends BaseFilter {
    float scaleFact = 1.0f;

    public f() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86356);
        if (map.containsKey("scalefact")) {
            this.scaleFact = ((Float) map.get("scalefact")).floatValue();
        }
        AppMethodBeat.o(86356);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86357);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = this.scaleFact;
        setNextFilter(baseFilter, null);
        baseFilter.setNextFilter(new BaseFilter(GLSLRender.bJB), null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86357);
    }
}
