package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector$2 */
public class WiFiConnector$2 extends BroadcastReceiver {
    final /* synthetic */ C38407a idB;

    public WiFiConnector$2(C38407a c38407a) {
        this.idB = c38407a;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(94388);
        if (intent == null) {
            AppMethodBeat.m2505o(94388);
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            AppMethodBeat.m2505o(94388);
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            NetworkInfo activeNetworkInfo = this.idB.idx.getActiveNetworkInfo();
            WifiInfo connectionInfo = C27140c.getConnectionInfo();
            if (activeNetworkInfo != null && connectionInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.getDetailedState() == DetailedState.CONNECTED && connectionInfo.getNetworkId() == this.idB.idw.networkId) {
                this.idB.mo61116i(true, "");
                C4990ab.m7416i("MicroMsg.wifi_event", "CONNECTIVITY_ACTION CONNECTED.");
            }
            AppMethodBeat.m2505o(94388);
        } else {
            if ("android.net.wifi.supplicant.STATE_CHANGE".equals(action)) {
                int intExtra;
                try {
                    intExtra = intent.getIntExtra("supplicantError", -1);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.WiFiConnector", e.getMessage());
                    intExtra = -1;
                }
                if (intExtra == 1) {
                    C4990ab.m7412e("MicroMsg.WiFiConnector", "ERROR_AUTHENTICATING");
                    C4990ab.m7416i("MicroMsg.wifi_event", "ERROR_AUTHENTICATING FAIL.");
                    C38407a c38407a = this.idB;
                    if (this.idB.idA) {
                        action = "wifi config may be expired";
                    } else {
                        action = "password error";
                    }
                    c38407a.mo61116i(false, action);
                }
            }
            AppMethodBeat.m2505o(94388);
        }
    }
}
