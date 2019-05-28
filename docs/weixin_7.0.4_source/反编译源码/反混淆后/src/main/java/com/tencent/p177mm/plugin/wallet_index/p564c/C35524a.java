package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.a */
public final class C35524a {
    /* renamed from: gO */
    public static boolean m58302gO(String str, String str2) {
        AppMethodBeat.m2504i(48174);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(48174);
            return false;
        }
        String str3 = null;
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            if (split2.length > 1 && split2[0].equals("prepay_id")) {
                str3 = split2[1];
                break;
            }
        }
        if (C5046bo.isNullOrNil(str3)) {
            AppMethodBeat.m2505o(48174);
            return false;
        }
        boolean z;
        if (str3.startsWith(str2)) {
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(48174);
        return z;
    }
}
