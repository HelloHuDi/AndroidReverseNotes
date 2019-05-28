package com.tencent.p177mm.plugin.ext.p964ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26102cf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI */
public class RedirectToQrCodeStubUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20439);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
        String stringExtra = getIntent().getStringExtra("K_STR");
        int intExtra = getIntent().getIntExtra("K_TYPE", -1);
        int intExtra2 = getIntent().getIntExtra("K_VERSION", -1);
        C26102cf c26102cf = new C26102cf();
        c26102cf.cvm.activity = this;
        c26102cf.cvm.ctB = stringExtra;
        c26102cf.cvm.cvn = intExtra;
        c26102cf.cvm.cvo = intExtra2;
        c26102cf.cvm.scene = 47;
        C4879a.xxA.mo10055m(c26102cf);
        finish();
        AppMethodBeat.m2505o(20439);
    }
}
