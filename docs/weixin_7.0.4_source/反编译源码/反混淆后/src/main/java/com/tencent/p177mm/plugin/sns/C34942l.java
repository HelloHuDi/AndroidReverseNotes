package com.tencent.p177mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C26485p;
import com.tencent.p177mm.modelstat.C26485p.C1876a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.sns.l */
public final class C34942l implements C46210i {
    /* renamed from: b */
    public final void mo55532b(String str, C32831d c32831d) {
        AppMethodBeat.m2504i(35628);
        C26485p.m42204b(str, c32831d);
        AppMethodBeat.m2505o(35628);
    }

    /* renamed from: a */
    public final String mo55529a(String str, PString pString) {
        AppMethodBeat.m2504i(35629);
        String a = C26485p.m42201a(str, pString);
        AppMethodBeat.m2505o(35629);
        return a;
    }

    /* renamed from: I */
    public final String mo55528I(C7620bi c7620bi) {
        AppMethodBeat.m2504i(35632);
        String I = C26485p.m42199I(c7620bi);
        AppMethodBeat.m2505o(35632);
        return I;
    }

    /* renamed from: a */
    public final void mo55530a(String str, C32800b c32800b, C7620bi c7620bi) {
        AppMethodBeat.m2504i(35630);
        if (c7620bi.bAA()) {
            C8910b me = C8910b.m16064me(c7620bi.field_content);
            if (!(me == null || C5046bo.isNullOrNil(me.cMn))) {
                c32800b.mo53356j(str, me.cMn);
            }
        }
        AppMethodBeat.m2505o(35630);
    }

    /* renamed from: ai */
    public final void mo55531ai(C7620bi c7620bi) {
        AppMethodBeat.m2504i(35631);
        String I = C26485p.m42199I(c7620bi);
        if (I != null) {
            byte[] decode = Base64.decode(I, 0);
            cdg cdg = new cdg();
            try {
                cdg.parseFrom(decode);
                if (cdg.xcS == null) {
                    AppMethodBeat.m2505o(35631);
                    return;
                }
                Object obj;
                if (c7620bi.field_talker.endsWith("@chatroom")) {
                    obj = C1876a.TalkChat.value;
                } else {
                    String obj2 = C1876a.Chat.value;
                }
                C4990ab.m7417i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", obj2, I, cdg.xcS.xcV, cdg.xcS.xcW);
                ((C13356c) C1720g.m3528K(C13356c.class)).mo25462e(13235, obj2, cdg.xcS.xcV, cdg.xcS.xcW);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
                AppMethodBeat.m2505o(35631);
                return;
            }
        }
        AppMethodBeat.m2505o(35631);
    }
}
