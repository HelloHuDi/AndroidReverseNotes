package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class m {
    private static final ThreadLocal<HashMap<String, Long>> qHb = new ThreadLocal();

    static {
        AppMethodBeat.i(35898);
        AppMethodBeat.o(35898);
    }

    public static boolean Xx(String str) {
        AppMethodBeat.i(35892);
        n YT = af.cnF().YT(str);
        boolean a = a(YT, aj.q(YT));
        AppMethodBeat.o(35892);
        return a;
    }

    public static boolean k(n nVar) {
        AppMethodBeat.i(35893);
        boolean a = a(nVar, aj.q(nVar));
        AppMethodBeat.o(35893);
        return a;
    }

    public static boolean a(n nVar, cbf cbf) {
        AppMethodBeat.i(35894);
        if (nVar == null) {
            AppMethodBeat.o(35894);
            return true;
        }
        bav cqM = nVar.cqM();
        if (nVar.field_type != 21) {
            AppMethodBeat.o(35894);
            return true;
        } else if (cqM.cRU == 1) {
            AppMethodBeat.o(35894);
            return true;
        } else if (r.Yz().equals(nVar.field_userName)) {
            AppMethodBeat.o(35894);
            return true;
        } else {
            if (cbf.xaE != null) {
                LinkedList<cbb> linkedList = cbf.xaE.xbh;
                if (linkedList == null || linkedList.size() == 0) {
                    AppMethodBeat.o(35894);
                    return false;
                }
                String Yz = r.Yz();
                for (cbb cbb : linkedList) {
                    if (Yz.equals(cbb.vHl)) {
                        AppMethodBeat.o(35894);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(35894);
            return false;
        }
    }

    public static long m(n nVar) {
        AppMethodBeat.i(35896);
        long b = b(nVar, null);
        AppMethodBeat.o(35896);
        return b;
    }

    public static long b(n nVar, cbf cbf) {
        long j = 0;
        AppMethodBeat.i(35897);
        if (nVar == null) {
            AppMethodBeat.o(35897);
            return 0;
        }
        if (cbf == null) {
            cbf = aj.q(nVar);
        }
        if (cbf == null) {
            AppMethodBeat.o(35897);
            return 0;
        }
        cbu cbu = cbf.xaE;
        if (cbu == null) {
            AppMethodBeat.o(35897);
            return 0;
        }
        LinkedList<cbb> linkedList = cbu.xbh;
        if (linkedList == null) {
            AppMethodBeat.o(35897);
            return 0;
        }
        Object obj;
        String str = nVar.reW;
        if (bo.isNullOrNil(str)) {
            obj = g.x(nVar.field_content) + g.x(nVar.field_attrBuf);
        } else {
            String obj2 = str;
        }
        HashMap hashMap = (HashMap) qHb.get();
        if (hashMap == null || !hashMap.containsKey(obj2)) {
            for (cbb cbb : linkedList) {
                ata ata = new ata();
                try {
                    ata.parseFrom(aa.a(cbb.wZK));
                } catch (Exception e) {
                    ab.e("MicrMsg.SnsLuckyUtil", e.getMessage() + "hbBuffer is error");
                }
                j += ata.cSh;
            }
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            hashMap.put(obj2, Long.valueOf(j));
            qHb.set(hashMap);
            AppMethodBeat.o(35897);
            return j;
        }
        j = ((Long) hashMap.get(obj2)).longValue();
        AppMethodBeat.o(35897);
        return j;
    }

    public static int l(n nVar) {
        AppMethodBeat.i(35895);
        if (nVar == null) {
            AppMethodBeat.o(35895);
            return 0;
        }
        cbf q = aj.q(nVar);
        if (q == null) {
            AppMethodBeat.o(35895);
            return 0;
        }
        cbu cbu = q.xaE;
        if (cbu == null || cbu.xbh.size() == 0) {
            AppMethodBeat.o(35895);
            return 0;
        }
        int size = cbu.xbh.size();
        AppMethodBeat.o(35895);
        return size;
    }
}
