package com.tencent.mm.plugin.card.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a implements b {
    public final boolean bbn() {
        AppMethodBeat.i(87965);
        boolean beC = l.beC();
        AppMethodBeat.o(87965);
        return beC;
    }

    public final boolean bbo() {
        AppMethodBeat.i(87966);
        boolean beE = l.beE();
        AppMethodBeat.o(87966);
        return beE;
    }

    public final String bbp() {
        AppMethodBeat.i(87967);
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null);
        AppMethodBeat.o(87967);
        return str;
    }

    public final int bbq() {
        int i = 0;
        AppMethodBeat.i(87968);
        c baW = am.baW();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
        Cursor a = baW.bSd.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        ab.i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i)));
        AppMethodBeat.o(87968);
        return i;
    }

    public final boolean sP(int i) {
        AppMethodBeat.i(87969);
        boolean sP = l.sP(i);
        AppMethodBeat.o(87969);
        return sP;
    }
}
