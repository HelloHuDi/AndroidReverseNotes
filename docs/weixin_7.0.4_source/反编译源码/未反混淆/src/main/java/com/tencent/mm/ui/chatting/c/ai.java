package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.by;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ad;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.x;
import java.util.LinkedList;
import java.util.List;

@a(dFp = ad.class)
public class ai extends a implements f, ad {
    private boolean yOx = false;
    private x yRR;
    private int yRS;

    private void djt() {
        AppMethodBeat.i(31682);
        if (this.yRR != null) {
            x xVar = this.yRR;
            if (xVar.yLx != null) {
                aa aaVar = xVar.yLx;
                aaVar.mHandler.removeMessages(0);
                if (aaVar.yLy != null) {
                    aaVar.yLy.stop();
                }
                ab.d("MicroMsg.EggMgr", "egg has been stop");
            }
        }
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.yRS);
        this.yRS = 0;
        AppMethodBeat.o(31682);
    }

    public final boolean arq(String str) {
        AppMethodBeat.i(31683);
        boolean eB = eB(str, 0);
        AppMethodBeat.o(31683);
        return eB;
    }

    private boolean eB(String str, final int i) {
        int i2 = 0;
        AppMethodBeat.i(31684);
        final String anz = bo.anz(str);
        if (anz == null || anz.length() == 0) {
            ab.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
            AppMethodBeat.o(31684);
            return false;
        }
        this.yRR.ard(anz);
        by byVar = new by();
        byVar.cvf.cvh = anz;
        byVar.cvf.context = this.cgL.yTx.getContext();
        byVar.cvf.username = this.cgL.getTalkerUserName();
        com.tencent.mm.sdk.b.a.xxA.m(byVar);
        if (byVar.cvg.cvi) {
            AppMethodBeat.o(31684);
            return true;
        }
        boolean z = WXHardCoderJNI.hcSendMsgEnable;
        int i3 = WXHardCoderJNI.hcSendMsgDelay;
        int i4 = WXHardCoderJNI.hcSendMsgCPU;
        int i5 = WXHardCoderJNI.hcSendMsgIO;
        if (WXHardCoderJNI.hcSendMsgThr) {
            i2 = g.RS().doL();
        }
        this.yRS = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
        com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31681);
                if (ai.this.cgL == null) {
                    ab.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
                    AppMethodBeat.o(31681);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.BN(20);
                if (ai.a(ai.this)) {
                    ai.this.cgL.dFu();
                    aw.Rg().a(new com.tencent.mm.ap.a(ai.this.cgL.sRl.field_username, anz), 0);
                    AppMethodBeat.o(31681);
                    return;
                }
                if (((h) ai.this.cgL.aF(h.class)).getCount() == 0 && com.tencent.mm.storage.ad.aow(ai.this.cgL.getTalkerUserName())) {
                    bv.aaq().c(10076, Integer.valueOf(1));
                }
                String talkerUserName = ai.this.cgL.getTalkerUserName();
                int nK = t.nK(talkerUserName);
                String str = anz;
                String aro = ((com.tencent.mm.ui.chatting.c.b.t) ai.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).aro(talkerUserName);
                if (bo.isNullOrNil(aro)) {
                    ab.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
                    AppMethodBeat.o(31681);
                    return;
                }
                String str2;
                o oVar = (o) ai.this.cgL.aF(o.class);
                int lastIndexOf = str.lastIndexOf(8197);
                if (lastIndexOf <= 0 || lastIndexOf != str.length() - 1) {
                    str2 = str;
                } else {
                    str2 = str.substring(0, lastIndexOf);
                    ab.w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(lastIndexOf)));
                }
                ChatFooter dDX = oVar.dDX();
                int i = i;
                int i2 = dDX.vna.vof.containsKey(talkerUserName) ? ((LinkedList) dDX.vna.vof.get(talkerUserName)).size() > 0 ? 291 : i : i;
                m hVar = new com.tencent.mm.modelmulti.h(aro, str2, nK, i2, oVar.dDX().hJ(talkerUserName, str));
                ((com.tencent.mm.ui.chatting.c.b.t) ai.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.t.class)).g(hVar);
                aw.Rg().a(hVar, 0);
                if (t.nG(talkerUserName)) {
                    aw.Rg().a(new j(q.Mc(), anz + " key " + bs.dut() + " local key " + bs.dus() + "NetType:" + at.getNetTypeString(ai.this.cgL.yTx.getContext().getApplicationContext()) + " hasNeon: " + n.LC() + " isArmv6: " + n.LE() + " isArmv7: " + n.LD()), 0);
                }
                AppMethodBeat.o(31681);
            }
        });
        this.cgL.qp(true);
        AppMethodBeat.o(31684);
        return true;
    }

    public final void a(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(31685);
        super.a(aVar);
        this.yRR = new x(this.cgL);
        AppMethodBeat.o(31685);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31686);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 207:
                eB(intent.getStringExtra("art_smiley_slelct_data"), 4);
                break;
        }
        AppMethodBeat.o(31686);
    }

    public final void dxz() {
        AppMethodBeat.i(31688);
        aw.Rg().a((int) c.CTRL_INDEX, (f) this);
        List dEK = ((v) this.cgL.aF(v.class)).dEK();
        if (dEK != null) {
            x xVar = this.yRR;
            if (!(xVar.yLx == null || xVar.cgL == null)) {
                aa aaVar = xVar.yLx;
                Activity context = xVar.cgL.yTx.getContext();
                aaVar.kbM = dEK;
                aaVar.yLz = context;
                if (aaVar.mHandler != null) {
                    aaVar.mHandler.sendEmptyMessageDelayed(0, 300);
                }
            }
        }
        AppMethodBeat.o(31688);
    }

    public final void dxA() {
        AppMethodBeat.i(31689);
        if (!this.yOx) {
            d.a(this.yRR);
        }
        this.yOx = false;
        AppMethodBeat.o(31689);
    }

    public final void dxC() {
        AppMethodBeat.i(31691);
        aw.Rg().b((int) c.CTRL_INDEX, (f) this);
        djt();
        AppMethodBeat.o(31691);
    }

    public final void dDh() {
        AppMethodBeat.i(31692);
        super.dDh();
        aw.Rg().b((int) c.CTRL_INDEX, (f) this);
        djt();
        AppMethodBeat.o(31692);
    }

    public final void dxy() {
        AppMethodBeat.i(31687);
        d.a(this.yRR);
        this.yOx = true;
        AppMethodBeat.o(31687);
    }

    public final void dxB() {
        AppMethodBeat.i(31690);
        d.b(this.yRR);
        AppMethodBeat.o(31690);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(31693);
        if (this.cgL != null) {
            this.cgL.dismissDialog();
        }
        if (c.CTRL_INDEX == mVar.getType()) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.yRS);
            this.yRS = 0;
        }
        AppMethodBeat.o(31693);
    }
}
