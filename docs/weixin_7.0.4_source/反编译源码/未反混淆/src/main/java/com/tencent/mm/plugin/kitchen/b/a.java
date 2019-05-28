package com.tencent.mm.plugin.kitchen.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kitchen.ui.KvInfoUI;

public final class a implements com.tencent.mm.plugin.kitchen.a.a {
    public final void w(Context context, Intent intent) {
        AppMethodBeat.i(114439);
        intent.setClass(context, KvInfoUI.class);
        context.startActivity(intent);
        AppMethodBeat.o(114439);
    }
}
