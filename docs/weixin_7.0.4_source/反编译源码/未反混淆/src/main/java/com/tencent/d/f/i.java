package com.tencent.d.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.d.e.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static a cd(Context context, String str) {
        AppMethodBeat.i(114621);
        a aVar = new a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.ceO = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
        } catch (Throwable th) {
        }
        AppMethodBeat.o(114621);
        return aVar;
    }
}
