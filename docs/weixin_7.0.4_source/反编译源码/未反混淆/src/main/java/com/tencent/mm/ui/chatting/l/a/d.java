package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.f.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class d extends a {
    private int zam = 0;
    private volatile long zaw = 0;
    private volatile long zax = 0;
    private volatile long zay = 0;

    public d(a aVar, e eVar) {
        super(aVar, eVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.chatting.l.e a(com.tencent.mm.ui.chatting.f.d.a aVar, Bundle bundle, com.tencent.mm.ui.chatting.f.d.d dVar) {
        AppMethodBeat.i(32731);
        com.tencent.mm.ui.chatting.l.e eVar = null;
        aw.ZK();
        int Rp = c.XO().Rp(this.cgL.getTalkerUserName());
        int i;
        switch (aVar) {
            case ACTION_ENTER:
                eVar = new com.tencent.mm.ui.chatting.l.c(this.cgL.getTalkerUserName(), 16, Rp);
                break;
            case ACTION_TOP:
                eVar = new com.tencent.mm.ui.chatting.l.c(this.cgL.getTalkerUserName(), this.zag + 48, Rp);
                break;
            case ACTION_UPDATE:
                i = Rp - this.zam;
                String talkerUserName = this.cgL.getTalkerUserName();
                int i2 = this.zag;
                if (i <= 0) {
                    i = 0;
                }
                Object eVar2 = new com.tencent.mm.ui.chatting.l.c(talkerUserName, i + i2, Rp);
                break;
            case ACTION_POSITION:
                if (bundle != null) {
                    if (bundle.getInt("SCENE", 0) != 1) {
                        if (bundle.getInt("SCENE", 0) == 2) {
                            if (bundle != null) {
                                ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", Integer.valueOf(Rp), Integer.valueOf(bundle.getInt("MSG_POSITION")), Integer.valueOf(Rp - bundle.getInt("MSG_POSITION")));
                                eVar2 = new com.tencent.mm.ui.chatting.l.c(this.cgL.getTalkerUserName(), r1, Rp);
                                break;
                            }
                            ab.e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
                            eVar2 = new com.tencent.mm.ui.chatting.l.c(this.cgL.getTalkerUserName(), this.zag, Rp);
                            break;
                        }
                    }
                    ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
                    if (bundle != null) {
                        String talkerUserName2 = this.cgL.getTalkerUserName();
                        long j = bundle.getLong("MSG_ID");
                        boolean z = bundle.getBoolean("IS_LOAD_ALL", false);
                        aw.ZK();
                        bi jf = c.XO().jf(j);
                        if (jf.field_msgId == j) {
                            long j2 = jf.field_createTime;
                            if (j2 < this.zaw || j2 > this.zax) {
                                this.zaw = j2;
                                this.zay = ((j) g.K(j.class)).bOr().Rt(talkerUserName2);
                                if (z) {
                                    this.zax = this.zay;
                                } else {
                                    aw.ZK();
                                    this.zax = c.XO().g(talkerUserName2, j2, 48);
                                }
                                aw.ZK();
                                ab.v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", Integer.valueOf(c.XO().s(talkerUserName2, this.zaw, this.zax)));
                                if (c.XO().s(talkerUserName2, this.zaw, this.zax) < 48) {
                                    ab.d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.zaw), Integer.valueOf(0));
                                    aw.ZK();
                                    this.zaw = c.XO().f(talkerUserName2, this.zaw, 48);
                                    aw.ZK();
                                    i = c.XO().s(talkerUserName2, this.zaw, j2);
                                } else {
                                    i = 0;
                                }
                            } else {
                                aw.ZK();
                                i = c.XO().s(talkerUserName2, this.zaw, j2);
                            }
                            dVar.selection = i;
                            eVar2 = new com.tencent.mm.ui.chatting.l.d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                            break;
                        }
                        ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", Long.valueOf(j));
                        eVar2 = new com.tencent.mm.ui.chatting.l.d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                        break;
                    }
                    ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
                    eVar2 = new com.tencent.mm.ui.chatting.l.d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                    break;
                }
                ab.w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
                AppMethodBeat.o(32731);
                return null;
                break;
        }
        this.zam = Rp;
        AppMethodBeat.o(32731);
        return eVar2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(MMChattingListView mMChattingListView, com.tencent.mm.ui.chatting.f.d.d<bi> dVar) {
        int i;
        AppMethodBeat.i(32732);
        super.a(mMChattingListView, dVar);
        com.tencent.mm.ui.chatting.f.d.a aVar = dVar.yYA;
        SparseArray sparseArray = dVar.yYD;
        int size = dVar.yYB.size();
        int i2 = dVar.enb;
        int i3 = dVar.selection;
        final Bundle bundle = dVar.yYz;
        bi biVar = (bi) sparseArray.get(0);
        bi biVar2 = (bi) sparseArray.get(sparseArray.size() - 1);
        if (biVar != null) {
            this.zaw = biVar.field_createTime;
        }
        if (biVar2 != null) {
            this.zax = biVar2.field_createTime;
        }
        switch (aVar) {
            case ACTION_ENTER:
                this.cgL.qp(false);
                i = i3;
                break;
            case ACTION_TOP:
                mMChattingListView.qc(false);
                k.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((h) this.cgL.aF(h.class)).Ow(curCount);
                    i = i3;
                    break;
                }
            case ACTION_POSITION:
                i = Math.max(0, mMChattingListView.getCurCount() - (dVar.enb - bundle.getInt("MSG_POSITION")));
                dVar.selection = i;
                mMChattingListView.getListView().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(32729);
                        h hVar = (h) d.this.cgL.aF(h.class);
                        if (bundle.getInt("SCENE", 0) == 1) {
                            d.this.Pj(i);
                            AppMethodBeat.o(32729);
                            return;
                        }
                        if (bundle.getInt("SCENE", 0) == 2) {
                            hVar.Ov(i);
                            d.this.cgL.bY(i);
                        }
                        AppMethodBeat.o(32729);
                    }
                });
                break;
            case ACTION_BOTTOM:
                mMChattingListView.qd(false);
                k.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                i = i3;
                break;
            default:
                i = i3;
                break;
        }
        if (aVar != com.tencent.mm.ui.chatting.f.d.a.ACTION_ENTER) {
            boolean z;
            ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", aVar, Long.valueOf(this.zaw), Long.valueOf(this.zax), Integer.valueOf(size), Integer.valueOf(i2), Integer.valueOf(i));
            String talkerUserName = this.cgL.getTalkerUserName();
            long QQ = ((j) g.K(j.class)).Yo().QQ(talkerUserName);
            aw.ZK();
            ab.i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(QQ), Integer.valueOf(c.XO().s(talkerUserName, 0, QQ)));
            if (i2 - c.XO().s(talkerUserName, 0, QQ) <= size) {
                z = true;
            } else {
                z = false;
            }
            mMChattingListView.setIsTopShowAll(z);
            mMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.o(32732);
    }

    private int dHg() {
        AppMethodBeat.i(32733);
        int dEx = ((r) this.cgL.aF(r.class)).dEx();
        AppMethodBeat.o(32733);
        return dEx;
    }
}
