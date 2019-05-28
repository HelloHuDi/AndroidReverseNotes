package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class FaceTransStubUI extends MMActivity {
    private Context context = this;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FaceTransStubUI() {
        AppMethodBeat.i(746);
        AppMethodBeat.o(746);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(747);
        super.onCreate(bundle);
        ab.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
        oo ooVar = new oo();
        ooVar.cKR.scene = getIntent().getIntExtra("scene", 0);
        ooVar.cKR.packageName = getIntent().getStringExtra("package");
        ooVar.cKR.cKT = getIntent().getStringExtra("packageSign");
        ooVar.cKR.cKU = getIntent().getStringExtra("otherVerifyTitle");
        ooVar.cKR.requestCode = 63;
        if (this.context instanceof Activity) {
            ooVar.cKR.czX = (Activity) this.context;
        }
        com.tencent.mm.sdk.b.a.xxA.m(ooVar);
        ab.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", Boolean.valueOf(ooVar.cKS.cKV));
        if (!ooVar.cKS.cKV) {
            if (ooVar.cKS.extras != null) {
                Intent intent = new Intent();
                intent.putExtras(ooVar.cKS.extras);
                setResult(1, intent);
            } else {
                setResult(1);
            }
            finish();
        }
        AppMethodBeat.o(747);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(748);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(748);
    }

    public final int getLayoutId() {
        return -1;
    }
}
