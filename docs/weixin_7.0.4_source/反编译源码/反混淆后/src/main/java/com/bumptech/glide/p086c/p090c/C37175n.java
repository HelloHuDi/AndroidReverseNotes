package com.bumptech.glide.p086c.p090c;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C0742d;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.c.c.n */
public interface C37175n<Model, Data> {

    /* renamed from: com.bumptech.glide.c.c.n$a */
    public static class C37176a<Data> {
        public final List<C0779h> aEp;
        public final C0742d<Data> aEq;
        public final C0779h azW;

        public C37176a(C0779h c0779h, C0742d<Data> c0742d) {
            this(c0779h, Collections.emptyList(), c0742d);
            AppMethodBeat.m2504i(92098);
            AppMethodBeat.m2505o(92098);
        }

        private C37176a(C0779h c0779h, List<C0779h> list, C0742d<Data> c0742d) {
            AppMethodBeat.m2504i(92099);
            this.azW = (C0779h) C8561i.m15217d(c0779h, "Argument must not be null");
            this.aEp = (List) C8561i.m15217d(list, "Argument must not be null");
            this.aEq = (C0742d) C8561i.m15217d(c0742d, "Argument must not be null");
            AppMethodBeat.m2505o(92099);
        }
    }

    /* renamed from: X */
    boolean mo2224X(Model model);

    /* renamed from: b */
    C37176a<Data> mo2225b(Model model, int i, int i2, C31967j c31967j);
}
