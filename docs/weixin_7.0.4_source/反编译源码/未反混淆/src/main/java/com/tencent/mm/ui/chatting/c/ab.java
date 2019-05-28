package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.w;
import com.tencent.mm.ui.chatting.view.b;
import com.tencent.mm.ui.u;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@a(dFp = w.class)
public class ab extends a implements f, w {
    static /* synthetic */ void a(ab abVar, bi biVar) {
        AppMethodBeat.i(31603);
        abVar.ba(biVar);
        AppMethodBeat.o(31603);
    }

    public final void dxz() {
        AppMethodBeat.i(31597);
        aw.Rg().a((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31597);
    }

    public final void dxC() {
        AppMethodBeat.i(31598);
        aw.Rg().b((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31598);
    }

    public final void dDh() {
        AppMethodBeat.i(31599);
        super.dDh();
        aw.Rg().b((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31599);
    }

    public final void j(MenuItem menuItem) {
        AppMethodBeat.i(31600);
        final bi Ou = ((h) this.cgL.aF(h.class)).Ou(menuItem.getGroupId());
        if (Ou == null) {
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "context item select failed, null msg");
            AppMethodBeat.o(31600);
            return;
        }
        switch (menuItem.getItemId()) {
            case d.CTRL_INDEX /*134*/:
                aw.ZK();
                if (!((Boolean) c.Ry().get(ac.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                    ba(Ou);
                    break;
                }
                com.tencent.mm.ui.base.h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.dnd), this.cgL.yTx.getMMResources().getString(R.string.dne), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31594);
                        ab.a(ab.this, Ou);
                        AppMethodBeat.o(31594);
                    }
                });
                aw.ZK();
                c.Ry().set(ac.a.USERINFO_POSITION_REMIND_MSG_TIP_IN_BOOLEAN, Boolean.FALSE);
                AppMethodBeat.o(31600);
                return;
        }
        AppMethodBeat.o(31600);
    }

    private void ba(final bi biVar) {
        AppMethodBeat.i(31601);
        final b bVar = new b(this.cgL.yTx.getContext());
        bVar.zaY = new b.a() {
            public final void ne(long j) {
                AppMethodBeat.i(31595);
                bVar.hide();
                com.tencent.mm.plugin.report.service.h.pYm.a(795, 1, 1, false);
                if (NetUtil.isConnected(ab.this.cgL.yTx.getContext())) {
                    bre bre = new bre();
                    bre.lvf = (int) (j / 1000);
                    bre.jCt = 1;
                    bre.wOI = 1;
                    try {
                        bdl bdl = new bdl();
                        bdl.jBB = ab.this.cgL.getTalkerUserName();
                        bdl.ptF = biVar.field_msgSvrId;
                        bdl.Title = ab.b(ab.this, biVar);
                        bre.wcJ = new com.tencent.mm.bt.b(bdl.toByteArray());
                    } catch (IOException e) {
                        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "[onOk] %s", e.toString());
                    }
                    aw.Rg().a(new com.tencent.mm.modelsimple.w(1, bre), 0);
                    AppMethodBeat.o(31595);
                    return;
                }
                com.tencent.mm.ui.base.h.b(ab.this.cgL.yTx.getContext(), ab.this.cgL.yTx.getMMResources().getString(R.string.d5l), ab.this.cgL.yTx.getMMResources().getString(R.string.dna), true);
                AppMethodBeat.o(31595);
            }

            public final void onCancel() {
                AppMethodBeat.i(31596);
                bVar.hide();
                AppMethodBeat.o(31596);
            }
        };
        bVar.show();
        com.tencent.mm.plugin.report.service.h.pYm.a(795, 0, 1, false);
        AppMethodBeat.o(31601);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(31602);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + mVar.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(31602);
        } else if (bo.cv(this.cgL.yTx.getContext())) {
            int i3;
            Activity context = this.cgL.yTx.getContext();
            if (u.a.a(context, i, i2, str, 7)) {
                i3 = 1;
            } else if (u.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                AppMethodBeat.o(31602);
            } else if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case i.CTRL_INDEX /*525*/:
                        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "set msg remind!");
                        com.tencent.mm.ui.widget.snackbar.b.a(this.cgL.yTx.getContext(), this.cgL.yTx.getView(), this.cgL.yTx.getMMResources().getString(R.string.cbl), "");
                        AppMethodBeat.o(31602);
                        return;
                    default:
                        AppMethodBeat.o(31602);
                        return;
                }
            } else {
                if (mVar.getType() == i.CTRL_INDEX) {
                    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingUI.MsgRemindComponent", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(i.CTRL_INDEX), Integer.valueOf(i2), Integer.valueOf(i), bo.nullAsNil(str));
                    Context context2 = this.cgL.yTx.getContext();
                    if (bo.isNullOrNil(str)) {
                        str = this.cgL.yTx.getMMResources().getString(R.string.dn_);
                    }
                    com.tencent.mm.ui.base.h.b(context2, str, this.cgL.yTx.getMMResources().getString(R.string.dna), true);
                    com.tencent.mm.plugin.report.service.h.pYm.a(795, 4, 1, false);
                }
                AppMethodBeat.o(31602);
            }
        } else {
            AppMethodBeat.o(31602);
        }
    }

    static /* synthetic */ String b(ab abVar, bi biVar) {
        AppMethodBeat.i(31604);
        int ox;
        if (biVar.isText() || biVar.dtz()) {
            String str = biVar.field_content;
            ox = bf.ox(str);
            if (ox != -1) {
                str = str.substring(ox + 1).trim();
            }
            AppMethodBeat.o(31604);
            return str;
        }
        Activity context = abVar.cgL.yTx.getContext();
        ox = biVar.getType();
        String str2 = biVar.field_content;
        abVar.cgL.getTalkerUserName();
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingUI.MsgRemindComponent", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.getType()), AllRemindMsgUI.a(context, ox, str2, biVar.field_isSend));
        AppMethodBeat.o(31604);
        return AllRemindMsgUI.a(context, ox, str2, biVar.field_isSend);
    }
}
