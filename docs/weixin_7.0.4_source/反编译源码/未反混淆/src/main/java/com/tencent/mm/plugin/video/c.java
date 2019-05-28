package com.tencent.mm.plugin.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;

public final class c {
    public static String abR(String str) {
        AppMethodBeat.i(50970);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(50970);
            return str2;
        }
        str2 = new BigInteger(Long.toBinaryString(bo.getLong(str, 0)), 2).toString();
        AppMethodBeat.o(50970);
        return str2;
    }
}
