package com.tencent.p177mm.plugin.messenger.foundation.p454a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a.r */
public interface C21279r {

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.r$a */
    public static class C21278a {
        private static ConcurrentHashMap<Integer, C21279r> oqz = new ConcurrentHashMap();

        static {
            AppMethodBeat.m2504i(60006);
            AppMethodBeat.m2505o(60006);
        }

        /* renamed from: a */
        public static void m32647a(int i, C21279r c21279r) {
            AppMethodBeat.m2504i(60004);
            Assert.assertTrue(oqz.get(Integer.valueOf(i)) == null);
            oqz.put(Integer.valueOf(i), c21279r);
            AppMethodBeat.m2505o(60004);
        }

        /* renamed from: yv */
        public static C21279r m32648yv(int i) {
            AppMethodBeat.m2504i(60005);
            C21279r c21279r = (C21279r) oqz.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(60005);
            return c21279r;
        }
    }

    /* renamed from: a */
    void mo36640a(C40573tb c40573tb, byte[] bArr, boolean z, C21280t c21280t);
}
