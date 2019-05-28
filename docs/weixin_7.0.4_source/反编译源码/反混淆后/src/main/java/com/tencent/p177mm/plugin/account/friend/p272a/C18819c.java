package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p230g.p231a.C18211ag;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.friend.a.c */
public final class C18819c extends C4884c<C18211ag> {
    public C18819c() {
        AppMethodBeat.m2504i(108323);
        this.xxI = C18211ag.class.getName().hashCode();
        AppMethodBeat.m2505o(108323);
    }

    /* renamed from: a */
    private static boolean m29402a(C18211ag c18211ag) {
        AppMethodBeat.m2504i(108324);
        if (c18211ag.ctc.cte == 0) {
            try {
                int YK = C1853r.m3829YK() | 4096;
                C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", YK, "", ""));
                C4990ab.m7410d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(108324);
        return false;
    }
}
