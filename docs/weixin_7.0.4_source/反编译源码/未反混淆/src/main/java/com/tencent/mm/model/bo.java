package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class bo extends a {
    public bo(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    public final boolean Yt() {
        AppMethodBeat.i(11238);
        if (this.values == null) {
            AppMethodBeat.o(11238);
        } else if (this.TYPE.equals("reportbizlocation")) {
            String str = (String) this.values.get(".sysmsg.reportbizlocation.link.text");
            String str2 = ((String) this.values.get(".sysmsg.reportbizlocation.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.o(11238);
        } else {
            AppMethodBeat.o(11238);
        }
        return false;
    }

    public static void Yu() {
        AppMethodBeat.i(11239);
        a.a.a("reportbizlocation", new a.a() {
            public final a a(Map<String, String> map, bi biVar) {
                AppMethodBeat.i(11237);
                bo boVar = new bo(map, biVar);
                AppMethodBeat.o(11237);
                return boVar;
            }
        });
        AppMethodBeat.o(11239);
    }
}
