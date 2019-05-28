package com.tencent.p177mm.plugin.webview.p580ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.webview.modeltools.C46430c;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.adl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.k */
public final class C40344k {
    Map<String, C40345a> ulm;
    private JsapiPermissionWrapper uln;
    private GeneralControlWrapper ulo;
    private final JsapiPermissionWrapper ulp = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper ulq = GeneralControlWrapper.vxF;
    private C40343b utR;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.k$b */
    public interface C40343b {
        String aYj();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.k$a */
    static class C40345a {
        public JsapiPermissionWrapper ulr;
        public GeneralControlWrapper uls;

        public C40345a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.ulr = jsapiPermissionWrapper;
            this.uls = generalControlWrapper;
        }

        public final String toString() {
            AppMethodBeat.m2504i(7687);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.ulr);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.uls);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(7687);
            return stringBuilder2;
        }
    }

    public C40344k(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper, C40343b c40343b) {
        int i;
        AppMethodBeat.m2504i(7688);
        this.uln = jsapiPermissionWrapper;
        if (C1947ae.giu == null || C1947ae.giu.length() == 0) {
            C4990ab.m7416i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = C5046bo.getInt(C1947ae.giu, 0);
                if (i < 0) {
                    C4990ab.m7420w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.uln = new JsapiPermissionWrapper(i);
                    C4990ab.m7416i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uln);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.uln = null;
            }
        }
        this.ulo = generalControlWrapper;
        if (C1947ae.giv == null || C1947ae.giv.length() == 0) {
            C4990ab.m7416i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                C4990ab.m7417i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(C5046bo.getInt(C1947ae.giv, 0)));
                adl adl = new adl();
                adl.wli = i;
                this.ulo = new GeneralControlWrapper(adl);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.ulo = null;
            }
            C4990ab.m7416i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.ulo);
        }
        this.utR = c40343b;
        C4990ab.m7416i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + jsapiPermissionWrapper + ", hardcodeGenCtrl = " + generalControlWrapper);
        this.ulm = new HashMap();
        AppMethodBeat.m2505o(7688);
    }

    /* renamed from: a */
    public final void mo63705a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        boolean z = false;
        AppMethodBeat.m2504i(7689);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewPermission", "update fail, url is null");
            AppMethodBeat.m2505o(7689);
            return;
        }
        Object jsapiPermissionWrapper2;
        Object generalControlWrapper2;
        if (generalControlWrapper2 != null) {
            if ((generalControlWrapper2.vxG & SQLiteGlobal.journalSizeLimit) != 0) {
                z = true;
            }
            C4990ab.m7410d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(z)));
        }
        C46430c.m87450bF(str, z);
        String aef = C40344k.aef(str);
        if (jsapiPermissionWrapper2 == null) {
            jsapiPermissionWrapper2 = this.ulp;
        }
        if (generalControlWrapper2 == null) {
            generalControlWrapper2 = this.ulq;
        }
        C4990ab.m7416i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper2 + ", genCtrl = " + generalControlWrapper2 + ", url = " + aef);
        this.ulm.put(aef, new C40345a(jsapiPermissionWrapper2, generalControlWrapper2));
        AppMethodBeat.m2505o(7689);
    }

    public final boolean has(String str) {
        AppMethodBeat.m2504i(7690);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewPermission", "has fail, url is null");
            AppMethodBeat.m2505o(7690);
            return false;
        }
        C40345a c40345a = (C40345a) this.ulm.get(C40344k.aef(str));
        if (c40345a == null || c40345a.ulr == this.ulp || c40345a.uls == this.ulq) {
            AppMethodBeat.m2505o(7690);
            return false;
        }
        AppMethodBeat.m2505o(7690);
        return true;
    }

    public final JsapiPermissionWrapper cZS() {
        AppMethodBeat.m2504i(7691);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            C4990ab.m7416i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.m2505o(7691);
            return jsapiPermissionWrapper;
        }
        jsapiPermissionWrapper = aei(this.utR != null ? this.utR.aYj() : null);
        AppMethodBeat.m2505o(7691);
        return jsapiPermissionWrapper;
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.m2504i(7692);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            C4990ab.m7416i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.m2505o(7692);
            return jsapiPermissionWrapper;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewPermission", "getJsPerm fail, url = ".concat(String.valueOf(str)));
            jsapiPermissionWrapper = this.ulp;
            AppMethodBeat.m2505o(7692);
            return jsapiPermissionWrapper;
        } else {
            String aef = C40344k.aef(str);
            if (this.ulm == null) {
                C4990ab.m7412e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.m2505o(7692);
                return jsapiPermissionWrapper;
            }
            C40345a c40345a = (C40345a) this.ulm.get(aef);
            if (c40345a == null) {
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.m2505o(7692);
                return jsapiPermissionWrapper;
            }
            jsapiPermissionWrapper = c40345a.ulr;
            AppMethodBeat.m2505o(7692);
            return jsapiPermissionWrapper;
        }
    }

    public final GeneralControlWrapper cZT() {
        AppMethodBeat.m2504i(7693);
        GeneralControlWrapper aej = aej(this.utR != null ? this.utR.aYj() : null);
        AppMethodBeat.m2505o(7693);
        return aej;
    }

    private GeneralControlWrapper aej(String str) {
        AppMethodBeat.m2504i(7694);
        GeneralControlWrapper generalControlWrapper;
        if (this.ulo != null) {
            C4990ab.m7416i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.ulo);
            generalControlWrapper = this.ulo;
            AppMethodBeat.m2505o(7694);
            return generalControlWrapper;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = ".concat(String.valueOf(str)));
            generalControlWrapper = this.ulq;
            AppMethodBeat.m2505o(7694);
            return generalControlWrapper;
        } else {
            String aef = C40344k.aef(str);
            C40345a c40345a = (C40345a) this.ulm.get(aef);
            C4990ab.m7416i("MicroMsg.WebViewPermission", "edw getGenCtrl, genCtrl = " + (c40345a == null ? null : c40345a.uls) + ", url = " + aef);
            if (c40345a == null) {
                generalControlWrapper = this.ulq;
                AppMethodBeat.m2505o(7694);
                return generalControlWrapper;
            }
            generalControlWrapper = c40345a.uls;
            AppMethodBeat.m2505o(7694);
            return generalControlWrapper;
        }
    }

    private static String aef(String str) {
        AppMethodBeat.m2504i(7695);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(7695);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(7695);
        return str;
    }
}
