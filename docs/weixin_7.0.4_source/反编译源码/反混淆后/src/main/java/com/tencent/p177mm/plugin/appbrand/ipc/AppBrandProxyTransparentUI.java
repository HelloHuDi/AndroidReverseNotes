package com.tencent.p177mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.C19245a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI */
public class AppBrandProxyTransparentUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(73147);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
        C5222ae.m7935a(getWindow());
        try {
            getIntent().getExtras().setClassLoader(Class.forName(getIntent().getStringExtra("task_class_name")).getClassLoader());
        } catch (ClassNotFoundException e) {
            C4990ab.m7412e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
            setResult(1);
            finish();
        }
        final AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) getIntent().getParcelableExtra("task_object");
        final String stringExtra = getIntent().getStringExtra("task_id");
        if (appBrandProxyTransparentUIProcessTask != null) {
            appBrandProxyTransparentUIProcessTask.mo6020a((Context) this, new C19245a() {
                public final void aBT() {
                    AppMethodBeat.m2504i(73146);
                    C4990ab.m7416i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
                    Intent intent = new Intent();
                    intent.putExtra("task_object", appBrandProxyTransparentUIProcessTask);
                    intent.putExtra("task_id", stringExtra);
                    AppBrandProxyTransparentUI.this.setResult(-1, intent);
                    AppBrandProxyTransparentUI.this.finish();
                    AppMethodBeat.m2505o(73146);
                }
            });
            AppMethodBeat.m2505o(73147);
            return;
        }
        setResult(1);
        finish();
        AppMethodBeat.m2505o(73147);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(73148);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
        AppMethodBeat.m2505o(73148);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void aBS() {
        AppMethodBeat.m2504i(73149);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.m2505o(73149);
    }
}
