package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends a {

    public static class a extends b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
    }

    public c(l lVar) {
        super(lVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74618);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.ye, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnC = (TextView) view.findViewById(R.id.aw);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        aar c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        CharSequence charSequence = gVar.field_favProto.title;
        if (bo.isNullOrNil(charSequence)) {
            charSequence = c.title;
        }
        bVar2.gnB.setText(charSequence);
        bVar2.gnC.setText(com.tencent.mm.plugin.fav.a.b.aC((float) c.wgu));
        if (c.whh == 2) {
            bVar2.gnC.setText(">25MB");
        }
        bVar2.iqT.setImageResource(com.tencent.mm.plugin.fav.ui.c.LX(c.wgo));
        AppMethodBeat.o(74618);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74619);
        g gVar = ((a) view.getTag()).mgf;
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), gVar, abh);
        AppMethodBeat.o(74619);
    }
}
