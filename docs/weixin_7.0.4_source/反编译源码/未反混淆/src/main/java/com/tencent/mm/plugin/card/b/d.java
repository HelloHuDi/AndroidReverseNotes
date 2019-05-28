package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements f, com.tencent.mm.plugin.card.b.k.a, com.tencent.mm.plugin.card.base.d {
    public WeakReference<Context> atF;
    public List<WeakReference<a>> kaD = new ArrayList();
    public HashMap<a, Boolean> kaP = new HashMap();
    public HashMap<String, Boolean> kaQ = new HashMap();
    public HashMap<String, Boolean> kaR = new HashMap();
    public b kaS = null;
    public boolean kaT = false;
    public String kaU;

    public interface a {
        void Gm(String str);

        void bau();

        void bav();

        void d(b bVar);
    }

    public d() {
        AppMethodBeat.i(87654);
        AppMethodBeat.o(87654);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(87656);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(87656);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(87657);
        if (this.kaD == null) {
            AppMethodBeat.o(87657);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.o(87657);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87657);
                return;
            }
        }
    }

    public final void b(b bVar) {
        boolean z = false;
        AppMethodBeat.i(87658);
        this.kaS = bVar;
        if (!(!this.kaT || this.kaS == null || bVar.aZZ() == null || bVar.aZZ().equals(this.kaS.aZZ()))) {
            this.kaT = false;
        }
        if (this.kaD == null) {
            AppMethodBeat.o(87658);
            return;
        }
        while (true) {
            boolean z2 = z;
            if (z2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(z2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kaP.get(aVar);
                    if (!(aVar == null || bool == null || bool.booleanValue())) {
                        aVar.d(bVar);
                    }
                }
                z = z2 + 1;
            } else {
                AppMethodBeat.o(87658);
                return;
            }
        }
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(87659);
        if (this.kaP == null) {
            this.kaP = new HashMap();
        }
        this.kaP.put(aVar, Boolean.valueOf(z));
        AppMethodBeat.o(87659);
    }

    public final void c(a aVar) {
        AppMethodBeat.i(87660);
        if (this.kaP == null) {
            this.kaP = new HashMap();
        }
        this.kaP.remove(aVar);
        AppMethodBeat.o(87660);
    }

    public final void bag() {
        AppMethodBeat.i(87661);
        ab.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.kaS == null) {
            ab.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            AppMethodBeat.o(87661);
            return;
        }
        b GK;
        if (this.kaS.aZC()) {
            GK = am.bbe().GK(this.kaS.aZZ());
        } else {
            Object GK2 = am.baW().Gu(this.kaS.aZZ());
        }
        if (!(GK2 == null || GK2.aZW() == null || this.kaS == null || this.kaS.aZW() == null)) {
            ab.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", Integer.valueOf(this.kaS.aZW().status), Integer.valueOf(GK2.aZW().status), Boolean.valueOf(this.kaT), Boolean.valueOf(this.kaS.aZC()));
            if (this.kaS.aZC() && (this.kaS instanceof ShareCardInfo)) {
                ab.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", Integer.valueOf(((ShareCardInfo) this.kaS).field_status));
            } else if (this.kaS.aZC()) {
                ab.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (GK2.aZW().status != r2) {
                baq();
                if (this.kaS.aZC() && !this.kaT && GK2.aZW().status == 1) {
                    ab.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.kaQ.get(this.kaS.aZZ());
                    if (bool == null || !bool.booleanValue()) {
                        ab.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.atF.get();
                        ab.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kaS.aZZ());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kaS);
                        this.kaQ.put(this.kaS.aZZ(), Boolean.TRUE);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        h.pYm.b(arrayList, true);
                    } else {
                        ab.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    bas();
                } else if (this.kaS.aZC() && this.kaT) {
                    ab.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    ab.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    bar();
                }
                ab.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.kaS = GK2;
            c(this.kaS);
        }
        AppMethodBeat.o(87661);
    }

    public final void aVU() {
        AppMethodBeat.i(87662);
        baq();
        AppMethodBeat.o(87662);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(87663);
        ab.i("MicroMsg.CardConsumedMgr", "onChange()");
        ab.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kaS == null) {
            ab.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            bar();
            AppMethodBeat.o(87663);
            return;
        }
        ab.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kaS.aZB() && gVar.field_card_id != null && gVar.field_card_id.equals(this.kaS.aZZ()) && gVar.kdy == 3) {
            ab.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            bar();
            AppMethodBeat.o(87663);
        } else if (this.kaS.aZC()) {
            if (gVar.kdy == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.kaS.aZZ()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
                no aZW;
                if (gVar.field_card_id != null && gVar.field_card_id.equals(this.kaS.aZZ())) {
                    ShareCardInfo GK = am.bbe().GK(this.kaS.aZZ());
                    if (!(GK == null || GK.aZW() == null)) {
                        int i = this.kaS.aZW().status;
                        ab.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", Integer.valueOf(i), Integer.valueOf(GK.aZW().status), Integer.valueOf(((ShareCardInfo) this.kaS).field_status));
                        if (GK.aZW().status != i) {
                            baq();
                        } else if (i != 1) {
                            ab.i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
                            aZW = this.kaS.aZW();
                            aZW.status = 1;
                            ((ShareCardInfo) this.kaS).field_status = 1;
                            this.kaS.a(aZW);
                            l.h(this.kaS);
                        }
                    }
                } else if (gVar.field_card_id != null) {
                    ShareCardInfo GK2 = am.bbe().GK(gVar.field_card_id);
                    if (GK2 == null || GK2.aZW() == null) {
                        ab.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                    } else {
                        ab.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", Integer.valueOf(GK2.aZW().status), Integer.valueOf(GK2.field_status));
                        if (GK2.aZW().status != 1) {
                            aZW = GK2.aZW();
                            aZW.status = 1;
                            GK2.field_status = 1;
                            GK2.a(aZW);
                            l.h(GK2);
                        }
                    }
                }
                c(this.kaS);
                Boolean bool = (Boolean) this.kaQ.get(this.kaS.aZZ());
                if (bool == null || !bool.booleanValue()) {
                    Context context = (Context) this.atF.get();
                    ab.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kaS.aZZ());
                    com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kaS);
                    this.kaQ.put(this.kaS.aZZ(), Boolean.TRUE);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(30);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(31);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    h.pYm.b(arrayList, true);
                } else {
                    ab.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                }
                bas();
            }
            AppMethodBeat.o(87663);
        } else {
            ab.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            bar();
            AppMethodBeat.o(87663);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87664);
        ab.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) mVar;
                if (TextUtils.isEmpty(dVar.kdS)) {
                    ab.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    Gl(dVar.kdS);
                }
                this.kaT = false;
                ab.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                bar();
                AppMethodBeat.o(87664);
                return;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.kaT = false;
            ab.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            bar();
            AppMethodBeat.o(87664);
            return;
        }
        AppMethodBeat.o(87664);
    }

    private void Gl(String str) {
        AppMethodBeat.i(87665);
        ab.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.kaD == null) {
            AppMethodBeat.o(87665);
            return;
        }
        int i = 0;
        Object obj = null;
        while (i < this.kaD.size()) {
            WeakReference weakReference = (WeakReference) this.kaD.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                Boolean bool = (Boolean) this.kaP.get(aVar);
                if (!(aVar == null || bool == null || !bool.booleanValue())) {
                    aVar.Gm(str);
                    obj = 1;
                }
            }
            i++;
            obj = obj;
        }
        Boolean bool2 = (Boolean) this.kaQ.get(this.kaS.aZZ());
        if (obj != null) {
            ab.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
            this.kaU = "";
            AppMethodBeat.o(87665);
            return;
        }
        if (bool2 != null && bool2.booleanValue()) {
            ab.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
            this.kaU = str;
            this.kaR.put(this.kaS.aZZ(), Boolean.TRUE);
        }
        AppMethodBeat.o(87665);
    }

    private void c(b bVar) {
        AppMethodBeat.i(87666);
        ab.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.kaD == null) {
            AppMethodBeat.o(87666);
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
                        aVar.d(bVar);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87666);
                return;
            }
        }
    }

    private void baq() {
        AppMethodBeat.i(87667);
        ab.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.kaD == null) {
            AppMethodBeat.o(87667);
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
                        aVar.bau();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87667);
                return;
            }
        }
    }

    private void bar() {
        AppMethodBeat.i(87668);
        ab.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.kaD == null) {
            AppMethodBeat.o(87668);
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
                        aVar.bav();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(87668);
                return;
            }
        }
    }

    private void bas() {
        AppMethodBeat.i(87669);
        ab.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        bat();
        AppMethodBeat.o(87669);
    }

    private synchronized void bat() {
        AppMethodBeat.i(87670);
        if (this.kaT) {
            ab.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
            AppMethodBeat.o(87670);
        } else {
            ab.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.kaT = true;
            com.tencent.mm.kernel.g.RO().eJo.a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kaS.aZZ(), "", ""), 0);
            AppMethodBeat.o(87670);
        }
    }

    public final void release() {
        AppMethodBeat.i(87655);
        com.tencent.mm.kernel.g.RO().eJo.b(910, (f) this);
        am.bbd().b(this);
        b baV = am.baV();
        if (baV.kaD != null) {
            for (int i = 0; i < baV.kaD.size(); i++) {
                WeakReference weakReference = (WeakReference) baV.kaD.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        baV.kaD.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.kaD.clear();
        this.kaP.clear();
        this.kaR.clear();
        this.kaT = false;
        AppMethodBeat.o(87655);
    }
}
