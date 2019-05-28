package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.model.C32978j;
import com.tencent.p177mm.plugin.account.model.C32978j.C32982a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C33008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C38070b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.crs;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.ui.k */
public final class C42308k implements C1202f, C38070b {
    private MobileInputUI gDo;
    private String gDp;
    private String gDq;
    private int gDr = 0;
    private String gDy;
    int gDz = 1;

    /* renamed from: com.tencent.mm.plugin.account.ui.k$9 */
    class C189649 implements OnClickListener {
        C189649() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125125);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_200,");
            C1720g.m3534RN();
            C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_200")).append(",2").toString());
            AppMethodBeat.m2505o(125125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.k$10 */
    class C2666010 implements OnCancelListener {
        C2666010() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.k$8 */
    class C423078 implements OnClickListener {
        C423078() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125124);
            C42308k.m74823a(C42308k.this);
            AppMethodBeat.m2505o(125124);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.k$7 */
    class C423097 implements OnCancelListener {
        C423097() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: a */
    public final void mo21369a(final MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125126);
        this.gDo = mobileInputUI;
        String str = "";
        if (C7243d.vxr) {
            str = str + mobileInputUI.getString(C25738R.string.f8807fk);
        }
        mobileInputUI.setMMTitle(str);
        mobileInputUI.showOptionMenu(false);
        mobileInputUI.gDO.setVisibility(0);
        mobileInputUI.gDO.setVisibility(0);
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDK.setVisibility(0);
        mobileInputUI.gCV.setVisibility(0);
        mobileInputUI.gDS.setVisibility(8);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDN.setText(C25738R.string.cpa);
        if (mobileInputUI.gDM != null) {
            mobileInputUI.gDM.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125114);
                    C5046bo.m7506M(mobileInputUI, mobileInputUI.getString(C25738R.string.ezj));
                    AppMethodBeat.m2505o(125114);
                }
            });
        }
        str = mobileInputUI.getString(C25738R.string.cmf);
        String str2 = "  ";
        String string;
        String string2;
        String string3;
        Spannable newSpannable;
        if (C4988aa.doo()) {
            string = mobileInputUI.getString(C25738R.string.cmg);
            string2 = mobileInputUI.getString(C25738R.string.dei);
            string3 = mobileInputUI.getString(C25738R.string.f8812fq);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125116);
                    C5046bo.m7506M(mobileInputUI.mController.ylL, mobileInputUI.getString(C25738R.string.ezj));
                    AppMethodBeat.m2505o(125116);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.m2504i(125117);
                    textPaint.setColor(mobileInputUI.getResources().getColor(C25738R.color.f12123t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.m2505o(125117);
                }
            }, str.length() + str2.length(), (str.length() + string.length()) + str2.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125118);
                    C5046bo.m7506M(mobileInputUI, C4996ah.getResources().getString(C25738R.string.g7o, new Object[]{C4988aa.m7403gw(mobileInputUI), C4988aa.doq(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
                    AppMethodBeat.m2505o(125118);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.m2504i(125119);
                    textPaint.setColor(mobileInputUI.getResources().getColor(C25738R.color.f12123t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.m2505o(125119);
                }
            }, ((str.length() + str2.length()) + string.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.gDL.setText(newSpannable);
        } else {
            string = mobileInputUI.getString(C25738R.string.cmk);
            string2 = mobileInputUI.getString(C25738R.string.cmi);
            string3 = mobileInputUI.getString(C25738R.string.f8812fq);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125120);
                    C5046bo.m7506M(mobileInputUI.mController.ylL, mobileInputUI.getString(C25738R.string.ezo));
                    AppMethodBeat.m2505o(125120);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.m2504i(125121);
                    textPaint.setColor(mobileInputUI.getResources().getColor(C25738R.color.f12123t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.m2505o(125121);
                }
            }, str.length() + str2.length(), (str.length() + str2.length()) + string.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125122);
                    C5046bo.m7506M(mobileInputUI, C4996ah.getResources().getString(C25738R.string.g7o, new Object[]{C4988aa.m7403gw(mobileInputUI), C4988aa.doq(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
                    AppMethodBeat.m2505o(125122);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.m2504i(125123);
                    textPaint.setColor(mobileInputUI.getResources().getColor(C25738R.color.f12123t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.m2505o(125123);
                }
            }, ((str.length() + string.length()) + str2.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.gDL.setText(newSpannable);
        }
        mobileInputUI.gDL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.m2505o(125126);
    }

    public final void start() {
        AppMethodBeat.m2504i(125127);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_100")).append(",1").toString());
        C42756a.m75798wz("R200_100");
        this.gDr = 0;
        AppMethodBeat.m2505o(125127);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125128);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("R200_100")).append(",2").toString());
        AppMethodBeat.m2505o(125128);
    }

    /* renamed from: a */
    public final void mo21368a(C33008a c33008a) {
        AppMethodBeat.m2504i(125129);
        switch (c33008a) {
            case GoNext:
                this.gDo.aqX();
                switch (this.gDz) {
                    case 1:
                        C32921a.m53856b(this.gDo, this.gDo.getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), C17950b.m28212m(this.gDo, this.gDo.countryCode, this.gDo.getString(C25738R.string.b3_)), "reg", Integer.valueOf(1), Integer.valueOf(0)}), 32047, false);
                        break;
                    case 2:
                        arc();
                        break;
                    default:
                        this.gDo.gDU = C5025av.amP(this.gDo.countryCode);
                        this.gDo.gDV = this.gDo.gDH.getText().toString();
                        String str = this.gDo.gDU + this.gDo.gDV;
                        if (C32921a.m53854O(this.gDo, this.gDo.gBJ.getText().toString())) {
                            if (this.gDo.guc != null && this.gDo.guc.isShowing()) {
                                C4990ab.m7410d("MicroMsg.MobileInputRegLogic", "already checking ");
                                break;
                            }
                            int i;
                            int i2;
                            MobileInputUI mobileInputUI = this.gDo;
                            Context context = this.gDo;
                            this.gDo.getString(C25738R.string.f9238tz);
                            mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C423097());
                            String obj = this.gDo.gDH.getText().toString();
                            if (this.gDp != null && this.gDq != null && !obj.equals(this.gDp) && obj.equals(this.gDq)) {
                                i = 1;
                            } else if (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || obj.equals(this.gDq)) {
                                i = 0;
                            } else {
                                i = 2;
                            }
                            C1207m c32815a = new C32815a(str, 12, "", 0, "");
                            c32815a.mo53384lo(this.gDr);
                            c32815a.mo53385lp(i);
                            if (C6998b.oTO.mo8088TL("ie_reg_eu")) {
                                C6998b.oTO.mo8087TK("ie_reg_eu");
                            }
                            crs crs = new crs();
                            crs.xpk = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8089TM("ie_reg_eu"));
                            crs.xpl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8092TP("ce_reg_eu"));
                            if (C17950b.m28217sP(this.gDo.countryCode)) {
                                i2 = 4;
                            } else {
                                i2 = 6;
                            }
                            crs.xpm = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8082Am(i2));
                            c32815a.mo53367a(crs);
                            C1720g.m3540Rg().mo14541a(c32815a, 0);
                            this.gDp = this.gDo.gDH.getText().toString();
                            this.gDr++;
                            break;
                        }
                        break;
                }
                this.gDz = 0;
                break;
        }
        AppMethodBeat.m2505o(125129);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125130);
        C4990ab.m7416i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (i2 == -75) {
            C30379h.m48467g(this.gDo, C25738R.string.f8810fn, C25738R.string.djw);
            AppMethodBeat.m2505o(125130);
            return;
        }
        if (c1207m.getType() == 145) {
            C42124a jY;
            if (i2 == -41 || i2 == -59) {
                jY = C42124a.m74268jY(str);
                if (jY != null) {
                    jY.mo67668a(this.gDo, null, null);
                    AppMethodBeat.m2505o(125130);
                    return;
                }
                C30379h.m48467g(this.gDo, C25738R.string.dl6, C25738R.string.dl7);
                AppMethodBeat.m2505o(125130);
                return;
            }
            String agi;
            int Ah = ((C32815a) c1207m).mo53366Ah();
            if (Ah == 12) {
                this.gDo.gDV = C5025av.amN(this.gDo.gDV);
                this.gDq = this.gDo.gDU + this.gDo.gDV;
                this.gDy = ((C32815a) c1207m).agt();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    agi = ((C32815a) c1207m).agi();
                    if (!C5046bo.isNullOrNil(agi)) {
                        this.gDo.gDV = agi.trim();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_200,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_200")).append(",1").toString());
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this.gDo, new C423078(), new C189649());
                        AppMethodBeat.m2505o(125130);
                        return;
                    }
                    arc();
                    stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",R200_200,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("R200_200")).append(",2").toString());
                    AppMethodBeat.m2505o(125130);
                    return;
                } else if (i2 == -355) {
                    C42257z.m74635f(this.gDo, str, 32046);
                    AppMethodBeat.m2505o(125130);
                    return;
                } else if (i2 == -34) {
                    C30379h.m48461b(this.gDo, this.gDo.getString(C25738R.string.a6k), "", true);
                    AppMethodBeat.m2505o(125130);
                    return;
                }
            }
            if (Ah == 14) {
                if (i2 == 0 || str == null) {
                    if (((C32815a) c1207m).agj() == 1) {
                        String str2 = this.gDo.gDU + this.gDo.gDV;
                        agi = ((C32815a) c1207m).agl();
                        String agk = ((C32815a) c1207m).agk();
                        Intent intent = new Intent(this.gDo, RegByMobileSendSmsUI.class);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", agi);
                        intent.putExtra("verify_code", agk);
                        intent.putExtra("key_reg_style", 2);
                        intent.putExtra("kintent_password", this.gDo.gBJ.getText().toString());
                        intent.putExtra("regsession_id", this.gDy);
                        this.gDo.startActivity(intent);
                    } else {
                        C42756a.m75796wA("R200_300");
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.gDo.gDU + " " + this.gDo.gDH.getText().toString());
                        intent2.putExtra("bindmcontact_shortmobile", this.gDo.gDV);
                        intent2.putExtra("country_name", this.gDo.fHE);
                        intent2.putExtra("couttry_code", this.gDo.countryCode);
                        intent2.putExtra("mobileverify_countdownsec", ((C32815a) c1207m).agn());
                        intent2.putExtra("mobileverify_countdownstyle", ((C32815a) c1207m).ago());
                        intent2.putExtra("mobileverify_fb", ((C32815a) c1207m).agp());
                        intent2.putExtra("mobileverify_reg_qq", ((C32815a) c1207m).agq());
                        intent2.putExtra("key_reg_style", 2);
                        intent2.putExtra("kintent_password", this.gDo.gBJ.getText().toString());
                        intent2.putExtra("mobile_verify_purpose", 2);
                        intent2.putExtra("regsession_id", this.gDy);
                        intent2.setClass(this.gDo, MobileVerifyUI.class);
                        this.gDo.startActivity(intent2);
                        C32978j.m53917a(C32982a.SENT);
                    }
                } else if (i2 == -34) {
                    C30379h.m48461b(this.gDo, this.gDo.getString(C25738R.string.a6k), "", true);
                    AppMethodBeat.m2505o(125130);
                    return;
                } else if (C24679a.gkF.mo38859a(this.gDo, i, i2, str)) {
                    AppMethodBeat.m2505o(125130);
                    return;
                }
            }
            jY = C42124a.m74268jY(str);
            if (!(jY == null || this.gDo == null || !jY.mo67668a(this.gDo, null, null))) {
                AppMethodBeat.m2505o(125130);
                return;
            }
        }
        AppMethodBeat.m2505o(125130);
    }

    private void arc() {
        AppMethodBeat.m2504i(125131);
        MobileInputUI mobileInputUI = this.gDo;
        Context context = this.gDo;
        this.gDo.getString(C25738R.string.f9238tz);
        mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C2666010());
        C1207m c32815a = new C32815a(this.gDo.gDU + this.gDo.gDV, 14, "", 0, "");
        c32815a.mo53386rV(this.gDy);
        C1720g.m3540Rg().mo14541a(c32815a, 0);
        AppMethodBeat.m2505o(125131);
    }
}
