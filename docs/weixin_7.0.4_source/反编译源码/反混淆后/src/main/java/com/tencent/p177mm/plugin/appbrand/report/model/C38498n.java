package com.tencent.p177mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.n */
public final class C38498n {
    public String appId;
    public int axy;
    public int css;
    public final String cvF;
    public final C41243o htn;
    public String iBz;
    public volatile long iCb;
    public volatile boolean iCc = false;
    public int iCd;
    public int iCe;
    public long iCf;
    public long iCg;
    public int scene;

    public C38498n(C41243o c41243o) {
        AppMethodBeat.m2504i(132650);
        this.htn = c41243o;
        this.cvF = c41243o.atI().mo32993xz();
        AppMethodBeat.m2505o(132650);
    }

    public final String toString() {
        AppMethodBeat.m2504i(132651);
        String str = "kv_14576{, networkType='" + this.iBz + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.axy + ", appState=" + this.css + ", scene=" + this.scene + ", sessionId='" + this.cvF + '\'' + ", is_download_code=" + this.iCd + ", is_load_x5=" + this.iCe + ", cost_time=" + this.iCf + ", event_time=" + this.iCg + ", load_time=" + this.iCb + ", real_time=" + C5046bo.m7588yz() + '}';
        AppMethodBeat.m2505o(132651);
        return str;
    }
}
