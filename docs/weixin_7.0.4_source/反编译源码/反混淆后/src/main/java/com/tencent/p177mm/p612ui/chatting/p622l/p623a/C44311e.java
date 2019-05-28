package com.tencent.p177mm.p612ui.chatting.p622l.p623a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.p612ui.chatting.p622l.C40800d;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.l.a.e */
public final class C44311e extends C17017a {
    private String talker = this.cgL.getTalkerUserName();
    private boolean zaB;
    private Runnable zaC;
    private volatile long zaw = 0;
    private volatile long zax = 0;
    private volatile long zay = 0;

    public C44311e(C46650a c46650a, C40748d c40748d) {
        super(c46650a, c40748d);
        AppMethodBeat.m2504i(32736);
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[ChattingSearchDataPresenter] talker:%s", this.talker);
        AppMethodBeat.m2505o(32736);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C30549e mo31087a(C40749a c40749a, Bundle bundle, C40752d c40752d) {
        int s;
        int i;
        AppMethodBeat.m2504i(32737);
        int max;
        switch (c40749a) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (bundle != null) {
                    long j = bundle.getLong("MSG_ID");
                    this.zaB = bundle.getBoolean("IS_LOAD_ALL", false);
                    C9638aw.m17190ZK();
                    C7620bi jf = C18628c.m29080XO().mo15340jf(j);
                    if (jf.field_msgId == j) {
                        long j2 = jf.field_createTime;
                        if (j2 < this.zaw || j2 > this.zax) {
                            this.zaw = j2;
                            this.zay = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(this.talker);
                            if (this.zaB) {
                                this.zax = this.zay;
                            } else {
                                C9638aw.m17190ZK();
                                this.zax = C18628c.m29080XO().mo15335g(this.talker, j2, 48);
                            }
                            C9638aw.m17190ZK();
                            C4990ab.m7419v("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reset position, reload count %d", Integer.valueOf(C18628c.m29080XO().mo15350s(this.talker, this.zaw, this.zax)));
                            if (C18628c.m29080XO().mo15350s(this.talker, this.zaw, this.zax) < 48) {
                                C4990ab.m7411d("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.zaw), Integer.valueOf(0));
                                C9638aw.m17190ZK();
                                this.zaw = C18628c.m29080XO().mo15330f(this.talker, this.zaw, 48);
                                C9638aw.m17190ZK();
                                s = C18628c.m29080XO().mo15350s(this.talker, this.zaw, j2);
                            } else {
                                s = 0;
                            }
                        } else {
                            C9638aw.m17190ZK();
                            s = C18628c.m29080XO().mo15350s(this.talker, this.zaw, j2);
                        }
                        c40752d.selection = s;
                        s = 0;
                        i = 0;
                        break;
                    }
                    C4990ab.m7421w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "get msg info by id %d error", Long.valueOf(j));
                    s = 0;
                    i = 0;
                    break;
                }
                C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[handleEnter] sourceArgs is null!");
                s = 0;
                i = 0;
                break;
                break;
            case ACTION_TOP:
                C9638aw.m17190ZK();
                long f = C18628c.m29080XO().mo15330f(this.talker, this.zaw, 48);
                C9638aw.m17190ZK();
                max = Math.max(0, C18628c.m29080XO().mo15350s(this.talker, f, this.zaw) - 1);
                this.zaw = f;
                s = 0;
                i = max;
                break;
            case ACTION_BOTTOM:
                C9638aw.m17190ZK();
                long g = C18628c.m29080XO().mo15335g(this.talker, this.zax, 48);
                C9638aw.m17190ZK();
                s = Math.max(0, C18628c.m29080XO().mo15350s(this.talker, this.zax, g) - 1);
                this.zax = g;
                i = 0;
                break;
            case ACTION_UPDATE:
                this.zay = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(this.talker);
                C9638aw.m17190ZK();
                max = Math.max(0, C18628c.m29080XO().mo15350s(this.talker, this.zax, this.zay) - 1);
                if (this.zaB || max <= 480) {
                    this.zax = this.zay;
                } else {
                    C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(this.talker);
                    if (Rb.field_isSend == 1 && this.zay != Rb.field_createTime) {
                        this.zay = Rb.field_createTime;
                        C9638aw.m17190ZK();
                        this.zaw = C18628c.m29080XO().mo15330f(this.talker, this.zaw, 48);
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
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "mode[%s] query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]", c40749a, Long.valueOf(this.zaw), Long.valueOf(this.zax), Long.valueOf(this.zay), Integer.valueOf(i), Integer.valueOf(s));
        C40800d c40800d = new C40800d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
        AppMethodBeat.m2505o(32737);
        return c40800d;
    }

    /* renamed from: a */
    public final void mo10969a(final MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d) {
        boolean booleanValue;
        boolean z = true;
        AppMethodBeat.m2504i(32738);
        super.mo10969a(mMChattingListView, c40752d);
        C40749a c40749a = c40752d.yYA;
        final int i = c40752d.selection;
        mMChattingListView.getListView().setTranscriptMode(0);
        switch (c40749a) {
            case ACTION_POSITION:
            case ACTION_ENTER:
                if (i >= 0) {
                    booleanValue = this.cgL.yTx.getBooleanExtra("need_hight_item", false).booleanValue();
                    mo31086Pj(i);
                    if (booleanValue) {
                        this.cgL.yTx.getLongExtra("msg_local_id", -1);
                        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[matteHighLightItem] position:%s", Integer.valueOf(i));
                        C5004al.m7439af(this.zaC);
                        C53531 c53531 = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(32734);
                                int max = Math.max(0, i - C44311e.this.cgL.getFirstVisiblePosition());
                                C44311e.this.mo31086Pj(i);
                                mMChattingListView.setHighLightChild(max);
                                C9638aw.m17190ZK();
                                C18628c.m29072Ry().set(C5127a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.FALSE);
                                AppMethodBeat.m2505o(32734);
                            }
                        };
                        this.zaC = c53531;
                        C5004al.m7442n(c53531, 500);
                        break;
                    }
                }
                break;
            case ACTION_TOP:
                mMChattingListView.mo10809qc(false);
                C35897k.m58842a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                i = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (i > 0) {
                    ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27800Ow(i);
                    break;
                }
                break;
            case ACTION_BOTTOM:
                mMChattingListView.mo10810qd(false);
                C35897k.m58842a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                break;
        }
        if (this.cgL.getLastVisiblePosition() == c40752d.yYC - 1) {
            mMChattingListView.getListView().setTranscriptMode(1);
        }
        mMChattingListView.setBottomViewVisible(true);
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingSearchDataPresenter", "[isShowTopAll] firstMsgCreateTime:%s lastTopMsgCreateTime:%s", Long.valueOf(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15265Rs(this.talker)), Long.valueOf(this.zaw));
        if (this.zaw <= ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15265Rs(this.talker)) {
            booleanValue = true;
        } else {
            booleanValue = false;
        }
        mMChattingListView.setIsTopShowAll(booleanValue);
        if (this.zax < this.zay) {
            z = false;
        }
        mMChattingListView.setIsBottomShowAll(z);
        AppMethodBeat.m2505o(32738);
    }

    private int dHg() {
        AppMethodBeat.m2504i(32739);
        int dEx = ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEx();
        AppMethodBeat.m2505o(32739);
        return dEx;
    }
}
