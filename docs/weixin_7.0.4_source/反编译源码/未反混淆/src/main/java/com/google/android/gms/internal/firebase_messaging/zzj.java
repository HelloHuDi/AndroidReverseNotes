package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzj {
    private final ConcurrentHashMap<zzk, List<Throwable>> zzh = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzi = new ReferenceQueue();

    zzj() {
        AppMethodBeat.i(108681);
        AppMethodBeat.o(108681);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.i(108682);
        Object poll = this.zzi.poll();
        while (poll != null) {
            this.zzh.remove(poll);
            poll = this.zzi.poll();
        }
        List list = (List) this.zzh.get(new zzk(th, null));
        if (list != null) {
            AppMethodBeat.o(108682);
            return list;
        }
        Vector vector = new Vector(2);
        list = (List) this.zzh.putIfAbsent(new zzk(th, this.zzi), vector);
        if (list == null) {
            AppMethodBeat.o(108682);
            return vector;
        }
        AppMethodBeat.o(108682);
        return list;
    }
}
