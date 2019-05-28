package com.tencent.mm.compatible.e;

import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.bo;

final class j implements a {
    j() {
    }

    public static a.a b(Looper looper) {
        AppMethodBeat.i(92932);
        a.a aVar = new a.a();
        try {
            aVar.erH = u.c(looper);
            aVar.rotate = 0;
            if (aVar.erH == null) {
                AppMethodBeat.o(92932);
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.rotate = 90;
                aVar.erH.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        if (split == null || split.length < 2) {
                            i = -1;
                        } else {
                            i = bo.getInt(split[1], 0);
                        }
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    aVar.rotate = 90;
                    aVar.erH.setDisplayOrientation(180);
                }
            }
            AppMethodBeat.o(92932);
            return aVar;
        } catch (Exception e) {
            AppMethodBeat.o(92932);
            return null;
        }
    }
}
