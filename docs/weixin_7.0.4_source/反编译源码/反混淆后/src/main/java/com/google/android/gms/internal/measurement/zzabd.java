package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class zzabd implements Comparable<zzabd>, Entry<K, V> {
    private V value;
    private final K zzbue;
    private final /* synthetic */ zzaay zzbuf;

    zzabd(zzaay zzaay, K k, V v) {
        this.zzbuf = zzaay;
        this.zzbue = k;
        this.value = v;
    }

    zzabd(zzaay zzaay, Entry<K, V> entry) {
        this(zzaay, (Comparable) entry.getKey(), entry.getValue());
        AppMethodBeat.m2504i(3393);
        AppMethodBeat.m2505o(3393);
    }

    private static boolean equals(Object obj, Object obj2) {
        AppMethodBeat.m2504i(3398);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.m2505o(3398);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.m2505o(3398);
            return true;
        } else {
            AppMethodBeat.m2505o(3398);
            return false;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(3399);
        int compareTo = ((Comparable) getKey()).compareTo((Comparable) ((zzabd) obj).getKey());
        AppMethodBeat.m2505o(3399);
        return compareTo;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3395);
        if (obj == this) {
            AppMethodBeat.m2505o(3395);
            return true;
        } else if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            if (equals(this.zzbue, entry.getKey()) && equals(this.value, entry.getValue())) {
                AppMethodBeat.m2505o(3395);
                return true;
            }
            AppMethodBeat.m2505o(3395);
            return false;
        } else {
            AppMethodBeat.m2505o(3395);
            return false;
        }
    }

    public final /* synthetic */ Object getKey() {
        return this.zzbue;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(3396);
        int hashCode = this.zzbue == null ? 0 : this.zzbue.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        hashCode ^= i;
        AppMethodBeat.m2505o(3396);
        return hashCode;
    }

    public final V setValue(V v) {
        AppMethodBeat.m2504i(3394);
        zzaay.zza(this.zzbuf);
        Object obj = this.value;
        this.value = v;
        AppMethodBeat.m2505o(3394);
        return obj;
    }

    public final String toString() {
        AppMethodBeat.m2504i(3397);
        String valueOf = String.valueOf(this.zzbue);
        String valueOf2 = String.valueOf(this.value);
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        AppMethodBeat.m2505o(3397);
        return valueOf;
    }
}
