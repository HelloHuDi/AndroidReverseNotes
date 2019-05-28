package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class WiFiConnector$2 extends BroadcastReceiver {
    final /* synthetic */ a idB;

    public WiFiConnector$2(a aVar) {
        this.idB = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(94388);
        if (intent == null) {
            AppMethodBeat.o(94388);
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            AppMethodBeat.o(94388);
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            NetworkInfo activeNetworkInfo = this.idB.idx.getActiveNetworkInfo();
            WifiInfo connectionInfo = c.getConnectionInfo();
            if (activeNetworkInfo != null && connectionInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.getDetailedState() == DetailedState.CONNECTED && connectionInfo.getNetworkId() == this.idB.idw.networkId) {
                this.idB.i(true, "");
                ab.i("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
            }
            AppMethodBeat.o(94388);
        } else {
            if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
                int intExtra;
                try {
                    intExtra = intent.getIntExtra("supplicantError", -1);
                } catch (Exception e) {
                    ab.e("MicroMsg.WiFiConnector", e.getMessage());
                    intExtra = -1;
                }
                if (intExtra == 1) {
                    ab.e("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
                    ab.i("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
                    a aVar = this.idB;
                    if (this.idB.idA) {
                        action = "wifi config may be expired";
                    } else {
                        action = "password error";
                    }
                    aVar.i(false, action);
                }
            }
            AppMethodBeat.o(94388);
        }
    }
}
