package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.C22592i;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22563q;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C30860n;
import com.tencent.p177mm.wallet_core.p649c.C30860n.C30861a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.p177mm.wallet_core.tenpay.model.C40944q;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI */
public class WalletVerifyCodeUI extends WalletBaseUI implements C36397a {
    private Button gEZ;
    private PayInfo pVL;
    private Orders pWy;
    private int tLa = 60000;
    protected WalletFormView tLb = null;
    private Button tLc;
    private String tLd;
    private String tLe;
    private boolean tLf = false;
    private C46372a tLg = null;
    private TextView tLh;
    private TextView tLi;
    private boolean tLj = false;
    private boolean tLk = true;
    private C22592i tLl = new C22592i();
    private C30861a tLm = new C2261711();
    private Authen tms;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$2 */
    class C143042 implements OnClickListener {
        C143042() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$3 */
    class C143053 implements OnClickListener {
        C143053() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$4 */
    class C143064 implements View.OnClickListener {
        C143064() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47692);
            WalletVerifyCodeUI.this.aqX();
            if (WalletVerifyCodeUI.m87166a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.tLm)) {
                AppMethodBeat.m2505o(47692);
                return;
            }
            WalletVerifyCodeUI.this.cRW();
            AppMethodBeat.m2505o(47692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$11 */
    class C2261711 implements C30861a {
        C2261711() {
        }

        public final void cRX() {
            AppMethodBeat.m2504i(47700);
            WalletVerifyCodeUI.this.cRW();
            AppMethodBeat.m2505o(47700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$10 */
    class C4012010 implements OnMenuItemClickListener {
        C4012010() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(47699);
            WalletVerifyCodeUI.this.aqX();
            if (WalletVerifyCodeUI.this.cNR()) {
                WalletVerifyCodeUI.this.showDialog(1000);
            } else {
                WalletVerifyCodeUI.this.finish();
            }
            AppMethodBeat.m2505o(47699);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$8 */
    class C463718 implements View.OnClickListener {
        C463718() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47697);
            WalletVerifyCodeUI.m87171e(WalletVerifyCodeUI.this);
            AppMethodBeat.m2505o(47697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$a */
    class C46372a extends CountDownTimer {
        public C46372a(long j) {
            super(j, 1000);
        }

        public final void onTick(long j) {
            AppMethodBeat.m2504i(47701);
            WalletVerifyCodeUI.this.tLc.setText(WalletVerifyCodeUI.this.getString(C25738R.string.fuo) + "(" + (j / 1000) + ")");
            AppMethodBeat.m2505o(47701);
        }

        public final void onFinish() {
            AppMethodBeat.m2504i(47702);
            WalletVerifyCodeUI.this.tLc.setClickable(true);
            WalletVerifyCodeUI.this.tLc.setEnabled(true);
            WalletVerifyCodeUI.this.tLc.setText(WalletVerifyCodeUI.this.getString(C25738R.string.fuo));
            AppMethodBeat.m2505o(47702);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletVerifyCodeUI() {
        AppMethodBeat.m2504i(47703);
        AppMethodBeat.m2505o(47703);
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        AppMethodBeat.m2504i(47704);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "on create");
        setMMTitle((int) C25738R.string.fur);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.tLe = this.mBundle.getString("key_bank_phone");
        this.tLl = new C22592i(this.mBundle);
        this.tLf = false;
        initView();
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[2];
        int i2 = (this.pVL == null || this.pVL.cIf == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.tLf) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        c7060h.mo8381e(10706, objArr);
        C40148d.cSP();
        C40148d.m68847a(this, this.mBundle, 4);
        if (this.tLl.cPm()) {
            C7060h.pYm.mo8381e(13731, Integer.valueOf(5));
            if (!C5046bo.isNullOrNil(this.tLl.tyi.title)) {
                setMMTitle(this.tLl.tyi.title);
            }
            if (this.tLh != null) {
                this.tLh.setText(getString(C25738R.string.fuh));
            }
            if (!(this.gEZ == null || C5046bo.isNullOrNil(this.tLl.tyi.Afn))) {
                this.gEZ.setText(this.tLl.tyi.Afn);
            }
        }
        this.Ahr.mo49372nf(1580);
        AppMethodBeat.m2505o(47704);
    }

    public void finish() {
        AppMethodBeat.m2504i(47705);
        C4990ab.m7417i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", C5046bo.dpG());
        super.finish();
        AppMethodBeat.m2505o(47705);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRV() {
        int i = 2;
        AppMethodBeat.m2504i(47707);
        C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[2];
        int i2 = (this.pVL == null || this.pVL.cIf == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.tLf) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        c7060h.mo8381e(10706, objArr);
        this.tLf = true;
        this.tLc.setClickable(false);
        this.tLc.setEnabled(false);
        if (this.tLg != null) {
            this.tLg.cancel();
            this.tLg = null;
        }
        C46372a c46372a = new C46372a((long) this.tLa);
        this.tLg = c46372a;
        c46372a.start();
        if (dOE().mo38265x(this.tLd)) {
            AppMethodBeat.m2505o(47707);
        } else if (mo39994rl(false)) {
            AppMethodBeat.m2505o(47707);
        } else {
            this.tms = (Authen) this.mBundle.getParcelable("key_authen");
            if (this.tms == null) {
                C4990ab.m7420w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
                AppMethodBeat.m2505o(47707);
                return;
            }
            C40148d.cSP();
            AppMethodBeat.m2505o(47707);
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(47708);
        C40931c aE = C24143a.m37112aE(this);
        final Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        this.tLh = (TextView) findViewById(2131826507);
        this.tLi = (TextView) findViewById(2131829076);
        this.tLb = (WalletFormView) findViewById(2131821771);
        this.tLb.setOnInputValidChangeListener(this);
        this.tLc = (Button) findViewById(2131826508);
        this.tLc.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47691);
                C40931c dOD = WalletVerifyCodeUI.this.dOD();
                if (WalletVerifyCodeUI.this.tLk && dOD != null && dOD.bxP().equals("PayProcess")) {
                    int i;
                    if (bankcard == null) {
                        i = 0;
                    } else if (bankcard.cPc()) {
                        i = 1;
                    } else if (bankcard.cPd()) {
                        i = 3;
                    } else {
                        i = 2;
                    }
                    C5652a c5652a = new C5652a(WalletVerifyCodeUI.this.mController.ylL);
                    c5652a.mo11446PV(C25738R.string.fu_);
                    c5652a.asE(WalletVerifyCodeUI.this.getString(C25738R.string.fu9, new Object[]{WalletVerifyCodeUI.this.cRU()}));
                    c5652a.mo11482rc(true);
                    c5652a.mo11453Qc(C25738R.string.fu8);
                    c5652a.mo11454Qd(C25738R.string.fu7);
                    c5652a.mo11457a(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(47689);
                            WalletVerifyCodeUI.this.cRV();
                            C7060h.pYm.mo8381e(15443, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i));
                            AppMethodBeat.m2505o(47689);
                        }
                    });
                    c5652a.mo11476b(new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z;
                            AppMethodBeat.m2504i(47690);
                            Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                            bundle.putInt("key_err_code", 417);
                            bundle.putBoolean("key_need_show_switch_phone", true);
                            String str = "key_isbalance";
                            if (bankcard == null || bankcard.cPc()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            bundle.putBoolean(str, z);
                            C24143a.m37116j(WalletVerifyCodeUI.this, bundle);
                            C7060h.pYm.mo8381e(15443, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i));
                            AppMethodBeat.m2505o(47690);
                        }
                    });
                    c5652a.aMb().show();
                    C7060h.pYm.mo8381e(15443, Integer.valueOf(1));
                    WalletVerifyCodeUI.this.tLk = false;
                    AppMethodBeat.m2505o(47691);
                    return;
                }
                WalletVerifyCodeUI.this.cRV();
                AppMethodBeat.m2505o(47691);
            }
        });
        this.gEZ = (Button) findViewById(2131821772);
        this.gEZ.setOnClickListener(new C143064());
        m87169cu();
        this.tLc.setClickable(false);
        this.tLc.setEnabled(false);
        if (this.tLg != null) {
            this.tLg.cancel();
            this.tLg = null;
        }
        C46372a c46372a = new C46372a((long) this.tLa);
        this.tLg = c46372a;
        c46372a.start();
        TextView textView = (TextView) findViewById(2131826509);
        boolean z = this.mBundle.getBoolean("key_is_changing_balance_phone_num");
        boolean z2 = this.mBundle.getBoolean("key_need_show_switch_phone", false);
        if (!z || z2) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        PayInfo payInfo = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        int i;
        if (payInfo != null) {
            i = payInfo.cIf;
        } else {
            i = 0;
        }
        if (z2) {
            textView.setText(C25738R.string.fuf);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean z = true;
                    AppMethodBeat.m2504i(47693);
                    C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
                    Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                    bundle.putInt("key_err_code", 417);
                    bundle.putBoolean("key_need_show_switch_phone", true);
                    WalletVerifyCodeUI.this.mBundle.putBoolean("key_block_bind_new_card", true);
                    String str = "key_isbalance";
                    if (!(bankcard == null || bankcard.cPc())) {
                        z = false;
                    }
                    bundle.putBoolean(str, z);
                    C24143a.m37116j(WalletVerifyCodeUI.this, bundle);
                    WalletVerifyCodeUI.this.finish();
                    AppMethodBeat.m2505o(47693);
                }
            });
        } else if (aE == null || !aE.dNH() || i == 11 || i == 21) {
            textView.setText(C44423ae.m80308iq(this));
            textView.setOnClickListener(new C463718());
        } else if (bankcard.cPc() || bankcard.cPd()) {
            CharSequence string = this.mBundle.getString("key_verify_tail_wording", getString(C25738R.string.fuf));
            if (C5046bo.isNullOrNil(string)) {
                string = getString(C25738R.string.fuf);
            }
            textView.setText(string);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean z = false;
                    AppMethodBeat.m2504i(47696);
                    C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
                    if (WalletVerifyCodeUI.this.tLl != null && WalletVerifyCodeUI.this.tLl.cPm()) {
                        C7060h.pYm.mo8381e(13731, Integer.valueOf(9));
                    }
                    Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                    bundle.putInt("key_err_code", 417);
                    bundle.putBoolean("key_need_show_switch_phone", true);
                    String str = "key_isbalance";
                    if (bankcard == null || bankcard.cPc()) {
                        z = true;
                    }
                    bundle.putBoolean(str, z);
                    C24143a.m37116j(WalletVerifyCodeUI.this, bundle);
                    AppMethodBeat.m2505o(47696);
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() {

                /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI$6$1 */
                class C143081 implements OnClickListener {
                    C143081() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(47694);
                        C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                        Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                        bundle.putInt("key_err_code", 408);
                        C24143a.m37116j(WalletVerifyCodeUI.this, bundle);
                        WalletVerifyCodeUI.this.finish();
                        AppMethodBeat.m2505o(47694);
                    }
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(47695);
                    C30379h.m48466d(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(C25738R.string.fp0, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", WalletVerifyCodeUI.this.getString(C25738R.string.foz), WalletVerifyCodeUI.this.getString(C25738R.string.f9076or), new C143081(), null);
                    AppMethodBeat.m2505o(47695);
                }
            });
        }
        this.tLb.requestFocus();
        final String string2 = this.mBundle.getString("key_QADNA_URL");
        if (!C5046bo.isNullOrNil(string2)) {
            addIconOptionMenu(0, C25738R.drawable.bli, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.m2504i(47698);
                    C36391e.m60016n(WalletVerifyCodeUI.this.mController.ylL, string2, false);
                    AppMethodBeat.m2505o(47698);
                    return true;
                }
            });
        }
        setBackBtn(new C4012010());
        AppMethodBeat.m2505o(47708);
    }

    public void onResume() {
        AppMethodBeat.m2504i(138556);
        super.onResume();
        m87169cu();
        AppMethodBeat.m2505o(138556);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(138557);
        super.onNewIntent(intent);
        m87169cu();
        AppMethodBeat.m2505o(138557);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47710);
        C4990ab.m7410d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (c1207m instanceof C30860n) {
            if (i2 != 0 && ((C30860n) c1207m).cNi) {
                C30379h.m48448a(this.mController.ylL, str, null, false, new C143042());
            }
            AppMethodBeat.m2505o(47710);
            return true;
        }
        if (i == 0 && i2 == 0) {
            boolean z;
            C40931c aE = C24143a.m37112aE(this);
            if (c1207m instanceof C35475y) {
                this.mBundle.putBoolean("intent_bind_end", true);
                C30379h.m48465bQ(this, getString(C25738R.string.f_2));
                C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                z = true;
            } else {
                if (!(c1207m instanceof C40944q)) {
                    if (aE.mo8128c((Activity) this, null)) {
                        mo39970a(new C35475y(cNH(), 13), true, false);
                        C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                    } else {
                        z = true;
                    }
                }
                z = false;
            }
            if (c1207m instanceof C22563q) {
                C7060h.pYm.mo8381e(10707, Integer.valueOf(2), Integer.valueOf(C40148d.cSQ()));
            }
            if (this.tms != null && (c1207m instanceof C5749m)) {
                String token = ((C5749m) c1207m).getToken();
                if (!C5046bo.isNullOrNil(token)) {
                    this.mBundle.putString("kreq_token", token);
                }
            }
            if (z) {
                C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                C24143a.m37116j(this, this.mBundle);
                if (aE == null || !aE.bxP().equals("PayProcess")) {
                    C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "finish self");
                    finish();
                }
                AppMethodBeat.m2505o(47710);
                return true;
            }
        }
        AppMethodBeat.m2505o(47710);
        return false;
    }

    public final int getLayoutId() {
        return 2130971180;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47711);
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(47711);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47713);
        this.Ahr.mo49373ng(1580);
        super.onDestroy();
        AppMethodBeat.m2505o(47713);
    }

    public final boolean cNR() {
        AppMethodBeat.m2504i(47714);
        boolean booleanExtra = getIntent().getBooleanExtra("key_need_confirm_finish", false);
        if ((this.pVL == null || !this.pVL.mXg) && !booleanExtra) {
            booleanExtra = super.cNR();
            AppMethodBeat.m2505o(47714);
            return booleanExtra;
        }
        AppMethodBeat.m2505o(47714);
        return true;
    }

    /* renamed from: i */
    public final boolean mo39991i(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47715);
        C4990ab.m7417i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", Integer.valueOf(i2), c1207m);
        if ((c1207m instanceof C30860n) && i2 == 0) {
            this.tLj = true;
            C23639t.makeText(this, C25738R.string.fmp, 0).show();
            C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.m2505o(47715);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String cRU() {
        String str;
        AppMethodBeat.m2504i(47706);
        String bc = C5046bo.m7532bc(this.mBundle.getString("key_mobile"), "");
        if (C5046bo.isNullOrNil(bc)) {
            Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
            if (bankcard != null) {
                str = bankcard.field_mobile;
                AppMethodBeat.m2505o(47706);
                return str;
            }
        }
        str = bc;
        AppMethodBeat.m2505o(47706);
        return str;
    }

    /* renamed from: cu */
    private void m87169cu() {
        String str;
        AppMethodBeat.m2504i(138558);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        String cRU = cRU();
        if (!C5046bo.isNullOrNil(cRU) || bankcard == null) {
            str = cRU;
        } else {
            str = bankcard.field_mobile;
            this.mBundle.putString("key_mobile", str);
        }
        this.tLi.setText(getString(C25738R.string.fqk, new Object[]{str}));
        CharSequence dOF = dOF();
        if (C5046bo.m7519ac(dOF)) {
            this.tLh.setText(String.format(getString(C25738R.string.fua), new Object[]{str}));
            AppMethodBeat.m2505o(138558);
            return;
        }
        this.tLh.setText(dOF);
        AppMethodBeat.m2505o(138558);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRW() {
        AppMethodBeat.m2504i(47709);
        Bundle bundle = this.mBundle;
        String string = this.mBundle.getString("key_pwd1");
        this.tLd = this.tLb.getText();
        C14264s c14264s = new C14264s();
        c14264s.guu = string;
        c14264s.pGr = this.pVL;
        c14264s.tCi = this.tLd;
        c14264s.token = C5046bo.m7532bc(this.mBundle.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            c14264s.pbn = bankcard.field_bankcardType;
            c14264s.pbo = bankcard.field_bindSerial;
            c14264s.twk = C5046bo.m7532bc(bankcard.field_arrive_type, "");
        } else {
            c14264s.pbn = this.mBundle.getString("key_bank_type");
            if (C5046bo.isNullOrNil(c14264s.pbn)) {
                c14264s.pbn = this.mBundle.getString("key_bind_card_type", "");
            }
        }
        C4990ab.m7410d("MicroMsg.WalletVertifyCodeUI", "payInfo " + c14264s.pGr + " mVerifyCode: " + this.tLd);
        bundle.putString("key_verify_code", this.tLd);
        C24143a.m37112aE(this);
        C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(dOE().mo9366p(this.tLd, c14264s))));
        AppMethodBeat.m2505o(47709);
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(47712);
        if (this.tLb.mo64602fx(null)) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.m2505o(47712);
            return;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.m2505o(47712);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m87166a(WalletVerifyCodeUI walletVerifyCodeUI, C30861a c30861a) {
        AppMethodBeat.m2504i(47716);
        if (walletVerifyCodeUI.tLj) {
            C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            AppMethodBeat.m2505o(47716);
            return false;
        } else if (walletVerifyCodeUI.tLl.cPo()) {
            C4990ab.m7417i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", c30861a);
            if (C5046bo.isNullOrNil(walletVerifyCodeUI.tLb.getText())) {
                C4990ab.m7417i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", c30861a);
                AppMethodBeat.m2505o(47716);
                return false;
            }
            C7060h.pYm.mo8381e(13731, Integer.valueOf(6));
            walletVerifyCodeUI.mo39970a(new C30860n(walletVerifyCodeUI.tLb.getText(), walletVerifyCodeUI.cNH(), c30861a, true), true, true);
            AppMethodBeat.m2505o(47716);
            return true;
        } else if (walletVerifyCodeUI.tLl.cPn()) {
            C4990ab.m7417i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", c30861a);
            C7060h.pYm.mo8381e(13731, Integer.valueOf(6));
            walletVerifyCodeUI.mo39970a(new C30860n(walletVerifyCodeUI.tLb.getText(), walletVerifyCodeUI.cNH(), c30861a, false), true, true);
            AppMethodBeat.m2505o(47716);
            return true;
        } else {
            C4990ab.m7416i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            AppMethodBeat.m2505o(47716);
            return false;
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m87171e(WalletVerifyCodeUI walletVerifyCodeUI) {
        String string;
        AppMethodBeat.m2504i(47717);
        if (walletVerifyCodeUI.tLe == null) {
            walletVerifyCodeUI.tLe = "";
        }
        if (C1853r.m3831YM()) {
            string = walletVerifyCodeUI.getString(C25738R.string.fue);
        } else {
            string = walletVerifyCodeUI.getString(C25738R.string.fud);
        }
        String format = String.format(string, new Object[]{walletVerifyCodeUI.tLe});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.mController.ylL.getSystemService("layout_inflater");
        View view = (TextView) layoutInflater.inflate(2130969840, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        view.setText(format);
        C30379h.m48441a(walletVerifyCodeUI.mController.ylL, walletVerifyCodeUI.getString(C25738R.string.fuf), walletVerifyCodeUI.getString(C25738R.string.ffp), view, new C143053());
        AppMethodBeat.m2505o(47717);
    }
}
