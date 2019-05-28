package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzck {
    public static final Status zzmm = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzmn = new BasePendingResult[0];
    private final Map<AnyClientKey<?>, Client> zzil;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zzmo = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzcn zzmp = new zzcl(this);

    static {
        AppMethodBeat.m2504i(60895);
        AppMethodBeat.m2505o(60895);
    }

    public zzck(Map<AnyClientKey<?>, Client> map) {
        AppMethodBeat.m2504i(60891);
        this.zzil = map;
        AppMethodBeat.m2505o(60891);
    }

    public final void release() {
        zzcn zzcn = null;
        AppMethodBeat.m2504i(60893);
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            basePendingResult.zza(zzcn);
            if (basePendingResult.zzo() != null) {
                basePendingResult.setResultCallback(zzcn);
                IBinder serviceBrokerBinder = ((Client) this.zzil.get(((ApiMethodImpl) basePendingResult).getClientKey())).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zza(new zzcm(basePendingResult, zzcn, serviceBrokerBinder, zzcn));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zza(zzcn);
                    basePendingResult.cancel();
                    zzcn.remove(basePendingResult.zzo().intValue());
                } else {
                    zzcn zzcm = new zzcm(basePendingResult, zzcn, serviceBrokerBinder, zzcn);
                    basePendingResult.zza(zzcm);
                    try {
                        serviceBrokerBinder.linkToDeath(zzcm, 0);
                    } catch (RemoteException e) {
                        basePendingResult.cancel();
                        zzcn.remove(basePendingResult.zzo().intValue());
                    }
                }
                this.zzmo.remove(basePendingResult);
            } else if (basePendingResult.zzw()) {
                this.zzmo.remove(basePendingResult);
            }
        }
        AppMethodBeat.m2505o(60893);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        AppMethodBeat.m2504i(60892);
        this.zzmo.add(basePendingResult);
        basePendingResult.zza(this.zzmp);
        AppMethodBeat.m2505o(60892);
    }

    public final void zzce() {
        AppMethodBeat.m2504i(60894);
        for (BasePendingResult zzb : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            zzb.zzb(zzmm);
        }
        AppMethodBeat.m2505o(60894);
    }
}
