package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.gq;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.util.ActUtil;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int gOW;
    private int gwj = -1;
    boolean paU = true;
    private boolean paV = false;
    private c<gq> paW = new c<gq>() {
        {
            AppMethodBeat.i(43632);
            this.xxI = gq.class.getName().hashCode();
            AppMethodBeat.o(43632);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(43633);
            ab.i("MicroMsg.WalletOfflineEntranceUI", "rcv fuck event: %s", ((gq) bVar).cBo.cBp);
            Intent intent = new Intent();
            intent.putExtra("key_callback", r7.cBo.cBp);
            WalletOfflineEntranceUI.this.setResult(-1, intent);
            WalletOfflineEntranceUI.this.finish();
            AppMethodBeat.o(43633);
            return false;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOfflineEntranceUI() {
        AppMethodBeat.i(43634);
        AppMethodBeat.o(43634);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43635);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(0);
        } else if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        com.tencent.mm.wallet_core.c.b.dNJ();
        com.tencent.mm.wallet_core.c.b.init(getApplicationContext());
        this.paW.dnU();
        bYa();
        AppMethodBeat.o(43635);
    }

    private void bYa() {
        AppMethodBeat.i(43636);
        ab.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        k.Hp(1);
        e.QS(30);
        bYc();
        this.gOW = getIntent().getIntExtra("key_from_scene", 0);
        if (getIntent().getBooleanExtra("is_offline_create", false) || !(this.gOW == 6 || this.gOW == 7)) {
            init();
            this.paU = false;
            AppMethodBeat.o(43636);
            return;
        }
        m aVar;
        ab.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", Integer.valueOf(this.gOW));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("appId");
        String stringExtra2 = intent.getStringExtra("timeStamp");
        String stringExtra3 = intent.getStringExtra("nonceStr");
        String stringExtra4 = intent.getStringExtra("packageExt");
        String stringExtra5 = intent.getStringExtra("signtype");
        String stringExtra6 = intent.getStringExtra("paySignature");
        int intExtra = intent.getIntExtra("pay_channel", 0);
        if (this.gOW == 6) {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra("url"), 16, ax.NAME, intExtra);
        } else {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, 16, intent.getStringExtra("wxapp_username"), intent.getStringExtra("wxapp_path"), ax.NAME, intExtra);
        }
        nf(580);
        a(aVar, true, false);
        this.paU = false;
        AppMethodBeat.o(43636);
    }

    public void onDestroy() {
        AppMethodBeat.i(43637);
        super.onDestroy();
        this.paW.dead();
        AppMethodBeat.o(43637);
    }

    private void bYb() {
        int i = 3;
        AppMethodBeat.i(43638);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_from_scene")) {
            int intExtra = intent.getIntExtra("key_from_scene", 0);
            if (intExtra == 1) {
                this.gwj = 1;
                i = 2;
            } else if (intExtra == 2) {
                this.gwj = 2;
                i = 1;
            } else if (intExtra == 3) {
                this.gwj = 3;
            } else if (intExtra == 4) {
                this.gwj = 4;
                i = 6;
            } else if (intExtra == 5) {
                this.gwj = 8;
                i = 4;
            } else if (intExtra == 6) {
                this.gwj = 10;
                i = 7;
            } else if (intExtra == 7) {
                this.gwj = 11;
                i = 8;
            } else if (intExtra == 8) {
                this.gwj = 12;
                i = 9;
            } else {
                this.gwj = 0;
                ab.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", Integer.valueOf(intExtra));
                i = 1;
            }
            h.pYm.e(14021, Integer.valueOf(1), Integer.valueOf(i));
        }
        AppMethodBeat.o(43638);
    }

    private void init() {
        AppMethodBeat.i(43639);
        bYb();
        if (r.cPI().cQl()) {
            ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            a(new y(null, 8), true, false);
            this.paU = false;
            AppMethodBeat.o(43639);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_entry_scene", this.gwj);
        intent.putExtra("key_from_scene", this.gOW);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!bo.isNullOrNil(stringExtra)) {
            intent.putExtra("key_business_attach", stringExtra);
        }
        intent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        intent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
        d.b(this.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent, 1);
        AppMethodBeat.o(43639);
    }

    public void onResume() {
        AppMethodBeat.i(43640);
        super.onResume();
        ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.paU) {
            ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.c.a.bYd()) {
                ab.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.gwj);
                intent.putExtra("key_from_scene", 0);
                AppMethodBeat.o(43640);
                return;
            }
            ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            AppMethodBeat.o(43640);
            return;
        }
        ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.paU = true;
        AppMethodBeat.o(43640);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43641);
        if (i == 1 && i2 == -1) {
            ab.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
        } else {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(43641);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43642);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
                f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
                init();
                if (this.gOW == 6 || this.gOW == 7) {
                    Intent intent = new Intent();
                    if (this.paV) {
                        intent.putExtra("key_callback", "return");
                    } else {
                        intent.putExtra("key_callback", "ok");
                    }
                    setResult(-1, intent);
                }
                AppMethodBeat.o(43642);
                return true;
            }
            ab.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.gOW == 6 || this.gOW == 7) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_callback", "fail");
                setResult(0, intent2);
            }
            finish();
            AppMethodBeat.o(43642);
            return true;
        } else if (i == 0 && i2 == 0) {
            ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            AppMethodBeat.o(43642);
            return true;
        } else {
            ab.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            init();
            ab.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
            finish();
            AppMethodBeat.o(43642);
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43643);
        if (i == 4) {
            finish();
        }
        AppMethodBeat.o(43643);
        return true;
    }

    private void bYc() {
        AppMethodBeat.i(43644);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            ab.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(intExtra)));
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.c.a.pbe = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                ab.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.c.a.pbf = intExtra;
                com.tencent.mm.plugin.offline.c.a.pbg = longExtra;
                com.tencent.mm.plugin.offline.c.a.pbh = booleanExtra;
                com.tencent.mm.plugin.offline.c.a.kaE = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.c.a.pbi = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.c.a.pbj = getIntent().getStringExtra("key_card_code");
                AppMethodBeat.o(43644);
                return;
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.c.a.pbe = intExtra;
                com.tencent.mm.plugin.offline.c.a.pbf = 0;
                com.tencent.mm.plugin.offline.c.a.pbg = 0;
                com.tencent.mm.plugin.offline.c.a.pbh = false;
                com.tencent.mm.plugin.offline.c.a.kaE = "";
                com.tencent.mm.plugin.offline.c.a.pbi = "";
                com.tencent.mm.plugin.offline.c.a.pbj = "";
            }
        }
        AppMethodBeat.o(43644);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(43645);
        ab.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
        if (intent == null || !intent.hasExtra("is_offline_create")) {
            this.paU = false;
            this.paV = true;
            setIntent(intent);
            bYa();
            AppMethodBeat.o(43645);
            return;
        }
        this.paU = true;
        this.paV = true;
        setIntent(intent);
        bYa();
        AppMethodBeat.o(43645);
    }
}
