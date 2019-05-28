package com.tencent.mm.plugin.wenote.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.c;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static boolean dfJ() {
        int i;
        AppMethodBeat.i(26976);
        String str = (String) c.abi().ll("100352").dru().get("Close");
        if (bo.isNullOrNil(str)) {
            i = 0;
        } else {
            i = bo.getInt(str, 0);
        }
        if (i == 0) {
            AppMethodBeat.o(26976);
            return true;
        }
        AppMethodBeat.o(26976);
        return false;
    }
}
