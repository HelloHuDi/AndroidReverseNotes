package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public class s {
    private LinkedList<a> vay = new LinkedList();

    public class a {
        public String detail;
        public String key;
        public long time;

        a(String str, long j, String str2) {
            this.key = str;
            this.time = j;
            this.detail = str2;
        }
    }

    public s() {
        AppMethodBeat.i(105834);
        AppMethodBeat.o(105834);
    }

    public final void aI(String str, long j) {
        AppMethodBeat.i(105835);
        c(str, j, "");
        AppMethodBeat.o(105835);
    }

    private void c(String str, long j, String str2) {
        AppMethodBeat.i(105836);
        this.vay.add(new a(str, j, str2));
        AppMethodBeat.o(105836);
    }

    public final long ais(String str) {
        AppMethodBeat.i(105837);
        Iterator it = this.vay.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.key.equals(str)) {
                long j = aVar.time;
                AppMethodBeat.o(105837);
                return j;
            }
        }
        AppMethodBeat.o(105837);
        return 0;
    }
}
