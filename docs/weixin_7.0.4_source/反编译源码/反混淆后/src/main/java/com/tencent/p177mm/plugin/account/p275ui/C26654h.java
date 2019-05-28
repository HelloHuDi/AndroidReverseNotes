package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C33008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C38070b;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.h */
public final class C26654h implements C1202f, C38070b {
    private MobileInputUI gDo;
    private String gDp;
    private String gDq;
    private int gDr = 0;

    /* renamed from: com.tencent.mm.plugin.account.ui.h$1 */
    class C266551 implements OnCancelListener {
        C266551() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.h$3 */
    class C266563 implements OnClickListener {
        C266563() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125087);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_200,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_200")).append(",2").toString());
            AppMethodBeat.m2505o(125087);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.h$4 */
    class C266574 implements OnCancelListener {
        C266574() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.h$2 */
    class C266582 implements OnClickListener {
        C266582() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125086);
            C26654h.m42508a(C26654h.this);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_200,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_200")).append(",2").toString());
            AppMethodBeat.m2505o(125086);
        }
    }

    /* renamed from: a */
    public final void mo21369a(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125089);
        this.gDo = mobileInputUI;
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(C25738R.string.dm9);
        if (C7243d.vxr) {
            string = string + mobileInputUI.getString(C25738R.string.f8807fk);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDN.setText(C25738R.string.f9182s1);
        mobileInputUI.gDN.setVisibility(0);
        AppMethodBeat.m2505o(125089);
    }

    public final void start() {
        AppMethodBeat.m2504i(125090);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_100")).append(",1").toString());
        C42756a.m75798wz("F200_100");
        this.gDr = 0;
        AppMethodBeat.m2505o(125090);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125091);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("F200_100")).append(",2").toString());
        AppMethodBeat.m2505o(125091);
    }

    /* renamed from: a */
    public final void mo21368a(C33008a c33008a) {
        AppMethodBeat.m2504i(125092);
        switch (c33008a) {
            case GoNext:
                this.gDo.gDU = C5025av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDH.getText().toString();
                String str = this.gDo.gDU + this.gDo.gDV;
                if (this.gDo.guc == null) {
                    MobileInputUI mobileInputUI = this.gDo;
                    Context context = this.gDo;
                    this.gDo.getString(C25738R.string.f9238tz);
                    mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C266551());
                    String obj = this.gDo.gDH.getText().toString();
                    int i = (this.gDp == null || this.gDq == null || obj.equals(this.gDp) || !obj.equals(this.gDq)) ? (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || obj.equals(this.gDq)) ? 0 : 2 : 1;
                    C1207m c32815a = new C32815a(str, 12, "", 0, "");
                    c32815a.mo53384lo(this.gDr);
                    c32815a.mo53385lp(i);
                    C1720g.m3540Rg().mo14541a(c32815a, 0);
                    this.gDp = this.gDo.gDH.getText().toString();
                    this.gDr++;
                    break;
                }
                C4990ab.m7410d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                AppMethodBeat.m2505o(125092);
                return;
        }
        AppMethodBeat.m2505o(125092);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125093);
        C4990ab.m7416i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        C42124a jY;
        if (i2 == -75) {
            C30379h.m48467g(this.gDo, C25738R.string.f8810fn, C25738R.string.djw);
            AppMethodBeat.m2505o(125093);
        } else if (i2 == -41 || i2 == -59) {
            jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(this.gDo, null, null);
                AppMethodBeat.m2505o(125093);
                return;
            }
            C30379h.m48467g(this.gDo, C25738R.string.dl6, C25738R.string.dl7);
            AppMethodBeat.m2505o(125093);
        } else {
            if (c1207m.getType() == 145) {
                int Ah = ((C32815a) c1207m).mo53366Ah();
                if (Ah == 12) {
                    if (i2 == -36 || i2 == -35 || i2 == -3) {
                        String agi = ((C32815a) c1207m).agi();
                        if (!C5046bo.isNullOrNil(agi)) {
                            this.gDo.gDV = agi.trim();
                        }
                        this.gDo.gDV = C5025av.amN(this.gDo.gDV);
                        this.gDq = this.gDo.gDU + this.gDo.gDV;
                        StringBuilder stringBuilder = new StringBuilder();
                        C1720g.m3534RN();
                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                        C1720g.m3534RN();
                        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_200")).append(",1").toString());
                        jY = C42124a.m74268jY(str);
                        if (jY != null) {
                            jY.mo67668a(this.gDo, new C266582(), new C266563());
                            AppMethodBeat.m2505o(125093);
                            return;
                        }
                        arc();
                        stringBuilder = new StringBuilder();
                        C1720g.m3534RN();
                        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                        C1720g.m3534RN();
                        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("F200_200")).append(",2").toString());
                        AppMethodBeat.m2505o(125093);
                        return;
                    } else if (i2 == -34) {
                        C30379h.m48461b(this.gDo, this.gDo.getString(C25738R.string.a6k), "", true);
                        AppMethodBeat.m2505o(125093);
                        return;
                    } else {
                        Toast.makeText(this.gDo, this.gDo.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                }
                if (Ah == 8 && i2 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("bindmcontact_mobile", this.gDo.gDU + " " + this.gDo.gDH.getText().toString());
                    intent.putExtra("bindmcontact_shortmobile", this.gDo.gDV);
                    intent.putExtra("country_name", this.gDo.fHE);
                    intent.putExtra("couttry_code", this.gDo.countryCode);
                    intent.putExtra("mobileverify_countdownsec", ((C32815a) c1207m).agn());
                    intent.putExtra("mobileverify_countdownstyle", ((C32815a) c1207m).ago());
                    intent.putExtra("mobileverify_fb", ((C32815a) c1207m).agp());
                    intent.putExtra("mobileverify_reg_qq", ((C32815a) c1207m).agq());
                    intent.putExtra("mobile_verify_purpose", 3);
                    intent.setClass(this.gDo, MobileVerifyUI.class);
                    this.gDo.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(125093);
        }
    }

    private void arc() {
        AppMethodBeat.m2504i(125094);
        MobileInputUI mobileInputUI = this.gDo;
        Context context = this.gDo;
        this.gDo.getString(C25738R.string.f9238tz);
        mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C266574());
        C1720g.m3540Rg().mo14541a(new C32815a(this.gDo.gDU + this.gDo.gDV, 8, "", 0, ""), 0);
        AppMethodBeat.m2505o(125094);
    }
}
