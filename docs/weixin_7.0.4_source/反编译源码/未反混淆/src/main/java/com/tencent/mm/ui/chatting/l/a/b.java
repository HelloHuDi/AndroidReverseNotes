package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.f.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class b extends a {
    private long yNB = ((d) this.cgL.aF(d.class)).dDz();
    private int zam;

    public b(a aVar, e eVar) {
        super(aVar, eVar);
        AppMethodBeat.i(32717);
        AppMethodBeat.o(32717);
    }

    public final void a(MMChattingListView mMChattingListView, com.tencent.mm.ui.chatting.f.d.d<bi> dVar) {
        boolean z;
        AppMethodBeat.i(32718);
        super.a(mMChattingListView, dVar);
        com.tencent.mm.ui.chatting.f.d.a aVar = dVar.yYA;
        int size = dVar.yYB.size();
        int i = dVar.enb;
        switch (aVar) {
            case ACTION_ENTER:
                this.cgL.qp(false);
                break;
            case ACTION_TOP:
                mMChattingListView.qc(false);
                k.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((h) this.cgL.aF(h.class)).Ow(curCount);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.qd(false);
                k.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                break;
        }
        ab.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", dVar.toString());
        String talkerUserName = this.cgL.getTalkerUserName();
        long QQ = ((j) g.K(j.class)).Yo().QQ(talkerUserName);
        aw.ZK();
        ab.i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(QQ), Integer.valueOf(c.XO().s(talkerUserName, 0, QQ)));
        if (i - c.XO().s(talkerUserName, 0, QQ) <= size) {
            z = true;
        } else {
            z = false;
        }
        mMChattingListView.setIsTopShowAll(z);
        mMChattingListView.setIsBottomShowAll(true);
        AppMethodBeat.o(32718);
    }

    private int dHg() {
        AppMethodBeat.i(32719);
        int dEx = ((r) this.cgL.aF(r.class)).dEx();
        AppMethodBeat.o(32719);
        return dEx;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ com.tencent.mm.ui.chatting.l.e a(com.tencent.mm.ui.chatting.f.d.a aVar, Bundle bundle, com.tencent.mm.ui.chatting.f.d.d dVar) {
        AppMethodBeat.i(32720);
        com.tencent.mm.ui.chatting.l.e eVar = null;
        aw.ZK();
        int aQ = c.XP().aQ(this.cgL.getTalkerUserName(), this.yNB);
        switch (aVar) {
            case ACTION_ENTER:
                eVar = new com.tencent.mm.ui.chatting.l.a(this.cgL.getTalkerUserName(), this.yNB, 48, aQ);
                break;
            case ACTION_TOP:
                eVar = new com.tencent.mm.ui.chatting.l.a(this.cgL.getTalkerUserName(), this.yNB, this.zag + 48, aQ);
                break;
            case ACTION_UPDATE:
                int i = aQ - this.zam;
                String talkerUserName = this.cgL.getTalkerUserName();
                long j = this.yNB;
                int i2 = this.zag;
                if (i <= 0) {
                    i = 0;
                }
                eVar = new com.tencent.mm.ui.chatting.l.a(talkerUserName, j, i + i2, aQ);
                break;
        }
        this.zam = aQ;
        AppMethodBeat.o(32720);
        return eVar;
    }
}
