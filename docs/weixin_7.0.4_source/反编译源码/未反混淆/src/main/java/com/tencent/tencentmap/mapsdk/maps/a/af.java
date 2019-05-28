package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class af extends ak {
    private static Map<String, String> g;
    private static ArrayList<String> h;
    private static ArrayList<String> i;
    public byte a = (byte) 0;
    public byte b = (byte) 0;
    public String c = "";
    public Map<String, String> d = null;
    public ArrayList<String> e = null;
    public ArrayList<String> f = null;

    public final void a(aj ajVar) {
        AppMethodBeat.i(98414);
        ajVar.a(this.a, 0);
        ajVar.a(this.b, 1);
        ajVar.a(this.c, 2);
        ajVar.a(this.d, 3);
        if (this.e != null) {
            ajVar.a(this.e, 4);
        }
        if (this.f != null) {
            ajVar.a(this.f, 6);
        }
        AppMethodBeat.o(98414);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98415);
        this.a = aiVar.a(this.a, 0, true);
        this.b = aiVar.a(this.b, 1, true);
        this.c = aiVar.a(2, true);
        if (g == null) {
            g = new HashMap();
            g.put("", "");
        }
        this.d = (Map) aiVar.a(g, 3, true);
        if (h == null) {
            h = new ArrayList();
            h.add("");
        }
        this.e = (ArrayList) aiVar.a(h, 4, false);
        if (i == null) {
            i = new ArrayList();
            i.add("");
        }
        this.f = (ArrayList) aiVar.a(i, 6, false);
        AppMethodBeat.o(98415);
    }
}
