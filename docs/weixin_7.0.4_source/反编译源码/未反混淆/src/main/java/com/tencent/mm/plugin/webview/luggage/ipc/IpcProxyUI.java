package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IpcProxyUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(6250);
        super.onCreate(bundle);
        ab.i("MicroMsg.IpcProxyUI", "onCreate");
        if (d.iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        c cVar = (c) k.b(getIntent().getStringExtra("task_class_name"), c.class);
        if (cVar != null) {
            cVar.a(this, getIntent().getBundleExtra("input_data"), new a() {
                public final void l(Bundle bundle) {
                    AppMethodBeat.i(6249);
                    Intent intent = new Intent();
                    intent.putExtra("input_data", bundle);
                    IpcProxyUI.this.setResult(-1, intent);
                    IpcProxyUI.this.finish();
                    AppMethodBeat.o(6249);
                }
            });
            AppMethodBeat.o(6250);
            return;
        }
        setResult(-1, new Intent());
        finish();
        AppMethodBeat.o(6250);
    }

    public void onDestroy() {
        AppMethodBeat.i(6251);
        super.onDestroy();
        ab.i("MicroMsg.IpcProxyUI", "onDestroy");
        AppMethodBeat.o(6251);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void aBS() {
        AppMethodBeat.i(6252);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.o(6252);
    }
}
