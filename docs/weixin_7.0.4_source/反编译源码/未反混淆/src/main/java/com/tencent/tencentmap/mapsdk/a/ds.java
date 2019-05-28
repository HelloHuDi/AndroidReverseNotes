package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ds {
    private static ds c;
    private dr a = new dv();
    private boolean b = false;

    public static synchronized ds a() {
        ds dsVar;
        synchronized (ds.class) {
            AppMethodBeat.i(101104);
            if (c == null) {
                c = new ds();
            }
            dsVar = c;
            AppMethodBeat.o(101104);
        }
        return dsVar;
    }

    private ds() {
        AppMethodBeat.i(101105);
        AppMethodBeat.o(101105);
    }

    public void a(Context context) {
        AppMethodBeat.i(101106);
        if (this.b) {
            AppMethodBeat.o(101106);
            return;
        }
        if (this.a != null) {
            this.a.a(context.getApplicationContext());
            this.b = true;
        }
        AppMethodBeat.o(101106);
    }

    public dt a(String str) {
        AppMethodBeat.i(101107);
        if (this.a == null) {
            AppMethodBeat.o(101107);
            return null;
        }
        dt a = this.a.a(str);
        AppMethodBeat.o(101107);
        return a;
    }

    public dt a(String str, String str2) {
        AppMethodBeat.i(101108);
        if (this.a == null) {
            AppMethodBeat.o(101108);
            return null;
        }
        dt a = this.a.a(str, str2);
        AppMethodBeat.o(101108);
        return a;
    }

    public dt a(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(101109);
        if (this.a == null) {
            AppMethodBeat.o(101109);
            return null;
        }
        dt a = this.a.a(str, str2, bArr);
        AppMethodBeat.o(101109);
        return a;
    }
}
