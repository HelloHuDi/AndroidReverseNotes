package com.tencent.mm.model.a;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f {
    private static void oR(String str) {
        AppMethodBeat.i(118145);
        ab.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", str);
        if (g.aaK().aaI()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra(b.CONTENT, str);
            ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            AppMethodBeat.o(118145);
            return;
        }
        ab.i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
        AppMethodBeat.o(118145);
    }

    private static void a(e eVar, boolean z) {
        AppMethodBeat.i(118146);
        if (eVar == null || !g.aaK().aaI()) {
            ab.w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            AppMethodBeat.o(118146);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(g.aaK().fnW.fnS);
        stringBuilder.append("_");
        stringBuilder.append(eVar.id);
        stringBuilder.append("_");
        stringBuilder.append(eVar.fnY);
        stringBuilder.append("_");
        stringBuilder.append(eVar.fnY);
        stringBuilder.append("_");
        stringBuilder.append(eVar.fnZ);
        stringBuilder.append("_");
        stringBuilder.append(eVar.result);
        stringBuilder.append("_");
        stringBuilder.append(eVar.fob);
        oR(stringBuilder.toString());
        AppMethodBeat.o(118146);
    }

    public static void a(e eVar) {
        AppMethodBeat.i(118147);
        if (eVar != null && g.aaK().aaI()) {
            String str = g.aaK().fnW.fnS;
            String str2 = eVar.id;
            String str3 = eVar.id;
            String str4 = (eVar.endTime - eVar.startTime);
            String str5 = eVar.result;
            String str6 = eVar.fnY;
            long j = eVar.fob;
            ab.i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", str, str2, str6, str3, str4, str5, Long.valueOf(j));
            h.pYm.e(11394, str, str2, str6, str3, str4, str5, Long.valueOf(j));
        }
        AppMethodBeat.o(118147);
    }

    public static void oS(String str) {
        AppMethodBeat.i(118148);
        ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        oR("TestCaseID:".concat(String.valueOf(str)));
        AppMethodBeat.o(118148);
    }

    public static void oT(String str) {
        AppMethodBeat.i(118149);
        if (g.aaK().oP(str) != null) {
            ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", str);
            g.aaK().oP(str).fnZ = System.currentTimeMillis();
            g.aaK().oP(str).startTime = System.currentTimeMillis();
            g.aaK().oP(str).foa = false;
            g.aaK().oP(str).result = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            a(g.aaK().oP(str), true);
        }
        AppMethodBeat.o(118149);
    }

    public static void oU(String str) {
        AppMethodBeat.i(118150);
        if (!(g.aaK().oP(str) == null || g.aaK().oP(str).foa)) {
            ab.i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", str);
            g.aaK().oP(str).fnZ = System.currentTimeMillis();
            g.aaK().oP(str).endTime = System.currentTimeMillis();
            g.aaK().oP(str).foa = true;
            a(g.aaK().oP(str));
            a(g.aaK().oP(str), false);
        }
        AppMethodBeat.o(118150);
    }
}
