package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzet<T> extends zzgm<Status> {
    private WeakReference<Map<T, zzhk<T>>> zzec;
    private WeakReference<T> zzed;

    zzet(Map<T, zzhk<T>> map, T t, ResultHolder<Status> resultHolder) {
        super(resultHolder);
        AppMethodBeat.i(71285);
        this.zzec = new WeakReference(map);
        this.zzed = new WeakReference(t);
        AppMethodBeat.o(71285);
    }

    public final void zza(Status status) {
        AppMethodBeat.i(71286);
        Map map = (Map) this.zzec.get();
        Object obj = this.zzed.get();
        if (!(status.getStatus().getStatusCode() != WearableStatusCodes.UNKNOWN_LISTENER || map == null || obj == null)) {
            synchronized (map) {
                try {
                    zzhk zzhk = (zzhk) map.remove(obj);
                    if (zzhk != null) {
                        zzhk.clear();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71286);
                    }
                }
            }
        }
        zza(status);
        AppMethodBeat.o(71286);
    }
}
