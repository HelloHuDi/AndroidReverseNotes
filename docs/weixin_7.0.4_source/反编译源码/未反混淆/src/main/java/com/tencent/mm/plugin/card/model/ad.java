package com.tencent.mm.plugin.card.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.view.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class ad extends m implements k {
    private final b ehh;
    private f ehi;
    public boolean kei = false;
    public ol kej;
    public bvx kek;
    public int kel;

    public ad(double d, double d2, int i) {
        AppMethodBeat.i(87904);
        a aVar = new a();
        aVar.fsJ = new agv();
        aVar.fsK = new agw();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.fsI = 984;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        agv agv = (agv) this.ehh.fsG.fsP;
        agv.latitude = d;
        agv.longitude = d2;
        agv.scene = i;
        agv.wno = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null);
        AppMethodBeat.o(87904);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87905);
        ab.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        agw agw = (agw) this.ehh.fsH.fsP;
        ab.v("MicroMsg.NetSceneGetCardsLayout", "json:" + agw.kdS);
        this.kej = agw.wnp;
        if (i2 == 0 && i3 == 0) {
            boolean z;
            g.RP().Ry().set(ac.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, agw.wno);
            Object obj = agw.kdS;
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, null);
            if (!bo.isNullOrNil(str2)) {
                obj = str2;
            }
            agz Hm = j.Hm(obj);
            am.baW().bSd.hY("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 , label_wording='' where stickyIndex>0");
            if (Hm == null) {
                ab.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
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
                    long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                    if (Hm.wnu.vWA == null || Hm.wnu.vWA.vWz == null || Hm.wnu.vWA.vWz.size() <= 0) {
                        i4 = 0;
                    } else {
                        z = true;
                        j.c(Hm.wnu.vWA.vWz, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        i4 = Hm.wnu.vWA.vWz.size() + 0;
                    }
                    if (!(Hm.wnu.vWB == null || Hm.wnu.vWB.vWz == null || Hm.wnu.vWB.vWz.size() <= 0)) {
                        z = true;
                        j.c(Hm.wnu.vWB.vWz, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += Hm.wnu.vWB.vWz.size();
                    }
                    if (!(Hm.wnu.vWC == null || Hm.wnu.vWC.vWz == null || Hm.wnu.vWC.vWz.size() <= 0)) {
                        z = true;
                        j.c(Hm.wnu.vWC.vWz, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += Hm.wnu.vWC.vWz.size();
                    }
                    if (!(Hm.wnu.vWD == null || Hm.wnu.vWD.vWz == null || Hm.wnu.vWD.vWz.size() <= 0)) {
                        z = true;
                        i4 += Hm.wnu.vWD.vWz.size();
                        j.d(Hm.wnu.vWD.vWz, 0);
                    }
                    if (!(Hm.wnu.vWE == null || Hm.wnu.vWE.vWz == null || Hm.wnu.vWE.vWz.size() <= 0)) {
                        z = true;
                        int intValue = (((Integer) hashMap.get("first_list")).intValue() * 100000) + 4;
                        j.c(Hm.wnu.vWE.vWz, intValue);
                        j.d(Hm.wnu.vWE.vWz, intValue);
                        i4 += Hm.wnu.vWE.vWz.size();
                    }
                    g.RP().eJN.mB(iV);
                } else {
                    i4 = 0;
                }
                am.bbb().putValue("key_get_card_layout_resp", Hm);
                g.RP().Ry().set(ac.a.USERINFO_CARD_GET_LAYOUT_JSON_STRING_SYNC, obj);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue((long) i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue((long) (((int) (currentTimeMillis2 - currentTimeMillis)) / i4));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    h.pYm.b(arrayList, true);
                }
            }
            this.kei = z;
            if (this.kej != null) {
                try {
                    byte[] toByteArray = this.kej.toByteArray();
                    g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, new String(toByteArray, 0, toByteArray.length, "ISO-8859-1"));
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e, "", new Object[0]);
                }
            } else {
                g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_LIST_STRING_SYNC, (Object) "");
            }
            this.kel = agw.wnq;
            if (this.kel < 0) {
                this.kel = 0;
            }
            g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_CARD_NUM_INT_SYNC, Integer.valueOf(this.kel));
            if (agw.wnr != null) {
                this.kek = agw.wnr;
                try {
                    byte[] toByteArray2 = agw.wnr.toByteArray();
                    g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, new String(toByteArray2, 0, toByteArray2.length, "ISO-8859-1"));
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.NetSceneGetCardsLayout", e2, "", new Object[0]);
                }
                g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.TRUE);
            } else {
                g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_SECOND_ENTRANCE_STRING_SYNC, (Object) "");
                g.RP().Ry().set(ac.a.USERINFO_CARD_HOME_PAGE_HAS_LOAD_NEW_ENTRANCE_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87905);
    }

    public final int getType() {
        return 984;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87906);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87906);
        return a;
    }
}
