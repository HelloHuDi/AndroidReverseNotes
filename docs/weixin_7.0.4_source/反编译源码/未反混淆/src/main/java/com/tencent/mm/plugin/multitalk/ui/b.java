package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class b extends q {
    private String chatroomName;
    private String[] gnP;
    private Cursor gnQ;
    private String query;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        AppMethodBeat.i(54177);
        this.chatroomName = str;
        List oe = ((c) g.K(c.class)).XV().oe(this.chatroomName);
        if (oe != null) {
            this.gnP = bo.ej(oe);
        }
        AppMethodBeat.o(54177);
    }

    public final void a(String str, int[] iArr, boolean z) {
        AppMethodBeat.i(54178);
        ab.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", str);
        clearCache();
        this.query = str;
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        if (!(bo.isNullOrNil(this.query) || this.gnP == null)) {
            this.gnQ = ((j) g.K(j.class)).XM().a(this.gnP, "@all.chatroom", this.query, null, null);
        }
        notifyDataSetChanged();
        ci(str, true);
        AppMethodBeat.o(54178);
    }

    public final a mP(int i) {
        AppMethodBeat.i(54179);
        a aVar = null;
        if (this.gnQ.moveToPosition(i)) {
            ad adVar = new ad();
            adVar.d(this.gnQ);
            aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
            aVar.ehM = adVar;
            aVar.zmW = clI();
            aVar.query = this.query;
        }
        AppMethodBeat.o(54179);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(54180);
        super.finish();
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.o(54180);
    }

    public final int getCount() {
        AppMethodBeat.i(54181);
        if (this.gnQ == null) {
            AppMethodBeat.o(54181);
            return 0;
        }
        int count = this.gnQ.getCount();
        AppMethodBeat.o(54181);
        return count;
    }
}
