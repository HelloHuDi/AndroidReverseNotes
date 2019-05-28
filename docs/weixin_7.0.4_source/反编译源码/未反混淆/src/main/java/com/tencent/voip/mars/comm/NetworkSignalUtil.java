package com.tencent.voip.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetworkSignalUtil {
    public static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static Context context = null;
    private static long strength = 10000;

    static /* synthetic */ void access$000(SignalStrength signalStrength) {
        AppMethodBeat.i(92749);
        calSignalStrength(signalStrength);
        AppMethodBeat.o(92749);
    }

    public static void InitNetworkSignalUtil(Context context) {
        AppMethodBeat.i(92746);
        context = context;
        try {
            ((TelephonyManager) context.getSystemService("phone")).listen(new PhoneStateListener() {
                public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                    AppMethodBeat.i(92789);
                    super.onSignalStrengthsChanged(signalStrength);
                    NetworkSignalUtil.access$000(signalStrength);
                    AppMethodBeat.o(92789);
                }
            }, 256);
            AppMethodBeat.o(92746);
        } catch (ArrayIndexOutOfBoundsException e) {
            AppMethodBeat.o(92746);
        }
    }

    public static long getNetworkSignalStrength(boolean z) {
        return 0;
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getWifiSignalStrength() {
        AppMethodBeat.i(92747);
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null) {
            AppMethodBeat.o(92747);
            return 0;
        }
        int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 10);
        if (calculateSignalLevel > 10) {
            calculateSignalLevel = 10;
        }
        if (calculateSignalLevel < 0) {
            calculateSignalLevel = 0;
        }
        long j = (long) (calculateSignalLevel * 10);
        AppMethodBeat.o(92747);
        return j;
    }

    private static void calSignalStrength(SignalStrength signalStrength) {
        int gsmSignalStrength;
        long j;
        AppMethodBeat.i(92748);
        if (signalStrength.isGsm()) {
            gsmSignalStrength = signalStrength.getGsmSignalStrength();
        } else {
            gsmSignalStrength = (signalStrength.getCdmaDbm() + 113) / 2;
        }
        if (signalStrength.isGsm() && gsmSignalStrength == 99) {
            j = 0;
        } else {
            j = (long) (((float) gsmSignalStrength) * 3.2258065f);
            strength = j;
            j = j > 100 ? 100 : strength;
            strength = j;
            j = j < 0 ? 0 : strength;
        }
        strength = j;
        AppMethodBeat.o(92748);
    }
}
