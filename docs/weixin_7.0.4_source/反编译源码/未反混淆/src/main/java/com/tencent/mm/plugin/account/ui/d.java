package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.p;

@Deprecated
final class d extends p<g> {
    a gBa;
    private int[] gty;
    private String gtz;

    public interface a {
        void mT(int i);
    }

    static class b {
        ImageView eks;
        TextView gBb;
        TextView gBc;
        ImageView gBd;
        TextView gtG;
        TextView gvr;

        b() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(124806);
        g gVar = (g) obj;
        if (gVar == null) {
            gVar = new g();
        }
        gVar.d(cursor);
        AppMethodBeat.o(124806);
        return gVar;
    }

    public d(Context context, com.tencent.mm.ui.p.a aVar) {
        super(context, new g());
        AppMethodBeat.i(124801);
        super.a(aVar);
        AppMethodBeat.o(124801);
    }

    public final void KD() {
        AppMethodBeat.i(124802);
        KC();
        AppMethodBeat.o(124802);
    }

    public final void KC() {
        AppMethodBeat.i(124803);
        setCursor(com.tencent.mm.plugin.account.a.getFacebookFrdStg().wa(this.gtz));
        this.gty = new int[getCount()];
        if (!(this.gBa == null || this.gtz == null)) {
            this.gBa.mT(getCursor().getCount());
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(124803);
    }

    public final void vM(String str) {
        AppMethodBeat.i(124804);
        this.gtz = bo.vA(str.trim());
        bIf();
        KC();
        AppMethodBeat.o(124804);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(124805);
        g gVar = (g) getItem(i);
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.context, R.layout.xr, null);
            bVar.eks = (ImageView) view.findViewById(R.id.bo3);
            bVar.gtG = (TextView) view.findViewById(R.id.bo4);
            bVar.gvr = (TextView) view.findViewById(R.id.bo7);
            bVar.gBb = (TextView) view.findViewById(R.id.bo5);
            bVar.gBc = (TextView) view.findViewById(R.id.bo6);
            bVar.gBd = (ImageView) view.findViewById(R.id.bo8);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.gtG.setText(j.b(this.context, gVar.apL(), bVar.gtG.getTextSize()));
        bVar.gBc.setVisibility(8);
        bVar.gBd.setVisibility(0);
        switch (this.gty[i]) {
            case 0:
                if (gVar.status == 102 || ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoJ(gVar.getUsername())) {
                    if (gVar.status != 102) {
                        bVar.gvr.setVisibility(0);
                        bVar.gvr.setText(R.string.c11);
                        bVar.gvr.setTextColor(this.context.getResources().getColor(R.color.e_));
                        bVar.gBb.setVisibility(8);
                        break;
                    }
                    bVar.gvr.setVisibility(8);
                    bVar.gBb.setVisibility(8);
                    bVar.gBd.setVisibility(8);
                    break;
                }
                bVar.gvr.setVisibility(8);
                bVar.gBb.setVisibility(0);
                break;
                break;
            case 2:
                bVar.gBb.setVisibility(8);
                bVar.gvr.setVisibility(0);
                bVar.gvr.setText(R.string.c15);
                bVar.gvr.setTextColor(this.context.getResources().getColor(R.color.ea));
                break;
        }
        Bitmap pS = com.tencent.mm.ah.b.pS(gVar.dtU);
        if (pS == null) {
            bVar.eks.setImageDrawable(com.tencent.mm.bz.a.g(this.context, R.raw.default_avatar));
        } else {
            bVar.eks.setImageBitmap(pS);
        }
        AppMethodBeat.o(124805);
        return view;
    }
}
