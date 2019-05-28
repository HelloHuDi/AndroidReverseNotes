package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.precondition.c;
import com.tencent.mm.plugin.appbrand.launching.precondition.e;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(7)
@i
public final class AppBrandLaunchProxyUI extends MMBaseActivity implements o {
    private p ifC;
    private g ifD;
    private MMActivity.a ifE = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static boolean D(Intent intent) {
        AppMethodBeat.i(131706);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getShortClassName().equals(".plugin.appbrand.launching.AppBrandLaunchProxyUI")) {
                    AppMethodBeat.o(131706);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.o(131706);
                return false;
            }
        }
        AppMethodBeat.o(131706);
        return false;
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.i(131707);
        a(context, str, null, str2, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(131707);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        AppMethodBeat.i(131708);
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            AppMethodBeat.o(131708);
            return false;
        }
        boolean a = f.ijT.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
        AppMethodBeat.o(131708);
        return a;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(131709);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(131709);
            return;
        }
        g cVar;
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("extra_from_mm", true)) {
            cVar = new c(this);
        } else if (intent.getBooleanExtra("extra_launch_weishi_video", false)) {
            cVar = new com.tencent.mm.plugin.appbrand.weishi.a(this);
        } else {
            cVar = new e(this);
        }
        this.ifD = cVar;
        if (this.ifD != null) {
            ab.i("MicroMsg.AppBrandLaunchProxyUI", "onCreate, uiDelegate %s", this.ifD.getClass().getSimpleName());
            this.ifD.E(getIntent());
            if (!isFinishing() && this.ifD.aHO()) {
                getString(R.string.tz);
                this.ifC = h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(131704);
                        AppBrandLaunchProxyUI.this.finish();
                        AppMethodBeat.o(131704);
                    }
                });
                if (this.ifC == null) {
                    ab.e("MicroMsg.AppBrandLaunchProxyUI", "onCreate, get null progress dialog");
                    finish();
                    AppMethodBeat.o(131709);
                    return;
                }
                this.ifC.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(131705);
                        if (!AppBrandLaunchProxyUI.this.isFinishing()) {
                            AppBrandLaunchProxyUI.this.finish();
                        }
                        AppMethodBeat.o(131705);
                    }
                });
                if (this.ifC.getWindow() != null) {
                    LayoutParams attributes = this.ifC.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.ifC.getWindow().setAttributes(attributes);
                    AppMethodBeat.o(131709);
                    return;
                }
            }
        }
        finish();
        AppMethodBeat.o(131709);
    }

    public final void onResume() {
        AppMethodBeat.i(131710);
        super.onResume();
        ab.i("MicroMsg.AppBrandLaunchProxyUI", "onResume");
        if (this.ifD != null) {
            this.ifD.onResume();
            AppMethodBeat.o(131710);
            return;
        }
        super.finish();
        AppMethodBeat.o(131710);
    }

    public final void onPause() {
        AppMethodBeat.i(131711);
        super.onPause();
        ab.i("MicroMsg.AppBrandLaunchProxyUI", "onPause");
        if (this.ifD != null) {
            this.ifD.onPause();
            AppMethodBeat.o(131711);
            return;
        }
        super.finish();
        AppMethodBeat.o(131711);
    }

    public final void onDestroy() {
        AppMethodBeat.i(131712);
        super.onDestroy();
        ab.i("MicroMsg.AppBrandLaunchProxyUI", "onDestroy");
        if (this.ifC != null) {
            this.ifC.dismiss();
            this.ifC = null;
        }
        if (this.ifD != null) {
            this.ifD.onDestroy();
        }
        AppMethodBeat.o(131712);
    }

    public final void finish() {
        AppMethodBeat.i(131713);
        super.finish();
        ab.i("MicroMsg.AppBrandLaunchProxyUI", "finish");
        AppMethodBeat.o(131713);
    }

    public final void a(MMActivity.a aVar, Intent intent, int i) {
        AppMethodBeat.i(131714);
        this.ifE = aVar;
        startActivityForResult(intent, i);
        AppMethodBeat.o(131714);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(131715);
        super.onActivityResult(i, i2, intent);
        if (this.ifE != null) {
            this.ifE.c(i, i2, intent);
        }
        this.ifE = null;
        AppMethodBeat.o(131715);
    }

    public final boolean aHa() {
        AppMethodBeat.i(131716);
        if (isFinishing()) {
            AppMethodBeat.o(131716);
            return false;
        }
        AppMethodBeat.o(131716);
        return true;
    }
}
