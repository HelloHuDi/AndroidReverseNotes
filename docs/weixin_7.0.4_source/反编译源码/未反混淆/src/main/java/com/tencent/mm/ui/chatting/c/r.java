package com.tencent.mm.ui.chatting.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.p;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.c.b.z;
import java.util.HashSet;

@com.tencent.mm.ui.chatting.c.a.a(dFp = p.class)
public class r extends a implements b, p {
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(31443);
            super.handleMessage(message);
            if (message.what == 1) {
                z zVar = (z) r.this.cgL.aF(z.class);
                boolean z = zVar.dEU() || zVar.dET();
                r.this.cgL.yTz.setIsBottomShowAll(false);
                r.this.cgL.yTz.setBottomViewVisible(true);
                if (z) {
                    r.this.cgL.yTz.qd(true);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("load_bottom", true);
                    r.this.cgL.yTz.aw(bundle);
                }
                ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", Boolean.valueOf(z), r.this.cgL.getTalkerUserName());
                AppMethodBeat.o(31443);
            } else if (message.what == 2) {
                r.this.cgL.yTz.setIsBottomShowAll(true);
                r.this.cgL.yTz.setBottomViewVisible(true);
                r.this.mMainHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(31442);
                        ((s) r.this.cgL.aF(s.class)).dEA();
                        AppMethodBeat.o(31442);
                    }
                }, 300);
                ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", r.this.cgL.getTalkerUserName());
                AppMethodBeat.o(31443);
            } else if (message.what == 4) {
                r.this.cgL.yTz.setIsBottomShowAll(false);
                r.this.cgL.yTz.setBottomViewVisible(true);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("load_bottom", true);
                r.this.cgL.yTz.aw(bundle2);
                ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", r.this.cgL.getTalkerUserName());
                AppMethodBeat.o(31443);
            } else {
                if (message.what == 8) {
                    ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
                    r.this.cgL.yTx.dBR();
                }
                AppMethodBeat.o(31443);
            }
        }
    };
    private a yPZ;
    private HashSet<String> yQa = new HashSet();
    private volatile bi yQb;
    private h yQc;

    class a implements Runnable {
        String talker;

        /* synthetic */ a(r rVar, String str, byte b) {
            this(str);
        }

        private a(String str) {
            this.talker = str;
        }

        public final void run() {
            AppMethodBeat.i(31444);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                aw.ZK();
                ak aoZ = c.XR().aoZ(this.talker);
                com.tencent.mm.plugin.messenger.foundation.a.a.h bOr = ((j) g.K(j.class)).bOr();
                String str;
                if (aoZ == null || bOr == null) {
                    String str2 = "MicroMsg.GetChatroomComponent";
                    str = "[CheckGetChatroomTask$run] null == conv?%s talker:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(aoZ == null);
                    objArr[1] = this.talker;
                    ab.e(str2, str, objArr);
                    r.this.mMainHandler.sendEmptyMessage(2);
                    ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(31444);
                    return;
                }
                long j = aoZ.field_lastSeq;
                long j2 = aoZ.field_conversationTime;
                Object obj;
                if (r.this.dEi()) {
                    w QN = ((j) g.K(j.class)).bOm().QN(r.this.cgL.getTalkerUserName());
                    long j3 = QN.field_lastLocalSeq;
                    long j4 = QN.field_lastPushSeq;
                    ab.i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + j4 + " lastLocalSeq:" + j3);
                    if (j3 != j4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        r.this.mMainHandler.sendEmptyMessage(1);
                    } else {
                        r.this.mMainHandler.sendEmptyMessage(2);
                    }
                } else if (aoZ.jl(67108864)) {
                    ab.w("MicroMsg.GetChatroomComponent", "has check! %s", this.talker);
                    r.this.mMainHandler.sendEmptyMessage(2);
                    ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(31444);
                    return;
                } else {
                    aoZ.jj(67108864);
                    aw.ZK();
                    c.XR().a(aoZ, this.talker);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ab.i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", Long.valueOf(bOr.fa(this.talker, " and msgSeq != 0 and flag & 2 != 0").field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), " and msgSeq != 0 and flag & 2 != 0");
                    obj = (bOr.fa(this.talker, " and msgSeq != 0 and flag & 2 != 0").field_msgId > 0 || aoZ.field_UnDeliverCount > 0) ? 1 : null;
                    if (obj != null) {
                        bi Rc = bOr.Rc(this.talker);
                        currentTimeMillis2 = cb.aaD() - 259200000;
                        str = com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", currentTimeMillis2 / 1000);
                        bi af = bOr.af(this.talker, currentTimeMillis2);
                        if (af.field_msgId == 0) {
                            ab.w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
                            currentTimeMillis2 = ((j) g.K(j.class)).Yo().QQ(this.talker);
                            long QP = ((j) g.K(j.class)).Yo().QP(this.talker);
                            af.eJ(currentTimeMillis2);
                            af.eL(QP);
                        }
                        String formatTime = com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", af.field_createTime / 1000);
                        ab.i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", this.talker, Long.valueOf(j), Long.valueOf(af.field_msgSeq), Long.valueOf(j2), Long.valueOf(af.field_createTime), str, formatTime);
                        hk hkVar = new hk();
                        hkVar.cCg.username = r.this.cgL.getTalkerUserName();
                        hkVar.cCg.cCj = af.field_msgSeq;
                        hkVar.cCg.cCk = af.field_createTime;
                        hkVar.cCg.cCh = j;
                        hkVar.cCg.cCi = j2;
                        com.tencent.mm.sdk.b.a.xxA.m(hkVar);
                        r.this.mMainHandler.sendEmptyMessage(8);
                        if (Rc == null || Rc.field_msgSeq == j) {
                            r.this.mMainHandler.sendEmptyMessage(4);
                        } else {
                            r.this.mMainHandler.sendEmptyMessage(1);
                        }
                        ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", this.talker);
                    } else {
                        ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", this.talker);
                        r.this.mMainHandler.sendEmptyMessage(2);
                    }
                }
                ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(31444);
            } catch (Throwable th) {
                ab.i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(31444);
            }
        }
    }

    public r() {
        AppMethodBeat.i(31445);
        AppMethodBeat.o(31445);
    }

    public final void dxx() {
        AppMethodBeat.i(31446);
        super.dxx();
        if (this.cgL.dFx()) {
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31440);
                    long currentTimeMillis = System.currentTimeMillis();
                    r.this.yQb = ((j) g.K(j.class)).bOr().Rb(r.this.cgL.getTalkerUserName());
                    if (r.this.yQb == null) {
                        AppMethodBeat.o(31440);
                        return;
                    }
                    ab.i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r.this.cgL.getTalkerUserName(), Long.valueOf(r.this.yQb.field_createTime));
                    AppMethodBeat.o(31440);
                }
            });
            AppMethodBeat.o(31446);
            return;
        }
        AppMethodBeat.o(31446);
    }

    public final void dxy() {
        AppMethodBeat.i(31447);
        super.dxy();
        if (this.cgL.dFx()) {
            long currentTimeMillis = System.currentTimeMillis();
            ((j) g.K(j.class)).bOm().a(this, g.RS().oAl.getLooper());
            this.yPZ = new a(this, this.cgL.getTalkerUserName(), (byte) 0);
            d.g(this.yPZ, "[GetChatroomComponent]");
            ab.i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.cgL.getTalkerUserName());
            AppMethodBeat.o(31447);
            return;
        }
        AppMethodBeat.o(31447);
    }

    public final void dxC() {
        AppMethodBeat.i(31448);
        super.dxC();
        if (this.cgL.dFx()) {
            d.xDG.remove(this.yPZ);
            ((j) g.K(j.class)).bOm().b(this);
            if (!this.yQa.contains(this.cgL.getTalkerUserName())) {
                d.post(new com.tencent.mm.aq.a.AnonymousClass1(this.cgL.getTalkerUserName()), "checkDirtyBlock");
                this.yQa.add(this.cgL.getTalkerUserName());
            }
            AppMethodBeat.o(31448);
            return;
        }
        AppMethodBeat.o(31448);
    }

    public final void dDh() {
        AppMethodBeat.i(31449);
        super.dDh();
        ((j) g.K(j.class)).bOm().b(this);
        AppMethodBeat.o(31449);
    }

    public final boolean dEi() {
        AppMethodBeat.i(31450);
        boolean QL = ((j) g.K(j.class)).bOm().QL(this.cgL.getTalkerUserName());
        AppMethodBeat.o(31450);
        return QL;
    }

    public final void dEj() {
        boolean z = false;
        AppMethodBeat.i(31451);
        if (this.yQb == null) {
            ab.e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", this.cgL.getTalkerUserName());
            AppMethodBeat.o(31451);
            return;
        }
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.j.a.a.c f = ((j) g.K(j.class)).bOm().f(this.cgL.getTalkerUserName(), this.yQb.field_createTime, false);
        String str = "MicroMsg.GetChatroomComponent";
        String str2 = "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s";
        Object[] objArr = new Object[3];
        objArr[0] = bo.anv(this.yQb.field_content);
        if (f == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Long.valueOf(this.yQb.field_createTime);
        ab.i(str, str2, objArr);
        if (f == null) {
            if (this.yQc == null) {
                this.yQc = (h) this.cgL.aF(h.class);
            }
            int dEy = ((s) this.cgL.aF(s.class)).dEy();
            if (this.yQc.getCount() >= dEy) {
                bi Ou = this.yQc.Ou(this.yQc.getCount() - 1);
                if (Ou != null) {
                    long f2 = ((j) g.K(j.class)).bOr().f(this.cgL.getTalkerUserName(), Ou.field_createTime, dEy);
                    for (int count = this.yQc.getCount() - 1; count >= 0; count--) {
                        bi Ou2 = this.yQc.Ou(count);
                        if (Ou2 != null && Ou2.field_createTime == f2) {
                            dEy = count;
                            break;
                        }
                    }
                } else {
                    ab.w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("MSG_POSITION_UNREAD_COUNT", dEy);
                this.cgL.yTx.dBQ().a(com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION, true, bundle);
            }
            dEy = 0;
            ab.i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", Integer.valueOf(dEy));
            this.cgL.bY(dEy);
            ((h) this.cgL.aF(h.class)).Ov(dEy);
        } else {
            this.cgL.bY(0);
            this.cgL.getListView().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31441);
                    Bundle bundle = new Bundle();
                    bundle.putLong("MSG_ID", r.this.yQb.field_msgId);
                    r.this.cgL.yTz.ax(bundle);
                    AppMethodBeat.o(31441);
                }
            }, 166);
        }
        ((s) this.cgL.aF(s.class)).dEz();
        String str3 = "MicroMsg.GetChatroomComponent";
        str = "[goBackToHistory] cost:%s null == seqBlock?:%s";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        if (f == null) {
            z = true;
        }
        objArr2[1] = Boolean.valueOf(z);
        ab.i(str3, str, objArr2);
        AppMethodBeat.o(31451);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(31452);
        com.tencent.mm.plugin.messenger.foundation.a.a.b.a aVar = (com.tencent.mm.plugin.messenger.foundation.a.a.b.a) obj;
        String str = aVar.username;
        boolean z = aVar.oqE;
        if (str.equals(this.cgL.getTalkerUserName())) {
            ab.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", this.cgL.getTalkerUserName(), Integer.valueOf(aVar.id), Boolean.valueOf(aVar.oqE));
            if (i == 4 && !z) {
                ab.i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(str)));
                this.mMainHandler.sendEmptyMessage(8);
            }
            if (!z && (i == 2 || i == 4)) {
                w QN = ((j) g.K(j.class)).bOm().QN(this.cgL.getTalkerUserName());
                com.tencent.mm.aq.b.agG().a(this.cgL.getTalkerUserName(), QN.field_lastLocalSeq + 1, QN.field_lastPushSeq, 0, null);
            }
            AppMethodBeat.o(31452);
            return;
        }
        AppMethodBeat.o(31452);
    }
}
