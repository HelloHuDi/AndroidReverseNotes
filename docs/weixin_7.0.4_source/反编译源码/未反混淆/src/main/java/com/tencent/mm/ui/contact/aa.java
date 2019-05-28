package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import java.util.ArrayList;

public final class aa extends o {
    private Cursor gnQ = ((j) g.K(j.class)).XM().d(this.zjx, "", this.elZ);
    private String zjx;

    public aa(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, new ArrayList(), false, false);
        AppMethodBeat.i(105265);
        this.zjx = str;
        g.RQ();
        AppMethodBeat.o(105265);
    }

    public final int getCount() {
        AppMethodBeat.i(105266);
        int count = this.gnQ.getCount();
        AppMethodBeat.o(105266);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    public final a mP(int i) {
        AppMethodBeat.i(105267);
        a aVar = null;
        if (i < 0 || !this.gnQ.moveToPosition(i)) {
            ab.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            aVar = new e(i);
            ad adVar = new ad();
            adVar.d(this.gnQ);
            aVar.ehM = adVar;
            aVar.zmW = clI();
        }
        AppMethodBeat.o(105267);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(105268);
        super.finish();
        ab.i("MicroMsg.SpecialContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.o(105268);
    }
}
