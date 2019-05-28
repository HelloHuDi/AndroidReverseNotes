package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37950w;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p612ui.AllRemindMsgUI;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23731w;
import com.tencent.p177mm.p612ui.chatting.view.C30578b;
import com.tencent.p177mm.p612ui.chatting.view.C30578b.C30581a;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bdl;
import com.tencent.p177mm.protocal.protobuf.bre;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.recovery.p662wx.util.NetUtil;
import java.io.IOException;

@C15590a(dFp = C23731w.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ab */
public class C36126ab extends C44291a implements C1202f, C23731w {
    /* renamed from: a */
    static /* synthetic */ void m59483a(C36126ab c36126ab, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31603);
        c36126ab.m59485ba(c7620bi);
        AppMethodBeat.m2505o(31603);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31597);
        C9638aw.m17182Rg().mo14539a((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31597);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31598);
        C9638aw.m17182Rg().mo14546b((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31598);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31599);
        super.dDh();
        C9638aw.m17182Rg().mo14546b((int) C44699i.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31599);
    }

    /* renamed from: j */
    public final void mo39573j(MenuItem menuItem) {
        AppMethodBeat.m2504i(31600);
        final C7620bi Ou = ((C15612h) this.cgL.mo74857aF(C15612h.class)).mo27798Ou(menuItem.getGroupId());
        if (Ou == null) {
            C4990ab.m7412e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
            AppMethodBeat.m2505o(31600);
            return;
        }
        switch (menuItem.getItemId()) {
            case C19392d.CTRL_INDEX /*134*/:
                C9638aw.m17190ZK();
                if (!((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                    m59485ba(Ou);
                    break;
                }
                C30379h.m48438a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.dnd), this.cgL.yTx.getMMResources().getString(C25738R.string.dne), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(31594);
                        C36126ab.m59483a(C36126ab.this, Ou);
                        AppMethodBeat.m2505o(31594);
                    }
                });
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.FALSE);
                AppMethodBeat.m2505o(31600);
                return;
        }
        AppMethodBeat.m2505o(31600);
    }

    /* renamed from: ba */
    private void m59485ba(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31601);
        final C30578b c30578b = new C30578b(this.cgL.yTx.getContext());
        c30578b.zaY = new C30581a() {
            /* renamed from: ne */
            public final void mo39544ne(long j) {
                AppMethodBeat.m2504i(31595);
                c30578b.hide();
                C7060h.pYm.mo8378a(795, 1, 1, false);
                if (NetUtil.isConnected(C36126ab.this.cgL.yTx.getContext())) {
                    bre bre = new bre();
                    bre.lvf = (int) (j / 1000);
                    bre.jCt = 1;
                    bre.wOI = 1;
                    try {
                        bdl bdl = new bdl();
                        bdl.jBB = C36126ab.this.cgL.getTalkerUserName();
                        bdl.ptF = c7620bi.field_msgSvrId;
                        bdl.Title = C36126ab.m59484b(C36126ab.this, c7620bi);
                        bre.wcJ = new C1332b(bdl.toByteArray());
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", e.toString());
                    }
                    C9638aw.m17182Rg().mo14541a(new C37950w(1, bre), 0);
                    AppMethodBeat.m2505o(31595);
                    return;
                }
                C30379h.m48461b(C36126ab.this.cgL.yTx.getContext(), C36126ab.this.cgL.yTx.getMMResources().getString(C25738R.string.d5l), C36126ab.this.cgL.yTx.getMMResources().getString(C25738R.string.dna), true);
                AppMethodBeat.m2505o(31595);
            }

            public final void onCancel() {
                AppMethodBeat.m2504i(31596);
                c30578b.hide();
                AppMethodBeat.m2505o(31596);
            }
        };
        c30578b.show();
        C7060h.pYm.mo8378a(795, 0, 1, false);
        AppMethodBeat.m2505o(31601);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31602);
        C4990ab.m7416i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + c1207m.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.m2505o(31602);
        } else if (C5046bo.m7544cv(this.cgL.yTx.getContext())) {
            int i3;
            Activity context = this.cgL.yTx.getContext();
            if (C30784a.m49123a(context, i, i2, str, 7)) {
                i3 = 1;
            } else if (C30777u.m49118a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                AppMethodBeat.m2505o(31602);
            } else if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case C44699i.CTRL_INDEX /*525*/:
                        C4990ab.m7416i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
                        C5670b.m8520a(this.cgL.yTx.getContext(), this.cgL.yTx.getView(), this.cgL.yTx.getMMResources().getString(C25738R.string.cbl), "");
                        AppMethodBeat.m2505o(31602);
                        return;
                    default:
                        AppMethodBeat.m2505o(31602);
                        return;
                }
            } else {
                if (c1207m.getType() == C44699i.CTRL_INDEX) {
                    C4990ab.m7413e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(C44699i.CTRL_INDEX), Integer.valueOf(i2), Integer.valueOf(i), C5046bo.nullAsNil(str));
                    Context context2 = this.cgL.yTx.getContext();
                    if (C5046bo.isNullOrNil(str)) {
                        str = this.cgL.yTx.getMMResources().getString(C25738R.string.dn_);
                    }
                    C30379h.m48461b(context2, str, this.cgL.yTx.getMMResources().getString(C25738R.string.dna), true);
                    C7060h.pYm.mo8378a(795, 4, 1, false);
                }
                AppMethodBeat.m2505o(31602);
            }
        } else {
            AppMethodBeat.m2505o(31602);
        }
    }

    /* renamed from: b */
    static /* synthetic */ String m59484b(C36126ab c36126ab, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31604);
        int ox;
        if (c7620bi.isText() || c7620bi.dtz()) {
            String str = c7620bi.field_content;
            ox = C1829bf.m3761ox(str);
            if (ox != -1) {
                str = str.substring(ox + 1).trim();
            }
            AppMethodBeat.m2505o(31604);
            return str;
        }
        Activity context = c36126ab.cgL.yTx.getContext();
        ox = c7620bi.getType();
        String str2 = c7620bi.field_content;
        c36126ab.cgL.getTalkerUserName();
        C4990ab.m7417i("MicroMsg.ChattingUI.MsgRemindComponent", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.getType()), AllRemindMsgUI.m48280a(context, ox, str2, c7620bi.field_isSend));
        AppMethodBeat.m2505o(31604);
        return AllRemindMsgUI.m48280a(context, ox, str2, c7620bi.field_isSend);
    }
}
