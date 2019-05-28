package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzm {
    private final ConcurrentHashMap<zzn, List<Throwable>> zzahj = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzahk = new ReferenceQueue();

    zzm() {
        AppMethodBeat.m2504i(90496);
        AppMethodBeat.m2505o(90496);
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        AppMethodBeat.m2504i(90497);
        Object poll = this.zzahk.poll();
        while (poll != null) {
            this.zzahj.remove(poll);
            poll = this.zzahk.poll();
        }
        List list = (List) this.zzahj.get(new zzn(th, null));
        if (list != null) {
            AppMethodBeat.m2505o(90497);
            return list;
        }
        Vector vector = new Vector(2);
        list = (List) this.zzahj.putIfAbsent(new zzn(th, this.zzahk), vector);
        if (list == null) {
            AppMethodBeat.m2505o(90497);
            return vector;
        }
        AppMethodBeat.m2505o(90497);
        return list;
    }
}
