package com.tencent.p177mm.pluginsdk.p597ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5068w;

@C5271a(3)
/* renamed from: com.tencent.mm.pluginsdk.ui.AutoLoginActivity */
public abstract class AutoLoginActivity extends MMActivity {

    /* renamed from: com.tencent.mm.pluginsdk.ui.AutoLoginActivity$a */
    public enum C4737a {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL;

        static {
            AppMethodBeat.m2505o(73688);
        }
    }

    /* renamed from: O */
    public abstract boolean mo6736O(Intent intent);

    /* renamed from: a */
    public abstract void mo6737a(C4737a c4737a, Intent intent);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        Intent intent = getIntent();
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        C25985d.dlL();
        C4990ab.m7416i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = C5068w.m7682a(intent, "wizard_activity_result_code", -2);
        C4990ab.m7416i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(a)));
        if (a != -2) {
            m79223KJ(a);
        } else if (!mo6736O(intent)) {
            C4990ab.m7412e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (bVD()) {
            finish();
            C4990ab.m7420w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            mo6737a(C4737a.LOGIN_OK, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = C5068w.m7682a(intent, "wizard_activity_result_code", 0);
            C4990ab.m7416i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(a)));
            m79223KJ(a);
        }
    }

    /* renamed from: KJ */
    private void m79223KJ(int i) {
        switch (i) {
            case -1:
                mo6737a(C4737a.LOGIN_OK, getIntent());
                return;
            case 0:
                bVD();
                return;
            case 1:
                mo6737a(C4737a.LOGIN_CANCEL, getIntent());
                return;
            default:
                C4990ab.m7412e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(i)));
                mo6737a(C4737a.LOGIN_FAIL, getIntent());
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean bVD() {
        C1720g.m3534RN();
        if (C1668a.m3395QX() && !C1668a.m3393QT()) {
            return false;
        }
        C4990ab.m7420w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        C25985d.m41454a((Context) this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", intent2, intent);
        return true;
    }

    public int getLayoutId() {
        return -1;
    }
}
