package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzxf {
    private final ConcurrentHashMap<zzxg, List<Throwable>> zzboa = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzbob = new ReferenceQueue();

    zzxf() {
        AppMethodBeat.i(3539);
        AppMethodBeat.o(3539);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.i(3540);
        Object poll = this.zzbob.poll();
        while (poll != null) {
            this.zzboa.remove(poll);
            poll = this.zzbob.poll();
        }
        List list = (List) this.zzboa.get(new zzxg(th, null));
        AppMethodBeat.o(3540);
        return list;
    }
}
