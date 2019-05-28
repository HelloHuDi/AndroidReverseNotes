package com.tencent.mm.ui.chatting.l;

import android.database.Cursor;
import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.f.d.a;
import com.tencent.mm.ui.chatting.f.d.d;
import java.util.List;

public final class b implements e<bi> {
    Cursor PI;
    String emo;
    private boolean ooX;
    private a yZP;
    long yZQ;
    long yZR;
    private long yZS;
    int yZT;
    private Bundle yZU;
    private d yZV;

    public b(String str, a aVar, Bundle bundle, long j, long j2, long j3, int i, d dVar, boolean z) {
        AppMethodBeat.i(32693);
        this.yZS = j;
        this.yZQ = j2;
        this.yZR = j3;
        this.yZT = i;
        this.emo = str;
        this.yZP = aVar;
        this.yZU = bundle;
        this.yZV = dVar;
        this.ooX = z;
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[ChattingGetDataSource] mLastTopCreateTime:" + this.yZQ + " mLastBottomCreateTime:" + this.yZR + " isFromSearch:" + z + " mLastCount:" + this.yZT + " mLastBottomMsgSeq:" + this.yZS + " mTalker:" + this.emo + " action:" + aVar);
        AppMethodBeat.o(32693);
    }

    public final void a(com.tencent.mm.ui.chatting.f.d.b bVar) {
        AppMethodBeat.i(32694);
        long j;
        long j2;
        int s;
        long j3;
        long j4;
        switch (this.yZP) {
            case ACTION_ENTER:
                b(bVar);
                AppMethodBeat.o(32694);
                return;
            case ACTION_BOTTOM:
                final com.tencent.mm.ui.chatting.f.d.b bVar2;
                w QN;
                if (this.yZU == null || !this.yZU.getBoolean("load_bottom", false)) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.b bOm = ((j) g.K(j.class)).bOm();
                    c f = bOm.f(this.emo, this.yZR, true);
                    if (f != null) {
                        bVar2 = bVar;
                        com.tencent.mm.aq.b.agG().a(this.emo, f.eoC, f.eoD, 0, new com.tencent.mm.aq.b.b() {
                            public final void b(int i, List<bi> list) {
                                AppMethodBeat.i(32689);
                                if (i < 0 || list.size() <= 0) {
                                    b.this.d(bVar2);
                                    AppMethodBeat.o(32689);
                                    return;
                                }
                                long j = b.this.yZQ;
                                bi biVar = (bi) list.get(list.size() - 1);
                                long ns = b.this.ns(biVar.field_createTime);
                                ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.emo + " from:" + j + " to:" + ns + " addMsg.CreateTime:" + biVar.field_createTime);
                                b.this.PI = ((j) g.K(j.class)).bOr().d(b.this.emo, j, ns, BaseClientBuilder.API_PRIORITY_OTHER);
                                bVar2.dY();
                                AppMethodBeat.o(32689);
                            }
                        });
                        AppMethodBeat.o(32694);
                        return;
                    }
                    ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock talker:" + this.emo + " mLastBottomCreateTime:" + this.yZR);
                    QN = bOm.QN(this.emo);
                    bVar2 = bVar;
                    com.tencent.mm.aq.b.agG().a(this.emo, 1 + QN.field_lastLocalSeq, QN.field_lastPushSeq, 0, new com.tencent.mm.aq.b.b() {
                        public final void b(int i, List<bi> list) {
                            AppMethodBeat.i(32690);
                            if (i < 0 || list.size() <= 0) {
                                ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] null == seqBlock ret:".concat(String.valueOf(i)));
                                b.this.d(bVar2);
                                AppMethodBeat.o(32690);
                                return;
                            }
                            long j = b.this.yZQ;
                            long ns = b.this.ns(((bi) list.get(list.size() - 1)).field_createTime);
                            ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadBottom] talker:" + b.this.emo + " from:" + j + " to:" + ns + " size:" + list.size());
                            b.this.PI = ((j) g.K(j.class)).bOr().d(b.this.emo, j, ns, BaseClientBuilder.API_PRIORITY_OTHER);
                            bVar2.dY();
                            AppMethodBeat.o(32690);
                        }
                    });
                    AppMethodBeat.o(32694);
                    return;
                }
                QN = ((j) g.K(j.class)).bOm().QN(this.emo);
                bVar2 = bVar;
                com.tencent.mm.aq.b.agG().a(this.emo, QN.field_lastPushSeq, 1 + QN.field_lastLocalSeq, 1, new com.tencent.mm.aq.b.b() {
                    public final void b(int i, List<bi> list) {
                        AppMethodBeat.i(32688);
                        if (i < 0 || list.size() <= 0) {
                            b.this.d(bVar2);
                            AppMethodBeat.o(32688);
                            return;
                        }
                        long dHc = b.this.dHc();
                        long dHf = b.this.dHf();
                        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleBottomAfterEnter] talker:" + b.this.emo + " from:" + dHc + " to:" + dHf);
                        b.this.PI = ((j) g.K(j.class)).bOr().d(b.this.emo, dHc, dHf, 18);
                        bVar2.dY();
                        AppMethodBeat.o(32688);
                    }
                });
                AppMethodBeat.o(32694);
                return;
            case ACTION_TOP:
                com.tencent.mm.plugin.messenger.foundation.a.a.b bOm2 = ((j) g.K(j.class)).bOm();
                c M = bOm2.M(this.emo, this.yZQ);
                j = M == null ? 0 : M.eoF;
                j2 = this.yZQ;
                s = ((j) g.K(j.class)).bOr().s(this.emo, j, j2);
                ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.emo + " from:" + j + " to:" + j2 + " count:" + s + " seqBlock is null? " + (M == null));
                if (s >= 18 || M == null) {
                    j2 = this.yZR;
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop] talker:" + this.emo + " from:" + j + " to:" + j2 + " count:" + (this.yZT + 18));
                    this.PI = ((j) g.K(j.class)).bOr().d(this.emo, j, j2, this.yZT + 18);
                    bVar.dY();
                    AppMethodBeat.o(32694);
                    return;
                }
                if (M != null) {
                    j3 = M.eoD;
                    j4 = M.eoC;
                    final long j5 = M.eoF;
                    j = M.eoE;
                    final com.tencent.mm.plugin.messenger.foundation.a.a.b bVar3 = bOm2;
                    final com.tencent.mm.ui.chatting.f.d.b bVar4 = bVar;
                    com.tencent.mm.aq.b.agG().a(this.emo, j3, j4, 1, (com.tencent.mm.aq.b.b) new com.tencent.mm.aq.b.b() {
                        public final void b(int i, List<bi> list) {
                            AppMethodBeat.i(32691);
                            if (i >= 0) {
                                long j;
                                long j2 = j;
                                if (list.size() > 0) {
                                    j = ((bi) list.get(0)).field_createTime;
                                } else {
                                    j = j2;
                                }
                                if (bVar3.M(b.this.emo, j) == null && list.size() < 18) {
                                    j = ((j) g.K(j.class)).bOr().f(b.this.emo, j, 18 - list.size());
                                }
                                if (j <= 0) {
                                    j = j;
                                }
                                ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleLoadTop#fetch] talker:" + b.this.emo + " firstCreateTime:" + j + " lastCreateTime:" + j5 + " from:" + j);
                                b.this.PI = ((j) g.K(j.class)).bOr().d(b.this.emo, j, b.this.yZR, b.this.yZT + 18);
                                bVar4.dY();
                                AppMethodBeat.o(32691);
                                return;
                            }
                            b.this.d(bVar4);
                            AppMethodBeat.o(32691);
                        }
                    });
                }
                AppMethodBeat.o(32694);
                return;
            case ACTION_UPDATE:
                c(bVar);
                AppMethodBeat.o(32694);
                return;
            case ACTION_POSITION:
                if (!this.ooX) {
                    com.tencent.mm.plugin.messenger.foundation.a.a.b bOm3 = ((j) g.K(j.class)).bOm();
                    String str = "MicroMsg.ChattingLoader.ChattingGetDataSource";
                    String str2 = "null == mSourceArgs?%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.yZU == null);
                    ab.i(str, str2, objArr);
                    s = this.yZU == null ? 0 : this.yZU.getInt("MSG_POSITION_UNREAD_COUNT");
                    if (s <= 0) {
                        c QM = bOm3.QM(this.emo);
                        if (QM != null) {
                            j3 = QM.eoC;
                            j = QM.eoE;
                            j4 = QM.eoD;
                            j2 = QM.eoF;
                            final com.tencent.mm.ui.chatting.f.d.b bVar5 = bVar;
                            com.tencent.mm.aq.b.agG().a(this.emo, j3, j4, 0, (com.tencent.mm.aq.b.b) new com.tencent.mm.aq.b.b() {
                                public final void b(int i, List<bi> list) {
                                    AppMethodBeat.i(32687);
                                    if (i < 0 || list.size() <= 0) {
                                        b.this.d(bVar5);
                                        AppMethodBeat.o(32687);
                                        return;
                                    }
                                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + b.this.emo + " fromCreateTime:" + j + " toCreateTime:" + j2 + " addSize:" + list.size());
                                    long j = j2;
                                    if (list.size() <= 18) {
                                        j = b.this.ns(((bi) list.get(list.size() - 1)).field_createTime);
                                    }
                                    b.this.PI = ((j) g.K(j.class)).bOr().d(b.this.emo, j, j, 36);
                                    bVar5.dY();
                                    AppMethodBeat.o(32687);
                                }
                            });
                            break;
                        }
                        ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] lastSeqBlock == null！mTalker:%s", this.emo);
                        d(bVar);
                        AppMethodBeat.o(32694);
                        return;
                    }
                    j2 = dHd();
                    j = ((j) g.K(j.class)).bOr().f(this.emo, j2, s);
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePosition] talker:" + this.emo + " from:" + j + " to:" + j2 + " unreadCount:" + s);
                    this.PI = ((j) g.K(j.class)).bOr().d(this.emo, j, j2, BaseClientBuilder.API_PRIORITY_OTHER);
                    bVar.dY();
                    AppMethodBeat.o(32694);
                    return;
                }
                long j6 = this.yZU.getLong("MSG_ID");
                boolean z = this.yZU.getBoolean("IS_LOAD_ALL", false);
                aw.ZK();
                bi jf = com.tencent.mm.model.c.XO().jf(j6);
                if (jf.field_msgId != j6) {
                    ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "get msg info by id %d error", Long.valueOf(j6));
                    bVar.dY();
                    AppMethodBeat.o(32694);
                    return;
                }
                int i;
                j4 = jf.field_createTime;
                ab.d("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] targetCreateTime:%s [%s:%s]", Long.valueOf(j4), Long.valueOf(this.yZQ), Long.valueOf(this.yZR));
                if (j4 < this.yZQ || j4 > this.yZR) {
                    j = jf.field_createTime;
                    aw.ZK();
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] [from:%s to:%s] messageId:%s isLoadAllBottomMsg:%s selection:%s", Long.valueOf(j), Long.valueOf(Math.min(ns(jf.field_createTime), com.tencent.mm.model.c.XO().g(this.emo, j, 18))), Long.valueOf(j6), Boolean.valueOf(z), Integer.valueOf(0));
                    this.PI = ((j) g.K(j.class)).bOr().d(this.emo, j, j2, BaseClientBuilder.API_PRIORITY_OTHER);
                    i = 0;
                } else {
                    this.PI = ((j) g.K(j.class)).bOr().d(this.emo, this.yZQ, this.yZR, BaseClientBuilder.API_PRIORITY_OTHER);
                    aw.ZK();
                    i = com.tencent.mm.model.c.XO().s(this.emo, this.yZQ, j4) - 1;
                    ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handlePositionForSearch] selection:%s messageId:%s isLoadAllBottomMsg:%s", Integer.valueOf(i), Long.valueOf(j6), Boolean.valueOf(z));
                }
                this.yZV.selection = Math.max(0, i);
                bVar.dY();
                AppMethodBeat.o(32694);
                return;
                break;
        }
        AppMethodBeat.o(32694);
    }

    private void b(com.tencent.mm.ui.chatting.f.d.b bVar) {
        AppMethodBeat.i(32695);
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleEnter] from:%d to:%d", Long.valueOf(dHc()), Long.valueOf(dHf()));
        this.PI = ((j) g.K(j.class)).bOr().d(this.emo, r2, r4, 18);
        bVar.dY();
        AppMethodBeat.o(32695);
    }

    private void c(com.tencent.mm.ui.chatting.f.d.b bVar) {
        long dHd;
        AppMethodBeat.i(32696);
        boolean z = this.yZV.yYz != null && this.yZV.yYz.getBoolean("has_position_tongue", false);
        boolean z2;
        if (this.yZV.yYz == null || !this.yZV.yYz.getBoolean("has_position_search", false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z) {
            bi Rb = ((j) g.K(j.class)).bOr().Rb(this.emo);
            if (Rb != null && Rb.field_isSend == 1 && Rb.field_msgSeq == 0) {
                b(bVar);
                if (this.yZV.yYz == null) {
                    this.yZV.yYz = new Bundle();
                }
                this.yZV.yYz.putBoolean("need_scroll_to_bottom", true);
                ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] send msg! need scroll to bottom!");
                AppMethodBeat.o(32696);
                return;
            }
        }
        long dHe = dHe();
        if (z || !z2) {
            dHd = dHd();
        } else {
            dHd = this.yZR;
        }
        ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[handleUpdate] talker:" + this.emo + " from:" + dHe + " to:" + dHd + " hasTongue:" + z);
        this.PI = ((j) g.K(j.class)).bOr().d(this.emo, dHe, dHd, BaseClientBuilder.API_PRIORITY_OTHER);
        bVar.dY();
        AppMethodBeat.o(32696);
    }

    public final int dCP() {
        AppMethodBeat.i(32697);
        aw.ZK();
        int Rp = com.tencent.mm.model.c.XO().Rp(this.emo);
        AppMethodBeat.o(32697);
        return Rp;
    }

    public final void fk(List<bi> list) {
        AppMethodBeat.i(32698);
        if (this.PI == null) {
            ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fillItem] cursor is null");
            AppMethodBeat.o(32698);
            return;
        }
        this.PI.moveToFirst();
        while (!this.PI.isAfterLast()) {
            bi biVar = new bi();
            biVar.d(this.PI);
            list.add(biVar);
            this.PI.moveToNext();
        }
        AppMethodBeat.o(32698);
    }

    public final void close() {
        AppMethodBeat.i(32699);
        if (this.PI != null) {
            this.PI.close();
        }
        AppMethodBeat.o(32699);
    }

    /* Access modifiers changed, original: final */
    public final long dHc() {
        AppMethodBeat.i(32700);
        c QM = ((j) g.K(j.class)).bOm().QM(this.emo);
        long j;
        if (QM != null) {
            ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockLastSeq] has block! so return just lastBlock of lastCreateTime! lastCreateTime:" + QM.eoF + " seq:" + QM.eoC + "~" + QM.eoD);
            j = QM.eoF;
            AppMethodBeat.o(32700);
            return j;
        }
        j = this.yZQ;
        AppMethodBeat.o(32700);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final long ns(long j) {
        AppMethodBeat.i(32701);
        c f = ((j) g.K(j.class)).bOm().f(this.emo, j, true);
        long j2;
        if (f != null) {
            ab.i("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findLastBlockFirstCreateTime] has block! so return just lastBlock of lastCreateTime! firstCreateTime:" + f.eoE + " time:" + j);
            j2 = f.eoE;
            AppMethodBeat.o(32701);
            return j2;
        }
        j2 = dHf();
        AppMethodBeat.o(32701);
        return j2;
    }

    private long dHd() {
        AppMethodBeat.i(32702);
        w QN = ((j) g.K(j.class)).bOm().QN(this.emo);
        long dHf;
        if (this.yZS <= 0 || QN.mP(this.yZS).size() <= 0) {
            dHf = dHf();
            AppMethodBeat.o(32702);
            return dHf;
        }
        ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateLastCreateTime] mLastBottomMsgSeq:" + this.yZS + " chatroomMsgSeq:" + QN);
        dHf = this.yZR;
        AppMethodBeat.o(32702);
        return dHf;
    }

    private long dHe() {
        AppMethodBeat.i(32703);
        if (this.yZQ == 0) {
            ab.w("MicroMsg.ChattingLoader.ChattingGetDataSource", "[findUpdateFirstCreateTime] mLastTopCreateTime == 0");
            this.yZQ = ((j) g.K(j.class)).bOr().f(this.emo, dHf(), 18);
        }
        long j = this.yZQ;
        AppMethodBeat.o(32703);
        return j;
    }

    /* Access modifiers changed, original: final */
    public final long dHf() {
        AppMethodBeat.i(32704);
        long Rt = ((j) g.K(j.class)).bOr().Rt(this.emo);
        AppMethodBeat.o(32704);
        return Rt;
    }

    /* Access modifiers changed, original: final */
    public final void d(com.tencent.mm.ui.chatting.f.d.b bVar) {
        AppMethodBeat.i(32705);
        ab.e("MicroMsg.ChattingLoader.ChattingGetDataSource", "[fallback]");
        c(bVar);
        AppMethodBeat.o(32705);
    }
}
