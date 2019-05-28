package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.ey;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum m {
    ;

    static dp m(JSONObject jSONObject) {
        AppMethodBeat.i(101819);
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        dp dpVar = new dp();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            dpVar.vFu = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    cnp cnp = new cnp();
                    cnp.type = optJSONObject2.optInt("type");
                    cnp.version = optJSONObject2.optInt("version");
                    dpVar.vFu.add(cnp);
                }
            }
        }
        AppMethodBeat.o(101819);
        return dpVar;
    }

    public static String a(ey eyVar) {
        AppMethodBeat.i(101820);
        String str;
        if (eyVar == null) {
            str = "AppRunningFlagInfo{null}";
            AppMethodBeat.o(101820);
            return str;
        }
        str = "AppRunningFlagInfo{RunningFlag=" + eyVar.vGQ + ", StopServiceTime" + eyVar.vGR + ", AppForbiddenReason" + eyVar.vGS + ", SessionOpenForbiddenReason" + eyVar.vGT + ", TimelineOpenForbiddenReason" + eyVar.vGU + "}";
        AppMethodBeat.o(101820);
        return str;
    }

    public static void a(AppBrandSysConfigLU appBrandSysConfigLU, String str) {
        AppMethodBeat.i(101821);
        appBrandSysConfigLU.hgY = true;
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
            AppMethodBeat.o(101821);
            return;
        }
        try {
            boolean z;
            if (new JSONObject(str).getJSONObject("bgKeepAlive").getInt("music") == 1) {
                z = true;
            } else {
                z = false;
            }
            appBrandSysConfigLU.hgY = z;
            AppMethodBeat.o(101821);
        } catch (JSONException e) {
            ab.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", str);
            ab.w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", e);
            AppMethodBeat.o(101821);
        }
    }
}
