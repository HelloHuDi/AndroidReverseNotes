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
import java.util.List;

public final class h extends o {
    private Cursor gnQ = ((j) g.K(j.class)).XM().ew(this.zmn);
    private List<String> zmn;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        AppMethodBeat.i(105204);
        this.zmn = list;
        g.RQ();
        AppMethodBeat.o(105204);
    }

    public final int getCount() {
        AppMethodBeat.i(105205);
        int count = this.gnQ.getCount();
        AppMethodBeat.o(105205);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    public final a mP(int i) {
        AppMethodBeat.i(105206);
        a aVar = null;
        if (i < 0 || !this.gnQ.moveToPosition(i)) {
            ab.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            aVar = new e(i);
            ad adVar = new ad();
            adVar.d(this.gnQ);
            aVar.ehM = adVar;
            aVar.zmW = clI();
        }
        AppMethodBeat.o(105206);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(105207);
        super.finish();
        ab.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.o(105207);
    }
}
