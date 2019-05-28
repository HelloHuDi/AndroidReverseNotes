package com.tencent.p177mm.p612ui.chatting.p622l.p623a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p617f.C36163e;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.p612ui.chatting.p622l.C46663a;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.l.a.b */
public final class C36198b extends C17017a {
    private long yNB = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDz();
    private int zam;

    public C36198b(C46650a c46650a, C36163e c36163e) {
        super(c46650a, c36163e);
        AppMethodBeat.m2504i(32717);
        AppMethodBeat.m2505o(32717);
    }

    /* renamed from: a */
    public final void mo10969a(MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d) {
        boolean z;
        AppMethodBeat.m2504i(32718);
        super.mo10969a(mMChattingListView, c40752d);
        C40749a c40749a = c40752d.yYA;
        int size = c40752d.yYB.size();
        int i = c40752d.enb;
        switch (c40749a) {
            case ACTION_ENTER:
                this.cgL.mo74882qp(false);
                break;
            case ACTION_TOP:
                mMChattingListView.mo10809qc(false);
                C35897k.m58842a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27800Ow(curCount);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.mo10810qd(false);
                C35897k.m58842a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                break;
        }
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[onViewUpdate] result:%s", c40752d.toString());
        String talkerUserName = this.cgL.getTalkerUserName();
        long QQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(talkerUserName);
        C9638aw.m17190ZK();
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingBizDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(QQ), Integer.valueOf(C18628c.m29080XO().mo15350s(talkerUserName, 0, QQ)));
        if (i - C18628c.m29080XO().mo15350s(talkerUserName, 0, QQ) <= size) {
            z = true;
        } else {
            z = false;
        }
        mMChattingListView.setIsTopShowAll(z);
        mMChattingListView.setIsBottomShowAll(true);
        AppMethodBeat.m2505o(32718);
    }

    private int dHg() {
        AppMethodBeat.m2504i(32719);
        int dEx = ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEx();
        AppMethodBeat.m2505o(32719);
        return dEx;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ C30549e mo31087a(C40749a c40749a, Bundle bundle, C40752d c40752d) {
        AppMethodBeat.m2504i(32720);
        C30549e c30549e = null;
        C9638aw.m17190ZK();
        int aQ = C18628c.m29081XP().mo74796aQ(this.cgL.getTalkerUserName(), this.yNB);
        switch (c40749a) {
            case ACTION_ENTER:
                c30549e = new C46663a(this.cgL.getTalkerUserName(), this.yNB, 48, aQ);
                break;
            case ACTION_TOP:
                c30549e = new C46663a(this.cgL.getTalkerUserName(), this.yNB, this.zag + 48, aQ);
                break;
            case ACTION_UPDATE:
                int i = aQ - this.zam;
                String talkerUserName = this.cgL.getTalkerUserName();
                long j = this.yNB;
                int i2 = this.zag;
                if (i <= 0) {
                    i = 0;
                }
                c30549e = new C46663a(talkerUserName, j, i + i2, aQ);
                break;
        }
        this.zam = aQ;
        AppMethodBeat.m2505o(32720);
        return c30549e;
    }
}
