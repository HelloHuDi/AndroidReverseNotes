package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public class BluetoothStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(15837);
        ab.d("MicroMsg.BluetoothStateReceiver", "BluetoothStateReceiver.onReceive()");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.getState() == 12) {
                h.pYm.e(11921, Integer.valueOf(1));
            } else if (defaultAdapter.getState() == 10) {
                h.pYm.e(11921, Integer.valueOf(0));
            }
            ab.e("MicroMsg.BluetoothStateReceiver", "[oneliang]bluetoothAdapter state:" + defaultAdapter.getState());
        }
        AppMethodBeat.o(15837);
    }
}
