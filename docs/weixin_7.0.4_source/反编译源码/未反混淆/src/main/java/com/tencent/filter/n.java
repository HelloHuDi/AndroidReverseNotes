package com.tencent.filter;

import com.tencent.filter.m.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n extends BaseFilter {
    public n() {
        super(GLSLRender.bJG, "share_film.jpg");
        AppMethodBeat.i(86425);
        addParam(new b("randomCoord2", (float) Math.random(), (float) Math.random()));
        AppMethodBeat.o(86425);
    }

    public final void OnDrawFrameGLSL() {
        AppMethodBeat.i(86426);
        b bVar = (b) getParam("randomCoord2");
        bVar.x = (float) Math.random();
        bVar.y = (float) Math.random();
        super.OnDrawFrameGLSL();
        AppMethodBeat.o(86426);
    }
}
