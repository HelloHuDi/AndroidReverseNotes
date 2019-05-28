package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

final class zzju implements Callable<String> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjr zzaqu;

    zzju(zzjr zzjr, zzdz zzdz) {
        this.zzaqu = zzjr;
        this.zzane = zzdz;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.i(69488);
        zzdy zza = this.zzaqu.zzgg().zzaz(this.zzane.packageName) ? zzjr.zza(this.zzaqu, this.zzane) : this.zzaqu.zzix().zzbc(this.zzane.packageName);
        if (zza == null) {
            this.zzaqu.zzge().zzip().log("App info was null when attempting to get app instance id");
            AppMethodBeat.o(69488);
            return null;
        }
        String appInstanceId = zza.getAppInstanceId();
        AppMethodBeat.o(69488);
        return appInstanceId;
    }
}
