package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class k extends a {
    public k(Map<String, String> map, bi biVar) {
        super(map, biVar);
    }

    public final boolean Yt() {
        AppMethodBeat.i(11235);
        if (this.values == null) {
            AppMethodBeat.o(11235);
        } else if (this.TYPE.equals("biz_services_mute")) {
            String str = (String) this.values.get(".sysmsg.biz_services_mute.link.text");
            String str2 = ((String) this.values.get(".sysmsg.biz_services_mute.text")) + str;
            this.fKY.add(str);
            this.fKZ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.fLa.add(Integer.valueOf(str2.length()));
            this.fKW = str2;
            AppMethodBeat.o(11235);
        } else {
            AppMethodBeat.o(11235);
        }
        return false;
    }

    public static void Yu() {
        AppMethodBeat.i(11236);
        a.a.a("biz_services_mute", new a.a() {
            public final a a(Map<String, String> map, bi biVar) {
                AppMethodBeat.i(11234);
                k kVar = new k(map, biVar);
                AppMethodBeat.o(11234);
                return kVar;
            }
        });
        AppMethodBeat.o(11236);
    }
}
