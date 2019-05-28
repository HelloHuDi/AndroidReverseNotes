package com.google.android.gms.auth.api.accounttransfer;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk extends zzd<DeviceMetaData> {
    private final /* synthetic */ zzj zzbd;

    zzk(zzj zzj, zze zze) {
        this.zzbd = zzj;
        super(zze);
    }

    public final void zzd(DeviceMetaData deviceMetaData) {
        AppMethodBeat.m2504i(76998);
        this.zzbd.setResult(deviceMetaData);
        AppMethodBeat.m2505o(76998);
    }
}
