package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.u;
import java.util.List;

public class aq extends a implements f, a, b, v {
    public final void dxz() {
        AppMethodBeat.i(31841);
        aw.Rg().a(137, (f) this);
        aw.ZK();
        c.XM().a(this);
        AppMethodBeat.o(31841);
    }

    public final void dxC() {
        AppMethodBeat.i(31842);
        aw.Rg().b(137, (f) this);
        if (aw.RK()) {
            aw.ZK();
            c.XM().b(this);
        }
        AppMethodBeat.o(31842);
    }

    public final void dDh() {
        AppMethodBeat.i(31843);
        super.dDh();
        aw.Rg().b(137, (f) this);
        if (aw.RK()) {
            aw.ZK();
            c.XM().b(this);
        }
        AppMethodBeat.o(31843);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = true;
        AppMethodBeat.i(31844);
        ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + mVar.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(31844);
        } else if (bo.cv(this.cgL.yTx.getContext())) {
            Activity context = this.cgL.yTx.getContext();
            if (!(u.a.a(context, i, i2, str, 7) || u.a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(31844);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case 137:
                        List list = ((com.tencent.mm.pluginsdk.model.m) mVar).vbm;
                        if (list == null || list.contains(this.cgL.sRl.field_username)) {
                            ad adVar = this.cgL.sRl;
                            aw.ZK();
                            ad aoO = c.XM().aoO(adVar.field_username);
                            if (aoO == null || ((int) aoO.ewQ) == 0) {
                                aw.ZK();
                                if (c.XM().Y(adVar)) {
                                    aw.ZK();
                                    aoO = c.XM().aoO(adVar.field_username);
                                } else {
                                    ab.e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + adVar.field_username);
                                    aoO = null;
                                }
                            }
                            if (aoO != null) {
                                t.q(aoO);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(31844);
        } else {
            AppMethodBeat.o(31844);
        }
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(31845);
        if (this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(i)));
            aw.ZK();
            ad aoO = c.XM().aoO(this.cgL.getTalkerUserName());
            if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                if (bo.isNullOrNil(aoO.field_nickname)) {
                    aoO.iB(this.cgL.sRl.field_nickname);
                }
                this.cgL.af(aoO);
                ((r) this.cgL.aF(r.class)).dEm();
                ((r) this.cgL.aF(r.class)).qr(true);
                this.cgL.aWv();
            }
            AppMethodBeat.o(31845);
            return;
        }
        ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
        AppMethodBeat.o(31845);
    }

    public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
        while (true) {
        }
    }
}
