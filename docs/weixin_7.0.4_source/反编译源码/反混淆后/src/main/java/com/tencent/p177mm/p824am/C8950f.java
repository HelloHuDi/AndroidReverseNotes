package com.tencent.p177mm.p824am;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7310be.C5133b;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.am.f */
public final class C8950f extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16434);
        C4990ab.m7411d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            C7060h.pYm.mo15419k(336, 14, 1);
            C9638aw.m17190ZK();
            C7480h Ru = C18628c.m29069Ru();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username from rconversation, rcontact, bizinfo where rconversation.username = rcontact.username and rconversation.username = bizinfo.username and ( rcontact.verifyFlag & 8").append(" ) != 0 ");
            C4990ab.m7411d("MicroMsg.ConversationDataTransfer", "select sql %s", stringBuilder.toString());
            Cursor a = Ru.mo10104a(r1, null, 2);
            if (a != null && a.moveToFirst()) {
                C7617ak c7617ak;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = a.getString(0);
                    if (!C1855t.m3921nG(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (a.moveToNext());
                a.close();
                C4990ab.m7411d("MicroMsg.ConversationDataTransfer", "changed[%B] execute sql[%s]", Boolean.TRUE, stringBuilder.toString());
                Ru.mo10108hY("rconversation", r1);
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ("officialaccounts");
                if (aoZ == null) {
                    aoZ = new C7617ak("officialaccounts");
                    aoZ.dsI();
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15807d(aoZ);
                    c7617ak = aoZ;
                } else {
                    c7617ak = aoZ;
                }
                C9638aw.m17190ZK();
                String dsR = C18628c.m29083XR().dsR();
                if (C5046bo.isNullOrNil(dsR)) {
                    C4990ab.m7420w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    AppMethodBeat.m2505o(16434);
                    return;
                }
                C9638aw.m17190ZK();
                C7620bi Rb = C18628c.m29080XO().mo15248Rb(dsR);
                if (Rb == null || Rb.field_msgId == 0) {
                    C4990ab.m7420w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    AppMethodBeat.m2505o(16434);
                    return;
                }
                c7617ak.mo17068ap(Rb);
                c7617ak.setContent(Rb.field_talker + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + Rb.field_content);
                c7617ak.mo14757jg(Integer.toString(Rb.getType()));
                C9638aw.m17190ZK();
                C5133b Cb = C18628c.m29083XR().mo15765Cb();
                if (Cb != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Rb.mo14794ju("officialaccounts");
                    Rb.setContent(c7617ak.field_content);
                    Cb.mo10533a(Rb, pString, pString2, pInt, false);
                    c7617ak.mo14758jh(pString.value);
                    c7617ak.mo14759ji(pString2.value);
                    c7617ak.mo14751hP(pInt.value);
                }
                C9638aw.m17190ZK();
                C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
            }
            if (!(a == null || a.isClosed())) {
                a.close();
            }
        }
        AppMethodBeat.m2505o(16434);
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
