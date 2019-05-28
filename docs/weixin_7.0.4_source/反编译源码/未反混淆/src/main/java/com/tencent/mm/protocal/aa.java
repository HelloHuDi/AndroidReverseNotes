package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.cfz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class aa {
    public static byte[] j(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(58879);
        if (bArr == null || bArr.length <= 0) {
            ab.d("MicroMsg.SyncKeyUtil", "empty old key, use new key");
            AppMethodBeat.o(58879);
            return bArr2;
        } else if (bArr2 == null || bArr2.length <= 0) {
            ab.e("MicroMsg.SyncKeyUtil", "newKey is null");
            AppMethodBeat.o(58879);
            return null;
        } else {
            PByteArray pByteArray = new PByteArray();
            try {
                if (MMProtocalJni.mergeSyncKey(bArr, bArr2, pByteArray)) {
                    bArr2 = pByteArray.value;
                    AppMethodBeat.o(58879);
                    return bArr2;
                }
                ab.e("MicroMsg.SyncKeyUtil", "merge key failed");
                AppMethodBeat.o(58879);
                return null;
            } catch (IncompatibleClassChangeError e) {
                ab.printErrStackTrace("MicroMsg.Crash", e, "NoSuchMethod MMProtocalJni.mergeSyncKey", new Object[0]);
                IncompatibleClassChangeError e2 = (IncompatibleClassChangeError) new IncompatibleClassChangeError("NoSuchMethod MMProtocalJni.mergeSyncKey").initCause(e2);
                AppMethodBeat.o(58879);
                throw e2;
            }
        }
    }

    private static Map<Integer, Long> bO(byte[] bArr) {
        AppMethodBeat.i(58880);
        if (bo.cb(bArr)) {
            AppMethodBeat.o(58880);
            return null;
        }
        try {
            cfz cfz = (cfz) new cfz().parseFrom(bArr);
            if (cfz == null) {
                AppMethodBeat.o(58880);
                return null;
            }
            ab.d("MicroMsg.SyncKeyUtil", "dkpush : keyCount:" + cfz.wYL);
            LinkedList linkedList = cfz.wYM;
            if (linkedList.size() != cfz.wYL) {
                AppMethodBeat.o(58880);
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
                AppMethodBeat.o(58880);
                return null;
            }
            AppMethodBeat.o(58880);
            return hashMap;
        } catch (Exception e) {
            AppMethodBeat.o(58880);
            return null;
        }
    }

    public static String bP(byte[] bArr) {
        AppMethodBeat.i(58881);
        String str;
        if (bo.cb(bArr)) {
            str = "";
            AppMethodBeat.o(58881);
            return str;
        }
        Map bO = bO(bArr);
        if (bO == null || bO.size() <= 0) {
            str = "";
            AppMethodBeat.o(58881);
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
        AppMethodBeat.o(58881);
        return str;
    }

    public static boolean k(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(58882);
        Map bO = bO(bArr);
        if (bO == null) {
            ab.d("MicroMsg.SyncKeyUtil", "dkpush local sync key failed");
            AppMethodBeat.o(58882);
            return true;
        }
        Map bO2 = bO(bArr2);
        if (bO2 == null) {
            ab.e("MicroMsg.SyncKeyUtil", "dkpush svr sync key failed");
            AppMethodBeat.o(58882);
            return false;
        }
        for (Integer num : bO2.keySet()) {
            Long l = (Long) bO.get(num);
            Long l2 = (Long) bO2.get(num);
            if (l == null) {
                ab.d("MicroMsg.SyncKeyUtil", "dkpush local key null :".concat(String.valueOf(num)));
                AppMethodBeat.o(58882);
                return true;
            }
            ab.d("MicroMsg.SyncKeyUtil", "dkpush local key:" + num + " sv:" + l2 + " lv:" + l);
            if (l2.longValue() > l.longValue()) {
                AppMethodBeat.o(58882);
                return true;
            }
        }
        ab.d("MicroMsg.SyncKeyUtil", "dkpush two sync key is the same");
        AppMethodBeat.o(58882);
        return false;
    }
}
