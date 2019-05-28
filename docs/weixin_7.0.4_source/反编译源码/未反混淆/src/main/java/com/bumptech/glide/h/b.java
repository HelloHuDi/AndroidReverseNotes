package com.bumptech.glide.h;

import android.support.v4.f.a;
import android.support.v4.f.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V> extends a<K, V> {
    private int aBR;

    public final void clear() {
        AppMethodBeat.i(92553);
        this.aBR = 0;
        super.clear();
        AppMethodBeat.o(92553);
    }

    public final V setValueAt(int i, V v) {
        AppMethodBeat.i(92554);
        this.aBR = 0;
        Object valueAt = super.setValueAt(i, v);
        AppMethodBeat.o(92554);
        return valueAt;
    }

    public final V put(K k, V v) {
        AppMethodBeat.i(92555);
        this.aBR = 0;
        Object put = super.put(k, v);
        AppMethodBeat.o(92555);
        return put;
    }

    public final void a(m<? extends K, ? extends V> mVar) {
        AppMethodBeat.i(92556);
        this.aBR = 0;
        super.a(mVar);
        AppMethodBeat.o(92556);
    }

    public final V removeAt(int i) {
        AppMethodBeat.i(92557);
        this.aBR = 0;
        Object removeAt = super.removeAt(i);
        AppMethodBeat.o(92557);
        return removeAt;
    }

    public final int hashCode() {
        AppMethodBeat.i(92558);
        if (this.aBR == 0) {
            this.aBR = super.hashCode();
        }
        int i = this.aBR;
        AppMethodBeat.o(92558);
        return i;
    }
}
