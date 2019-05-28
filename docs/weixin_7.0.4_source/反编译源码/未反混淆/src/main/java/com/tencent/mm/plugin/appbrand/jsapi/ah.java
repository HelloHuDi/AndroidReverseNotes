package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ah extends b {
    private c hcM;
    private String hwL;
    private Map<String, Object> hwM;
    int hwN;

    public ah j(c cVar) {
        if (cVar != null) {
            this.hcM = cVar;
            this.hwN = 0;
        }
        return this;
    }

    public ah b(c cVar, int i) {
        AppMethodBeat.i(91036);
        j(cVar);
        this.hwN = i;
        AppMethodBeat.o(91036);
        return this;
    }

    public final ah n(String str, Object obj) {
        AppMethodBeat.i(91037);
        if (this.hwM == null) {
            this.hwM = new HashMap();
        }
        this.hwM.put(str, obj);
        AppMethodBeat.o(91037);
        return this;
    }

    public ah AM(String str) {
        this.hwL = str;
        return this;
    }

    public ah t(Map<String, Object> map) {
        AppMethodBeat.i(91038);
        if (map == null) {
            AppMethodBeat.o(91038);
        } else {
            i.d(map);
            this.hwM = map;
            AppMethodBeat.o(91038);
        }
        return this;
    }

    public final String getData() {
        AppMethodBeat.i(91039);
        String str;
        if (this.hwL != null) {
            str = this.hwL;
            AppMethodBeat.o(91039);
            return str;
        } else if (this.hwM != null) {
            i.d(this.hwM);
            str = new JSONObject(this.hwM).toString();
            AppMethodBeat.o(91039);
            return str;
        } else {
            AppMethodBeat.o(91039);
            return null;
        }
    }

    public final void aCj() {
        AppMethodBeat.i(91040);
        if (this.hcM == null) {
            AppMethodBeat.o(91040);
            return;
        }
        this.hcM.a(this);
        AppMethodBeat.o(91040);
    }
}
