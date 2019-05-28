package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.w.b;
import com.tencent.mm.plugin.w.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(18225);
        super.onCreate(bundle);
        AppMethodBeat.o(18225);
    }

    public final boolean O(Intent intent) {
        return true;
    }

    public final void a(a aVar, Intent intent) {
        AppMethodBeat.i(18226);
        if (intent == null) {
            ab.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            AppMethodBeat.o(18226);
            return;
        }
        c cVar = c.qwS;
        int a = w.a(intent, "type", 0);
        AppCompatActivity appCompatActivity = this.mController.ylL;
        if (intent != null) {
            b bVar = (b) cVar.qwT.get(a);
            if (bVar != null) {
                bVar.l(appCompatActivity, intent);
            }
        }
        finish();
        AppMethodBeat.o(18226);
    }
}
