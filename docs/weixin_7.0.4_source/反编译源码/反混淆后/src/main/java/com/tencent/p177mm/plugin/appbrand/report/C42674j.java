package com.tencent.p177mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C16674d.C16675a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/report/ReportUtilKt;", "", "()V", "getNetworkTypeForReport", "", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.report.j */
public final class C42674j {
    public static final C42674j iAv = new C42674j();

    static {
        AppMethodBeat.m2504i(134943);
        AppMethodBeat.m2505o(134943);
    }

    private C42674j() {
    }

    /* renamed from: cW */
    public static final String m75576cW(Context context) {
        AppMethodBeat.m2504i(134942);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C16675a cK = C16674d.m25680cK(context);
        String str;
        switch (C19694k.eQZ[cK.ordinal()]) {
            case 1:
                str = "offline";
                AppMethodBeat.m2505o(134942);
                return str;
            default:
                str = cK.value;
                C25052j.m39375o(str, "type.value");
                AppMethodBeat.m2505o(134942);
                return str;
        }
    }
}
