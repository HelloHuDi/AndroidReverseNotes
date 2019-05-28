package com.tencent.p177mm.plugin.card.p352b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.base.C42838d;
import com.tencent.p177mm.plugin.card.model.C38747g;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C2752k.C2754a;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.sharecard.model.C20153d;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35938no;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.b.d */
public final class C27568d implements C1202f, C2754a, C42838d {
    public WeakReference<Context> atF;
    public List<WeakReference<C27569a>> kaD = new ArrayList();
    public HashMap<C27569a, Boolean> kaP = new HashMap();
    public HashMap<String, Boolean> kaQ = new HashMap();
    public HashMap<String, Boolean> kaR = new HashMap();
    public C42837b kaS = null;
    public boolean kaT = false;
    public String kaU;

    /* renamed from: com.tencent.mm.plugin.card.b.d$a */
    public interface C27569a {
        /* renamed from: Gm */
        void mo41610Gm(String str);

        void bau();

        void bav();

        /* renamed from: d */
        void mo41613d(C42837b c42837b);
    }

    public C27568d() {
        AppMethodBeat.m2504i(87654);
        AppMethodBeat.m2505o(87654);
    }

    /* renamed from: a */
    public final void mo45372a(C27569a c27569a) {
        AppMethodBeat.m2504i(87656);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(c27569a));
        AppMethodBeat.m2505o(87656);
    }

    /* renamed from: b */
    public final void mo45374b(C27569a c27569a) {
        AppMethodBeat.m2504i(87657);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87657);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C27569a c27569a2 = (C27569a) weakReference.get();
                    if (c27569a2 != null && c27569a2.equals(c27569a)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.m2505o(87657);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87657);
                return;
            }
        }
    }

    /* renamed from: b */
    public final void mo45375b(C42837b c42837b) {
        boolean z = false;
        AppMethodBeat.m2504i(87658);
        this.kaS = c42837b;
        if (!(!this.kaT || this.kaS == null || c42837b.aZZ() == null || c42837b.aZZ().equals(this.kaS.aZZ()))) {
            this.kaT = false;
        }
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87658);
            return;
        }
        while (true) {
            boolean z2 = z;
            if (z2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(z2);
                if (weakReference != null) {
                    C27569a c27569a = (C27569a) weakReference.get();
                    Boolean bool = (Boolean) this.kaP.get(c27569a);
                    if (!(c27569a == null || bool == null || bool.booleanValue())) {
                        c27569a.mo41613d(c42837b);
                    }
                }
                z = z2 + 1;
            } else {
                AppMethodBeat.m2505o(87658);
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo45373a(C27569a c27569a, boolean z) {
        AppMethodBeat.m2504i(87659);
        if (this.kaP == null) {
            this.kaP = new HashMap();
        }
        this.kaP.put(c27569a, Boolean.valueOf(z));
        AppMethodBeat.m2505o(87659);
    }

    /* renamed from: c */
    public final void mo45377c(C27569a c27569a) {
        AppMethodBeat.m2504i(87660);
        if (this.kaP == null) {
            this.kaP = new HashMap();
        }
        this.kaP.remove(c27569a);
        AppMethodBeat.m2505o(87660);
    }

    public final void bag() {
        AppMethodBeat.m2504i(87661);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            AppMethodBeat.m2505o(87661);
            return;
        }
        C42837b GK;
        if (this.kaS.aZC()) {
            GK = C42852am.bbe().mo35397GK(this.kaS.aZZ());
        } else {
            Object GK2 = C42852am.baW().mo45383Gu(this.kaS.aZZ());
        }
        if (!(GK2 == null || GK2.aZW() == null || this.kaS == null || this.kaS.aZW() == null)) {
            C4990ab.m7411d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", Integer.valueOf(this.kaS.aZW().status), Integer.valueOf(GK2.aZW().status), Boolean.valueOf(this.kaT), Boolean.valueOf(this.kaS.aZC()));
            if (this.kaS.aZC() && (this.kaS instanceof ShareCardInfo)) {
                C4990ab.m7411d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", Integer.valueOf(((ShareCardInfo) this.kaS).field_status));
            } else if (this.kaS.aZC()) {
                C4990ab.m7412e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (GK2.aZW().status != r2) {
                baq();
                if (this.kaS.aZC() && !this.kaT && GK2.aZW().status == 1) {
                    C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.kaQ.get(this.kaS.aZZ());
                    if (bool == null || !bool.booleanValue()) {
                        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.atF.get();
                        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kaS.aZZ());
                        C42856b.m76079a(context, this.kaS);
                        this.kaQ.put(this.kaS.aZZ(), Boolean.TRUE);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        C7060h.pYm.mo8379b(arrayList, true);
                    } else {
                        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    bas();
                } else if (this.kaS.aZC() && this.kaT) {
                    C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    bar();
                }
                C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.kaS = GK2;
            m43782c(this.kaS);
        }
        AppMethodBeat.m2505o(87661);
    }

    public final void aVU() {
        AppMethodBeat.m2504i(87662);
        baq();
        AppMethodBeat.m2505o(87662);
    }

    /* renamed from: a */
    public final void mo6836a(C38747g c38747g) {
        AppMethodBeat.m2504i(87663);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onChange()");
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "card msg card id is " + c38747g.field_card_id);
        if (this.kaS == null) {
            C4990ab.m7412e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            bar();
            AppMethodBeat.m2505o(87663);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "card msg card id is " + c38747g.field_card_id);
        if (this.kaS.aZB() && c38747g.field_card_id != null && c38747g.field_card_id.equals(this.kaS.aZZ()) && c38747g.kdy == 3) {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            bar();
            AppMethodBeat.m2505o(87663);
        } else if (this.kaS.aZC()) {
            if (c38747g.kdy == 3 || !(c38747g.field_card_id == null || !c38747g.field_card_id.equals(this.kaS.aZZ()) || TextUtils.isEmpty(c38747g.field_consumed_box_id))) {
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
                C35938no aZW;
                if (c38747g.field_card_id != null && c38747g.field_card_id.equals(this.kaS.aZZ())) {
                    ShareCardInfo GK = C42852am.bbe().mo35397GK(this.kaS.aZZ());
                    if (!(GK == null || GK.aZW() == null)) {
                        int i = this.kaS.aZW().status;
                        C4990ab.m7411d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", Integer.valueOf(i), Integer.valueOf(GK.aZW().status), Integer.valueOf(((ShareCardInfo) this.kaS).field_status));
                        if (GK.aZW().status != i) {
                            baq();
                        } else if (i != 1) {
                            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "share card oldState status is ".concat(String.valueOf(i)));
                            aZW = this.kaS.aZW();
                            aZW.status = 1;
                            ((ShareCardInfo) this.kaS).field_status = 1;
                            this.kaS.mo45388a(aZW);
                            C38736l.m65732h(this.kaS);
                        }
                    }
                } else if (c38747g.field_card_id != null) {
                    ShareCardInfo GK2 = C42852am.bbe().mo35397GK(c38747g.field_card_id);
                    if (GK2 == null || GK2.aZW() == null) {
                        C4990ab.m7420w("MicroMsg.CardConsumedMgr", "tempCard is null");
                    } else {
                        C4990ab.m7411d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", Integer.valueOf(GK2.aZW().status), Integer.valueOf(GK2.field_status));
                        if (GK2.aZW().status != 1) {
                            aZW = GK2.aZW();
                            aZW.status = 1;
                            GK2.field_status = 1;
                            GK2.mo45388a(aZW);
                            C38736l.m65732h(GK2);
                        }
                    }
                }
                m43782c(this.kaS);
                Boolean bool = (Boolean) this.kaQ.get(this.kaS.aZZ());
                if (bool == null || !bool.booleanValue()) {
                    Context context = (Context) this.atF.get();
                    C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kaS.aZZ());
                    C42856b.m76079a(context, this.kaS);
                    this.kaQ.put(this.kaS.aZZ(), Boolean.TRUE);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey.SetKey(30);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
                    iDKey2.SetKey(31);
                    iDKey2.SetValue((long) ((int) (currentTimeMillis2 - currentTimeMillis)));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    C7060h.pYm.mo8379b(arrayList, true);
                } else {
                    C4990ab.m7416i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                }
                bas();
            }
            AppMethodBeat.m2505o(87663);
        } else {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            bar();
            AppMethodBeat.m2505o(87663);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87664);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C20153d) {
                C20153d c20153d = (C20153d) c1207m;
                if (TextUtils.isEmpty(c20153d.kdS)) {
                    C4990ab.m7412e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    m43781Gl(c20153d.kdS);
                }
                this.kaT = false;
                C4990ab.m7412e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                bar();
                AppMethodBeat.m2505o(87664);
                return;
            }
        } else if (c1207m instanceof C20153d) {
            this.kaT = false;
            C4990ab.m7412e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            bar();
            AppMethodBeat.m2505o(87664);
            return;
        }
        AppMethodBeat.m2505o(87664);
    }

    /* renamed from: Gl */
    private void m43781Gl(String str) {
        AppMethodBeat.m2504i(87665);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87665);
            return;
        }
        int i = 0;
        Object obj = null;
        while (i < this.kaD.size()) {
            WeakReference weakReference = (WeakReference) this.kaD.get(i);
            if (weakReference != null) {
                C27569a c27569a = (C27569a) weakReference.get();
                Boolean bool = (Boolean) this.kaP.get(c27569a);
                if (!(c27569a == null || bool == null || !bool.booleanValue())) {
                    c27569a.mo41610Gm(str);
                    obj = 1;
                }
            }
            i++;
            obj = obj;
        }
        Boolean bool2 = (Boolean) this.kaQ.get(this.kaS.aZZ());
        if (obj != null) {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
            this.kaU = "";
            AppMethodBeat.m2505o(87665);
            return;
        }
        if (bool2 != null && bool2.booleanValue()) {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
            this.kaU = str;
            this.kaR.put(this.kaS.aZZ(), Boolean.TRUE);
        }
        AppMethodBeat.m2505o(87665);
    }

    /* renamed from: c */
    private void m43782c(C42837b c42837b) {
        AppMethodBeat.m2504i(87666);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87666);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C27569a c27569a = (C27569a) weakReference.get();
                    if (c27569a != null) {
                        c27569a.mo41613d(c42837b);
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87666);
                return;
            }
        }
    }

    private void baq() {
        AppMethodBeat.m2504i(87667);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87667);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C27569a c27569a = (C27569a) weakReference.get();
                    if (c27569a != null) {
                        c27569a.bau();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87667);
                return;
            }
        }
    }

    private void bar() {
        AppMethodBeat.m2504i(87668);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.kaD == null) {
            AppMethodBeat.m2505o(87668);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    C27569a c27569a = (C27569a) weakReference.get();
                    if (c27569a != null) {
                        c27569a.bav();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(87668);
                return;
            }
        }
    }

    private void bas() {
        AppMethodBeat.m2504i(87669);
        C4990ab.m7416i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        bat();
        AppMethodBeat.m2505o(87669);
    }

    private synchronized void bat() {
        AppMethodBeat.m2504i(87670);
        if (this.kaT) {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
            AppMethodBeat.m2505o(87670);
        } else {
            C4990ab.m7416i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.kaT = true;
            C1720g.m3535RO().eJo.mo14541a(new C20153d(this.kaS.aZZ(), "", ""), 0);
            AppMethodBeat.m2505o(87670);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(87655);
        C1720g.m3535RO().eJo.mo14546b(910, (C1202f) this);
        C42852am.bbd().mo68361b(this);
        C27567b baV = C42852am.baV();
        if (baV.kaD != null) {
            for (int i = 0; i < baV.kaD.size(); i++) {
                WeakReference weakReference = (WeakReference) baV.kaD.get(i);
                if (weakReference != null) {
                    C42838d c42838d = (C42838d) weakReference.get();
                    if (c42838d != null && c42838d.equals(this)) {
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
        AppMethodBeat.m2505o(87655);
    }
}
