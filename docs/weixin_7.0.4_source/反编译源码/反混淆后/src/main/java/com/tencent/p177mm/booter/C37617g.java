package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.modelmulti.C42211b;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1182l;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32597lx;
import com.tencent.p177mm.p230g.p231a.C45364rv;
import com.tencent.p177mm.p230g.p231a.C6488hm;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.C4845x.C4847b;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;

/* renamed from: com.tencent.mm.booter.g */
public final class C37617g {

    /* renamed from: com.tencent.mm.booter.g$1 */
    static class C376181 implements C1202f {
        C376181() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(57807);
            C4990ab.m7417i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(57807);
        }
    }

    /* renamed from: com.tencent.mm.booter.g$2 */
    static class C376192 implements C1202f {
        C376192() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(57808);
            C4990ab.m7417i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(57808);
        }
    }

    /* renamed from: a */
    public static boolean m63508a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.m2504i(57809);
        C4990ab.m7417i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            C37617g.m63511eQ(2);
            AppMethodBeat.m2505o(57809);
            return true;
        } else if (i != 2) {
            AppMethodBeat.m2505o(57809);
            return false;
        } else {
            switch (i2) {
                case 138:
                    long j2;
                    if (bArr == null) {
                        j2 = 7;
                    } else {
                        j2 = (long) C37432o.m63092t(bArr, 0);
                    }
                    C37617g.m63511eQ(j2);
                    break;
                case 268369921:
                    if (C5046bo.m7540cb(bArr) || bArr.length <= 8) {
                        C4990ab.m7412e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int t = C37432o.m63092t(bArr, 0);
                    int t2 = C37432o.m63092t(bArr, 4);
                    C4990ab.m7410d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + t + " bufLen:" + t2 + " dump:" + C5046bo.m7511W(bArr, 8));
                    if (t2 != bArr.length - 8) {
                        C4990ab.m7412e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    byte[] bArr3 = new byte[t2];
                    System.arraycopy(bArr, 8, bArr3, 0, t2);
                    C7290b c7290b = new C7290b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    PInt pInt4 = new PInt(255);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr3, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                        if (pInt3.value != 0) {
                            C6488hm c6488hm = new C6488hm();
                            c6488hm.cCo.cCp = pInt3.value;
                            boolean m = C4879a.xxA.mo10055m(c6488hm);
                            C4990ab.m7417i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                            pInt3.value = 0;
                        }
                        if (!(pInt2.value != 13 || C1892aa.ano() == null || C1892aa.ano().gcU == null)) {
                            byte[] jQ = C1892aa.ano().gcU.mo5509jQ(3);
                            pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(jQ, pByteArray2.value);
                            String str = "MicroMsg.NotifySyncMgr";
                            String str2 = "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(jQ == null ? -1 : jQ.length);
                            objArr[1] = pByteArray2.value;
                            objArr[2] = Integer.valueOf(pByteArray2.value == null ? -1 : pByteArray2.value.length);
                            C4990ab.m7417i(str, str2, objArr);
                        }
                        if (!unpack) {
                            C4990ab.m7412e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                            break;
                        }
                        c7290b.vym = pInt4.value;
                        if (pInt.value != -13) {
                            t2 = c7290b.mo5744P(pByteArray2.value);
                            C4990ab.m7410d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                            c7290b.vyl = t2;
                            c7290b.bufferSize = (long) bArr3.length;
                            byte[] anf = C5046bo.anf(C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).getString("notify_sync_key_keybuf", ""));
                            bArr3 = C1946aa.m4150a(c7290b.vyH.vTO);
                            if (!C5046bo.m7540cb(bArr3) && C44098aa.m79383k(anf, bArr3)) {
                                new C42211b(c7290b, t, j).mo4456a(C1892aa.ano(), new C376181());
                                if (pInt3.value != 0) {
                                    C6488hm c6488hm2 = new C6488hm();
                                    c6488hm2.cCo.cCp = pInt3.value;
                                    boolean m2 = C4879a.xxA.mo10055m(c6488hm2);
                                    C4990ab.m7417i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                                    pInt3.value = 0;
                                    break;
                                }
                            }
                            C4990ab.m7412e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                            break;
                        }
                        c7290b.vyl = pInt.value;
                        C4990ab.m7412e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                        break;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e);
                        C4990ab.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    C4847b c4847b = new C4847b();
                    try {
                        c4847b.mo5744P(bArr);
                        C37617g.m63511eQ(c4847b.vyM);
                        break;
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    C37617g.m63511eQ(7);
                    break;
            }
            AppMethodBeat.m2505o(57809);
            return true;
        }
    }

    /* renamed from: eQ */
    private static void m63511eQ(long j) {
        AppMethodBeat.m2504i(57810);
        C4990ab.m7416i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(j)));
        if ((256 & j) != 0) {
            C45364rv c45364rv = new C45364rv();
            c45364rv.cNO.cvp = 4;
            C4879a.xxA.mo10055m(c45364rv);
        }
        if ((2097152 & j) != 0) {
            C4879a.xxA.mo10055m(new C32597lx());
        }
        if ((((-257 & j) & -2097153) & 2) != 0) {
            new C42211b().mo4456a(C1892aa.ano(), new C376192());
        }
        AppMethodBeat.m2505o(57810);
    }

    /* renamed from: a */
    public static byte[] m63509a(PInt pInt, int i) {
        AppMethodBeat.m2504i(57811);
        String ij = C37617g.m63512ij(i);
        int jH = C37617g.m63513jH(ij);
        for (int i2 = 1; i2 <= jH; i2++) {
            String str = ij + "/syncResp.bin" + i2;
            if (C1173e.m2561ct(str)) {
                byte[] f = C1173e.m2571f(str, 0, -1);
                if (C5046bo.m7540cb(f)) {
                    C4990ab.m7420w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    f = C1173e.m2571f(str, 0, -1);
                }
                byte[] c = C1182l.m2607c(f, C1178g.m2591x((C1427q.m3026LK() + i).getBytes()).getBytes());
                C4990ab.m7417i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i2), Integer.valueOf(jH), C37617g.m63507J(f), C37617g.m63507J(c), C37617g.m63507J(r6.getBytes()));
                if (!C5046bo.m7540cb(c)) {
                    pInt.value = i2;
                    AppMethodBeat.m2505o(57811);
                    return c;
                }
            }
        }
        AppMethodBeat.m2505o(57811);
        return null;
    }

    /* renamed from: bO */
    public static void m63510bO(int i, int i2) {
        AppMethodBeat.m2504i(57812);
        String ij = C37617g.m63512ij(i2);
        int jH = C37617g.m63513jH(ij);
        C1173e.deleteFile(ij + "/syncResp.bin" + i);
        C4990ab.m7417i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i), Integer.valueOf(jH));
        if (i == jH) {
            C1173e.deleteFile(ij + "/syncResp.ini");
            C4990ab.m7416i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
        AppMethodBeat.m2505o(57812);
    }

    /* renamed from: jH */
    public static int m63513jH(String str) {
        int i = 0;
        AppMethodBeat.m2504i(57813);
        byte[] f = C1173e.m2571f(str + "/syncResp.ini", i, -1);
        if (C5046bo.m7540cb(f)) {
            AppMethodBeat.m2505o(57813);
        } else {
            try {
                i = Integer.parseInt(new String(f));
                AppMethodBeat.m2505o(57813);
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(57813);
            }
        }
        return i;
    }

    /* renamed from: ij */
    public static String m63512ij(int i) {
        AppMethodBeat.m2504i(57814);
        String str = C5128ac.eSj + C1178g.m2591x("mm".concat(String.valueOf(i)).getBytes()) + "/pushSyncResp";
        C1173e.m2564cw(str);
        AppMethodBeat.m2505o(57814);
        return str;
    }

    /* renamed from: J */
    public static String m63507J(byte[] bArr) {
        AppMethodBeat.m2504i(57815);
        String str;
        if (C5046bo.m7540cb(bArr)) {
            str = "buf is nullOrNil";
            AppMethodBeat.m2505o(57815);
            return str;
        } else if (bArr.length == 1) {
            str = "buf.len is 1: " + Integer.toHexString(bArr[0]);
            AppMethodBeat.m2505o(57815);
            return str;
        } else {
            str = "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
            AppMethodBeat.m2505o(57815);
            return str;
        }
    }
}
