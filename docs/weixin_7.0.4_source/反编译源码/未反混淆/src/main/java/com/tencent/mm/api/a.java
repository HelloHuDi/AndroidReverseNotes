package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static String cC(String str) {
        AppMethodBeat.i(105476);
        if (bo.isNullOrNil(str)) {
            str = "tempConv";
        }
        StringBuilder stringBuilder = new StringBuilder(c.XX());
        stringBuilder.append(g.x(str.getBytes())).append("/");
        stringBuilder.append("conv/");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(105476);
        return stringBuilder2;
    }
}
