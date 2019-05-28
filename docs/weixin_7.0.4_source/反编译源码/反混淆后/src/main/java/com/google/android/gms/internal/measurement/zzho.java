package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzho implements Callable<String> {
    private final /* synthetic */ zzhk zzanw;

    zzho(zzhk zzhk) {
        this.zzanw = zzhk;
    }

    public final /* synthetic */ Object call() {
        AppMethodBeat.m2504i(69220);
        Object zzja = this.zzanw.zzgf().zzja();
        if (zzja != null) {
            AppMethodBeat.m2505o(69220);
        } else {
            zzhk zzfu = this.zzanw.zzfu();
            if (zzfu.zzgd().zzjk()) {
                zzfu.zzge().zzim().log("Cannot retrieve app instance id from analytics worker thread");
                zzja = null;
            } else {
                zzfu.zzgd();
                if (zzgg.isMainThread()) {
                    zzfu.zzge().zzim().log("Cannot retrieve app instance id from main thread");
                    zzja = null;
                } else {
                    long elapsedRealtime = zzfu.zzbt().elapsedRealtime();
                    zzja = zzfu.zzae(120000);
                    elapsedRealtime = zzfu.zzbt().elapsedRealtime() - elapsedRealtime;
                    if (zzja == null && elapsedRealtime < 120000) {
                        zzja = zzfu.zzae(120000 - elapsedRealtime);
                    }
                }
            }
            if (zzja == null) {
                TimeoutException timeoutException = new TimeoutException();
                AppMethodBeat.m2505o(69220);
                throw timeoutException;
            }
            this.zzanw.zzgf().zzbr(zzja);
            AppMethodBeat.m2505o(69220);
        }
        return zzja;
    }
}
