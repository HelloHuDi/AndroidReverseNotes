package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.m;

public final class i extends a {
    private CharSequence mKU;
    private b zqf = new b();
    com.tencent.mm.ui.contact.a.a.a zqg = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView mKx;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(105296);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ar4, viewGroup, false);
            a aVar = (a) i.this.zqg;
            aVar.mKx = (TextView) inflate.findViewById(R.id.by7);
            inflate.setTag(aVar);
            AppMethodBeat.o(105296);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105297);
            m.a(i.this.mKU, ((a) aVar).mKx);
            AppMethodBeat.o(105297);
        }

        public final boolean aov() {
            return false;
        }
    }

    public i(int i) {
        super(6, i);
        AppMethodBeat.i(105298);
        AppMethodBeat.o(105298);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(105299);
        this.mKU = f.a(context.getString(R.string.dzw), context.getString(R.string.dzv), d.b(this.query, this.query)).mDR;
        AppMethodBeat.o(105299);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zqf;
    }
}
