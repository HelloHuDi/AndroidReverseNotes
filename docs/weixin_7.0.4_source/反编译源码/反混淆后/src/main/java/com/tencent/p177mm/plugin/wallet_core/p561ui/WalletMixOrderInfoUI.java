package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C45376up;
import com.tencent.p177mm.p230g.p231a.C45380vs;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1660c.C46359a;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.C30205nb;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI */
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
    private C30205nb tHW;
    private int tHX;
    private C4884c tHY = new C248983();
    private String timeStamp = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI$3 */
    class C248983 extends C4884c<C45376up> {
        C248983() {
            AppMethodBeat.m2504i(47413);
            this.xxI = C45376up.class.getName().hashCode();
            AppMethodBeat.m2505o(47413);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            boolean z = false;
            AppMethodBeat.m2504i(47414);
            C45376up c45376up = (C45376up) c4883b;
            if (c45376up instanceof C45376up) {
                C4879a.xxA.mo10053d(this);
                WalletMixOrderInfoUI.this.appId = c45376up.cQN.appId;
                WalletMixOrderInfoUI.this.timeStamp = c45376up.cQN.timeStamp;
                WalletMixOrderInfoUI.this.nonceStr = c45376up.cQN.nonceStr;
                WalletMixOrderInfoUI.this.packageExt = c45376up.cQN.packageExt;
                WalletMixOrderInfoUI.this.czZ = c45376up.cQN.czZ;
                WalletMixOrderInfoUI.this.cQO = c45376up.cQN.cQO;
                WalletMixOrderInfoUI.this.signType = c45376up.cQN.signType;
                WalletMixOrderInfoUI.this.cQF = c45376up.cQN.cQF;
                if (WalletMixOrderInfoUI.this.cQO == 1 && !C5046bo.isNullOrNil(WalletMixOrderInfoUI.this.prepayId) && (C5046bo.isNullOrNil(WalletMixOrderInfoUI.this.czZ) || WalletMixOrderInfoUI.this.czZ.equals(WalletMixOrderInfoUI.this.prepayId))) {
                    WalletMixOrderInfoUI.this.mo39970a(new C46359a(WalletMixOrderInfoUI.this.appId, WalletMixOrderInfoUI.this.timeStamp, WalletMixOrderInfoUI.this.nonceStr, WalletMixOrderInfoUI.this.packageExt, WalletMixOrderInfoUI.this.czZ, WalletMixOrderInfoUI.this.cQO, WalletMixOrderInfoUI.this.signType, WalletMixOrderInfoUI.this.cQF), true, false);
                } else {
                    z = true;
                }
                if (z) {
                    WalletMixOrderInfoUI.this.tHV = false;
                    WalletMixOrderInfoUI.m38895a(WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this.getString(C25738R.string.fly));
                }
                AppMethodBeat.m2505o(47414);
                return true;
            }
            AppMethodBeat.m2505o(47414);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI$2 */
    class C249002 implements OnClickListener {
        C249002() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47412);
            dialogInterface.dismiss();
            C32652uv c32652uv = new C32652uv();
            c32652uv.cRF.czZ = WalletMixOrderInfoUI.this.prepayId;
            c32652uv.cRF.result = 0;
            C4879a.xxA.mo10055m(c32652uv);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.m2505o(47412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI$4 */
    class C249014 implements OnClickListener {
        final /* synthetic */ int tIb = 0;

        C249014() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47415);
            dialogInterface.dismiss();
            if (WalletMixOrderInfoUI.this.tHU) {
                C45380vs c45380vs = new C45380vs();
                c45380vs.cSF.result = this.tIb;
                C4879a.xxA.mo10055m(c45380vs);
            }
            C32652uv c32652uv = new C32652uv();
            c32652uv.cRF.czZ = WalletMixOrderInfoUI.this.prepayId;
            c32652uv.cRF.result = this.tIb;
            C4879a.xxA.mo10055m(c32652uv);
            WalletMixOrderInfoUI.this.setResult(this.tIb);
            WalletMixOrderInfoUI.this.finish();
            AppMethodBeat.m2505o(47415);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletMixOrderInfoUI() {
        AppMethodBeat.m2504i(47416);
        AppMethodBeat.m2505o(47416);
    }

    /* renamed from: a */
    static /* synthetic */ void m38895a(WalletMixOrderInfoUI walletMixOrderInfoUI, Context context, String str) {
        AppMethodBeat.m2504i(47424);
        walletMixOrderInfoUI.m38899be(context, str);
        AppMethodBeat.m2505o(47424);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47417);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.tHW = new C30205nb();
        this.tHW.vRG = intent.getIntExtra("max_count", 3);
        this.tHW.vRF = intent.getIntExtra("inteval_time", 4);
        this.tHW.vRH = intent.getStringExtra("default_wording");
        if (C5046bo.isNullOrNil(this.tHW.vRH)) {
            this.tHW.vRH = getString(C25738R.string.fdx);
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
            if (this.cQO == 2 && C5046bo.isNullOrNil(this.prepayId)) {
                mo39970a(new C46359a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.czZ, this.cQO, this.signType, this.cQF), true, false);
                AppMethodBeat.m2505o(47417);
                return;
            }
            m38899be(this, getString(C25738R.string.fly));
            AppMethodBeat.m2505o(47417);
            return;
        }
        final String stringExtra = intent.getStringExtra("pay_gate_url");
        boolean booleanExtra = intent.getBooleanExtra("need_dialog", false);
        String stringExtra2 = intent.getStringExtra("dialog_text");
        this.prepayId = intent.getStringExtra("prepayId");
        if (booleanExtra) {
            C30379h.m48440a((Context) this, stringExtra2, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(47411);
                    dialogInterface.dismiss();
                    WalletMixOrderInfoUI.m38896a(WalletMixOrderInfoUI.this, stringExtra);
                    AppMethodBeat.m2505o(47411);
                }
            }, new C249002()).setCancelable(false);
        } else {
            ada(stringExtra);
        }
        C4879a.xxA.mo10052c(this.tHY);
        AppMethodBeat.m2505o(47417);
    }

    public void onResume() {
        AppMethodBeat.m2504i(47418);
        super.onResume();
        AppMethodBeat.m2505o(47418);
    }

    public final int getLayoutId() {
        return 2130970969;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47419);
        if (c1207m instanceof C46359a) {
            if (i == 0 && i2 == 0) {
                this.tHV = false;
                C45380vs c45380vs = new C45380vs();
                c45380vs.cSF.result = -1;
                C4879a.xxA.mo10055m(c45380vs);
                Orders orders = ((C46359a) c1207m).tuL;
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
                    C4990ab.m7410d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
                    C4990ab.m7411d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", Integer.valueOf(this.tHX));
                    this.tHX--;
                    mo39971a(new C46359a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.cQO, this.signType, this.cQF), true, false, this.tHW.vRF);
                } else {
                    this.tHV = false;
                    if (str.isEmpty()) {
                        str = this.tHW.vRH;
                    }
                    m38899be(this, str);
                }
            }
            AppMethodBeat.m2505o(47419);
            return true;
        }
        AppMethodBeat.m2505o(47419);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47420);
        if (i == 1 && i2 == 0) {
            C4990ab.m7411d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.tHV) {
                C4879a.xxA.mo10053d(this.tHY);
                C32652uv c32652uv = new C32652uv();
                c32652uv.cRF.czZ = this.prepayId;
                c32652uv.cRF.result = 0;
                C4879a.xxA.mo10055m(c32652uv);
                finish();
            }
        }
        AppMethodBeat.m2505o(47420);
    }

    private void ada(String str) {
        AppMethodBeat.m2504i(47421);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47421);
            return;
        }
        C4990ab.m7411d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        C25985d.m41468b((Context) this, "webview", ".ui.tools.WebViewUI", intent, 1);
        AppMethodBeat.m2505o(47421);
    }

    /* renamed from: be */
    private void m38899be(Context context, String str) {
        AppMethodBeat.m2504i(47422);
        if (!this.tHU) {
            C45380vs c45380vs = new C45380vs();
            c45380vs.cSF.result = 0;
            C4879a.xxA.mo10055m(c45380vs);
        }
        C30379h.m48448a(context, str, "", false, new C249014()).setCancelable(false);
        AppMethodBeat.m2505o(47422);
    }
}
