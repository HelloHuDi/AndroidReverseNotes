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
        AppMethodBeat.i(3597);
        boolean hasNext = this.zzbsv.hasNext();
        AppMethodBeat.o(3597);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(3599);
        Entry entry = (Entry) this.zzbsv.next();
        if (entry.getValue() instanceof zzzu) {
            zzzw zzzw = new zzzw(entry, null);
            AppMethodBeat.o(3599);
            return zzzw;
        }
        AppMethodBeat.o(3599);
        return entry;
    }

    public final void remove() {
        AppMethodBeat.i(3598);
        this.zzbsv.remove();
        AppMethodBeat.o(3598);
    }
}
