package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.m;

public final class l extends com.tencent.mm.plugin.fts.a.d.a.a {
    CharSequence mKU;
    private com.tencent.mm.plugin.fts.a.d.a.a.b mKV = new b();
    com.tencent.mm.plugin.fts.a.d.a.a.a mKW = new a();

    public class a extends com.tencent.mm.plugin.fts.a.d.a.a.a {
        public View mKk;
        public TextView mKx;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.d.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(62009);
            View inflate = LayoutInflater.from(context).inflate(R.layout.a1j, viewGroup, false);
            a aVar = (a) l.this.mKW;
            aVar.mKx = (TextView) inflate.findViewById(R.id.by7);
            aVar.mKk = inflate.findViewById(R.id.it);
            inflate.setTag(aVar);
            AppMethodBeat.o(62009);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(62010);
            a aVar3 = (a) aVar;
            m.a(l.this.mKU, aVar3.mKx);
            if (l.this.position == 0) {
                aVar3.mKk.setVisibility(8);
                AppMethodBeat.o(62010);
                return;
            }
            aVar3.mKk.setVisibility(0);
            AppMethodBeat.o(62010);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            return false;
        }
    }

    public l(int i) {
        super(18, i);
        AppMethodBeat.i(62011);
        AppMethodBeat.o(62011);
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a.b Ps() {
        return this.mKV;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        AppMethodBeat.i(62012);
        String charSequence = TextUtils.ellipsize(this.mDz.mDY, c.mHz, 400.0f, TruncateAt.MIDDLE).toString();
        this.mKU = f.a(context.getString(R.string.dzw), context.getString(R.string.dzv), d.b(charSequence, charSequence)).mDR;
        AppMethodBeat.o(62012);
    }
}
