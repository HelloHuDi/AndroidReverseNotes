package com.tencent.p177mm.p612ui.chatting.p616c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p189aq.C1277a.C12781;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p230g.p231a.C37727hk;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30469p;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b.C3453a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashSet;

@C15590a(dFp = C30469p.class)
/* renamed from: com.tencent.mm.ui.chatting.c.r */
public class C40736r extends C44291a implements C4937b, C30469p {
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {

        /* renamed from: com.tencent.mm.ui.chatting.c.r$3$1 */
        class C53241 implements Runnable {
            C53241() {
            }

            public final void run() {
                AppMethodBeat.m2504i(31442);
                ((C46643s) C40736r.this.cgL.mo74857aF(C46643s.class)).dEA();
                AppMethodBeat.m2505o(31442);
            }
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(31443);
            super.handleMessage(message);
            if (message.what == 1) {
                C23733z c23733z = (C23733z) C40736r.this.cgL.mo74857aF(C23733z.class);
                boolean z = c23733z.dEU() || c23733z.dET();
                C40736r.this.cgL.yTz.setIsBottomShowAll(false);
                C40736r.this.cgL.yTz.setBottomViewVisible(true);
                if (z) {
                    C40736r.this.cgL.yTz.mo56981qd(true);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("load_bottom", true);
                    C40736r.this.cgL.yTz.mo56964aw(bundle);
                }
                C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] load bottom! isFromSearch:%s talker:%s", Boolean.valueOf(z), C40736r.this.cgL.getTalkerUserName());
                AppMethodBeat.m2505o(31443);
            } else if (message.what == 2) {
                C40736r.this.cgL.yTz.setIsBottomShowAll(true);
                C40736r.this.cgL.yTz.setBottomViewVisible(true);
                C40736r.this.mMainHandler.postDelayed(new C53241(), 300);
                C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom! talker:%s", C40736r.this.cgL.getTalkerUserName());
                AppMethodBeat.m2505o(31443);
            } else if (message.what == 4) {
                C40736r.this.cgL.yTz.setIsBottomShowAll(false);
                C40736r.this.cgL.yTz.setBottomViewVisible(true);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("load_bottom", true);
                C40736r.this.cgL.yTz.mo56964aw(bundle2);
                C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] unLoad bottom and reset! talker:%s", C40736r.this.cgL.getTalkerUserName());
                AppMethodBeat.m2505o(31443);
            } else {
                if (message.what == 8) {
                    C4990ab.m7416i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$handleMessage] reset presenter");
                    C40736r.this.cgL.yTx.dBR();
                }
                AppMethodBeat.m2505o(31443);
            }
        }
    };
    private C40738a yPZ;
    private HashSet<String> yQa = new HashSet();
    private volatile C7620bi yQb;
    private C15612h yQc;

    /* renamed from: com.tencent.mm.ui.chatting.c.r$2 */
    class C237612 implements Runnable {
        C237612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31441);
            Bundle bundle = new Bundle();
            bundle.putLong("MSG_ID", C40736r.this.yQb.field_msgId);
            C40736r.this.cgL.yTz.mo56965ax(bundle);
            AppMethodBeat.m2505o(31441);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.r$1 */
    class C407371 implements Runnable {
        C407371() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31440);
            long currentTimeMillis = System.currentTimeMillis();
            C40736r.this.yQb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(C40736r.this.cgL.getTalkerUserName());
            if (C40736r.this.yQb == null) {
                AppMethodBeat.m2505o(31440);
                return;
            }
            C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[onChattingInit] cost:%sms talker:%s createTime:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), C40736r.this.cgL.getTalkerUserName(), Long.valueOf(C40736r.this.yQb.field_createTime));
            AppMethodBeat.m2505o(31440);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.r$a */
    class C40738a implements Runnable {
        String talker;

        /* synthetic */ C40738a(C40736r c40736r, String str, byte b) {
            this(str);
        }

        private C40738a(String str) {
            this.talker = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(31444);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                C9638aw.m17190ZK();
                C7617ak aoZ = C18628c.m29083XR().aoZ(this.talker);
                C6977h bOr = ((C6982j) C1720g.m3528K(C6982j.class)).bOr();
                String str;
                if (aoZ == null || bOr == null) {
                    String str2 = "MicroMsg.GetChatroomComponent";
                    str = "[CheckGetChatroomTask$run] null == conv?%s talker:%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(aoZ == null);
                    objArr[1] = this.talker;
                    C4990ab.m7413e(str2, str, objArr);
                    C40736r.this.mMainHandler.sendEmptyMessage(2);
                    C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(31444);
                    return;
                }
                long j = aoZ.field_lastSeq;
                long j2 = aoZ.field_conversationTime;
                Object obj;
                if (C40736r.this.dEi()) {
                    C7578w QN = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15218QN(C40736r.this.cgL.getTalkerUserName());
                    long j3 = QN.field_lastLocalSeq;
                    long j4 = QN.field_lastPushSeq;
                    C4990ab.m7416i("MicroMsg.GetChatroomComponent", "[isNeedLoadBottom] lastPushSeq:" + j4 + " lastLocalSeq:" + j3);
                    if (j3 != j4) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        C40736r.this.mMainHandler.sendEmptyMessage(1);
                    } else {
                        C40736r.this.mMainHandler.sendEmptyMessage(2);
                    }
                } else if (aoZ.mo16714jl(67108864)) {
                    C4990ab.m7421w("MicroMsg.GetChatroomComponent", "has check! %s", this.talker);
                    C40736r.this.mMainHandler.sendEmptyMessage(2);
                    C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(31444);
                    return;
                } else {
                    aoZ.mo16712jj(67108864);
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15767a(aoZ, this.talker);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    C4990ab.m7417i("MicroMsg.GetChatroomComponent", "seq:%s getLastMsg cost:%sms filter:%s", Long.valueOf(bOr.mo15331fa(this.talker, " and msgSeq != 0 and flag & 2 != 0").field_msgSeq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2), " and msgSeq != 0 and flag & 2 != 0");
                    obj = (bOr.mo15331fa(this.talker, " and msgSeq != 0 and flag & 2 != 0").field_msgId > 0 || aoZ.field_UnDeliverCount > 0) ? 1 : null;
                    if (obj != null) {
                        C7620bi Rc = bOr.mo15249Rc(this.talker);
                        currentTimeMillis2 = C1839cb.aaD() - 259200000;
                        str = C14835h.formatTime("yyyy-MM-dd HH:mm:ss", currentTimeMillis2 / 1000);
                        C7620bi af = bOr.mo15300af(this.talker, currentTimeMillis2);
                        if (af.field_msgId == 0) {
                            C4990ab.m7420w("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] getUpIncReceivedMsg is null!");
                            currentTimeMillis2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(this.talker);
                            long QP = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7907QP(this.talker);
                            af.mo14775eJ(currentTimeMillis2);
                            af.mo14777eL(QP);
                        }
                        String formatTime = C14835h.formatTime("yyyy-MM-dd HH:mm:ss", af.field_createTime / 1000);
                        C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[handleFoundGetChatroom] talker:%s seq:[%s:%s] time:[%s:%s] fromTimeFormat:%s recMsgTimeFormat:%s", this.talker, Long.valueOf(j), Long.valueOf(af.field_msgSeq), Long.valueOf(j2), Long.valueOf(af.field_createTime), str, formatTime);
                        C37727hk c37727hk = new C37727hk();
                        c37727hk.cCg.username = C40736r.this.cgL.getTalkerUserName();
                        c37727hk.cCg.cCj = af.field_msgSeq;
                        c37727hk.cCg.cCk = af.field_createTime;
                        c37727hk.cCg.cCh = j;
                        c37727hk.cCg.cCi = j2;
                        C4879a.xxA.mo10055m(c37727hk);
                        C40736r.this.mMainHandler.sendEmptyMessage(8);
                        if (Rc == null || Rc.field_msgSeq == j) {
                            C40736r.this.mMainHandler.sendEmptyMessage(4);
                        } else {
                            C40736r.this.mMainHandler.sendEmptyMessage(1);
                        }
                        C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] found get chatroom![%s]", this.talker);
                    } else {
                        C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] not found get chatroom![%s]", this.talker);
                        C40736r.this.mMainHandler.sendEmptyMessage(2);
                    }
                }
                C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(31444);
            } catch (Throwable th) {
                C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[CheckGetChatroomTask$run] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(31444);
            }
        }
    }

    public C40736r() {
        AppMethodBeat.m2504i(31445);
        AppMethodBeat.m2505o(31445);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31446);
        super.dxx();
        if (this.cgL.dFx()) {
            C1720g.m3539RS().mo10302aa(new C407371());
            AppMethodBeat.m2505o(31446);
            return;
        }
        AppMethodBeat.m2505o(31446);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31447);
        super.dxy();
        if (this.cgL.dFx()) {
            long currentTimeMillis = System.currentTimeMillis();
            ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo10119a(this, C1720g.m3539RS().oAl.getLooper());
            this.yPZ = new C40738a(this, this.cgL.getTalkerUserName(), (byte) 0);
            C7305d.m12299g(this.yPZ, "[GetChatroomComponent]");
            C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[onChattingEnterAnimStart] cost:%sms talker:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31447);
            return;
        }
        AppMethodBeat.m2505o(31447);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31448);
        super.dxC();
        if (this.cgL.dFx()) {
            C7305d.xDG.remove(this.yPZ);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo10121b(this);
            if (!this.yQa.contains(this.cgL.getTalkerUserName())) {
                C7305d.post(new C12781(this.cgL.getTalkerUserName()), "checkDirtyBlock");
                this.yQa.add(this.cgL.getTalkerUserName());
            }
            AppMethodBeat.m2505o(31448);
            return;
        }
        AppMethodBeat.m2505o(31448);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31449);
        super.dDh();
        ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo10121b(this);
        AppMethodBeat.m2505o(31449);
    }

    public final boolean dEi() {
        AppMethodBeat.m2504i(31450);
        boolean QL = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15216QL(this.cgL.getTalkerUserName());
        AppMethodBeat.m2505o(31450);
        return QL;
    }

    public final void dEj() {
        boolean z = false;
        AppMethodBeat.m2504i(31451);
        if (this.yQb == null) {
            C4990ab.m7413e("MicroMsg.GetChatroomComponent", "[goBackToHistory] null == mLastSeqMsg! talker:%s", this.cgL.getTalkerUserName());
            AppMethodBeat.m2505o(31451);
            return;
        }
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        C6594c f = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15225f(this.cgL.getTalkerUserName(), this.yQb.field_createTime, false);
        String str = "MicroMsg.GetChatroomComponent";
        String str2 = "[goBackToHistory] msgInfo content:%s null == seqBlock?:%s time:%s";
        Object[] objArr = new Object[3];
        objArr[0] = C5046bo.anv(this.yQb.field_content);
        if (f == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Long.valueOf(this.yQb.field_createTime);
        C4990ab.m7417i(str, str2, objArr);
        if (f == null) {
            if (this.yQc == null) {
                this.yQc = (C15612h) this.cgL.mo74857aF(C15612h.class);
            }
            int dEy = ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEy();
            if (this.yQc.getCount() >= dEy) {
                C7620bi Ou = this.yQc.mo27798Ou(this.yQc.getCount() - 1);
                if (Ou != null) {
                    long f2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15330f(this.cgL.getTalkerUserName(), Ou.field_createTime, dEy);
                    for (int count = this.yQc.getCount() - 1; count >= 0; count--) {
                        C7620bi Ou2 = this.yQc.mo27798Ou(count);
                        if (Ou2 != null && Ou2.field_createTime == f2) {
                            dEy = count;
                            break;
                        }
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.GetChatroomComponent", "[findPosition] msg is null");
                }
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("MSG_POSITION_UNREAD_COUNT", dEy);
                this.cgL.yTx.dBQ().mo31088a(C40749a.ACTION_POSITION, true, bundle);
            }
            dEy = 0;
            C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[goBackToHistory] findPosition:%s", Integer.valueOf(dEy));
            this.cgL.mo74861bY(dEy);
            ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27799Ov(dEy);
        } else {
            this.cgL.mo74861bY(0);
            this.cgL.getListView().postDelayed(new C237612(), 166);
        }
        ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEz();
        String str3 = "MicroMsg.GetChatroomComponent";
        str = "[goBackToHistory] cost:%s null == seqBlock?:%s";
        Object[] objArr2 = new Object[2];
        objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        if (f == null) {
            z = true;
        }
        objArr2[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str3, str, objArr2);
        AppMethodBeat.m2505o(31451);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(31452);
        C3453a c3453a = (C3453a) obj;
        String str = c3453a.username;
        boolean z = c3453a.oqE;
        if (str.equals(this.cgL.getTalkerUserName())) {
            C4990ab.m7417i("MicroMsg.GetChatroomComponent", "[onNotifyChange] talker:%s id:%s isInsertForWrap:%s", this.cgL.getTalkerUserName(), Integer.valueOf(c3453a.f1271id), Boolean.valueOf(c3453a.oqE));
            if (i == 4 && !z) {
                C4990ab.m7416i("MicroMsg.GetChatroomComponent", "[onNotifyChange] resetDataPresenter! username:".concat(String.valueOf(str)));
                this.mMainHandler.sendEmptyMessage(8);
            }
            if (!z && (i == 2 || i == 4)) {
                C7578w QN = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15218QN(this.cgL.getTalkerUserName());
                C6320b.agG().mo14566a(this.cgL.getTalkerUserName(), QN.field_lastLocalSeq + 1, QN.field_lastPushSeq, 0, null);
            }
            AppMethodBeat.m2505o(31452);
            return;
        }
        AppMethodBeat.m2505o(31452);
    }
}
