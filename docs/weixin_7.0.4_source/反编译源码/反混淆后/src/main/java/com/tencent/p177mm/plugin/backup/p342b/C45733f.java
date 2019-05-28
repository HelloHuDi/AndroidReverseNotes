package com.tencent.p177mm.plugin.backup.p342b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.backup.b.f */
public final class C45733f {

    /* renamed from: com.tencent.mm.plugin.backup.b.f$a */
    public static class C19940a {
        public long endTime;
        public String jrd;
        public int jre;
        public long startTime;

        public C19940a(int i, String str, long j, long j2) {
            this.jre = i;
            this.jrd = str;
            this.startTime = j;
            this.endTime = j2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.b.f$b */
    public static class C27443b implements Cloneable, Comparable<C27443b> {
        public String jrf;
        public long jrg = 0;
        public long jrh = 0;
        public long jri = -1;
        public long jrj = -1;

        public final /* synthetic */ Object clone() {
            AppMethodBeat.m2504i(17115);
            C27443b aSE = aSE();
            AppMethodBeat.m2505o(17115);
            return aSE;
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            C27443b c27443b = (C27443b) obj;
            if (this.jri < c27443b.jri) {
                return 1;
            }
            if (this.jri > c27443b.jri) {
                return -1;
            }
            return 0;
        }

        public final C27443b aSE() {
            AppMethodBeat.m2504i(17114);
            C27443b c27443b = new C27443b();
            c27443b.jrf = this.jrf;
            c27443b.jrg = this.jrg;
            c27443b.jrh = this.jrh;
            c27443b.jri = this.jri;
            c27443b.jrj = this.jrj;
            AppMethodBeat.m2505o(17114);
            return c27443b;
        }
    }
}
