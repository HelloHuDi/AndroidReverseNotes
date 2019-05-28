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
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMImageView;

public final class l extends a {
    private final int moM;
    private final String mpi = "";

    public static class a extends b {
        TextView gnB;
        TextView gnC;
        MMImageView mlG;
        TextView moL;
    }

    public l(com.tencent.mm.plugin.fav.ui.l lVar) {
        super(lVar);
        AppMethodBeat.i(74648);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hw);
        AppMethodBeat.o(74648);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        AppMethodBeat.i(74649);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.mlG = (MMImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnC = (TextView) view.findViewById(R.id.av);
            aVar.moL = (TextView) view.findViewById(R.id.b8);
            aVar.moL.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        abo abo = gVar.field_favProto.whE;
        if (abo != null) {
            aVar.gnB.setText(bo.nullAsNil(abo.title));
            aVar.gnC.setText(bo.nullAsNil(abo.desc));
        } else {
            aVar.gnB.setText("");
            aVar.gnC.setText("");
        }
        aVar.moL.setText(bo.bc(com.tencent.mm.plugin.fav.a.b.getAppName(context, gVar.field_favProto.wit.appId), this.mpi));
        this.mhy.a(aVar.mlG, null, gVar, (int) R.raw.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.o(74649);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74650);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74650);
    }
}
