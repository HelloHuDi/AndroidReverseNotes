package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C10707q.C10708a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.h */
public final class C19592h implements C10708a {
    private String version = "";

    public C19592h(Context context) {
        AppMethodBeat.m2504i(80436);
        PackageInfo packageInfo = C19679b.getPackageInfo(context, C4996ah.getPackageName());
        if (packageInfo != null) {
            this.version += C5059g.m7672ar(null, C7243d.vxo);
            this.version += "." + packageInfo.versionCode;
            this.version += "(" + C5058f.CLIENT_VERSION + ")";
            StringBuilder append = new StringBuilder().append(this.version).append(" Process/");
            String toLowerCase = C4996ah.getPackageName().trim().toLowerCase();
            String toLowerCase2 = C4996ah.getProcessName().trim().toLowerCase();
            if (toLowerCase2.equals(toLowerCase)) {
                toLowerCase = "mm";
            } else if (toLowerCase2.startsWith(toLowerCase)) {
                toLowerCase = toLowerCase2.substring(toLowerCase.length() + 1);
            } else {
                toLowerCase = "unknown";
            }
            this.version = append.append(toLowerCase).toString();
        }
        AppMethodBeat.m2505o(80436);
    }

    /* renamed from: xJ */
    public final String mo22249xJ() {
        return " MicroMessenger/";
    }

    /* renamed from: xK */
    public final String mo22250xK() {
        return this.version;
    }
}
