package com.tencent.p177mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21905g;
import com.tencent.p177mm.plugin.sns.p1025h.C21895a;
import com.tencent.p177mm.plugin.sns.p1025h.C34937b;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.plugin.sns.storage.C21990h;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C40509db;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ary;
import com.tencent.p177mm.protocal.protobuf.ayq;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbb;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbn;
import com.tencent.p177mm.protocal.protobuf.cbu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.sns.model.aj */
public final class C34955aj {
    private static Map<String, cbf> qMr = new ConcurrentHashMap();

    /* renamed from: a */
    public static List<C46236n> m57396a(String str, boolean z, String str2, boolean z2) {
        Cursor b;
        AppMethodBeat.m2504i(36537);
        if (z2) {
            b = C13373af.cnF().mo62929b(str, 10, z, str2);
        } else {
            b = C13373af.cnF().mo62937e(str, z, str2);
        }
        ArrayList arrayList = new ArrayList();
        if (b.getCount() == 0) {
            b.close();
            AppMethodBeat.m2505o(36537);
            return arrayList;
        }
        if (b.moveToFirst()) {
            do {
                C46236n c46236n = new C46236n();
                c46236n.mo8995d(b);
                arrayList.add(c46236n);
            } while (b.moveToNext());
        }
        b.close();
        AppMethodBeat.m2505o(36537);
        return arrayList;
    }

