package com.tencent.p177mm.plugin.sns.lucky.p1298a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.ata;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.cbb;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.lucky.a.m */
public final class C39742m {
    private static final ThreadLocal<HashMap<String, Long>> qHb = new ThreadLocal();

    static {
        AppMethodBeat.m2504i(35898);
        AppMethodBeat.m2505o(35898);
    }

    /* renamed from: Xx */
    public static boolean m67967Xx(String str) {
        AppMethodBeat.m2504i(35892);
        C46236n YT = C13373af.cnF().mo62918YT(str);
        boolean a = C39742m.m67968a(YT, C34955aj.m57409q(YT));
        AppMethodBeat.m2505o(35892);
        return a;
    }

    /* renamed from: k */
    public static boolean m67970k(C46236n c46236n) {
        AppMethodBeat.m2504i(35893);
        boolean a = C39742m.m67968a(c46236n, C34955aj.m57409q(c46236n));
        AppMethodBeat.m2505o(35893);
        return a;
    }

    /* renamed from: a */
    public static boolean m67968a(C46236n c46236n, cbf cbf) {
        AppMethodBeat.m2504i(35894);
        if (c46236n == null) {
            AppMethodBeat.m2505o(35894);
            return true;
        }
        bav cqM = c46236n.cqM();
        if (c46236n.field_type != 21) {
            AppMethodBeat.m2505o(35894);
            return true;
        } else if (cqM.cRU == 1) {
            AppMethodBeat.m2505o(35894);
            return true;
        } else if (C1853r.m3846Yz().equals(c46236n.field_userName)) {
            AppMethodBeat.m2505o(35894);
            return true;
        } else {
            if (cbf.xaE != null) {
                LinkedList<cbb> linkedList = cbf.xaE.xbh;
                if (linkedList == null || linkedList.size() == 0) {
                    AppMethodBeat.m2505o(35894);
                    return false;
                }
                String Yz = C1853r.m3846Yz();
                for (cbb cbb : linkedList) {
                    if (Yz.equals(cbb.vHl)) {
                        AppMethodBeat.m2505o(35894);
                        return true;
                    }
                }
            }
            AppMethodBeat.m2505o(35894);
            return false;
        }
    }

    /* renamed from: m */
    public static long m67972m(C46236n c46236n) {
        AppMethodBeat.m2504i(35896);
        long b = C39742m.m67969b(c46236n, null);
        AppMethodBeat.m2505o(35896);
        return b;
    }

    /* renamed from: b */
    public static long m67969b(C46236n c46236n, cbf cbf) {
        long j = 0;
        AppMethodBeat.m2504i(35897);
        if (c46236n == null) {
            AppMethodBeat.m2505o(35897);
            return 0;
        }
        if (cbf == null) {
            cbf = C34955aj.m57409q(c46236n);
        }
        if (cbf == null) {
            AppMethodBeat.m2505o(35897);
            return 0;
        }
        cbu cbu = cbf.xaE;
        if (cbu == null) {
            AppMethodBeat.m2505o(35897);
            return 0;
        }
        LinkedList<cbb> linkedList = cbu.xbh;
        if (linkedList == null) {
            AppMethodBeat.m2505o(35897);
            return 0;
        }
        Object obj;
        String str = c46236n.reW;
        if (C5046bo.isNullOrNil(str)) {
            obj = C1178g.m2591x(c46236n.field_content) + C1178g.m2591x(c46236n.field_attrBuf);
        } else {
            String obj2 = str;
        }
        HashMap hashMap = (HashMap) qHb.get();
        if (hashMap == null || !hashMap.containsKey(obj2)) {
            for (cbb cbb : linkedList) {
                ata ata = new ata();
                try {
                    ata.parseFrom(C1946aa.m4150a(cbb.wZK));
                } catch (Exception e) {
                    C4990ab.m7412e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
                }
                j += ata.cSh;
            }
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            hashMap.put(obj2, Long.valueOf(j));
            qHb.set(hashMap);
            AppMethodBeat.m2505o(35897);
            return j;
        }
        j = ((Long) hashMap.get(obj2)).longValue();
        AppMethodBeat.m2505o(35897);
        return j;
    }

    /* renamed from: l */
    public static int m67971l(C46236n c46236n) {
        AppMethodBeat.m2504i(35895);
        if (c46236n == null) {
            AppMethodBeat.m2505o(35895);
            return 0;
        }
        cbf q = C34955aj.m57409q(c46236n);
        if (q == null) {
            AppMethodBeat.m2505o(35895);
            return 0;
        }
        cbu cbu = q.xaE;
        if (cbu == null || cbu.xbh.size() == 0) {
            AppMethodBeat.m2505o(35895);
            return 0;
        }
        int size = cbu.xbh.size();
        AppMethodBeat.m2505o(35895);
        return size;
    }
}
