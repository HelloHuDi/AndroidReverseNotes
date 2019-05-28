package com.tencent.mm.plugin.d.a.e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static boolean dv(Context context) {
        AppMethodBeat.i(18517);
        ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")));
        AppMethodBeat.o(18517);
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean aVF() {
        boolean z;
        AppMethodBeat.i(18518);
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", Boolean.valueOf(z));
        AppMethodBeat.o(18518);
        return z;
    }

    public static boolean aVH() {
        AppMethodBeat.i(18519);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            AppMethodBeat.o(18519);
            return false;
        }
        ab.i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", Boolean.valueOf(defaultAdapter.isEnabled()));
        AppMethodBeat.o(18519);
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    public static String gC(long j) {
        AppMethodBeat.i(139017);
        String ie = b.ie(j);
        AppMethodBeat.o(139017);
        return ie;
    }
}
