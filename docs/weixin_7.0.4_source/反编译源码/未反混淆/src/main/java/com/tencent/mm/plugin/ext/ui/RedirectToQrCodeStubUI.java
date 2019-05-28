package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class RedirectToQrCodeStubUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20439);
        super.onCreate(bundle);
        ab.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        cf cfVar = new cf();
        cfVar.cvm.activity = this;
        cfVar.cvm.ctB = stringExtra;
        cfVar.cvm.cvn = intExtra;
        cfVar.cvm.cvo = intExtra2;
        cfVar.cvm.scene = 47;
        a.xxA.m(cfVar);
        finish();
        AppMethodBeat.o(20439);
    }
}
