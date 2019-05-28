package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class f {
    NetworkInfo ebY = null;
    private String ebZ = "";
    private String eca = "";
    private int ecb = -1;

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0094=Splitter:B:31:0x0094, B:54:0x0169=Splitter:B:54:0x0169} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Il() {
        AppMethodBeat.i(57779);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) aa.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                ab.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.ebY = null;
                AppMethodBeat.o(57779);
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                ab.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                ab.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.ebY = null;
                AppMethodBeat.o(57779);
                return false;
            }
            WifiInfo wifiInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                wifiInfo = at.getWifiInfo(ah.getContext());
                if (wifiInfo != null && this.eca.equals(wifiInfo.getBSSID()) && this.ebZ.equals(at.gE(ah.getContext())) && this.ecb == wifiInfo.getNetworkId()) {
                    ab.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    AppMethodBeat.o(57779);
                    return false;
                }
                ab.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s %s %s", wifiInfo.getBSSID(), at.gE(ah.getContext()), Integer.valueOf(wifiInfo.getNetworkId()));
                ab.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s %s %s", this.eca, this.ebZ, Integer.valueOf(this.ecb));
            } else if (this.ebY != null && this.ebY.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.ebY.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                ab.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.o(57779);
                return false;
            } else if (this.ebY != null && this.ebY.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                ab.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.o(57779);
                return false;
            } else {
                wifiInfo = null;
            }
            if (i == 0) {
                ab.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.ebY != null) {
                    ab.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.ebY);
                }
            }
            this.ebY = activeNetworkInfo;
            this.eca = wifiInfo.getBSSID();
            this.ebZ = at.gE(ah.getContext());
            this.ecb = wifiInfo.getNetworkId();
            AppMethodBeat.o(57779);
            return true;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.NetworkChangeMgr", e2, "", new Object[0]);
        }
    }
}
