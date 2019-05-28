package com.tencent.p177mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.plugin.webview.preload.c */
public final class C43926c {
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

    /* renamed from: IV */
    public final void mo69612IV(int i) {
        this.upL += i;
    }

    /* renamed from: IF */
    public final void mo69611IF() {
        String str;
        AppMethodBeat.m2504i(80444);
        long j = this.endTime - this.startTime;
        if (C5023at.isWifi(C4996ah.getContext())) {
            str = "wifi";
        } else if (C5023at.is4G(C4996ah.getContext())) {
            str = "4g";
        } else if (C5023at.is3G(C4996ah.getContext())) {
            str = "3g";
        } else if (C5023at.is2G(C4996ah.getContext())) {
            str = "2g";
        } else {
            str = "none";
        }
        C4990ab.m7411d("MicroMsg.Preload.Kv15871", "scene:%d, requestCount:%d, responseContentUpdateCount:%d, responseContentNotUpdateCount:%d, costTime:%d responseContentTotalSize:%d, netWorkType:%s", Integer.valueOf(this.scene), Integer.valueOf(this.exv), Integer.valueOf(this.upJ), Integer.valueOf(this.upK), Long.valueOf(j), Integer.valueOf(this.upL), str);
        C7060h.pYm.mo8381e(15871, Integer.valueOf(this.scene), Integer.valueOf(this.exv), Integer.valueOf(this.upJ), Integer.valueOf(this.upK), Long.valueOf(j), Integer.valueOf(this.upL), str);
        AppMethodBeat.m2505o(80444);
    }
}
