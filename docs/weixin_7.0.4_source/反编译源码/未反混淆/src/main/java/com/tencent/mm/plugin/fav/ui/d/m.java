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
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.abh;

public final class m extends a {

    public static class a extends b {
        TextView ene;
    }

    public m(l lVar) {
        super(lVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74651);
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.layout.ym, null), aVar, gVar);
            aVar.ene = (TextView) view.findViewById(R.id.bqe);
            bVar = aVar;
        } else {
            a bVar2 = (a) view.getTag();
        }
        a(bVar2, gVar);
        if (gVar.field_favProto.desc == null || gVar.field_favProto.desc.length() <= 0) {
            bVar2.ene.setText("");
            AppMethodBeat.o(74651);
        } else {
            bVar2.ene.setText(j.b(bVar2.ene.getContext(), gVar.field_favProto.desc, bVar2.ene.getTextSize()));
            AppMethodBeat.o(74651);
        }
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74652);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74652);
    }
}
