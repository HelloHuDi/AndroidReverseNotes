package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.api.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.m.a;
import java.util.List;

public final class p extends q {
    private Cursor gnQ;
    private ak handler = new ak(Looper.getMainLooper());
    private String jMp;
    private String query;
    private a zmU;
    private List<String> znn = null;

    public p(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        AppMethodBeat.i(105225);
        this.jMp = str;
        ab.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Kh();
        AppMethodBeat.o(105225);
    }

    public final void a(a aVar) {
        this.zmU = aVar;
    }

    public final void ci(String str, boolean z) {
        AppMethodBeat.i(105226);
        if (this.zmU != null) {
            this.zmU.w(str, getCount(), z);
        }
        AppMethodBeat.o(105226);
    }

    private void Kh() {
        AppMethodBeat.i(105227);
        ab.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.query = null;
        clearCache();
        AppMethodBeat.o(105227);
    }

    public final int getCount() {
        AppMethodBeat.i(105228);
        if (this.gnQ == null) {
            AppMethodBeat.o(105228);
            return 0;
        }
        int count = this.gnQ.getCount();
        AppMethodBeat.o(105228);
        return count;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(105229);
        com.tencent.mm.ui.contact.a.a aVar = null;
        if (i < 0 || !this.gnQ.moveToPosition(i)) {
            ab.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            com.tencent.mm.ui.contact.a.a aVar2 = new com.tencent.mm.ui.bizchat.a(i);
            c cVar = new c();
            cVar.d(this.gnQ);
            if (aVar2.jMj == -1) {
                aVar2.jMj = cVar.field_bizChatLocalId;
                if (cVar.isGroup()) {
                    aVar2.gnx = cVar.field_chatName;
                    aVar2.yDO = cVar.field_headImageUrl;
                    aVar2.username = cVar.field_brandUserName;
                } else {
                    j cH = ((i) g.K(i.class)).cH(cVar.field_bizChatServId);
                    if (cH != null) {
                        aVar2.gnx = cH.field_userName;
                        aVar2.yDO = cH.field_headImageUrl;
                        aVar2.username = cH.field_brandUserName;
                    }
                }
                if (bo.ac(aVar2.gnx)) {
                    aVar2.gnx = this.zmV.getActivity().getResources().getString(R.string.e1q);
                }
                if (bo.isNullOrNil(aVar2.username)) {
                    aVar2.username = cVar.field_brandUserName;
                }
            }
            aVar = aVar2;
        }
        AppMethodBeat.o(105229);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(105230);
        super.finish();
        ab.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Kh();
        AppMethodBeat.o(105230);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
