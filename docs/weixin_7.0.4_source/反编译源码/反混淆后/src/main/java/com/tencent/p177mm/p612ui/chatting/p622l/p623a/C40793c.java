package com.tencent.p177mm.p612ui.chatting.p622l.p623a;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.p612ui.chatting.p622l.C40797b;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.chatting.l.a.c */
public final class C40793c extends C17017a {
    private boolean zan = false;
    private boolean zao = false;

    /* renamed from: com.tencent.mm.ui.chatting.l.a.c$a */
    class C23799a implements Runnable {
        private String username;
        private View view;
        private long zap;
        private long zaq;
        WeakReference<MMChattingListView> zar;

        /* synthetic */ C23799a(C40793c c40793c, MMChattingListView mMChattingListView, String str, long j, long j2, byte b) {
            this(mMChattingListView, str, j, j2);
        }

        private C23799a(MMChattingListView mMChattingListView, String str, long j, long j2) {
            AppMethodBeat.m2504i(32723);
            this.view = mMChattingListView;
            this.username = str;
            this.zar = new WeakReference(mMChattingListView);
            this.zap = j2;
            this.zaq = j;
            AppMethodBeat.m2505o(32723);
        }

        public final void run() {
            int o;
            int o2;
            AppMethodBeat.m2504i(32724);
            C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
            int s = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15350s(this.username, 0, this.zaq - 1);
            if (s <= 0) {
                o = bOm.mo15226o(this.username, 0, this.zaq - 1);
            } else {
                o = 0;
            }
            final boolean z = s <= 0 && o <= 0;
            int s2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15350s(this.username, this.zap + 1, Long.MAX_VALUE);
            if (s2 <= 0) {
                o2 = bOm.mo15226o(this.username, this.zap + 1, Long.MAX_VALUE);
            } else {
                o2 = 0;
            }
            boolean z2 = s2 <= 0 && o2 <= 0;
            if (z2) {
                C7578w QN = bOm.mo15218QN(this.username);
                z2 = QN.field_lastLocalSeq == QN.field_lastPushSeq;
            }
            C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[CheckEdgeTask#run] isShowTopAll:%s topCount:%s topBlockCount:%s isShowBottomAll:%s bottomCount:%s bottomBlockCount:%s", Boolean.valueOf(z), Integer.valueOf(s), Integer.valueOf(o), Boolean.valueOf(z2), Integer.valueOf(s2), Integer.valueOf(o2));
            this.view.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(32722);
                    MMChattingListView mMChattingListView = (MMChattingListView) C23799a.this.zar.get();
                    if (mMChattingListView != null) {
                        mMChattingListView.getListView().setTranscriptMode(1);
                        mMChattingListView.setIsTopShowAll(z);
                        mMChattingListView.setIsBottomShowAll(z2);
                    }
                    AppMethodBeat.m2505o(32722);
                }
            }, 60);
            AppMethodBeat.m2505o(32724);
        }
    }

    public C40793c(C46650a c46650a, C40748d c40748d) {
        super(c46650a, c40748d);
    }

    /* renamed from: a */
    public final void mo31088a(C40749a c40749a, boolean z, Bundle bundle) {
        boolean z2 = true;
        AppMethodBeat.m2504i(32725);
        if (c40749a == C40749a.ACTION_UPDATE) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (this.zan) {
                C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position before");
                bundle.putBoolean("has_position_tongue", true);
            } else if (this.zao) {
                bundle.putBoolean("has_position_search", true);
            }
        } else if (c40749a == C40749a.ACTION_POSITION) {
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
            C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onLoad] has tongue position!");
        }
        super.mo31088a(c40749a, z, bundle);
        AppMethodBeat.m2505o(32725);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C30549e mo31087a(C40749a c40749a, Bundle bundle, C40752d c40752d) {
        AppMethodBeat.m2504i(32726);
        boolean z = bundle != null && bundle.getInt("SCENE") == 1;
        C40797b c40797b = new C40797b(this.cgL.getTalkerUserName(), c40749a, bundle, this.zah, this.yZQ, this.yZR, this.zag, c40752d, z);
        AppMethodBeat.m2505o(32726);
        return c40797b;
    }

    /* renamed from: a */
    public final void mo10969a(MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d) {
        long j;
        AppMethodBeat.m2504i(32727);
        int size = c40752d.yYB.size();
        int i = c40752d.enb;
        int i2 = c40752d.selection;
        SparseArray sparseArray = c40752d.yYD;
        C40749a c40749a = c40752d.yYA;
        C7620bi c7620bi = (C7620bi) sparseArray.get(0);
        C7620bi c7620bi2 = (C7620bi) sparseArray.get(sparseArray.size() - 1);
        super.mo10969a(mMChattingListView, c40752d);
        if (c40752d.yYA != C40749a.ACTION_UPDATE) {
            mMChattingListView.getListView().setTranscriptMode(0);
        }
        if (sparseArray.size() <= 6 && i > 6) {
            C4990ab.m7413e("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] may be err! talker:%s", this.cgL.getTalkerUserName());
        }
        int preCount;
        int height;
        switch (c40752d.yYA) {
            case ACTION_ENTER:
                mMChattingListView.mo10810qd(false);
                this.cgL.mo74882qp(true);
                break;
            case ACTION_UPDATE:
                if (c40752d.yYz != null && c40752d.yYz.getBoolean("need_scroll_to_bottom", false)) {
                    mMChattingListView.mo10810qd(false);
                    this.cgL.mo74882qp(true);
                    this.zan = false;
                }
                this.zao = false;
                break;
            case ACTION_BOTTOM:
                if (c40752d.yYz == null || !c40752d.yYz.getBoolean("load_bottom", false)) {
                    preCount = mMChattingListView.getPreCount() + 1;
                    height = (mMChattingListView.getListView().getHeight() - dHg()) - mMChattingListView.getBottomHeight();
                    this.cgL.mo74881ho(preCount, height);
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "selection:" + preCount + " offset:" + height + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                } else {
                    this.cgL.mo74882qp(true);
                    ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEA();
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "after enter load bottom!");
                }
                mMChattingListView.mo10810qd(false);
                break;
            case ACTION_POSITION:
                Object obj = (c40752d.yYz == null || c40752d.yYz.getInt("SCENE") != 1) ? null : 1;
                if (obj != null) {
                    mo31086Pj(c40752d.selection);
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "isFromSearch! selection:" + c40752d.selection);
                    break;
                } else if (c40752d.yYz != null) {
                    mMChattingListView.mo64351a(false, null);
                    j = c40752d.yYz.getLong("MSG_ID", 0);
                    for (height = sparseArray.size() - 1; height >= 0; height--) {
                        C7620bi c7620bi3 = (C7620bi) sparseArray.get(height);
                        if (c7620bi3 != null && c7620bi3.field_msgId == j) {
                            preCount = height;
                            height = Math.max(0, preCount);
                            c40752d.selection = height;
                            ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27799Ov(c40752d.selection);
                            mo31086Pj(c40752d.selection);
                            C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + height + " msgId:" + j);
                            break;
                        }
                    }
                    preCount = 0;
                    height = Math.max(0, preCount);
                    c40752d.selection = height;
                    ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27799Ov(c40752d.selection);
                    mo31086Pj(c40752d.selection);
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "pos:" + height + " msgId:" + j);
                }
                break;
            case ACTION_TOP:
                mMChattingListView.mo10809qc(false);
                preCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                this.cgL.mo74881ho(preCount + 1, dHg() + mMChattingListView.getTopHeight());
                height = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "select:" + preCount + " curCount:" + mMChattingListView.getCurCount() + " preCount:" + mMChattingListView.getPreCount());
                if (height > 0) {
                    ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27800Ow(height);
                    break;
                }
                break;
        }
        mMChattingListView.setIsTopShowAll(true);
        mMChattingListView.setIsBottomShowAll(true);
        long j2 = 0;
        if (c7620bi != null) {
            j2 = c7620bi.field_createTime;
        }
        j = 0;
        if (c7620bi2 != null) {
            j = c7620bi2.field_createTime;
        }
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingGetDataPresenter", "[onViewUpdate] talker:%s action:%s loadedCount:%s allCount:%s selection:%s lastTopCreateTime:%s lastBottomCreateTime:%s", this.cgL.getTalkerUserName(), c40749a, Integer.valueOf(size), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j));
        C1720g.m3539RS().mo10302aa(new C23799a(this, mMChattingListView, this.cgL.getTalkerUserName(), j2, j, (byte) 0));
        AppMethodBeat.m2505o(32727);
    }

    private int dHg() {
        AppMethodBeat.m2504i(32728);
        int dEx = ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEx();
        AppMethodBeat.m2505o(32728);
        return dEx;
    }
}
