package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.p086c.p090c.C25431j.C25432a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.bumptech.glide.c.c.h */
public interface C0762h {
    @Deprecated
    public static final C0762h aEe = new C07631();
    public static final C0762h aEf;

    /* renamed from: com.bumptech.glide.c.c.h$1 */
    class C07631 implements C0762h {
        C07631() {
        }

        public final Map<String, String> getHeaders() {
            AppMethodBeat.m2504i(92075);
            Map emptyMap = Collections.emptyMap();
            AppMethodBeat.m2505o(92075);
            return emptyMap;
        }
    }

    Map<String, String> getHeaders();

    static {
        C25432a c25432a = new C25432a();
        c25432a.aEj = true;
        aEf = new C25431j(c25432a.headers);
    }
}
