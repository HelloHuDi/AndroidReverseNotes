package com.bumptech.glide.c.c;

import com.bumptech.glide.c.c.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

public interface h {
    @Deprecated
    public static final h aEe = new h() {
        public final Map<String, String> getHeaders() {
            AppMethodBeat.i(92075);
            Map emptyMap = Collections.emptyMap();
            AppMethodBeat.o(92075);
            return emptyMap;
        }
    };
    public static final h aEf;

    Map<String, String> getHeaders();

    static {
        a aVar = new a();
        aVar.aEj = true;
        aEf = new j(aVar.headers);
    }
}
