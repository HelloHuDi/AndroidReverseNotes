package com.tencent.p177mm.p612ui.chatting.p622l.p623a;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p617f.C36163e;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.p612ui.chatting.p622l.C40800d;
import com.tencent.p177mm.p612ui.chatting.p622l.C46664c;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.l.a.d */
public final class C46662d extends C17017a {
    private int zam = 0;
    private volatile long zaw = 0;
    private volatile long zax = 0;
    private volatile long zay = 0;

    public C46662d(C46650a c46650a, C36163e c36163e) {
        super(c46650a, c36163e);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C30549e mo31087a(C40749a c40749a, Bundle bundle, C40752d c40752d) {
        AppMethodBeat.m2504i(32731);
        C30549e c30549e = null;
        C9638aw.m17190ZK();
        int Rp = C18628c.m29080XO().mo15262Rp(this.cgL.getTalkerUserName());
        int i;
        switch (c40749a) {
            case ACTION_ENTER:
                c30549e = new C46664c(this.cgL.getTalkerUserName(), 16, Rp);
                break;
            case ACTION_TOP:
                c30549e = new C46664c(this.cgL.getTalkerUserName(), this.zag + 48, Rp);
                break;
            case ACTION_UPDATE:
                i = Rp - this.zam;
                String talkerUserName = this.cgL.getTalkerUserName();
                int i2 = this.zag;
                if (i <= 0) {
                    i = 0;
                }
                Object c30549e2 = new C46664c(talkerUserName, i + i2, Rp);
                break;
            case ACTION_POSITION:
                if (bundle != null) {
                    if (bundle.getInt("SCENE", 0) != 1) {
                        if (bundle.getInt("SCENE", 0) == 2) {
                            if (bundle != null) {
                                C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] totalCount:%s position:%s count:%s", Integer.valueOf(Rp), Integer.valueOf(bundle.getInt("MSG_POSITION")), Integer.valueOf(Rp - bundle.getInt("MSG_POSITION")));
                                c30549e2 = new C46664c(this.cgL.getTalkerUserName(), r1, Rp);
                                break;
                            }
                            C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForTongue] sourceArgs == null");
                            c30549e2 = new C46664c(this.cgL.getTalkerUserName(), this.zag, Rp);
                            break;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handlePositionForSearch]");
                    if (bundle != null) {
                        String talkerUserName2 = this.cgL.getTalkerUserName();
                        long j = bundle.getLong("MSG_ID");
                        boolean z = bundle.getBoolean("IS_LOAD_ALL", false);
                        C9638aw.m17190ZK();
                        C7620bi jf = C18628c.m29080XO().mo15340jf(j);
                        if (jf.field_msgId == j) {
                            long j2 = jf.field_createTime;
                            if (j2 < this.zaw || j2 > this.zax) {
                                this.zaw = j2;
                                this.zay = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(talkerUserName2);
                                if (z) {
                                    this.zax = this.zay;
                                } else {
                                    C9638aw.m17190ZK();
                                    this.zax = C18628c.m29080XO().mo15335g(talkerUserName2, j2, 48);
                                }
                                C9638aw.m17190ZK();
                                C4990ab.m7419v("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reset position, reload count %d", Integer.valueOf(C18628c.m29080XO().mo15350s(talkerUserName2, this.zaw, this.zax)));
                                if (C18628c.m29080XO().mo15350s(talkerUserName2, this.zaw, this.zax) < 48) {
                                    C4990ab.m7411d("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.zaw), Integer.valueOf(0));
                                    C9638aw.m17190ZK();
                                    this.zaw = C18628c.m29080XO().mo15330f(talkerUserName2, this.zaw, 48);
                                    C9638aw.m17190ZK();
                                    i = C18628c.m29080XO().mo15350s(talkerUserName2, this.zaw, j2);
                                } else {
                                    i = 0;
                                }
                            } else {
                                C9638aw.m17190ZK();
                                i = C18628c.m29080XO().mo15350s(talkerUserName2, this.zaw, j2);
                            }
                            c40752d.selection = i;
                            c30549e2 = new C40800d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                            break;
                        }
                        C4990ab.m7421w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "get msg info by id %d error", Long.valueOf(j));
                        c30549e2 = new C40800d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[handleEnter] sourceArgs is null!");
                    c30549e2 = new C40800d(this.cgL.getTalkerUserName(), this.zaw, this.zax);
                    break;
                }
                C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "null == sourceArgs!");
                AppMethodBeat.m2505o(32731);
                return null;
                break;
        }
        this.zam = Rp;
        AppMethodBeat.m2505o(32731);
        return c30549e2;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo10969a(MMChattingListView mMChattingListView, C40752d<C7620bi> c40752d) {
        int i;
        AppMethodBeat.m2504i(32732);
        super.mo10969a(mMChattingListView, c40752d);
        C40749a c40749a = c40752d.yYA;
        SparseArray sparseArray = c40752d.yYD;
        int size = c40752d.yYB.size();
        int i2 = c40752d.enb;
        int i3 = c40752d.selection;
        final Bundle bundle = c40752d.yYz;
        C7620bi c7620bi = (C7620bi) sparseArray.get(0);
        C7620bi c7620bi2 = (C7620bi) sparseArray.get(sparseArray.size() - 1);
        if (c7620bi != null) {
            this.zaw = c7620bi.field_createTime;
        }
        if (c7620bi2 != null) {
            this.zax = c7620bi2.field_createTime;
        }
        switch (c40749a) {
            case ACTION_ENTER:
                this.cgL.mo74882qp(false);
                i = i3;
                break;
            case ACTION_TOP:
                mMChattingListView.mo10809qc(false);
                C35897k.m58842a(mMChattingListView.getListView(), (mMChattingListView.getCurCount() - mMChattingListView.getPreCount()) + 1, dHg() + mMChattingListView.getTopHeight(), false);
                int curCount = mMChattingListView.getCurCount() - mMChattingListView.getPreCount();
                if (curCount > 0) {
                    ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27800Ow(curCount);
                    i = i3;
                    break;
                }
            case ACTION_POSITION:
                i = Math.max(0, mMChattingListView.getCurCount() - (c40752d.enb - bundle.getInt("MSG_POSITION")));
                c40752d.selection = i;
                mMChattingListView.getListView().post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(32729);
                        C15612h c15612h = (C15612h) C46662d.this.cgL.mo74857aF(C15612h.class);
                        if (bundle.getInt("SCENE", 0) == 1) {
                            C46662d.this.mo31086Pj(i);
                            AppMethodBeat.m2505o(32729);
                            return;
                        }
                        if (bundle.getInt("SCENE", 0) == 2) {
                            c15612h.mo27799Ov(i);
                            C46662d.this.cgL.mo74861bY(i);
                        }
                        AppMethodBeat.m2505o(32729);
                    }
                });
                break;
            case ACTION_BOTTOM:
                mMChattingListView.mo10810qd(false);
                C35897k.m58842a(mMChattingListView.getListView(), mMChattingListView.getPreCount() + 1, mMChattingListView.getListView().getHeight() - dHg(), false);
                i = i3;
                break;
            default:
                i = i3;
                break;
        }
        if (c40749a != C40749a.ACTION_ENTER) {
            boolean z;
            C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[onViewUpdate] mode:%s lastTopMsgCreateTime:%s lastBottomMsgCreateTime:%s loadedCount:%s allCount:%s selection:%s", c40749a, Long.valueOf(this.zaw), Long.valueOf(this.zax), Integer.valueOf(size), Integer.valueOf(i2), Integer.valueOf(i));
            String talkerUserName = this.cgL.getTalkerUserName();
            long QQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(talkerUserName);
            C9638aw.m17190ZK();
            C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingNormalDataPresenter", "[isShowTopAll] talker:%s createTime:%s expiredCount:%s", talkerUserName, Long.valueOf(QQ), Integer.valueOf(C18628c.m29080XO().mo15350s(talkerUserName, 0, QQ)));
            if (i2 - C18628c.m29080XO().mo15350s(talkerUserName, 0, QQ) <= size) {
                z = true;
            } else {
                z = false;
            }
            mMChattingListView.setIsTopShowAll(z);
            mMChattingListView.setIsBottomShowAll(true);
        }
        AppMethodBeat.m2505o(32732);
    }

    private int dHg() {
        AppMethodBeat.m2504i(32733);
        int dEx = ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEx();
        AppMethodBeat.m2505o(32733);
        return dEx;
    }
}
