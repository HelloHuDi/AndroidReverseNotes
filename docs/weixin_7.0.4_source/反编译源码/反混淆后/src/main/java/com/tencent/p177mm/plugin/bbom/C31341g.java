package com.tencent.p177mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.TrafficStatsReceiver;
import com.tencent.p177mm.modelfriend.AddrBookObserver;
import com.tencent.p177mm.modelstat.WatchDogPushReceiver;
import com.tencent.p177mm.plugin.zero.p591a.C30032a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.bbom.g */
public final class C31341g implements C30032a {
    private AddrBookObserver jEp;
    private WatchDogPushReceiver jEq;
    private TrafficStatsReceiver jEr;

    /* renamed from: a */
    public final void mo48264a(Service service) {
        AppMethodBeat.m2504i(18256);
        boolean z = VERSION.SDK_INT < 26;
        if (!z) {
            z = C35805b.m58714o(service.getApplicationContext(), "android.permission.READ_CONTACTS");
        }
        if (z) {
            try {
                this.jEp = new AddrBookObserver(service);
                service.getContentResolver().registerContentObserver(C46482a.dgN(), true, this.jEp);
            } catch (Exception e) {
                this.jEp = null;
                C4990ab.m7413e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", e.getMessage());
            }
        }
        this.jEq = new WatchDogPushReceiver();
        service.registerReceiver(this.jEq, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.jEr = new TrafficStatsReceiver();
        service.registerReceiver(this.jEr, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.m16683bu(service);
        AppMethodBeat.m2505o(18256);
    }

    /* renamed from: b */
    public final void mo48265b(Service service) {
        AppMethodBeat.m2504i(18257);
        if (this.jEp != null) {
            service.getContentResolver().unregisterContentObserver(this.jEp);
            this.jEp = null;
        }
        service.unregisterReceiver(this.jEq);
        service.unregisterReceiver(this.jEr);
        TrafficStatsReceiver.m16684bv(service);
        AppMethodBeat.m2505o(18257);
    }
}
