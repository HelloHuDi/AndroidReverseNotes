package com.tencent.p177mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sight.base.a */
public final class C43528a {
    public int eTk = 0;
    public int eWK = 0;
    public int fzS = 0;
    public int height = 0;
    public int qwV = 0;
    public int videoBitrate = 0;
    public int width = 0;

    public final int ckU() {
        AppMethodBeat.m2504i(117301);
        int mA = C5046bo.m7576mA((long) this.eWK);
        AppMethodBeat.m2505o(117301);
        return mA;
    }

    public final String toString() {
        AppMethodBeat.m2504i(117302);
        String str = "[ videoDuration: " + this.eWK + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.eTk + " audioChannel: " + this.qwV + " audioBitrate: " + this.fzS + "]";
        AppMethodBeat.m2505o(117302);
        return str;
    }
}
