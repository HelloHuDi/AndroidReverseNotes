package com.tencent.p177mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.p297h.C38235g;
import com.tencent.p177mm.plugin.appbrand.p297h.C38237q;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.e */
public abstract class C33176e {
    public final C38492q gMN;
    private final C38237q gMO;
    private final C38235g gMP;

    public abstract String asJ();

    public abstract String asK();

    public abstract int asL();

    protected C33176e(C38492q c38492q, C38237q c38237q) {
        this.gMN = c38492q;
        this.gMO = c38237q;
        this.gMP = c38237q.aGV();
    }

    @JavascriptInterface
    public int alloc() {
        C38235g asI = asI();
        if (asI == null) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", this.gMN.getAppId());
            return -2;
        }
        JSONObject aue;
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", Integer.valueOf(asI.aGT()));
        this.gMP.mo30573a(asI, "WeixinJSContext");
        if (this.gMN.getRuntime() == null) {
            aue = this.gMN.aue();
        } else {
            aue = this.gMN.mo21959xW();
        }
        asI.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[]{aue.toString()}), null);
        mo53707a(asI);
        String asJ = asJ();
        String asK = asK();
        if (C5046bo.isNullOrNil(asK)) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), sdkScript 404", this.gMN.getAppId());
            asM();
            return 0;
        }
        mo53708a(asI, asJ, asK);
        return asI.aGT();
    }

    @JavascriptInterface
    public int create(String str) {
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", this.gMN.getAppId(), str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", this.gMN.getAppId());
            return -1;
        }
        int alloc = alloc();
        if (alloc <= 0) {
            return alloc;
        }
        C38235g oO = this.gMO.mo30582oO(alloc);
        if (evaluateScriptFile(alloc, str) != 1) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", this.gMN.getAppId(), str, Integer.valueOf(evaluateScriptFile(alloc, str)));
            return -1;
        }
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", this.gMN.getAppId(), str, Integer.valueOf(oO.aGT()));
        return oO.aGT();
    }

    @JavascriptInterface
    public int evaluateScriptFile(int i, final String str) {
        C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", this.gMN.getAppId(), Integer.valueOf(i), str);
        final C38235g oO = this.gMO.mo30582oO(i);
        if (oO == null) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", this.gMN.getAppId(), Integer.valueOf(i), str);
            return -1;
        } else if (oO.aGS()) {
            C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", this.gMN.getAppId(), str);
            return -1;
        } else {
            String a = C33082aw.m54068a(this.gMN.getRuntime(), str);
            if (C5046bo.isNullOrNil(a)) {
                C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), script 404", this.gMN.getAppId(), Integer.valueOf(i), str);
                asN();
                return 0;
            }
            mo53723wL(str);
            mo53709a(oO, str, a, new C42683a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.m2504i(86647);
                    C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject succeed", C33176e.this.gMN.getAppId(), Integer.valueOf(oO.aGT()), str);
                    C33176e.this.mo53721dt(true);
                    AppMethodBeat.m2505o(86647);
                }

                /* renamed from: lo */
                public final void mo5987lo(String str) {
                    AppMethodBeat.m2504i(86648);
                    C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject failed", C33176e.this.gMN.getAppId(), Integer.valueOf(oO.aGT()), str);
                    C33176e.this.mo53721dt(false);
                    AppMethodBeat.m2505o(86648);
                }
            });
            return 1;
        }
    }

    @JavascriptInterface
    public final void destroy(int i) {
        this.gMO.mo30583oP(i);
    }

    /* Access modifiers changed, original: protected */
    public void asH() {
        this.gMO.aGU().mo30573a(this.gMP, "WeixinJSContext");
    }

    /* Access modifiers changed, original: protected */
    public C38235g asI() {
        return this.gMO.aGV();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo53707a(C38235g c38235g) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo53709a(C38235g c38235g, String str, String str2, C42683a c42683a) {
        C42682n.m75590a(c38235g, this.gMN.aug() + str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().mo15034ye().hhd.cvZ, str2, this.gMN.mo61201xc(str), c42683a);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo53708a(C38235g c38235g, final String str, String str2) {
        C42682n.m75590a(c38235g, this.gMN.auf() + str, str, "v" + asL(), str2, "", new C42683a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(86649);
                C4990ab.m7417i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", C33176e.this.gMN.getAppId(), str);
                C33176e.this.mo53720ds(true);
                AppMethodBeat.m2505o(86649);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                AppMethodBeat.m2504i(86650);
                C4990ab.m7413e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject failed", C33176e.this.gMN.getAppId(), str);
                C33176e.this.mo53720ds(false);
                AppMethodBeat.m2505o(86650);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void asM() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: ds */
    public void mo53720ds(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void asN() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wL */
    public void mo53723wL(String str) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: dt */
    public void mo53721dt(boolean z) {
    }
}
