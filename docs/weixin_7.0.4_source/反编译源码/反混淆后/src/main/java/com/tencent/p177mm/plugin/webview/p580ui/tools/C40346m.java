package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C40259aq;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.m */
public final class C40346m {
    public static C40346m uuj = new C40346m();
    private String bssid;
    private String cvF;
    boolean foa = false;
    C46434d icy = null;
    private int networkType;
    String qTK;
    private String ssid;
    String uuk;

    static {
        AppMethodBeat.m2504i(7712);
        AppMethodBeat.m2505o(7712);
    }

    private C40346m() {
    }

    /* renamed from: hg */
    public final void mo63714hg(String str, String str2) {
        AppMethodBeat.m2504i(7707);
        C4990ab.m7416i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.qTK = str;
        this.networkType = C40259aq.aEn();
        this.cvF = C4995ag.m7428ck(str2 + C5046bo.anU());
        this.ssid = C5023at.m7474gE(C4996ah.getContext());
        this.bssid = C5023at.m7475gF(C4996ah.getContext());
        this.foa = false;
        AppMethodBeat.m2505o(7707);
    }

    /* renamed from: Jq */
    public final void mo63711Jq(int i) {
        AppMethodBeat.m2504i(7708);
        C4990ab.m7419v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", this.qTK);
        if (C5046bo.isNullOrNil(this.qTK)) {
            AppMethodBeat.m2505o(7708);
            return;
        }
        mo63713h(3, "", i);
        AppMethodBeat.m2505o(7708);
    }

    public final void close() {
        AppMethodBeat.m2504i(7709);
        C4990ab.m7419v("MicroMsg.WebViewReportUtil", "close traceid %s", this.qTK);
        this.foa = true;
        if (C5046bo.isNullOrNil(this.qTK)) {
            AppMethodBeat.m2505o(7709);
            return;
        }
        mo63715kT(4);
        this.qTK = null;
        AppMethodBeat.m2505o(7709);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kT */
    public final void mo63715kT(int i) {
        AppMethodBeat.m2504i(7710);
        mo63713h(i, "", 0);
        AppMethodBeat.m2505o(7710);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final void mo63713h(int i, String str, int i2) {
        AppMethodBeat.m2504i(7711);
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20adInfo", this.qTK + ",");
        c32831d.mo53400l("21optype", i + ",");
        c32831d.mo53400l("22sessionId", this.cvF + ",");
        c32831d.mo53400l("23currURL", this.uuk + ",");
        c32831d.mo53400l("24referURL", str + ",");
        c32831d.mo53400l("25errCode", i2 + ",");
        c32831d.mo53400l("26networkType", this.networkType + ",");
        c32831d.mo53400l("27timeStamp", C5046bo.anU() + ",");
        c32831d.mo53400l("28ssid", this.ssid + ",");
        c32831d.mo53400l("29bssid", this.bssid + ",");
        C4990ab.m7417i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", Integer.valueOf(i), this.cvF, this.uuk, str, Integer.valueOf(i2), Integer.valueOf(this.networkType));
        C7060h.pYm.mo8381e(13791, c32831d);
        if (this.icy == null) {
            C4990ab.m7412e("MicroMsg.WebViewReportUtil", "report invoker null");
            AppMethodBeat.m2505o(7711);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ad_report_data_str", c32831d.toString());
        try {
            this.icy.mo15590s(1295, bundle);
            AppMethodBeat.m2505o(7711);
        } catch (RemoteException e) {
            C4990ab.m7413e("MicroMsg.WebViewReportUtil", "report: exp:%s", e);
            AppMethodBeat.m2505o(7711);
        }
    }
}
