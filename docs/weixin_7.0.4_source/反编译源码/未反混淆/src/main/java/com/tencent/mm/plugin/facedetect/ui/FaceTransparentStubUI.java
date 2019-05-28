package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.or;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceTransparentStubUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(514);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                bundleExtra.putString("k_user_name", r.YC());
            }
        }
        or orVar = new or();
        orVar.cLd.context = this;
        orVar.cLd.cKY = intExtra;
        orVar.cLd.extras = bundleExtra;
        com.tencent.mm.sdk.b.a.xxA.m(orVar);
        ab.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", Boolean.valueOf(orVar.cLe.cKV));
        if (!orVar.cLe.cKV) {
            if (orVar.cLe.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(orVar.cLe.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.o(514);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(515);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(515);
    }

    public final int getLayoutId() {
        return -1;
    }
}
