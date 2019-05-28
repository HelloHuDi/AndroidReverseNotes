package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.f;
import java.util.Timer;
import java.util.TimerTask;

@a(7)
public class HCETransparentUI extends Activity {
    private ResultReceiver JF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(137929);
        super.onCreate(bundle);
        setContentView(R.layout.a6o);
        this.JF = (ResultReceiver) getIntent().getParcelableExtra("HCE_Result_Receiver");
        a aVar = a.hSt;
        ResultReceiver resultReceiver = this.JF;
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
        if (resultReceiver == null) {
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
        }
        aVar.hSq = this;
        aVar.JF = resultReceiver;
        aVar = a.hSt;
        aVar.hSl = false;
        aVar.hSm = false;
        aVar.hSk = false;
        AppMethodBeat.o(137929);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.i(137930);
        super.onResume();
        ab.i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        ComponentName componentName = new ComponentName(this, HCEService.class.getCanonicalName());
        a aVar = a.hSt;
        ab.i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
        aVar.hSp = componentName;
        a aVar2 = a.hSt;
        if (aVar2.hSl) {
            aVar2.hSo = new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(137885);
                    ab.i("MicroMsg.HCEActivityMgr", "alvinluo loop check NFC switch currentCount: %d", Integer.valueOf(a.this.hSj));
                    a.this.hSj = a.this.hSj + 1;
                    m.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(137884);
                            if (a.this.hSj > 10) {
                                ab.i("MicroMsg.HCEActivityMgr", "alvinluo loop check count exceed max limit: %d", Integer.valueOf(10));
                                a.c(a.this);
                                a.d(a.this);
                                AppMethodBeat.o(137884);
                                return;
                            }
                            if (d.aEC()) {
                                ab.i("MicroMsg.HCEActivityMgr", "alvinluo loopCheck NFC switch is opened, and cancel task");
                                a.c(a.this);
                                a.e(a.this);
                            }
                            AppMethodBeat.o(137884);
                        }
                    });
                    AppMethodBeat.o(137885);
                }
            };
            aVar2.hSn = new Timer();
            aVar2.hSn.scheduleAtFixedRate(aVar2.hSo, 0, 300);
            if (aVar2.hSq != null) {
                aVar2.hSr = f.g(aVar2.hSq, aVar2.hSq.getString(R.string.cub));
                AppMethodBeat.o(137930);
                return;
            }
            ab.e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
            AppMethodBeat.o(137930);
            return;
        }
        aVar2.aEu();
        AppMethodBeat.o(137930);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(137931);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        a aVar = a.hSt;
        if (i == 1) {
            ab.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            aVar.hSl = true;
            AppMethodBeat.o(137931);
            return;
        }
        if (i == 2) {
            ab.i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
        AppMethodBeat.o(137931);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.i(137932);
        super.onPause();
        a.hSt.dismissDialog();
        AppMethodBeat.o(137932);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.i(137933);
        super.onDestroy();
        AppMethodBeat.o(137933);
    }
}
