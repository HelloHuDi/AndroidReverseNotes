package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class ho extends m {
    static ArrayList<hp> g = new ArrayList();
    public ArrayList<hp> a = null;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";

    public ho(ArrayList<hp> arrayList, String str, String str2, String str3, String str4, String str5) {
        this.a = arrayList;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }

    public final void writeTo(l lVar) {
        AppMethodBeat.i(99562);
        lVar.a(this.a, 0);
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
        if (this.f != null) {
            lVar.a(this.f, 5);
        }
        AppMethodBeat.o(99562);
    }

    static {
        AppMethodBeat.i(99564);
        g.add(new hp());
        AppMethodBeat.o(99564);
    }

    public final void readFrom(k kVar) {
        AppMethodBeat.i(99563);
        this.a = (ArrayList) kVar.a(g, 0, true);
        this.b = kVar.a(1, false);
        this.c = kVar.a(2, false);
        this.d = kVar.a(3, false);
        this.e = kVar.a(4, false);
        this.f = kVar.a(5, false);
        AppMethodBeat.o(99563);
    }
}
