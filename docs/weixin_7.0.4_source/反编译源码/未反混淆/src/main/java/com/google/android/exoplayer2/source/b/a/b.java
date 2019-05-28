package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b extends c {
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
    public final a bjR;
    public final List<a> bjS;
    public final int version;

    public static final class a implements Comparable<Long> {
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
            AppMethodBeat.i(125963);
            Long l = (Long) obj;
            if (this.bjU > l.longValue()) {
                AppMethodBeat.o(125963);
                return 1;
            } else if (this.bjU < l.longValue()) {
                AppMethodBeat.o(125963);
                return -1;
            } else {
                AppMethodBeat.o(125963);
                return 0;
            }
        }

        public a(String str, long j, long j2) {
            this(str, 0, -1, -9223372036854775807L, false, null, null, j, j2);
        }

        public a(String str, long j, int i, long j2, boolean z, String str2, String str3, long j3, long j4) {
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

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, a aVar, List<a> list2) {
        super(str, list);
        AppMethodBeat.i(125964);
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
        this.bjR = aVar;
        this.bjS = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.aOz = 0;
        } else {
            a aVar2 = (a) list2.get(list2.size() - 1);
            this.aOz = aVar2.aOz + aVar2.bjU;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.aOz;
        }
        this.bjJ = j;
        AppMethodBeat.o(125964);
    }

    public final long sC() {
        return this.bif + this.aOz;
    }
}
