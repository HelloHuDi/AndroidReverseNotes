package com.tencent.mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;

@k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(15836);
        if (context == null || intent == null || bo.isNullOrNil(intent.getAction())) {
            AppMethodBeat.o(15836);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            ab.d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
            AppMethodBeat.o(15836);
            return;
        }
        Set bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices == null || bondedDevices.size() == 0) {
            ab.d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            AppMethodBeat.o(15836);
        } else if (bo.isNullOrNil(intent.getAction())) {
            AppMethodBeat.o(15836);
        } else {
            ab.d("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
            if (aw.RK()) {
                int intExtra;
                try {
                    intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                } catch (Exception e) {
                    ab.e("MicroMsg.BluetoothReceiver", "%s", bo.l(e));
                    intExtra = 0;
                }
                ab.d("MicroMsg.BluetoothReceiver", "dkbt  action :" + intent.getAction() + " state:" + intExtra + " isBluetoothScoOn :" + aw.ZL().KP() + " " + aw.ZL().KT());
                if (intent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED")) {
                    ab.d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + intent.getAction());
                    AppMethodBeat.o(15836);
                    return;
                } else if (intExtra == 1) {
                    ab.d("MicroMsg.BluetoothReceiver", "sco connected!");
                    ab.i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", aw.ZL().KT());
                    g.epc = true;
                    r0.iI(1);
                    AppMethodBeat.o(15836);
                    return;
                } else {
                    if (intExtra == 0) {
                        ab.d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", Integer.valueOf(q.etn.erJ));
                        if (q.etn.erJ == 1) {
                            aw.ZL().KN();
                        }
                        aw.ZL().KL();
                    }
                    AppMethodBeat.o(15836);
                    return;
                }
            }
            AppMethodBeat.o(15836);
        }
    }
}
