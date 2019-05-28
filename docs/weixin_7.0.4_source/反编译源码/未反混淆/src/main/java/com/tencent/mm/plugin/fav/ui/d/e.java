package com.tencent.mm.plugin.fav.ui.d;

import android.annotation.SuppressLint;
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
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.bo;

public final class e extends a {

    public static class a extends b {
        TextView gnB;
        TextView gnC;
        ImageView iqT;
    }

    public e(l lVar) {
        super(lVar);
    }

    @SuppressLint({"ResourceType"})
    public final View a(View view, ViewGroup viewGroup, g gVar) {
        b bVar;
        AppMethodBeat.i(74623);
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
        bVar2.iqT.setImageResource(R.raw.app_attach_file_icon_location);
        aay aay = gVar.field_favProto.why;
        CharSequence charSequence = gVar.field_favProto.hHV;
        if (!bo.isNullOrNil(charSequence)) {
            bVar2.gnB.setText(j.b(bVar2.gnB.getContext(), charSequence, bVar2.gnB.getTextSize()));
            if (k.Md(aay.cIK)) {
                bVar2.gnC.setText(aay.cIK);
                AppMethodBeat.o(74623);
                return view;
            }
        } else if (k.Md(aay.cIK)) {
            bVar2.gnB.setText(aay.cIK);
        } else {
            bVar2.gnB.setText(aay.label);
            bVar2.gnC.setVisibility(8);
            AppMethodBeat.o(74623);
            return view;
        }
        bVar2.gnC.setText(aay.label);
        AppMethodBeat.o(74623);
        return view;
    }

    public final void a(View view, abh abh) {
        AppMethodBeat.i(74624);
        a aVar = (a) view.getTag();
        ((y) com.tencent.mm.kernel.g.K(y.class)).a(view.getContext(), aVar.mgf, abh);
        AppMethodBeat.o(74624);
    }
}
