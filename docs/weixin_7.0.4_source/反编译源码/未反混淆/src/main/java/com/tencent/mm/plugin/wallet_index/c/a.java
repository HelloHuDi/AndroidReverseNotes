package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static boolean gO(String str, String str2) {
        AppMethodBeat.i(48174);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(48174);
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
        if (bo.isNullOrNil(str3)) {
            AppMethodBeat.o(48174);
            return false;
        }
        boolean z;
        if (str3.startsWith(str2)) {
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.o(48174);
        return z;
    }
}
