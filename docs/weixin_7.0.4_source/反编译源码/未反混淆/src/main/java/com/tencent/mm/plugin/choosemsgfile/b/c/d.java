package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.ui.a;
import java.util.List;

public final class d extends a {
    public d(a aVar, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> list) {
        super(aVar, list);
    }

    public final v a(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(54337);
        v m;
        switch (i) {
            case 0:
                m = l.m(viewGroup);
                AppMethodBeat.o(54337);
                return m;
            default:
                m = n.m(viewGroup);
                AppMethodBeat.o(54337);
                return m;
        }
    }
}
