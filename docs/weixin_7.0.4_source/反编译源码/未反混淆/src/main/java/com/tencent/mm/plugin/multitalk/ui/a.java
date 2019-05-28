package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a extends o {
    private String chatroomName;
    private List<String> gnO = ((c) g.K(c.class)).XV().oe(this.chatroomName);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        AppMethodBeat.i(54174);
        this.chatroomName = str;
        ab.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        if (this.gnO == null) {
            this.gnO = new ArrayList();
        }
        AppMethodBeat.o(54174);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(54175);
        ad aoO = ((j) g.K(j.class)).XM().aoO((String) this.gnO.get(i));
        com.tencent.mm.plugin.multitalk.ui.widget.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.ehM = aoO;
        aVar.zmW = clI();
        AppMethodBeat.o(54175);
        return aVar;
    }

    public final int getCount() {
        AppMethodBeat.i(54176);
        int size = this.gnO.size();
        AppMethodBeat.o(54176);
        return size;
    }
}
