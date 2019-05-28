package com.tencent.p177mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.monitor.a */
public interface C39415a {

    /* renamed from: com.tencent.mm.plugin.monitor.a$a */
    public static class C21323a {
        int bna;
        long ckF;
        boolean fIa = false;
        long fileLenInvalidCount;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        ArrayList<C21324b> oEq = new ArrayList(20);
        ArrayList<C21325c> oEr = new ArrayList(20);

        C21323a(String str) {
            AppMethodBeat.m2504i(84511);
            this.oEn = str;
            AppMethodBeat.m2505o(84511);
        }

        public final String toString() {
            AppMethodBeat.m2504i(84512);
            String format = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.oEq.size()), Integer.valueOf(this.oEr.size()), Long.valueOf(this.ckF), Integer.valueOf(this.bna)});
            AppMethodBeat.m2505o(84512);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.a$b */
    public static class C21324b {
        boolean fIa = false;
        long fileLenInvalidCount;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        final int tag;

        C21324b(String str, int i) {
            this.oEn = str;
            this.tag = i;
        }

        public final String toString() {
            AppMethodBeat.m2504i(84513);
            String format = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.fileLenInvalidCount)});
            AppMethodBeat.m2505o(84513);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.monitor.a$c */
    public static class C21325c {
        boolean fIa = false;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        long oEs;

        C21325c(String str) {
            this.oEn = str;
        }

        public final String toString() {
            AppMethodBeat.m2504i(84514);
            String format = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.oEs)});
            AppMethodBeat.m2505o(84514);
            return format;
        }
    }

    /* renamed from: a */
    void mo46508a(int i, C21323a c21323a);
}
