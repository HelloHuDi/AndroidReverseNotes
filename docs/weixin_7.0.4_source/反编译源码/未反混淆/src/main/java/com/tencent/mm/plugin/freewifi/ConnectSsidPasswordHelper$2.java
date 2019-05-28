package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.c.AnonymousClass2;
import com.tencent.mm.sdk.platformtools.ab;

public class ConnectSsidPasswordHelper$2 extends BroadcastReceiver {
    final /* synthetic */ c mtJ;

    public ConnectSsidPasswordHelper$2(c cVar) {
        this.mtJ = cVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(20566);
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s, networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.mtJ.ssid, m.Mx("MicroMsg.FreeWifi.ConnectSsidPasswordHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.mtJ.ssid.equals(m.Mv(networkInfo.getExtraInfo()))) {
                try {
                    this.mtJ.aCZ.lock();
                    this.mtJ.connected = true;
                    this.mtJ.mtH = false;
                    this.mtJ.cbS.signalAll();
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect successs! signal success!");
                    return;
                } finally {
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    AppMethodBeat.o(20566);
                }
            } else {
                AppMethodBeat.o(20566);
                return;
            }
        }
        if ("android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction())) {
            switch (AnonymousClass2.mtK[((SupplicantState) intent.getParcelableExtra("newState")).ordinal()]) {
                case 1:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATED");
                    break;
                case 2:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, ASSOCIATING");
                    break;
                case 3:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Authenticating...");
                    break;
                case 4:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Connected");
                    break;
                case 5:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Disconnected");
                    break;
                case 6:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, DORMANT");
                    break;
                case 7:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, FOUR_WAY_HANDSHAKE");
                    break;
                case 8:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, GROUP_HANDSHAKE");
                    break;
                case 9:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INACTIVE");
                    break;
                case 10:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INTERFACE_DISABLED");
                    break;
                case 11:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, INVALID");
                    break;
                case 12:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, SCANNING");
                    break;
                case 13:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, UNINITIALIZED");
                    break;
                default:
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "SupplicantState, Unknown");
                    break;
            }
            if (intent.getIntExtra("supplicantError", -1) == 1) {
                try {
                    this.mtJ.aCZ.lock();
                    this.mtJ.connected = false;
                    this.mtJ.mtH = true;
                    this.mtJ.cbS.signalAll();
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "WifiManager connect AUTHENTICATING error! signal error!");
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    ab.i("MicroMsg.FreeWifi.ConnectSsidPasswordHelper", "ERROR_AUTHENTICATING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } catch (Throwable th) {
                    this.mtJ.byc();
                    this.mtJ.aCZ.unlock();
                    AppMethodBeat.o(20566);
                }
            }
        }
        AppMethodBeat.o(20566);
    }
}
