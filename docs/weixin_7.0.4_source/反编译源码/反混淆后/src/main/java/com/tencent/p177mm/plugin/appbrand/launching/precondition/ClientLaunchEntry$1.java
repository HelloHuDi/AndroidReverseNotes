package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.ClientLaunchEntry$1 */
class ClientLaunchEntry$1 extends ResultReceiver {
    final /* synthetic */ C38424b ijM;
    final /* synthetic */ Context val$context;

    ClientLaunchEntry$1(C38424b c38424b, Handler handler, Context context) {
        this.ijM = c38424b;
        this.val$context = context;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        boolean z;
        AppMethodBeat.m2504i(132055);
        boolean pb = C42614i.m75455pb(C42614i.ijV);
        boolean z2 = i == -1;
        if ((this.val$context instanceof AppBrandUI) && ((AppBrandUI) this.val$context).iIX) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.Precondition.ClientLaunchEntry", "[appswitch] onReceiveResult, %s, proxyLaunchBack %b, pendingNewIntents %b, handlingNewIntent %b", this.val$context.getClass().getSimpleName(), Boolean.valueOf(z2), Boolean.valueOf(pb), Boolean.valueOf(z));
        if (!(!z2 || pb || z)) {
            ((MMActivity) this.val$context).moveTaskToBack(true);
        }
        AppMethodBeat.m2505o(132055);
    }
}
