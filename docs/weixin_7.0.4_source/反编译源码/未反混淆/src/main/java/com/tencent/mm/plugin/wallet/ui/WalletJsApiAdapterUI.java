package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletJsApiAdapterUI extends WalletBaseUI {
    protected boolean pQP = false;
    protected String packageName = "";
    protected String ttH = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46456);
        super.onCreate(bundle);
        AM(8);
        this.packageName = getIntent().getStringExtra("intent_jump_package");
        this.ttH = getIntent().getStringExtra("intent_jump_ui");
        nf(580);
        if (getIntent() == null) {
            ab.d("MicroMsg.WalletJsApiAdapterUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(46456);
            return;
        }
        int intExtra = getIntent().getIntExtra("source_type", 1);
        ab.i("MicroMsg.WalletJsApiAdapterUI", "do check jsapi: %s", Integer.valueOf(intExtra));
        m mVar = null;
        if (intExtra == 1) {
            mVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), getIntent().getIntExtra("jsapi_scene", 0), "openWCPayCardList", getIntent().getIntExtra("pay_channel", 0));
        } else if (intExtra == 2) {
            mVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getIntExtra("jsapi_scene", 0), getIntent().getStringExtra("wxapp_username"), getIntent().getStringExtra("wxapp_path"), getIntent().getStringExtra("command_word"), getIntent().getIntExtra("pay_channel", 0));
        }
        if (mVar != null) {
            a(mVar, true, false);
        }
        AppMethodBeat.o(46456);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(46457);
        ab.v("MicroMsg.WalletJsApiAdapterUI", "onNewIntent");
        int intExtra = intent.getIntExtra("RESET_PWD_USER_ACTION", 0);
        if (intExtra == 1) {
            setResult(-1);
            finish();
            AppMethodBeat.o(46457);
        } else if (intExtra == 2) {
            setResult(-1000);
            finish();
            AppMethodBeat.o(46457);
        } else {
            setResult(0);
            finish();
            AppMethodBeat.o(46457);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(46458);
        ng(580);
        super.onDestroy();
        AppMethodBeat.o(46458);
    }

    public void onBackPressed() {
        AppMethodBeat.i(46459);
        if (this.pQP) {
            ab.d("MicroMsg.WalletJsApiAdapterUI", "back press but lock");
            AppMethodBeat.o(46459);
            return;
        }
        ab.d("MicroMsg.WalletJsApiAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.o(46459);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46460);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(46460);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46461);
        ab.i("MicroMsg.WalletJsApiAdapterUI", "onSceneEnd errType %s errCode %s errMsg %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (i != 0 || i2 != 0) {
            setResult(-1000);
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(46461);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
            if (bo.isNullOrNil(this.packageName) || bo.isNullOrNil(this.ttH)) {
                setResult(-1);
                finish();
            } else {
                Intent intent = new Intent();
                intent.putExtra("intent_finish_self", true);
                d.b((Context) this, this.packageName, this.ttH, intent, 1);
            }
            AppMethodBeat.o(46461);
            return true;
        } else {
            AppMethodBeat.o(46461);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
