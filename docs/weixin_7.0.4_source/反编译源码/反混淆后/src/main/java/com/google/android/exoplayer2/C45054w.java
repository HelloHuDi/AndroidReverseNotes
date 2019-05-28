package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.w */
public abstract class C45054w {
    public static final C45054w aPb = new C372861();

    /* renamed from: com.google.android.exoplayer2.w$a */
    public static final class C17694a {
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

        /* renamed from: qi */
        public final int mo32399qi() {
            return this.aPe == null ? 0 : this.aPe.length;
        }

        /* renamed from: dy */
        public final boolean mo32398dy(int i) {
            return this.aPf[i] != -1 && this.aPh[i] == this.aPf[i];
        }

        /* renamed from: F */
        public final int mo32394F(long j) {
            AppMethodBeat.m2504i(95755);
            if (this.aPe == null) {
                AppMethodBeat.m2505o(95755);
                return -1;
            }
            int length = this.aPe.length - 1;
            while (length >= 0 && (this.aPe[length] == Long.MIN_VALUE || this.aPe[length] > j)) {
                length--;
            }
            if (length < 0 || mo32398dy(length)) {
                AppMethodBeat.m2505o(95755);
                return -1;
            }
            AppMethodBeat.m2505o(95755);
            return length;
        }

        /* renamed from: G */
        public final int mo32395G(long j) {
            AppMethodBeat.m2504i(95756);
            if (this.aPe == null) {
                AppMethodBeat.m2505o(95756);
                return -1;
            }
            int i = 0;
            while (i < this.aPe.length && this.aPe[i] != Long.MIN_VALUE && (j >= this.aPe[i] || mo32398dy(i))) {
                i++;
            }
            if (i < this.aPe.length) {
                AppMethodBeat.m2505o(95756);
                return i;
            }
            AppMethodBeat.m2505o(95756);
            return -1;
        }

        /* renamed from: ba */
        public final boolean mo32396ba(int i, int i2) {
            return i2 < this.aPg[i];
        }

        /* renamed from: bb */
        public final long mo32397bb(int i, int i2) {
            if (i2 >= this.aPi[i].length) {
                return -9223372036854775807L;
            }
            return this.aPi[i][i2];
        }
    }

    /* renamed from: com.google.android.exoplayer2.w$b */
    public static final class C17695b {
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

    /* renamed from: com.google.android.exoplayer2.w$1 */
    static class C372861 extends C45054w {
        C372861() {
        }

        /* renamed from: qg */
        public final int mo42830qg() {
            return 0;
        }

        /* renamed from: a */
        public final C17695b mo42827a(int i, C17695b c17695b, boolean z, long j) {
            AppMethodBeat.m2504i(95753);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.m2505o(95753);
            throw indexOutOfBoundsException;
        }

        /* renamed from: qh */
        public final int mo42831qh() {
            return 0;
        }

        /* renamed from: a */
        public final C17694a mo42826a(int i, C17694a c17694a, boolean z) {
            AppMethodBeat.m2504i(95754);
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.m2505o(95754);
            throw indexOutOfBoundsException;
        }

        /* renamed from: ac */
        public final int mo42829ac(Object obj) {
            return -1;
        }
    }

    /* renamed from: a */
    public abstract C17694a mo42826a(int i, C17694a c17694a, boolean z);

    /* renamed from: a */
    public abstract C17695b mo42827a(int i, C17695b c17695b, boolean z, long j);

    /* renamed from: ac */
    public abstract int mo42829ac(Object obj);

    /* renamed from: qg */
    public abstract int mo42830qg();

    /* renamed from: qh */
    public abstract int mo42831qh();

    public final boolean isEmpty() {
        return mo42830qg() == 0;
    }

    /* renamed from: aZ */
    public int mo42828aZ(int i, int i2) {
        switch (i2) {
            case 0:
                return i == mo42830qg() + -1 ? -1 : i + 1;
            case 1:
                return i;
            case 2:
                return i == mo42830qg() + -1 ? 0 : i + 1;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public final C17695b mo72574a(int i, C17695b c17695b) {
        return mo42827a(i, c17695b, false, 0);
    }

    /* renamed from: a */
    public final int mo72571a(int i, C17694a c17694a, C17695b c17695b, int i2) {
        int i3 = mo42826a(i, c17694a, false).aNV;
        if (mo72574a(i3, c17695b).aPp != i) {
            return i + 1;
        }
        i3 = mo42828aZ(i3, i2);
        if (i3 == -1) {
            return -1;
        }
        return mo72574a(i3, c17695b).aPo;
    }

    /* renamed from: b */
    public final boolean mo72575b(int i, C17694a c17694a, C17695b c17695b, int i2) {
        return mo72571a(i, c17694a, c17695b, i2) == -1;
    }

    /* renamed from: a */
    public final Pair<Integer, Long> mo72572a(C17695b c17695b, C17694a c17694a, int i, long j) {
        return mo72573a(c17695b, c17694a, i, j, 0);
    }

    /* renamed from: a */
    public final Pair<Integer, Long> mo72573a(C17695b c17695b, C17694a c17694a, int i, long j, long j2) {
        C45039a.m82573bh(i, mo42830qg());
        mo42827a(i, c17695b, false, j2);
        if (j == -9223372036854775807L) {
            j = c17695b.aPq;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = c17695b.aPo;
        long j3 = c17695b.aPr + j;
        long j4 = mo42826a(i2, c17694a, false).aOz;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < c17695b.aPp) {
            j3 -= j4;
            i2++;
            j4 = mo42826a(i2, c17694a, false).aOz;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }
}
