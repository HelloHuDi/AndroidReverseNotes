package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class k extends a {
    private a zqk = new a();
    b zql = new b();

    public class a extends com.tencent.mm.ui.contact.a.a.b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(105303);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ar6, viewGroup, false);
            b bVar = k.this.zql;
            bVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            bVar.contentView = inflate.findViewById(R.id.de9);
            bVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            inflate.setTag(bVar);
            AppMethodBeat.o(105303);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105304);
            b bVar = (b) aVar;
            bVar.gnB.setText(R.string.e1k);
            bVar.gnD.setBackgroundResource(R.drawable.ud);
            bVar.gnD.setChecked(z2);
            bVar.gnD.setEnabled(true);
            bVar.gnD.setVisibility(0);
            bVar.contentView.setBackgroundResource(R.drawable.k7);
            AppMethodBeat.o(105304);
        }

        public final boolean aov() {
            return false;
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.a {
        public View contentView;
        public TextView gnB;
        public CheckBox gnD;

        public b() {
            super();
        }
    }

    public k(int i) {
        super(7, i);
        AppMethodBeat.i(105305);
        AppMethodBeat.o(105305);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zqk;
    }
}
