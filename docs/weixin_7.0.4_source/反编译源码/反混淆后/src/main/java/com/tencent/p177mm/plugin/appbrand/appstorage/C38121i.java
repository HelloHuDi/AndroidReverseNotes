package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.i */
final class C38121i {

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.i$a */
    static final class C19091a {
        C19091a() {
        }
    }

    /* renamed from: bx */
    static boolean m64493bx(String str, String str2) {
        AppMethodBeat.m2504i(105365);
        if (VERSION.SDK_INT >= 21) {
            try {
                long anU = C5046bo.anU();
                C19091a c19091a = new C19091a();
                Os.rename(str, str2);
                C4990ab.m7411d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", Long.valueOf(C5046bo.anU() - anU));
                AppMethodBeat.m2505o(105365);
                return true;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", C5046bo.m7574l(e));
            }
        }
        boolean renameTo = new File(str).renameTo(new File(str2));
        AppMethodBeat.m2505o(105365);
        return renameTo;
    }
}
