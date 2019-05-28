package com.tencent.p177mm.p612ui.chatting.p622l.p623a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40751c;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p617f.C5336b.C5337a;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.ui.chatting.l.a.a */
public abstract class C17017a implements C5337a {
    C46650a cgL;
    long yZQ;
    long yZR;
    public C40748d zae;
    int zaf;
    int zag;
    long zah;
    long zai;
    int zaj = 3;

    /* renamed from: a */
    public abstract C30549e mo31087a(C40749a c40749a, Bundle bundle, C40752d c40752d);

    public C17017a(C46650a c46650a, C40748d c40748d) {
        this.cgL = c46650a;
        this.zae = c40748d;
    }

    /* renamed from: a */
    public void mo31088a(final C40749a c40749a, boolean z, final Bundle bundle) {
        Log.m81049i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] action:" + c40749a + " isBlock:" + z + " username:" + this.cgL.getTalkerUserName());
        if (C5046bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            Log.m81051w("MicroMsg.ChattingLoader.AbstractDataPresenter", "[onLoad] username is null!");
            return;
        }
        C34830g.m57194BN(13);
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).dCU();
        this.zae.mo57055a(c40749a, z, new C40751c<C7620bi>() {
            /* renamed from: b */
            public final C30549e mo31090b(C40752d<C7620bi> c40752d) {
                AppMethodBeat.m2504i(32713);
                c40752d.yYz = bundle;
                C30549e a = C17017a.this.mo31087a(c40749a, bundle, (C40752d) c40752d);
                AppMethodBeat.m2505o(32713);
                return a;
            }

            /* renamed from: c */
            public final void mo31091c(C40752d<C7620bi> c40752d) {
                AppMethodBeat.m2504i(32714);
                C17017a.this.zaf = c40752d.enb;
                C17017a.this.zag = c40752d.yYC;
                if (c40752d.yYB.size() > 0) {
                    C7620bi c7620bi = (C7620bi) c40752d.yYB.get(0);
                    if (c7620bi != null) {
                        C17017a.this.yZQ = c7620bi.field_createTime;
                        C17017a.this.zai = c7620bi.field_msgSeq;
                    }
                    c7620bi = (C7620bi) c40752d.yYB.get(c40752d.yYB.size() - 1);
                    if (c7620bi != null) {
                        C17017a.this.yZR = c7620bi.field_createTime;
                        C17017a.this.zah = c7620bi.field_msgSeq;
                    }
                }
                AppMethodBeat.m2505o(32714);
            }
        });
    }

    /* renamed from: a */
    public void mo10969a(MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d) {
        C34830g.m57195BO(13);
        mMChattingListView.getBaseAdapter().notifyDataSetChanged();
        ((C15612h) this.cgL.mo74857aF(C15612h.class)).dCV();
        if (c40752d.yYA == C40749a.ACTION_UPDATE) {
            this.cgL.yTx.cch();
        }
    }

    public String toString() {
        return getClass().getName();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Pj */
    public final void mo31086Pj(final int i) {
        this.zaj = 3;
        this.cgL.mo74853Oq(i);
        this.cgL.getListView().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(32715);
                if (C17017a.this.cgL.getFirstVisiblePosition() > i || i > C17017a.this.cgL.getLastVisiblePosition()) {
                    Log.m81049i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] pos:" + i + " reTryCount:" + C17017a.this.zaj);
                    C17017a.this.cgL.mo74881ho(i, 0);
                    C17017a c17017a = C17017a.this;
                    c17017a.zaj--;
                    if (C17017a.this.zaj >= 0) {
                        C17017a.this.cgL.getListView().postDelayed(this, 20);
                        AppMethodBeat.m2505o(32715);
                        return;
                    }
                }
                Log.m81049i("MicroMsg.ChattingLoader.AbstractDataPresenter", "[protectSetSelection] successfully! pos:" + i);
                AppMethodBeat.m2505o(32715);
            }
        }, 200);
    }
}
