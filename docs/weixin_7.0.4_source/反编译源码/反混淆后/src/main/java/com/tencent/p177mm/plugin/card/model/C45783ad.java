package com.tencent.p177mm.plugin.card.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.card.p931d.C42844j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C30209ol;
import com.tencent.p177mm.protocal.protobuf.agv;
import com.tencent.p177mm.protocal.protobuf.agw;
import com.tencent.p177mm.protocal.protobuf.agz;
import com.tencent.p177mm.protocal.protobuf.bvx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.card.model.ad */
public final class C45783ad extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public boolean kei = false;
    public C30209ol kej;
    public bvx kek;
    public int kel;

    public C45783ad(double d, double d2, int i) {
        AppMethodBeat.m2504i(87904);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agv();
        c1196a.fsK = new agw();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        c1196a.fsI = 984;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        agv agv = (agv) this.ehh.fsG.fsP;
        agv.latitude = d;
        agv.longitude = d2;
        agv.scene = i;
        agv.wno = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null);
        AppMethodBeat.m2505o(87904);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87905);
        C4990ab.m7417i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        agw agw = (agw) this.ehh.fsH.fsP;
        C4990ab.m7418v("MicroMsg.NetSceneGetCardsLayout", "json:" + agw.kdS);
        this.kej = agw.wnp;
        if (i2 == 0 && i3 == 0) {
            boolean z;
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, agw.wno);
            Object obj = agw.kdS;
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARDLAYOUT_TESTDATA_STRING, null);
            if (!C5046bo.isNullOrNil(str2)) {
                obj = str2;
            }
            agz Hm = C42844j.m76048Hm(obj);
            C42852am.baW().bSd.mo10108hY("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 , label_wording='' where stickyIndex>0");
            if (Hm == null) {
                C4990ab.m7420w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                int i4;
                z = false;
                if (Hm.wnu != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("expiring_list", Integer.valueOf(2));
                    hashMap.put("member_card_list", Integer.valueOf(2));
                    hashMap.put("nearby_list", Integer.valueOf(3));
                    hashMap.put("first_list", Integer.valueOf(5));
                    if (Hm.wnx == 100) {
                        hashMap.put("expiring_list", Integer.valueOf(4));
                    } else if (Hm.wnx == 102) {
                        hashMap.put("member_card_list", Integer.valueOf(4));
                    } else if (Hm.wnx == 101) {
                        hashMap.put("nearby_list", Integer.valueOf(4));
                    }
                    long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                    if (Hm.wnu.vWA == null || Hm.wnu.vWA.vWz == null || Hm.wnu.vWA.vWz.size() <= 0) {
                        i4 = 0;
                    } else {
                        z = true;
                        C42844j.m76051c(Hm.wnu.vWA.vWz, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        i4 = Hm.wnu.vWA.vWz.size() + 0;
                    }
                    if (!(Hm.wnu.vWB == null || Hm.wnu.vWB.vWz == null || Hm.wnu.vWB.vWz.size() <= 0)) {
                        z = true;
                        C42844j.m76051c(Hm.wnu.vWB.vWz, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += Hm.wnu.vWB.vWz.size();
                    }
                    if (!(Hm.wnu.vWC == null || Hm.wnu.vWC.vWz == null || Hm.wnu.vWC.vWz.size() <= 0)) {
                        z = true;
                        C42844j.m76051c(Hm.wnu.vWC.vWz, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += Hm.wnu.vWC.vWz.size();
                    }
                    if (!(Hm.wnu.vWD == null || Hm.wnu.vWD.vWz == null || Hm.wnu.vWD.vWz.size() <= 0)) {
                        z = true;
                        i4 += Hm.wnu.vWD.vWz.size();
                        C42844j.m76052d(Hm.wnu.vWD.vWz, 0);
                    }
                    if (!(Hm.wnu.vWE == null || Hm.wnu.vWE.vWz == null || Hm.wnu.vWE.vWz.size() <= 0)) {
                        z = true;
                        int intValue = (((Integer) hashMap.get("first_list")).intValue() * 100000) + 4;
                        C42844j.m76051c(Hm.wnu.vWE.vWz, intValue);
                        C42844j.m76052d(Hm.wnu.vWE.vWz, intValue);
                        i4 += Hm.wnu.vWE.vWz.size();
                    }
                    C1720g.m3536RP().eJN.mo15640mB(iV);
                } else {
                    i4 = 0;
                }
                C42852am.bbb().putValue("key_get_card_layout_resp", Hm);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_GET_LAYOUT_JSON_STRING_SYNC, obj);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue((long) i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue((long) (((int) (currentTimeMillis2 - currentTimeMillis)) / i4));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    C7060h.pYm.mo8379b(arrayList, true);
                }
            }
            this.kei = z;
            if (this.kej != null) {
                try {
                    byte[] toByteArray = this.kej.toByteArray();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, new String(toByteArray, 0, toByteArray.length, "ISO-8859-1"));
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e, "", new Object[0]);
                }
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, (Object) "");
            }
            this.kel = agw.wnq;
            if (this.kel < 0) {
                this.kel = 0;
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(this.kel));
            if (agw.wnr != null) {
                this.kek = agw.wnr;
                try {
                    byte[] toByteArray2 = agw.wnr.toByteArray();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, new String(toByteArray2, 0, toByteArray2.length, "ISO-8859-1"));
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e2, "", new Object[0]);
                }
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.TRUE);
            } else {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, (Object) "");
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87905);
    }

    public final int getType() {
        return 984;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87906);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87906);
        return a;
    }
}
