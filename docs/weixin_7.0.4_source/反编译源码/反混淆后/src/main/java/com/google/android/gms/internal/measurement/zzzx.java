package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzzx<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzbsv;

    public zzzx(Iterator<Entry<K, Object>> it) {
        this.zzbsv = it;
    }

    public final boolean hasNext() {
        AppMethodBeat.m2504i(3597);
        boolean hasNext = this.zzbsv.hasNext();
        AppMethodBeat.m2505o(3597);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.m2504i(3599);
        Entry entry = (Entry) this.zzbsv.next();
        if (entry.getValue() instanceof zzzu) {
            zzzw zzzw = new zzzw(entry, null);
            AppMethodBeat.m2505o(3599);
            return zzzw;
        }
        AppMethodBeat.m2505o(3599);
        return entry;
    }

    public final void remove() {
        AppMethodBeat.m2504i(3598);
        this.zzbsv.remove();
        AppMethodBeat.m2505o(3598);
    }
}
