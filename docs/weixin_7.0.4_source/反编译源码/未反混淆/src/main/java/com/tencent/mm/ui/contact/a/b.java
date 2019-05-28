package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.a.a;

public final class b extends f {
    public String bCu;
    public int resId = 0;
    private boolean zpE;

    public b(int i) {
        super(i);
    }

    public final void a(Context context, a aVar) {
        AppMethodBeat.i(105269);
        if (this.resId == 0 || this.bCu == null) {
            ad adVar = this.ehM;
            if (!this.zpE) {
                g.RQ();
                adVar = ((j) g.K(j.class)).XM().aoO(this.username);
                this.ehM = adVar;
                this.zpE = true;
            }
            ad adVar2 = adVar;
            if (adVar2 == null) {
                this.gnx = "";
                AppMethodBeat.o(105269);
                return;
            }
            this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).c(adVar2), com.tencent.mm.bz.a.al(context, R.dimen.m5));
            this.username = adVar2.field_username;
            AppMethodBeat.o(105269);
            return;
        }
        this.zpV = this.resId;
        this.zpU = this.bCu;
        AppMethodBeat.o(105269);
    }
}
