package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class o extends bd<e> {
    public final String name() {
        return "reportGamePageTime";
    }

    public final int biG() {
        return 0;
    }

    public final void a(Context context, String str, a aVar) {
    }

    public final void b(com.tencent.luggage.d.a.a aVar) {
        boolean z;
        AppMethodBeat.i(135885);
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("reportId");
        boolean z2 = jSONObject.optInt("reportInstantly", 0) == 1;
        if (jSONObject.optInt("reportTimeBegin", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        String optString2 = jSONObject.optString("reportFormatData");
        String optString3 = jSONObject.optString("reportTabsFormatData");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
            aVar.a("invalid_reportId", null);
            AppMethodBeat.o(135885);
        } else if (bo.isNullOrNil(optString2) && bo.isNullOrNil(optString3)) {
            ab.e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
            aVar.a("invalid_reportFormatData_reportTabsFormatData", null);
            AppMethodBeat.o(135885);
        } else {
            ab.i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", optString, Boolean.valueOf(z2), Boolean.valueOf(z), optString2, optString3);
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", optString);
            bundle.putBoolean("game_page_report_instantly", z2);
            bundle.putBoolean("game_page_report_time_begin", z);
            bundle.putString("game_page_report_format_data", optString2);
            bundle.putString("game_page_report_tabs_format_data", optString3);
            ((e) aVar.bOZ).mUY.uDp.ao(bundle);
            aVar.a("", null);
            AppMethodBeat.o(135885);
        }
    }
}
