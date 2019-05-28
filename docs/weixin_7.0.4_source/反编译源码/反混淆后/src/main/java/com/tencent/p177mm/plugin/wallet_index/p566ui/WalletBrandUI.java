package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C32653uw;
import com.tencent.p177mm.p230g.p231a.C37805ul;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_index.p564c.C14343c;
import com.tencent.p177mm.plugin.wallet_index.p564c.C14344d;
import com.tencent.p177mm.plugin.wallet_index.p564c.C35524a;
import com.tencent.p177mm.plugin.wallet_index.p564c.C40151j;
import com.tencent.p177mm.plugin.wallet_index.p564c.C4484e;
import com.tencent.p177mm.plugin.wallet_index.p564c.C46378i;
import com.tencent.p177mm.plugin.wallet_index.p564c.p1661b.C46376a;
import com.tencent.p177mm.plugin.wallet_index.p564c.p565a.C4483a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.csj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI */
public class WalletBrandUI extends MMActivity implements C1202f {
    private String appId;
    private String cIe;
    private int cQO;
    private Dialog gII = null;
    private boolean tRO = false;
    private C4485b tRP;
    private String tRQ;
    private C1207m tRR = null;
    private C4884c tRS = new C463792();
    private C4884c tRT = new C143553();

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$b */
    interface C4485b {
        int cSY();

        C1207m cSZ();

        String cTa();

        void onSceneEnd(int i, int i2, String str, C1207m c1207m);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$a */
    public class C7193a implements C4485b {
        private int tRV = 0;
        private String tos = "";

        /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$a$1 */
        class C71941 implements OnClickListener {
            C71941() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48249);
                WalletBrandUI.this.setResult(0);
                WalletBrandUI.this.finish();
                AppMethodBeat.m2505o(48249);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$a$2 */
        class C71952 implements OnClickListener {
            C71952() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48250);
                WalletBrandUI.this.setResult(0);
                WalletBrandUI.this.finish();
                AppMethodBeat.m2505o(48250);
            }
        }

        public final int cSY() {
            return 1563;
        }

        public final C1207m cSZ() {
            AppMethodBeat.m2504i(48251);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            this.tRV = WalletBrandUI.this.getIntent().getIntExtra("result_jump_mode", 0);
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            C1207m c4483a = new C4483a(WalletBrandUI.this.appId, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c4483a, 0);
            AppMethodBeat.m2505o(48251);
            return c4483a;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48252);
            if (i == 0 && i2 == 0 && (c1207m instanceof C4483a)) {
                String str2 = ((C4483a) c1207m).jumpUrl;
                C4990ab.m7417i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", str2);
                this.tos = str2;
                String str3 = ((C4483a) c1207m).tRo;
                Intent intent;
                if (this.tRV == 1) {
                    intent = new Intent();
                    intent.putExtra("url", str2);
                    intent.putExtra("jsInjectCode", str3);
                    WalletBrandUI.this.setResult(-1, intent);
                } else {
                    intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    if (!C5046bo.isNullOrNil(str3)) {
                        intent.putExtra("shouldForceViewPort", true);
                        intent.putExtra("view_port_code", str3);
                    }
                    C25985d.m41467b(WalletBrandUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    WalletBrandUI.this.setResult(-1);
                }
                WalletBrandUI.this.finish();
                AppMethodBeat.m2505o(48252);
                return;
            }
            C4990ab.m7417i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            C30379h.m48440a(WalletBrandUI.this, str, "", new C71941(), new C71952());
            AppMethodBeat.m2505o(48252);
        }

