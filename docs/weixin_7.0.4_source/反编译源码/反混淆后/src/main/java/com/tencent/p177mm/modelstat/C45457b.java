package com.tencent.p177mm.modelstat;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p230g.p231a.C6542qe;
import com.tencent.p177mm.plugin.report.kvdata.IMBehavior;
import com.tencent.p177mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.p177mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.p177mm.plugin.report.kvdata.log_13835;
import com.tencent.p177mm.plugin.report.kvdata.log_13913;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* renamed from: com.tencent.mm.modelstat.b */
public final class C45457b {
    public static C45457b fRa = new C45457b();
    private C4884c ecP = new C454561();
    public log_13835 fQZ;
    private int fRb = 1;
    private int fRc = 1;
    private boolean hasInit = false;
    public Object lock = new Object();

    /* renamed from: com.tencent.mm.modelstat.b$a */
    public enum C1873a {
        OP_Chatting(1),
        OP_Msg(2);
        
        public int value;

        static {
            AppMethodBeat.m2505o(78629);
        }

        private C1873a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.b$b */
    public enum C18681b {
        UnKnownType(0),
        expourse(1),
        click(2),
        send(3),
        fav(4),
        revoke(5),
        delete(6),
        voiceToText(7),
        translate(8),
        translateHidden(9),
        doubleClickText(10),
        imageSaveToLocal(11),
        playMusic(12),
        stopMusic(13);
        
        public int value;

        static {
            AppMethodBeat.m2505o(78632);
        }

        private C18681b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.modelstat.b$1 */
    class C454561 extends C4884c<C6542qe> {
        C454561() {
            AppMethodBeat.m2504i(78623);
            this.xxI = C6542qe.class.getName().hashCode();
            AppMethodBeat.m2505o(78623);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78624);
            C6542qe c6542qe = (C6542qe) c4883b;
            if (c6542qe instanceof C6542qe) {
                C45457b.this.mo73265j(c6542qe.cMu.csG);
            }
            AppMethodBeat.m2505o(78624);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(78656);
        AppMethodBeat.m2505o(78656);
    }

    private C45457b() {
        AppMethodBeat.m2504i(78633);
        C4879a.xxA.mo10051b(this.ecP);
        AppMethodBeat.m2505o(78633);
    }

    /* renamed from: cM */
    public final boolean mo73264cM(String str) {
        AppMethodBeat.m2504i(78634);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.ChattingOperationUitl", "check error:%s", C5046bo.dpG().toString());
            log_13913 log_13913 = new log_13913();
            log_13913.scene_ = 1;
            log_13913.error_ = r2;
            C7060h.pYm.mo15417c(13913, log_13913);
            AppMethodBeat.m2505o(78634);
            return false;
        }
        if (!(this.fQZ == null || this.fQZ.currChatName_ == null || this.fQZ.currChatName_.equals(str))) {
            mo73253IF();
        }
        if (this.fQZ == null) {
            this.fQZ = new log_13835();
            this.fQZ.currChatName_ = str;
        }
        AppMethodBeat.m2505o(78634);
        return true;
    }

