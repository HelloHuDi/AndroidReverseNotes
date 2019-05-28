package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C45054w;
import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.C45054w.C17695b;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.source.n */
public final class C25561n extends C45054w {
    private static final Object bhU = new Object();
    private final long aPk;
    private final long aPl;
    private final boolean aPm;
    private final boolean aPn;
    private final long bhV;
    private final long bhW;
    private final long bhX;
    private final long bhY;

    static {
        AppMethodBeat.m2504i(95551);
        AppMethodBeat.m2505o(95551);
    }

    public C25561n(long j, boolean z) {
        this(j, j, z);
        AppMethodBeat.m2504i(95547);
        AppMethodBeat.m2505o(95547);
    }

    private C25561n(long j, long j2, boolean z) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, 0, 0, z, false);
    }

    public C25561n(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.aPk = j;
        this.aPl = j2;
        this.bhV = j3;
        this.bhW = j4;
        this.bhX = j5;
        this.bhY = j6;
        this.aPm = z;
        this.aPn = z2;
    }

    /* renamed from: qg */
    public final int mo42830qg() {
        return 1;
    }

    /* renamed from: a */
    public final C17695b mo42827a(int i, C17695b c17695b, boolean z, long j) {
        AppMethodBeat.m2504i(95548);
        C45039a.m82573bh(i, 1);
        Object obj = z ? bhU : null;
        long j2 = this.bhY;
        if (this.aPn) {
            j2 += j;
            if (j2 > this.bhW) {
                j2 = -9223372036854775807L;
            }
        }
        long j3 = this.aPk;
        long j4 = this.aPl;
        boolean z2 = this.aPm;
        boolean z3 = this.aPn;
        long j5 = this.bhW;
        long j6 = this.bhX;
        c17695b.aPc = obj;
        c17695b.aPk = j3;
        c17695b.aPl = j4;
        c17695b.aPm = z2;
        c17695b.aPn = z3;
        c17695b.aPq = j2;
        c17695b.aOz = j5;
        c17695b.aPo = 0;
        c17695b.aPp = 0;
        c17695b.aPr = j6;
        AppMethodBeat.m2505o(95548);
        return c17695b;
    }

    /* renamed from: qh */
    public final int mo42831qh() {
        return 1;
    }

    /* renamed from: a */
    public final C17694a mo42826a(int i, C17694a c17694a, boolean z) {
        Object obj;
        AppMethodBeat.m2504i(95549);
        C45039a.m82573bh(i, 1);
        if (z) {
            obj = bhU;
        } else {
            obj = null;
        }
        long j = this.bhV;
        long j2 = -this.bhX;
        c17694a.aPc = obj;
        c17694a.aNH = obj;
        c17694a.aNV = 0;
        c17694a.aOz = j;
        c17694a.aPd = j2;
        c17694a.aPe = null;
        c17694a.aPf = null;
        c17694a.aPg = null;
        c17694a.aPh = null;
        c17694a.aPi = null;
        c17694a.aPj = -9223372036854775807L;
        AppMethodBeat.m2505o(95549);
        return c17694a;
    }

    /* renamed from: ac */
    public final int mo42829ac(Object obj) {
        AppMethodBeat.m2504i(95550);
        if (bhU.equals(obj)) {
            AppMethodBeat.m2505o(95550);
            return 0;
        }
        AppMethodBeat.m2505o(95550);
        return -1;
    }
}
