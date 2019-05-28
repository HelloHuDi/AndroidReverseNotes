package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.o;

public final class d extends o implements b {
    private Cursor gnQ;
    private String jMp;
    private int pUv;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        AppMethodBeat.i(30242);
        ab.i("MicroMsg.RecentConversationAdapter", "create!");
        this.jMp = str;
        Km();
        AppMethodBeat.o(30242);
    }

    private void Km() {
        AppMethodBeat.i(30243);
        ab.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        this.gnQ = z.aeU().rn(this.jMp);
        this.pUv = 0;
        AppMethodBeat.o(30243);
    }

    public final int getCount() {
        AppMethodBeat.i(30244);
        int count = this.gnQ.getCount() + 1;
        AppMethodBeat.o(30244);
        return count;
    }

    public final a mP(int i) {
        AppMethodBeat.i(30245);
        a aVar = null;
        if (i == this.pUv) {
            aVar = new h(i);
            aVar.mKQ = this.zmV.getActivity().getResources().getString(R.string.e1t);
        } else if (i <= this.pUv || !this.gnQ.moveToPosition((i - this.pUv) - 1)) {
            ab.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            aVar = new a(i);
            com.tencent.mm.aj.a.a aVar2 = new com.tencent.mm.aj.a.a();
            aVar2.d(this.gnQ);
            if (aVar.jMj == -1) {
                aVar.jMj = aVar2.field_bizChatId;
                c aK = z.aeT().aK(aVar2.field_bizChatId);
                if (aK.isGroup()) {
                    aVar.gnx = aK.field_chatName;
                    aVar.yDO = aK.field_headImageUrl;
                    aVar.username = aK.field_brandUserName;
                } else {
                    j cH = z.aeV().cH(aK.field_bizChatServId);
                    if (cH != null) {
                        aVar.gnx = cH.field_userName;
                        aVar.yDO = cH.field_headImageUrl;
                        aVar.username = cH.field_brandUserName;
                    }
                }
                if (bo.ac(aVar.gnx)) {
                    aVar.gnx = this.zmV.getActivity().getResources().getString(R.string.dso);
                }
                if (bo.isNullOrNil(aVar.username)) {
                    aVar.username = aVar2.field_brandUserName;
                }
            }
        }
        AppMethodBeat.o(30245);
        return aVar;
    }

    public final void finish() {
        AppMethodBeat.i(30246);
        super.finish();
        ab.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.gnQ != null) {
            this.gnQ.close();
            this.gnQ = null;
        }
        AppMethodBeat.o(30246);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(30247);
        Km();
        notifyDataSetChanged();
        AppMethodBeat.o(30247);
    }
}
