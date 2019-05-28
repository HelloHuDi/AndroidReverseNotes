package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;

public final class h extends a {
    public String mKQ;
    private b zqc = new b();
    a zqd = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView kxr;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(105293);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ar3, viewGroup, false);
            a aVar = h.this.zqd;
            aVar.kxr = (TextView) inflate.findViewById(R.id.aw4);
            inflate.setTag(aVar);
            AppMethodBeat.o(105293);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105294);
            m.b(((h) aVar2).mKQ, ((a) aVar).kxr);
            AppMethodBeat.o(105294);
        }

        public final boolean aov() {
            return false;
        }
    }

    public h(int i) {
        super(0, i);
        AppMethodBeat.i(105295);
        AppMethodBeat.o(105295);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zqc;
    }
}
