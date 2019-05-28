package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_index.c.i;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI extends MMActivity implements f {
    private String appId;
    private String cIe;
    private int cQO;
    private Dialog gII = null;
    private boolean tRO = false;
    private b tRP;
    private String tRQ;
    private m tRR = null;
    private com.tencent.mm.sdk.b.c tRS = new com.tencent.mm.sdk.b.c<uv>() {
        {
            AppMethodBeat.i(48245);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(48245);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(48246);
            uv uvVar = (uv) bVar;
            ab.i("MicroMsg.WalletBrandUI", "onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s", Integer.valueOf(uvVar.cRF.result), uvVar.cRF.czZ, Integer.valueOf(uvVar.cRF.cRH));
            if (WalletBrandUI.this.tRP.cSY() != 398) {
                WalletBrandUI.this.setResult(uvVar.cRF.result, uvVar.cRF.intent);
                WalletBrandUI.this.finish();
                AppMethodBeat.o(48246);
            } else if (uvVar.cRF == null || bo.isNullOrNil(uvVar.cRF.czZ) || !uvVar.cRF.czZ.equalsIgnoreCase(WalletBrandUI.this.tRP.cTa()) || uvVar.cRF.cRH != 1) {
                ab.i("MicroMsg.WalletBrandUI", "FuncId %d,is not current request key || comeFrom:%s is not FINISH", Integer.valueOf(WalletBrandUI.this.tRP.cSY()), Integer.valueOf(uvVar.cRF.cRH));
                AppMethodBeat.o(48246);
            } else {
                if (bo.isNullOrNil(WalletBrandUI.this.tRQ) || !WalletBrandUI.this.tRQ.equalsIgnoreCase("key_from_scene_appbrandgame")) {
                    WalletBrandUI.this.setResult(uvVar.cRF.result, uvVar.cRF.intent);
                    WalletBrandUI.this.finish();
                } else {
                    WalletBrandUI.i(uvVar.cRF.result, uvVar.cRF.intent);
                }
                AppMethodBeat.o(48246);
            }
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c tRT = new com.tencent.mm.sdk.b.c<ul>() {
        {
            AppMethodBeat.i(48247);
            this.xxI = ul.class.getName().hashCode();
            AppMethodBeat.o(48247);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(48248);
            if (WalletBrandUI.this.gII != null) {
                WalletBrandUI.this.gII.dismiss();
                WalletBrandUI.this.gII = null;
            }
            AppMethodBeat.o(48248);
            return true;
        }
    };

    interface b {
        int cSY();

        m cSZ();

        String cTa();

        void onSceneEnd(int i, int i2, String str, m mVar);
    }

    public class a implements b {
        private int tRV = 0;
        private String tos = "";

        public final int cSY() {
            return 1563;
        }

        public final m cSZ() {
            AppMethodBeat.i(48251);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            this.tRV = WalletBrandUI.this.getIntent().getIntExtra("result_jump_mode", 0);
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            m aVar = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.this.appId, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0));
            g.RQ();
            g.RO().eJo.a(aVar, 0);
            AppMethodBeat.o(48251);
            return aVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48252);
            if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet_index.c.a.a)) {
                String str2 = ((com.tencent.mm.plugin.wallet_index.c.a.a) mVar).jumpUrl;
                ab.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", str2);
                this.tos = str2;
                String str3 = ((com.tencent.mm.plugin.wallet_index.c.a.a) mVar).tRo;
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
                    if (!bo.isNullOrNil(str3)) {
                        intent.putExtra("shouldForceViewPort", true);
                        intent.putExtra("view_port_code", str3);
                    }
                    com.tencent.mm.bp.d.b(WalletBrandUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    WalletBrandUI.this.setResult(-1);
                }
                WalletBrandUI.this.finish();
                AppMethodBeat.o(48252);
                return;
            }
            ab.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            h.a(WalletBrandUI.this, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48249);
                    WalletBrandUI.this.setResult(0);
                    WalletBrandUI.this.finish();
                    AppMethodBeat.o(48249);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(48250);
                    WalletBrandUI.this.setResult(0);
                    WalletBrandUI.this.finish();
                    AppMethodBeat.o(48250);
                }
            });
            AppMethodBeat.o(48252);
        }

        public final String cTa() {
            return this.tos;
        }
    }

    class c implements b {
        private String tos = "";

        c() {
        }

        public final m cSZ() {
            AppMethodBeat.i(48253);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            m aVar = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.this.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0));
            g.RQ();
            g.RO().eJo.a(aVar, 0);
            AppMethodBeat.o(48253);
            return aVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48254);
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = (com.tencent.mm.plugin.wallet_index.c.b.a) mVar;
            String str2 = aVar.tRa;
            ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
            this.tos = str2;
            PayInfo payInfo = new PayInfo();
            payInfo.czZ = str2;
            payInfo.appId = WalletBrandUI.this.appId;
            payInfo.tRb = aVar.tRb;
            payInfo.cIf = WalletBrandUI.this.cQO;
            payInfo.aIm = str;
            payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0);
            com.tencent.mm.pluginsdk.wallet.h.a(WalletBrandUI.this, payInfo, 1);
            AppMethodBeat.o(48254);
        }

        public final int cSY() {
            return 1521;
        }

        public final String cTa() {
            return this.tos;
        }
    }

    class d implements b {
        private String tos = "";

        d() {
        }

        public final m cSZ() {
            m jVar;
            AppMethodBeat.i(48255);
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
            if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra4, "up_")) {
                jVar = new j(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra4, "tax_")) {
                jVar = new i(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra4, "dc_")) {
                jVar = new com.tencent.mm.plugin.wallet_index.c.c(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            } else {
                jVar = new com.tencent.mm.plugin.wallet_index.c.e(f, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, g, intExtra, h, intExtra2, stringExtra7);
            }
            jVar.hbj = System.currentTimeMillis();
            jVar.eHT = "PayProcess";
            jVar.gOW = WalletBrandUI.this.cQO;
            g.RQ();
            g.RO().eJo.a(jVar, 0);
            AppMethodBeat.o(48255);
            return jVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48256);
            Intent intent;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_index.c.e eVar = (com.tencent.mm.plugin.wallet_index.c.e) mVar;
                String str2 = eVar.tRa;
                ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                this.tos = str2;
                com.tencent.mm.sdk.b.a.xxA.m(new ul());
                csj csj = ((com.tencent.mm.plugin.wallet_index.c.e) mVar).tRc;
                if (csj == null || bo.isNullOrNil(csj.xpI)) {
                    PayInfo payInfo = new PayInfo();
                    payInfo.czZ = str2;
                    payInfo.appId = WalletBrandUI.this.appId;
                    payInfo.tRb = eVar.tRb;
                    payInfo.cIf = WalletBrandUI.this.cQO;
                    payInfo.aIm = str;
                    payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0);
                    payInfo.vwj = eVar.hbj;
                    if (payInfo.vwh == null) {
                        payInfo.vwh = new Bundle();
                    }
                    payInfo.vwh.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.c.e) mVar).tRd);
                    payInfo.vwh.putString("extinfo_key_21", WalletBrandUI.this.getIntent().getStringExtra("intent_app_brand_from_path"));
                    payInfo.vwh.putString("extinfo_key_22", WalletBrandUI.this.getIntent().getStringExtra("intent_app_brand_from_username"));
                    ad.o(payInfo.cIf, str2, i2);
                    com.tencent.mm.pluginsdk.wallet.h.a(WalletBrandUI.this, payInfo, 1);
                    AppMethodBeat.o(48256);
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
                com.tencent.mm.bp.d.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                AppMethodBeat.o(48256);
                return;
            }
            ad.o(WalletBrandUI.this.cQO, "", i2);
            intent = new Intent();
            if (i != 0) {
                i2 = -1;
            }
            intent.putExtra("key_jsapi_pay_err_code", i2);
            String str3 = "key_jsapi_pay_err_msg";
            if (bo.isNullOrNil(str)) {
                str = WalletBrandUI.this.getString(R.string.fk3);
            }
            intent.putExtra(str3, str);
            WalletBrandUI.this.setResult(5, intent);
            WalletBrandUI.this.finish();
            AppMethodBeat.o(48256);
        }

        public final int cSY() {
            AppMethodBeat.i(48257);
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra, "up_")) {
                AppMethodBeat.o(48257);
                return 2519;
            } else if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra, "tax_")) {
                AppMethodBeat.o(48257);
                return 2923;
            } else if (com.tencent.mm.plugin.wallet_index.c.a.gO(stringExtra, "dc_")) {
                AppMethodBeat.o(48257);
                return 2798;
            } else {
                AppMethodBeat.o(48257);
                return 398;
            }
        }

        public final String cTa() {
            return this.tos;
        }
    }

    class e implements b {
        private String tos = "";

        e() {
        }

        public final int cSY() {
            return 2755;
        }

        public final m cSZ() {
            AppMethodBeat.i(48258);
            WalletBrandUI.this.appId = WalletBrandUI.this.getIntent().getStringExtra("appId");
            String stringExtra = WalletBrandUI.this.getIntent().getStringExtra("signtype");
            String stringExtra2 = WalletBrandUI.this.getIntent().getStringExtra("nonceStr");
            String stringExtra3 = WalletBrandUI.this.getIntent().getStringExtra("timeStamp");
            String stringExtra4 = WalletBrandUI.this.getIntent().getStringExtra("packageExt");
            String stringExtra5 = WalletBrandUI.this.getIntent().getStringExtra("paySignature");
            String stringExtra6 = WalletBrandUI.this.getIntent().getStringExtra("url");
            String stringExtra7 = WalletBrandUI.this.getIntent().getStringExtra("ext_info");
            WalletBrandUI.this.cIe = WalletBrandUI.this.getIntent().getStringExtra("bizUsername");
            m dVar = new com.tencent.mm.plugin.wallet_index.c.d(WalletBrandUI.this.appId, stringExtra, stringExtra2, stringExtra4, stringExtra5, stringExtra3, stringExtra6, WalletBrandUI.this.cIe, WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 0), WalletBrandUI.this.cQO, stringExtra7);
            dVar.hbj = System.currentTimeMillis();
            dVar.eHT = "PayProcess";
            dVar.gOW = WalletBrandUI.this.cQO;
            g.RQ();
            g.RO().eJo.a(dVar, 0);
            AppMethodBeat.o(48258);
            return dVar;
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48259);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_index.c.d dVar = (com.tencent.mm.plugin.wallet_index.c.d) mVar;
                String str2 = dVar.tRa;
                this.tos = str2;
                ab.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                PayInfo payInfo = new PayInfo();
                payInfo.czZ = str2;
                payInfo.appId = WalletBrandUI.this.appId;
                payInfo.tRb = dVar.tRb;
                payInfo.cIf = WalletBrandUI.this.cQO;
                payInfo.aIm = str;
                payInfo.cIb = WalletBrandUI.this.getIntent().getIntExtra("pay_channel", 16);
                payInfo.vwj = dVar.hbj;
                ad.o(payInfo.cIf, str2, i2);
                com.tencent.mm.pluginsdk.wallet.h.a(WalletBrandUI.this, payInfo, 1);
                AppMethodBeat.o(48259);
                return;
            }
            WalletBrandUI.this.finish();
            AppMethodBeat.o(48259);
        }

        public final String cTa() {
            return this.tos;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBrandUI() {
        AppMethodBeat.i(48260);
        AppMethodBeat.o(48260);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48261);
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(android.support.v4.widget.j.INVALID_ID);
            getWindow().setStatusBarColor(0);
        }
        this.cQO = getIntent().getIntExtra("pay_scene", 3);
        this.tRQ = getIntent().getStringExtra("intent_app_brand_from_scene");
        z.dNW();
        ab.i("MicroMsg.WalletBrandUI", "onCreate");
        int intExtra = getIntent().getIntExtra("pay_for_wallet_type", 1);
        ab.i("MicroMsg.WalletBrandUI", "onCreate payForWalletType is ".concat(String.valueOf(intExtra)));
        if (r.YM()) {
            ab.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.tRP = new c();
        } else if (intExtra == 2) {
            ab.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.tRP = new a();
        } else if (intExtra == 3) {
            ab.i("MicroMsg.WalletBrandUI", "do pay with mall");
            this.tRP = new e();
        } else {
            ab.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.tRP = new d();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.tRS);
        com.tencent.mm.sdk.b.a.xxA.c(this.tRT);
        g.RQ();
        g.RO().eJo.a(this.tRP.cSY(), (f) this);
        AppMethodBeat.o(48261);
    }

    public void onDestroy() {
        AppMethodBeat.i(48262);
        ab.i("MicroMsg.WalletBrandUI", "onDestroy");
        super.onDestroy();
        g.RQ();
        g.RO().eJo.b(this.tRP.cSY(), (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.tRS);
        com.tencent.mm.sdk.b.a.xxA.d(this.tRT);
        AppMethodBeat.o(48262);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(48263);
        ab.i("MicroMsg.WalletBrandUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(48263);
    }

    public void onResume() {
        AppMethodBeat.i(48264);
        ab.i("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        ab.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", Boolean.valueOf(this.tRO), Integer.valueOf(getTaskId()), getCallingActivity());
        if (!this.tRO) {
            this.tRO = true;
            this.tRR = this.tRP.cSZ();
            if (this.gII != null) {
                this.gII.dismiss();
                this.gII = null;
            }
            this.gII = com.tencent.mm.wallet_core.ui.g.g(this, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(48244);
                    g.RQ();
                    g.RO().eJo.c(WalletBrandUI.this.tRR);
                    WalletBrandUI.this.finish();
                    AppMethodBeat.o(48244);
                }
            });
        }
        AppMethodBeat.o(48264);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(48265);
        if (i == 4) {
            finish();
            AppMethodBeat.o(48265);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(48265);
        return onKeyDown;
    }

    public void onStart() {
        AppMethodBeat.i(48266);
        super.onStart();
        AppMethodBeat.o(48266);
    }

    public void onStop() {
        AppMethodBeat.i(48267);
        super.onStop();
        if (this.gII != null) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(48267);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48268);
        ab.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar, this.tRR);
        if (mVar.getType() == this.tRP.cSY() && mVar == this.tRR) {
            this.tRP.onSceneEnd(i, i2, str, mVar);
            AppMethodBeat.o(48268);
            return;
        }
        AppMethodBeat.o(48268);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48269);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i2 + " requestCode: " + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ab.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra("test"));
                    break;
            }
        }
        finish();
        AppMethodBeat.o(48269);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void i(int i, Intent intent) {
        AppMethodBeat.i(48270);
        uw uwVar = new uw();
        uwVar.cRI.intent = intent;
        uwVar.cRI.cRH = 1;
        uwVar.cRI.czZ = "key_from_scene_appbrandgame";
        uwVar.cRI.result = i;
        com.tencent.mm.sdk.b.a.xxA.m(uwVar);
        AppMethodBeat.o(48270);
    }
}
