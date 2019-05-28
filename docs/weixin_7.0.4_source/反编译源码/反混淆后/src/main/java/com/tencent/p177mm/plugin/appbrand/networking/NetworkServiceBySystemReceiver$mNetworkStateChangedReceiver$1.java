package com.tencent.p177mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.networking.NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 */
public final class NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ C19614d ipH;

    NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(C19614d c19614d) {
        this.ipH = c19614d;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(87580);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(intent, "intent");
        C19614d.m30410a(this.ipH);
        AppMethodBeat.m2505o(87580);
    }
}
