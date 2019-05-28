package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tb;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public interface r {

    public static class a {
        private static ConcurrentHashMap<Integer, r> oqz = new ConcurrentHashMap();

        static {
            AppMethodBeat.i(60006);
            AppMethodBeat.o(60006);
        }

        public static void a(int i, r rVar) {
            AppMethodBeat.i(60004);
            Assert.assertTrue(oqz.get(Integer.valueOf(i)) == null);
            oqz.put(Integer.valueOf(i), rVar);
            AppMethodBeat.o(60004);
        }

        public static r yv(int i) {
            AppMethodBeat.i(60005);
            r rVar = (r) oqz.get(Integer.valueOf(i));
            AppMethodBeat.o(60005);
            return rVar;
        }
    }

    void a(tb tbVar, byte[] bArr, boolean z, t tVar);
}
