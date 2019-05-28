package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzev extends zzn<SendMessageResult> {
    private final /* synthetic */ String val$action;
    private final /* synthetic */ String zzcb;
    private final /* synthetic */ byte[] zzee;

    zzev(zzeu zzeu, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        this.zzcb = str;
        this.val$action = str2;
        this.zzee = bArr;
        super(googleApiClient);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        AppMethodBeat.m2504i(71293);
        zzey zzey = new zzey(status, -1);
        AppMethodBeat.m2505o(71293);
        return zzey;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71292);
        zzhg zzhg = (zzhg) anyClient;
        ((zzep) zzhg.getService()).zza(new zzhe(this), this.zzcb, this.val$action, this.zzee);
        AppMethodBeat.m2505o(71292);
    }
}
