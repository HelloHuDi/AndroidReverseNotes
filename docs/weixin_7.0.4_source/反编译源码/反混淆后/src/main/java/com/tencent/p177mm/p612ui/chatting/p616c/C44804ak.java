package com.tencent.p177mm.p612ui.chatting.p616c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23729ac;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46643s;
import com.tencent.p177mm.plugin.chatroom.p721a.C33810a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7310be;
import com.tencent.p177mm.storage.C7310be.C5132a;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;

@C15590a(dFp = C23729ac.class)
@Deprecated
/* renamed from: com.tencent.mm.ui.chatting.c.ak */
public final class C44804ak extends C44291a implements C5132a, C23729ac {
    public static int yRY = 350;
    public boolean yRZ;
    public boolean ySa;
    public boolean ySb;
    private C4884c ySc;
    private boolean ySd;

    /* renamed from: a */
    public final void mo10531a(C7617ak c7617ak, C7310be c7310be) {
        AppMethodBeat.m2504i(31715);
        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", c7617ak.field_username, Long.valueOf(Thread.currentThread().getId()));
        if (this.cgL.caA) {
            if (this.cgL.dFx() && this.cgL.sRl.field_username.equals(c7617ak.field_username)) {
                final C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
                int i = c7617ak.field_msgCount;
                int dCP = c15612h.dCP();
                C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(dCP), Boolean.valueOf(this.yRZ), Integer.valueOf(c7617ak.field_UnDeliverCount));
                if (i > dCP) {
                    C7620bi c7620bi = c7617ak.xXq;
                    if (c7620bi == null || c7620bi.field_msgId == 0) {
                        AppMethodBeat.m2505o(31715);
                        return;
                    }
                    if (i - dCP > 1) {
                        this.ySd = true;
                    }
                    int i2 = c7620bi.field_flag;
                    C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(c7620bi.field_msgSvrId), Long.valueOf(c7620bi.field_msgSeq), Integer.valueOf(i2), C5046bo.dpG());
                    int lastVisiblePosition;
                    if ((i2 & 2) == 0) {
                        AppMethodBeat.m2505o(31715);
                        return;
                    } else if (this.cgL.getListView() == null || c15612h == null || this.cgL.yTz == null) {
                        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", this.cgL.getListView(), c15612h, this.cgL.yTz);
                        AppMethodBeat.m2505o(31715);
                        return;
                    } else if ((i2 & 4) == 0) {
                        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", Boolean.valueOf(this.yRZ));
                        if (this.yRZ) {
                            C4990ab.m7416i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                            AppMethodBeat.m2505o(31715);
                            return;
                        }
                        final int firstVisiblePosition = this.cgL.getFirstVisiblePosition();
                        int i3 = i - dCP;
                        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.cgL.sRl.field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(dCP), Integer.valueOf(i3), Integer.valueOf(lastVisiblePosition), Integer.valueOf(c15612h.getCount()), Integer.valueOf(c15612h.getCount() - c15612h.getCount()), Integer.valueOf(0), Boolean.valueOf(this.ySa));
                        if (c15612h.getCount() - c15612h.getCount() > 1) {
                            View view;
                            ListView listView = this.cgL.getListView();
                            dCP = listView.getFirstVisiblePosition();
                            i2 = (listView.getChildCount() + dCP) - 1;
                            if (firstVisiblePosition < dCP || firstVisiblePosition > i2) {
                                view = listView.getAdapter().getView(firstVisiblePosition, null, listView);
                            } else {
                                view = listView.getChildAt(firstVisiblePosition - dCP);
                            }
                            i2 = (view == null ? 0 : view.getTop()) - this.cgL.yTz.getBottomHeight();
                            this.cgL.getListView().setAdapter(this.cgL.getListView().getAdapter());
                            this.cgL.mo74881ho(firstVisiblePosition, i2);
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", Integer.valueOf(firstVisiblePosition), view, Integer.valueOf(i), Integer.valueOf(i2));
                            this.cgL.getListView().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(31711);
                                    C44804ak.this.cgL.mo74881ho(firstVisiblePosition, i2);
                                    C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", Integer.valueOf(C44804ak.this.cgL.getFirstVisiblePosition()), Integer.valueOf(C44804ak.this.cgL.getLastVisiblePosition()), Integer.valueOf(c15612h.getCount()));
                                    AppMethodBeat.m2505o(31711);
                                }
                            });
                            this.cgL.getListView().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(31712);
                                    C44804ak.this.cgL.mo74881ho(firstVisiblePosition, i2);
                                    C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", Integer.valueOf(C44804ak.this.cgL.getFirstVisiblePosition()), Integer.valueOf(C44804ak.this.cgL.getLastVisiblePosition()), Integer.valueOf(c15612h.getCount()));
                                    AppMethodBeat.m2505o(31712);
                                }
                            }, 200);
                        }
                        AppMethodBeat.m2505o(31715);
                        return;
                    } else {
                        i2 = this.cgL.getFirstVisiblePosition();
                        lastVisiblePosition = this.cgL.getLastVisiblePosition();
                        C7620bi Ou = c15612h.mo27798Ou(i2);
                        C7620bi Ou2 = c15612h.mo27798Ou(lastVisiblePosition);
                        int i4 = i - dCP;
                        final int count = c15612h.getCount() - c15612h.getCount();
                        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", this.cgL.sRl.field_username, Integer.valueOf(i), Integer.valueOf(dCP), Integer.valueOf(i4), Integer.valueOf(c15612h.getCount()), Integer.valueOf(c15612h.getCount()), Integer.valueOf(count), Integer.valueOf(0), Boolean.valueOf(this.ySa));
                        if (Ou2 != null && Ou2.field_msgId != 0 && Ou2.field_createTime < c7620bi.field_createTime) {
                            C4990ab.m7416i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
                        } else if (count > 0) {
                            long j;
                            c15612h.mo27800Ow(count);
                            String str = "MicroMsg.ChattingUI.SilenceMsgComponent";
                            String str2 = "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]";
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(i2);
                            objArr[1] = Integer.valueOf(lastVisiblePosition);
                            if (Ou == null) {
                                j = -1;
                            } else {
                                j = Ou.field_createTime;
                            }
                            objArr[2] = Long.valueOf(j);
                            if (Ou2 == null) {
                                j = -1;
                            } else {
                                j = Ou2.field_createTime;
                            }
                            objArr[3] = Long.valueOf(j);
                            objArr[4] = Long.valueOf(c7620bi.field_createTime);
                            C4990ab.m7417i(str, str2, objArr);
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", Integer.valueOf(count), Integer.valueOf(count + 1), Integer.valueOf(i2));
                            this.cgL.mo74881ho(count + 1, ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEx() + this.cgL.yTz.getTopHeight());
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(31713);
                                    C44804ak.this.cgL.mo74881ho(count + 1, ((C44299r) C44804ak.this.cgL.mo74857aF(C44299r.class)).dEx() + C44804ak.this.cgL.yTz.getTopHeight());
                                    AppMethodBeat.m2505o(31713);
                                }
                            });
                        } else {
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i4), Integer.valueOf(count), Integer.valueOf(0));
                        }
                        this.cgL.yTz.dCB();
                        if (c7617ak.field_UnDeliverCount <= 0) {
                            ((C46643s) this.cgL.mo74857aF(C46643s.class)).dEz();
                        }
                        if (this.ySa) {
                            this.ySa = false;
                            this.cgL.yTz.setIsBottomShowAll(false);
                            this.cgL.yTz.setBottomViewVisible(((C23733z) this.cgL.mo74857aF(C23733z.class)).dES());
                            this.cgL.yTz.mo56981qd(false);
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.ySa));
                            final C7617ak c7617ak2 = c7617ak;
                            C46650a.dFz().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(31714);
                                    C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(c7617ak2.field_UnDeliverCount), Integer.valueOf(c7617ak2.field_unReadCount));
                                    AppMethodBeat.m2505o(31714);
                                }
                            }, 500);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(31715);
            return;
        }
        C4990ab.m7420w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
        AppMethodBeat.m2505o(31715);
    }

    /* renamed from: bk */
    public final void mo72004bk(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31716);
        if (!(c7620bi == null || c7620bi.field_msgId == 0)) {
            long j;
            int i;
            long j2 = c7620bi.field_msgSeq;
            boolean z = (c7620bi.field_flag & 4) != 0;
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(this.cgL.sRl.field_username);
            if (aoZ != null) {
                if (z) {
                    j = aoZ.field_firstUnDeliverSeq;
                } else {
                    j = aoZ.field_lastSeq;
                }
                if (z && j == 0) {
                    i = aoZ.field_UnDeliverCount;
                } else {
                    i = 0;
                }
                if (z && j > j2) {
                    C7620bi ae = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15299ae(this.cgL.sRl.field_username, j2);
                    if (ae != null && ae.field_msgSeq < j2) {
                        C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", Long.valueOf(j), Long.valueOf(ae.field_msgSeq));
                        j = ae.field_msgSeq;
                    }
                }
            } else {
                i = 0;
                j = 0;
            }
            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(c7620bi.field_flag), Boolean.valueOf(z));
            this.yRZ = false;
            C33810a c33810a = new C33810a(this.cgL.sRl.field_username, (int) j, (int) j2, i, z ? 1 : 0);
        }
        AppMethodBeat.m2505o(31716);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(31717);
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            try {
                View childAt = this.cgL.getChildAt(this.cgL.getFirstVisiblePosition());
                C7620bi Ou;
                if (childAt != null && childAt.getTop() == 0) {
                    C4990ab.m7416i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.cgL.dFx()) {
                        Ou = ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27798Ou(0);
                        if (!(Ou == null || Ou.field_msgId == 0)) {
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(Ou.field_flag), Integer.valueOf(Ou.field_isSend), Long.valueOf(Ou.field_msgId), Long.valueOf(Ou.field_msgSvrId), Long.valueOf(Ou.field_msgSeq), Long.valueOf(Ou.field_createTime), Integer.valueOf(Ou.getType()), Ou.field_talker);
                            if (!((Ou.field_flag & 1) == 0 || (Ou.field_flag & 4) == 0)) {
                                this.cgL.yTz.dCA();
                            }
                        }
                        AppMethodBeat.m2505o(31717);
                        return;
                    }
                } else if (this.cgL.dFx() && this.cgL.getChildAt(this.cgL.getListView().getChildCount() - 1) != null) {
                    C15612h c15612h = (C15612h) this.cgL.mo74857aF(C15612h.class);
                    if (this.cgL.getLastVisiblePosition() == this.cgL.getListView().getAdapter().getCount() - 1) {
                        C6575cy c6575cy;
                        C6575cy c6575cy2 = null;
                        for (int i2 = 1; i2 < 5; i2++) {
                            c6575cy2 = ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27798Ou(c15612h.getCount() - i2);
                            if (c6575cy2 != null && c6575cy2.field_msgId != 0 && (c6575cy2.field_flag & 1) != 0) {
                                C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", Integer.valueOf(i2));
                                c6575cy = c6575cy2;
                                break;
                            }
                        }
                        c6575cy = c6575cy2;
                        if (c6575cy == null || c6575cy.field_msgId == 0) {
                            int i3;
                            if (c6575cy != null) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            if ((((c6575cy.field_flag & 2) != 0 ? 1 : 0) & i3) != 0) {
                                C9638aw.m17190ZK();
                                Ou = C18628c.m29080XO().mo15248Rb(c6575cy.field_talker);
                                if (!(Ou == null || Ou.field_msgId == 0 || Ou.field_createTime <= c6575cy.field_createTime)) {
                                    C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", Integer.valueOf(Ou.field_flag), Integer.valueOf(Ou.field_isSend), Long.valueOf(Ou.field_msgId), Long.valueOf(Ou.field_msgSvrId), Long.valueOf(Ou.field_msgSeq), Long.valueOf(Ou.field_createTime), Integer.valueOf(Ou.getType()), Ou.field_talker);
                                }
                            }
                        } else {
                            Ou = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15246R(c6575cy.field_talker, c6575cy.field_msgSeq);
                            if (Ou.field_msgId != 0 && Ou.field_msgId == c6575cy.field_msgId && (Ou.field_flag & 1) == 0) {
                                C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", Long.valueOf(Ou.field_msgId), Integer.valueOf(Ou.field_flag));
                                AppMethodBeat.m2505o(31717);
                                return;
                            }
                            C4990ab.m7417i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(c6575cy.field_flag), Integer.valueOf(c6575cy.field_isSend), Long.valueOf(c6575cy.field_msgId), Long.valueOf(c6575cy.field_msgSvrId), Long.valueOf(c6575cy.field_msgSeq), Long.valueOf(c6575cy.field_createTime), Integer.valueOf(c6575cy.getType()), c6575cy.field_talker);
                            if ((c6575cy.field_flag & 1) == 0 || (c6575cy.field_flag & 4) != 0) {
                                AppMethodBeat.m2505o(31717);
                                return;
                            }
                            C4990ab.m7416i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
                            this.cgL.yTz.setIsBottomShowAll(false);
                            this.cgL.yTz.setBottomViewVisible(true);
                            this.cgL.yTz.mo56981qd(true);
                            C4990ab.m7416i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
                            C9638aw.m17180RS().mo10302aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(31710);
                                    C7053e.pXa.mo8378a(403, 7, 1, false);
                                    C44804ak.this.mo72004bk(c6575cy);
                                    AppMethodBeat.m2505o(31710);
                                }
                            });
                            AppMethodBeat.m2505o(31717);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", e, "silenceMsgImp handleIdelScrollChange", new Object[0]);
                AppMethodBeat.m2505o(31717);
                return;
            }
        }
        AppMethodBeat.m2505o(31717);
    }

    public final void dxB() {
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31718);
        this.yRZ = false;
        this.ySb = this.cgL.dFx();
        this.yRZ = false;
        this.ySa = false;
        AppMethodBeat.m2505o(31718);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31719);
        C4879a.xxA.mo10053d(this.ySc);
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo15803b(this);
        AppMethodBeat.m2505o(31719);
    }
}
