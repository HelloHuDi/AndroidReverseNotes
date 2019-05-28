package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzh {
    private final ConcurrentHashMap<zzi, List<Throwable>> zzdf = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzdg = new ReferenceQueue();

    zzh() {
        AppMethodBeat.m2504i(57626);
        AppMethodBeat.m2505o(57626);
    }

    public final List<Throwable> zzd(Throwable th, boolean z) {
        AppMethodBeat.m2504i(57627);
        Object poll = this.zzdg.poll();
        while (poll != null) {
            this.zzdf.remove(poll);
            poll = this.zzdg.poll();
        }
        List list = (List) this.zzdf.get(new zzi(th, null));
        if (list != null) {
            AppMethodBeat.m2505o(57627);
            return list;
        }
        Vector vector = new Vector(2);
        list = (List) this.zzdf.putIfAbsent(new zzi(th, this.zzdg), vector);
        if (list == null) {
            AppMethodBeat.m2505o(57627);
            return vector;
        }
        AppMethodBeat.m2505o(57627);
        return list;
    }
}
