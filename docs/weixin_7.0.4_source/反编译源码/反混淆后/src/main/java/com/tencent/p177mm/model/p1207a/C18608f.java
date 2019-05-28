package com.tencent.p177mm.model.p1207a;

import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.model.a.f */
public final class C18608f {
    /* renamed from: oR */
    private static void m29042oR(String str) {
        AppMethodBeat.m2504i(118145);
        C4990ab.m7417i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast:%s", str);
        if (C26407g.aaK().aaI()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.ui.ACTION_ABTEST");
            intent.putExtra(C8741b.CONTENT, str);
            C4996ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
            AppMethodBeat.m2505o(118145);
            return;
        }
        C4990ab.m7416i("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. no test case.");
        AppMethodBeat.m2505o(118145);
    }

    /* renamed from: a */
    private static void m29041a(C42183e c42183e, boolean z) {
        AppMethodBeat.m2504i(118146);
        if (c42183e == null || !C26407g.aaK().aaI()) {
            C4990ab.m7420w("MicroMsg.abtest.AbTestReportHelper", "[AbTest] reportAbTestClickStreamBroadcast abtest faild. abTestPoint or testcase is null.");
            AppMethodBeat.m2505o(118146);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? stringBuilder.append("TestPointStart:") : stringBuilder.append("TestPointEnd:"));
        stringBuilder.append(C26407g.aaK().fnW.fnS);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.f17167id);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.fnY);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.fnY);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.fnZ);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.result);
        stringBuilder.append("_");
        stringBuilder.append(c42183e.fob);
        C18608f.m29042oR(stringBuilder.toString());
        AppMethodBeat.m2505o(118146);
    }

    /* renamed from: a */
    public static void m29040a(C42183e c42183e) {
        AppMethodBeat.m2504i(118147);
        if (c42183e != null && C26407g.aaK().aaI()) {
            String str = C26407g.aaK().fnW.fnS;
            String str2 = c42183e.f17167id;
            String str3 = c42183e.f17167id;
            String str4 = (c42183e.endTime - c42183e.startTime);
            String str5 = c42183e.result;
            String str6 = c42183e.fnY;
            long j = c42183e.fob;
            C4990ab.m7417i("MicroMsg.abtest.AbTestReportHelper", "TestCaseID:%s TestPointsID:%s TestReportID：%s TetsCheckID:%s TestDurationTime:%s TestActionResult:%s, TestActionScene:%d", str, str2, str6, str3, str4, str5, Long.valueOf(j));
            C7060h.pYm.mo8381e(11394, str, str2, str6, str3, str4, str5, Long.valueOf(j));
        }
        AppMethodBeat.m2505o(118147);
    }

    /* renamed from: oS */
    public static void m29043oS(String str) {
        AppMethodBeat.m2504i(118148);
        C4990ab.m7416i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestCase: start abtest click stream");
        C18608f.m29042oR("TestCaseID:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(118148);
    }

    /* renamed from: oT */
    public static void m29044oT(String str) {
        AppMethodBeat.m2504i(118149);
        if (C26407g.aaK().mo60654oP(str) != null) {
            C4990ab.m7417i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] startAbTestPoint:%s", str);
            C26407g.aaK().mo60654oP(str).fnZ = System.currentTimeMillis();
            C26407g.aaK().mo60654oP(str).startTime = System.currentTimeMillis();
            C26407g.aaK().mo60654oP(str).foa = false;
            C26407g.aaK().mo60654oP(str).result = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            C18608f.m29041a(C26407g.aaK().mo60654oP(str), true);
        }
        AppMethodBeat.m2505o(118149);
    }

    /* renamed from: oU */
    public static void m29045oU(String str) {
        AppMethodBeat.m2504i(118150);
        if (!(C26407g.aaK().mo60654oP(str) == null || C26407g.aaK().mo60654oP(str).foa)) {
            C4990ab.m7417i("MicroMsg.abtest.AbTestReportHelper", "[Abtest] endAbTestPoint:%s", str);
            C26407g.aaK().mo60654oP(str).fnZ = System.currentTimeMillis();
            C26407g.aaK().mo60654oP(str).endTime = System.currentTimeMillis();
            C26407g.aaK().mo60654oP(str).foa = true;
            C18608f.m29040a(C26407g.aaK().mo60654oP(str));
            C18608f.m29041a(C26407g.aaK().mo60654oP(str), false);
        }
        AppMethodBeat.m2505o(118150);
    }
}
