package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandRedirectUI extends MMActivity {
    private int fromScene = -1;
    private boolean iIq = false;
    private int result = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133083);
        super.onCreate(bundle);
        n.a(getWindow());
        ab.i("AppBrandRedirectUI", "onCreate");
        setResult(0);
        this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
        if (this.fromScene == 0) {
            getIntent().putExtra("WizardRootClass", getClass().getName());
            ab.i("AppBrandRedirectUI", "start to bind phone number");
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
            intent.putExtra("bind_scene", 5);
            String simCountryIso = ((TelephonyManager) this.mController.ylL.getSystemService("phone")).getSimCountryIso();
            if (!bo.isNullOrNil(simCountryIso)) {
                b.a k = b.k(this, simCountryIso, this.mController.ylL.getString(R.string.b3_));
                if (k != null) {
                    intent.putExtra("country_name", k.fHE);
                    intent.putExtra("couttry_code", k.fHD);
                }
            }
            MMWizardActivity.J(this, intent);
            AppMethodBeat.o(133083);
            return;
        }
        ab.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
        finish();
        AppMethodBeat.o(133083);
    }

    public void onResume() {
        AppMethodBeat.i(133084);
        super.onResume();
        ab.i("AppBrandRedirectUI", "onResume");
        if (this.iIq) {
            ab.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
            setResult(0);
            finish();
            AppMethodBeat.o(133084);
            return;
        }
        this.iIq = true;
        AppMethodBeat.o(133084);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(133085);
        if (i == 4) {
            ab.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(133085);
        return onKeyUp;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(133086);
        ab.i("AppBrandRedirectUI", "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null) {
            this.result = intent.getIntExtra("wizard_activity_result_code", 0);
            setResult(this.result);
            ab.i("AppBrandRedirectUI", "result:%d, finish activity", Integer.valueOf(this.result));
        } else {
            ab.i("AppBrandRedirectUI", "intent is null");
            setResult(0);
        }
        finish();
        AppMethodBeat.o(133086);
    }
}
