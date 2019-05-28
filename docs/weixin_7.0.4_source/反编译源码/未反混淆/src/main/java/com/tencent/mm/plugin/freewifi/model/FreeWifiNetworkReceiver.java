package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b mvX;
    public a mvY;

    public interface a {
        void a(State state);
    }

    public interface b {
        void vS(int i);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(20729);
        if (intent == null) {
            ab.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            AppMethodBeat.o(20729);
            return;
        }
        String action = intent.getAction();
        ab.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", action);
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
            AppMethodBeat.o(20729);
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            ab.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", Integer.valueOf(intent.getIntExtra("wifi_state", 0)));
            if (this.mvX != null) {
                this.mvX.vS(r0);
            }
            AppMethodBeat.o(20729);
        } else {
            if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                    if (!(networkInfo == null || this.mvY == null)) {
                        this.mvY.a(networkInfo.getState());
                    }
                }
            }
            AppMethodBeat.o(20729);
        }
    }
}
