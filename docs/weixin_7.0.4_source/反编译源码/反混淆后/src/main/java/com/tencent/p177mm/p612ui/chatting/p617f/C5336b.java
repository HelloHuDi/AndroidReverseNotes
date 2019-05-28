package com.tencent.p177mm.p612ui.chatting.p617f;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30470q;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.f.b */
public final class C5336b implements C36166f<C7620bi> {
    private C46650a cgL;
    private MMChattingListView yYq;
    public C5337a yYr;

    /* renamed from: com.tencent.mm.ui.chatting.f.b$a */
    public interface C5337a {
        /* renamed from: a */
        void mo10969a(MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d);
    }

    public C5336b(C46650a c46650a, MMChattingListView mMChattingListView) {
        this.yYq = mMChattingListView;
        this.cgL = c46650a;
    }

    /* renamed from: a */
    public final void mo10968a(C40752d c40752d) {
        AppMethodBeat.m2504i(32479);
        if (this.cgL.caA) {
            C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", c40752d.toString());
            if (this.cgL.yTx.keyboardState() == 1) {
                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
                this.cgL.mo74882qp(true);
            }
            if (c40752d.yYA != C40749a.ACTION_UPDATE) {
                MMChattingListView mMChattingListView = this.yYq;
                MMPullDownView.m8031d((ViewGroup) mMChattingListView.ywu, 4);
                MMPullDownView.m8031d((ViewGroup) mMChattingListView.yho, 4);
            }
            ((C30470q) this.cgL.mo74857aF(C30470q.class)).startTimer();
            if (this.yYr != null) {
                this.yYr.mo10969a(this.yYq, c40752d);
            }
            AppMethodBeat.m2505o(32479);
            return;
        }
        C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
        AppMethodBeat.m2505o(32479);
    }
}
