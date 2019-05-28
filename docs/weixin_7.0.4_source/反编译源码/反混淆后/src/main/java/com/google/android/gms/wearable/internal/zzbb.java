package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbb extends zzn<GetInputStreamResult> {
    private final /* synthetic */ zzay zzcm;

    zzbb(zzay zzay, GoogleApiClient googleApiClient) {
        this.zzcm = zzay;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71064);
        zzbg zzbg = new zzbg(status, null);
        AppMethodBeat.m2505o(71064);
        return zzbg;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71063);
        zzhg zzhg = (zzhg) anyClient;
        String zza = this.zzcm.zzce;
        zzei zzbr = new zzbr();
        ((zzep) zzhg.getService()).zza(new zzgs(this, zzbr), zzbr, zza);
        AppMethodBeat.m2505o(71063);
    }
}
