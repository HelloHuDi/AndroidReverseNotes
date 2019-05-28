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
import com.tencent.mm.protocal.protobuf.abe;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends a {
    private final int moM;

    public static class a extends b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public f(l lVar) {
        super(lVar);
        AppMethodBeat.i(74625);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hw);
        AppMethodBeat.o(74625);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        AppMethodBeat.i(74626);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnC = (TextView) view.findViewById(R.id.av);
            aVar.moL = (TextView) view.findViewById(R.id.b8);
            aVar.moL.setVisibility(8);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        abe abe = gVar.field_favProto.whC;
        aVar.gnB.setText(bo.nullAsNil(abe.title));
        aVar.gnC.setText(bo.nullAsNil(abe.desc));
        aVar.gnB.setSingleLine(false);
        aVar.gnB.setMaxLines(2);
        this.mhy.a(aVar.iqT, null, gVar, (int) R.raw.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.o(74626);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74627);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74627);
    }
}
