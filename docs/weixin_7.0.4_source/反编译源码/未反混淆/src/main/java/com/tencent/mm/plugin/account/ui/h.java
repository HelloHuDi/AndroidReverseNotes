package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;

public final class h implements f, b {
    private MobileInputUI gDo;
    private String gDp;
    private String gDq;
    private int gDr = 0;

    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125089);
        this.gDo = mobileInputUI;
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(R.string.dm9);
        if (d.vxr) {
            string = string + mobileInputUI.getString(R.string.fk);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDN.setText(R.string.s1);
        mobileInputUI.gDN.setVisibility(0);
        AppMethodBeat.o(125089);
    }

    public final void start() {
        AppMethodBeat.i(125090);
        g.Rg().a(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("F200_100");
        this.gDr = 0;
        AppMethodBeat.o(125090);
    }

    public final void stop() {
        AppMethodBeat.i(125091);
        g.Rg().b(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(a.lF("F200_100")).append(",2").toString());
        AppMethodBeat.o(125091);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125092);
        switch (aVar) {
            case GoNext:
                this.gDo.gDU = av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDH.getText().toString();
                String str = this.gDo.gDU + this.gDo.gDV;
                if (this.gDo.guc == null) {
                    MobileInputUI mobileInputUI = this.gDo;
                    Context context = this.gDo;
                    this.gDo.getString(R.string.tz);
                    mobileInputUI.guc = com.tencent.mm.ui.base.h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    String obj = this.gDo.gDH.getText().toString();
                    int i = (this.gDp == null || this.gDq == null || obj.equals(this.gDp) || !obj.equals(this.gDq)) ? (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || obj.equals(this.gDq)) ? 0 : 2 : 1;
                    m aVar2 = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                    aVar2.lo(this.gDr);
                    aVar2.lp(i);
                    g.Rg().a(aVar2, 0);
                    this.gDp = this.gDo.gDH.getText().toString();
                    this.gDr++;
                    break;
                }
                ab.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                AppMethodBeat.o(125092);
                return;
        }
        AppMethodBeat.o(125092);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125093);
        ab.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        com.tencent.mm.h.a jY;
        if (i2 == -75) {
            com.tencent.mm.ui.base.h.g(this.gDo, R.string.fn, R.string.djw);
            AppMethodBeat.o(125093);
        } else if (i2 == -41 || i2 == -59) {
            jY = com.tencent.mm.h.a.jY(str);
            if (jY != null) {
                jY.a(this.gDo, null, null);
                AppMethodBeat.o(125093);
                return;
            }
            com.tencent.mm.ui.base.h.g(this.gDo, R.string.dl6, R.string.dl7);
            AppMethodBeat.o(125093);
        } else {
            if (mVar.getType() == 145) {
                int Ah = ((com.tencent.mm.modelfriend.a) mVar).Ah();
                if (Ah == 12) {
                    if (i2 == -36 || i2 == -35 || i2 == -3) {
                        String agi = ((com.tencent.mm.modelfriend.a) mVar).agi();
                        if (!bo.isNullOrNil(agi)) {
                            this.gDo.gDV = agi.trim();
                        }
                        this.gDo.gDV = av.amN(this.gDo.gDV);
                        this.gDq = this.gDo.gDU + this.gDo.gDV;
                        StringBuilder stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                        g.RN();
                        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_200")).append(",1").toString());
                        jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null) {
                            jY.a(this.gDo, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(125086);
                                    h.a(h.this);
                                    StringBuilder stringBuilder = new StringBuilder();
                                    g.RN();
                                    stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                                    g.RN();
                                    com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_200")).append(",2").toString());
                                    AppMethodBeat.o(125086);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(125087);
                                    StringBuilder stringBuilder = new StringBuilder();
                                    g.RN();
                                    stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                                    g.RN();
                                    com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_200")).append(",2").toString());
                                    AppMethodBeat.o(125087);
                                }
                            });
                            AppMethodBeat.o(125093);
                            return;
                        }
                        arc();
                        stringBuilder = new StringBuilder();
                        g.RN();
                        stringBuilder = stringBuilder.append(a.Rb()).append(",").append(getClass().getName()).append(",F200_200,");
                        g.RN();
                        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(a.lF("F200_200")).append(",2").toString());
                        AppMethodBeat.o(125093);
                        return;
                    } else if (i2 == -34) {
                        com.tencent.mm.ui.base.h.b(this.gDo, this.gDo.getString(R.string.a6k), "", true);
                        AppMethodBeat.o(125093);
                        return;
                    } else {
                        Toast.makeText(this.gDo, this.gDo.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    }
                }
                if (Ah == 8 && i2 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("bindmcontact_mobile", this.gDo.gDU + " " + this.gDo.gDH.getText().toString());
                    intent.putExtra("bindmcontact_shortmobile", this.gDo.gDV);
                    intent.putExtra("country_name", this.gDo.fHE);
                    intent.putExtra("couttry_code", this.gDo.countryCode);
                    intent.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) mVar).agn());
                    intent.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) mVar).ago());
                    intent.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) mVar).agp());
                    intent.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) mVar).agq());
                    intent.putExtra("mobile_verify_purpose", 3);
                    intent.setClass(this.gDo, MobileVerifyUI.class);
                    this.gDo.startActivity(intent);
                }
            }
            AppMethodBeat.o(125093);
        }
    }

    private void arc() {
        AppMethodBeat.i(125094);
        MobileInputUI mobileInputUI = this.gDo;
        Context context = this.gDo;
        this.gDo.getString(R.string.tz);
        mobileInputUI.guc = com.tencent.mm.ui.base.h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.Rg().a(new com.tencent.mm.modelfriend.a(this.gDo.gDU + this.gDo.gDV, 8, "", 0, ""), 0);
        AppMethodBeat.o(125094);
    }
}
