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
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abh;
import java.util.LinkedList;

public final class p extends a {
    final int moM;

    public static class a extends b {
        ImageView moN;
        TextView mps;
    }

    public p(l lVar) {
        super(lVar);
        AppMethodBeat.i(74658);
        this.moM = com.tencent.mm.bz.a.al(lVar.context, R.dimen.hx);
        AppMethodBeat.o(74658);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        a aVar;
        AppMethodBeat.i(74659);
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, R.layout.yk, null), (b) aVar, gVar);
            aVar.moN = (ImageView) view.findViewById(R.id.bq6);
            aVar.mps = (TextView) view.findViewById(R.id.bqd);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mps.setVisibility(0);
        LinkedList linkedList = gVar.field_favProto.wiv;
        if (linkedList.size() <= 0 || ((aar) linkedList.getFirst()).duration <= 0) {
            aVar.mps.setText("");
        } else {
            aVar.mps.setText(j.B(context, ((aar) linkedList.getFirst()).duration));
        }
        a((b) aVar, gVar);
        this.mhy.a(aVar.moN, com.tencent.mm.plugin.fav.a.b.c(gVar), gVar, (int) R.raw.app_attach_file_icon_video, this.moM, this.moM);
        AppMethodBeat.o(74659);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74660);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74660);
    }
}
