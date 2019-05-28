package com.tencent.p177mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver */
public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public C20797b mvX;
    public C20796a mvY;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver$a */
    public interface C20796a {
        /* renamed from: a */
        void mo17587a(State state);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver$b */
    public interface C20797b {
        /* renamed from: vS */
        void mo17579vS(int i);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(20729);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            AppMethodBeat.m2505o(20729);
            return;
        }
        String action = intent.getAction();
        C4990ab.m7417i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", action);
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
            AppMethodBeat.m2505o(20729);
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            C4990ab.m7417i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", Integer.valueOf(intent.getIntExtra("wifi_state", 0)));
            if (this.mvX != null) {
                this.mvX.mo17579vS(r0);
            }
            AppMethodBeat.m2505o(20729);
        } else {
            if (action.equals("android.net.wifi.STATE_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                if (parcelableExtra != null) {
                    NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                    if (!(networkInfo == null || this.mvY == null)) {
                        this.mvY.mo17587a(networkInfo.getState());
                    }
                }
            }
            AppMethodBeat.m2505o(20729);
        }
    }
}
