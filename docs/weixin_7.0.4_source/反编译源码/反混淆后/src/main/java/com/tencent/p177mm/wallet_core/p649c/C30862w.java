package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.wallet_core.c.w */
public final class C30862w {
    private static String AfQ = "";
    private static long kfQ = 0;
    private static String tyv = "";

    public static void setTimeStamp(String str) {
        AppMethodBeat.m2504i(49083);
        tyv = str;
        kfQ = System.currentTimeMillis() / 1000;
        AfQ = C5046bo.dpG().toString();
        AppMethodBeat.m2505o(49083);
    }

    public static boolean dNQ() {
        AppMethodBeat.m2504i(49084);
        long fp = C5046bo.m7549fp(kfQ);
        C4990ab.m7410d("MicroMsg.TimeStampHelper", "pass time ".concat(String.valueOf(fp)));
        if (fp > 300) {
            AppMethodBeat.m2505o(49084);
            return true;
        }
        AppMethodBeat.m2505o(49084);
        return false;
    }

    public static String dNR() {
        AppMethodBeat.m2504i(49085);
        if (C5046bo.isNullOrNil(tyv) || C4872b.dnO()) {
            C4990ab.m7417i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", AfQ, Boolean.valueOf(C30862w.dNQ()), Long.valueOf(kfQ));
        }
        String str = tyv;
        AppMethodBeat.m2505o(49085);
        return str;
    }
}
