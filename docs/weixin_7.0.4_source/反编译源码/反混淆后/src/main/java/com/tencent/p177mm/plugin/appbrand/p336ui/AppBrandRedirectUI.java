package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI */
public class AppBrandRedirectUI extends MMActivity {
    private int fromScene = -1;
    private boolean iIq = false;
    private int result = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133083);
        super.onCreate(bundle);
        C42696n.m75615a(getWindow());
        C4990ab.m7416i("AppBrandRedirectUI", "onCreate");
        setResult(0);
        this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
        if (this.fromScene == 0) {
            getIntent().putExtra("WizardRootClass", getClass().getName());
            C4990ab.m7416i("AppBrandRedirectUI", "start to bind phone number");
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
            intent.putExtra("bind_scene", 5);
            String simCountryIso = ((TelephonyManager) this.mController.ylL.getSystemService("phone")).getSimCountryIso();
            if (!C5046bo.isNullOrNil(simCountryIso)) {
                C17951a k = C17950b.m28210k(this, simCountryIso, this.mController.ylL.getString(C25738R.string.b3_));
                if (k != null) {
                    intent.putExtra("country_name", k.fHE);
                    intent.putExtra("couttry_code", k.fHD);
                }
            }
            MMWizardActivity.m23791J(this, intent);
            AppMethodBeat.m2505o(133083);
            return;
        }
        C4990ab.m7412e("AppBrandRedirectUI", "from scene is illegal, finish activity");
        finish();
        AppMethodBeat.m2505o(133083);
    }

    public void onResume() {
        AppMethodBeat.m2504i(133084);
        super.onResume();
        C4990ab.m7416i("AppBrandRedirectUI", "onResume");
        if (this.iIq) {
            C4990ab.m7416i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(133084);
            return;
        }
        this.iIq = true;
        AppMethodBeat.m2505o(133084);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(133085);
        if (i == 4) {
            C4990ab.m7412e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(133085);
        return onKeyUp;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(133086);
        C4990ab.m7416i("AppBrandRedirectUI", "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null) {
            this.result = intent.getIntExtra("wizard_activity_result_code", 0);
            setResult(this.result);
            C4990ab.m7417i("AppBrandRedirectUI", "result:%d, finish activity", Integer.valueOf(this.result));
        } else {
            C4990ab.m7416i("AppBrandRedirectUI", "intent is null");
            setResult(0);
        }
        finish();
        AppMethodBeat.m2505o(133086);
    }
}
