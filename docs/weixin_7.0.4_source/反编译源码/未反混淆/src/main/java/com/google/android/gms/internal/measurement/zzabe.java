package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzabe implements Iterator<Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzaay zzbuf;
    private boolean zzbug;
    private Iterator<Entry<K, V>> zzbuh;

    private zzabe(zzaay zzaay) {
        this.zzbuf = zzaay;
        this.pos = -1;
    }

    /* synthetic */ zzabe(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    private final Iterator<Entry<K, V>> zzup() {
        AppMethodBeat.i(3402);
        if (this.zzbuh == null) {
            this.zzbuh = this.zzbuf.zzbtz.entrySet().iterator();
        }
        Iterator it = this.zzbuh;
        AppMethodBeat.o(3402);
        return it;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(3400);
        if (this.pos + 1 < this.zzbuf.zzbty.size() || (!this.zzbuf.zzbtz.isEmpty() && zzup().hasNext())) {
            AppMethodBeat.o(3400);
            return true;
        }
        AppMethodBeat.o(3400);
        return false;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(3403);
        this.zzbug = true;
        int i = this.pos + 1;
        this.pos = i;
        Entry entry;
        if (i < this.zzbuf.zzbty.size()) {
            entry = (Entry) this.zzbuf.zzbty.get(this.pos);
            AppMethodBeat.o(3403);
            return entry;
        }
        entry = (Entry) zzup().next();
        AppMethodBeat.o(3403);
        return entry;
    }

    public final void remove() {
        AppMethodBeat.i(3401);
        if (this.zzbug) {
            this.zzbug = false;
            zzaay.zza(this.zzbuf);
            if (this.pos < this.zzbuf.zzbty.size()) {
                zzaay zzaay = this.zzbuf;
                int i = this.pos;
                this.pos = i - 1;
                zzaay.zza(zzaay, i);
                AppMethodBeat.o(3401);
                return;
            }
            zzup().remove();
            AppMethodBeat.o(3401);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("remove() was called before next()");
        AppMethodBeat.o(3401);
        throw illegalStateException;
    }
}
