package com.tencent.p177mm.plugin.card.p352b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C11288k;
import com.tencent.p177mm.plugin.card.model.C11289l;
import com.tencent.p177mm.plugin.card.model.C20137ah;
import com.tencent.p177mm.plugin.card.model.C20149i;
import com.tencent.p177mm.plugin.card.model.C38741ae;
import com.tencent.p177mm.plugin.card.model.C38747g;
import com.tencent.p177mm.plugin.card.model.C38747g.C38746c;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C11280q;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42839c;
import com.tencent.p177mm.plugin.card.p931d.C42843e;
import com.tencent.p177mm.protocal.protobuf.bhl;
import com.tencent.p177mm.protocal.protobuf.bnc;
import com.tencent.p177mm.protocal.protobuf.bnd;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.g */
public final class C33753g implements C1202f {
    public int exv;
    public List<WeakReference<C20120a>> kaD = new ArrayList();
    public C42839c kaZ;
    public C7564ap kba = new C7564ap(new C337541(), false);

    /* renamed from: com.tencent.mm.plugin.card.b.g$a */
    public interface C20120a {
        /* renamed from: ap */
        void mo35365ap(int i, String str);

        /* renamed from: b */
        void mo35366b(C42839c c42839c);

        void baA();

        /* renamed from: c */
        void mo35368c(C42839c c42839c);
    }

    /* renamed from: com.tencent.mm.plugin.card.b.g$1 */
    class C337541 implements C5015a {
        C337541() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(87680);
            C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
            C33753g c33753g = C33753g.this;
            C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
            if (c33753g.kaD != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= c33753g.kaD.size()) {
                        break;
                    }
                    WeakReference weakReference = (WeakReference) c33753g.kaD.get(i2);
                    if (weakReference != null) {
                        C20120a c20120a = (C20120a) weakReference.get();
                        if (c20120a != null) {
                            c20120a.baA();
                        }
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(87680);
            return true;
        }
    }

    public C33753g() {
        AppMethodBeat.m2504i(87681);
        AppMethodBeat.m2505o(87681);
    }

    public final void release() {
        AppMethodBeat.m2504i(87682);
        this.exv = 0;
        bao();
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        C1720g.m3535RO().eJo.mo14546b(1382, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1275, (C1202f) this);
        AppMethodBeat.m2505o(87682);
    }

