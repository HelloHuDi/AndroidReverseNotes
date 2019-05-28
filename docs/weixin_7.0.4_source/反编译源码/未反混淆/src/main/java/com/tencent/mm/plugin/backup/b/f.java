package com.tencent.mm.plugin.backup.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {

    public static class a {
        public long endTime;
        public String jrd;
        public int jre;
        public long startTime;

        public a(int i, String str, long j, long j2) {
            this.jre = i;
            this.jrd = str;
            this.startTime = j;
            this.endTime = j2;
        }
    }

    public static class b implements Cloneable, Comparable<b> {
        public String jrf;
        public long jrg = 0;
        public long jrh = 0;
        public long jri = -1;
        public long jrj = -1;

        public final /* synthetic */ Object clone() {
            AppMethodBeat.i(17115);
            b aSE = aSE();
            AppMethodBeat.o(17115);
            return aSE;
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            if (this.jri < bVar.jri) {
                return 1;
            }
            if (this.jri > bVar.jri) {
                return -1;
            }
            return 0;
        }

        public final b aSE() {
            AppMethodBeat.i(17114);
            b bVar = new b();
            bVar.jrf = this.jrf;
            bVar.jrg = this.jrg;
            bVar.jrh = this.jrh;
            bVar.jri = this.jri;
            bVar.jrj = this.jrj;
            AppMethodBeat.o(17114);
            return bVar;
        }
    }
}
