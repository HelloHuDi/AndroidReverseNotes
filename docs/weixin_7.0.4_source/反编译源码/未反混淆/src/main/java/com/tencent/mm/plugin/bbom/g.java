package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class g implements a {
    private AddrBookObserver jEp;
    private WatchDogPushReceiver jEq;
    private TrafficStatsReceiver jEr;

    public final void a(Service service) {
        AppMethodBeat.i(18256);
        boolean z = VERSION.SDK_INT < 26;
        if (!z) {
            z = b.o(service.getApplicationContext(), "android.permission.READ_CONTACTS");
        }
        if (z) {
            try {
                this.jEp = new AddrBookObserver(service);
                service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.dgN(), true, this.jEp);
            } catch (Exception e) {
                this.jEp = null;
                ab.e("MicroMsg.CoreService", "onCreate registerContentObserver() Exception = %s", e.getMessage());
            }
        }
        this.jEq = new WatchDogPushReceiver();
        service.registerReceiver(this.jEq, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.jEr = new TrafficStatsReceiver();
        service.registerReceiver(this.jEr, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bu(service);
        AppMethodBeat.o(18256);
    }

    public final void b(Service service) {
        AppMethodBeat.i(18257);
        if (this.jEp != null) {
            service.getContentResolver().unregisterContentObserver(this.jEp);
            this.jEp = null;
        }
        service.unregisterReceiver(this.jEq);
        service.unregisterReceiver(this.jEr);
        TrafficStatsReceiver.bv(service);
        AppMethodBeat.o(18257);
    }
}
