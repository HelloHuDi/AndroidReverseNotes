package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p230g.p231a.C32653uw;
import com.tencent.p177mm.p230g.p231a.C37805ul;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C22688c;
import com.tencent.p177mm.plugin.wallet_index.p564c.C14345f;
import com.tencent.p177mm.plugin.wallet_index.p564c.C29692l;
import com.tencent.p177mm.plugin.wallet_index.p564c.C35525b;
import com.tencent.p177mm.protocal.protobuf.auh;
import com.tencent.p177mm.protocal.protobuf.aui;
import com.tencent.p177mm.protocal.protobuf.blm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C16079t;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C46721s;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.wxmm.v2helper;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI */
public class WalletIapUI extends MMActivity implements C1202f {
    private final int DEFAULT = 1003;
    /* renamed from: OK */
    private final int f15071OK = 1000;
    private int currentState = 1003;
    private int czV = 0;
    private Dialog iMU;
    private C4884c piM = new C226904();
    private C4884c tRS = new C355281();
    private final int tRX = 4;
    private final int tRY = 0;
    private final int tRZ = 1;
    private C14357c tRr;
    private C4487d tRt = new C296933();
    private final int tSa = 2;
    private final int tSb = 3;
    private final int tSc = 1001;
    private final int tSd = 1002;
    private boolean tSe = false;
    private int tSf = 0;
    private boolean tSg;
    private String tSh = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private C4486b tSi;
    private C4487d tSj = new C226892();

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI$2 */
    class C226892 implements C4487d {
        C226892() {
        }

