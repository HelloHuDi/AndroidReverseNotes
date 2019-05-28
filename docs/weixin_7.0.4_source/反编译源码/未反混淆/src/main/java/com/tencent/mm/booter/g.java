package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.l;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.network.aa;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;

public final class g {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        AppMethodBeat.i(57809);
        ab.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 1) {
            eQ(2);
            AppMethodBeat.o(57809);
            return true;
        } else if (i != 2) {
            AppMethodBeat.o(57809);
            return false;
        } else {
            switch (i2) {
                case 138:
                    long j2;
                    if (bArr == null) {
                        j2 = 7;
                    } else {
                        j2 = (long) o.t(bArr, 0);
                    }
                    eQ(j2);
                    break;
                case 268369921:
                    if (bo.cb(bArr) || bArr.length <= 8) {
                        ab.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int t = o.t(bArr, 0);
                    int t2 = o.t(bArr, 4);
                    ab.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + t + " bufLen:" + t2 + " dump:" + bo.W(bArr, 8));
                    if (t2 != bArr.length - 8) {
                        ab.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    byte[] bArr3 = new byte[t2];
                    System.arraycopy(bArr, 8, bArr3, 0, t2);
                    b bVar = new b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    PInt pInt4 = new PInt(255);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, bArr3, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                        if (pInt3.value != 0) {
                            hm hmVar = new hm();
                            hmVar.cCo.cCp = pInt3.value;
                            boolean m = a.xxA.m(hmVar);
                            ab.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                            pInt3.value = 0;
                        }
                        if (!(pInt2.value != 13 || aa.ano() == null || aa.ano().gcU == null)) {
                            byte[] jQ = aa.ano().gcU.jQ(3);
                            pByteArray2.value = UtilsJni.AesGcmDecryptWithUncompress(jQ, pByteArray2.value);
                            String str = "MicroMsg.NotifySyncMgr";
                            String str2 = "summerdiz dealWithPushResp unpack AES_GCM_ENCRYPT serverSession[%s] new pr[%s, %s]";
                            Object[] objArr = new Object[3];
                            objArr[0] = Integer.valueOf(jQ == null ? -1 : jQ.length);
                            objArr[1] = pByteArray2.value;
                            objArr[2] = Integer.valueOf(pByteArray2.value == null ? -1 : pByteArray2.value.length);
                            ab.i(str, str2, objArr);
                        }
                        if (!unpack) {
                            ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                            break;
                        }
                        bVar.vym = pInt4.value;
                        if (pInt.value != -13) {
                            t2 = bVar.P(pByteArray2.value);
                            ab.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                            bVar.vyl = t2;
                            bVar.bufferSize = (long) bArr3.length;
                            byte[] anf = bo.anf(ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).getString("notify_sync_key_keybuf", ""));
                            bArr3 = com.tencent.mm.platformtools.aa.a(bVar.vyH.vTO);
                            if (!bo.cb(bArr3) && com.tencent.mm.protocal.aa.k(anf, bArr3)) {
                                new com.tencent.mm.modelmulti.b(bVar, t, j).a(aa.ano(), new f() {
                                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                        AppMethodBeat.i(57807);
                                        ab.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                                        AppMethodBeat.o(57807);
                                    }
                                });
                                if (pInt3.value != 0) {
                                    hm hmVar2 = new hm();
                                    hmVar2.cCo.cCp = pInt3.value;
                                    boolean m2 = a.xxA.m(hmVar2);
                                    ab.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m2));
                                    pInt3.value = 0;
                                    break;
                                }
                            }
                            ab.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                            break;
                        }
                        bVar.vyl = pInt.value;
                        ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                        break;
                    } catch (Exception e) {
                        ab.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", e);
                        ab.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    x.b bVar2 = new x.b();
                    try {
                        bVar2.P(bArr);
                        eQ(bVar2.vyM);
                        break;
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    eQ(7);
                    break;
            }
            AppMethodBeat.o(57809);
            return true;
        }
    }

    private static void eQ(long j) {
        AppMethodBeat.i(57810);
        ab.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = ".concat(String.valueOf(j)));
        if ((256 & j) != 0) {
            rv rvVar = new rv();
            rvVar.cNO.cvp = 4;
            a.xxA.m(rvVar);
        }
        if ((2097152 & j) != 0) {
            a.xxA.m(new lx());
        }
        if ((((-257 & j) & -2097153) & 2) != 0) {
            new com.tencent.mm.modelmulti.b().a(aa.ano(), new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(57808);
                    ab.i("MicroMsg.NotifySyncMgr", "onGYNetEnd: %d [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.o(57808);
                }
            });
        }
        AppMethodBeat.o(57810);
    }

    public static byte[] a(PInt pInt, int i) {
        AppMethodBeat.i(57811);
        String ij = ij(i);
        int jH = jH(ij);
        for (int i2 = 1; i2 <= jH; i2++) {
            String str = ij + "/syncResp.bin" + i2;
            if (e.ct(str)) {
                byte[] f = e.f(str, 0, -1);
                if (bo.cb(f)) {
                    ab.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    f = e.f(str, 0, -1);
                }
                byte[] c = l.c(f, com.tencent.mm.a.g.x((q.LK() + i).getBytes()).getBytes());
                ab.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", Integer.valueOf(i2), Integer.valueOf(jH), J(f), J(c), J(r6.getBytes()));
                if (!bo.cb(c)) {
                    pInt.value = i2;
                    AppMethodBeat.o(57811);
                    return c;
                }
            }
        }
        AppMethodBeat.o(57811);
        return null;
    }

    public static void bO(int i, int i2) {
        AppMethodBeat.i(57812);
        String ij = ij(i2);
        int jH = jH(ij);
        e.deleteFile(ij + "/syncResp.bin" + i);
        ab.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", Integer.valueOf(i), Integer.valueOf(jH));
        if (i == jH) {
            e.deleteFile(ij + "/syncResp.ini");
            ab.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
        AppMethodBeat.o(57812);
    }

    public static int jH(String str) {
        int i = 0;
        AppMethodBeat.i(57813);
        byte[] f = e.f(str + "/syncResp.ini", i, -1);
        if (bo.cb(f)) {
            AppMethodBeat.o(57813);
        } else {
            try {
                i = Integer.parseInt(new String(f));
                AppMethodBeat.o(57813);
            } catch (NumberFormatException e) {
                AppMethodBeat.o(57813);
            }
        }
        return i;
    }

    public static String ij(int i) {
        AppMethodBeat.i(57814);
        String str = ac.eSj + com.tencent.mm.a.g.x("mm".concat(String.valueOf(i)).getBytes()) + "/pushSyncResp";
        e.cw(str);
        AppMethodBeat.o(57814);
        return str;
    }

    public static String J(byte[] bArr) {
        AppMethodBeat.i(57815);
        String str;
        if (bo.cb(bArr)) {
            str = "buf is nullOrNil";
            AppMethodBeat.o(57815);
            return str;
        } else if (bArr.length == 1) {
            str = "buf.len is 1: " + Integer.toHexString(bArr[0]);
            AppMethodBeat.o(57815);
            return str;
        } else {
            str = "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
            AppMethodBeat.o(57815);
            return str;
        }
    }
}
