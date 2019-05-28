package com.tencent.p177mm.plugin.appbrand.networking;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.networking.d */
public final class C19614d extends C27211e {
    private final NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 ipG = new NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(this);

    public C19614d(C6750i c6750i) {
        C25052j.m39376p(c6750i, "rt");
        super(c6750i);
        AppMethodBeat.m2504i(87583);
        AppMethodBeat.m2505o(87583);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m30410a(C19614d c19614d) {
        AppMethodBeat.m2504i(87584);
        super.aIQ();
        AppMethodBeat.m2505o(87584);
    }

    /* renamed from: SH */
    public final void mo5202SH() {
        AppMethodBeat.m2504i(87581);
        super.mo5202SH();
        Activity context = this.gPI.getContext();
        BroadcastReceiver broadcastReceiver = this.ipG;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(broadcastReceiver, intentFilter);
        AppMethodBeat.m2505o(87581);
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        AppMethodBeat.m2504i(87582);
        super.mo5203SI();
        this.gPI.getContext().unregisterReceiver(this.ipG);
        AppMethodBeat.m2505o(87582);
    }
}
