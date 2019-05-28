package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p230g.p231a.C45375um;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.bind.p1311a.C22520c;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C29629ai;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7187a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C7186s.C7188b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI */
public class WalletBindUI extends WalletBaseUI {
    private C7186s onl = new C7186s();
    private PayInfo pGr = new PayInfo();
    private boolean tmf = false;
    private String tmg;
    private int tmh = -1;
    private C22558a tmi = null;
    private boolean tmj = false;
    C4884c tmk = new C43573();
    private String token = null;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$4 */
    class C43534 implements C30857a {
        C43534() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(45799);
            Intent intent = new Intent(WalletBindUI.this.mController.ylL, WalletBankcardManageUI.class);
            AppMethodBeat.m2505o(45799);
            return intent;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$6 */
    class C43546 implements OnClickListener {
        C43546() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45801);
            WalletBindUI.this.finish();
            AppMethodBeat.m2505o(45801);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$2 */
    class C43552 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$2$1 */
        class C43561 implements C7187a {
            C43561() {
            }

            public final void bNo() {
                AppMethodBeat.m2504i(45793);
                WalletBindUI.m6702c(WalletBindUI.this);
                AppMethodBeat.m2505o(45793);
            }

            public final void cancel() {
                AppMethodBeat.m2504i(45794);
                WalletBindUI.this.finish();
                AppMethodBeat.m2505o(45794);
            }

            public final void bNp() {
                AppMethodBeat.m2504i(45795);
                WalletBindUI.m6702c(WalletBindUI.this);
                AppMethodBeat.m2505o(45795);
            }
        }

