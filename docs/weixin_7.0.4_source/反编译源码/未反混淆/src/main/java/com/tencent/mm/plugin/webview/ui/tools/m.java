package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    public static m uuj = new m();
    private String bssid;
    private String cvF;
    boolean foa = false;
    d icy = null;
    private int networkType;
    String qTK;
    private String ssid;
    String uuk;

    static {
        AppMethodBeat.i(7712);
        AppMethodBeat.o(7712);
    }

    private m() {
    }

    public final void hg(String str, String str2) {
        AppMethodBeat.i(7707);
        ab.i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.qTK = str;
        this.networkType = aq.aEn();
        this.cvF = ag.ck(str2 + bo.anU());
        this.ssid = at.gE(ah.getContext());
        this.bssid = at.gF(ah.getContext());
        this.foa = false;
        AppMethodBeat.o(7707);
    }

    public final void Jq(int i) {
        AppMethodBeat.i(7708);
        ab.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", this.qTK);
        if (bo.isNullOrNil(this.qTK)) {
            AppMethodBeat.o(7708);
            return;
        }
        h(3, "", i);
        AppMethodBeat.o(7708);
    }

    public final void close() {
        AppMethodBeat.i(7709);
        ab.v("MicroMsg.WebViewReportUtil", "close traceid %s", this.qTK);
        this.foa = true;
        if (bo.isNullOrNil(this.qTK)) {
            AppMethodBeat.o(7709);
            return;
        }
        kT(4);
        this.qTK = null;
        AppMethodBeat.o(7709);
    }

    /* Access modifiers changed, original: final */
    public final void kT(int i) {
        AppMethodBeat.i(7710);
        h(i, "", 0);
        AppMethodBeat.o(7710);
    }

    /* Access modifiers changed, original: final */
    public final void h(int i, String str, int i2) {
        AppMethodBeat.i(7711);
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20adInfo", this.qTK + ",");
        dVar.l("21optype", i + ",");
        dVar.l("22sessionId", this.cvF + ",");
        dVar.l("23currURL", this.uuk + ",");
        dVar.l("24referURL", str + ",");
        dVar.l("25errCode", i2 + ",");
        dVar.l("26networkType", this.networkType + ",");
        dVar.l("27timeStamp", bo.anU() + ",");
        dVar.l("28ssid", this.ssid + ",");
        dVar.l("29bssid", this.bssid + ",");
        ab.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", Integer.valueOf(i), this.cvF, this.uuk, str, Integer.valueOf(i2), Integer.valueOf(this.networkType));
        h.pYm.e(13791, dVar);
        if (this.icy == null) {
            ab.e("MicroMsg.WebViewReportUtil", "report invoker null");
            AppMethodBeat.o(7711);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ad_report_data_str", dVar.toString());
        try {
            this.icy.s(1295, bundle);
            AppMethodBeat.o(7711);
        } catch (RemoteException e) {
            ab.e("MicroMsg.WebViewReportUtil", "report: exp:%s", e);
            AppMethodBeat.o(7711);
        }
    }
}
