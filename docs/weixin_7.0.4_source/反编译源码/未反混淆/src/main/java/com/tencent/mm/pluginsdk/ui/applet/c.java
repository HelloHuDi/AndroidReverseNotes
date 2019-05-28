package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g;

public final class c implements g {
    public final o a(Context context, String str, n nVar) {
        AppMethodBeat.i(27636);
        b bVar = new b(context, str, nVar);
        AppMethodBeat.o(27636);
        return bVar;
    }

    public final o a(Context context, String str, int i, n nVar, String str2) {
        AppMethodBeat.i(27637);
        b bVar = new b(context, str, i, nVar, str2);
        AppMethodBeat.o(27637);
        return bVar;
    }

    public final o a(Context context, String str, int i, n nVar, boolean z, String str2) {
        AppMethodBeat.i(27638);
        b bVar = new b(context, str, i, nVar, z, str2);
        AppMethodBeat.o(27638);
        return bVar;
    }
}
