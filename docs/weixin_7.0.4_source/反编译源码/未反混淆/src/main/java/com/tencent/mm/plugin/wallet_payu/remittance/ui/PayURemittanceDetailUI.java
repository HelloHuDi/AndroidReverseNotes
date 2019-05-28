package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int pVq;
    private String pWz;
    private int pcD;
    private int pcE;
    private String tUC;
    private String tUD;
    private int tUE;
    private int tUF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ String adl(String str) {
        AppMethodBeat.i(48560);
        String bc = RemittanceDetailUI.bc(str, false);
        AppMethodBeat.o(48560);
        return bc;
    }

    static /* synthetic */ String adm(String str) {
        AppMethodBeat.i(48561);
        String bc = RemittanceDetailUI.bc(str, false);
        AppMethodBeat.o(48561);
        return bc;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48553);
        super.onCreate(bundle);
        this.pVq = getIntent().getIntExtra("total_fee", 0);
        this.tUC = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.tUD = r.Yz();
            this.pWz = this.pVm;
            AppMethodBeat.o(48553);
            return;
        }
        this.tUD = this.pVm;
        this.pWz = r.Yz();
        AppMethodBeat.o(48553);
    }

    public final void BK(int i) {
        AppMethodBeat.i(48554);
        a(new e(this.pRG, this.pVm, this.pVj), true, false);
        AppMethodBeat.o(48554);
    }

    public final void BL(int i) {
        AppMethodBeat.i(48555);
        a(new e(this.pRG, this.pVm, this.pVj, i), true, false);
        AppMethodBeat.o(48555);
    }

    public final void an(Intent intent) {
        AppMethodBeat.i(48556);
        d.b((Context) this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
        AppMethodBeat.o(48556);
    }

    public final void cfV() {
        AppMethodBeat.i(48557);
        a(new c(this.pRG, this.pVq, this.tUC, this.pVm), true, true);
        AppMethodBeat.o(48557);
    }

    public final void cfW() {
        AppMethodBeat.i(48558);
        a(new b(this.pRG, this.pVq, this.tUC, this.pVm), true, true);
        AppMethodBeat.o(48558);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(48559);
        if (mVar instanceof e) {
            e eVar = (e) mVar;
            String string;
            String string2;
            SpannableString spannableString;
            a aVar;
            if (eVar.czE != 0) {
                if (i == 0 && i2 == 0) {
                    this.tUE = eVar.status;
                    this.tUF = eVar.pQf;
                    this.pcE = eVar.tUy;
                    this.pcD = eVar.tUz;
                    this.pVq = (int) (eVar.kCJ * 100.0d);
                    this.tUC = eVar.pcl;
                    boolean equals = this.pWz.equals(r.Yz());
                    this.pUD.setVisibility(8);
                    this.pUA.setText(com.tencent.mm.wallet_core.ui.e.e(((double) this.pVq) / 100.0d, this.tUC));
                    this.pUE.setVisibility(0);
                    this.pUZ.setVisibility(8);
                    int i3 = this.tUE;
                    switch (i3) {
                        case 2000:
                            if (equals) {
                                this.pUy.setImageResource(R.drawable.blt);
                                this.pUD.setVisibility(0);
                                this.pUD.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(48544);
                                        PayURemittanceDetailUI.this.cfV();
                                        AppMethodBeat.o(48544);
                                    }
                                });
                                string = getString(R.string.dp0, new Object[]{Integer.valueOf(this.pVo)});
                                string2 = getString(R.string.doo);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.peT = new a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(48546);
                                        h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.dok, new Object[]{PayURemittanceDetailUI.adl(PayURemittanceDetailUI.this.tUD)}), PayURemittanceDetailUI.this.getString(R.string.t6), PayURemittanceDetailUI.this.getString(R.string.dop), PayURemittanceDetailUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(48545);
                                                PayURemittanceDetailUI.this.cfW();
                                                AppMethodBeat.o(48545);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                        AppMethodBeat.o(48546);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            } else {
                                this.pUz.setText(j.b((Context) this, getString(R.string.dox, new Object[]{RemittanceDetailUI.bc(this.pWz, true)}), this.pUz.getTextSize()));
                                string = getString(R.string.dp4, new Object[]{Integer.valueOf(this.pVo)});
                                string2 = getString(R.string.dq4);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.peT = new a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(48543);
                                        h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.do5), PayURemittanceDetailUI.this.getString(R.string.t6), PayURemittanceDetailUI.this.getString(R.string.dq3), PayURemittanceDetailUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(48542);
                                                Intent intent = new Intent();
                                                intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, PayURemittanceDetailUI.this.pVl);
                                                intent.putExtra("receiver_name", PayURemittanceDetailUI.this.pWz);
                                                intent.putExtra("total_fee", PayURemittanceDetailUI.this.pVq);
                                                intent.putExtra("fee_type", PayURemittanceDetailUI.this.tUC);
                                                PayURemittanceDetailUI.this.an(intent);
                                                AppMethodBeat.o(48542);
                                            }
                                        }, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                        AppMethodBeat.o(48543);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            }
                            this.pUy.setImageResource(R.drawable.blt);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(this.pcE)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setVisibility(8);
                            z = true;
                            break;
                        case 2001:
                            this.pUy.setImageResource(R.raw.remittance_received);
                            if (equals) {
                                this.pUz.setText(R.string.dor);
                                string = getString(R.string.do9);
                                SpannableString spannableString2 = new SpannableString(string);
                                a aVar2 = new a(this);
                                aVar2.peT = new a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(48547);
                                        com.tencent.mm.pluginsdk.wallet.h.ak(PayURemittanceDetailUI.this, 0);
                                        AppMethodBeat.o(48547);
                                    }
                                };
                                spannableString2.setSpan(aVar2, 0, string.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString2);
                                this.ocV.setVisibility(0);
                            } else {
                                this.pUz.setText(j.b((Context) this, RemittanceDetailUI.bc(this.pWz, true) + " " + getString(R.string.dor), this.pUz.getTextSize()));
                                this.ocV.setVisibility(8);
                            }
                            this.pUB.setText(getString(R.string.dp5, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(this.tUF)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(R.string.dog, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(this.pcD)}));
                            this.pUC.setVisibility(0);
                            z = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUy.setImageResource(R.raw.remittance_refunded);
                                if (equals) {
                                    this.pUz.setText(R.string.dot);
                                } else {
                                    this.pUz.setText(j.b((Context) this, RemittanceDetailUI.bc(this.pWz, true) + getString(R.string.dot), this.pUz.getTextSize()));
                                }
                            } else {
                                this.pUy.setImageResource(R.raw.remittance_timed_out);
                                this.pUz.setText(R.string.dov);
                            }
                            if (equals) {
                                this.ocV.setText("");
                            } else {
                                string = getString(R.string.dol);
                                string2 = getString(R.string.do9);
                                spannableString = new SpannableString(string + string2);
                                aVar = new a(this);
                                aVar.peT = new a.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(48548);
                                        com.tencent.mm.pluginsdk.wallet.h.ak(PayURemittanceDetailUI.this, 0);
                                        AppMethodBeat.o(48548);
                                    }
                                };
                                spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            }
                            this.ocV.setVisibility(0);
                            this.pUB.setText(getString(R.string.dp5, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(this.tUF)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(R.string.doj, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(this.pcE)}));
                            this.pUC.setVisibility(0);
                            z = true;
                            break;
                        default:
                            finish();
                            z = true;
                            break;
                    }
                }
                if (eVar.bJt == 1) {
                    g.RQ();
                    if (((String) g.RP().Ry().get(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        h.a(this.mController.ylL, (int) R.string.alf, (int) R.string.frh, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(48552);
                                h.bQ(PayURemittanceDetailUI.this.mController.ylL, PayURemittanceDetailUI.this.getString(R.string.doe));
                                AppMethodBeat.o(48552);
                            }
                        });
                        g.RQ();
                        g.RP().Ry().set(327729, (Object) "1");
                    } else {
                        h.bQ(this.mController.ylL, getString(R.string.doe));
                    }
                }
                AppMethodBeat.o(48559);
                return z;
            } else if (i == 0 && i2 == 0) {
                if (this.pVk == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.pUy.setImageResource(R.drawable.blt);
                    this.pUz.setText(R.string.dow);
                    this.pUA.setText(com.tencent.mm.wallet_core.ui.e.e(eVar.kCJ, eVar.pcl));
                    this.pUD.setVisibility(0);
                    this.pUD.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(48549);
                            PayURemittanceDetailUI.this.cfV();
                            AppMethodBeat.o(48549);
                        }
                    });
                    string = getString(R.string.dp0, new Object[]{Integer.valueOf(this.pVo)});
                    string2 = getString(R.string.doo);
                    spannableString = new SpannableString(string + string2);
                    aVar = new a(this);
                    aVar.peT = new a.a() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(48551);
                            h.d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(R.string.dok, new Object[]{PayURemittanceDetailUI.adm(PayURemittanceDetailUI.this.pVm)}), PayURemittanceDetailUI.this.getString(R.string.t6), PayURemittanceDetailUI.this.getString(R.string.dop), PayURemittanceDetailUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(48550);
                                    PayURemittanceDetailUI.this.cfW();
                                    AppMethodBeat.o(48550);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            AppMethodBeat.o(48551);
                        }
                    };
                    spannableString.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                    this.ocV.setText(spannableString);
                    this.pUB.setText(getString(R.string.dp5, new Object[]{com.tencent.mm.wallet_core.ui.e.kC(eVar.pQf)}));
                    this.pUB.setVisibility(0);
                    this.pUC.setVisibility(8);
                }
                AppMethodBeat.o(48559);
                return true;
            } else {
                BL(0);
                AppMethodBeat.o(48559);
                return true;
            }
        } else if (!(mVar instanceof c) && !(mVar instanceof b)) {
            AppMethodBeat.o(48559);
            return false;
        } else if (i == 0 && i2 == 0) {
            if (mVar instanceof c) {
                BL(1);
            } else {
                aZ(0, getString(R.string.dof));
            }
            AppMethodBeat.o(48559);
            return true;
        } else {
            aZ(i2, str);
            AppMethodBeat.o(48559);
            return true;
        }
    }
}
