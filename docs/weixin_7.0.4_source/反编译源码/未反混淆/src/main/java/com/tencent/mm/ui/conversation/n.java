package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.a;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.LauncherUI;

public final class n implements a {
    Activity czX;
    IdleHandler jQs;
    c kTz = null;
    Runnable zky = new Runnable() {
        public final void run() {
            AppMethodBeat.i(34607);
            n nVar = n.this;
            LauncherUI launcherUI = (LauncherUI) nVar.czX;
            if (launcherUI == null || launcherUI.yjJ.getMainTabUI().mbt == 0) {
                ConversationListView conversationListView = nVar.zuW;
                if (conversationListView.getFirstVisiblePosition() > conversationListView.getFirstHeaderVisible() + 16) {
                    conversationListView.setSelection(conversationListView.getFirstHeaderVisible() + 16);
                }
                conversationListView.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34212);
                        ConversationListView.this.smoothScrollToPositionFromTop(0, 0, 300);
                        AppMethodBeat.o(34212);
                    }
                });
            }
            AppMethodBeat.o(34607);
        }
    };
    h zrd;
    ConversationListView zuW;
    c zvA = null;
    c zvz = null;

    /* renamed from: com.tencent.mm.ui.conversation.n$5 */
    class AnonymousClass5 extends c<jq> {
        final /* synthetic */ ConversationListView zvE;

        AnonymousClass5(ConversationListView conversationListView) {
            this.zvE = conversationListView;
            AppMethodBeat.i(34598);
            this.xxI = jq.class.getName().hashCode();
            AppMethodBeat.o(34598);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34599);
            if (this.zvE != null) {
                this.zvE.setSelection(0);
            }
            AppMethodBeat.o(34599);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.n$3 */
    class AnonymousClass3 extends c<nf> {
        final /* synthetic */ ak zvC;

        AnonymousClass3(ak akVar) {
            this.zvC = akVar;
            AppMethodBeat.i(34593);
            this.xxI = nf.class.getName().hashCode();
            AppMethodBeat.o(34593);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34594);
            this.zvC.sendEmptyMessage(0);
            AppMethodBeat.o(34594);
            return false;
        }
    }

    public n() {
        AppMethodBeat.i(34608);
        AppMethodBeat.o(34608);
    }

    public final void k(String str, String str2, String str3) {
        AppMethodBeat.i(34609);
        if (this.zrd != null) {
            this.zrd.notifyDataSetChanged();
        }
        AppMethodBeat.o(34609);
    }
}
