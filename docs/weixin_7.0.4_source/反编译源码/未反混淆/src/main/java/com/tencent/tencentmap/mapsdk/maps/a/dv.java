package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv {
    public String a = "";
    public int b = 0;
    public String c = "";
    public String d = "";
    public int e;

    public dv() {
        AppMethodBeat.i(98748);
        try {
            this.a = bt.a().getPackageName();
            PackageInfo packageInfo = bt.a().getPackageManager().getPackageInfo(this.a, 0);
            this.b = packageInfo.versionCode;
            this.c = packageInfo.versionName;
            this.e = bt.c();
            this.d = "";
            AppMethodBeat.o(98748);
        } catch (Throwable th) {
            AppMethodBeat.o(98748);
        }
    }
}
