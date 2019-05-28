package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public final class k implements f, b {
    private MobileInputUI gDo;
    private String gDp;
    private String gDq;
    private int gDr = 0;
    private String gDy;
    int gDz = 1;

    public final void a(final MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125126);
        this.gDo = mobileInputUI;
        String str = "";
        if (d.vxr) {
            str = str + mobileInputUI.getString(R.string.fk);
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
        mobileInputUI.gDN.setText(R.string.cpa);
        if (mobileInputUI.gDM != null) {
            mobileInputUI.gDM.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125114);
                    bo.M(mobileInputUI, mobileInputUI.getString(R.string.ezj));
                    AppMethodBeat.o(125114);
                }
            });
        }
        str = mobileInputUI.getString(R.string.cmf);
        String str2 = "  ";
        String string;
        String string2;
        String string3;
        Spannable newSpannable;
        if (aa.doo()) {
            string = mobileInputUI.getString(R.string.cmg);
            string2 = mobileInputUI.getString(R.string.dei);
            string3 = mobileInputUI.getString(R.string.fq);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125116);
                    bo.M(mobileInputUI.mController.ylL, mobileInputUI.getString(R.string.ezj));
                    AppMethodBeat.o(125116);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125117);
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125117);
                }
            }, str.length() + str2.length(), (str.length() + string.length()) + str2.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125118);
                    bo.M(mobileInputUI, ah.getResources().getString(R.string.g7o, new Object[]{aa.gw(mobileInputUI), aa.doq(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
                    AppMethodBeat.o(125118);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125119);
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125119);
                }
            }, ((str.length() + str2.length()) + string.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.gDL.setText(newSpannable);
        } else {
            string = mobileInputUI.getString(R.string.cmk);
            string2 = mobileInputUI.getString(R.string.cmi);
            string3 = mobileInputUI.getString(R.string.fq);
            newSpannable = Factory.getInstance().newSpannable(str + str2 + string + string3 + string2);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125120);
                    bo.M(mobileInputUI.mController.ylL, mobileInputUI.getString(R.string.ezo));
                    AppMethodBeat.o(125120);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125121);
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125121);
                }
            }, str.length() + str2.length(), (str.length() + str2.length()) + string.length(), 33);
            newSpannable.setSpan(new ClickableSpan() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125122);
                    bo.M(mobileInputUI, ah.getResources().getString(R.string.g7o, new Object[]{aa.gw(mobileInputUI), aa.doq(), "setting", Integer.valueOf(1), Integer.valueOf(0)}));
                    AppMethodBeat.o(125122);
                }

                public final void updateDrawState(TextPaint textPaint) {
                    AppMethodBeat.i(125123);
                    textPaint.setColor(mobileInputUI.getResources().getColor(R.color.t7));
                    textPaint.setUnderlineText(true);
                    AppMethodBeat.o(125123);
                }
            }, ((str.length() + string.length()) + str2.length()) + string3.length(), (((str.length() + string.length()) + str2.length()) + string3.length()) + string2.length(), 33);
            mobileInputUI.gDL.setText(newSpannable);
        }
        mobileInputUI.gDL.setMovementMethod(LinkMovementMethod.getInstance());
        AppMethodBeat.o(125126);
    }

    public final void start() {
        AppMethodBeat.i(125127);
        g.Rg().a(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("R200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("R200_100");
        this.gDr = 0;
        AppMethodBeat.o(125127);
    }

    public final void stop() {
        AppMethodBeat.i(125128);
        g.Rg().b(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(a.lF("R200_100")).append(",2").toString());
        AppMethodBeat.o(125128);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125129);
        switch (aVar) {
            case GoNext:
                this.gDo.aqX();
                switch (this.gDz) {
                    case 1:
                        com.tencent.mm.plugin.account.a.b.a.b(this.gDo, this.gDo.getString(R.string.g7o, new Object[]{aa.dor(), com.tencent.mm.au.b.m(this.gDo, this.gDo.countryCode, this.gDo.getString(R.string.b3_)), "reg", Integer.valueOf(1), Integer.valueOf(0)}), 32047, false);
                        break;
                    case 2:
                        arc();
                        break;
                    default:
                        this.gDo.gDU = av.amP(this.gDo.countryCode);
                        this.gDo.gDV = this.gDo.gDH.getText().toString();
                        String str = this.gDo.gDU + this.gDo.gDV;
                        if (com.tencent.mm.plugin.account.a.b.a.O(this.gDo, this.gDo.gBJ.getText().toString())) {
                            if (this.gDo.guc != null && this.gDo.guc.isShowing()) {
                                ab.d("MicroMsg.MobileInputRegLogic", "already checking ");
                                break;
                            }
                            int i;
                            int i2;
                            MobileInputUI mobileInputUI = this.gDo;
                            Context context = this.gDo;
                            this.gDo.getString(R.string.tz);
                            mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            String obj = this.gDo.gDH.getText().toString();
                            if (this.gDp != null && this.gDq != null && !obj.equals(this.gDp) && obj.equals(this.gDq)) {
                                i = 1;
                            } else if (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || obj.equals(this.gDq)) {
                                i = 0;
                            } else {
                                i = 2;
                            }
                            m aVar2 = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                            aVar2.lo(this.gDr);
                            aVar2.lp(i);
                            if (com.tencent.mm.plugin.normsg.a.b.oTO.TL("ie_reg_eu")) {
                                com.tencent.mm.plugin.normsg.a.b.oTO.TK("ie_reg_eu");
                            }
                            crs crs = new crs();
                            crs.xpk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.TM("ie_reg_eu"));
                            crs.xpl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.TP("ce_reg_eu"));
                            if (com.tencent.mm.au.b.sP(this.gDo.countryCode)) {
                                i2 = 4;
                            } else {
                                i2 = 6;
                            }
                            crs.xpm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.Am(i2));
                            aVar2.a(crs);
                            g.Rg().a(aVar2, 0);
                            this.gDp = this.gDo.gDH.getText().toString();
                            this.gDr++;
                            break;
                        }
                        break;
                }
                this.gDz = 0;
                break;
        }
        AppMethodBeat.o(125129);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125130);
        ab.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (i2 == -75) {
            h.g(this.gDo, R.string.fn, R.string.djw);
            AppMethodBeat.o(125130);
            return;
        }
        if (mVar.getType() == 145) {
            com.tencent.mm.h.a jY;
            if (i2 == -41 || i2 == -59) {
                jY = com.tencent.mm.h.a.jY(str);
                if (jY != null) {
                    jY.a(this.gDo, null, null);
                    AppMethodBeat.o(125130);
                    return;
                }
                h.g(this.gDo, R.string.dl6, R.string.dl7);
                AppMethodBeat.o(125130);
                return;
            }
            String agi;
            int Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
            if (Ah == 12) {
                this.gDo.gDV = av.amN(this.gDo.gDV);
                this.gDq = this.gDo.gDU + this.gDo.gDV;
                this.gDy = ((com.tencent.mm.modelfriend.a) mVar).agt();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    agi = ((com.tencent.mm.modelfriend.a) mVar).agi();
                    if (!bo.isNullOrNil(agi)) {
                        this.gDo.gDV = agi.trim();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("R200_200")).append(",1").toString());
                    jY = com.tencent.mm.h.a.jY(str);
                    if (jY != null) {
                        jY.a(this.gDo, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125124);
                                k.a(k.this);
                                AppMethodBeat.o(125124);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(125125);
                                StringBuilder stringBuilder = new StringBuilder();
                                g.RN();
                                stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_200,");
                                g.RN();
                                com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("R200_200")).append(",2").toString());
                                AppMethodBeat.o(125125);
                            }
                        });
                        AppMethodBeat.o(125130);
                        return;
                    }
                    arc();
                    stringBuilder = new StringBuilder();
                    g.RN();
                    stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.RN();
                    com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("R200_200")).append(",2").toString());
                    AppMethodBeat.o(125130);
                    return;
                } else if (i2 == -355) {
                    z.f(this.gDo, str, 32046);
                    AppMethodBeat.o(125130);
                    return;
                } else if (i2 == -34) {
                    h.b(this.gDo, this.gDo.getString(R.string.a6k), "", true);
                    AppMethodBeat.o(125130);
                    return;
                }
            }
            if (Ah == 14) {
                if (i2 == 0 || str == null) {
                    if (((com.tencent.mm.modelfriend.a) mVar).agj() == 1) {
                        String str2 = this.gDo.gDU + this.gDo.gDV;
                        agi = ((com.tencent.mm.modelfriend.a) mVar).agl();
                        String agk = ((com.tencent.mm.modelfriend.a) mVar).agk();
                        Intent intent = new Intent(this.gDo, RegByMobileSendSmsUI.class);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", agi);
                        intent.putExtra("verify_code", agk);
                        intent.putExtra("key_reg_style", 2);
                        intent.putExtra("kintent_password", this.gDo.gBJ.getText().toString());
                        intent.putExtra("regsession_id", this.gDy);
                        this.gDo.startActivity(intent);
                    } else {
                        com.tencent.mm.plugin.b.a.wA("R200_300");
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.gDo.gDU + " " + this.gDo.gDH.getText().toString());
                        intent2.putExtra("bindmcontact_shortmobile", this.gDo.gDV);
                        intent2.putExtra("country_name", this.gDo.fHE);
                        intent2.putExtra("couttry_code", this.gDo.countryCode);
                        intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) mVar).agn());
                        intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) mVar).ago());
                        intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) mVar).agp());
                        intent2.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) mVar).agq());
                        intent2.putExtra("key_reg_style", 2);
                        intent2.putExtra("kintent_password", this.gDo.gBJ.getText().toString());
                        intent2.putExtra("mobile_verify_purpose", 2);
                        intent2.putExtra("regsession_id", this.gDy);
                        intent2.setClass(this.gDo, MobileVerifyUI.class);
                        this.gDo.startActivity(intent2);
                        j.a(j.a.SENT);
                    }
                } else if (i2 == -34) {
                    h.b(this.gDo, this.gDo.getString(R.string.a6k), "", true);
                    AppMethodBeat.o(125130);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.gkF.a(this.gDo, i, i2, str)) {
                    AppMethodBeat.o(125130);
                    return;
                }
            }
            jY = com.tencent.mm.h.a.jY(str);
            if (!(jY == null || this.gDo == null || !jY.a(this.gDo, null, null))) {
                AppMethodBeat.o(125130);
                return;
            }
        }
        AppMethodBeat.o(125130);
    }

    private void arc() {
        AppMethodBeat.i(125131);
        MobileInputUI mobileInputUI = this.gDo;
        Context context = this.gDo;
        this.gDo.getString(R.string.tz);
        mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        m aVar = new com.tencent.mm.modelfriend.a(this.gDo.gDU + this.gDo.gDV, 14, "", 0, "");
        aVar.rV(this.gDy);
        g.Rg().a(aVar, 0);
        AppMethodBeat.o(125131);
    }
}
