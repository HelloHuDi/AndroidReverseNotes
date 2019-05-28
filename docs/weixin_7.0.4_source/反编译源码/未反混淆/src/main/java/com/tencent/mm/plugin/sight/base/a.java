package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public int eTk = 0;
    public int eWK = 0;
    public int fzS = 0;
    public int height = 0;
    public int qwV = 0;
    public int videoBitrate = 0;
    public int width = 0;

    public final int ckU() {
        AppMethodBeat.i(117301);
        int mA = bo.mA((long) this.eWK);
        AppMethodBeat.o(117301);
        return mA;
    }

    public final String toString() {
        AppMethodBeat.i(117302);
        String str = "[ videoDuration: " + this.eWK + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.eTk + " audioChannel: " + this.qwV + " audioBitrate: " + this.fzS + "]";
        AppMethodBeat.o(117302);
        return str;
    }
}
