package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends JsApiAppBrandNFCBase {
    public static final int CTRL_INDEX = 352;
    public static final String NAME = "startHCE";
    private JSONObject bOf;
    private int bOs = -1;
    boolean eTM = false;
    Activity gNy = null;
    private Class<?> hSd = null;
    Class<?> hSe = null;
    private int hSf;
    private ResultReceiver hSg = new JsApiNFCStartHCE$5(this, ak.fetchFreeHandler(Looper.getMainLooper()));
    c hzz = null;
    final Object mLock = new Object();
    long mStartTime = -1;
    Timer mTimer;

    public d(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(137877);
        this.hSd = cls;
        this.hSe = cls2;
        AppMethodBeat.o(137877);
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137878);
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", jSONObject.toString());
        this.hzz = cVar;
        this.bOs = i;
        this.bOf = jSONObject;
        synchronized (this.mLock) {
            try {
                this.eTM = false;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(137878);
                }
            }
        }
        if (this.hSd == null || this.hSe == null) {
            AR(j("fail: HostApduService or HCETransparentUI is nil", null));
            AppMethodBeat.o(137878);
            return;
        }
        this.hSf = this.bOf.optInt("time_limit", 1500);
        a(new a() {
            public final void T(int i, String str) {
                AppMethodBeat.i(137872);
                HashMap hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(i));
                if (i == 0) {
                    d dVar = d.this;
                    if (dVar.hzz.getContext() instanceof Activity) {
                        dVar.gNy = (Activity) dVar.hzz.getContext();
                        Intent intent = new Intent(dVar.gNy, dVar.hSe);
                        intent.putExtra("HCE_Result_Receiver", new JsApiNFCStartHCE$2(dVar, ak.fetchFreeHandler(Looper.getMainLooper())));
                        dVar.gNy.startActivity(intent);
                        AppMethodBeat.o(137872);
                        return;
                    }
                    dVar.AR(dVar.j("fail: unknown error", null));
                    AppMethodBeat.o(137872);
                    return;
                }
                com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.G(d.this.hzz.getAppId(), i, -1);
                d.this.AR(d.this.j("fail: ".concat(String.valueOf(str)), hashMap));
                AppMethodBeat.o(137872);
            }
        });
        AppMethodBeat.o(137878);
    }

    /* Access modifiers changed, original: final */
    public final void AR(String str) {
        AppMethodBeat.i(137879);
        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", str);
        if (this.hzz != null) {
            this.hzz.M(this.bOs, str);
        }
        AppMethodBeat.o(137879);
    }

    /* Access modifiers changed, original: final */
    public final void onSuccess() {
        AppMethodBeat.i(137880);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = this.bOf.getJSONArray("aid_list");
            ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", this.bOf.toString(), jSONArray.toString(), Integer.valueOf(jSONArray.length()));
            for (int i = 0; i < r5; i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            g.a(this.hzz.getAppId(), new g.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(137874);
                    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
                    HCEEventLogic.eo(true);
                    AppMethodBeat.o(137874);
                }
            });
            Intent intent = new Intent(this.gNy, this.hSd);
            intent.putExtra("HCE_Result_Receiver", this.hSg);
            intent.putExtra("key_appid", this.hzz.getAppId());
            intent.putExtra("key_time_limit", this.hSf);
            intent.putStringArrayListExtra("key_aid_list", arrayList);
            HCEEventLogic.eo(false);
            this.gNy.startService(intent);
            this.mStartTime = System.currentTimeMillis();
            AnonymousClass3 anonymousClass3 = new TimerTask() {
                public final void run() {
                    boolean z;
                    AppMethodBeat.i(137875);
                    d dVar = d.this;
                    synchronized (dVar.mLock) {
                        try {
                            z = dVar.eTM;
                            if (!z) {
                                dVar.eTM = true;
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(137875);
                        }
                    }
                    if (z) {
                        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
                    } else if (HCEEventLogic.aEt()) {
                        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
                        AppMethodBeat.o(137875);
                    } else {
                        ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", Integer.valueOf(10));
                        HCEEventLogic.eo(true);
                        if (dVar.hzz != null) {
                            com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.G(dVar.hzz.getAppId(), 13007, -2);
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(13007));
                        dVar.AR(dVar.j("fail: start HCEService failed", hashMap));
                        AppMethodBeat.o(137875);
                    }
                }
            };
            this.mTimer = new Timer();
            this.mTimer.schedule(anonymousClass3, 10000);
            AppMethodBeat.o(137880);
        } catch (Exception e) {
            hashMap.put("errCode", Integer.valueOf(13003));
            AR(j("fail: aid_list invalid", hashMap));
            com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.G(this.hzz.getAppId(), 13003, -1);
            AppMethodBeat.o(137880);
        }
    }
}
