package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.C25623a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.filter.a.cp */
public final class C17744cp extends BaseFilter {
    public C17744cp() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86548);
        C25623a c25623a = new C25623a(GLSLRender.bJB);
        HashMap hashMap = new HashMap();
        hashMap.put("intensity", Float.valueOf(0.65f));
        c25623a.setParameterDic(hashMap);
        setNextFilter(c25623a, null);
        C44654ab c44654ab = new C44654ab();
        c44654ab.addParam(new C0936o("inputImageTexture2", "sh/kongcheng_lf.png", 33986));
        c25623a.setNextFilter(c44654ab, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86548);
    }
}
