package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.e.b;

public final class a extends e {
    private a oHY = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(54182);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ahu, viewGroup, false);
            com.tencent.mm.ui.contact.a.e.a aVar = (com.tencent.mm.ui.contact.a.e.a) a.a(a.this);
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.contentView = inflate.findViewById(R.id.de9);
            aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            inflate.setTag(aVar);
            AppMethodBeat.o(54182);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(54183);
            com.tencent.mm.ui.contact.a.e.a aVar3 = (com.tencent.mm.ui.contact.a.e.a) aVar;
            e eVar = (e) aVar2;
            if (eVar.username == null || eVar.username.length() <= 0) {
                aVar3.ejo.setImageResource(R.drawable.ad2);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, eVar.username);
            }
            m.a(eVar.gnx, aVar3.gnB);
            if (a.this.zmW) {
                if (z) {
                    aVar3.gnD.setChecked(true);
                    aVar3.gnD.setEnabled(false);
                } else {
                    aVar3.gnD.setChecked(z2);
                    aVar3.gnD.setEnabled(true);
                }
                aVar3.gnD.setVisibility(0);
                AppMethodBeat.o(54183);
                return;
            }
            aVar3.gnD.setVisibility(8);
            AppMethodBeat.o(54183);
        }
    }

    static /* synthetic */ com.tencent.mm.ui.contact.a.a.a a(a aVar) {
        AppMethodBeat.i(54185);
        com.tencent.mm.ui.contact.a.a.a clJ = aVar.clJ();
        AppMethodBeat.o(54185);
        return clJ;
    }

    public a(int i) {
        super(i);
        AppMethodBeat.i(54184);
        AppMethodBeat.o(54184);
    }

    public final com.tencent.mm.ui.contact.a.a.b aou() {
        return this.oHY;
    }
}
