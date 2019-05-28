package com.tencent.ttpic.device;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;

public class DeviceCoffee {
    private static native byte[] nDrink(byte[] bArr, int i, String str, String str2);

    private static native byte[] nDrinkRawData(byte[] bArr, int i, String str);

    static {
        AppMethodBeat.m2504i(49835);
        try {
            System.loadLibrary("pitu_device");
            AppMethodBeat.m2505o(49835);
        } catch (UnsatisfiedLinkError e) {
            LogUtils.m50206e(e);
            AppMethodBeat.m2505o(49835);
        } catch (RuntimeException e2) {
            LogUtils.m50206e(e2);
            AppMethodBeat.m2505o(49835);
        } catch (Exception e3) {
            LogUtils.m50206e(e3);
            AppMethodBeat.m2505o(49835);
        }
    }

    public static byte[] drink(byte[] bArr, String str, String str2) {
        AppMethodBeat.m2504i(49833);
        LogUtils.m50210v("Coffee", "drink() deviceName = " + str + ", sign = " + str2);
        byte[] nDrink = nDrink(bArr, bArr.length, str, str2);
        AppMethodBeat.m2505o(49833);
        return nDrink;
    }

    public static byte[] drinkRawData(byte[] bArr, String str) {
        AppMethodBeat.m2504i(49834);
        byte[] nDrinkRawData = nDrinkRawData(bArr, bArr.length, str);
        AppMethodBeat.m2505o(49834);
        return nDrinkRawData;
    }
}
