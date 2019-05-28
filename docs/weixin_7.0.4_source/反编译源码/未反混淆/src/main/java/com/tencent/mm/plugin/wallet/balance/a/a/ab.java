package com.tencent.mm.plugin.wallet.balance.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class ab {
    private static String tgu = "";

    public static void ach(String str) {
        AppMethodBeat.i(45328);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtTraceInfoStore", "trace info: %s", str);
        tgu = str;
        AppMethodBeat.o(45328);
    }

    public static String cMM() {
        return tgu;
    }

    public static void parseUrl(String str) {
        AppMethodBeat.i(45329);
        String queryParameter = Uri.parse(str).getQueryParameter("trace_info");
        if (!bo.isNullOrNil(queryParameter)) {
            ach(queryParameter);
        }
        AppMethodBeat.o(45329);
    }

    public static String aci(String str) {
        AppMethodBeat.i(45330);
        String queryParameter = Uri.parse(str).getQueryParameter("operate_id");
        AppMethodBeat.o(45330);
        return queryParameter;
    }
}
