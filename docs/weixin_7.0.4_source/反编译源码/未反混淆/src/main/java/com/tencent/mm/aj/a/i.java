package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;

public final class i {
    public static void h(int i, String str, String str2) {
        AppMethodBeat.i(11590);
        if ("EnterpriseChatStatus".equals(str)) {
            String[] split = str2.split(";");
            String str3 = split[0];
            String str4 = split[1];
            bo.getInt(split[2], 0);
            if (i == 7) {
                aI(str4, str3);
                AppMethodBeat.o(11590);
                return;
            } else if (i == 8) {
                aI(str4, str3);
                AppMethodBeat.o(11590);
                return;
            } else {
                if (i == 9) {
                    aI(str4, str3);
                }
                AppMethodBeat.o(11590);
                return;
            }
        }
        AppMethodBeat.o(11590);
    }

    private static void aI(String str, String str2) {
        AppMethodBeat.i(11591);
        long ry = e.ry(str);
        if (ry == -1) {
            ab.i("MicroMsg.BizChatStatusNotifyService", "qy_status_notify bizLocalId == -1,%s", str);
            AppMethodBeat.o(11591);
            return;
        }
        int i = z.aeU().fv(ry).field_newUnReadCount;
        z.aeU().fx(ry);
        c aK = z.aeT().aK(ry);
        ak aoZ = ((j) g.K(j.class)).XR().aoZ(str2);
        if (aoZ == null) {
            ab.w("MicroMsg.BizChatStatusNotifyService", "qy_status_notify cvs == null:%s", str2);
            AppMethodBeat.o(11591);
        } else if (aK.lc(1)) {
            if (aoZ.field_unReadMuteCount <= i) {
                aoZ.hS(0);
                ((j) g.K(j.class)).XR().a(aoZ, str2);
                ((a) g.M(a.class)).getNotification().cancelNotification(str2);
                AppMethodBeat.o(11591);
                return;
            }
            aoZ.hS(aoZ.field_unReadMuteCount - i);
            ((j) g.K(j.class)).XR().a(aoZ, str2);
            AppMethodBeat.o(11591);
        } else if (aoZ.field_unReadCount <= i) {
            ((j) g.K(j.class)).XR().apb(str2);
            ((a) g.M(a.class)).getNotification().cancelNotification(str2);
            AppMethodBeat.o(11591);
        } else {
            aoZ.hR(0);
            aoZ.hM(aoZ.field_unReadCount - i);
            ((j) g.K(j.class)).XR().a(aoZ, str2);
            AppMethodBeat.o(11591);
        }
    }
}
