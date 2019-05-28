package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.m;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence mJP;
    private b mJQ = new b();
    private a mJR = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View contentView;
        public ImageView iqT;
        public TextView mJS;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(61968);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1w, viewGroup, false);
            a aVar = new a();
            aVar.iqT = (ImageView) inflate.findViewById(R.id.rq);
            aVar.mJS = (TextView) inflate.findViewById(R.id.n0);
            aVar.contentView = inflate.findViewById(R.id.qj);
            inflate.setTag(aVar);
            AppMethodBeat.o(61968);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(61969);
            a aVar3 = (a) aVar;
            m.p(aVar3.contentView, a.this.mFk);
            m.a(a.this.mJP, aVar3.mJS);
            aVar3.iqT.setImageResource(R.raw.search_add_icon_green);
            AppMethodBeat.o(61969);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public a(int i) {
        super(10, i);
        AppMethodBeat.i(61970);
        AppMethodBeat.o(61970);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(61971);
        this.mJP = f.a(context.getResources().getString(R.string.c1e), "", d.b(this.mDz.mDY, this.mDz.mDY)).mDR;
        AppMethodBeat.o(61971);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mJQ;
    }
}
