package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.p275ui.C10004g.C10008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7703b;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7711a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.ui.m */
public final class C42315m implements C1202f, C7703b {
    C31280f gBT = null;
    private int gDW;
    private C10004g gDu = null;
    MobileVerifyUI gEE;
    SecurityImage gue = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.m$2 */
    class C330422 implements OnClickListener {
        C330422() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125236);
            C4990ab.m7410d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + C42315m.this.gBT.guh + " img len" + C42315m.this.gBT.gug.length + " " + C1447g.m3075Mq());
            final C1207m c6686q = new C6686q(C42315m.this.gBT.account, C42315m.this.gBT.gCK, C42315m.this.gBT.gCL, C42315m.this.gue.getSecImgCode(), C42315m.this.gue.getSecImgSid(), C42315m.this.gue.getSecImgEncryptKey(), 1, "", false, true);
            C1720g.m3540Rg().mo14541a(c6686q, 0);
            Context context = C42315m.this.gEE;
            C42315m.this.gEE.getString(C25738R.string.f9238tz);
            C30379h.m48458b(context, C42315m.this.gEE.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125235);
                    C1720g.m3540Rg().mo14547c(c6686q);
                    C1720g.m3540Rg().mo14546b(701, C42315m.this);
                    C1720g.m3540Rg().mo14546b(252, C42315m.this);
                    AppMethodBeat.m2505o(125235);
                }
            });
            AppMethodBeat.m2505o(125236);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.m$3 */
    class C330433 implements OnDismissListener {
        C330433() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C42315m.this.gue = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.m$4 */
    class C380884 implements C10008a {
        C380884() {
        }

        /* renamed from: a */
        public final void mo17503a(ProgressDialog progressDialog) {
            C42315m.this.gEE.ehJ = progressDialog;
        }
    }

    public C42315m(int i) {
        AppMethodBeat.m2504i(125238);
        this.gDW = i;
        C4990ab.m7417i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(125238);
    }

    /* renamed from: a */
    public final void mo17520a(MobileVerifyUI mobileVerifyUI) {
        this.gEE = mobileVerifyUI;
    }

    public final void start() {
        AppMethodBeat.m2504i(125239);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_300,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_300")).append(",1").toString());
        C42756a.m75798wz("F200_300");
        AppMethodBeat.m2505o(125239);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125240);
        int i = 2;
        if (this.gEE.gFj != -1) {
            i = this.gEE.gFj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_300,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("F200_300")).append(",").append(i).toString());
        AppMethodBeat.m2505o(125240);
    }

    /* renamed from: a */
    public final boolean mo17521a(C7711a c7711a) {
        AppMethodBeat.m2504i(125241);
        switch (c7711a) {
            case GoNext:
                arg();
                break;
            case DoSend:
                StringBuilder stringBuilder = new StringBuilder();
                C1720g.m3534RN();
                stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_400,");
                C1720g.m3534RN();
                C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_400")).append(",1").toString());
                C1207m c1207m = null;
                if (this.gDW == 3) {
                    c1207m = new C32815a(this.gEE.cFl, 8, "", 0, "");
                } else if (this.gDW == 5) {
                    c1207m = new C38037x(this.gEE.cFl, 20, "", 0, "");
                }
                if (c1207m != null) {
                    C1720g.m3540Rg().mo14541a(c1207m, 0);
                    break;
                }
                break;
            case DoProcessSMS:
                arg();
                break;
        }
        AppMethodBeat.m2505o(125241);
        return false;
    }

    private void arg() {
        AppMethodBeat.m2504i(125242);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_350_auto,");
        C1720g.m3534RN();
        C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("R200_350_auto")).append(",1").toString());
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        C1207m c1207m = null;
        if (this.gDW == 3) {
            c1207m = new C32815a(this.gEE.cFl, 9, this.gEE.grL.getText().toString().trim(), 0, "");
        } else if (this.gDW == 5) {
            c1207m = new C38037x(this.gEE.cFl, 21, this.gEE.grL.getText().toString().trim(), 0, "");
        }
        if (c1207m != null) {
            C1720g.m3540Rg().mo14541a(c1207m, 0);
            MobileVerifyUI mobileVerifyUI = this.gEE;
            Context context = this.gEE;
            this.gEE.getString(C25738R.string.f9238tz);
            mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.a7n), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(125234);
                    C1720g.m3540Rg().mo14547c(c1207m);
                    C1720g.m3540Rg().mo14546b(145, C42315m.this);
                    C1720g.m3540Rg().mo14546b(132, C42315m.this);
                    AppMethodBeat.m2505o(125234);
                }
            });
        }
        AppMethodBeat.m2505o(125242);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125243);
        C4990ab.m7416i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        if (this.gBT == null) {
            this.gBT = new C31280f();
        }
        if ((c1207m.getType() == 252 || c1207m.getType() == 701) && this.gDu != null) {
            C1720g.m3540Rg().mo14546b(701, (C1202f) this);
            C1720g.m3540Rg().mo14546b(252, (C1202f) this);
            this.gBT.guh = ((C6686q) c1207m).ajn();
            this.gBT.gug = ((C6686q) c1207m).ajo();
            this.gBT.gui = ((C6686q) c1207m).ajp();
            this.gBT.gCL = ((C6686q) c1207m).getSecCodeType();
            if (i2 == -6 || i2 == -311 || i2 == -310) {
                C1720g.m3540Rg().mo14539a(701, (C1202f) this);
                C1720g.m3540Rg().mo14539a(252, (C1202f) this);
                if (this.gue == null) {
                    this.gue = C15492a.m23811a(this.gEE, this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui, new C330422(), null, new C330433(), this.gBT);
                    AppMethodBeat.m2505o(125243);
                    return;
                }
                C4990ab.m7410d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.gBT.guh + " img len" + this.gBT.gug.length + " " + C1447g.m3075Mq());
                this.gue.mo27573b(this.gBT.gCL, this.gBT.gug, this.gBT.guh, this.gBT.gui);
                AppMethodBeat.m2505o(125243);
                return;
            }
            this.gDu.mo21363a(this.gEE, i, i2, str, c1207m);
            if (i == 0 && i2 == 0) {
                boolean z = true;
                if (c1207m instanceof C6686q) {
                    z = ((C6686q) c1207m).ajv();
                }
                this.gEE.mo17510dq(z);
            }
            AppMethodBeat.m2505o(125243);
            return;
        }
        C42124a jY;
        if (c1207m.getType() == 145) {
            this.gBT.account = ((C32815a) c1207m).getUsername();
            this.gBT.gCK = ((C32815a) c1207m).agf();
            C1720g.m3540Rg().mo14546b(145, (C1202f) this);
            if (i == 0 && i2 == 0) {
                if (this.gDW == 3) {
                    C1720g.m3540Rg().mo14539a(701, (C1202f) this);
                    C1720g.m3540Rg().mo14539a(252, (C1202f) this);
                    this.gDu = new C10004g(new C380884(), ((C32815a) c1207m).getUsername(), ((C32815a) c1207m).agf(), this.gEE.cFl);
                    this.gDu.mo21362a(this.gEE);
                }
                AppMethodBeat.m2505o(125243);
                return;
            } else if (i2 == -51) {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this.gEE, null, null);
                    AppMethodBeat.m2505o(125243);
                    return;
                }
                C30379h.m48467g(this.gEE, C25738R.string.a7s, C25738R.string.a7y);
                AppMethodBeat.m2505o(125243);
                return;
            }
        }
        if (c1207m.getType() == 132) {
            C1720g.m3540Rg().mo14546b(132, (C1202f) this);
            if (i == 0 && i2 == 0) {
                if (this.gDW == 5) {
                    String agg = ((C38037x) c1207m).agg();
                    Intent intent = new Intent();
                    intent.putExtra("setpwd_ticket", agg);
                    this.gEE.setResult(-1, intent);
                    this.gEE.finish();
                }
                AppMethodBeat.m2505o(125243);
                return;
            } else if (i2 == -51) {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this.gEE, null, null);
                    AppMethodBeat.m2505o(125243);
                    return;
                }
                C30379h.m48467g(this.gEE, C25738R.string.a7s, C25738R.string.a7y);
                AppMethodBeat.m2505o(125243);
                return;
            }
        }
        if (this.gEE.mo17511j(i, i2, str)) {
            AppMethodBeat.m2505o(125243);
            return;
        }
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            jY = C42124a.m74268jY(str);
            if (jY != null && jY.mo67668a(this.gEE, null, null)) {
                AppMethodBeat.m2505o(125243);
                return;
            }
        }
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this.gEE, this.gEE.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
        AppMethodBeat.m2505o(125243);
    }
}
