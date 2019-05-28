package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.cao;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbt;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String qHv;
    private static LinkedHashMap<Long, Integer> qHw;
    private static Comparator<cat> qHx = new Comparator<cat>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((cat) obj).pcX - ((cat) obj2).pcX;
        }
    };

    static {
        AppMethodBeat.i(36096);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        qHv = stringBuilder.append(g.RP().cachePath).append("sns_recvd_ad").toString();
        AppMethodBeat.o(36096);
    }

    public static void a(cai cai, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.i(36066);
        if (cai == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36066);
        } else if (cai.wZu == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36066);
        } else {
            e b = b(cai);
            if (b == null) {
                AppMethodBeat.o(36066);
                return;
            }
            b.field_adinfo = a(b.field_adinfo, sKBuiltinBuffer_t);
            if (af.cnI().kv(cai.wZu.vQE)) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + cai.wZu.vQE);
                af.cnI().b(cai.wZu.vQE, b);
                AppMethodBeat.o(36066);
                return;
            }
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + cai.wZu.vQE);
            AppMethodBeat.o(36066);
        }
    }

    public static void a(cbt cbt) {
        AppMethodBeat.i(36067);
        a(b(cbt));
        AppMethodBeat.o(36067);
    }

    public static void a(cai cai) {
        AppMethodBeat.i(36068);
        if (cai == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36068);
        } else if (cai.wZu == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36068);
        } else {
            af.cnI().a(cai.wZu.vQE, b(cai));
            AppMethodBeat.o(36068);
        }
    }

    public static void a(cy cyVar) {
        AppMethodBeat.i(36069);
        if (cyVar == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
            AppMethodBeat.o(36069);
        } else if (cyVar.vEX == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
            AppMethodBeat.o(36069);
        } else if (cyVar.vEX.wZu == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
            AppMethodBeat.o(36069);
        } else {
            if (af.cnI().kv(cyVar.vEX.wZu.vQE)) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
                a(cyVar.vEX);
            } else {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (cyVar.vEX.wZu.xas > 0) {
                    currentTimeMillis = ((cat) cyVar.vEX.wZu.xat.get(0)).pcX;
                }
                a(cyVar, currentTimeMillis, currentTimeMillis);
                e ku = af.cnI().ku(cyVar.vEX.wZu.vQE);
                if (ku != null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
                    ku.field_localFlag |= 256;
                    af.cnI().a(ku.field_snsId, ku);
                }
            }
            e ku2 = af.cnI().ku(cyVar.vEX.wZu.vQE);
            if (ku2 != null) {
                ku2.field_atAdinfo = aa.a(cyVar.vEY);
                bs cqv = ku2.cqv();
                if (cqv == null) {
                    cqv = new bs();
                }
                cqv.vDZ = cyVar.vFa;
                if (cqv.vDZ != null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid %d", Integer.valueOf(cqv.vDZ.wTz));
                }
                ku2.a(cqv);
                af.cnI().a(ku2.field_snsId, ku2);
            }
            AppMethodBeat.o(36069);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A:{Catch:{ IOException -> 0x0096 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void jX(long j) {
        AppMethodBeat.i(36070);
        e ku = af.cnI().ku(j);
        if (ku == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
            AppMethodBeat.o(36070);
            return;
        }
        try {
            cbf cbf = (cbf) new cbf().parseFrom(ku.field_attrBuf);
            if (cbf == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsObject is null!");
                AppMethodBeat.o(36070);
                return;
            }
            boolean z;
            if (cbf.xan == 0) {
                LinkedList<cat> linkedList = cbf.xat;
                String Yz = r.Yz();
                if (linkedList != null) {
                    for (cat cat : linkedList) {
                        if (cat == null || bo.isNullOrNil(cat.vHl) || !cat.vHl.equals(Yz)) {
                        }
                    }
                }
                z = false;
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "hasCommentLike %s", Boolean.valueOf(z));
                if (!z) {
                    af.cnI().delete(j);
                    af.cnK().ky(j);
                    i.kx(j);
                }
                AppMethodBeat.o(36070);
            }
            z = true;
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "hasCommentLike %s", Boolean.valueOf(z));
            if (z) {
            }
            AppMethodBeat.o(36070);
        } catch (IOException e) {
            ab.e("MicroMsg.AdSnsInfoStorageLogic", "parse SnsObject error!");
            AppMethodBeat.o(36070);
        }
    }

    private static e b(cai cai) {
        e eVar;
        AppMethodBeat.i(36071);
        e ku = af.cnI().ku(cai.wZu.vQE);
        cbf cbf = cai.wZu;
        String str = null;
        if (ku == null) {
            eVar = new e();
        } else {
            str = ku.cqu().rjC;
            eVar = ku;
        }
        String b = aa.b(cbf.xam);
        if (bo.isNullOrNil(b)) {
            AppMethodBeat.o(36071);
            return null;
        } else if (eVar.YR(b)) {
            TimeLineObject cqu;
            Iterator it;
            if (!bo.isNullOrNil(str)) {
                cqu = eVar.cqu();
                cqu.rjC = str;
                eVar.c(cqu);
            }
            cbf.xaD = aj.b(cbf.xaD, eVar.field_attrBuf);
            ab.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(cbf.vQE));
            cbf.xam.setBuffer(new byte[0]);
            eVar.field_userName = cbf.vHl;
            if (cai.wZv != null) {
                str = aa.a(cai.wZv);
                if (!bo.isNullOrNil(str)) {
                    eVar.field_recxml = str;
                }
                str = eVar.field_recxml;
                if (!(bo.isNullOrNil(str) || str.equals(eVar.field_adxml))) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(str)));
                    eVar.field_adxml = str;
                }
            }
            eVar.field_likeFlag = cbf.xan;
            long j = cbf.vQE;
            eVar.field_snsId = j;
            if (j != 0) {
                eVar.field_stringSeq = com.tencent.mm.plugin.sns.data.i.jV(j);
                eVar.field_stringSeq = com.tencent.mm.plugin.sns.data.i.Xl(eVar.field_stringSeq);
                ab.d("MicroMsg.AdSnsInfo", j + " stringSeq " + eVar.field_stringSeq);
            }
            eVar.DF(2);
            eVar.DF(32);
            try {
                cbf cbf2;
                LinkedList<cat> linkedList;
                Iterator it2;
                cat cat;
                Iterator it3;
                cat cat2;
                ad aoO;
                if (eVar.field_attrBuf == null) {
                    cbf2 = new cbf();
                } else {
                    cbf2 = (cbf) new cbf().parseFrom(eVar.field_attrBuf);
                }
                if (!(cbf2 == null || cbf2.xat == null)) {
                    linkedList = new LinkedList();
                    it2 = cbf.xat.iterator();
                    while (it2.hasNext()) {
                        cat = (cat) it2.next();
                        if (cat.wGu > 0) {
                            linkedList.add(cat);
                            it3 = cbf2.xat.iterator();
                            while (it3.hasNext()) {
                                cat2 = (cat) it3.next();
                                if (cat2.wZJ == cat.wZJ) {
                                    cbf2.xat.remove(cat2);
                                    break;
                                }
                            }
                        }
                    }
                    for (cat cat3 : linkedList) {
                        cbf.xat.remove(cat3);
                    }
                    linkedList.clear();
                    Iterator it4 = cbf2.xat.iterator();
                    while (it4.hasNext()) {
                        cat3 = (cat) it4.next();
                        if (!(b(cat3, cbf.xat) || cat3.wZJ == 0)) {
                            g.RQ();
                            aoO = ((j) g.K(j.class)).XM().aoO(cat3.vHl);
                            if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type) || aoO.Oa()) {
                                ab.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + cat3.vHl);
                            } else {
                                cbf.xat.add(cat3);
                                cbf.xas = cbf.xat.size();
                            }
                        }
                    }
                }
                Collections.sort(cbf.xat, qHx);
                if (cbf.xaq != null) {
                    linkedList = new LinkedList();
                    it2 = cbf.xaq.iterator();
                    while (it2.hasNext()) {
                        cat3 = (cat) it2.next();
                        if (cat3.wGu > 0) {
                            linkedList.add(cat3);
                            it3 = cbf2.xaq.iterator();
                            while (it3.hasNext()) {
                                cat2 = (cat) it3.next();
                                if (!bo.isNullOrNil(cat2.vHl)) {
                                    if (cat2.vHl.equals(cat3.vHl)) {
                                    }
                                }
                                cbf2.xaq.remove(cat2);
                            }
                        }
                    }
                    for (cat cat32 : linkedList) {
                        cbf.xaq.remove(cat32);
                    }
                    linkedList.clear();
                    if (!(cbf2 == null || cbf2.xaq == null)) {
                        it = cbf2.xaq.iterator();
                        while (it.hasNext()) {
                            cat32 = (cat) it.next();
                            if (!a(cat32, cbf.xaq)) {
                                g.RQ();
                                aoO = ((j) g.K(j.class)).XM().aoO(cat32.vHl);
                                if (aoO == null || !com.tencent.mm.n.a.jh(aoO.field_type) || aoO.Oa()) {
                                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + cat32.vHl);
                                } else {
                                    cbf.xaq.add(cat32);
                                    cbf.xap = cbf.xaq.size();
                                }
                            }
                        }
                    }
                    Collections.sort(cbf.xaq, qHx);
                }
            } catch (Exception e) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
                ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            try {
                eVar.bi(cbf.toByteArray());
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
            }
            cqu = eVar.cqu();
            cqu.jBB = cbf.vHl;
            eVar.field_pravited = cqu.wEJ;
            ab.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + cbf.wGz + " " + cbf.xat.size() + " " + cbf.xaq.size());
            it = cqu.xfI.wbK.iterator();
            while (it.hasNext()) {
                ((bau) it.next()).qFG = true;
            }
            eVar.c(cqu);
            eVar.field_type = cqu.xfI.wbJ;
            eVar.field_subType = cqu.xfI.wbL;
            AppMethodBeat.o(36071);
            return eVar;
        } else {
            AppMethodBeat.o(36071);
            return null;
        }
    }

    private static boolean a(cat cat, List<cat> list) {
        AppMethodBeat.i(36072);
        for (cat cat2 : list) {
            if (!bo.isNullOrNil(cat.vHl) && cat.vHl.equals(cat2.vHl)) {
                AppMethodBeat.o(36072);
                return true;
            }
        }
        AppMethodBeat.o(36072);
        return false;
    }

    private static boolean b(cat cat, List<cat> list) {
        AppMethodBeat.i(36073);
        for (cat cat2 : list) {
            if (cat.wZJ == cat2.wZJ && cat2.wZJ != 0) {
                AppMethodBeat.o(36073);
                return true;
            }
        }
        AppMethodBeat.o(36073);
        return false;
    }

    private static void a(cy cyVar, int i, int i2) {
        AppMethodBeat.i(36074);
        if (cyVar == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36074);
        } else if (cyVar.vEX == null || cyVar.vEX.wZu == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.o(36074);
        } else {
            cbf cbf = cyVar.vEX.wZu;
            e b = b(cyVar.vEX);
            if (b == null) {
                ab.w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
                AppMethodBeat.o(36074);
                return;
            }
            String a;
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(aa.a(cyVar.vEY));
            TimeLineObject cqu = b.cqu();
            cdg cdg = new cdg();
            cdg.xcS = new cdh();
            cdg.xcS.xcW = aVar.qPj;
            cdg.xcS.xcV = cqu.Id;
            cdg.xcS.cvd = b.getSource();
            cdg.xcS.reJ = p.a(cdg.xcS);
            if (cqu.xfI.wbJ == 1) {
                cdg.xcS.qUe = 1;
            } else if (cqu.xfI.wbJ == 15) {
                cdg.xcS.qUe = 2;
            } else {
                cdg.xcS.qUe = 0;
            }
            cdg.xcS.xcX = b.cqt();
            try {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", cqu.Id, Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, ""), cdg.xcS.xcV, cdg.xcS.xcW);
                cqu.rjC = a;
                b.c(cqu);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (b == null) {
                AppMethodBeat.o(36074);
                return;
            }
            b.field_createTime = i;
            b.field_createAdTime = i2;
            a = aa.a(cyVar.vEX.wZv);
            if (!bo.isNullOrNil(a)) {
                b.field_recxml = a;
            }
            b.field_adinfo = aa.a(cyVar.vEY);
            b.field_adxml = b.field_recxml;
            af.cnI().a(cbf.vQE, b);
            AppMethodBeat.o(36074);
        }
    }

    private static cai b(cbt cbt) {
        AppMethodBeat.i(36075);
        if (cbt != null) {
            cai cai = new cai();
            cai.wZv = cbt.xbf;
            if (cai.wZv == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
            }
            cai.wZu = cbt.wZu;
            AppMethodBeat.o(36075);
            return cai;
        }
        AppMethodBeat.o(36075);
        return null;
    }

    private static cy a(bpx bpx) {
        AppMethodBeat.i(36076);
        if (bpx != null) {
            cy cyVar = new cy();
            cyVar.vEY = bpx.wSg;
            if (cyVar.vEY == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
                AppMethodBeat.o(36076);
                return null;
            }
            cyVar.vEX = b(bpx.wSf);
            AppMethodBeat.o(36076);
            return cyVar;
        }
        AppMethodBeat.o(36076);
        return null;
    }

    public static void b(bpx bpx) {
        AppMethodBeat.i(36077);
        cy a = a(bpx);
        if (a == null) {
            AppMethodBeat.o(36077);
            return;
        }
        int anT;
        com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(aa.a(a.vEY));
        int i = aVar.qTt;
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", Integer.valueOf(i), Integer.valueOf(i <= 0 ? 1 : i + 1), Integer.valueOf(af.cnF().Zg("")));
        Cursor ah = af.cnF().ah("", r6, anT);
        if (ah == null || ah.getCount() <= 0) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
            anT = (int) bo.anT();
        } else {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", Integer.valueOf(ah.getCount()));
            n nVar = new n();
            if (i < 0) {
                anT = 0;
            } else {
                anT = i;
            }
            if (ah.moveToPosition(anT)) {
                nVar.d(ah);
            } else {
                ah.moveToLast();
                nVar.d(ah);
            }
            anT = nVar.field_createTime + 1;
        }
        ah.close();
        ab.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.vEX.wZu.vQE + " ,createTime " + anT);
        a(a, anT, (int) bo.anT());
        b(a);
        a(a.vEX.wZu.vQE, aVar);
        AppMethodBeat.o(36077);
    }

    public static void e(LinkedList<bpx> linkedList, LinkedList<cbf> linkedList2) {
        AppMethodBeat.i(36078);
        if (linkedList != null) {
            LinkedList am = am(linkedList);
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + am.size() + " recObj to AdvertiseObj");
            Iterator it = am.iterator();
            while (it.hasNext()) {
                cy cyVar = (cy) it.next();
                if (jY(cyVar.vEX.wZu.vQE)) {
                    ab.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + cyVar.vEX.wZu.vQE);
                    it.remove();
                }
            }
            j(am, linkedList2);
        }
        AppMethodBeat.o(36078);
    }

    private static LinkedList<cy> am(LinkedList<bpx> linkedList) {
        AppMethodBeat.i(36079);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cy a = a((bpx) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        AppMethodBeat.o(36079);
        return linkedList2;
    }

    private static void j(List<cy> list, List<cbf> list2) {
        AppMethodBeat.i(36080);
        if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.o(36080);
            return;
        }
        int a = a((cbf) list2.get(list2.size() - 1));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                cy cyVar = (cy) list.get(i2);
                if (cyVar == null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (cyVar.vEX == null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (cyVar.vEX.wZu == null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else {
                    String a2 = aa.a(cyVar.vEY);
                    String a3 = aa.a(cyVar.vEX.wZv);
                    String b = aa.b(cyVar.vEX.wZu.xam);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(a2)));
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(a3)));
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                    b bVar = new b(a3);
                    if (bVar.qUC == 0 || !jY(bVar.qUC)) {
                        int i3 = a + 1;
                        if (aVar.qTt >= list2.size() || aVar.qTt < 0) {
                            ab.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.qTt);
                        } else {
                            i3 = a((cbf) list2.get(aVar.qTt)) + 1;
                            ab.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i3 + " pos " + aVar.qTt);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        ab.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                        a(cyVar, i3, currentTimeMillis);
                        jZ(cyVar.vEX.wZu.vQE);
                        jZ(bVar.qUC);
                        a(cyVar.vEX.wZu.vQE, aVar);
                    } else {
                        ab.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + bVar.qUC);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(36080);
                return;
            }
        }
    }

    public static void k(List<cy> list, List<cbf> list2) {
        AppMethodBeat.i(36081);
        if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.o(36081);
            return;
        }
        int a = a((cbf) list2.get(list2.size() - 1));
        for (int i = 0; i < list.size(); i++) {
            cy cyVar = (cy) list.get(i);
            if (cyVar == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
            } else if (cyVar.vEX == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
            } else if (cyVar.vEX.wZu == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
            } else {
                String a2 = aa.a(cyVar.vEY);
                String a3 = aa.a(cyVar.vEX.wZv);
                String b = aa.b(cyVar.vEX.wZu.xam);
                com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", a2, a3, b);
                int i2 = a + 1;
                if (aVar.qTt >= list2.size() || aVar.qTt < 0) {
                    ab.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.qTt);
                } else {
                    i2 = a((cbf) list2.get(aVar.qTt)) + 1;
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.qTt);
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                a(cyVar, i2, currentTimeMillis);
                e ku = af.cnI().ku(cyVar.vEX.wZu.vQE);
                if (ku != null) {
                    bs cqv = ku.cqv();
                    if (cqv == null) {
                        cqv = new bs();
                    }
                    cqv.vDY = cyVar.vFa;
                    if (cqv.vDY != null) {
                        ab.i("MicroMsg.AdSnsInfoStorageLogic", "update timeline remind info , aid:%d", Integer.valueOf(cqv.vDY.wTz));
                    }
                    ku.a(cqv);
                    ku.field_localFlag &= -257;
                    af.cnI().a(ku);
                }
                a(cyVar.vEX.wZu.vQE, aVar);
            }
        }
        AppMethodBeat.o(36081);
    }

    private static void a(long j, com.tencent.mm.plugin.sns.storage.a aVar) {
        AppMethodBeat.i(36082);
        if (!aVar.qTV || bo.isNullOrNil(aVar.qTU)) {
            AppMethodBeat.o(36082);
            return;
        }
        m mVar = new m(j, 1, aVar.qTU);
        g.RQ();
        g.RO().eJo.a(mVar, 0);
        AppMethodBeat.o(36082);
    }

    public static void an(LinkedList<bpx> linkedList) {
        AppMethodBeat.i(36083);
        if (!(linkedList == null || linkedList.isEmpty())) {
            LinkedList am = am(linkedList);
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + am.size() + " recObj to AdvertiseObj");
            ao(am);
        }
        AppMethodBeat.o(36083);
    }

    public static void ao(LinkedList<cy> linkedList) {
        AppMethodBeat.i(36084);
        if (linkedList == null) {
            AppMethodBeat.o(36084);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                b((cy) linkedList.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(36084);
                return;
            }
        }
    }

    private static void b(cy cyVar) {
        AppMethodBeat.i(36085);
        final String a = aa.a(cyVar.vEX.wZv);
        if (!bo.isNullOrNil(a) && new b(a).coK()) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(36062);
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.cql().f("adId", a, "adxml", 0);
                    AppMethodBeat.o(36062);
                }
            }, "predownloadAdLandingPages");
        }
        AppMethodBeat.o(36085);
    }

    public static void ap(LinkedList<cbf> linkedList) {
        AppMethodBeat.i(36086);
        if (linkedList == null) {
            AppMethodBeat.o(36086);
            return;
        }
        o cnF = af.cnF();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                cbf cbf = (cbf) linkedList.get(i2);
                if (cbf != null) {
                    n kD = cnF.kD(cbf.vQE);
                    if (kD != null) {
                        final TimeLineObject cqu = kD.cqu();
                        if (!(cqu == null || bo.isNullOrNil(cqu.rCK))) {
                            d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(36063);
                                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.cql().f("adId", cqu.rCK, "adxml", 0);
                                    AppMethodBeat.o(36063);
                                }
                            }, "preDownloadAdLandingPagesForSnsObject");
                        }
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(36086);
                return;
            }
        }
    }

    public static void XB(final String str) {
        AppMethodBeat.i(36087);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(36087);
            return;
        }
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36064);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.cql().f("adId", str, "adxml", 1);
                AppMethodBeat.o(36064);
            }
        }, "preDownloadAdLandingPagesForMsg");
        AppMethodBeat.o(36087);
    }

    private static int a(cbf cbf) {
        AppMethodBeat.i(36088);
        n kD = af.cnF().kD(cbf.vQE);
        int i;
        if (kD == null) {
            i = cbf.pcX;
            AppMethodBeat.o(36088);
            return i;
        }
        i = kD.field_createTime;
        AppMethodBeat.o(36088);
        return i;
    }

    public static boolean a(long j, cao cao, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(36089);
        if (cao != null) {
            can can = cao.wZN;
            if (!(can.jCt == 7 || can.jCt == 8 || can.jCt == 16)) {
                AppMethodBeat.o(36089);
                return false;
            }
        }
        String Yz = r.Yz();
        if (cao == null || cao.wZO == null || cao.wZO.wPm == null || !cao.wZO.wPm.equals(Yz)) {
            e ku = af.cnI().ku(j);
            if (ku == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", Long.valueOf(j));
                AppMethodBeat.o(36089);
                return false;
            }
            try {
                com.tencent.mm.plugin.sns.storage.a cqq;
                c cVar;
                cat cat;
                int i4;
                cbf cbf = (cbf) new cbf().parseFrom(ku.field_attrBuf);
                cbf.vQE = j;
                int i5 = ku.field_firstControlTime;
                can can2 = cao.wZN;
                int source;
                Object[] objArr;
                if (can2.jCt == 7) {
                    if (i2 > 0 && i5 + i2 < can2.pcX) {
                        if (z) {
                            if (af.cnF().YS(ku.cqA()) != null) {
                                cqq = ku.cqq();
                                if (cqq != null) {
                                    cVar = (c) g.K(c.class);
                                    source = ku.getSource();
                                    objArr = new Object[7];
                                    objArr[0] = Long.valueOf(v.Zm(ku.cqA()));
                                    objArr[1] = cqq.hnw;
                                    objArr[2] = Integer.valueOf(2);
                                    objArr[3] = Integer.valueOf(1);
                                    objArr[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                    objArr[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                    objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                    cVar.a(13182, source, objArr);
                                } else {
                                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                                }
                            } else {
                                ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                            }
                        }
                        ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + can2.pcX + "is over the time limit!");
                        AppMethodBeat.o(36089);
                        return false;
                    }
                } else if ((can2.jCt == 8 || can2.jCt == 16) && i3 > 0 && i5 + i3 < can2.pcX) {
                    if (z) {
                        if (af.cnF().YS(ku.cqA()) != null) {
                            cqq = ku.cqq();
                            if (cqq != null) {
                                cVar = (c) g.K(c.class);
                                source = ku.getSource();
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(v.Zm(ku.cqA()));
                                objArr[1] = cqq.hnw;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(2);
                                objArr[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                objArr[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                cVar.a(13182, source, objArr);
                            } else {
                                ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + can2.pcX + "is over the time limit!");
                    AppMethodBeat.o(36089);
                    return false;
                }
                int i6 = 0;
                Iterator it = cbf.xaq.iterator();
                while (it.hasNext()) {
                    cat = (cat) it.next();
                    if (cat.pcX <= i5 || !(cat == null || cat.vHl == null || !cat.vHl.equals(Yz))) {
                        i4 = i6;
                    } else {
                        i4 = i6 + 1;
                    }
                    i6 = i4;
                }
                int i7 = i6 + 0;
                i6 = 0;
                Iterator it2 = cbf.xat.iterator();
                while (it2.hasNext()) {
                    cat = (cat) it2.next();
                    if (cat.pcX <= i5 || !(cat == null || cat.vHl == null || !cat.vHl.equals(Yz))) {
                        i4 = i6;
                    } else {
                        i4 = i6 + 1;
                    }
                    i6 = i4;
                }
                i4 = i7 + i6;
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
                if (i4 >= i) {
                    if (z) {
                        n YS = af.cnF().YS(ku.cqA());
                        if (YS != null) {
                            cqq = YS.cqq();
                            if (cqq != null) {
                                cVar = (c) g.K(c.class);
                                i5 = ku.getSource();
                                Object[] objArr2 = new Object[7];
                                objArr2[0] = Long.valueOf(v.Zm(ku.cqA()));
                                objArr2[1] = cqq.hnw;
                                objArr2[2] = Integer.valueOf(1);
                                objArr2[3] = Integer.valueOf(2);
                                objArr2[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                objArr2[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                cVar.a(13182, i5, objArr2);
                            } else {
                                ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            ab.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    AppMethodBeat.o(36089);
                    return false;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            AppMethodBeat.o(36089);
            return true;
        }
        AppMethodBeat.o(36089);
        return true;
    }

    public static boolean a(long j, cao cao) {
        AppMethodBeat.i(36090);
        can can = cao.wZN;
        if (can.jCt == 7 || can.jCt == 8 || can.jCt == 16) {
            e ku = af.cnI().ku(j);
            if (ku == null) {
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(j)));
                AppMethodBeat.o(36090);
                return false;
            }
            try {
                cbf cbf = (cbf) new cbf().parseFrom(ku.field_attrBuf);
                cbf.vQE = j;
                Iterator it;
                cat cat;
                if (can.jCt == 7) {
                    it = cbf.xaq.iterator();
                    while (it.hasNext()) {
                        cat = (cat) it.next();
                        if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                            ab.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + cat.pcX + " ");
                            AppMethodBeat.o(36090);
                            return false;
                        }
                    }
                    cbf.xaq.add(ad.b(cao));
                } else if (can.jCt == 8 || can.jCt == 16) {
                    it = cbf.xat.iterator();
                    while (it.hasNext()) {
                        cat = (cat) it.next();
                        if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                            ab.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + cat.pcX + " ");
                            AppMethodBeat.o(36090);
                            return false;
                        }
                    }
                    cbf.xat.add(ad.b(cao));
                }
                ku.bi(cbf.toByteArray());
                af.cnI().a(cbf.vQE, ku);
            } catch (Exception e) {
                ab.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
                ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            AppMethodBeat.o(36090);
            return true;
        }
        AppMethodBeat.o(36090);
        return false;
    }

    private static boolean jY(long j) {
        AppMethodBeat.i(36091);
        cmF();
        if (qHw.get(Long.valueOf(j)) != null) {
            AppMethodBeat.o(36091);
            return true;
        }
        AppMethodBeat.o(36091);
        return false;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0035=Splitter:B:18:0x0035, B:26:0x0049=Splitter:B:26:0x0049, B:34:0x005d=Splitter:B:34:0x005d} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A:{SYNTHETIC, Splitter:B:21:0x0041} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055 A:{SYNTHETIC, Splitter:B:29:0x0055} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069 A:{SYNTHETIC, Splitter:B:37:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0073 A:{SYNTHETIC, Splitter:B:43:0x0073} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void cmF() {
        Throwable e;
        AppMethodBeat.i(36092);
        if (qHw == null) {
            byte[] aji = com.tencent.mm.pluginsdk.g.a.d.a.aji(qHv);
            if (aji != null) {
                ObjectInput objectInputStream;
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(aji));
                    try {
                        qHw = (LinkedHashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (StreamCorruptedException e3) {
                        e = e3;
                        try {
                            ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (qHw == null) {
                            }
                            AppMethodBeat.o(36092);
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                            }
                            AppMethodBeat.o(36092);
                            throw e;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (qHw == null) {
                        }
                        AppMethodBeat.o(36092);
                    } catch (ClassNotFoundException e7) {
                        e = e7;
                        ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (qHw == null) {
                        }
                        AppMethodBeat.o(36092);
                    }
                } catch (StreamCorruptedException e9) {
                    e = e9;
                    objectInputStream = null;
                    ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.o(36092);
                } catch (IOException e10) {
                    e = e10;
                    objectInputStream = null;
                    ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.o(36092);
                } catch (ClassNotFoundException e11) {
                    e = e11;
                    objectInputStream = null;
                    ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.o(36092);
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e12) {
                        }
                    }
                    AppMethodBeat.o(36092);
                    throw e;
                }
            }
            if (qHw == null) {
                cmG();
            }
        }
        AppMethodBeat.o(36092);
    }

    private static void cmG() {
        AppMethodBeat.i(36093);
        qHw = new LinkedHashMap<Long, Integer>(((int) Math.ceil(666.6666870117188d)) + 1) {
            /* Access modifiers changed, original: protected|final */
            public final boolean removeEldestEntry(Entry<Long, Integer> entry) {
                AppMethodBeat.i(36065);
                if (size() > 500 && entry != null) {
                    ab.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
                }
                if (size() > 500) {
                    AppMethodBeat.o(36065);
                    return true;
                }
                AppMethodBeat.o(36065);
                return false;
            }
        };
        AppMethodBeat.o(36093);
    }

    private static void jZ(long j) {
        AppMethodBeat.i(36094);
        if (j == 0) {
            AppMethodBeat.o(36094);
            return;
        }
        if (qHw == null) {
            cmF();
        }
        qHw.put(Long.valueOf(j), Integer.valueOf(0));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(qHw);
            objectOutputStream.flush();
            com.tencent.mm.pluginsdk.g.a.d.a.D(qHv, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            ab.e("MicroMsg.AdSnsInfoStorageLogic", bo.l(e));
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
            AppMethodBeat.o(36094);
        }
    }

    private static String a(String str, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        Throwable e;
        AppMethodBeat.i(36095);
        if (sKBuiltinBuffer_t == null || str == null) {
            ab.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            AppMethodBeat.o(36095);
            return str;
        }
        CharSequence charSequence;
        try {
            z zVar = new z();
            zVar.parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
            if (zVar.vAH != null) {
                String str2 = "<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))";
                String str3 = "";
                Iterator it = zVar.vAH.iterator();
                charSequence = str;
                while (it.hasNext()) {
                    try {
                        String str4;
                        cal cal = (cal) it.next();
                        if (cal.key != null) {
                            String format = String.format(str2, new Object[]{cal.key});
                            Matcher matcher = Pattern.compile(format).matcher(charSequence);
                            if (matcher.find()) {
                                String group = matcher.group(2);
                                if (group != null && group.length() > 0) {
                                    charSequence = charSequence.replaceAll(format + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[]{group}), String.format("<$1>%s</%s>", new Object[]{cal.value, group}));
                                    str4 = str3 + cal.key + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + cal.value + ";";
                                    str3 = str4;
                                }
                            }
                        }
                        str4 = str3;
                        str3 = str4;
                    } catch (Exception e2) {
                        e = e2;
                        ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "replace error occurs!", new Object[0]);
                        AppMethodBeat.o(36095);
                        return charSequence;
                    }
                }
                ab.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", str3);
                if (br.z(str, "ADInfo") == null) {
                    ab.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    AppMethodBeat.o(36095);
                    return str;
                }
            }
            Object obj = str;
        } catch (Exception e3) {
            e = e3;
            charSequence = str;
            ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "replace error occurs!", new Object[0]);
            AppMethodBeat.o(36095);
            return charSequence;
        }
        AppMethodBeat.o(36095);
        return charSequence;
    }
}
