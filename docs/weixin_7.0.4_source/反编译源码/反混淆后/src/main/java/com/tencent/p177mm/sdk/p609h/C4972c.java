package com.tencent.p177mm.sdk.p609h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.h.c */
public final class C4972c {
    public static boolean dqy() {
        AppMethodBeat.m2504i(65375);
        try {
            boolean booleanValue = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            AppMethodBeat.m2505o(65375);
            return booleanValue;
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                AppMethodBeat.m2505o(65375);
                return true;
            } else if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                AppMethodBeat.m2505o(65375);
                return false;
            } else {
                AppMethodBeat.m2505o(65375);
                return false;
            }
        }
    }
}
