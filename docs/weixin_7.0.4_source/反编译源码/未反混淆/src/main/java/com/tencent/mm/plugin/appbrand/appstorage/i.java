package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class i {

    static final class a {
        a() {
        }
    }

    static boolean bx(String str, String str2) {
        AppMethodBeat.i(105365);
        if (VERSION.SDK_INT >= 21) {
            try {
                long anU = bo.anU();
                a aVar = new a();
                Os.rename(str, str2);
                ab.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", Long.valueOf(bo.anU() - anU));
                AppMethodBeat.o(105365);
                return true;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", bo.l(e));
            }
        }
        boolean renameTo = new File(str).renameTo(new File(str2));
        AppMethodBeat.o(105365);
        return renameTo;
    }
}
