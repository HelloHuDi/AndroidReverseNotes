package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dx {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;

    public dx() {
        AppMethodBeat.i(98750);
        try {
            this.a = Build.MODEL;
            this.b = VERSION.RELEASE;
            this.c = eu.a();
            this.d = eu.b();
            eu.e();
            this.e = eu.f();
            AppMethodBeat.o(98750);
        } catch (Throwable th) {
            AppMethodBeat.o(98750);
        }
    }
}
