package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C37778or;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI */
public class FaceTransparentStubUI extends MMActivity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(514);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
        Bundle bundleExtra = getIntent().getBundleExtra("KEY_EXTRAS");
        if (!bundleExtra.containsKey("k_user_name")) {
            C1720g.m3534RN();
            if (C1668a.m3395QX()) {
                bundleExtra.putString("k_user_name", C1853r.m3821YC());
            }
        }
        C37778or c37778or = new C37778or();
        c37778or.cLd.context = this;
        c37778or.cLd.cKY = intExtra;
        c37778or.cLd.extras = bundleExtra;
        C4879a.xxA.mo10055m(c37778or);
        C4990ab.m7417i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", Boolean.valueOf(c37778or.cLe.cKV));
        if (!c37778or.cLe.cKV) {
            if (c37778or.cLe.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(c37778or.cLe.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.m2505o(514);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(515);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
        setResult(i2, intent);
        finish();
        AppMethodBeat.m2505o(515);
    }

    public final int getLayoutId() {
        return -1;
    }
}