    /* renamed from: c */
    public static List<C46236n> m57402c(String str, boolean z, String str2) {
        Object obj;
        AppMethodBeat.m2504i(36538);
        C39789o cnF = C13373af.cnF();
        String bp = C39789o.m68085bp(str, z);
        if (C39789o.m68080Zb(str2)) {
            bp = bp + " AND " + cnF.mo62921Zc(str2);
        }
        if (z) {
            obj = bp + C39789o.rfq;
        } else {
            obj = bp + C39789o.rfr;
        }
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(obj)));
        Cursor rawQuery = cnF.bSd.rawQuery(obj, null);
        ArrayList arrayList = new ArrayList();
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.m2505o(36538);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    C46236n c46236n = new C46236n();
                    c46236n.mo8995d(rawQuery);
                    arrayList.add(c46236n);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.m2505o(36538);
        }
        return arrayList;
    }

    /* renamed from: XX */
    public static C46236n m57389XX(String str) {
        AppMethodBeat.m2504i(36539);
        Cursor b = C13373af.cnF().mo62929b(str, 1, false, "");
        if (b.getCount() == 0) {
            b.close();
            AppMethodBeat.m2505o(36539);
            return null;
        }
        b.moveToFirst();
        C46236n c46236n = new C46236n();
        c46236n.mo8995d(b);
        if (!b.isClosed()) {
            b.close();
        }
        AppMethodBeat.m2505o(36539);
        return c46236n;
    }

    public static void cnW() {
        AppMethodBeat.m2504i(36540);
        if (qMr != null) {
            qMr.clear();
        }
        AppMethodBeat.m2505o(36540);
    }

    /* renamed from: p */
    public static cbf m57408p(C46236n c46236n) {
        AppMethodBeat.m2504i(36541);
        cbf c;
        try {
            c = C13373af.cnE().mo37403c((cbf) new cbf().parseFrom(c46236n.field_attrBuf));
            qMr.clear();
            AppMethodBeat.m2505o(36541);
            return c;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            c = new cbf();
            AppMethodBeat.m2505o(36541);
            return c;
        }
    }

    static {
        AppMethodBeat.m2504i(36563);
        AppMethodBeat.m2505o(36563);
    }

    /* renamed from: q */
    public static cbf m57409q(C46236n c46236n) {
        AppMethodBeat.m2504i(36542);
        cbf cbf;
        try {
            if (c46236n.reW == null) {
                c46236n.reW = C1178g.m2591x(c46236n.field_content) + C1178g.m2591x(c46236n.field_attrBuf);
            }
            if (qMr.containsKey(c46236n.reW)) {
                cbf = (cbf) qMr.get(c46236n.reW);
                if (cbf != null) {
                    C13373af.cnE().mo37403c(cbf);
                    AppMethodBeat.m2505o(36542);
                    return cbf;
                }
            }
            cbf = (cbf) new cbf().parseFrom(c46236n.field_attrBuf);
            qMr.put(c46236n.reW, cbf);
            C13373af.cnE().mo37403c(cbf);
            AppMethodBeat.m2505o(36542);
            return cbf;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            cbf = new cbf();
            AppMethodBeat.m2505o(36542);
            return cbf;
        }
    }

    /* renamed from: b */
    public static void m57401b(long j, cao cao) {
        AppMethodBeat.m2504i(36543);
        can can = cao.wZN;
        if (can.jCt != 9) {
            AppMethodBeat.m2505o(36543);
            return;
        }
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(36543);
            return;
        }
        try {
            cbf cbf = (cbf) new cbf().parseFrom(kD.field_attrBuf);
            cbf.vQE = j;
            Iterator it = cbf.xat.iterator();
            while (it.hasNext()) {
                cat cat = (cat) it.next();
                if (cat.wZG == can.wZG && !C5046bo.isNullOrNil(cat.vHl) && cat.vHl.equals(can.wPm)) {
                    cbf.xat.remove(cat);
                    break;
                }
            }
            kD.mo74256bi(cbf.toByteArray());
            C13373af.cnF().mo62926a(cbf.vQE, kD);
            AppMethodBeat.m2505o(36543);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            AppMethodBeat.m2505o(36543);
        }
    }

    /* renamed from: c */
    public static void m57403c(long j, cao cao) {
        AppMethodBeat.m2504i(36544);
        can can = cao.wZN;
        if (can.jCt != 13) {
            AppMethodBeat.m2505o(36544);
            return;
        }
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(36544);
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
                        AppMethodBeat.m2505o(36544);
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
            kD.mo74256bi(cbf.toByteArray());
            C13373af.cnF().mo62926a(cbf.vQE, kD);
            AppMethodBeat.m2505o(36544);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            AppMethodBeat.m2505o(36544);
        }
    }

    /* renamed from: a */
    public static boolean m57398a(long j, cao cao) {
        AppMethodBeat.m2504i(36545);
        can can = cao.wZN;
        if (can.jCt == 1 || can.jCt == 2) {
            C46236n kD = C13373af.cnF().mo62941kD(j);
            if (kD == null) {
                AppMethodBeat.m2505o(36545);
                return true;
            } else if (kD.field_type != 21 || C21905g.cmw()) {
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
                                AppMethodBeat.m2505o(36545);
                                return true;
                            }
                        }
                        cbf.xaq.add(C21915ad.m33481b(cao));
                    } else if (can.jCt == 2) {
                        it = cbf.xat.iterator();
                        while (it.hasNext()) {
                            cat = (cat) it.next();
                            if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                                AppMethodBeat.m2505o(36545);
                                return true;
                            }
                        }
                        cbf.xat.add(C21915ad.m33481b(cao));
                    }
                    kD.mo74256bi(cbf.toByteArray());
                    C13373af.cnF().mo62926a(cbf.vQE, kD);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(36545);
                return true;
            } else {
                C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
                AppMethodBeat.m2505o(36545);
                return false;
            }
        }
        AppMethodBeat.m2505o(36545);
        return true;
    }

    /* renamed from: d */
    public static long m57404d(cbf cbf) {
        AppMethodBeat.m2504i(36546);
        String str = "";
        C46236n kD = C13373af.cnF().mo62941kD(cbf.vQE);
        if (kD == null) {
            kD = new C46236n();
        }
        long a = C34955aj.m57393a(kD, cbf, str, 0);
        AppMethodBeat.m2505o(36546);
        return a;
    }

    /* renamed from: a */
    private static long m57393a(C46236n c46236n, cbf cbf, String str, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(36547);
        if (c46236n == null) {
            c46236n = new C46236n();
        }
        long j;
        if (!C13373af.cnE().mo37409kl(c46236n.field_snsId)) {
            j = cbf.vQE;
            AppMethodBeat.m2505o(36547);
            return j;
        } else if (cbf.xax != 0) {
            C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + cbf.vQE + "  " + C29036i.m46117jV(cbf.vQE));
            if (c46236n.mo74253DI(i)) {
                i2 = 0;
            } else {
                c46236n.mo74252DF(i);
            }
            if (i2 != 0) {
                C13373af.cnF().mo62926a(cbf.vQE, c46236n);
            }
            j = cbf.vQE;
            AppMethodBeat.m2505o(36547);
            return j;
        } else {
            LinkedList linkedList = cbf.xat;
            C4990ab.m7417i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", Long.valueOf(cbf.vQE), Integer.valueOf(linkedList.size()), C29036i.m46117jV(cbf.vQE));
            if (cbf.xam == null || cbf.xam.getBuffer() == null) {
                C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
                j = cbf.vQE;
                AppMethodBeat.m2505o(36547);
                return j;
            }
            String str2 = new String(cbf.xam.getBuffer().toByteArray());
            C4990ab.m7411d("MicroMsg.SnsInfoStorageLogic", "from server %d ", Long.valueOf(cbf.vQE));
            if (C5046bo.isNullOrNil(str2)) {
                j = cbf.vQE;
                AppMethodBeat.m2505o(36547);
                return j;
            } else if (c46236n.mo74255YR(str2)) {
                int i3;
                cbf.xaD = C34955aj.m57400b(cbf.xaD, c46236n.field_attrBuf);
                C4990ab.m7411d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(cbf.vQE));
                cbf.xam.setBuffer(new byte[0]);
                c46236n.field_userName = cbf.vHl;
                c46236n.mo74294ls(cbf.pcX);
                c46236n.field_likeFlag = cbf.xan;
                c46236n.mo74293kz(cbf.vQE);
                c46236n.mo74292kB(cbf.vQE);
                c46236n.mo74252DF(i);
                try {
                    long yz = C5046bo.m7588yz();
                    try {
                        if (c46236n.field_type == 15) {
                            cbf cbf2 = (cbf) new cbf().parseFrom(c46236n.field_attrBuf);
                            if (!(cbf2 == null || cbf2.xaF == null || cbf2.xaF.wOd <= 0)) {
                                cbf.xaF = cbf2.xaF;
                                C4990ab.m7417i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", Integer.valueOf(cbf.xaF.wOd), Integer.valueOf(cbf.xaF.wOe), cbf.xaF.wOf, Long.valueOf(C5046bo.m7525az(yz)));
                            }
                        }
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", e.toString());
                    }
                    c46236n.mo74256bi(cbf.toByteArray());
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
                }
                TimeLineObject cqu = c46236n.cqu();
                cqu.jBB = cbf.vHl;
                int i4 = cqu.wEJ;
                c46236n.field_pravited = i4;
                C4990ab.m7417i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", Long.valueOf(cbf.vQE), Integer.valueOf(cbf.wGz));
                if ((cbf.wGz & 1) > 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    c46236n.cqR();
                } else {
                    c46236n.cqS();
                }
                if (i4 != 1 || i == 4) {
                    if (i4 == 1 || (!str.equals(cbf.vHl) && i == 4)) {
                        c46236n.cqO();
                    }
                    c46236n.mo74257c(cqu);
                    c46236n.field_type = cqu.xfI.wbJ;
                    c46236n.field_subType = cqu.xfI.wbL;
                    C13373af.cnF().mo62926a(cbf.vQE, c46236n);
                    j = cbf.vQE;
                    AppMethodBeat.m2505o(36547);
                    return j;
                }
                C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
                AppMethodBeat.m2505o(36547);
                return 0;
            } else {
                j = cbf.vQE;
                AppMethodBeat.m2505o(36547);
                return j;
            }
        }
    }

    /* renamed from: b */
    public static SKBuiltinBuffer_t m57400b(SKBuiltinBuffer_t sKBuiltinBuffer_t, byte[] bArr) {
        SKBuiltinBuffer_t sKBuiltinBuffer_t2;
        AppMethodBeat.m2504i(36548);
        if (bArr != null) {
            try {
                sKBuiltinBuffer_t2 = ((cbf) new cbf().parseFrom(bArr)).xaD;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                AppMethodBeat.m2505o(36548);
                return null;
            }
        }
        sKBuiltinBuffer_t2 = null;
        if (sKBuiltinBuffer_t == null) {
            AppMethodBeat.m2505o(36548);
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
        AppMethodBeat.m2505o(36548);
        return sKBuiltinBuffer_t2;
    }

    /* renamed from: de */
    private static String m57405de(List<String> list) {
        AppMethodBeat.m2504i(36549);
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
                AppMethodBeat.m2505o(36549);
                return str2;
            }
        }
    }

    /* renamed from: a */
    public static void m57397a(String str, int i, LinkedList<cbf> linkedList, String str2) {
        AppMethodBeat.m2504i(36550);
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.m2505o(36550);
            return;
        }
        String str3;
        Cursor rawQuery;
        C39789o cnF = C13373af.cnF();
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList2 = new LinkedList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= linkedList.size()) {
                break;
            }
            cbf cbf = (cbf) linkedList.get(i3);
            C46236n kD = cnF.mo62941kD(cbf.vQE);
            if (kD == null) {
                kD = new C46236n();
            }
            if (C34955aj.m57393a(kD, cbf, str, i) != 0) {
                if (linkedList2.size() < 3 && (kD.field_type == 1 || kD.field_type == 15)) {
                    linkedList2.add(C29036i.m46117jV(kD.field_snsId));
                }
                arrayList.add(Long.valueOf(cbf.vQE));
            }
            i2 = i3 + 1;
        }
        if ((i == 4 || i == 8) && str2.equals("")) {
            String str4;
            C29097l YX = C13373af.cnJ().mo69179YX(str);
            if (YX != null) {
                str4 = YX.field_newerIds;
            } else {
                str4 = "";
            }
            ArrayList P = C5046bo.m7508P(C5046bo.m7532bc(str4, "").split(","));
            C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "newerIds " + C34955aj.m57405de(linkedList2));
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
            C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + C34955aj.m57405de(linkedList2));
            C13373af.cnJ().mo69183gq(str, C34955aj.m57405de(linkedList2));
        }
        str3 = C29036i.m46089Xl(C29036i.m46117jV(((cbf) linkedList.getLast()).vQE));
        C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
        C39789o cnF2;
        Object crk;
        if (i == 2) {
            cnF2 = C13373af.cnF();
            crk = C39789o.crk();
            if (str2 == null || !str2.equals("")) {
                crk = crk + " AND " + cnF2.mo62923Zf(str2);
            }
            if (C39789o.m68080Zb(str3)) {
                crk = crk + " AND " + cnF2.mo62921Zc(str3);
            }
            C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(crk)));
            rawQuery = cnF2.bSd.rawQuery(crk, null);
        } else {
            boolean z;
            cnF2 = C13373af.cnF();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            crk = C39789o.m68084bn(str, z);
            if (C39789o.m68080Zb(str2)) {
                crk = crk + " AND " + cnF2.mo62923Zf(str2);
            }
            if (C39789o.m68080Zb(str3)) {
                crk = crk + " AND " + cnF2.mo62921Zc(str3);
            }
            C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq ".concat(String.valueOf(crk)));
            rawQuery = cnF2.bSd.rawQuery(crk, null);
        }
        if (rawQuery == null) {
            AppMethodBeat.m2505o(36550);
        } else if (rawQuery.moveToFirst()) {
            do {
                C46236n c46236n = new C46236n();
                c46236n.mo8995d(rawQuery);
                long j = c46236n.field_snsId;
                if (c46236n.cqV()) {
                    C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                } else if (c46236n.cqW()) {
                    C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "die one ");
                } else if (!arrayList.contains(Long.valueOf(j))) {
                    c46236n.mo74254DJ(i);
                    C13373af.cnF().mo62930b(j, c46236n);
                    C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.m2505o(36550);
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(36550);
        }
    }

    /* renamed from: ab */
    public static boolean m57399ab(int i, boolean z) {
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
    /* renamed from: CY */
    public static boolean m57386CY(int i) {
        Throwable e;
        AppMethodBeat.m2504i(36551);
        C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　".concat(String.valueOf(i)));
        C46236n DK = C13373af.cnF().mo62914DK(i);
        if (DK == null) {
            AppMethodBeat.m2505o(36551);
            return false;
        }
        DK.cqX();
        DK.mo74294ls((int) (System.currentTimeMillis() / 1000));
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
                C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                if (bav == null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            C4990ab.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            if (bav == null) {
            }
        }
        if (bav == null) {
            AppMethodBeat.m2505o(36551);
            return false;
        }
        C13373af.cnF().mo62928b(i, DK);
        for (int i2 = 0; i2 < bav.wFf.size(); i2++) {
            int i3 = ((ayq) bav.wFf.get(i2)).wCt;
            C29098r kE = C13373af.cnu().mo25635kE((long) i3);
            if (kE != null) {
                kE.offset = 0;
                try {
                    bax bax = (bax) new bax().parseFrom(kE.rfI);
                    if (bax.wFD != 0) {
                        bax.wFD = 2;
                        bax.wFE = "";
                        kE.rfI = bax.toByteArray();
                        C13373af.cnu().mo25631a(i3, kE);
                    }
                } catch (Exception e4) {
                    C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                    AppMethodBeat.m2505o(36551);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(36551);
        return true;
    }

    /* renamed from: XY */
    public static boolean m57390XY(String str) {
        AppMethodBeat.m2504i(36552);
        boolean equals = C1853r.m3846Yz().equals(str.trim());
        AppMethodBeat.m2505o(36552);
        return equals;
    }

    public static List<C46236n> cnX() {
        AppMethodBeat.m2504i(36553);
        ArrayList arrayList = new ArrayList();
        C39789o cnF = C13373af.cnF();
        Cursor rawQuery = cnF.bSd.rawQuery(C39789o.crl() + " AND " + C39789o.rft + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.m2505o(36553);
        } else {
            rawQuery.moveToFirst();
            do {
                C46236n c46236n = new C46236n();
                c46236n.mo8995d(rawQuery);
                arrayList.add(c46236n);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.m2505o(36553);
        }
        return arrayList;
    }

    /* renamed from: XZ */
    public static String m57391XZ(String str) {
        AppMethodBeat.m2504i(36554);
        int i = 1;
        LinkedList linkedList = new LinkedList();
        Cursor cursor = C13373af.cnL().getCursor();
        if (cursor.moveToFirst()) {
            do {
                C13479t c13479t = new C13479t();
                c13479t.mo8995d(cursor);
                linkedList.add(C5046bo.m7532bc(c13479t.field_tagName, ""));
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
        AppMethodBeat.m2505o(36554);
        return obj;
    }

    /* renamed from: CZ */
    public static C46236n m57387CZ(int i) {
        AppMethodBeat.m2504i(36555);
        C46236n c46236n = new C46236n();
        C39789o cnF = C13373af.cnF();
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", ((C39789o.crm() + " and createTime < " + i) + C39789o.rfn) + " LIMIT 1");
        Cursor rawQuery = cnF.bSd.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            AppMethodBeat.m2505o(36555);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c46236n.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(36555);
            return c46236n;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(36555);
            return null;
        }
    }

    /* renamed from: fY */
    public static List<C34937b> m57407fY(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(36556);
        ArrayList arrayList = new ArrayList();
        C40509db c40509db = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (C5730e.m8628ct(str3)) {
                c40509db = (C40509db) new C40509db().parseFrom(C5730e.m8632e(str3, 0, (int) C5730e.asZ(str3)));
            }
            if (c40509db == null) {
                C5730e.deleteFile(str3);
                c40509db = C21895a.m33456YD(new String(C5730e.m8632e(str4, 0, (int) C5730e.asZ(str4))));
                C5730e.m8624b(str3, c40509db.toByteArray(), -1);
            }
            Iterator it = c40509db.vFk.iterator();
            while (it.hasNext()) {
                ary ary = (ary) it.next();
                str4 = ary.Name;
                Iterator it2 = ary.wbK.iterator();
                while (it2.hasNext()) {
                    bau bau = (bau) it2.next();
                    bau.Desc = str4;
                    C34937b c34937b = new C34937b();
                    c34937b.cNr = bau;
                    c34937b.qQd = "";
                    int i2 = i + 1;
                    c34937b.qQe = i;
                    arrayList.add(c34937b);
                    i = i2;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        AppMethodBeat.m2505o(36556);
        return arrayList;
    }

    /* renamed from: a */
    public static bau m57394a(C46236n c46236n, int i) {
        AppMethodBeat.m2504i(36557);
        if (C13373af.cnn()) {
            AppMethodBeat.m2505o(36557);
            return null;
        } else if (c46236n == null) {
            AppMethodBeat.m2505o(36557);
            return null;
        } else {
            TimeLineObject cqu = c46236n.cqu();
            if (cqu.xfI == null || cqu.xfI.wbK.size() == 0 || cqu.xfI.wbK.size() <= i) {
                AppMethodBeat.m2505o(36557);
                return null;
            }
            bau bau = (bau) cqu.xfI.wbK.get(i);
            AppMethodBeat.m2505o(36557);
            return bau;
        }
    }

    /* renamed from: a */
    public static bau m57395a(C46236n c46236n, String str) {
        AppMethodBeat.m2504i(36558);
        TimeLineObject cqu = c46236n.cqu();
        if (cqu.xfI == null || cqu.xfI.wbK.size() == 0) {
            AppMethodBeat.m2505o(36558);
            return null;
        }
        Iterator it = cqu.xfI.wbK.iterator();
        while (it.hasNext()) {
            bau bau = (bau) it.next();
            if (bau.f17915Id.equals(str)) {
                AppMethodBeat.m2505o(36558);
                return bau;
            }
        }
        AppMethodBeat.m2505o(36558);
        return null;
    }

    /* renamed from: Ya */
    public static List<C34937b> m57392Ya(String str) {
        AppMethodBeat.m2504i(36559);
        ArrayList arrayList = new ArrayList();
        if (C13373af.cnn()) {
            AppMethodBeat.m2505o(36559);
            return arrayList;
        }
        C46236n YT = C21990h.m33616YT(str);
        if (YT == null) {
            AppMethodBeat.m2505o(36559);
            return arrayList;
        }
        TimeLineObject cqu = YT.cqu();
        if (cqu.xfI == null || cqu.xfI.wbK.size() == 0) {
            AppMethodBeat.m2505o(36559);
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = cqu.xfI.wbK.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                bau bau = (bau) it.next();
                C34937b c34937b = new C34937b();
                c34937b.cNr = bau;
                c34937b.qQd = str;
                c34937b.fDG = cqu.pcX;
                i = i2 + 1;
                c34937b.qQe = i2;
                arrayList.add(c34937b);
            } else {
                AppMethodBeat.m2505o(36559);
                return arrayList;
            }
        }
    }

    /* renamed from: df */
    public static List<C34937b> m57406df(List<String> list) {
        AppMethodBeat.m2504i(36560);
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            AppMethodBeat.m2505o(36560);
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String str = (String) it.next();
                C34937b c34937b = new C34937b();
                bau bau = new bau();
                bau.f17915Id = "pre_temp_extend_pic".concat(String.valueOf(str));
                c34937b.cNr = bau;
                c34937b.qQd = "";
                i = i2 + 1;
                c34937b.qQe = i2;
                arrayList.add(c34937b);
            } else {
                AppMethodBeat.m2505o(36560);
                return arrayList;
            }
        }
    }

    /* renamed from: Da */
    public static void m57388Da(int i) {
        AppMethodBeat.m2504i(36561);
        C4990ab.m7410d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　".concat(String.valueOf(i)));
        C46236n DK = C13373af.cnF().mo62914DK(i);
        if (DK == null) {
            AppMethodBeat.m2505o(36561);
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
        C13373af.cnF().mo62928b(i, DK);
        AppMethodBeat.m2505o(36561);
    }

    public static void cnY() {
        AppMethodBeat.m2504i(36562);
        Cursor df = C13373af.cnF().mo62936df("", 0);
        if (df != null) {
            C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (df.moveToNext()) {
                C46236n c46236n = new C46236n();
                c46236n.mo8995d(df);
                C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", c46236n.cqA());
            }
            C4990ab.m7416i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            df.close();
        }
        AppMethodBeat.m2505o(36562);
    }
}
