package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.p1390d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.support.p057v4.content.C0380b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Method;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b */
public final class C38283b {
    private static synchronized BluetoothManager aCX() {
        BluetoothManager bluetoothManager;
        synchronized (C38283b.class) {
            AppMethodBeat.m2504i(94345);
            bluetoothManager = (BluetoothManager) C4996ah.getContext().getSystemService("bluetooth");
            AppMethodBeat.m2505o(94345);
        }
        return bluetoothManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static synchronized BluetoothAdapter aCY() {
        BluetoothAdapter adapter;
        synchronized (C38283b.class) {
            AppMethodBeat.m2504i(94346);
            BluetoothManager aCX = C38283b.aCX();
            if (aCX != null) {
                adapter = aCX.getAdapter();
                AppMethodBeat.m2505o(94346);
            } else {
                C26944a.m42896e("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
                adapter = null;
                AppMethodBeat.m2505o(94346);
            }
        }
        return adapter;
    }

    /* renamed from: AW */
    public static boolean m64774AW(String str) {
        AppMethodBeat.m2504i(94347);
        if (C0380b.checkSelfPermission(C4996ah.getContext(), str) == 0) {
            AppMethodBeat.m2505o(94347);
            return true;
        }
        AppMethodBeat.m2505o(94347);
        return false;
    }

    public static boolean aCZ() {
        AppMethodBeat.m2504i(94348);
        if (C38283b.aCY() == null) {
            AppMethodBeat.m2505o(94348);
            return false;
        }
        boolean isEnabled = C38283b.aCY().isEnabled();
        AppMethodBeat.m2505o(94348);
        return isEnabled;
    }

    /* renamed from: og */
    public static boolean m64777og(int i) {
        if ((i & 2) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: oh */
    public static boolean m64778oh(int i) {
        if ((i & 8) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: oi */
    public static boolean m64779oi(int i) {
        if ((i & 4) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: oj */
    public static boolean m64780oj(int i) {
        if ((i & 16) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m64781ok(int i) {
        if ((i & 32) > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: AX */
    public static boolean m64775AX(String str) {
        AppMethodBeat.m2504i(94349);
        try {
            UUID.fromString(str);
            AppMethodBeat.m2505o(94349);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(94349);
            return false;
        }
    }

    @TargetApi(18)
    /* renamed from: a */
    public static boolean m64776a(BluetoothGatt bluetoothGatt) {
        boolean booleanValue;
        boolean z = false;
        AppMethodBeat.m2504i(94350);
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    z = booleanValue;
                    AppMethodBeat.m2505o(94350);
                    return z;
                }
            } catch (Exception e) {
            }
        }
        booleanValue = false;
        z = booleanValue;
        AppMethodBeat.m2505o(94350);
        return z;
    }
}
