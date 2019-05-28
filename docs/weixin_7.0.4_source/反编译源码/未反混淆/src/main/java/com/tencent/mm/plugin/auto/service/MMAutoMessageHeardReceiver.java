package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17109);
        String n = w.n(intent, "key_username");
        if (n == null) {
            AppMethodBeat.o(17109);
            return;
        }
        ab.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", n);
        aw.ZK();
        c.XR().apb(n);
        AppMethodBeat.o(17109);
    }
}
