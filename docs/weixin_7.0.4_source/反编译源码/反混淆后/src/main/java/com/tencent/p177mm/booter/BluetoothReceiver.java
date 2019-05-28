package com.tencent.p177mm.booter;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Set;

@C26347k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.booter.BluetoothReceiver */
public class BluetoothReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(15836);
        if (context == null || intent == null || C5046bo.isNullOrNil(intent.getAction())) {
            AppMethodBeat.m2505o(15836);
            return;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            C4990ab.m7410d("MicroMsg.BluetoothReceiver", "getDefaultAdapter == null");
            AppMethodBeat.m2505o(15836);
            return;
        }
        Set bondedDevices = defaultAdapter.getBondedDevices();
        if (bondedDevices == null || bondedDevices.size() == 0) {
            C4990ab.m7410d("MicroMsg.BluetoothReceiver", "getBondedDevices == null");
            AppMethodBeat.m2505o(15836);
        } else if (C5046bo.isNullOrNil(intent.getAction())) {
            AppMethodBeat.m2505o(15836);
        } else {
            C4990ab.m7410d("MicroMsg.BluetoothReceiver", "dkbt action :" + intent.getAction());
            if (C9638aw.m17179RK()) {
                int intExtra;
                try {
                    intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.BluetoothReceiver", "%s", C5046bo.m7574l(e));
                    intExtra = 0;
                }
                C4990ab.m7410d("MicroMsg.BluetoothReceiver", "dkbt  action :" + intent.getAction() + " state:" + intExtra + " isBluetoothScoOn :" + C9638aw.m17191ZL().mo4819KP() + " " + C9638aw.m17191ZL().mo4820KT());
                if (intent.getAction().equalsIgnoreCase("android.media.SCO_AUDIO_STATE_CHANGED")) {
                    C4990ab.m7410d("MicroMsg.BluetoothReceiver", "just STATE_CHANGED not real STATE_UPDATED" + intent.getAction());
                    AppMethodBeat.m2505o(15836);
                    return;
                } else if (intExtra == 1) {
                    C4990ab.m7410d("MicroMsg.BluetoothReceiver", "sco connected!");
                    C4990ab.m7417i("MicroMsg.MMAudioManager", "dkbt bluetoothStartSucc %s", C9638aw.m17191ZL().mo4820KT());
                    C1407g.epc = true;
                    r0.mo4837iI(1);
                    AppMethodBeat.m2505o(15836);
                    return;
                } else {
                    if (intExtra == 0) {
                        C4990ab.m7411d("MicroMsg.BluetoothReceiver", "sco disconnected!getStopBluetoothInBR = %s", Integer.valueOf(C1427q.etn.erJ));
                        if (C1427q.etn.erJ == 1) {
                            C9638aw.m17191ZL().mo4818KN();
                        }
                        C9638aw.m17191ZL().mo4816KL();
                    }
                    AppMethodBeat.m2505o(15836);
                    return;
                }
            }
            AppMethodBeat.m2505o(15836);
        }
    }
}
