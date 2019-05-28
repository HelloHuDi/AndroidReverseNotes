package com.tencent.p177mm.plugin.wallet_payu.remittance.p1056ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.order.p1008c.C12784a;
import com.tencent.p177mm.plugin.order.p1008c.C12784a.C12783a;
import com.tencent.p177mm.plugin.remittance.p497ui.RemittanceDetailUI;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C22709c;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C29700b;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C40164e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI */
public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int pVq;
    private String pWz;
    private int pcD;
    private int pcE;
    private String tUC;
    private String tUD;
    private int tUE;
    private int tUF;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$6 */
    class C143726 implements OnClickListener {
        C143726() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48549);
            PayURemittanceDetailUI.this.cfV();
            AppMethodBeat.m2505o(48549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$4 */
    class C169194 implements C12783a {
        C169194() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48547);
            C35899h.m58862ak(PayURemittanceDetailUI.this, 0);
            AppMethodBeat.m2505o(48547);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$7 */
    class C169207 implements C12783a {

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$7$1 */
        class C169211 implements DialogInterface.OnClickListener {
            C169211() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48550);
                PayURemittanceDetailUI.this.cfW();
                AppMethodBeat.m2505o(48550);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$7$2 */
        class C169222 implements DialogInterface.OnClickListener {
            C169222() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C169207() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48551);
            C30379h.m48466d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(C25738R.string.dok, new Object[]{PayURemittanceDetailUI.adm(PayURemittanceDetailUI.this.pVm)}), PayURemittanceDetailUI.this.getString(C25738R.string.f9213t6), PayURemittanceDetailUI.this.getString(C25738R.string.dop), PayURemittanceDetailUI.this.getString(C25738R.string.f9076or), new C169211(), new C169222());
            AppMethodBeat.m2505o(48551);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$5 */
    class C297025 implements C12783a {
        C297025() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48548);
            C35899h.m58862ak(PayURemittanceDetailUI.this, 0);
            AppMethodBeat.m2505o(48548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$8 */
    class C297038 implements DialogInterface.OnClickListener {
        C297038() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48552);
            C30379h.m48465bQ(PayURemittanceDetailUI.this.mController.ylL, PayURemittanceDetailUI.this.getString(C25738R.string.doe));
            AppMethodBeat.m2505o(48552);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$2 */
    class C355322 implements OnClickListener {
        C355322() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48544);
            PayURemittanceDetailUI.this.cfV();
            AppMethodBeat.m2505o(48544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$1 */
    class C355331 implements C12783a {

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$1$1 */
        class C227101 implements DialogInterface.OnClickListener {
            C227101() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48542);
                Intent intent = new Intent();
                intent.putExtra(C8741b.TRANSACTION_ID, PayURemittanceDetailUI.this.pVl);
                intent.putExtra("receiver_name", PayURemittanceDetailUI.this.pWz);
                intent.putExtra("total_fee", PayURemittanceDetailUI.this.pVq);
                intent.putExtra("fee_type", PayURemittanceDetailUI.this.tUC);
                PayURemittanceDetailUI.this.mo56271an(intent);
                AppMethodBeat.m2505o(48542);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$1$2 */
        class C297012 implements DialogInterface.OnClickListener {
            C297012() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C355331() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48543);
            C30379h.m48466d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(C25738R.string.do5), PayURemittanceDetailUI.this.getString(C25738R.string.f9213t6), PayURemittanceDetailUI.this.getString(C25738R.string.dq3), PayURemittanceDetailUI.this.getString(C25738R.string.f9076or), new C227101(), new C297012());
            AppMethodBeat.m2505o(48543);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$3 */
    class C355343 implements C12783a {

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$3$1 */
        class C355351 implements DialogInterface.OnClickListener {
            C355351() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48545);
                PayURemittanceDetailUI.this.cfW();
                AppMethodBeat.m2505o(48545);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI$3$2 */
        class C355362 implements DialogInterface.OnClickListener {
            C355362() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C355343() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48546);
            C30379h.m48466d(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(C25738R.string.dok, new Object[]{PayURemittanceDetailUI.adl(PayURemittanceDetailUI.this.tUD)}), PayURemittanceDetailUI.this.getString(C25738R.string.f9213t6), PayURemittanceDetailUI.this.getString(C25738R.string.dop), PayURemittanceDetailUI.this.getString(C25738R.string.f9076or), new C355351(), new C355362());
            AppMethodBeat.m2505o(48546);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    static /* synthetic */ String adl(String str) {
        AppMethodBeat.m2504i(48560);
        String bc = RemittanceDetailUI.m77642bc(str, false);
        AppMethodBeat.m2505o(48560);
        return bc;
    }

    static /* synthetic */ String adm(String str) {
        AppMethodBeat.m2504i(48561);
        String bc = RemittanceDetailUI.m77642bc(str, false);
        AppMethodBeat.m2505o(48561);
        return bc;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48553);
        super.onCreate(bundle);
        this.pVq = getIntent().getIntExtra("total_fee", 0);
        this.tUC = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.tUD = C1853r.m3846Yz();
            this.pWz = this.pVm;
            AppMethodBeat.m2505o(48553);
            return;
        }
        this.tUD = this.pVm;
        this.pWz = C1853r.m3846Yz();
        AppMethodBeat.m2505o(48553);
    }

    /* renamed from: BK */
    public final void mo56269BK(int i) {
        AppMethodBeat.m2504i(48554);
        mo39970a(new C40164e(this.pRG, this.pVm, this.pVj), true, false);
        AppMethodBeat.m2505o(48554);
    }

    /* renamed from: BL */
    public final void mo56270BL(int i) {
        AppMethodBeat.m2504i(48555);
        mo39970a(new C40164e(this.pRG, this.pVm, this.pVj, i), true, false);
        AppMethodBeat.m2505o(48555);
    }

    /* renamed from: an */
    public final void mo56271an(Intent intent) {
        AppMethodBeat.m2504i(48556);
        C25985d.m41467b((Context) this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
        AppMethodBeat.m2505o(48556);
    }

    public final void cfV() {
        AppMethodBeat.m2504i(48557);
        mo39970a(new C22709c(this.pRG, this.pVq, this.tUC, this.pVm), true, true);
        AppMethodBeat.m2505o(48557);
    }

    public final void cfW() {
        AppMethodBeat.m2504i(48558);
        mo39970a(new C29700b(this.pRG, this.pVq, this.tUC, this.pVm), true, true);
        AppMethodBeat.m2505o(48558);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(48559);
        if (c1207m instanceof C40164e) {
            C40164e c40164e = (C40164e) c1207m;
            String string;
            String string2;
            SpannableString spannableString;
            C12784a c12784a;
            if (c40164e.czE != 0) {
                if (i == 0 && i2 == 0) {
                    this.tUE = c40164e.status;
                    this.tUF = c40164e.pQf;
                    this.pcE = c40164e.tUy;
                    this.pcD = c40164e.tUz;
                    this.pVq = (int) (c40164e.kCJ * 100.0d);
                    this.tUC = c40164e.pcl;
                    boolean equals = this.pWz.equals(C1853r.m3846Yz());
                    this.pUD.setVisibility(8);
                    this.pUA.setText(C36391e.m60006e(((double) this.pVq) / 100.0d, this.tUC));
                    this.pUE.setVisibility(0);
                    this.pUZ.setVisibility(8);
                    int i3 = this.tUE;
                    switch (i3) {
                        case 2000:
                            if (equals) {
                                this.pUy.setImageResource(C25738R.drawable.blt);
                                this.pUD.setVisibility(0);
                                this.pUD.setOnClickListener(new C355322());
                                string = getString(C25738R.string.dp0, new Object[]{Integer.valueOf(this.pVo)});
                                string2 = getString(C25738R.string.doo);
                                spannableString = new SpannableString(string + string2);
                                c12784a = new C12784a(this);
                                c12784a.peT = new C355343();
                                spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            } else {
                                this.pUz.setText(C44089j.m79293b((Context) this, getString(C25738R.string.dox, new Object[]{RemittanceDetailUI.m77642bc(this.pWz, true)}), this.pUz.getTextSize()));
                                string = getString(C25738R.string.dp4, new Object[]{Integer.valueOf(this.pVo)});
                                string2 = getString(C25738R.string.dq4);
                                spannableString = new SpannableString(string + string2);
                                c12784a = new C12784a(this);
                                c12784a.peT = new C355331();
                                spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            }
                            this.pUy.setImageResource(C25738R.drawable.blt);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(this.pcE)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setVisibility(8);
                            z = true;
                            break;
                        case 2001:
                            this.pUy.setImageResource(C1318a.remittance_received);
                            if (equals) {
                                this.pUz.setText(C25738R.string.dor);
                                string = getString(C25738R.string.do9);
                                SpannableString spannableString2 = new SpannableString(string);
                                C12784a c12784a2 = new C12784a(this);
                                c12784a2.peT = new C169194();
                                spannableString2.setSpan(c12784a2, 0, string.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString2);
                                this.ocV.setVisibility(0);
                            } else {
                                this.pUz.setText(C44089j.m79293b((Context) this, RemittanceDetailUI.m77642bc(this.pWz, true) + " " + getString(C25738R.string.dor), this.pUz.getTextSize()));
                                this.ocV.setVisibility(8);
                            }
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(this.tUF)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(C25738R.string.dog, new Object[]{C36391e.m60014kC(this.pcD)}));
                            this.pUC.setVisibility(0);
                            z = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.pUy.setImageResource(C1318a.remittance_refunded);
                                if (equals) {
                                    this.pUz.setText(C25738R.string.dot);
                                } else {
                                    this.pUz.setText(C44089j.m79293b((Context) this, RemittanceDetailUI.m77642bc(this.pWz, true) + getString(C25738R.string.dot), this.pUz.getTextSize()));
                                }
                            } else {
                                this.pUy.setImageResource(C1318a.remittance_timed_out);
                                this.pUz.setText(C25738R.string.dov);
                            }
                            if (equals) {
                                this.ocV.setText("");
                            } else {
                                string = getString(C25738R.string.dol);
                                string2 = getString(C25738R.string.do9);
                                spannableString = new SpannableString(string + string2);
                                c12784a = new C12784a(this);
                                c12784a.peT = new C297025();
                                spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                                this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                                this.ocV.setText(spannableString);
                            }
                            this.ocV.setVisibility(0);
                            this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(this.tUF)}));
                            this.pUB.setVisibility(0);
                            this.pUC.setText(getString(C25738R.string.doj, new Object[]{C36391e.m60014kC(this.pcE)}));
                            this.pUC.setVisibility(0);
                            z = true;
                            break;
                        default:
                            finish();
                            z = true;
                            break;
                    }
                }
                if (c40164e.bJt == 1) {
                    C1720g.m3537RQ();
                    if (((String) C1720g.m3536RP().mo5239Ry().get(327729, AppEventsConstants.EVENT_PARAM_VALUE_NO)).equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        C30379h.m48431a(this.mController.ylL, (int) C25738R.string.alf, (int) C25738R.string.frh, new C297038());
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(327729, (Object) "1");
                    } else {
                        C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.doe));
                    }
                }
                AppMethodBeat.m2505o(48559);
                return z;
            } else if (i == 0 && i2 == 0) {
                if (this.pVk == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.pUy.setImageResource(C25738R.drawable.blt);
                    this.pUz.setText(C25738R.string.dow);
                    this.pUA.setText(C36391e.m60006e(c40164e.kCJ, c40164e.pcl));
                    this.pUD.setVisibility(0);
                    this.pUD.setOnClickListener(new C143726());
                    string = getString(C25738R.string.dp0, new Object[]{Integer.valueOf(this.pVo)});
                    string2 = getString(C25738R.string.doo);
                    spannableString = new SpannableString(string + string2);
                    c12784a = new C12784a(this);
                    c12784a.peT = new C169207();
                    spannableString.setSpan(c12784a, string.length(), string.length() + string2.length(), 33);
                    this.ocV.setMovementMethod(LinkMovementMethod.getInstance());
                    this.ocV.setText(spannableString);
                    this.pUB.setText(getString(C25738R.string.dp5, new Object[]{C36391e.m60014kC(c40164e.pQf)}));
                    this.pUB.setVisibility(0);
                    this.pUC.setVisibility(8);
                }
                AppMethodBeat.m2505o(48559);
                return true;
            } else {
                mo56270BL(0);
                AppMethodBeat.m2505o(48559);
                return true;
            }
        } else if (!(c1207m instanceof C22709c) && !(c1207m instanceof C29700b)) {
            AppMethodBeat.m2505o(48559);
            return false;
        } else if (i == 0 && i2 == 0) {
            if (c1207m instanceof C22709c) {
                mo56270BL(1);
            } else {
                mo69033aZ(0, getString(C25738R.string.dof));
            }
            AppMethodBeat.m2505o(48559);
            return true;
        } else {
            mo69033aZ(i2, str);
            AppMethodBeat.m2505o(48559);
            return true;
        }
    }
}
