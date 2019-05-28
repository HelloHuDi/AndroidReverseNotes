package com.tencent.mm.plugin.aa.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class d extends o {
    private String chatroomName;
    private List<String> gnO = h.vE(this.chatroomName);

    public d(l lVar, String str) {
        super(lVar, null, true, true);
        AppMethodBeat.i(40767);
        this.chatroomName = str;
        ab.i("MicroMsg.AASelectInitAdapter", "resetData");
        AppMethodBeat.o(40767);
    }

    public final a mP(int i) {
        AppMethodBeat.i(40768);
        String str = (String) this.gnO.get(i);
        g.RQ();
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        c cVar = new c(i);
        cVar.cuP = this.chatroomName;
        cVar.ehM = aoO;
        cVar.zmW = true;
        AppMethodBeat.o(40768);
        return cVar;
    }

    public final int getCount() {
        AppMethodBeat.i(40769);
        int size = this.gnO.size();
        AppMethodBeat.o(40769);
        return size;
    }
}
