package com.tencent.p177mm.plugin.backup.bakoldlogic.p918d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.d */
public final class C11131d {
    /* renamed from: k */
    public static void m18843k(HashMap<String, Integer> hashMap) {
        AppMethodBeat.m2504i(18038);
        for (String str : hashMap.keySet()) {
            C7620bi fa = C11124b.aUY().aUZ().mo45269XO().mo15331fa(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (fa != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = fa.field_talker;
                C4990ab.m7417i("MicroMsg.BakOldTempStorageLogic", "talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                Object obj = null;
                C7617ak aoZ = C11124b.aUY().aUZ().mo45270XR().aoZ(str2);
                if (aoZ == null || aoZ.field_conversationTime <= fa.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
                    if (aoZ == null) {
                        C4990ab.m7416i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg conversation is null.");
                        C4990ab.m7411d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s", str2);
                        aoZ = new C7617ak(str2);
                        obj = 1;
                    }
                    aoZ.mo14750hO(fa.field_isSend);
                    aoZ.mo14748hM(intValue + aoZ.field_unReadCount);
                    aoZ.mo17068ap(fa);
                    aoZ.mo14757jg(Integer.toString(fa.getType()));
                    aoZ.mo14743eE((aoZ.field_flag & 4611686018427387904L) | (fa.field_createTime & 72057594037927935L));
                    aoZ.mo14747hL(0);
                    if (obj != null) {
                        C4990ab.m7411d("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", str2, Long.valueOf(aoZ.field_flag));
                        C11124b.aUY().aUZ().mo45270XR().mo15807d(aoZ);
                    } else {
                        C11124b.aUY().aUZ().mo45270XR().mo15767a(aoZ, str2);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.BakOldTempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
        }
        C11124b.aUY().aUZ().mo45270XR().dsL();
        AppMethodBeat.m2505o(18038);
    }

    /* renamed from: kH */
    public static boolean m18844kH(String str) {
        AppMethodBeat.m2504i(18039);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(18039);
            return false;
        }
        boolean endsWith = str.endsWith("@chatroom");
        AppMethodBeat.m2505o(18039);
        return endsWith;
    }

    /* renamed from: l */
    public static long m18845l(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18040);
        C7616ad aoO = C11124b.aUY().aUZ().mo45268XM().aoO(c7620bi.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            if (!C5046bo.isNullOrNil(c7620bi.field_talker)) {
                C11124b.aUY().aVa().mo73539g(2, c7620bi.field_talker);
                C11124b.aUY().aUZ().mo45268XM().mo15702Z(new C7616ad(c7620bi.field_talker));
            } else if (c7620bi.field_talker.endsWith("@chatroom") && C11124b.aUY().aUZ().mo45271XV().mo14889oe(c7620bi.field_talker) == null) {
                C11124b.aUY().aVa().mo73539g(2, c7620bi.field_talker);
            }
        }
        long Z = C11124b.aUY().aUZ().mo45269XO().mo15281Z(c7620bi);
        if (Z < 0) {
            C4990ab.m7413e("MicroMsg.BakOldTempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(c7620bi.getType()), c7620bi.field_talker);
        }
        AppMethodBeat.m2505o(18040);
        return Z;
    }

    /* renamed from: ox */
    public static int m18846ox(String str) {
        AppMethodBeat.m2504i(18041);
        if (str == null) {
            AppMethodBeat.m2505o(18041);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.m2505o(18041);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.m2505o(18041);
                return indexOf;
            }
            AppMethodBeat.m2505o(18041);
            return -1;
        }
    }

    /* renamed from: Fm */
    public static C26493s m18841Fm(String str) {
        AppMethodBeat.m2504i(18042);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(18042);
            return null;
        }
        C26493s uf = C11124b.aUY().aUZ().all().mo21063uf(str);
        AppMethodBeat.m2505o(18042);
        return uf;
    }

    /* renamed from: Fn */
    public static String m18842Fn(String str) {
        AppMethodBeat.m2504i(18043);
        String b = C15428j.m23709b(C11124b.aUY().aUZ().mo45272XY(), "msg_", str, ".amr", 2);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(18043);
            return null;
        } else if (new C5728b(b).exists()) {
            AppMethodBeat.m2505o(18043);
            return b;
        } else {
            String str2 = C11124b.aUY().aUZ().amg() + str;
            if (new C5728b(str2 + ".amr").exists()) {
                C5730e.m8623aQ(str2 + ".amr", b);
            } else if (new C5728b(str2).exists()) {
                C5730e.m8623aQ(str2, b);
            }
            AppMethodBeat.m2505o(18043);
            return b;
        }
    }
}
