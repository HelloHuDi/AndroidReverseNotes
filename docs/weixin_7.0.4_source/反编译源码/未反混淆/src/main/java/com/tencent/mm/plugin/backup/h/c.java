package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.b;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class c {
    public static void k(HashMap<String, Integer> hashMap) {
        AppMethodBeat.i(17700);
        ab.i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", Integer.valueOf(hashMap.size()));
        for (String str : hashMap.keySet()) {
            bi fa = d.aUr().aUs().XO().fa(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (fa != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = fa.field_talker;
                ab.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                ak aoZ = d.aUr().aUs().XR().aoZ(str2);
                if (aoZ == null || aoZ.field_conversationTime <= fa.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
                    boolean z = false;
                    if (aoZ == null) {
                        aoZ = new ak(str2);
                        z = true;
                    }
                    aoZ.hO(fa.field_isSend);
                    aoZ.hM(intValue + aoZ.field_unReadCount);
                    aoZ.ap(fa);
                    aoZ.jg(Integer.toString(fa.getType()));
                    aoZ.eE((fa.field_createTime & 72057594037927935L) | (aoZ.field_flag & 4611686018427387904L));
                    aoZ.hL(0);
                    ab.i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", Boolean.valueOf(z), str2, Long.valueOf(aoZ.field_flag));
                    if (z) {
                        d.aUr().aUs().XR().d(aoZ);
                    } else {
                        d.aUr().aUs().XR().a(aoZ, str2);
                    }
                } else {
                    ab.e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
            b aUs = d.aUr().aUs();
            if (aUs.uin == 0) {
                b bVar = new b();
                AppMethodBeat.o(17700);
                throw bVar;
            }
            aUs.jyy.O(str, 0);
        }
        d.aUr().aUs().XR().dsL();
        AppMethodBeat.o(17700);
    }

    public static boolean kH(String str) {
        AppMethodBeat.i(17701);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(17701);
            return false;
        }
        boolean mN = t.mN(str);
        AppMethodBeat.o(17701);
        return mN;
    }

    public static long l(bi biVar) {
        AppMethodBeat.i(17702);
        ad aoO = d.aUr().aUs().XM().aoO(biVar.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            if (!bo.isNullOrNil(biVar.field_talker)) {
                d.aUr().aUt().g(2, biVar.field_talker);
                d.aUr().aUs().XM().Z(new ad(biVar.field_talker));
            } else if (biVar.field_talker.endsWith("@chatroom") && d.aUr().aUs().XV().oe(biVar.field_talker) == null) {
                d.aUr().aUt().g(2, biVar.field_talker);
            }
        }
        long Z = d.aUr().aUs().XO().Z(biVar);
        if (Z < 0) {
            ab.e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(biVar.getType()), biVar.field_talker);
        }
        AppMethodBeat.o(17702);
        return Z;
    }

    public static int ox(String str) {
        AppMethodBeat.i(17703);
        if (str == null) {
            AppMethodBeat.o(17703);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.o(17703);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(17703);
                return indexOf;
            }
            AppMethodBeat.o(17703);
            return -1;
        }
    }

    public static s Fm(String str) {
        AppMethodBeat.i(17704);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(17704);
            return null;
        }
        s uf = d.aUr().aUs().all().uf(str);
        AppMethodBeat.o(17704);
        return uf;
    }

    public static String Fn(String str) {
        AppMethodBeat.i(17705);
        String b = j.b(d.aUr().aUs().XY(), "msg_", str, ".amr", 2);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(17705);
            return null;
        } else if (new com.tencent.mm.vfs.b(b).exists()) {
            AppMethodBeat.o(17705);
            return b;
        } else {
            String str2 = d.aUr().aUs().amg() + str;
            if (new com.tencent.mm.vfs.b(str2 + ".amr").exists()) {
                e.aQ(str2 + ".amr", b);
            } else if (new com.tencent.mm.vfs.b(str2).exists()) {
                e.aQ(str2, b);
            }
            AppMethodBeat.o(17705);
            return b;
        }
    }
}
