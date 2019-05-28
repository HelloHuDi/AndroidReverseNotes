package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.aj.a.i */
public final class C8926i {
    /* renamed from: h */
    public static void m16085h(int i, String str, String str2) {
        AppMethodBeat.m2504i(11590);
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            C5046bo.getInt(split[2], 0);
            if (i == 7) {
                C8926i.m16084aI(str4, str3);
                AppMethodBeat.m2505o(11590);
                return;
            } else if (i == 8) {
                C8926i.m16084aI(str4, str3);
                AppMethodBeat.m2505o(11590);
                return;
            } else {
                if (i == 9) {
                    C8926i.m16084aI(str4, str3);
                }
                AppMethodBeat.m2505o(11590);
                return;
            }
        }
        AppMethodBeat.m2505o(11590);
    }

    /* renamed from: aI */
    private static void m16084aI(String str, String str2) {
        AppMethodBeat.m2504i(11591);
        long ry = C25754e.m40911ry(str);
        if (ry == -1) {
            C4990ab.m7417i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            AppMethodBeat.m2505o(11591);
            return;
        }
        int i = C41747z.aeU().mo60340fv(ry).field_newUnReadCount;
        C41747z.aeU().mo60342fx(ry);
        C45142c aK = C41747z.aeT().mo60349aK(ry);
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str2);
        if (aoZ == null) {
            C4990ab.m7421w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
            AppMethodBeat.m2505o(11591);
        } else if (aK.mo73052lc(1)) {
            if (aoZ.field_unReadMuteCount <= i) {
                aoZ.mo14754hS(0);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str2);
                ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancelNotification(str2);
                AppMethodBeat.m2505o(11591);
                return;
            }
            aoZ.mo14754hS(aoZ.field_unReadMuteCount - i);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str2);
            AppMethodBeat.m2505o(11591);
        } else if (aoZ.field_unReadCount <= i) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(str2);
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancelNotification(str2);
            AppMethodBeat.m2505o(11591);
        } else {
            aoZ.mo14753hR(0);
            aoZ.mo14748hM(aoZ.field_unReadCount - i);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str2);
            AppMethodBeat.m2505o(11591);
        }
    }
}
