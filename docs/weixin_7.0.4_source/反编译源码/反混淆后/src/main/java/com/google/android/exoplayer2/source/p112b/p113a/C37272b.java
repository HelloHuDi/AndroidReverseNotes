package com.google.android.exoplayer2.source.p112b.p113a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.a.b */
public final class C37272b extends C45047c {
    public final long aOz;
    public final long bif;
    public final int bjI;
    public final long bjJ;
    public final boolean bjK;
    public final int bjL;
    public final int bjM;
    public final long bjN;
    public final boolean bjO;
    public final boolean bjP;
    public final boolean bjQ;
    public final C37273a bjR;
    public final List<C37273a> bjS;
    public final int version;

    /* renamed from: com.google.android.exoplayer2.source.b.a.b$a */
    public static final class C37273a implements Comparable<Long> {
        public final long aOz;
        public final boolean aZs;
        public final int bjT;
        public final long bjU;
        public final String bjV;
        public final String bjW;
        public final long bjX;
        public final long bjY;
        public final String url;

        public final /* synthetic */ int compareTo(Object obj) {
            AppMethodBeat.m2504i(125963);
            Long l = (Long) obj;
            if (this.bjU > l.longValue()) {
                AppMethodBeat.m2505o(125963);
                return 1;
            } else if (this.bjU < l.longValue()) {
                AppMethodBeat.m2505o(125963);
                return -1;
            } else {
                AppMethodBeat.m2505o(125963);
                return 0;
            }
        }

        public C37273a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, null, null, j, j2);
        }

        public C37273a(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
            this.url = str;
            this.aOz = j;
            this.bjT = i;
            this.bjU = j2;
            this.aZs = z;
            this.bjV = str2;
            this.bjW = str3;
            this.bjX = j3;
            this.bjY = j4;
        }
    }

    public C37272b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, C37273a c37273a, List<C37273a> list2) {
        super(str, list);
        AppMethodBeat.m2504i(125964);
        this.bjI = i;
        this.bif = j2;
        this.bjK = z;
        this.bjL = i2;
        this.bjM = i3;
        this.version = i4;
        this.bjN = j3;
        this.bjO = z2;
        this.bjP = z3;
        this.bjQ = z4;
        this.bjR = c37273a;
        this.bjS = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.aOz = 0;
        } else {
            C37273a c37273a2 = (C37273a) list2.get(list2.size() - 1);
            this.aOz = c37273a2.aOz + c37273a2.bjU;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.aOz;
        }
        this.bjJ = j;
        AppMethodBeat.m2505o(125964);
    }

    /* renamed from: sC */
    public final long mo59516sC() {
        return this.bif + this.aOz;
    }
}
