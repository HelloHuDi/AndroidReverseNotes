package com.tencent.p177mm.plugin.notification.p476c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p230g.p231a.C45340kt;
import com.tencent.p177mm.p230g.p231a.C45373tq;
import com.tencent.p177mm.plugin.notification.p1005ui.C34641a;
import com.tencent.p177mm.plugin.notification.p1005ui.C34642b;
import com.tencent.p177mm.plugin.notification.p1005ui.C34643c;
import com.tencent.p177mm.plugin.notification.p1005ui.FailSendMsgNotification;
import com.tencent.p177mm.plugin.notification.p477d.C12730b;
import com.tencent.p177mm.plugin.notification.p477d.C12730b.C12731a;
import com.tencent.p177mm.plugin.notification.p477d.C34636f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.notification.c.a */
public abstract class C34627a<T> implements C12729c {
    protected Context mContext;
    protected C3557b oVG;
    protected FailSendMsgNotification oVH;
    protected boolean oVI;
    protected ArrayList<Long> oVJ;
    protected ArrayList<Long> oVK;
    protected ArrayList<Long> oVL;
    private ArrayList<C7564ap> oVM;
    private C7564ap oVN;
    private C4884c oVO;

    /* renamed from: com.tencent.mm.plugin.notification.c.a$1 */
    class C127281 extends C4884c<C45373tq> {
        C127281() {
            AppMethodBeat.m2504i(23099);
            this.xxI = C45373tq.class.getName().hashCode();
            AppMethodBeat.m2505o(23099);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(23100);
            C45373tq c45373tq = (C45373tq) c4883b;
            C34627a.m56806a(C34627a.this, c45373tq.cPN.cPO, c45373tq.cPN.cPP);
            AppMethodBeat.m2505o(23100);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.c.a$2 */
    class C213982 implements C34641a {

        /* renamed from: com.tencent.mm.plugin.notification.c.a$2$1 */
        class C213961 implements Runnable {
            C213961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(23101);
                C7060h.pYm.mo8381e(11425, Integer.valueOf(C34627a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
                C34627a.this.bWD();
                C34627a.m56804a(C34627a.this);
                C34627a.this.bWu();
                AppMethodBeat.m2505o(23101);
            }
        }

        /* renamed from: com.tencent.mm.plugin.notification.c.a$2$2 */
        class C213972 implements Runnable {
            C213972() {
            }

            public final void run() {
                AppMethodBeat.m2504i(23102);
                C7060h.pYm.mo8381e(11425, Integer.valueOf(C34627a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
                C34627a.this.bWD();
                C34627a.this.bWz();
                C34627a.this.bHM();
                C34627a.this.oVH.dismiss();
                AppMethodBeat.m2505o(23102);
            }
        }

        C213982() {
        }

        public final void bWG() {
            AppMethodBeat.m2504i(23103);
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
            C5004al.m7441d(new C213961());
            AppMethodBeat.m2505o(23103);
        }

        public final void bWH() {
            AppMethodBeat.m2504i(23104);
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
            C5004al.m7441d(new C213972());
            AppMethodBeat.m2505o(23104);
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.c.a$3 */
    class C286233 implements C34642b {
        C286233() {
        }

        public final void bWI() {
            AppMethodBeat.m2504i(23105);
            C7060h.pYm.mo8381e(11425, Integer.valueOf(C34627a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
            C34627a.this.bWD();
            C34627a.this.bWF();
            if (!C34627a.this.oVI) {
                C34627a.this.oVH.dismiss();
            }
            AppMethodBeat.m2505o(23105);
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.c.a$4 */
    class C346284 implements C34643c {
        C346284() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(23106);
            C34627a.this.bHM();
            AppMethodBeat.m2505o(23106);
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.c.a$5 */
    class C346295 implements C5015a {
        C346295() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(23107);
            if (C34627a.this.oVI) {
                C4990ab.m7417i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(C34627a.this.oVG.oVR.size()), Integer.valueOf(C34627a.this.oVJ.size()), Integer.valueOf(C34627a.this.oVK.size()));
                C34627a.this.bWw();
                C4990ab.m7417i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(C34627a.this.oVG.oVR.size()), Integer.valueOf(C34627a.this.oVJ.size()), Integer.valueOf(C34627a.this.oVK.size()));
                if (C34627a.this.oVG.oVR.size() > 0) {
                    C34627a.this.bWr();
                } else {
                    C34627a.this.bWs();
                }
                AppMethodBeat.m2505o(23107);
                return true;
            }
            AppMethodBeat.m2505o(23107);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.notification.c.a$6 */
    class C346306 implements Runnable {
        C346306() {
        }

        public final void run() {
            AppMethodBeat.m2504i(23108);
            C34627a.this.bWq();
            AppMethodBeat.m2505o(23108);
        }
    }

    /* renamed from: Aq */
    public abstract String mo55213Aq(int i);

    /* renamed from: N */
    public abstract void mo55214N(ArrayList<Long> arrayList);

    /* renamed from: af */
    public abstract String mo55215af(int i, int i2, int i3);

    public abstract void bWF();

    /* renamed from: cj */
    public abstract long mo55221cj(T t);

    /* renamed from: ck */
    public abstract ArrayList<Long> mo55222ck(T t);

    /* renamed from: eL */
    public abstract String mo55223eL(int i, int i2);

    /* renamed from: eM */
    public abstract String mo55224eM(int i, int i2);

    public abstract int getType();

    /* renamed from: jq */
    public abstract void mo55228jq(long j);

    /* renamed from: jr */
    public abstract boolean mo55229jr(long j);

    /* renamed from: a */
    static /* synthetic */ void m56805a(C34627a c34627a, long j) {
        while (!c34627a.mo55229jr(j)) {
            c34627a.oVK.add(Long.valueOf(j));
            C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", Long.valueOf(j));
            c34627a.bWr();
            j = c34627a.oVG.bWJ();
            if (j == -1) {
                C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (c34627a.oVJ.size() + c34627a.oVK.size() >= c34627a.oVG.oVR.size()) {
                    C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    c34627a.bWs();
                    return;
                }
                return;
            }
        }
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", Long.valueOf(j));
        c34627a.mo55228jq(j);
        C7564ap c7564ap = new C7564ap(new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(23110);
                if (!(C34627a.this.oVJ.contains(Long.valueOf(j)) || C34627a.this.oVK.contains(Long.valueOf(j)) || !C34627a.this.oVG.contains(j))) {
                    C4990ab.m7417i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", Long.valueOf(j));
                    C34627a.this.oVK.add(Long.valueOf(j));
                    C34627a.this.oVL.add(Long.valueOf(j));
                    if (C34627a.this.oVJ.size() + C34627a.this.oVK.size() >= C34627a.this.oVG.oVR.size()) {
                        C34627a.this.bWs();
                    } else {
                        C34627a.this.mo55227jp(C34627a.this.oVG.bWJ());
                    }
                }
                AppMethodBeat.m2505o(23110);
                return true;
            }
        }, false);
        c7564ap.mo16770ae(1800000, 1800000);
        c34627a.oVM.add(c7564ap);
    }

    public C34627a() {
        this.oVG = null;
        this.oVH = null;
        this.oVI = false;
        this.mContext = null;
        this.oVJ = null;
        this.oVK = null;
        this.oVL = null;
        this.oVM = new ArrayList();
        this.oVN = null;
        this.oVO = new C127281();
        this.oVG = new C3557b();
        this.oVH = new FailSendMsgNotification(getType());
        this.oVI = false;
        this.mContext = C4996ah.getContext();
        this.oVJ = new ArrayList();
        this.oVK = new ArrayList();
        this.oVL = new ArrayList();
        this.oVH.oWA = new C213982();
        this.oVH.oWB = new C286233();
        this.oVH.oWC = new C346284();
        bWo();
    }

    private void bWo() {
        this.oVN = new C7564ap(Looper.getMainLooper(), new C346295(), true);
    }

    private void bWp() {
        if (this.oVN != null) {
            this.oVN.stopTimer();
        } else {
            C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
    }

    /* renamed from: ch */
    public final void mo55219ch(T t) {
        if (t != null) {
            C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", Long.valueOf(mo55221cj(t)), bWA(), Boolean.valueOf(this.oVI));
            if (this.oVI) {
                if (this.oVG.contains(mo55221cj(t)) && !this.oVK.contains(Long.valueOf(mo55221cj(t)))) {
                    this.oVK.add(Long.valueOf(mo55221cj(t)));
                }
                if (!this.oVG.contains(mo55221cj(t))) {
                    C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.oVG.mo8115js(mo55221cj(t));
                }
                bWr();
                C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
                if (this.oVJ.size() + this.oVK.size() < this.oVG.oVR.size()) {
                    long bWJ = this.oVG.bWJ();
                    if (bWJ == -1) {
                        C4990ab.m7412e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bWJ));
                    bWE();
                    mo55227jp(bWJ);
                    return;
                }
                bWs();
            } else if (this.oVL.contains(Long.valueOf(mo55221cj(t)))) {
                this.oVL.remove(Long.valueOf(mo55221cj(t)));
            } else if (t == null) {
                C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                ArrayList ck = mo55222ck(t);
                if (ck == null || ck.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                bHM();
                C3557b c3557b = this.oVG;
                if (ck != null && ck.size() > 0) {
                    c3557b.oVR.addAll(ck);
                }
                bWE();
                C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", Integer.valueOf(this.oVG.oVR.size()), bWA());
                C7060h.pYm.mo8381e(11426, Integer.valueOf(getType()));
                C5004al.m7442n(new C346306(), 1000);
            }
        }
    }

    private void bWq() {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", Boolean.valueOf(C34636f.aJt()));
        this.oVH.oWE = mo55213Aq(this.oVG.oVR.size());
        this.oVH.bWU();
        if (!C34636f.aJt() && !this.oVH.oWJ) {
            this.oVH.oWD = mo55213Aq(this.oVG.oVR.size());
            this.oVH.bWT();
            this.oVH.bWS();
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.oVH.show();
            C4879a.xxA.mo10053d(this.oVO);
            C4879a.xxA.mo10052c(this.oVO);
        } else if (this.oVH.oWJ) {
            this.oVH.bWT();
            this.oVH.bWS();
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.oVH.mo68888TV(mo55213Aq(this.oVG.oVR.size()));
            C4879a.xxA.mo10053d(this.oVO);
            C4879a.xxA.mo10052c(this.oVO);
        } else {
            C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", Boolean.valueOf(C34636f.aJt()));
        }
    }

    /* renamed from: ci */
    public final void mo55220ci(T t) {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", Long.valueOf(mo55221cj(t)), bWA());
        if (this.oVG.contains(mo55221cj(t))) {
            long cj = mo55221cj(t);
            if (this.oVL.contains(Long.valueOf(cj)) && this.oVK.contains(Long.valueOf(cj))) {
                C4990ab.m7416i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.oVL.remove(Long.valueOf(cj));
                this.oVK.remove(Long.valueOf(cj));
            }
            if (this.oVI) {
                this.oVJ.add(Long.valueOf(cj));
                bWr();
                C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
                if (this.oVJ.size() + this.oVK.size() < this.oVG.oVR.size()) {
                    cj = this.oVG.bWJ();
                    if (cj == -1) {
                        C4990ab.m7412e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(cj));
                    bWE();
                    mo55227jp(cj);
                    return;
                }
                bWs();
                return;
            }
            this.oVG.remove(mo55221cj(t));
            if (this.oVG.oVR.size() == 0) {
                this.oVH.dismiss();
                bHM();
                C12730b.m20745As(getType());
                return;
            }
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.oVH.mo68888TV(mo55213Aq(this.oVG.oVR.size()));
        }
    }

    private void bWr() {
        if (VERSION.SDK_INT >= 16) {
            this.oVH.oWE = mo55213Aq(this.oVG.oVR.size());
            if (this.oVK.size() <= 0) {
                this.oVH.mo68888TV(mo55223eL(this.oVG.oVR.size(), this.oVJ.size() + this.oVK.size()));
            } else {
                this.oVH.mo68888TV(mo55215af(this.oVG.oVR.size(), this.oVJ.size() + this.oVK.size(), this.oVK.size()));
            }
        }
    }

    private void bWs() {
        this.oVI = false;
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVK.size()), Integer.valueOf(this.oVJ.size()));
        bWv();
        if (this.oVK.size() <= 0 || VERSION.SDK_INT < 16) {
            C12730b.m20745As(getType());
        }
        C7060h.pYm.mo8381e(11425, Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
        if (VERSION.SDK_INT >= 16) {
            this.oVH.bWT();
            this.oVH.oWE = mo55213Aq(this.oVG.oVR.size());
            FailSendMsgNotification failSendMsgNotification = this.oVH;
            this.oVG.oVR.size();
            failSendMsgNotification.mo68888TV(mo55224eM(this.oVJ.size(), this.oVK.size()));
            this.oVH.bWS();
            if (this.oVK.size() > 0) {
                this.oVH.bWU();
                this.oVH.show();
                bWC();
                bWE();
            }
        }
        C45340kt c45340kt = new C45340kt();
        c45340kt.cGI.type = getType();
        C4879a.xxA.mo10055m(c45340kt);
        bWp();
        bWy();
        C4879a.xxA.mo10053d(this.oVO);
        bWt();
    }

    /* Access modifiers changed, original: protected */
    public void bWt() {
    }

    public final void bWu() {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", Integer.valueOf(this.oVG.oVR.size()));
        this.oVI = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.oVH;
            failSendMsgNotification.oWL = false;
            failSendMsgNotification.oWx = C45186a.m83262bt(failSendMsgNotification.mContext, C45186a.dgM());
            failSendMsgNotification.bWR();
            failSendMsgNotification.show();
            C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.oVH;
            failSendMsgNotification.oWx.mo627k(2, true);
            failSendMsgNotification.oWK = true;
            failSendMsgNotification.show();
            C4990ab.m7410d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.oVH.mo68888TV(mo55223eL(this.oVG.oVR.size(), 0));
        }
        this.oVG.currentIndex = 0;
        bWy();
        C4879a.xxA.mo10053d(this.oVO);
        C4879a.xxA.mo10052c(this.oVO);
        mo55227jp(this.oVG.bWJ());
        if (this.oVN != null) {
            this.oVN.mo16770ae(300000, 300000);
        } else {
            C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    private void bWv() {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
        bWw();
        bWx();
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
    }

    private void bWw() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.oVG.oVR.size(); i++) {
            long j = this.oVG.get(i);
            if (!mo55229jr(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.oVG.remove(((Long) it.next()).longValue());
            }
        }
    }

    private void bWx() {
        Long l;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.oVJ.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!mo55229jr(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.oVJ.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.oVK.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!mo55229jr(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.oVK.remove((Long) it2.next());
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jp */
    public final void mo55227jp(final long j) {
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23109);
                C34627a.m56805a(C34627a.this, j);
                AppMethodBeat.m2505o(23109);
            }
        }, 200);
    }

    private void bWy() {
        Iterator it = this.oVM.iterator();
        while (it.hasNext()) {
            ((C7564ap) it.next()).stopTimer();
        }
        this.oVM.clear();
        this.oVL.clear();
    }

    public final void bWz() {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", Integer.valueOf(this.oVG.oVR.size()));
        if (this.oVG.oVR.size() > 0) {
            C3557b c3557b = this.oVG;
            ArrayList arrayList = new ArrayList();
            Iterator it = c3557b.oVR.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            mo55214N(arrayList);
        }
    }

    private void bHM() {
        this.oVG.clear();
        this.oVI = false;
        this.oVJ.clear();
        this.oVK.clear();
        bWy();
    }

    /* Access modifiers changed, original: protected|final */
    public final Context getContext() {
        return this.mContext;
    }

    private String bWA() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.oVG.oVR.size(); i++) {
            stringBuilder.append(this.oVG.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification bWB() {
        return this.oVH;
    }

    private void bWC() {
        this.oVG.currentIndex = 0;
        if (this.oVJ.size() > 0) {
            Iterator it = this.oVJ.iterator();
            while (it.hasNext()) {
                this.oVG.remove(((Long) it.next()).longValue());
            }
        }
        this.oVJ.clear();
        this.oVK.clear();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bWD() {
        if (this.oVG == null || this.oVG.oVR.size() == 0) {
            C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            C12731a Ar = C12730b.m20744Ar(getType());
            if (Ar == null) {
                C4990ab.m7412e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.oVN == null) {
                bWo();
            }
            C3557b c3557b = Ar.oVT;
            ArrayList arrayList = Ar.oVV;
            ArrayList arrayList2 = Ar.oVW;
            int i = Ar.oVU;
            if (arrayList.size() == 0 && arrayList2.size() == 0 && i == 0) {
                C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.oVG.clear();
                this.oVG = c3557b;
                this.oVJ.clear();
                this.oVK.clear();
                bWq();
            } else if (arrayList.size() + arrayList2.size() >= c3557b.oVR.size()) {
                C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                bWs();
            } else {
                C4990ab.m7410d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.oVG.clear();
                this.oVG = c3557b;
                this.oVG.currentIndex = i;
                this.oVJ.clear();
                this.oVJ.addAll(arrayList);
                this.oVK.clear();
                this.oVK.addAll(arrayList2);
                bWr();
            }
        }
    }

    private void bWE() {
        C12730b.m20746a(getType(), new C12731a(this.oVG, this.oVG.currentIndex, this.oVJ, this.oVK));
    }

    /* renamed from: a */
    static /* synthetic */ void m56806a(C34627a c34627a, long j, long j2) {
        C4990ab.m7417i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", Long.valueOf(j), Long.valueOf(j2));
        if (c34627a.oVG.contains(j)) {
            C3557b c3557b = c34627a.oVG;
            int indexOf = c3557b.oVR.indexOf(Long.valueOf(j));
            if (indexOf != -1) {
                c3557b.oVR.set(indexOf, Long.valueOf(j2));
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m56804a(C34627a c34627a) {
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", Integer.valueOf(c34627a.oVG.oVR.size()));
        c34627a.bWw();
        if (VERSION.SDK_INT >= 16) {
            c34627a.oVH.mo68888TV(c34627a.mo55213Aq(c34627a.oVG.oVR.size()));
        }
        C4990ab.m7411d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", Integer.valueOf(c34627a.oVG.oVR.size()));
    }
}
