package com.tencent.filter;

import com.tencent.filter.C25624m.C25629b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.filter.n */
public final class C17758n extends BaseFilter {
    public C17758n() {
        super(GLSLRender.bJG, "share_film.jpg");
        AppMethodBeat.m2504i(86425);
        addParam(new C25629b("randomCoord2", (float) Math.random(), (float) Math.random()));
        AppMethodBeat.m2505o(86425);
    }

    public final void OnDrawFrameGLSL() {
        AppMethodBeat.m2504i(86426);
        C25629b c25629b = (C25629b) getParam("randomCoord2");
        c25629b.f5227x = (float) Math.random();
        c25629b.f5228y = (float) Math.random();
        super.OnDrawFrameGLSL();
        AppMethodBeat.m2505o(86426);
    }
}
