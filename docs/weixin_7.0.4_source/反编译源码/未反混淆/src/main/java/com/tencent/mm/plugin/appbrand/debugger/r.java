package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.i;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class r extends s implements i {
    private l hjR;
    private n hku;

    public final i aua() {
        AppMethodBeat.i(129947);
        this.hku = new n();
        n nVar = this.hku;
        AppMethodBeat.o(129947);
        return nVar;
    }

    public final boolean aui() {
        return false;
    }

    public final void h(String str, String str2, int i) {
        String str3;
        AppMethodBeat.i(129948);
        if (bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        ab.d("MicroMsg.RemoteDebugService", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i));
        this.hku.hjS = str;
        n nVar = this.hku;
        String str4 = "typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\" , %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        if (i == 0) {
            str3 = "undefined";
        } else {
            str3 = String.valueOf(i);
        }
        objArr[2] = str3;
        objArr[3] = com.tencent.mm.plugin.appbrand.jsapi.bo.QB();
        nVar.evaluateJavascript(String.format(str4, objArr), null);
        AppMethodBeat.o(129948);
    }

    public final void M(int i, String str) {
        AppMethodBeat.i(129949);
        if (bo.isNullOrNil(str)) {
            str = "{}";
        }
        this.hku.hjU.L(i, str);
        AppMethodBeat.o(129949);
    }

    public final int a(i iVar, int i) {
        return i;
    }

    public final void aud() {
    }

    public final void wO() {
        AppMethodBeat.i(129950);
        atZ();
        AppMethodBeat.o(129950);
    }

    public final void xd(String str) {
    }

    public final void m(com.tencent.mm.plugin.appbrand.i iVar) {
        AppMethodBeat.i(129951);
        super.m(iVar);
        aCd();
        if (t.hkA != null) {
            this.hjR = t.hkA;
            t.hkA = null;
        } else {
            this.hjR = new l();
        }
        this.hjR.a(this, getRuntime().atI().extInfo);
        this.hku.a(this.hjR);
        AppMethodBeat.o(129951);
    }

    public final void dw(boolean z) {
        AppMethodBeat.i(129952);
        super.dw(z);
        this.hku.hjW.bringToFront();
        AppMethodBeat.o(129952);
    }

    public final String ayX() {
        AppMethodBeat.i(129953);
        JSONObject xW = xW();
        String str = getRuntime().getAppConfig().hfg;
        String format = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{xW.toString(), str});
        AppMethodBeat.o(129953);
        return format;
    }

    public final void zH(String str) {
        AppMethodBeat.i(129954);
        ab.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
        cqv cqv = new cqv();
        cqv.xoH = getRuntime().atJ().getCurrentPage().getCurrentPageView().hashCode();
        cqv.xoG = str;
        this.hku.a(t.a(cqv, this.hjR, "domEvent"));
        AppMethodBeat.o(129954);
    }
}
