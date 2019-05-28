package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.g.c;

public final class e {
    public final List<d> BYO;

    public e() {
        AppMethodBeat.i(77261);
        this.BYO = new ArrayList();
        AppMethodBeat.o(77261);
    }

    public e(List<d> list) {
        AppMethodBeat.i(77262);
        this.BYO = new ArrayList(list);
        AppMethodBeat.o(77262);
    }

    public e(Map<String, String> map) {
        this();
        AppMethodBeat.i(77263);
        for (Entry entry : map.entrySet()) {
            this.BYO.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
        AppMethodBeat.o(77263);
    }

    public final String enh() {
        AppMethodBeat.i(77264);
        String str;
        if (this.BYO.size() == 0) {
            str = "";
            AppMethodBeat.o(77264);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d eng : this.BYO) {
            stringBuilder.append('&').append(eng.eng());
        }
        str = stringBuilder.toString().substring(1);
        AppMethodBeat.o(77264);
        return str;
    }

    public final void a(e eVar) {
        AppMethodBeat.i(77265);
        this.BYO.addAll(eVar.BYO);
        AppMethodBeat.o(77265);
    }

    public final void awV(String str) {
        AppMethodBeat.i(77266);
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.BYO.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
        AppMethodBeat.o(77266);
    }
}
