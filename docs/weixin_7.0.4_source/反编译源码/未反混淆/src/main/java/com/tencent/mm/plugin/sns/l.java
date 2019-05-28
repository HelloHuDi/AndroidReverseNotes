package com.tencent.mm.plugin.sns;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class l implements i {
    public final void b(String str, d dVar) {
        AppMethodBeat.i(35628);
        p.b(str, dVar);
        AppMethodBeat.o(35628);
    }

    public final String a(String str, PString pString) {
        AppMethodBeat.i(35629);
        String a = p.a(str, pString);
        AppMethodBeat.o(35629);
        return a;
    }

    public final String I(bi biVar) {
        AppMethodBeat.i(35632);
        String I = p.I(biVar);
        AppMethodBeat.o(35632);
        return I;
    }

    public final void a(String str, b bVar, bi biVar) {
        AppMethodBeat.i(35630);
        if (biVar.bAA()) {
            j.b me = j.b.me(biVar.field_content);
            if (!(me == null || bo.isNullOrNil(me.cMn))) {
                bVar.j(str, me.cMn);
            }
        }
        AppMethodBeat.o(35630);
    }

    public final void ai(bi biVar) {
        AppMethodBeat.i(35631);
        String I = p.I(biVar);
        if (I != null) {
            byte[] decode = Base64.decode(I, 0);
            cdg cdg = new cdg();
            try {
                cdg.parseFrom(decode);
                if (cdg.xcS == null) {
                    AppMethodBeat.o(35631);
                    return;
                }
                Object obj;
                if (biVar.field_talker.endsWith("@chatroom")) {
                    obj = a.TalkChat.value;
                } else {
                    String obj2 = a.Chat.value;
                }
                ab.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", obj2, I, cdg.xcS.xcV, cdg.xcS.xcW);
                ((c) g.K(c.class)).e(13235, obj2, cdg.xcS.xcV, cdg.xcS.xcW);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, "", new Object[0]);
                AppMethodBeat.o(35631);
                return;
            }
        }
        AppMethodBeat.o(35631);
    }
}
