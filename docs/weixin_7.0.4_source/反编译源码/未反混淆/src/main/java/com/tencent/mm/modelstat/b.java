package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class b {
    public static b fRa = new b();
    private c ecP = new c<qe>() {
        {
            AppMethodBeat.i(78623);
            this.xxI = qe.class.getName().hashCode();
            AppMethodBeat.o(78623);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(78624);
            qe qeVar = (qe) bVar;
            if (qeVar instanceof qe) {
                b.this.j(qeVar.cMu.csG);
            }
            AppMethodBeat.o(78624);
            return false;
        }
    };
    public log_13835 fQZ;
    private int fRb = 1;
    private int fRc = 1;
    private boolean hasInit = false;
    public Object lock = new Object();

    public enum a {
        OP_Chatting(1),
        OP_Msg(2);
        
        public int value;

        static {
            AppMethodBeat.o(78629);
        }

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
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
            AppMethodBeat.o(78632);
        }

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    static {
        AppMethodBeat.i(78656);
        AppMethodBeat.o(78656);
    }

    private b() {
        AppMethodBeat.i(78633);
        com.tencent.mm.sdk.b.a.xxA.b(this.ecP);
        AppMethodBeat.o(78633);
    }

    public final boolean cM(String str) {
        AppMethodBeat.i(78634);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.ChattingOperationUitl", "check error:%s", bo.dpG().toString());
            log_13913 log_13913 = new log_13913();
            log_13913.scene_ = 1;
            log_13913.error_ = r2;
            h.pYm.c(13913, log_13913);
            AppMethodBeat.o(78634);
            return false;
        }
        if (!(this.fQZ == null || this.fQZ.currChatName_ == null || this.fQZ.currChatName_.equals(str))) {
            IF();
        }
        if (this.fQZ == null) {
            this.fQZ = new log_13835();
            this.fQZ.currChatName_ = str;
        }
        AppMethodBeat.o(78634);
        return true;
    }

    public final void IF() {
        AppMethodBeat.i(78635);
        if (aka()) {
            int i;
            synchronized (this.lock) {
                try {
                    i = (this.fQZ == null || this.fQZ.oplist_.isEmpty()) ? 0 : 1;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78635);
                    }
                }
            }
            if (i != 0) {
                if (this.fRc != 0) {
                    ab.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    h.pYm.c(13835, this.fQZ);
                }
                if (this.fRb != 0) {
                    ab.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", ajZ());
                    h.pYm.X(13748, r0);
                }
            }
            this.fQZ = null;
            AppMethodBeat.o(78635);
            return;
        }
        AppMethodBeat.o(78635);
    }

    public final void Q(String str, boolean z) {
        int i = 1;
        AppMethodBeat.i(78636);
        if (aka()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            IF();
            if (cM(str)) {
                synchronized (this.lock) {
                    try {
                        this.fQZ.oplist_.add(iMBehavior);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(78636);
                    }
                }
                IF();
                return;
            }
            AppMethodBeat.o(78636);
            return;
        }
        AppMethodBeat.o(78636);
    }

    public final void c(boolean z, String str, boolean z2) {
        int i = 1;
        AppMethodBeat.i(78637);
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
                IF();
            }
            if (cM(str)) {
                synchronized (this.lock) {
                    try {
                        this.fQZ.oplist_.add(iMBehavior);
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(78637);
                        }
                    }
                }
                if (z) {
                    IF();
                }
                AppMethodBeat.o(78637);
                return;
            }
            AppMethodBeat.o(78637);
            return;
        }
        AppMethodBeat.o(78637);
    }

    public final void R(String str, boolean z) {
        int i = 1;
        AppMethodBeat.i(78638);
        if (!aka()) {
            AppMethodBeat.o(78638);
        } else if (cM(str)) {
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
                    AppMethodBeat.o(78638);
                }
            }
        } else {
            AppMethodBeat.o(78638);
        }
    }

    private void a(IMBehavior iMBehavior) {
        AppMethodBeat.i(78639);
        synchronized (this.lock) {
            try {
                if (iMBehavior.opType == a.OP_Chatting.value) {
                    this.fQZ.oplist_.add(iMBehavior);
                } else {
                    Iterator it = this.fQZ.oplist_.iterator();
                    while (it.hasNext()) {
                        IMBehavior iMBehavior2 = (IMBehavior) it.next();
                        if (iMBehavior2.opType == a.OP_Msg.value) {
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
                                AppMethodBeat.o(78639);
                                return;
                            }
                        }
                    }
                    this.fQZ.oplist_.add(iMBehavior);
                    AppMethodBeat.o(78639);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(78639);
            }
        }
    }

    public final void a(bi biVar, b bVar, int i) {
        AppMethodBeat.i(78640);
        if (biVar == null || !cM(biVar.field_talker)) {
            AppMethodBeat.o(78640);
            return;
        }
        IMBehavior iMBehavior = new IMBehavior();
        iMBehavior.opType = 2;
        iMBehavior.msgOp = new IMBehaviorMsgOP();
        iMBehavior.msgOp.msgType = biVar.getType() & CdnLogic.kBizGeneric;
        if (biVar.bAA()) {
            iMBehavior.msgOp.appMsgInnerType = i;
        }
        iMBehavior.msgOp.msgOpType = bVar.value;
        iMBehavior.msgOp.count = 1;
        a(iMBehavior);
        AppMethodBeat.o(78640);
    }

    public final void a(final bi biVar, final int i) {
        AppMethodBeat.i(78641);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78625);
                b.a(b.this, biVar, i);
                AppMethodBeat.o(78625);
            }
        });
        AppMethodBeat.o(78641);
    }

    public final void j(final bi biVar) {
        AppMethodBeat.i(78642);
        new ak(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(78626);
                b.a(b.this, biVar, 0);
                AppMethodBeat.o(78626);
            }
        });
        AppMethodBeat.o(78642);
    }

    public final void b(bi biVar, int i) {
        AppMethodBeat.i(78643);
        if (aka()) {
            a(biVar, b.fav, i);
            AppMethodBeat.o(78643);
            return;
        }
        AppMethodBeat.o(78643);
    }

    public final void D(bi biVar) {
        AppMethodBeat.i(78644);
        if (aka()) {
            a(biVar, b.fav, 0);
            AppMethodBeat.o(78644);
            return;
        }
        AppMethodBeat.o(78644);
    }

    public final void c(bi biVar, int i) {
        AppMethodBeat.i(78645);
        if (aka()) {
            a(biVar, b.delete, i);
            AppMethodBeat.o(78645);
            return;
        }
        AppMethodBeat.o(78645);
    }

    public final void E(bi biVar) {
        AppMethodBeat.i(78646);
        if (aka()) {
            a(biVar, b.delete, 0);
            AppMethodBeat.o(78646);
            return;
        }
        AppMethodBeat.o(78646);
    }

    public final void F(bi biVar) {
        AppMethodBeat.i(78647);
        if (aka()) {
            a(biVar, b.click, 0);
            AppMethodBeat.o(78647);
            return;
        }
        AppMethodBeat.o(78647);
    }

    public final void G(bi biVar) {
        AppMethodBeat.i(78648);
        if (aka()) {
            a(biVar, b.voiceToText, 0);
            AppMethodBeat.o(78648);
            return;
        }
        AppMethodBeat.o(78648);
    }

    public final void a(bi biVar, boolean z) {
        AppMethodBeat.i(78649);
        if (!aka()) {
            AppMethodBeat.o(78649);
        } else if (biVar.isText()) {
            a(biVar, z ? b.translate : b.translateHidden, 0);
            AppMethodBeat.o(78649);
        } else {
            AppMethodBeat.o(78649);
        }
    }

    public final void H(bi biVar) {
        AppMethodBeat.i(78650);
        if (aka()) {
            a(biVar, b.imageSaveToLocal, 0);
            AppMethodBeat.o(78650);
            return;
        }
        AppMethodBeat.o(78650);
    }

    public final void a(bi biVar, boolean z, int i) {
        AppMethodBeat.i(78651);
        if (aka()) {
            a(biVar, z ? b.playMusic : b.stopMusic, i);
            AppMethodBeat.o(78651);
            return;
        }
        AppMethodBeat.o(78651);
    }

    private String ajZ() {
        AppMethodBeat.i(78652);
        String str;
        if (this.fQZ == null) {
            str = "";
            AppMethodBeat.o(78652);
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
                AppMethodBeat.o(78652);
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
        AppMethodBeat.i(78653);
        akb();
        if (this.fRb == 0 && this.fRc == 0) {
            AppMethodBeat.o(78653);
            return false;
        }
        AppMethodBeat.o(78653);
        return true;
    }

    private void akb() {
        AppMethodBeat.i(78654);
        if (this.hasInit) {
            AppMethodBeat.o(78654);
            return;
        }
        this.hasInit = true;
        if (g.RK()) {
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100148");
            if (ll.isValid()) {
                this.fRb = bo.getInt((String) ll.dru().get("needUploadData"), 1);
            }
            ll = com.tencent.mm.model.c.c.abi().ll("100149");
            if (ll.isValid()) {
                this.fRc = bo.getInt((String) ll.dru().get("needUploadData"), 1);
            }
            AppMethodBeat.o(78654);
            return;
        }
        ab.w("MicroMsg.ChattingOperationUitl", "account has not ready");
        AppMethodBeat.o(78654);
    }
}
