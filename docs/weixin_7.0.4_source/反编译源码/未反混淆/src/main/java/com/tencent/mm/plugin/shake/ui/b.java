package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

final class b extends p<bt> {
    private MMActivity crP;
    protected g jJO;
    protected c jJP;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();
    private int limit = -1;
    protected f oQS;
    private bu qui;

    static class a {
        ImageView eks;
        TextView gtG;
        View jJW;
        TextView jJX;
        TextView ooM;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(24706);
        bt btVar = (bt) obj;
        if (btVar == null) {
            btVar = new bt();
        }
        btVar.d(cursor);
        AppMethodBeat.o(24706);
        return btVar;
    }

    public b(Context context, bu buVar, int i) {
        super(context, new bt());
        AppMethodBeat.i(24701);
        this.crP = (MMActivity) context;
        this.limit = i;
        this.qui = buVar;
        AppMethodBeat.o(24701);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.oQS = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public final void CA(int i) {
        AppMethodBeat.i(24702);
        bIf();
        this.limit = i;
        KC();
        AppMethodBeat.o(24702);
    }

    public final void KD() {
        AppMethodBeat.i(24703);
        KC();
        AppMethodBeat.o(24703);
    }

    public final void KC() {
        AppMethodBeat.i(24704);
        setCursor(this.qui.xm(this.limit));
        super.notifyDataSetChanged();
        AppMethodBeat.o(24704);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(24705);
        bt btVar = (bt) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.crP, R.layout.g8, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.crP, R.layout.ap4, null);
            aVar2.eks = (ImageView) inflate.findViewById(R.id.bo3);
            aVar2.gtG = (TextView) inflate.findViewById(R.id.e4_);
            aVar2.ooM = (TextView) inflate.findViewById(R.id.e4a);
            aVar2.jJW = view2.findViewById(R.id.a4b);
            aVar2.jJX = (TextView) view2.findViewById(R.id.nu);
            view2.setView(inflate);
            view2.setPerformItemClickListener(this.jJO);
            view2.setGetViewPositionCallback(this.jJP);
            view2.setItemStatusCallBack(this.jJR);
            view2.setEnable(false);
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jJW.setTag(Long.valueOf(btVar.field_svrid));
        aVar.jJW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(24700);
                ab.v("MicroMsg.SayHiAdapter", "on delView clicked");
                b.this.jJR.bIq();
                if (b.this.oQS != null) {
                    b.this.oQS.bN(view.getTag());
                }
                AppMethodBeat.o(24700);
            }
        });
        aVar.gtG.setText(j.b(this.crP, bi.d.apF(btVar.field_content).getDisplayName(), aVar.gtG.getTextSize()));
        aVar.ooM.setText(btVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.b(aVar.eks, btVar.field_sayhiuser);
        AppMethodBeat.o(24705);
        return view;
    }
}
