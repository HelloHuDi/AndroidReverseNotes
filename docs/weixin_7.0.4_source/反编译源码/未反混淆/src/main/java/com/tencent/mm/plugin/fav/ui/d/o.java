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
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.bo;

public final class o extends a {
    private final int moM;

    public static class a extends b {
        TextView gnB;
        ImageView iqT;
    }

    public o(l lVar) {
        super(lVar);
        AppMethodBeat.i(74655);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hw);
        AppMethodBeat.o(74655);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        AppMethodBeat.i(74656);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnB.setMaxLines(2);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aar c = com.tencent.mm.plugin.fav.a.b.c(gVar);
        abu abu = gVar.field_favProto.whA;
        TextView textView = aVar.gnB;
        aar c2 = com.tencent.mm.plugin.fav.a.b.c(gVar);
        String str = "";
        if (abu != null) {
            str = abu.title;
        }
        if (bo.isNullOrNil(str) && c2 != null) {
            str = c2.title;
        }
        if (bo.isNullOrNil(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        int ail = d.ail(c.wgo);
        l lVar = this.mhy;
        ImageView imageView = aVar.iqT;
        if (ail == d.dgO()) {
            ail = R.raw.app_attach_file_icon_webpage;
        }
        lVar.a(imageView, c, gVar, ail, this.moM, this.moM);
        AppMethodBeat.o(74656);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74657);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74657);
    }
}
