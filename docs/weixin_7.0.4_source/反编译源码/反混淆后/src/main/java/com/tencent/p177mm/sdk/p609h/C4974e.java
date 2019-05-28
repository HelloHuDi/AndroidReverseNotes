package com.tencent.p177mm.sdk.p609h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.tencent.mm.sdk.h.e */
public final class C4974e {
    /* renamed from: hb */
    public static boolean m7367hb(Context context) {
        AppMethodBeat.m2504i(65377);
        if (context == null) {
            AppMethodBeat.m2505o(65377);
            return false;
        }
        try {
            Class loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.valueOf(((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue()));
            AppMethodBeat.m2505o(65377);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{Integer.valueOf(32)})).booleanValue();
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e, "hasCutOut, ClassNotFoundException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65377);
            return false;
        } catch (NoSuchMethodException e2) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e2, "hasCutOut, NoSuchMethodException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65377);
            return false;
        } catch (IllegalAccessException e3) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e3, "hasCutOut, IllegalAccessException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65377);
            return false;
        } catch (InvocationTargetException e4) {
            C4990ab.printErrStackTrace("MicroMsg.Vendor.Vivo", e4, "hasCutOut, InvocationTargetException!!", new Object[0]);
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65377);
            return false;
        } catch (Throwable th) {
            C4990ab.m7411d("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.m2505o(65377);
            return false;
        }
    }
}
