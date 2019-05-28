package com.tencent.mm.plugin.appbrand.networking;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

@l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"})
public final class d extends e {
    private final NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 ipG = new NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(this);

    public d(i iVar) {
        j.p(iVar, "rt");
        super(iVar);
        AppMethodBeat.i(87583);
        AppMethodBeat.o(87583);
    }

    public static final /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(87584);
        super.aIQ();
        AppMethodBeat.o(87584);
    }

    public final void SH() {
        AppMethodBeat.i(87581);
        super.SH();
        Activity context = this.gPI.getContext();
        BroadcastReceiver broadcastReceiver = this.ipG;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.o(87581);
    }

    public final void SI() {
        AppMethodBeat.i(87582);
        super.SI();
        this.gPI.getContext().unregisterReceiver(this.ipG);
        AppMethodBeat.o(87582);
    }
}
