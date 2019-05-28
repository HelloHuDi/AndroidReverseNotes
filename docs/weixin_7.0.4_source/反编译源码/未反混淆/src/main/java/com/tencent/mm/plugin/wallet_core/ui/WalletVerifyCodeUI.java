package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.tenpay.model.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@com.tencent.mm.ui.base.a(19)
public class WalletVerifyCodeUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button gEZ;
    private PayInfo pVL;
    private Orders pWy;
    private int tLa = 60000;
    protected WalletFormView tLb = null;
    private Button tLc;
    private String tLd;
    private String tLe;
    private boolean tLf = false;
    private a tLg = null;
    private TextView tLh;
    private TextView tLi;
    private boolean tLj = false;
    private boolean tLk = true;
    private i tLl = new i();
    private com.tencent.mm.wallet_core.c.n.a tLm = new com.tencent.mm.wallet_core.c.n.a() {
        public final void cRX() {
            AppMethodBeat.i(47700);
            WalletVerifyCodeUI.this.cRW();
            AppMethodBeat.o(47700);
        }
    };
    private Authen tms;

    class a extends CountDownTimer {
        public a(long j) {
            super(j, 1000);
        }

        public final void onTick(long j) {
            AppMethodBeat.i(47701);
            WalletVerifyCodeUI.this.tLc.setText(WalletVerifyCodeUI.this.getString(R.string.fuo) + "(" + (j / 1000) + ")");
            AppMethodBeat.o(47701);
        }

        public final void onFinish() {
            AppMethodBeat.i(47702);
            WalletVerifyCodeUI.this.tLc.setClickable(true);
            WalletVerifyCodeUI.this.tLc.setEnabled(true);
            WalletVerifyCodeUI.this.tLc.setText(WalletVerifyCodeUI.this.getString(R.string.fuo));
            AppMethodBeat.o(47702);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletVerifyCodeUI() {
        AppMethodBeat.i(47703);
        AppMethodBeat.o(47703);
    }

    public void onCreate(Bundle bundle) {
        int i = 2;
        AppMethodBeat.i(47704);
        super.onCreate(bundle);
        ab.i("MicroMsg.WalletVertifyCodeUI", "on create");
        setMMTitle((int) R.string.fur);
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.tLe = this.mBundle.getString("key_bank_phone");
        this.tLl = new i(this.mBundle);
        this.tLf = false;
        initView();
        h hVar = h.pYm;
        Object[] objArr = new Object[2];
        int i2 = (this.pVL == null || this.pVL.cIf == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.tLf) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.e(10706, objArr);
        d.cSP();
        d.a(this, this.mBundle, 4);
        if (this.tLl.cPm()) {
            h.pYm.e(13731, Integer.valueOf(5));
            if (!bo.isNullOrNil(this.tLl.tyi.title)) {
                setMMTitle(this.tLl.tyi.title);
            }
            if (this.tLh != null) {
                this.tLh.setText(getString(R.string.fuh));
            }
            if (!(this.gEZ == null || bo.isNullOrNil(this.tLl.tyi.Afn))) {
                this.gEZ.setText(this.tLl.tyi.Afn);
            }
        }
        this.Ahr.nf(1580);
        AppMethodBeat.o(47704);
    }

    public void finish() {
        AppMethodBeat.i(47705);
        ab.i("MicroMsg.WalletVertifyCodeUI", "do finish: %s", bo.dpG());
        super.finish();
        AppMethodBeat.o(47705);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRV() {
        int i = 2;
        AppMethodBeat.i(47707);
        ab.i("MicroMsg.WalletVertifyCodeUI", "get verify code!");
        h hVar = h.pYm;
        Object[] objArr = new Object[2];
        int i2 = (this.pVL == null || this.pVL.cIf == 0) ? 2 : 1;
        objArr[0] = Integer.valueOf(i2);
        if (!this.tLf) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.e(10706, objArr);
        this.tLf = true;
        this.tLc.setClickable(false);
        this.tLc.setEnabled(false);
        if (this.tLg != null) {
            this.tLg.cancel();
            this.tLg = null;
        }
        a aVar = new a((long) this.tLa);
        this.tLg = aVar;
        aVar.start();
        if (dOE().x(this.tLd)) {
            AppMethodBeat.o(47707);
        } else if (rl(false)) {
            AppMethodBeat.o(47707);
        } else {
            this.tms = (Authen) this.mBundle.getParcelable("key_authen");
            if (this.tms == null) {
                ab.w("MicroMsg.WalletVertifyCodeUI", "error authen is null");
                AppMethodBeat.o(47707);
                return;
            }
            d.cSP();
            AppMethodBeat.o(47707);
        }
    }

    public final void initView() {
        AppMethodBeat.i(47708);
        c aE = com.tencent.mm.wallet_core.a.aE(this);
        final Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        this.tLh = (TextView) findViewById(R.id.dm7);
        this.tLi = (TextView) findViewById(R.id.fhm);
        this.tLb = (WalletFormView) findViewById(R.id.a65);
        this.tLb.setOnInputValidChangeListener(this);
        this.tLc = (Button) findViewById(R.id.dm8);
        this.tLc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47691);
                c dOD = WalletVerifyCodeUI.this.dOD();
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
                    com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(WalletVerifyCodeUI.this.mController.ylL);
                    aVar.PV(R.string.fu_);
                    aVar.asE(WalletVerifyCodeUI.this.getString(R.string.fu9, new Object[]{WalletVerifyCodeUI.this.cRU()}));
                    aVar.rc(true);
                    aVar.Qc(R.string.fu8);
                    aVar.Qd(R.string.fu7);
                    aVar.a(new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(47689);
                            WalletVerifyCodeUI.this.cRV();
                            h.pYm.e(15443, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(i));
                            AppMethodBeat.o(47689);
                        }
                    });
                    aVar.b(new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z;
                            AppMethodBeat.i(47690);
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
                            com.tencent.mm.wallet_core.a.j(WalletVerifyCodeUI.this, bundle);
                            h.pYm.e(15443, Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i));
                            AppMethodBeat.o(47690);
                        }
                    });
                    aVar.aMb().show();
                    h.pYm.e(15443, Integer.valueOf(1));
                    WalletVerifyCodeUI.this.tLk = false;
                    AppMethodBeat.o(47691);
                    return;
                }
                WalletVerifyCodeUI.this.cRV();
                AppMethodBeat.o(47691);
            }
        });
        this.gEZ = (Button) findViewById(R.id.a66);
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47692);
                WalletVerifyCodeUI.this.aqX();
                if (WalletVerifyCodeUI.a(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.tLm)) {
                    AppMethodBeat.o(47692);
                    return;
                }
                WalletVerifyCodeUI.this.cRW();
                AppMethodBeat.o(47692);
            }
        });
        cu();
        this.tLc.setClickable(false);
        this.tLc.setEnabled(false);
        if (this.tLg != null) {
            this.tLg.cancel();
            this.tLg = null;
        }
        a aVar = new a((long) this.tLa);
        this.tLg = aVar;
        aVar.start();
        TextView textView = (TextView) findViewById(R.id.dm9);
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
            textView.setText(R.string.fuf);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    boolean z = true;
                    AppMethodBeat.i(47693);
                    ab.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess and finish!");
                    Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                    bundle.putInt("key_err_code", 417);
                    bundle.putBoolean("key_need_show_switch_phone", true);
                    WalletVerifyCodeUI.this.mBundle.putBoolean("key_block_bind_new_card", true);
                    String str = "key_isbalance";
                    if (!(bankcard == null || bankcard.cPc())) {
                        z = false;
                    }
                    bundle.putBoolean(str, z);
                    com.tencent.mm.wallet_core.a.j(WalletVerifyCodeUI.this, bundle);
                    WalletVerifyCodeUI.this.finish();
                    AppMethodBeat.o(47693);
                }
            });
        } else if (aE == null || !aE.dNH() || i == 11 || i == 21) {
            textView.setText(ae.iq(this));
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47697);
                    WalletVerifyCodeUI.e(WalletVerifyCodeUI.this);
                    AppMethodBeat.o(47697);
                }
            });
        } else if (bankcard.cPc() || bankcard.cPd()) {
            CharSequence string = this.mBundle.getString("key_verify_tail_wording", getString(R.string.fuf));
            if (bo.isNullOrNil(string)) {
                string = getString(R.string.fuf);
            }
            textView.setText(string);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    boolean z = false;
                    AppMethodBeat.i(47696);
                    ab.i("MicroMsg.WalletVertifyCodeUI", "hy: user clicked on the reset info tv and is balance. ");
                    ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess3 and finish!");
                    if (WalletVerifyCodeUI.this.tLl != null && WalletVerifyCodeUI.this.tLl.cPm()) {
                        h.pYm.e(13731, Integer.valueOf(9));
                    }
                    Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                    bundle.putInt("key_err_code", 417);
                    bundle.putBoolean("key_need_show_switch_phone", true);
                    String str = "key_isbalance";
                    if (bankcard == null || bankcard.cPc()) {
                        z = true;
                    }
                    bundle.putBoolean(str, z);
                    com.tencent.mm.wallet_core.a.j(WalletVerifyCodeUI.this, bundle);
                    AppMethodBeat.o(47696);
                }
            });
        } else {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47695);
                    com.tencent.mm.ui.base.h.d(WalletVerifyCodeUI.this, WalletVerifyCodeUI.this.getString(R.string.fp0, new Object[]{bankcard.field_desc, bankcard.field_mobile}), "", WalletVerifyCodeUI.this.getString(R.string.foz), WalletVerifyCodeUI.this.getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(47694);
                            ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess2 and finish to reset mobile num!");
                            Bundle bundle = WalletVerifyCodeUI.this.mBundle;
                            bundle.putInt("key_err_code", 408);
                            com.tencent.mm.wallet_core.a.j(WalletVerifyCodeUI.this, bundle);
                            WalletVerifyCodeUI.this.finish();
                            AppMethodBeat.o(47694);
                        }
                    }, null);
                    AppMethodBeat.o(47695);
                }
            });
        }
        this.tLb.requestFocus();
        final String string2 = this.mBundle.getString("key_QADNA_URL");
        if (!bo.isNullOrNil(string2)) {
            addIconOptionMenu(0, R.drawable.bli, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(47698);
                    e.n(WalletVerifyCodeUI.this.mController.ylL, string2, false);
                    AppMethodBeat.o(47698);
                    return true;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(47699);
                WalletVerifyCodeUI.this.aqX();
                if (WalletVerifyCodeUI.this.cNR()) {
                    WalletVerifyCodeUI.this.showDialog(1000);
                } else {
                    WalletVerifyCodeUI.this.finish();
                }
                AppMethodBeat.o(47699);
                return false;
            }
        });
        AppMethodBeat.o(47708);
    }

    public void onResume() {
        AppMethodBeat.i(138556);
        super.onResume();
        cu();
        AppMethodBeat.o(138556);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(138557);
        super.onNewIntent(intent);
        cu();
        AppMethodBeat.o(138557);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47710);
        ab.d("MicroMsg.WalletVertifyCodeUI", " errCode: " + i2 + " errMsg :" + str);
        if (mVar instanceof n) {
            if (i2 != 0 && ((n) mVar).cNi) {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, str, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            AppMethodBeat.o(47710);
            return true;
        }
        if (i == 0 && i2 == 0) {
            boolean z;
            c aE = com.tencent.mm.wallet_core.a.aE(this);
            if (mVar instanceof y) {
                this.mBundle.putBoolean("intent_bind_end", true);
                com.tencent.mm.ui.base.h.bQ(this, getString(R.string.f_2));
                ab.i("MicroMsg.WalletVertifyCodeUI", "query bound bank card resp!");
                z = true;
            } else {
                if (!(mVar instanceof q)) {
                    if (aE.c((Activity) this, null)) {
                        a(new y(cNH(), 13), true, false);
                        ab.i("MicroMsg.WalletVertifyCodeUI", "to query bound bank card!");
                    } else {
                        z = true;
                    }
                }
                z = false;
            }
            if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.q) {
                h.pYm.e(10707, Integer.valueOf(2), Integer.valueOf(d.cSQ()));
            }
            if (this.tms != null && (mVar instanceof com.tencent.mm.wallet_core.tenpay.model.m)) {
                String token = ((com.tencent.mm.wallet_core.tenpay.model.m) mVar).getToken();
                if (!bo.isNullOrNil(token)) {
                    this.mBundle.putString("kreq_token", token);
                }
            }
            if (z) {
                ab.i("MicroMsg.WalletVertifyCodeUI", "forwardProcess1 and finish!");
                com.tencent.mm.wallet_core.a.j(this, this.mBundle);
                if (aE == null || !aE.bxP().equals("PayProcess")) {
                    ab.i("MicroMsg.WalletVertifyCodeUI", "finish self");
                    finish();
                }
                AppMethodBeat.o(47710);
                return true;
            }
        }
        AppMethodBeat.o(47710);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6g;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47711);
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(47711);
        return onKeyUp;
    }

    public void onDestroy() {
        AppMethodBeat.i(47713);
        this.Ahr.ng(1580);
        super.onDestroy();
        AppMethodBeat.o(47713);
    }

    public final boolean cNR() {
        AppMethodBeat.i(47714);
        boolean booleanExtra = getIntent().getBooleanExtra("key_need_confirm_finish", false);
        if ((this.pVL == null || !this.pVL.mXg) && !booleanExtra) {
            booleanExtra = super.cNR();
            AppMethodBeat.o(47714);
            return booleanExtra;
        }
        AppMethodBeat.o(47714);
        return true;
    }

    public final boolean i(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47715);
        ab.i("MicroMsg.WalletVertifyCodeUI", "onPreSceneEnd %s %s", Integer.valueOf(i2), mVar);
        if ((mVar instanceof n) && i2 == 0) {
            this.tLj = true;
            t.makeText(this, R.string.fmp, 0).show();
            ab.i("MicroMsg.WalletVertifyCodeUI", "tag it isCertInstalled ok");
        }
        AppMethodBeat.o(47715);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final String cRU() {
        String str;
        AppMethodBeat.i(47706);
        String bc = bo.bc(this.mBundle.getString("key_mobile"), "");
        if (bo.isNullOrNil(bc)) {
            Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
            if (bankcard != null) {
                str = bankcard.field_mobile;
                AppMethodBeat.o(47706);
                return str;
            }
        }
        str = bc;
        AppMethodBeat.o(47706);
        return str;
    }

    private void cu() {
        String str;
        AppMethodBeat.i(138558);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        String cRU = cRU();
        if (!bo.isNullOrNil(cRU) || bankcard == null) {
            str = cRU;
        } else {
            str = bankcard.field_mobile;
            this.mBundle.putString("key_mobile", str);
        }
        this.tLi.setText(getString(R.string.fqk, new Object[]{str}));
        CharSequence dOF = dOF();
        if (bo.ac(dOF)) {
            this.tLh.setText(String.format(getString(R.string.fua), new Object[]{str}));
            AppMethodBeat.o(138558);
            return;
        }
        this.tLh.setText(dOF);
        AppMethodBeat.o(138558);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRW() {
        AppMethodBeat.i(47709);
        Bundle bundle = this.mBundle;
        String string = this.mBundle.getString("key_pwd1");
        this.tLd = this.tLb.getText();
        s sVar = new s();
        sVar.guu = string;
        sVar.pGr = this.pVL;
        sVar.tCi = this.tLd;
        sVar.token = bo.bc(this.mBundle.getString("kreq_token"), "");
        Bankcard bankcard = (Bankcard) bundle.getParcelable("key_bankcard");
        if (bankcard != null) {
            sVar.pbn = bankcard.field_bankcardType;
            sVar.pbo = bankcard.field_bindSerial;
            sVar.twk = bo.bc(bankcard.field_arrive_type, "");
        } else {
            sVar.pbn = this.mBundle.getString("key_bank_type");
            if (bo.isNullOrNil(sVar.pbn)) {
                sVar.pbn = this.mBundle.getString("key_bind_card_type", "");
            }
        }
        ab.d("MicroMsg.WalletVertifyCodeUI", "payInfo " + sVar.pGr + " mVerifyCode: " + this.tLd);
        bundle.putString("key_verify_code", this.tLd);
        com.tencent.mm.wallet_core.a.aE(this);
        ab.i("MicroMsg.WalletVertifyCodeUI", "do verify result : ".concat(String.valueOf(dOE().p(this.tLd, sVar))));
        AppMethodBeat.o(47709);
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(47712);
        if (this.tLb.fx(null)) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.o(47712);
            return;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.o(47712);
    }

    static /* synthetic */ boolean a(WalletVerifyCodeUI walletVerifyCodeUI, com.tencent.mm.wallet_core.c.n.a aVar) {
        AppMethodBeat.i(47716);
        if (walletVerifyCodeUI.tLj) {
            ab.i("MicroMsg.WalletVertifyCodeUI", "isCertInstalled passed");
            AppMethodBeat.o(47716);
            return false;
        } else if (walletVerifyCodeUI.tLl.cPo()) {
            ab.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall %s", aVar);
            if (bo.isNullOrNil(walletVerifyCodeUI.tLb.getText())) {
                ab.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isBlockInstall sms error %s", aVar);
                AppMethodBeat.o(47716);
                return false;
            }
            h.pYm.e(13731, Integer.valueOf(6));
            walletVerifyCodeUI.a(new n(walletVerifyCodeUI.tLb.getText(), walletVerifyCodeUI.cNH(), aVar, true), true, true);
            AppMethodBeat.o(47716);
            return true;
        } else if (walletVerifyCodeUI.tLl.cPn()) {
            ab.i("MicroMsg.WalletVertifyCodeUI", "tryToinstallCert isNeedInstall %s", aVar);
            h.pYm.e(13731, Integer.valueOf(6));
            walletVerifyCodeUI.a(new n(walletVerifyCodeUI.tLb.getText(), walletVerifyCodeUI.cNH(), aVar, false), true, true);
            AppMethodBeat.o(47716);
            return true;
        } else {
            ab.i("MicroMsg.WalletVertifyCodeUI", "no need installcert");
            AppMethodBeat.o(47716);
            return false;
        }
    }

    static /* synthetic */ void e(WalletVerifyCodeUI walletVerifyCodeUI) {
        String string;
        AppMethodBeat.i(47717);
        if (walletVerifyCodeUI.tLe == null) {
            walletVerifyCodeUI.tLe = "";
        }
        if (r.YM()) {
            string = walletVerifyCodeUI.getString(R.string.fue);
        } else {
            string = walletVerifyCodeUI.getString(R.string.fud);
        }
        String format = String.format(string, new Object[]{walletVerifyCodeUI.tLe});
        LayoutInflater layoutInflater = (LayoutInflater) walletVerifyCodeUI.mController.ylL.getSystemService("layout_inflater");
        View view = (TextView) layoutInflater.inflate(R.layout.a7c, null);
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.dimen.l5);
        view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        view.setText(format);
        com.tencent.mm.ui.base.h.a(walletVerifyCodeUI.mController.ylL, walletVerifyCodeUI.getString(R.string.fuf), walletVerifyCodeUI.getString(R.string.ffp), view, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(47717);
    }
}
