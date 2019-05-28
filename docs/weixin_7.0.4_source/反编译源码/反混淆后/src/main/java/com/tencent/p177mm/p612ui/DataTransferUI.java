package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

@C5271a(19)
/* renamed from: com.tencent.mm.ui.DataTransferUI */
public class DataTransferUI extends MMBaseActivity {
    private C44275p iGY;
    private long startTime = 0;

    /* renamed from: com.tencent.mm.ui.DataTransferUI$1 */
    class C303221 extends C7306ak {
        C303221() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(29190);
            if (DataTransferUI.this.iGY != null && DataTransferUI.this.iGY.isShowing()) {
                C4990ab.m7412e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                DataTransferUI.this.iGY.dismiss();
                DataTransferUI.this.finish();
            }
            AppMethodBeat.m2505o(29190);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(29191);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(C25738R.string.f9238tz);
        this.iGY = C30379h.m48458b((Context) this, getString(C25738R.string.f9085p1), false, null);
        new C303221().sendEmptyMessageDelayed(0, 60000);
        m48290aP(getIntent());
        AppMethodBeat.m2505o(29191);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(29192);
        C4990ab.m7410d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        m48290aP(intent);
        AppMethodBeat.m2505o(29192);
    }

    /* renamed from: aP */
    private void m48290aP(Intent intent) {
        AppMethodBeat.m2504i(29193);
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        C4990ab.m7410d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
        AppMethodBeat.m2505o(29193);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(29194);
        C4990ab.m7410d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
        AppMethodBeat.m2505o(29194);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(29195);
        super.onDestroy();
        C4990ab.m7410d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.iGY != null && this.iGY.isShowing()) {
            this.iGY.dismiss();
        }
        AppMethodBeat.m2505o(29195);
    }
}
