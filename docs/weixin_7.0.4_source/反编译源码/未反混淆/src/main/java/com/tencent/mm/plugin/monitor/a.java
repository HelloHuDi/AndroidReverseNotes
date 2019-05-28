package com.tencent.mm.plugin.monitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public interface a {

    public static class a {
        int bna;
        long ckF;
        boolean fIa = false;
        long fileLenInvalidCount;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        ArrayList<b> oEq = new ArrayList(20);
        ArrayList<c> oEr = new ArrayList(20);

        a(String str) {
            AppMethodBeat.i(84511);
            this.oEn = str;
            AppMethodBeat.o(84511);
        }

        public final String toString() {
            AppMethodBeat.i(84512);
            String format = String.format("FileResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d], subDirResult[%d], tempAccDirResult[%d], totalTime[%d], depth[%d]", new Object[]{Integer.valueOf(hashCode()), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.fileLenInvalidCount), Integer.valueOf(this.oEq.size()), Integer.valueOf(this.oEr.size()), Long.valueOf(this.ckF), Integer.valueOf(this.bna)});
            AppMethodBeat.o(84512);
            return format;
        }
    }

    public static class b {
        boolean fIa = false;
        long fileLenInvalidCount;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        final int tag;

        b(String str, int i) {
            this.oEn = str;
            this.tag = i;
        }

        public final String toString() {
            AppMethodBeat.i(84513);
            String format = String.format("SubDirResult hash(%d) root[%d][%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvalidCount[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.tag), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.fileLenInvalidCount)});
            AppMethodBeat.o(84513);
            return format;
        }
    }

    public static class c {
        boolean fIa = false;
        long jrb;
        final String oEn;
        long oEo;
        long oEp;
        long oEs;

        c(String str) {
            this.oEn = str;
        }

        public final String toString() {
            AppMethodBeat.i(84514);
            String format = String.format("TempAccDirResult hash(%d) root[%s], canceled[%b], dirCount[%d], fileCount[%d], totalSize[%d], fileLenInvaildCount[%d]", new Object[]{Integer.valueOf(hashCode()), this.oEn, Boolean.valueOf(this.fIa), Long.valueOf(this.oEo), Long.valueOf(this.oEp), Long.valueOf(this.jrb), Long.valueOf(this.oEs)});
            AppMethodBeat.o(84514);
            return format;
        }
    }

    void a(int i, a aVar);
}
