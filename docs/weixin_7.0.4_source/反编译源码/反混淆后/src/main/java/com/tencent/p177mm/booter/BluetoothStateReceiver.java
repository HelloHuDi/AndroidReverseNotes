package com.tencent.p177mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.booter.BluetoothStateReceiver */
public class BluetoothStateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(15837);
        C4990ab.m7410d("MicroMsg.BluetoothStateReceiver", "BluetoothStateReceiver.onReceive()");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            if (defaultAdapter.getState() == 12) {
                C7060h.pYm.mo8381e(11921, Integer.valueOf(1));
            } else if (defaultAdapter.getState() == 10) {
                C7060h.pYm.mo8381e(11921, Integer.valueOf(0));
            }
            C4990ab.m7412e("MicroMsg.BluetoothStateReceiver", "[oneliang]bluetoothAdapter state:" + defaultAdapter.getState());
        }
        AppMethodBeat.m2505o(15837);
    }
}
