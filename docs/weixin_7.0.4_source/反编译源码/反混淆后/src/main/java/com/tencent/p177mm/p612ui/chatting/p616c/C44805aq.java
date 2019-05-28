package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.pluginsdk.model.C46498m;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.c.aq */
public class C44805aq extends C44291a implements C1202f, C4931a, C4937b, C5326v {
    public final void dxz() {
        AppMethodBeat.m2504i(31841);
        C9638aw.m17182Rg().mo14539a(137, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this);
        AppMethodBeat.m2505o(31841);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31842);
        C9638aw.m17182Rg().mo14546b(137, (C1202f) this);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10121b(this);
        }
        AppMethodBeat.m2505o(31842);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31843);
        super.dDh();
        C9638aw.m17182Rg().mo14546b(137, (C1202f) this);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10121b(this);
        }
        AppMethodBeat.m2505o(31843);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(31844);
        C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + c1207m.getType());
        this.cgL.dismissDialog();
        if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.m2505o(31844);
        } else if (C5046bo.m7544cv(this.cgL.yTx.getContext())) {
            Activity context = this.cgL.yTx.getContext();
            if (!(C30784a.m49123a(context, i, i2, str, 7) || C30777u.m49118a(context, i, i2, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str))) {
                z = false;
            }
            if (z) {
                AppMethodBeat.m2505o(31844);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case 137:
                        List list = ((C46498m) c1207m).vbm;
                        if (list == null || list.contains(this.cgL.sRl.field_username)) {
                            C7616ad c7616ad = this.cgL.sRl;
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(c7616ad.field_username);
                            if (aoO == null || ((int) aoO.ewQ) == 0) {
                                C9638aw.m17190ZK();
                                if (C18628c.m29078XM().mo15701Y(c7616ad)) {
                                    C9638aw.m17190ZK();
                                    aoO = C18628c.m29078XM().aoO(c7616ad.field_username);
                                } else {
                                    C4990ab.m7412e("MicroMsg.ChattingUI.ChattingLogic", "insert contact failed, username = " + c7616ad.field_username);
                                    aoO = null;
                                }
                            }
                            if (aoO != null) {
                                C1855t.m3960q(aoO);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(31844);
        } else {
            AppMethodBeat.m2505o(31844);
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(31845);
        if (this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange ".concat(String.valueOf(i)));
            C9638aw.m17190ZK();
            C7616ad aoO = C18628c.m29078XM().aoO(this.cgL.getTalkerUserName());
            if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                if (C5046bo.isNullOrNil(aoO.field_nickname)) {
                    aoO.mo14703iB(this.cgL.sRl.field_nickname);
                }
                this.cgL.mo74859af(aoO);
                ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEm();
                ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64266qr(true);
                this.cgL.aWv();
            }
            AppMethodBeat.m2505o(31845);
            return;
        }
        C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onNotifyChange fragment not foreground, return");
        AppMethodBeat.m2505o(31845);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        while (true) {
        }
    }
}
