package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g {
    private long[] brk;
    public int size;

    public g() {
        this((byte) 0);
    }

    private g(byte b) {
        AppMethodBeat.i(95876);
        this.brk = new long[32];
        AppMethodBeat.o(95876);
    }

    public final void add(long j) {
        AppMethodBeat.i(95877);
        if (this.size == this.brk.length) {
            this.brk = Arrays.copyOf(this.brk, this.size * 2);
        }
        long[] jArr = this.brk;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
        AppMethodBeat.o(95877);
    }

    public final long get(int i) {
        AppMethodBeat.i(95878);
        if (i < 0 || i >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
            AppMethodBeat.o(95878);
            throw indexOutOfBoundsException;
        }
        long j = this.brk[i];
        AppMethodBeat.o(95878);
        return j;
    }

    public final long[] toArray() {
        AppMethodBeat.i(95879);
        long[] copyOf = Arrays.copyOf(this.brk, this.size);
        AppMethodBeat.o(95879);
        return copyOf;
    }
}
