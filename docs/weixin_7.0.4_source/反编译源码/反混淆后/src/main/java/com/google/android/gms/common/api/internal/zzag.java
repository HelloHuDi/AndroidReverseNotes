package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzag implements zzbc {
    private final zzbd zzhf;
    private boolean zzhg = false;

    public zzag(zzbd zzbd) {
        this.zzhf = zzbd;
    }

    public final void begin() {
    }

    public final void connect() {
        AppMethodBeat.m2504i(60715);
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zza(new zzai(this, this));
        }
        AppMethodBeat.m2505o(60715);
    }

    public final boolean disconnect() {
        AppMethodBeat.m2504i(60714);
        if (this.zzhg) {
            AppMethodBeat.m2505o(60714);
            return false;
        } else if (this.zzhf.zzfq.zzba()) {
            this.zzhg = true;
            for (zzch zzcc : this.zzhf.zzfq.zziq) {
                zzcc.zzcc();
            }
            AppMethodBeat.m2505o(60714);
            return false;
        } else {
            this.zzhf.zzf(null);
            AppMethodBeat.m2505o(60714);
            return true;
        }
    }

    public final <A extends AnyClient, R extends Result, T extends ApiMethodImpl<R, A>> T enqueue(T t) {
        AppMethodBeat.m2504i(60712);
        ApiMethodImpl execute = execute(t);
        AppMethodBeat.m2505o(60712);
        return execute;
    }

    public final <A extends AnyClient, T extends ApiMethodImpl<? extends Result, A>> T execute(T t) {
        AppMethodBeat.m2504i(60713);
        try {
            this.zzhf.zzfq.zzir.zzb(t);
            zzav zzav = this.zzhf.zzfq;
            AnyClient anyClient = (Client) zzav.zzil.get(t.getClientKey());
            Preconditions.checkNotNull(anyClient, "Appropriate Api was not requested.");
            if (anyClient.isConnected() || !this.zzhf.zzjb.containsKey(t.getClientKey())) {
                if (anyClient instanceof SimpleClientAdapter) {
                    anyClient = ((SimpleClientAdapter) anyClient).getClient();
                }
                t.run(anyClient);
                AppMethodBeat.m2505o(60713);
                return t;
            }
            t.setFailedResult(new Status(17));
            AppMethodBeat.m2505o(60713);
            return t;
        } catch (DeadObjectException e) {
            this.zzhf.zza(new zzah(this, this));
        }
    }

    public final void onConnected(Bundle bundle) {
    }

    public final void onConnectionSuspended(int i) {
        AppMethodBeat.m2504i(60716);
        this.zzhf.zzf(null);
        this.zzhf.zzjf.zzb(i, this.zzhg);
        AppMethodBeat.m2505o(60716);
    }

    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    /* Access modifiers changed, original: final */
    public final void zzap() {
        AppMethodBeat.m2504i(60717);
        if (this.zzhg) {
            this.zzhg = false;
            this.zzhf.zzfq.zzir.release();
            disconnect();
        }
        AppMethodBeat.m2505o(60717);
    }
}
