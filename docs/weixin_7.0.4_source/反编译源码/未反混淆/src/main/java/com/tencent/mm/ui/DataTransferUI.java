package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(19)
public class DataTransferUI extends MMBaseActivity {
    private p iGY;
    private long startTime = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29191);
        super.onCreate(bundle);
        ab.d("MicroMsg.DataTransferUI", "onCreate, timestamp = " + System.currentTimeMillis());
        this.startTime = System.currentTimeMillis();
        getString(R.string.tz);
        this.iGY = h.b((Context) this, getString(R.string.p1), false, null);
        new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(29190);
                if (DataTransferUI.this.iGY != null && DataTransferUI.this.iGY.isShowing()) {
                    ab.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
                    DataTransferUI.this.iGY.dismiss();
                    DataTransferUI.this.finish();
                }
                AppMethodBeat.o(29190);
            }
        }.sendEmptyMessageDelayed(0, 60000);
        aP(getIntent());
        AppMethodBeat.o(29191);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(29192);
        ab.d("MicroMsg.DataTransferUI", "onNewIntent, timestamp = " + System.currentTimeMillis());
        aP(intent);
        AppMethodBeat.o(29192);
    }

    private void aP(Intent intent) {
        AppMethodBeat.i(29193);
        boolean booleanExtra = intent.getBooleanExtra("finish_data_transfer", false);
        ab.d("MicroMsg.DataTransferUI", "tryFinish, timestamp = " + System.currentTimeMillis() + ", finish = " + booleanExtra);
        if (booleanExtra) {
            finish();
        }
        AppMethodBeat.o(29193);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(29194);
        ab.d("MicroMsg.DataTransferUI", "edw DataTransferUI duration time = " + (System.currentTimeMillis() - this.startTime));
        super.onPause();
        AppMethodBeat.o(29194);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(29195);
        super.onDestroy();
        ab.d("MicroMsg.DataTransferUI", "onDestroy");
        if (this.iGY != null && this.iGY.isShowing()) {
            this.iGY.dismiss();
        }
        AppMethodBeat.o(29195);
    }
}
