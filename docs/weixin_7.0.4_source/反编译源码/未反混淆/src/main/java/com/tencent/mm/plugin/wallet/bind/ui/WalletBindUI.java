package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.ui.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletBindUI extends WalletBaseUI {
    private s onl = new s();
    private PayInfo pGr = new PayInfo();
    private boolean tmf = false;
    private String tmg;
    private int tmh = -1;
    private com.tencent.mm.plugin.wallet_core.c.a tmi = null;
    private boolean tmj = false;
    c tmk = new c<um>() {
        {
            AppMethodBeat.i(45797);
            this.xxI = um.class.getName().hashCode();
            AppMethodBeat.o(45797);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(45798);
            WalletBindUI.this.finish();
            AppMethodBeat.o(45798);
            return false;
        }
    };
    private String token = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindUI() {
        AppMethodBeat.i(45803);
        AppMethodBeat.o(45803);
    }

    static /* synthetic */ void c(WalletBindUI walletBindUI) {
        AppMethodBeat.i(45817);
        walletBindUI.cNx();
        AppMethodBeat.o(45817);
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        AppMethodBeat.i(45804);
        super.onCreate(bundle);
        nf(580);
        this.onl.tLw = new s.b() {
            public final int bNq() {
                return 1;
            }

            public final Context getContext() {
                return WalletBindUI.this;
            }
        };
        this.tmg = getIntent().getStringExtra("key_import_key");
        this.tmh = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i = getIntent().getIntExtra("key_bind_scene", 13);
        }
        uq uqVar = new uq();
        if (i == 4) {
            uqVar.cQP.scene = 20;
        } else {
            uqVar.cQP.scene = 13;
        }
        uqVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(45796);
                if (WalletBindUI.this.tmj) {
                    AppMethodBeat.o(45796);
                    return;
                }
                if (WalletBindUI.this.tmh == 4) {
                    WalletBindUI.this.onl.a(new s.a() {
                        public final void bNo() {
                            AppMethodBeat.i(45793);
                            WalletBindUI.c(WalletBindUI.this);
                            AppMethodBeat.o(45793);
                        }

                        public final void cancel() {
                            AppMethodBeat.i(45794);
                            WalletBindUI.this.finish();
                            AppMethodBeat.o(45794);
                        }

                        public final void bNp() {
                            AppMethodBeat.i(45795);
                            WalletBindUI.c(WalletBindUI.this);
                            AppMethodBeat.o(45795);
                        }
                    }, new ai().cQe());
                } else {
                    WalletBindUI.c(WalletBindUI.this);
                }
                if (!WalletBindUI.this.tmj) {
                    WalletBindUI.this.tmj = true;
                }
                AppMethodBeat.o(45796);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uqVar);
        com.tencent.mm.sdk.b.a.xxA.c(this.tmk);
        z.hL(6, 0);
        AppMethodBeat.o(45804);
    }

    private void cNx() {
        AppMethodBeat.i(45805);
        this.pGr.cIg = this.tmh;
        this.mBundle.putParcelable("key_pay_info", this.pGr);
        if (this.tmh == 2) {
            if (bo.isNullOrNil(this.tmg)) {
                JN("");
                AppMethodBeat.o(45805);
                return;
            }
            ab.d("MicroMsg.WalletBindUI", "importKey " + this.tmg);
            a(new com.tencent.mm.plugin.wallet.bind.a.c(this.tmg, this.pGr), true, false);
            AppMethodBeat.o(45805);
        } else if (this.tmh == 4) {
            x.QN(4);
            if (getIntent() == null) {
                JN("");
                AppMethodBeat.o(45805);
                return;
            }
            String stringExtra = getIntent().getStringExtra("appId");
            String stringExtra2 = getIntent().getStringExtra("timeStamp");
            String stringExtra3 = getIntent().getStringExtra("nonceStr");
            String stringExtra4 = getIntent().getStringExtra("packageExt");
            String stringExtra5 = getIntent().getStringExtra("signtype");
            String stringExtra6 = getIntent().getStringExtra("paySignature");
            String stringExtra7 = getIntent().getStringExtra("url");
            int intExtra = getIntent().getIntExtra("pay_channel", 0);
            if (this.tmh == 6) {
                this.tmi = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.tmi = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            a(this.tmi, true, false);
            AppMethodBeat.o(45805);
        } else if (this.tmh == 6) {
            cNy();
            AppMethodBeat.o(45805);
        } else {
            He(this.tmh);
            AppMethodBeat.o(45805);
        }
    }

    private void He(int i) {
        AppMethodBeat.i(45806);
        ab.i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + bo.dpG().toString());
        Bundle bundle = this.mBundle;
        bundle.putParcelable("key_pay_info", this.pGr);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        com.tencent.mm.plugin.wallet.a.s.cNC();
        if (com.tencent.mm.plugin.wallet.a.s.cND().cQl()) {
            ab.i("MicroMsg.WalletBindUI", "user status invalid");
            if (i == 4) {
                a(new y(null, 20), true, false);
                AppMethodBeat.o(45806);
                return;
            }
            a(new y(null, 12), true, false);
            AppMethodBeat.o(45806);
            return;
        }
        com.tencent.mm.plugin.wallet.a.s.cNC();
        if (com.tencent.mm.plugin.wallet.a.s.cND().cQg()) {
            ab.i("MicroMsg.WalletBindUI", "user status reg");
            this.tmf = true;
            this.pGr.cIg = this.tmh;
            bundle.putInt("key_bind_scene", this.pGr.cIg);
            if (!bo.isNullOrNil(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
            AppMethodBeat.o(45806);
            return;
        }
        ab.i("MicroMsg.WalletBindUI", "user status unreg");
        this.tmf = true;
        if (this.tmh >= 0) {
            this.pGr.cIg = this.tmh;
        } else {
            this.pGr.cIg = 1;
        }
        bundle.putInt("key_bind_scene", this.pGr.cIg);
        com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, null);
        AppMethodBeat.o(45806);
    }

    private void cNy() {
        int i = 0;
        AppMethodBeat.i(45807);
        com.tencent.mm.plugin.wallet.a.s.cNC();
        if (com.tencent.mm.plugin.wallet.a.s.cND().cQl()) {
            a(new y(null, 12), true, false);
            AppMethodBeat.o(45807);
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!bo.isNullOrNil(str) && split.length >= 2) {
            int length = split.length;
            str = null;
            String str2 = null;
            while (i < length) {
                String str3 = split[i];
                if (str3.startsWith("bankType=")) {
                    str2 = str3.replace("bankType=", "");
                } else if (str3.startsWith("bankName=")) {
                    str = str3.replace("bankName=", "");
                }
                i++;
            }
            if (!(bo.isNullOrNil(str) || bo.isNullOrNil(str2))) {
                com.tencent.mm.plugin.wallet.a.s.cNC();
                if (com.tencent.mm.plugin.wallet.a.s.cND().acC(str2)) {
                    Bundle bundle = new Bundle();
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    com.tencent.mm.wallet_core.a.a((Activity) this, "WXCreditOpenProcess", bundle, null);
                    AppMethodBeat.o(45807);
                    return;
                }
            }
        }
        finish();
        AppMethodBeat.o(45807);
    }

    public void onResume() {
        AppMethodBeat.i(45808);
        if (this.tmf) {
            finish();
        }
        super.onResume();
        this.onl.onResume();
        AppMethodBeat.o(45808);
    }

    public void onPause() {
        AppMethodBeat.i(45809);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.o(45809);
    }

    public void onDestroy() {
        AppMethodBeat.i(45810);
        ng(580);
        com.tencent.mm.sdk.b.a.xxA.d(this.tmk);
        super.onDestroy();
        AppMethodBeat.o(45810);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45811);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.o(45811);
                return;
            }
            this.onl.cancel();
            finish();
        }
        AppMethodBeat.o(45811);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45812);
        if (mVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            this.tmf = true;
        }
        if (i != 0 || i2 != 0) {
            JN(str);
            AppMethodBeat.o(45812);
            return true;
        } else if (mVar instanceof y) {
            if (this.tmh == 6) {
                cNy();
            } else {
                cNx();
            }
            AppMethodBeat.o(45812);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet.bind.a.c) {
            com.tencent.mm.plugin.wallet.bind.a.c cVar = (com.tencent.mm.plugin.wallet.bind.a.c) mVar;
            Bundle bundle = this.mBundle;
            bundle.putBoolean("key_is_import_bind", true);
            if (cVar.tgB == null || cVar.tgB.size() <= 0) {
                if (bo.isNullOrNil(str)) {
                    str = getString(R.string.f_w);
                }
                h.a((Context) this, str, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45801);
                        WalletBindUI.this.finish();
                        AppMethodBeat.o(45801);
                    }
                });
            } else {
                Bankcard bankcard = (Bankcard) cVar.tgB.get(0);
                if (bankcard.txb) {
                    h.a((Context) this, (int) R.string.fbo, 0, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45800);
                            WalletBindUI.this.finish();
                            AppMethodBeat.o(45800);
                        }
                    });
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", cVar.token);
                    bundle.putString("key_bank_username", cVar.tli);
                    bundle.putString("key_recommand_desc", cVar.tlj);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.tmf = true;
                    bundle.putInt("key_bind_scene", 2);
                    com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet_core.b.b.class, bundle, new com.tencent.mm.wallet_core.c.a() {
                        public final Intent n(int i, Bundle bundle) {
                            AppMethodBeat.i(45799);
                            Intent intent = new Intent(WalletBindUI.this.mController.ylL, WalletBankcardManageUI.class);
                            AppMethodBeat.o(45799);
                            return intent;
                        }
                    });
                }
            }
            AppMethodBeat.o(45812);
            return true;
        } else {
            if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                if (this.tmi == null || !this.tmi.equals(mVar)) {
                    x.dNV();
                } else {
                    f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                    this.token = ((com.tencent.mm.plugin.wallet_core.c.a) mVar).getToken();
                    He(4);
                    AppMethodBeat.o(45812);
                    return true;
                }
            }
            AppMethodBeat.o(45812);
            return false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(45813);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.tmf);
        AppMethodBeat.o(45813);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(45814);
        super.onRestoreInstanceState(bundle);
        this.tmf = bundle.getBoolean("key_is_jump", false);
        AppMethodBeat.o(45814);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean bNf() {
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(45815);
        if (intent == null) {
            ab.e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(45815);
            return;
        }
        super.onNewIntent(intent);
        ab.v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            ab.i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            ab.d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
        AppMethodBeat.o(45815);
    }

    private void JN(String str) {
        AppMethodBeat.i(45816);
        if (bo.isNullOrNil(str)) {
            str = getString(R.string.fu2);
        }
        h.a((Context) this, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45802);
                WalletBindUI.this.finish();
                AppMethodBeat.o(45802);
            }
        });
        AppMethodBeat.o(45816);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
