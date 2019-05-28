package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class lm {
    private int a = 0;
    private int b = 0;
    private String c = "default";
    private String d = "";
    private String e = "";
    private String f;

    public lm(int i, int i2, String str, String str2, String str3, String str4) {
        this.a = i;
        this.b = i2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.c = str4;
    }

    public int a() {
        return (this.a * 10) + this.b;
    }

    public boolean a(a aVar) {
        AppMethodBeat.i(100439);
        boolean b;
        switch (this.a) {
            case 0:
                b = b(aVar);
                AppMethodBeat.o(100439);
                return b;
            case 1:
                b = c(aVar);
                AppMethodBeat.o(100439);
                return b;
            default:
                AppMethodBeat.o(100439);
                return false;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    private boolean b(a aVar) {
        AppMethodBeat.i(100440);
        if ("default".equals(this.c)) {
            AppMethodBeat.o(100440);
            return true;
        } else if (aVar == null) {
            AppMethodBeat.o(100440);
            return false;
        } else {
            boolean a = ln.a(aVar.a(), ln.a().c(this.c));
            AppMethodBeat.o(100440);
            return a;
        }
    }

    private boolean c(a aVar) {
        AppMethodBeat.i(100441);
        if ("default".equals(this.c)) {
            AppMethodBeat.o(100441);
            return true;
        } else if (aVar == null) {
            AppMethodBeat.o(100441);
            return false;
        } else {
            b[] c = ln.a().c(this.c);
            b[] b = aVar.b();
            if (b == null || c == null) {
                AppMethodBeat.o(100441);
                return true;
            }
            boolean a = ln.a(b, c);
            AppMethodBeat.o(100441);
            return a;
        }
    }
}
