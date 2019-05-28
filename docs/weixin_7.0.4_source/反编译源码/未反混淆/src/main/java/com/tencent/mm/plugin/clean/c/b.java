package com.tencent.mm.plugin.clean.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long jrb;
    public ArrayList<a> kwf;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.jrb < bVar.jrb) {
            return -1;
        }
        if (this.jrb > bVar.jrb) {
            return 1;
        }
        return 0;
    }

    public final boolean bfI() {
        AppMethodBeat.i(18666);
        this.jrb = 0;
        Iterator it = this.kwf.iterator();
        while (it.hasNext()) {
            this.jrb += ((a) it.next()).size;
        }
        if (this.kwf.size() == 0) {
            AppMethodBeat.o(18666);
            return false;
        }
        AppMethodBeat.o(18666);
        return true;
    }
}
