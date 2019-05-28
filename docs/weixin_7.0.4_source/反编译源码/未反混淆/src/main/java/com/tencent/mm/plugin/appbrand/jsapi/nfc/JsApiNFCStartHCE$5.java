package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

class JsApiNFCStartHCE$5 extends ResultReceiver {
    final /* synthetic */ d hSh;

    JsApiNFCStartHCE$5(d dVar, Handler handler) {
        this.hSh = dVar;
        super(handler);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.i(137876);
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver resultCode: %d", Integer.valueOf(i));
        if (bundle == null || i != 10002) {
            AppMethodBeat.o(137876);
            return;
        }
        int i2 = bundle.getInt("key_event_type", -1);
        String string = bundle.getString("key_appid");
        int i3 = bundle.getInt("errCode", -1);
        String string2 = bundle.getString("errMsg");
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mHCEServiceResultReceiver onReceiveResult eventType: %d, appId: %s", Integer.valueOf(i2), string);
        switch (i2) {
            case 12:
                if (bundle != null) {
                    boolean z;
                    d dVar = this.hSh;
                    synchronized (dVar.mLock) {
                        try {
                            z = dVar.eTM;
                            if (!z) {
                                dVar.eTM = true;
                            }
                        } finally {
                            while (true) {
                                AppMethodBeat.o(137876);
                                break;
                            }
                        }
                    }
                    if (z) {
                        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEFinish has finished, return");
                        return;
                    } else if (HCEEventLogic.aEt()) {
                        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                        AppMethodBeat.o(137876);
                        return;
                    } else {
                        HashMap hashMap = new HashMap();
                        int currentTimeMillis = (int) (System.currentTimeMillis() - dVar.mStartTime);
                        if (dVar.mTimer != null) {
                            ab.d("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE timer cancel");
                            dVar.mTimer.cancel();
                        }
                        if (string == null || string.equals(dVar.hzz.getAppId())) {
                            ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo HCE start HCEService callback onRefreshed errCode: %d, errMsg: %s", Integer.valueOf(i3), string2);
                            if (i3 == 0) {
                                HCEEventLogic.BE(dVar.hzz.getAppId());
                                hashMap.put("errCode", Integer.valueOf(0));
                                dVar.AR(dVar.j("ok", hashMap));
                            } else {
                                hashMap.put("errCode", Integer.valueOf(i3));
                                dVar.AR(dVar.j("fail: ".concat(String.valueOf(string2)), hashMap));
                            }
                            c.G(dVar.hzz.getAppId(), i3, currentTimeMillis);
                            HCEEventLogic.eo(true);
                            break;
                        }
                        ab.e("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCESevice callback appId invalid, appId: %s", string);
                        hashMap.put("errCode", Integer.valueOf(13010));
                        c.G(dVar.hzz.getAppId(), 13010, currentTimeMillis);
                        dVar.AR(dVar.j("fail: unknown error", hashMap));
                        AppMethodBeat.o(137876);
                        return;
                    }
                }
                break;
            case 31:
            case 41:
                a.a(this.hSh.hzz, i2, bundle);
                AppMethodBeat.o(137876);
                return;
        }
        AppMethodBeat.o(137876);
    }
}
