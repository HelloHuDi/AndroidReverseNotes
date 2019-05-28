package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.appbrand.jsapi.b.g;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.y;
import com.tencent.mm.ui.u;

@a(dFp = y.class)
public class af extends a implements f, y {
    private final c edy = new al(al.a.CHATTING_ITEM_VIDEO, null);
    private com.tencent.mm.ui.widget.a.c yRn = null;

    public af() {
        AppMethodBeat.i(31635);
        AppMethodBeat.o(31635);
    }

    public final void dxz() {
        AppMethodBeat.i(31636);
        aw.Rg().a((int) g.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31636);
    }

    public final void dxA() {
        AppMethodBeat.i(31637);
        if (!com.tencent.mm.sdk.b.a.xxA.e(this.edy)) {
            com.tencent.mm.sdk.b.a.xxA.c(this.edy);
        }
        AppMethodBeat.o(31637);
    }

    public final void dxB() {
        AppMethodBeat.i(31638);
        com.tencent.mm.sdk.b.a.xxA.d(this.edy);
        AppMethodBeat.o(31638);
    }

    public final void dxC() {
        AppMethodBeat.i(31639);
        aw.Rg().b((int) g.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31639);
    }

    public final void dDh() {
        AppMethodBeat.i(31640);
        super.dDh();
        com.tencent.mm.sdk.b.a.xxA.d(this.edy);
        aw.Rg().b((int) g.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31640);
    }

    public final void bj(final bi biVar) {
        AppMethodBeat.i(31641);
        final m tVar = new t(biVar, this.cgL.yTx.getMMResources().getString(R.string.ao0));
        this.cgL.c(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.anz), new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(31631);
                ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "cancel revoke msg:%d", Long.valueOf(biVar.field_msgId));
                aw.Rg().c(tVar);
                AppMethodBeat.o(31631);
            }
        });
        aw.Rg().a(tVar, 0);
        AppMethodBeat.o(31641);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(31642);
        ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + mVar.getType());
        this.cgL.dismissDialog();
        if (this.yRn != null) {
            this.yRn.dismiss();
            this.yRn = null;
        }
        if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUI.VerifyUserComponent", "onSceneEnd fragment not foreground, return");
            AppMethodBeat.o(31642);
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
                AppMethodBeat.o(31642);
                return;
            }
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case g.CTRL_INDEX /*594*/:
                        btj ajB = ((t) mVar).ajB();
                        if (!bo.isNullOrNil(ajB.wVs)) {
                            h.a(this.cgL.yTx.getContext(), ajB.wVs, "", this.cgL.yTx.getMMResources().getString(R.string.anx), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(31632);
                                    if (dialogInterface != null) {
                                        dialogInterface.dismiss();
                                    }
                                    AppMethodBeat.o(31632);
                                }
                            });
                            AppMethodBeat.o(31642);
                            return;
                        }
                        break;
                    default:
                        AppMethodBeat.o(31642);
                        return;
                }
            } else if (mVar.getType() == g.CTRL_INDEX) {
                btj ajB2 = ((t) mVar).ajB();
                ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsgTimeout] sysWording:%s", ajB2.wVt);
                if (i2 == 0 || bo.isNullOrNil(ajB2.wVt)) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 == 0) {
                    ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] sysWording:%s", ajB2.wVt);
                    this.yRn = h.a(this.cgL.yTx.getContext(), ajB2.wVt, "", this.cgL.yTx.getMMResources().getString(R.string.anx), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(31633);
                            if (af.this.yRn != null) {
                                af.this.yRn.dismiss();
                            }
                            AppMethodBeat.o(31633);
                        }
                    });
                    AppMethodBeat.o(31642);
                    return;
                }
                ab.d("MicroMsg.ChattingUI.VerifyUserComponent", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i2), ajB2.wVt);
                this.yRn = h.a(this.cgL.yTx.getContext(), this.cgL.yTx.getMMResources().getString(R.string.any), "", this.cgL.yTx.getMMResources().getString(R.string.anx), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(31634);
                        if (af.this.yRn != null) {
                            af.this.yRn.dismiss();
                        }
                        AppMethodBeat.o(31634);
                    }
                });
            }
            AppMethodBeat.o(31642);
        } else {
            AppMethodBeat.o(31642);
        }
    }
}
