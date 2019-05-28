package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map;

public final class k {
    Map<String, a> ulm;
    private JsapiPermissionWrapper uln;
    private GeneralControlWrapper ulo;
    private final JsapiPermissionWrapper ulp = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper ulq = GeneralControlWrapper.vxF;
    private b utR;

    public interface b {
        String aYj();
    }

    static class a {
        public JsapiPermissionWrapper ulr;
        public GeneralControlWrapper uls;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.ulr = jsapiPermissionWrapper;
            this.uls = generalControlWrapper;
        }

        public final String toString() {
            AppMethodBeat.i(7687);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.ulr);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.uls);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(7687);
            return stringBuilder2;
        }
    }

    public k(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper, b bVar) {
        int i;
        AppMethodBeat.i(7688);
        this.uln = jsapiPermissionWrapper;
        if (ae.giu == null || ae.giu.length() == 0) {
            ab.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bo.getInt(ae.giu, 0);
                if (i < 0) {
                    ab.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.uln = new JsapiPermissionWrapper(i);
                    ab.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.uln);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.uln = null;
            }
        }
        this.ulo = generalControlWrapper;
        if (ae.giv == null || ae.giv.length() == 0) {
            ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", Integer.valueOf(bo.getInt(ae.giv, 0)));
                adl adl = new adl();
                adl.wli = i;
                this.ulo = new GeneralControlWrapper(adl);
            } catch (Exception e2) {
                ab.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", e2.getMessage());
                this.ulo = null;
            }
            ab.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.ulo);
        }
        this.utR = bVar;
        ab.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + jsapiPermissionWrapper + ", hardcodeGenCtrl = " + generalControlWrapper);
        this.ulm = new HashMap();
        AppMethodBeat.o(7688);
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        boolean z = false;
        AppMethodBeat.i(7689);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewPermission", "update fail, url is null");
            AppMethodBeat.o(7689);
            return;
        }
        Object jsapiPermissionWrapper2;
        Object generalControlWrapper2;
        if (generalControlWrapper2 != null) {
            if ((generalControlWrapper2.vxG & SQLiteGlobal.journalSizeLimit) != 0) {
                z = true;
            }
            ab.d("MicroMsg.GeneralControlWrapper", "needClearData, ret = ".concat(String.valueOf(z)));
        }
        c.bF(str, z);
        String aef = aef(str);
        if (jsapiPermissionWrapper2 == null) {
            jsapiPermissionWrapper2 = this.ulp;
        }
        if (generalControlWrapper2 == null) {
            generalControlWrapper2 = this.ulq;
        }
        ab.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper2 + ", genCtrl = " + generalControlWrapper2 + ", url = " + aef);
        this.ulm.put(aef, new a(jsapiPermissionWrapper2, generalControlWrapper2));
        AppMethodBeat.o(7689);
    }

    public final boolean has(String str) {
        AppMethodBeat.i(7690);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewPermission", "has fail, url is null");
            AppMethodBeat.o(7690);
            return false;
        }
        a aVar = (a) this.ulm.get(aef(str));
        if (aVar == null || aVar.ulr == this.ulp || aVar.uls == this.ulq) {
            AppMethodBeat.o(7690);
            return false;
        }
        AppMethodBeat.o(7690);
        return true;
    }

    public final JsapiPermissionWrapper cZS() {
        AppMethodBeat.i(7691);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            ab.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.o(7691);
            return jsapiPermissionWrapper;
        }
        jsapiPermissionWrapper = aei(this.utR != null ? this.utR.aYj() : null);
        AppMethodBeat.o(7691);
        return jsapiPermissionWrapper;
    }

    public final JsapiPermissionWrapper aei(String str) {
        AppMethodBeat.i(7692);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        if (this.uln != null) {
            ab.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.uln);
            jsapiPermissionWrapper = this.uln;
            AppMethodBeat.o(7692);
            return jsapiPermissionWrapper;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = ".concat(String.valueOf(str)));
            jsapiPermissionWrapper = this.ulp;
            AppMethodBeat.o(7692);
            return jsapiPermissionWrapper;
        } else {
            String aef = aef(str);
            if (this.ulm == null) {
                ab.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.o(7692);
                return jsapiPermissionWrapper;
            }
            a aVar = (a) this.ulm.get(aef);
            if (aVar == null) {
                jsapiPermissionWrapper = this.ulp;
                AppMethodBeat.o(7692);
                return jsapiPermissionWrapper;
            }
            jsapiPermissionWrapper = aVar.ulr;
            AppMethodBeat.o(7692);
            return jsapiPermissionWrapper;
        }
    }

    public final GeneralControlWrapper cZT() {
        AppMethodBeat.i(7693);
        GeneralControlWrapper aej = aej(this.utR != null ? this.utR.aYj() : null);
        AppMethodBeat.o(7693);
        return aej;
    }

    private GeneralControlWrapper aej(String str) {
        AppMethodBeat.i(7694);
        GeneralControlWrapper generalControlWrapper;
        if (this.ulo != null) {
            ab.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.ulo);
            generalControlWrapper = this.ulo;
            AppMethodBeat.o(7694);
            return generalControlWrapper;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = ".concat(String.valueOf(str)));
            generalControlWrapper = this.ulq;
            AppMethodBeat.o(7694);
            return generalControlWrapper;
        } else {
            String aef = aef(str);
            a aVar = (a) this.ulm.get(aef);
            ab.i("MicroMsg.WebViewPermission", "edw getGenCtrl, genCtrl = " + (aVar == null ? null : aVar.uls) + ", url = " + aef);
            if (aVar == null) {
                generalControlWrapper = this.ulq;
                AppMethodBeat.o(7694);
                return generalControlWrapper;
            }
            generalControlWrapper = aVar.uls;
            AppMethodBeat.o(7694);
            return generalControlWrapper;
        }
    }

    private static String aef(String str) {
        AppMethodBeat.i(7695);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(7695);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(7695);
        return str;
    }
}
