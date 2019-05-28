package com.tencent.p177mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelstat.C26485p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C34998j;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.protocal.protobuf.C23375bs;
import com.tencent.p177mm.protocal.protobuf.C44200z;
import com.tencent.p177mm.protocal.protobuf.C46531cy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bpx;
import com.tencent.p177mm.protocal.protobuf.cai;
import com.tencent.p177mm.protocal.protobuf.cal;
import com.tencent.p177mm.protocal.protobuf.can;
import com.tencent.p177mm.protocal.protobuf.cao;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbt;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.protocal.protobuf.cdh;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
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

/* renamed from: com.tencent.mm.plugin.sns.model.a */
public final class C43555a {
    private static final String qHv;
    private static LinkedHashMap<Long, Integer> qHw;
    private static Comparator<cat> qHx = new C397441();

    /* renamed from: com.tencent.mm.plugin.sns.model.a$1 */
    static class C397441 implements Comparator<cat> {
        C397441() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((cat) obj).pcX - ((cat) obj2).pcX;
        }
    }

    static {
        AppMethodBeat.m2504i(36096);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        qHv = stringBuilder.append(C1720g.m3536RP().cachePath).append("sns_recvd_ad").toString();
        AppMethodBeat.m2505o(36096);
    }

    /* renamed from: a */
    public static void m77867a(cai cai, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        AppMethodBeat.m2504i(36066);
        if (cai == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36066);
        } else if (cai.wZu == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36066);
        } else {
            C43570e b = C43555a.m77878b(cai);
            if (b == null) {
                AppMethodBeat.m2505o(36066);
                return;
            }
            b.field_adinfo = C43555a.m77864a(b.field_adinfo, sKBuiltinBuffer_t);
            if (C13373af.cnI().mo69175kv(cai.wZu.vQE)) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "find this adobj and update" + cai.wZu.vQE);
                C13373af.cnI().mo69172b(cai.wZu.vQE, b);
                AppMethodBeat.m2505o(36066);
                return;
            }
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + cai.wZu.vQE);
            AppMethodBeat.m2505o(36066);
        }
    }

    /* renamed from: a */
    public static void m77868a(cbt cbt) {
        AppMethodBeat.m2504i(36067);
        C43555a.m77866a(C43555a.m77879b(cbt));
        AppMethodBeat.m2505o(36067);
    }

    /* renamed from: a */
    public static void m77866a(cai cai) {
        AppMethodBeat.m2504i(36068);
        if (cai == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36068);
        } else if (cai.wZu == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36068);
        } else {
            C13373af.cnI().mo69171a(cai.wZu.vQE, C43555a.m77878b(cai));
            AppMethodBeat.m2505o(36068);
        }
    }

    /* renamed from: a */
    public static void m77869a(C46531cy c46531cy) {
        AppMethodBeat.m2504i(36069);
        if (c46531cy == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject null");
            AppMethodBeat.m2505o(36069);
        } else if (c46531cy.vEX == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject is null");
            AppMethodBeat.m2505o(36069);
        } else if (c46531cy.vEX.wZu == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "advertiseObject.SnsADObject.SnsObject is null");
            AppMethodBeat.m2505o(36069);
        } else {
            if (C13373af.cnI().mo69175kv(c46531cy.vEX.wZu.vQE)) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "just update at SnsAdObject");
                C43555a.m77866a(c46531cy.vEX);
            } else {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "insert at adObject");
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (c46531cy.vEX.wZu.xas > 0) {
                    currentTimeMillis = ((cat) c46531cy.vEX.wZu.xat.get(0)).pcX;
                }
                C43555a.m77870a(c46531cy, currentTimeMillis, currentTimeMillis);
                C43570e ku = C13373af.cnI().mo69174ku(c46531cy.vEX.wZu.vQE);
                if (ku != null) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "set at ad invisible");
                    ku.field_localFlag |= 256;
                    C13373af.cnI().mo69171a(ku.field_snsId, ku);
                }
            }
            C43570e ku2 = C13373af.cnI().mo69174ku(c46531cy.vEX.wZu.vQE);
            if (ku2 != null) {
                ku2.field_atAdinfo = C1946aa.m4148a(c46531cy.vEY);
                C23375bs cqv = ku2.cqv();
                if (cqv == null) {
                    cqv = new C23375bs();
                }
                cqv.vDZ = c46531cy.vFa;
                if (cqv.vDZ != null) {
                    C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "update atFriend remindInfo, aid %d", Integer.valueOf(cqv.vDZ.wTz));
                }
                ku2.mo69151a(cqv);
                C13373af.cnI().mo69171a(ku2.field_snsId, ku2);
            }
            AppMethodBeat.m2505o(36069);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A:{Catch:{ IOException -> 0x0096 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: jX */
    public static void m77885jX(long j) {
        AppMethodBeat.m2504i(36070);
        C43570e ku = C13373af.cnI().mo69174ku(j);
        if (ku == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
            AppMethodBeat.m2505o(36070);
            return;
        }
        try {
            cbf cbf = (cbf) new cbf().parseFrom(ku.field_attrBuf);
            if (cbf == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "snsObject is null!");
                AppMethodBeat.m2505o(36070);
                return;
            }
            boolean z;
            if (cbf.xan == 0) {
                LinkedList<cat> linkedList = cbf.xat;
                String Yz = C1853r.m3846Yz();
                if (linkedList != null) {
                    for (cat cat : linkedList) {
                        if (cat == null || C5046bo.isNullOrNil(cat.vHl) || !cat.vHl.equals(Yz)) {
                        }
                    }
                }
                z = false;
                C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "hasCommentLike %s", Boolean.valueOf(z));
                if (!z) {
                    C13373af.cnI().delete(j);
                    C13373af.cnK().mo47208ky(j);
                    C21991i.m33620kx(j);
                }
                AppMethodBeat.m2505o(36070);
            }
            z = true;
            C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "hasCommentLike %s", Boolean.valueOf(z));
            if (z) {
            }
            AppMethodBeat.m2505o(36070);
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", "parse SnsObject error!");
            AppMethodBeat.m2505o(36070);
        }
    }

    /* renamed from: b */
    private static C43570e m77878b(cai cai) {
        C43570e c43570e;
        AppMethodBeat.m2504i(36071);
        C43570e ku = C13373af.cnI().mo69174ku(cai.wZu.vQE);
        cbf cbf = cai.wZu;
        String str = null;
        if (ku == null) {
            c43570e = new C43570e();
        } else {
            str = ku.cqu().rjC;
            c43570e = ku;
        }
        String b = C1946aa.m4153b(cbf.xam);
        if (C5046bo.isNullOrNil(b)) {
            AppMethodBeat.m2505o(36071);
            return null;
        } else if (c43570e.mo69150YR(b)) {
            TimeLineObject cqu;
            Iterator it;
            if (!C5046bo.isNullOrNil(str)) {
                cqu = c43570e.cqu();
                cqu.rjC = str;
                c43570e.mo69153c(cqu);
            }
            cbf.xaD = C34955aj.m57400b(cbf.xaD, c43570e.field_attrBuf);
            C4990ab.m7411d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(cbf.vQE));
            cbf.xam.setBuffer(new byte[0]);
            c43570e.field_userName = cbf.vHl;
            if (cai.wZv != null) {
                str = C1946aa.m4148a(cai.wZv);
                if (!C5046bo.isNullOrNil(str)) {
                    c43570e.field_recxml = str;
                }
                str = c43570e.field_recxml;
                if (!(C5046bo.isNullOrNil(str) || str.equals(c43570e.field_adxml))) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml ".concat(String.valueOf(str)));
                    c43570e.field_adxml = str;
                }
            }
            c43570e.field_likeFlag = cbf.xan;
            long j = cbf.vQE;
            c43570e.field_snsId = j;
            if (j != 0) {
                c43570e.field_stringSeq = C29036i.m46117jV(j);
                c43570e.field_stringSeq = C29036i.m46089Xl(c43570e.field_stringSeq);
                C4990ab.m7410d("MicroMsg.AdSnsInfo", j + " stringSeq " + c43570e.field_stringSeq);
            }
            c43570e.mo69148DF(2);
            c43570e.mo69148DF(32);
            try {
                cbf cbf2;
                LinkedList<cat> linkedList;
                Iterator it2;
                cat cat;
                Iterator it3;
                cat cat2;
                C7616ad aoO;
                if (c43570e.field_attrBuf == null) {
                    cbf2 = new cbf();
                } else {
                    cbf2 = (cbf) new cbf().parseFrom(c43570e.field_attrBuf);
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
                        if (!(C43555a.m77882b(cat3, cbf.xat) || cat3.wZJ == 0)) {
                            C1720g.m3537RQ();
                            aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(cat3.vHl);
                            if (aoO == null || !C7486a.m12942jh(aoO.field_type) || aoO.mo16698Oa()) {
                                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + cat3.vHl);
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
                                if (!C5046bo.isNullOrNil(cat2.vHl)) {
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
                            if (!C43555a.m77873a(cat32, cbf.xaq)) {
                                C1720g.m3537RQ();
                                aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(cat32.vHl);
                                if (aoO == null || !C7486a.m12942jh(aoO.field_type) || aoO.mo16698Oa()) {
                                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + cat32.vHl);
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
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            try {
                c43570e.mo69152bi(cbf.toByteArray());
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
            }
            cqu = c43570e.cqu();
            cqu.jBB = cbf.vHl;
            c43570e.field_pravited = cqu.wEJ;
            C4990ab.m7410d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + cbf.wGz + " " + cbf.xat.size() + " " + cbf.xaq.size());
            it = cqu.xfI.wbK.iterator();
            while (it.hasNext()) {
                ((bau) it.next()).qFG = true;
            }
            c43570e.mo69153c(cqu);
            c43570e.field_type = cqu.xfI.wbJ;
            c43570e.field_subType = cqu.xfI.wbL;
            AppMethodBeat.m2505o(36071);
            return c43570e;
        } else {
            AppMethodBeat.m2505o(36071);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m77873a(cat cat, List<cat> list) {
        AppMethodBeat.m2504i(36072);
        for (cat cat2 : list) {
            if (!C5046bo.isNullOrNil(cat.vHl) && cat.vHl.equals(cat2.vHl)) {
                AppMethodBeat.m2505o(36072);
                return true;
            }
        }
        AppMethodBeat.m2505o(36072);
        return false;
    }

    /* renamed from: b */
    private static boolean m77882b(cat cat, List<cat> list) {
        AppMethodBeat.m2504i(36073);
        for (cat cat2 : list) {
            if (cat.wZJ == cat2.wZJ && cat2.wZJ != 0) {
                AppMethodBeat.m2505o(36073);
                return true;
            }
        }
        AppMethodBeat.m2505o(36073);
        return false;
    }

    /* renamed from: a */
    private static void m77870a(C46531cy c46531cy, int i, int i2) {
        AppMethodBeat.m2504i(36074);
        if (c46531cy == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36074);
        } else if (c46531cy.vEX == null || c46531cy.vEX.wZu == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
            AppMethodBeat.m2505o(36074);
        } else {
            cbf cbf = c46531cy.vEX.wZu;
            C43570e b = C43555a.m77878b(c46531cy.vEX);
            if (b == null) {
                C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "adSnsInfo is null!");
                AppMethodBeat.m2505o(36074);
                return;
            }
            String a;
            C21980a c21980a = new C21980a(C1946aa.m4148a(c46531cy.vEY));
            TimeLineObject cqu = b.cqu();
            cdg cdg = new cdg();
            cdg.xcS = new cdh();
            cdg.xcS.xcW = c21980a.qPj;
            cdg.xcS.xcV = cqu.f15074Id;
            cdg.xcS.cvd = b.getSource();
            cdg.xcS.reJ = C26485p.m42200a(cdg.xcS);
            if (cqu.xfI.wbJ == 1) {
                cdg.xcS.qUe = 1;
            } else if (cqu.xfI.wbJ == 15) {
                cdg.xcS.qUe = 2;
            } else {
                cdg.xcS.qUe = 0;
            }
            cdg.xcS.xcX = b.cqt();
            try {
                C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", cqu.f15074Id, Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, ""), cdg.xcS.xcV, cdg.xcS.xcW);
                cqu.rjC = a;
                b.mo69153c(cqu);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (b == null) {
                AppMethodBeat.m2505o(36074);
                return;
            }
            b.field_createTime = i;
            b.field_createAdTime = i2;
            a = C1946aa.m4148a(c46531cy.vEX.wZv);
            if (!C5046bo.isNullOrNil(a)) {
                b.field_recxml = a;
            }
            b.field_adinfo = C1946aa.m4148a(c46531cy.vEY);
            b.field_adxml = b.field_recxml;
            C13373af.cnI().mo69171a(cbf.vQE, b);
            AppMethodBeat.m2505o(36074);
        }
    }

    /* renamed from: b */
    private static cai m77879b(cbt cbt) {
        AppMethodBeat.m2504i(36075);
        if (cbt != null) {
            cai cai = new cai();
            cai.wZv = cbt.xbf;
            if (cai.wZv == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
            }
            cai.wZu = cbt.wZu;
            AppMethodBeat.m2505o(36075);
            return cai;
        }
        AppMethodBeat.m2505o(36075);
        return null;
    }

    /* renamed from: a */
    private static C46531cy m77863a(bpx bpx) {
        AppMethodBeat.m2504i(36076);
        if (bpx != null) {
            C46531cy c46531cy = new C46531cy();
            c46531cy.vEY = bpx.wSg;
            if (c46531cy.vEY == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
                AppMethodBeat.m2505o(36076);
                return null;
            }
            c46531cy.vEX = C43555a.m77879b(bpx.wSf);
            AppMethodBeat.m2505o(36076);
            return c46531cy;
        }
        AppMethodBeat.m2505o(36076);
        return null;
    }

    /* renamed from: b */
    public static void m77880b(bpx bpx) {
        AppMethodBeat.m2504i(36077);
        C46531cy a = C43555a.m77863a(bpx);
        if (a == null) {
            AppMethodBeat.m2505o(36077);
            return;
        }
        int anT;
        C21980a c21980a = new C21980a(C1946aa.m4148a(a.vEY));
        int i = c21980a.qTt;
        C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", Integer.valueOf(i), Integer.valueOf(i <= 0 ? 1 : i + 1), Integer.valueOf(C13373af.cnF().mo62924Zg("")));
        Cursor ah = C13373af.cnF().mo62927ah("", r6, anT);
        if (ah == null || ah.getCount() <= 0) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
            anT = (int) C5046bo.anT();
        } else {
            C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", Integer.valueOf(ah.getCount()));
            C46236n c46236n = new C46236n();
            if (i < 0) {
                anT = 0;
            } else {
                anT = i;
            }
            if (ah.moveToPosition(anT)) {
                c46236n.mo8995d(ah);
            } else {
                ah.moveToLast();
                c46236n.mo8995d(ah);
            }
            anT = c46236n.field_createTime + 1;
        }
        ah.close();
        C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.vEX.wZu.vQE + " ,createTime " + anT);
        C43555a.m77870a(a, anT, (int) C5046bo.anT());
        C43555a.m77881b(a);
        C43555a.m77865a(a.vEX.wZu.vQE, c21980a);
        AppMethodBeat.m2505o(36077);
    }

    /* renamed from: e */
    public static void m77883e(LinkedList<bpx> linkedList, LinkedList<cbf> linkedList2) {
        AppMethodBeat.m2504i(36078);
        if (linkedList != null) {
            LinkedList am = C43555a.m77874am(linkedList);
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "convert " + am.size() + " recObj to AdvertiseObj");
            Iterator it = am.iterator();
            while (it.hasNext()) {
                C46531cy c46531cy = (C46531cy) it.next();
                if (C43555a.m77886jY(c46531cy.vEX.wZu.vQE)) {
                    C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + c46531cy.vEX.wZu.vQE);
                    it.remove();
                }
            }
            C43555a.m77884j(am, linkedList2);
        }
        AppMethodBeat.m2505o(36078);
    }

    /* renamed from: am */
    private static LinkedList<C46531cy> m77874am(LinkedList<bpx> linkedList) {
        AppMethodBeat.m2504i(36079);
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C46531cy a = C43555a.m77863a((bpx) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        AppMethodBeat.m2505o(36079);
        return linkedList2;
    }

    /* renamed from: j */
    private static void m77884j(List<C46531cy> list, List<cbf> list2) {
        AppMethodBeat.m2504i(36080);
        if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.m2505o(36080);
            return;
        }
        int a = C43555a.m77862a((cbf) list2.get(list2.size() - 1));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C46531cy c46531cy = (C46531cy) list.get(i2);
                if (c46531cy == null) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (c46531cy.vEX == null) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (c46531cy.vEX.wZu == null) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else {
                    String a2 = C1946aa.m4148a(c46531cy.vEY);
                    String a3 = C1946aa.m4148a(c46531cy.vEX.wZv);
                    String b = C1946aa.m4153b(c46531cy.vEX.wZu.xam);
                    C21980a c21980a = new C21980a(a2);
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "skXml ".concat(String.valueOf(a2)));
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "adXml ".concat(String.valueOf(a3)));
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + IOUtils.LINE_SEPARATOR_WINDOWS);
                    C21984b c21984b = new C21984b(a3);
                    if (c21984b.qUC == 0 || !C43555a.m77886jY(c21984b.qUC)) {
                        int i3 = a + 1;
                        if (c21980a.qTt >= list2.size() || c21980a.qTt < 0) {
                            C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + c21980a.qTt);
                        } else {
                            i3 = C43555a.m77862a((cbf) list2.get(c21980a.qTt)) + 1;
                            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i3 + " pos " + c21980a.qTt);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                        C43555a.m77870a(c46531cy, i3, currentTimeMillis);
                        C43555a.m77887jZ(c46531cy.vEX.wZu.vQE);
                        C43555a.m77887jZ(c21984b.qUC);
                        C43555a.m77865a(c46531cy.vEX.wZu.vQE, c21980a);
                    } else {
                        C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + c21984b.qUC);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(36080);
                return;
            }
        }
    }

    /* renamed from: k */
    public static void m77888k(List<C46531cy> list, List<cbf> list2) {
        AppMethodBeat.m2504i(36081);
        if (list == null || list2 == null || list2.size() == 0) {
            AppMethodBeat.m2505o(36081);
            return;
        }
        int a = C43555a.m77862a((cbf) list2.get(list2.size() - 1));
        for (int i = 0; i < list.size(); i++) {
            C46531cy c46531cy = (C46531cy) list.get(i);
            if (c46531cy == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
            } else if (c46531cy.vEX == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
            } else if (c46531cy.vEX.wZu == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
            } else {
                String a2 = C1946aa.m4148a(c46531cy.vEY);
                String a3 = C1946aa.m4148a(c46531cy.vEX.wZv);
                String b = C1946aa.m4153b(c46531cy.vEX.wZu.xam);
                C21980a c21980a = new C21980a(a2);
                C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "skXml %s, adXml %s, snsXml %s", a2, a3, b);
                int i2 = a + 1;
                if (c21980a.qTt >= list2.size() || c21980a.qTt < 0) {
                    C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + c21980a.qTt);
                } else {
                    i2 = C43555a.m77862a((cbf) list2.get(c21980a.qTt)) + 1;
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + c21980a.qTt);
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "gettime ".concat(String.valueOf(currentTimeMillis)));
                C43555a.m77870a(c46531cy, i2, currentTimeMillis);
                C43570e ku = C13373af.cnI().mo69174ku(c46531cy.vEX.wZu.vQE);
                if (ku != null) {
                    C23375bs cqv = ku.cqv();
                    if (cqv == null) {
                        cqv = new C23375bs();
                    }
                    cqv.vDY = c46531cy.vFa;
                    if (cqv.vDY != null) {
                        C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "update timeline remind info , aid:%d", Integer.valueOf(cqv.vDY.wTz));
                    }
                    ku.mo69151a(cqv);
                    ku.field_localFlag &= -257;
                    C13373af.cnI().mo10099a(ku);
                }
                C43555a.m77865a(c46531cy.vEX.wZu.vQE, c21980a);
            }
        }
        AppMethodBeat.m2505o(36081);
    }

    /* renamed from: a */
    private static void m77865a(long j, C21980a c21980a) {
        AppMethodBeat.m2504i(36082);
        if (!c21980a.qTV || C5046bo.isNullOrNil(c21980a.qTU)) {
            AppMethodBeat.m2505o(36082);
            return;
        }
        C1207m c13428m = new C13428m(j, 1, c21980a.qTU);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c13428m, 0);
        AppMethodBeat.m2505o(36082);
    }

    /* renamed from: an */
    public static void m77875an(LinkedList<bpx> linkedList) {
        AppMethodBeat.m2504i(36083);
        if (!(linkedList == null || linkedList.isEmpty())) {
            LinkedList am = C43555a.m77874am(linkedList);
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "convert " + am.size() + " recObj to AdvertiseObj");
            C43555a.m77876ao(am);
        }
        AppMethodBeat.m2505o(36083);
    }

    /* renamed from: ao */
    public static void m77876ao(LinkedList<C46531cy> linkedList) {
        AppMethodBeat.m2504i(36084);
        if (linkedList == null) {
            AppMethodBeat.m2505o(36084);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                C43555a.m77881b((C46531cy) linkedList.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(36084);
                return;
            }
        }
    }

    /* renamed from: b */
    private static void m77881b(C46531cy c46531cy) {
        AppMethodBeat.m2504i(36085);
        final String a = C1946aa.m4148a(c46531cy.vEX.wZv);
        if (!C5046bo.isNullOrNil(a) && new C21984b(a).coK()) {
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36062);
                    C34998j.cql().mo55575f("adId", a, "adxml", 0);
                    AppMethodBeat.m2505o(36062);
                }
            }, "predownloadAdLandingPages");
        }
        AppMethodBeat.m2505o(36085);
    }

    /* renamed from: ap */
    public static void m77877ap(LinkedList<cbf> linkedList) {
        AppMethodBeat.m2504i(36086);
        if (linkedList == null) {
            AppMethodBeat.m2505o(36086);
            return;
        }
        C39789o cnF = C13373af.cnF();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size()) {
                cbf cbf = (cbf) linkedList.get(i2);
                if (cbf != null) {
                    C46236n kD = cnF.mo62941kD(cbf.vQE);
                    if (kD != null) {
                        final TimeLineObject cqu = kD.cqu();
                        if (!(cqu == null || C5046bo.isNullOrNil(cqu.rCK))) {
                            C7305d.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(36063);
                                    C34998j.cql().mo55575f("adId", cqu.rCK, "adxml", 0);
                                    AppMethodBeat.m2505o(36063);
                                }
                            }, "preDownloadAdLandingPagesForSnsObject");
                        }
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(36086);
                return;
            }
        }
    }

    /* renamed from: XB */
    public static void m77861XB(final String str) {
        AppMethodBeat.m2504i(36087);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(36087);
            return;
        }
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36064);
                C34998j.cql().mo55575f("adId", str, "adxml", 1);
                AppMethodBeat.m2505o(36064);
            }
        }, "preDownloadAdLandingPagesForMsg");
        AppMethodBeat.m2505o(36087);
    }

    /* renamed from: a */
    private static int m77862a(cbf cbf) {
        AppMethodBeat.m2504i(36088);
        C46236n kD = C13373af.cnF().mo62941kD(cbf.vQE);
        int i;
        if (kD == null) {
            i = cbf.pcX;
            AppMethodBeat.m2505o(36088);
            return i;
        }
        i = kD.field_createTime;
        AppMethodBeat.m2505o(36088);
        return i;
    }

    /* renamed from: a */
    public static boolean m77872a(long j, cao cao, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(36089);
        if (cao != null) {
            can can = cao.wZN;
            if (!(can.jCt == 7 || can.jCt == 8 || can.jCt == 16)) {
                AppMethodBeat.m2505o(36089);
                return false;
            }
        }
        String Yz = C1853r.m3846Yz();
        if (cao == null || cao.wZO == null || cao.wZO.wPm == null || !cao.wZO.wPm.equals(Yz)) {
            C43570e ku = C13373af.cnI().mo69174ku(j);
            if (ku == null) {
                C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "AdSnsInfo of %s is not exist!", Long.valueOf(j));
                AppMethodBeat.m2505o(36089);
                return false;
            }
            try {
                C21980a cqq;
                C13356c c13356c;
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
                            if (C13373af.cnF().mo62917YS(ku.cqA()) != null) {
                                cqq = ku.cqq();
                                if (cqq != null) {
                                    c13356c = (C13356c) C1720g.m3528K(C13356c.class);
                                    source = ku.getSource();
                                    objArr = new Object[7];
                                    objArr[0] = Long.valueOf(C35002v.m57483Zm(ku.cqA()));
                                    objArr[1] = cqq.hnw;
                                    objArr[2] = Integer.valueOf(2);
                                    objArr[3] = Integer.valueOf(1);
                                    objArr[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                    objArr[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                    objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                    c13356c.mo25461a(13182, source, objArr);
                                } else {
                                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                                }
                            } else {
                                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                            }
                        }
                        C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + can2.pcX + "is over the time limit!");
                        AppMethodBeat.m2505o(36089);
                        return false;
                    }
                } else if ((can2.jCt == 8 || can2.jCt == 16) && i3 > 0 && i5 + i3 < can2.pcX) {
                    if (z) {
                        if (C13373af.cnF().mo62917YS(ku.cqA()) != null) {
                            cqq = ku.cqq();
                            if (cqq != null) {
                                c13356c = (C13356c) C1720g.m3528K(C13356c.class);
                                source = ku.getSource();
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(C35002v.m57483Zm(ku.cqA()));
                                objArr[1] = cqq.hnw;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(2);
                                objArr[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                objArr[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                c13356c.mo25461a(13182, source, objArr);
                            } else {
                                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + can2.pcX + "is over the time limit!");
                    AppMethodBeat.m2505o(36089);
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
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
                if (i4 >= i) {
                    if (z) {
                        C46236n YS = C13373af.cnF().mo62917YS(ku.cqA());
                        if (YS != null) {
                            cqq = YS.cqq();
                            if (cqq != null) {
                                c13356c = (C13356c) C1720g.m3528K(C13356c.class);
                                i5 = ku.getSource();
                                Object[] objArr2 = new Object[7];
                                objArr2[0] = Long.valueOf(C35002v.m57483Zm(ku.cqA()));
                                objArr2[1] = cqq.hnw;
                                objArr2[2] = Integer.valueOf(1);
                                objArr2[3] = Integer.valueOf(2);
                                objArr2[4] = Integer.valueOf(cbf.xaq != null ? cbf.xaq.size() : 0);
                                objArr2[5] = Integer.valueOf(cbf.xat != null ? cbf.xat.size() : 0);
                                objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                c13356c.mo25461a(13182, i5, objArr2);
                            } else {
                                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    AppMethodBeat.m2505o(36089);
                    return false;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(36089);
            return true;
        }
        AppMethodBeat.m2505o(36089);
        return true;
    }

    /* renamed from: a */
    public static boolean m77871a(long j, cao cao) {
        AppMethodBeat.m2504i(36090);
        can can = cao.wZN;
        if (can.jCt == 7 || can.jCt == 8 || can.jCt == 16) {
            C43570e ku = C13373af.cnI().mo69174ku(j);
            if (ku == null) {
                C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null ".concat(String.valueOf(j)));
                AppMethodBeat.m2505o(36090);
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
                            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + cat.pcX + " ");
                            AppMethodBeat.m2505o(36090);
                            return false;
                        }
                    }
                    cbf.xaq.add(C21915ad.m33481b(cao));
                } else if (can.jCt == 8 || can.jCt == 16) {
                    it = cbf.xat.iterator();
                    while (it.hasNext()) {
                        cat = (cat) it.next();
                        if (cat.pcX == can.pcX && cat.vHl.equals(can.wPm)) {
                            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + cat.pcX + " ");
                            AppMethodBeat.m2505o(36090);
                            return false;
                        }
                    }
                    cbf.xat.add(C21915ad.m33481b(cao));
                }
                ku.mo69152bi(cbf.toByteArray());
                C13373af.cnI().mo69171a(cbf.vQE, ku);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            AppMethodBeat.m2505o(36090);
            return true;
        }
        AppMethodBeat.m2505o(36090);
        return false;
    }

    /* renamed from: jY */
    private static boolean m77886jY(long j) {
        AppMethodBeat.m2504i(36091);
        C43555a.cmF();
        if (qHw.get(Long.valueOf(j)) != null) {
            AppMethodBeat.m2505o(36091);
            return true;
        }
        AppMethodBeat.m2505o(36091);
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
        AppMethodBeat.m2504i(36092);
        if (qHw == null) {
            byte[] aji = C40433a.aji(qHv);
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
                            C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (qHw == null) {
                            }
                            AppMethodBeat.m2505o(36092);
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                            }
                            AppMethodBeat.m2505o(36092);
                            throw e;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (qHw == null) {
                        }
                        AppMethodBeat.m2505o(36092);
                    } catch (ClassNotFoundException e7) {
                        e = e7;
                        C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (qHw == null) {
                        }
                        AppMethodBeat.m2505o(36092);
                    }
                } catch (StreamCorruptedException e9) {
                    e = e9;
                    objectInputStream = null;
                    C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.m2505o(36092);
                } catch (IOException e10) {
                    e = e10;
                    objectInputStream = null;
                    C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.m2505o(36092);
                } catch (ClassNotFoundException e11) {
                    e = e11;
                    objectInputStream = null;
                    C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
                    if (objectInputStream != null) {
                    }
                    if (qHw == null) {
                    }
                    AppMethodBeat.m2505o(36092);
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e12) {
                        }
                    }
                    AppMethodBeat.m2505o(36092);
                    throw e;
                }
            }
            if (qHw == null) {
                C43555a.cmG();
            }
        }
        AppMethodBeat.m2505o(36092);
    }

    private static void cmG() {
        AppMethodBeat.m2504i(36093);
        qHw = new LinkedHashMap<Long, Integer>(((int) Math.ceil(666.6666870117188d)) + 1) {
            /* Access modifiers changed, original: protected|final */
            public final boolean removeEldestEntry(Entry<Long, Integer> entry) {
                AppMethodBeat.m2504i(36065);
                if (size() > 500 && entry != null) {
                    C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
                }
                if (size() > 500) {
                    AppMethodBeat.m2505o(36065);
                    return true;
                }
                AppMethodBeat.m2505o(36065);
                return false;
            }
        };
        AppMethodBeat.m2505o(36093);
    }

    /* renamed from: jZ */
    private static void m77887jZ(long j) {
        AppMethodBeat.m2504i(36094);
        if (j == 0) {
            AppMethodBeat.m2505o(36094);
            return;
        }
        if (qHw == null) {
            C43555a.cmF();
        }
        qHw.put(Long.valueOf(j), Integer.valueOf(0));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(qHw);
            objectOutputStream.flush();
            C40433a.m69344D(qHv, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            C4990ab.m7412e("MicroMsg.AdSnsInfoStorageLogic", C5046bo.m7574l(e));
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
            AppMethodBeat.m2505o(36094);
        }
    }

    /* renamed from: a */
    private static String m77864a(String str, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        Throwable e;
        AppMethodBeat.m2504i(36095);
        if (sKBuiltinBuffer_t == null || str == null) {
            C4990ab.m7416i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            AppMethodBeat.m2505o(36095);
            return str;
        }
        CharSequence charSequence;
        try {
            C44200z c44200z = new C44200z();
            c44200z.parseFrom(sKBuiltinBuffer_t.getBufferToBytes());
            if (c44200z.vAH != null) {
                String str2 = "<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))";
                String str3 = "";
                Iterator it = c44200z.vAH.iterator();
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
                        C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "replace error occurs!", new Object[0]);
                        AppMethodBeat.m2505o(36095);
                        return charSequence;
                    }
                }
                C4990ab.m7417i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", str3);
                if (C5049br.m7595z(str, "ADInfo") == null) {
                    C4990ab.m7420w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    AppMethodBeat.m2505o(36095);
                    return str;
                }
            }
            Object obj = str;
        } catch (Exception e3) {
            e = e3;
            charSequence = str;
            C4990ab.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "replace error occurs!", new Object[0]);
            AppMethodBeat.m2505o(36095);
            return charSequence;
        }
        AppMethodBeat.m2505o(36095);
        return charSequence;
    }
}
