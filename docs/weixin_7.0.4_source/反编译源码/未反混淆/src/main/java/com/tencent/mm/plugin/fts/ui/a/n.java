package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ab;

public class n extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String mLd;
    private b mLe = new b();
    private a mLf = new a();

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62018);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1u, viewGroup, false);
            a aVar = new a();
            aVar.mJS = (TextView) inflate.findViewById(R.id.n0);
            aVar.iqT = (ImageView) inflate.findViewById(R.id.rq);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(62018);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62019);
            a aVar3 = (a) aVar;
            n nVar = (n) aVar2;
            m.p(aVar3.contentView, n.this.mFk);
            aVar3.mJS.setText(nVar.mLd);
            aVar3.iqT.setImageResource(R.raw.fts_more_button_icon);
            AppMethodBeat.o(62019);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(62020);
            Intent intent = new Intent();
            intent.putExtra("detail_query", n.this.mDz.mDY);
            intent.putExtra("detail_type", n.this.mFl);
            intent.putExtra("Search_Scene", n.this.mFa);
            d.c(context, ".ui.FTSDetailUI", intent);
            AppMethodBeat.o(62020);
            return true;
        }
    }

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        public a() {
            super();
        }
    }

    public n(int i) {
        super(12, i);
        AppMethodBeat.i(62021);
        AppMethodBeat.o(62021);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62022);
        if (m.wf(this.mFl) == null) {
            this.mLd = "";
        } else {
            this.mLd = context.getResources().getString(R.string.dzq, new Object[]{r0});
        }
        ab.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", this.mLd);
        AppMethodBeat.o(62022);
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mLe;
    }
}
