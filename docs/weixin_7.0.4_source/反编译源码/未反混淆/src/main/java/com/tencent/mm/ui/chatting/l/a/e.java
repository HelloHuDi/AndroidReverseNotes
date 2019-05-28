package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

public final class e extends a {
    private String talker = this.cgL.getTalkerUserName();
    private boolean zaB;
    private Runnable zaC;
    private volatile long zaw = 0;
    private volatile long zax = 0;
    private volatile long zay = 0;

    public e(a aVar, d dVar) {
        super(aVar, dVar);
        AppMethodBeat.i(32736);
        ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", this.talker);
        AppMethodBeat.o(32736);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.chatting.l.e a(d.a aVar, Bundle bundle, d.d dVar) {
        int s;
        int i;
        AppMethodBeat.i(32737);
        int max;
        switch (aVar) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (bundle != null) {
                    long j = bundle.getLong("MSG_ID");
                    this.zaB = bundle.getBoolean("IS_LOAD_ALL", false);
                    aw.ZK();
                    bi jf = c.XO().jf(j);
                    if (jf.field_msgId == j) {
                        long j2 = jf.field_createTime;
                        if (j2 < this.zaw || j2 > this.zax) {
                            this.zaw = j2;
                            this.zay = ((j) g.K(j.class)).bOr().Rt(this.talker);
                            if (this.zaB) {
                                this.zax = this.zay;
                            } else {
                                aw.ZK();
                                this.zax = c.XO().g(this.talker, j2, 48);
                            }
                            aw.ZK();
                            ab.v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", Integer.valueOf(c.XO().s(this.talker, this.zaw, this.zax)));
                            if (c.XO().s(this.talker, this.zaw, this.zax) < 48) {
                                ab.d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.zaw), Integer.valueOf(0));
                                aw.ZK();
                                this.zaw = c.XO().f(this.talker, this.zaw, 48);
                                aw.ZK();
                                s = c.XO().s(this.talker, this.zaw, j2);
                            } else {
                                s = 0;
                            }
                        } else {
                            aw.ZK();
                            s = c.XO().s(this.talker, this.zaw, j2);
                        }
                        dVar.selection = s;
                        s = 0;
                        i = 0;
                        break;
                    }
                    ab.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", Long.valueOf(j));
                    s = 0;
                    i = 0;
                    break;
                }
                ab.w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
                s = 0;
                i = 0;
                break;
                break;
            case ACTION_TOP:
                aw.ZK();
                long f = c.XO().f(this.talker, this.zaw, 48);
                aw.ZK();
                max = Math.max(0, c.XO().s(this.talker, f, this.zaw) - 1);
                this.zaw = f;
                s = 0;
                i = max;
                break;
            case ACTION_BOTTOM:
                aw.ZK();
                long g = c.XO().g(this.talker, this.zax, 48);
                aw.ZK();
                s = Math.max(0, c.XO().s(this.talker, this.zax, g) - 1);
                this.zax = g;
                i = 0;
                break;
            case ACTION_UPDATE:
                this.zay = ((j) g.K(j.class)).bOr().Rt(this.talker);
                aw.ZK();
                max = Math.max(0, c.XO().s(this.talker, this.zax, this.zay) - 1);
                if (this.zaB || max <= 480) {
                    this.zax = this.zay;
                } else {
                    bi Rb = ((j) g.K(j.class)).bOr().Rb(this.talker);
                    if (Rb.field_isSend == 1 && this.zay != Rb.field_createTime) {
                        this.zay = Rb.field_createTime;
                        aw.ZK();
                        this.zaw = c.XO().f(this.talker, this.zaw, 48);
                        this.zax = this.zay;
                    }
                }
                s = max;
                i = 0;
                break;
            default:
                s = 0;
                i = 0;
                break;
        }
        ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", aVar, Long.valueOf(this.zaw), Long.valueOf(this.zax), Long.valueOf(this.zay), Integer.valueOf(i), Integer.valueOf(s));
        com.tencent.mm.ui.chatting.l.d dVar2 = new com.tencent.mm.ui.chatting.l.d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
        AppMethodBeat.o(32737);
        return dVar2;
    }

    public final void a(final MMChattingListView mMChattingListView, d.d<bi> dVar) {
        boolean booleanValue;
        boolean z = true;
        AppMethodBeat.i(32738);
        super.a(mMChattingListView, dVar);
        d.a aVar = dVar.yYA;
        final int i = dVar.selection;
        mMChattingListView.getListView().setTranscriptMode(0);
        switch (aVar) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (i >= 0) {
                    booleanValue = this.cgL.yTx.getBooleanExtra("need_hight_item", false).booleanValue();
                    Pj(i);
                    if (booleanValue) {
                        this.cgL.yTx.getLongExtra("msg_local_id", -1);
                        ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", Integer.valueOf(i));
                        al.af(this.zaC);
                        AnonymousClass1 anonymousClass1 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32734);
                                int max = Math.max(0, i - e.this.cgL.getFirstVisiblePosition());
                                e.this.Pj(i);
                                mMChattingListView.setHighLightChild(max);
                                aw.ZK();
                                c.Ry().set(ac.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.FALSE);
                                AppMethodBeat.o(32734);
                            }
                        };
                        this.zaC = anonymousClass1;
                        al.n(anonymousClass1, 500);
                        break;
                    }
                }
                break;
            case ACTION_TOP:
                mMChattingListView.qc(false);
                k.a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                i = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (i > 0) {
                    ((h) this.cgL.aF(h.class)).Ow(i);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.qd(false);
                k.a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                break;
        }
        if (this.cgL.getLastVisiblePosition() == dVar.yYC - 1) {
            mMChattingListView.getListView().setTranscriptMode(1);
        }
        mMChattingListView.setBottomViewVisible(true);
        ab.i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", Long.valueOf(((j) g.K(j.class)).bOr().Rs(this.talker)), Long.valueOf(this.zaw));
        if (this.zaw <= ((j) g.K(j.class)).bOr().Rs(this.talker)) {
            booleanValue = true;
        } else {
            booleanValue = false;
        }
        mMChattingListView.setIsTopShowAll(booleanValue);
        if (this.zax < this.zay) {
            z = false;
        }
        mMChattingListView.setIsBottomShowAll(z);
        AppMethodBeat.o(32738);
    }

    private int dHg() {
        AppMethodBeat.i(32739);
        int dEx = ((r) this.cgL.aF(r.class)).dEx();
        AppMethodBeat.o(32739);
        return dEx;
    }
}
