package com.tencent.mm.ui.chatting.l.a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.f.d;
import com.tencent.mm.ui.chatting.l.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import java.lang.ref.WeakReference;

public final class c extends a {
    private boolean zan = false;
    private boolean zao = false;

    class a implements Runnable {
        private String username;
        private View view;
        private long zap;
        private long zaq;
        WeakReference<MMChattingListView> zar;

        /* synthetic */ a(c cVar, MMChattingListView mMChattingListView, String str, long j, long j2, byte b) {
            this(mMChattingListView, str, j, j2);
        }

        private a(MMChattingListView mMChattingListView, String str, long j, long j2) {
            AppMethodBeat.i(32723);
            this.view = mMChattingListView;
            this.username = str;
            this.zar = new WeakReference(mMChattingListView);
            this.zap = j2;
            this.zaq = j;
            AppMethodBeat.o(32723);
        }

        public final void run() {
            int o;
            int o2;
            AppMethodBeat.i(32724);
            b bOm = ((j) g.K(j.class)).bOm();
            int s = ((j) g.K(j.class)).bOr().s(this.username, 0, this.zaq - 1);
            if (s <= 0) {
                o = bOm.o(this.username, 0, this.zaq - 1);
            } else {
                o = 0;
            }
            final boolean z = s <= 0 && o <= 0;
            int s2 = ((j) g.K(j.class)).bOr().s(this.username, this.zap + 1, Long.MAX_VALUE);
            if (s2 <= 0) {
                o2 = bOm.o(this.username, this.zap + 1, Long.MAX_VALUE);
            } else {
                o2 = 0;
            }
            boolean z2 = s2 <= 0 && o2 <= 0;
            if (z2) {
                w QN = bOm.QN(this.username);
                z2 = QN.field_lastLocalSeq == QN.field_lastPushSeq;
            }
            ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", Boolean.valueOf(z), Integer.valueOf(s), Integer.valueOf(o), Boolean.valueOf(z2), Integer.valueOf(s2), Integer.valueOf(o2));
            this.view.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(32722);
                    MMChattingListView mMChattingListView = (MMChattingListView) a.this.zar.get();
                    if (mMChattingListView != null) {
                        mMChattingListView.getListView().setTranscriptMode(1);
                        mMChattingListView.setIsTopShowAll(z);
                        mMChattingListView.setIsBottomShowAll(z2);
                    }
                    AppMethodBeat.o(32722);
                }
            }, 60);
            AppMethodBeat.o(32724);
        }
    }

    public c(com.tencent.mm.ui.chatting.d.a aVar, d dVar) {
        super(aVar, dVar);
    }

    public final void a(com.tencent.mm.ui.chatting.f.d.a aVar, boolean z, Bundle bundle) {
        boolean z2 = true;
        AppMethodBeat.i(32725);
        if (aVar == com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (this.zan) {
                ab.w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
                bundle.putBoolean("has_position_tongue", true);
            } else if (this.zao) {
                bundle.putBoolean("has_position_search", true);
            }
        } else if (aVar == com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION) {
            boolean z3;
            if (bundle == null || bundle.getInt("SCENE") != 2) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.zan = z3;
            if (bundle == null || bundle.getInt("SCENE") != 1) {
                z2 = false;
            }
            this.zao = z2;
            ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
        }
        super.a(aVar, z, bundle);
        AppMethodBeat.o(32725);
    }

    /* Access modifiers changed, original: protected|final */
    public final e a(com.tencent.mm.ui.chatting.f.d.a aVar, Bundle bundle, d.d dVar) {
        AppMethodBeat.i(32726);
        boolean z = bundle != null && bundle.getInt("SCENE") == 1;
        com.tencent.mm.ui.chatting.l.b bVar = new com.tencent.mm.ui.chatting.l.b(this.cgL.getTalkerUserName(), aVar, bundle, this.zah, this.yZQ, this.yZR, this.zag, dVar, z);
        AppMethodBeat.o(32726);
        return bVar;
    }

    public final void a(MMChattingListView mMChattingListView, d.d<bi> dVar) {
        long j;
        AppMethodBeat.i(32727);
        int size = dVar.yYB.size();
        int i = dVar.enb;
        int i2 = dVar.selection;
        SparseArray sparseArray = dVar.yYD;
        com.tencent.mm.ui.chatting.f.d.a aVar = dVar.yYA;
        bi biVar = (bi) sparseArray.get(0);
        bi biVar2 = (bi) sparseArray.get(sparseArray.size() - 1);
        super.a(mMChattingListView, dVar);
        if (dVar.yYA != com.tencent.mm.ui.chatting.f.d.a.ACTION_UPDATE) {
            mMChattingListView.getListView().setTranscriptMode(0);
        }
        if (sparseArray.size() <= 6 && i > 6) {
            ab.e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", this.cgL.getTalkerUserName());
        }
        int preCount;
        int height;
        switch (dVar.yYA) {
            case ACTION_ENTER:
                mMChattingListView.qd(false);
                this.cgL.qp(true);
                break;
            case ACTION_UPDATE:
                if (dVar.yYz != null && dVar.yYz.getBoolean("need_scroll_to_bottom", false)) {
                    mMChattingListView.qd(false);
                    this.cgL.qp(true);
                    this.zan = false;
                }
                this.zao = false;
                break;
            case ACTION_BOTTOM:
                if (dVar.yYz == null || !dVar.yYz.getBoolean("load_bottom", false)) {
                    preCount = mMChattingListView.getPreCount() + 1;
                    height = (mMChattingListView.getListView().getHeight() - dHg()) - mMChattingListView.getBottomHeight();
                    this.cgL.ho(preCount, height);
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + preCount + " offset:" + height + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                } else {
                    this.cgL.qp(true);
                    ((s) this.cgL.aF(s.class)).dEA();
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
                }
                mMChattingListView.qd(false);
                break;
            case ACTION_POSITION:
                Object obj = (dVar.yYz == null || dVar.yYz.getInt("SCENE") != 1) ? null : 1;
                if (obj != null) {
                    Pj(dVar.selection);
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + dVar.selection);
                    break;
                } else if (dVar.yYz != null) {
                    mMChattingListView.a(false, null);
                    j = dVar.yYz.getLong("MSG_ID", 0);
                    for (height = sparseArray.size() - 1; height >= 0; height--) {
                        bi biVar3 = (bi) sparseArray.get(height);
                        if (biVar3 != null && biVar3.field_msgId == j) {
                            preCount = height;
                            height = Math.max(0, preCount);
                            dVar.selection = height;
                            ((h) this.cgL.aF(h.class)).Ov(dVar.selection);
                            Pj(dVar.selection);
                            ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + height + " msgId:" + j);
                            break;
                        }
                    }
                    preCount = 0;
                    height = Math.max(0, preCount);
                    dVar.selection = height;
                    ((h) this.cgL.aF(h.class)).Ov(dVar.selection);
                    Pj(dVar.selection);
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + height + " msgId:" + j);
                }
                break;
            case ACTION_TOP:
                mMChattingListView.qc(false);
                preCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                this.cgL.ho(preCount + 1, dHg() + mMChattingListView.getTopHeight());
                height = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + preCount + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                if (height > 0) {
                    ((h) this.cgL.aF(h.class)).Ow(height);
                    break;
                }
                break;
        }
        mMChattingListView.setIsTopShowAll(true);
        mMChattingListView.setIsBottomShowAll(true);
        long j2 = 0;
        if (biVar != null) {
            j2 = biVar.field_createTime;
        }
        j = 0;
        if (biVar2 != null) {
            j = biVar2.field_createTime;
        }
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", this.cgL.getTalkerUserName(), aVar, Integer.valueOf(size), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j));
        g.RS().aa(new a(this, mMChattingListView, this.cgL.getTalkerUserName(), j2, j, (byte) 0));
        AppMethodBeat.o(32727);
    }

    private int dHg() {
        AppMethodBeat.i(32728);
        int dEx = ((r) this.cgL.aF(r.class)).dEx();
        AppMethodBeat.o(32728);
        return dEx;
    }
}
