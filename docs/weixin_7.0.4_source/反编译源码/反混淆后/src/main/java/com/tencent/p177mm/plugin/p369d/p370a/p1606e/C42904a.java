package com.tencent.p177mm.plugin.p369d.p370a.p1606e;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.d.a.e.a */
public final class C42904a {
    /* renamed from: dv */
    public static boolean m76178dv(Context context) {
        AppMethodBeat.m2504i(18517);
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKUtil", "isBLESupported, ret = %b", Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")));
        AppMethodBeat.m2505o(18517);
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static boolean aVF() {
        boolean z;
        AppMethodBeat.m2504i(18518);
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKUtil", "isSupportBC: %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(18518);
        return z;
    }

    public static boolean aVH() {
        AppMethodBeat.m2504i(18519);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            AppMethodBeat.m2505o(18519);
            return false;
        }
        C4990ab.m7417i("MicroMsg.exdevice.BluetoothSDKUtil", "isBluetoothOpen: %b", Boolean.valueOf(defaultAdapter.isEnabled()));
        AppMethodBeat.m2505o(18519);
        return defaultAdapter.isEnabled();
    }

    @Deprecated
    /* renamed from: gC */
    public static String m76179gC(long j) {
        AppMethodBeat.m2504i(139017);
        String ie = C42992b.m76358ie(j);
        AppMethodBeat.m2505o(139017);
        return ie;
    }
}
