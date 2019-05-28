package com.tencent.p177mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.modelappbrand.LaunchParamsOptional;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C19583g;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C27178e;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C46895c;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.weishi.C27352a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@C5271a(7)
@C18524i
/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI */
public final class AppBrandLaunchProxyUI extends MMBaseActivity implements C19578o {
    private C44275p ifC;
    private C19583g ifD;
    private C5186a ifE = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI$1 */
    class C166841 implements OnCancelListener {
        C166841() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(131704);
            AppBrandLaunchProxyUI.this.finish();
            AppMethodBeat.m2505o(131704);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI$2 */
    class C166852 implements OnDismissListener {
        C166852() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(131705);
            if (!AppBrandLaunchProxyUI.this.isFinishing()) {
                AppBrandLaunchProxyUI.this.finish();
            }
            AppMethodBeat.m2505o(131705);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: D */
    public static boolean m25692D(Intent intent) {
        AppMethodBeat.m2504i(131706);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                    AppMethodBeat.m2505o(131706);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(131706);
                return false;
            }
        }
        AppMethodBeat.m2505o(131706);
        return false;
    }

    /* renamed from: a */
    public static void m25693a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.m2504i(131707);
        AppBrandLaunchProxyUI.m25694a(context, str, null, str2, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.m2505o(131707);
    }

    /* renamed from: a */
    public static boolean m25694a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.m2504i(131708);
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(131708);
            return false;
        }
        boolean a = C10600f.ijT.mo33003a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.m2505o(131708);
        return a;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(131709);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(131709);
            return;
        }
        C19583g c46895c;
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("extra_from_mm", true)) {
            c46895c = new C46895c(this);
        } else if (intent.getBooleanExtra("extra_launch_weishi_video", false)) {
            c46895c = new C27352a(this);
        } else {
            c46895c = new C27178e(this);
        }
        this.ifD = c46895c;
        if (this.ifD != null) {
            C4990ab.m7417i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", this.ifD.getClass().getSimpleName());
            this.ifD.mo34794E(getIntent());
            if (!isFinishing() && this.ifD.aHO()) {
                getString(C25738R.string.f9238tz);
                this.ifC = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C166841());
                if (this.ifC == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, get null progress dialog");
                    finish();
                    AppMethodBeat.m2505o(131709);
                    return;
                }
                this.ifC.setOnDismissListener(new C166852());
                if (this.ifC.getWindow() != null) {
                    LayoutParams attributes = this.ifC.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.ifC.getWindow().setAttributes(attributes);
                    AppMethodBeat.m2505o(131709);
                    return;
                }
            }
        }
        finish();
        AppMethodBeat.m2505o(131709);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(131710);
        super.onResume();
        C4990ab.m7416i("MicroMsg.AppBrandLaunchProxyUI", "onResume");
        if (this.ifD != null) {
            this.ifD.onResume();
            AppMethodBeat.m2505o(131710);
            return;
        }
        super.finish();
        AppMethodBeat.m2505o(131710);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(131711);
        super.onPause();
        C4990ab.m7416i("MicroMsg.AppBrandLaunchProxyUI", "onPause");
        if (this.ifD != null) {
            this.ifD.onPause();
            AppMethodBeat.m2505o(131711);
            return;
        }
        super.finish();
        AppMethodBeat.m2505o(131711);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(131712);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy");
        if (this.ifC != null) {
            this.ifC.dismiss();
            this.ifC = null;
        }
        if (this.ifD != null) {
            this.ifD.onDestroy();
        }
        AppMethodBeat.m2505o(131712);
    }

    public final void finish() {
        AppMethodBeat.m2504i(131713);
        super.finish();
        C4990ab.m7416i("MicroMsg.AppBrandLaunchProxyUI", "finish");
        AppMethodBeat.m2505o(131713);
    }

    /* renamed from: a */
    public final void mo30646a(C5186a c5186a, Intent intent, int i) {
        AppMethodBeat.m2504i(131714);
        this.ifE = c5186a;
        startActivityForResult(intent, i);
        AppMethodBeat.m2505o(131714);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(131715);
        super.onActivityResult(i, i2, intent);
        if (this.ifE != null) {
            this.ifE.mo6069c(i, i2, intent);
        }
        this.ifE = null;
        AppMethodBeat.m2505o(131715);
    }

    public final boolean aHa() {
        AppMethodBeat.m2504i(131716);
        if (isFinishing()) {
            AppMethodBeat.m2505o(131716);
            return false;
        }
        AppMethodBeat.m2505o(131716);
        return true;
    }
}
