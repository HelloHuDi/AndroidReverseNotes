package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.at;

public final class ab {
    public b geg = null;
    public boolean geh = false;

    public static boolean cg(Context context) {
        AppMethodBeat.i(58681);
        if (context == null || at.isWap(context)) {
            AppMethodBeat.o(58681);
            return false;
        }
        AppMethodBeat.o(58681);
        return true;
    }

    public static boolean ch(Context context) {
        AppMethodBeat.i(58682);
        if (context == null || !at.isWifi(context)) {
            AppMethodBeat.o(58682);
            return false;
        }
        AppMethodBeat.o(58682);
        return true;
    }
}
