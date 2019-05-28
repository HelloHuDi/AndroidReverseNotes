package com.tencent.p177mm.p612ui.chatting.p616c;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32824f;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42031nn;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23728ab;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C23728ab.class)
/* renamed from: com.tencent.mm.ui.chatting.c.aj */
public class C44803aj extends C44291a implements C1202f, C3457a, C23728ab {
    private static boolean yRV = false;
    private int eCL = -1;
    @SuppressLint({"HandlerLeak"})
    private C7306ak handler = new C442921();
    private int yRU;
    private long yRW;

    /* renamed from: com.tencent.mm.ui.chatting.c.aj$4 */
    class C237154 implements C1835a {
        C237154() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(31698);
            if (c1902e == null) {
                AppMethodBeat.m2505o(31698);
                return;
            }
            c1902e.stopSignalling();
            AppMethodBeat.m2505o(31698);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.aj$1 */
    class C442921 extends C7306ak {
        C442921() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(31695);
            if (C44803aj.this.cgL == null || !C44803aj.this.cgL.caA) {
                AppMethodBeat.m2505o(31695);
                return;
            }
            if (C44803aj.yRV) {
                C44803aj.yRV = false;
                ((C44299r) C44803aj.this.cgL.mo74857aF(C44299r.class)).dEm();
                C44803aj.this.cgL.aWv();
            }
            AppMethodBeat.m2505o(31695);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.aj$2 */
    class C442932 implements C1835a {
        C442932() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(31696);
            if (c1902e == null) {
                AppMethodBeat.m2505o(31696);
                return;
            }
            C44803aj.m81913a(C44803aj.this, c1902e);
            AppMethodBeat.m2505o(31696);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.aj$3 */
    class C442943 implements C1835a {
        C442943() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(31697);
            if (c1902e == null) {
                AppMethodBeat.m2505o(31697);
                return;
            }
            c1902e.keepSignalling();
            AppMethodBeat.m2505o(31697);
        }
    }

    public C44803aj() {
        AppMethodBeat.m2504i(31699);
        AppMethodBeat.m2505o(31699);
    }

    public final void keepSignalling() {
        AppMethodBeat.m2504i(31700);
        if (this.yRU == -2) {
            C9638aw.m17182Rg().mo14541a(new C6668bk(new C442943()), 0);
        }
        AppMethodBeat.m2505o(31700);
    }

    public final void stopSignalling() {
        AppMethodBeat.m2504i(31701);
        C9638aw.m17182Rg().mo14541a(new C6668bk(new C237154()), 0);
        AppMethodBeat.m2505o(31701);
    }

