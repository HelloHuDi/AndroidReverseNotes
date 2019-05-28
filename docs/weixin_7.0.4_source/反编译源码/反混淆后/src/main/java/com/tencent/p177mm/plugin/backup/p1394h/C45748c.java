package com.tencent.p177mm.plugin.backup.p1394h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C1855t;
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

/* renamed from: com.tencent.mm.plugin.backup.h.c */
public final class C45748c {
    /* renamed from: k */
    public static void m84548k(HashMap<String, Integer> hashMap) {
        AppMethodBeat.m2504i(17700);
        C4990ab.m7417i("MicroMsg.BackupStorageLogic", "buildConversation, unReadSum size[%d]", Integer.valueOf(hashMap.size()));
        for (String str : hashMap.keySet()) {
            C7620bi fa = C38658d.aUr().aUs().mo61498XO().mo15331fa(str, " and not ( type = 10000 and isSend != 2 ) ");
            if (fa != null) {
                int intValue = ((Integer) hashMap.get(str)).intValue();
                String str2 = fa.field_talker;
                C4990ab.m7417i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, talker:%s, addUnreadCount:%d", str2, Integer.valueOf(intValue));
                C7617ak aoZ = C38658d.aUr().aUs().mo61499XR().aoZ(str2);
                if (aoZ == null || aoZ.field_conversationTime <= fa.field_createTime || aoZ.field_conversationTime == Long.MAX_VALUE) {
                    boolean z = false;
                    if (aoZ == null) {
                        aoZ = new C7617ak(str2);
                        z = true;
                    }
                    aoZ.mo14750hO(fa.field_isSend);
                    aoZ.mo14748hM(intValue + aoZ.field_unReadCount);
                    aoZ.mo17068ap(fa);
                    aoZ.mo14757jg(Integer.toString(fa.getType()));
                    aoZ.mo14743eE((fa.field_createTime & 72057594037927935L) | (aoZ.field_flag & 4611686018427387904L));
                    aoZ.mo14747hL(0);
                    C4990ab.m7417i("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg, isNewConv[%b], talker[%s], flag[%d]", Boolean.valueOf(z), str2, Long.valueOf(aoZ.field_flag));
                    if (z) {
                        C38658d.aUr().aUs().mo61499XR().mo15807d(aoZ);
                    } else {
                        C38658d.aUr().aUs().mo61499XR().mo15767a(aoZ, str2);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.BackupStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
                }
            }
            C38657b aUs = C38658d.aUr().aUs();
            if (aUs.uin == 0) {
                C1819b c1819b = new C1819b();
                AppMethodBeat.m2505o(17700);
                throw c1819b;
            }
            aUs.jyy.mo7906O(str, 0);
        }
        C38658d.aUr().aUs().mo61499XR().dsL();
        AppMethodBeat.m2505o(17700);
    }

    /* renamed from: kH */
    public static boolean m84549kH(String str) {
        AppMethodBeat.m2504i(17701);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(17701);
            return false;
        }
        boolean mN = C1855t.m3901mN(str);
        AppMethodBeat.m2505o(17701);
        return mN;
    }

    /* renamed from: l */
    public static long m84550l(C7620bi c7620bi) {
        AppMethodBeat.m2504i(17702);
        C7616ad aoO = C38658d.aUr().aUs().mo61497XM().aoO(c7620bi.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            if (!C5046bo.isNullOrNil(c7620bi.field_talker)) {
                C38658d.aUr().aUt().mo73547g(2, c7620bi.field_talker);
                C38658d.aUr().aUs().mo61497XM().mo15702Z(new C7616ad(c7620bi.field_talker));
            } else if (c7620bi.field_talker.endsWith("@chatroom") && C38658d.aUr().aUs().mo61500XV().mo14889oe(c7620bi.field_talker) == null) {
                C38658d.aUr().aUt().mo73547g(2, c7620bi.field_talker);
            }
        }
        long Z = C38658d.aUr().aUs().mo61498XO().mo15281Z(c7620bi);
        if (Z < 0) {
            C4990ab.m7413e("MicroMsg.BackupStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", Integer.valueOf(c7620bi.getType()), c7620bi.field_talker);
        }
        AppMethodBeat.m2505o(17702);
        return Z;
    }

    /* renamed from: ox */
    public static int m84551ox(String str) {
        AppMethodBeat.m2504i(17703);
        if (str == null) {
            AppMethodBeat.m2505o(17703);
            return -1;
        } else if (str.length() <= 0) {
            AppMethodBeat.m2505o(17703);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.m2505o(17703);
                return indexOf;
            }
            AppMethodBeat.m2505o(17703);
            return -1;
        }
    }

    /* renamed from: Fm */
    public static C26493s m84546Fm(String str) {
        AppMethodBeat.m2504i(17704);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(17704);
            return null;
        }
        C26493s uf = C38658d.aUr().aUs().all().mo21063uf(str);
        AppMethodBeat.m2505o(17704);
        return uf;
    }

    /* renamed from: Fn */
    public static String m84547Fn(String str) {
        AppMethodBeat.m2504i(17705);
        String b = C15428j.m23709b(C38658d.aUr().aUs().mo61501XY(), "msg_", str, ".amr", 2);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(17705);
            return null;
        } else if (new C5728b(b).exists()) {
            AppMethodBeat.m2505o(17705);
            return b;
        } else {
            String str2 = C38658d.aUr().aUs().amg() + str;
            if (new C5728b(str2 + ".amr").exists()) {
                C5730e.m8623aQ(str2 + ".amr", b);
            } else if (new C5728b(str2).exists()) {
                C5730e.m8623aQ(str2, b);
            }
            AppMethodBeat.m2505o(17705);
            return b;
        }
    }
}
