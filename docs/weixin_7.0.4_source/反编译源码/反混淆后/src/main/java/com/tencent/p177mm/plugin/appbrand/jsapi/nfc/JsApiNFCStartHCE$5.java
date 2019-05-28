package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33383c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiNFCStartHCE$5 */
class JsApiNFCStartHCE$5 extends ResultReceiver {
    final /* synthetic */ C33381d hSh;

    JsApiNFCStartHCE$5(C33381d c33381d, Handler handler) {
        this.hSh = c33381d;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.m2504i(137876);
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", Integer.valueOf(i));
        if (bundle == null || i != 10002) {
            AppMethodBeat.m2505o(137876);
            return;
        }
        int i2 = bundle.getInt("key_event_type", -1);
        String string = bundle.getString("key_appid");
        int i3 = bundle.getInt("errCode", -1);
        String string2 = bundle.getString("errMsg");
        C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", Integer.valueOf(i2), string);
        switch (i2) {
            case 12:
                if (bundle != null) {
                    boolean z;
                    C33381d c33381d = this.hSh;
                    synchronized (c33381d.mLock) {
                        try {
                            z = c33381d.eTM;
                            if (!z) {
                                c33381d.eTM = true;
                            }
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(137876);
                                break;
                            }
                        }
                    }
                    if (z) {
                        C4990ab.m7416i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
                        return;
                    } else if (HCEEventLogic.aEt()) {
                        C4990ab.m7416i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                        AppMethodBeat.m2505o(137876);
                        return;
                    } else {
                        HashMap hashMap = new HashMap();
                        int currentTimeMillis = (int) (System.currentTimeMillis() - c33381d.mStartTime);
                        if (c33381d.mTimer != null) {
                            C4990ab.m7410d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
                            c33381d.mTimer.cancel();
                        }
                        if (string == null || string.equals(c33381d.hzz.getAppId())) {
                            C4990ab.m7417i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", Integer.valueOf(i3), string2);
                            if (i3 == 0) {
                                HCEEventLogic.m75348BE(c33381d.hzz.getAppId());
                                hashMap.put("errCode", Integer.valueOf(0));
                                c33381d.mo53857AR(c33381d.mo73394j("ok", hashMap));
                            } else {
                                hashMap.put("errCode", Integer.valueOf(i3));
                                c33381d.mo53857AR(c33381d.mo73394j("fail: ".concat(String.valueOf(string2)), hashMap));
                            }
                            C33383c.m54578G(c33381d.hzz.getAppId(), i3, currentTimeMillis);
                            HCEEventLogic.m75351eo(true);
                            break;
                        }
                        C4990ab.m7413e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", string);
                        hashMap.put("errCode", Integer.valueOf(13010));
                        C33383c.m54578G(c33381d.hzz.getAppId(), 13010, currentTimeMillis);
                        c33381d.mo53857AR(c33381d.mo73394j("fail: unknown error", hashMap));
                        AppMethodBeat.m2505o(137876);
                        return;
                    }
                }
                break;
            case 31:
            case 41:
                C45609a.m84185a(this.hSh.hzz, i2, bundle);
                AppMethodBeat.m2505o(137876);
                return;
        }
        AppMethodBeat.m2505o(137876);
    }
}
