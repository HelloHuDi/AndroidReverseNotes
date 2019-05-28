package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ae extends ak {
    private static ArrayList<af> e;
    private static Map<String, String> f;
    public ArrayList<af> a = null;
    public int b = 0;
    public String c = "";
    public Map<String, String> d = null;

    public final void a(aj ajVar) {
        AppMethodBeat.i(98412);
        ajVar.a(this.a, 0);
        ajVar.a(this.b, 1);
        ajVar.a(this.c, 2);
        if (this.d != null) {
            ajVar.a(this.d, 3);
        }
        AppMethodBeat.o(98412);
    }

    public final void a(ai aiVar) {
        AppMethodBeat.i(98413);
        if (e == null) {
            e = new ArrayList();
            e.add(new af());
        }
        this.a = (ArrayList) aiVar.a(e, 0, true);
        this.b = aiVar.a(this.b, 1, true);
        this.c = aiVar.a(2, true);
        if (f == null) {
            f = new HashMap();
            f.put("", "");
        }
        this.d = (Map) aiVar.a(f, 3, false);
        AppMethodBeat.o(98413);
    }
}
