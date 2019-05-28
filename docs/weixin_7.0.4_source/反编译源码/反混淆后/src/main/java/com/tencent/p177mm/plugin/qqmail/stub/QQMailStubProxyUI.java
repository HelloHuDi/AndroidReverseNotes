package com.tencent.p177mm.plugin.qqmail.stub;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.qqmail.p487ui.C12925c;
import com.tencent.p177mm.plugin.qqmail.p487ui.C12925c.C12927a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI */
public class QQMailStubProxyUI extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68078);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        final C12925c c12925c = new C12925c(this);
        c12925c.mo24951a(new C12927a() {
            public final void ccF() {
                AppMethodBeat.m2504i(68076);
                C4990ab.m7410d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
                c12925c.release();
                QQMailStubProxyUI.this.setResult(-1);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.m2505o(68076);
            }

            public final void ccG() {
                AppMethodBeat.m2504i(68077);
                C4990ab.m7412e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
                c12925c.release();
                QQMailStubProxyUI.this.setResult(0);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.m2505o(68077);
            }
        });
        AppMethodBeat.m2505o(68078);
    }
}
