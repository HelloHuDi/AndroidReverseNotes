package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.choosemsgfile.ui.a;
import java.util.List;

public final class c extends a implements g {
    boolean kuX;

    public c(a aVar, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> list) {
        super(aVar, list);
    }

    public final boolean bfz() {
        return this.kuX;
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(54335);
        v m;
        switch (i) {
            case 0:
                m = l.m(viewGroup);
                AppMethodBeat.o(54335);
                return m;
            default:
                m = m.m(viewGroup);
                AppMethodBeat.o(54335);
                return m;
        }
    }

    public final int gU(long j) {
        AppMethodBeat.i(54336);
        int i = -1;
        for (com.tencent.mm.plugin.choosemsgfile.b.b.a aVar : this.iJL) {
            i++;
            if (aVar.kua != null && aVar.kua.field_msgId == j) {
                AppMethodBeat.o(54336);
                return i;
            }
        }
        AppMethodBeat.o(54336);
        return -1;
    }
}
