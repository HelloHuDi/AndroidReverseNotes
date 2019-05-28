package com.tencent.p177mm.plugin.clean.p362c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.clean.c.b */
public final class C27641b implements Comparable<C27641b> {
    public long jrb;
    public ArrayList<C11389a> kwf;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C27641b c27641b = (C27641b) obj;
        if (this.jrb < c27641b.jrb) {
            return -1;
        }
        if (this.jrb > c27641b.jrb) {
            return 1;
        }
        return 0;
    }

    public final boolean bfI() {
        AppMethodBeat.m2504i(18666);
        this.jrb = 0;
        Iterator it = this.kwf.iterator();
        while (it.hasNext()) {
            this.jrb += ((C11389a) it.next()).size;
        }
        if (this.kwf.size() == 0) {
            AppMethodBeat.m2505o(18666);
            return false;
        }
        AppMethodBeat.m2505o(18666);
        return true;
    }
}
