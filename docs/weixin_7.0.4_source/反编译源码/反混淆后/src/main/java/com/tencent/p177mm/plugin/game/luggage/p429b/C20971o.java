package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.luggage.p432d.C12140e;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C46419bd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.o */
public class C20971o extends C46419bd<C12140e> {
    public final String name() {
        return "reportGamePageTime";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        boolean z;
        AppMethodBeat.m2504i(135885);
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("reportId");
        boolean z2 = jSONObject.optInt("reportInstantly", 0) == 1;
        if (jSONObject.optInt("reportTimeBegin", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        String optString2 = jSONObject.optString("reportFormatData");
        String optString3 = jSONObject.optString("reportTabsFormatData");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
            c32183a.mo52824a("invalid_reportId", null);
            AppMethodBeat.m2505o(135885);
        } else if (C5046bo.isNullOrNil(optString2) && C5046bo.isNullOrNil(optString3)) {
            C4990ab.m7412e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
            c32183a.mo52824a("invalid_reportFormatData_reportTabsFormatData", null);
            AppMethodBeat.m2505o(135885);
        } else {
            C4990ab.m7417i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", optString, Boolean.valueOf(z2), Boolean.valueOf(z), optString2, optString3);
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", optString);
            bundle.putBoolean("game_page_report_instantly", z2);
            bundle.putBoolean("game_page_report_time_begin", z);
            bundle.putString("game_page_report_format_data", optString2);
            bundle.putString("game_page_report_tabs_format_data", optString3);
            ((C12140e) c32183a.bOZ).mUY.uDp.mo26864ao(bundle);
            c32183a.mo52824a("", null);
            AppMethodBeat.m2505o(135885);
        }
    }
}
