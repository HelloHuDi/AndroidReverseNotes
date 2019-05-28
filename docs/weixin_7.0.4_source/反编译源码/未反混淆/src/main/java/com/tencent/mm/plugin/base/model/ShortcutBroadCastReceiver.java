package com.tencent.mm.plugin.base.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public class ShortcutBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(79060);
        if (intent == null) {
            ab.e("MicroMsg.ShortcutBroadCastReceiver", "alvinluo shortcut receiver intent is null");
            AppMethodBeat.o(79060);
            return;
        }
        h.bQ(context, context.getString(R.string.fv));
        AppMethodBeat.o(79060);
    }
}
