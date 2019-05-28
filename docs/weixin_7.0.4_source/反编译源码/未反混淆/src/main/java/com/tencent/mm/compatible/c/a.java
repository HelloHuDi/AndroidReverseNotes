package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static boolean a(AudioManager audioManager) {
        AppMethodBeat.i(92902);
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            AppMethodBeat.o(92902);
            return false;
        } else if (ax.Ex()) {
            AppMethodBeat.o(92902);
            return false;
        } else {
            ab.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(q.etn.erL));
            if ((q.etn.erL == 1 || q.etn.erL == -1) && !audioManager.isBluetoothScoOn()) {
                ab.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", bo.dpG());
                audioManager.startBluetoothSco();
            }
            AppMethodBeat.o(92902);
            return true;
        }
    }

    public static boolean b(AudioManager audioManager) {
        AppMethodBeat.i(92903);
        if (ax.Ex()) {
            AppMethodBeat.o(92903);
            return false;
        }
        ab.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(q.etn.erL), Integer.valueOf(q.etn.erK));
        if ((q.etn.erK == 1 || q.etn.erL == -1) && audioManager.isBluetoothScoOn()) {
            ab.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", bo.dpG());
            audioManager.stopBluetoothSco();
        }
        AppMethodBeat.o(92903);
        return true;
    }
}
