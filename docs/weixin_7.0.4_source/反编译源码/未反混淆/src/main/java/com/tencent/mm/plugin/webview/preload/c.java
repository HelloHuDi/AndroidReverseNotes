package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class c {
    public long endTime;
    public int exv = 0;
    public int scene;
    public long startTime;
    public int upJ = 0;
    public int upK = 0;
    public int upL = 0;

    public final void cYQ() {
        this.upJ++;
    }

    public final void cYR() {
        this.upK++;
    }

    public final void IV(int i) {
        this.upL += i;
    }

    public final void IF() {
        String str;
        AppMethodBeat.i(80444);
        long j = this.endTime - this.startTime;
        if (at.isWifi(ah.getContext())) {
            str = "wifi";
        } else if (at.is4G(ah.getContext())) {
            str = "4g";
        } else if (at.is3G(ah.getContext())) {
            str = "3g";
        } else if (at.is2G(ah.getContext())) {
            str = "2g";
        } else {
            str = "none";
        }
        ab.d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", Integer.valueOf(this.scene), Integer.valueOf(this.exv), Integer.valueOf(this.upJ), Integer.valueOf(this.upK), Long.valueOf(j), Integer.valueOf(this.upL), str);
        h.pYm.e(15871, Integer.valueOf(this.scene), Integer.valueOf(this.exv), Integer.valueOf(this.upJ), Integer.valueOf(this.upK), Long.valueOf(j), Integer.valueOf(this.upL), str);
        AppMethodBeat.o(80444);
    }
}
