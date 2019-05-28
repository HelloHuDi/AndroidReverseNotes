package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;

public final class d extends a {
    private static int moM;

    public static class a extends b {
        ImageView moN;
    }

    public d(l lVar) {
        super(lVar);
        AppMethodBeat.i(74620);
        moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hx);
        AppMethodBeat.o(74620);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74621);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.yi, null), aVar, gVar);
            aVar.moN = (ImageView) view.findViewById(R.id.bq6);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        aar c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        ImageView imageView = bVar2.moN;
        int i = moM;
        l.a(imageView, c, gVar, false, i, i);
        AppMethodBeat.o(74621);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74622);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74622);
    }
}
