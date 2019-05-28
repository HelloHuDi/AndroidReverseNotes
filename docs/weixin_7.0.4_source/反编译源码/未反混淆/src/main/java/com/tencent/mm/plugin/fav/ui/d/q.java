package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.abh;

public final class q extends a {

    public static class a extends b {
        TextView gnB;
    }

    public q(l lVar) {
        super(lVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        CharSequence string;
        AppMethodBeat.i(74661);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.yn, null), aVar, gVar);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        int fY = (int) com.tencent.mm.plugin.fav.a.b.fY((long) com.tencent.mm.plugin.fav.a.b.c(gVar).duration);
        TextView textView = bVar2.gnB;
        context = this.mhy.context;
        if (fY <= 0) {
            string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(0)});
        } else {
            string = context.getString(R.string.bsa, new Object[]{Integer.valueOf(fY)});
        }
        textView.setText(string);
        AppMethodBeat.o(74661);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74662);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74662);
    }
}
