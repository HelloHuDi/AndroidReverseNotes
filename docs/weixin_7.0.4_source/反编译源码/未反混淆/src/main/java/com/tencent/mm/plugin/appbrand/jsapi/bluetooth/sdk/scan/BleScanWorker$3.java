package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.sdk.platformtools.ab;

public class BleScanWorker$3 extends BroadcastReceiver {
    final /* synthetic */ a hFl;

    public BleScanWorker$3(a aVar) {
        this.hFl = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(94288);
        if (intent == null) {
            ab.i("MicroMsg.Ble.BleScanWorker", "Receive intent failed");
            AppMethodBeat.o(94288);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            int state = defaultAdapter.getState();
            ab.d("MicroMsg.Ble.BleScanWorker", "state:%d", Integer.valueOf(state));
            if (!(state == 12 || state == 11 || (state != 10 && state != 13))) {
                a.i("MicroMsg.Ble.BleScanWorker", "bluetooth is disable, stop scan", new Object[0]);
                this.hFl.hFh.set(false);
                this.hFl.aCU();
            }
        }
        AppMethodBeat.o(94288);
    }
}
