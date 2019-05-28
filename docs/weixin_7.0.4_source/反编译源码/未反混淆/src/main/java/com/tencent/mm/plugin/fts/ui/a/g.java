package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.a.m.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends m {
    private a mKy = new a();
    CharSequence mKz;

    public class a extends b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61986);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1t, viewGroup, false);
            com.tencent.mm.plugin.fts.ui.a.m.a aVar = g.this.mLb;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.ejp = (TextView) inflate.findViewById(R.id.b6e);
            aVar.ene = (TextView) inflate.findViewById(R.id.b01);
            aVar.contentView = inflate.findViewById(R.id.qj);
            aVar.enf = (TextView) inflate.findViewById(R.id.la);
            aVar.ejo.getLayoutParams().width = com.tencent.mm.bz.a.al(context, R.dimen.n3);
            aVar.ejo.getLayoutParams().height = com.tencent.mm.bz.a.al(context, R.dimen.n3);
            inflate.setTag(aVar);
            AppMethodBeat.o(61986);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61987);
            g gVar = (g) aVar2;
            com.tencent.mm.plugin.fts.ui.a.m.a aVar3 = (com.tencent.mm.plugin.fts.ui.a.m.a) aVar;
            m.p(aVar3.contentView, g.this.mFk);
            if (bo.isNullOrNil(gVar.hpS.talker)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, gVar.hpS.mDx);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, gVar.hpS.talker);
            }
            m.a(gVar.mKz, aVar3.ejp);
            m.a(gVar.gny, aVar3.ene);
            m.a(gVar.mKZ, aVar3.enf);
            AppMethodBeat.o(61987);
        }
    }

    public g(int i) {
        super(i);
        AppMethodBeat.i(61988);
        AppMethodBeat.o(61988);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKy;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61989);
        super.a(context, aVar, objArr);
        CharSequence LC = d.LC(this.hpS.talker);
        if (bo.isNullOrNil(LC)) {
            LC = d.LC(this.hpS.mDx);
        }
        this.mKz = j.d(context, LC, (float) c.mHy);
        AppMethodBeat.o(61989);
    }
}
