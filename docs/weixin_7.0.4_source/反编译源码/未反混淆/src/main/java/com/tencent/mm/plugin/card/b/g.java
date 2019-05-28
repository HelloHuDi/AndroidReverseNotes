package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements f {
    public int exv;
    public List<WeakReference<a>> kaD = new ArrayList();
    public c kaZ;
    public ap kba = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(87680);
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
            g gVar = g.this;
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
            if (gVar.kaD != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= gVar.kaD.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) gVar.kaD.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.baA();
                        }
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.o(87680);
            return true;
        }
    }, false);

    public interface a {
        void ap(int i, String str);

        void b(c cVar);

        void baA();

        void c(c cVar);
    }

    public g() {
        AppMethodBeat.i(87681);
        AppMethodBeat.o(87681);
    }

    public final void release() {
        AppMethodBeat.i(87682);
        this.exv = 0;
        bao();
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        com.tencent.mm.kernel.g.RO().eJo.b(1382, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.b(1275, (f) this);
        AppMethodBeat.o(87682);
    }

    public final void a(b bVar, q qVar) {
        AppMethodBeat.i(87683);
        if (!e(bVar)) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            R(2, "");
            AppMethodBeat.o(87683);
        } else if (!l.isNetworkAvailable(ah.getContext())) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            R(-1, "");
            AppMethodBeat.o(87683);
        } else if (this.exv >= 3) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.exv + ",cannot request!");
            AppMethodBeat.o(87683);
        } else {
            a(bVar.aZZ(), qVar);
            this.exv++;
            AppMethodBeat.o(87683);
        }
    }

    public final void a(q qVar) {
        AppMethodBeat.i(87684);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", Integer.valueOf(qVar.scene));
        List<CardInfo> baL = am.baW().baL();
        if (baL == null || baL.isEmpty()) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", Integer.valueOf(qVar.scene));
            AppMethodBeat.o(87684);
            return;
        }
        for (CardInfo cardInfo : baL) {
            if (cardInfo == null) {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", Integer.valueOf(qVar.scene));
            } else if (qVar == null) {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", cardInfo.aZZ(), Integer.valueOf(qVar.scene));
                if (e(cardInfo)) {
                    int i;
                    String aZZ = cardInfo.aZZ();
                    i Gv = am.bbl().Gv(aZZ);
                    if (Gv == null) {
                        i = 1;
                    } else {
                        List Gw = am.bbk().Gw(aZZ);
                        if (Gw.isEmpty()) {
                            i = 1;
                        } else if (Gw.size() < Gv.field_lower_bound) {
                            this.kaZ = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                            i = 1;
                        } else if (a(Gv)) {
                            this.kaZ = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", cardInfo.aZZ(), Integer.valueOf(qVar.scene));
                    } else {
                        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", Integer.valueOf(qVar.scene));
                        a(cardInfo.aZZ(), qVar);
                    }
                } else {
                    ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", cardInfo.aZZ());
                }
            }
        }
        AppMethodBeat.o(87684);
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        AppMethodBeat.i(87685);
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l bbk = am.bbk();
        List Gw;
        k Gy;
        if (gVar.kdz) {
            Gw = am.bbk().Gw(str);
            Gy = bbk.Gy(str);
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", str);
            if (bbk.pI(str)) {
                if (Gy != null) {
                    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", str);
                    b(c.CARDCODEREFRESHACTION_BANCODE);
                }
                a(str, Gw, c.CARDCODEREFRESHACTION_BANCODE);
            }
            AppMethodBeat.o(87685);
            return;
        }
        List<com.tencent.mm.plugin.card.model.g.c> Gw2 = gVar.kdA;
        if (Gw2 == null) {
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", str);
            AppMethodBeat.o(87685);
            return;
        }
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", str, Integer.valueOf(Gw2.size()));
        Gy = bbk.Gy(str);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.card.model.g.c cVar : Gw2) {
            if (am.bbk().dm(str, cVar.kdG)) {
                linkedList.add(b(str, cVar.kdG, c.CARDCODEREFRESHACTION_BANCODE));
            }
        }
        if (Gy != null) {
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", str, Gy.field_code_id);
            b(c.CARDCODEREFRESHACTION_BANCODE);
        }
        if (!linkedList.isEmpty()) {
            I(linkedList);
        }
        AppMethodBeat.o(87685);
    }

    public static boolean a(i iVar) {
        AppMethodBeat.i(87686);
        if (System.currentTimeMillis() - iVar.field_fetch_time > ((long) (iVar.field_expire_time_interval * 1000))) {
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval));
            AppMethodBeat.o(87686);
            return true;
        }
        AppMethodBeat.o(87686);
        return false;
    }

    public final void bao() {
        AppMethodBeat.i(87687);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.kba.doT()) {
            this.kba.stopTimer();
        }
        AppMethodBeat.o(87687);
    }

    private static boolean e(b bVar) {
        AppMethodBeat.i(87688);
        if (bVar == null) {
            AppMethodBeat.o(87688);
            return false;
        } else if (bVar.aZW() == null || !bVar.aZW().vSq) {
            ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
            AppMethodBeat.o(87688);
            return false;
        } else {
            AppMethodBeat.o(87688);
            return true;
        }
    }

    private void a(String str, q qVar) {
        int i;
        AppMethodBeat.i(87689);
        String str2 = "MicroMsg.CardDynamicQrcodeOfflineMgr";
        StringBuilder append = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(str).append(",scene :");
        if (qVar == null) {
            i = 0;
        } else {
            i = qVar.scene;
        }
        ab.i(str2, append.append(i).toString());
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        if (qVar == null) {
            i = 0;
        } else {
            i = qVar.scene;
        }
        m aeVar = new ae(linkedList, i);
        com.tencent.mm.kernel.g.RO().eJo.a(1382, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(aeVar, 0);
        AppMethodBeat.o(87689);
    }

    private void a(String str, List<k> list, c cVar) {
        AppMethodBeat.i(87690);
        if (cVar == null) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            AppMethodBeat.o(87690);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        I(linkedList);
        AppMethodBeat.o(87690);
    }

    public final void a(String str, String str2, c cVar) {
        AppMethodBeat.i(87691);
        LinkedList linkedList = new LinkedList();
        linkedList.add(b(str, str2, cVar));
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action));
        I(linkedList);
        AppMethodBeat.o(87691);
    }

    private void I(LinkedList<bhl> linkedList) {
        AppMethodBeat.i(87692);
        com.tencent.mm.kernel.g.RO().eJo.a(1275, (f) this);
        com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.card.model.ah(linkedList), 0);
        AppMethodBeat.o(87692);
    }

    private static bhl b(String str, String str2, c cVar) {
        int i;
        AppMethodBeat.i(87693);
        bhl bhl = new bhl();
        bhl.cMC = str;
        bhl.kdG = str2;
        bhl.wKK = new Long(System.currentTimeMillis() / 1000).intValue();
        if (cVar == null) {
            i = -1;
        } else {
            i = cVar.action;
        }
        bhl.wKL = i;
        AppMethodBeat.o(87693);
        return bhl;
    }

    private void a(bnd bnd) {
        AppMethodBeat.i(87694);
        if (bnd == null) {
            AppMethodBeat.o(87694);
            return;
        }
        String str = bnd.cMC;
        if (am.bbl().Gv(str) == null) {
            am.bbl().b((com.tencent.mm.sdk.e.c) b(bnd));
        } else {
            am.bbl().c(b(bnd), new String[0]);
        }
        List Gw = am.bbk().Gw(str);
        if (!(Gw.isEmpty() || !am.bbk().pI(str) || this.kaZ == null)) {
            a(str, Gw, this.kaZ);
        }
        Iterator it = bnd.wQb.iterator();
        while (it.hasNext()) {
            bnc bnc = (bnc) it.next();
            k kVar = new k();
            kVar.field_card_id = str;
            kVar.field_code_id = bnc.kdG;
            kVar.field_code = e.dt(str, bnc.data);
            am.bbk().b((com.tencent.mm.sdk.e.c) kVar);
        }
        AppMethodBeat.o(87694);
    }

    private static i b(bnd bnd) {
        AppMethodBeat.i(87695);
        i iVar = new i();
        iVar.field_card_id = bnd.cMC;
        iVar.field_lower_bound = bnd.wPW;
        iVar.field_expire_time_interval = bnd.wPZ;
        iVar.field_need_insert_show_timestamp = bnd.wPX;
        iVar.field_show_expire_interval = bnd.wQa;
        iVar.field_show_timestamp_encrypt_key = bnd.wPY;
        iVar.field_fetch_time = System.currentTimeMillis();
        AppMethodBeat.o(87695);
        return iVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87696);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (mVar != null ? mVar.getClass() : ""));
        if (i != 0 || i2 != 0) {
            ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (mVar != null ? mVar.getType() : 0) + "  NetSceneBase=" + (mVar != null ? mVar.getClass() : ""));
            if (mVar instanceof ae) {
                R(i2, str);
                com.tencent.mm.kernel.g.RO().eJo.b(1382, (f) this);
                AppMethodBeat.o(87696);
                return;
            }
            com.tencent.mm.kernel.g.RO().eJo.b(1275, (f) this);
            AppMethodBeat.o(87696);
        } else if (mVar instanceof ae) {
            bnd bnd = ((ae) mVar).kem;
            if (bnd == null) {
                ab.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                AppMethodBeat.o(87696);
                return;
            }
            a(bnd);
            a(this.kaZ);
            com.tencent.mm.kernel.g.RO().eJo.b(1382, (f) this);
            AppMethodBeat.o(87696);
        } else {
            com.tencent.mm.kernel.g.RO().eJo.b(1275, (f) this);
            AppMethodBeat.o(87696);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87697);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(87697);
    }

    private void a(c cVar) {
        AppMethodBeat.i(87698);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.o(87698);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.c(cVar);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87698);
                return;
            }
        }
    }

    public final void R(int i, String str) {
        AppMethodBeat.i(87699);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.kaD == null) {
            AppMethodBeat.o(87699);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i3);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.ap(i, str);
                    }
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(87699);
                return;
            }
        }
    }

    private void b(c cVar) {
        AppMethodBeat.i(87700);
        ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.kaD == null) {
            AppMethodBeat.o(87700);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.b(cVar);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87700);
                return;
            }
        }
    }
}
