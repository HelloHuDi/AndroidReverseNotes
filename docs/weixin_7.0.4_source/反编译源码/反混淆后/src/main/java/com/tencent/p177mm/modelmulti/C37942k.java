package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6488hm;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelmulti.k */
public final class C37942k {
    public static boolean ahT() {
        boolean z;
        AppMethodBeat.m2504i(58394);
        C1720g.m3537RQ();
        if (C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)).length() > 0) {
            C1720g.m3537RQ();
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0) {
                z = false;
                C4990ab.m7417i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
                AppMethodBeat.m2505o(58394);
                return z;
            }
        }
        z = true;
        C4990ab.m7417i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", Boolean.valueOf(z));
        AppMethodBeat.m2505o(58394);
        return z;
    }

    /* renamed from: b */
    public static void m64132b(int i, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.m2504i(58395);
        C7290b c7290b = new C7290b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(255);
        try {
            byte[] jQ;
            boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
            C4990ab.m7417i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret:" + unpack + ", noticeid:" + unpack, Integer.valueOf(pInt3.value));
            if (pInt3.value != 0) {
                C6488hm c6488hm = new C6488hm();
                c6488hm.cCo.cCp = pInt3.value;
                boolean m = C4879a.xxA.mo10055m(c6488hm);
                C4990ab.m7417i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                pInt3.value = 0;
            }
            if (pInt2.value == 13) {
                C1720g.m3537RQ();
                jQ = C1720g.m3535RO().mo5189jQ(3);
                pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(jQ, pByteArray2.value);
                C4990ab.m7416i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession" + (jQ == null ? -1 : jQ.length) + " new pr[" + pByteArray2.value + ": " + (pByteArray2.value == null ? -1 : pByteArray2.value.length) + "]");
            }
            if (unpack) {
                c7290b.vym = pInt4.value;
                if (pInt.value == -13) {
                    c7290b.vyl = pInt.value;
                    C4990ab.m7412e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
                    AppMethodBeat.m2505o(58395);
                    return;
                }
                int P = c7290b.mo5744P(pByteArray2.value);
                C4990ab.m7410d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                c7290b.vyl = P;
                c7290b.bufferSize = (long) bArr.length;
                C1720g.m3537RQ();
                byte[] anf = C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)));
                jQ = C1946aa.m4150a(c7290b.vyH.vTO);
                C1720g.m3537RQ();
                C1720g.m3534RN().mo5163cd(c7290b.vyH.jBT, c7290b.vyH.wIy);
                C1668a.m3403jO(c7290b.vyH.jBT);
                if (C5046bo.m7540cb(jQ) || !C44098aa.m79383k(anf, jQ)) {
                    C4990ab.m7412e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                    AppMethodBeat.m2505o(58395);
                    return;
                }
                ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44215a(c7290b, i, j);
                if (pInt3.value != 0) {
                    C6488hm c6488hm2 = new C6488hm();
                    c6488hm2.cCo.cCp = pInt3.value;
                    boolean m2 = C4879a.xxA.mo10055m(c6488hm2);
                    C4990ab.m7417i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                    pInt3.value = 0;
                }
                AppMethodBeat.m2505o(58395);
                return;
            }
            C4990ab.m7412e("MicroMsg.NewSyncMgr", "unpack push resp failed");
            AppMethodBeat.m2505o(58395);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", e);
            C4990ab.printErrStackTrace("MicroMsg.NewSyncMgr", e, "", new Object[0]);
        }
    }
}
