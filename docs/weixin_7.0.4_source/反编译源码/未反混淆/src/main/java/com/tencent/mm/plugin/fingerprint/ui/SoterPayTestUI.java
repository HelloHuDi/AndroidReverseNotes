package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.e;

public class SoterPayTestUI extends MMActivity implements f {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41664);
        super.onCreate(bundle);
        findViewById(R.id.btr).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41662);
                ab.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
                g.RQ();
                g.RO().eJo.a(1586, SoterPayTestUI.this);
                g.RQ();
                g.RO().eJo.a(new a(0), 0);
                AppMethodBeat.o(41662);
            }
        });
        findViewById(R.id.bts).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41663);
                ab.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
                com.tencent.soter.a.a.a(new b<c>() {
                    public final /* bridge */ /* synthetic */ void a(e eVar) {
                    }
                }, false, null);
                AppMethodBeat.o(41663);
            }
        });
        findViewById(R.id.btt).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        AppMethodBeat.o(41664);
    }

    public final int getLayoutId() {
        return R.layout.zw;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41665);
        ab.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        t.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}), 1).show();
        g.RQ();
        g.RO().eJo.b(mVar.getType(), (f) this);
        AppMethodBeat.o(41665);
    }
}
