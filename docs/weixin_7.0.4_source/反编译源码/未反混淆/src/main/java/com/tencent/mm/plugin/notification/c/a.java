package com.tencent.mm.plugin.notification.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class a<T> implements c {
    protected Context mContext;
    protected b oVG;
    protected FailSendMsgNotification oVH;
    protected boolean oVI;
    protected ArrayList<Long> oVJ;
    protected ArrayList<Long> oVK;
    protected ArrayList<Long> oVL;
    private ArrayList<ap> oVM;
    private ap oVN;
    private c oVO;

    public abstract String Aq(int i);

    public abstract void N(ArrayList<Long> arrayList);

    public abstract String af(int i, int i2, int i3);

    public abstract void bWF();

    public abstract long cj(T t);

    public abstract ArrayList<Long> ck(T t);

    public abstract String eL(int i, int i2);

    public abstract String eM(int i, int i2);

    public abstract int getType();

    public abstract void jq(long j);

    public abstract boolean jr(long j);

    static /* synthetic */ void a(a aVar, long j) {
        while (!aVar.jr(j)) {
            aVar.oVK.add(Long.valueOf(j));
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", Long.valueOf(j));
            aVar.bWr();
            j = aVar.oVG.bWJ();
            if (j == -1) {
                ab.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.oVJ.size() + aVar.oVK.size() >= aVar.oVG.oVR.size()) {
                    ab.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.bWs();
                    return;
                }
                return;
            }
        }
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", Long.valueOf(j));
        aVar.jq(j);
        ap apVar = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(23110);
                if (!(a.this.oVJ.contains(Long.valueOf(j)) || a.this.oVK.contains(Long.valueOf(j)) || !a.this.oVG.contains(j))) {
                    ab.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", Long.valueOf(j));
                    a.this.oVK.add(Long.valueOf(j));
                    a.this.oVL.add(Long.valueOf(j));
                    if (a.this.oVJ.size() + a.this.oVK.size() >= a.this.oVG.oVR.size()) {
                        a.this.bWs();
                    } else {
                        a.this.jp(a.this.oVG.bWJ());
                    }
                }
                AppMethodBeat.o(23110);
                return true;
            }
        }, false);
        apVar.ae(1800000, 1800000);
        aVar.oVM.add(apVar);
    }

    public a() {
        this.oVG = null;
        this.oVH = null;
        this.oVI = false;
        this.mContext = null;
        this.oVJ = null;
        this.oVK = null;
        this.oVL = null;
        this.oVM = new ArrayList();
        this.oVN = null;
        this.oVO = new c<tq>() {
            {
                AppMethodBeat.i(23099);
                this.xxI = tq.class.getName().hashCode();
                AppMethodBeat.o(23099);
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(23100);
                tq tqVar = (tq) bVar;
                a.a(a.this, tqVar.cPN.cPO, tqVar.cPN.cPP);
                AppMethodBeat.o(23100);
                return false;
            }
        };
        this.oVG = new b();
        this.oVH = new FailSendMsgNotification(getType());
        this.oVI = false;
        this.mContext = ah.getContext();
        this.oVJ = new ArrayList();
        this.oVK = new ArrayList();
        this.oVL = new ArrayList();
        this.oVH.oWA = new com.tencent.mm.plugin.notification.ui.a() {
            public final void bWG() {
                AppMethodBeat.i(23103);
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(23101);
                        h.pYm.e(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0));
                        a.this.bWD();
                        a.a(a.this);
                        a.this.bWu();
                        AppMethodBeat.o(23101);
                    }
                });
                AppMethodBeat.o(23103);
            }

            public final void bWH() {
                AppMethodBeat.i(23104);
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(23102);
                        h.pYm.e(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
                        a.this.bWD();
                        a.this.bWz();
                        a.this.bHM();
                        a.this.oVH.dismiss();
                        AppMethodBeat.o(23102);
                    }
                });
                AppMethodBeat.o(23104);
            }
        };
        this.oVH.oWB = new com.tencent.mm.plugin.notification.ui.b() {
            public final void bWI() {
                AppMethodBeat.i(23105);
                h.pYm.e(11425, Integer.valueOf(a.this.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
                a.this.bWD();
                a.this.bWF();
                if (!a.this.oVI) {
                    a.this.oVH.dismiss();
                }
                AppMethodBeat.o(23105);
            }
        };
        this.oVH.oWC = new com.tencent.mm.plugin.notification.ui.c() {
            public final void onDismiss() {
                AppMethodBeat.i(23106);
                a.this.bHM();
                AppMethodBeat.o(23106);
            }
        };
        bWo();
    }

    private void bWo() {
        this.oVN = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(23107);
                if (a.this.oVI) {
                    ab.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.oVG.oVR.size()), Integer.valueOf(a.this.oVJ.size()), Integer.valueOf(a.this.oVK.size()));
                    a.this.bWw();
                    ab.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", Integer.valueOf(a.this.oVG.oVR.size()), Integer.valueOf(a.this.oVJ.size()), Integer.valueOf(a.this.oVK.size()));
                    if (a.this.oVG.oVR.size() > 0) {
                        a.this.bWr();
                    } else {
                        a.this.bWs();
                    }
                    AppMethodBeat.o(23107);
                    return true;
                }
                AppMethodBeat.o(23107);
                return false;
            }
        }, true);
    }

    private void bWp() {
        if (this.oVN != null) {
            this.oVN.stopTimer();
        } else {
            ab.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
    }

    public final void ch(T t) {
        if (t != null) {
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", Long.valueOf(cj(t)), bWA(), Boolean.valueOf(this.oVI));
            if (this.oVI) {
                if (this.oVG.contains(cj(t)) && !this.oVK.contains(Long.valueOf(cj(t)))) {
                    this.oVK.add(Long.valueOf(cj(t)));
                }
                if (!this.oVG.contains(cj(t))) {
                    ab.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.oVG.js(cj(t));
                }
                bWr();
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
                if (this.oVJ.size() + this.oVK.size() < this.oVG.oVR.size()) {
                    long bWJ = this.oVG.bWJ();
                    if (bWJ == -1) {
                        ab.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    ab.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(bWJ));
                    bWE();
                    jp(bWJ);
                    return;
                }
                bWs();
            } else if (this.oVL.contains(Long.valueOf(cj(t)))) {
                this.oVL.remove(Long.valueOf(cj(t)));
            } else if (t == null) {
                ab.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                ArrayList ck = ck(t);
                if (ck == null || ck.size() <= 0) {
                    ab.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                bHM();
                b bVar = this.oVG;
                if (ck != null && ck.size() > 0) {
                    bVar.oVR.addAll(ck);
                }
                bWE();
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", Integer.valueOf(this.oVG.oVR.size()), bWA());
                h.pYm.e(11426, Integer.valueOf(getType()));
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(23108);
                        a.this.bWq();
                        AppMethodBeat.o(23108);
                    }
                }, 1000);
            }
        }
    }

    private void bWq() {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", Boolean.valueOf(f.aJt()));
        this.oVH.oWE = Aq(this.oVG.oVR.size());
        this.oVH.bWU();
        if (!f.aJt() && !this.oVH.oWJ) {
            this.oVH.oWD = Aq(this.oVG.oVR.size());
            this.oVH.bWT();
            this.oVH.bWS();
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.oVH.show();
            com.tencent.mm.sdk.b.a.xxA.d(this.oVO);
            com.tencent.mm.sdk.b.a.xxA.c(this.oVO);
        } else if (this.oVH.oWJ) {
            this.oVH.bWT();
            this.oVH.bWS();
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.oVH.TV(Aq(this.oVG.oVR.size()));
            com.tencent.mm.sdk.b.a.xxA.d(this.oVO);
            com.tencent.mm.sdk.b.a.xxA.c(this.oVO);
        } else {
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", Boolean.valueOf(f.aJt()));
        }
    }

    public final void ci(T t) {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", Long.valueOf(cj(t)), bWA());
        if (this.oVG.contains(cj(t))) {
            long cj = cj(t);
            if (this.oVL.contains(Long.valueOf(cj)) && this.oVK.contains(Long.valueOf(cj))) {
                ab.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.oVL.remove(Long.valueOf(cj));
                this.oVK.remove(Long.valueOf(cj));
            }
            if (this.oVI) {
                this.oVJ.add(Long.valueOf(cj));
                bWr();
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
                if (this.oVJ.size() + this.oVK.size() < this.oVG.oVR.size()) {
                    cj = this.oVG.bWJ();
                    if (cj == -1) {
                        ab.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    ab.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", Long.valueOf(cj));
                    bWE();
                    jp(cj);
                    return;
                }
                bWs();
                return;
            }
            this.oVG.remove(cj(t));
            if (this.oVG.oVR.size() == 0) {
                this.oVH.dismiss();
                bHM();
                com.tencent.mm.plugin.notification.d.b.As(getType());
                return;
            }
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.oVH.TV(Aq(this.oVG.oVR.size()));
        }
    }

    private void bWr() {
        if (VERSION.SDK_INT >= 16) {
            this.oVH.oWE = Aq(this.oVG.oVR.size());
            if (this.oVK.size() <= 0) {
                this.oVH.TV(eL(this.oVG.oVR.size(), this.oVJ.size() + this.oVK.size()));
            } else {
                this.oVH.TV(af(this.oVG.oVR.size(), this.oVJ.size() + this.oVK.size(), this.oVK.size()));
            }
        }
    }

    private void bWs() {
        this.oVI = false;
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVK.size()), Integer.valueOf(this.oVJ.size()));
        bWv();
        if (this.oVK.size() <= 0 || VERSION.SDK_INT < 16) {
            com.tencent.mm.plugin.notification.d.b.As(getType());
        }
        h.pYm.e(11425, Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
        if (VERSION.SDK_INT >= 16) {
            this.oVH.bWT();
            this.oVH.oWE = Aq(this.oVG.oVR.size());
            FailSendMsgNotification failSendMsgNotification = this.oVH;
            this.oVG.oVR.size();
            failSendMsgNotification.TV(eM(this.oVJ.size(), this.oVK.size()));
            this.oVH.bWS();
            if (this.oVK.size() > 0) {
                this.oVH.bWU();
                this.oVH.show();
                bWC();
                bWE();
            }
        }
        kt ktVar = new kt();
        ktVar.cGI.type = getType();
        com.tencent.mm.sdk.b.a.xxA.m(ktVar);
        bWp();
        bWy();
        com.tencent.mm.sdk.b.a.xxA.d(this.oVO);
        bWt();
    }

    /* Access modifiers changed, original: protected */
    public void bWt() {
    }

    public final void bWu() {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", Integer.valueOf(this.oVG.oVR.size()));
        this.oVI = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.oVH;
            failSendMsgNotification.oWL = false;
            failSendMsgNotification.oWx = com.tencent.mm.bo.a.bt(failSendMsgNotification.mContext, com.tencent.mm.bo.a.dgM());
            failSendMsgNotification.bWR();
            failSendMsgNotification.show();
            ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.oVH;
            failSendMsgNotification.oWx.k(2, true);
            failSendMsgNotification.oWK = true;
            failSendMsgNotification.show();
            ab.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.oVH.TV(eL(this.oVG.oVR.size(), 0));
        }
        this.oVG.currentIndex = 0;
        bWy();
        com.tencent.mm.sdk.b.a.xxA.d(this.oVO);
        com.tencent.mm.sdk.b.a.xxA.c(this.oVO);
        jp(this.oVG.bWJ());
        if (this.oVN != null) {
            this.oVN.ae(300000, 300000);
        } else {
            ab.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    private void bWv() {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
        bWw();
        bWx();
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", Integer.valueOf(this.oVG.oVR.size()), Integer.valueOf(this.oVJ.size()), Integer.valueOf(this.oVK.size()));
    }

    private void bWw() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.oVG.oVR.size(); i++) {
            long j = this.oVG.get(i);
            if (!jr(j)) {
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
            if (!jr(l.longValue())) {
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
            if (!jr(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.oVK.remove((Long) it2.next());
        }
    }

    /* Access modifiers changed, original: final */
    public final void jp(final long j) {
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23109);
                a.a(a.this, j);
                AppMethodBeat.o(23109);
            }
        }, 200);
    }

    private void bWy() {
        Iterator it = this.oVM.iterator();
        while (it.hasNext()) {
            ((ap) it.next()).stopTimer();
        }
        this.oVM.clear();
        this.oVL.clear();
    }

    public final void bWz() {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", Integer.valueOf(this.oVG.oVR.size()));
        if (this.oVG.oVR.size() > 0) {
            b bVar = this.oVG;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.oVR.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            N(arrayList);
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
            ab.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.d.b.a Ar = com.tencent.mm.plugin.notification.d.b.Ar(getType());
            if (Ar == null) {
                ab.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.oVN == null) {
                bWo();
            }
            b bVar = Ar.oVT;
            ArrayList arrayList = Ar.oVV;
            ArrayList arrayList2 = Ar.oVW;
            int i = Ar.oVU;
            if (arrayList.size() == 0 && arrayList2.size() == 0 && i == 0) {
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.oVG.clear();
                this.oVG = bVar;
                this.oVJ.clear();
                this.oVK.clear();
                bWq();
            } else if (arrayList.size() + arrayList2.size() >= bVar.oVR.size()) {
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                bWs();
            } else {
                ab.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.oVG.clear();
                this.oVG = bVar;
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
        com.tencent.mm.plugin.notification.d.b.a(getType(), new com.tencent.mm.plugin.notification.d.b.a(this.oVG, this.oVG.currentIndex, this.oVJ, this.oVK));
    }

    static /* synthetic */ void a(a aVar, long j, long j2) {
        ab.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", Long.valueOf(j), Long.valueOf(j2));
        if (aVar.oVG.contains(j)) {
            b bVar = aVar.oVG;
            int indexOf = bVar.oVR.indexOf(Long.valueOf(j));
            if (indexOf != -1) {
                bVar.oVR.set(indexOf, Long.valueOf(j2));
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", Integer.valueOf(aVar.oVG.oVR.size()));
        aVar.bWw();
        if (VERSION.SDK_INT >= 16) {
            aVar.oVH.TV(aVar.Aq(aVar.oVG.oVR.size()));
        }
        ab.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", Integer.valueOf(aVar.oVG.oVR.size()));
    }
}
