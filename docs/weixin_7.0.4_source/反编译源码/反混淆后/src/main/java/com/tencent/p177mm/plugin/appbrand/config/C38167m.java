package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C15330dp;
import com.tencent.p177mm.protocal.protobuf.C46539ey;
import com.tencent.p177mm.protocal.protobuf.cnp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.config.m */
public enum C38167m {
    ;

    /* renamed from: m */
    static C15330dp m64603m(JSONObject jSONObject) {
        AppMethodBeat.m2504i(101819);
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        C15330dp c15330dp = new C15330dp();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            c15330dp.vFu = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    cnp cnp = new cnp();
                    cnp.type = optJSONObject2.optInt("type");
                    cnp.version = optJSONObject2.optInt("version");
                    c15330dp.vFu.add(cnp);
                }
            }
        }
        AppMethodBeat.m2505o(101819);
        return c15330dp;
    }

    /* renamed from: a */
    public static String m64601a(C46539ey c46539ey) {
        AppMethodBeat.m2504i(101820);
        String str;
        if (c46539ey == null) {
            str = "AppRunningFlagInfo{null}";
            AppMethodBeat.m2505o(101820);
            return str;
        }
        str = "AppRunningFlagInfo{RunningFlag=" + c46539ey.vGQ + ", StopServiceTime" + c46539ey.vGR + ", AppForbiddenReason" + c46539ey.vGS + ", SessionOpenForbiddenReason" + c46539ey.vGT + ", TimelineOpenForbiddenReason" + c46539ey.vGU + "}";
        AppMethodBeat.m2505o(101820);
        return str;
    }

    /* renamed from: a */
    public static void m64602a(AppBrandSysConfigLU appBrandSysConfigLU, String str) {
        AppMethodBeat.m2504i(101821);
        appBrandSysConfigLU.hgY = true;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.AppBrandSysConfigUtil", "operationInfo nil");
            AppMethodBeat.m2505o(101821);
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
            AppMethodBeat.m2505o(101821);
        } catch (JSONException e) {
            C4990ab.m7421w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo operationInfo:%s", str);
            C4990ab.m7421w("MicroMsg.AppBrandSysConfigUtil", "assembleBgKeepAliveConfigByOperationInfo exp:%s", e);
            AppMethodBeat.m2505o(101821);
        }
    }
}
