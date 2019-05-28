package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class c implements v {
    public final void a(int i, Activity activity, b bVar) {
        AppMethodBeat.i(27235);
        com.tencent.mm.plugin.fav.ui.c.a(i, activity, bVar);
        AppMethodBeat.o(27235);
    }
}
