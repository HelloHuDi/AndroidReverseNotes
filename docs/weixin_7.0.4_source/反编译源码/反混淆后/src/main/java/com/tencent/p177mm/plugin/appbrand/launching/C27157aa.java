package com.tencent.p177mm.plugin.appbrand.launching;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9526cs;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C38167m;
import com.tencent.p177mm.plugin.appbrand.p328r.C19682k;
import com.tencent.p177mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.p177mm.protocal.protobuf.axr;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.aa */
public final class C27157aa extends C9526cs {
    static final C4924a gSs;
    public transient boolean ihY;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return gSs;
    }

    /* renamed from: a */
    public final void mo44830a(axr axr) {
        this.field_launchAction = axr.wBI;
        this.field_jsapiInfo = axr.wBJ;
        this.field_hostInfo = axr.wBK;
        this.field_actionsheetInfo = axr.wBM;
        this.field_operationInfo = axr.wBN;
    }

    /* renamed from: a */
    public final void mo44829a(AppBrandSysConfigWC appBrandSysConfigWC) {
        int i;
        boolean z = true;
        AppMethodBeat.m2504i(131921);
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
        if (!(this.field_operationInfo == null || C5046bo.isNullOrNil(this.field_operationInfo.wKM))) {
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
            C38167m.m64602a(appBrandSysConfigWC, appBrandSysConfigWC.bQu);
        }
        AppMethodBeat.m2505o(131921);
    }

    /* renamed from: Cj */
    public final boolean mo44828Cj(String str) {
        AppMethodBeat.m2504i(131922);
        if (!(this.field_operationInfo == null || C5046bo.isNullOrNil(this.field_operationInfo.wKM))) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_operationInfo.wKM);
                String str2 = "jumpWeAppFromLongPressCodeBanInfo";
                if (jSONObject.has(str2)) {
                    jSONObject = jSONObject.getJSONObject(str2);
                    if (!jSONObject.has(str)) {
                        AppMethodBeat.m2505o(131922);
                        return false;
                    } else if (jSONObject.optInt(str, 0) == 1) {
                        AppMethodBeat.m2505o(131922);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(131922);
                        return false;
                    }
                }
                AppMethodBeat.m2505o(131922);
                return false;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.AppBrand.LaunchWxaAppInfo", "[banjump] shouldBanJumpInternal fail", e);
            }
        }
        AppMethodBeat.m2505o(131922);
        return false;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(131923);
        if (obj instanceof C27157aa) {
            C27157aa c27157aa = (C27157aa) obj;
            if (this.field_appId.equals(c27157aa.field_appId) && this.field_launchAction != null && C19682k.m30480a(this.field_launchAction, c27157aa.field_launchAction) && this.field_jsapiInfo != null && C19682k.m30480a(this.field_jsapiInfo, c27157aa.field_jsapiInfo) && this.field_hostInfo != null && C19682k.m30480a(this.field_hostInfo, c27157aa.field_hostInfo) && this.field_actionsheetInfo != null && C19682k.m30480a(this.field_actionsheetInfo, c27157aa.field_actionsheetInfo) && this.field_operationInfo != null && C19682k.m30480a(this.field_operationInfo, c27157aa.field_operationInfo)) {
                AppMethodBeat.m2505o(131923);
                return true;
            }
            AppMethodBeat.m2505o(131923);
            return false;
        }
        AppMethodBeat.m2505o(131923);
        return false;
    }

    static {
        AppMethodBeat.m2504i(131924);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "appIdHash";
        c4924a.xDd.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "appIdHash";
        c4924a.columns[1] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "launchAction";
        c4924a.xDd.put("launchAction", "BLOB");
        stringBuilder.append(" launchAction BLOB");
        stringBuilder.append(", ");
        c4924a.columns[3] = "jsapiInfo";
        c4924a.xDd.put("jsapiInfo", "BLOB");
        stringBuilder.append(" jsapiInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[4] = "hostInfo";
        c4924a.xDd.put("hostInfo", "BLOB");
        stringBuilder.append(" hostInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[5] = "actionsheetInfo";
        c4924a.xDd.put("actionsheetInfo", "BLOB");
        stringBuilder.append(" actionsheetInfo BLOB");
        stringBuilder.append(", ");
        c4924a.columns[6] = "operationInfo";
        c4924a.xDd.put("operationInfo", "BLOB");
        stringBuilder.append(" operationInfo BLOB");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        gSs = c4924a;
        AppMethodBeat.m2505o(131924);
    }
}
