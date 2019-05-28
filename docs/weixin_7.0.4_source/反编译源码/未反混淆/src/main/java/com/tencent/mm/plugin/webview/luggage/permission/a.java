package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class a {
    Map<String, a> ulm = new HashMap();
    private JsapiPermissionWrapper uln = null;
    private GeneralControlWrapper ulo;
    final JsapiPermissionWrapper ulp = new JsapiPermissionWrapper(2);
    final GeneralControlWrapper ulq = GeneralControlWrapper.vxF;

    static class a {
        public JsapiPermissionWrapper ulr;
        public GeneralControlWrapper uls;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.ulr = jsapiPermissionWrapper;
            this.uls = generalControlWrapper;
        }

        public final String toString() {
            AppMethodBeat.i(6481);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.ulr);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.uls);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(6481);
            return stringBuilder2;
        }
    }

    public a() {
        int i;
        AppMethodBeat.i(6482);
        if (ae.giu == null || ae.giu.length() == 0) {
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bo.getInt(ae.giu, 0);
                if (i < 0) {
                    ab.w("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.uln = new JsapiPermissionWrapper(i);
                    ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uln);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.uln = null;
            }
        }
        this.ulo = null;
        if (ae.giv == null || ae.giv.length() == 0) {
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(bo.getInt(ae.giv, 0)));
                adl adl = new adl();
                adl.wli = i;
                this.ulo = new GeneralControlWrapper(adl);
            } catch (Exception e2) {
                ab.e("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.ulo = null;
            }
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.ulo);
        }
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "hardcodeJsPerm = " + null + ", hardcodeGenCtrl = " + null);
        AppMethodBeat.o(6482);
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        AppMethodBeat.i(6483);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.LuggageGetA8KeyPermission", "update fail, url is null");
            AppMethodBeat.o(6483);
            return;
        }
        String aef = aef(str);
        ab.i("MicroMsg.LuggageGetA8KeyPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + aef);
        this.ulm.put(aef, new a(jsapiPermissionWrapper, generalControlWrapper));
        AppMethodBeat.o(6483);
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.i(6484);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.o(6484);
            return jsapiPermissionWrapper;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, url = ".concat(String.valueOf(str)));
            jsapiPermissionWrapper = this.ulp;
            AppMethodBeat.o(6484);
            return jsapiPermissionWrapper;
        } else {
            String aef = aef(str);
            if (this.ulm == null) {
                ab.e("MicroMsg.LuggageGetA8KeyPermission", "getJsPerm fail, permMap is null");
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.o(6484);
                return jsapiPermissionWrapper;
            }
            a aVar = (a) this.ulm.get(aef);
            if (aVar == null) {
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.o(6484);
                return jsapiPermissionWrapper;
            }
            jsapiPermissionWrapper = aVar.ulr;
            AppMethodBeat.o(6484);
            return jsapiPermissionWrapper;
        }
    }

    public final GeneralControlWrapper aej(String str) {
        AppMethodBeat.i(6485);
        GeneralControlWrapper generalControlWrapper;
        if (this.ulo != null) {
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.ulo);
            generalControlWrapper = this.ulo;
            AppMethodBeat.o(6485);
            return generalControlWrapper;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.LuggageGetA8KeyPermission", "getGenCtrl fail, url = ".concat(String.valueOf(str)));
            generalControlWrapper = this.ulq;
            AppMethodBeat.o(6485);
            return generalControlWrapper;
        } else {
            String aef = aef(str);
            a aVar = (a) this.ulm.get(aef);
            ab.i("MicroMsg.LuggageGetA8KeyPermission", "edw getGenCtrl, genCtrl = " + (aVar == null ? null : aVar.uls) + ", url = " + aef);
            if (aVar == null) {
                generalControlWrapper = this.ulq;
                AppMethodBeat.o(6485);
                return generalControlWrapper;
            }
            generalControlWrapper = aVar.uls;
            AppMethodBeat.o(6485);
            return generalControlWrapper;
        }
    }

    static String aef(String str) {
        AppMethodBeat.i(6486);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(6486);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(6486);
        return str;
    }
}
