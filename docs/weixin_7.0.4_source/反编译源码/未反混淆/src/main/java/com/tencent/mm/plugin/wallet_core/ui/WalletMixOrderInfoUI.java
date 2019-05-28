package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletMixOrderInfoUI extends WalletBaseUI {
    private String appId = null;
    private String cQF = null;
    private int cQO;
    private String czZ = null;
    private String nonceStr = null;
    private String packageExt = null;
    private String prepayId = null;
    private String signType = null;
    private boolean tHU;
    private boolean tHV;
    private nb tHW;
    private int tHX;
    private c tHY = new c<up>() {
        {
            AppMethodBeat.i(47413);
            this.xxI = up.class.getName().hashCode();
            AppMethodBeat.o(47413);
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = false;
            AppMethodBeat.i(47414);
            up upVar = (up) bVar;
            if (upVar instanceof up) {
                com.tencent.mm.sdk.b.a.xxA.d(this);
                WalletMixOrderInfoUI.this.appId = upVar.cQN.appId;
                WalletMixOrderInfoUI.this.timeStamp = upVar.cQN.timeStamp;
                WalletMixOrderInfoUI.this.nonceStr = upVar.cQN.nonceStr;
                WalletMixOrderInfoUI.this.packageExt = upVar.cQN.packageExt;
                WalletMixOrderInfoUI.this.czZ = upVar.cQN.czZ;
                WalletMixOrderInfoUI.this.cQO = upVar.cQN.cQO;
                WalletMixOrderInfoUI.this.signType = upVar.cQN.signType;
                WalletMixOrderInfoUI.this.cQF = upVar.cQN.cQF;
                if (WalletMixOrderInfoUI.this.cQO == 1 && !bo.isNullOrNil(WalletMixOrderInfoUI.this.prepayId) && (bo.isNullOrNil(WalletMixOrderInfoUI.this.czZ) || WalletMixOrderInfoUI.this.czZ.equals(WalletMixOrderInfoUI.this.prepayId))) {
                    WalletMixOrderInfoUI.this.a(new com.tencent.mm.plugin.wallet_core.c.c.a(WalletMixOrderInfoUI.this.appId, WalletMixOrderInfoUI.this.timeStamp, WalletMixOrderInfoUI.this.nonceStr, WalletMixOrderInfoUI.this.packageExt, WalletMixOrderInfoUI.this.czZ, WalletMixOrderInfoUI.this.cQO, WalletMixOrderInfoUI.this.signType, WalletMixOrderInfoUI.this.cQF), true, false);
                } else {
                    z = true;
                }
                if (z) {
                    WalletMixOrderInfoUI.this.tHV = false;
                    WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this.getString(R.string.fly));
                }
                AppMethodBeat.o(47414);
                return true;
            }
            AppMethodBeat.o(47414);
            return false;
        }
    };
    private String timeStamp = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletMixOrderInfoUI() {
        AppMethodBeat.i(47416);
        AppMethodBeat.o(47416);
    }

    static /* synthetic */ void a(WalletMixOrderInfoUI walletMixOrderInfoUI, Context context, String str) {
        AppMethodBeat.i(47424);
        walletMixOrderInfoUI.be(context, str);
        AppMethodBeat.o(47424);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47417);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.tHW = new nb();
        this.tHW.vRG = intent.getIntExtra("max_count", 3);
        this.tHW.vRF = intent.getIntExtra("inteval_time", 4);
        this.tHW.vRH = intent.getStringExtra("default_wording");
        if (bo.isNullOrNil(this.tHW.vRH)) {
            this.tHW.vRH = getString(R.string.fdx);
        }
        this.tHX = this.tHW.vRG;
        this.tHU = intent.getBooleanExtra("is_jsapi_offline_pay", false);
        this.tHV = true;
        if (this.tHU) {
            this.appId = getIntent().getStringExtra("appId");
            this.timeStamp = getIntent().getStringExtra("timeStamp");
            this.nonceStr = getIntent().getStringExtra("nonceStr");
            this.packageExt = getIntent().getStringExtra("packageExt");
            this.czZ = getIntent().getStringExtra("reqKey");
            this.cQO = getIntent().getIntExtra("payScene", -1);
            this.signType = getIntent().getStringExtra("signtype");
            this.cQF = getIntent().getStringExtra("paySignature");
            if (this.cQO == 2 && bo.isNullOrNil(this.prepayId)) {
                a(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.czZ, this.cQO, this.signType, this.cQF), true, false);
                AppMethodBeat.o(47417);
                return;
            }
            be(this, getString(R.string.fly));
            AppMethodBeat.o(47417);
            return;
        }
        final String stringExtra = intent.getStringExtra("pay_gate_url");
        boolean booleanExtra = intent.getBooleanExtra("need_dialog", false);
        String stringExtra2 = intent.getStringExtra("dialog_text");
        this.prepayId = intent.getStringExtra("prepayId");
        if (booleanExtra) {
            h.a((Context) this, stringExtra2, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(47411);
                    dialogInterface.dismiss();
                    WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this, stringExtra);
                    AppMethodBeat.o(47411);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(47412);
                    dialogInterface.dismiss();
                    uv uvVar = new uv();
                    uvVar.cRF.czZ = WalletMixOrderInfoUI.this.prepayId;
                    uvVar.cRF.result = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(uvVar);
                    WalletMixOrderInfoUI.this.finish();
                    AppMethodBeat.o(47412);
                }
            }).setCancelable(false);
        } else {
            ada(stringExtra);
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.tHY);
        AppMethodBeat.o(47417);
    }

    public void onResume() {
        AppMethodBeat.i(47418);
        super.onResume();
        AppMethodBeat.o(47418);
    }

    public final int getLayoutId() {
        return R.layout.b0t;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47419);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.c.a) {
            if (i == 0 && i2 == 0) {
                this.tHV = false;
                vs vsVar = new vs();
                vsVar.cSF.result = -1;
                com.tencent.mm.sdk.b.a.xxA.m(vsVar);
                Orders orders = ((com.tencent.mm.plugin.wallet_core.c.c.a) mVar).tuL;
                Intent intent = new Intent(this, WalletMixOrderInfoProxyUI.class);
                intent.putExtra("key_orders", orders);
                intent.putExtra("prepayId", this.prepayId);
                startActivity(intent);
                setResult(-1);
                finish();
            } else {
                Object obj;
                if (this.tHX == 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    ab.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
                    ab.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", Integer.valueOf(this.tHX));
                    this.tHX--;
                    a(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.cQO, this.signType, this.cQF), true, false, this.tHW.vRF);
                } else {
                    this.tHV = false;
                    if (str.isEmpty()) {
                        str = this.tHW.vRH;
                    }
                    be(this, str);
                }
            }
            AppMethodBeat.o(47419);
            return true;
        }
        AppMethodBeat.o(47419);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47420);
        if (i == 1 && i2 == 0) {
            ab.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.tHV) {
                com.tencent.mm.sdk.b.a.xxA.d(this.tHY);
                uv uvVar = new uv();
                uvVar.cRF.czZ = this.prepayId;
                uvVar.cRF.result = 0;
                com.tencent.mm.sdk.b.a.xxA.m(uvVar);
                finish();
            }
        }
        AppMethodBeat.o(47420);
    }

    private void ada(String str) {
        AppMethodBeat.i(47421);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(47421);
            return;
        }
        ab.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.o(47421);
    }

    private void be(Context context, String str) {
        AppMethodBeat.i(47422);
        if (!this.tHU) {
            vs vsVar = new vs();
            vsVar.cSF.result = 0;
            com.tencent.mm.sdk.b.a.xxA.m(vsVar);
        }
        h.a(context, str, "", false, new OnClickListener() {
            final /* synthetic */ int tIb = 0;

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(47415);
                dialogInterface.dismiss();
                if (WalletMixOrderInfoUI.this.tHU) {
                    vs vsVar = new vs();
                    vsVar.cSF.result = this.tIb;
                    com.tencent.mm.sdk.b.a.xxA.m(vsVar);
                }
                uv uvVar = new uv();
                uvVar.cRF.czZ = WalletMixOrderInfoUI.this.prepayId;
                uvVar.cRF.result = this.tIb;
                com.tencent.mm.sdk.b.a.xxA.m(uvVar);
                WalletMixOrderInfoUI.this.setResult(this.tIb);
                WalletMixOrderInfoUI.this.finish();
                AppMethodBeat.o(47415);
            }
        }).setCancelable(false);
        AppMethodBeat.o(47422);
    }
}
