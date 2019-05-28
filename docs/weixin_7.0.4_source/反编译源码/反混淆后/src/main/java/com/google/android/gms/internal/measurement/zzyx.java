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
        AppMethodBeat.m2504i(3548);
        AppMethodBeat.m2505o(3548);
    }

    private final byte nextByte() {
        AppMethodBeat.m2504i(3549);
        try {
            zzyw zzyw = this.zzbqz;
            int i = this.position;
            this.position = i + 1;
            byte zzae = zzyw.zzae(i);
            AppMethodBeat.m2505o(3549);
            return zzae;
        } catch (IndexOutOfBoundsException e) {
            NoSuchElementException noSuchElementException = new NoSuchElementException(e.getMessage());
            AppMethodBeat.m2505o(3549);
            throw noSuchElementException;
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.m2504i(3551);
        Byte valueOf = Byte.valueOf(nextByte());
        AppMethodBeat.m2505o(3551);
        return valueOf;
    }

    public final void remove() {
        AppMethodBeat.m2504i(3550);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(3550);
        throw unsupportedOperationException;
    }
}
