package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public interface e {

    public static class a {
        private static Map<String, e> eft = new HashMap();

        static {
            AppMethodBeat.i(57826);
            AppMethodBeat.o(57826);
        }

        public static void a(String str, e eVar) {
            AppMethodBeat.i(57819);
            eft.put(str, eVar);
            AppMethodBeat.o(57819);
        }

        private static e kc(String str) {
            AppMethodBeat.i(57820);
            e eVar = (e) eft.get(str);
            AppMethodBeat.o(57820);
            return eVar;
        }

        public static <T> T J(String str, String str2) {
            AppMethodBeat.i(57821);
            Object a = a(kc(str), str2);
            AppMethodBeat.o(57821);
            return a;
        }

        public static <T> void a(String str, String str2, T t) {
            AppMethodBeat.i(57822);
            e kc = kc(str);
            if (kc == null) {
                ab.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(57822);
                return;
            }
            kc.f(str2, t);
            AppMethodBeat.o(57822);
        }

        public static <T> void K(String str, String str2) {
            AppMethodBeat.i(57823);
            b(kc(str), str2);
            AppMethodBeat.o(57823);
        }

        private static <T> T a(e eVar, String str) {
            T t = null;
            AppMethodBeat.i(57824);
            if (eVar == null) {
                ab.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(57824);
            } else {
                try {
                    t = eVar.get(str);
                    AppMethodBeat.o(57824);
                } catch (Exception e) {
                    ab.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    ab.e("MicroMsg.ICacheService.Factory", "exception:%s", bo.l(e));
                    AppMethodBeat.o(57824);
                }
            }
            return t;
        }

        private static <T> T b(e eVar, String str) {
            T t = null;
            AppMethodBeat.i(57825);
            if (eVar == null) {
                ab.e("MicroMsg.ICacheService.Factory", "null service");
                AppMethodBeat.o(57825);
            } else {
                try {
                    t = eVar.remove(str);
                    AppMethodBeat.o(57825);
                } catch (Exception e) {
                    ab.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    ab.e("MicroMsg.ICacheService.Factory", "exception:%s", bo.l(e));
                    AppMethodBeat.o(57825);
                }
            }
            return t;
        }
    }

    void f(Object obj, Object obj2);

    Object get(Object obj);

    Object remove(Object obj);
}
