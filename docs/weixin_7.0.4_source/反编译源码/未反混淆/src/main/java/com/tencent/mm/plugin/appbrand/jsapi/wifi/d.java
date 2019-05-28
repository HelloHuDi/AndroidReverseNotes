package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 314;
    public static final String NAME = "startWifi";
    public static boolean ide = false;
    public static BroadcastReceiver idf = null;

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94376);
        ab.i("MicroMsg.JsApiStartWifi", "invoke startWifi");
        final Context context = cVar.getContext();
        HashMap hashMap;
        if (context == null) {
            ab.e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            cVar.M(i, j("fail:context is null", hashMap));
            AppMethodBeat.o(94376);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.cP(context);
        if (!ide) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
            idf = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(94374);
                    if (intent == null) {
                        AppMethodBeat.o(94374);
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action)) {
                        AppMethodBeat.o(94374);
                        return;
                    }
                    int intExtra;
                    ab.i("MicroMsg.JsApiStartWifi", "actiong:%s", action);
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                        intExtra = intent.getIntExtra("wifi_state", 0);
                        ab.i("MicroMsg.JsApiStartWifi", "wifiState".concat(String.valueOf(intExtra)));
                        switch (intExtra) {
                            case 1:
                                d.x(cVar);
                                break;
                        }
                    }
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                        Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                        if (parcelableExtra != null) {
                            NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                            intExtra = networkInfo.getState() == State.CONNECTED ? 1 : 0;
                            int i;
                            if (networkInfo.getType() == 1) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (intExtra == 0 || i == 0) {
                                d.x(cVar);
                            } else {
                                b aGy = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d.aGy();
                                ab.i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", aGy);
                                if (aGy == null) {
                                    ab.e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                                    AppMethodBeat.o(94374);
                                    return;
                                }
                                try {
                                    a.a aVar = new a.a();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("wifi", aGy.toJSONObject());
                                    aVar.b(cVar, 0).t(hashMap).aCj();
                                    AppMethodBeat.o(94374);
                                    return;
                                } catch (JSONException e) {
                                    ab.e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                                    ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
                                    AppMethodBeat.o(94374);
                                    return;
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(94374);
                }
            };
            context.registerReceiver(idf, intentFilter);
            ide = true;
        }
        g.a(cVar.getAppId(), new g.c() {
            public final void onDestroy() {
                AppMethodBeat.i(94375);
                if (d.idf != null) {
                    ab.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
                    try {
                        context.unregisterReceiver(d.idf);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
                    }
                    d.ide = false;
                    d.idf = null;
                }
                g.b(cVar.getAppId(), this);
                AppMethodBeat.o(94375);
            }
        });
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(0));
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(94376);
    }

    static /* synthetic */ void x(c cVar) {
        AppMethodBeat.i(94377);
        try {
            a.a aVar = new a.a();
            HashMap hashMap = new HashMap();
            hashMap.put("wifi", new b().toJSONObject());
            aVar.b(cVar, 0).t(hashMap).aCj();
            AppMethodBeat.o(94377);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
            ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
            AppMethodBeat.o(94377);
        }
    }
}
