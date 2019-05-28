package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Method;
import java.util.UUID;

public final class b {
    private static synchronized BluetoothManager aCX() {
        BluetoothManager bluetoothManager;
        synchronized (b.class) {
            AppMethodBeat.i(94345);
            bluetoothManager = (BluetoothManager) ah.getContext().getSystemService("bluetooth");
            AppMethodBeat.o(94345);
        }
        return bluetoothManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static synchronized BluetoothAdapter aCY() {
        BluetoothAdapter adapter;
        synchronized (b.class) {
            AppMethodBeat.i(94346);
            BluetoothManager aCX = aCX();
            if (aCX != null) {
                adapter = aCX.getAdapter();
                AppMethodBeat.o(94346);
            } else {
                a.e("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
                adapter = null;
                AppMethodBeat.o(94346);
            }
        }
        return adapter;
    }

    public static boolean AW(String str) {
        AppMethodBeat.i(94347);
        if (android.support.v4.content.b.checkSelfPermission(ah.getContext(), str) == 0) {
            AppMethodBeat.o(94347);
            return true;
        }
        AppMethodBeat.o(94347);
        return false;
    }

    public static boolean aCZ() {
        AppMethodBeat.i(94348);
        if (aCY() == null) {
            AppMethodBeat.o(94348);
            return false;
        }
        boolean isEnabled = aCY().isEnabled();
        AppMethodBeat.o(94348);
        return isEnabled;
    }

    public static boolean og(int i) {
        if ((i & 2) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oh(int i) {
        if ((i & 8) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oi(int i) {
        if ((i & 4) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oj(int i) {
        if ((i & 16) > 0) {
            return true;
        }
        return false;
    }

    public static boolean ok(int i) {
        if ((i & 32) > 0) {
            return true;
        }
        return false;
    }

    public static boolean AX(String str) {
        AppMethodBeat.i(94349);
        try {
            UUID.fromString(str);
            AppMethodBeat.o(94349);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(94349);
            return false;
        }
    }

    @TargetApi(18)
    public static boolean a(BluetoothGatt bluetoothGatt) {
        boolean booleanValue;
        boolean z = false;
        AppMethodBeat.i(94350);
        if (bluetoothGatt != null) {
            try {
                Method method = BluetoothGatt.class.getMethod("refresh", new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    z = booleanValue;
                    AppMethodBeat.o(94350);
                    return z;
                }
            } catch (Exception e) {
            }
        }
        booleanValue = false;
        z = booleanValue;
        AppMethodBeat.o(94350);
        return z;
    }
}
