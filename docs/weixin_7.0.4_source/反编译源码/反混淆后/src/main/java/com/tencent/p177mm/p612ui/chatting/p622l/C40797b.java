package com.tencent.p177mm.p612ui.chatting.p622l;

import android.database.Cursor;
import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p189aq.C6320b.C6323b;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40750b;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6973b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7578w;
import com.tencent.p177mm.storage.C7620bi;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.l.b */
public final class C40797b implements C30549e<C7620bi> {
    /* renamed from: PI */
    Cursor f16212PI;
    String emo;
    private boolean ooX;
    private C40749a yZP;
    long yZQ;
    long yZR;
    private long yZS;
    int yZT;
    private Bundle yZU;
    private C40752d yZV;

    public C40797b(String str, C40749a c40749a, Bundle bundle, long j, long j2, long j3, int i, C40752d c40752d, boolean z) {
        AppMethodBeat.m2504i(32693);
        this.yZS = j;
        this.yZQ = j2;
        this.yZR = j3;
        this.yZT = i;
        this.emo = str;
        this.yZP = c40749a;
        this.yZU = bundle;
        this.yZV = c40752d;
        this.ooX = z;
        C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.yZQ + " mLastBottomCreateTime:" + this.yZR + " isFromSearch:" + z + " mLastCount:" + this.yZT + " mLastBottomMsgSeq:" + this.yZS + " mTalker:" + this.emo + " action:" + c40749a);
        AppMethodBeat.m2505o(32693);
    }

    /* renamed from: a */
    public final void mo48956a(C40750b c40750b) {
        AppMethodBeat.m2504i(32694);
        long j;
        long j2;
        int s;
        long j3;
        long j4;
        switch (this.yZP) {
            case ACTION_ENTER:
                m70687b(c40750b);
                AppMethodBeat.m2505o(32694);
                return;
            case ACTION_BOTTOM:
                final C40750b c40750b2;
                C7578w QN;
                if (this.yZU == null || !this.yZU.getBoolean("load_bottom", false)) {
                    C6973b bOm = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                    C6594c f = bOm.mo15225f(this.emo, this.yZR, true);
                    if (f != null) {
                        c40750b2 = c40750b;
                        C6320b.agG().mo14566a(this.emo, f.eoC, f.eoD, 0, new C6323b() {
                            /* renamed from: b */
                            public final void mo4575b(int i, List<C7620bi> list) {
                                AppMethodBeat.m2504i(32689);
                                if (i < 0 || list.size() <= 0) {
                                    C40797b.this.mo64343d(c40750b2);
                                    AppMethodBeat.m2505o(32689);
                                    return;
                                }
                                long j = C40797b.this.yZQ;
                                C7620bi c7620bi = (C7620bi) list.get(list.size() - 1);
                                long ns = C40797b.this.mo64346ns(c7620bi.field_createTime);
                                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + C40797b.this.emo + " from:" + j + " to:" + ns + " addMsg.CreateTime:" + c7620bi.field_createTime);
                                C40797b.this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(C40797b.this.emo, j, ns, BaseClientBuilder.API_PRIORITY_OTHER);
                                c40750b2.mo15847dY();
                                AppMethodBeat.m2505o(32689);
                            }
                        });
                        AppMethodBeat.m2505o(32694);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.emo + " mLastBottomCreateTime:" + this.yZR);
                    QN = bOm.mo15218QN(this.emo);
                    c40750b2 = c40750b;
                    C6320b.agG().mo14566a(this.emo, 1 + QN.field_lastLocalSeq, QN.field_lastPushSeq, 0, new C6323b() {
                        /* renamed from: b */
                        public final void mo4575b(int i, List<C7620bi> list) {
                            AppMethodBeat.m2504i(32690);
                            if (i < 0 || list.size() <= 0) {
                                C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(i)));
                                C40797b.this.mo64343d(c40750b2);
                                AppMethodBeat.m2505o(32690);
                                return;
                            }
                            long j = C40797b.this.yZQ;
                            long ns = C40797b.this.mo64346ns(((C7620bi) list.get(list.size() - 1)).field_createTime);
                            C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + C40797b.this.emo + " from:" + j + " to:" + ns + " size:" + list.size());
                            C40797b.this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(C40797b.this.emo, j, ns, BaseClientBuilder.API_PRIORITY_OTHER);
                            c40750b2.mo15847dY();
                            AppMethodBeat.m2505o(32690);
                        }
                    });
                    AppMethodBeat.m2505o(32694);
                    return;
                }
                QN = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15218QN(this.emo);
                c40750b2 = c40750b;
                C6320b.agG().mo14566a(this.emo, QN.field_lastPushSeq, 1 + QN.field_lastLocalSeq, 1, new C6323b() {
                    /* renamed from: b */
                    public final void mo4575b(int i, List<C7620bi> list) {
                        AppMethodBeat.m2504i(32688);
                        if (i < 0 || list.size() <= 0) {
                            C40797b.this.mo64343d(c40750b2);
                            AppMethodBeat.m2505o(32688);
                            return;
                        }
                        long dHc = C40797b.this.dHc();
                        long dHf = C40797b.this.dHf();
                        C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + C40797b.this.emo + " from:" + dHc + " to:" + dHf);
                        C40797b.this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(C40797b.this.emo, dHc, dHf, 18);
                        c40750b2.mo15847dY();
                        AppMethodBeat.m2505o(32688);
                    }
                });
                AppMethodBeat.m2505o(32694);
                return;
            case ACTION_TOP:
                C6973b bOm2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                C6594c M = bOm2.mo15209M(this.emo, this.yZQ);
                j = M == null ? 0 : M.eoF;
                j2 = this.yZQ;
                s = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15350s(this.emo, j, j2);
                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.emo + " from:" + j + " to:" + j2 + " count:" + s + " seqBlock is null? " + (M == null));
                if (s >= 18 || M == null) {
                    j2 = this.yZR;
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.emo + " from:" + j + " to:" + j2 + " count:" + (this.yZT + 18));
                    this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, j, j2, this.yZT + 18);
                    c40750b.mo15847dY();
                    AppMethodBeat.m2505o(32694);
                    return;
                }
                if (M != null) {
                    j3 = M.eoD;
                    j4 = M.eoC;
                    final long j5 = M.eoF;
                    j = M.eoE;
                    final C6973b c6973b = bOm2;
                    final C40750b c40750b3 = c40750b;
                    C6320b.agG().mo14566a(this.emo, j3, j4, 1, (C6323b) new C6323b() {
                        /* renamed from: b */
                        public final void mo4575b(int i, List<C7620bi> list) {
                            AppMethodBeat.m2504i(32691);
                            if (i >= 0) {
                                long j;
                                long j2 = j;
                                if (list.size() > 0) {
                                    j = ((C7620bi) list.get(0)).field_createTime;
                                } else {
                                    j = j2;
                                }
                                if (c6973b.mo15209M(C40797b.this.emo, j) == null && list.size() < 18) {
                                    j = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15330f(C40797b.this.emo, j, 18 - list.size());
                                }
                                if (j <= 0) {
                                    j = j;
                                }
                                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + C40797b.this.emo + " firstCreateTime:" + j + " lastCreateTime:" + j5 + " from:" + j);
                                C40797b.this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(C40797b.this.emo, j, C40797b.this.yZR, C40797b.this.yZT + 18);
                                c40750b3.mo15847dY();
                                AppMethodBeat.m2505o(32691);
                                return;
                            }
                            C40797b.this.mo64343d(c40750b3);
                            AppMethodBeat.m2505o(32691);
                        }
                    });
                }
                AppMethodBeat.m2505o(32694);
                return;
            case ACTION_UPDATE:
                m70688c(c40750b);
                AppMethodBeat.m2505o(32694);
                return;
            case ACTION_POSITION:
                if (!this.ooX) {
                    C6973b bOm3 = ((C6982j) C1720g.m3528K(C6982j.class)).bOm();
                    String str = "MicroMsg.ChattingLoader.ChattingGetDataSource";
                    String str2 = "null == mSourceArgs?%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.yZU == null);
                    C4990ab.m7417i(str, str2, objArr);
                    s = this.yZU == null ? 0 : this.yZU.getInt("MSG_POSITION_UNREAD_COUNT");
                    if (s <= 0) {
                        C6594c QM = bOm3.mo15217QM(this.emo);
                        if (QM != null) {
                            j3 = QM.eoC;
                            j = QM.eoE;
                            j4 = QM.eoD;
                            j2 = QM.eoF;
                            final C40750b c40750b4 = c40750b;
                            C6320b.agG().mo14566a(this.emo, j3, j4, 0, (C6323b) new C6323b() {
                                /* renamed from: b */
                                public final void mo4575b(int i, List<C7620bi> list) {
                                    AppMethodBeat.m2504i(32687);
                                    if (i < 0 || list.size() <= 0) {
                                        C40797b.this.mo64343d(c40750b4);
                                        AppMethodBeat.m2505o(32687);
                                        return;
                                    }
                                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + C40797b.this.emo + " fromCreateTime:" + j + " toCreateTime:" + j2 + " addSize:" + list.size());
                                    long j = j2;
                                    if (list.size() <= 18) {
                                        j = C40797b.this.mo64346ns(((C7620bi) list.get(list.size() - 1)).field_createTime);
                                    }
                                    C40797b.this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(C40797b.this.emo, j, j, 36);
                                    c40750b4.mo15847dY();
                                    AppMethodBeat.m2505o(32687);
                                }
                            });
                            break;
                        }
                        C4990ab.m7421w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", this.emo);
                        mo64343d(c40750b);
                        AppMethodBeat.m2505o(32694);
                        return;
                    }
                    j2 = dHd();
                    j = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15330f(this.emo, j2, s);
                    C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.emo + " from:" + j + " to:" + j2 + " unreadCount:" + s);
                    this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, j, j2, BaseClientBuilder.API_PRIORITY_OTHER);
                    c40750b.mo15847dY();
                    AppMethodBeat.m2505o(32694);
                    return;
                }
                long j6 = this.yZU.getLong("MSG_ID");
                boolean z = this.yZU.getBoolean("IS_LOAD_ALL", false);
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(j6);
                if (jf.field_msgId != j6) {
                    C4990ab.m7421w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", Long.valueOf(j6));
                    c40750b.mo15847dY();
                    AppMethodBeat.m2505o(32694);
                    return;
                }
                int i;
                j4 = jf.field_createTime;
                C4990ab.m7411d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", Long.valueOf(j4), Long.valueOf(this.yZQ), Long.valueOf(this.yZR));
                if (j4 < this.yZQ || j4 > this.yZR) {
                    j = jf.field_createTime;
                    C9638aw.m17190ZK();
                    C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", Long.valueOf(j), Long.valueOf(Math.min(mo64346ns(jf.field_createTime), C18628c.m29080XO().mo15335g(this.emo, j, 18))), Long.valueOf(j6), Boolean.valueOf(z), Integer.valueOf(0));
                    this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, j, j2, BaseClientBuilder.API_PRIORITY_OTHER);
                    i = 0;
                } else {
                    this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, this.yZQ, this.yZR, BaseClientBuilder.API_PRIORITY_OTHER);
                    C9638aw.m17190ZK();
                    i = C18628c.m29080XO().mo15350s(this.emo, this.yZQ, j4) - 1;
                    C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", Integer.valueOf(i), Long.valueOf(j6), Boolean.valueOf(z));
                }
                this.yZV.selection = Math.max(0, i);
                c40750b.mo15847dY();
                AppMethodBeat.m2505o(32694);
                return;
                break;
        }
        AppMethodBeat.m2505o(32694);
    }

    /* renamed from: b */
    private void m70687b(C40750b c40750b) {
        AppMethodBeat.m2504i(32695);
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", Long.valueOf(dHc()), Long.valueOf(dHf()));
        this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, r2, r4, 18);
        c40750b.mo15847dY();
        AppMethodBeat.m2505o(32695);
    }

    /* renamed from: c */
    private void m70688c(C40750b c40750b) {
        long dHd;
        AppMethodBeat.m2504i(32696);
        boolean z = this.yZV.yYz != null && this.yZV.yYz.getBoolean("has_position_tongue", false);
        boolean z2;
        if (this.yZV.yYz == null || !this.yZV.yYz.getBoolean("has_position_search", false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z) {
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(this.emo);
            if (Rb != null && Rb.field_isSend == 1 && Rb.field_msgSeq == 0) {
                m70687b(c40750b);
                if (this.yZV.yYz == null) {
                    this.yZV.yYz = new Bundle();
                }
                this.yZV.yYz.putBoolean("need_scroll_to_bottom", true);
                C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
                AppMethodBeat.m2505o(32696);
                return;
            }
        }
        long dHe = dHe();
        if (z || !z2) {
            dHd = dHd();
        } else {
            dHd = this.yZR;
        }
        C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.emo + " from:" + dHe + " to:" + dHd + " hasTongue:" + z);
        this.f16212PI = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15328d(this.emo, dHe, dHd, BaseClientBuilder.API_PRIORITY_OTHER);
        c40750b.mo15847dY();
        AppMethodBeat.m2505o(32696);
    }

    public final int dCP() {
        AppMethodBeat.m2504i(32697);
        C9638aw.m17190ZK();
        int Rp = C18628c.m29080XO().mo15262Rp(this.emo);
        AppMethodBeat.m2505o(32697);
        return Rp;
    }

    /* renamed from: fk */
    public final void mo48959fk(List<C7620bi> list) {
        AppMethodBeat.m2504i(32698);
        if (this.f16212PI == null) {
            C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
            AppMethodBeat.m2505o(32698);
            return;
        }
        this.f16212PI.moveToFirst();
        while (!this.f16212PI.isAfterLast()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(this.f16212PI);
            list.add(c7620bi);
            this.f16212PI.moveToNext();
        }
        AppMethodBeat.m2505o(32698);
    }

    public final void close() {
        AppMethodBeat.m2504i(32699);
        if (this.f16212PI != null) {
            this.f16212PI.close();
        }
        AppMethodBeat.m2505o(32699);
    }

    /* Access modifiers changed, original: final */
    public final long dHc() {
        AppMethodBeat.m2504i(32700);
        C6594c QM = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15217QM(this.emo);
        long j;
        if (QM != null) {
            C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + QM.eoF + " seq:" + QM.eoC + "~" + QM.eoD);
            j = QM.eoF;
            AppMethodBeat.m2505o(32700);
            return j;
        }
        j = this.yZQ;
        AppMethodBeat.m2505o(32700);
        return j;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ns */
    public final long mo64346ns(long j) {
        AppMethodBeat.m2504i(32701);
        C6594c f = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15225f(this.emo, j, true);
        long j2;
        if (f != null) {
            C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + f.eoE + " time:" + j);
            j2 = f.eoE;
            AppMethodBeat.m2505o(32701);
            return j2;
        }
        j2 = dHf();
        AppMethodBeat.m2505o(32701);
        return j2;
    }

    private long dHd() {
        AppMethodBeat.m2504i(32702);
        C7578w QN = ((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15218QN(this.emo);
        long dHf;
        if (this.yZS <= 0 || QN.mo16811mP(this.yZS).size() <= 0) {
            dHf = dHf();
            AppMethodBeat.m2505o(32702);
            return dHf;
        }
        C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] mLastBottomMsgSeq:" + this.yZS + " chatroomMsgSeq:" + QN);
        dHf = this.yZR;
        AppMethodBeat.m2505o(32702);
        return dHf;
    }

    private long dHe() {
        AppMethodBeat.m2504i(32703);
        if (this.yZQ == 0) {
            C4990ab.m7420w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
            this.yZQ = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15330f(this.emo, dHf(), 18);
        }
        long j = this.yZQ;
        AppMethodBeat.m2505o(32703);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final long dHf() {
        AppMethodBeat.m2504i(32704);
        long Rt = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(this.emo);
        AppMethodBeat.m2505o(32704);
        return Rt;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo64343d(C40750b c40750b) {
        AppMethodBeat.m2504i(32705);
        C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
        m70688c(c40750b);
        AppMethodBeat.m2505o(32705);
    }
}
