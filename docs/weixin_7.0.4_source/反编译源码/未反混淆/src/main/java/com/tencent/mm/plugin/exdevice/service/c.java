package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a lwE;
    public volatile boolean lwF;
    private List<Runnable> lwG = new LinkedList();

    public static abstract class a {
        public int cxI;

        public abstract void onServiceConnected();

        public a(int i) {
            this.cxI = i;
        }
    }

    public c() {
        AppMethodBeat.i(19571);
        AppMethodBeat.o(19571);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ArrayList arrayList;
        AppMethodBeat.i(19572);
        ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(com.tencent.mm.plugin.exdevice.service.h.a.u(iBinder));
        u.a(xVar);
        ah.doH();
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.bop());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.boA());
        if (!xVar.a(ad.bpi())) {
            ab.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.lwE != null) {
            this.lwE.onServiceConnected();
        }
        this.lwF = true;
        synchronized (this.lwG) {
            try {
                arrayList = new ArrayList(this.lwG);
                this.lwG.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(19572);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            Runnable runnable = (Runnable) arrayList.get(i2);
            if (runnable != null) {
                runnable.run();
            }
            i = i2 + 1;
        }
        arrayList.clear();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(19573);
        ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.lwF = false;
        u.a(null);
        ah.doH();
        if (!aw.ZM() || aw.QT()) {
            ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
            AppMethodBeat.o(19573);
            return;
        }
        dH(ah.getContext());
        AppMethodBeat.o(19573);
    }

    public final void dH(Context context) {
        AppMethodBeat.i(19574);
        if (!d.dI(context)) {
            ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
            AppMethodBeat.o(19574);
        } else if (d.a(new Intent(context, ExDeviceService.class), (ServiceConnection) this, "exdevice")) {
            ab.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
            AppMethodBeat.o(19574);
        } else {
            ab.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
            AppMethodBeat.o(19574);
        }
    }

    public final boolean U(Runnable runnable) {
        AppMethodBeat.i(19575);
        if (runnable == null) {
            AppMethodBeat.o(19575);
            return false;
        }
        if (this.lwF) {
            runnable.run();
        } else {
            synchronized (this.lwG) {
                try {
                    this.lwG.add(runnable);
                } catch (Throwable th) {
                    AppMethodBeat.o(19575);
                }
            }
        }
        AppMethodBeat.o(19575);
        return true;
    }
}
