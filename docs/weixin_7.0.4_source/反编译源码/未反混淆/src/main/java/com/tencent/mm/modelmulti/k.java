package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class k {
    public static boolean ahT() {
        boolean z;
        AppMethodBeat.i(58394);
        g.RQ();
        if (bo.nullAsNil((String) g.RP().Ry().get(8195, null)).length() > 0) {
            g.RQ();
            if (bo.h((Integer) g.RP().Ry().get(15, null)) != 0) {
                z = false;
                ab.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
                AppMethodBeat.o(58394);
                return z;
            }
        }
        z = true;
        ab.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(58394);
        return z;
    }

    public static void b(int i, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.i(58395);
        b bVar = new b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            byte[] jQ;
            boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
            ab.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret:" + unpack + ", noticeid:" + unpack, Integer.valueOf(pInt3.value));
            if (pInt3.value != 0) {
                hm hmVar = new hm();
                hmVar.cCo.cCp = pInt3.value;
                boolean m = a.xxA.m(hmVar);
                ab.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                pInt3.value = 0;
            }
            if (pInt2.value == 13) {
                g.RQ();
                jQ = g.RO().jQ(3);
                pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(jQ, pByteArray2.value);
                ab.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession" + (jQ == null ? -1 : jQ.length) + " new pr[" + pByteArray2.value + ": " + (pByteArray2.value == null ? -1 : pByteArray2.value.length) + "]");
            }
            if (unpack) {
                bVar.vym = pInt4.value;
                if (pInt.value == -13) {
                    bVar.vyl = pInt.value;
                    ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
                    AppMethodBeat.o(58395);
                    return;
                }
                int P = bVar.P(pByteArray2.value);
                ab.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                bVar.vyl = P;
                bVar.bufferSize = (long) bArr.length;
                g.RQ();
                byte[] anf = bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null)));
                jQ = aa.a(bVar.vyH.vTO);
                g.RQ();
                g.RN().cd(bVar.vyH.jBT, bVar.vyH.wIy);
                com.tencent.mm.kernel.a.jO(bVar.vyH.jBT);
                if (bo.cb(jQ) || !com.tencent.mm.protocal.aa.k(anf, jQ)) {
                    ab.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                    AppMethodBeat.o(58395);
                    return;
                }
                ((com.tencent.mm.plugin.zero.b.b) g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(bVar, i, j);
                if (pInt3.value != 0) {
                    hm hmVar2 = new hm();
                    hmVar2.cCo.cCp = pInt3.value;
                    boolean m2 = a.xxA.m(hmVar2);
                    ab.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                    pInt3.value = 0;
                }
                AppMethodBeat.o(58395);
                return;
            }
            ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
            AppMethodBeat.o(58395);
        } catch (Exception e) {
            ab.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", e);
            ab.printErrStackTrace("MicroMsg.NewSyncMgr", e, "", new Object[0]);
        }
    }
}
