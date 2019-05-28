package com.tencent.p177mm.compatible.p220c;

import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.compatible.c.a */
public final class C1411a {
    /* renamed from: a */
    public static boolean m2990a(AudioManager audioManager) {
        AppMethodBeat.m2504i(92902);
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            AppMethodBeat.m2505o(92902);
            return false;
        } else if (C5031ax.m7487Ex()) {
            AppMethodBeat.m2505o(92902);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(C1427q.etn.erL));
            if ((C1427q.etn.erL == 1 || C1427q.etn.erL == -1) && !audioManager.isBluetoothScoOn()) {
                C4990ab.m7417i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", C5046bo.dpG());
                audioManager.startBluetoothSco();
            }
            AppMethodBeat.m2505o(92902);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m2991b(AudioManager audioManager) {
        AppMethodBeat.m2504i(92903);
        if (C5031ax.m7487Ex()) {
            AppMethodBeat.m2505o(92903);
            return false;
        }
        C4990ab.m7417i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(C1427q.etn.erL), Integer.valueOf(C1427q.etn.erK));
        if ((C1427q.etn.erK == 1 || C1427q.etn.erL == -1) && audioManager.isBluetoothScoOn()) {
            C4990ab.m7417i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", C5046bo.dpG());
            audioManager.stopBluetoothSco();
        }
        AppMethodBeat.m2505o(92903);
        return true;
    }
}
