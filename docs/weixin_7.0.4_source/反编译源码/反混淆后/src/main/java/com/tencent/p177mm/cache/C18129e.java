package com.tencent.p177mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.cache.e */
public interface C18129e {

    /* renamed from: com.tencent.mm.cache.e$a */
    public static class C18130a {
        private static Map<String, C18129e> eft = new HashMap();

        static {
            AppMethodBeat.m2504i(57826);
            AppMethodBeat.m2505o(57826);
        }

        /* renamed from: a */
        public static void m28565a(String str, C18129e c18129e) {
            AppMethodBeat.m2504i(57819);
            eft.put(str, c18129e);
            AppMethodBeat.m2505o(57819);
        }

        /* renamed from: kc */
        private static C18129e m28568kc(String str) {
            AppMethodBeat.m2504i(57820);
            C18129e c18129e = (C18129e) eft.get(str);
            AppMethodBeat.m2505o(57820);
            return c18129e;
        }

        /* renamed from: J */
        public static <T> T m28562J(String str, String str2) {
            AppMethodBeat.m2504i(57821);
            Object a = C18130a.m28564a(C18130a.m28568kc(str), str2);
            AppMethodBeat.m2505o(57821);
            return a;
        }

        /* renamed from: a */
        public static <T> void m28566a(String str, String str2, T t) {
            AppMethodBeat.m2504i(57822);
            C18129e kc = C18130a.m28568kc(str);
            if (kc == null) {
                C4990ab.m7412e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.m2505o(57822);
                return;
            }
            kc.mo20452f(str2, t);
            AppMethodBeat.m2505o(57822);
        }

        /* renamed from: K */
        public static <T> void m28563K(String str, String str2) {
            AppMethodBeat.m2504i(57823);
            C18130a.m28567b(C18130a.m28568kc(str), str2);
            AppMethodBeat.m2505o(57823);
        }

        /* renamed from: a */
        private static <T> T m28564a(C18129e c18129e, String str) {
            T t = null;
            AppMethodBeat.m2504i(57824);
            if (c18129e == null) {
                C4990ab.m7412e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.m2505o(57824);
            } else {
                try {
                    t = c18129e.get(str);
                    AppMethodBeat.m2505o(57824);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    C4990ab.m7413e("MicroMsg.ICacheService.Factory", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(57824);
                }
            }
            return t;
        }

        /* renamed from: b */
        private static <T> T m28567b(C18129e c18129e, String str) {
            T t = null;
            AppMethodBeat.m2504i(57825);
            if (c18129e == null) {
                C4990ab.m7412e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.m2505o(57825);
            } else {
                try {
                    t = c18129e.remove(str);
                    AppMethodBeat.m2505o(57825);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    C4990ab.m7413e("MicroMsg.ICacheService.Factory", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(57825);
                }
            }
            return t;
        }
    }

    /* renamed from: f */
    void mo20452f(Object obj, Object obj2);

    Object get(Object obj);

    Object remove(Object obj);
}
