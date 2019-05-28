package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzyx implements Iterator {
    private final int limit = this.zzbqz.size();
    private int position = 0;
    private final /* synthetic */ zzyw zzbqz;

    zzyx(zzyw zzyw) {
        this.zzbqz = zzyw;
        AppMethodBeat.i(3548);
        AppMethodBeat.o(3548);
    }

    private final byte nextByte() {
        AppMethodBeat.i(3549);
        try {
            zzyw zzyw = this.zzbqz;
            int i = this.position;
            this.position = i + 1;
            byte zzae = zzyw.zzae(i);
            AppMethodBeat.o(3549);
            return zzae;
        } catch (IndexOutOfBoundsException e) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(e.getMessage());
            AppMethodBeat.o(3549);
            throw noSuchElementException;
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(3551);
        Byte valueOf = Byte.valueOf(nextByte());
        AppMethodBeat.o(3551);
        return valueOf;
    }

    public final void remove() {
        AppMethodBeat.i(3550);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(3550);
        throw unsupportedOperationException;
    }
}
