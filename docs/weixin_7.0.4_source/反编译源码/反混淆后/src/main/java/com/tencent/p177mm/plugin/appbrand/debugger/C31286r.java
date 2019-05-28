package com.tencent.p177mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19346bo;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.protocal.protobuf.cqv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.r */
public final class C31286r extends C19722s implements C26849i {
    private C42411l hjR;
    private C42413n hku;

    public final C6747i aua() {
        AppMethodBeat.m2504i(129947);
        this.hku = new C42413n();
        C42413n c42413n = this.hku;
        AppMethodBeat.m2505o(129947);
        return c42413n;
    }

    public final boolean aui() {
        return false;
    }

    /* renamed from: h */
    public final void mo51255h(String str, String str2, int i) {
        String str3;
        AppMethodBeat.m2504i(129948);
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "{}";
        }
        C4990ab.m7411d("MicroMsg.RemoteDebugService", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i));
        this.hku.hjS = str;
        C42413n c42413n = this.hku;
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
        objArr[3] = C19346bo.m30024QB();
        c42413n.evaluateJavascript(String.format(str4, objArr), null);
        AppMethodBeat.m2505o(129948);
    }

    /* renamed from: M */
    public final void mo6107M(int i, String str) {
        AppMethodBeat.m2504i(129949);
        if (C5046bo.isNullOrNil(str)) {
            str = "{}";
        }
        this.hku.hjU.mo67942L(i, str);
        AppMethodBeat.m2505o(129949);
    }

    /* renamed from: a */
    public final int mo51254a(C6747i c6747i, int i) {
        return i;
    }

    public final void aud() {
    }

    /* renamed from: wO */
    public final void mo34953wO() {
        AppMethodBeat.m2504i(129950);
        atZ();
        AppMethodBeat.m2505o(129950);
    }

    /* renamed from: xd */
    public final void mo34956xd(String str) {
    }

    /* renamed from: m */
    public final void mo34952m(C6750i c6750i) {
        AppMethodBeat.m2504i(129951);
        super.mo34952m(c6750i);
        aCd();
        if (C26852t.hkA != null) {
            this.hjR = C26852t.hkA;
            C26852t.hkA = null;
        } else {
            this.hjR = new C42411l();
        }
        this.hjR.mo67920a(this, getRuntime().atI().extInfo);
        this.hku.mo67938a(this.hjR);
        AppMethodBeat.m2505o(129951);
    }

    /* renamed from: dw */
    public final void mo34948dw(boolean z) {
        AppMethodBeat.m2504i(129952);
        super.mo34948dw(z);
        this.hku.hjW.bringToFront();
        AppMethodBeat.m2505o(129952);
    }

    public final String ayX() {
        AppMethodBeat.m2504i(129953);
        JSONObject xW = mo21959xW();
        String str = getRuntime().getAppConfig().hfg;
        String format = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{xW.toString(), str});
        AppMethodBeat.m2505o(129953);
        return format;
    }

    /* renamed from: zH */
    public final void mo44623zH(String str) {
        AppMethodBeat.m2504i(129954);
        C4990ab.m7410d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
        cqv cqv = new cqv();
        cqv.xoH = getRuntime().atJ().getCurrentPage().getCurrentPageView().hashCode();
        cqv.xoG = str;
        this.hku.mo67939a(C26852t.m42761a(cqv, this.hjR, "domEvent"));
        AppMethodBeat.m2505o(129954);
    }
}
