package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class g extends b {
    protected int gCL = 0;
    protected byte[] gug = null;
    protected String guh = "";
    protected String gui = "";

    g() {
    }

    public final void apw() {
        AppMethodBeat.i(34883);
        aw.Rg().a(new q(this.gCL, "", this.guh, this.gui), 0);
        AppMethodBeat.o(34883);
    }
}
