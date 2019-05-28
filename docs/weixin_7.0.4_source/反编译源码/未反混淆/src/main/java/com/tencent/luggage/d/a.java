package com.tencent.luggage.d;

import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public abstract class a<CONTEXT extends b> {
    CONTEXT bOY;

    public class a {
        public CONTEXT bOZ;
        public k bPa;

        public final void c(String str, Map<String, Object> map) {
            AppMethodBeat.i(90768);
            k kVar = this.bPa;
            if (str == null) {
                str = "";
            }
            kVar.bOy = str;
            kVar.bOz = map != null ? new JSONObject(map) : null;
            if (kVar.bOs != 0) {
                kVar.wM();
            }
            AppMethodBeat.o(90768);
        }

        public final void a(String str, JSONObject jSONObject) {
            AppMethodBeat.i(90769);
            this.bPa.a(str, jSONObject);
            AppMethodBeat.o(90769);
        }
    }

    public abstract void a(a aVar);

    public abstract String name();
}
