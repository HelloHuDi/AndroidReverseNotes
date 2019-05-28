package com.tencent.p177mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.adl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.luggage.permission.a */
public final class C46421a {
    Map<String, C14504a> ulm = new HashMap();
    private JsapiPermissionWrapper uln = null;
    private GeneralControlWrapper ulo;
    final JsapiPermissionWrapper ulp = new JsapiPermissionWrapper(2);
    final GeneralControlWrapper ulq = GeneralControlWrapper.vxF;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.permission.a$a */
    static class C14504a {
        public JsapiPermissionWrapper ulr;
        public GeneralControlWrapper uls;

        public C14504a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.ulr = jsapiPermissionWrapper;
            this.uls = generalControlWrapper;
        }

        public final String toString() {
            AppMethodBeat.m2504i(6481);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.ulr);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.uls);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(6481);
            return stringBuilder2;
        }
    }

    public C46421a() {
        int i;
        AppMethodBeat.m2504i(6482);
        if (C1947ae.giu == null || C1947ae.giu.length() == 0) {
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = C5046bo.getInt(C1947ae.giu, 0);
                if (i < 0) {
                    C4990ab.m7420w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.uln = new JsapiPermissionWrapper(i);
                    C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uln);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.uln = null;
            }
        }
        this.ulo = null;
        if (C1947ae.giv == null || C1947ae.giv.length() == 0) {
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                C4990ab.m7417i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(C5046bo.getInt(C1947ae.giv, 0)));
                adl adl = new adl();
                adl.wli = i;
                this.ulo = new GeneralControlWrapper(adl);
            } catch (Exception e2) {
                C4990ab.m7413e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.ulo = null;
            }
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.ulo);
        }
        C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.m2505o(6482);
    }

    /* renamed from: a */
    public final void mo74641a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.m2504i(6483);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
            AppMethodBeat.m2505o(6483);
            return;
        }
        String aef = C46421a.aef(str);
        C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + aef);
        this.ulm.put(aef, new C14504a(jsapiPermissionWrapper, generalControlWrapper));
        AppMethodBeat.m2505o(6483);
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.m2504i(6484);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.m2505o(6484);
            return jsapiPermissionWrapper;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(str)));
            jsapiPermissionWrapper = this.ulp;
            AppMethodBeat.m2505o(6484);
            return jsapiPermissionWrapper;
        } else {
            String aef = C46421a.aef(str);
            if (this.ulm == null) {
                C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.m2505o(6484);
                return jsapiPermissionWrapper;
            }
            C14504a c14504a = (C14504a) this.ulm.get(aef);
            if (c14504a == null) {
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.m2505o(6484);
                return jsapiPermissionWrapper;
            }
            jsapiPermissionWrapper = c14504a.ulr;
            AppMethodBeat.m2505o(6484);
            return jsapiPermissionWrapper;
        }
    }

    public final GeneralControlWrapper aej(String str) {
        AppMethodBeat.m2504i(6485);
        GeneralControlWrapper generalControlWrapper;
        if (this.ulo != null) {
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.ulo);
            generalControlWrapper = this.ulo;
            AppMethodBeat.m2505o(6485);
            return generalControlWrapper;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(str)));
            generalControlWrapper = this.ulq;
            AppMethodBeat.m2505o(6485);
            return generalControlWrapper;
        } else {
            String aef = C46421a.aef(str);
            C14504a c14504a = (C14504a) this.ulm.get(aef);
            C4990ab.m7416i("MicroMsg.LuggageGetA8KeyPermission", "edw getGenCtrl, genCtrl = " + (c14504a == null ? null : c14504a.uls) + ", url = " + aef);
            if (c14504a == null) {
                generalControlWrapper = this.ulq;
                AppMethodBeat.m2505o(6485);
                return generalControlWrapper;
            }
            generalControlWrapper = c14504a.uls;
            AppMethodBeat.m2505o(6485);
            return generalControlWrapper;
        }
    }

    static String aef(String str) {
        AppMethodBeat.m2504i(6486);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(6486);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(6486);
        return str;
    }
}
