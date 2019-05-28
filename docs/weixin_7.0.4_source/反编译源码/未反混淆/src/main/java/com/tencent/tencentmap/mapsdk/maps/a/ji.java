package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.r;

public class ji implements gx {
    private Context a;
    private final r b;
    private String c;

    public ji(Context context, String str) {
        AppMethodBeat.i(100036);
        if (context != null) {
            this.a = context.getApplicationContext();
            this.b = r.a(this.a);
            this.c = str;
            AppMethodBeat.o(100036);
            return;
        }
        this.b = null;
        AppMethodBeat.o(100036);
    }

    public String a() {
        AppMethodBeat.i(100037);
        if (this.b != null) {
            String b = this.b.b();
            AppMethodBeat.o(100037);
            return b;
        }
        AppMethodBeat.o(100037);
        return null;
    }

    public String b() {
        AppMethodBeat.i(100038);
        if (this.b != null) {
            String c = this.b.c();
            AppMethodBeat.o(100038);
            return c;
        }
        AppMethodBeat.o(100038);
        return null;
    }

    public String c() {
        AppMethodBeat.i(100039);
        if (this.b != null) {
            String b = this.b.b(this.c);
            AppMethodBeat.o(100039);
            return b;
        }
        AppMethodBeat.o(100039);
        return null;
    }

    public String d() {
        AppMethodBeat.i(100040);
        if (this.b != null) {
            String c = this.b.c(this.c);
            AppMethodBeat.o(100040);
            return c;
        }
        AppMethodBeat.o(100040);
        return null;
    }

    public String e() {
        AppMethodBeat.i(100041);
        if (this.b != null) {
            String d = this.b.d();
            AppMethodBeat.o(100041);
            return d;
        }
        AppMethodBeat.o(100041);
        return null;
    }
}
