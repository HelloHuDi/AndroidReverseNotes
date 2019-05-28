package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity */
public class FreeWifiTestActivity extends Activity {

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity$2 */
    class C208092 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity$2$1 */
        class C208081 implements DialogInterface.OnClickListener {
            C208081() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C208092() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21109);
            C30379h.m48440a(FreeWifiTestActivity.this, "t12345", "t54331", new C208081(), null);
            AppMethodBeat.m2505o(21109);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity$1 */
    class C281021 implements OnClickListener {
        C281021() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(21108);
            Toast.makeText(C4996ah.getContext(), "test message", 0).show();
            AppMethodBeat.m2505o(21108);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(21110);
        super.onCreate(bundle);
        setContentView(2130969600);
        findViewById(2131824168).setOnClickListener(new C281021());
        findViewById(2131824169).setOnClickListener(new C208092());
        AppMethodBeat.m2505o(21110);
    }
}
