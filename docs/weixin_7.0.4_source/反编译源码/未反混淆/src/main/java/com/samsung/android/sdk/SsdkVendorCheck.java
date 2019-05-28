package com.samsung.android.sdk;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SsdkVendorCheck {
    private static String strBrand = Build.BRAND;
    private static String strManufacturer = Build.MANUFACTURER;

    private SsdkVendorCheck() {
    }

    public static boolean isSamsungDevice() {
        AppMethodBeat.i(123523);
        if (strBrand == null || strManufacturer == null) {
            AppMethodBeat.o(123523);
            return false;
        } else if (strBrand.compareToIgnoreCase("Samsung") == 0 || strManufacturer.compareToIgnoreCase("Samsung") == 0) {
            AppMethodBeat.o(123523);
            return true;
        } else {
            AppMethodBeat.o(123523);
            return false;
        }
    }
}
