package org.p1128b.p1132d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.p1128b.p1134g.C36644c;

/* renamed from: org.b.d.e */
public final class C16475e {
    public final List<C31206d> BYO;

    public C16475e() {
        AppMethodBeat.m2504i(77261);
        this.BYO = new ArrayList();
        AppMethodBeat.m2505o(77261);
    }

    public C16475e(List<C31206d> list) {
        AppMethodBeat.m2504i(77262);
        this.BYO = new ArrayList(list);
        AppMethodBeat.m2505o(77262);
    }

    public C16475e(Map<String, String> map) {
        this();
        AppMethodBeat.m2504i(77263);
        for (Entry entry : map.entrySet()) {
            this.BYO.add(new C31206d((String) entry.getKey(), (String) entry.getValue()));
        }
        AppMethodBeat.m2505o(77263);
    }

    public final String enh() {
        AppMethodBeat.m2504i(77264);
        String str;
        if (this.BYO.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(77264);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (C31206d eng : this.BYO) {
            stringBuilder.append('&').append(eng.eng());
        }
        str = stringBuilder.toString().substring(1);
        AppMethodBeat.m2505o(77264);
        return str;
    }

    /* renamed from: a */
    public final void mo30363a(C16475e c16475e) {
        AppMethodBeat.m2504i(77265);
        this.BYO.addAll(c16475e.BYO);
        AppMethodBeat.m2505o(77265);
    }

    public final void awV(String str) {
        AppMethodBeat.m2504i(77266);
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.BYO.add(new C31206d(C36644c.decode(split2[0]), split2.length > 1 ? C36644c.decode(split2[1]) : ""));
            }
        }
        AppMethodBeat.m2505o(77266);
    }
}
