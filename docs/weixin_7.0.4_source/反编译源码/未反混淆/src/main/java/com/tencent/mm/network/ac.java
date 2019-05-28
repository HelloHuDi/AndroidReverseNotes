package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class ac extends a {
    private ap frk = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(58683);
            ab.i("MicroMsg.NetworkEvent", "listeners ct : %d", Integer.valueOf(ac.this.gel.beginBroadcast()));
            for (int i = r0 - 1; i >= 0; i--) {
                try {
                    ((n) ac.this.gel.getBroadcastItem(i)).gl(ac.this.gei);
                } catch (RemoteException e) {
                    ab.e("MicroMsg.NetworkEvent", "exception:%s", bo.l(e));
                }
            }
            ac.this.gel.finishBroadcast();
            AppMethodBeat.o(58683);
            return false;
        }
    }, false);
    private int gei = 4;
    private long gej;
    private int gek = 0;
    private final RemoteCallbackList<n> gel = new RemoteCallbackList();

    public ac() {
        AppMethodBeat.i(58684);
        AppMethodBeat.o(58684);
    }

    public final int amP() {
        AppMethodBeat.i(58685);
        ab.i("MicroMsg.NetworkEvent", "getNowStatus = %d", Integer.valueOf(0 > bo.fp(this.gej) ? 5 : this.gei));
        AppMethodBeat.o(58685);
        return 0 > bo.fp(this.gej) ? 5 : this.gei;
    }

    private boolean mE(int i) {
        if (i == this.gei) {
            return false;
        }
        if (3 != i) {
            if (2 == i) {
                if (this.gei == 0 || this.gei == 1) {
                    return false;
                }
                this.gek++;
                if (this.gek > 0) {
                    this.gei = 2;
                    return true;
                }
            } else if (4 == i) {
                this.gek = 0;
                this.gei = 4;
                return true;
            } else if (VERSION.SDK_INT >= 26 && i == -1) {
                this.gei = 0;
                return true;
            }
            this.gei = i;
            return true;
        } else if (this.gei != 2) {
            return false;
        } else {
            this.gei = i;
            return true;
        }
    }

    public final boolean c(n nVar) {
        AppMethodBeat.i(58686);
        try {
            this.gel.register(nVar);
        } catch (Exception e) {
            ab.e("MicroMsg.NetworkEvent", "addListener %s", e);
            ab.e("MicroMsg.NetworkEvent", "exception:%s", bo.l(e));
        }
        AppMethodBeat.o(58686);
        return true;
    }

    public final boolean d(n nVar) {
        boolean z = false;
        AppMethodBeat.i(58687);
        try {
            z = this.gel.unregister(nVar);
        } catch (Exception e) {
            ab.e("MicroMsg.NetworkEvent", "removeListener %s", e);
            ab.e("MicroMsg.NetworkEvent", "exception:%s", bo.l(e));
        }
        AppMethodBeat.o(58687);
        return z;
    }

    public final void amQ() {
        AppMethodBeat.i(58688);
        this.gel.kill();
        AppMethodBeat.o(58688);
    }

    public final void mF(int i) {
        AppMethodBeat.i(58689);
        ab.i("MicroMsg.NetworkEvent", "networkChange : %d", Integer.valueOf(i));
        if (!mE(i)) {
            AppMethodBeat.o(58689);
        } else if (this.gei == 0 || this.gei == 4 || this.gei == 6) {
            this.frk.ae(1000, 1000);
            AppMethodBeat.o(58689);
        } else {
            AppMethodBeat.o(58689);
        }
    }

    public final long amR() {
        return this.gej;
    }
}
