package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.plugin.appbrand.r.q.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;

public final class h implements a {
    private String version = "";

    public h(Context context) {
        AppMethodBeat.i(80436);
        PackageInfo packageInfo = b.getPackageInfo(context, ah.getPackageName());
        if (packageInfo != null) {
            this.version += g.ar(null, d.vxo);
            this.version += "." + packageInfo.versionCode;
            this.version += "(" + f.CLIENT_VERSION + ")";
            StringBuilder append = new StringBuilder().append(this.version).append(" Process/");
            String toLowerCase = ah.getPackageName().trim().toLowerCase();
            String toLowerCase2 = ah.getProcessName().trim().toLowerCase();
            if (toLowerCase2.equals(toLowerCase)) {
                toLowerCase = "mm";
            } else if (toLowerCase2.startsWith(toLowerCase)) {
                toLowerCase = toLowerCase2.substring(toLowerCase.length() + 1);
            } else {
                toLowerCase = "unknown";
            }
            this.version = append.append(toLowerCase).toString();
        }
        AppMethodBeat.o(80436);
    }

    public final String xJ() {
        return " MicroMessenger/";
    }

    public final String xK() {
        return this.version;
    }
}
