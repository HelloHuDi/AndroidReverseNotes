package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;

public class DeviceCoffee {
    private static native byte[] nDrink(byte[] bArr, int i, String str, String str2);

    private static native byte[] nDrinkRawData(byte[] bArr, int i, String str);

    static {
        AppMethodBeat.i(49835);
        try {
            System.loadLibrary("pitu_device");
            AppMethodBeat.o(49835);
        } catch (UnsatisfiedLinkError e) {
            LogUtils.e(e);
            AppMethodBeat.o(49835);
        } catch (RuntimeException e2) {
            LogUtils.e(e2);
            AppMethodBeat.o(49835);
        } catch (Exception e3) {
            LogUtils.e(e3);
            AppMethodBeat.o(49835);
        }
    }

    public static byte[] drink(byte[] bArr, String str, String str2) {
        AppMethodBeat.i(49833);
        LogUtils.v("Coffee", "drink() deviceName = " + str + ", sign = " + str2);
        byte[] nDrink = nDrink(bArr, bArr.length, str, str2);
        AppMethodBeat.o(49833);
        return nDrink;
    }

    public static byte[] drinkRawData(byte[] bArr, String str) {
        AppMethodBeat.i(49834);
        byte[] nDrinkRawData = nDrinkRawData(bArr, bArr.length, str);
        AppMethodBeat.o(49834);
        return nDrinkRawData;
    }
}
