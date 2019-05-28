package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.a;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class cp extends BaseFilter {
    public cp() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86548);
        a aVar = new a(GLSLRender.bJB);
        HashMap hashMap = new HashMap();
        hashMap.put("intensity", Float.valueOf(0.65f));
        aVar.setParameterDic(hashMap);
        setNextFilter(aVar, null);
        ab abVar = new ab();
        abVar.addParam(new o("inputImageTexture2", "sh/kongcheng_lf.png", 33986));
        aVar.setNextFilter(abVar, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86548);
    }
}
