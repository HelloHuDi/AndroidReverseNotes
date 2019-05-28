package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C42194e;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;

/* renamed from: com.tencent.mm.plugin.account.friend.a.d */
public final class C44692d extends C42194e {
    /* renamed from: a */
    public final C7620bi mo43844a(C7254cm c7254cm, String str, String str2, String str3) {
        AppMethodBeat.m2504i(108326);
        String a = C1946aa.m4148a(c7254cm.vED);
        if (a == null || a.length() <= 0) {
            C4990ab.m7412e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            AppMethodBeat.m2505o(108326);
            return null;
        }
        C5135a apC = C5135a.apC(a);
        if (c7254cm.nao == 66) {
            ((C32873b) C1720g.m3528K(C32873b.class)).mo44310vh(apC.xZo);
        }
        if (C5046bo.nullAsNil(apC.svN).length() > 0) {
            C17880h c17880h = new C17880h();
            c17880h.username = apC.svN;
            c17880h.dtR = 3;
            c17880h.mo33385cB(true);
            c17880h.frW = apC.xZk;
            c17880h.frV = apC.xZl;
            c17880h.bJt = -1;
            C4990ab.m7411d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", apC.svN, c17880h.ack(), c17880h.acl());
            C17884o.act().mo33391b(c17880h);
        }
        C7620bi a2 = super.mo43844a(c7254cm, str, str2, str3);
        AppMethodBeat.m2505o(108326);
        return a2;
    }
}
