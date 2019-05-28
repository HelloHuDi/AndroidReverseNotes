package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.List;

public final class m {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static List<Boolean> S(List<String> list) {
        AppMethodBeat.i(5508);
        if (list == null) {
            AppMethodBeat.o(5508);
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            boolean z;
            if (t.kH(str)) {
                boolean z2;
                boolean z3 = false;
                long j = 0;
                ak aoZ = ((j) g.K(j.class)).XR().aoZ(str);
                if (aoZ != null) {
                    if (aoZ.field_lastSeq != 0 && ((j) g.K(j.class)).bOr().R(str, aoZ.field_lastSeq).field_msgId == 0) {
                        j = aoZ.field_lastSeq;
                        z3 = true;
                    }
                    if (aoZ.field_firstUnDeliverSeq != 0) {
                        aoZ.eG(0);
                        aoZ.eF(0);
                        ((j) g.K(j.class)).XR().a(aoZ, str);
                        ab.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId update conv");
                    }
                }
                long j2 = j;
                if (!z3) {
                    bi Rv = ((j) g.K(j.class)).bOr().Rv(str);
                    if (!(Rv == null || Rv.field_msgId == 0)) {
                        z2 = true;
                        if (j2 == 0) {
                            j2 = ((j) g.K(j.class)).bOr().Ru(str);
                        }
                        if (j2 != 0) {
                            ((j) g.K(j.class)).Yo().N(str, j2);
                        }
                        ab.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z2), Long.valueOf(j2));
                        z = z2;
                    }
                }
                z2 = z3;
                if (j2 == 0) {
                }
                if (j2 != 0) {
                }
                ab.i("MicroMsg.ChatroomLogic", "summerbadcr deleteConv chatroomId[%s], needClear[%b], lastMsgSeq[%d]", str, Boolean.valueOf(z2), Long.valueOf(j2));
                z = z2;
            } else {
                z = false;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        AppMethodBeat.o(5508);
        return arrayList;
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3) {
        AppMethodBeat.i(5509);
        a(str, list, str2, z, str3, 2);
        AppMethodBeat.o(5509);
    }

    public static void a(String str, List<String> list, String str2, boolean z, String str3, int i) {
        AppMethodBeat.i(5510);
        bi biVar = new bi();
        biVar.ju(str);
        biVar.setType(Downloads.MIN_WAIT_FOR_NETWORK);
        biVar.eJ(System.currentTimeMillis());
        biVar.setStatus(4);
        biVar.hO(i);
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            String Yz = r.Yz();
            String string = ah.getContext().getString(R.string.ajw);
            for (String str4 : list) {
                if (!str4.equals(Yz)) {
                    ad aoO = ((j) g.K(j.class)).XM().aoO(str4);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        if (z) {
                            stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + str4 + "</a>" + string);
                        } else {
                            stringBuffer.append(str4 + string);
                        }
                    } else if (z) {
                        stringBuffer.append("<a href=\"" + str3 + str4 + "\">" + d(aoO) + "</a>" + string);
                    } else {
                        stringBuffer.append(d(aoO) + string);
                    }
                }
            }
            if (stringBuffer.length() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(string));
            }
        }
        biVar.setContent(str2.replace("%s", stringBuffer));
        ((j) g.K(j.class)).bOr().Z(biVar);
        AppMethodBeat.o(5510);
    }

    private static String d(ad adVar) {
        AppMethodBeat.i(5511);
        String A;
        if (a.z(adVar)) {
            A = a.A(adVar);
            if (A != null) {
                A = adVar.Oj() + A;
                AppMethodBeat.o(5511);
                return A;
            }
            A = adVar.Oj();
            AppMethodBeat.o(5511);
            return A;
        }
        A = adVar.Oj();
        AppMethodBeat.o(5511);
        return A;
    }

    public static boolean mo(String str) {
        AppMethodBeat.i(5512);
        if (t.mM(str) || ad.aox(str)) {
            AppMethodBeat.o(5512);
            return true;
        }
        AppMethodBeat.o(5512);
        return false;
    }
}
