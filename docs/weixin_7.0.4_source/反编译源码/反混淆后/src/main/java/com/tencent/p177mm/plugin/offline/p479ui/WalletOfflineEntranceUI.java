package com.tencent.p177mm.plugin.offline.p479ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32565gq;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33246ax;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.util.ActUtil;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI */
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int gOW;
    private int gwj = -1;
    boolean paU = true;
    private boolean paV = false;
    private C4884c<C32565gq> paW = new C127561();

    /* renamed from: com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI$1 */
    class C127561 extends C4884c<C32565gq> {
        C127561() {
            AppMethodBeat.m2504i(43632);
            this.xxI = C32565gq.class.getName().hashCode();
            AppMethodBeat.m2505o(43632);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43633);
            C4990ab.m7417i("MicroMsg.WalletOfflineEntranceUI", "rcv fuck event: %s", ((C32565gq) c4883b).cBo.cBp);
            Intent intent = new Intent();
            intent.putExtra("key_callback", r7.cBo.cBp);
            WalletOfflineEntranceUI.this.setResult(-1, intent);
            WalletOfflineEntranceUI.this.finish();
            AppMethodBeat.m2505o(43633);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOfflineEntranceUI() {
        AppMethodBeat.m2504i(43634);
        AppMethodBeat.m2505o(43634);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43635);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(0);
        } else if (VERSION.SDK_INT >= 19) {
            getWindow().addFlags(67108864);
        }
        C40928b.dNJ();
        C40928b.init(getApplicationContext());
        this.paW.dnU();
        bYa();
        AppMethodBeat.m2505o(43635);
    }

    private void bYa() {
        AppMethodBeat.m2504i(43636);
        C4990ab.m7418v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        C22594k.m34292Hp(1);
        C36391e.m59978QS(30);
        bYc();
        this.gOW = getIntent().getIntExtra("key_from_scene", 0);
        if (getIntent().getBooleanExtra("is_offline_create", false) || !(this.gOW == 6 || this.gOW == 7)) {
            init();
            this.paU = false;
            AppMethodBeat.m2505o(43636);
            return;
        }
        C1207m c22558a;
        C4990ab.m7417i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", Integer.valueOf(this.gOW));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("appId");
        String stringExtra2 = intent.getStringExtra("timeStamp");
        String stringExtra3 = intent.getStringExtra("nonceStr");
        String stringExtra4 = intent.getStringExtra("packageExt");
        String stringExtra5 = intent.getStringExtra("signtype");
        String stringExtra6 = intent.getStringExtra("paySignature");
        int intExtra = intent.getIntExtra("pay_channel", 0);
        if (this.gOW == 6) {
            c22558a = new C22558a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra("url"), 16, C33246ax.NAME, intExtra);
        } else {
            c22558a = new C22558a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, 16, intent.getStringExtra("wxapp_username"), intent.getStringExtra("wxapp_path"), C33246ax.NAME, intExtra);
        }
        mo39992nf(580);
        mo39970a(c22558a, true, false);
        this.paU = false;
        AppMethodBeat.m2505o(43636);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43637);
        super.onDestroy();
        this.paW.dead();
        AppMethodBeat.m2505o(43637);
    }

    private void bYb() {
        int i = 3;
        AppMethodBeat.m2504i(43638);
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
                C4990ab.m7417i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", Integer.valueOf(intExtra));
                i = 1;
            }
            C7060h.pYm.mo8381e(14021, Integer.valueOf(1), Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(43638);
    }

    private void init() {
        AppMethodBeat.m2504i(43639);
        bYb();
        if (C14241r.cPI().cQl()) {
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            mo39970a(new C35475y(null, 8), true, false);
            this.paU = false;
            AppMethodBeat.m2505o(43639);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_entry_scene", this.gwj);
        intent.putExtra("key_from_scene", this.gOW);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            intent.putExtra("key_business_attach", stringExtra);
        }
        intent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        intent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
        C25985d.m41468b(this.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent, 1);
        AppMethodBeat.m2505o(43639);
    }

    public void onResume() {
        AppMethodBeat.m2504i(43640);
        super.onResume();
        C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.paU) {
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (C28630a.bYd()) {
                C4990ab.m7418v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.gwj);
                intent.putExtra("key_from_scene", 0);
                AppMethodBeat.m2505o(43640);
                return;
            }
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            AppMethodBeat.m2505o(43640);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.paU = true;
        AppMethodBeat.m2505o(43640);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43641);
        if (i == 1 && i2 == -1) {
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
        } else {
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(43641);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43642);
        if (c1207m instanceof C22558a) {
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
                C46512f.akr(((C22558a) c1207m).cOS());
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
                AppMethodBeat.m2505o(43642);
                return true;
            }
            C4990ab.m7417i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.gOW == 6 || this.gOW == 7) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_callback", "fail");
                setResult(0, intent2);
            }
            finish();
            AppMethodBeat.m2505o(43642);
            return true;
        } else if (i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            AppMethodBeat.m2505o(43642);
            return true;
        } else {
            C4990ab.m7417i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
            init();
            C4990ab.m7412e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
            finish();
            AppMethodBeat.m2505o(43642);
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43643);
        if (i == 4) {
            finish();
        }
        AppMethodBeat.m2505o(43643);
        return true;
    }

    private void bYc() {
        AppMethodBeat.m2504i(43644);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(intExtra)));
            if (intExtra == 3) {
                C28630a.pbe = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                C28630a.pbf = intExtra;
                C28630a.pbg = longExtra;
                C28630a.pbh = booleanExtra;
                C28630a.kaE = getIntent().getStringExtra("key_card_id");
                C28630a.pbi = getIntent().getStringExtra("key_user_card_id");
                C28630a.pbj = getIntent().getStringExtra("key_card_code");
                AppMethodBeat.m2505o(43644);
                return;
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                C28630a.pbe = intExtra;
                C28630a.pbf = 0;
                C28630a.pbg = 0;
                C28630a.pbh = false;
                C28630a.kaE = "";
                C28630a.pbi = "";
                C28630a.pbj = "";
            }
        }
        AppMethodBeat.m2505o(43644);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(43645);
        C4990ab.m7416i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
        if (intent == null || !intent.hasExtra("is_offline_create")) {
            this.paU = false;
            this.paV = true;
            setIntent(intent);
            bYa();
            AppMethodBeat.m2505o(43645);
            return;
        }
        this.paU = true;
        this.paV = true;
        setIntent(intent);
        bYa();
        AppMethodBeat.m2505o(43645);
    }
}
