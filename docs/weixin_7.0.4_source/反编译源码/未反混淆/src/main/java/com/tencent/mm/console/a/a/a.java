package com.tencent.mm.console.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class a implements com.tencent.mm.pluginsdk.cmd.a {
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16152);
        if (strArr.length <= 1) {
            AppMethodBeat.o(16152);
            return false;
        }
        if (bo.getInt(strArr[1], 0) > 0) {
            com.tencent.mm.plugin.hardcoder.a.nqe = true;
        } else {
            com.tencent.mm.plugin.hardcoder.a.nqe = false;
        }
        AppMethodBeat.o(16152);
        return true;
    }
}
