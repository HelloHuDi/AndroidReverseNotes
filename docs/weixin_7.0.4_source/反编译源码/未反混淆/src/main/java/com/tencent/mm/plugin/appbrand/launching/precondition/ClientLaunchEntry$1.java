package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

class ClientLaunchEntry$1 extends ResultReceiver {
    final /* synthetic */ b ijM;
    final /* synthetic */ Context val$context;

    ClientLaunchEntry$1(b bVar, Handler handler, Context context) {
        this.ijM = bVar;
        this.val$context = context;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(132055);
        boolean pb = i.pb(i.ijV);
        boolean z2 = i == -1;
        if ((this.val$context instanceof AppBrandUI) && ((AppBrandUI) this.val$context).iIX) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.AppBrand.Precondition.ClientLaunchEntry", "[appswitch] onReceiveResult, %s, proxyLaunchBack %b, pendingNewIntents %b, handlingNewIntent %b", this.val$context.getClass().getSimpleName(), Boolean.valueOf(z2), Boolean.valueOf(pb), Boolean.valueOf(z));
        if (!(!z2 || pb || z)) {
            ((MMActivity) this.val$context).moveTaskToBack(true);
        }
        AppMethodBeat.o(132055);
    }
}
