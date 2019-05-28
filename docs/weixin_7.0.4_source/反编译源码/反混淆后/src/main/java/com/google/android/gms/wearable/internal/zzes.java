package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzes<T> extends zzgm<Status> {
    private WeakReference<Map<T, zzhk<T>>> zzec;
    private WeakReference<T> zzed;

    zzes(Map<T, zzhk<T>> map, T t, ResultHolder<Status> resultHolder) {
        super(resultHolder);
        AppMethodBeat.m2504i(71283);
        this.zzec = new WeakReference(map);
        this.zzed = new WeakReference(t);
        AppMethodBeat.m2505o(71283);
    }

    public final void zza(Status status) {
        AppMethodBeat.m2504i(71284);
        Map map = (Map) this.zzec.get();
        Object obj = this.zzed.get();
        if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
            synchronized (map) {
                try {
                    zzhk zzhk = (zzhk) map.remove(obj);
                    if (zzhk != null) {
                        zzhk.clear();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(71284);
                    }
                }
            }
        }
        zza(status);
        AppMethodBeat.m2505o(71284);
    }
}
