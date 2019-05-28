package com.tencent.p177mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;

/* renamed from: com.tencent.mm.booter.f */
public final class C32424f {
    NetworkInfo ebY = null;
    private String ebZ = "";
    private String eca = "";
    private int ecb = -1;

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0094=Splitter:B:31:0x0094, B:54:0x0169=Splitter:B:54:0x0169} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Il */
    public final boolean mo53065Il() {
        AppMethodBeat.m2504i(57779);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) C1892aa.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                C4990ab.m7420w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.ebY = null;
                AppMethodBeat.m2505o(57779);
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                C4990ab.m7420w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.ebY = null;
                AppMethodBeat.m2505o(57779);
                return false;
            }
            WifiInfo wifiInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                wifiInfo = C5023at.getWifiInfo(C4996ah.getContext());
                if (wifiInfo != null && this.eca.equals(wifiInfo.getBSSID()) && this.ebZ.equals(C5023at.m7474gE(C4996ah.getContext())) && this.ecb == wifiInfo.getNetworkId()) {
                    C4990ab.m7420w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    AppMethodBeat.m2505o(57779);
                    return false;
                }
                C4990ab.m7411d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s %s %s", wifiInfo.getBSSID(), C5023at.m7474gE(C4996ah.getContext()), Integer.valueOf(wifiInfo.getNetworkId()));
                C4990ab.m7411d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s %s %s", this.eca, this.ebZ, Integer.valueOf(this.ecb));
            } else if (this.ebY != null && this.ebY.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.ebY.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                C4990ab.m7420w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.m2505o(57779);
                return false;
            } else if (this.ebY != null && this.ebY.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.ebY.getSubtype() == activeNetworkInfo.getSubtype() && this.ebY.getType() == activeNetworkInfo.getType()) {
                C4990ab.m7420w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                AppMethodBeat.m2505o(57779);
                return false;
            } else {
                wifiInfo = null;
            }
            if (i == 0) {
                C4990ab.m7411d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.ebY != null) {
                    C4990ab.m7411d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.ebY);
                }
            }
            this.ebY = activeNetworkInfo;
            this.eca = wifiInfo.getBSSID();
            this.ebZ = C5023at.m7474gE(C4996ah.getContext());
            this.ecb = wifiInfo.getNetworkId();
            AppMethodBeat.m2505o(57779);
            return true;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.NetworkChangeMgr", e2, "", new Object[0]);
        }
    }
}
