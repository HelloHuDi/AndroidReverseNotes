package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

public final class m implements f, b {
    f gBT = null;
    private int gDW;
    private g gDu = null;
    MobileVerifyUI gEE;
    SecurityImage gue = null;

    public m(int i) {
        AppMethodBeat.i(125238);
        this.gDW = i;
        ab.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", Integer.valueOf(i));
        AppMethodBeat.o(125238);
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.gEE = mobileVerifyUI;
    }

    public final void start() {
        AppMethodBeat.i(125239);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_300,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_300")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("F200_300");
        AppMethodBeat.o(125239);
    }

    public final void stop() {
        AppMethodBeat.i(125240);
        int i = 2;
        if (this.gEE.gFj != -1) {
            i = this.gEE.gFj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_300,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(a.lF("F200_300")).append(",").append(i).toString());
        AppMethodBeat.o(125240);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(125241);
        switch (aVar) {
            case GoNext:
                arg();
                break;
            case DoSend:
                StringBuilder stringBuilder = new StringBuilder();
                g.RN();
                stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_400,");
                g.RN();
                com.tencent.mm.plugin.b.a.wB(stringBuilder.append(a.lF("R200_400")).append(",1").toString());
                com.tencent.mm.ai.m mVar = null;
                if (this.gDW == 3) {
                    mVar = new com.tencent.mm.modelfriend.a(this.gEE.cFl, 8, "", 0, "");
                } else if (this.gDW == 5) {
                    mVar = new x(this.gEE.cFl, 20, "", 0, "");
                }
                if (mVar != null) {
                    g.Rg().a(mVar, 0);
                    break;
                }
                break;
            case DoProcessSMS:
                arg();
                break;
        }
        AppMethodBeat.o(125241);
        return false;
    }

    private void arg() {
        AppMethodBeat.i(125242);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_350_auto,");
        g.RN();
        com.tencent.mm.plugin.b.a.wB(stringBuilder.append(a.lF("R200_350_auto")).append(",1").toString());
        g.Rg().a(145, (f) this);
        g.Rg().a(132, (f) this);
        com.tencent.mm.ai.m mVar = null;
        if (this.gDW == 3) {
            mVar = new com.tencent.mm.modelfriend.a(this.gEE.cFl, 9, this.gEE.grL.getText().toString().trim(), 0, "");
        } else if (this.gDW == 5) {
            mVar = new x(this.gEE.cFl, 21, this.gEE.grL.getText().toString().trim(), 0, "");
        }
        if (mVar != null) {
            g.Rg().a(mVar, 0);
            MobileVerifyUI mobileVerifyUI = this.gEE;
            Context context = this.gEE;
            this.gEE.getString(R.string.tz);
            mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.a7n), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(125234);
                    g.Rg().c(mVar);
                    g.Rg().b(145, m.this);
                    g.Rg().b(132, m.this);
                    AppMethodBeat.o(125234);
                }
            });
        }
        AppMethodBeat.o(125242);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(125243);
        ab.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        if (this.gBT == null) {
            this.gBT = new f();
        }
        if ((mVar.getType() == 252 || mVar.getType() == 701) && this.gDu != null) {
            g.Rg().b(701, (f) this);
            g.Rg().b(252, (f) this);
            this.gBT.guh = ((q) mVar).ajn();
            this.gBT.gug = ((q) mVar).ajo();
            this.gBT.gui = ((q) mVar).ajp();
            this.gBT.gCL = ((q) mVar).getSecCodeType();
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                g.Rg().a(701, (f) this);
                g.Rg().a(252, (f) this);
                if (this.gue == null) {
                    this.gue = SecurityImage.a.a(this.gEE, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(125236);
                            ab.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + m.this.gBT.guh + " img len" + m.this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                            final com.tencent.mm.ai.m qVar = new q(m.this.gBT.account, m.this.gBT.gCK, m.this.gBT.gCL, m.this.gue.getSecImgCode(), m.this.gue.getSecImgSid(), m.this.gue.getSecImgEncryptKey(), 1, "", false, true);
                            g.Rg().a(qVar, 0);
                            Context context = m.this.gEE;
                            m.this.gEE.getString(R.string.tz);
                            h.b(context, m.this.gEE.getString(R.string.cou), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(125235);
                                    g.Rg().c(qVar);
                                    g.Rg().b(701, m.this);
                                    g.Rg().b(252, m.this);
                                    AppMethodBeat.o(125235);
                                }
                            });
                            AppMethodBeat.o(125236);
                        }
                    }, null, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            m.this.gue = null;
                        }
                    }, this.gBT);
                    AppMethodBeat.o(125243);
                    return;
                }
                ab.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + com.tencent.mm.compatible.util.g.Mq());
                this.gue.b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                AppMethodBeat.o(125243);
                return;
            }
            this.gDu.a(this.gEE, i, i2, str, mVar);
            if (i == 0 && i2 == 0) {
                boolean z = true;
                if (mVar instanceof q) {
                    z = ((q) mVar).ajv();
                }
                this.gEE.dq(z);
            }
            AppMethodBeat.o(125243);
            return;
        }
        com.tencent.mm.h.a jY;
        if (mVar.getType() == 145) {
            this.gBT.account = ((com.tencent.mm.modelfriend.a) mVar).getUsername();
            this.gBT.gCK = ((com.tencent.mm.modelfriend.a) mVar).agf();
            g.Rg().b(145, (f) this);
            if (i == 0 && i2 == 0) {
                if (this.gDW == 3) {
                    g.Rg().a(701, (f) this);
                    g.Rg().a(252, (f) this);
                    this.gDu = new g(new g.a() {
                        public final void a(ProgressDialog progressDialog) {
                            m.this.gEE.ehJ = progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) mVar).getUsername(), ((com.tencent.mm.modelfriend.a) mVar).agf(), this.gEE.cFl);
                    this.gDu.a(this.gEE);
                }
                AppMethodBeat.o(125243);
                return;
            } else if (i2 == -51) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this.gEE, null, null);
                    AppMethodBeat.o(125243);
                    return;
                }
                h.g(this.gEE, R.string.a7s, R.string.a7y);
                AppMethodBeat.o(125243);
                return;
            }
        }
        if (mVar.getType() == 132) {
            g.Rg().b(132, (f) this);
            if (i == 0 && i2 == 0) {
                if (this.gDW == 5) {
                    String agg = ((x) mVar).agg();
                    Intent intent = new Intent();
                    intent.putExtra("setpwd_ticket", agg);
                    this.gEE.setResult(-1, intent);
                    this.gEE.finish();
                }
                AppMethodBeat.o(125243);
                return;
            } else if (i2 == -51) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this.gEE, null, null);
                    AppMethodBeat.o(125243);
                    return;
                }
                h.g(this.gEE, R.string.a7s, R.string.a7y);
                AppMethodBeat.o(125243);
                return;
            }
        }
        if (this.gEE.j(i, i2, str)) {
            AppMethodBeat.o(125243);
            return;
        }
        if (mVar.getType() == 252 || mVar.getType() == 701) {
            jY = com.tencent.mm.h.a.jY(str);
            if (jY != null && jY.a(this.gEE, null, null)) {
                AppMethodBeat.o(125243);
                return;
            }
        }
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this.gEE, this.gEE.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        AppMethodBeat.o(125243);
    }
}
