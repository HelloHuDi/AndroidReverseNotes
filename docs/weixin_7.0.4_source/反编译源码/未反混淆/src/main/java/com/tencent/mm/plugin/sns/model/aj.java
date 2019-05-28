package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.a;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aj {
    private static Map<String, cbf> qMr = new ConcurrentHashMap();

    public static List<n> a(String str, boolean z, String str2, boolean z2) {
        Cursor b;
        AppMethodBeat.i(36537);
        if (z2) {
            b = af.cnF().b(str, 10, z, str2);
        } else {
            b = af.cnF().e(str, z, str2);
        }
        ArrayList arrayList = new ArrayList();
        if (b.getCount() == 0) {
            b.close();
            AppMethodBeat.o(36537);
            return arrayList;
        }
        if (b.moveToFirst()) {
            do {
                n nVar = new n();
                nVar.d(b);
                arrayList.add(nVar);
            } while (b.moveToNext());
        }
        b.close();
        AppMethodBeat.o(36537);
        return arrayList;
    }

    public static List<n> c(String str, boolean z, String str2) {
        Object obj;
        AppMethodBeat.i(36538);
        o cnF = af.cnF();
        String bp = o.bp(str, z);
        if (o.Zb(str2)) {
            bp = bp + " AND " + cnF.Zc(str2);
        }
        if (z) {
            obj = bp + o.rfq;
        } else {
            obj = bp + o.rfr;
        }
        ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(obj)));
        Cursor rawQuery = cnF.bSd.rawQuery(obj, null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(36538);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    n nVar = new n();
                    nVar.d(rawQuery);
                    arrayList.add(nVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(36538);
        }
        return arrayList;
    }

    public static n XX(String str) {
        AppMethodBeat.i(36539);
        Cursor b = af.cnF().b(str, 1, false, "");
        if (b.getCount() == 0) {
            b.close();
            AppMethodBeat.o(36539);
            return null;
        }
        b.moveToFirst();
        n nVar = new n();
        nVar.d(b);
        if (!b.isClosed()) {
            b.close();
        }
        AppMethodBeat.o(36539);
        return nVar;
    }

    public static void cnW() {
        AppMethodBeat.i(36540);
        if (qMr != null) {
            qMr.clear();
        }
        AppMethodBeat.o(36540);
    }

    public static cbf p(n nVar) {
        AppMethodBeat.i(36541);
        cbf c;
        try {
            c = af.cnE().c((cbf) new cbf().parseFrom(nVar.field_attrBuf));
            qMr.clear();
            AppMethodBeat.o(36541);
            return c;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            c = new cbf();
            AppMethodBeat.o(36541);
            return c;
        }
    }

    static {
        AppMethodBeat.i(36563);
        AppMethodBeat.o(36563);
    }

    public static cbf q(n nVar) {
        AppMethodBeat.i(36542);
        cbf cbf;
        try {
            if (nVar.reW == null) {
                nVar.reW = g.x(nVar.field_content) + g.x(nVar.field_attrBuf);
            }
            if (qMr.containsKey(nVar.reW)) {
                cbf = (cbf) qMr.get(nVar.reW);
                if (cbf != null) {
                    af.cnE().c(cbf);
                    AppMethodBeat.o(36542);
                    return cbf;
                }
            }
            cbf = (cbf) new cbf().parseFrom(nVar.field_attrBuf);
            qMr.put(nVar.reW, cbf);
            af.cnE().c(cbf);
            AppMethodBeat.o(36542);
            return cbf;
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            cbf = new cbf();
            AppMethodBeat.o(36542);
            return cbf;
        }
    }

    public static void b(long j, cao cao) {
        AppMethodBeat.i(36543);
        can can = cao.wZN;
        if (can.jCt != 9) {
            AppMethodBeat.o(36543);
            return;
        }
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(36543);
            return;
        }
        try {
            cbf cbf = (cbf) new cbf().parseFrom(kD.field_attrBuf);
            cbf.vQE = j;
            Iterator it = cbf.xat.iterator();
            while (it.hasNext()) {
                cat cat = (cat) it.next();
                if (cat.wZG == can.wZG && !bo.isNullOrNil(cat.vHl) && cat.vHl.equals(can.wPm)) {
                    cbf.xat.remove(cat);
                    break;
                }
            }
            kD.bi(cbf.toByteArray());
            af.cnF().a(cbf.vQE, kD);
            AppMethodBeat.o(36543);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            AppMethodBeat.o(36543);
        }
    }

    public static void c(long j, cao cao) {
        AppMethodBeat.i(36544);
        can can = cao.wZN;
        if (can.jCt != 13) {
            AppMethodBeat.o(36544);
            return;
        }
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(36544);
            return;
        }
        try {
            cbf cbf = (cbf) new cbf().parseFrom(kD.field_attrBuf);
            cbf.vQE = j;
            if (cbf.xaE == null) {
                cbf.xaE = new cbu();
            }
            if (can.jCt == 13) {
                Iterator it = cbf.xaE.xbh.iterator();
                while (it.hasNext()) {
                    if (((cbb) it.next()).vHl.equals(can.wPm)) {
                        AppMethodBeat.o(36544);
                        return;
                    }
                }
                cbb cbb = new cbb();
                cbb.wZK = can.wZK;
                cbb.pcX = can.pcX;
                cbb.vHl = can.wPm;
                cbf.xaE.xbh.add(cbb);
                cbf.xaE.xbg = cbf.xaE.xbh.size();
            }
            kD.bi(cbf.toByteArray());
            af.cnF().a(cbf.vQE, kD);
            AppMethodBeat.o(36544);
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            AppMethodBeat.o(36544);
        }
    }

    public static boolean a(long j, cao cao) {
        AppMethodBeat.i(36545);
        can can = cao.wZN;
        if (can.jCt == 1 || can.jCt == 2) {
            n kD = af.cnF().kD(j);
            if (kD == null) {
                AppMethodBeat.o(36545);
                return true;
            } else if (kD.field_type != 21 || com.tencent.mm.plugin.sns.lucky.a.g.cmw()) {
                try {
                    cbf cbf = (cbf) new cbf().parseFrom(kD.field_attrBuf);
                    cbf.vQE = j;
                    Iterator it;
                    cat cat;
                    if (can.jCt == 1) {
                        it = cbf.xaq.iterator();
                        while (it.hasNext()) {
                            cat = (cat) it.next();
                            if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                                AppMethodBeat.o(36545);
                                return true;
                            }
                        }
                        cbf.xaq.add(ad.b(cao));
                    } else if (can.jCt == 2) {
                        it = cbf.xat.iterator();
                        while (it.hasNext()) {
                            cat = (cat) it.next();
                            if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                                AppMethodBeat.o(36545);
                                return true;
                            }
                        }
                        cbf.xat.add(ad.b(cao));
                    }
                    kD.bi(cbf.toByteArray());
                    af.cnF().a(cbf.vQE, kD);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
                AppMethodBeat.o(36545);
                return true;
            } else {
                ab.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
                AppMethodBeat.o(36545);
                return false;
            }
        }
        AppMethodBeat.o(36545);
        return true;
    }

    public static long d(cbf cbf) {
        AppMethodBeat.i(36546);
        String str = "";
        n kD = af.cnF().kD(cbf.vQE);
        if (kD == null) {
            kD = new n();
        }
        long a = a(kD, cbf, str, 0);
        AppMethodBeat.o(36546);
        return a;
    }

    private static long a(n nVar, cbf cbf, String str, int i) {
        int i2 = 1;
        AppMethodBeat.i(36547);
        if (nVar == null) {
            nVar = new n();
        }
        long j;
        if (!af.cnE().kl(nVar.field_snsId)) {
            j = cbf.vQE;
            AppMethodBeat.o(36547);
            return j;
        } else if (cbf.xax != 0) {
            ab.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + cbf.vQE + "  " + i.jV(cbf.vQE));
            if (nVar.DI(i)) {
                i2 = 0;
            } else {
                nVar.DF(i);
            }
            if (i2 != 0) {
                af.cnF().a(cbf.vQE, nVar);
            }
            j = cbf.vQE;
            AppMethodBeat.o(36547);
            return j;
        } else {
            LinkedList linkedList = cbf.xat;
            ab.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", Long.valueOf(cbf.vQE), Integer.valueOf(linkedList.size()), i.jV(cbf.vQE));
            if (cbf.xam == null || cbf.xam.getBuffer() == null) {
                ab.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
                j = cbf.vQE;
                AppMethodBeat.o(36547);
                return j;
            }
            String str2 = new String(cbf.xam.getBuffer().toByteArray());
            ab.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", Long.valueOf(cbf.vQE));
            if (bo.isNullOrNil(str2)) {
                j = cbf.vQE;
                AppMethodBeat.o(36547);
                return j;
            } else if (nVar.YR(str2)) {
                int i3;
                cbf.xaD = b(cbf.xaD, nVar.field_attrBuf);
                ab.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(cbf.vQE));
                cbf.xam.setBuffer(new byte[0]);
                nVar.field_userName = cbf.vHl;
                nVar.ls(cbf.pcX);
                nVar.field_likeFlag = cbf.xan;
                nVar.kz(cbf.vQE);
                nVar.kB(cbf.vQE);
                nVar.DF(i);
                try {
                    long yz = bo.yz();
                    try {
                        if (nVar.field_type == 15) {
                            cbf cbf2 = (cbf) new cbf().parseFrom(nVar.field_attrBuf);
                            if (!(cbf2 == null || cbf2.xaF == null || cbf2.xaF.wOd <= 0)) {
                                cbf.xaF = cbf2.xaF;
                                ab.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", Integer.valueOf(cbf.xaF.wOd), Integer.valueOf(cbf.xaF.wOe), cbf.xaF.wOf, Long.valueOf(bo.az(yz)));
                            }
                        }
                    } catch (Exception e) {
                        ab.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", e.toString());
                    }
                    nVar.bi(cbf.toByteArray());
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
                }
                TimeLineObject cqu = nVar.cqu();
                cqu.jBB = cbf.vHl;
                int i4 = cqu.wEJ;
                nVar.field_pravited = i4;
                ab.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", Long.valueOf(cbf.vQE), Integer.valueOf(cbf.wGz));
                if ((cbf.wGz & 1) > 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    nVar.cqR();
                } else {
                    nVar.cqS();
                }
                if (i4 != 1 || i == 4) {
                    if (i4 == 1 || (!str.equals(cbf.vHl) && i == 4)) {
                        nVar.cqO();
                    }
                    nVar.c(cqu);
                    nVar.field_type = cqu.xfI.wbJ;
                    nVar.field_subType = cqu.xfI.wbL;
                    af.cnF().a(cbf.vQE, nVar);
                    j = cbf.vQE;
                    AppMethodBeat.o(36547);
                    return j;
                }
                ab.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
                AppMethodBeat.o(36547);
                return 0;
            } else {
                j = cbf.vQE;
                AppMethodBeat.o(36547);
                return j;
            }
        }
    }

    public static SKBuiltinBuffer_t b(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        SKBuiltinBuffer_t sKBuiltinBuffer_t2;
        AppMethodBeat.i(36548);
        if (bArr != null) {
            try {
                sKBuiltinBuffer_t2 = ((cbf) new cbf().parseFrom(bArr)).xaD;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                AppMethodBeat.o(36548);
                return null;
            }
        }
        sKBuiltinBuffer_t2 = null;
        if (sKBuiltinBuffer_t == null) {
            AppMethodBeat.o(36548);
            return sKBuiltinBuffer_t2;
        }
        cbn cbn = new cbn();
        if (sKBuiltinBuffer_t2 != null) {
            cbn = (cbn) cbn.parseFrom(sKBuiltinBuffer_t2.getBufferToBytes());
        }
        cbn cbn2 = (cbn) new cbn().parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
        if (cbn2.xaS == null) {
            cbn2.xaS = cbn.xaS;
        }
        if (cbn.xaR == null) {
            cbn2.xaR = null;
        } else if (cbn2.xaR == null) {
            cbn2.xaR = cbn.xaR;
        }
        sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t().setBuffer(cbn2.toByteArray());
        AppMethodBeat.o(36548);
        return sKBuiltinBuffer_t2;
    }

    private static String de(List<String> list) {
        AppMethodBeat.i(36549);
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = (String) it.next();
                if (str2.length() != 0) {
                    str = str2 + "," + str;
                }
            } else {
                AppMethodBeat.o(36549);
                return str2;
            }
        }
    }

    public static void a(String str, int i, LinkedList<cbf> linkedList, String str2) {
        AppMethodBeat.i(36550);
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(36550);
            return;
        }
        String str3;
        Cursor rawQuery;
        o cnF = af.cnF();
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= linkedList.size()) {
                break;
            }
            cbf cbf = (cbf) linkedList.get(i3);
            n kD = cnF.kD(cbf.vQE);
            if (kD == null) {
                kD = new n();
            }
            if (a(kD, cbf, str, i) != 0) {
                if (linkedList2.size() < 3 && (kD.field_type == 1 || kD.field_type == 15)) {
                    linkedList2.add(i.jV(kD.field_snsId));
                }
                arrayList.add(Long.valueOf(cbf.vQE));
            }
            i2 = i3 + 1;
        }
        if ((i == 4 || i == 8) && str2.equals("")) {
            String str4;
            l YX = af.cnJ().YX(str);
            if (YX != null) {
                str4 = YX.field_newerIds;
            } else {
                str4 = "";
            }
            ArrayList P = bo.P(bo.bc(str4, "").split(","));
            ab.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + de(linkedList2));
            while (linkedList2.size() < 3 && P.size() > 0) {
                str3 = (String) P.remove(0);
                if (str3 != null) {
                    i2 = 0;
                    while (true) {
                        int i4 = i2;
                        if (i4 >= linkedList2.size()) {
                            break;
                        }
                        str4 = (String) linkedList2.get(i4);
                        if (str3.compareTo(str4) == 0) {
                            break;
                        } else if (str3.compareTo(str4) > 0) {
                            linkedList2.add(0, str3);
                            break;
                        } else {
                            i2 = i4 + 1;
                        }
                    }
                    if (!linkedList2.contains(str3)) {
                        linkedList2.add(str3);
                    }
                }
            }
            ab.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + de(linkedList2));
            af.cnJ().gq(str, de(linkedList2));
        }
        str3 = i.Xl(i.jV(((cbf) linkedList.getLast()).vQE));
        ab.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
        o cnF2;
        Object crk;
        if (i == 2) {
            cnF2 = af.cnF();
            crk = o.crk();
            if (str2 == null || !str2.equals("")) {
                crk = crk + " AND " + cnF2.Zf(str2);
            }
            if (o.Zb(str3)) {
                crk = crk + " AND " + cnF2.Zc(str3);
            }
            ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(crk)));
            rawQuery = cnF2.bSd.rawQuery(crk, null);
        } else {
            boolean z;
            cnF2 = af.cnF();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            crk = o.bn(str, z);
            if (o.Zb(str2)) {
                crk = crk + " AND " + cnF2.Zf(str2);
            }
            if (o.Zb(str3)) {
                crk = crk + " AND " + cnF2.Zc(str3);
            }
            ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(crk)));
            rawQuery = cnF2.bSd.rawQuery(crk, null);
        }
        if (rawQuery == null) {
            AppMethodBeat.o(36550);
        } else if (rawQuery.moveToFirst()) {
            do {
                n nVar = new n();
                nVar.d(rawQuery);
                long j = nVar.field_snsId;
                if (nVar.cqV()) {
                    ab.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                } else if (nVar.cqW()) {
                    ab.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                } else if (!arrayList.contains(Long.valueOf(j))) {
                    nVar.DJ(i);
                    af.cnF().b(j, nVar);
                    ab.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.o(36550);
        } else {
            rawQuery.close();
            AppMethodBeat.o(36550);
        }
    }

    public static boolean ab(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean CY(int i) {
        Throwable e;
        AppMethodBeat.i(36551);
        ab.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(i)));
        n DK = af.cnF().DK(i);
        if (DK == null) {
            AppMethodBeat.o(36551);
            return false;
        }
        DK.cqX();
        DK.ls((int) (System.currentTimeMillis() / 1000));
        bav bav = null;
        try {
            bav bav2 = (bav) new bav().parseFrom(DK.field_postBuf);
            try {
                bav2.eRu = 0;
                bav2.wFi = System.currentTimeMillis();
                DK.field_postBuf = bav2.toByteArray();
                bav = bav2;
            } catch (Exception e2) {
                e = e2;
                bav = bav2;
                ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                if (bav == null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            if (bav == null) {
            }
        }
        if (bav == null) {
            AppMethodBeat.o(36551);
            return false;
        }
        af.cnF().b(i, DK);
        for (int i2 = 0; i2 < bav.wFf.size(); i2++) {
            int i3 = ((ayq) bav.wFf.get(i2)).wCt;
            r kE = af.cnu().kE((long) i3);
            if (kE != null) {
                kE.offset = 0;
                try {
                    bax bax = (bax) new bax().parseFrom(kE.rfI);
                    if (bax.wFD != 0) {
                        bax.wFD = 2;
                        bax.wFE = "";
                        kE.rfI = bax.toByteArray();
                        af.cnu().a(i3, kE);
                    }
                } catch (Exception e4) {
                    ab.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                    AppMethodBeat.o(36551);
                    return false;
                }
            }
        }
        AppMethodBeat.o(36551);
        return true;
    }

    public static boolean XY(String str) {
        AppMethodBeat.i(36552);
        boolean equals = com.tencent.mm.model.r.Yz().equals(str.trim());
        AppMethodBeat.o(36552);
        return equals;
    }

    public static List<n> cnX() {
        AppMethodBeat.i(36553);
        ArrayList arrayList = new ArrayList();
        o cnF = af.cnF();
        Cursor rawQuery = cnF.bSd.rawQuery(o.crl() + " AND " + o.rft + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(36553);
        } else {
            rawQuery.moveToFirst();
            do {
                n nVar = new n();
                nVar.d(rawQuery);
                arrayList.add(nVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.o(36553);
        }
        return arrayList;
    }

    public static String XZ(String str) {
        AppMethodBeat.i(36554);
        int i = 1;
        LinkedList linkedList = new LinkedList();
        Cursor cursor = af.cnL().getCursor();
        if (cursor.moveToFirst()) {
            do {
                t tVar = new t();
                tVar.d(cursor);
                linkedList.add(bo.bc(tVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        Object obj = str;
        while (linkedList.contains(obj)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            obj = append.append(i).toString();
            i = i2;
        }
        AppMethodBeat.o(36554);
        return obj;
    }

    public static n CZ(int i) {
        AppMethodBeat.i(36555);
        n nVar = new n();
        o cnF = af.cnF();
        ab.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", ((o.crm() + " and createTime < " + i) + o.rfn) + " LIMIT 1");
        Cursor rawQuery = cnF.bSd.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.o(36555);
            return null;
        } else if (rawQuery.moveToFirst()) {
            nVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(36555);
            return nVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(36555);
            return null;
        }
    }

    public static List<b> fY(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(36556);
        ArrayList arrayList = new ArrayList();
        db dbVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (e.ct(str3)) {
                dbVar = (db) new db().parseFrom(e.e(str3, 0, (int) e.asZ(str3)));
            }
            if (dbVar == null) {
                e.deleteFile(str3);
                dbVar = a.YD(new String(e.e(str4, 0, (int) e.asZ(str4))));
                e.b(str3, dbVar.toByteArray(), -1);
            }
            Iterator it = dbVar.vFk.iterator();
            while (it.hasNext()) {
                ary ary = (ary) it.next();
                str4 = ary.Name;
                Iterator it2 = ary.wbK.iterator();
                while (it2.hasNext()) {
                    bau bau = (bau) it2.next();
                    bau.Desc = str4;
                    b bVar = new b();
                    bVar.cNr = bau;
                    bVar.qQd = "";
                    int i2 = i + 1;
                    bVar.qQe = i;
                    arrayList.add(bVar);
                    i = i2;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        AppMethodBeat.o(36556);
        return arrayList;
    }

    public static bau a(n nVar, int i) {
        AppMethodBeat.i(36557);
        if (af.cnn()) {
            AppMethodBeat.o(36557);
            return null;
        } else if (nVar == null) {
            AppMethodBeat.o(36557);
            return null;
        } else {
            TimeLineObject cqu = nVar.cqu();
            if (cqu.xfI == null || cqu.xfI.wbK.size() == 0 || cqu.xfI.wbK.size() <= i) {
                AppMethodBeat.o(36557);
                return null;
            }
            bau bau = (bau) cqu.xfI.wbK.get(i);
            AppMethodBeat.o(36557);
            return bau;
        }
    }

    public static bau a(n nVar, String str) {
        AppMethodBeat.i(36558);
        TimeLineObject cqu = nVar.cqu();
        if (cqu.xfI == null || cqu.xfI.wbK.size() == 0) {
            AppMethodBeat.o(36558);
            return null;
        }
        Iterator it = cqu.xfI.wbK.iterator();
        while (it.hasNext()) {
            bau bau = (bau) it.next();
            if (bau.Id.equals(str)) {
                AppMethodBeat.o(36558);
                return bau;
            }
        }
        AppMethodBeat.o(36558);
        return null;
    }

    public static List<b> Ya(String str) {
        AppMethodBeat.i(36559);
        ArrayList arrayList = new ArrayList();
        if (af.cnn()) {
            AppMethodBeat.o(36559);
            return arrayList;
        }
        n YT = h.YT(str);
        if (YT == null) {
            AppMethodBeat.o(36559);
            return arrayList;
        }
        TimeLineObject cqu = YT.cqu();
        if (cqu.xfI == null || cqu.xfI.wbK.size() == 0) {
            AppMethodBeat.o(36559);
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = cqu.xfI.wbK.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                bau bau = (bau) it.next();
                b bVar = new b();
                bVar.cNr = bau;
                bVar.qQd = str;
                bVar.fDG = cqu.pcX;
                i = i2 + 1;
                bVar.qQe = i2;
                arrayList.add(bVar);
            } else {
                AppMethodBeat.o(36559);
                return arrayList;
            }
        }
    }

    public static List<b> df(List<String> list) {
        AppMethodBeat.i(36560);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.o(36560);
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String str = (String) it.next();
                b bVar = new b();
                bau bau = new bau();
                bau.Id = "pre_temp_extend_pic".concat(String.valueOf(str));
                bVar.cNr = bau;
                bVar.qQd = "";
                i = i2 + 1;
                bVar.qQe = i2;
                arrayList.add(bVar);
            } else {
                AppMethodBeat.o(36560);
                return arrayList;
            }
        }
    }

    public static void Da(int i) {
        AppMethodBeat.i(36561);
        ab.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(i)));
        n DK = af.cnF().DK(i);
        if (DK == null) {
            AppMethodBeat.o(36561);
            return;
        }
        Object obj;
        if ((DK.field_localFlag & 64) > 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            DK.field_localFlag &= -65;
        }
        af.cnF().b(i, DK);
        AppMethodBeat.o(36561);
    }

    public static void cnY() {
        AppMethodBeat.i(36562);
        Cursor df = af.cnF().df("", 0);
        if (df != null) {
            ab.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (df.moveToNext()) {
                n nVar = new n();
                nVar.d(df);
                ab.i("MicroMsg.SnsInfoStorageLogic", nVar.cqA());
            }
            ab.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            df.close();
        }
        AppMethodBeat.o(36562);
    }
}
