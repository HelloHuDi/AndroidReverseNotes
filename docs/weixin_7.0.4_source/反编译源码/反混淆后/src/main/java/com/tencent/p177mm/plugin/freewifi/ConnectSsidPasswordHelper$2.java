package com.tencent.p177mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C28073c.C119562;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.ConnectSsidPasswordHelper$2 */
public class ConnectSsidPasswordHelper$2 extends BroadcastReceiver {
    final /* synthetic */ C28073c mtJ;

    public ConnectSsidPasswordHelper$2(C28073c c28073c) {
        this.mtJ = c28073c;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(20566);
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                C4990ab.m7417i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.mtJ.ssid, C34189m.m56059Mx("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.mtJ.ssid.equals(C34189m.m56057Mv(networkInfo.getExtraInfo()))) {
                try {
                    this.mtJ.aCZ.lock();
                    this.mtJ.connected = true;
                    this.mtJ.mtH = false;
                    this.mtJ.cbS.signalAll();
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
                    return;
                } finally {
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    AppMethodBeat.m2505o(20566);
                }
            } else {
                AppMethodBeat.m2505o(20566);
                return;
            }
        }
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction())) {
            switch (C119562.mtK[((SupplicantState) intent.getParcelableExtra("newState")).ordinal()]) {
                case 1:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
                    break;
                case 2:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
                    break;
                case 3:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
                    break;
                case 4:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
                    break;
                case 5:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
                    break;
                case 6:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
                    break;
                case 7:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
                    break;
                case 8:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
                    break;
                case 9:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
                    break;
                case 10:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
                    break;
                case 11:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
                    break;
                case 12:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
                    break;
                case 13:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
                    break;
                default:
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
                    break;
            }
            if (intent.getIntExtra("supplicantError", -1) == 1) {
                try {
                    this.mtJ.aCZ.lock();
                    this.mtJ.connected = false;
                    this.mtJ.mtH = true;
                    this.mtJ.cbS.signalAll();
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    C4990ab.m7416i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "ERROR_AUTHENTICATING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } catch (Throwable th) {
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    AppMethodBeat.m2505o(20566);
                }
            }
        }
        AppMethodBeat.m2505o(20566);
    }
}
