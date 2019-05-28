package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak implements aj {
    public volatile boolean cEn;
    public volatile boolean ftW;
    public volatile boolean hxt;
    public volatile boolean hxu;
    a vcJ;

    public interface a {
        void r(boolean z, boolean z2);
    }

    public ak(a aVar) {
        this.vcJ = aVar;
    }

    public final void dR(boolean z) {
        AppMethodBeat.i(79395);
        this.ftW = true;
        this.hxt = z;
        if (this.hxu && this.vcJ != null) {
            this.vcJ.r(this.cEn, z);
        }
        AppMethodBeat.o(79395);
    }

    public final void dS(boolean z) {
        AppMethodBeat.i(79396);
        this.cEn = z;
        this.hxu = true;
        if (this.ftW && this.vcJ != null) {
            this.vcJ.r(z, this.hxt);
        }
        AppMethodBeat.o(79396);
    }
}
