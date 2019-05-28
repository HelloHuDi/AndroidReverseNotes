package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class d {
    public static void k(HashMap<String, Integer> hashMap) {
        AppMethodBeat.i(18038);
        for (String str : hashMap.keySet()) {
            bi fa = b.aUY().aUZ().XO().fa(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (fa != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = fa.field_talker;
                ab.i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                Object obj = null;
                ak aoZ = b.aUY().aUZ().XR().aoZ(str2);
                if (aoZ == null || aoZ.field_conversationTime <= fa.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
                    if (aoZ == null) {
                        ab.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        ab.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", str2);
                        aoZ = new ak(str2);
                        obj = 1;
                    }
                    aoZ.hO(fa.field_isSend);
                    aoZ.hM(intValue + aoZ.field_unReadCount);
                    aoZ.ap(fa);
                    aoZ.jg(Integer.toString(fa.getType()));
                    aoZ.eE((aoZ.field_flag & 4611686018427387904L) | (fa.field_createTime & 72057594037927935L));
                    aoZ.hL(0);
                    if (obj != null) {
                        ab.d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", str2, Long.valueOf(aoZ.field_flag));
                        b.aUY().aUZ().XR().d(aoZ);
                    } else {
                        b.aUY().aUZ().XR().a(aoZ, str2);
                    }
                } else {
                    ab.i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        b.aUY().aUZ().XR().dsL();
        AppMethodBeat.o(18038);
    }

    public static boolean kH(String str) {
        AppMethodBeat.i(18039);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(18039);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.o(18039);
        return endsWith;
    }

    public static long l(bi biVar) {
        AppMethodBeat.i(18040);
        ad aoO = b.aUY().aUZ().XM().aoO(biVar.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            if (!bo.isNullOrNil(biVar.field_talker)) {
                b.aUY().aVa().g(2, biVar.field_talker);
                b.aUY().aUZ().XM().Z(new ad(biVar.field_talker));
            } else if (biVar.field_talker.endsWith("@chatroom") && b.aUY().aUZ().XV().oe(biVar.field_talker) == null) {
                b.aUY().aVa().g(2, biVar.field_talker);
            }
        }
        long Z = b.aUY().aUZ().XO().Z(biVar);
        if (Z < 0) {
            ab.e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(biVar.getType()), biVar.field_talker);
        }
        AppMethodBeat.o(18040);
        return Z;
    }

    public static int ox(String str) {
        AppMethodBeat.i(18041);
        if (str == null) {
            AppMethodBeat.o(18041);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.o(18041);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(18041);
                return indexOf;
            }
            AppMethodBeat.o(18041);
            return -1;
        }
    }

    public static s Fm(String str) {
        AppMethodBeat.i(18042);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(18042);
            return null;
        }
        s uf = b.aUY().aUZ().all().uf(str);
        AppMethodBeat.o(18042);
        return uf;
    }

    public static String Fn(String str) {
        AppMethodBeat.i(18043);
        String b = j.b(b.aUY().aUZ().XY(), "msg_", str, ".amr", 2);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(18043);
            return null;
        } else if (new b(b).exists()) {
            AppMethodBeat.o(18043);
            return b;
        } else {
            String str2 = b.aUY().aUZ().amg() + str;
            if (new b(str2 + ".amr").exists()) {
                e.aQ(str2 + ".amr", b);
            } else if (new b(str2).exists()) {
                e.aQ(str2, b);
            }
            AppMethodBeat.o(18043);
            return b;
        }
    }
}
