package com.tencent.p177mm.p612ui.conversation;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p203bg.C32335a;
import com.tencent.p177mm.p230g.p231a.C32508a;
import com.tencent.p177mm.p230g.p231a.C32561go;
import com.tencent.p177mm.p230g.p231a.C37757lh;
import com.tencent.p177mm.p230g.p231a.C37767nf;
import com.tencent.p177mm.p230g.p231a.C37779ot;
import com.tencent.p177mm.p230g.p231a.C42016jq;
import com.tencent.p177mm.p230g.p231a.C42033nw;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.conversation.ConversationListView.C368813;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.friend.p272a.C9877al;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.conversation.n */
public final class C46684n implements C32335a {
    Activity czX;
    IdleHandler jQs;
    C4884c kTz = null;
    Runnable zky = new C3069810();
    C23987h zrd;
    ConversationListView zuW;
    C4884c zvA = null;
    C4884c zvz = null;

    /* renamed from: com.tencent.mm.ui.conversation.n$4 */
    class C239984 extends C4884c<C42033nw> {

        /* renamed from: com.tencent.mm.ui.conversation.n$4$1 */
        class C239971 implements Runnable {
            C239971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34595);
                C4990ab.m7410d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
                if (C46684n.this.zrd != null) {
                    C46684n.this.zrd.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(34595);
            }
        }

        C239984() {
            AppMethodBeat.m2504i(34596);
            this.xxI = C42033nw.class.getName().hashCode();
            AppMethodBeat.m2505o(34596);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34597);
            if (C46684n.this.zrd != null) {
                C5004al.m7441d(new C239971());
            }
            AppMethodBeat.m2505o(34597);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$5 */
    class C239995 extends C4884c<C42016jq> {
        final /* synthetic */ ConversationListView zvE;

        C239995(ConversationListView conversationListView) {
            this.zvE = conversationListView;
            AppMethodBeat.m2504i(34598);
            this.xxI = C42016jq.class.getName().hashCode();
            AppMethodBeat.m2505o(34598);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34599);
            if (this.zvE != null) {
                this.zvE.setSelection(0);
            }
            AppMethodBeat.m2505o(34599);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$6 */
    class C240006 implements IdleHandler {
        C240006() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(34600);
            C4990ab.m7410d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
            if (C9638aw.m17179RK() && C38033l.apS() == C38034a.SUCC && !C38033l.apR()) {
                C9638aw.m17182Rg().mo14541a(new C9877al(C38033l.aqb(), C38033l.aqa()), 0);
            }
            Looper.myQueue().removeIdleHandler(C46684n.this.jQs);
            AppMethodBeat.m2505o(34600);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$10 */
    class C3069810 implements Runnable {
        C3069810() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34607);
            C46684n c46684n = C46684n.this;
            LauncherUI launcherUI = (LauncherUI) c46684n.czX;
            if (launcherUI == null || launcherUI.yjJ.getMainTabUI().mbt == 0) {
                ConversationListView conversationListView = c46684n.zuW;
                if (conversationListView.getFirstVisiblePosition() > conversationListView.getFirstHeaderVisible() + 16) {
                    conversationListView.setSelection(conversationListView.getFirstHeaderVisible() + 16);
                }
                conversationListView.post(new C368813());
            }
            AppMethodBeat.m2505o(34607);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$7 */
    class C306997 implements Runnable {

        /* renamed from: com.tencent.mm.ui.conversation.n$7$1 */
        class C307001 implements Runnable {
            C307001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34601);
                C4990ab.m7416i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
                C4879a.xxA.mo10055m(new C32508a());
                AppMethodBeat.m2505o(34601);
            }
        }

        C306997() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34602);
            if (!C4996ah.dox()) {
                C4996ah.m7432ph(true);
                C5004al.m7442n(new C307001(), 100);
            }
            C34830g.m57195BO(8);
            AppMethodBeat.m2505o(34602);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$1 */
    class C443671 extends C7306ak {
        C443671() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34591);
            if (C46684n.this.zrd != null) {
                C46684n.this.zrd.clearCache();
                C46684n.this.zrd.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(34591);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$3 */
    class C443683 extends C4884c<C37767nf> {
        final /* synthetic */ C7306ak zvC;

        C443683(C7306ak c7306ak) {
            this.zvC = c7306ak;
            AppMethodBeat.m2504i(34593);
            this.xxI = C37767nf.class.getName().hashCode();
            AppMethodBeat.m2505o(34593);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34594);
            this.zvC.sendEmptyMessage(0);
            AppMethodBeat.m2505o(34594);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$8 */
    class C443698 implements Runnable {
        C443698() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34603);
            C32561go c32561go = new C32561go();
            c32561go.cBl.data = "MAIN_UI_EVENT_UPDATE_VIEW";
            C4879a.xxA.mo10055m(c32561go);
            AppMethodBeat.m2505o(34603);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$9 */
    class C443709 implements Runnable {

        /* renamed from: com.tencent.mm.ui.conversation.n$9$1 */
        class C158771 implements OnClickListener {
            C158771() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34604);
                C4879a.xxA.mo10055m(new C37779ot());
                AppMethodBeat.m2505o(34604);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.n$9$2 */
        class C307012 implements OnClickListener {
            C307012() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34605);
                C4879a.xxA.mo10055m(new C37757lh());
                AppMethodBeat.m2505o(34605);
            }
        }

        C443709() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34606);
            C30379h.m48466d(C46684n.this.czX, C46684n.this.czX.getString(C25738R.string.d9p), "", C46684n.this.czX.getString(C25738R.string.d9q), C46684n.this.czX.getString(C25738R.string.f9076or), new C158771(), new C307012());
            AppMethodBeat.m2505o(34606);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$2 */
    class C466832 implements Runnable {
        C466832() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34592);
            if (!C46684n.this.czX.isFinishing()) {
                C46684n.this.zuW.setSelection(0);
            }
            AppMethodBeat.m2505o(34592);
        }
    }

    public C46684n() {
        AppMethodBeat.m2504i(34608);
        AppMethodBeat.m2505o(34608);
    }

    /* renamed from: k */
    public final void mo14628k(String str, String str2, String str3) {
        AppMethodBeat.m2504i(34609);
        if (this.zrd != null) {
            this.zrd.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(34609);
    }
}
