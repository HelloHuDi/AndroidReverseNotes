package com.tencent.mm.am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bi;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class f extends ai {
    public final boolean kw(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        AppMethodBeat.i(16434);
        ab.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            h.pYm.k(336, 14, 1);
            aw.ZK();
            com.tencent.mm.cd.h Ru = c.Ru();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
            ab.d("MicroMsg.ConversationDataTransfer", "select sql %s", stringBuilder.toString());
            Cursor a = Ru.a(r1, null, 2);
            if (a != null && a.moveToFirst()) {
                ak akVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = a.getString(0);
                    if (!t.nG(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (a.moveToNext());
                a.close();
                ab.d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", Boolean.TRUE, stringBuilder.toString());
                Ru.hY("rconversation", r1);
                aw.ZK();
                ak aoZ = c.XR().aoZ("officialaccounts");
                if (aoZ == null) {
                    aoZ = new ak("officialaccounts");
                    aoZ.dsI();
                    aw.ZK();
                    c.XR().d(aoZ);
                    akVar = aoZ;
                } else {
                    akVar = aoZ;
                }
                aw.ZK();
                String dsR = c.XR().dsR();
                if (bo.isNullOrNil(dsR)) {
                    ab.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    AppMethodBeat.o(16434);
                    return;
                }
                aw.ZK();
                bi Rb = c.XO().Rb(dsR);
                if (Rb == null || Rb.field_msgId == 0) {
                    ab.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    AppMethodBeat.o(16434);
                    return;
                }
                akVar.ap(Rb);
                akVar.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                akVar.jg(Integer.toString(Rb.getType()));
                aw.ZK();
                b Cb = c.XR().Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.ju("officialaccounts");
                    Rb.setContent(akVar.field_content);
                    Cb.a(Rb, pString, pString2, pInt, false);
                    akVar.jh(pString.value);
                    akVar.ji(pString2.value);
                    akVar.hP(pInt.value);
                }
                aw.ZK();
                c.XR().a(akVar, akVar.field_username);
            }
            if (!(a == null || a.isClosed())) {
                a.close();
            }
        }
        AppMethodBeat.o(16434);
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