        C43552() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45796);
            if (WalletBindUI.this.tmj) {
                AppMethodBeat.m2505o(45796);
                return;
            }
            if (WalletBindUI.this.tmh == 4) {
                WalletBindUI.this.onl.mo15494a(new C43561(), new C29629ai().cQe());
            } else {
                WalletBindUI.m6702c(WalletBindUI.this);
            }
            if (!WalletBindUI.this.tmj) {
                WalletBindUI.this.tmj = true;
            }
            AppMethodBeat.m2505o(45796);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$3 */
    class C43573 extends C4884c<C45375um> {
        C43573() {
            AppMethodBeat.m2504i(45797);
            this.xxI = C45375um.class.getName().hashCode();
            AppMethodBeat.m2505o(45797);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45798);
            WalletBindUI.this.finish();
            AppMethodBeat.m2505o(45798);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$5 */
    class C43585 implements OnClickListener {
        C43585() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45800);
            WalletBindUI.this.finish();
            AppMethodBeat.m2505o(45800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$1 */
    class C43591 implements C7188b {
        C43591() {
        }

        public final int bNq() {
            return 1;
        }

        public final Context getContext() {
            return WalletBindUI.this;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBindUI$7 */
    class C43607 implements OnClickListener {
        C43607() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45802);
            WalletBindUI.this.finish();
            AppMethodBeat.m2505o(45802);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBindUI() {
        AppMethodBeat.m2504i(45803);
        AppMethodBeat.m2505o(45803);
    }

    /* renamed from: c */
    static /* synthetic */ void m6702c(WalletBindUI walletBindUI) {
        AppMethodBeat.m2504i(45817);
        walletBindUI.cNx();
        AppMethodBeat.m2505o(45817);
    }

    public void onCreate(Bundle bundle) {
        int i = -1;
        AppMethodBeat.m2504i(45804);
        super.onCreate(bundle);
        mo39992nf(580);
        this.onl.tLw = new C43591();
        this.tmg = getIntent().getStringExtra("key_import_key");
        this.tmh = getIntent().getIntExtra("key_bind_scene", -1);
        if (getIntent() != null) {
            i = getIntent().getIntExtra("key_bind_scene", 13);
        }
        C18416uq c18416uq = new C18416uq();
        if (i == 4) {
            c18416uq.cQP.scene = 20;
        } else {
            c18416uq.cQP.scene = 13;
        }
        c18416uq.callback = new C43552();
        C4879a.xxA.mo10055m(c18416uq);
        C4879a.xxA.mo10052c(this.tmk);
        C36381z.m59954hL(6, 0);
        AppMethodBeat.m2505o(45804);
    }

    private void cNx() {
        AppMethodBeat.m2504i(45805);
        this.pGr.cIg = this.tmh;
        this.mBundle.putParcelable("key_pay_info", this.pGr);
        if (this.tmh == 2) {
            if (C5046bo.isNullOrNil(this.tmg)) {
                m6699JN("");
                AppMethodBeat.m2505o(45805);
                return;
            }
            C4990ab.m7410d("MicroMsg.WalletBindUI", "importKey " + this.tmg);
            mo39970a(new C22520c(this.tmg, this.pGr), true, false);
            AppMethodBeat.m2505o(45805);
        } else if (this.tmh == 4) {
            C36379x.m59950QN(4);
            if (getIntent() == null) {
                m6699JN("");
                AppMethodBeat.m2505o(45805);
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
                this.tmi = new C22558a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 2, "getBrandWCPayCreateCreditCardRequest", intExtra);
            } else {
                this.tmi = new C22558a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, 1, "getBrandWCPayBindCardRequest", intExtra);
            }
            mo39970a(this.tmi, true, false);
            AppMethodBeat.m2505o(45805);
        } else if (this.tmh == 6) {
            cNy();
            AppMethodBeat.m2505o(45805);
        } else {
            m6698He(this.tmh);
            AppMethodBeat.m2505o(45805);
        }
    }

    /* renamed from: He */
    private void m6698He(int i) {
        AppMethodBeat.m2504i(45806);
        C4990ab.m7416i("MicroMsg.WalletBindUI", "doBindCardForOtherScene " + C5046bo.dpG().toString());
        Bundle bundle = this.mBundle;
        bundle.putParcelable("key_pay_info", this.pGr);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putString("key_custom_bind_tips", getIntent().getStringExtra("key_custom_bind_tips"));
        C46332s.cNC();
        if (C46332s.cND().cQl()) {
            C4990ab.m7416i("MicroMsg.WalletBindUI", "user status invalid");
            if (i == 4) {
                mo39970a(new C35475y(null, 20), true, false);
                AppMethodBeat.m2505o(45806);
                return;
            }
            mo39970a(new C35475y(null, 12), true, false);
            AppMethodBeat.m2505o(45806);
            return;
        }
        C46332s.cNC();
        if (C46332s.cND().cQg()) {
            C4990ab.m7416i("MicroMsg.WalletBindUI", "user status reg");
            this.tmf = true;
            this.pGr.cIg = this.tmh;
            bundle.putInt("key_bind_scene", this.pGr.cIg);
            if (!C5046bo.isNullOrNil(this.token)) {
                bundle.putString("kreq_token", this.token);
            }
            C24143a.m37106a((Activity) this, C29615b.class, bundle, null);
            AppMethodBeat.m2505o(45806);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletBindUI", "user status unreg");
        this.tmf = true;
        if (this.tmh >= 0) {
            this.pGr.cIg = this.tmh;
        } else {
            this.pGr.cIg = 1;
        }
        bundle.putInt("key_bind_scene", this.pGr.cIg);
        C24143a.m37106a((Activity) this, C29615b.class, bundle, null);
        AppMethodBeat.m2505o(45806);
    }

    private void cNy() {
        int i = 0;
        AppMethodBeat.m2504i(45807);
        C46332s.cNC();
        if (C46332s.cND().cQl()) {
            mo39970a(new C35475y(null, 12), true, false);
            AppMethodBeat.m2505o(45807);
            return;
        }
        String str = getIntent().getStringExtra("packageExt");
        String[] split = str.split("&");
        if (!C5046bo.isNullOrNil(str) && split.length >= 2) {
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
            if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2))) {
                C46332s.cNC();
                if (C46332s.cND().acC(str2)) {
                    Bundle bundle = new Bundle();
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bankName = str;
                    bankcard.field_bankcardType = str2;
                    bundle.putParcelable("key_bankcard", bankcard);
                    bundle.putString("key_bank_type", bankcard.field_bankcardType);
                    C24143a.m37107a((Activity) this, "WXCreditOpenProcess", bundle, null);
                    AppMethodBeat.m2505o(45807);
                    return;
                }
            }
        }
        finish();
        AppMethodBeat.m2505o(45807);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45808);
        if (this.tmf) {
            finish();
        }
        super.onResume();
        this.onl.onResume();
        AppMethodBeat.m2505o(45808);
    }

    public void onPause() {
        AppMethodBeat.m2504i(45809);
        super.onPause();
        this.onl.onPause();
        AppMethodBeat.m2505o(45809);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45810);
        mo39993ng(580);
        C4879a.xxA.mo10053d(this.tmk);
        super.onDestroy();
        AppMethodBeat.m2505o(45810);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45811);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.onl.bNo();
                AppMethodBeat.m2505o(45811);
                return;
            }
            this.onl.cancel();
            finish();
        }
        AppMethodBeat.m2505o(45811);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45812);
        if (c1207m instanceof C22520c) {
            this.tmf = true;
        }
        if (i != 0 || i2 != 0) {
            m6699JN(str);
            AppMethodBeat.m2505o(45812);
            return true;
        } else if (c1207m instanceof C35475y) {
            if (this.tmh == 6) {
                cNy();
            } else {
                cNx();
            }
            AppMethodBeat.m2505o(45812);
            return true;
        } else if (c1207m instanceof C22520c) {
            C22520c c22520c = (C22520c) c1207m;
            Bundle bundle = this.mBundle;
            bundle.putBoolean("key_is_import_bind", true);
            if (c22520c.tgB == null || c22520c.tgB.size() <= 0) {
                if (C5046bo.isNullOrNil(str)) {
                    str = getString(C25738R.string.f_w);
                }
                C30379h.m48448a((Context) this, str, null, false, new C43546());
            } else {
                Bankcard bankcard = (Bankcard) c22520c.tgB.get(0);
                if (bankcard.txb) {
                    C30379h.m48433a((Context) this, (int) C25738R.string.fbo, 0, false, new C43585());
                } else {
                    bundle.putBoolean("key_need_bind_response", true);
                    bundle.putString("kreq_token", c22520c.token);
                    bundle.putString("key_bank_username", c22520c.tli);
                    bundle.putString("key_recommand_desc", c22520c.tlj);
                    bundle.putParcelable("key_import_bankcard", bankcard);
                    this.tmf = true;
                    bundle.putInt("key_bind_scene", 2);
                    C24143a.m37106a((Activity) this, C29615b.class, bundle, new C43534());
                }
            }
            AppMethodBeat.m2505o(45812);
            return true;
        } else {
            if (c1207m instanceof C22558a) {
                if (this.tmi == null || !this.tmi.equals(c1207m)) {
                    C36379x.dNV();
                } else {
                    C46512f.akr(((C22558a) c1207m).cOS());
                    this.token = ((C22558a) c1207m).getToken();
                    m6698He(4);
                    AppMethodBeat.m2505o(45812);
                    return true;
                }
            }
            AppMethodBeat.m2505o(45812);
            return false;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(45813);
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("key_is_jump", this.tmf);
        AppMethodBeat.m2505o(45813);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(45814);
        super.onRestoreInstanceState(bundle);
        this.tmf = bundle.getBoolean("key_is_jump", false);
        AppMethodBeat.m2505o(45814);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean bNf() {
        return false;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(45815);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.WalletBindUI", "onNewIntent intent null");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(45815);
            return;
        }
        super.onNewIntent(intent);
        C4990ab.m7418v("MicroMsg.WalletBindUI", "onNewIntent");
        setIntent(intent);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            C4990ab.m7416i("MicroMsg.WalletBindUI", "pay cancel");
            setResult(0);
        } else {
            C4990ab.m7410d("MicroMsg.WalletBindUI", "pay done... errCode:" + intent.getBooleanExtra("intent_bind_end", false));
            setResult(-1, getIntent());
        }
        finish();
        AppMethodBeat.m2505o(45815);
    }

    /* renamed from: JN */
    private void m6699JN(String str) {
        AppMethodBeat.m2504i(45816);
        if (C5046bo.isNullOrNil(str)) {
            str = getString(C25738R.string.fu2);
        }
        C30379h.m48448a((Context) this, str, null, false, new C43607());
        AppMethodBeat.m2505o(45816);
    }

    public final int getForceOrientation() {
        return 1;
    }
}
