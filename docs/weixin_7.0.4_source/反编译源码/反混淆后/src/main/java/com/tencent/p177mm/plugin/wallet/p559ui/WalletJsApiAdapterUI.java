package com.tencent.p177mm.plugin.wallet.p559ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.ui.WalletJsApiAdapterUI */
public class WalletJsApiAdapterUI extends WalletBaseUI {
    protected boolean pQP = false;
    protected String packageName = "";
    protected String ttH = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46456);
        super.onCreate(bundle);
        mo9439AM(8);
        this.packageName = getIntent().getStringExtra("intent_jump_package");
        this.ttH = getIntent().getStringExtra("intent_jump_ui");
        mo39992nf(580);
        if (getIntent() == null) {
            C4990ab.m7410d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(46456);
            return;
        }
        int intExtra = getIntent().getIntExtra("source_type", 1);
        C4990ab.m7417i("MicroMsg.WalletJsApiAdapterUI", "do check jsapi: %s", Integer.valueOf(intExtra));
        C1207m c1207m = null;
        if (intExtra == 1) {
            c1207m = new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), getIntent().getIntExtra("jsapi_scene", 0), "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
        } else if (intExtra == 2) {
            c1207m = new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getIntExtra("jsapi_scene", 0), getIntent().getStringExtra("wxapp_username"), getIntent().getStringExtra("wxapp_path"), getIntent().getStringExtra("command_word"), getIntent().getIntExtra("pay_channel", 0));
        }
        if (c1207m != null) {
            mo39970a(c1207m, true, false);
        }
        AppMethodBeat.m2505o(46456);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(46457);
        C4990ab.m7418v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(46457);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.m2505o(46457);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(46457);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46458);
        mo39993ng(580);
        super.onDestroy();
        AppMethodBeat.m2505o(46458);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(46459);
        if (this.pQP) {
            C4990ab.m7410d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
            AppMethodBeat.m2505o(46459);
            return;
        }
        C4990ab.m7410d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.m2505o(46459);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46460);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.m2505o(46460);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46461);
        C4990ab.m7417i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (i != 0 || i2 != 0) {
            setResult(-1000);
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(46461);
            return true;
        } else if (c1207m instanceof C22558a) {
            C46512f.akr(((C22558a) c1207m).cOS());
            if (C5046bo.isNullOrNil(this.packageName) || C5046bo.isNullOrNil(this.ttH)) {
                setResult(-1);
                finish();
            } else {
                Intent intent = new Intent();
                intent.putExtra("intent_finish_self", true);
                C25985d.m41468b((Context) this, this.packageName, this.ttH, intent, 1);
            }
            AppMethodBeat.m2505o(46461);
            return true;
        } else {
            AppMethodBeat.m2505o(46461);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
