package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.loan.C40068a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C35445c;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22585ah;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29677n;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C29682c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C7184s;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.VError;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI */
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String gEk;
    private double pPz;
    private String pcl = "CNY";
    protected C40131q toD;
    private String toP;
    private String toQ;
    private String toR;
    private String toS;
    private String toT;
    private String toU;
    private String toV;
    private String toW;
    private int toX;
    private String token;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$2 */
    class C43652 implements OnClickListener {
        C43652() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45992);
            WalletLoanRepaymentUI.m6719c(WalletLoanRepaymentUI.this);
            if (WalletLoanRepaymentUI.this.toD != null) {
                WalletLoanRepaymentUI.this.toD.dismiss();
            }
            AppMethodBeat.m2505o(45992);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$3 */
    class C43663 implements OnCancelListener {
        C43663() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(45993);
            if (WalletLoanRepaymentUI.this.toD != null) {
                WalletLoanRepaymentUI.this.toD.cancel();
                WalletLoanRepaymentUI.this.setResult(0);
                WalletLoanRepaymentUI.this.finish();
            }
            AppMethodBeat.m2505o(45993);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$4 */
    class C43674 implements DialogInterface.OnClickListener {
        C43674() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45994);
            C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
            WalletLoanRepaymentUI.this.cNT();
            AppMethodBeat.m2505o(45994);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$5 */
    class C43685 implements DialogInterface.OnClickListener {
        C43685() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45995);
            if (WalletLoanRepaymentUI.this.bwP()) {
                WalletLoanRepaymentUI.this.finish();
            }
            AppMethodBeat.m2505o(45995);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$6 */
    class C43696 implements C30857a {
        C43696() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(45996);
            if (i == -1) {
                WalletLoanRepaymentUI.m6718b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.this.token);
            } else {
                C22585ah cPJ = C14241r.cPJ();
                if (cPJ.cPU()) {
                    WalletLoanRepaymentUI.m6715a(WalletLoanRepaymentUI.this, cPJ.cPV(), WalletLoanRepaymentUI.this.pPz, WalletLoanRepaymentUI.this.pcl);
                } else {
                    WalletLoanRepaymentUI.this.setResult(0, null);
                }
            }
            AppMethodBeat.m2505o(45996);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI$1 */
    class C43701 implements C29682c {
        C43701() {
        }

        /* renamed from: a */
        public final void mo9392a(String str, FavorPayInfo favorPayInfo, boolean z) {
            AppMethodBeat.m2504i(45991);
            WalletLoanRepaymentUI.this.gEk = str;
            WalletLoanRepaymentUI.this.mo39970a(new C7184s(WalletLoanRepaymentUI.this.gEk, WalletLoanRepaymentUI.this.token, (byte) 0), true, true);
            AppMethodBeat.m2505o(45991);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m6715a(WalletLoanRepaymentUI walletLoanRepaymentUI, Bankcard bankcard, double d, String str) {
        AppMethodBeat.m2504i(46008);
        walletLoanRepaymentUI.m6716a(bankcard, d, str);
        AppMethodBeat.m2505o(46008);
    }

    /* renamed from: b */
    static /* synthetic */ void m6718b(WalletLoanRepaymentUI walletLoanRepaymentUI, String str) {
        AppMethodBeat.m2504i(46007);
        walletLoanRepaymentUI.act(str);
        AppMethodBeat.m2505o(46007);
    }

    /* renamed from: c */
    static /* synthetic */ void m6719c(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        AppMethodBeat.m2504i(46006);
        walletLoanRepaymentUI.cNS();
        AppMethodBeat.m2505o(46006);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45997);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.toU = intent.getStringExtra("appId");
        this.toP = intent.getStringExtra("timeStamp");
        this.toQ = intent.getStringExtra("nonceStr");
        this.toR = intent.getStringExtra("packageExt");
        this.toS = intent.getStringExtra("signtype");
        this.toT = intent.getStringExtra("paySignature");
        this.toV = intent.getStringExtra("url");
        this.toX = intent.getIntExtra("pay_channel", 0);
        mo39992nf(580);
        mo39970a(new C22558a(this.toU, this.toP, this.toQ, this.toR, this.toS, this.toT, this.toV, 7, "getWebPayCheckoutCounterRequst", this.toX), true, false);
        AppMethodBeat.m2505o(45997);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45998);
        super.onResume();
        AppMethodBeat.m2505o(45998);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void act(String str) {
        AppMethodBeat.m2504i(45999);
        mo39970a(new C35445c(str), true, false);
        AppMethodBeat.m2505o(45999);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46000);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C22558a) {
                C46512f.akr(((C22558a) c1207m).cOS());
                this.token = ((C22558a) c1207m).getToken();
                act(this.token);
                AppMethodBeat.m2505o(46000);
                return true;
            } else if (c1207m instanceof C35445c) {
                C35445c c35445c = (C35445c) c1207m;
                this.pcl = c35445c.pcl;
                this.pPz = c35445c.pPz;
                this.desc = c35445c.desc;
                C22585ah cPJ = C14241r.cPJ();
                if (cPJ.cPU()) {
                    Bankcard cPV = cPJ.cPV();
                    if (cPV == null || !C5046bo.isNullOrNil(cPV.field_forbidWord)) {
                        cNS();
                    } else {
                        m6716a(cPV, this.pPz, this.pcl);
                    }
                } else {
                    C30379h.m48466d(this, getResources().getString(C25738R.string.fgx), "", getString(C25738R.string.fnt), getString(C25738R.string.f9076or), new C43674(), new C43685());
                }
                AppMethodBeat.m2505o(46000);
                return true;
            } else if (c1207m instanceof C7184s) {
                C7184s c7184s = (C7184s) c1207m;
                if (c7184s.cOT()) {
                    C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.gEk);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", c7184s.tul);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", c7184s.tuk);
                    C24143a.m37105a(this, C29677n.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", c7184s.tui);
                    intent.putExtra("bind_serial", this.toW);
                    setResult(-1, intent);
                    finish();
                }
                AppMethodBeat.m2505o(46000);
                return true;
            }
        }
        AppMethodBeat.m2505o(46000);
        return false;
    }

    /* renamed from: a */
    private void m6716a(Bankcard bankcard, double d, String str) {
        AppMethodBeat.m2504i(46001);
        C29682c c43701 = new C43701();
        OnClickListener c43652 = new C43652();
        OnCancelListener c43663 = new C43663();
        this.toW = bankcard.field_bindSerial;
        this.toD = C40131q.m68801a((Context) this, this.desc, d, str, bankcard, c43701, c43652, c43663);
        AppMethodBeat.m2505o(46001);
    }

    private void cNS() {
        AppMethodBeat.m2504i(46002);
        C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
        AppMethodBeat.m2505o(46002);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNT() {
        AppMethodBeat.m2504i(46003);
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        C24143a.m37106a((Activity) this, C40068a.class, bundle, new C43696());
        AppMethodBeat.m2505o(46003);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(46004);
        Bundle extras = intent.getExtras();
        C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            act(this.token);
            AppMethodBeat.m2505o(46004);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.toW);
            setResult(-1, intent2);
            finish();
            AppMethodBeat.m2505o(46004);
        } else {
            C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
            AppMethodBeat.m2505o(46004);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46005);
        Bankcard acB;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(46005);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", -1000);
            if (intExtra == VError.ERROR_DETECTOR_INSTANCE_INIT) {
                C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                cNT();
                AppMethodBeat.m2505o(46005);
            } else if (intExtra == 0) {
                C4990ab.m7416i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                acB = C14241r.cPJ().acB(intent.getStringExtra("bindSerial"));
                if (acB == null) {
                    C4990ab.m7412e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    AppMethodBeat.m2505o(46005);
                    return;
                }
                m6716a(acB, this.pPz, this.pcl);
                AppMethodBeat.m2505o(46005);
            } else {
                C4990ab.m7412e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
                AppMethodBeat.m2505o(46005);
            }
        } else {
            C22585ah cPJ = C14241r.cPJ();
            if (cPJ.cPU()) {
                acB = cPJ.cPV();
                if (acB == null || !C5046bo.isNullOrNil(acB.field_forbidWord)) {
                    finish();
                    AppMethodBeat.m2505o(46005);
                    return;
                }
                m6716a(acB, this.pPz, this.pcl);
                AppMethodBeat.m2505o(46005);
                return;
            }
            C4990ab.m7412e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
            AppMethodBeat.m2505o(46005);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }
}
