package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.h.g;
import com.tencent.mm.plugin.appbrand.h.q;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.appbrand.s.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Locale;
import org.json.JSONObject;

public abstract class e {
    public final q gMN;
    private final q gMO;
    private final g gMP;

    public abstract String asJ();

    public abstract String asK();

    public abstract int asL();

    protected e(q qVar, q qVar2) {
        this.gMN = qVar;
        this.gMO = qVar2;
        this.gMP = qVar2.aGV();
    }

    @JavascriptInterface
    public int alloc() {
        g asI = asI();
        if (asI == null) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", this.gMN.getAppId());
            return -2;
        }
        JSONObject aue;
        ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", Integer.valueOf(asI.aGT()));
        this.gMP.a(asI, "WeixinJSContext");
        if (this.gMN.getRuntime() == null) {
            aue = this.gMN.aue();
        } else {
            aue = this.gMN.xW();
        }
        asI.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[]{aue.toString()}), null);
        a(asI);
        String asJ = asJ();
        String asK = asK();
        if (bo.isNullOrNil(asK)) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), sdkScript 404", this.gMN.getAppId());
            asM();
            return 0;
        }
        a(asI, asJ, asK);
        return asI.aGT();
    }

    @JavascriptInterface
    public int create(String str) {
        ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", this.gMN.getAppId(), str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", this.gMN.getAppId());
            return -1;
        }
        int alloc = alloc();
        if (alloc <= 0) {
            return alloc;
        }
        g oO = this.gMO.oO(alloc);
        if (evaluateScriptFile(alloc, str) != 1) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", this.gMN.getAppId(), str, Integer.valueOf(evaluateScriptFile(alloc, str)));
            return -1;
        }
        ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", this.gMN.getAppId(), str, Integer.valueOf(oO.aGT()));
        return oO.aGT();
    }

    @JavascriptInterface
    public int evaluateScriptFile(int i, final String str) {
        ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", this.gMN.getAppId(), Integer.valueOf(i), str);
        final g oO = this.gMO.oO(i);
        if (oO == null) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", this.gMN.getAppId(), Integer.valueOf(i), str);
            return -1;
        } else if (oO.aGS()) {
            ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", this.gMN.getAppId(), str);
            return -1;
        } else {
            String a = aw.a(this.gMN.getRuntime(), str);
            if (bo.isNullOrNil(a)) {
                ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), script 404", this.gMN.getAppId(), Integer.valueOf(i), str);
                asN();
                return 0;
            }
            wL(str);
            a(oO, str, a, new a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(86647);
                    ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject succeed", e.this.gMN.getAppId(), Integer.valueOf(oO.aGT()), str);
                    e.this.dt(true);
                    AppMethodBeat.o(86647);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(86648);
                    ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), appScript inject failed", e.this.gMN.getAppId(), Integer.valueOf(oO.aGT()), str);
                    e.this.dt(false);
                    AppMethodBeat.o(86648);
                }
            });
            return 1;
        }
    }

    @JavascriptInterface
    public final void destroy(int i) {
        this.gMO.oP(i);
    }

    /* Access modifiers changed, original: protected */
    public void asH() {
        this.gMO.aGU().a(this.gMP, "WeixinJSContext");
    }

    /* Access modifiers changed, original: protected */
    public g asI() {
        return this.gMO.aGV();
    }

    /* Access modifiers changed, original: protected */
    public void a(g gVar) {
    }

    /* Access modifiers changed, original: protected */
    public void a(g gVar, String str, String str2, a aVar) {
        n.a(gVar, this.gMN.aug() + str, str.replace(IOUtils.DIR_SEPARATOR_UNIX, '_') + "_" + this.gMN.getAppId(), this.gMN.getRuntime().ye().hhd.cvZ, str2, this.gMN.xc(str), aVar);
    }

    /* Access modifiers changed, original: protected */
    public void a(g gVar, final String str, String str2) {
        n.a(gVar, this.gMN.auf() + str, str, "v" + asL(), str2, "", new a() {
            public final void onSuccess(String str) {
                AppMethodBeat.i(86649);
                ab.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject succeed", e.this.gMN.getAppId(), str);
                e.this.ds(true);
                AppMethodBeat.o(86649);
            }

            public final void lo(String str) {
                AppMethodBeat.i(86650);
                ab.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), scriptPath(%s), sdkScript inject failed", e.this.gMN.getAppId(), str);
                e.this.ds(false);
                AppMethodBeat.o(86650);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void asM() {
    }

    /* Access modifiers changed, original: protected */
    public void ds(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void asN() {
    }

    /* Access modifiers changed, original: protected */
    public void wL(String str) {
    }

    /* Access modifiers changed, original: protected */
    public void dt(boolean z) {
    }
}
