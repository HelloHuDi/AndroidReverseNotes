package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.f.b;

public final class d extends f {
    public ad ehM;
    public CharSequence zpK;
    public boolean zpL;
    private a zpM = new a();

    class a extends b {
        a() {
            super();
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(105276);
            super.a(context, aVar, aVar2, z, z2);
            com.tencent.mm.ui.contact.a.f.a aVar3 = (com.tencent.mm.ui.contact.a.f.a) aVar;
            if (bo.ac(d.this.zpK)) {
                aVar3.gnC.setVisibility(8);
                AppMethodBeat.o(105276);
                return;
            }
            aVar3.gnC.setVisibility(0);
            d.this.zpK = j.b(context, d.this.zpK, com.tencent.mm.bz.a.al(context, R.dimen.m5));
            aVar3.gnC.setText(aVar3.gnC.getContext().getResources().getString(d.this.zpL ? R.string.ave : R.string.avd, new Object[]{d.this.zpK}));
            AppMethodBeat.o(105276);
        }
    }

    public d(int i, ad adVar) {
        boolean z = true;
        super(i);
        AppMethodBeat.i(105277);
        this.ehM = adVar;
        if (adVar.dtS != 1) {
            z = false;
        }
        this.zpL = z;
        AppMethodBeat.o(105277);
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar) {
        boolean z = true;
        AppMethodBeat.i(105278);
        super.a(context, aVar);
        if (this.ehM.dtS != 1) {
            z = false;
        }
        this.zpL = z;
        this.zpK = ((c) g.K(c.class)).XV().ob(this.ehM.field_username).mJ(this.ehM.field_username);
        AppMethodBeat.o(105278);
    }

    public final a.b aou() {
        return this.zpM;
    }
}
