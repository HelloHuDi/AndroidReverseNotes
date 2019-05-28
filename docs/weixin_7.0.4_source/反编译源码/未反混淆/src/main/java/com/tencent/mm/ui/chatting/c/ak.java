package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ac;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.mm.ui.chatting.c.b.z;

@a(dFp = ac.class)
@Deprecated
public final class ak extends a implements be.a, ac {
    public static int yRY = 350;
    public boolean yRZ;
    public boolean ySa;
    public boolean ySb;
    private c ySc;
    private boolean ySd;

    public final void a(com.tencent.mm.storage.ak akVar, be beVar) {
        AppMethodBeat.i(31715);
        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", akVar.field_username, Long.valueOf(Thread.currentThread().getId()));
        if (this.cgL.caA) {
            if (this.cgL.dFx() && this.cgL.sRl.field_username.equals(akVar.field_username)) {
                final h hVar = (h) this.cgL.aF(h.class);
                int i = akVar.field_msgCount;
                int dCP = hVar.dCP();
                ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(dCP), Boolean.valueOf(this.yRZ), Integer.valueOf(akVar.field_UnDeliverCount));
                if (i > dCP) {
                    bi biVar = akVar.xXq;
                    if (biVar == null || biVar.field_msgId == 0) {
                        AppMethodBeat.o(31715);
                        return;
                    }
                    if (i - dCP > 1) {
                        this.ySd = true;
                    }
                    int i2 = biVar.field_flag;
                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(biVar.field_msgSvrId), Long.valueOf(biVar.field_msgSeq), Integer.valueOf(i2), bo.dpG());
                    int lastVisiblePosition;
                    if ((i2 & 2) == 0) {
                        AppMethodBeat.o(31715);
                        return;
                    } else if (this.cgL.getListView() == null || hVar == null || this.cgL.yTz == null) {
                        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr something is null %s %s %s", this.cgL.getListView(), hVar, this.cgL.yTz);
                        AppMethodBeat.o(31715);
                        return;
                    } else if ((i2 & 4) == 0) {
                        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", Boolean.valueOf(this.yRZ));
                        if (this.yRZ) {
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                            AppMethodBeat.o(31715);
                            return;
                        }
                        final int firstVisiblePosition = this.cgL.getFirstVisiblePosition();
                        int i3 = i - dCP;
                        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.cgL.sRl.field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(dCP), Integer.valueOf(i3), Integer.valueOf(lastVisiblePosition), Integer.valueOf(hVar.getCount()), Integer.valueOf(hVar.getCount() - hVar.getCount()), Integer.valueOf(0), Boolean.valueOf(this.ySa));
                        if (hVar.getCount() - hVar.getCount() > 1) {
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
                            this.cgL.ho(firstVisiblePosition, i2);
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", Integer.valueOf(firstVisiblePosition), view, Integer.valueOf(i), Integer.valueOf(i2));
                            this.cgL.getListView().post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(31711);
                                    ak.this.cgL.ho(firstVisiblePosition, i2);
                                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 111 %s %s %s", Integer.valueOf(ak.this.cgL.getFirstVisiblePosition()), Integer.valueOf(ak.this.cgL.getLastVisiblePosition()), Integer.valueOf(hVar.getCount()));
                                    AppMethodBeat.o(31711);
                                }
                            });
                            this.cgL.getListView().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(31712);
                                    ak.this.cgL.ho(firstVisiblePosition, i2);
                                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr firstVisiblePosition 222 %s %s %s", Integer.valueOf(ak.this.cgL.getFirstVisiblePosition()), Integer.valueOf(ak.this.cgL.getLastVisiblePosition()), Integer.valueOf(hVar.getCount()));
                                    AppMethodBeat.o(31712);
                                }
                            }, 200);
                        }
                        AppMethodBeat.o(31715);
                        return;
                    } else {
                        i2 = this.cgL.getFirstVisiblePosition();
                        lastVisiblePosition = this.cgL.getLastVisiblePosition();
                        bi Ou = hVar.Ou(i2);
                        bi Ou2 = hVar.Ou(lastVisiblePosition);
                        int i4 = i - dCP;
                        final int count = hVar.getCount() - hVar.getCount();
                        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", this.cgL.sRl.field_username, Integer.valueOf(i), Integer.valueOf(dCP), Integer.valueOf(i4), Integer.valueOf(hVar.getCount()), Integer.valueOf(hVar.getCount()), Integer.valueOf(count), Integer.valueOf(0), Boolean.valueOf(this.ySa));
                        if (Ou2 != null && Ou2.field_msgId != 0 && Ou2.field_createTime < biVar.field_createTime) {
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
                        } else if (count > 0) {
                            long j;
                            hVar.Ow(count);
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
                            objArr[4] = Long.valueOf(biVar.field_createTime);
                            ab.i(str, str2, objArr);
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", Integer.valueOf(count), Integer.valueOf(count + 1), Integer.valueOf(i2));
                            this.cgL.ho(count + 1, ((r) this.cgL.aF(r.class)).dEx() + this.cgL.yTz.getTopHeight());
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(31713);
                                    ak.this.cgL.ho(count + 1, ((r) ak.this.cgL.aF(r.class)).dEx() + ak.this.cgL.yTz.getTopHeight());
                                    AppMethodBeat.o(31713);
                                }
                            });
                        } else {
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i4), Integer.valueOf(count), Integer.valueOf(0));
                        }
                        this.cgL.yTz.dCB();
                        if (akVar.field_UnDeliverCount <= 0) {
                            ((s) this.cgL.aF(s.class)).dEz();
                        }
                        if (this.ySa) {
                            this.ySa = false;
                            this.cgL.yTz.setIsBottomShowAll(false);
                            this.cgL.yTz.setBottomViewVisible(((z) this.cgL.aF(z.class)).dES());
                            this.cgL.yTz.qd(false);
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.ySa));
                            final com.tencent.mm.storage.ak akVar2 = akVar;
                            com.tencent.mm.ui.chatting.d.a.dFz().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(31714);
                                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr onMsgChangeNotify updateGoBackToHistoryMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(akVar2.field_UnDeliverCount), Integer.valueOf(akVar2.field_unReadCount));
                                    AppMethodBeat.o(31714);
                                }
                            }, 500);
                        }
                    }
                }
            }
            AppMethodBeat.o(31715);
            return;
        }
        ab.w("MicroMsg.ChattingUI.SilenceMsgComponent", "[onMsgChangeNotify] ChattingUI is not in Foreground!!");
        AppMethodBeat.o(31715);
    }

    public final void bk(bi biVar) {
        AppMethodBeat.i(31716);
        if (!(biVar == null || biVar.field_msgId == 0)) {
            long j;
            int i;
            long j2 = biVar.field_msgSeq;
            boolean z = (biVar.field_flag & 4) != 0;
            aw.ZK();
            com.tencent.mm.storage.ak aoZ = com.tencent.mm.model.c.XR().aoZ(this.cgL.sRl.field_username);
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
                    bi ae = ((j) g.K(j.class)).bOr().ae(this.cgL.sRl.field_username, j2);
                    if (ae != null && ae.field_msgSeq < j2) {
                        ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", Long.valueOf(j), Long.valueOf(ae.field_msgSeq));
                        j = ae.field_msgSeq;
                    }
                }
            } else {
                i = 0;
                j = 0;
            }
            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(biVar.field_flag), Boolean.valueOf(z));
            this.yRZ = false;
            com.tencent.mm.plugin.chatroom.a.a aVar = new com.tencent.mm.plugin.chatroom.a.a(this.cgL.sRl.field_username, (int) j, (int) j2, i, z ? 1 : 0);
        }
        AppMethodBeat.o(31716);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(31717);
        super.onScrollStateChanged(absListView, i);
        if (i == 0) {
            try {
                View childAt = this.cgL.getChildAt(this.cgL.getFirstVisiblePosition());
                bi Ou;
                if (childAt != null && childAt.getTop() == 0) {
                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.cgL.dFx()) {
                        Ou = ((h) this.cgL.aF(h.class)).Ou(0);
                        if (!(Ou == null || Ou.field_msgId == 0)) {
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(Ou.field_flag), Integer.valueOf(Ou.field_isSend), Long.valueOf(Ou.field_msgId), Long.valueOf(Ou.field_msgSvrId), Long.valueOf(Ou.field_msgSeq), Long.valueOf(Ou.field_createTime), Integer.valueOf(Ou.getType()), Ou.field_talker);
                            if (!((Ou.field_flag & 1) == 0 || (Ou.field_flag & 4) == 0)) {
                                this.cgL.yTz.dCA();
                            }
                        }
                        AppMethodBeat.o(31717);
                        return;
                    }
                } else if (this.cgL.dFx() && this.cgL.getChildAt(this.cgL.getListView().getChildCount() - 1) != null) {
                    h hVar = (h) this.cgL.aF(h.class);
                    if (this.cgL.getLastVisiblePosition() == this.cgL.getListView().getAdapter().getCount() - 1) {
                        cy cyVar;
                        cy cyVar2 = null;
                        for (int i2 = 1; i2 < 5; i2++) {
                            cyVar2 = ((h) this.cgL.aF(h.class)).Ou(hVar.getCount() - i2);
                            if (cyVar2 != null && cyVar2.field_msgId != 0 && (cyVar2.field_flag & 1) != 0) {
                                ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found i[%s]", Integer.valueOf(i2));
                                cyVar = cyVar2;
                                break;
                            }
                        }
                        cyVar = cyVar2;
                        if (cyVar == null || cyVar.field_msgId == 0) {
                            int i3;
                            if (cyVar != null) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            if ((((cyVar.field_flag & 2) != 0 ? 1 : 0) & i3) != 0) {
                                aw.ZK();
                                Ou = com.tencent.mm.model.c.XO().Rb(cyVar.field_talker);
                                if (!(Ou == null || Ou.field_msgId == 0 || Ou.field_createTime <= cyVar.field_createTime)) {
                                    ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s] not need notify", Integer.valueOf(Ou.field_flag), Integer.valueOf(Ou.field_isSend), Long.valueOf(Ou.field_msgId), Long.valueOf(Ou.field_msgSvrId), Long.valueOf(Ou.field_msgSeq), Long.valueOf(Ou.field_createTime), Integer.valueOf(Ou.getType()), Ou.field_talker);
                                }
                            }
                        } else {
                            Ou = ((j) g.K(j.class)).bOr().R(cyVar.field_talker, cyVar.field_msgSeq);
                            if (Ou.field_msgId != 0 && Ou.field_msgId == cyVar.field_msgId && (Ou.field_flag & 1) == 0) {
                                ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange found msg not fault msgId[%s] flag[%s]", Long.valueOf(Ou.field_msgId), Integer.valueOf(Ou.field_flag));
                                AppMethodBeat.o(31717);
                                return;
                            }
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(cyVar.field_flag), Integer.valueOf(cyVar.field_isSend), Long.valueOf(cyVar.field_msgId), Long.valueOf(cyVar.field_msgSvrId), Long.valueOf(cyVar.field_msgSeq), Long.valueOf(cyVar.field_createTime), Integer.valueOf(cyVar.getType()), cyVar.field_talker);
                            if ((cyVar.field_flag & 1) == 0 || (cyVar.field_flag & 4) != 0) {
                                AppMethodBeat.o(31717);
                                return;
                            }
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange forceBottomLoadData");
                            this.cgL.yTz.setIsBottomShowAll(false);
                            this.cgL.yTz.setBottomViewVisible(true);
                            this.cgL.yTz.qd(true);
                            ab.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr handleScrollChange bottom check fault found");
                            aw.RS().aa(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(31710);
                                    e.pXa.a(403, 7, 1, false);
                                    ak.this.bk(cyVar);
                                    AppMethodBeat.o(31710);
                                }
                            });
                            AppMethodBeat.o(31717);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", e, "silenceMsgImp handleIdelScrollChange", new Object[0]);
                AppMethodBeat.o(31717);
                return;
            }
        }
        AppMethodBeat.o(31717);
    }

    public final void dxB() {
    }

    public final void dxx() {
        AppMethodBeat.i(31718);
        this.yRZ = false;
        this.ySb = this.cgL.dFx();
        this.yRZ = false;
        this.ySa = false;
        AppMethodBeat.o(31718);
    }

    public final void dxC() {
        AppMethodBeat.i(31719);
        com.tencent.mm.sdk.b.a.xxA.d(this.ySc);
        aw.ZK();
        com.tencent.mm.model.c.XR().b(this);
        AppMethodBeat.o(31719);
    }
}
