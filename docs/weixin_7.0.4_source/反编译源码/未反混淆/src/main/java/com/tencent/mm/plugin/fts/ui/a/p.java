package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.m.b;

public final class p extends m {
    public l mKp;
    private a mLj = new a();
    public int showType;

    public class a extends b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62026);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1t, viewGroup, false);
            com.tencent.mm.plugin.fts.ui.a.m.a aVar = p.this.mLb;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.ejp = (TextView) inflate.findViewById(R.id.b6e);
            aVar.ene = (TextView) inflate.findViewById(R.id.b01);
            aVar.contentView = inflate.findViewById(R.id.qj);
            aVar.enf = (TextView) inflate.findViewById(R.id.la);
            aVar.ejo.getLayoutParams().width = com.tencent.mm.bz.a.al(context, R.dimen.n3);
            aVar.ejo.getLayoutParams().height = com.tencent.mm.bz.a.al(context, R.dimen.n3);
            inflate.setTag(aVar);
            AppMethodBeat.o(62026);
            return inflate;
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62027);
            boolean a = ((n) g.M(n.class)).getItemClickHandler(p.this.klY).a(context, aVar);
            AppMethodBeat.o(62027);
            return a;
        }
    }

    public p(int i) {
        super(i);
        AppMethodBeat.i(62028);
        AppMethodBeat.o(62028);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLj;
    }

    public final int bAw() {
        if (this.mKY < 2) {
            return 0;
        }
        return 2;
    }
}
