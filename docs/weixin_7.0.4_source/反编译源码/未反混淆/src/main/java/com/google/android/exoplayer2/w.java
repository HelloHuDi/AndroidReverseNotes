package com.google.android.exoplayer2;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w {
    public static final w aPb = new w() {
        public final int qg() {
            return 0;
        }

        public final b a(int i, b bVar, boolean z, long j) {
            AppMethodBeat.i(95753);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(95753);
            throw indexOutOfBoundsException;
        }

        public final int qh() {
            return 0;
        }

        public final a a(int i, a aVar, boolean z) {
            AppMethodBeat.i(95754);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(95754);
            throw indexOutOfBoundsException;
        }

        public final int ac(Object obj) {
            return -1;
        }
    };

    public static final class a {
        public Object aNH;
        public int aNV;
        public long aOz;
        public Object aPc;
        public long aPd;
        public long[] aPe;
        public int[] aPf;
        public int[] aPg;
        public int[] aPh;
        public long[][] aPi;
        public long aPj;

        public final int qi() {
            return this.aPe == null ? 0 : this.aPe.length;
        }

        public final boolean dy(int i) {
            return this.aPf[i] != -1 && this.aPh[i] == this.aPf[i];
        }

        public final int F(long j) {
            AppMethodBeat.i(95755);
            if (this.aPe == null) {
                AppMethodBeat.o(95755);
                return -1;
            }
            int length = this.aPe.length - 1;
            while (length >= 0 && (this.aPe[length] == Long.MIN_VALUE || this.aPe[length] > j)) {
                length--;
            }
            if (length < 0 || dy(length)) {
                AppMethodBeat.o(95755);
                return -1;
            }
            AppMethodBeat.o(95755);
            return length;
        }

        public final int G(long j) {
            AppMethodBeat.i(95756);
            if (this.aPe == null) {
                AppMethodBeat.o(95756);
                return -1;
            }
            int i = 0;
            while (i < this.aPe.length && this.aPe[i] != Long.MIN_VALUE && (j >= this.aPe[i] || dy(i))) {
                i++;
            }
            if (i < this.aPe.length) {
                AppMethodBeat.o(95756);
                return i;
            }
            AppMethodBeat.o(95756);
            return -1;
        }

        public final boolean ba(int i, int i2) {
            return i2 < this.aPg[i];
        }

        public final long bb(int i, int i2) {
            if (i2 >= this.aPi[i].length) {
                return -9223372036854775807L;
            }
            return this.aPi[i][i2];
        }
    }

    public static final class b {
        public long aOz;
        public Object aPc;
        public long aPk;
        public long aPl;
        public boolean aPm;
        public boolean aPn;
        public int aPo;
        public int aPp;
        public long aPq;
        public long aPr;
    }

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, boolean z, long j);

    public abstract int ac(Object obj);

    public abstract int qg();

    public abstract int qh();

    public final boolean isEmpty() {
        return qg() == 0;
    }

    public int aZ(int i, int i2) {
        switch (i2) {
            case 0:
                return i == qg() + -1 ? -1 : i + 1;
            case 1:
                return i;
            case 2:
                return i == qg() + -1 ? 0 : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final b a(int i, b bVar) {
        return a(i, bVar, false, 0);
    }

    public final int a(int i, a aVar, b bVar, int i2) {
        int i3 = a(i, aVar, false).aNV;
        if (a(i3, bVar).aPp != i) {
            return i + 1;
        }
        i3 = aZ(i3, i2);
        if (i3 == -1) {
            return -1;
        }
        return a(i3, bVar).aPo;
    }

    public final boolean b(int i, a aVar, b bVar, int i2) {
        return a(i, aVar, bVar, i2) == -1;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        com.google.android.exoplayer2.i.a.bh(i, qg());
        a(i, bVar, false, j2);
        if (j == -9223372036854775807L) {
            j = bVar.aPq;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.aPo;
        long j3 = bVar.aPr + j;
        long j4 = a(i2, aVar, false).aOz;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < bVar.aPp) {
            j3 -= j4;
            i2++;
            j4 = a(i2, aVar, false).aOz;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }
}
