package com.tencent.mm.ui.chatting.f;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.chatting.c.b.q;
import com.tencent.mm.ui.chatting.f.d.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class b implements f<bi> {
    private com.tencent.mm.ui.chatting.d.a cgL;
    private MMChattingListView yYq;
    public a yYr;

    public interface a {
        void a(MMChattingListView mMChattingListView, d<bi> dVar);
    }

    public b(com.tencent.mm.ui.chatting.d.a aVar, MMChattingListView mMChattingListView) {
        this.yYq = mMChattingListView;
        this.cgL = aVar;
    }

    public final void a(d dVar) {
        AppMethodBeat.i(32479);
        if (this.cgL.caA) {
            ab.i("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] result:%s", dVar.toString());
            if (this.cgL.yTx.keyboardState() == 1) {
                ab.i("MicroMsg.ChattingLoader.ChattingViewCallback", "keyboard is shown! scroll to last");
                this.cgL.qp(true);
            }
            if (dVar.yYA != com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE) {
                MMChattingListView mMChattingListView = this.yYq;
                MMPullDownView.d((ViewGroup) mMChattingListView.ywu, 4);
                MMPullDownView.d((ViewGroup) mMChattingListView.yho, 4);
            }
            ((q) this.cgL.aF(q.class)).startTimer();
            if (this.yYr != null) {
                this.yYr.a(this.yYq, dVar);
            }
            AppMethodBeat.o(32479);
            return;
        }
        ab.e("MicroMsg.ChattingLoader.ChattingViewCallback", "[onViewUpdate] this ChattingUI has been in background!");
        AppMethodBeat.o(32479);
    }
}
