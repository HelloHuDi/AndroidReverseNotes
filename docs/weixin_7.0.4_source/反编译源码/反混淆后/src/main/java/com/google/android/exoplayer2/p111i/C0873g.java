package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.i.g */
public final class C0873g {
    private long[] brk;
    public int size;

    public C0873g() {
        this((byte) 0);
    }

    private C0873g(byte b) {
        AppMethodBeat.m2504i(95876);
        this.brk = new long[32];
        AppMethodBeat.m2505o(95876);
    }

    public final void add(long j) {
        AppMethodBeat.m2504i(95877);
        if (this.size == this.brk.length) {
            this.brk = Arrays.copyOf(this.brk, this.size * 2);
        }
        long[] jArr = this.brk;
        int i = this.size;
        this.size = i + 1;
        jArr[i] = j;
        AppMethodBeat.m2505o(95877);
    }

    public final long get(int i) {
        AppMethodBeat.m2504i(95878);
        if (i < 0 || i >= this.size) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.size);
            AppMethodBeat.m2505o(95878);
            throw indexOutOfBoundsException;
        }
        long j = this.brk[i];
        AppMethodBeat.m2505o(95878);
        return j;
    }

    public final long[] toArray() {
        AppMethodBeat.m2504i(95879);
        long[] copyOf = Arrays.copyOf(this.brk, this.size);
        AppMethodBeat.m2505o(95879);
        return copyOf;
    }
}
