package com.tencent.p177mm.plugin.card.p1243c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.card.model.C27587c;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.card.c.a */
public final class C20129a implements C33762b {
    public final boolean bbn() {
        AppMethodBeat.m2504i(87965);
        boolean beC = C38736l.beC();
        AppMethodBeat.m2505o(87965);
        return beC;
    }

    public final boolean bbo() {
        AppMethodBeat.m2504i(87966);
        boolean beE = C38736l.beE();
        AppMethodBeat.m2505o(87966);
        return beE;
    }

    public final String bbp() {
        AppMethodBeat.m2504i(87967);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null);
        AppMethodBeat.m2505o(87967);
        return str;
    }

    public final int bbq() {
        int i = 0;
        AppMethodBeat.m2504i(87968);
        C27587c baW = C42852am.baW();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) and (block_mask= '1' OR block_mask= '0' )");
        Cursor a = baW.bSd.mo10104a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        C4990ab.m7416i("MicroMsg.CardMgrImpl", "getGiftCardCount:".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(87968);
        return i;
    }

    /* renamed from: sP */
    public final boolean mo35386sP(int i) {
        AppMethodBeat.m2504i(87969);
        boolean sP = C38736l.m65733sP(i);
        AppMethodBeat.m2505o(87969);
        return sP;
    }
}
