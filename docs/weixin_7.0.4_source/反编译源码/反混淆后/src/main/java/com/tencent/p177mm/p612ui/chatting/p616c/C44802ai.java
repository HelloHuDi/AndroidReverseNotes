package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.p1178ap.C17913a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45313by;
import com.tencent.p177mm.p612ui.chatting.C15571aa;
import com.tencent.p177mm.p612ui.chatting.C15763x;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30467ad;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.notification.C3559d;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.plugin.setting.model.C7081j;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

@C15590a(dFp = C30467ad.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ai */
public class C44802ai extends C44291a implements C1202f, C30467ad {
    private boolean yOx = false;
    private C15763x yRR;
    private int yRS;

    private void djt() {
        AppMethodBeat.m2504i(31682);
        if (this.yRR != null) {
            C15763x c15763x = this.yRR;
            if (c15763x.yLx != null) {
                C15571aa c15571aa = c15763x.yLx;
                c15571aa.mHandler.removeMessages(0);
                if (c15571aa.yLy != null) {
                    c15571aa.yLy.stop();
                }
                C4990ab.m7410d("MicroMsg.EggMgr", "egg has been stop");
            }
        }
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.yRS);
        this.yRS = 0;
        AppMethodBeat.m2505o(31682);
    }

    public final boolean arq(String str) {
        AppMethodBeat.m2504i(31683);
        boolean eB = m81910eB(str, 0);
        AppMethodBeat.m2505o(31683);
        return eB;
    }

    /* renamed from: eB */
    private boolean m81910eB(String str, final int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(31684);
        final String anz = C5046bo.anz(str);
        if (anz == null || anz.length() == 0) {
            C4990ab.m7412e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
            AppMethodBeat.m2505o(31684);
            return false;
        }
        this.yRR.ard(anz);
        C45313by c45313by = new C45313by();
        c45313by.cvf.cvh = anz;
        c45313by.cvf.context = this.cgL.yTx.getContext();
        c45313by.cvf.username = this.cgL.getTalkerUserName();
        C4879a.xxA.mo10055m(c45313by);
        if (c45313by.cvg.cvi) {
            AppMethodBeat.m2505o(31684);
            return true;
        }
        boolean z = WXHardCoderJNI.hcSendMsgEnable;
        int i3 = WXHardCoderJNI.hcSendMsgDelay;
        int i4 = WXHardCoderJNI.hcSendMsgCPU;
        int i5 = WXHardCoderJNI.hcSendMsgIO;
        if (WXHardCoderJNI.hcSendMsgThr) {
            i2 = C1720g.m3539RS().doL();
        }
        this.yRS = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
        C46650a.dFz().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(31681);
                if (C44802ai.this.cgL == null) {
                    C4990ab.m7420w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
                    AppMethodBeat.m2505o(31681);
                    return;
                }
                C34830g.m57194BN(20);
                if (C44802ai.m81909a(C44802ai.this)) {
                    C44802ai.this.cgL.dFu();
                    C9638aw.m17182Rg().mo14541a(new C17913a(C44802ai.this.cgL.sRl.field_username, anz), 0);
                    AppMethodBeat.m2505o(31681);
                    return;
                }
                if (((C15612h) C44802ai.this.cgL.mo74857aF(C15612h.class)).getCount() == 0 && C7616ad.aow(C44802ai.this.cgL.getTalkerUserName())) {
                    C37907bv.aaq().mo60662c(10076, Integer.valueOf(1));
                }
                String talkerUserName = C44802ai.this.cgL.getTalkerUserName();
                int nK = C1855t.m3925nK(talkerUserName);
                String str = anz;
                String aro = ((C40725t) C44802ai.this.cgL.mo74857aF(C40725t.class)).aro(talkerUserName);
                if (C5046bo.isNullOrNil(aro)) {
                    C4990ab.m7420w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
                    AppMethodBeat.m2505o(31681);
                    return;
                }
                String str2;
                C15614o c15614o = (C15614o) C44802ai.this.cgL.mo74857aF(C15614o.class);
                int lastIndexOf = str.lastIndexOf(8197);
                if (lastIndexOf <= 0 || lastIndexOf != str.length() - 1) {
                    str2 = str;
                } else {
                    str2 = str.substring(0, lastIndexOf);
                    C4990ab.m7420w("MicroMsg.ChattingUI.SendTextComponent", "delete @ last char! index:".concat(String.valueOf(lastIndexOf)));
                }
                ChatFooter dDX = c15614o.dDX();
                int i = i;
                int i2 = dDX.vna.vof.containsKey(talkerUserName) ? ((LinkedList) dDX.vna.vof.get(talkerUserName)).size() > 0 ? 291 : i : i;
                C1207m c26451h = new C26451h(aro, str2, nK, i2, c15614o.dDX().mo63953hJ(talkerUserName, str));
                ((C40725t) C44802ai.this.cgL.mo74857aF(C40725t.class)).mo10958g(c26451h);
                C9638aw.m17182Rg().mo14541a(c26451h, 0);
                if (C1855t.m3921nG(talkerUserName)) {
                    C9638aw.m17182Rg().mo14541a(new C7081j(C1427q.m3044Mc(), anz + " key " + C7574bs.dut() + " local key " + C7574bs.dus() + "NetType:" + C5023at.getNetTypeString(C44802ai.this.cgL.yTx.getContext().getApplicationContext()) + " hasNeon: " + C1422n.m3013LC() + " isArmv6: " + C1422n.m3015LE() + " isArmv7: " + C1422n.m3014LD()), 0);
                }
                AppMethodBeat.m2505o(31681);
            }
        });
        this.cgL.mo74882qp(true);
        AppMethodBeat.m2505o(31684);
        return true;
    }

    /* renamed from: a */
    public final void mo10944a(C46650a c46650a) {
        AppMethodBeat.m2504i(31685);
        super.mo10944a(c46650a);
        this.yRR = new C15763x(this.cgL);
        AppMethodBeat.m2505o(31685);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31686);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 207:
                m81910eB(intent.getStringExtra("art_smiley_slelct_data"), 4);
                break;
        }
        AppMethodBeat.m2505o(31686);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31688);
        C9638aw.m17182Rg().mo14539a((int) C19482c.CTRL_INDEX, (C1202f) this);
        List dEK = ((C40726v) this.cgL.mo74857aF(C40726v.class)).dEK();
        if (dEK != null) {
            C15763x c15763x = this.yRR;
            if (!(c15763x.yLx == null || c15763x.cgL == null)) {
                C15571aa c15571aa = c15763x.yLx;
                Activity context = c15763x.cgL.yTx.getContext();
                c15571aa.kbM = dEK;
                c15571aa.yLz = context;
                if (c15571aa.mHandler != null) {
                    c15571aa.mHandler.sendEmptyMessageDelayed(0, 300);
                }
            }
        }
        AppMethodBeat.m2505o(31688);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31689);
        if (!this.yOx) {
            C3559d.m5893a(this.yRR);
        }
        this.yOx = false;
        AppMethodBeat.m2505o(31689);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31691);
        C9638aw.m17182Rg().mo14546b((int) C19482c.CTRL_INDEX, (C1202f) this);
        djt();
        AppMethodBeat.m2505o(31691);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31692);
        super.dDh();
        C9638aw.m17182Rg().mo14546b((int) C19482c.CTRL_INDEX, (C1202f) this);
        djt();
        AppMethodBeat.m2505o(31692);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31687);
        C3559d.m5893a(this.yRR);
        this.yOx = true;
        AppMethodBeat.m2505o(31687);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31690);
        C3559d.m5894b(this.yRR);
        AppMethodBeat.m2505o(31690);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31693);
        if (this.cgL != null) {
            this.cgL.dismissDialog();
        }
        if (C19482c.CTRL_INDEX == c1207m.getType()) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.yRS);
            this.yRS = 0;
        }
        AppMethodBeat.m2505o(31693);
    }
}
