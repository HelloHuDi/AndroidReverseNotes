package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d.C26944a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.BleScanWorker$3 */
public class BleScanWorker$3 extends BroadcastReceiver {
    final /* synthetic */ C26945a hFl;

    public BleScanWorker$3(C26945a c26945a) {
        this.hFl = c26945a;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(94288);
        if (intent == null) {
            C4990ab.m7416i("MicroMsg.Ble.BleScanWorker", "Receive intent failed");
            AppMethodBeat.m2505o(94288);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            C4990ab.m7411d("MicroMsg.Ble.BleScanWorker", "state:%d", Integer.valueOf(state));
            if (!(state == 12 || state == 11 || (state != 10 && state != 13))) {
                C26944a.m42897i("MicroMsg.Ble.BleScanWorker", "bluetooth is disable, stop scan", new Object[0]);
                this.hFl.hFh.set(false);
                this.hFl.aCU();
            }
        }
        AppMethodBeat.m2505o(94288);
    }
}
