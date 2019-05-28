package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C18678t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C23701al;
import com.tencent.p177mm.p612ui.chatting.C23701al.C23702a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30471y;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19314g;
import com.tencent.p177mm.protocal.protobuf.btj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

@C15590a(dFp = C30471y.class)
/* renamed from: com.tencent.mm.ui.chatting.c.af */
public class C36131af extends C44291a implements C1202f, C30471y {
    private final C4884c edy = new C23701al(C23702a.CHATTING_ITEM_VIDEO, null);
    private C5653c yRn = null;

    /* renamed from: com.tencent.mm.ui.chatting.c.af$3 */
    class C53073 implements OnClickListener {
        C53073() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31633);
            if (C36131af.this.yRn != null) {
                C36131af.this.yRn.dismiss();
            }
            AppMethodBeat.m2505o(31633);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.af$4 */
    class C53084 implements OnClickListener {
        C53084() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31634);
            if (C36131af.this.yRn != null) {
                C36131af.this.yRn.dismiss();
            }
            AppMethodBeat.m2505o(31634);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.c.af$2 */
    class C361302 implements OnClickListener {
        C361302() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(31632);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            AppMethodBeat.m2505o(31632);
        }
    }

    public C36131af() {
        AppMethodBeat.m2504i(31635);
        AppMethodBeat.m2505o(31635);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31636);
        C9638aw.m17182Rg().mo14539a((int) C19314g.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31636);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31637);
        if (!C4879a.xxA.mo10054e(this.edy)) {
            C4879a.xxA.mo10052c(this.edy);
        }
        AppMethodBeat.m2505o(31637);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31638);
        C4879a.xxA.mo10053d(this.edy);
        AppMethodBeat.m2505o(31638);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31639);
        C9638aw.m17182Rg().mo14546b((int) C19314g.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31639);
    }

    public final void dDh() {
        AppMethodBeat.m2504i(31640);
        super.dDh();
        C4879a.xxA.mo10053d(this.edy);
        C9638aw.m17182Rg().mo14546b((int) C19314g.CTRL_INDEX, (C1202f) this);
        AppMethodBeat.m2505o(31640);
    }

    /* renamed from: bj */
    public final void mo48870bj(final C7620bi c7620bi) {
        AppMethodBeat.m2504i(31641);
        final C1207m c18678t = new C18678t(c7620bi, this.cgL.yTx.getMMResources().getString(C25738R.string.ao0));
        this.cgL.mo74862c(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.anz), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(31631);
                C4990ab.m7417i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", Long.valueOf(c7620bi.field_msgId));
                C9638aw.m17182Rg().mo14547c(c18678t);
                AppMethodBeat.m2505o(31631);
            }
        });
        C9638aw.m17182Rg().mo14541a(c18678t, 0);
        AppMethodBeat.m2505o(31641);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(31642);
        C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + c1207m.getType());
        this.cgL.dismissDialog();
        if (this.yRn != null) {
            this.yRn.dismiss();
            this.yRn = null;
        }
        if (!this.cgL.caA) {
            C4990ab.m7416i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.m2505o(31642);
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
                AppMethodBeat.m2505o(31642);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case C19314g.CTRL_INDEX /*594*/:
                        btj ajB = ((C18678t) c1207m).ajB();
                        if (!C5046bo.isNullOrNil(ajB.wVs)) {
                            C30379h.m48443a(this.cgL.yTx.getContext(), ajB.wVs, "", this.cgL.yTx.getMMResources().getString(C25738R.string.anx), new C361302());
                            AppMethodBeat.m2505o(31642);
                            return;
                        }
                        break;
                    default:
                        AppMethodBeat.m2505o(31642);
                        return;
                }
            } else if (c1207m.getType() == C19314g.CTRL_INDEX) {
                btj ajB2 = ((C18678t) c1207m).ajB();
                C4990ab.m7411d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", ajB2.wVt);
                if (i2 == 0 || C5046bo.isNullOrNil(ajB2.wVt)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 == 0) {
                    C4990ab.m7411d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", ajB2.wVt);
                    this.yRn = C30379h.m48443a(this.cgL.yTx.getContext(), ajB2.wVt, "", this.cgL.yTx.getMMResources().getString(C25738R.string.anx), new C53073());
                    AppMethodBeat.m2505o(31642);
                    return;
                }
                C4990ab.m7411d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i2), ajB2.wVt);
                this.yRn = C30379h.m48443a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(C25738R.string.any), "", this.cgL.yTx.getMMResources().getString(C25738R.string.anx), new C53084());
            }
            AppMethodBeat.m2505o(31642);
        } else {
            AppMethodBeat.m2505o(31642);
        }
    }
}
