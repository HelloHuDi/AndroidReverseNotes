package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.ab */
public final class C14103ab {
    private static String tgu = "";

    public static void ach(String str) {
        AppMethodBeat.m2504i(45328);
        C4990ab.m7417i("MicroMsg.LqtTraceInfoStore", "trace info: %s", str);
        tgu = str;
        AppMethodBeat.m2505o(45328);
    }

    public static String cMM() {
        return tgu;
    }

    public static void parseUrl(String str) {
        AppMethodBeat.m2504i(45329);
        String queryParameter = Uri.parse(str).getQueryParameter("trace_info");
        if (!C5046bo.isNullOrNil(queryParameter)) {
            C14103ab.ach(queryParameter);
        }
        AppMethodBeat.m2505o(45329);
    }

    public static String aci(String str) {
        AppMethodBeat.m2504i(45330);
        String queryParameter = Uri.parse(str).getQueryParameter("operate_id");
        AppMethodBeat.m2505o(45330);
        return queryParameter;
    }
}
