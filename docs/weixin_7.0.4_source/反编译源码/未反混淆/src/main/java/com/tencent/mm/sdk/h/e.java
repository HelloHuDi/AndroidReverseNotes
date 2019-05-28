package com.tencent.mm.sdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationTargetException;

public final class e {
    public static boolean hb(Context context) {
        AppMethodBeat.i(65377);
        if (context == null) {
            AppMethodBeat.o(65377);
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue()));
            AppMethodBeat.o(65377);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65377);
            return false;
        } catch (NoSuchMethodException e2) {
            ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65377);
            return false;
        } catch (IllegalAccessException e3) {
            ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e3, "hasCutOut, IllegalAccessException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65377);
            return false;
        } catch (InvocationTargetException e4) {
            ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e4, "hasCutOut, InvocationTargetException!!", new Object[0]);
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65377);
            return false;
        } catch (Throwable th) {
            ab.d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(65377);
            return false;
        }
    }
}
