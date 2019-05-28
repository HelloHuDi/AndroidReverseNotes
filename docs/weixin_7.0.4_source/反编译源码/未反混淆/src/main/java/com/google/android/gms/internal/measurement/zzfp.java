package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

class zzfp extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzaaw = zzfp.class.getName();
    private boolean zzaax;
    private boolean zzaay;
    private final zzjr zzajp;

    static {
        AppMethodBeat.i(68938);
        AppMethodBeat.o(68938);
    }

    zzfp(zzjr zzjr) {
        AppMethodBeat.i(68934);
        Preconditions.checkNotNull(zzjr);
        this.zzajp = zzjr;
        AppMethodBeat.o(68934);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(68935);
        this.zzajp.zzkq();
        String action = intent.getAction();
        this.zzajp.zzge().zzit().zzg("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzex = this.zzajp.zzkn().zzex();
            if (this.zzaay != zzex) {
                this.zzaay = zzex;
                this.zzajp.zzgd().zzc(new zzfq(this, zzex));
            }
            AppMethodBeat.o(68935);
            return;
        }
        this.zzajp.zzge().zzip().zzg("NetworkBroadcastReceiver received unknown action", action);
        AppMethodBeat.o(68935);
    }

    public final void unregister() {
        AppMethodBeat.i(68937);
        this.zzajp.zzkq();
        this.zzajp.zzab();
        this.zzajp.zzab();
        if (this.zzaax) {
            this.zzajp.zzge().zzit().log("Unregistering connectivity change receiver");
            this.zzaax = false;
            this.zzaay = false;
            try {
                this.zzajp.getContext().unregisterReceiver(this);
                AppMethodBeat.o(68937);
                return;
            } catch (IllegalArgumentException e) {
                this.zzajp.zzge().zzim().zzg("Failed to unregister the network broadcast receiver", e);
                AppMethodBeat.o(68937);
                return;
            }
        }
        AppMethodBeat.o(68937);
    }

    public final void zzeu() {
        AppMethodBeat.i(68936);
        this.zzajp.zzkq();
        this.zzajp.zzab();
        if (this.zzaax) {
            AppMethodBeat.o(68936);
            return;
        }
        this.zzajp.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.zzaay = this.zzajp.zzkn().zzex();
        this.zzajp.zzge().zzit().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzaay));
        this.zzaax = true;
        AppMethodBeat.o(68936);
    }
}
