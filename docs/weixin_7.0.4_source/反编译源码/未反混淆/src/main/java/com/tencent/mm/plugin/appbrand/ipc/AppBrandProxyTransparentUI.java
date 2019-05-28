package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73147);
        super.onCreate(bundle);
        ab.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
        ae.a(getWindow());
        try {
            getIntent().getExtras().setClassLoader(Class.forName(getIntent().getStringExtra("task_class_name")).getClassLoader());
        } catch (ClassNotFoundException e) {
            ab.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
            setResult(1);
            finish();
        }
        final AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) getIntent().getParcelableExtra("task_object");
        final String stringExtra = getIntent().getStringExtra("task_id");
        if (appBrandProxyTransparentUIProcessTask != null) {
            appBrandProxyTransparentUIProcessTask.a((Context) this, new AppBrandProxyTransparentUIProcessTask.a() {
                public final void aBT() {
                    AppMethodBeat.i(73146);
                    ab.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
                    Intent intent = new Intent();
                    intent.putExtra("task_object", appBrandProxyTransparentUIProcessTask);
                    intent.putExtra("task_id", stringExtra);
                    AppBrandProxyTransparentUI.this.setResult(-1, intent);
                    AppBrandProxyTransparentUI.this.finish();
                    AppMethodBeat.o(73146);
                }
            });
            AppMethodBeat.o(73147);
            return;
        }
        setResult(1);
        finish();
        AppMethodBeat.o(73147);
    }

    public void onDestroy() {
        AppMethodBeat.i(73148);
        super.onDestroy();
        ab.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
        AppMethodBeat.o(73148);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void aBS() {
        AppMethodBeat.i(73149);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.o(73149);
    }
}
