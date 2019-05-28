package com.tencent.p177mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.ipcinvoker.C26341k;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI */
public class IpcProxyUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI$1 */
    class C355891 implements C4541a {
        C355891() {
        }

        /* renamed from: l */
        public final void mo9613l(Bundle bundle) {
            AppMethodBeat.m2504i(6249);
            Intent intent = new Intent();
            intent.putExtra("input_data", bundle);
            IpcProxyUI.this.setResult(-1, intent);
            IpcProxyUI.this.finish();
            AppMethodBeat.m2505o(6249);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(6250);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.IpcProxyUI", "onCreate");
        if (C1443d.m3068iW(21)) {
            getWindow().setStatusBarColor(0);
        }
        C35590c c35590c = (C35590c) C26341k.m41919b(getIntent().getStringExtra("task_class_name"), C35590c.class);
        if (c35590c != null) {
            c35590c.mo56317a(this, getIntent().getBundleExtra("input_data"), new C355891());
            AppMethodBeat.m2505o(6250);
            return;
        }
        setResult(-1, new Intent());
        finish();
        AppMethodBeat.m2505o(6250);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(6251);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.IpcProxyUI", "onDestroy");
        AppMethodBeat.m2505o(6251);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void aBS() {
        AppMethodBeat.m2504i(6252);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.m2505o(6252);
    }
}
