package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class b extends a {

    public static class a extends com.tencent.mm.plugin.fav.ui.d.a.b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public b(l lVar) {
        super(lVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        com.tencent.mm.plugin.fav.ui.d.a.b aVar;
        AppMethodBeat.i(74615);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnB.setSingleLine(false);
            aVar.gnB.setMaxLines(2);
            aVar.gnC = (TextView) view.findViewById(R.id.av);
            aVar.moL = (TextView) view.findViewById(R.id.b8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        com.tencent.mm.storage.bi.a Rn = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().Rn(com.tencent.mm.plugin.fav.a.b.c(gVar).desc);
        if (Rn.svN == null || Rn.svN.length() <= 0) {
            ab.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (bo.isNullOrNil(a(Rn))) {
            aVar.gnC.setVisibility(8);
        } else {
            aVar.gnC.setText(a(Rn));
        }
        aVar.moL.setText(R.string.bp3);
        aVar.moL.setVisibility(0);
        ImageView imageView = aVar.iqT;
        String str = Rn.svN;
        if (bo.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.ad2);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
        }
        AppMethodBeat.o(74615);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74616);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74616);
    }

    private static String a(com.tencent.mm.storage.bi.a aVar) {
        Object obj;
        Object obj2 = 1;
        Object obj3 = null;
        AppMethodBeat.i(74617);
        String str = aVar.dFl;
        if (bo.isNullOrNil(str)) {
            str = aVar.svN;
            if (ad.aoA(str) || t.mX(str)) {
                obj3 = 1;
            }
            obj = obj3;
        } else {
            obj = null;
        }
        if (obj != null || ((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoJ(str)) {
            obj2 = obj;
        }
        boolean kv = t.kv(aVar.ufB);
        if (obj2 != null || kv) {
            String str2 = "";
            AppMethodBeat.o(74617);
            return str2;
        }
        AppMethodBeat.o(74617);
        return str;
    }
}
