package com.tencent.p177mm.plugin.ipcall.p438a.p441e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e.a */
public class C39258a {
    public boolean cFy = false;

    public void start() {
        AppMethodBeat.m2504i(21881);
        reset();
        this.cFy = true;
        AppMethodBeat.m2505o(21881);
    }

    public void reset() {
    }

    /* Access modifiers changed, original: protected */
    public void bHT() {
    }

    public final void finish() {
        AppMethodBeat.m2504i(21882);
        if (this.cFy) {
            bHT();
            this.cFy = false;
        }
        AppMethodBeat.m2505o(21882);
    }
}