        public final String cTa() {
            return this.tos;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$3 */
    class C143553 extends C4884c<C37805ul> {
        C143553() {
            AppMethodBeat.m2504i(48247);
            this.xxI = C37805ul.class.getName().hashCode();
            AppMethodBeat.m2505o(48247);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48248);
            if (WalletBrandUI.this.gII != null) {
                WalletBrandUI.this.gII.dismiss();
                WalletBrandUI.this.gII = null;
            }
            AppMethodBeat.m2505o(48248);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$c */
    class C35526c implements C4485b {
        private String tos = "";

        C35526c() {
        }

        public final C1207m cSZ() {
            AppMethodBeat.m2504i(48253);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            C1207m c46376a = new C46376a(WalletBrandUI.this.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c46376a, 0);
            AppMethodBeat.m2505o(48253);
            return c46376a;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48254);
            C46376a c46376a = (C46376a) c1207m;
            String str2 = c46376a.tRa;
            C4990ab.m7410d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
            this.tos = str2;
            PayInfo payInfo = new PayInfo();
            payInfo.czZ = str2;
            payInfo.appId = WalletBrandUI.this.appId;
            payInfo.tRb = c46376a.tRb;
            payInfo.cIf = WalletBrandUI.this.cQO;
            payInfo.aIm = str;
            payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0);
            C35899h.m58853a(WalletBrandUI.this, payInfo, 1);
            AppMethodBeat.m2505o(48254);
        }

        public final int cSY() {
            return 1521;
        }

        public final String cTa() {
            return this.tos;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$d */
    class C35527d implements C4485b {
        private String tos = "";

        C35527d() {
        }

        public final C1207m cSZ() {
            C1207m c40151j;
            AppMethodBeat.m2504i(48255);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            int intExtra = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0);
            int intExtra2 = WalletBrandUI.this.getIntent().getIntExtra("key_wx_app_scene", 0);
            String stringExtra7 = WalletBrandUI.this.getIntent().getStringExtra("cookie");
            String f = WalletBrandUI.this.appId;
            String g = WalletBrandUI.this.cIe;
            int h = WalletBrandUI.this.cQO;
            if (C35524a.m58302gO(stringExtra4, "up_")) {
                c40151j = new C40151j(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else if (C35524a.m58302gO(stringExtra4, "tax_")) {
                c40151j = new C46378i(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else if (C35524a.m58302gO(stringExtra4, "dc_")) {
                c40151j = new C14343c(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else {
                c40151j = new C4484e(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            }
            c40151j.hbj = System.currentTimeMillis();
            c40151j.eHT = "PayProcess";
            c40151j.gOW = WalletBrandUI.this.cQO;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c40151j, 0);
            AppMethodBeat.m2505o(48255);
            return c40151j;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48256);
            Intent intent;
            if (i == 0 && i2 == 0) {
                C4484e c4484e = (C4484e) c1207m;
                String str2 = c4484e.tRa;
                C4990ab.m7410d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                this.tos = str2;
                C4879a.xxA.mo10055m(new C37805ul());
                csj csj = ((C4484e) c1207m).tRc;
                if (csj == null || C5046bo.isNullOrNil(csj.xpI)) {
                    PayInfo payInfo = new PayInfo();
                    payInfo.czZ = str2;
                    payInfo.appId = WalletBrandUI.this.appId;
                    payInfo.tRb = c4484e.tRb;
                    payInfo.cIf = WalletBrandUI.this.cQO;
                    payInfo.aIm = str;
                    payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0);
                    payInfo.vwj = c4484e.hbj;
                    if (payInfo.vwh == null) {
                        payInfo.vwh = new Bundle();
                    }
                    payInfo.vwh.putString("extinfo_key_20", ((C4484e) c1207m).tRd);
                    payInfo.vwh.putString("extinfo_key_21", WalletBrandUI.this.getIntent().getStringExtra("intent_app_brand_from_path"));
                    payInfo.vwh.putString("extinfo_key_22", WalletBrandUI.this.getIntent().getStringExtra("intent_app_brand_from_username"));
                    C44422ad.m80307o(payInfo.cIf, str2, i2);
                    C35899h.m58853a(WalletBrandUI.this, payInfo, 1);
                    AppMethodBeat.m2505o(48256);
                    return;
                }
                intent = new Intent();
                intent.putExtra("prepayId", str2);
                intent.putExtra("is_jsapi_offline_pay", false);
                intent.putExtra("pay_gate_url", csj.xpI);
                intent.putExtra("need_dialog", csj.xpK);
                intent.putExtra("dialog_text", csj.xpL);
                intent.putExtra("max_count", csj.xpJ.vRG);
                intent.putExtra("inteval_time", csj.xpJ.vRF);
                intent.putExtra("default_wording", csj.xpJ.vRH);
                C25985d.m41472c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                AppMethodBeat.m2505o(48256);
                return;
            }
            C44422ad.m80307o(WalletBrandUI.this.cQO, "", i2);
            intent = new Intent();
            if (i != 0) {
                i2 = -1;
            }
            intent.putExtra("key_jsapi_pay_err_code", i2);
            String str3 = "key_jsapi_pay_err_msg";
            if (C5046bo.isNullOrNil(str)) {
                str = WalletBrandUI.this.getString(C25738R.string.fk3);
            }
            intent.putExtra(str3, str);
            WalletBrandUI.this.setResult(5, intent);
            WalletBrandUI.this.finish();
            AppMethodBeat.m2505o(48256);
        }

        public final int cSY() {
            AppMethodBeat.m2504i(48257);
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            if (C35524a.m58302gO(stringExtra, "up_")) {
                AppMethodBeat.m2505o(48257);
                return 2519;
            } else if (C35524a.m58302gO(stringExtra, "tax_")) {
                AppMethodBeat.m2505o(48257);
                return 2923;
            } else if (C35524a.m58302gO(stringExtra, "dc_")) {
                AppMethodBeat.m2505o(48257);
                return 2798;
            } else {
                AppMethodBeat.m2505o(48257);
                return 398;
            }
        }

        public final String cTa() {
            return this.tos;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$1 */
    class C401521 implements OnCancelListener {
        C401521() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(48244);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(WalletBrandUI.this.tRR);
            WalletBrandUI.this.finish();
            AppMethodBeat.m2505o(48244);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$e */
    class C40153e implements C4485b {
        private String tos = "";

        C40153e() {
        }

        public final int cSY() {
            return 2755;
        }

        public final C1207m cSZ() {
            AppMethodBeat.m2504i(48258);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            String stringExtra7 = WalletBrandUI.this.getIntent().getStringExtra("ext_info");
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            C1207m c14344d = new C14344d(WalletBrandUI.this.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.this.cQO, stringExtra7);
            c14344d.hbj = System.currentTimeMillis();
            c14344d.eHT = "PayProcess";
            c14344d.gOW = WalletBrandUI.this.cQO;
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c14344d, 0);
            AppMethodBeat.m2505o(48258);
            return c14344d;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48259);
            if (i == 0 && i2 == 0) {
                C14344d c14344d = (C14344d) c1207m;
                String str2 = c14344d.tRa;
                this.tos = str2;
                C4990ab.m7410d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = str2;
                payInfo.appId = WalletBrandUI.this.appId;
                payInfo.tRb = c14344d.tRb;
                payInfo.cIf = WalletBrandUI.this.cQO;
                payInfo.aIm = str;
                payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 16);
                payInfo.vwj = c14344d.hbj;
                C44422ad.m80307o(payInfo.cIf, str2, i2);
                C35899h.m58853a(WalletBrandUI.this, payInfo, 1);
                AppMethodBeat.m2505o(48259);
                return;
            }
            WalletBrandUI.this.finish();
            AppMethodBeat.m2505o(48259);
        }

        public final String cTa() {
            return this.tos;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI$2 */
    class C463792 extends C4884c<C32652uv> {
        C463792() {
            AppMethodBeat.m2504i(48245);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(48245);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48246);
            C32652uv c32652uv = (C32652uv) c4883b;
            C4990ab.m7417i("MicroMsg.WalletBrandUI", "onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s", Integer.valueOf(c32652uv.cRF.result), c32652uv.cRF.czZ, Integer.valueOf(c32652uv.cRF.cRH));
            if (WalletBrandUI.this.tRP.cSY() != 398) {
                WalletBrandUI.this.setResult(c32652uv.cRF.result, c32652uv.cRF.intent);
                WalletBrandUI.this.finish();
                AppMethodBeat.m2505o(48246);
            } else if (c32652uv.cRF == null || C5046bo.isNullOrNil(c32652uv.cRF.czZ) || !c32652uv.cRF.czZ.equalsIgnoreCase(WalletBrandUI.this.tRP.cTa()) || c32652uv.cRF.cRH != 1) {
                C4990ab.m7417i("MicroMsg.WalletBrandUI", "FuncId %d,is not current request key || comeFrom:%s is not FINISH", Integer.valueOf(WalletBrandUI.this.tRP.cSY()), Integer.valueOf(c32652uv.cRF.cRH));
                AppMethodBeat.m2505o(48246);
            } else {
                if (C5046bo.isNullOrNil(WalletBrandUI.this.tRQ) || !WalletBrandUI.this.tRQ.equalsIgnoreCase("key_from_scene_appbrandgame")) {
                    WalletBrandUI.this.setResult(c32652uv.cRF.result, c32652uv.cRF.intent);
                    WalletBrandUI.this.finish();
                } else {
                    WalletBrandUI.m87198i(c32652uv.cRF.result, c32652uv.cRF.intent);
                }
                AppMethodBeat.m2505o(48246);
            }
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBrandUI() {
        AppMethodBeat.m2504i(48260);
        AppMethodBeat.m2505o(48260);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48261);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(C8415j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        this.cQO = getIntent().getIntExtra("pay_scene", 3);
        this.tRQ = getIntent().getStringExtra("intent_app_brand_from_scene");
        C36381z.dNW();
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is ".concat(String.valueOf(intExtra)));
        if (C1853r.m3831YM()) {
            C4990ab.m7416i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.tRP = new C35526c();
        } else if (intExtra == 2) {
            C4990ab.m7416i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.tRP = new C7193a();
        } else if (intExtra == 3) {
            C4990ab.m7416i("MicroMsg.WalletBrandUI", "do pay with mall");
            this.tRP = new C40153e();
        } else {
            C4990ab.m7416i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.tRP = new C35527d();
        }
        C4879a.xxA.mo10052c(this.tRS);
        C4879a.xxA.mo10052c(this.tRT);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(this.tRP.cSY(), (C1202f) this);
        AppMethodBeat.m2505o(48261);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48262);
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onDestroy");
        super.onDestroy();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(this.tRP.cSY(), (C1202f) this);
        C4879a.xxA.mo10053d(this.tRS);
        C4879a.xxA.mo10053d(this.tRT);
        AppMethodBeat.m2505o(48262);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(48263);
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(48263);
    }

    public void onResume() {
        AppMethodBeat.m2504i(48264);
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        C4990ab.m7417i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", Boolean.valueOf(this.tRO), Integer.valueOf(getTaskId()), getCallingActivity());
        if (!this.tRO) {
            this.tRO = true;
            this.tRR = this.tRP.cSZ();
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            this.gII = C30901g.m49320g(this, new C401521());
        }
        AppMethodBeat.m2505o(48264);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(48265);
        if (i == 4) {
            finish();
            AppMethodBeat.m2505o(48265);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(48265);
        return onKeyDown;
    }

    public void onStart() {
        AppMethodBeat.m2504i(48266);
        super.onStart();
        AppMethodBeat.m2505o(48266);
    }

    public void onStop() {
        AppMethodBeat.m2504i(48267);
        super.onStop();
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(48267);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48268);
        C4990ab.m7417i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m, this.tRR);
        if (c1207m.getType() == this.tRP.cSY() && c1207m == this.tRR) {
            this.tRP.onSceneEnd(i, i2, str, c1207m);
            AppMethodBeat.m2505o(48268);
            return;
        }
        AppMethodBeat.m2505o(48268);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48269);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    C4990ab.m7416i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
        AppMethodBeat.m2505o(48269);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: i */
    static /* synthetic */ void m87198i(int i, Intent intent) {
        AppMethodBeat.m2504i(48270);
        C32653uw c32653uw = new C32653uw();
        c32653uw.cRI.intent = intent;
        c32653uw.cRI.cRH = 1;
        c32653uw.cRI.czZ = "key_from_scene_appbrandgame";
        c32653uw.cRI.result = i;
        C4879a.xxA.mo10055m(c32653uw);
        AppMethodBeat.m2505o(48270);
    }
}
