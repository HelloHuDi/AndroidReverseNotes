package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.protobuf.axg;
import com.tencent.p177mm.protocal.protobuf.cfz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.protocal.aa */
public final class C44098aa {
    /* renamed from: j */
    public static byte[] m79382j(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(58879);
        if (bArr == null || bArr.length <= 0) {
            C4990ab.m7410d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            AppMethodBeat.m2505o(58879);
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            C4990ab.m7412e("MicroMsg.SyncKeyUtil", "newKey is null");
            AppMethodBeat.m2505o(58879);
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    bArr2 = pByteArray.value;
                    AppMethodBeat.m2505o(58879);
                    return bArr2;
                }
                C4990ab.m7412e("MicroMsg.SyncKeyUtil", "merge key failed");
                AppMethodBeat.m2505o(58879);
                return null;
            } catch (IncompatibleClassChangeError e) {
                C4990ab.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e2);
                AppMethodBeat.m2505o(58879);
                throw e2;
            }
        }
    }

    /* renamed from: bO */
    private static Map<Integer, Long> m79380bO(byte[] bArr) {
        AppMethodBeat.m2504i(58880);
        if (C5046bo.m7540cb(bArr)) {
            AppMethodBeat.m2505o(58880);
            return null;
        }
        try {
            cfz cfz = (cfz) new cfz().parseFrom(bArr);
            if (cfz == null) {
                AppMethodBeat.m2505o(58880);
                return null;
            }
            C4990ab.m7410d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + cfz.wYL);
            LinkedList linkedList = cfz.wYM;
            if (linkedList.size() != cfz.wYL) {
                AppMethodBeat.m2505o(58880);
                return null;
            }
            HashMap hashMap = new HashMap();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cfz.wYL) {
                    break;
                }
                hashMap.put(Integer.valueOf(((axg) linkedList.get(i2)).pXC), Long.valueOf(4294967295L & ((long) ((axg) linkedList.get(i2)).wBo)));
                i = i2 + 1;
            }
            if (hashMap.size() != cfz.wYL) {
                AppMethodBeat.m2505o(58880);
                return null;
            }
            AppMethodBeat.m2505o(58880);
            return hashMap;
        } catch (Exception e) {
            AppMethodBeat.m2505o(58880);
            return null;
        }
    }

    /* renamed from: bP */
    public static String m79381bP(byte[] bArr) {
        AppMethodBeat.m2504i(58881);
        String str;
        if (C5046bo.m7540cb(bArr)) {
            str = "";
            AppMethodBeat.m2505o(58881);
            return str;
        }
        Map bO = C44098aa.m79380bO(bArr);
        if (bO == null || bO.size() <= 0) {
            str = "";
            AppMethodBeat.m2505o(58881);
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" MsgKey:" + bO.get(Integer.valueOf(2)));
        stringBuffer.append(" profile:" + bO.get(Integer.valueOf(1)));
        stringBuffer.append(" contact:" + bO.get(Integer.valueOf(3)));
        stringBuffer.append(" chatroom:" + bO.get(Integer.valueOf(11)));
        stringBuffer.append(" Bottle:" + bO.get(Integer.valueOf(7)));
        stringBuffer.append(" QContact:" + bO.get(Integer.valueOf(5)));
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(58881);
        return str;
    }

    /* renamed from: k */
    public static boolean m79383k(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(58882);
        Map bO = C44098aa.m79380bO(bArr);
        if (bO == null) {
            C4990ab.m7410d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            AppMethodBeat.m2505o(58882);
            return true;
        }
        Map bO2 = C44098aa.m79380bO(bArr2);
        if (bO2 == null) {
            C4990ab.m7412e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            AppMethodBeat.m2505o(58882);
            return false;
        }
        for (Integer num : bO2.keySet()) {
            Long l = (Long) bO.get(num);
            Long l2 = (Long) bO2.get(num);
            if (l == null) {
                C4990ab.m7410d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(num)));
                AppMethodBeat.m2505o(58882);
                return true;
            }
            C4990ab.m7410d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                AppMethodBeat.m2505o(58882);
                return true;
            }
        }
        C4990ab.m7410d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        AppMethodBeat.m2505o(58882);
        return false;
    }
}
