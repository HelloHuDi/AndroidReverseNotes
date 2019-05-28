package com.tencent.mm.sdk.h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationTargetException;

public final class a {
    private static Boolean xER = null;

    public static boolean gZ(Context context) {
        AppMethodBeat.i(65366);
        if (context == null) {
            AppMethodBeat.o(65366);
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue()));
            AppMethodBeat.o(65366);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65366);
            return false;
        } catch (NoSuchMethodException e2) {
            ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65366);
            return false;
        } catch (IllegalAccessException e3) {
            ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e3, "hasCutOut, IllegalAccessException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65366);
            return false;
        } catch (InvocationTargetException e4) {
            ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e4, "hasCutOut, InvocationTargetException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65366);
            return false;
        } catch (Throwable th) {
            ab.d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65366);
            return false;
        }
    }

    public static boolean dqu() {
        AppMethodBeat.i(65367);
        if (xER == null) {
            String str = Build.BRAND;
            ab.i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", str);
            if ("HONOR".equalsIgnoreCase(str)) {
                xER = Boolean.TRUE;
            } else if ("HUAWEI".equalsIgnoreCase(str)) {
                xER = Boolean.TRUE;
            } else {
                xER = Boolean.FALSE;
            }
        }
        boolean booleanValue = xER.booleanValue();
        AppMethodBeat.o(65367);
        return booleanValue;
    }
}