    /* renamed from: IF */
    public final void mo73253IF() {
        AppMethodBeat.m2504i(78635);
        if (aka()) {
            int i;
            synchronized (this.lock) {
                try {
                    i = (this.fQZ == null || this.fQZ.oplist_.isEmpty()) ? 0 : 1;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78635);
                    }
                }
            }
            if (i != 0) {
                if (this.fRc != 0) {
                    C4990ab.m7416i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    C7060h.pYm.mo15417c(13835, this.fQZ);
                }
                if (this.fRb != 0) {
                    C4990ab.m7417i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", ajZ());
                    C7060h.pYm.mo8374X(13748, r0);
                }
            }
            this.fQZ = null;
            AppMethodBeat.m2505o(78635);
            return;
        }
        AppMethodBeat.m2505o(78635);
    }

    /* renamed from: Q */
    public final void mo73254Q(String str, boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(78636);
        if (aka()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            mo73253IF();
            if (mo73264cM(str)) {
                synchronized (this.lock) {
                    try {
                        this.fQZ.oplist_.add(iMBehavior);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(78636);
                    }
                }
                mo73253IF();
                return;
            }
            AppMethodBeat.m2505o(78636);
            return;
        }
        AppMethodBeat.m2505o(78636);
    }

    /* renamed from: c */
    public final void mo73263c(boolean z, String str, boolean z2) {
        int i = 1;
        AppMethodBeat.m2504i(78637);
        if (aka()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z2) {
                i = 2;
            }
            iMBehaviorChattingOP.changeTop = i;
            if (z) {
                mo73253IF();
            }
            if (mo73264cM(str)) {
                synchronized (this.lock) {
                    try {
                        this.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(78637);
                        }
                    }
                }
                if (z) {
                    mo73253IF();
                }
                AppMethodBeat.m2505o(78637);
                return;
            }
            AppMethodBeat.m2505o(78637);
            return;
        }
        AppMethodBeat.m2505o(78637);
    }

    /* renamed from: R */
    public final void mo73255R(String str, boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(78638);
        if (!aka()) {
            AppMethodBeat.m2505o(78638);
        } else if (mo73264cM(str)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i;
            synchronized (this.lock) {
                try {
                    this.fQZ.oplist_.add(iMBehavior);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(78638);
                }
            }
        } else {
            AppMethodBeat.m2505o(78638);
        }
    }

    /* renamed from: a */
    private void m83739a(IMBehavior iMBehavior) {
        AppMethodBeat.m2504i(78639);
        synchronized (this.lock) {
            try {
                if (iMBehavior.opType == C1873a.OP_Chatting.value) {
                    this.fQZ.oplist_.add(iMBehavior);
                } else {
                    Iterator it = this.fQZ.oplist_.iterator();
                    while (it.hasNext()) {
                        IMBehavior iMBehavior2 = (IMBehavior) it.next();
                        if (iMBehavior2.opType == C1873a.OP_Msg.value) {
                            Object obj;
                            IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior2.msgOp;
                            IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                            if (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                IMBehaviorMsgOP iMBehaviorMsgOP3 = iMBehavior2.msgOp;
                                iMBehaviorMsgOP3.count++;
                                AppMethodBeat.m2505o(78639);
                                return;
                            }
                        }
                    }
                    this.fQZ.oplist_.add(iMBehavior);
                    AppMethodBeat.m2505o(78639);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78639);
            }
        }
    }

    /* renamed from: a */
    public final void mo73257a(C7620bi c7620bi, C18681b c18681b, int i) {
        AppMethodBeat.m2504i(78640);
        if (c7620bi == null || !mo73264cM(c7620bi.field_talker)) {
            AppMethodBeat.m2505o(78640);
            return;
        }
        IMBehavior iMBehavior = new IMBehavior();
        iMBehavior.opType = 2;
        iMBehavior.msgOp = new IMBehaviorMsgOP();
        iMBehavior.msgOp.msgType = c7620bi.getType() & CdnLogic.kBizGeneric;
        if (c7620bi.bAA()) {
            iMBehavior.msgOp.appMsgInnerType = i;
        }
        iMBehavior.msgOp.msgOpType = c18681b.value;
        iMBehavior.msgOp.count = 1;
        m83739a(iMBehavior);
        AppMethodBeat.m2505o(78640);
    }

    /* renamed from: a */
    public final void mo73256a(final C7620bi c7620bi, final int i) {
        AppMethodBeat.m2504i(78641);
        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78625);
                C45457b.m83738a(C45457b.this, c7620bi, i);
                AppMethodBeat.m2505o(78625);
            }
        });
        AppMethodBeat.m2505o(78641);
    }

    /* renamed from: j */
    public final void mo73265j(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(78642);
        new C7306ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(78626);
                C45457b.m83738a(C45457b.this, c7620bi, 0);
                AppMethodBeat.m2505o(78626);
            }
        });
        AppMethodBeat.m2505o(78642);
    }

    /* renamed from: b */
    public final void mo73261b(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(78643);
        if (aka()) {
            mo73257a(c7620bi, C18681b.fav, i);
            AppMethodBeat.m2505o(78643);
            return;
        }
        AppMethodBeat.m2505o(78643);
    }

    /* renamed from: D */
    public final void mo73248D(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78644);
        if (aka()) {
            mo73257a(c7620bi, C18681b.fav, 0);
            AppMethodBeat.m2505o(78644);
            return;
        }
        AppMethodBeat.m2505o(78644);
    }

    /* renamed from: c */
    public final void mo73262c(C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(78645);
        if (aka()) {
            mo73257a(c7620bi, C18681b.delete, i);
            AppMethodBeat.m2505o(78645);
            return;
        }
        AppMethodBeat.m2505o(78645);
    }

    /* renamed from: E */
    public final void mo73249E(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78646);
        if (aka()) {
            mo73257a(c7620bi, C18681b.delete, 0);
            AppMethodBeat.m2505o(78646);
            return;
        }
        AppMethodBeat.m2505o(78646);
    }

    /* renamed from: F */
    public final void mo73250F(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78647);
        if (aka()) {
            mo73257a(c7620bi, C18681b.click, 0);
            AppMethodBeat.m2505o(78647);
            return;
        }
        AppMethodBeat.m2505o(78647);
    }

    /* renamed from: G */
    public final void mo73251G(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78648);
        if (aka()) {
            mo73257a(c7620bi, C18681b.voiceToText, 0);
            AppMethodBeat.m2505o(78648);
            return;
        }
        AppMethodBeat.m2505o(78648);
    }

    /* renamed from: a */
    public final void mo73258a(C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(78649);
        if (!aka()) {
            AppMethodBeat.m2505o(78649);
        } else if (c7620bi.isText()) {
            mo73257a(c7620bi, z ? C18681b.translate : C18681b.translateHidden, 0);
            AppMethodBeat.m2505o(78649);
        } else {
            AppMethodBeat.m2505o(78649);
        }
    }

    /* renamed from: H */
    public final void mo73252H(C7620bi c7620bi) {
        AppMethodBeat.m2504i(78650);
        if (aka()) {
            mo73257a(c7620bi, C18681b.imageSaveToLocal, 0);
            AppMethodBeat.m2505o(78650);
            return;
        }
        AppMethodBeat.m2505o(78650);
    }

    /* renamed from: a */
    public final void mo73259a(C7620bi c7620bi, boolean z, int i) {
        AppMethodBeat.m2504i(78651);
        if (aka()) {
            mo73257a(c7620bi, z ? C18681b.playMusic : C18681b.stopMusic, i);
            AppMethodBeat.m2505o(78651);
            return;
        }
        AppMethodBeat.m2505o(78651);
    }

    private String ajZ() {
        AppMethodBeat.m2504i(78652);
        String str;
        if (this.fQZ == null) {
            str = "";
            AppMethodBeat.m2505o(78652);
            return str;
        }
        String str2 = ",";
        LinkedList linkedList = new LinkedList();
        synchronized (this.lock) {
            try {
                linkedList.addAll(this.fQZ.oplist_);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(78652);
            }
        }
        Iterator it = linkedList.iterator();
        int i = 1;
        while (it.hasNext()) {
            StringBuilder append;
            IMBehavior iMBehavior = (IMBehavior) it.next();
            if (i == 0) {
                str2 = str2 + "|";
            }
            str2 = str2 + iMBehavior.opType + "#";
            if (iMBehavior.opType == 1) {
                append = new StringBuilder().append(str2);
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                str = "";
                if (iMBehaviorChattingOP.changeUnread != 0) {
                    str = str + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                }
                if (iMBehaviorChattingOP.changeTop != 0) {
                    str = str + "changeTop=" + iMBehaviorChattingOP.changeTop;
                }
                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                    str = str + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                }
                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                    str = str + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                }
                if (iMBehaviorChattingOP.expose != 0) {
                    str = str + "expose=" + iMBehaviorChattingOP.expose;
                }
            } else {
                append = new StringBuilder().append(str2);
                if (iMBehavior.msgOp.msgType == 49) {
                    str = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.appMsgInnerType), Integer.valueOf(iMBehavior.msgOp.count)});
                } else {
                    str = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.count)});
                }
            }
            str2 = append.append(str).toString();
            i = 0;
        }
        str = str2 + "," + this.fQZ.currChatName_;
        return str;
    }

    public final boolean aka() {
        AppMethodBeat.m2504i(78653);
        akb();
        if (this.fRb == 0 && this.fRc == 0) {
            AppMethodBeat.m2505o(78653);
            return false;
        }
        AppMethodBeat.m2505o(78653);
        return true;
    }

    private void akb() {
        AppMethodBeat.m2504i(78654);
        if (this.hasInit) {
            AppMethodBeat.m2505o(78654);
            return;
        }
        this.hasInit = true;
        if (C1720g.m3531RK()) {
            C5141c ll = C18624c.abi().mo17131ll("100148");
            if (ll.isValid()) {
                this.fRb = C5046bo.getInt((String) ll.dru().get("needUploadData"), 1);
            }
            ll = C18624c.abi().mo17131ll("100149");
            if (ll.isValid()) {
                this.fRc = C5046bo.getInt((String) ll.dru().get("needUploadData"), 1);
            }
            AppMethodBeat.m2505o(78654);
            return;
        }
        C4990ab.m7420w("MicroMsg.ChattingOperationUitl", "account has not ready");
        AppMethodBeat.m2505o(78654);
    }
}
