package com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C30800f;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.C27044a.C270481;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Timer;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCETransparentUI */
public class HCETransparentUI extends Activity {
    /* renamed from: JF */
    private ResultReceiver f16150JF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(137929);
        super.onCreate(bundle);
        setContentView(2130969815);
        this.f16150JF = (ResultReceiver) getIntent().getParcelableExtra("HCE_Result_Receiver");
        C27044a c27044a = C27044a.hSt;
        ResultReceiver resultReceiver = this.f16150JF;
        C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
        if (resultReceiver == null) {
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
        }
        c27044a.hSq = this;
        c27044a.f13674JF = resultReceiver;
        c27044a = C27044a.hSt;
        c27044a.hSl = false;
        c27044a.hSm = false;
        c27044a.hSk = false;
        AppMethodBeat.m2505o(137929);
    }

    /* Access modifiers changed, original: protected */
    public void onResume() {
        AppMethodBeat.m2504i(137930);
        super.onResume();
        C4990ab.m7416i("MicroMsg.HCETransparentUI", "alvinluo onResume");
        ComponentName componentName = new ComponentName(this, HCEService.class.getCanonicalName());
        C27044a c27044a = C27044a.hSt;
        C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
        c27044a.hSp = componentName;
        C27044a c27044a2 = C27044a.hSt;
        if (c27044a2.hSl) {
            c27044a2.hSo = new C270481();
            c27044a2.hSn = new Timer();
            c27044a2.hSn.scheduleAtFixedRate(c27044a2.hSo, 0, 300);
            if (c27044a2.hSq != null) {
                c27044a2.hSr = C30800f.m49147g(c27044a2.hSq, c27044a2.hSq.getString(C25738R.string.cub));
                AppMethodBeat.m2505o(137930);
                return;
            }
            C4990ab.m7412e("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
            AppMethodBeat.m2505o(137930);
            return;
        }
        c27044a2.aEu();
        AppMethodBeat.m2505o(137930);
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(137931);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.HCETransparentUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        C27044a c27044a = C27044a.hSt;
        if (i == 1) {
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
            c27044a.hSl = true;
            AppMethodBeat.m2505o(137931);
            return;
        }
        if (i == 2) {
            C4990ab.m7416i("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
        }
        AppMethodBeat.m2505o(137931);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        AppMethodBeat.m2504i(137932);
        super.onPause();
        C27044a.hSt.dismissDialog();
        AppMethodBeat.m2505o(137932);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
        AppMethodBeat.m2504i(137933);
        super.onDestroy();
        AppMethodBeat.m2505o(137933);
    }
}
