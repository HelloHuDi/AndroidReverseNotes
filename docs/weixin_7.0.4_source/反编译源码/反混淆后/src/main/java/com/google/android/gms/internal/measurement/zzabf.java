package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzabf extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzaay zzbuf;

    private zzabf(zzaay zzaay) {
        this.zzbuf = zzaay;
    }

    /* synthetic */ zzabf(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    public final /* synthetic */ boolean add(Object obj) {
        AppMethodBeat.m2504i(3409);
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            AppMethodBeat.m2505o(3409);
            return false;
        }
        this.zzbuf.zza((Comparable) entry.getKey(), entry.getValue());
        AppMethodBeat.m2505o(3409);
        return true;
    }

    public final void clear() {
        AppMethodBeat.m2504i(3408);
        this.zzbuf.clear();
        AppMethodBeat.m2505o(3408);
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.m2504i(3406);
        Entry entry = (Entry) obj;
        Object obj2 = this.zzbuf.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 == value || (obj2 != null && obj2.equals(value))) {
            AppMethodBeat.m2505o(3406);
            return true;
        }
        AppMethodBeat.m2505o(3406);
        return false;
    }

    public final Iterator<Entry<K, V>> iterator() {
        AppMethodBeat.m2504i(3404);
        zzabe zzabe = new zzabe(this.zzbuf, null);
        AppMethodBeat.m2505o(3404);
        return zzabe;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.m2504i(3407);
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            this.zzbuf.remove(entry.getKey());
            AppMethodBeat.m2505o(3407);
            return true;
        }
        AppMethodBeat.m2505o(3407);
        return false;
    }

    public final int size() {
        AppMethodBeat.m2504i(3405);
        int size = this.zzbuf.size();
        AppMethodBeat.m2505o(3405);
        return size;
    }
}
