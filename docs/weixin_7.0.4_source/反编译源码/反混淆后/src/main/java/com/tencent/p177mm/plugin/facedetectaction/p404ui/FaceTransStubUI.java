package com.tencent.p177mm.plugin.facedetectaction.p404ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9431oo;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI */
public class FaceTransStubUI extends MMActivity {
    private Context context = this;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FaceTransStubUI() {
        AppMethodBeat.m2504i(746);
        AppMethodBeat.m2505o(746);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(747);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
        C9431oo c9431oo = new C9431oo();
        c9431oo.cKR.scene = getIntent().getIntExtra("scene", 0);
        c9431oo.cKR.packageName = getIntent().getStringExtra("package");
        c9431oo.cKR.cKT = getIntent().getStringExtra("packageSign");
        c9431oo.cKR.cKU = getIntent().getStringExtra("otherVerifyTitle");
        c9431oo.cKR.requestCode = 63;
        if (this.context instanceof Activity) {
            c9431oo.cKR.czX = (Activity) this.context;
        }
        C4879a.xxA.mo10055m(c9431oo);
        C4990ab.m7417i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", Boolean.valueOf(c9431oo.cKS.cKV));
        if (!c9431oo.cKS.cKV) {
            if (c9431oo.cKS.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(c9431oo.cKS.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.m2505o(747);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(748);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
        setResult(i2, intent);
        finish();
        AppMethodBeat.m2505o(748);
    }

    public final int getLayoutId() {
        return -1;
    }
}
