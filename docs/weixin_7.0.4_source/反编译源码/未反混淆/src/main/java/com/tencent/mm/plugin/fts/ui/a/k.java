package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class k extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String mKQ;
    private b mKR = new b();
    private a mKS = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public TextView kxr;
        public View mKk;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62005);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1i, viewGroup, false);
            a aVar = (a) k.this.bBi();
            aVar.kxr = (TextView) inflate.findViewById(R.id.aw4);
            aVar.mKk = inflate.findViewById(R.id.it);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(62005);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62006);
            a aVar3 = (a) aVar;
            m.b(k.this.mKQ, aVar3.kxr);
            if (k.this.position == 0) {
                aVar3.mKk.setVisibility(8);
            } else {
                aVar3.mKk.setVisibility(0);
            }
            m.q(aVar3.contentView, k.this.mFk);
            AppMethodBeat.o(62006);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public k(int i) {
        super(0, i);
        AppMethodBeat.i(62007);
        AppMethodBeat.o(62007);
    }

    public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62008);
        this.mKQ = bo.bc(m.wf(this.mFl), "");
        ab.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", this.mKQ);
        AppMethodBeat.o(62008);
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKR;
    }

    public com.tencent.mm.plugin.fts.a.d.a.a.a bBi() {
        return this.mKS;
    }
}