        /* renamed from: a */
        public final void mo9553a(C35525b c35525b, C22688c c22688c) {
            AppMethodBeat.m2504i(48273);
            C4990ab.m7416i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + c35525b + ", purchase: " + c22688c);
            if (WalletIapUI.this.tSi instanceof C35529a) {
                if (c22688c != null) {
                    C36381z.m59953d(c22688c.tQS, c22688c.kWz, c22688c.tQY, c35525b.nqa, c35525b.nqb);
                } else {
                    C35529a c35529a = (C35529a) WalletIapUI.this.tSi;
                    C36381z.m59953d(c35529a.tRw, c35529a.kWz, c35529a.tQY, c35525b.nqa, c35525b.nqb);
                }
            }
            Intent intent;
            if (c35525b.cSV()) {
                C4990ab.m7416i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + c35525b.nqa + " , errMsg: " + c35525b.nqb);
                if (c35525b.nqa == 1) {
                    WalletIapUI.this.currentState = 1001;
                } else {
                    WalletIapUI.this.currentState = 1002;
                }
                intent = new Intent();
                intent.putExtra("key_err_code", c35525b.nqa);
                intent.putExtra("key_err_msg", c35525b.nqb);
                intent.putExtra("key_launch_ts", C35529a.tRs);
                intent.putExtra("key_gw_error_code", c35525b.tQZ);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.m2505o(48273);
            } else if (c35525b.cSU()) {
                WalletIapUI.this.tSf = 3;
                C4990ab.m7416i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                WalletIapUI.this.tSi.mo9550b(WalletIapUI.this, false);
                AppMethodBeat.m2505o(48273);
            } else if (c22688c != null) {
                C4990ab.m7416i("MicroMsg.WalletIapUI", "verify purchase! productId:" + c22688c.kWz + ",billNo:" + c22688c.tQV);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(WalletIapUI.this.tRr.mo26627a(c22688c, false), 0);
                WalletIapUI.this.tSf = 2;
                WalletIapUI.m58311e(WalletIapUI.this);
                AppMethodBeat.m2505o(48273);
            } else {
                WalletIapUI.this.currentState = 1002;
                intent = new Intent();
                C35525b bu = C35525b.m58303bu(6, "");
                intent.putExtra("key_err_code", bu.nqa);
                intent.putExtra("key_err_msg", bu.nqb);
                intent.putExtra("key_launch_ts", C35529a.tRs);
                intent.putExtra("key_gw_error_code", bu.tQZ);
                WalletIapUI.this.setResult(-1, intent);
                WalletIapUI.this.finish();
                AppMethodBeat.m2505o(48273);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI$4 */
    class C226904 extends C4884c<C37805ul> {
        C226904() {
            AppMethodBeat.m2504i(48275);
            this.xxI = C37805ul.class.getName().hashCode();
            AppMethodBeat.m2505o(48275);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48276);
            C37805ul c37805ul = (C37805ul) c4883b;
            C4990ab.m7416i("MicroMsg.WalletIapUI", "payListener callback to close progress");
            if (c37805ul instanceof C37805ul) {
                WalletIapUI.m58312f(WalletIapUI.this);
                AppMethodBeat.m2505o(48276);
                return true;
            }
            C4990ab.m7414f("MicroMsg.WalletIapUI", "mismatched event");
            AppMethodBeat.m2505o(48276);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI$5 */
    class C226915 implements OnCancelListener {
        C226915() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            C35525b bu;
            AppMethodBeat.m2504i(48277);
            C4990ab.m7417i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", Integer.valueOf(WalletIapUI.this.tSf));
            if (WalletIapUI.this.tSf == 2) {
                bu = C35525b.m58303bu(7, "");
            } else {
                bu = C35525b.m58303bu(1, "");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", bu.nqa);
            intent.putExtra("key_err_msg", bu.nqb);
            WalletIapUI.this.setResult(-1, intent);
            WalletIapUI.this.finish();
            AppMethodBeat.m2505o(48277);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI$3 */
    class C296933 implements C4487d {
        C296933() {
        }

        /* renamed from: a */
        public final void mo9553a(C35525b c35525b, C22688c c22688c) {
            AppMethodBeat.m2504i(48274);
            C4990ab.m7410d("MicroMsg.WalletIapUI", "Consume finished: " + c35525b + ", purchase: " + c22688c);
            if (c35525b.cSV()) {
                WalletIapUI.this.currentState = 1002;
                C4990ab.m7410d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
            } else {
                WalletIapUI.this.currentState = 1000;
                C4990ab.m7410d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
            }
            Intent intent = new Intent();
            intent.putExtra("key_err_code", c35525b.nqa);
            intent.putExtra("key_err_msg", c35525b.nqb);
            intent.putStringArrayListExtra("key_response_product_ids", WalletIapUI.this.tRr.tRz);
            intent.putStringArrayListExtra("key_response_series_ids", WalletIapUI.this.tRr.tRA);
            intent.putExtra("key_launch_ts", C35529a.tRs);
            WalletIapUI.this.setResult(-1, intent);
            WalletIapUI.this.finish();
            AppMethodBeat.m2505o(48274);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletIapUI$1 */
    class C355281 extends C4884c<C32653uw> {
        C355281() {
            AppMethodBeat.m2504i(48271);
            this.xxI = C32653uw.class.getName().hashCode();
            AppMethodBeat.m2505o(48271);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48272);
            C32653uw c32653uw = (C32653uw) c4883b;
            C4990ab.m7417i("MicroMsg.WalletIapUI", "walletPayResultListener onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s", Integer.valueOf(c32653uw.cRI.result), c32653uw.cRI.czZ, Integer.valueOf(c32653uw.cRI.cRH));
            if (c32653uw.cRI == null || C5046bo.isNullOrNil(c32653uw.cRI.czZ) || !c32653uw.cRI.czZ.equalsIgnoreCase("key_from_scene_appbrandgame") || c32653uw.cRI.cRH != 1) {
                C4990ab.m7417i("MicroMsg.WalletIapUI", "FuncId %s,is not current request key || comeFrom:%s is not FINISH", "key_from_scene_appbrandgame", Integer.valueOf(c32653uw.cRI.cRH));
                AppMethodBeat.m2505o(48272);
            } else {
                if (c32653uw.cRI.intent == null || c32653uw.cRI.intent.getExtras() == null || c32653uw.cRI.intent.getExtras().get("key_total_fee") == null) {
                    C4990ab.m7416i("MicroMsg.WalletIapUI", "no payAmount");
                } else {
                    WalletIapUI.this.tSh = c32653uw.cRI.intent.getExtras().get("key_total_fee").toString();
                    C4990ab.m7417i("MicroMsg.WalletIapUI", "has payAmount:%s", WalletIapUI.this.tSh);
                }
                if (WalletIapUI.this.tSi != null) {
                    WalletIapUI.this.tSi.mo9549a(WalletIapUI.this, WalletIapUI.this.czV, c32653uw.cRI.result, c32653uw.cRI.intent);
                    C4990ab.m7410d("MicroMsg.WalletIapUI", "walletPayResultListener handled by mWalletPay.");
                } else {
                    C4990ab.m7412e("MicroMsg.WalletIapUI", "havn't handle user action");
                    Intent intent = new Intent();
                    C35525b bu = C35525b.m58303bu(6, "");
                    intent.putExtra("key_err_code", bu.nqa);
                    intent.putExtra("key_err_msg", bu.nqb);
                    intent.putExtra("key_launch_ts", C35529a.tRs);
                    WalletIapUI.this.setResult(-1, intent);
                    WalletIapUI.this.finish();
                }
                AppMethodBeat.m2505o(48272);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletIapUI() {
        AppMethodBeat.m2504i(48278);
        AppMethodBeat.m2505o(48278);
    }

    /* renamed from: e */
    static /* synthetic */ void m58311e(WalletIapUI walletIapUI) {
        AppMethodBeat.m2504i(48288);
        walletIapUI.aoW();
        AppMethodBeat.m2505o(48288);
    }

    /* renamed from: f */
    static /* synthetic */ void m58312f(WalletIapUI walletIapUI) {
        AppMethodBeat.m2504i(48289);
        walletIapUI.aoX();
        AppMethodBeat.m2505o(48289);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48279);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onCreate");
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodOutputVolumeGainEnable, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(414, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1130, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1306, (C1202f) this);
        if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
            aoW();
        }
        this.tSg = getIntent().getBooleanExtra("key_is_mini_program", false);
        this.tRr = new C14357c();
        this.tRr.tRE = this.tSg;
        if (getIntent().getBooleanExtra("key_force_google", false) || C1853r.m3830YL()) {
            C4990ab.m7410d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
            this.tSi = new C35529a(this, this.tRr, this.tRt);
        } else {
            C4990ab.m7410d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
            this.tSi = new C46380f(this.tRr, this.piM);
        }
        this.tRr.peo = this.tSi.cSW();
        C4879a.xxA.mo10052c(this.tRS);
        AppMethodBeat.m2505o(48279);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(48280);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onResume");
        super.onResume();
        C4990ab.m7416i("MicroMsg.WalletIapUI", "Handler jump");
        if (!this.tSe) {
            this.tSe = true;
            Intent intent = getIntent();
            if (intent.getIntExtra("key_action_type", 200001) == 200002) {
                C4990ab.m7416i("MicroMsg.WalletIapUI", "start to restore the purchase!");
                this.tSf = 3;
                this.tSi.mo9550b(this, true);
                AppMethodBeat.m2505o(48280);
                return;
            }
            C1207m c14345f;
            C14357c c14357c = this.tRr;
            String stringExtra = intent.getStringExtra("key_product_id");
            c14357c.kWz = stringExtra;
            c14357c.tRD.add(stringExtra);
            C4990ab.m7410d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(stringExtra)));
            this.tRr.tQY = intent.getStringExtra("key_price");
            this.tRr.tQX = intent.getStringExtra("key_currency_type");
            String stringExtra2 = intent.getStringExtra("key_ext_info");
            this.tRr.mCount = intent.getIntExtra("key_count", 1);
            stringExtra = intent.getStringExtra("key_appid");
            String stringExtra3 = intent.getStringExtra("key_desc");
            String stringExtra4 = intent.getStringExtra("key_busiid");
            this.tRr.tRF = intent.getStringExtra("key_virtual_pay_sign");
            this.tRr.tRG = intent.getStringExtra("key_attach");
            C1720g.m3537RQ();
            C6300p c6300p = C1720g.m3535RO().eJo;
            C14357c c14357c2 = this.tRr;
            int cSW = this.tSi.cSW();
            if (c14357c2.tRE) {
                c14345f = new C14345f(cSW, stringExtra, c14357c2.tQY, stringExtra3, c14357c2.mCount, c14357c2.tQX, stringExtra4, c14357c2.tRF, c14357c2.tRG);
            } else {
                c14345f = new C46721s(c14357c2.kWz, c14357c2.tQY, c14357c2.tQX, c14357c2.mCount, cSW, stringExtra2);
            }
            c6300p.mo14541a(c14345f, 0);
        }
        AppMethodBeat.m2505o(48280);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(48281);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(48281);
    }

    public void onDestroy() {
        int i;
        AppMethodBeat.m2504i(48282);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onDestroy");
        aoX();
        if (this.currentState == 1003) {
            this.currentState = 1001;
        }
        String str = "";
        if (getIntent() != null) {
            str = getIntent().getStringExtra("key_appid");
        }
        if (this.tSi instanceof C46380f) {
            i = 0;
        } else {
            i = 1;
        }
        C4990ab.m7417i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", Integer.valueOf(15751), Boolean.valueOf(this.tSg), str, Integer.valueOf(i), Integer.valueOf(this.tSf), Integer.valueOf(this.currentState), this.tSh, Long.valueOf((long) (C5046bo.getDouble(this.tSh, 0.0d) * 100.0d)));
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.tSg ? 0 : 1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.tSf);
        objArr[4] = Integer.valueOf(this.currentState);
        objArr[5] = this.tSh;
        objArr[6] = Long.valueOf(r4);
        c7060h.mo8381e(15751, objArr);
        C7060h.pYm.mo8378a(1044, (long) (this.currentState - 1000), 1, false);
        if (this.currentState == 1001) {
            C7060h.pYm.mo8378a(1044, (long) (this.tSf + 4), 1, false);
        } else if (this.currentState == 1002) {
            C7060h.pYm.mo8378a(1044, (long) (this.tSf + 8), 1, false);
        }
        if (this.tSi != null) {
            this.tSi.mo9552l(this);
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodOutputVolumeGainEnable, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(414, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1130, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1306, (C1202f) this);
        C4879a.xxA.mo10053d(this.tRS);
        super.onDestroy();
        AppMethodBeat.m2505o(48282);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48283);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(i2)));
        if (intent == null || intent.getExtras() == null || intent.getExtras().get("key_total_fee") == null) {
            C4990ab.m7416i("MicroMsg.WalletIapUI", "no payAmount");
        } else {
            this.tSh = intent.getExtras().get("key_total_fee").toString();
            C4990ab.m7417i("MicroMsg.WalletIapUI", "has payAmount:%s", this.tSh);
        }
        if (this.tSi != null) {
            this.tSi.mo9549a((MMActivity) this, i, i2, intent);
            C4990ab.m7410d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
            AppMethodBeat.m2505o(48283);
            return;
        }
        C4990ab.m7412e("MicroMsg.WalletIapUI", "havn't handle user action");
        Intent intent2 = new Intent();
        C35525b bu = C35525b.m58303bu(6, "");
        intent2.putExtra("key_err_code", bu.nqa);
        intent2.putExtra("key_err_msg", bu.nqb);
        intent2.putExtra("key_launch_ts", C35529a.tRs);
        setResult(-1, intent2);
        finish();
        AppMethodBeat.m2505o(48283);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0202  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(48284);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "onSceneEnd type:" + c1207m.getType() + " errCode:" + i2 + ",errMsg:" + str);
        C35525b bu = C35525b.m58303bu(i2, str);
        int i3 = bu.nqa;
        String str2 = bu.nqb;
        int type = c1207m.getType();
        C14357c c14357c;
        Intent intent;
        switch (type) {
            case 414:
            case 1306:
                boolean z2;
                c14357c = this.tRr;
                if (c1207m instanceof C16079t) {
                    C16079t c16079t = (C16079t) c1207m;
                    c14357c.kWz = c16079t.kWz;
                    c14357c.tRB = c16079t.kWB;
                    c14357c.tRC = c16079t.tRC;
                    z2 = c16079t.errCode == 0;
                } else if (c1207m instanceof C29692l) {
                    C29692l c29692l = (C29692l) c1207m;
                    c14357c.kWz = c29692l.cwg;
                    z2 = c29692l.errCode == 0;
                } else {
                    z2 = false;
                }
                c14357c.tRD.remove(c14357c.kWz);
                if (z2) {
                    C4990ab.m7416i("MicroMsg.IapData", "Verify " + c14357c.kWz + " OK");
                    c14357c.tRz.add(c14357c.kWz);
                    c14357c.tRA.add(c14357c.tRB);
                } else if (!c14357c.kWz.startsWith("com.tencent.xin.wco")) {
                    C4990ab.m7416i("MicroMsg.IapData", "Verify " + c14357c.kWz + " fail");
                } else if (c14357c.tRC > 0) {
                    c14357c.tRz.add(c14357c.kWz);
                    c14357c.tRA.add(c14357c.tRB);
                    C4990ab.m7416i("MicroMsg.IapData", "Verify " + c14357c.kWz + " fail and cosume");
                    if (this.tRr.tRD.isEmpty()) {
                        C4990ab.m7410d("MicroMsg.WalletIapUI", "Verify All End... ");
                        if (this.tRr.tRz.isEmpty()) {
                            C4990ab.m7416i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + i3 + " , errMsg: " + str2);
                            this.currentState = 1002;
                            intent = new Intent();
                            intent.putExtra("key_err_code", i3);
                            intent.putExtra("key_err_msg", str2);
                            intent.putExtra("key_response_position", 3);
                            intent.putExtra("key_launch_ts", C35529a.tRs);
                            setResult(-1, intent);
                            finish();
                        } else {
                            C4990ab.m7416i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.tRr.tRz.size() + ", Consume ...");
                            this.tSi.mo9548a((MMActivity) this, this.tRr.tRz, this.tRt, z);
                            AppMethodBeat.m2505o(48284);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(48284);
                    return;
                } else {
                    C4990ab.m7416i("MicroMsg.IapData", "Verify " + c14357c.kWz + " fail");
                }
                z = false;
                if (this.tRr.tRD.isEmpty()) {
                }
                AppMethodBeat.m2505o(48284);
                return;
            case v2helper.EMethodOutputVolumeGainEnable /*422*/:
            case 1130:
                c14357c = this.tRr;
                C35525b bu2 = C35525b.m58303bu(i3, str2);
                type = bu2.nqa;
                if (c1207m instanceof C46721s) {
                    C46721s c46721s = (C46721s) c1207m;
                    if (type == 0) {
                        blm blm;
                        if (c14357c.cSX()) {
                            aui aui;
                            blm = (blm) c46721s.ehh.fsH.fsP;
                            if (blm != null) {
                                aui aui2 = new aui();
                                aui2.wyq = blm.wOw;
                                aui2.wyr = blm.wOx;
                                aui2.cIf = 5;
                                aui2.wys = blm.wOy;
                                C4990ab.m7410d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + blm.wOy);
                                aui = aui2;
                            } else {
                                C4990ab.m7412e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
                                aui = null;
                            }
                            c14357c.tRf = aui;
                        } else {
                            auh auh;
                            blm = (blm) c46721s.ehh.fsH.fsP;
                            if (blm != null) {
                                auh auh2 = new auh();
                                auh2.wma = c46721s.tQX;
                                auh2.pho = c46721s.kWz;
                                auh2.pdz = c46721s.tQY;
                                auh2.wym = blm.wOv;
                                C4990ab.m7410d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + blm.wOv);
                                auh = auh2;
                            } else {
                                C4990ab.m7412e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
                                auh = null;
                            }
                            c14357c.tRe = auh;
                        }
                    }
                } else if (c1207m instanceof C14345f) {
                    C14345f c14345f = (C14345f) c1207m;
                    if (type == 0 && c14345f.errCode == 0) {
                        c14357c.tRf = c14345f.tRf;
                        c14357c.tRe = c14345f.tRe;
                        if (c14357c.cSX()) {
                            if (c14357c.tRf != null) {
                                c14357c.tRw = c14357c.tRf.wym;
                            } else {
                                C4990ab.m7412e("MicroMsg.IapData", "iapWxPayData is null");
                            }
                        } else if (c14357c.tRe != null) {
                            c14357c.tRw = c14357c.tRe.wym;
                        } else {
                            C4990ab.m7412e("MicroMsg.IapData", "iapGoogleData is null");
                        }
                    }
                }
                if (bu2.nqa == 0) {
                    this.czV = this.tSi.mo9547a(this, this.tSj);
                    this.tSf = 1;
                    AppMethodBeat.m2505o(48284);
                    return;
                }
                this.currentState = 1002;
                C4990ab.m7416i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + bu2.nqa + " , errMsg: " + bu2.nqb);
                intent = new Intent();
                intent.putExtra("key_err_code", bu2.nqa);
                intent.putExtra("key_err_msg", bu2.nqb);
                intent.putExtra("key_response_position", 1);
                setResult(-1, intent);
                finish();
                AppMethodBeat.m2505o(48284);
                return;
            default:
                C4990ab.m7420w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(type)));
                AppMethodBeat.m2505o(48284);
                return;
        }
    }

    public void finish() {
        AppMethodBeat.m2504i(48285);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "finish");
        aoX();
        super.finish();
        AppMethodBeat.m2505o(48285);
    }

    private void aoW() {
        AppMethodBeat.m2504i(48286);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "showLoadingDialog!");
        this.iMU = C30901g.m49316a((Context) this, getString(C25738R.string.f9260un), new C226915());
        AppMethodBeat.m2505o(48286);
    }

    private void aoX() {
        AppMethodBeat.m2504i(48287);
        C4990ab.m7416i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
        if (this.iMU != null && this.iMU.isShowing()) {
            this.iMU.dismiss();
            this.iMU = null;
        }
        AppMethodBeat.m2505o(48287);
    }
}
