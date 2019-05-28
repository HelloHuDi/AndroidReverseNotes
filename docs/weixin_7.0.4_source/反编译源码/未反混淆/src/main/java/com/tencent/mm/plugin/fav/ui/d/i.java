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
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.bo;

public final class i extends a {
    private final int moM;
    private final String mpi;

    public static class a extends b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
        TextView moL;
    }

    public i(l lVar) {
        super(lVar);
        AppMethodBeat.i(74636);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hw);
        this.mpi = lVar.context.getString(R.string.bqc);
        AppMethodBeat.o(74636);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b aVar;
        AppMethodBeat.i(74637);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yd, null), aVar, gVar);
            aVar.iqT = (ImageView) view.findViewById(R.id.yk);
            aVar.gnB = (TextView) view.findViewById(R.id.bb);
            aVar.gnC = (TextView) view.findViewById(R.id.av);
            aVar.gnC.setVisibility(8);
            aVar.moL = (TextView) view.findViewById(R.id.b8);
            aVar.moL.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, gVar);
        aVar.gnB.setText(bo.nullAsNil(gVar.field_favProto.whC.title));
        aVar.moL.setText(bo.bc(com.tencent.mm.plugin.fav.a.b.getAppName(context, gVar.field_favProto.wit.appId), this.mpi));
        this.mhy.a(aVar.iqT, null, gVar, (int) R.raw.app_attach_file_icon_unknow, this.moM, this.moM);
        AppMethodBeat.o(74637);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74638);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74638);
    }
}
