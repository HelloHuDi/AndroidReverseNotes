package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity extends MMActivity {

    public enum a {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL;

        static {
            AppMethodBeat.o(73688);
        }
    }

    public abstract boolean O(Intent intent);

    public abstract void a(a aVar, Intent intent);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        Intent intent = getIntent();
        if (intent == null) {
            ab.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        d.dlL();
        ab.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = w.a(intent, "wizard_activity_result_code", -2);
        ab.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(a)));
        if (a != -2) {
            KJ(a);
        } else if (!O(intent)) {
            ab.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (bVD()) {
            finish();
            ab.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            a(a.LOGIN_OK, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = w.a(intent, "wizard_activity_result_code", 0);
            ab.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(a)));
            KJ(a);
        }
    }

    private void KJ(int i) {
        switch (i) {
            case -1:
                a(a.LOGIN_OK, getIntent());
                return;
            case 0:
                bVD();
                return;
            case 1:
                a(a.LOGIN_CANCEL, getIntent());
                return;
            default:
                ab.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(i)));
                a(a.LOGIN_FAIL, getIntent());
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean bVD() {
        g.RN();
        if (com.tencent.mm.kernel.a.QX() && !com.tencent.mm.kernel.a.QT()) {
            return false;
        }
        ab.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        d.a((Context) this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", intent2, intent);
        return true;
    }

    public int getLayoutId() {
        return -1;
    }
}
