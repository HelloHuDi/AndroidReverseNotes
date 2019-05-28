package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cs;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.r.k;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa extends cs {
    static final a gSs;
    public transient boolean ihY;

    public final a Ag() {
        return gSs;
    }

    public final void a(axr axr) {
        this.field_launchAction = axr.wBI;
        this.field_jsapiInfo = axr.wBJ;
        this.field_hostInfo = axr.wBK;
        this.field_actionsheetInfo = axr.wBM;
        this.field_operationInfo = axr.wBN;
    }

    public final void a(AppBrandSysConfigWC appBrandSysConfigWC) {
        int i;
        boolean z = true;
        AppMethodBeat.i(131921);
        boolean z2 = this.field_actionsheetInfo != null && this.field_actionsheetInfo.vCK;
        appBrandSysConfigWC.hhg = z2;
        if (this.field_actionsheetInfo == null || !this.field_actionsheetInfo.vCL) {
            z2 = false;
        } else {
            z2 = true;
        }
        appBrandSysConfigWC.hhh = z2;
        if (this.field_actionsheetInfo != null) {
            i = this.field_actionsheetInfo.vCM;
        } else {
            i = 0;
        }
        appBrandSysConfigWC.hhi = i;
        appBrandSysConfigWC.bQt = new AppRuntimeApiPermissionBundle(this.field_jsapiInfo);
        if (!(this.field_operationInfo == null || bo.isNullOrNil(this.field_operationInfo.wKM))) {
            appBrandSysConfigWC.bQu = this.field_operationInfo.wKM;
            try {
                JSONObject jSONObject = new JSONObject(appBrandSysConfigWC.bQu).getJSONObject(ShareConstants.WEB_DIALOG_PARAM_PRIVACY);
                if (jSONObject.getInt("banLocationIfEmptyDesc") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                appBrandSysConfigWC.hgZ = z2;
                if (jSONObject.getInt("banGetWifiListIfEmptyDesc") != 1) {
                    z = false;
                }
                appBrandSysConfigWC.hha = z;
            } catch (JSONException e) {
                appBrandSysConfigWC.hgZ = false;
                appBrandSysConfigWC.hha = false;
            }
            m.a(appBrandSysConfigWC, appBrandSysConfigWC.bQu);
        }
        AppMethodBeat.o(131921);
    }

    public final boolean Cj(String str) {
        AppMethodBeat.i(131922);
        if (!(this.field_operationInfo == null || bo.isNullOrNil(this.field_operationInfo.wKM))) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_operationInfo.wKM);
                String str2 = "jumpWeAppFromLongPressCodeBanInfo";
                if (jSONObject.has(str2)) {
                    jSONObject = jSONObject.getJSONObject(str2);
                    if (!jSONObject.has(str)) {
                        AppMethodBeat.o(131922);
                        return false;
                    } else if (jSONObject.optInt(str, 0) == 1) {
                        AppMethodBeat.o(131922);
                        return true;
                    } else {
                        AppMethodBeat.o(131922);
                        return false;
                    }
                }
                AppMethodBeat.o(131922);
                return false;
            } catch (JSONException e) {
                ab.e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", e);
            }
        }
        AppMethodBeat.o(131922);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(131923);
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (this.field_appId.equals(aaVar.field_appId) && this.field_launchAction != null && k.a(this.field_launchAction, aaVar.field_launchAction) && this.field_jsapiInfo != null && k.a(this.field_jsapiInfo, aaVar.field_jsapiInfo) && this.field_hostInfo != null && k.a(this.field_hostInfo, aaVar.field_hostInfo) && this.field_actionsheetInfo != null && k.a(this.field_actionsheetInfo, aaVar.field_actionsheetInfo) && this.field_operationInfo != null && k.a(this.field_operationInfo, aaVar.field_operationInfo)) {
                AppMethodBeat.o(131923);
                return true;
            }
            AppMethodBeat.o(131923);
            return false;
        }
        AppMethodBeat.o(131923);
        return false;
    }

    static {
        AppMethodBeat.i(131924);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.xDd.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "launchAction";
        aVar.xDd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "jsapiInfo";
        aVar.xDd.put("jsapiInfo", "BLOB");
        stringBuilder.append(" jsapiInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "hostInfo";
        aVar.xDd.put("hostInfo", "BLOB");
        stringBuilder.append(" hostInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[5] = "actionsheetInfo";
        aVar.xDd.put("actionsheetInfo", "BLOB");
        stringBuilder.append(" actionsheetInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[6] = "operationInfo";
        aVar.xDd.put("operationInfo", "BLOB");
        stringBuilder.append(" operationInfo BLOB");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        gSs = aVar;
        AppMethodBeat.o(131924);
    }
}
