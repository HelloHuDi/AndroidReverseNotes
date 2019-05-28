package com.tencent.luggage.bridge.p814a;

import com.tencent.luggage.p1170a.C25681b;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p1170a.C45116d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.bridge.a.a */
public final class C8852a {
    public static C8854b bOP;

    /* renamed from: com.tencent.luggage.bridge.a.a$a */
    public interface C8851a extends C8855c {
    }

    /* renamed from: com.tencent.luggage.bridge.a.a$1 */
    public static class C88531 implements C8855c {
        /* renamed from: a */
        public final <T extends C25681b> void mo20023a(Class<T> cls, T t) {
            AppMethodBeat.m2504i(90747);
            C37384e.m62987a((Class) cls, (C25681b) t);
            AppMethodBeat.m2505o(90747);
        }

        /* renamed from: a */
        public final <T extends C45116d> void mo20024a(Class<T> cls, T t) {
            AppMethodBeat.m2504i(90748);
            C37384e.m62988a((Class) cls, (C45116d) t);
            AppMethodBeat.m2505o(90748);
        }
    }

    /* renamed from: com.tencent.luggage.bridge.a.a$b */
    public interface C8854b {
        /* renamed from: a */
        void mo20025a(C8851a c8851a);

        /* renamed from: a */
        void mo20026a(C8855c c8855c);
    }

    /* renamed from: com.tencent.luggage.bridge.a.a$c */
    public interface C8855c {
        /* renamed from: a */
        <T extends C25681b> void mo20023a(Class<T> cls, T t);

        /* renamed from: a */
        <T extends C45116d> void mo20024a(Class<T> cls, T t);
    }
}
