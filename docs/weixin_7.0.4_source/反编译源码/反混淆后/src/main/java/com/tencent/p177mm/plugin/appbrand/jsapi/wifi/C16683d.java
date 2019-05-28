package com.tencent.p177mm.plugin.appbrand.jsapi.wifi;

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
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.C19523a.C19527a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C19528b;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C27138d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.d */
public final class C16683d extends C10296a {
    public static final int CTRL_INDEX = 314;
    public static final String NAME = "startWifi";
    public static boolean ide = false;
    public static BroadcastReceiver idf = null;

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94376);
        C4990ab.m7416i("MicroMsg.JsApiStartWifi", "invoke startWifi");
        final Context context = c2241c.getContext();
        HashMap hashMap;
        if (context == null) {
            C4990ab.m7412e("MicroMsg.JsApiStartWifi", "mContext is null, invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            c2241c.mo6107M(i, mo73394j("fail:context is null", hashMap));
            AppMethodBeat.m2505o(94376);
            return;
        }
        C27138d.m43130cP(context);
        if (!ide) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
            idf = new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.m2504i(94374);
                    if (intent == null) {
                        AppMethodBeat.m2505o(94374);
                        return;
                    }
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action)) {
                        AppMethodBeat.m2505o(94374);
                        return;
                    }
                    int intExtra;
                    C4990ab.m7417i("MicroMsg.JsApiStartWifi", "actiong:%s", action);
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                        intExtra = intent.getIntExtra("wifi_state", 0);
                        C4990ab.m7416i("MicroMsg.JsApiStartWifi", "wifiState".concat(String.valueOf(intExtra)));
                        switch (intExtra) {
                            case 1:
                                C16683d.m25689x(c2241c);
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
                                C16683d.m25689x(c2241c);
                            } else {
                                C19528b aGy = C27138d.aGy();
                                C4990ab.m7417i("MicroMsg.JsApiStartWifi", "[mWiFiEventReceiver]currentWifi:%s", aGy);
                                if (aGy == null) {
                                    C4990ab.m7412e("MicroMsg.JsApiStartWifi", "[CONNECTIVITY_ACTION]currentWIfi is null");
                                    AppMethodBeat.m2505o(94374);
                                    return;
                                }
                                try {
                                    C19527a c19527a = new C19527a();
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("wifi", aGy.toJSONObject());
                                    c19527a.mo61030b(c2241c, 0).mo34958t(hashMap).aCj();
                                    AppMethodBeat.m2505o(94374);
                                    return;
                                } catch (JSONException e) {
                                    C4990ab.m7412e("MicroMsg.JsApiStartWifi", "IConnectWiFiCallback is error");
                                    C4990ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
                                    AppMethodBeat.m2505o(94374);
                                    return;
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(94374);
                }
            };
            context.registerReceiver(idf, intentFilter);
            ide = true;
        }
        C33183g.m54274a(c2241c.getAppId(), new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(94375);
                if (C16683d.idf != null) {
                    C4990ab.m7416i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
                    try {
                        context.unregisterReceiver(C16683d.idf);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
                    }
                    C16683d.ide = false;
                    C16683d.idf = null;
                }
                C33183g.m54276b(c2241c.getAppId(), this);
                AppMethodBeat.m2505o(94375);
            }
        });
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(0));
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(94376);
    }

    /* renamed from: x */
    static /* synthetic */ void m25689x(C2241c c2241c) {
        AppMethodBeat.m2504i(94377);
        try {
            C19527a c19527a = new C19527a();
            HashMap hashMap = new HashMap();
            hashMap.put("wifi", new C19528b().toJSONObject());
            c19527a.mo61030b(c2241c, 0).mo34958t(hashMap).aCj();
            AppMethodBeat.m2505o(94377);
        } catch (JSONException e) {
            C4990ab.m7412e("MicroMsg.JsApiStartWifi", "mWiFiEventReceiver is error");
            C4990ab.printErrStackTrace("MicroMsg.JsApiStartWifi", e, "", new Object[0]);
            AppMethodBeat.m2505o(94377);
        }
    }
}
