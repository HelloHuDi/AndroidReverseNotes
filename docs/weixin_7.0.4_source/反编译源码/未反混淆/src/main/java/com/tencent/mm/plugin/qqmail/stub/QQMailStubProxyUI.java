package com.tencent.mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68078);
        super.onCreate(bundle);
        ab.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        final c cVar = new c(this);
        cVar.a(new c.a() {
            public final void ccF() {
                AppMethodBeat.i(68076);
                ab.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
                cVar.release();
                QQMailStubProxyUI.this.setResult(-1);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.o(68076);
            }

            public final void ccG() {
                AppMethodBeat.i(68077);
                ab.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
                cVar.release();
                QQMailStubProxyUI.this.setResult(0);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.o(68077);
            }
        });
        AppMethodBeat.o(68078);
    }
}