    /* renamed from: OE */
    public final void mo39569OE(int i) {
        AppMethodBeat.m2504i(31702);
        if (this.cgL == null) {
            C4990ab.m7413e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", C5046bo.dpG().toString());
            AppMethodBeat.m2505o(31702);
            return;
        }
        C46650a c46650a = this.cgL;
        int i2 = (c46650a.dFw() || ((C36135d) c46650a.mo74857aF(C36135d.class)).dDn()) ? 1 : 0;
        int intValue = ((Integer) C9638aw.m17188ZI().get(35, Integer.valueOf(10))).intValue();
        LinkedList linkedList = new LinkedList();
        linkedList.add(c46650a.getTalkerUserName());
        if (intValue == -2) {
            if (i2 == 0 || !(i == 1 || i == 2)) {
                C4990ab.m7411d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i));
                C9638aw.m17182Rg().mo14541a(new C32824f(linkedList, C37432o.m63091fZ(i)), 0);
                AppMethodBeat.m2505o(31702);
                return;
            }
            C4990ab.m7411d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(31702);
        } else if (i2 != 0 || C7616ad.aow(c46650a.getTalkerUserName()) || C7616ad.aou(c46650a.getTalkerUserName()) || c46650a.sRl.dsf()) {
            C4990ab.m7410d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
            AppMethodBeat.m2505o(31702);
        } else {
            if (this.yRW == 0) {
                List dEK = ((C40726v) this.cgL.mo74857aF(C40726v.class)).dEK();
                if (dEK != null && dEK.size() > 0) {
                    this.yRW = ((C7620bi) dEK.get(0)).field_createTime;
                }
            }
            long gb = C5046bo.m7566gb(this.yRW);
            if (intValue == -1 || gb > ((long) intValue) * 1000) {
                C4990ab.m7411d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(gb / 1000), Integer.valueOf(intValue));
                AppMethodBeat.m2505o(31702);
                return;
            }
            C4990ab.m7411d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i), Long.valueOf(gb / 1000));
            C9638aw.m17182Rg().mo14541a(new C32824f(linkedList, C37432o.m63091fZ(i)), 0);
            AppMethodBeat.m2505o(31702);
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31703);
        if (this.cgL == null) {
            AppMethodBeat.m2505o(31703);
            return;
        }
        this.cgL.dismissDialog();
        if (10 != c1207m.getType()) {
            AppMethodBeat.m2505o(31703);
            return;
        }
        boolean dES = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dES();
        boolean dET = ((C23733z) this.cgL.mo74857aF(C23733z.class)).dET();
        if (((C23733z) this.cgL.mo74857aF(C23733z.class)).dEW() || dET || dES) {
            C4990ab.m7417i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", Boolean.valueOf(dES), Boolean.valueOf(dET), Boolean.valueOf(r0));
            AppMethodBeat.m2505o(31703);
            return;
        }
        if (i == 0 && i2 == 0) {
            C32824f c32824f = (C32824f) c1207m;
            if (c32824f.fOt != null && c32824f.fOt.equals(this.cgL.getTalkerUserName())) {
                if (c32824f.content != null && c32824f.content.length == 4) {
                    int t = C37432o.m63092t(c32824f.content, 0);
                    C4990ab.m7410d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(t)));
                    switch (t) {
                        case 1:
                            yRV = true;
                            ((C44299r) this.cgL.mo74857aF(C44299r.class)).setMMTitle(C25738R.string.aop);
                            this.handler.sendMessageDelayed(new Message(), 15000);
                            C4879a.xxA.mo10055m(new C42031nn());
                            AppMethodBeat.m2505o(31703);
                            return;
                        case 3:
                            yRV = true;
                            ((C44299r) this.cgL.mo74857aF(C44299r.class)).setMMTitle(C25738R.string.aoq);
                            this.handler.sendMessageDelayed(new Message(), 15000);
                            AppMethodBeat.m2505o(31703);
                            return;
                        default:
                            yRV = false;
                            ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEm();
                            this.cgL.aWv();
                            break;
                    }
                }
                C4990ab.m7412e("MicroMsg.SignallingComponent", "unknown directsend op");
                AppMethodBeat.m2505o(31703);
                return;
            }
        }
        AppMethodBeat.m2505o(31703);
    }

    /* renamed from: a */
    public final void mo7913a(C6977h c6977h, C3460c c3460c) {
        AppMethodBeat.m2504i(31704);
        C4990ab.m7410d("MicroMsg.SignallingComponent", "on msg notify change");
        if (this.cgL == null) {
            C4990ab.m7420w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.m2505o(31704);
            return;
        }
        if (this.cgL.getTalkerUserName().equals(c3460c.talker) && "insert".equals(c3460c.oqJ) && c3460c.oqK.size() > 0 && ((C7620bi) c3460c.oqK.get(0)).field_isSend == 0) {
            C4990ab.m7417i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(((C7620bi) c3460c.oqK.get(0)).field_flag), Long.valueOf(((C7620bi) c3460c.oqK.get(0)).field_msgSeq));
            this.yRW = C5046bo.anU();
        }
        AppMethodBeat.m2505o(31704);
    }

    /* renamed from: a */
    public final void mo10944a(C46650a c46650a) {
        AppMethodBeat.m2504i(31705);
        super.mo10944a(c46650a);
        C4990ab.m7417i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", this);
        C9638aw.m17182Rg().mo14541a(new C6668bk(new C442932()), 0);
        AppMethodBeat.m2505o(31705);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31706);
        super.dDh();
        C4990ab.m7417i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", this);
        this.handler.removeCallbacksAndMessages(null);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a((C3457a) this);
        C9638aw.m17182Rg().mo14546b(10, (C1202f) this);
        AppMethodBeat.m2505o(31706);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31707);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15287a((C3457a) this, Looper.getMainLooper());
        C9638aw.m17182Rg().mo14539a(10, (C1202f) this);
        AppMethodBeat.m2505o(31707);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31708);
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a((C3457a) this);
        C9638aw.m17182Rg().mo14546b(10, (C1202f) this);
        AppMethodBeat.m2505o(31708);
    }
}
