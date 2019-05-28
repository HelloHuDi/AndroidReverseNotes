package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class zzzw<K> implements Entry<K, Object> {
    private Entry<K, zzzu> zzbsu;

    private zzzw(Entry<K, zzzu> entry) {
        this.zzbsu = entry;
    }

    /* synthetic */ zzzw(Entry entry, zzzv zzzv) {
        this(entry);
    }

    public final K getKey() {
        AppMethodBeat.m2504i(3594);
        Object key = this.zzbsu.getKey();
        AppMethodBeat.m2505o(3594);
        return key;
    }

    public final Object getValue() {
        AppMethodBeat.m2504i(3595);
        if (((zzzu) this.zzbsu.getValue()) == null) {
            AppMethodBeat.m2505o(3595);
            return null;
        }
        zzaal zzto = zzzu.zzto();
        AppMethodBeat.m2505o(3595);
        return zzto;
    }

    public final Object setValue(Object obj) {
        AppMethodBeat.m2504i(3596);
        if (obj instanceof zzaal) {
            zzaal zzc = ((zzzu) this.zzbsu.getValue()).zzc((zzaal) obj);
            AppMethodBeat.m2505o(3596);
            return zzc;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        AppMethodBeat.m2505o(3596);
        throw illegalArgumentException;
    }
}
