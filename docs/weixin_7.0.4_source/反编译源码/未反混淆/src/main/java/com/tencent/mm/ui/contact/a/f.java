package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;

public class f extends a {
    public CharSequence gnx;
    public String username;
    public CharSequence zpU;
    public int zpV = 0;
    private b zpW = new b();
    a zpX = new a();

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView ejo;
        public TextView ejp;
        public TextView gnC;
        public CheckBox gnD;

        public a() {
            super();
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        public b() {
            super();
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(105285);
            if (com.tencent.mm.bz.a.ga(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar1, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.ar0, viewGroup, false);
            }
            a aVar = f.this.zpX;
            aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
            aVar.ejp = (TextView) inflate.findViewById(R.id.qm);
            aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
            aVar.gnC.setVisibility(8);
            aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
            inflate.setTag(aVar);
            AppMethodBeat.o(105285);
            return inflate;
        }

        public void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105286);
            f fVar = (f) aVar2;
            a aVar3 = (a) aVar;
            aVar3.ejp.setCompoundDrawables(null, null, null, null);
            if (f.this.zpV == 0 || f.this.zpU == null) {
                m.a(fVar.gnx, aVar3.ejp);
                if (ad.aox(fVar.username)) {
                    g.RQ();
                    ad aoO = ((j) g.K(j.class)).XM().aoO(fVar.username);
                    ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(context, aVar3.ejp, fVar.gnx, aoO.field_openImAppid, aoO.field_descWordingId, (int) aVar3.ejp.getTextSize());
                }
                com.tencent.mm.pluginsdk.ui.a.b.b(aVar3.ejo, fVar.username);
                if (t.mP(fVar.username)) {
                    Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    aVar3.ejp.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                } else {
                    aVar3.ejp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }
                if (f.this.zmW) {
                    if (z) {
                        aVar3.gnD.setChecked(true);
                        aVar3.gnD.setEnabled(false);
                    } else {
                        aVar3.gnD.setChecked(z2);
                        aVar3.gnD.setEnabled(true);
                    }
                    aVar3.gnD.setVisibility(0);
                    AppMethodBeat.o(105286);
                    return;
                }
                aVar3.gnD.setVisibility(8);
                AppMethodBeat.o(105286);
                return;
            }
            aVar3.ejo.setImageResource(f.this.zpV);
            aVar3.ejp.setText(f.this.zpU);
            AppMethodBeat.o(105286);
        }

        public final boolean aov() {
            return false;
        }
    }

    public f(int i) {
        super(4, i);
        AppMethodBeat.i(105287);
        AppMethodBeat.o(105287);
    }

    public void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        AppMethodBeat.i(105288);
        if (this.zpV != 0 && this.zpU != null) {
            AppMethodBeat.o(105288);
        } else if (this.ehM == null) {
            this.gnx = "";
            this.username = "";
            AppMethodBeat.o(105288);
        } else {
            this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).c(this.ehM), com.tencent.mm.bz.a.al(context, R.dimen.m5));
            this.username = this.ehM.field_username;
            AppMethodBeat.o(105288);
        }
    }

    public com.tencent.mm.ui.contact.a.a.b aou() {
        return this.zpW;
    }
}