    /* renamed from: a */
    public final void mo54285a(C42837b c42837b, C11280q c11280q) {
        AppMethodBeat.m2504i(87683);
        if (!C33753g.m55151e(c42837b)) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            mo54283R(2, "");
            AppMethodBeat.m2505o(87683);
        } else if (!C38736l.isNetworkAvailable(C4996ah.getContext())) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            mo54283R(-1, "");
            AppMethodBeat.m2505o(87683);
        } else if (this.exv >= 3) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.exv + ",cannot request!");
            AppMethodBeat.m2505o(87683);
        } else {
            m55145a(c42837b.aZZ(), c11280q);
            this.exv++;
            AppMethodBeat.m2505o(87683);
        }
    }

    /* renamed from: a */
    public final void mo54286a(C11280q c11280q) {
        AppMethodBeat.m2504i(87684);
        C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", Integer.valueOf(c11280q.scene));
        List<CardInfo> baL = C42852am.baW().baL();
        if (baL == null || baL.isEmpty()) {
            C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", Integer.valueOf(c11280q.scene));
            AppMethodBeat.m2505o(87684);
            return;
        }
        for (CardInfo cardInfo : baL) {
            if (cardInfo == null) {
                C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", Integer.valueOf(c11280q.scene));
            } else if (c11280q == null) {
                C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", cardInfo.aZZ(), Integer.valueOf(c11280q.scene));
                if (C33753g.m55151e(cardInfo)) {
                    int i;
                    String aZZ = cardInfo.aZZ();
                    C20149i Gv = C42852am.bbl().mo17030Gv(aZZ);
                    if (Gv == null) {
                        i = 1;
                    } else {
                        List Gw = C42852am.bbk().mo22983Gw(aZZ);
                        if (Gw.isEmpty()) {
                            i = 1;
                        } else if (Gw.size() < Gv.field_lower_bound) {
                            this.kaZ = C42839c.CARDCODEREFRESHACTION_UPDATECHANGE;
                            i = 1;
                        } else if (C33753g.m55147a(Gv)) {
                            this.kaZ = C42839c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", cardInfo.aZZ(), Integer.valueOf(c11280q.scene));
                    } else {
                        C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", Integer.valueOf(c11280q.scene));
                        m55145a(cardInfo.aZZ(), c11280q);
                    }
                } else {
                    C4990ab.m7413e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", cardInfo.aZZ());
                }
            }
        }
        AppMethodBeat.m2505o(87684);
    }

    /* renamed from: b */
    public final void mo54288b(C38747g c38747g) {
        AppMethodBeat.m2504i(87685);
        String str = c38747g.field_card_id;
        C11289l bbk = C42852am.bbk();
        List Gw;
        C11288k Gy;
        if (c38747g.kdz) {
            Gw = C42852am.bbk().mo22983Gw(str);
            Gy = bbk.mo22985Gy(str);
            C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", str);
            if (bbk.mo22987pI(str)) {
                if (Gy != null) {
                    C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", str);
                    m55150b(C42839c.CARDCODEREFRESHACTION_BANCODE);
                }
                m55146a(str, Gw, C42839c.CARDCODEREFRESHACTION_BANCODE);
            }
            AppMethodBeat.m2505o(87685);
            return;
        }
        List<C38746c> Gw2 = c38747g.kdA;
        if (Gw2 == null) {
            C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", str);
            AppMethodBeat.m2505o(87685);
            return;
        }
        C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", str, Integer.valueOf(Gw2.size()));
        Gy = bbk.mo22985Gy(str);
        LinkedList linkedList = new LinkedList();
        for (C38746c c38746c : Gw2) {
            if (C42852am.bbk().mo22986dm(str, c38746c.kdG)) {
                linkedList.add(C33753g.m55149b(str, c38746c.kdG, C42839c.CARDCODEREFRESHACTION_BANCODE));
            }
        }
        if (Gy != null) {
            C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", str, Gy.field_code_id);
            m55150b(C42839c.CARDCODEREFRESHACTION_BANCODE);
        }
        if (!linkedList.isEmpty()) {
            m55142I(linkedList);
        }
        AppMethodBeat.m2505o(87685);
    }

    /* renamed from: a */
    public static boolean m55147a(C20149i c20149i) {
        AppMethodBeat.m2504i(87686);
        if (System.currentTimeMillis() - c20149i.field_fetch_time > ((long) (c20149i.field_expire_time_interval * 1000))) {
            C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(c20149i.field_fetch_time), Integer.valueOf(c20149i.field_expire_time_interval));
            AppMethodBeat.m2505o(87686);
            return true;
        }
        AppMethodBeat.m2505o(87686);
        return false;
    }

    public final void bao() {
        AppMethodBeat.m2504i(87687);
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.kba.doT()) {
            this.kba.stopTimer();
        }
        AppMethodBeat.m2505o(87687);
    }

    /* renamed from: e */
    private static boolean m55151e(C42837b c42837b) {
        AppMethodBeat.m2504i(87688);
        if (c42837b == null) {
            AppMethodBeat.m2505o(87688);
            return false;
        } else if (c42837b.aZW() == null || !c42837b.aZW().vSq) {
            C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
            AppMethodBeat.m2505o(87688);
            return false;
        } else {
            AppMethodBeat.m2505o(87688);
            return true;
        }
    }

    /* renamed from: a */
    private void m55145a(String str, C11280q c11280q) {
        int i;
        AppMethodBeat.m2504i(87689);
        String str2 = "MicroMsg.CardDynamicQrcodeOfflineMgr";
        StringBuilder append = new StringBuilder("doNetSceneGetDynamicQrcode, cardId:").append(str).append(",scene :");
        if (c11280q == null) {
            i = 0;
        } else {
            i = c11280q.scene;
        }
        C4990ab.m7416i(str2, append.append(i).toString());
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        if (c11280q == null) {
            i = 0;
        } else {
            i = c11280q.scene;
        }
        C1207m c38741ae = new C38741ae(linkedList, i);
        C1720g.m3535RO().eJo.mo14539a(1382, (C1202f) this);
        C1720g.m3535RO().eJo.mo14541a(c38741ae, 0);
        AppMethodBeat.m2505o(87689);
    }

    /* renamed from: a */
    private void m55146a(String str, List<C11288k> list, C42839c c42839c) {
        AppMethodBeat.m2504i(87690);
        if (c42839c == null) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            AppMethodBeat.m2505o(87690);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (C11288k c11288k : list) {
            linkedList.add(C33753g.m55149b(str, c11288k.field_code_id, c42839c));
        }
        m55142I(linkedList);
        AppMethodBeat.m2505o(87690);
    }

    /* renamed from: a */
    public final void mo54287a(String str, String str2, C42839c c42839c) {
        AppMethodBeat.m2504i(87691);
        LinkedList linkedList = new LinkedList();
        linkedList.add(C33753g.m55149b(str, str2, c42839c));
        C4990ab.m7417i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", Integer.valueOf(linkedList.size()), Integer.valueOf(c42839c.action));
        m55142I(linkedList);
        AppMethodBeat.m2505o(87691);
    }

    /* renamed from: I */
    private void m55142I(LinkedList<bhl> linkedList) {
        AppMethodBeat.m2504i(87692);
        C1720g.m3535RO().eJo.mo14539a(1275, (C1202f) this);
        C1720g.m3535RO().eJo.mo14541a(new C20137ah(linkedList), 0);
        AppMethodBeat.m2505o(87692);
    }

    /* renamed from: b */
    private static bhl m55149b(String str, String str2, C42839c c42839c) {
        int i;
        AppMethodBeat.m2504i(87693);
        bhl bhl = new bhl();
        bhl.cMC = str;
        bhl.kdG = str2;
        bhl.wKK = new Long(System.currentTimeMillis() / 1000).intValue();
        if (c42839c == null) {
            i = -1;
        } else {
            i = c42839c.action;
        }
        bhl.wKL = i;
        AppMethodBeat.m2505o(87693);
        return bhl;
    }

    /* renamed from: a */
    private void m55144a(bnd bnd) {
        AppMethodBeat.m2504i(87694);
        if (bnd == null) {
            AppMethodBeat.m2505o(87694);
            return;
        }
        String str = bnd.cMC;
        if (C42852am.bbl().mo17030Gv(str) == null) {
            C42852am.bbl().mo10101b((C4925c) C33753g.m55148b(bnd));
        } else {
            C42852am.bbl().mo10103c(C33753g.m55148b(bnd), new String[0]);
        }
        List Gw = C42852am.bbk().mo22983Gw(str);
        if (!(Gw.isEmpty() || !C42852am.bbk().mo22987pI(str) || this.kaZ == null)) {
            m55146a(str, Gw, this.kaZ);
        }
        Iterator it = bnd.wQb.iterator();
        while (it.hasNext()) {
            bnc bnc = (bnc) it.next();
            C11288k c11288k = new C11288k();
            c11288k.field_card_id = str;
            c11288k.field_code_id = bnc.kdG;
            c11288k.field_code = C42843e.m76045dt(str, bnc.data);
            C42852am.bbk().mo10101b((C4925c) c11288k);
        }
        AppMethodBeat.m2505o(87694);
    }

    /* renamed from: b */
    private static C20149i m55148b(bnd bnd) {
        AppMethodBeat.m2504i(87695);
        C20149i c20149i = new C20149i();
        c20149i.field_card_id = bnd.cMC;
        c20149i.field_lower_bound = bnd.wPW;
        c20149i.field_expire_time_interval = bnd.wPZ;
        c20149i.field_need_insert_show_timestamp = bnd.wPX;
        c20149i.field_show_expire_interval = bnd.wQa;
        c20149i.field_show_timestamp_encrypt_key = bnd.wPY;
        c20149i.field_fetch_time = System.currentTimeMillis();
        AppMethodBeat.m2505o(87695);
        return c20149i;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87696);
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (c1207m != null ? c1207m.getClass() : ""));
        if (i != 0 || i2 != 0) {
            C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (c1207m != null ? c1207m.getType() : 0) + "  NetSceneBase=" + (c1207m != null ? c1207m.getClass() : ""));
            if (c1207m instanceof C38741ae) {
                mo54283R(i2, str);
                C1720g.m3535RO().eJo.mo14546b(1382, (C1202f) this);
                AppMethodBeat.m2505o(87696);
                return;
            }
            C1720g.m3535RO().eJo.mo14546b(1275, (C1202f) this);
            AppMethodBeat.m2505o(87696);
        } else if (c1207m instanceof C38741ae) {
            bnd bnd = ((C38741ae) c1207m).kem;
            if (bnd == null) {
                C4990ab.m7412e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                AppMethodBeat.m2505o(87696);
                return;
            }
            m55144a(bnd);
            m55143a(this.kaZ);
            C1720g.m3535RO().eJo.mo14546b(1382, (C1202f) this);
            AppMethodBeat.m2505o(87696);
        } else {
            C1720g.m3535RO().eJo.mo14546b(1275, (C1202f) this);
            AppMethodBeat.m2505o(87696);
        }
    }

    /* renamed from: a */
    public final void mo54284a(C20120a c20120a) {
        AppMethodBeat.m2504i(87697);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c20120a));
        AppMethodBeat.m2505o(87697);
    }

    /* renamed from: a */
    private void m55143a(C42839c c42839c) {
        AppMethodBeat.m2504i(87698);
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87698);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C20120a c20120a = (C20120a) weakReference.get();
                    if (c20120a != null) {
                        c20120a.mo35368c(c42839c);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87698);
                return;
            }
        }
    }

    /* renamed from: R */
    public final void mo54283R(int i, String str) {
        AppMethodBeat.m2504i(87699);
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87699);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i3);
                if (weakReference != null) {
                    C20120a c20120a = (C20120a) weakReference.get();
                    if (c20120a != null) {
                        c20120a.mo35365ap(i, str);
                    }
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(87699);
                return;
            }
        }
    }

    /* renamed from: b */
    private void m55150b(C42839c c42839c) {
        AppMethodBeat.m2504i(87700);
        C4990ab.m7416i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87700);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C20120a c20120a = (C20120a) weakReference.get();
                    if (c20120a != null) {
                        c20120a.mo35366b(c42839c);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87700);
                return;
            }
        }
    }
}
