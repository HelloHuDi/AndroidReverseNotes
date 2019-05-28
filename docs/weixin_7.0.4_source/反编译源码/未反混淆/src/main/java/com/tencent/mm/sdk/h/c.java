package com.tencent.mm.sdk.h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static boolean dqy() {
        AppMethodBeat.i(65375);
        try {
            boolean booleanValue = ((Boolean) Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
            AppMethodBeat.o(65375);
            return booleanValue;
        } catch (Exception e) {
            if (Build.DEVICE.equals("mx2")) {
                AppMethodBeat.o(65375);
                return true;
            } else if (Build.DEVICE.equals("mx") || Build.DEVICE.equals("m9")) {
                AppMethodBeat.o(65375);
                return false;
            } else {
                AppMethodBeat.o(65375);
                return false;
            }
        }
    }
}
