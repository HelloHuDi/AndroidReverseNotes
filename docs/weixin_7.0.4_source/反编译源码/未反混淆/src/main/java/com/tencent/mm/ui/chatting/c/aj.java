package com.tencent.mm.ui.chatting.c;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.nn;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ab;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;
import java.util.LinkedList;
import java.util.List;

@a(dFp = ab.class)
public class aj extends a implements f, h.a, ab {
    private static boolean yRV = false;
    private int eCL = -1;
    @SuppressLint({"HandlerLeak"})
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(31695);
            if (aj.this.cgL == null || !aj.this.cgL.caA) {
                AppMethodBeat.o(31695);
                return;
            }
            if (aj.yRV) {
                aj.yRV = false;
                ((r) aj.this.cgL.aF(r.class)).dEm();
                aj.this.cgL.aWv();
            }
            AppMethodBeat.o(31695);
        }
    };
    private int yRU;
    private long yRW;

    public aj() {
        AppMethodBeat.i(31699);
        AppMethodBeat.o(31699);
    }

    public final void keepSignalling() {
        AppMethodBeat.i(31700);
        if (this.yRU == -2) {
            aw.Rg().a(new bk(new bk.a() {
                public final void a(e eVar) {
                    AppMethodBeat.i(31697);
                    if (eVar == null) {
                        AppMethodBeat.o(31697);
                        return;
                    }
                    eVar.keepSignalling();
                    AppMethodBeat.o(31697);
                }
            }), 0);
        }
        AppMethodBeat.o(31700);
    }

    public final void stopSignalling() {
        AppMethodBeat.i(31701);
        aw.Rg().a(new bk(new bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(31698);
                if (eVar == null) {
                    AppMethodBeat.o(31698);
                    return;
                }
                eVar.stopSignalling();
                AppMethodBeat.o(31698);
            }
        }), 0);
        AppMethodBeat.o(31701);
    }

    public final void OE(int i) {
        AppMethodBeat.i(31702);
        if (this.cgL == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", bo.dpG().toString());
            AppMethodBeat.o(31702);
            return;
        }
        com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
        int i2 = (aVar.dFw() || ((d) aVar.aF(d.class)).dDn()) ? 1 : 0;
        int intValue = ((Integer) aw.ZI().get(35, Integer.valueOf(10))).intValue();
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar.getTalkerUserName());
        if (intValue == -2) {
            if (i2 == 0 || !(i == 1 || i == 2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i));
                aw.Rg().a(new com.tencent.mm.modelsimple.f(linkedList, o.fZ(i)), 0);
                AppMethodBeat.o(31702);
                return;
            }
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i));
            AppMethodBeat.o(31702);
        } else if (i2 != 0 || ad.aow(aVar.getTalkerUserName()) || ad.aou(aVar.getTalkerUserName()) || aVar.sRl.dsf()) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
            AppMethodBeat.o(31702);
        } else {
            if (this.yRW == 0) {
                List dEK = ((v) this.cgL.aF(v.class)).dEK();
                if (dEK != null && dEK.size() > 0) {
                    this.yRW = ((bi) dEK.get(0)).field_createTime;
                }
            }
            long gb = bo.gb(this.yRW);
            if (intValue == -1 || gb > ((long) intValue) * 1000) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(gb / 1000), Integer.valueOf(intValue));
                AppMethodBeat.o(31702);
                return;
            }
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i), Long.valueOf(gb / 1000));
            aw.Rg().a(new com.tencent.mm.modelsimple.f(linkedList, o.fZ(i)), 0);
            AppMethodBeat.o(31702);
        }
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(31703);
        if (this.cgL == null) {
            AppMethodBeat.o(31703);
            return;
        }
        this.cgL.dismissDialog();
        if (10 != mVar.getType()) {
            AppMethodBeat.o(31703);
            return;
        }
        boolean dES = ((z) this.cgL.aF(z.class)).dES();
        boolean dET = ((z) this.cgL.aF(z.class)).dET();
        if (((z) this.cgL.aF(z.class)).dEW() || dET || dES) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", Boolean.valueOf(dES), Boolean.valueOf(dET), Boolean.valueOf(r0));
            AppMethodBeat.o(31703);
            return;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.modelsimple.f fVar = (com.tencent.mm.modelsimple.f) mVar;
            if (fVar.fOt != null && fVar.fOt.equals(this.cgL.getTalkerUserName())) {
                if (fVar.content != null && fVar.content.length == 4) {
                    int t = o.t(fVar.content, 0);
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(t)));
                    switch (t) {
                        case 1:
                            yRV = true;
                            ((r) this.cgL.aF(r.class)).setMMTitle(R.string.aop);
                            this.handler.sendMessageDelayed(new Message(), 15000);
                            com.tencent.mm.sdk.b.a.xxA.m(new nn());
                            AppMethodBeat.o(31703);
                            return;
                        case 3:
                            yRV = true;
                            ((r) this.cgL.aF(r.class)).setMMTitle(R.string.aoq);
                            this.handler.sendMessageDelayed(new Message(), 15000);
                            AppMethodBeat.o(31703);
                            return;
                        default:
                            yRV = false;
                            ((r) this.cgL.aF(r.class)).dEm();
                            this.cgL.aWv();
                            break;
                    }
                }
                com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SignallingComponent", "unknown directsend op");
                AppMethodBeat.o(31703);
                return;
            }
        }
        AppMethodBeat.o(31703);
    }

    public final void a(h hVar, c cVar) {
        AppMethodBeat.i(31704);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.SignallingComponent", "on msg notify change");
        if (this.cgL == null) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.o(31704);
            return;
        }
        if (this.cgL.getTalkerUserName().equals(cVar.talker) && "insert".equals(cVar.oqJ) && cVar.oqK.size() > 0 && ((bi) cVar.oqK.get(0)).field_isSend == 0) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(((bi) cVar.oqK.get(0)).field_flag), Long.valueOf(((bi) cVar.oqK.get(0)).field_msgSeq));
            this.yRW = bo.anU();
        }
        AppMethodBeat.o(31704);
    }

    public final void a(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(31705);
        super.a(aVar);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", this);
        aw.Rg().a(new bk(new bk.a() {
            public final void a(e eVar) {
                AppMethodBeat.i(31696);
                if (eVar == null) {
                    AppMethodBeat.o(31696);
                    return;
                }
                aj.a(aj.this, eVar);
                AppMethodBeat.o(31696);
            }
        }), 0);
        AppMethodBeat.o(31705);
    }

    public final void dDh() {
        AppMethodBeat.i(31706);
        super.dDh();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", this);
        this.handler.removeCallbacksAndMessages(null);
        aw.ZK();
        com.tencent.mm.model.c.XO().a((h.a) this);
        aw.Rg().b(10, (f) this);
        AppMethodBeat.o(31706);
    }

    public final void dxz() {
        AppMethodBeat.i(31707);
        aw.ZK();
        com.tencent.mm.model.c.XO().a((h.a) this, Looper.getMainLooper());
        aw.Rg().a(10, (f) this);
        AppMethodBeat.o(31707);
    }

    public final void dxC() {
        AppMethodBeat.i(31708);
        aw.ZK();
        com.tencent.mm.model.c.XO().a((h.a) this);
        aw.Rg().b(10, (f) this);
        AppMethodBeat.o(31708);
    }
}
