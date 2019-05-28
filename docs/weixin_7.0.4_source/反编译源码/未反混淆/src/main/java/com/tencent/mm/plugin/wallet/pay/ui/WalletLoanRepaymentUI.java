package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.pay.a.c;
import com.tencent.mm.plugin.wallet_core.c.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.n;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.ttpic.VError;

@a(7)
public class WalletLoanRepaymentUI extends WalletBaseUI {
    private String desc;
    private String gEk;
    private double pPz;
    private String pcl = "CNY";
    protected q toD;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletLoanRepaymentUI walletLoanRepaymentUI, Bankcard bankcard, double d, String str) {
        AppMethodBeat.i(46008);
        walletLoanRepaymentUI.a(bankcard, d, str);
        AppMethodBeat.o(46008);
    }

    static /* synthetic */ void b(WalletLoanRepaymentUI walletLoanRepaymentUI, String str) {
        AppMethodBeat.i(46007);
        walletLoanRepaymentUI.act(str);
        AppMethodBeat.o(46007);
    }

    static /* synthetic */ void c(WalletLoanRepaymentUI walletLoanRepaymentUI) {
        AppMethodBeat.i(46006);
        walletLoanRepaymentUI.cNS();
        AppMethodBeat.o(46006);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45997);
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
        nf(580);
        a(new com.tencent.mm.plugin.wallet_core.c.a(this.toU, this.toP, this.toQ, this.toR, this.toS, this.toT, this.toV, 7, "getWebPayCheckoutCounterRequst", this.toX), true, false);
        AppMethodBeat.o(45997);
    }

    public void onResume() {
        AppMethodBeat.i(45998);
        super.onResume();
        AppMethodBeat.o(45998);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void act(String str) {
        AppMethodBeat.i(45999);
        a(new c(str), true, false);
        AppMethodBeat.o(45999);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46000);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                this.token = ((com.tencent.mm.plugin.wallet_core.c.a) mVar).getToken();
                act(this.token);
                AppMethodBeat.o(46000);
                return true;
            } else if (mVar instanceof c) {
                c cVar = (c) mVar;
                this.pcl = cVar.pcl;
                this.pPz = cVar.pPz;
                this.desc = cVar.desc;
                ah cPJ = r.cPJ();
                if (cPJ.cPU()) {
                    Bankcard cPV = cPJ.cPV();
                    if (cPV == null || !bo.isNullOrNil(cPV.field_forbidWord)) {
                        cNS();
                    } else {
                        a(cPV, this.pPz, this.pcl);
                    }
                } else {
                    h.d(this, getResources().getString(R.string.fgx), "", getString(R.string.fnt), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45994);
                            ab.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new bankcard");
                            WalletLoanRepaymentUI.this.cNT();
                            AppMethodBeat.o(45994);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45995);
                            if (WalletLoanRepaymentUI.this.bwP()) {
                                WalletLoanRepaymentUI.this.finish();
                            }
                            AppMethodBeat.o(45995);
                        }
                    });
                }
                AppMethodBeat.o(46000);
                return true;
            } else if (mVar instanceof s) {
                s sVar = (s) mVar;
                if (sVar.cOT()) {
                    ab.i("MicroMsg.WalletLoanRepaymentUI", "need free sms");
                    Bundle bundle = new Bundle();
                    bundle.putString("key_pwd1", this.gEk);
                    bundle.putString("key_jsapi_token", this.token);
                    bundle.putString("key_relation_key", sVar.tul);
                    bundle.putInt("key_verify_scene", 8);
                    bundle.putString("key_mobile", sVar.tuk);
                    com.tencent.mm.wallet_core.a.a(this, n.class, bundle);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("token", sVar.tui);
                    intent.putExtra("bind_serial", this.toW);
                    setResult(-1, intent);
                    finish();
                }
                AppMethodBeat.o(46000);
                return true;
            }
        }
        AppMethodBeat.o(46000);
        return false;
    }

    private void a(Bankcard bankcard, double d, String str) {
        AppMethodBeat.i(46001);
        q.c anonymousClass1 = new q.c() {
            public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                AppMethodBeat.i(45991);
                WalletLoanRepaymentUI.this.gEk = str;
                WalletLoanRepaymentUI.this.a(new s(WalletLoanRepaymentUI.this.gEk, WalletLoanRepaymentUI.this.token, (byte) 0), true, true);
                AppMethodBeat.o(45991);
            }
        };
        View.OnClickListener anonymousClass2 = new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45992);
                WalletLoanRepaymentUI.c(WalletLoanRepaymentUI.this);
                if (WalletLoanRepaymentUI.this.toD != null) {
                    WalletLoanRepaymentUI.this.toD.dismiss();
                }
                AppMethodBeat.o(45992);
            }
        };
        OnCancelListener anonymousClass3 = new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(45993);
                if (WalletLoanRepaymentUI.this.toD != null) {
                    WalletLoanRepaymentUI.this.toD.cancel();
                    WalletLoanRepaymentUI.this.setResult(0);
                    WalletLoanRepaymentUI.this.finish();
                }
                AppMethodBeat.o(45993);
            }
        };
        this.toW = bankcard.field_bindSerial;
        this.toD = q.a((Context) this, this.desc, d, str, bankcard, anonymousClass1, anonymousClass2, anonymousClass3);
        AppMethodBeat.o(46001);
    }

    private void cNS() {
        AppMethodBeat.i(46002);
        ab.i("MicroMsg.WalletLoanRepaymentUI", "to change a bankcard");
        startActivityForResult(new Intent(this, WalletChangeLoanRepayBankcardUI.class), 1);
        AppMethodBeat.o(46002);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNT() {
        AppMethodBeat.i(46003);
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 8);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("kreq_token", this.token);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.loan.a.class, bundle, new com.tencent.mm.wallet_core.c.a() {
            public final Intent n(int i, Bundle bundle) {
                AppMethodBeat.i(45996);
                if (i == -1) {
                    WalletLoanRepaymentUI.b(WalletLoanRepaymentUI.this, WalletLoanRepaymentUI.this.token);
                } else {
                    ah cPJ = r.cPJ();
                    if (cPJ.cPU()) {
                        WalletLoanRepaymentUI.a(WalletLoanRepaymentUI.this, cPJ.cPV(), WalletLoanRepaymentUI.this.pPz, WalletLoanRepaymentUI.this.pcl);
                    } else {
                        WalletLoanRepaymentUI.this.setResult(0, null);
                    }
                }
                AppMethodBeat.o(45996);
                return null;
            }
        });
        AppMethodBeat.o(46003);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(46004);
        Bundle extras = intent.getExtras();
        ab.i("MicroMsg.WalletLoanRepaymentUI", "onNewIntent");
        if (extras.containsKey("intent_bind_end")) {
            ab.i("MicroMsg.WalletLoanRepaymentUI", "back from bind card");
            act(this.token);
            AppMethodBeat.o(46004);
        } else if (extras.containsKey("jsapi_verifycode_process_end")) {
            ab.i("MicroMsg.WalletLoanRepaymentUI", "back from verify code");
            Intent intent2 = new Intent();
            intent2.putExtra("token", intent.getStringExtra("token"));
            intent2.putExtra("bind_serial", this.toW);
            setResult(-1, intent2);
            finish();
            AppMethodBeat.o(46004);
        } else {
            ab.i("MicroMsg.WalletLoanRepaymentUI", "need to deal with,finish");
            finish();
            AppMethodBeat.o(46004);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46005);
        Bankcard acB;
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(46005);
        } else if (i2 == -1) {
            int intExtra = intent.getIntExtra("ret", -1000);
            if (intExtra == VError.ERROR_DETECTOR_INSTANCE_INIT) {
                ab.i("MicroMsg.WalletLoanRepaymentUI", "to bind a new card");
                cNT();
                AppMethodBeat.o(46005);
            } else if (intExtra == 0) {
                ab.i("MicroMsg.WalletLoanRepaymentUI", "change card ok");
                acB = r.cPJ().acB(intent.getStringExtra("bindSerial"));
                if (acB == null) {
                    ab.e("MicroMsg.WalletLoanRepaymentUI", "bankcard is null by getBankcardBySerialNo");
                    finish();
                    AppMethodBeat.o(46005);
                    return;
                }
                a(acB, this.pPz, this.pcl);
                AppMethodBeat.o(46005);
            } else {
                ab.e("MicroMsg.WalletLoanRepaymentUI", "activity return unknow error");
                AppMethodBeat.o(46005);
            }
        } else {
            ah cPJ = r.cPJ();
            if (cPJ.cPU()) {
                acB = cPJ.cPV();
                if (acB == null || !bo.isNullOrNil(acB.field_forbidWord)) {
                    finish();
                    AppMethodBeat.o(46005);
                    return;
                }
                a(acB, this.pPz, this.pcl);
                AppMethodBeat.o(46005);
                return;
            }
            ab.e("MicroMsg.WalletLoanRepaymentUI", "onActivityResult hasRepaymentBankcard is false");
            AppMethodBeat.o(46005);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }
}
