package com.tencent.p177mm.sdk.p609h;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.mm.sdk.h.a */
public final class C4970a {
    private static Boolean xER = null;

    /* renamed from: gZ */
    public static boolean m7362gZ(Context context) {
        AppMethodBeat.m2504i(65366);
        if (context == null) {
            AppMethodBeat.m2505o(65366);
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue()));
            AppMethodBeat.m2505o(65366);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65366);
            return false;
        } catch (NoSuchMethodException e2) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65366);
            return false;
        } catch (IllegalAccessException e3) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e3, "hasCutOut, IllegalAccessException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65366);
            return false;
        } catch (InvocationTargetException e4) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Huawei", e4, "hasCutOut, InvocationTargetException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65366);
            return false;
        } catch (Throwable th) {
            C4990ab.m7411d("MicroMsg.Vendor.Huawei", "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65366);
            return false;
        }
    }

    public static boolean dqu() {
        AppMethodBeat.m2504i(65367);
        if (xER == null) {
            String str = Build.BRAND;
            C4990ab.m7417i("MicroMsg.Vendor.Huawei", "Build.BRAND = %s", str);
            if ("HONOR".equalsIgnoreCase(str)) {
                xER = Boolean.TRUE;
            } else if ("HUAWEI".equalsIgnoreCase(str)) {
                xER = Boolean.TRUE;
            } else {
                xER = Boolean.FALSE;
            }
        }
        boolean booleanValue = xER.booleanValue();
        AppMethodBeat.m2505o(65367);
        return booleanValue;
    }
}
